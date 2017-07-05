<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = request.getContextPath();
%>
<script type="text/javascript">
	function loadTouziDetialFun(index){
		var data={
				year:document.frm.year.value
				,departmentID:document.frm.departmentID.value
				,index:index
			};
		$.ajax({
			url:"<%=path%>/ZongheAction.do?operation=touziDetail",
			method:"POST",
			data:data,
			success:function(html){
				var div=$("#touziDetailDIV");
				div.html(html);
			}
		});
	}
	jQuery(document).ready(function(){
		loadTouziDetialFun(0);
	})
</script>
<div class="chartContainerDIV cmccViewContainer">
	<div id="touziDetailDIV">
		<%request.setAttribute("index", 0); %>
		<jsp:include page="touziDetailTab.jsp"></jsp:include>
		<div class="tabContent" style='min-height: 250px;'>
			<div class="loaddingClass"></div>
		</div>
	</div>
</div>
<div id="touziDetailDIVTime" class="viewChangeTime marginTopTime"></div>
