<%@ page import="org.apache.commons.io.filefilter.FalseFileFilter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import= "com.zq.commons.utils.UIUtils" %>
<%@ page import= "com.zq.vo.process.BenefitEvalVO" %>
<%
	String path = request.getContextPath();
	//获取基本信息
	BenefitEvalVO benefitEvalInfo = (BenefitEvalVO)request.getAttribute("benefitEvalInfo");
	String dealRslt = (String)request.getAttribute("dealRslt");
	//获取下一步流程评审意见信息（下拉框枚举值）
	Map<String,String> rsltOption = (Map)request.getAttribute("rsltOption");
%>

<script type="text/javascript">

</script>

<div>
<!-- 下一步 -->
<%=UIUtils.togglePanelStart("下一步", true, request)%>
<table style="border:0;align:center;cellpadding:0;cellspacing:0" id="fieldTable" class="formTable">						
	<tbody>
		<tr>
			<td class="label white_background-color"></td>
			<td class="content white_background-color"></td>
			<td class="seperator"></td>
			<td class="label white_background-color"></td>
			<td class="content white_background-color"></td>
		</tr>
		<tr>
			<td class="label">处理人<font class="red">*</font></td>
			<td class="content  " id="creator">
				<div class="content-div" id="content-div-res01" style="cursor: pointer;">
					<input vtype="input" dbfield="assignee" class="text" value="<%=benefitEvalInfo.getAssignee()%>" readonly="" style="cursor: pointer;" type="text">
					<img src="/static/images/benefit/assign_resources.gif" id="div-img-res01" align="absmiddle">
				</div> 
				<script type="text/javascript">
					ET.Utils.addEvent(document.getElementById('content-div-res01'),'click',function(){ 
						var img=document.getElementById('div-img-res01');
						treeSelectUtils.showUserSelect(img.parentElement.children[0],img.parentElement.children[1], 7,69,true); 
					}) 
				</script>
			</td>
		</tr>
		<tr>
			<td colspan="5" height="5"></td>
		</tr>
		<tr>
			<td class="label">处理结果<%=dealRslt%><font class="red">*</font></td>
			<td class="content" id="dealRslt_statustd"> 
				<select vtype="select" dbField="dealRslt">
				<%if("".equals(dealRslt) || dealRslt == null) { %>
					<option value="">--请选择--</option>
					<%for (Map.Entry<String, String> entry : rsltOption.entrySet()) {%>	  
						<option value="<%=entry.getKey()%>"><%=entry.getValue()%></option>
					<%}%>
				<% }else {
					for (Map.Entry<String, String> entry : rsltOption.entrySet()) {
						if(entry.getKey() == dealRslt) { %>
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
				<textarea vtype="textarea" dbfield="dealOpinion" rows="3" cols="20"><%=benefitEvalInfo.getDealOpinion()%></textarea>
			</td>
		</tr>
	</tbody>
</table>
<%=UIUtils.togglePanelEnd(request)%>
</div>