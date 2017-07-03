<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 输出head1模块 --%>
<jsp:include page="../../common/Head1.jsp" />
<body>
<%-- 输出系统顶级模块的菜单 --%>
<jsp:include page="../../common/TopMenu.jsp">
	<jsp:param name="appid" value="2" />
</jsp:include>
<div class="container" id="bodyStart_container">
<%-- 输出LeftMenu模块 --%>
<jsp:include page="../../common/LeftMenu.jsp" />
<script type="text/javascript">
	window.toogle_close_flag=false;
</script>

<!-- 展示内容 -->
<div class="content-wrap" id="bodyStart__content_Wrap">
	<div class="content-empty"></div>
		<div class="newTitleDIV">CAPEX自主资金池</div>
			<div class="content-main">
				<form name="frm" id = "capexSelfFundsPool"action="/capex/capexSelfFundsPool" method="post">
					<div class="toolbar" id="toolbarDIV">
						<table class="toolbarTable">
							<tbody>
								<tr>
									<td id="ET_ToolbarButton" class="toolbarEnable" align="center" nowrap="">
									   <div class="ET_ToolbarButtonContainer " 	onclick="showMenu(this);">
											<span class="ET_ToolbarButtonImg"><img src="/static/images/newui/search.png"></span>
											<span id="ET_ToolbarButtonLabel" class=" labelSearch ">查询全部</span>
										</div>
									</td>
									<td id="ET_ToolbarButton" class="toolbarEnable" align="center" nowrap="">
										<div class="ET_ToolbarButtonContainer "	onclick="javascript:newFun();">
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
					<div class="Toolbar-spacing"></div><!-- 空格 -->
					<div class="barListSplitLine"></div><!-- 横线 -->
					
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
									<td align="center"><img name="action-open" id="actionImg" src="/static/images/16x16/action_open.gif" title="快捷操作" 
											style="cursor: pointer" onclick="javascript:showFormActionMenu(this, '285855');">											
									</td>
									<td style="cursor: pointer" align="center" onclick="">${record.year}</td>
									<td style="cursor: pointer" align="center" onclick="">${record.initfunds}</td>
									<td style="cursor: pointer" align="center" onclick="">${record.avifunds}</td>
								</tr>
								</c:forEach>										
						</tbody>
					</table>				
				</form>
			</div>
		</div>
</div>
<script type="text/javascript">
$(document).ready(function() { 
	document.getElementById("capexSelfFundsPool").submit();
	}); 
</script>
</body>
</html>