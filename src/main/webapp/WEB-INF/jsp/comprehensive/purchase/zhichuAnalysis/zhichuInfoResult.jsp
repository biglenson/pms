<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%@ page import="com.zq.commons.utils.StringUtils"%>
<%
String path = request.getContextPath();
Integer index=(Integer)request.getAttribute("index");
if(index==null){
	index=0;
}
List<String> methodNames = (List<String>)request.getAttribute("methodNames");
%>
<jsp:include page="zhichuAnalysisTab.jsp">
	<jsp:param value="<%=index %>" name="index" />
</jsp:include>
<%if(index == 0) {%>
<jsp:include page="zhichuMoney.jsp" />
<%}else if(index == 1){ %>
<jsp:include page="zhichuProject.jsp" />
<%} %>
<jsp:include page="/WEB-INF/jsp/common/viewChangeTime.jsp">
	<jsp:param name="lastUpdateDIV" value="zhichuInfoDIVTimeDIV" />
</jsp:include>