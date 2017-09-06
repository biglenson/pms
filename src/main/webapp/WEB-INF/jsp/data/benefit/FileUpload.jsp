<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import= "com.zq.commons.utils.UIUtils" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String processID = (String)request.getAttribute("processID");
%>

<%-- 输出Head1模块 --%>
<jsp:include page="../../common/Head1.jsp" />
<link href="/static/css/webuploader.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/static/js/webuploader.min.js"></script>

<style type="text/css">
	.input_file{
		visibility: hidden;
		height: 5px;
	}
	.input_file_ie{
		width:99%;
		height: 20px;
	}
	.fileDIV_ie{
		display: none;
	}
	.fileDIV{
	}
	a:hover {
		text-decoration: underline;
	}
	#old_attachDIV{
		display: none;
	}
</style>

<!-- 内容主体 -->
<script type="text/javascript">
//确定
function OkFun() {
	var support = WebUploader.Uploader.support();
	var isIE8 = /msie 8/i.test(navigator.userAgent);
	if(!support || isIE8){
		var fileName = document.frm.documentName.value;
		if(fileName == "") {
			alert('文件名不能为空');
			return false;
		}
		if(fileName.length > 120) {
			alert("文件名过长");
			return false;
		}
		if(!checkFileExt(fileName)){
			return false;
		}
		//setTimeout(refreshUploadStatus,500);
		etSubmit(document.frm);
		document.frm.fileText.disabled = true;
		document.frm.fileButton.disabled = true;
		document.frm.name.disabled = true;
		document.frm.okBtn.disabled = true;
		document.frm.cancelBtn.disabled = true;
	}else{
		uploader.options.formData.processID = <%=processID%>;
		window.uploader.upload();
	}
}

//取消
function cancelFun(){
	parent.ET.closeModalWindow();
}

function initFileHeight(){
	var objFile = document.getElementById("name");
	var fileDIV = document.getElementById("fileDIV");
	if(ET.is_ie){
		var ieHiddenDIV = document.getElementById("ieHiddenDIV");
		ieHiddenDIV.style.height="10px";
		objFile.className="input_file_ie";
		fileDIV.className="fileDIV_ie";
	}else{
		objFile.className="input_file";
		fileDIV.className="fileDIV";
	}
}
ET.Utils.addOnloadEvent("initFileHeight()");
</script>

<div class="popBodyDIV">
<form name="frm" method="post" action="" enctype="multipart/form-data">
<input type="hidden" name="processID" value="<%=processID%>"/>

<div id="searchDIV"  class="searchContainerDIV" >
	<%=UIUtils.groupBoxStart("上传文件的说明", request)%>
	<tr>
		<td>1、文件大小不能超过10MB；</td>
	</tr>
	<%=UIUtils.spacer(null, request)%>
	<tr>
		<td>2、只允许上传下列扩展名的文件：所有类型文件。</td>
	</tr>
	<%=UIUtils.groupBoxEnd(request)%>
	   
	<div id="new_attachDIV">
		<div id="uploader">
			<div id="picker" style="width:60px;height:30px; margin:10px auto;" class="webuploader-container">
				<div class="webuploader-pick">添加</div>
				<div id="rt_rt_1boqtc14juh31foc1ecf1efhr3v1" style="position: absolute; top: 0px; left: 0px; width: 54px; height: 37px; overflow: hidden; bottom: auto; right: auto;">
					<input name="attachment" class="webuploader-element-invisible" multiple="multiple" type="file">
					<label style="opacity: 0; width: 100%; height: 100%; display: block; cursor: pointer; background: rgb(255, 255, 255) none repeat scroll 0% 0%;"></label>
				</div>
			</div>
		</div>
		<div id="thelist" class="uploader-list dumascroll" style="overflow: hidden; position: relative;">
			<div class="dumascroll_area"></div>
			<div class="dumascroll_barY" style="display: none;">
				<div class="dumascroll_arrow_up"></div>
				<div class="dumascroll_handleY"></div>
				<div class="dumascroll_arrow_down"></div>
			</div>
			<div class="dumascroll_barX" style="display: none;">
				<div class="dumascroll_arrow_left"></div>
				<div class="dumascroll_handleX"></div>
				<div class="dumascroll_arrow_right"></div>
			</div>
			<div class="duma_rightButtom"></div>
		</div>
	</div>
	
</div>

<div class="OKButtonBottom">
	<div class="OKButtonDIV">
		<input name="okBtn" class="kbutton OKButton" type="button" value='上传' onclick='OkFun();'>
		<input name="cancelBtn" class="kbutton" type="button" value='取消' onclick="cancelFun()">
	</div>	
</div>

</form>
</div>

<%-- 输出公共BodyEnd模块 --%>
<jsp:include page="../../common/BodyEnd.jsp" />

<script type="text/javascript">
$(function() {
	if (!Array.prototype.indexOf) {
		Array.prototype.indexOf = function(elt) {
		  var len = this.length >>> 0;
		
		  var from = Number(arguments[1]) || 0;
		  from = (from < 0)
		       ? Math.ceil(from)
		       : Math.floor(from);
		  if (from < 0)
		    from += len;
		
		  for (; from < len; from++) {
		    if (from in this &&
		        this[from] === elt)
		      return from;
		  }
		  return -1;
		};
	}
	//文件上传请求的参数表，每次发送都会发送此对象中的参数。
	function getFormData(){
		var jhiddens=$('form input, form textarea, form select');
		var result = {};
		jhiddens.each(function(index, hidden){
			if(hidden.type=="radio"||hidden.type=="checkbox"){
				if(hidden.checked){
					result[hidden.name]=$(hidden).val();
				}
			}else{
				result[hidden.name]=$(hidden).val();
			}
		});
		return result;
	}
	var support = WebUploader.Uploader.support();
	var isIE8 = /msie 8/i.test(navigator.userAgent);
	if(support && !isIE8){
		function getFileSize(size){
			return WebUploader.Base.formatSize(size, 1, ['B', 'KB', 'M','GB'] ) ;
		}
		//文件数组
		var filesArray = [];
		window.filesArray = filesArray;
		var scrollBar = new ET.ScrollBar('thelist');
		//实例化
		var uploader = WebUploader.create({
			swf: '<%=path%>/static/Uploader.swf',
		    server: '/datamap/addAttachment',
		   	//指定选择文件的按钮容器，不指定则不创建按钮
		    pick: {
		    	//指定选择文件的按钮容器
		    	id: '#picker',
		    	//开起同时选择多个文件能力
		    	multiple: true
		    },
		    //设置文件上传域的name，默认值是file 
		    fileVal: 'attachment',
		    //验证文件总大小是否超出限制, 超出则不允许加入队列
		    fileSizeLimit: 10*1024*1024,
		    //向服务端传递数据
		    formData: getFormData(),
		    //允许通过粘贴来添加截屏的图片上传
		    paste: document.body,
		    //允许通过拖拽文件进来上传
		    disableGlobalDnd: true,
		    //指定允许拖拽接收文件的区域
		    dnd: '#picker',
		    //去重， 根据文件名字、文件大小和最后修改时间来生成hash Key
		    duplicate: false
		});
	   	var $list = $(scrollBar.contentDIV);
		$list.on("click", ".item-close", function(event) {
			var file_id = $(this).parent().attr("id");
			var file = uploader.getFile(file_id);
			uploader.removeFile(file, true);
			//js的indexOf方法在IE8中报错
			//若不加入上面一段，下面indexOf方法在ie8上会报错
			var index = filesArray.indexOf(file);
			filesArray.splice(index, 1);
			$(this).parent().remove();
			scrollBar.resize(true);
		});
		//当文件被加入队列以后触发
		uploader.on("fileQueued", function(file) {
			 filesArray.push(file);
			 var item = jQuery("<div id='" + file.id + "' class='uploader-list-item'>" +
				"<div id='fileName"+ file.id +"'class='item-name'>"+ file.name +"("+getFileSize(file.size)+")</div>" +
				"<div id='fileClose"+ file.id +"'class='item-close'></div>" +
				"<div id='fileProgress"+ file.id +"'class='item-progress'><div class='item-progress-value'></div></div>" +
			    "</div>");
			 $list.append(item);
			 scrollBar.scrollToEnd();
			 scrollBar.resize(false);
		});
		//当validate不通过时，会以派送错误事件的形式通知调用者
		uploader.on("error",function(type){
			 if(type=="Q_TYPE_DENIED"){
				 alert("文件大小超过限定的范围");
			 }else if(type=="Q_EXCEED_SIZE_LIMIT"){
				 alert(arguments[2].name + "文件大小超过限定的范围");
			 }else if(type="F_DUPLICATE"){
				 alert(arguments[1].name + "已经被添加了");
			 }
		});
		//当开始上传流程时触发
		uploader.on("startUpload",function(){
			window.uploader.options.formData = getFormData();
		});
		//上传过程中触发，携带上传进度
		uploader.on("uploadProgress", function(file, percentage){
			var fileProgress = $("#fileProgress"+ file.id +" .item-progress-value");
			fileProgress.css("width", (percentage*100) + "%");
		});
		//当文件上传成功时触发
		uploader.on("uploadSuccess", function(file) {
			$('#' + file.id ).remove();
			scrollBar.resize(false);
		});
		//当文件上传出错时触发
		uploader.on("uploadError", function(file) {
			    
		});
		//不管成功或者失败，文件上传完成时触发
		uploader.on("uploadFinished",function(){
			parent.ET.closeModalWindow("1");
		});
		window.uploader = uploader;
	}else {
		$("#old_attachDIV").css('display',"block");
		$("#new_attachDIV").css('display',"none");
	}
});
</script>