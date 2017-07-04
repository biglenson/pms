<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = request.getContextPath();
int index=TypeUtils.getIntFromString(request.getParameter("index"));
%>
<%--
<%=UIUtils_NEW.tabPanelStart(request, response) %>
	<%=UIUtils_NEW.tabPanel("javascript:changeZhichuAnalysis(0)", "金额", index==0, request, response)%>
	<%=UIUtils_NEW.tabPanel("javascript:changeZhichuAnalysis(1)", "项目数", index==1, request, response)%>
<%=UIUtils_NEW.tabPanelEnd(request, response) %>
 --%>
 
<div class="tabTitle">
	 	<ul>
	 		<li onclick="changeZhichuAnalysis(0)" class="<%=index==0?"on":""%>">采购方式金额分析</li>
	 		<li onclick="changeZhichuAnalysis(1)" class="<%=index==1?"on":""%>">采购方式项目数分析</li>
	 	</ul>
	 </div>	