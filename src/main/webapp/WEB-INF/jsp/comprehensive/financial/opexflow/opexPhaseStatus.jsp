<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = request.getContextPath();
/* Role department=(Role)request.getAttribute("department"); */
%>
<script type="text/javascript">
	function openOpexProjectList(index){
		var arg = new Array();
		arg.src = "<%=path%>/CMCCReportServer?reportlet=财务报表/OPEX多项目列表.cpt&_id="+Math.random();
		if(index!=-1){
			arg.src += "&opexStatus="+index;
		}
		arg.title = "OPEX多项目列表";
		arg.containerClass="fineReport";
		top.ET.showNewWindow(arg, function (ret) { 
		})
	}
</script>
<div class="chartContainerDIV" style="margin: 26px auto;">
	<div style="text-align: right">
		<div class="showHelpe" onclick="showTips(this,'opexPhaseTipNameDIV')"></div>
	</div>
	<div class="helpFloatDIV" id="opexPhaseTipNameDIV"
		style="line-height: 22px;">
		<div class="showHelpeContent" style="line-height: 23px;">
			<div>预算项目数量：年度立项制OPEX项目总数量</div>
			<div>各阶段项目数量：项目阶段为当前环节的项目数量</div>
			<div>需求阶段：需求提交-需求确认</div>
			<div>项目决策阶段：需求确认-项目决策</div>
			<div>采购阶段：项目决策-采购完成</div>
			<div>执行阶段：采购完成-报账开始</div>
			<div>报账阶段：报账开始-入账开始</div>
			<div>入账阶段：入账开始后</div>
		</div>
	</div>
	<div id="opexProjectStatusDIV">
		<div style="height: 220px;" class="loaddingClass"></div>
	</div>
</div>
<div id="opexProjectStatusDIVTime" class="viewChangeTime marginTopTime"></div>
<script type="text/javascript">
$(document).ready(function(){
	$.ajax({
		url:"<%=path%>/ZongheAction.do?operation=opexProjectStatus",
		method:"POST",
		data:{
			year:document.frm.year.value
			<%-- ,departmentID:<%=Role.ROOT_DEPARTMENT_ID%> --%>
			,showOpexView:false
		},
		success:function(html){
			var div=$("#opexProjectStatusDIV");
			div.html(html);
		}
	});
	
})
</script>