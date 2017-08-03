<%@page import="org.apache.commons.io.filefilter.FalseFileFilter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import= "com.zq.commons.utils.UIUtils" %>
<%@ page import= "com.zq.commons.result.PageInfo" %>
<%
	String path = request.getContextPath();
	String pageTitle = (String)request.getAttribute("pageTitle");
	Integer appid = (Integer)request.getAttribute("appid");
	Long pid = (Long)request.getAttribute("pid");
	String url = (String)request.getAttribute("url");
	PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	boolean isMulti = false;
%>

<script type="text/javascript">

</script>

<%-- 输出Head1模块 --%>
<jsp:include page="../../common/Head1.jsp" />

<!-- 内容主体 -->
<form name="frm" onsubmit="return false;">
<input type="hidden" name="idField" value="">
<table border="0" cellpadding="0" cellspacing="0" style='margin:0px auto;'>
	<tr>
		<td><div style='width:202px;'></div></td>
		<td><div style='width:10px;'></div></td>
		<td><div style='width:150px;'></div></td>
		<%if(isMulti){ %>
		<td><div style='width:59px;'></div></td>
		<td><div style='width:150px;'></div></td>
		<%} %>
	</tr>
	<%-- <tr>
		<%if (roleType == Role.RESOURCE_TEAM) {%>
			<td align="left" nowrap valign="bottom"><%=MessageUtils.getMessage(locale,"resourceTeam")%>:</td>
			<td>&nbsp;</td>
			<%if (isMulti) {%>
				<td align="left" nowrap valign="bottom"><bean:message key="notAllocatedResource" />:</td>
				<td>&nbsp;</td>
				<td align="left" nowrap valign="bottom"><bean:message key="allocatedResource" />:</td>
			<%} else {%>
				<td align="left" valign="bottom"><bean:message key="resouce" />:</td>
			<%}%>
		<%} else {%>
			<td align="left" nowrap valign="bottom"><%=isShowContact ? MessageUtils.getMessage(locale,"frequentContact") + "/"+ MessageUtils.getMessage(locale,"department") : MessageUtils.getMessage(locale,"department")%>:</td>
			<td></td>
			<%if (isMulti) {%>
				<td align="left" nowrap valign="bottom"><bean:message key="notAllocatedUser" />:</td>
				<td>&nbsp;</td>
				<td align="left" nowrap valign="bottom"><bean:message key="allocatedUser" />:
				</td>
			<%} else {%>
				<td align="left" valign="bottom"><bean:message key="user" />:</td>
			<%}%>
		<%}%>

	</tr> --%>
	<tr valign="top">
		<td >
			<input type="text" class="text"  id="searchDepartment"  onkeyup="searchDepartmentFun();"  onmouseup="searchDepartmentFun();"   style="width: 196px;outline: none;">
			<div id="userTreeDIVImg"  class="userTreeDIV" style="text-align: center;">
				<img align="absmiddle" src="<%=path%>/images/32x32/Loading.gif" border="0"  style='margin-top:60px;' />
			</div>
			<div class="userTreeDIV"  id="userTreeDIV"  style="display:none;position: relative;">
			</div>	
		</td>
		<td >&nbsp;</td>
		<td align="left">
			<div class='text' style='width: 144px;position: relative;' >
				<input type="text"   id="googleSearchInput" maxlength="12" autocomplete="off" title="<bean:message key="please_search"/>" placeholder='<bean:message key="please_search"/>' onkeyup="searchUserFun(this)" onmouseup="searchUserFun(this)" style="width:120px;border:none; outline: none;">
				<img src="<%=path %>/images/16x16/search.gif" onclick="searchUserFun(document.getElementById('googleSearchInput'),true)" style='position: absolute;top:3px; right:3px;cursor: pointer;'/>
			</div>
			<div style='overflow: hidden;'>
				<div id="toBeSelectedImg"  style='height:230px;margin-top:2px; width:148px;text-align: center;border:1px solid #59b0bd;display:none; '>
					<img align="absmiddle" src="<%=path%>/images/32x32/Loading.gif" border="0"  style='margin-top:60px;' />
				</div>
				<select multiple name="toBeSelected"   id="toBeSelected"  size="12" style="width: 150px; height: 230px; margin-top:2px; "
				 ondblclick=<%=isMulti ? "treeSelectUtils.selectToRight();" : "OKFun();"%>
				 ></select>
			</div>
		</td>
		<%if (isMulti) {%>
		<td   valign="middle">
				<div style='text-align: center;'>
						<input class="kbutton" style="width: 40px;" onclick="treeSelectUtils.selectToRight()" type="button" value=">">
						<div style='height:10px;'></div>
						<input class="kbutton" style="width: 40px; " onclick="treeSelectUtils.selectToLeft()" type="button" value="&lt;">
				</div>	
		</td>
		<td  align="right">
			<div style='height: 25px;'></div>
			<div  id="alreadySelectedImg"  style='height:230px;margin-top:2px; width:148px;text-align: center;border:1px solid #59b0bd; '>
					<img align="absmiddle" src="<%=path%>/images/32x32/Loading.gif" border="0"  style='margin-top:60px;'/>
			</div>
			<div>
				<select multiple="multiple" name="alreadySelected" id="alreadySelected" size="12"  style="width: 150px;height:230px; display: none" ondblclick="treeSelectUtils.selectToLeft()" ></select>
			</div>
		</td>
		<%}%>
	</tr>
	</table>
	<div style='text-align: center; margin-top:10px;'>
		<input type="button" id="btnSave" name="btnSave" class="kbutton" value="<bean:message key="ok"/>" onclick="OKFun();">
		<input type="button" id="btnCancel" name="btnCancel" class="kbutton" value="<bean:message key="cancel"/>" onclick="cancelFun();">
	</div>
</form>
<!-- 以上为表单 -->

<%-- 输出公共BodyEnd模块 --%>
<jsp:include page="../../common/BodyEnd.jsp" />