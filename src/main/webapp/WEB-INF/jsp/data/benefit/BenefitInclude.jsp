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
	
	int nameWidth = (760-30-180-80-50-100-(true?160:0)-10); //是否是后评估，这里还没有变量，先写成true
%>

<script type="text/javascript">

</script>
<body style="font-size:12px;">
<form>
<!-- 效益评估 -->
<%=UIUtils.togglePanelStart("效益评估", true, request)%>
<table style="width:100%;border:0;cellpadding:0;cellspacing:0" class="listTable">
	<thead>
	    <tr>
	    	<th ><div style="width:30px">序号</div></th>
			<th ><div style="width:<%=nameWidth%>px;">评价指标</div></th>
			<th ><div style="width:180px">指标说明</div></th>
			<%if(true){%>
			<th ><div style="width:80px">前评估值</div></th>
			<%}%>
			<th ><div style="width:80px"><%=(true?"后":"前")%>评估值</div></th>
			<%if(true){%>
			<th ><div style="width:80px">偏差</div></th>
			<%}%>
			<th ><div style="width:50px">参考值</div></th>
			<th ><div style="width:100px">描述</div></th>
 		</tr> 
	</thead>
	
	<%-- <tbody>
		<%
			if(cmccScoreItems!=null&&cmccScoreItems.size()>0){
				for(CMCCFormScoreCardItem item:cmccScoreItems){				
		%> 	
		<tr class="listTableTR" >
			<td align="center">
			<input type="hidden" name="cmcc_seqno" value="<%=item.getSeqno()%>"/>
			<input type="hidden" name="cmcc_scoreitemid" value="<%=item.getScoreitemid()%>"/>
			<input type="hidden" name="cmcc_parentid" value="0"/>
				<%=item.getSeqno()%>
			</td>
			<td title="<%=item.getName()%>">
				<div style="width: <%=nameWidth %>px" class="nowrapText">
					<input type="hidden" name="cmcc_name" value="<%=item.getName()%>"/>
					<img src="<%=path %>/images/16x16/folderClosed.gif" style="width: 16px; height: 16px;"/>
					<%=TypeUtils.xmlEncoderForIE(item.getName())%>
				</div>
			</td>
			<td title="<%=item.getDescription()%>">
				<div style="width:178px;" class="nowrapText">
					<input type="hidden" name="cmcc_description" value="<%=item.getDescription()%>"/>
					<%=TypeUtils.xmlEncoderForIE(item.getDescription())%>
				</div>
			</td>
			<%if(isAfterScore){%>
			<td>
			<input type="hidden" name="cmcc_prescore" value=""/>
			</td>
			<%}%>
			<td>
			<input type="hidden" name="cmcc_score" value=""/>
			</td>
			<%if(isAfterScore){%>
			<td>
			<input type="hidden" name="cmcc_deviation" value=""/>
			</td>
			<%}%>
			<td>
			<input type="hidden" name="cmcc_templatescore" value=""/>
			</td>
			<td>
			<input type="hidden" name="cmcc_remark" value=""/>
			</td>
		</tr>
		<%
			List<CMCCFormScoreCardItem> children = item.getChildren();
			if(children!=null&&children.size()>0){
				for(CMCCFormScoreCardItem child:children){
		%>
		<tr class="listTableTR" >
			<td align="center">
			<input type="hidden" name="cmcc_seqno" value="<%=child.getSeqno()%>"/>
			<input type="hidden" name="cmcc_scoreitemid" value="<%=child.getScoreitemid()%>"/>
			<input type="hidden" name="cmcc_parentid" value="<%=item.getScoreitemid()%>"/>
				<%=child.getSeqno()%>
			</td>
			<td title="<%=child.getName()%>">
				<div style="width: <%=nameWidth %>px" class="nowrapText">
					<input type="hidden" name="cmcc_name" value="<%=child.getName()%>"/>
					<img src="<%=path %>/images/16x16/empty.gif" style="width: 16px; height: 16px;"/><img src="<%=path %>/images/16x16/task.gif" style="width: 16px; height: 16px;"/>
					<%=TypeUtils.xmlEncoderForIE(child.getName())%>
				</div>
			</td>
			<td title="<%=child.getDescription()%>">
				<div style="width: 178px" class="nowrapText">
					<input type="hidden" name="cmcc_description" value="<%=TypeUtils.nullToString(child.getDescription())%>"/>
					<%=TypeUtils.xmlEncoderForIE(child.getDescription())%>
				</div>
			</td>
			<%if(isAfterScore){%>
			<td align="right">
				<%if(canEdit){%>
					<input type="text" class="text" style="width: 78px;text-align: right;border: none;" name="cmcc_prescore" contentType="N10.2" readonly="readonly" value="<%=TypeUtils.nullToString(child.getPrescore())%>"/>
				<%}else{%>
					<%=TypeUtils.nullToString(child.getPrescore())%>
				<%}%>
			</td>
			<%}%>
			<td align="right">
				<%if(canEdit){%>
					<input type="text" class="text" style="width: 78px;text-align: right;" name="cmcc_score" <%if(isAfterScore){%>onchange="cmccScoreChangeFun(this);"<%}%>
					 contentType="N10.2" value="<%=TypeUtils.nullToString(child.getScore())%>"/>
				<%}else{%>
					<%=TypeUtils.nullToString(child.getScore())%>
				<%}%>
			</td>
			<%if(isAfterScore){%>
			<td align="right">
				<%if(canEdit){%>
					<input type="text" class="text" style="width: 78px;text-align: right;border: none;" contentType="N10.2" name="cmcc_deviation" readonly="readonly" value="<%=TypeUtils.nullToString(child.getDeviation())%>"/>
				<%}else{%>
					<%=TypeUtils.nullToString(child.getDeviation())%>
				<%}%>
			</td>
			<%}%>
			<td title="<%=TypeUtils.nullToString(child.getTemplatescore())%>" align="center">
				<%if(isNew){%>
					<input type="hidden" name="cmcc_templatescore" value="<%=TypeUtils.nullToString(child.getTemplatescore())%>"/>
				<%}%>
				<%if(TypeUtils.nullToString(child.getTemplatescore()).length()>0){%>
				<img src="<%=path %>/images/16x16/discussion_filled.gif"/>
				<%}else{%>
				<img src="<%=path %>/images/16x16/discussion.gif"/>
				<%}%>
			</td>
			<td title="<%=TypeUtils.nullToString(child.getRemark())%>">
				<div style="width: 100px" class="nowrapText">
					<%if(canEdit){%>
						<input type="text" class="text" style="width:98px;" name="cmcc_remark" maxlength="100" value="<%=TypeUtils.xmlEncoderForIE(child.getRemark())%>"/>
					<%}else{%>
						<%=TypeUtils.xmlEncoderForIE(child.getRemark())%>
					<%}%>
				</div>
			</td>
		</tr>
		<%}}}}else{%>
		<tr class="listTableTR" >
			<td colspan="9"><bean:message key="noRecord"/></td>
		</tr>
		<%}%>
		</tbody> --%>
		<tbody>
			<tr class="listTableTR ">
				<td colspan="9">没有记录</td>
			</tr>
		</tbody>
</table>
<%=UIUtils.togglePanelEnd(request)%>

<!-- 以上为表单 -->
</form>
</body>