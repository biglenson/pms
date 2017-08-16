<%@page import="org.apache.commons.io.filefilter.FalseFileFilter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import= "com.zq.commons.utils.UIUtils" %>
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

//编辑
function edit() {	
	/* SimpleFormAction.checkModified(document.frm.schemaID.value, document.frm.formID.value, document.frm.updateTime.value, function(data) {
		var errNo = data.substring(0,1);
		if(errNo == "0"){
			alert(data.substring(1));
			parent.ET.closeModalWindow("1");
		} else if(errNo == "1"){
			alert(data.substring(1));		
			document.frm.operation.value="open";
			etSubmit(document.frm);
		}else if(errNo == "2"){
			alert(data.substring(1));		
		} else {
			document.frm.operation.value="edit";
			etSubmit(document.frm);
		}
	}); */
	document.frm.operation.value="edit";
	etSubmit(document.frm);
}
//解锁
function unlock() {
	console.log('点击了...');
	/* treeSelectUtils.showUserSelect(this.children[2],this.children[3],role,role_id,true); */
	var arg = new Array();
	if(isMulti){
		arg.width = 630;
		arg.height =430;
	}else{
		arg.width = 630;
		arg.height = 430;
	}
	parent.ET.showModalWindow(arg, function (oRet){
		/* if (oRet!=null) {
			if(typeof idField!='undefined' && idField!=null){
				idField.value=oRet.userIds;
			}
			if(typeof nameField!='undefined' && nameField!=null){
				nameField.value=oRet.userNames;
			}
		}
		if(typeof(parent.onSelectUserOKFun)!='undefined'&&typeof(funtion)=='undefined'){
			parent.onSelectUserOKFun(idField);
		}else if(typeof(funtion)!='undefined'){
			funtion(idField);
		} */
	});
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
<form name="frm" action="<%=path%>/datamap/benefitEvalPopup" method="post">
<input type="hidden" name="operation" value="edit">
<input type="hidden" name="tplID" value="<%=tplID%>">

<%=UIUtils.toolbarStart(request)%>
<%=UIUtils.toolbarButton(true, "javascript:edit(\"1\")", "编辑", "save.gif", false, false, request)%>
<%=UIUtils.toolbarButton(true, "javascript:unlock();", "解锁", "back.gif", false, false, request)%>

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
				<td class="seperator"></td>
				<td class="label white_background-color"></td>
				<td class="content white_background-color"></td>
			</tr>
			<tr>
				<td class="label">代码</td>
				<td class="content" id="evalCode"> 
					<div class="content-line" id="div-evalCode"><%=benefitEvalInfo.getEvalCode()%></div>
					<input name="evalCode" value="<%=benefitEvalInfo.getEvalCode()%>" type="hidden">
				</td>
			</tr>
			<tr>
				<td colspan="5" height="5"></td>
			</tr>
			<tr>
				<td class="label"><%=benefitEvalInfo.getEvalTitle()%><font class="red">*</font></td>
				<td colspan="4" class="content" id="evalTitle">
					<input class="text" name="evalTitle" value="<%=benefitEvalInfo.getEvalTitle()%>" maxlength="250" altstr="<%=benefitEvalInfo.getEvalTitle()%>" type="text">
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
					<div class="content-line" id="div-statusName">待需求负责人审批</div>
				</td>
			</tr>
			<tr>
				<td colspan="5" height="5"></td>
			</tr>
			<tr>
				<td class="label">创建人</td>
				<td class="content  " id="creator">
					<div class="content-div" id="content-div-res01" style="cursor: pointer;">
						<input name="creator" value="" type="hidden">
						<input class="text" name="creator" value="<%=benefitEvalInfo.getCreator()%>" readonly="" style="cursor: pointer;" type="text">
						<img src="<%=path%>/static/images/benefit/assign_resources.gif" id="div-img-res01" align="absmiddle">
					</div> 
					<script type="text/javascript">
						ET.Utils.addEvent(document.getElementById('content-div-res01'),'click',function(){ 
							var img=document.getElementById('div-img-res01');
							treeSelectUtils.showUserSelect(img.parentElement.children[0],img.parentElement.children[1], 7,69,true); 
						}) 
					</script>
				</td>
				<td class="seperator"></td>
				<td class="label">创建时间</td>
				<td class="content  " id="createDatetd">
					<div class="content-div" id="content-div-createDate"> 
						<input class="text" name="createDate" id="createDate" value="<%=benefitEvalInfo.getCreateDate()%>" contenttype="D2" style="cursor: pointer;" autocomplete="off" type="text">
						<!-- <img src="/pm/images/16x16/calendar.gif" name="imagdate01" id="imagdate01" style="cursor:pointer"> -->
					</div>  
					<script type="text/javascript"> 
						showCalendar("date01","imagdate01");
					</script>
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
					<select name="hasDept">
					  <option value="0">是</option>
					  <option value="1">否</option>
					</select>
				</td>
			</tr>
		</tbody>
	</table>
	<!-- 效益评估 -->
	<jsp:include page="./BenefitInclude.jsp"/>
	<!--附件 -->
	<jsp:include page="./AttachInclude.jsp"/>
	<!--工作流 -->
	<jsp:include page="./WorkFlowInclude.jsp"/>
	<%=UIUtils.formBodyEnd(request) %> 
</div>

<!-- 以上为表单 -->
</form>

<%-- 输出公共BodyEnd模块 --%>
<jsp:include page="../../common/BodyEnd.jsp" />