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
	boolean isMulti = false;
	boolean isShowProject=false;
	boolean isShowContact = false;
	boolean contractEmpty = false;
%>

<%-- 输出Head1模块 --%>
<jsp:include page="../../common/Head1.jsp" />

<link href="/static/css/user_select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/static/js/selectUser.js"></script>

<script type="text/javascript">
function onloadFun(){
	parent.ET.setModalWindowTheme("search");
	parent.ET.setModalWindowTitle("<div>选择用户</div>");
	/* try{
		document.frm.idField.value=parent.ET.currentIDField.value;
	}catch(ex){
	} */
	window.selectUserObj=new ET.SelectUser({
		isMutil:<%=isMulti%>
		,rootDepartmentID:69
	});
	var seachTypeJQuery = jQuery(".user_search_Table ul li");
	$("#backToProject").click(function(){
		$("#projectTypeDIV").show();
		$("#commonTypeDIV").hide();
		window.selectUserObj.searchType="project";
		$("#searchValue").val("");
		window.selectUserObj.doSearch();
	})
	$("#antherSelectType").click(function(){
		$("#commonTypeDIV").show();
		$("#projectTypeDIV").hide();
		var typeOn=seachTypeJQuery.filter('.on');
		if(typeOn.size()==0){
			$("#contract").addClass('on');
			window.selectUserObj.searchType="contract";
		}else{
			window.selectUserObj.searchType=typeOn.attr('id');
		}
		$("#searchValue").val("");
		window.selectUserObj.doSearch();
	});
	initAlreadySelected();
	seachTypeJQuery.on("click", function(event){
		var dom = $(this);
		if(!dom.hasClass('on')){
			var type = dom.attr('id');
			seachTypeJQuery.filter('.on').removeClass('on');
			dom.addClass('on');
			window.selectUserObj.searchType = type;
			if(type == "depart"){
				$("#searchValue").attr("placeholder", "按部门名称搜索");
				$("#searchValue").attr("title", "按部门名称搜索");
			}else{
				$("#searchValue").attr("placeholder", "输入以搜索");
				$("#searchValue").attr("title", "输入以搜索");
			}
			window.setTimeout(function(){
				window.selectUserObj.searchValue.focus();
			},10)
			window.selectUserObj.doSearch();
		}
	})
	<%if(isShowProject){%>
		window.selectUserObj.searchType="project";
	<%}else{%>
		var searchType=seachTypeJQuery.filter('.on').attr('id');
		window.selectUserObj.searchType=searchType;
	<%}%>
	window.setTimeout(function(){
		window.selectUserObj.searchValue.focus();
	},10)
	$("#btnCancel").on('click',function(){
		parent.ET.closeModalWindow();
	})
	$("#btnSave").on('click',function(){
		OKFun();
	})
}
function OKFun(){
	<%if(isMulti){%>
		 parent.ET.closeModalWindow(window.selectUserObj.getOldAlreadySelect());
	<%}else{%>
		var size = window.selectUserObj.getSelectSize();
	  <%boolean canReturnNull = Boolean.parseBoolean(request.getParameter("canReturnNull"));
		if(canReturnNull){%>
			parent.ET.closeModalWindow(window.selectUserObj.getOldAlreadySelect());
		<%}else{%>
		if(size>0){
			parent.ET.closeModalWindow(window.selectUserObj.getOldAlreadySelect());
		}else{
			alert('<bean:message key="pleaseSelectUser"/>');
		}
	<%}%>
<%}%>
}
function evalScripts(text){
	if( typeof text == 'string'){
		var script = null;
	    var scripts = []; 
	    var regexp = /<script[^>]*>([\s\S]*?)<\/script>/gi; 
	    while ((script = regexp.exec(text))) scripts.push(script[1]); 
	    scripts = scripts.join('\n'); 
	    window.eval(scripts);
	}else{
		jQuery('script',text);
		if(scripts != null){
			for(var i=0,j=scripts.length;i<j;i++){
				window.eval(scripts[i].innerHTML);
			}
		}
	}
}
//初始化已经被选择的的用户项(右侧Div)
function initAlreadySelected(){
	jQuery.ajax({
		url:'<%=path%>/UserAction.do?operation=alreaySelectUser',
		method:'post',
		data:{
			userIDArray:document.frm.idField.value
		},
		dataType:'html',
		success:function(html){
			window.selectUserObj.alreadySelectBarDIV.html($(html));
			evalScripts(html);
			window.selectUserObj.freshTotal();
			window.selectUserObj.alreadySelectBar.resize();
			//加载左侧Div用户选择界面
			window.selectUserObj.doSearch();
		}
	})
}
jQuery(document).ready(function(){
	onloadFun();
});
</script>

<!-- 内容主体 -->
<form name="frm" onsubmit="return false;">
<input type="hidden" name="idField" value="">
<input type="hidden" name="isMulti" value="<%=isMulti%>">

<div  id='userSelectDIV'  class=" userSelectDIV ">
	<div id="leftDIV" class='leftDIV' >
		<div id="user_search_Table" class="user_search_Table">
			<%if(isShowProject){ %>
			<div id="projectTypeDIV" class="projectTypeDIV"  >
				<div class=" projectName nowrapText"  title=""  >工程</div>
				<div class="antherSelectType"   id="antherSelectType">antherSelectType</div>
				<div style='clear:both;'></div>
			</div>
			<%} %>
			<div id="commonTypeDIV"  <%if(isShowProject){ %>style="display:none;" <%} %>>
				<%--切换 选项卡 --%>
				<%if(isShowProject){ %>
				<div id="backToProject"  class="backToProject"  title="<bean:message key="backToProjectSelect"/>"></div>
				<%} %>
				<ul style="margin-left:0px;">
					<li id='contract'>常用联系人</li>
					<li id='all' <%if(!isShowContact||contractEmpty ){ %> class="on" <%} %> >所有人</li>
					<li id='depart' >按部门筛选</li>
				</ul>
			</div>
		</div>
		
		<div id="searchDIV" class="searchDIV">
			<input id="searchValue" maxlength="200" autocomplete="off" title="输入以搜索" placeholder="输入以搜索" type="text">
			<img id="searchImg" src="<%=path %>/static/images/16x16/search.png">
		</div>
		 
		<div id="resultDIV"  class=" resultDIV">
			<%-- 搜索结果显示区域--%>
			<div class="loadding"></div>
		</div>
	</div><%-- id="leftDIV" --%>

	<div id="rightDIV"  class=" rightDIV"  >
		<%-- 显示已经选中的人 --%>
		<div id="selectMessage" class='selectMessage'>
			<span id='selectTag' class='selectTag'>已选择</span>
			<span id='selectCountTag' class='selectCountTag'>&nbsp;100</span>
			<span class='selectTag'>人员</span>
			<span id="clearAll" class='clearAll'>清空全部</span>
		</div>
		<div id="already_selectDIV"  class='already_selectDIV '   >	
			<div class="loadding"></div>
		</div>
	</div>

	<div style='clear:both;'></div>
</div>
<div class="OKButtonBottom">
	<div class="OKButtonDIV  "  >
		<input type="button" id="btnSave"  name="btnSave"  class="kbutton OKButton"  value="确定" >
		<input type="button" id="btnCancel"  class='kbutton  '  name="btnCancel"   value="取消" >
	</div>
</div>
</form>
<!-- 以上为表单 -->

<%-- 输出公共BodyEnd模块 --%>
<jsp:include page="../../common/BodyEnd.jsp" />