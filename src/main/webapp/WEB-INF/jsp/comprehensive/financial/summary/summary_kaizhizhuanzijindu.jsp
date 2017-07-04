<%@page import="com.zq.commons.utils.TypeUtils"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
double kaizhiTotal=(Double)request.getAttribute("kaizhiTotal");
double kaizhiActual=(Double)request.getAttribute("kaizhiActual");
Double kaizhiPerCenter=kaizhiTotal!=0?kaizhiActual/kaizhiTotal*100:0;
kaizhiPerCenter = kaizhiPerCenter>100?100:kaizhiPerCenter;

double opexPlan=(Double)request.getAttribute("opexPlan");
double opexActual=(Double)request.getAttribute("opexActual");
Double opexPerCenter=opexPlan!=0?opexActual/opexPlan*100:0;
opexPerCenter = opexPerCenter>100?100:opexPerCenter;

double zhuanziTotal=(Double)request.getAttribute("zhuanziTotal");
double zhuanziActual=(Double)request.getAttribute("zhuanziActual");
Double zhuanziPerCenter=zhuanziTotal!=0?zhuanziActual/zhuanziTotal*100:0;
zhuanziPerCenter = zhuanziPerCenter>100?100:zhuanziPerCenter;
%>
<table style="width: 90%;margin: 0 auto;height:100%">
	<tr>
		<td width="60%">
			<div style="line-height: 23px;">资本开支实际&nbsp;:</div>
		</td>
		<td width="40%" align="right">
			<b style="font-size: 14px;"><%=TypeUtils.formatWanMoney(kaizhiActual) %></b>
		</td>
	</tr>
	<tr style="border-bottom: 1px solid  #D9D9D9;">
		<td>
			<div style='height:8px;background-color:#E8E9ED;'>
				<div style='height:100%;width:<%=kaizhiPerCenter%>%;background-color:#0ACC4B;''></div>
			</div>
		</td>
		<td align="right">
			<div style="color:#0ACC4B;"><b style="font-size: 14px;"><%=TypeUtils.formatNumber(kaizhiPerCenter, 2) %>%</b></div>
		</td>
	</tr>
	<tr>
		<td>
			<div style="line-height: 23px;">转资实际&nbsp;:</div>
		</td>
		<td align="right">
			<b style="font-size: 14px;"><%=TypeUtils.formatWanMoney(zhuanziActual) %></b>
		</td>
	</tr>
	<tr style="border-bottom: 1px solid  #D9D9D9;">
		<td>
			<div style='height:8px;background-color:#E8E9ED;'>
				<div style='height:100%;width:<%=zhuanziPerCenter%>%;background-color:#0ACC4B;''></div>
			</div>
		</td>
		<td align="right">
			<div style="color:#0ACC4B;"><b style="font-size: 14px;"><%=TypeUtils.formatNumber(zhuanziPerCenter, 2) %>%</b></div>
		</td>
	</tr>
	<tr>
		<td>
			<div style="line-height: 23px;">成本开支实际&nbsp;:</div>
		</td>
		<td align="right">
			<b style="font-size: 14px;"><%=TypeUtils.formatWanMoney(opexActual) %></b>
		</td>
	</tr>
	<tr>
		<td>
			<div style='height:8px;background-color:#E8E9ED;'>
				<div style='height:100%;width:<%=opexPerCenter%>%;background-color:#0ACC4B;''></div>
			</div>
		</td>
		<td align="right">
			<div style="color:#0ACC4B;"><b style="font-size: 14px;"><%=TypeUtils.formatNumber(opexPerCenter, 2) %>%</b></div>
		</td>
	</tr>
</table>
<jsp:include page="/WEB-INF/jsp/common/viewChangeTime.jsp">
		<jsp:param  name="lastUpdateDIV" value="caiwukaizhizhuanziTimeDIV"/>
	</jsp:include>

