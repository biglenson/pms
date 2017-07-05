<%@ page language="java" pageEncoding="UTF-8"%>
<%-- <%
String path = request.getContextPath();
SessionManager webMgr = new SessionManager();
webMgr.init(session);
User user = webMgr.getCurrentUser();
Locale locale = webMgr.getCurrentLocale();
%> --%>
<style>
.tipSpan {
	white-space: nowrap;
	line-height: 23px;
}

.tipSpan2 {
	font-weight: bold;
	font-size: 14px;
}

.sumTitle {
	font-size: 14px;
	line-height: 40px;
	font-weight: bold;
	color: #FFF;
	background-color: #03A9F4;
	text-align: center;
}

.sumValue {
	line-height: 24px;
	padding-top: 10px;
	text-align: center;
	color: #0ACC4B;
	font-size: 24px;
	font-weight: bold;
}

.sumContainer1 {
	border: 1px solid #D9D9D9;
	border-top: none;
}

.infoLabel {
	padding-left: 10px;
	white-space: nowrap;
	line-height: 25px;
	padding-right: 10px;
}

.tdBorder {
	margin: 4px 0px;
	border-bottom: 1px dotted #D9D9D9;
}
</style>
<div>
	<table style='width: 1000px; margin: 10px auto;'>
		<tr>
			<td style='width: 20%; vertical-align: top;'>
				<div style='margin-right: 10px;'>
					<div class="sumTitle">投资使用进度</div>
					<div class='sumContainer1' style="height: 160px;"
						id="summary_touzi">
						<div class="loaddingClass"></div>
					</div>
					<div id="gongchengSummary0TimeDIV" class="viewChangeTime"></div>
				</div>
			</td>
			<td style='width: 25%; vertical-align: top;'>
				<div style='margin-right: 10px;'>
					<div class="sumTitle">自主资金池使用情况</div>
					<div class='sumContainer1' style="height: 160px;"
						id="summary_zizhuJin">
						<div class="loaddingClass"></div>
					</div>
					<div id="gongchengSummary1TimeDIV" class="viewChangeTime"></div>
				</div>
			</td>
			<td style='width: 21%; vertical-align: top;'>
				<div style='margin-right: 10px;'>
					<div class="sumTitle">开支、转资进度</div>
					<div class='sumContainer1' style="height: 160px;"
						id="sumary_kaizhi">
						<div class="loaddingClass"></div>
					</div>
					<div id="gongchengSummary2TimeDIV" class="viewChangeTime"></div>
				</div>
			</td>
			<td style='width: 32%; vertical-align: top;'>
				<div>
					<div class="sumTitle">CAPEX项目数量</div>
					<div class='sumContainer1' style="height: 160px;"
						id="summary_projectCount">
						<div class="loaddingClass"></div>
					</div>
					<div id="gongchengSummary3TimeDIV" class="viewChangeTime"></div>
				</div>
			</td>
		</tr>
	</table>
</div>
<script type="text/javascript">
<%-- jQuery(document).ready(function(){
	var doAjax=function(index,select){
		$.ajax({
			url:"<%=path%>/GongchengAction.do?operation=summary2",
			method:"POST",
			data:{
				year:document.frm.year.value
				,departmentID:<%=Role.ROOT_DEPARTMENT_ID%>
				,index:index
			},
			success:function(html){
				var div=$(select);
				div.html(html);
			}
		});
	};
	doAjax(0,"#summary_touzi");
	doAjax(1,"#summary_zizhuJin");
	doAjax(2,"#summary_projectCount");
	doAjax(3,"#sumary_kaizhi");
}) --%>
</script>