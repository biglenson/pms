<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%@ page import= "com.zq.entity.basic.capex.BasCAPEXProject" %>
<%@ page import= "com.zq.entity.basic.capex.BasCAPEXInvestPlan" %>
<%@ page import= "com.zq.commons.utils.UIUtils" %>
<%@ page import= "com.zq.commons.result.PageInfo" %>

<%  
	String path=request.getContextPath();
	PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
 	List<BasCAPEXProject> dataList = pageInfo.getItems();
	Map<String,String> projectZhunziMoney = (Map<String,String>)request.getAttribute("projectZhunziMoney");
	Map<String,BasCAPEXInvestPlan> projectTouziMap = (Map<String,BasCAPEXInvestPlan>)request.getAttribute("touziPlan"); 
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
			    //TypeUtils.prepareForFormList(user, dataList, request);
				//int year=TypeUtils.getIntFromString(request.getParameter("year"));
				for(int i=0,j=dataList.size();i<j;i++){
					BasCAPEXProject capexProject = dataList.get(i);
					String zhuanziMoney = projectZhunziMoney.get(capexProject.getProjCode());
					BasCAPEXInvestPlan touziPlan = projectTouziMap.get(capexProject.getProjCode());
			%>
			<tr class='listTableTR'>
				<td align="center" class='linkURL'
					onclick='openCAPEXMain(<%=capexProject.getId()%>)'><div
						style='text-align: center;'><%=TypeUtils.htmlEncoder(capexProject.getProjName())%></div></td>
				<td align="center"><div><%=TypeUtils.xmlEncoderForIE(touziPlan==null?"":String.valueOf(touziPlan.getAttribute()))%></div></td>
				<td align="center"><div><%=TypeUtils.xmlEncoderForIE(touziPlan==null?"":String.valueOf(touziPlan.getFirstDomain()))%></div></td>
				<td align="center"><div><%=TypeUtils.xmlEncoderForIE(String.valueOf(touziPlan.getDepartment()))%></div></td>
				<td align="center"><div><%=TypeUtils.xmlEncoderForIE(TypeUtils.date2String(capexProject.getReqFreezeTime()))%></div></td>
				<td align="center"><div>
						<%TypeUtils.string2Double(capexProject.getProjSetupAmount());%>
					</div></td>
				<td align="center"><div style='width: 102px;'><%=TypeUtils.string2Double(zhuanziMoney)%></div></td>
				<td align="center"><div style='width: 103px;'><%=capexProject.getProjStatus()%></div></td>
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
	<%=UIUtils.pageFunctionToolbar("changeCapexProjectPage",pageInfo, request)%>
	<div style="height: 10px;"></div>
</div>
