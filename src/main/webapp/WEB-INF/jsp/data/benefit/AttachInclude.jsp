<%@ page import="org.apache.commons.io.filefilter.FalseFileFilter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import= "com.zq.commons.utils.UIUtils" %>
<%@ page import= "com.zq.vo.process.BenefitEvalVO" %>
<%@ page import= "com.zq.vo.process.AttachmentVO" %>
<%
	String path = request.getContextPath();
	//获取基本信息
	BenefitEvalVO benefitEvalInfo = (BenefitEvalVO)request.getAttribute("benefitEvalInfo");
	//获取附件信息集合
	List<AttachmentVO> attachmentList = benefitEvalInfo.getAttachments();
	//获取是否可编辑信息(即区分评估发起人或者飞发起人,0是非发起者,1是发起者)
	String isEditable =  String.valueOf(request.getAttribute("isEditable"));
%>

<script type="text/javascript">
<%-- 选择附件窗体 --%>
function newAttachFun() {
	var arg = new Array();
	arg.src = "<%=path%>/datamap/openUploadWin?processID=<%=benefitEvalInfo.getProcessID()%>&_id=" + Math.random();
	arg.title = '新建附件';
	arg.width = 450;
	arg.height = 360;
	arg.theme = "search";
	ET.showModalWindow(arg, function (arry) { 
		
	});	
}

<%-- 预览附件 --%>
function openAttachFun(id) {
	console.log('===========测试中！======================>预览附件----');
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
function downloadAttachFun(attachID) {
	console.log('===========测试中！======================>下载附件----');
	console.log('===========测试中！======================>'+attachID);
	document.frm2.attachID.value = attachID;
	document.frm2.action = "<%=path%>/datamap/downloadFile";
	document.frm2.operation.value = "download";
	etSubmit(document.frm2);
}

<%-- 删除附件 --%>
function deleteAttachFun(obj, attachID) {
	console.log('===========测试中！======================>删除附件----');
	_currentAttachRow = obj.parentNode.parentNode;
	if(confirm("您确定要删除所选定的附件吗？")){
		$.ajax({
			type: "POST",
			url: "<%=path%>/datamap/delAttachment",
			data: {
				attachID: attachID
			},        
			success: function(data){
				console.log('===========测试中！======================>附件删除成功！！----');
				var attachTable = document.getElementById("attachTable");
				attachTable.deleteRow(_currentAttachRow.rowIndex);
				if(attachTable.rows.length == 0) {
					var newRow = attachTable1.rows[1].cloneNode(true);	
		    		attachTable.tBodies[0].appendChild(newRow);
		    	}
			},
			error: function(){
				
			}         
		});
	}
}
</script>

<form name="frm2" method="POST" action="">
<input type="hidden" name="operation" value="">
<input type="hidden" name="attachID" value="" />
<!-- 附件 -->
<%=UIUtils.togglePanelStart("附件", true, request)%>
	<%=UIUtils.toolbarStart(request)%>
	<%=UIUtils.toolbarButton(true, "javascript:newAttachFun();", "添加附件", "doc_attachment.gif", false, false,request)%>
	<%=UIUtils.toolbarEnd(request)%>
	
	<table style="width:100%;border:0;cellpadding:0;cellspacing:0" class="listTable" id="attachTable">
		 <tbody>
			<%for(AttachmentVO attachment : attachmentList) { %> 	
			<tr class="listTableTR"  id="attachRow___<%=attachment.getAttachID()%>" >
				<td align="left" >
					<span><img src="/static/images/attachment.png"></span>
					<a href="javascript:openAttachFun(<%=attachment.getAttachID()%>);"><%=attachment.getAttachName()%></a><span style="color: #949FA1;">(11 KB)</span>&nbsp;&nbsp;
					<a href="javascript:downloadAttachFun(<%=attachment.getAttachID()%>);"><span style="color: #35A0E5;">下载</span></a>&nbsp;&nbsp;
					<%if("1".equals(isEditable)){ %>
						<span style="color:  #35A0E5;cursor: pointer;" onclick="deleteAttachFun(this, <%=attachment.getAttachID()%>);">删除</span>
					<%} %>
				</td>
			</tr>
			<%}%>
			<%if(attachmentList.size() == 0){%>
		  	<tr class="listTableTR" id="noAttachTR">
		    	<td>没有记录!</td>
		  	</tr>
			<%}%> 		
		 </tbody>
	</table>
	
<%=UIUtils.togglePanelEnd(request)%>

<!-- 以上为表单 -->
</form>