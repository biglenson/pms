<%@page import="org.hibernate.sql.Template"%>
<%@page import="org.apache.commons.io.filefilter.FalseFileFilter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import= "com.zq.commons.utils.UIUtils" %>
<%@ page import="com.zq.vo.process.BenefitEvalTplVO" %>
<%@ page import="com.zq.vo.process.BenefitEvalTplItemVO" %>
<%
	String path = request.getContextPath();
	//获取模版基本信息
	BenefitEvalTplVO benefitEvalInfo = (BenefitEvalTplVO)request.getAttribute("templateInfo");
	String evalPhase = benefitEvalInfo.getEvalPhase().toString();
	String evalFor = String.valueOf(benefitEvalInfo.getEvalFor());
	int tplID = benefitEvalInfo.getTplID();
	boolean isAfterEval;
	if ("1".equals(evalPhase)){
		isAfterEval = true;
	}else {
		isAfterEval = false;
	}
	int nameWidth = (760-30-180-80-50-100-(isAfterEval?160:0)-10); //是否是后评估
	//获取评估信息，确定跳转页面的页面标题信息
	String evFor = evalFor=="0"?"项目":"产品";
	String evPhase = evalPhase == "0"?"前":"后";
%>

<style>
/* 层叠其他样式的覆盖 */
td,div {
	font-size: 12px;
}
</style>

<%-- 输出Head1模块 --%>
<jsp:include page="../../common/Head1.jsp" />

<script type="text/javascript">
//提交
function submit() {
	$(function () {
		var creator = $('input[name=evalTitle]').val();
		if (!creator) {
			alert('标题不能为空！');
		}else  {
			/* document.frm.submit(); */
			document.frm.operation.value="submit";
			document.frm.action="<%=path%>/datamap/benefitEvalPopup2";
			etSubmit(document.frm);
		}
	}); 
}

//保存
function save() {	
	$(function () {
		var creator = $('input[name=evalTitle]').val();
		if (!creator) {
			alert('标题不能为空！');
		}else  {
			/* document.frm.submit(); */
			document.frm.operation.value="save";
			etSubmit(document.frm);
		}
	});  
}

//取消
function cancel() {
	if(!isLeave()) return;   
	parent.ET.closeModalWindow();
}

//自动适配当前窗体高度
function autoContentHeight(){
	ET.MainScroll("contentDIV");
}
ET.Utils.addOnloadEvent(autoContentHeight);
</script>

<!-- 内容主体 -->
<form name="frm" action="<%=path%>/datamap/benefitEvalPopup" method="GET">
<input type="hidden" name="operation" value="">
<input type="hidden" name="tplID" value="<%=tplID%>">

<%=UIUtils.toolbarStart(request)%>
	<%=UIUtils.toolbarButton(true, "javascript:submit(\"0\");", "提交", "save.gif", false, false, request)%>
	<%=UIUtils.toolbarButton(true, "javascript:save(\"0\");", "保存", "save.gif", false, false, request)%>
	<%=UIUtils.toolbarButton(true, "javascript:cancel();", "取消", "back.gif", false, false, request)%>
<%=UIUtils.toolbarEnd(request)%>

<div style="overflow: auto;" class='relativeDIV' id="contentDIV">
	<%=UIUtils.formBodyStart(request) %>
	
		<!-- 基本信息 -->
		<table  style="border:0;align:center;cellpadding:0;cellspacing:0" id="fieldTable" class='formTable'>						
			<tbody>
				<tr>
					<td class="label white_background-color"></td>
					<td class="content white_background-color"></td>
					<td class="seperator"></td>
					<td class="label white_background-color"></td>
					<td class="content white_background-color"></td>
				</tr>
				<tr>
					<td class="label">代码</td>
					<td class="content" id="codetd"> 
						<div class="content-line" id="div-codeName"></div>
					</td>
				</tr>
				<tr>
					<td colspan="5" height="5"></td>
				</tr>
				<tr>
					<td class="label">标题<font class="red">*</font></td>
					<td colspan="4" class="content" id="titletd">
						<input class="text" name="evalTitle" value="" maxlength="250" type="text">
					</td>
				</tr>
				<tr>
					<td colspan="5" height="5"></td>
				</tr>
				<tr>
					<td class="label">评估类型</td>
					<td class="content  " id="categorytd"> 
						<div class="content-line" id="div-categoryName">项目前评估</div>
					</td>
					<td class="seperator"></td>
					<td class="label">状态</td>
					<td class="content  " id="statustd"> 
						<div class="content-line" id="div-statusName">待需求负责人审批</div>
					</td>
				</tr>
				<tr>
					<td colspan="5" height="5"></td>
				</tr>
				<tr>
					<td class="label">创建人</td>
					<td class="content  " id="creator">
						<div class="content-div" id="content-div-res01" style="cursor: pointer;">
							<input class="text" name="creator" value="admin" readonly="" style="cursor: pointer;" type="text">
							<img src="<%=path%>/static/images/benefit/assign_resources.gif" id="div-img-res01" align="absmiddle">
						</div> 
						<script type="text/javascript">
							ET.Utils.addEvent(document.getElementById('content-div-res01'),'click',function(){ 
								var img=document.getElementById('div-img-res01');
								treeSelectUtils.showUserSelect(img.parentElement.children[0],img.parentElement.children[1], 7,69,true); 
							}) 
						</script>
					</td>
					<td class="seperator"></td>
					<td class="label">创建时间</td>
					<td class="content  " id="date01td">
						<div class="content-div" id="content-div-date01"> 
							<input class="text" name="createDate" id="createDate" value="" contenttype="D2" style="cursor: pointer;" autocomplete="off" type="text">
							<!-- <img src="/pm/images/16x16/calendar.gif" name="imagdate01" id="imagdate01" style="cursor:pointer"> -->
						</div>  
						<script type="text/javascript"> 
							showCalendar("date01","imagdate01");
						</script>
					</td>
				</tr>
				<tr>
					<td colspan="5" height="5"></td>
				</tr>
				<tr>
					<td class="label">评估模板</td>
					<td class="content" id="str01td">
						<div class="content-line" id="div-str01Name">${templateInfo.tplTitle}</div>
					</td>
					<td class="seperator"></td>
					<td class="label">是否有归口部门</td>
					<td class="content  " id="statustd"> 
						<select name="hasDept">
						  <option value="0">是</option>
						  <option value="1">否</option>
						</select>
					</td>
				</tr>
			</tbody>
		</table>
		
		<!-- 效益评估 -->
		<%=UIUtils.togglePanelStart("效益评估", true, request)%>
		<table style="width:100%;border:0;cellpadding:0;cellspacing:0" class="listTable">
			<thead>
			    <tr>
			    	<th ><div style="width:30px">序号</div></th>
					<th ><div style="width:<%=nameWidth%>px;">评价指标</div></th>
					<th ><div style="width:180px">指标说明</div></th>
					<%if(isAfterEval){%>
					<th ><div style="width:80px">前评估值</div></th>
					<%}%>
					<th ><div style="width:80px"><%=(isAfterEval?"后":"前")%>评估值</div></th>
					<%if(isAfterEval){%>
					<th ><div style="width:80px">偏差</div></th>
					<%}%>
					<th ><div style="width:50px">参考值</div></th>
					<th ><div style="width:100px">描述</div></th>
		 		</tr> 
			</thead>
			<tbody>
				<!-- 大类项 -->
				<%
				List<BenefitEvalTplItemVO> formTemplate = (List)request.getAttribute("formTemplate");
					if(formTemplate != null && formTemplate.size() > 0){
						String dimension = ""; //大类标识
						int index = 1; //自定义索引
						for(BenefitEvalTplItemVO item : formTemplate){
							if(!dimension.equals(item.getEvalDimension())) {
								dimension = item.getEvalDimension();
				%>	
				<tr class="listTableTR" >
					<td align="center">
						<%=index%>
					</td>
					<td title="<%=item.getEvalDimension()%>">
						<div style="width: <%=nameWidth %>px" class="nowrapText">
							<img src="<%=path %>/static/images/folderClosed.gif" style="width: 16px; height: 16px;"/>
							<%=item.getEvalDimension()%>
						</div>
					</td>
					<td title="">
						<div style="width:178px;" class="nowrapText">
						</div>
					</td>
				</tr>		
				<%}%>
				<!-- 小类项 -->
				<tr class="listTableTR" >
					<td align="center">
						<%=index+1%>
					</td>
					<td title="<%=item.getEvalItem()%>">
						<div style="width: <%=nameWidth %>px" class="nowrapText">
							<img src="<%=path %>/static/images/benefit/empty.gif" style="width: 16px; height: 16px;"/>
							<img src="<%=path %>/static/images/benefit/task.gif" style="width: 16px; height: 16px;"/>
							<%=item.getEvalItem()%>
						</div>
					</td>
					<td title="<%=item.getEvalDesc()%>">
						<div style="width: 178px" class="nowrapText">
							<%=item.getEvalDesc()%>
						</div>
					</td>
					<%if(isAfterEval){%>
					<td align="right">
						<input type="text" class="text" style="width: 78px;text-align: right;border: none;" name="cmcc_prescore" contentType="N10.2" readonly="readonly" value=""/>
					</td>
					<%}%>
					<td align="right">
						<input type="text" class="text" style="width: 78px;text-align: right;" name="evalValue<%item.getTplItemID();%>" <%if(isAfterEval){%>onchange="cmccScoreChangeFun(this);"<%}%>
						 contentType="N10.2" value=""/>
					</td>
					<%if(isAfterEval){%>
					<td align="right">
						<input type="text" class="text" style="width: 78px;text-align: right;border: none;" contentType="N10.2" name="cmcc_deviation" readonly="readonly" value=""/>
					</td>
					<%}%>
					<td title="<%=item.getRefValue() %>" align="center">
						<%if(item.getRefValue().length()>0){%>
							<img src="<%=path %>/static/images/benefit/discussion_filled.gif" />
						<%}else{%>
							<img src="<%=path %>/static/images/benefit/discussion.gif" />
						<%}%>
					</td>
					<td title="">
						<div style="width: 100px" class="nowrapText">
							<input type="text" class="text" style="width:98px;" name="evalNote<%item.getTplItemID();%>" maxlength="100" value=""/>
						</div>
					</td>
				</tr>
				<%index++;}}else{%>
				<tr class="listTableTR" >
					<td colspan="9">没有记录</td>
				</tr>
				<%}%>
			</tbody>
		</table>
		<%=UIUtils.togglePanelEnd(request)%>
		
		<!--附件 -->
		<jsp:include page="./AttachInclude.jsp"/>
		<!--工作流 -->
		<jsp:include page="./WorkFlowInclude.jsp"/>
    <%=UIUtils.formBodyEnd(request) %>
</div>

<!-- 以上为表单 -->
</form>

<%-- 输出公共BodyEnd模块 --%>
<jsp:include page="../../common/BodyEnd.jsp" />
</html>