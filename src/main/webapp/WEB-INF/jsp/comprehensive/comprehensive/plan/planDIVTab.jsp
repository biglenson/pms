<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = request.getContextPath();
int index=TypeUtils.getIntFromString(request.getParameter("index"));
%>
<%if(index == 0 || index == 2){ %>
<div class="tabMore  linkURL" onclick="openduoxiangmucapexDetail()">更多</div>
<%}else if(index == 1){ %>
<div class="tabMore linkURL" onclick="openduoxiangmuopex()">更多</div>
<%}%>
<div class="tabTitle">
 	<ul>
 		<li onclick="A__changePlan(0)" class="<%=index==0?"on":""%>">资本开支</li>
 		<li onclick="A__changePlan(1)" class="<%=index==1?"on":""%>">成本开支</li>
 		<li onclick="A__changePlan(2)" class="<%=index==2?"on":""%>">转资</li>
 	</ul>
 </div>