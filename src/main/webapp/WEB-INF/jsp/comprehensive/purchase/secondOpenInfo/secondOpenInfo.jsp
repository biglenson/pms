<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = request.getContextPath();
%>
<script type="text/javascript">
	jQuery(document).ready(function(){
		$.ajax({
			url:"<%=path%>/CaiGouAction.do?operation=secondOpenMoneyInfo",
			method:"POST",
			data:{
				year:document.frm.year.value
			},
			success:function(html){
				var div=$("#openMoneyInfoDIV");
				div.html(html);
			}
		});
		$.ajax({
			url:"<%=path%>/CaiGouAction.do?operation=secondOpenProjectInfo",
			method:"POST",
			data:{
				year:document.frm.year.value
			},
			success:function(html){
				var div=$("#openProjectInfoDIV");
				div.html(html);
			}
		});
	})
</script>
<div>
	<table style='width:1000px;margin:26px auto;'>
		<td style='width:50%;vertical-align: top;'>
			<div style='margin-right:10px;' >
				<div class="sumTitle">
					二级集采金额公开统计
				</div>
				<div class='tabContent' style="height: 320px;width:500px;" id="openMoneyInfoDIV">
					<div  class="loaddingClass">
					</div>
				</div>
				<div id="secondOpenMoneyInfoDIVTimeDIV" class="viewChangeTime"></div>
			</div>
		</td>
		<td style='width:49%;vertical-align: top;'>
			<div>
				<div class="sumTitle">
					二级集采项目数公开统计
				</div>
				<div class='tabContent' style="height: 320px;" id="openProjectInfoDIV">
					<div  class="loaddingClass">
					</div>
				</div>
				<div id="secondOpenProjectInfoDIVTimeDIV" class="viewChangeTime"></div>
			</div>
		</td>
	</table>
</div>
