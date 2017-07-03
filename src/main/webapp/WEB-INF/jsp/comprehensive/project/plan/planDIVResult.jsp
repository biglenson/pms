<%@page import="com.easytrack.customization.cmcc.action.FormBaseResove"%>
<%@page import="com.easytrack.commons.util.TypeUtils"%>
<%@page import="com.easytrack.component.ComponentFactory"%>
<%@page import="com.easytrack.customization.cmcc.bean.CAPEXProject"%>
<%@page import="com.easytrack.component.profile.*"%>
<%@page import="com.easytrack.platform.ui.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
SessionManager webMgr = new SessionManager();
webMgr.init(session);
User user = webMgr.getCurrentUser();
Locale locale = webMgr.getCurrentLocale();
CAPEXProject project=(CAPEXProject)request.getAttribute("project");
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
	<jsp:include page="/jsp/viewChangeTime.jsp">
		<jsp:param  name="lastUpdateDIV" value="gongchengPlanDIVTimeDIV"/>
	</jsp:include>
