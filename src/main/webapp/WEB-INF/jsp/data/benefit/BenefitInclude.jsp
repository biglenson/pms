<%@page import="org.apache.commons.io.filefilter.FalseFileFilter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import= "com.zq.commons.utils.UIUtils" %>
<%@ page import= "com.zq.vo.process.BenefitEvalItemVO" %>
<%@ page import= "com.zq.vo.process.BenefitEvalVO" %>
<%@ page import="com.zq.commons.utils.TypeUtils" %>
<%
	String path = request.getContextPath();
	//获取基本信息
	BenefitEvalVO benefitEvalInfo = (BenefitEvalVO)request.getAttribute("benefitEvalInfo");
	//判断前后评估,1是后评估,0是前评估
	String evalPhase = String.valueOf(benefitEvalInfo.getEvalPhase());
	int tplID = benefitEvalInfo.getTplID();
	boolean isAfterEval;
	if ("1".equals(evalPhase)){
		isAfterEval = true;
	}else {
		isAfterEval = false;
	}
	int nameWidth = (760-30-180-80-50-100-(isAfterEval?160:0)-10);
	boolean canEdit = true;
	boolean isNew = true;
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
			<%if(isAfterEval){%>
			<th ><div style="width:80px">前评估值</div></th>
			<%}%>
			<th ><div style="width:80px"><%=(isAfterEval?"后":"前")%>评估值</div></th>
			<%if(isAfterEval){%>
			<th ><div style="width:80px">偏差</div></th>
			<%}%>
			<th ><div style="width:50px">参考值</div></th>
			<th ><div style="width:100px">描述</div></th>
 		</tr> 
	</thead>
	<%-- <tbody>
		<!-- 大类项 -->
		<%
		//获取效益评估Form表单信息
		List<BenefitEvalItemVO> benefitEvalFormList = (List)request.getAttribute("benefitEvalForm");
			if(benefitEvalFormList != null && benefitEvalFormList.size() > 0){
				String dimension = ""; //大类标识
				int index = 1; //自定义索引
				for(BenefitEvalItemVO item : benefitEvalFormList){
					if(!dimension.equals(item.getEvalDimension())) {
						dimension = item.getEvalDimension();
		%>	
		<tr class="listTableTR" >
			<td align="center">
				<%=index%>
			</td>
			<td title="<%=item.getEvalDimension()%>">
				<div style="width: <%=nameWidth %>px" class="nowrapText">
					<img src="<%=path %>/static/images/folderClosed.gif" style="width: 16px; height: 16px;"/>
					<%=item.getEvalDimension()%>
				</div>
			</td>
			<td title="">
				<div style="width:178px;" class="nowrapText">
				</div>
			</td>
		</tr>		
		<%}%>
		<!-- 小类项 -->
		<tr class="listTableTR" >
			<td align="center">
				<%=index+1%>
			</td>
			<td title="<%=item.getEvalItem()%>">
				<div style="width: <%=nameWidth %>px" class="nowrapText">
					<img src="<%=path %>/static/images/benefit/empty.gif" style="width: 16px; height: 16px;"/>
					<img src="<%=path %>/static/images/benefit/task.gif" style="width: 16px; height: 16px;"/>
					<%=item.getEvalItem()%>
				</div>
			</td>
			<td title="<%=item.getEvalDesc()%>">
				<div style="width: 178px" class="nowrapText">
					<%=item.getEvalDesc()%>
				</div>
			</td>
			<%if(isAfterEval){%>
			<td align="right">
				<%if(canEdit){%>
					<input type="text" class="text" style="width: 78px;text-align: right;border: none;" name="evalValue" contentType="N10.2" readonly="readonly" value="<%=item.getEvalValue()%>"/>
				<%}else{%>
					<%=TypeUtils.nullToString(item.getEvalValue())%>
				<%}%>
			</td>
			<%}%>
			<td align="right">
				 <%if(canEdit){%>
					<input type="text" class="text" style="width: 78px;text-align: right;" name="evalValue" <%if(isAfterEval){%>onchange="cmccScoreChangeFun(this);"<%}%>
					 contentType="N10.2" value="<%=TypeUtils.nullToString(item.getEvalValue())%>"/>
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
			<td title="<%=item.getRefValue()%>" align="center">
				<img src="<%=path %>/static/images/benefit/discussion.gif"/>
				<%if(isNew){%>
					<input type="hidden" name="refValue" value="<%=TypeUtils.nullToString(item.getRefValue())%>"/>
				<%}%>
				<%if(TypeUtils.nullToString(item.getRefValue()).length()>0){%>
				<img src="<%=path %>/static/images/benefit/discussion_filled.gif"/>
				<%}else{%>
				<img src="<%=path %>/static/images/benefit/discussion.gif"/>
				<%}%>
			</td>
			<td title="<%=item.getEvalNote()%>">
				<div style="width: 100px" class="nowrapText">
					<%if(canEdit){%>
						<input type="text" class="text" style="width:98px;" name="evalNote" maxlength="100" value="<%=TypeUtils.xmlEncoderForIE(item.getEvalNote())%>"/>
					<%}else{%>
						<%=TypeUtils.xmlEncoderForIE(item.getEvalNote())%>
					<%}%>
				</div>
			</td>
		</tr>
		<%index++;}}else{%>
		<tr class="listTableTR" >
			<td colspan="9">没有记录</td>
		</tr>
		<%}%>
	</tbody> --%>
</table>
<%=UIUtils.togglePanelEnd(request)%>

<!-- 以上为表单 -->
</form>