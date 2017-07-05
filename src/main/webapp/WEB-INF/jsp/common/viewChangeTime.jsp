<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.zq.commons.utils.TypeUtils"%>
<%
String date=(String)request.getAttribute("LASUPDATESTRING");
if(date!=null&&!"".equals(date)){
%>
<span
	id="<%=TypeUtils.nullToString(request.getParameter("lastUpdateDIV")) %>Span"
	class="viewChangeSpan  ">数据更新时间:<%=date%></span>
<%}%>
<script type="text/javascript">
	$("#<%=TypeUtils.nullToString(request.getParameter("lastUpdateDIV")) %>").html("").append($("#<%=TypeUtils.nullToString(request.getParameter("lastUpdateDIV")) %>Span"));
</script>