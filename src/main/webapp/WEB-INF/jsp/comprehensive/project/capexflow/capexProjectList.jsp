<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%  
	String path=request.getContextPath();
/* 	List<CAPEXProject> dataList = pageInfo.getItems();
	Map<String,String> projectZhunziMoney = (Map<String,String>)request.getAttribute("projectZhunziMoney");
	Map<String,CMCCTouziPlan> projectTouziMap = (Map<String,CMCCTouziPlan>)request.getAttribute("projectTouziMap"); */
%>
<% request.setAttribute("selectedTab", 2); %>
<%@include file="capexListTab.jsp"%>
<div id="listDIV" class="tabContent">
	<table border="0" cellpadding="0" cellspacing="0" class="listTable"
		id="entryTable">
		<thead>
			<tr>
				<th width="100%"><div style='width: 100%'>项目名称</div></th>
				<th><div style='width: 60px;'>属性</div></th>
				<th><div style='width: 70px;'>专业</div></th>
				<th><div style='width: 122px;'>需求部门</div></th>
				<th><div style='width: 113px;'>需求冻结时间</div></th>
				<th><div style='width: 102px;'>立项批复金额</div></th>
				<th><div style='width: 102px;'>转资金额</div></th>
				<th><div style='width: 103px;'>当前状态</div></th>
			</tr>
		</thead>
		<tbody>
			<%
			    TypeUtils.prepareForFormList(user, dataList, request);
				int year=TypeUtils.getIntFromString(request.getParameter("year"));
				for(int i=0,j=dataList.size();i<j;i++){
					CAPEXProject capexProject = dataList.get(i);
					String zhuanziMoney = projectZhunziMoney.get(capexProject.getCode());
					CMCCTouziPlan touziPlan = capexProject.getYearTouziPlan(year);
			%>
			<tr class='listTableTR'>
				<td align="center" class='linkURL'
					onclick='openCAPEXMain(<%=capexProject.getId()%>)'><div
						style='text-align: center;'><%=TypeUtils.htmlEncoder(capexProject.getTitle())%></div></td>
				<td align="center"><div><%=TypeUtils.xmlEncoderForIE(touziPlan==null?"":TypeUtils.resoveFieldAsString(user, touziPlan, "enum04", request))%></div></td>
				<td align="center"><div><%=TypeUtils.xmlEncoderForIE(touziPlan==null?"":TypeUtils.resoveFieldAsString(user, touziPlan, "enum01", request))%></div></td>
				<td align="center"><div><%=TypeUtils.xmlEncoderForIE(TypeUtils.resoveFieldAsString(user, capexProject, "str25.sys01",request))%></div></td>
				<td align="center"><div><%=TypeUtils.xmlEncoderForIE(TypeUtils.resoveFieldAsString(user, capexProject, "str25.date04", request))%></div></td>
				<td align="center"><div>
						<% double approvalM=TypeUtils.getNotNullDoubleValue(user, capexProject, "num01");
						Double zhuanZi=TypeUtils.string2Double(zhuanziMoney);
					%>
						<%=TypeUtils.formatWanMoney(approvalM) %>
					</div></td>
				<td align="center"><div style='width: 102px;'><%=TypeUtils.formatWanMoney(zhuanZi)%></div></td>
				<td align="center"><div style='width: 103px;'><%=TypeUtils.getEnumValueName(user, capexProject, "enum06")%></div></td>
			</tr>
			<%
				}
			%>

			<%
				if(dataList.size() == 0){
			%>
			<tr class="listTableTR">
				<td colspan="9" style="padding-left: 10px;">暂无数据</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<%=UIUtils_NEW.pageFunctionToolbar("changeCapexProjectPage",pageInfo, request, response)%>
	<div style="height: 10px;"></div>
</div>
