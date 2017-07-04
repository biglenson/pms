<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = request.getContextPath();
String[] phaseName=CAPEXProject.PHASENAMES;
Role department=(Role)request.getAttribute("department");
int[] allCount=(int[])request.getAttribute("allCount");
int[] newCount=(int[])request.getAttribute("newCount");
int totalCount=(Integer)request.getAttribute("totalCount");
int newTotalCount=(Integer)request.getAttribute("newTotalCount");
%>
<div>
<table class="statusTable" style="margin:0 auto;" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td style="vertical-align: top;"><div class="cmcc_phase_column" style="font-weight: bold;">CAPEX项目流程:</div></td>
		<td >
			<div style="padding-bottom:20px;"><img src="<%=path %>/images/cmcc/liucheng.png"></div>
		</td>
	</tr>
	
	<tr>
		<td><div class="cmcc_phase_column" >项目总数</div></td>
		<td>
			<div class="cmcc_phase_kuang" style="width:<%=2+103*8 %>px;">
				<div class="cmcc_phase_valueDIV linkURL" onclick="openCapexProjectList(-1,0);" ><%=TypeUtils.formatCount(totalCount) %></div>
				<%for(int i=0,j=phaseName.length;i<j;i++){%>
				<div class="cmcc_phase_valueDIV linkURL" onclick="openCapexProjectList(<%=i %>,0);" ><%=TypeUtils.formatCount(allCount[i]) %></div>
				<%} %>
				<div style="clear: both;"></div>
			</div>
		</td>
	</tr>
	<tr><td style="height:10px;"></td></tr>
	<tr>
		<td><div class="cmcc_phase_column" >新建项目数</div></td>
		<td >
		<div class="cmcc_phase_kuang" style="width:<%=2+103*8 %>px;">
			<div class="cmcc_phase_valueDIV linkURL" onclick="openCapexProjectList(-1,1);"><%=TypeUtils.formatCount(newTotalCount) %></div>
			<%for(int i=0,j=phaseName.length;i<j;i++){%>
				<div class="cmcc_phase_valueDIV linkURL"  onclick="openCapexProjectList(<%=i %>,1);"><%=TypeUtils.formatCount(newCount[i]) %></div>
			<%} %>
			<div style="clear: both;"></div>
		</td>
	</tr>
	<tr><td style="height:10px;"></td></tr>
	<%
		String[]moneyName={"投资计划金额",null,"立项决策总金额","合同不含税总金额","设计批复金额"}; 
	 	double[] moneyDouble=(double[])request.getAttribute("moneyDouble"); %>
	<tr>
		<td></td>
		<td>
			<div style="width:<%=2+103*8 %>px;">
				<%for(String s:moneyName){ %>
				<div class='cmcc_phase_moenyTip'><%=s!=null?s:"&nbsp;"%></div>
				<%} %>
				<div style="clear: both;"></div>
			</div>
		</td>
	</tr>
	<tr>
		<td> 
			&nbsp;&nbsp;
		</td>
		<td ><div style="width:<%=2+103*8 %>px;">
			<%for(int i=0,j=moneyName.length;i<j;i++ ){
				String s=moneyName[i];
				Double v=s!=null?moneyDouble[i]:null;
				%>
				<div class="cmcc_phase_moneyValue" ><%=TypeUtils.formatWanMoney(v, "")%>&nbsp;</div>
			<%} %>
			<div style="clear: both;"></div>
		</div></td>
	</tr>
	<tr><td style="height:10px;"></td></tr>
</table>
<%
String showCapexView=request.getParameter("showCapexView");
if(!"false".equals(showCapexView)){
	if(department.getId()==Role.ROOT_DEPARTMENT_ID){ %>
	<span class="openViewButton"  onclick="openGongCheng();" >CAPEX年度视图</span>
<%}}%>
</div>
<jsp:include page="/WEB-INF/jsp/common/viewChangeTime.jsp">
		<jsp:param  name="lastUpdateDIV" value="capex_phaseStatusDIVTimeDIV"/>
	</jsp:include>