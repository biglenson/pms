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
<%-- 输出公共BodyStart模块 --%>
<jsp:include page="../../common/BodyStart.jsp">
	<jsp:param name="pageTitle" value="<%= pageTitle %>" />
	<jsp:param name="appid" value="<%= appid %>" />
	<jsp:param name="pid" value="<%= pid %>" />
	<jsp:param name="url" value="<%= url %>" />
</jsp:include>

<!-- 内容主体 -->
<script type="text/javascript">
function showMenu(obj) {
	popupMenu(obj, listMenu, "");
}

function newFun() {
	var arg = new Array();
	arg.src = "<%=path%>${action}/add";
	arg.title = "<%= pageTitle %>";
	arg.width = 840;
	arg.height = document.body.clientHeight - 20;
	parent.ET.showNewWindow(arg, function (ret) { 
		if(ret != null){
			document.frm.submit();
		}
	});	
}

//列表项详情跳转
function openFrom(id) {
	var arg = new Array();
	arg.src = "<%=path%>/datamap/simpleFormBasic?pageTitle=<%= pageTitle %>&url=<%= url%>"+"&_id="+Math.random();
	arg.title = "<%= pageTitle %>";
	arg.width = 840;
	arg.height = document.body.clientHeight - 20;
	parent.ET.showNewWindow(arg, function (ret) { 
		if(ret != null){
			document.frm.submit();
		} 
	},
	function (ret) {
		
	});	
}
</script>

<div class="content-main">
	<form name="frm" id="${action}" action="${action}" method="post">
	<input type="hidden" name="page" value="${pageInfo.currentPage}">
	<!-- 工具栏 -->
		<div class="toolbar" id="toolbarDIV">
			<table class="toolbarTable">
				<tbody>
					<tr>
						<%=UIUtils.searchToolButton("showMenu(this);", "查询全部", request)%>
						<%=UIUtils.toolbarButton(true ,"newFun();", "添加", null, false, false,request)%>
						<td width='100%'></td>
						<%=UIUtils.toolbarButton(true , "showMore(this);", "更多...",null, false, false ,request)%>	
					</tr>
				</tbody>
			</table>
		</div>
		<!-- 空格 -->
		<div class="Toolbar-spacing"></div>
		<!-- 横线 -->
		<div class="barListSplitLine"></div>
		<div id = "formListTable_upDiv" style="overflow:auto">
		<!-- 以下为表单 -->
		<table class="listTable dataTable" id="formListTable" style="table-layout: fixed;">
			<thead>
				<tr>
					<th>
						<div style="width: 20px;">
							<img src="/static/images/16x16/action_open.gif" title="快捷操作">
						</div>
					</th>
					<c:forEach items="${formListTitle}" var="list">
						<th>
							<div style="${list.style}">${list.name}</div>
						</th>
					</c:forEach>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pageData}" var="record">
					<tr class="listTableTR">
						<td align="center"><img name="action-open" id="actionImg" src="/static/images/16x16/action_open.gif" title="快捷操作" style="cursor: pointer" onclick="javascript:showFormActionMenu(this, '285855');">
						</td>
						<c:forEach items="${formListTitle}" var="list">
							<td><div style="${list.style};white-space: nowrap;text-overflow: ellipsis;overflow: hidden;text-align:left;cursor:pointer" align="center" onclick="javascript:openFrom(${record})" title="${record[list.attribute]}">${record[list.attribute]}</div></td>
						</c:forEach>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
		<!-- 以上为表单 -->
		<%=UIUtils.pageToolbar(pageInfo, request)%>
	</form>
</div>
<script type="text/javascript">
	function findDimensions() { //函数：获取尺寸
		var winHeight = document.body.scrollHeight - 200; // 取窗口高度
		if (winHeight <= 0)
			winHeight = 640; // 初始高度并不总能取出，设默认值
		document.getElementById("formListTable_upDiv").style.height = winHeight	+ 'px'; // 设置宽度
	}
	findDimensions();
	//调用函数，获取数值
	window.onresize = findDimensions;
</script>
<%-- 输出公共BodyEnd模块 --%>
<jsp:include page="../../common/BodyEnd.jsp" />
			