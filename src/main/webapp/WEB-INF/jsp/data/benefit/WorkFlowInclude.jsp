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
	
	int nameWidth = (760-30-180-80-50-100-(true?160:0)-10); //是否是后评估，这里还没有变量，先写成true
%>

<script type="text/javascript">

</script>

<form>
<!-- 工作流 -->
<%=UIUtils.togglePanelStart("工作流", true, request)%>
<table width='100%' border="0" cellpadding="0" cellspacing="0" class="listTable" id="attachTable">
	<thead>
	    <tr>
	    	<th ><div style="width:20px">&nbsp;</div></th>
	         	<th ><div style="width:30px">序号</div></th>
			<th width="100%"><div style="width:150px;margin: 0px auto;">活动名称</div></th>
			<th ><div style="width:200px">责任人</div></th>
			<th ><div style="width:120px">计划时间</div></th>
			<th ><div style="width:120px">实际时间</div></th>
			</tr> 
	</thead>
	<tbody>
		<tr class="listTableTR" >
			<%-- <td>
				<%if(act.getId()==1){%>
				<img src="<%=path%>/images/16x16/<%if(isNew){%>bulletin_board_on.gif<%}else{%>userSelect_check.png<%}%>">
				<%}else if(!isNew){%>
					<%if(currentActIDs.contains(act.getId())){%>
						<img src="<%=path%>/images/16x16/bulletin_board_on.gif">
					<%}else if(historyActIDs.contains(act.getId())){%>
						<img src="<%=path%>/images/16x16/userSelect_check.png">
					<%}%>
				<%}%>
			</td>
			<td>
			<%=act.getSeqNo() %>
			</td>
			<td>
				<%=TypeUtils.xmlEncoderForIE(act.getDisplayName(lan)) %>
			</td>
			<td>
				<%if(act.getId()==1){%>
					<%=CommonUtils.getUserName(user,mode.getCreateBy()) %>
				<%}else{%>
					
					<%if(isEdit){%>
					<div class="text-div" style="cursor: pointer;display:<%=editflag_responsor==FormViewItem.READ_ONLY?"none":"block" %>;" 
					<%if(!act.checkRole(user)){%>
					onclick="treeSelectUtils.showUserSelect(this.children[2],this.children[3],<%=Role.DEPARTMENT%>,<%=Role.ROOT_DEPARTMENT_ID%>,true);";
					<%}else{%>
					onclick="showFormAssignment(this.children[4],'<%=mode.getReferenceID() %>','<%=isNew?"":mode.getId() %>');"
					<%}%>
					>
						<input type="hidden" name="actID" value="<%=act.getId() %>"/>
						<input type="hidden" name="actRoleID" value="<%=act.getRoleID() %>"/>
						<input type="hidden" name="actUserID" value="<%=actUserIDs %>"/>
						<input type="text" <%if(editflag_responsor==FormViewItem.MANDATORY){ %>altStr="<bean:message key="WorkFlow"/> : <%=TypeUtils.xmlEncoderForIE(act.getDisplayName(lan)) %>-<bean:message key="responser"/>"<%}%> class="text" readonly="readonly" style="width: 90%;cursor: pointer;" name="operatorName" value="<%=actUserIDNames %>">
						<img src="<%=path %>/images/button/assign_resources.gif" />
					</div>
					<%if(editflag_responsor==FormViewItem.READ_ONLY){%>
					<%=actUserIDNames%>
					<%}%>
					<%}else{%>
					<%=actUserIDNames %>
					<%}%>
				<%}%>
			</td>
			<td>
			<%if(act.getId()!=1){%>
				<%if(isEdit){%>
				<div class="text-div" style="cursor: pointer;display:<%=editflag_plan_enddate==FormViewItem.READ_ONLY?"none":"block" %>;">
					<input type="text" class="text" <%if(editflag_plan_enddate==FormViewItem.MANDATORY){ %>altStr="<bean:message key="WorkFlow"/> : <%=TypeUtils.xmlEncoderForIE(act.getDisplayName(lan)) %>-<bean:message key="planHours"/>"<%}%> id="actPlanenddate_<%=act.getId() %>" name="actPlanenddate" style="width: 85%;" value="<%=TypeUtils.date2String(plan_end,1)%>" contenttype="D" readonly="readonly"/>
					<img src="<%=path %>/images/16x16/calendar.gif" id="actPlanenddate_img_<%=act.getId() %>">
					<script type="text/javascript">showCalendar("actPlanenddate_<%=act.getId() %>","actPlanenddate_img_<%=act.getId() %>");</script>
				</div>
				<%if(editflag_plan_enddate==FormViewItem.READ_ONLY){%>
				<%=TypeUtils.date2String(plan_end,1)%>
				<%}%>
				<%}else{%>
					<%=TypeUtils.date2String(plan_end,1)%>
				<%}%>
			<%}%>
			</td>
			<td>
			<%if(act.getId()!=1){%>
				<%if(isEdit){%>
				<div class="text-div" style="cursor: pointer;display:<%=editflag_actual_enddate==FormViewItem.READ_ONLY?"none":"block" %>;" >
					<input type="text" class="text" <%if(editflag_plan_enddate==FormViewItem.MANDATORY){ %>altStr="<bean:message key="WorkFlow"/> : <%=TypeUtils.xmlEncoderForIE(act.getDisplayName(lan)) %>-<bean:message key="actualHours"/>"<%}%> id="actActualenddate_<%=act.getId() %>" name="actActualenddate" style="width: 85%;" value="<%=TypeUtils.date2String(actual_end,1)%>" contenttype="D" readonly="readonly"/>
					<img src="<%=path %>/images/16x16/calendar.gif" id="actActualenddate_img_<%=act.getId() %>">
					<script type="text/javascript">showCalendar("actActualenddate_<%=act.getId() %>","actActualenddate_img_<%=act.getId() %>");</script>
				</div>
				<%if(editflag_actual_enddate==FormViewItem.READ_ONLY){%>
				<%=TypeUtils.date2String(actual_end,1)%>
				<%}%>
				<%}else{%>
					<%=TypeUtils.date2String(actual_end,1)%>
				<%}%>
			<%}%>
			</td> --%>
			<td><img src="/static/images/userSelect_check.png"></td>
			<td>1</td>
			<td>新建</td>
			<td>zhengqi2</td>
			<td></td>
			<td></td>
		</tr>
		<tr class="listTableTR">
			<td><img src="/static/images/bulletin_board_on.gif"></td>
			<td>2</td>
			<td>需求负责人审批</td>
			<td>zhengqi1</td>
			<td></td>
			<td></td>
		</tr>
	</tbody>
</table>
<%=UIUtils.togglePanelEnd(request)%>

<!-- 以上为表单 -->
</form>

