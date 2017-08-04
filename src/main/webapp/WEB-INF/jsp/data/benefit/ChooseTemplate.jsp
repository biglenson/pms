<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import= "com.zq.commons.utils.UIUtils" %>
<%@ page import= "com.zq.commons.result.PageInfo" %>

<%
	String path = request.getContextPath();
%>

<!-- 内容主体 -->
<!DOCTYPE HTML>
<html>
<head>
<%-- 输出Head1模块 --%>
<jsp:include page="../../common/Head1.jsp" />
<script type="text/javascript" src="<%=path%>/js/firefox/DataTableAll.js"></script>
<script type="text/javascript" src="<%=path%>/js/firefox/contentDIV.js"></script>

<script type="text/javascript">
//确定
function OkFun(){
	var idArray=document.getElementsByName("templateID");
	for(var i=0;i<idArray.length;i++){
		if(idArray[i].checked){
			parent.ET.closeModalWindow(idArray[i].value);
			return;
		}
	}
}
function openTemplate(uid){
	
}

function showContent(obj){
	if(contentDIV!=null && contentDIV.floatDIV != null && contentDIV.floatDIV.sourceElement.style.display=='block'){
		contentDIV.hideDIV();
	}else{
		popupContent(obj,document.getElementById("contentDIV"),true,obj.clientWidth+2,true);
	}
}

function clickToken(obj){
	var id=obj.getAttribute("value");
	if(jQuery(obj).hasClass("autoCompleteTokenSelect")){
		jQuery(obj).removeClass('autoCompleteTokenSelect');
		labelMap[id]=false;
	}else{
		jQuery(obj).addClass('autoCompleteTokenSelect');
		labelMap[id]=true;
	}
}
function trackTaskStatusFun(){
	<%-- var checkArr=new Array();
	for(var key in labelMap){
		if(labelMap[key]==true){
			checkArr.push(key);
		}
	}
	document.frm.labels.value=checkArr.join(',');
	document.frm.action="<%=path%>/ScorecardAction.do";
	document.frm.operation.value="chooseScorecard";
	etSubmit(document.frm); --%>
}
function closeTrackDiv(){
	contentDIV.hideDIV();
}
var labelMap={};

</script>

<!-- 模版样式 -->
<style type="text/css">
#listMenuClassWrap {
	padding-bottom: 0px;
}
.autoCompleteValue{
}
.autoCompleteValueDIV .autoCompleteValue .autoCompleteToken{
	padding-right: 3px;
	
}
.autoCompleteValue .autoCompleteToken{
	padding-right: 3px;
	
}
.autoCompleteToken{
	padding:3px 8px 3px 8px;
	margin:3px 5px 3px 5px;
	border-radius:3px;
	background-color: #E0DFDF;
	cursor: pointer;
}
.autoCompleteToken:not([class~="autoCompleteTokenSelect"]):hover{
	background-color: yellow;
}
.autoCompleteTokenSelect{
	background-color: #85b2cb;
}
.listMenuClass .listMenuClassWrap{
	padding: 5px 1px 5px 1px;
}
</style>

</head>
<body class="popBody" onload="ET.Utils.onloadEvent();">
<div class="popBodyDIV">
<form name="frm" method="post" action="<%=path%>/benefitEvalEditPopup">
<input type="hidden" name="operation" value="selectResourceType">
<%-- <input type="hidden" name="scorecardType" value="<%=TypeUtils.nullToString(request.getParameter("scorecardType")) %>"> --%>
<div style="height: 260px;"> 
	<table style="border:0;cellpadding:0;cellspacing:0" class="listTable" id="fieldTable">
	<thead>
		<tr>
			<th ><div style='width:20px'>&nbsp;</div></th>
			<th width='100%'><div style='width:100px;margin:0 auto'>名称</div></th>					
			<th ><div style='width:100px'>创建人</div></th>
			<th ><div style='width:100px'>创建时间</div></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${benefitEvalTplList}" var="benefitEval">
			<tr class="listTableTR"> 
			    <td><input type="radio" id="templateID" name="templateID" value="${benefitEval.tplID}" /></td>
			    <td >${benefitEval.tplTitle}</td>
				<td >${benefitEval.creator}&nbsp;</td>
				<td >${benefitEval.createTime}&nbsp;</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
</div>
<%=UIUtils.spacerDIV("5",request)%>
<div class="OKButtonBottom">
	<div class="OKButtonDIV">
		<input class="kbutton OKButton" type="button" value='确定' onclick='OkFun();'>
		<input name="cancelBtn" class="kbutton" type="button" value='关闭' onclick="parent.ET.closeModalWindow()">
	</div>
</div>
</form>
</div>
<script type="text/javascript">
$(function () {
	//模版默认选中第一个
	$(':radio').eq(0).attr('checked', true);
});
window.fixedTable=new EasyTrack.DataTable('fieldTable',{
	autoHeight:false
});	
</script>
</body>
</html>
<%-- 输出公共BodyEnd模块 --%>
<jsp:include page="../../common/BodyEnd.jsp" />
