<%@page import="org.apache.commons.io.filefilter.FalseFileFilter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import= "com.zq.commons.utils.UIUtils" %>
<%@ page import= "com.zq.vo.process.BenefitEvalVO" %>
<%
	String path = request.getContextPath();
	//获取基本信息
	BenefitEvalVO benefitEvalInfo = (BenefitEvalVO)request.getAttribute("benefitEvalInfo");
	String processID = (String)request.getAttribute("processID");
%>

<script type="text/javascript">
<%-- 选择附件窗体 --%>
function newAttachFun() {
	var arg = new Array();
	arg.src = "<%=path%>/datamap/openUploadWin?processID=<%=processID%>&_id=" + Math.random();
	arg.title = '新建附件';
	arg.width = 450;
	arg.height = 360;
	arg.theme = "search";
	ET.showModalWindow(arg, function (arry) { 
		
	});	
}

<%-- 打开附件 --%>
function openAttachFun(id) {
	var url = "<%=path%>/AttachAction.do?operation=open&documentID=" + id + "&_id=" + Math.random();
	url+="&objectID="+document.frm.objectID.value;
		url+="&objectType="+document.frm.objectType.value;
		url+="&objectSubType="+document.frm.objectSubType.value;
	var width = 840;
	var height = document.body.clientHeight;
	var left = (screen.width - width) /2;
	var top = (screen.height - height) /2;
	formWin = open(url,'formWin', 'width='+ width + ',height='+ height + ',left='+ left + ',top='+ top + ',status=0,resizable=yes,scrollbars=yes');
	formWin.focus();
}

<%-- 下载附件 --%>
function downloadAttachFun(documentID,attachmentID,attachmentType) {
	document.frm.documentID.value = documentID;
	document.frm.attachmentID.value = attachmentID;
	document.frm.attachmentType.value = attachmentType;
	document.frm.action="<%=path%>/AttachAction.do";
	document.frm.operation.value="download";
	etSubmit(document.frm);
	document.frm.action="<%=path%>/DemandAction.do";	
}
</script>

<form>
<!-- 附件 -->
<%=UIUtils.togglePanelStart("附件", true, request)%>
	<%=UIUtils.toolbarStart(request)%>
	<%=UIUtils.toolbarButton(true, "javascript:newAttachFun();", "添加附件", "doc_attachment.gif", false, false,request)%>
	<%=UIUtils.toolbarEnd(request)%>
	
	<table style="width:100%;border:0;cellpadding:0;cellspacing:0" class="listTable" id="attachTable">
		 <tbody>
			<%-- <%	
			for(Document document : attachList) {
				String disableItems = "";
				boolean canView=document.canConvertToPDF();
				if(!canView){
					disableItems+=",2";
				}
				if(!isEdit){
					disableItems+=",3";
				}
				boolean isAttach = (document.getAttachmentType() == Document.ATTACHMENT );
				String menuFun=isAttach ? "showAttachMenu" : "showLinkMenu";
				String img=isAttach?"attachment.png":"doclink.png";
			%> 	
			<tr class="listTableTR"  id="attachRow___<%=document.getId() %>" >
				<td align="left" >
					<input type="hidden" name="_documentID" value="<%=document.getId()%>">
					<input type="hidden" name="_attachmentID" value="<%=document.getAttachmentID()%>">
					<input type="hidden" name="_attachmentType" value="<%=document.getAttachmentType()%>">
					<input type="hidden" name="_disableItems" value="<%=disableItems%>">
					<span><img src="<%=path%>/images/attachment/<%=img %>"/></span>
					<a href="javascript:openAttachFun(<%=document.getId()%>);"><%=document.getName()%></a><span style="color: #949FA1;"><%="("+document.getKBSize()+")"%></span>&nbsp;&nbsp;
					<a href="javascript:downloadAttachFun(<%=document.getId()%>,<%=document.getAttachmentID()%>,<%=document.getAttachmentType()%>);"><span style="color: #35A0E5;"><bean:message key="download"/></span></a>&nbsp;&nbsp;
					<!--  <a href="javascript:viewOnLine(<%=document.getId()%>,<%=document.getAttachmentID()%>,<%=document.getAttachmentType()%>);"><span style="color:  #35A0E5;"><bean:message key="preview"/></span></a>&nbsp;&nbsp;-->
					<%if(isEdit && canDelete){ %>
						<span style="color:  #35A0E5;cursor: pointer;" onclick="deleteAttachFun(this,<%=document.getAttachmentID()%>);"><bean:message key="delete"/></span></a>
					<%} %>
				</td>
			</tr>
			<%}%>
			<%if(attachList.size() == 0){%>
			  <tr class="listTableTR" id="noAttachTR">
			    <td><bean:message key="NoRecord"/></td>
			  </tr>
			<%}%> 	 --%>	
			<tr class="listTableTR" id="attachRow___475018" >
				<td align="left">
					<!-- <input name="_documentID" value="475018" type="hidden">
					<input name="_attachmentID" value="2388" type="hidden">
					<input name="_attachmentType" value="0" type="hidden">
					<input name="_disableItems" value=",3" type="hidden"> -->
					<span><img src="/static/images/attachment.png"></span>
					<a href="javascript:openAttachFun(475018);">新建 Microsoft Word 文档.docx</a><span style="color: #949FA1;">(11 KB)</span>&nbsp;&nbsp;
					<a href="javascript:downloadAttachFun(475018,2388,0);"><span style="color: #35A0E5;">下载</span></a>&nbsp;&nbsp;
					<!--  <a href="javascript:viewOnLine(475018,2388,0);"><span style="color:  #35A0E5;">预览</span></a>&nbsp;&nbsp;-->
				</td>
			</tr>
		 </tbody>
	</table>
	
<%=UIUtils.togglePanelEnd(request)%>

<!-- 以上为表单 -->
</form>

<!----------------------------结束------------------------------>	
<!-----------------------------附件克隆表----------------------------->	
<%-- <table id="attachTable1" width="100%" border="0" cellpadding="0" cellspacing="0" style="display:none;">
	<tr class="listTableTR" >
		<td id="attachName" align="left">
			<input type="hidden" name="_documentID" value="">
			<input type="hidden" name="_attachmentID" value="">
			<input type="hidden" name="_attachmentType" value="">
			<input type="hidden" name="_disableItems" value="">
			<span><img src="<%=path%>/images/16x16/empty.png"/></span>
			<a href="#"></a><span style="color: #949FA1;"></span>&nbsp;&nbsp;
			<a href="#"><span style="color: #35A0E5;"><bean:message key="download"/></span></a>&nbsp;&nbsp;
			<a href="#"><span style="color:  #35A0E5;"><bean:message key="preview"/></span></a>&nbsp;&nbsp;
			<span style="color:  #35A0E5;cursor: pointer;"><bean:message key="delete"/></span></a>
		</td>
	</tr>
  	<tr class="listTableTR" id="noAttachTR">
		  <td><bean:message key="NoRecord"/></td>
	</tr>
</table> --%>
