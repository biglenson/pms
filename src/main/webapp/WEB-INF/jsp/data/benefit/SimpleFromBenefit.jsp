<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import= "com.zq.commons.utils.UIUtils" %>
<%@ page import= "com.zq.commons.result.PageInfo" %>
<%
	String path = request.getContextPath();
	String pageTitle = (String)request.getAttribute("pageTitle");
	Integer appid = (Integer)request.getAttribute("appid");
	Long pid = (Long)request.getAttribute("pid");
	String url = (String)request.getAttribute("url");
	PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
%>
<%-- 输出Head1模块 --%>
<jsp:include page="../../common/Head1.jsp" />

<!-- 内容主体 -->
<script type="text/javascript">
//产本、项目基本信息
function simpleForm(){
	document.frm.action = "<%=path%>/datamap/simpleFormBasic";
	etSubmit(document.frm);
}

//新建前评估
function newBeforeScorecard(){
	if("<%=url%>".indexOf("/datamap/basitemset") >= 0) {
		selectScorecardTemplate("0","0");
		console.log("项目页--前评估");
	}else{
		selectScorecardTemplate("1","0");
		console.log("产品页--前评估");
	}
}

//新建后评估
function newAfterScorecard(){
	if("<%=url%>".indexOf("/datamap/basitemset") >= 0) {
		selectScorecardTemplate("0","1");
		console.log("项目页--后评估");
	}else{
		selectScorecardTemplate("1","1");
		console.log("产品页--后评估");
	}
}

//新建评估弹窗——选择模版 
function selectScorecardTemplate(evalFor,evalPhase){
	var arg=new Array();
	var scorecardType = 0;
	arg.src = "<%=path%>/datamap/chooseTemplate?evalFor=" + evalFor + "&evalPhase=" + evalPhase +"&_id=" + Math.random();
	arg.title = '效益评估模板';
	arg.width = 600;
	arg.theme="search";
	arg.height =310;
	ET.showModalWindow(arg, function (ret) { 
		if(!isNaN(ret)){
			if(ret!=0){
				newFormFun(evalFor, evalPhase, ret);
			}
		}
	});  
}

//选择模版之后的编辑弹出窗体
function newFormFun(evalFor, evalPhase, chooseItem) {
	var chooseFor = evalFor=='0'?"项目":"产品";
	var choosePhase = evalPhase == '0'?"前":"后";
	var arg = new Array();
	arg.src = "<%=path%>/datamap/benefitEvalEditPopup?tplID="+ chooseItem +"&_id=" + Math.random();
	arg.title = chooseFor + choosePhase + "评估";
	arg.width = 840;
	arg.height = parent.document.body.clientHeight - 20;
	parent.ET.showModalWindow(arg, function (ret) { 
		if(ret != null){
			cleanFun();
			etSubmit(document.frm);
		}
	});
}

//清空函数返回上个界面
function cleanFun(){
	document.frm.action = "<%=path%>/datamap/simpleFromBenefit"+"&_id="+Math.random();
	etSubmit(document.frm);
}

//评估列表条目 
function openForm(id,schemaID) {
	var arg = new Array();
	arg.src = "<%=path%>/datamap/benefitEvalPopup?pageTitle=<%= pageTitle %>&url=<%= url%>"+"&_id="+Math.random();
	arg.title = "项目前评估";
	arg.width = 840;
	arg.height = parent.document.body.clientHeight - 20;
	parent.ET.showModalWindow(arg, function (ret) { 
		SimpleFormAction.unlockMySelf(id, function(data) {
			if(ret != null){
				cleanFun();
				etSubmit(document.frm);
			}
		});
	});
}
</script>
<div class="popBodyDIV popBodyDIVNew">
<form name="frm" action="<%=path%>/datamap/simpleFromBenefit" method="post">
<input type="hidden" name="pageTitle" value="<%= pageTitle %>">
<input type="hidden" name="url" value="<%= url %>">

<%=UIUtils.tabPanelStart(request)%>
<%=UIUtils.tabPanel(true, "javascript:simpleForm();", pageTitle+"基本信息", null, false, request)%>
<%=UIUtils.tabPanel(true, "javascript:openFormScorecard();", "效益评估", null, true, request)%>
<%=UIUtils.tabPanelEnd(request)%>

	<div class="toolbar" id="toolbarDIV">
		<table class="toolbarTable">
			<tbody>
				<tr>
					<%=UIUtils.toolbarButton(true, "javascript:newBeforeScorecard()","新建前评估","add.gif", false, false, request)%>
					<%=UIUtils.toolbarButton(true, "javascript:newAfterScorecard()","新建后评估","add.gif", false, false, request)%>	
				</tr>
			</tbody>
		</table>
	</div>

	<table style="border:0;cellpadding:0;cellspacing:0" class="listTable"  id="fieldTable">
  		<thead>
	         <tr>
			  	<th style="width:100%;"><div style="width: 200px;margin:0 auto;">评估名称</div></th>
				<th><div style="width: 90px;">评估状态</div></th>
				<th><div style="width: 120px;">评估类型</div></th>
				<th><div style="width: 120px;">评估模板</div></th>
				<th><div style="width: 90px;">评估人</div></th>
				<th><div style="width: 90px;">评估时间</div></th>
	  		</tr>
  		</thead>
		<tbody>		
<%-- 				<%
				if (totalSize == 0) {
						%>
					  <tr class="listTableTR">
					    <td colspan="6"><bean:message key="NoRecord"/></td>
					  </tr>
				<%
					} else{
							for (FormBase form:formBaseList) {
				%>
				<tr class="listTableTR">
					<td class="linkURL" onclick="openForm(<%=form.getId()%>,<%=form.getCategory()%>);"><%=TypeUtils.xmlEncoderForIE(form.getTitle())%></td>
					<td><%=TypeUtils.xmlEncoderForIE(form.getStatusName(sLocale))%></td>
					<td><%=TypeUtils.xmlEncoderForIE(form.getCategoryName(user, sLocale))%></td>
					<td><%=TypeUtils.xmlEncoderForIE(cmccSimpleForm.getScoreCardTemplateName(user, form.getStr01()))%></td>
					<td><%=TypeUtils.xmlEncoderForIE(CommonUtils.getUserNameByIDs(user.getCompanyID(), form.getRes01()))%></td>
					<td><%=TypeUtils.date2String(form.getDate01(), 1)%></td>
				</tr>
			<%
				}}
			%> --%>

			<tr class="listTableTR" style="">
				<td class="linkURL" onclick="openForm(520996,1096);">前评估测试</td>
				<td>待需求负责人审批</td>
				<td>项目前评估</td>
				<td>项目效益评估模型-促销项目</td>
				<td>chenliang</td>
				<td>2017-07-25</td>
			</tr>
		
			<tr class="listTableTR" style="">
				<td class="linkURL" onclick="openForm(517121,1097);">test项目后评估</td>
				<td>待提交</td>
				<td>项目后评估</td>
				<td>项目效益评估模型-促销项目</td>
				<td>黄利利</td>
				<td>2017-06-20</td>
			</tr>
		
			<tr class="listTableTR" style="">
				<td class="linkURL" onclick="openForm(421632,1096);">促销项目效益评估</td>
				<td>通过</td>
				<td>项目前评估</td>
				<td>项目效益评估模型-促销项目</td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
     </table>
     
	<!-- 以上为表单 -->
	<%-- <%=UIUtils.pageToolbar(pageInfo, request)%> --%>
</form>
</div>
<%-- 输出公共BodyEnd模块 --%>
<jsp:include page="../../common/BodyEnd.jsp" />
