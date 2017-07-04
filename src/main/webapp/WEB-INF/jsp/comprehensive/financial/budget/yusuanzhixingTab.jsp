<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = request.getContextPath();
int index=TypeUtils.getIntFromString(request.getParameter("index"));
%>
<div class="tabMore linkURL" onclick="openchengbenfeiyongDetail()">更多</div>
 
 <div class="tabTitle">
 	<ul>
 		<li onclick="changeYusuanzhixing(0)" class="<%=index==0?"on":""%>">预算执行情况</li>
 		<li onclick="changeYusuanzhixing(1)" class="<%=index==1?"on":""%>">分部门预算执行情况</li>
 	</ul>	 
</div>	