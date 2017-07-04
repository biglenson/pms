<%@page import="com.easytrack.customization.cmcc.action.FormBaseResove"%>
<%@page import="com.easytrack.commons.util.TypeUtils"%>
<%@page import="com.easytrack.component.ComponentFactory"%>
<%@page import="com.easytrack.customization.cmcc.bean.CAPEXProject"%>
<%@page import="com.easytrack.component.profile.*"%>
<%@page import="com.easytrack.platform.ui.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
SessionManager webMgr = new SessionManager();
webMgr.init(session);
User user = webMgr.getCurrentUser();
Locale locale = webMgr.getCurrentLocale();
String[] phaseName=CAPEXProject.PHASENAMES;



int[] allCount=(int[])request.getAttribute("allCount");
int[] newCount=(int[])request.getAttribute("newCount");
int totalCount=(Integer)request.getAttribute("totalCount");
int newTotalCount=(Integer)request.getAttribute("newTotalCount");
%>
<table class="statusTable" style="margin:0 auto;" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td><div class="column1">CAPEX项目流程:</div></td>
		<td  class="statusHeader"><div >投资计划</div></td>
		
		<%for(int i=0,j=phaseName.length;i<j;i++){   %>
			<td rowspan="4" valign="top" style="border: none;"><div class="fouHao"><%//=i==0?"=":"+" %></div></td>
			<td class="statusHeader"><div  class="touzi"><%=phaseName[i] %></div></td>
		<%} %>
	</tr>
	<tr>
		<td  style="border:none;height:10px;"  colspan="<%=2*phaseName.length+2%>"></td>
	</tr>
	<tr>
		<td><div class="column1" >项目总数</div></td>
		<td ><div class="valueDIV linkURL" onclick="openCapexProjectList(-1,0)" ><%=FormBaseResove.formatCount(totalCount) %></div></td>
		<%for(int i=0,j=phaseName.length;i<j;i++){%>
		<td  ><div class="valueDIV linkURL" onclick="openCapexProjectList(<%=i %>,0)" ><%=FormBaseResove.formatCount(allCount[i]) %></div></td>
		<%} %>
	</tr>
	<tr>
		<td><div class="column1" >新建项目数</div></td>
		<td ><div class="valueDIV2 linkURL" onclick="openCapexProjectList(-1,1)" ><%=FormBaseResove.formatCount(newTotalCount) %></div></td>
		<%for(int i=0,j=phaseName.length;i<j;i++){%>
		<td ><div class="valueDIV2 linkURL" onclick="openCapexProjectList(<%=i %>,1);" ><%=FormBaseResove.formatCount(newCount[i]) %></div></td>
		<%} %>
	</tr>
	<tr>
		<td  style="border:none;height:10px;"  colspan="<%=2*phaseName.length+2%>"></td>
	</tr>
	<%String[]moneyName={"投资计划金额",null,"立项决策总金额","合同不含税总金额","设计批复金额"}; 
	 double[] moneyDouble=(double[])request.getAttribute("moneyDouble"); %>
	<tr>
		<td></td>
		<%for(String s:moneyName){ %>
		<td><div class='moenyTip'><%=s!=null?s:"&nbsp;"%></div></td>
		<td></td>
		<%} %>
	</tr>
	<tr>
		<td></td>
		<%for(int i=0,j=moneyName.length;i<j;i++ ){
			String s=moneyName[i];
			Double v=s!=null?moneyDouble[i]:null;
		%>
		<td  style="text-align:center;"><div ><%=FormBaseResove.formatWanMoney(v,"")%></div></td>
		<td></td>
		<%} %>
	</tr>
</table>
<jsp:include page="/jsp/viewChangeTime.jsp">
		<jsp:param  name="lastUpdateDIV" value="gongcheng_phaseStatusDIVTimeDIV"/>
	</jsp:include>