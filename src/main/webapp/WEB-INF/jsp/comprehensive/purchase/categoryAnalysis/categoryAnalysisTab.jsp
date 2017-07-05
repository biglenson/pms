<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = request.getContextPath();
int index=TypeUtils.getIntFromString(request.getParameter("index"));
%>
<div class="tabTitle">
	<ul>
		<li onclick="changeCategoryAnalysis(0)" class="<%=index==0?"on":""%>">采购品类金额分析</li>
		<li onclick="changeCategoryAnalysis(1)" class="<%=index==1?"on":""%>">采购品类项目数分析</li>
	</ul>
</div>
