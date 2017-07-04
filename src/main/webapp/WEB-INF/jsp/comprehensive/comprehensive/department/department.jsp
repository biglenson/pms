<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = request.getContextPath();
%>
<style type="text/css">
	#departmentResultTable.listTable  tbody tr td{
		border: none;
	}
	#departmentResultTable th{
		
	}
	.depart_chengBenClass{
		width:auto;
		height:20px;
		float:right;
		position:relative;
		background-color: #528ED4;
	}
	.depart_shouRuClass{
		width:auto;
		height:20px;
		position:relative;
		background-color: #00B24D;
	}
	.depart_liRunLine{
		height: 100%;
		background-color: #ED842C;
		width:1px;
		position: absolute;
		left:0px;
		
	}
</style>
<script type="text/javascript">
function openDepartmentView(departmentID){
	var arg = new Array();
	arg.src = "<%=path%>/ZongheAction.do?operation=dashBoard";
	arg.src+="&departmentID="+departmentID;
	arg.src+="&isDialog=true";
	arg.title = undefined;
	ET.showNewWindow(arg, function (ret) { 
		if(ret != null){
			
		}
	});
}
	function loadDepartmentFun(index){
		$.ajax({
			url:"<%=path%>/ZongheAction.do?operation=departmentResult",
			method:"POST",
			data:{
				year:document.frm.year.value
			},
			success:function(html){
				var div=$("#department_ID");
				div.html(html);
			}
		});
	}
	jQuery(document).ready(function(){
		loadDepartmentFun(0);
	})
</script>
	<div   class="chartContainerDIV" style="border:none">
		<div><span class="subTabTitle">部门利润排名(Top 10)</span></div>
		<div id="department_ID">
			<div style="height:150px;" class="loaddingClass">
			</div>
		</div>
	</div>
	