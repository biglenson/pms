<%-- <%@page import="com.zq.commons.utils.TypeUtils"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();

List<Role> departmentList=(List<Role>) request.getAttribute("departmentList"); 
Map<Integer,Double> chengBenMap=(Map<Integer,Double>)request.getAttribute("chengBenMap");
Map<Integer,Double> touziMap=(Map<Integer,Double>)request.getAttribute("touziMap");
Map<Integer,Double> shouRuMap=(Map<Integer,Double>)request.getAttribute("shouRuMap");
Double maxChengBen=(Double)request.getAttribute("maxChengBen");
Double maxShouRu=(Double)request.getAttribute("maxShouRu");
Double max=maxChengBen+maxShouRu;

if(maxShouRu==0d){
	maxShouRu=maxChengBen;
}
if(maxChengBen==0d){
	maxChengBen=maxShouRu;
}
if(maxShouRu>maxChengBen&maxShouRu!=0){
	Double d=maxShouRu/maxChengBen;
	int size=d.intValue();
	if(size>5){
		maxChengBen=maxShouRu/5;
	}
}
if(maxShouRu<maxChengBen&maxChengBen!=0){
	Double d=maxChengBen/maxShouRu;
	int size=d.intValue();
	if(size>5){
		maxShouRu=maxChengBen/5;
	}
}
if(maxShouRu==0&&maxChengBen==0){
	maxShouRu=100d;
	maxChengBen=100d;
}
Double width=300d;
%>
<div style="width:100%;margin:0px auto;">
	<table id="departmentResultTable" class="listTable" style=" margin:10px auto;" cellpadding="0" cellspacing="0" border="0">
		<thead>
			<tr>
				<th width="100%"><div style='width:80px'>部门</div></th>
				<%
				double chengBenColumn=maxChengBen/(maxShouRu+maxChengBen)*width;
				double shouRuColumn=maxShouRu/(maxShouRu+maxChengBen)*width;
				%>
				<th><div style='width:<%=chengBenColumn%>px'>成本</div></th>
				<th><div style='width:<%=shouRuColumn%>px'>收入</div></th>
				<th><div style='width:80px'>非流动性资产</div></th>
			</tr>
		</thead>
		<tbody>
			<%for(Role t:departmentList){ 
			
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
			//System.out.println("t_chengBen"+t_chengBen +" t_shou="+t_shou);
			%>
				<tr>
					<td><div style='width:99px;text-align: left;padding-left: 10px;' title="<%=TypeUtils.xmlEncoderForIE(t.getName()) %>" class="nowrapText linkURL" onclick="openDepartmentView(<%=t.getId()%>)"><%=TypeUtils.xmlEncoderForIE(t.getName()) %></div></td>
					<td style="border-right:1px solid #D9D9D9; ">
							<div class='chengBenClass' title="成本：<%=TypeUtils.formatWanMoney(t_chengBen==null?0:t_chengBen) %>" style='width:<%=t_chengBen>maxChengBen?100:t_chengBen/maxChengBen*100%>%;'>
								<%if(t_chengBen>t_shou&&t_chengBen!=0){ %>
									<div class="liRunLine" style="left:auto;right:<%=(t_shou)/t_chengBen*100%>%;margin-right:1px;"></div>
								<%} %>
							</div>
						
					</td>
					<td >
						<div class='shouRuClass' title="收入：<%=TypeUtils.formatWanMoney(t_shou==null?0:t_shou) %>" style='width:<%=t_shou>maxShouRu?100: t_shou/maxShouRu*100%>%;'>
						<%if(t_shou>t_chengBen&&t_shou!=0){ %>
							<div class="liRunLine" style="margin-left:-1px;left:<%=(t_chengBen)/t_shou*100%>%;"></div>
						<%} %>
						</div>
						
					</td>
					
					<td><div style='width:80px;text-align: center;' class="nowrapText" title="<%=TypeUtils.formatWanMoney(t_touzi, "")%>"><%=TypeUtils.formatWanMoney(t_touzi, "")%></div></td>
				</tr>TypeUtils
			<%}if(departmentList.isEmpty()){ %>
				<tr>
					<td colspan="10" style="padding-left:10px;padding-top: 130px;"> 暂无数据</td>
				</tr>
			<%} %>
		</tbody>
	</table>
</div>
<jsp:include page="/WEB-INF/jsp/common/viewChangeTime.jsp">
		<jsp:param  name="lastUpdateDIV" value="caiwu_productAndDepart_departTime"/>
	</jsp:include> --%>