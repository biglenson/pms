<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%@ page import= "com.zq.commons.utils.UIUtils" %>
<%@ page import= "com.zq.commons.result.PageInfo" %>
<%@ page import= "com.zq.entity.basic.capex.BasCAPEXInvestPlan" %>
<%  
	String path=request.getContextPath();
    PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	List<BasCAPEXInvestPlan> dataList = pageInfo.getItems();
%>
<% request.setAttribute("selectedTab", 1); %>
<%@include file="capexListTab.jsp"%>
<div id="listDIV" class="tabContent">
	<table border="0" cellpadding="0" cellspacing="0" class="listTable"
		id="entryTable">
		<thead>
			<tr>
				<th width="100%"><div style='width: 100%'>项目集/项目名称</div></th>
				<th><div style='width: 250px;'>项目集/项目编码</div></th>
				<th><div style='width: 80px;'>专业</div></th>
				<th><div style='width: 80px;'>属性</div></th>
				<th><div style='width: 91px;'>项目集总投资</div></th>
				<th><div style='width: 90px;'>上年底累计完成资本开支</div></th>
				<th><div style='width: 90px;'>项目集结转资本开支</div></th>
			</tr>
		</thead>
		<tbody>
			<%
				for(int i=0,j=dataList.size();i<j;i++){
					BasCAPEXInvestPlan touziPlan = dataList.get(i);
					BasCAPEXInvestPlan p=touziPlan;
					Double zongValue=TypeUtils.string2Double(p.getTotalInvest());
					Double lastValue=TypeUtils.string2Double(p.getLastFinishCapex());
					Double lastValue2=TypeUtils.string2Double(p.getTransferCapex());
			%>
			<tr class='listTableTR'>
				<td align="center"><%=TypeUtils.xmlEncoderForIE(touziPlan.getProjName()) %></td>
				<td align="center"><%=TypeUtils.xmlEncoderForIE(touziPlan.getProjCode()) %></td>
				<td align="center"><%=TypeUtils.xmlEncoderForIE(String.valueOf(p.getFirstDomain())) %></td>
				<td align="center"><%=TypeUtils.xmlEncoderForIE(String.valueOf(p.getAttribute())) %></td>
				<td align="center"><%=TypeUtils.formatWanMoney(zongValue) %></td>
				<td align="center"><%=TypeUtils.formatWanMoney(lastValue) %></td>
				<td align="center"><%=TypeUtils.formatWanMoney(lastValue2) %></td>
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
	<%=UIUtils.pageFunctionToolbar("changeTouziplanPage",pageInfo, request)%>
	<div style="height: 10px;"></div>
</div>
