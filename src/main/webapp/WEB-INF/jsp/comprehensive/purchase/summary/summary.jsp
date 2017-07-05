<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = request.getContextPath();
%>
<style>
.tipDIV {
	margin: 10px 5px;
	width: 15px;
	height: 15px;
}

.blodDIV {
	font-weight: bold;
}
</style>
<div>
	<table style='width: 1000px; margin: 26px auto;'>
		<td style='width: 50%; vertical-align: top;'>
			<div style='margin-right: 10px;'>
				<div class="sumTitle">采购项目启动及时率</div>
				<div class='tabContent' style="height: 200px; width: 500px;"
					id="summary_start">
					<div class="loaddingClass"></div>
				</div>
				<div id="summary_startDIVTimeDIV" class="viewChangeTime"></div>
			</div>
		</td>
		<td style='width: 49%; vertical-align: top;'>
			<div>
				<div class="sumTitle">采购项目完成及时率</div>
				<div class='tabContent' style="height: 200px;" id="summary_finish">
					<div class="loaddingClass"></div>
				</div>
				<div id="summary_finishDIVTimeDIV" class="viewChangeTime"></div>
			</div>
		</td>
	</table>
</div>
<script type="text/javascript">
jQuery(document).ready(function(){
	var doAjax=function(index,select){
		$.ajax({
			url:"<%=path%>/CaiGouAction.do?operation=summary",
			method:"POST",
			data:{
				year:document.frm.year.value,
				index:index
			},
			success:function(html){
				var div=$(select);
				div.html(html);
			}
		});
	};
	doAjax(0,"#summary_start");
	doAjax(1,"#summary_finish");
})
</script>