<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = request.getContextPath();
Integer index=(Integer)request.getAttribute("index");
if(index==null){
	index=0;
}
%>
	<%if(index==0){ %>
		<jsp:include  page="touziplanList.jsp" />
	<%}else if(index==1){%>
		<jsp:include  page="capexProjectList.jsp" />
	<%} %>
	<jsp:include page="/WEB-INF/jsp/common/viewChangeTime.jsp">
		<jsp:param  name="lastUpdateDIV" value="gongchengListTimeDIV"/>
	</jsp:include>
