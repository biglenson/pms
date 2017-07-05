<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>%>
<%
String path = request.getContextPath();
Integer index=(Integer)request.getAttribute("index");
if(index==null){
	index=0;
}
%>
<jsp:include page="planDIVTab.jsp">
	<jsp:param value="<%=index %>" name="index" />
</jsp:include>

<jsp:include page="kaizhiPlan.jsp" />

<jsp:include page="/WEB-INF/jsp/common/viewChangeTime.jsp">
	<jsp:param name="lastUpdateDIV" value="planDIVDIVTimeDIV" />
</jsp:include>

