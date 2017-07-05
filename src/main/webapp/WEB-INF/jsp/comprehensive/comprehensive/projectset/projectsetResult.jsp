<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = request.getContextPath();
List<CMCCItemSet> itemSet=(List<CMCCItemSet>) request.getAttribute("itemSet");
Map<Integer,Double> itemSetKaizhiMap=(Map<Integer,Double>)request.getAttribute("itemSetKaizhiMap");
Map<Integer,Double> itmeSetOpexCostMap=(Map<Integer,Double>)request.getAttribute("itmeSetOpexCostMap");
Map<Integer,Double> itmeSetZhuanZiMap=(Map<Integer,Double>)request.getAttribute("itmeSetZhuanZiMap");
Map<Integer,Integer> itemCapexCountMap=(Map<Integer,Integer>)request.getAttribute("itemCapexCountMap");
%>
<div style="margin: 10px auto; max-height: 250px; overflow: auto;"
	id="projectsetDIV">
	<table id="projectSetResultTable" class="listTable" cellpadding="0"
		cellspacing="0" border="0">
		<thead>
			<tr>
				<th width="100%"><div style='width: 100%'>项目名称</div></th>
				<th><div style='width: 200px'>需求部门</div></th>
				<!-- 
				<th><div style='width:120px'>包含的CAPEX总数</div></th>
				 -->
				<th><div style='width: 150px'>成本开支总额</div></th>
				<th><div style='width: 150px'>资本开支总额</div></th>
				<th><div style='width: 150px'>转资总额</div></th>
			</tr>
		</thead>
		<tbody>
			<%for(CMCCItemSet s:itemSet){ %>
			<tr>
				<td align="center"><div class="nowrapText linkURL"
						onclick="openItemSet(<%=s.getId()%>)" style="width: 200px;"
						title="<%=TypeUtils.xmlEncoderForIE(s.getTitle())%>"><%=TypeUtils.xmlEncoderForIE(s.getTitle())%></div></td>
				<td align="center"><%=TypeUtils.xmlEncoderForIE(TypeUtils.getDepartValueName(user, s, "sys01"))%></td>
				<% 
						Integer count=itemCapexCountMap.get(s.getId());
						Double opexDouble=itmeSetOpexCostMap.get(s.getId());
						Double kaizhDouble=itemSetKaizhiMap.get(s.getId());
						Double zhuanziDouble=itmeSetZhuanZiMap.get(s.getId());
						%>
				<!-- 
					<td>
						
						<%=count!=null?count:"&nbsp;" %>
					</td>
					 -->
				<td align="center"><div
						style='width: 110px; padding-right: 10px;' class="nowrapText"><%=opexDouble!=null? TypeUtils.formatWanMoney(opexDouble, ""):"0"%></div></td>
				<td align="center"><div
						style='width: 110px; padding-right: 10px;' class="nowrapText"><%=kaizhDouble!=null? TypeUtils.formatWanMoney(kaizhDouble, ""):"0"%></div></td>
				<td align="center"><div
						style='width: 110px; padding-right: 10px;' class="nowrapText"><%=zhuanziDouble!=null? TypeUtils.formatWanMoney(zhuanziDouble, ""):"0"%></div></td>

			</tr>
			<%}if(itemSet.isEmpty()){ %>
			<tr>
				<td colspan="10" style="padding-left: 100px;">暂无数据</td>
			</tr>
			<%} %>
		</tbody>
	</table>
</div>
<jsp:include page="/WEB-INF/jsp/common/viewChangeTime.jsp">
	<jsp:param name="lastUpdateDIV" value="projectSetRequestJSPTime" />
</jsp:include>
<script type="text/javascript">
	var div=document.getElementById("projectsetDIV");
	if(div.scrollHeight>div.offsetHeight){
		div.style.height="250px";
		window.projectResultTableObj=new EasyTrack.DataTable("projectSetResultTable",{
			autoHeight:false
		})
	}
	
</script>