<%@page import="com.zq.commons.utils.TypeUtils"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
double totalPlanCostValue=(Double)request.getAttribute("totalPlanCostValue");
double totalActualCostValue=(Double)request.getAttribute("totalActualCostValue");
Map<Integer,Double> kemuMoney = (Map<Integer,Double>)request.getAttribute("kemuMoney");
List<Map.Entry<Integer, String>> sortList = (List<Map.Entry<Integer, String>>)request.getAttribute("sortList");
%>
					
	<div  class="sumValue" style="color:<%=(totalActualCostValue>totalPlanCostValue)?"#BF100F":"#0ACC4B" %>" >
		<b><%=TypeUtils.formatWanMoney(totalActualCostValue) %></b>&nbsp;
	</div>
	<div style='width:90%;margin:3px auto;height:8px;background-color:#E8E9ED;'>
	<%Double percent=totalPlanCostValue!=0?totalActualCostValue/totalPlanCostValue*100:0; %>
		<div style=' height:100%;width:<%=totalPlanCostValue!=0?percent.intValue()>100?100:percent.intValue():0%>%;background-color:<%=(totalActualCostValue>totalPlanCostValue)?"#BF100F":"#0ACC4B" %>;''></div>
	</div>
	<div style='width:90%;margin:5px auto;'>
		<table style='width:100%;'>
			<tr>
				<td width="60%" class='tipSpan' style="text-align: left;"><span>计划值&nbsp;:</span></td>
				<td width="40%" align="right"><span class="tipSpan2"><%=TypeUtils.formatWanMoney(totalPlanCostValue)%></span></td>
			</tr>
			<tr>
				<td class='tipSpan' style="text-align: left;"><span> 完成比例&nbsp;:</span></td>
				<td align="right"><span class="tipSpan2"><%=percent!=null?TypeUtils.double2String(percent):"0.00"%>%</span></td>
			</tr>
		</table>						
	</div>
	<div style='width:90%;margin:2px auto;height:1px;background-color:#E8E9ED;'></div>	
	<div style='width:90%;margin:5px auto;'>
		<table style='width:100%;'>
			<%
				for(Map.Entry<Integer, String> entryKemu : sortList){
			%>
				<tr>
					<td width="60%" class='tipSpan' style="text-align: left;"><span><%=entryKemu.getValue() %>&nbsp;:</span></td>
					<td width="40%" align="right"><span class="tipSpan2"><%=TypeUtils.formatWanMoney(kemuMoney.get(entryKemu.getKey()))%></span></td>
				</tr>
			<%} %>
		</table>						
	</div>
	<jsp:include page="/WEB-INF/jsp/common/viewChangeTime.jsp">
		<jsp:param  name="lastUpdateDIV" value="caiwuchengbenTimeDIV"/>
	</jsp:include>