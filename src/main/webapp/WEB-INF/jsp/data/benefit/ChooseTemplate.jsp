<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import= "com.zq.commons.utils.UIUtils" %>
<%@ page import= "com.zq.commons.result.PageInfo" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
%>

<%-- 输出Head1模块 --%>
<jsp:include page="../../common/Head1.jsp" />
<script type="text/javascript" src="/static/js/firefox/DataTableAll.js"></script>
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
</script>

<%-- 内容主体 --%>
<body class="popBody" onload="ET.Utils.onloadEvent();">
<div class="popBodyDIV">
<form name="frm" method="post" action="<%=path%>/benefitEvalEditPopup">
<input type="hidden" name="operation" value="selectResourceType">
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
				<td><fmt:formatDate value="${benefitEval.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>&nbsp;</td>
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
	<%-- 模版默认选中第一个 --%>
	$(':radio').eq(0).attr('checked', true);
});
<%-- 窗体高度自适应 --%>
window.fixedTable=new EasyTrack.DataTable('fieldTable',{
	autoHeight:false
});	
</script>
</body>

<%-- 输出公共BodyEnd模块 --%>
<jsp:include page="../../common/BodyEnd.jsp" />
