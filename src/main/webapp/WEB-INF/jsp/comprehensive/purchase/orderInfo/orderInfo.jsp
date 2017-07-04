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
					超时订单TOP10
				</div>
				<div class='tabContent' style="height: 400px;width:500px;" id="order_overtime">
					<div  class="loaddingClass">
					</div>
				</div>
				<div id="order_overtimeDIVTimeDIV" class="viewChangeTime"></div>
			</div>
		</td>
		<td style='width:49%;vertical-align: top;'>
			<div>
				<div class="sumTitle">
					即将超时订单TOP10
				</div>
				<div class='tabContent' style="height: 400px;" id="order_overtimesoon">
					<div  class="loaddingClass">
					</div>
				</div>
				<div id="order_overtimesoonDIVTimeDIV" class="viewChangeTime"></div>
			</div>
		</td>
	</table>
</div>
<script type="text/javascript">
jQuery(document).ready(function(){
	var doAjax=function(index,select){
		$.ajax({
			url:"<%=path%>/CaiGouAction.do?operation=orderInfo",
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
	doAjax(0,"#order_overtime");
	doAjax(1,"#order_overtimesoon");
})
</script>