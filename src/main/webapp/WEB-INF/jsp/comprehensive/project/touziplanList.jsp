<%@page import="com.easytrack.customization.cmcc.bean.CMCCTouziPlan"%>
<%@page import="com.easytrack.customization.cmcc.action.FormBaseResove"%>
<%@page import="com.easytrack.customization.cmcc.bean.CAPEXProject"%>
<%@page import="com.easytrack.commons.db.PageInfo"%>
<%@page import="com.easytrack.platform.ui.UIUtils_NEW"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="java.util.List"%>
<%@page import="com.easytrack.platform.constants.*"%>
<%@page import="com.easytrack.commons.util.CalendarUtils"%>
<%@page import="com.easytrack.commons.util.TypeUtils"%>
<%@page import="com.easytrack.commons.util.MessageUtils"%>
<%@page import="java.util.Locale"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>	
<%  
	String path=request.getContextPath();
	Locale locale = (Locale) session.getAttribute("org.apache.struts.action.LOCALE");
    SessionManager webMgr = new SessionManager();
    webMgr.init(session);
    User user=webMgr.getCurrentUser();
    PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	List<CMCCTouziPlan> dataList = pageInfo.getItems();
%>
<% request.setAttribute("selectedTab", 1); %>
<%@include file="capexListTab.jsp" %>
<div id="listDIV"  class="tabContent"> 
	<table border="0" cellpadding="0" cellspacing="0" class="listTable" id="entryTable">
    	<thead>
			<tr>
				<th width="100%"><div style='width:100%'>项目集/项目名称</div></th>
				<th><div style='width:250px;'>项目集/项目编码</div></th>
				<th><div style='width:80px;'>专业</div></th>
				<th><div style='width:80px;'>属性</div></th>
				<th><div style='width:91px;'>项目集总投资</div></th>
				<th><div style='width:90px;'>上年底累计完成资本开支</div></th>
				<th><div style='width:90px;'>项目集结转资本开支</div></th>	
			</tr>
		</thead>
		<tbody>
			<%
				for(int i=0,j=dataList.size();i<j;i++){
					CMCCTouziPlan touziPlan = dataList.get(i);
					CMCCTouziPlan p=touziPlan;
					Double zongValue=FormBaseResove.getDoubleValue(user, p, "num02");
					Double lastValue=FormBaseResove.getDoubleValue(user, p, "num06");
					Double lastValue2=FormBaseResove.getDoubleValue(user,p, "num04");
			%>
				<tr class='listTableTR'>
					<td align="center"><%=TypeUtils.xmlEncoderForIE(touziPlan.getStr18()) %></td>
					<td align="center"><%=TypeUtils.xmlEncoderForIE(touziPlan.getStr01()) %></td>
					<td align="center"><%=TypeUtils.xmlEncoderForIE(FormBaseResove.resoveFieldAsString(user, p, "enum01", request)) %></td>
					<td align="center"><%=TypeUtils.xmlEncoderForIE(FormBaseResove.resoveFieldAsString(user, p, "enum04", request)) %></td>
					<td align="center">
						<%=FormBaseResove.formatWanMoney(zongValue) %>
					</td>
					<td align="center">
						<%=FormBaseResove.formatWanMoney(lastValue) %>
					</td>
					<td align="center">
						<%=FormBaseResove.formatWanMoney(lastValue2) %>
					</td>
				</tr>
			<%
				}
			%>
			
			<%
				if(dataList.size() == 0){
			%>
				<tr class="listTableTR" >
					<td colspan="9" style="padding-left: 10px;">暂无数据</td>
				</tr>
			<%
				}
			%>
		</tbody>
	</table>
<%=UIUtils_NEW.pageFunctionToolbar("changeTouziplanPage",pageInfo, request, response)%>
<div style="height:10px;"></div>
</div>
