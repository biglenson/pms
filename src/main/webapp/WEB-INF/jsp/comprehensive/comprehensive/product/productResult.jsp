<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = request.getContextPath();
List<FormBase> productList=(List<FormBase>) request.getAttribute("productList");
Map<Integer,Double> chengBenMap=(Map<Integer,Double>)request.getAttribute("chengBenMap");
Map<Integer,Double> shouRuMap=(Map<Integer,Double>)request.getAttribute("shouRuMap");
Map<Integer,Double> touziMap=(Map<Integer,Double>)request.getAttribute("touziMap");

Map<Integer,Double> year_chengBenMap=(Map<Integer,Double>)request.getAttribute("year_chengBenMap");
Map<Integer,Double> year_shouRuMap=(Map<Integer,Double>)request.getAttribute("year_shouRuMap");
Map<Integer,Double> year_touziMap=(Map<Integer,Double>)request.getAttribute("year_touziMap");

Double maxChengBen=(Double)request.getAttribute("maxChengBen");
Double maxShouRu=(Double)request.getAttribute("maxShouRu");
Double max=maxChengBen+maxShouRu;
if(maxShouRu==0d){
	maxShouRu=maxChengBen;
}
if(maxChengBen==0d){
	maxChengBen=maxShouRu;
}
if(maxChengBen==0d&&maxShouRu==0d){
	maxShouRu=100d;
	maxChengBen=100d;
}

Double width=350d;
%>
<div>
	<table id="productDepartResultTable" class="listTable"
		style="margin: 10px auto; width: 100%" cellpadding="0" cellspacing="0"
		border="0">
		<thead>
			<tr>
				<th width="100%"><div style='width: 100%'>产品</div></th>
				<%
				double chengBenColumn=maxChengBen/(maxShouRu+maxChengBen)*width;
				double shouRuColumn=maxShouRu/(maxShouRu+maxChengBen)*width;
				%>
				<th><div style='width:<%=chengBenColumn%>px'>成本</div></th>
				<th><div style='width:<%=shouRuColumn%>px'>收入</div></th>

				<th><div style='width: 100px'>当年成本</div></th>
				<th><div style='width: 100px'>当年收入</div></th>
				<%-- 
				<th><div style='width:100px'>当年资本投入</div></th>
				--%>
				<th><div style='width: 100px'>累计成本</div></th>
				<th><div style='width: 100px'>累计收入</div></th>
				<%-- 
				<th><div style='width:100px'>累计资本投入</div></th>
				--%>
			</tr>
		</thead>
		<tbody>
			<%for(FormBase t:productList){ 
			
			Double t_shou=shouRuMap.get(t.getId());
			if(t_shou==null){
				t_shou=0d;
			};
			Double t_chengBen=chengBenMap.get(t.getId());
			if(t_chengBen==null){
				t_chengBen=0d;
			}
			Double t_touzi=touziMap.get(t.getId());
			if(t_touzi==null){
				t_touzi=0d;
			}
			
			Double t_shou2=year_shouRuMap.get(t.getId());
			if(t_shou2==null){
				t_shou2=0d;
			};
			Double t_chengBen2=year_chengBenMap.get(t.getId());
			if(t_chengBen2==null){
				t_chengBen2=0d;
			}
			Double t_touzi2=year_touziMap.get(t.getId());
			if(t_touzi2==null){
				t_touzi2=0d;
			}
			%>
			<tr>
				<td align="center"><div style='width: 150px;'
						class="nowrapText linkURL" onclick="openProduct(<%=t.getId()%>)"><%=TypeUtils.xmlEncoderForIE(t.getTitle()) %></div></td>
				<td style="border-right: 1px solid #D9D9D9;">
					<div class='chengBenClass'
						title="成本：<%=TypeUtils.formatWanMoney(t_chengBen==null?0:t_chengBen) %>"
						style='width:<%=t_chengBen>maxChengBen?100: t_chengBen/maxChengBen*100%>%;'>
						<%if(t_chengBen>t_shou&&t_chengBen!=0){ %>
						<div class="liRunLine"
							style="left:auto;right:<%=(t_shou)/t_chengBen*100%>%;margin-right:1px;"></div>
						<%} %>
					</div>

				</td>
				<td>
					<div class='shouRuClass'
						title="收入：<%=TypeUtils.formatWanMoney(t_shou==null?0:t_shou) %>"
						style='width:<%=t_shou>maxShouRu?100: t_shou/maxShouRu*100%>%;'>
						<%if(t_shou>t_chengBen&&t_shou!=0){ %>
						<div class="liRunLine"
							style="margin-left:-1px;left:<%=(t_chengBen)/t_shou*100%>%;"></div>
						<%} %>
					</div>

				</td>
				<td><div style='width: 100px; text-align: center;'
						class="nowrapText"><%=TypeUtils.formatWanMoney(t_chengBen2, "")%></div></td>
				<td><div style='width: 100px; text-align: center;'
						class="nowrapText"><%=TypeUtils.formatWanMoney(t_shou2, "")%></div></td>
				<%-- 
					<td><div style='width:100px;text-align: center;' class="nowrapText"><%=TypeUtils.formatWanMoney(t_touzi2, "")%></div></td>
					--%>
				<td><div style='width: 100px; text-align: center;'
						class="nowrapText"><%=TypeUtils.formatWanMoney(t_chengBen, "")%></div></td>
				<td><div style='width: 100px; text-align: center;'
						class="nowrapText"><%=TypeUtils.formatWanMoney(t_shou, "")%></div></td>
				<%--
					<td><div style='width:100px;text-align: center;' class="nowrapText"><%=TypeUtils.formatWanMoney(t_touzi, "")%></div></td>
				 	--%>

			</tr>
			<%}if(productList.isEmpty()){ %>
			<tr>
				<td colspan="10" style="padding-left: 100px;">暂无数据</td>
			</tr>
			<%} %>
		</tbody>
	</table>
</div>
<jsp:include page="/WEB-INF/jsp/common/viewChangeTime.jsp">
	<jsp:param name="lastUpdateDIV" value="productTimeDIV" />
</jsp:include>