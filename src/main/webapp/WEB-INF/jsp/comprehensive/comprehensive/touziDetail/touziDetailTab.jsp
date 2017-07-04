<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = request.getContextPath();
Integer index=(Integer)request.getAttribute("index");
%>
<%if(index == 0){ %>
<div class="tabMore linkURL" onclick="openTouzizhixingDetail()">更多</div>
<%}else{ %>
<div class="tabMore linkURL" onclick="openYusuanFenjie()">更多</div>
<%} %>

 <div class="tabTitle">
 	<ul>
 		<li onclick="loadTouziDetialFun(0)" class="<%=index==0?"on":""%>">投资计划执行情况</li>
 		<li onclick="loadTouziDetialFun(1)" class="<%=index==1?"on":""%>">预算执行</li>
 	</ul>
 </div>