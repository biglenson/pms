<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String pageTitle = (String)request.getAttribute("pageTitle");
	Integer appid = (Integer)request.getAttribute("appid");
	Long pid = (Long)request.getAttribute("pid");
	String url = (String)request.getAttribute("url");
%>
<%-- 输出Head2模块 --%>
<jsp:include page="../../common/Head2.jsp" />
<%-- 输出公共BodyStart模块 --%>
<jsp:include page="../../common/BodyStart.jsp">
	<jsp:param name="pageTitle" value="<%= pageTitle %>" />
	<jsp:param name="appid" value="<%= appid %>" />
	<jsp:param name="pid" value="<%= pid %>" />
	<jsp:param name="url" value="<%= url %>" />
</jsp:include>
<!-- 内容主体 -->
<div class="content-main">
	<form name="frm" id="capexSelfFundsPool" action="/capex/capexSelfFundsPool" method="post">
	<!-- 工具栏 -->
		<div class="toolbar" id="toolbarDIV">
			<table class="toolbarTable">
				<tbody>
					<tr>
						<td id="ET_ToolbarButton" class="toolbarEnable" align="center" nowrap="">
							<div class="ET_ToolbarButtonContainer " onclick="showMenu(this);">
								<span class="ET_ToolbarButtonImg">
									<img src="/static/images/newui/search.png">
								</span> 
								<span id="ET_ToolbarButtonLabel" class=" labelSearch ">查询全部</span>
							</div>
						</td>
						<td id="ET_ToolbarButton" class="toolbarEnable" align="center" nowrap="">
							<div class="ET_ToolbarButtonContainer " onclick="javascript:newFun();">
								<span id="ET_ToolbarButtonLabel" class=" labelNoImg ">添加</span>
							</div>
						</td>
						<td width="100%"></td>
						<td id="ET_ToolbarButton" class="toolbarEnable" align="center" nowrap="">
							<div class="ET_ToolbarButtonContainer " onclick="javascript:showMore(this);">
								<span id="ET_ToolbarButtonLabel" class=" labelNoImg ">更多...</span>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- 空格 -->
		<div class="Toolbar-spacing"></div>
		<!-- 横线 -->
		<div class="barListSplitLine"></div>
		
		<!-- 以下为表单 -->
		<table class="listTable dataTable" id="formListTable">
			<thead>
				<tr>
					<th><div style="width: 20px;">
							<img src="/static/images/16x16/action_open.gif" title="快捷操作">
						</div>
					</th>
					<c:forEach items="${titlelist}" var="list">
						<th>
							<div style="width: 100px;">${list}</div>
						</th>
					</c:forEach>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${recordlist}" var="record">
					<tr class="listTableTR">
						<td align="center"><img name="action-open" id="actionImg" src="/static/images/16x16/action_open.gif" title="快捷操作" style="cursor: pointer" onclick="javascript:showFormActionMenu(this, '285855');">
						</td>
						<td style="cursor: pointer" align="center" onclick="">${record.year}</td>
						<td style="cursor: pointer" align="center" onclick="">${record.initfunds}</td>
						<td style="cursor: pointer" align="center" onclick="">${record.avifunds}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<!-- 以上为表单 -->
		
	</form>
</div>
<%-- 输出公共BodyEnd模块 --%>
<jsp:include page="../../common/BodyEnd.jsp" />
			
