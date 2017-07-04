<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%
	int index=TypeUtils.getIntFromString(request.getParameter("index"));
%>
<%if(index == 0){ %>
	<div class="tabMore linkURL" onclick="openniandutouziplan()">更多</div>
<%}else{ %>
	<div class="tabMore linkURL" onclick="openCapexProjectList()">更多</div>
<%} %>
 <div class="tabTitle">
 	<ul>
 		<li onclick="A_changeList(0)" class="<%=index==0?"on":""%>">投资计划</li>
 		<li onclick="A_changeList(1)" class="<%=index==1?"on":""%>">CAPEX项目</li>
 	</ul>
 </div>
 
<input type="hidden" id="thisPage" name="thisPage" value = "1"/>
