<%-- <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%  
	String path=request.getContextPath();
    PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	List<OPEXProject> dataList = pageInfo.getItems();
%>
<% request.setAttribute("selectedTab", 2); %>
<%@include file="opexListTab.jsp" %>
<div id="listDIV" > 
 	<table border="0" cellpadding="0" cellspacing="0" class="listTable" id="entryTable">
    	<thead>
			<tr>
				<th><div style='width:125px'>项目编号</div></th>
				<th><div style='width:165px;'>项目名称</div></th>
				<th><div style='width:105px;'>费用类别</div></th>
				<th><div style='width:117px;'>归口部门</div></th>
				<th><div style='width:125px;'>预算金额</div></th>
				<th><div style='width:125px;'>立项批复金额</div></th>
				<th><div style='width:125px;'>报账金额</div></th>
				<th><div style='width:105px;'>当前进度</div></th>	
			</tr>
		</thead>
		<tbody>
			<%
			TypeUtils.prepareForFormList(user, dataList, request);
				for(int i=0,j=dataList.size();i<j;i++){
					OPEXProject opexProject = dataList.get(i);
					String feeCategory = (String)TypeUtils.resoveFieldAsObject(user, opexProject, "str02.str01.str01.enum01", request);
					String guikouDepart = (String)TypeUtils.resoveFieldAsObject(user, opexProject, "str02.sys02", request);
					Double yusuanMoney = (Double)TypeUtils.resoveFieldAsObject(user, opexProject, "str02.num05", request);
			%>
				<tr class='listTableTR'>
					<td align="left" class='linkURL' onclick='openOPEXMain(<%=opexProject.getId()%>)'><div style="width: 125px;"><%=TypeUtils.htmlEncoder(opexProject.getCode())%></div></td>
					<td align="left" class='linkURL' onclick='openOPEXMain(<%=opexProject.getId()%>)'><div style='width:165px;'><%=TypeUtils.htmlEncoder(opexProject.getTitle())%></div></td>
					<td align="left"><div style='width:105px;'><%=TypeUtils.xmlEncoderForIE(feeCategory==null?"":feeCategory)%></div></td>
					<td align="left"><div style='width:117px;'><%=TypeUtils.xmlEncoderForIE(guikouDepart==null?"":guikouDepart)%></div></td>
					<td align="left"><div style='width:125px;'><%=TypeUtils.formatMoney(yusuanMoney)%></div></td>
					<td align="left"><div style='width:125px;'><%=TypeUtils.string2Double(opexProject.getLixiangMoney())%></div></td>
					<td align="left"><div style='width:125px;'><%=TypeUtils.string2Double(opexProject.getBaozhangMoney())%></div></td>
					<td align="left"><div style='width:105px;'><%=TypeUtils.xmlEncoderForIE(OPEXProject.PHASENAMES[opexProject.getCurrentPhase()])%></div></td>
				</tr>
			<%
				}
			%>
			
			<%
				if(dataList.size() == 0){
			%>
				<tr class="listTableTR" >
					<td colspan="9"><bean:message key="NoRecord"/></td>
				</tr>
			<%
				}
			%>
		</tbody>
	</table>
<%=UIUtils_NEW.pageFunctionToolbar("changeOpexProjectPage",pageInfo, request, response)%>
</div>
 --%>