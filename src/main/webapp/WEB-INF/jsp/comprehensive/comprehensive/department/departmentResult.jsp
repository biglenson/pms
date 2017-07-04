<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = request.getContextPath();
List<Role> departmentList=(List<Role>) request.getAttribute("departmentList");
Map<Integer,Double> chengBenMap=(Map<Integer,Double>)request.getAttribute("chengBenMap");
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

Double width=460d;
%>
<div>
	<table id="departmentResultTable" class="listTable" style="margin:10px auto;" cellpadding="0" cellspacing="0" border="0">
		<thead>
			<tr>
				<th width="100%"><div style='width:150px'>部门</div></th>
				<%
				double chengBenColumn=maxChengBen/(maxShouRu+maxChengBen)*width;
				double shouRuColumn=maxShouRu/(maxShouRu+maxChengBen)*width;
				%>
				<th><div style='width:<%=chengBenColumn%>px'>成本</div></th>
				<th><div style='width:<%=shouRuColumn%>px'>收入</div></th>
				
				<th><div style='width:120px'>成本</div></th>
				<th><div style='width:120px'>收入</div></th>
				<th><div style='width:120px'>毛利润</div></th>
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
			//System.out.println("t_chengBen"+t_chengBen +" t_shou="+t_shou);
			%>
				<tr>
					<td><div style='width:150px;' class="nowrapText linkURL" onclick="openDepartmentView(<%=t.getId()%>)"><%=TypeUtils.xmlEncoderForIE(t.getName()) %></div></td>
					<td style="border-right:none; ">
							<div class='depart_chengBenClass' style='width:<%=t_chengBen>maxChengBen?100:t_chengBen/maxChengBen*100%>%;'>
								<%if(t_chengBen>t_shou&&t_chengBen!=0){ %>
									<div class="depart_liRunLine" style="left:auto;right:<%=(t_shou)/t_chengBen*100%>%;margin-right:1px;"></div>
								<%} %>
							</div>
						
					</td>
					<td >
						<div class='depart_shouRuClass' style='width:<%=t_shou>maxShouRu?100: t_shou/maxShouRu*100%>%;'>
						<%if(t_shou>t_chengBen&&t_shou!=0){ %>
							<div class="depart_liRunLine" style="margin-left:-1px;left:<%=(t_chengBen)/t_shou*100%>%;"></div>
						<%} %>
						</div>
						
					</td>
					<td><div style='width:120px;text-align: center;' class="nowrapText"><%=TypeUtils.formatMoney(t_chengBen, "")%></div></td>
					<td><div style='width:120px;text-align: center;' class="nowrapText"><%=TypeUtils.formatMoney(t_shou, "")%></div></td>
					<td><div style='width:120px;text-align: center;' class="nowrapText"><%=TypeUtils.formatMoney(t_shou-t_chengBen, "")%></div></td>
				</tr>
			<%}if(departmentList.isEmpty()){ %>
				<tr>
					<td colspan="10" style="padding-left:100px;"> 暂无数据</td>
				</tr>
			<%} %>
		</tbody>
	</table>

</div>