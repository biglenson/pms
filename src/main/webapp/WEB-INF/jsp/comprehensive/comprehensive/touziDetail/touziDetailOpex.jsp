<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = request.getContextPath();
double opexValue=(Double)request.getAttribute("opexValue");
double opexShiYongValue=(Double)request.getAttribute("opexShiYongValue");
double poolValue=(Double)request.getAttribute("poolValue");
double poolShiYongValue=(Double)request.getAttribute("poolShiYongValue");
List<Hierarchyable>roleList=(List<Hierarchyable>)request.getAttribute("roleList");
Map<Integer,Double> opexValueMap=(Map<Integer,Double>)request.getAttribute("opexValueMap");
Map<Integer,Double> opexShiYongValueMap=(Map<Integer,Double>)request.getAttribute("opexShiYongValueMap");

%>
<div id="touziDetailOpexDIV" class="tabContent">
	<div style="width: 190px; float: left; margin-left: 10px;">
		<div style="margin-top: 8px;">
			<div style="padding-bottom: 8px;">预算使用&nbsp;:</div>
			<div style="padding-bottom: 8px; font-size: 16px; font-weight: bold;"><%=TypeUtils.formatWanMoney(opexShiYongValue,"") %></div>
			<div
				style='width: 95%; margin: 10px auto; height: 8px; background-color: #E8E9ED;'>
				<div
					style=' height:100%;width:<%=opexValue!=0? (opexShiYongValue>opexValue?100:opexShiYongValue/opexValue*100):0%>%;background-color:#0ACC4B'></div>
			</div>
			<div style="padding-bottom: 18px; border-bottom: 1px solid #EBE8EF;">
				预算总额&nbsp;: <b style="font-size: 14px;"><%=TypeUtils.formatWanMoney(opexValue,"")  %></b>
			</div>
		</div>


		<div style="margin-top: 15px;">
			<div style="padding-bottom: 10px;">预算池使用&nbsp;:</div>
			<div
				style="padding-bottom: 10px; font-size: 16px; font-weight: bold;"><%=TypeUtils.formatWanMoney(poolShiYongValue,"") %></div>
			<div
				style='width: 95%; margin: 10px auto; height: 8px; background-color: #E8E9ED;'>
				<div
					style=' height:100%;width:<%=poolValue!=0?(poolShiYongValue>poolValue?100: poolShiYongValue/poolValue*100):0%>%;background-color:#0ACC4B'></div>
			</div>
			<div style="padding-bottom: 8px;">
				动态预算池总额&nbsp;: <b style="font-size: 14px;"><%=TypeUtils.formatWanMoney(poolValue,"")  %></b>
			</div>
		</div>
	</div>
	<div id="touziDetialOpexDIV" style="margin-left: 220px;">
		<div style="height: 250px;">
			<table id="touziDetialOpexDIVTable" class="listTable" cellpadding="0"
				cellspacing="0" border="0">
				<thead>
					<tr>
						<th width="100%"><div style='width: 100%'>部门名称</div></th>
						<th><div style='width: 180px'>预算总金额</div></th>
						<th><div style='width: 180px'>预算完成金额</div></th>
						<th><div style='width: 150px'>预算执行进度</div></th>
					</tr>
				</thead>
				<tbody>
					<%for(Hierarchyable role:roleList){ 
				//Role role=(Role) a;
				//System.out.println("部门名称："+role.getName());
				if("公司统筹".equals(role.getName())){
					continue;
				}
				boolean contains=opexValueMap.containsKey(role.getId())||opexShiYongValueMap.containsKey(role.getId());
				if(!contains){
					continue;
				}
				Double capexV=opexValueMap.get(role.getId());
				Double capexV2=opexShiYongValueMap.get(role.getId());
				Double per=capexV!=null? (capexV2==null?0:capexV2)/capexV*100:null;
				%>
					<tr>
						<td align="center"><div class="linkURL"
								onclick="openDepartmentView(<%=role.getId()%>)"><%=TypeUtils.xmlEncoderForIE(role.getName()) %></div></td>
						<td align="center"><div style="padding-right: 5px;"><%=TypeUtils.formatWanMoney(capexV, "") %></div></td>
						<td align="center"><div style="padding-right: 5px;"><%=TypeUtils.formatWanMoney(capexV2, "") %></div></td>
						<td align="center"><div style="padding-right: 5px;"><%=per!=null?TypeUtils.double2String(per):"0.00"%>%
							</div></td>
					</tr>
					<%} %>
				</tbody>
			</table>
		</div>
	</div>
	<div style="clear: both;"></div>
</div>
<script type="text/javascript">
	window.touziDetialOpexDIVTableObj=new EasyTrack.DataTable("touziDetialOpexDIVTable",{
		autoHeight:false
	})
</script>