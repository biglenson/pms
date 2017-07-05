<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = request.getContextPath();
double capexMoney=(Double)request.getAttribute("capexMoney");
double opexMoney=(Double)request.getAttribute("opexMoney");
Double totalPercent = (Double)request.getAttribute("percent");
double total = capexMoney + opexMoney;
%>

<div class="sumValue">
	<b><%=TypeUtils.double2String(total)%></b>
</div>
<div
	style='width: 90%; margin: 5px auto; height: 8px; background-color: #E8E9ED;'>
	<%
		Integer capexPercent = 0;
		Integer opexPercent = 0;
		if(total != 0){
			Double percent = capexMoney/total*100;
			capexPercent = percent.intValue();
			if(capexPercent > 100){
				capexPercent = 100;
			}
			opexPercent = 100 - capexPercent;
		}
	%>
	<div
		style='float:left;height:100%;width:<%=capexPercent%>%;background-color:#0ACC4B;''></div>
	<div
		style='float:left;height:100%;width:<%=opexPercent%>%;background-color:#fe902c;''></div>
</div>
<div style='width: 90%; margin: 10px auto;'>
	<table style='width: 100%;'>
		<tr>
			<td width="50%" class='tipSpan'
				style="text-align: center; border-right: #E8E9ED solid 1px; padding-left: 5px;"><span>CAPEX</span><br>
			<span class="tipSpan2"><%=TypeUtils.double2String(capexMoney)%></span></td>
			<td width="50%" class='tipSpan'
				style="text-align: center; padding-left: 5px;"><span>OPEX</span><br>
			<span class="tipSpan2"><%=TypeUtils.double2String(opexMoney)%></span></td>
		</tr>
	</table>
</div>
<div
	style='width: 100%; margin: 25px auto; height: 1px; background-color: #D9D9D9;'></div>
<div style='width: 90%; margin: 10px auto;'>
	<table style='width: 100%;'>
		<tr>
			<td width="55%" align="center"
				style="font-size: 18px; font-weight: bold;">成本占收比：</td>
			<td align="center" style="font-size: 24px; font-weight: bold;"><%=totalPercent!=null?TypeUtils.double2String(totalPercent):"0.00" %>%</td>
		</tr>
	</table>
</div>
<jsp:include page="/WEB-INF/jsp/common/viewChangeTime.jsp">
	<jsp:param name="lastUpdateDIV" value="caiwutouziyusuanTimeDIV" />
</jsp:include>
