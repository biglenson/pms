<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = request.getContextPath();
double capexValue=(Double)request.getAttribute("capexValue");
double shiYongValue=(Double)request.getAttribute("shiYongValue");
double ziJinValue=(Double)request.getAttribute("ziJinValue");
double ziJinShiYongValue=(Double)request.getAttribute("ziJinShiYongValue");
List<Hierarchyable>roleList=(List<Hierarchyable>)request.getAttribute("roleList");
Map<Integer,Double> capexValueMap=(Map<Integer,Double>)request.getAttribute("capexValueMap");
Map<Integer,Double> shiYongValueMap=(Map<Integer,Double>)request.getAttribute("shiYongValueMap");
%>
<div id="touziDetailCapexDIV" class="tabContent">
	<div style="width:190px;margin-left:10px;float:left">
		<div style="margin-top:8px;">
			<div style="padding-bottom:8px;">新建项目投资执行进度&nbsp;:</div>
			<div style="padding-bottom:8px;font-size: 16px;font-weight: bold;"><%=TypeUtils.formatWanMoney(shiYongValue,"") %></div>
			<div style='width:95%;margin:10px auto;height:8px;background-color:#E8E9ED;'>
				<div style=' height:100%;width:<%=capexValue!=0? (shiYongValue>capexValue?100:shiYongValue/capexValue*100):0%>%;background-color:#0ACC4B'></div>
			</div>
			<div style="padding-bottom:18px;border-bottom:1px solid #EBE8EF;">投资计划总额&nbsp;: <b style="font-size: 14px;"><%=TypeUtils.formatWanMoney(capexValue,"")  %></b></div>
		</div>
		
		
		<div style="margin-top:15px;">
			<div style="padding-bottom:10px;">自主资金使用&nbsp;:</div>
			<div style="padding-bottom:10px;font-size: 16px;font-weight: bold;"><%=TypeUtils.formatWanMoney(ziJinShiYongValue,"") %></div>
			<div style='width:95%;margin:10px auto;height:8px;background-color:#E8E9ED;'>
				<div style=' height:100%;width:<%=ziJinValue!=0?(ziJinShiYongValue>ziJinValue?100: ziJinShiYongValue/ziJinValue*100):0%>%;background-color:#0ACC4B'></div>
			</div>
			<div style="padding-bottom:8px;">自主资金池总额&nbsp;: <b style="font-size: 14px;"><%=TypeUtils.formatWanMoney(ziJinValue,"")  %></b></div>
		</div>
	</div>
	<div id="touziDetialCapexDepartDIV" style="margin-left:220px;">
		<div style="height:250px;">
			<table id="touziDetialCapexDepartDIVTable" class="listTable"  cellpadding="0" cellspacing="0" border="0">
			<thead>
				<tr>
					<th width="100%"><div style='width:100%'>部门名称</div></th>
					<th ><div style='width:180px'>投资计划总额</div></th>
					<th ><div style='width:180px'>立项批复金额</div></th>
					<th><div style='width:150px'>投资计划使用进度</div></th>
				</tr>
			</thead>
			<tbody>
				<%for(Hierarchyable role:roleList){ 
				//Role role=(Role) a;
				//System.out.println("部门名称："+role.getName());
				if("公司统筹".equals(role.getName())){
					continue;
				}
				boolean contains=capexValueMap.containsKey(role.getId())||shiYongValueMap.containsKey(role.getId());
				if(!contains){
					continue;
				}
				Double capexV=capexValueMap.get(role.getId());
				Double capexV2=shiYongValueMap.get(role.getId());
				Double per=capexV!=null? (capexV2==null?0:capexV2)/capexV*100:null;
				%>
				<tr>
					<td align="center" class="linkURL" onclick="openDepartmentView(<%=role.getId()%>)"><div><%=TypeUtils.xmlEncoderForIE(role.getName()) %></div></td>
					<td align="center"><div style="padding-right:5px;"><%=TypeUtils.formatWanMoney(capexV, "") %></div></td>	
					<td align="center"><div style="padding-right:5px;"><%=TypeUtils.formatWanMoney(capexV2, "") %></div></td>	
					<td align="center"><div style="padding-right:5px;"><%=per!=null?TypeUtils.double2String(per):"0.00"%>%</div></td>
				</tr>
				<%} %>
			</tbody>
			</table>
		</div>
	</div>
	<div style="clear:both;"></div>
</div>
<script type="text/javascript">
	window.touziDetialCapexDepartDIVTableObj=new EasyTrack.DataTable("touziDetialCapexDepartDIVTable",{
		autoHeight:false
	})
</script>