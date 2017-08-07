<%@page import="org.apache.commons.io.filefilter.FalseFileFilter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import= "com.zq.commons.utils.UIUtils" %>
<%-- <%@ page import="com.zq.vo.process.BenefitEvalTplVO" %>
<%@ page import="com.zq.vo.process.BenefitEvalTplItemVO" %>
<%@ page import="com.zq.commons.utils.TypeUtils" %> --%>
<%
	String path = request.getContextPath();
	/* BenefitEvalTplVO benefitEvalInfo = (BenefitEvalTplVO)request.getAttribute("templateInfo");
	String evalPhase = benefitEvalInfo.getEvalPhase().toString();
	boolean isAfterEval;
	if ("1".equals(evalPhase)){
		isAfterEval = true;
	}else {
		isAfterEval = false;
	}
	int nameWidth = (760-30-180-80-50-100-(isAfterEval?160:0)-10); //是否是后评估  */
	int nameWidth = (760-30-180-80-50-100-(true?160:0)-10);
	/* boolean canEdit = true;
	boolean isNew = true; */
%>

<script type="text/javascript">

</script>

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
		<!-- 大类项 -->
		<%
		List<BenefitEvalTplItemVO> formTemplate2 = (List)request.getAttribute("formTemplate");
			if(formTemplate2 != null && formTemplate2.size() > 0){
				for(BenefitEvalTplItemVO item2 : formTemplate2){
		%>
		<tr class="listTableTR" >
			<td align="center">
			<input type="hidden" name="tplItemID" value="<%=item2.getListOrder()%>"/>
				<%=item2.getListOrder()%>
			</td>
			<td title="<%=item2.getEvalDimension()%>">
				<div style="width: <%=nameWidth %>px" class="nowrapText">
					<input type="hidden" name="evalDimension" value="<%=item2.getEvalDimension()%>"/>
					<img src="<%=path %>/static/images/folderClosed.gif" style="width: 16px; height: 16px;"/>
					<%=item2.getEvalDimension()%>
				</div>
			</td>
			<td title="">
				<div style="width:178px;" class="nowrapText">
					<input type="hidden" name="cmcc_description" value=""/>
					
				</div>
			</td>
		</tr>
		<%}} %>
		<!-- 小类项 -->
		<%
		List<BenefitEvalTplItemVO> formTemplate = (List)request.getAttribute("formTemplate");
			if(formTemplate != null && formTemplate.size() > 0){
				for(BenefitEvalTplItemVO item : formTemplate){
		%>
		<tr class="listTableTR" >
			<td align="center">
				<input type="hidden" name="tplItemID" value="<%=item.getTplItemID()%>"/>
				<%=item.getTplItemID()%>
			</td>
			<td title="<%=item.getEvalItem()%>">
				<div style="width: <%=nameWidth %>px" class="nowrapText">
					<input type="hidden" name="evalItem" value="<%=item.getEvalItem()%>"/>
					<img src="<%=path %>/static/images/benefit/empty.gif" style="width: 16px; height: 16px;"/>
					<img src="<%=path %>/static/images/benefit/task.gif" style="width: 16px; height: 16px;"/>
					<%=item.getEvalItem()%>
				</div>
			</td>
			<td title="<%=item.getEvalDesc()%>">
				<div style="width: 178px" class="nowrapText">
					<input type="hidden" name="evalDesc" value="<%=item.getEvalDesc()%>"/>
					<%=item.getEvalDesc()%>
				</div>
			</td>
			<%if(isAfterEval){%>
			<td align="right">
				<%if(canEdit){%>
					<input type="text" class="text" style="width: 78px;text-align: right;border: none;" name="cmcc_prescore" contentType="N10.2" readonly="readonly" value="<%=item.getEvalDimension()%>"/>
				<%}else{%>
					<%=TypeUtils.nullToString(item.getEvalDimension())%>
				<%}%>
			</td>
			<%}%>
			<td align="right">
				 <%if(canEdit){%>
					<input type="text" class="text" style="width: 78px;text-align: right;" name="cmcc_score" <%if(isAfterEval){%>onchange="cmccScoreChangeFun(this);"<%}%>
					 contentType="N10.2" value="<%=TypeUtils.nullToString(item.getEvalItem())%>"/>
				<%}else{%>
					<%=TypeUtils.nullToString(item.getEvalItem())%>
				<%}%>
			</td>
			<%if(isAfterEval){%>
			<td align="right">
				<%if(canEdit){%>
					<input type="text" class="text" style="width: 78px;text-align: right;border: none;" contentType="N10.2" name="cmcc_deviation" readonly="readonly" value="<%=TypeUtils.nullToString(item.getEvalItem())%>"/>
				<%}else{%>
					<%=TypeUtils.nullToString(item.getEvalItem())%>
				<%}%>
			</td>
			<%}%>
			<td title="" align="center">
				<img src="<%=path %>/static/images/benefit/discussion.gif"/>
				<%if(isNew){%>
					<input type="hidden" name="cmcc_templatescore" value="<%=TypeUtils.nullToString(item.getEvalItem())%>"/>
				<%}%>
				<%if(TypeUtils.nullToString(item.getEvalItem()).length()>0){%>
				<img src="<%=path %>/static/images/benefit/discussion_filled.gif"/>
				<%}else{%>
				<img src="<%=path %>/static/images/benefit/discussion.gif"/>
				<%}%>
			</td>
			<td title="<%=item.getRefValue()%>">
				<div style="width: 100px" class="nowrapText">
					<%if(canEdit){%>
						<input type="text" class="text" style="width:98px;" name="cmcc_remark" maxlength="100" value="<%=TypeUtils.xmlEncoderForIE(item.getEvalItem())%>"/>
					<%}else{%>
						<%=TypeUtils.xmlEncoderForIE(item.getEvalItem())%>
					<%}%>
				</div>
			</td>
		</tr>
		<%}}else{%>
		<tr class="listTableTR" >
			<td colspan="9">没有记录</td>
		</tr>
		<%}%>
	</tbody> --%>
</table>
<%=UIUtils.togglePanelEnd(request)%>

<!-- 以上为表单 -->
</form>