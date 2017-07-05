<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = request.getContextPath();
Double totalMoney = (Double)request.getAttribute("totalMoney");
Double capexPlanMoney = (Double)request.getAttribute("capexPlanMoney");
Double opexPlanMoney = (Double)request.getAttribute("opexPlanMoney");
Double capexActualMoney = (Double)request.getAttribute("capexActualMoney");
Double opexActualMoney = (Double)request.getAttribute("opexActualMoney");
%>
<div class="totalDIV">
	合计采购节约成本:&nbsp;<b class="moneySize"
		style="color: <%=totalMoney<0?"#fe5151":"#46c6f0"%>;"><%=TypeUtils.double2String(-totalMoney/10000) %></b>&nbsp;
</div>
<div style="height: 132px; width: 100%; border: none;">
	<table style="border: none; width: 100%;">
		<tr>
			<td width="15%" align="right"><div>&nbsp;</div></td>
			<td width="35%"><div style="margin-left: 8px;">
					CAPEX采购节约成本:&nbsp;<b class="moneySize"
						style="color: <%=(capexPlanMoney-capexActualMoney)<0?"#fe5151":"#46c6f0"%>;"><%=TypeUtils.double2String(-(capexPlanMoney-capexActualMoney)/10000) %></b>&nbsp;
				</div></td>
			<td width="15%" align="right"><div>&nbsp;</div></td>
			<td width="35%"><div style="margin-left: 8px;">
					OPEX采购节约成本:&nbsp;<b class="moneySize"
						style="color: <%=(opexPlanMoney-opexActualMoney)<0?"#fe5151":"#46c6f0"%>;"><%=TypeUtils.double2String(-(opexPlanMoney-opexActualMoney)/10000) %></b>&nbsp;
				</div></td>
		</tr>
		<tr>
			<td width="15%" align="right"><div>计划</div></td>
			<td width="35%">
				<div>
					<div class="colorDIV"
						style="width: 240px; background-color: #46c6f0;" />
					<div class="colorDIV"><%=TypeUtils.double2String(capexPlanMoney/10000) %>&nbsp;
					</div>
				</div>
			</td>
			<td width="15%" align="right"><div>计划</div></td>
			<td width="35%">
				<div>
					<div class="colorDIV"
						style="width: 240px; background-color: #46c6f0;" />
					<div class="colorDIV"><%=TypeUtils.double2String(opexPlanMoney/10000) %>&nbsp;
					</div>
				</div>
			</td>
		</tr>
		<tr>
			<td width="15%" align="right"><div>实际</div></td>
			<td width="35%">
				<div>
					<%
						Double capexDivWidth = (capexActualMoney/capexPlanMoney*240);
					%>
					<div class="colorDIV"
						style="width: <%=capexDivWidth>240?240:capexDivWidth %>px;background-color: <%=capexActualMoney<capexPlanMoney?"#a8da72":"#fe5151" %>;" />
					<div class="colorDIV"><%=TypeUtils.double2String(capexActualMoney/10000) %>&nbsp;
					</div>
				</div>
			</td>
			<td width="15%" align="right"><div>实际</div></td>
			<td width="35%">
				<div>
					<%
						Double opexDivWidth = (opexActualMoney/opexPlanMoney*240);
					%>
					<div class="colorDIV"
						style="width: <%=opexDivWidth>240?240:opexDivWidth %>px;background-color: <%=opexActualMoney<opexPlanMoney?"#a8da72":"#fe5151" %>;" />
					<div class="colorDIV"><%=TypeUtils.double2String(opexActualMoney/10000) %>&nbsp;
					</div>
				</div>
			</td>
		</tr>
	</table>
	<div class="tabMore linkURL" style="margin-top: 20px;"
		onclick="openjieyuechengbenDetail()">更多详情</div>
</div>
<jsp:include page="/WEB-INF/jsp/common/viewChangeTime.jsp">
	<jsp:param name="lastUpdateDIV" value="costsavingInfoDIVTimeDIV" />
</jsp:include>