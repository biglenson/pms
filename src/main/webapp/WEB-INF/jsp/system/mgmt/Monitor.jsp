<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String pageTitle = (String)request.getAttribute("pageTitle");
	Integer appid = (Integer)request.getAttribute("appid");
	Long pid = (Long)request.getAttribute("pid");
	String url = (String)request.getAttribute("url");
%>
<%-- 输出Head2模块 --%>
<jsp:include page="../../common/Head2.jsp" />
<%-- 输出公共BodyStart模块 --%>
<jsp:include page="../../common/BodyStart1.jsp">
	<jsp:param name="pageTitle" value="<%= pageTitle %>" />
	<jsp:param name="appid" value="<%= appid %>" />
	<jsp:param name="pid" value="<%= pid %>" />
	<jsp:param name="url" value="<%= url %>" />
</jsp:include>
<!-- 内容主体 -->
<div class="content-main">
<!-- 空格 -->
<div class="Toolbar-spacing"></div>
<!-- 横线 -->
<div class="barListSplitLine"></div>
	<iframe src="/druid/login.html" width="98%" height="600"></iframe>	
</div>
<%-- 输出公共BodyEnd模块 --%>
<jsp:include page="../../common/BodyEnd.jsp" />
			
