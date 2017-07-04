<%-- <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>

<%
	String path2 = request.getContextPath();
	SessionManager webMgr2 = new SessionManager();
	webMgr2.init(session);
	User user2 = webMgr2.getCurrentUser();
	Locale locale2 = webMgr2.getCurrentLocale(); 
	int selectedTab=TypeUtils.nullToInt(request.getAttribute("selectedTab"));
%>
<%=UIUtils_NEW.tabPanelStart(request, response) %>
<%=UIUtils_NEW.tabPanel("javascript:yusuanProjectList()", "预算项目", selectedTab==1, request, response) %>
<%=UIUtils_NEW.tabPanel("javascript:opexProjectList()", "OPEX项目", selectedTab==2, request, response) %>
<%=UIUtils_NEW.tabPanelEnd(request, response) %>
<input type="hidden" id="thisPage" name="thisPage" value = "1"/> --%>
