<%@page import="com.easytrack.customization.cmcc.action.FormBaseResove"%>
<%@page import="com.easytrack.commons.util.TypeUtils"%>
<%@page import="com.easytrack.component.ComponentFactory"%>
<%@page import="com.easytrack.customization.cmcc.bean.CAPEXProject"%>
<%@page import="com.easytrack.component.profile.*"%>
<%@page import="com.easytrack.platform.ui.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
SessionManager webMgr = new SessionManager();
webMgr.init(session);
int index=TypeUtils.getIntFromString(request.getParameter("index"));
%>
<%if(index == 0){ %>
<div class="tabMore linkURL" onclick="openTouzizhixingDetail()">更多</div>
<%}else{ %>
<div class="tabMore linkURL" onclick="openduoxiangmucapexDetail()">更多</div>
<%} %>
<div style="height:10px;"></div>
<%--
<%=UIUtils_NEW.tabPanelStart(request, response) %>
	<%=UIUtils_NEW.tabPanel("javascript:A__changePlan(0)", "投资计划", index==0, request, response)%>
	<%=UIUtils_NEW.tabPanel("javascript:A__changePlan(1)", "资本开支", index==1, request, response)%>
	<%=UIUtils_NEW.tabPanel("javascript:A__changePlan(2)", "转资", index==2, request, response)%>
	<%//=UIUtils_NEW.tabPanel("", "效益分析", index==3, request, response)%>
<%=UIUtils_NEW.tabPanelEnd(request, response) %>
 --%>
<div class="tabTitle">
 	<ul>
 		<li onclick="A__changePlan(0)" class="<%=index==0?"on":""%>">投资计划</li>
 		<li onclick="A__changePlan(1)" class="<%=index==1?"on":""%>">资本开支</li>
 		<li onclick="A__changePlan(2)" class="<%=index==2?"on":""%>">转资</li>
 	</ul>
 </div>