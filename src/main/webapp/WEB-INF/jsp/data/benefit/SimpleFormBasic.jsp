<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import= "com.zq.commons.utils.UIUtils" %>
<%@ page import= "com.zq.commons.result.PageInfo" %>
<%
	String path = request.getContextPath();
	String pageTitle = (String)request.getAttribute("pageTitle");
	Integer appid = (Integer)request.getAttribute("appid");
	Long pid = (Long)request.getAttribute("pid");
	String url = (String)request.getAttribute("url");
	PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
%>

<script type="text/javascript">
//效益评估
function openFormScorecard() {
	document.frm.action = "<%=path%>/datamap/simpleFromBenefit";
	etSubmit(document.frm);
}
</script>

<%-- 输出Head1模块 --%>
<jsp:include page="../../common/Head1.jsp" />

<!-- 内容主体 -->
<form name="frm" action="<%=path%>/datamap/simpleFormBasic" method="post">
<input type="hidden" name="pageTitle" value="<%= pageTitle %>">
<input type="hidden" name="url" value="<%= url %>">

<%=UIUtils.tabPanelStart(request)%>
<%=UIUtils.tabPanel(true, "javascript:simpleForm();", pageTitle+"基本信息", null, true, request)%>
<%=UIUtils.tabPanel(true, "javascript:openFormScorecard();", "效益评估", null, false, request)%>
<%=UIUtils.tabPanelEnd(request)%>

<table>
	<tbody>
		<h1>&nbsp;&nbsp;&nbsp;&nbsp;基本信息页</h1>
	</tbody>
</table>

<!-- 以上为表单 -->
</form>
<%-- 输出公共BodyEnd模块 --%>
<jsp:include page="../../common/BodyEnd.jsp" />
