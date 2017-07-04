<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = request.getContextPath();
Integer index = (Integer)request.getAttribute("index");
%>
<%if(index==0){
	Map<String,Integer> overtimeData = (Map<String,Integer>)request.getAttribute("contractOvertimeData");
%>
<div style="height:100%;width: 100%;border: none;">
	<table style="border: none;width: 100%;">
		<%
			int widthDIV = 380;
			int firstDays = 0;
			int count = 0;
			for(String name : overtimeData.keySet()){
				Integer days = overtimeData.get(name);
				count++;
				if(count == 1){
					firstDays = days;
				}
				double percent = days*1.0/firstDays;
				if(percent > 1){
					percent = 1;
				}
		%>
			<tr height="20px;">
				<td><div style="width: 480px;line-height: 20px;margin: 0px 8px;" class="nowrapText" title="<%=TypeUtils.xmlEncoderForIE(name) %>"><%=TypeUtils.xmlEncoderForIE(name) %></div></td>
			</tr>
			<tr height="20px;">
				<td width="100%">
					<div>
						<div class="colorDIV" style="margin:2px 8px;background-color:#fe5151;width: <%=percent*widthDIV%>px;"/>
						<div>采购周期&nbsp;<%=days %>&nbsp;天</div>
					</div>
				</td>
			</tr>
		<%} %>
		<%if(overtimeData.size() == 0){ %>
			<tr><td colspan="2" style="padding-left:10px">暂无数据</td></tr>
		<%} %>
	</table>
</div>
<jsp:include page="/WEB-INF/jsp/common/viewChangeTime.jsp">
		<jsp:param  name="lastUpdateDIV" value="contract_overtimeDIVTimeDIV"/>
	</jsp:include>
<%}else if(index==1){
	Map<String,Integer> overtimeSoonData = (Map<String,Integer>)request.getAttribute("contractOvertimeSoonData");
%>
<div style="height:100%;width: 100%;border: none;">
	<table style="border: none;width: 100%;">
		<%
			int widthDIV = 380;
			int firstDays = 0;
			int count = 0;
			for(String name : overtimeSoonData.keySet()){
				Integer days = overtimeSoonData.get(name);
				count++;
				if(count == 1){
					firstDays = days;
				}
				double percent = days*1.0/firstDays;
				if(percent > 1){
					percent = 1;
				}
		%>
			<tr height="20px;">
				<td><div style="width: 480px;line-height: 20px;margin: 0px 8px;" class="nowrapText" title="<%=TypeUtils.xmlEncoderForIE(name) %>"><%=TypeUtils.xmlEncoderForIE(name) %></div></td>
			</tr>
			<tr height="20px;">
				<td width="100%">
					<div>
						<div class="colorDIV" style="margin:2px 8px;background-color:#fee485;width: <%=percent*widthDIV%>px;"/>
						<div>目前采购周期&nbsp;<%=days %>&nbsp;天</div>
					</div>
				</td>
			</tr>
		<%} %>
		<%if(overtimeSoonData.size() == 0){ %>
			<tr><td colspan="2" style="padding-left:10px">暂无数据</td></tr>
		<%} %>
	</table>
</div>
<jsp:include page="/WEB-INF/jsp/common/viewChangeTime.jsp">
		<jsp:param  name="lastUpdateDIV" value="contract_overtimesoonDIVTimeDIV"/>
	</jsp:include>
<%} %>
