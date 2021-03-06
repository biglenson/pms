<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	boolean isDialog = Boolean.parseBoolean(request.getParameter("isDialog"));
	String pageTitle = "财务视图";
%>
<html>
<%-- 输出head模块 --%>
<jsp:include page="../../common/Head.jsp" />
<body>
	<%-- 输出系统顶级模块的菜单 --%>
	<jsp:include page="../../common/TopMenu.jsp">
		<jsp:param name="appid" value="1" />
		<jsp:param name="url" value="/financialview" />
	</jsp:include>
	<div class="container  " id="bodyStart_container" style="top: 50px">
		<div class="content-wrap" id="bodyStart__content_Wrap"
			style="left: 0px;">
			<div class="content-empty"></div>
			<div class="content-main">
				<form name="frm" action="/pm/CMCCAction.do" method="post">
					<input type="hidden" name="operation" value="caiWu"> <input
						type="hidden" name="year" value="2017"> <input
						type="hidden" name="menuID" value="56"> <input
						type="hidden" name="page" value=""> <input type="hidden"
						name="isDialog" value="false">
					<div class="cmccTopTitle">
						<div style="width: 1000px; margin: 0px auto;">
							<div
								style="float: left; font-size: 24px; font-weight: bold; color: #4C4C4C;"><%= pageTitle %></div>
						</div>
						<div style="height: 34px; width: 1000px; margin: 0px auto;">
							<%
								if (isDialog) {
							%>
							<div class="returnDIV" style="float: right; margin-left: 13px;"
								onclick="returnLastWindow()">返回上一级</div>
							<%
								}
							%>
							<div class="HighChartYearSelect">
								<jsp:include page='/WEB-INF/jsp/common/year_toolInclude.jsp'>
									<jsp:param name="jsFunction" value="changeyear" />
									<jsp:param name="yearID" value="yearID" />
									<jsp:param name="containerID" value="departContainer" />
								</jsp:include>
							</div>
							<div style="clear: both;"></div>
						</div>
						<div
							style="font-size: 12px; line-height: 25px; text-align: right; margin: 0px auto; width: 1000px;">单位:万元</div>
					</div>
					<div id="propDIV" class='yibiao_start'>
						<div style="width: 1000px; margin: 0 auto;">
							<jsp:include page="./summary/summary.jsp" />
							<jsp:include page="./pnd/productAndDepart.jsp" />
							<jsp:include page="./budget/yusuanzhixingDIV.jsp" />
							<jsp:include page="./opexflow/opexPhaseStatus.jsp" />
						</div>
					</div>
					<script type="text/javascript">
						//var oldIndexArray=['milestone','workProduct','task','WorkItem'];
						var scrollbar2 = new ET.ScrollBar('propDIV', {
							destoryHtml : false
						});
						window.dashScrollBar = scrollbar2;
						function scrollBoardDIV() {
							var dashBoardDIV = EventUtil.$ID("propDIV");

							//dashBoardDIV.style.overflow="auto";
							var bodyHeight = 0;
							if (document.compatMode == 'CSS1Compat') {
								bodyHeight = document.documentElement.clientHeight;
							} else {
								bodyHeight = document.body.clientHeight;
								//dashBoardDIV.style.width=(document.body.clientWidth-dashBoardDIV.getBoundingClientRect().left)+"px";
							}
							var height = bodyHeight - dashBoardDIV.getBoundingClientRect().top - 0;
							if (height <= 0) {
								height = 0;
							}
							dashBoardDIV.style.height = height + "px";
							scrollbar2.resize();
							//setSummaryJiao(oldIndexArray[oldIndex-1]);
						}
						EventUtil.addHandler(window, 'resize', scrollBoardDIV);
						ET.addToggleLeftEvent(scrollBoardDIV);
						ET.Utils.addOnloadEvent(scrollBoardDIV);
					</script>
				</form>
			</div>
		</div>
	</div>
</body>
</html>

