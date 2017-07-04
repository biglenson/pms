<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = request.getContextPath();
/* CAPEXProject project=(CAPEXProject)request.getAttribute("project"); */
Integer index=(Integer)request.getAttribute("index");
if(index==null){
	index=0;
}
%>
	<jsp:include  page="planDIVTab.jsp">
		<jsp:param value="<%=index %>" name="index"/>
	</jsp:include>
	<%if(index==0){ %>
		<jsp:include  page="touzhiPlan.jsp" />
	<%}else if(index==1){%>
		<jsp:include  page="kaizhiPlan.jsp" />
	<%}else if(index==2){%>
		<jsp:include  page="zhuanziPlan.jsp" />
	<%} %>
	<jsp:include page="/WEB-INF/jsp/common/viewChangeTime.jsp">
		<jsp:param  name="lastUpdateDIV" value="gongchengPlanDIVTimeDIV"/>
	</jsp:include>
