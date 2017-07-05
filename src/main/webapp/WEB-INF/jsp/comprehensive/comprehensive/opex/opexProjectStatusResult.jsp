<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = request.getContextPath();
String[] phaseName=OPEXProject.PHASENAMES;
Map<String,Double> zhixingDetail = (Map<String,Double>)request.getAttribute("zhixingDetail");
int[] allCount=(int[])request.getAttribute("allCount");
int totalCount=(Integer)request.getAttribute("totalCount");
double[] allMoney = (double[])request.getAttribute("allMoney");
Double totalMoney = (Double)request.getAttribute("totalMoney");
String[] moneyNames = (String[])request.getAttribute("moneyNames");
%>
<div>
	<table class="statusTable" style="margin: 0 auto;" border="0"
		cellspacing="0" cellpadding="0">
		<tr>
			<td style="vertical-align: top;"><div class="cmcc_phase_column"
					style='width: 119px; font-weight: bold;'>OPEX项目流程：</div></td>
			<td>
				<div style="padding-bottom: 20px;">
					<img src="<%=path %>/images/cmcc/liucheng2.png">
				</div>
			</td>
		</tr>
		<tr>
			<td style="height: 10px;"></td>
		</tr>
		<tr>
			<td><div class="cmcc_phase_column" style='width: 119px;'>项目总数：</div></td>
			<td>
				<div class="cmcc_phase_kuang" style="background-position: 15px 0px">
					<div class="cmcc_phase_valueDIV linkURL" style="width: 119px;"
						onclick="openOpexProjectList(-1);"><%=TypeUtils.formatCount(totalCount) %></div>
					<%for(int i=0,j=phaseName.length;i<j;i++){%>
					<div class="cmcc_phase_valueDIV linkURL" style="width: 119px;"
						onclick="openOpexProjectList(<%=i %>);"><%=TypeUtils.formatCount(allCount[i]) %></div>
					<%} %>
				</div>
		</tr>
		<tr>
			<td style="height: 10px;"></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<div style="width:<%=2+119*8 %>px;">
					<div class='cmcc_phase_moenyTip' style="width: 119px;">预算金额</div>
					<%for(int i=0,j=phaseName.length;i<j;i++){%>
					<div class='cmcc_phase_moenyTip' style="width: 119px;"><%=TypeUtils.xmlEncoderForIE(moneyNames[i]) %>&nbsp;
					</div>
					<%} %>
				</div>
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td style="text-align: center; vertical-align: top">
				<div style="width:<%=2+119*8 %>px;">
					<div class="cmcc_phase_moneyValue" style='width: 119px;'><%=TypeUtils.formatWanMoney(totalMoney) %>&nbsp;
					</div>
					<%for(int i=0,j=phaseName.length;i<j;i++){%>
					<%if(i!=0){
					if(i==3){ %>

					<div class="cmcc_phase_moneyValue" style='width: 119px;'>
						初级：<%=TypeUtils.formatNumber(zhixingDetail.get("初级"), 1) %>人天<br>
						中级：<%=TypeUtils.formatNumber(zhixingDetail.get("中级"), 1) %>人天<br>
						高级：<%=TypeUtils.formatNumber(zhixingDetail.get("高级"), 1) %>人天<br>
						服务：<%=TypeUtils.formatNumber(zhixingDetail.get("服务"), 0) %>次
					</div>

					<%}else{ %>
					<div class="cmcc_phase_moneyValue" style='width: 119px;'><%=TypeUtils.formatWanMoney(allMoney[i]) %>&nbsp;
					</div>
					<%}}else{ %>
					<div class="cmcc_phase_moneyValue" style='width: 119px;'>&nbsp;</div>
					<%} %>
					<%} %>
				</div>
			</td>
		</tr>
		<tr>
			<td style="height: 10px;"></td>
		</tr>
	</table>
	<%String showOpexView=request.getParameter("showOpexView");
if(!"false".equals(showOpexView)){
if(department.getId()==Role.ROOT_DEPARTMENT_ID){ %>
	<span class="openViewButton" onclick="openCaiwu();">OPEX年度视图</span>
	<%}}%>
</div>
<jsp:include page="/WEB-INF/jsp/common/viewChangeTime.jsp">
	<jsp:param name="lastUpdateDIV" value="opexProjectStatusDIVTime" />
</jsp:include>