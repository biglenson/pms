<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>

<% 
Integer index = (Integer)request.getAttribute("index");
if(index == null){
	index = 0;
}
%>

<jsp:include  page="yusuanzhixingTab.jsp">
	<jsp:param value="<%=index %>" name="index"/>
</jsp:include>
<%if(index == 0){ %>
	<jsp:include  page="./yusuanzhixingDetail.jsp" />
<%}else if(index == 1){%>
	<jsp:include  page="./yusuanzhixingDepartDetail.jsp" />
<%} %>
<jsp:include page="/WEB-INF/jsp/common/viewChangeTime.jsp">
	<jsp:param  name="lastUpdateDIV" value="caiwuYusuanzhixingDIVTimeDIV"/>
</jsp:include>