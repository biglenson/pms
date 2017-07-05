<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = request.getContextPath();
Integer index=(Integer)request.getAttribute("index");
%>

<jsp:include page="touziDetailTab.jsp"></jsp:include>
<%if(index==0){ %>
<jsp:include page="touziDetailCapex.jsp"></jsp:include>
<%}else if(index==1){ %>
<jsp:include page="touziDetailOpex.jsp"></jsp:include>
<%} %>

<jsp:include page="/WEB-INF/jsp/common/viewChangeTime.jsp">
	<jsp:param name="lastUpdateDIV" value="touziDetailDIVTime" />
</jsp:include>