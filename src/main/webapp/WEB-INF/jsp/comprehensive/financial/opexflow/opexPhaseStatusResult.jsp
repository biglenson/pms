<%-- <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = request.getContextPath();
/* Role department=(Role)request.getAttribute("department"); */
String[] phaseName=OPEXProject.PHASENAMES;
Map<String,Double> zhixingDetail = (Map<String,Double>)request.getAttribute("zhixingDetail");
int[] allCount=(int[])request.getAttribute("allCount");
int totalCount=(Integer)request.getAttribute("totalCount");
double[] allMoney = (double[])request.getAttribute("allMoney");
Double totalMoney = (Double)request.getAttribute("totalMoney");
String[] moneyNames = (String[])request.getAttribute("moneyNames");
%>
<table class="statusTable" style="margin:0 auto;" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td><div class="column1">OPEX项目流程：</div></td>
		<td  class="statusHeader"><div >预算</div></td>
		<%for(int i=0,j=phaseName.length;i<j;i++){   %>
			<td rowspan="4" valign="top" style="border: none;"><div class="nextStep"><%//=i==0?"=":"+" %></div></td>
			<td class="statusHeader"><div><%=phaseName[i] %></div></td>
		<%} %>
	</tr>
	<tr>
		<td  style="border:none;height:10px;"  colspan="<%=2*phaseName.length+2%>"></td>
	</tr>
	<tr>
		<td><div class="column1" >项目总数：</div></td>
		<td ><div class="valueDIV linkURL" onclick="openOpexProjectList(-1);" ><%=TypeUtils.formatCount(totalCount) %></div></td>
		<%for(int i=0,j=phaseName.length;i<j;i++){%>
		<td  ><div class="valueDIV linkURL" onclick="openOpexProjectList(<%=i %>);"  ><%=TypeUtils.formatCount(allCount[i]) %></div></td>
		<%} %>
	</tr>
	<tr>
		<td  style="border:none;height:10px;"  colspan="<%=2*phaseName.length+2%>"></td>
	</tr>
	<tr>
		<td></td>
		<td style="text-align:center;"><div class='moenyTip'>预算金额</div></td>
		<td></td>
		<%for(int i=0,j=phaseName.length;i<j;i++){%>
		<td style="text-align:center;"><div class='moenyTip'><%=TypeUtils.xmlEncoderForIE(moneyNames[i]) %></div></td>
		<td></td>
		<%} %>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td style="text-align:center;"><div><%=TypeUtils.formatWanMoney(totalMoney) %></div></td>
		<td>&nbsp;</td>
		<%for(int i=0,j=phaseName.length;i<j;i++){%>
			<%if(i!=0){
				if(i==3){ %>
				<td style="text-align:center;">
					<div>
						初级：<%=TypeUtils.formatNumber(zhixingDetail.get("初级"), 1) %>人天<br>
						中级：<%=TypeUtils.formatNumber(zhixingDetail.get("中级"), 1) %>人天<br>
						高级：<%=TypeUtils.formatNumber(zhixingDetail.get("高级"), 1) %>人天<br>
						服务：<%=TypeUtils.formatNumber(zhixingDetail.get("服务"), 0) %>次
					</div>
				</td>
			<%}else{ %>
				<td style="text-align:center;"><div><%=TypeUtils.formatWanMoney(allMoney[i]) %></div></td>
			<%}}else{ %>
				<td>&nbsp;</td>
			<%} %>
			<td>&nbsp;</td>
		<%} %>
	</tr>
</table>
<jsp:include page="/WEB-INF/jsp/common/viewChangeTime.jsp">
		<jsp:param  name="lastUpdateDIV" value="caiwu_phaseStatusDIVTimeDIV"/>
	</jsp:include> --%>