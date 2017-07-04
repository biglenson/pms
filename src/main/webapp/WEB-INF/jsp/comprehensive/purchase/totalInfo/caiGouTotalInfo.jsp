<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = request.getContextPath();
%>
<script type="text/javascript">
	jQuery(document).ready(function(){
		$.ajax({
			url:"<%=path%>/CaiGouAction.do?operation=caiGouTotalMoneyInfo",
			method:"POST",
			data:{
				year:document.frm.year.value
			},
			success:function(html){
				var div=$("#totalMoneyInfoDIV");
				div.html(html);
			}
		});
		$.ajax({
			url:"<%=path%>/CaiGouAction.do?operation=caiGouTotalProjectInfo",
			method:"POST",
			data:{
				year:document.frm.year.value
			},
			success:function(html){
				var div=$("#totalProjectInfoDIV");
				div.html(html);
			}
		});
	})
</script>
<div>
	<table style='width:1000px;margin:10px auto;'>
		<td style='width:50%;vertical-align: top;'>
			<div style='margin-right:10px;' >
				<div class="sumTitle">
					采购金额
				</div>
				<div class='tabContent' style="height: 470px;width:488px;" id="totalMoneyInfoDIV">
					<div  class="loaddingClass">
					</div>
				</div>
				<div id="caigouTotalMoneyInfoDIVTimeDIV" class="viewChangeTime"></div>
			</div>
		</td>
		
		<td style='width:50%;vertical-align: top;'>
			<div>
				<div class="sumTitle">
					采购项目数
				</div>
				<div class='tabContent' style="height: 470px;" id="totalProjectInfoDIV">
					<div  class="loaddingClass">
					</div>
				</div>
				<div id="caigouTotalProjectInfoDIVTimeDIV" class="viewChangeTime"></div>
			</div>
		</td>
	</table>
</div>
	