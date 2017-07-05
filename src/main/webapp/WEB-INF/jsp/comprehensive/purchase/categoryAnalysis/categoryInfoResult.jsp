<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = request.getContextPath();
Integer index=(Integer)request.getAttribute("index");
if(index==null){
	index=0;
}
List<String> pinleiNames = (List<String>)request.getAttribute("pinleiNames");
%>
<jsp:include page="categoryAnalysisTab.jsp">
	<jsp:param value="<%=index %>" name="index" />
</jsp:include>
<%if(index == 0) {%>
<jsp:include page="categoryMoney.jsp" />
<%}else if(index == 1){ %>
<jsp:include page="categoryProject.jsp" />
<%} %>
<jsp:include page="/WEB-INF/jsp/common/viewChangeTime.jsp">
	<jsp:param name="lastUpdateDIV" value="categoryInfoDIVTimeDIV" />
</jsp:include>