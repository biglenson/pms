<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = request.getContextPath();
Role department=(Role)request.getAttribute("department");
%>
<style type="text/css">
</style>
<div class="chartContainerDIV" style="margin: 26px auto;">
	<div style="text-align: right">
		<div class="showHelpe" onclick="showCapexPhaseTip(this)"></div>
	</div>
	<div class="helpFloatDIV" id="pahseTipNameDIV"
		style="line-height: 22px;">
		<div class="showHelpeContent" style="line-height: 23px;">
			<div>投资计划项目数量：年度项目总数量</div>
			<div>各阶段项目数量：项目阶段为当前环节的项目数量</div>
			<div>需求阶段：需求提交-需求冻结</div>
			<div>立项/可研阶段：需求冻结-可研批复</div>
			<div>采购阶段：可研批复-采购完成</div>
			<div>设计阶段：采购完成-设计批复</div>
			<div>工程建设阶段：设计批复-试运行</div>
			<div>试运行阶段：试运行-终验批复</div>
			<div>竣工投产：终验批复后</div>
		</div>
	</div>
	<div id="capex_phaseStatusDIV" style="min-height: 220px;">
		<div class="loaddingClass"></div>
	</div>
</div>
<div id="capex_phaseStatusDIVTimeDIV"
	class="viewChangeTime marginTopTime"></div>

<script type="text/javascript">
$(document).ready(function(){
	$.ajax({
		url:"<%=path%>/ZongheAction.do?operation=capexPhaseStatus",
		method:"POST",
		data:{
			year:document.frm.year.value
			,departmentID:<%=department.getId()%>
		},
		success:function(html){
			var div=$("#capex_phaseStatusDIV");
			div.html(html);
		}
	});
})
function showCapexPhaseTip(obj){
	var detaiObj=obj.detaiObj;
	if(detaiObj==null){
		detaiObj=new ET.FloatDIV("pahseTipNameDIV");
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
</script>