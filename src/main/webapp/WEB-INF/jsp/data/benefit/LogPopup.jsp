<%@page import="org.apache.commons.io.filefilter.FalseFileFilter"%>
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
<%-- function attachFun() {
 	document.frm.action="<%=path%>/AttachAction.do";
	document.frm.operation.value="list";
	etSubmit(document.frm);
}
function topicFun(){
	document.frm.action="<%=path%>/TopicAction.do";
	document.frm.operation.value="openTopic";
	etSubmit(document.frm);
}

function logFun(){
	document.frm.action = "<%=path%>/SimpleFormAction.do";
	document.frm.operation.value="openHistory";
	etSubmit(document.frm);
}
function backLogItemCreateTask(){
	document.frm.action="<%=path%>/AgileAction.do";
	document.frm.operation.value = "backLogItemCreateTask";
	etSubmit(document.frm);
}
function checkPointFun(){
	document.frm.action="<%=path%>/CheckAction.do";
	document.frm.operation.value="openReviewCheck";
	etSubmit(document.frm);
}
function relatedFormFun(id){
	document.frm.action="<%=path%>/SimpleFormAction.do";
	document.frm.fromObjectSubType.value=id;
	document.frm.operation.value="listRelatedForm";
	etSubmit(document.frm);
}

function openFun() {
	document.frm.action="<%=path%>/DemandAction.do";
	document.frm.operation.value="openDemand";
	etSubmit(document.frm);
}
function openBaseLineFun(){
	document.frm.action = "<%=path%>/DemandAction.do";
	document.frm.operation.value = "openDemandBaseLine";
	etSubmit(document.frm);
}

function testResoultForm(){
	document.frm.action="<%=path%>/AgileAction.do";
	document.frm.operation.value = "createTestResult";
	etSubmit(document.frm);
}
function backlogDefectForm(){
	document.frm.action="<%=path%>/AgileAction.do";
	document.frm.operation.value = "backLogDefectList";
	document.frm.isDialog1.value = "true";
	etSubmit(document.frm);
} --%>
</script>

<%-- 输出Head1模块 --%>
<jsp:include page="../../common/Head1.jsp" />

<form name="frm" action="<%=path%>/SimpleFormAction.do" method="post">
	
	<div style="height:40px"> 
	  <table style="border:0;cellpadding:0;cellspacing:0" id="fieldTable" class="listTable" >
		<thead>
         <tr >
         	<th nowrap="nowrap"><div style="width: 30px;">序号</div></th>
         	<th nowrap="nowrap"><div style="width: 60px;">操作者</div></th>
         	<th nowrap="nowrap"><div style="width: 110px;">时间</div></th>
         	<th nowrap="nowrap"><div style="width: 100px;">操作</div></th>
			<th style='width:100%' nowrap="nowrap"><div style="width:150px;margin:0 auto;">处理意见</div></th>
		  </tr> 
		</thead>
		  
		<tbody>
			<%-- <%
		 	for(int i = 0; i < eventList.size(); i++){ 
		 		WFLog log = (WFLog)eventList.get(i);
			 %>		
			<tr class="listTableTR"> 
				<td align="center"><%=i+1%></td>
				<td><%=log.getActionUser().getDisplayName()%></td>
				<td align="center"><%=TypeUtils.date2String(log.getActionTime())%>&nbsp;</td>
				<td><%=log.getDisplayActionDesc(locale)%>&nbsp;</td>
				<td><%=TypeUtils.nullToString(log.getRemark())%>&nbsp;</td>
			</tr>
			<%}
			if (eventList.size() == 0) {
			%>
			  <tr class="listTableTR">
			    <td colspan="10"><bean:message key="NoRecord"/></td>
			  </tr>
			<%}%>  --%>
		</tbody>
     </table>
</div>

</form>
<%-- <%
boolean WF_JBPM_DIAGRAM = "true".equals(Config.getConfig("CONFIG", "WF-JBPM-DIAGRAM"));
if(WF_JBPM_DIAGRAM){
%>
<div id="imageJbpmJSONDIV" style="width: 820px;height: 400px;overflow: auto;text-align: center;">
	<img  src="<%=path %>/SimpleFormAction.do?operation=imageJbpmJSON&objectID=<%=mode.getId()%>&objectType=<%=objectType%>&objectSubType=<%=objectSubType%>&schemaID=<%=mode.getCategory()%>&_id=<%=Math.random() %>" />
</div> --%>


<%-- 输出公共BodyEnd模块 --%>
<jsp:include page="../../common/BodyEnd.jsp" />
