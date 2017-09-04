<%@page import="org.apache.commons.io.filefilter.FalseFileFilter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import= "com.zq.commons.utils.UIUtils" %>
<%@ page import= "com.zq.vo.process.TaskHisItemVO" %>
<%@ page import="com.zq.commons.utils.TypeUtils" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
%>

<script type="text/javascript">

</script>

<form>
<!-- 工作流 -->
<%=UIUtils.togglePanelStart("工作流", true, request)%>
<table style="width:100%;border:0;cellpadding:0;cellspacing:0" class="listTable" id="attachTable">
	<thead>
	    <tr>
	    	<th ><div style="width:20px">&nbsp;</div></th>
	        <th ><div style="width:30px">序号</div></th>
			<th width="100%"><div style="width:150px;margin: 0px auto;">活动名称</div></th>
			<th ><div style="width:120px">责任人</div></th>
			<th ><div style="width:200px">处理时间</div></th>
			<th ><div style="width:120px">处理结果</div></th>
			<th ><div style="width:120px">处理意见</div></th>
			</tr> 
	</thead>
	<tbody>
		<% 
		//获取工作流信息
		List<TaskHisItemVO> taskHisList = (List)request.getAttribute("taskHis");
		if(taskHisList != null && taskHisList.size() > 0){
			int index = taskHisList.size(); //自定义索引
			for(TaskHisItemVO item : taskHisList){
		%>
		<tr class="listTableTR" >
			<td>
				<%if(index != taskHisList.size()){%>
					<img src="<%=path%>/static/images/userSelect_check.png">
				<%}else {%>
					<img src="<%=path%>/static/images/bulletin_board_on.gif">
				<%}%>
			</td>
			<td>
				<%=index%>
			</td>
			<td title="<%=TypeUtils.nullToString(item.getTaskName())%>">
				<%=TypeUtils.nullToString(item.getTaskName())%>
			</td>
			<td>
				<%=TypeUtils.nullToString(item.getAssignee())%>
			</td>
			<td>
				<fmt:formatDate value="<%=item.getDealTime()%>" pattern="yyyy-MM-dd HH:mm:ss"/>
			</td>
			<td title="<%=TypeUtils.nullToString(item.getDealResult())%>">
				<%=TypeUtils.nullToString(item.getDealResult())%>
			</td>
			<td title="<%=TypeUtils.nullToString(item.getDealOpinion())%>">
				<%=TypeUtils.nullToString(item.getDealOpinion())%>
			</td>
		</tr>
		<%index--;}}else{%>
		<tr class="listTableTR" >
			<td colspan="9">没有记录</td>
		</tr>
		<%}%>
	</tbody>
</table>
<%=UIUtils.togglePanelEnd(request)%>

<!-- 以上为表单 -->
</form>