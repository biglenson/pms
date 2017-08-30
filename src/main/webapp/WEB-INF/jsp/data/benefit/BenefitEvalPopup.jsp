<%@page import="com.alibaba.druid.sql.ast.statement.SQLIfStatement.Else"%>
<%@page import="org.apache.commons.io.filefilter.FalseFileFilter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import= "com.zq.commons.utils.UIUtils" %>
<%@ page import="com.zq.commons.utils.TypeUtils" %>
<%@ page import= "com.zq.vo.process.BenefitEvalItemVO" %>
<%@ page import= "com.zq.vo.process.TaskHisItemVO" %>
<%@ page import= "com.zq.vo.process.BenefitEvalVO" %>
<%
	String path = request.getContextPath();
	//获取效益评估Form表单信息
	List<BenefitEvalItemVO> benefitEvalFormList = (List)request.getAttribute("benefitEvalForm");
	//获取工作流信息
	List<TaskHisItemVO> taskHisList = (List)request.getAttribute("taskHis");
	//获取基本信息
	BenefitEvalVO benefitEvalInfo = (BenefitEvalVO)request.getAttribute("benefitEvalInfo");
	//判断前后评估,1是后评估,0是前评估
	String evalPhase = String.valueOf(benefitEvalInfo.getEvalPhase());
	int tplID = benefitEvalInfo.getTplID();
	boolean isAfterEval;
	if ("1".equals(evalPhase)){
		isAfterEval = true;
	}else {
		isAfterEval = false;
	}
	int nameWidth = (760-30-180-80-50-100-(isAfterEval?160:0)-10);
	//获取效益评估Form表单信息
	List<BenefitEvalItemVO> formInfos = (List)request.getAttribute("benefitEvalForm");
	//获取唯一任务单ID号
	String taskID = (String)request.getAttribute("taskID");
	//获取是否可编辑信息(即区分评估发起人或者飞发起人,0是非发起者,1是发起者)
	String isEditable =  String.valueOf(request.getAttribute("isEditable"));
	//获取任务单来源,todo为待办,done为已办
	String submitFrom = (String)request.getAttribute("submitFrom");
%>

<style>
/* 层叠其他样式的覆盖 */
td,div {
	font-size: 12px;
}
</style>

<%-- 输出Head1模块 --%>
<jsp:include page="../../common/Head1.jsp" />

<script type="text/javascript">
//效益评估
function openFormScorecard() {
	document.frm.action = "<%=path%>/datamap/simpleFromBenefit";
	etSubmit(document.frm);
};

//更多
function showMoreButton (obj){
	var listMenu = new Array();
	listMenu.items = new Array();
	var i=0;
	listMenu.items[i] = new Array();
	listMenu.items[i]["type"] 		= 'item';
	listMenu.items[i]["function"]	= 'logFun()';
	listMenu.items[i]["label"]		= '日志';
	i++;
	listMenu.items[i] = new Array();
	listMenu.items[i]["type"] 		= 'item';
	listMenu.items[i]["function"]	= 'exportExcel()';
	listMenu.items[i]["label"]		= '导出到 MS Excel';
	popupMenu(obj, listMenu, "");
}

//日志
function logFun(){
	var src= "<%=path%>/datamap/logPopup?pageTitle=产品&url=/datamap/basproduct"+"&_id="+Math.random();
	var arg = {};
	arg.src=src;
	arg.title='日志';
	arg.width = 840;
	arg.height = top.document.body.clientHeight - 160;
	top.ET.showModalWindow(arg)
}

//提交
function submit() {
	console.log('===========测试中！======================>提交----');
	$(function () {
		var evalTitle = $('input[dbField=evalTitle]').val();
		var evalTitle2 = $('div[dbField=evalTitle]').text();
		var assignee = $('input[dbField=assignee]').val();
		var dealRslt = $('select[dbField=dealRslt]').val();
		var dealRslt2 = $('input[dbField=dealRslt]').val();
		console.log('执行了-==========================');
		if (!evalTitle && !evalTitle2) {
			alert('标题不能为空！');
		}else if (!assignee) {
			alert('处理人不能为空！');
		}else if (!dealRslt) {
			if (!dealRslt2) {
				alert('处理结果不能为空！');
			}else {
				console.log('处理校验通过==========处理结果通过校验===========');
				if (window.confirm("确定提交该任务单?")) {
					confirmSubmit();
				}
			}
		}else {
			console.log('处理校验通过==========全部通过校验===========');
			if (window.confirm("确定提交该任务单?")) {
				confirmSubmit();
			}
		}
	});
}

<%-- 确认提交 --%>
function confirmSubmit() {
	var obj = {};
	$('.formTable').find('[dbField]').each(function(index, elem) {
		var dbField = $(elem).attr("dbField");
		var vtype = $(elem).attr("vtype");
		obj[dbField] = getVtypeVal(vtype, elem);
	});
	var selectValue = $("#next-step-select").find("option:selected").text();
	obj.rsltDesc = selectValue;
	console.log('提交的下拉框选中词语:  '+selectValue);
	var arr = new Array();
	for (var i = 1; i <= <%=formInfos.size()%>; i++) {
		var obj2 = {};
		$('.listTable').find('[dbField'+i+']').each(function(index, elem) {
			var dbField = $(elem).attr("dbField"+i);
			var vtype = $(elem).attr("vtype");
			obj2[dbField] = getVtypeVal(vtype, elem);
			arr[i-1] = obj2;
		});
	}
	
	console.log(obj);
	console.log(arr);
	
	document.frm.operation.value="submit";
	document.frm.evalInfo.value=JSON.stringify(obj);
	document.frm.evalForm.value=JSON.stringify(arr);
	document.frm.action="<%=path%>/datamap/submitBenefitEval";
	etSubmit(document.frm);
	parent.ET.setModalWindowTheme("feedback");
	parent.ET.setModalWindowSize(220, 140);
	parent.ET.setModalWindowReturnValue("1");
	
	<%-- $.ajax({
		type: "POST",
		url: "<%=path%>/datamap/submitBenefitEval",
		data: {
			evalInfo: JSON.stringify(obj),
			evalForm: JSON.stringify(arr)
		},
		/* datatype: "html", */
		//在请求之前调用的函数
		beforeSend: function(){
			
		},
		//成功返回之后调用的函数             
		success: function(data){
			console.log(decodeURI(data));     
			alert('<%=request.getAttribute("feedback")%>');
		},
		//调用执行后调用的函数
		complete: function(XMLHttpRequest, textStatus){
		   /* alert(XMLHttpRequest.responseText);
		   alert(textStatus); */
		},
		//调用出错执行的函数
		error: function(){
			//请求出错处理
		}         
		});
		parent.ET.setModalWindowReturnValue("1"); --%>
}

//保存
function save() {	
	console.log('===========测试中！======================>修改再保存----');
	var obj = {};
	$('.formTable').find('[dbField]').each(function(index, elem) {
		var dbField = $(elem).attr("dbField");
		var vtype = $(elem).attr("vtype");
		obj[dbField] = getVtypeVal(vtype, elem);
	});
	var selectValue = $("#next-step-select").find("option:selected").text();
	obj.rsltDesc = selectValue;
	console.log('提交的下拉框选中词语:  '+selectValue);
	var arr = new Array();
	for (var i = 1; i <= <%=formInfos.size()%>; i++) {
		var obj2 = {};
		$('.listTable').find('[dbField'+i+']').each(function(index, elem) {
			var dbField = $(elem).attr("dbField"+i);
			var vtype = $(elem).attr("vtype");
			obj2[dbField] = getVtypeVal(vtype, elem);
			arr[i-1] = obj2;
		});
	}
	
	console.log(obj);
	console.log(arr);
	
	document.frm.operation.value="save";
	document.frm.submitFrom.value="todo";
	document.frm.evalInfo.value=JSON.stringify(obj);
	document.frm.evalForm.value=JSON.stringify(arr);
	document.frm.action="<%=path%>/datamap/saveBenefitEval";
	etSubmit(document.frm);
	parent.ET.setModalWindowReturnValue("1");
}

//删除
function del() {
	console.log('===========测试中！======================>删除----');
	
	if (window.confirm("确定删除该任务单?")) {
		var arg = new Array();
		arg.src="<%=path%>/datamap/delBenefitEval?taskID=<%=taskID%>";
		arg.width = 220;
		arg.height = 120;
		arg.theme="feedback";
		top.ET.showModalWindow(arg, function (ret) { 
			parent.ET.setModalWindowReturnValue (1);
			parent.ET.closeModalWindow(
					function cc() {
						//刷新待办任务
						document.frm.action = "<%=path%>/datamap/getTaskTodo";
						etSubmit(document.frm);
						console.log('===========测试中！======================>刷新了待办任务----');
						
					}
			);
		});
	}
}

//取消
function cancel() {
	console.log('===========测试中！======================>取消----');
	parent.ET.closeModalWindow();
}

//关闭 
function closeBtn() {
	console.log('===========测试中！======================>关闭----');
	parent.ET.closeModalWindow("1");
}

<%-- function showMoreButton (obj){
	var listMenu = new Array();
	listMenu.items = new Array();
	var i=0;
	<%if (!isEdit) {%>
		<%if(isVersionSupport){%>
			<%if(lineList.size()>0){ %>
				listMenu.items[i] = new Array();
				listMenu.items[i]["type"] 		= 'item';
				listMenu.items[i]["function"]	= 'compareVersionFun()';
				listMenu.items[i]["label"]		= '版本比较';
				i++;
			<%} %>
		<%}else if(schema.getId()==CMCCConstant.FEE_DETAIL||schema.getId()==CMCCConstant.ZICHAN_DETAIL){%>
			listMenu.items[i] = new Array();
			listMenu.items[i]["type"] 		= 'item';
			listMenu.items[i]["function"]	= 'compareFeedVersionFun()';
			listMenu.items[i]["label"]		= '跟原始版本比较';
			i++;
		<%}%>
		
		<%if(isLixiang&&wfSchema!=null){%>
			
			listMenu.items[i] = new Array();
			listMenu.items[i]["type"] 		= 'item';
			listMenu.items[i]["function"]	= 'logFun()';
			listMenu.items[i]["label"]		= '日志';
			i++;
		<%}%>
		listMenu.items[i] = new Array();
		listMenu.items[i]["type"] 		= 'item';
		listMenu.items[i]["function"]	= 'exportExcel()';
		listMenu.items[i]["label"]		= '<bean:message key="outAsExcelFun"/>';
	<%} %>
	popupMenu(obj, listMenu, "");
} --%>

//自动适配当前窗体高度
function autoContentHeight(){
	ET.MainScroll("contentDIV");
}
ET.Utils.addOnloadEvent(autoContentHeight);
</script>

<!-- 内容主体 -->
<form name="frm" action="" method="POST">
<input type="hidden" name="operation" value="">
<input type="hidden" name="evalInfo" value="">
<input type="hidden" name="evalForm" value="">
<input type="hidden" name="taskID" value="${taskID}">
<input type="hidden" name="submitFrom" value="">

<%=UIUtils.toolbarStart(request)%>
<%if("todo".equals(submitFrom)){ %>
<%=UIUtils.toolbarButton(true, "javascript:submit();", "提交", "save.gif", false, false, request)%>
<%=UIUtils.toolbarButton(true, "javascript:save();", "保存", "save.gif", false, false, request)%>
<%if("1".equals(isEditable)) { %>
	<%=UIUtils.toolbarButton(true, "javascript:del();", "删除", "save.gif", false, false, request)%>
<%}%>
<%=UIUtils.toolbarButton(true, "javascript:cancel();", "取消", "back.gif", false, false, request)%>
<%} %>
<%if("done".equals(submitFrom)){ %>
<%=UIUtils.toolbarButton(true, "javascript:closeBtn();", "关闭", "back.gif", false, false, request)%>
<%} %>


<%=UIUtils.toolbarFloatRight(request)%>
	<%=UIUtils.toolbarButton(true, "javascript:showMoreButton(this);","更多", null, false, false, request)%>
<%=UIUtils.toolbarEnd(request)%>

<div style="overflow: auto;" class='relativeDIV' id="contentDIV">
	<%=UIUtils.formBodyStart(request) %>
	<!-- 基本信息 -->
	<table style="border:0;align:center;cellpadding:0;cellspacing:0" class='formTable' id="fieldTable">
		<tbody>
			<tr>
				<td class="label white_background-color"></td>
				<td class="content white_background-color"></td>
				<td class="seperator">
					<input vtype="input" dbField="evalID" type="hidden" value="<%=benefitEvalInfo.getEvalID()%>"/>
					<input vtype="input" dbField="tplID" type="hidden" value="<%=benefitEvalInfo.getTplID()%>"/>
				</td>
				<td class="label white_background-color"></td>
				<td class="content white_background-color"></td>
			</tr>
			<tr>
				<td class="label">代码</td>
				<td class="content" id="evalCode"> 
					<div class="content-line" id="div-evalCode"><%=benefitEvalInfo.getEvalCode()%></div>
					<input vtype="input" dbField="evalCode" type="hidden" value="<%=benefitEvalInfo.getEvalCode()%>"/>
				</td>
			</tr>
			<tr>
				<td colspan="5" height="5"></td>
			</tr>
			<tr>
				<td class="label">标题<font class="red">*</font></td>
				<td colspan="4" class="content" id="evalTitle">
					<%if("done".equals(submitFrom)) { %>
						<div vtype="div" dbField="evalTitle" class="content-line" id="div-evalTitle"><%=benefitEvalInfo.getEvalTitle()%></div>
					<%}else if("1".equals(isEditable)){ %>
						<input vtype="input" dbField="evalTitle" class="text" value="<%=benefitEvalInfo.getEvalTitle()%>" maxlength="250" altstr="<%=benefitEvalInfo.getEvalTitle()%>" type="text">
					<%}else { %>
						<div vtype="div" dbField="evalTitle" class="content-line" id="div-titleName"><%=benefitEvalInfo.getEvalTitle()%></div>
					<% }%>
				</td>
			</tr>
			<tr>
				<td colspan="5" height="5"></td>
			</tr>
			<tr>
				<td class="label">评估类型</td>
				<td class="content  " id="categorytd"> 
					<div class="content-line" id="div-categoryName"><%=benefitEvalInfo.getEvalFor()==0?"项目":"产品"%><%=isAfterEval==false?"前":"后"%>评估</div>
				</td>
				<td class="seperator"></td>
				<td class="label">状态</td>
				<td class="content  " id="statustd"> 
					<div class="content-line" id="div-statusName"><%=TypeUtils.nullToString(benefitEvalInfo.getTaskName())%></div>
				</td>
			</tr>
			<tr>
				<td colspan="5" height="5"></td>
			</tr>
			<tr>
				<td class="label">创建人</td>
				<td class="content  " id="creator">
					<div vtype="div" dbField="creator" class="content-line" style="cursor: pointer;"><%=benefitEvalInfo.getCreator()%></div> 
				</td>
				<td class="seperator"></td>
				<td class="label">创建时间</td>
				<td class="content  " id="createDatetd">
					<div class="content-line" id="content-div-createDate">
						<%if(benefitEvalInfo.getCreateDate() == null) { %>
							系统自动创建
						<%}else { %>
							<fmt:formatDate value="<%=benefitEvalInfo.getCreateDate()%>" pattern="yyyy-MM-dd HH:mm:ss"/>
						<% } %>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="5" height="5"></td>
			</tr>
			<tr>
				<td class="label">评估模板</td>
				<td class="content" id="tplTitle">
					<div class="content-line" id="div-tplTitle"><%=benefitEvalInfo.getTplTitle() %></div>
				</td>
				<td class="seperator"></td>
				<td class="label">是否有归口部门</td>
				<td class="content  " id="statustd"> 
					<%if(benefitEvalInfo.getHasDept() == 1) { 
						if("done".equals(submitFrom)) {
					%>
							<div class="content-line">是</div>
							<input type="hidden" vtype="input" dbField="hasDept" value="1"/>
						<%} else if("1".equals(isEditable)) {%>
							<select vtype="select" dbField="hasDept" id="selector_status">
							  <option value="1" selected="selected">是</option>
							  <option value="0">否</option>
							</select>
						<%} else { %>
							<div class="content-line">是</div>
							<input type="hidden" vtype="input" dbField="hasDept" value="1"/>
						<%} %>
					<%}else if(benefitEvalInfo.getHasDept() == 0) {
						if("done".equals(submitFrom)) {
					%>
							<div class="content-line">否</div>
							<input type="hidden" vtype="input" dbField="hasDept" value="0"/>
						<%} else if("1".equals(isEditable)) {%>
							<select vtype="select" dbField="hasDept" id="selector_status">
							  <option value="1">是</option>
							  <option value="0" selected="selected">否</option>
							</select>
						<%} else { %>
							<div class="content-line">否</div>
							<input type="hidden" vtype="input" dbField="hasDept" value="0"/>
						<%} %>
					<%}%>
				</td>
			</tr>
		</tbody>
	</table>
	<%-- 效益评估 --%>
	<jsp:include page="./BenefitInclude.jsp"/>
	<%-- 附件 --%>
	<jsp:include page="./AttachInclude.jsp"/>
	<%-- 下一步 --%>
	<%if("todo".equals(submitFrom)) {%>
	<jsp:include page="./NextStepInclude.jsp"/>
	<%}%>
	<%-- 工作流 --%>
	<jsp:include page="./WorkFlowInclude.jsp"/>
	<%=UIUtils.formBodyEnd(request) %> 
</div>

<!-- 以上为表单 -->
</form>

<%-- 输出公共BodyEnd模块 --%>
<jsp:include page="../../common/BodyEnd.jsp" />

<script type="text/javascript">
<%-- 判断各表单项类型获取对应的值 --%>
function getVtypeVal(vtype, elem) {
	var val = "";
	if (vtype == "input") { // 输入框
		val = $.trim($(elem).val());
	} else if (vtype == "select") { // 下拉框
		val = $(elem).val();
	} else if (vtype == "radios") { // 单选
		val = $(elem).attr("val");
	} else if (vtype == "date") {	// 时间
		val = $(elem).val();
	} else if (vtype == "textarea") {	// 文本域
		val = $(elem).val();
	} else if (vtype == "div") { // div
		val = $(elem).text();
	}
	if (!val) {
		val = "";
	}
	return val;
}
</script>