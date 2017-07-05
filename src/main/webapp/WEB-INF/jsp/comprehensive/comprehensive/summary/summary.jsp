<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = request.getContextPath();
Role department=(Role)request.getAttribute("department");
CMCCDepart newDepart = (CMCCDepart)request.getAttribute("newDepart");
boolean isRoot=department.getId()==Role.ROOT_DEPARTMENT_ID;
%>
<style>
.tipSpan {
	text-align: right;
	padding-left: 10px;
	padding-right: 10px;
	white-space: nowrap;
	line-height: 23px;
}

.tipSpan2 {
	font-weight: bold;
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
	font-size: 14px;
}

.sumContainer1 {
	border: 1px solid #D9D9D9;
	border-top: none;
}

.capexColumn {
	text-align: center;
	line-height: 30px;
	font-size: 14px;
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
		<td style='width: 27%; vertical-align: top;'>
			<div style='margin-right: 10px;'>
				<%if(TypeUtils.getIntFromString(newDepart.getEnum03())==2){ %>
				<div class="sumTitle">新建项目投资/OPEX预算</div>
				<%}else{ %>
				<div class="sumTitle">
					<%=isRoot?"本年分公司真实收入":"本年部门真实收入" %>
				</div>
				<%} %>
				<div class='sumContainer1' style="height: 170px;" id="shouRuSummary">
					<div class="loaddingClass"></div>
				</div>
				<div id="shouRuSummaryTime" class="viewChangeTime"></div>
			</div>
		</td>

		<td style='width: 27%; vertical-align: top;'>
			<div style='margin-right: 10px;'>
				<%if(TypeUtils.getIntFromString(newDepart.getEnum03())==2){ %>
				<div class="sumTitle">年度项目数量</div>
				<%}else{ %>
				<div class="sumTitle">新建项目投资/OPEX预算</div>
				<%} %>
				<div class='sumContainer1' style="height: 170px;"
					id="doTouzhiSummary">
					<div class="loaddingClass"></div>
				</div>
				<div id="doTouzhiSummaryTime" class="viewChangeTime"></div>
			</div>
		</td>
		<td style='width: 23%; vertical-align: top;'>
			<div style='margin-right: 10px;'>
				<div class="sumTitle">投资计划/预算执行进度</div>
				<div class='sumContainer1' style="height: 170px;"
					id="doTouziProcessSummary">
					<div class="loaddingClass"></div>
				</div>
				<div id="doTouziProcessSummaryTime" class="viewChangeTime"></div>
			</div>
		</td>
		<td style='width: 23%; vertical-align: top;'>
			<div>
				<div class="sumTitle">开支、转资进度</div>
				<div class='sumContainer1' style="height: 170px;"
					id="kaizhiAndZhuanZhiSummary">
					<div class="loaddingClass"></div>
				</div>
				<div id="kaizhiAndZhuanZhiSummaryTime" class="viewChangeTime"></div>
			</div>
		</td>
		</tr>
	</table>
</div>
<script type="text/javascript">
function showSummaryShouRuTip(obj){
	var detaiObj=obj.detaiObj;
	if(detaiObj==null){
		detaiObj=new ET.FloatDIV("showSummaryShouRuTipDIV");
		obj.detaiObj=detaiObj;
		ET.Utils.addEvent(detaiObj.sourceElement,'mouseover',function(){
			window.clearTimeout(detaiObj.hideID);
		})
		ET.Utils.addEvent(detaiObj.sourceElement,'mouseout',function(){
			detaiObj.hideID=window.setTimeout(function(){
				detaiObj.hide();
			},500)
		})
	}
	detaiObj.popup(obj,{
		x:2,
		y:3
	})
	
}
function showTouziSummaryTip(obj){
	var detaiObj=obj.detaiObj;
	if(detaiObj==null){
		detaiObj=new ET.FloatDIV("showTouziSummaryTipDIV");
		obj.detaiObj=detaiObj;
		ET.Utils.addEvent(detaiObj.sourceElement,'mouseover',function(){
			window.clearTimeout(detaiObj.hideID);
		})
		ET.Utils.addEvent(detaiObj.sourceElement,'mouseout',function(){
			detaiObj.hideID=window.setTimeout(function(){
				detaiObj.hide();
			},500)
		})
	}
	detaiObj.popup(obj,{
		x:2,
		y:3
	})
	
}

jQuery(document).ready(function(){
	var doAjax=function(subOperation){
		$.ajax({
			url:"<%=path%>/ZongheAction.do?operation=summary",
			method:"POST",
			data:{
				year:document.frm.year.value
				,'subOperation':subOperation
				,departmentID:<%=department.getId()%>
			},
			success:function(html){
				var div=$("#"+subOperation);
				div.html(html);
			}
		});
	};
	doAjax("shouRuSummary");
	doAjax("doTouzhiSummary");
	doAjax("doTouziProcessSummary");
	doAjax("kaizhiAndZhuanZhiSummary");
})
</script>