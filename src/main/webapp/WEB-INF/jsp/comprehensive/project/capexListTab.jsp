<%@page import="com.easytrack.platform.ui.UIUtils_NEW"%>
<%@page import="java.util.Locale"%>
<%@page import="com.easytrack.commons.util.TypeUtils"%>
<%@page import="com.easytrack.component.profile.User"%>
<%@page import="com.easytrack.platform.ui.SessionManager"%>
<%@page import="com.easytrack.component.project.Project"%>
<%@ page contentType="text/html; charset=utf-8"%>

<%
	SessionManager webMgr1 = new SessionManager();
	webMgr1.init(session);
	int index=TypeUtils.getIntFromString(request.getParameter("index"));
%>
<%if(index == 0){ %>
	<div class="tabMore linkURL" onclick="openniandutouziplan()">更多</div>
<%}else{ %>
	<div class="tabMore linkURL" onclick="openCapexProjectList()">更多</div>
<%} %>
<%--
<%=UIUtils_NEW.tabPanelStart(request, response) %>
<%=UIUtils_NEW.tabPanel("javascript:A_changeList(0)", "投资计划", index==0, request, response) %>
<%=UIUtils_NEW.tabPanel("javascript:A_changeList(1)", "CAPEX项目", index==1, request, response) %>
<%=UIUtils_NEW.tabPanelEnd(request, response) %>
 --%>
 <div class="tabTitle">
 	<ul>
 		<li onclick="A_changeList(0)" class="<%=index==0?"on":""%>">投资计划</li>
 		<li onclick="A_changeList(1)" class="<%=index==1?"on":""%>">CAPEX项目</li>
 	</ul>
 </div>
 
<input type="hidden" id="thisPage" name="thisPage" value = "1"/>
