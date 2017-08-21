<%@ page import="org.apache.commons.io.filefilter.FalseFileFilter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import= "com.zq.commons.utils.UIUtils" %>
<%
	String path = request.getContextPath();
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
					<input vtype="input" dbfield="deal" class="text" value="admin" readonly="" style="cursor: pointer;" type="text">
					<img src="/static/images/benefit/assign_resources.gif" id="div-img-res01" align="absmiddle">
				</div> 
				<script type="text/javascript">
					ET.Utils.addEvent(document.getElementById('content-div-res01'),'click',function(){ 
						var img=document.getElementById('div-img-res01');
						treeSelectUtils.showUserSelect(img.parentElement.children[0],img.parentElement.children[1], 7,69,true); 
					}) 
				</script>
			</td>
			<td class="seperator"></td>
			<td class="label">处理时间</td>
			<td class="content " id="date01td">
				<div class="content-line" id="content-div-date01"> 
					<input vtype="input" dbfield="dealTime" class="text" value="" type="hidden">
					系统带入
				</div>  
			</td>
		</tr>
		<tr>
			<td colspan="5" height="5"></td>
		</tr>
		<tr>
			<td class="label">处理意见</td>
			<td class="content" id="evalCode"> 
				<textarea rows="3" cols="20"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="5" height="5"></td>
		</tr>
		<tr>
			<td class="label">处理结果</td>
			<td colspan="4" class="content" id="titletd">
				<textarea style="border: 1px solid #D4D4D4" disabled="disabled" readonly="readonly" placeholder=""></textarea>
			</td>
		</tr>
	</tbody>
</table>
<%=UIUtils.togglePanelEnd(request)%>
</div>