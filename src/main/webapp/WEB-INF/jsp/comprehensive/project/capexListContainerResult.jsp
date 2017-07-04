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
	<jsp:include page="/jsp/viewChangeTime.jsp">
		<jsp:param  name="lastUpdateDIV" value="gongchengListTimeDIV"/>
	</jsp:include>
