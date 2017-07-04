<%@page import="com.zq.commons.utils.TypeUtils"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
double totalPlanValue=(Double)request.getAttribute("totalPlanValue");
double totalActualValue=(Double)request.getAttribute("totalActualValue");
Map<Integer,Double> typeShouruMap = (Map<Integer,Double>)request.getAttribute("typeShouruMap");
Map<Integer,String> categoryNames = (Map<Integer,String>)request.getAttribute("categoryNames");
%>
<div style="position: relative;">				
	<div  class="sumValue" style="color:<%=(totalActualValue>totalPlanValue)?"#BF100F":"#0ACC4B" %>" >
		<b><%=TypeUtils.formatWanMoney(totalActualValue) %></b>&nbsp;
	</div>
	<div style='width:90%;margin:3px auto;height:8px;background-color:#E8E9ED;'>
	<%Double percent=totalActualValue/totalPlanValue*100; %>
		<div style=' height:100%;width:<%=totalPlanValue!=0?percent.intValue()>100?100:percent.intValue():0%>%;background-color:<%=(totalActualValue>totalPlanValue)?"#BF100F":"#0ACC4B" %>;''></div>
	</div>
	<div style='width:90%;margin:5px auto;height:70%'>
		<table style='width:100%;height:100%;'>
			<tr>
				<td width="40%" class='tipSpan' align="left"><span>计划值&nbsp;:</span></td>
				<td width="60%" align="right"><span class="tipSpan2"><%=TypeUtils.formatWanMoney(totalPlanValue)%></span></td>
			</tr>
			<tr>
				<td class='tipSpan'><span>完成比例&nbsp;:</span></td>
				<td align="right"><span class="tipSpan2"><%=percent!=null?TypeUtils.double2String(percent):"0.00"%>%</span></td>
			</tr>
		</table>						
	</div>
	<div style='width:90%;margin:2px auto;height:1px;background-color:#E8E9ED;'></div>	
	<div style='width:90%;margin:15px auto;'>
		<table style='width:100%;'>
			<%Set<Integer> keySet =  categoryNames.keySet();
				for(Integer categoryId : keySet){
			%>
				<tr>
					<td width="40%" class='tipSpan' align="left"><span><%=categoryNames.get(categoryId) %>&nbsp;:</span></td>
					<td width="60%" align="right"><span class="tipSpan2"><%=TypeUtils.formatWanMoney(typeShouruMap.get(categoryId))%></span></td>
				</tr>
			<%} %>
		</table>						
	</div>
	<div style="position:absolute;right:-5px; top:-5px;" >
		<div class="showHelpe" onclick="showSummaryShouRuTip(this)"></div>
	</div>
	<div class="helpFloatDIV" id="showSummaryShouRuTipDIV" style="line-height: 22px;">
		<div class="showHelpeContent" style="line-height: 23px;max-width:700px;">
			<div>本年分公司真实收入：取自分公司财务报表的收入，包括以下四类。<br>
			销售支撑收入：政企分公司直接签约销售全网产品与省公司产品，销售收入全额结算给省公司，省公司从成本中支出销售收入的5%作为销售支撑费结算给政企。<br>
			运营支撑收入：政企分公司面向省公司提供涉及全网集中运营产品（需总部认定）、重点项目（如双跨IMS、行业WLAN、视频监控、和对讲(POC)、云MAS等）的统一运营支撑，省公司从成本中支出运营支撑费结算给政企。<br>
			产品销售收入：政企签约销售政企自有产品，政企分公司100%确认收入，使用省公司/其他公司（铁通、国际公司等）资源的部分，从分公司成本中支出资源成本价给相关单位。<br>
			产品合作收入：省公司签约销售政企自有产品，各省按照结算方案采取收入分成或成本结算模式结算给政企（不同产品具体结算方案不一样）</div>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/jsp/common/viewChangeTime.jsp">
		<jsp:param  name="lastUpdateDIV" value="caiwushouruTimeDIV"/>
	</jsp:include>