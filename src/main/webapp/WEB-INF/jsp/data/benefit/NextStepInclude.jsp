<%@ page import="org.apache.commons.io.filefilter.FalseFileFilter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import= "com.zq.commons.utils.UIUtils" %>
<%@ page import="com.zq.commons.utils.TypeUtils" %>
<%@ page import= "com.zq.vo.process.BenefitEvalVO" %>
<%
	String path = request.getContextPath();
	//获取基本信息
	BenefitEvalVO benefitEvalInfo = (BenefitEvalVO)request.getAttribute("benefitEvalInfo");
	String dealRslt = benefitEvalInfo.getDealRslt();
	//获取下一步流程评审意见信息（下拉框枚举值）
	Map<String,String> rsltOption = (Map)request.getAttribute("rsltOption");
%>

<div>
<!-- 下一步 -->
<%=UIUtils.togglePanelStart("下一步", true, request)%>
<table style="border:0;align:center;cellpadding:0;cellspacing:0" id="fieldTable" class="formTable">						
	<tbody>
		<tr>
			<td class="label white_background-color"></td>
			<td class="content white_background-color"></td>
			<td class="seperator">
			<%if("提出人创建编辑评估".equals(benefitEvalInfo.getTaskName())) { %>
				<input type="hidden" vtype="input" dbField="dealRslt" value="1"/>
				<input type="hidden" vtype="input" dbField="rsltDesc" value="提交"/>
				<input type="hidden" vtype="textarea" dbfield="dealOpinion" value=""/>
			<%} %>
			</td>
			<td class="label white_background-color"></td>
			<td class="content white_background-color"></td>
		</tr>
		<tr>
			<td class="label">处理人<font class="red">*</font></td>
			<td class="content  " id="creator">
				<div class="content-div" id="content-div-res01" style="cursor: pointer;">
					<input vtype="input" dbfield="assignee" id="operator_del" class="text" value="<%=TypeUtils.nullToString(benefitEvalInfo.getAssignee())%>" readonly="" style="cursor: pointer;" type="text">
					<img src="/static/images/benefit/assign_resources.gif" id="div-img-res01" align="absmiddle">
				</div> 
				<script type="text/javascript">
				//选择联系人
				ET.Utils.addEvent(document.getElementById('content-div-res01'), 'click', function() { 
					var arg=new Array();
					var scorecardType = 0;
					arg.src = "<%=path%>/datamap/getUserList?_id=" + Math.random();
					arg.title = '选择联系人';
					arg.width = 400;
					arg.theme = "search";
					arg.height = 310;
					parent.ET.showModalWindow(arg, function (ret) { 
						console.log('返回值结果：  ' + ret);
						console.log('===========测试中！======================>用户已经选定下一步处理人----');
						//设置选中的下一步处理人
						if (ret) {
							document.getElementById('operator_del').value = ret;
						}
					});
				}) 
				</script>
			</td>
		</tr>
		<%if(!"提出人创建编辑评估".equals(benefitEvalInfo.getTaskName())) { %>
		<tr>
			<td colspan="5" height="5"></td>
		</tr>
		<tr>
			<td class="label">处理结果<font class="red">*</font></td>
			<td class="content" id="dealRslt_statustd"> 
				<select vtype="select" dbField="dealRslt" id="next-step-select">
				<%if("".equals(dealRslt) || dealRslt == null) { %>
					<option value="">--请选择--</option>
					<%for (Map.Entry<String, String> entry : rsltOption.entrySet()) {%>	  
						<option value="<%=entry.getKey()%>"><%=entry.getValue()%></option>
					<%}%>
				<% }else {
					for (Map.Entry<String, String> entry : rsltOption.entrySet()) {
						if(entry.getKey().equals(dealRslt)) { %>
							<option value="<%=entry.getKey()%>" selected="selected"><%=entry.getValue()%></option>
					<% 	}else { %>
							<option value="<%=entry.getKey()%>"><%=entry.getValue()%></option>
					<%	}
					}%>
				<%} %>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="5" height="5"></td>
		</tr>
		<tr>
			<td class="label">处理意见</td>
			<td class="content" id="evalCode"> 
				<textarea vtype="textarea" dbfield="dealOpinion" rows="3" cols="20"><%=TypeUtils.nullToString(benefitEvalInfo.getDealOpinion())%></textarea>
			</td>
		</tr>
		<%} %>
	</tbody>
</table>
<%=UIUtils.togglePanelEnd(request)%>
</div>