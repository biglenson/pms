<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>

<%
Map<Integer,Double> departmentYusuan=(Map<Integer,Double>)request.getAttribute("departmentYusuan");
Map<Integer,Double> departmentActualYusuan=(Map<Integer,Double>)request.getAttribute("departmentActualYusuan");
Map<Integer,Double> departmentYujiYusuan=(Map<Integer,Double>)request.getAttribute("departmentYujiYusuan");
/* List<Role> departmentList=(List<Role>)request.getAttribute("departmentList"); */
%>
<div class="tabContent">
<div style="text-align:right">
	<div class="showHelpe" onclick="showTips(this,'caiwuYusuanDepartTipNameDIV')"></div>
</div>
<div class="helpFloatDIV" id="caiwuYusuanDepartTipNameDIV" style="line-height: 22px;">
	<div class="showHelpeContent" style="line-height: 23px;">
		<div>完成进度：预算完成/全年预算</div>
		<div>计划进度：截止本月全年计划开支总额/全年预算</div>
		<div>执行偏差：完成进度-计划进度</div>
	</div>
</div>
<div style="height:250px;overflow: auto;">
	<table id="yusuanzhixingDepartDetailTable" class="listTable"  cellpadding="0" cellspacing="0" border="0">
		<thead>
			<tr>
				<th width="100%"><div style='width:100%'>部门</div></th>
				<th><div style='width:150px'>全年预算</div></th>
				<th><div style='width:150px'>预算完成</div></th>
				<th><div style='width:150px'>完成进度</div></th>
				<th><div style='width:150px'>计划进度</div></th>
				<th><div style='width:150px'>执行偏差</div></th>
			</tr>
		</thead>
		<%-- <tbody>
			<%for(Role department : departmentList){
				Integer departID = department.getId();
				Double yusuanMoney = departmentYusuan.get(departID);
				Double actualYusuanMoney = departmentActualYusuan.get(departID);
				Double finishjindu = actualYusuanMoney/yusuanMoney*100;
				Double yujiYusuanMoney = departmentYujiYusuan.get(departID);
				Double jihuajindu = yujiYusuanMoney/yusuanMoney*100;
				if(yusuanMoney == 0){
					finishjindu = 0d;
					jihuajindu = 0d;
				}
			%>
				<tr>
					<td align="center"><div class="nowrapText linkURL" onclick="openDepartmentView(<%=department.getId()%>)"><%=TypeUtils.xmlEncoderForIE(department.getName())%></div></td>
					<td align="center"><%=FormBaseResove.formatWanMoney(yusuanMoney)%></td>
					<td align="center"><%=FormBaseResove.formatWanMoney(actualYusuanMoney)%></td>
					<td align="center"><%=TypeUtils.formatNumber(finishjindu, 2)%>%</td>
					<td align="center"><%=TypeUtils.formatNumber(jihuajindu, 2)%>%</td>
					<td align="center"><%=TypeUtils.formatNumber(finishjindu-jihuajindu, 2)%>%</td>
				</tr>
			<%}if(departmentList.size() == 0){ %>
				<tr>
					<td colspan="6" style="padding-left:100px;"> 暂无数据</td>
				</tr>
			<%} %>
		</tbody> --%>
	</table>
</div>
</div>
<script type="text/javascript">
	window.projectResultTableObj=new EasyTrack.DataTable("yusuanzhixingDepartDetailTable",{
		autoHeight:false
	})
</script>
