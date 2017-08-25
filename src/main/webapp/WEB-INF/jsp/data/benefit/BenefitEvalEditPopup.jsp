<%@page import="org.hibernate.sql.Template"%>
<%@page import="org.apache.commons.io.filefilter.FalseFileFilter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import= "com.zq.commons.utils.UIUtils" %>
<%@ page import="com.zq.vo.process.LoginInfoVO" %>
<%@ page import="com.zq.vo.process.BenefitEvalTplVO" %>
<%@ page import="com.zq.vo.process.BenefitEvalTplItemVO" %>
<%
	String path = request.getContextPath();
	//获取登录人信息
	LoginInfoVO loginInfo = (LoginInfoVO)request.getAttribute("loginInfo");
	//获取基本信息
	BenefitEvalTplVO benefitEvalInfo = (BenefitEvalTplVO)request.getAttribute("templateInfo");
	String evalPhase = benefitEvalInfo.getEvalPhase().toString();
	String evalFor = String.valueOf(benefitEvalInfo.getEvalFor());
	int tplID = benefitEvalInfo.getTplID();
	String evPhase = "";
	//判断是前评估还是后评估，1是后评估，0是前评估
	boolean isAfterEval;
	if ("1".equals(evalPhase)){
		isAfterEval = true;
		evPhase = "后";
	}else {
		isAfterEval = false;
		evPhase = "前";
	}
	int nameWidth = (760-30-180-80-50-100-(isAfterEval?160:0)-10);
	//获取评估信息，确定跳转页面的页面标题信息
	String evFor = "";
	if("0".equals(evalFor)) {
		evFor = "项目";
	}else{
		evFor = "产品";
	}
	// 评估状态
	String evalStatus = evFor + evPhase;
	//获取效益评估信息
	List<BenefitEvalTplItemVO> formInfos = (List)request.getAttribute("formTemplate");
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
		var creator = $('input[dbField=evalTitle]').val();
		var assignee = $('input[dbField=assignee]').val();
		if (!creator) {
			alert('标题不能为空！');
		}else if(!assignee) {
			alert('处理人不能为空！');
		}else {
			console.log('===========测试中！======================>修改再保存----');
			var obj = {};
			$('.formTable').find('[dbField]').each(function(index, elem) {
				var dbField = $(elem).attr("dbField");
				var vtype = $(elem).attr("vtype");
				obj[dbField] = getVtypeVal(vtype, elem);
			});
			var arr = new Array();
			for (var i = 1; i <= <%=formInfos.size()%>; i++) {
				var obj2 = {};
				$('.listTable').find('[dbField'+i+']').each(function(index, elem) {
					var dbField = $(elem).attr("dbField"+i);
					var vtype = $(elem).attr("vtype");
					obj2[dbField] = getVtypeVal(vtype, elem);
					arr[i-1] = obj2;
				});
			}
			
			console.log(obj);
			console.log(arr);
			
			document.frm.operation.value="submit";
			document.frm.evalInfo.value=JSON.stringify(obj);
			document.frm.evalForm.value=JSON.stringify(arr);
			document.frm.action="<%=path%>/datamap/submitBenefitEval";
			etSubmit(document.frm);
			parent.ET.setModalWindowReturnValue("1");
		}
	}); 
}

//保存
function save() {	
	$(function () {
		var creator = $('input[dbField=evalTitle]').val();
		if (!creator) {
			alert('标题不能为空！');
		}else  {
			var obj = {};
			$('.formTable').find('[dbField]').each(function(index, elem) {
				var dbField = $(elem).attr("dbField");
				var vtype = $(elem).attr("vtype");
				obj[dbField] = getVtypeVal(vtype, elem);
			});
			var arr = new Array();
			for (var i = 1; i <= <%=formInfos.size()%>; i++) {
				var obj2 = {};
				$('.listTable').find('[dbField'+i+']').each(function(index, elem) {
					var dbField = $(elem).attr("dbField"+i);
					var vtype = $(elem).attr("vtype");
					obj2[dbField] = getVtypeVal(vtype, elem);
					arr[i-1] = obj2;
				});
			}
			
			console.log(obj);
			console.log(arr);
			
			document.frm.operation.value="save";
			document.frm.submitFrom.value="todo";
			document.frm.evalInfo.value=JSON.stringify(obj);
			document.frm.evalForm.value=JSON.stringify(arr);
			document.frm.action="<%=path%>/datamap/saveBenefitEval";
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
<form name="frm" action="" method="POST">
<input type="hidden" name="operation" value="">
<input type="hidden" name="evalInfo" value="">
<input type="hidden" name="evalForm" value="">
<input type="hidden" name="submitFrom" value="">

<%=UIUtils.toolbarStart(request)%>
	<%=UIUtils.toolbarButton(true, "javascript:submit(\"0\");", "提交", "save.gif", false, false, request)%>
	<%=UIUtils.toolbarButton(true, "javascript:save();", "保存", "save.gif", false, false, request)%>
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
					<td class="seperator">
						<input vtype="input" dbField="evalID" type="hidden" value=""/>
						<input vtype="input" dbField="tplID" type="hidden" value="<%=benefitEvalInfo.getTplID()%>"/>
					</td>
					<td class="label white_background-color"></td>
					<td class="content white_background-color"></td>
				</tr>
				<tr>
					<td class="label">代码</td>
					<td class="content" id="evalCode"> 
						<div class="content-line" id="div-evalCode"></div>
						<input vtype="input" dbField="evalCode" type="hidden" value=""/>
					</td>
				</tr>
				<tr>
					<td colspan="5" height="5"></td>
				</tr>
				<tr>
					<td class="label">标题<font class="red">*</font></td>
					<td colspan="4" class="content" id="titletd">
						<input vtype="input" dbField="evalTitle" class="text" value="" maxlength="250" type="text">
					</td>
				</tr>
				<tr>
					<td colspan="5" height="5"></td>
				</tr>
				<tr>
					<td class="label">评估类型</td>
					<td class="content  " id="categorytd"> 
						<div class="content-line" id="div-categoryName"><%=evalStatus%>评估</div>
					</td>
					<td class="seperator"></td>
					<td class="label">状态</td>
					<td class="content  " id="statustd"> 
						<div class="content-line" id="div-statusName">${taskName}</div>
					</td>
				</tr>
				<tr>
					<td colspan="5" height="5"></td>
				</tr>
				<tr>
					<td class="label">创建人</td>
					<td class="content  " id="creator">
						<div class="content-line" style="cursor: pointer;"><%=loginInfo.getLoginName()%></div> 
					</td>
					<td class="seperator"></td>
					<td class="label">创建时间</td>
					<td class="content  " id="date01td">
						<div class="content-line">系统自动创建</div>
					</td>
				</tr>
				<tr>
					<td colspan="5" height="5"></td>
				</tr>
				<tr>
					<td class="label">评估模板</td>
					<td class="content" id="str01td">
						<div class="content-line" id="div-str01Name">${templateInfo.tplTitle}</div>
						<input vtype="input" dbField="tplTitle" type="hidden" value="${templateInfo.tplTitle}"/>
					</td>
					<td class="seperator"></td>
					<td class="label">是否有归口部门</td>
					<td class="content" id="statustd"> 
						<select vtype="select" dbField="hasDept">
						  <option value="1" selected="selected">是</option>
						  <option value="0">否</option>
						</select>
					</td>
				</tr>
			</tbody>
		</table>
		
		<%-- 效益评估 --%>
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
						int index = 1; //自定义索引,该索引仅用于排序
						int indexKey = 1; //自定义索引,该索引用于表单数据的提取
						for(BenefitEvalTplItemVO item : formTemplate){
							if(!dimension.equals(item.getEvalDimension())) {
								dimension = item.getEvalDimension();
				%>	
				<tr class="listTableTR" >
					<td align="center">
						<%=index++%>
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
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>		
				<%}%>
				<!-- 小类项 -->
				<tr class="listTableTR" >
					<td align="center">
						<%=index%>
						<input vtype="input" dbField<%=indexKey%>="tplItemID" type="hidden" value="<%=item.getTplItemID()%>"/>
						<input vtype="input" dbField<%=indexKey%>="evalID" type="hidden" value=""/>
						<input vtype="input" dbField<%=indexKey%>="itemID" type="hidden" value=""/>
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
						<input type="text" class="text" style="width: 78px;text-align: right;border: none;" contentType="N10.2" readonly="readonly" value=""/>
					</td>
					<%}%>
					<td align="right">
						<input vtype="input" dbField<%=indexKey%>="evalValue" type="text" class="text" style="width: 78px;text-align: right;" <%if(isAfterEval){%>onchange="cmccScoreChangeFun(this);"<%}%>
						 contentType="N10.2" value=""/>
					</td>
					<%if(isAfterEval){%>
					<td align="right">
						<input type="text" class="text" style="width: 78px;text-align: right;border: none;" contentType="N10.2" readonly="readonly" value=""/>
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
							<input vtype="input" dbField<%=indexKey%>="evalNote" type="text" class="text" style="width:98px;" maxlength="100" value=""/>
						</div>
					</td>
				</tr>
				<%index++;indexKey++;}}else{%>
				<tr class="listTableTR" >
					<td colspan="9">没有记录</td>
				</tr>
				<%}%>
			</tbody>
		</table>
		<%=UIUtils.togglePanelEnd(request)%>
		
		<%-- 附件 --%>
		<jsp:include page="./AttachInclude.jsp"/>
		<%-- 下一步 --%>
		<%=UIUtils.togglePanelStart("下一步", true, request)%>
		<table style="border:0;align:center;cellpadding:0;cellspacing:0" id="fieldTable" class="formTable">						
			<tbody>
				<tr>
					<td class="label white_background-color"></td>
					<td class="content white_background-color"></td>
					<td class="seperator">
						<input type="hidden" vtype="select" dbField="dealRslt" value="1"/>
						<input type="hidden" vtype="select" dbField="rsltDesc" value="提交"/>
						<input type="hidden" vtype="textarea" dbfield="dealOpinion" value=""/>
					</td>
					<td class="label white_background-color"></td>
					<td class="content white_background-color"></td>
				</tr>
				<tr>
					<td class="label">处理人<font class="red">*</font></td>
					<td class="content  " id="creator">
						<div class="content-div" id="content-div-res01" style="cursor: pointer;">
							<!-- <input vtype="input" dbfield="assignee" class="text" value="lenson" readonly="" style="cursor: pointer;" type="text">
							<img src="/static/images/benefit/assign_resources.gif" id="div-img-res01" align="absmiddle"> -->
							<input vtype="input" dbfield="assignee" class="text" value="" style="cursor: pointer;" type="text">
						</div> 
						<script type="text/javascript">
							ET.Utils.addEvent(document.getElementById('content-div-res01'),'click',function(){ 
								var img=document.getElementById('div-img-res01');
								treeSelectUtils.showUserSelect(img.parentElement.children[0],img.parentElement.children[1], 7,69,true); 
							}) 
						</script>
					</td>
				</tr>
			</tbody>
		</table>
		<%=UIUtils.togglePanelEnd(request)%>
		<%-- 工作流 --%>
		<jsp:include page="./WorkFlowInclude.jsp"/>
    <%=UIUtils.formBodyEnd(request) %>
</div>

<!-- 以上为表单 -->
</form>

<%-- 输出公共BodyEnd模块 --%>
<jsp:include page="../../common/BodyEnd.jsp" />
</html>

<script>
<%-- 判断各表单项类型获取对应的值 --%>
function getVtypeVal(vtype, elem) {
	var val = "";
	if (vtype == "input") { // 输入框
		val = $.trim($(elem).val());
	} else if (vtype == "select") { // 下拉框
		val = $(elem).val();
	} else if (vtype == "radios") { // 单选
		val = $(elem).attr("val");
	} else if (vtype == "date") {	// 时间
		val = $(elem).val();
	} else if (vtype == "textarea") {	// 文本域
		val = $(elem).val();
	}
	if (!val) {
		val = "";
	}
	return val;
}
</script>
