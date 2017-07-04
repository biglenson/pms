<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = request.getContextPath();
%>
<style>
</style>
<div>
	<table style='width:1000px;margin:26px auto;'>
		<td style='width:50%;vertical-align: top;'>
			<div style='margin-right:10px;' >
				<div class="sumTitle">
					超时合同TOP10
				</div>
				<div class='tabContent' style="height: 400px;width:500px;" id="contract_overtime">
					<div  class="loaddingClass">
					</div>
				</div>
				<div id="contract_overtimeDIVTimeDIV" class="viewChangeTime"></div>
			</div>
		</td>
		<td style='width:49%;vertical-align: top;'>
			<div>
				<div class="sumTitle">
					即将超时合同TOP10
				</div>
				<div class='tabContent' style="height: 400px;" id="contract_overtimesoon">
					<div  class="loaddingClass">
					</div>
				</div>
				<div id="contract_overtimesoonDIVTimeDIV" class="viewChangeTime"></div>
			</div>
		</td>
	</table>
</div>
<script type="text/javascript">
jQuery(document).ready(function(){
	var doAjax=function(index,select){
		$.ajax({
			url:"<%=path%>/CaiGouAction.do?operation=contractInfo",
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
	doAjax(0,"#contract_overtime");
	doAjax(1,"#contract_overtimesoon");
})
</script>