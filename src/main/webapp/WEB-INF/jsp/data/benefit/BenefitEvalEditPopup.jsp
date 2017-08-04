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

<style>
/* 层叠其他样式的覆盖 */
td,div {
	font-size: 12px;
}
</style>

<script type="text/javascript">
//保存
function save() {	
	<%-- try{
		fillEditorContent(); //如果定义了富文本，需要将富文本的内容输入到name属性为richText01等隐藏input中才能保存,该方法在RichTextScript.jsp中定义
	}catch(e){
	}
	
	if(!checkAllNecessaryFormInputs(document.frm, "<%=session.getAttribute("CurrentLanguage")%>")) {
		return false;
	}	
	
	var code=document.frm.code;
	if(code!=null){
		CMCCAction.checkCodeUnique({
			'code':code.value
			,schemaID:'<%=schema.getId()%>'
		},function(ret){
			if(ret==null){
				parent.ET.setModalWindowReturnValue("1");
				ET.disableAllButton();	
				document.frm.backType.value=backType;
				document.frm.operation.value="newSimpleForm";
				etSubmit(document.frm);
			}else{
				alert(ret);
				document.frm.code.select();
			}
		})
	}else{
		parent.ET.setModalWindowReturnValue("1");
		ET.disableAllButton();	
		document.frm.backType.value=backType;
		document.frm.operation.value="newSimpleForm";
		etSubmit(document.frm);
	} --%>
}

//取消
function cancel() {
	if(!isLeave()) return;   
	parent.ET.closeModalWindow();
}

//自动填充窗体标题栏
function autoContentHeight(){
	ET.MainScroll("contentDIV");
	parent.ET.setModalWindowTitle('项目后评估');
}
ET.Utils.addOnloadEvent(autoContentHeight);
</script>

<%-- 输出Head1模块 --%>
<jsp:include page="../../common/Head1.jsp" />

<!-- 内容主体 -->
<form name="frm" action="<%=path%>/datamap/benefitEvalPopup" method="post">
<input type="hidden" name="pageTitle" value="<%= pageTitle %>">
<input type="hidden" name="url" value="<%= url %>">
<input type="hidden" name="operation" value="edit">

<%=UIUtils.toolbarStart(request)%>
	<%=UIUtils.toolbarButton(true, "javascript:save(\"0\");", "保存", "save.gif", false, false, request)%>
	<%=UIUtils.toolbarButton(true, "javascript:cancel();", "取消", "back.gif", false, false, request)%>
<%=UIUtils.toolbarEnd(request)%>

<div style="overflow: auto;" class='relativeDIV' id="contentDIV">
	<%=UIUtils.formBodyStart(request) %>
		<!-- 基本信息 -->
		<table  style="border:0;align:center;cellpadding:0;cellspacing:0" id="fieldTable" class='formTable'>						
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
					<td class="content" id="codetd"> 
						<div class="content-line" id="div-codeName"></div>
					</td>
				</tr>
				<tr>
					<td colspan="5" height="5"></td>
				</tr>
				<tr>
					<td class="label">标题<font class="red">*</font></td>
					<td colspan="4" class="content" id="titletd">
						<input class="text" name="title" value="" maxlength="250" altstr="标题" type="text">
					</td>
				</tr>
				<tr>
					<td colspan="5" height="5"></td>
				</tr>
				<tr>
					<td class="label">评估类型</td>
					<td class="content  " id="categorytd"> 
						<div class="content-line" id="div-categoryName">项目前评估</div>
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
					<td class="label">评估人</td>
					<td class="content  " id="res01td">
						<div class="content-div" id="content-div-res01" style="cursor: pointer;">
							<input name="res01" value="" type="hidden">
							<input class="text" name="res01Name" value="" readonly="" style="cursor: pointer;" type="text">
							<img src="/pm/images/button/assign_resources.gif" id="div-img-res01" align="absmiddle">
						</div> 
						<script type="text/javascript">
							ET.Utils.addEvent(document.getElementById('content-div-res01'),'click',function(){ 
								var img=document.getElementById('div-img-res01');
								treeSelectUtils.showUserSelect(img.parentElement.children[0],img.parentElement.children[1], 7,69,true); 
							}) 
						</script>
					</td>
					<td class="seperator"></td>
					<td class="label">评估时间</td>
					<td class="content  " id="date01td">
						<div class="content-div" id="content-div-date01"> 
							<input class="text" name="date01" id="date01" value="" contenttype="D2" style="cursor: pointer;" autocomplete="off" type="text">
							<img src="/pm/images/16x16/calendar.gif" name="imagdate01" id="imagdate01" style="cursor:pointer">
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
					<td class="content" id="str01td">
						<div class="content-line" id="div-str01Name">2.1项目评估模型-平台项目-增收型新建项目</div>
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