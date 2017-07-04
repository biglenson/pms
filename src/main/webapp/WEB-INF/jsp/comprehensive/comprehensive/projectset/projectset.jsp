<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = request.getContextPath();
Locale locale = webMgr.getCurrentLocale();
%>
<script type="text/javascript">

	function loadProjectSetFun(){
		var data={
				year:document.frm.year.value
				,departmentID:document.frm.departmentID.value
			};
		$.ajax({
			url:"<%=path%>/ZongheAction.do?operation=projectSetResult",
			method:"POST",
			data:data,
			success:function(html){
				var div=$("#projectSetRequestJSP");
				div.html(html);
			}
		});
	}
	jQuery(document).ready(function(){
		loadProjectSetFun();
	})
</script>
	<div   class="chartContainerDIV cmccViewContainer" style="margin: 26px auto;">
		<div class="tabMore linkURL" onclick="openProjectSetSummaryList()">更多</div>
		<div class="tabTitle">
		 	<ul>
		 		<li onclick="loadProjectSetFun()" class="on">项目执行情况</li>
		 	</ul>
		 </div>
		<div style='min-height:120px;' class="tabContent" id="projectSetRequestJSP">
			<div  class="loaddingClass"></div>
		</div>
	</div>
	<div id="projectSetRequestJSPTime" class="viewChangeTime marginTopTime"></div>