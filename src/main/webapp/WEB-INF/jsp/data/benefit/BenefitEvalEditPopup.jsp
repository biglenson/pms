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