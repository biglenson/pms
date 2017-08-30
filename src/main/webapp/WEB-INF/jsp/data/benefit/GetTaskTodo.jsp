<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import= "com.zq.commons.utils.UIUtils" %>
<%@ page import= "com.zq.commons.result.PageInfo" %>
<%@ page import="com.zq.vo.process.TaskTodoItemVO" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String pageTitle = (String)request.getAttribute("pageTitle");
	Integer appid = (Integer)request.getAttribute("appid");
	Long pid = (Long)request.getAttribute("pid");
	String url = (String)request.getAttribute("url");
	PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");

	//获取待办任务数据集合
	List<TaskTodoItemVO> taskTodoList = (List)request.getAttribute("taskTodo");
	String evalFor = url.indexOf("/datamap/basitemset") >= 0 ? "项目" : "产品";
	//判断任务待办归属产品还是项目
	int isProject = 0;
	if(url.indexOf("/datamap/basitemset") >= 0) {
		isProject = 0;
	}else{
		isProject = 1;
	}
	
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
		console.log('===========测试中！======================>关闭了弹出窗口----');
		if(ret != null){
			cleanFun();
			etSubmit(document.frm);
		}
		//刷新待办任务
		document.frm.action = "<%=path%>/datamap/getTaskTodo";
		etSubmit(document.frm);
		console.log('===========测试中！======================>刷新了待办任务----');
	});
}

//清空函数返回上个界面
function cleanFun(){
	document.frm.action = "<%=path%>/datamap/simpleFromBenefit"+"&_id="+Math.random();
	etSubmit(document.frm);
}

//评估列表条目点击事件
function openForm(processID, evalPhase) {
	var arg = new Array();
	arg.src = "<%=path%>/datamap/benefitEvalPopup?pageTitle=<%= pageTitle %>&url=<%= url%>&processID="+processID+"&submitFrom=todo"+"&_id="+Math.random();
	var evPhase = evalPhase==0?"前":"后";
	arg.title = "<%=evalFor%>"+ evPhase +"评估";
	arg.width = 840;
	arg.height = parent.document.body.clientHeight - 20;
	parent.ET.showModalWindow(arg, function (ret) { 
		console.log('返回值结果：  ' + ret);
		//刷新待办任务
		document.frm.action = "<%=path%>/datamap/getTaskTodo";
		etSubmit(document.frm);
		console.log('===========测试中！======================>刷新了待办任务----');
	});
}
</script>
<div class="popBodyDIV popBodyDIVNew">
<form name="frm" action="<%=path%>/datamap/simpleFromBenefit" method="GET">
<input type="hidden" name="pageTitle" value="<%= pageTitle %>">
<input type="hidden" name="url" value="<%= url %>">
<input type="hidden" name="operation" value="">
<input type="hidden" name="currentPage" value="${pageInfo.currentPage}">

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
	<ul id="tab" style="margin:0;padding:0;list-style:none;overflow:hidden;border-top:1px solid #DDD;background:#F4F4F4;">
        <li style="float:left;width:60px;height:30px;background:#FFF;border:0px;text-align:center;line-height:30px;cursor:pointer;border-left: 1px solid #DDD; ">待办</li>
        <li style="float:left;width:60px;height:30px;background:#F4F4F4;border:0px;text-align:center;line-height:30px;cursor:pointer;">已办</li>
    </ul>

	<div id='todo'>	
	<table style="border:0;cellpadding:0;cellspacing:0" class="listTable"  id="fieldTable">
  		<thead>
	         <tr style="border-bottom: 1px solid #DDD;">
			  	<th style="width:100%;background-color: #fff;"><div style="width: 200px;margin:0 auto;">评估名称</div></th>
				<th style="background-color: #fff;"><div style="width: 90px;">评估状态</div></th>
				<th style="background-color: #fff;"><div style="width: 120px;">评估类型</div></th>
				<th style="background-color: #fff;"><div style="width: 120px;">评估模板</div></th>
				<th style="background-color: #fff;"><div style="width: 90px;">评估人</div></th>
				<th style="background-color: #fff;"><div style="width: 90px;">评估时间</div></th>
	  		</tr>
  		</thead>
		<tbody>		
			<%if (taskTodoList.size() == 0) {%>
			<tr class="listTableTR">
				<td colspan="6">没有记录</td>
			</tr>
			<%} else{ 
				int count = taskTodoList.size();
				for (TaskTodoItemVO taskTodo : taskTodoList) {
					if (taskTodo.getEvalFor() == isProject){
						count --;
						%>
						<tr class="listTableTR">
							<td class="linkURL" onclick="openForm(<%=taskTodo.getProcessID()%>,<%=taskTodo.getEvalPhase()%>);"><%=taskTodo.getEvalTitle()%></td>
							<td><%=taskTodo.getTaskName()%></td>
							<td><%=evalFor%><%=taskTodo.getEvalPhase()==0?"前":"后"%>评估</td>
							<td><%=taskTodo.getTplTitle()%></td>
							<td><%=taskTodo.getAssignee()%></td>
							<td><fmt:formatDate value="<%=taskTodo.getCreateTime()%>" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						</tr>
						<%
					}
				} 
				if(count == taskTodoList.size()){
					%>
						<tr class="listTableTR">
							<td colspan="6">没有记录</td>
						</tr>
					<% 
				}
			}%>
		</tbody>
     </table>
     </div>
     <div id='todo'></div>
	<!-- 以上为表单 -->
	<!-- 分页导航条 -->
	<%=UIUtils.pageToolbar(pageInfo, request)%>
</form>
</div>

<script>
    $(document).ready(function() {
        $("#tab li").click(function() {
        	console.log('当前索引1'+$(this).index());
            $("#tab li").eq($(this).index()).css("background-color", "#FFF").siblings().css("background-color", "#F4F4F4");
            $("div[id=todo]").hide().eq($(this).index()).show();
            //另一种方法: $("div").eq($(".tab li").index(this)).addClass("on").siblings().removeClass('on'); 
            if ($(this).index() == 1) {
            	document.frm.action = "<%=path%>/datamap/getTaskDone";
            	document.frm.operation.value="toggle";
            	etSubmit(document.frm);
			}
        });
    });
</script>
<%-- 输出公共BodyEnd模块 --%>
<jsp:include page="../../common/BodyEnd.jsp" />