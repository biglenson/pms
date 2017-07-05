<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%@ page import="com.zq.commons.utils.StringUtils"%>
<%
String path = request.getContextPath();
Map<Integer,Map<Integer,List>> allProjectsCategory = (Map<Integer,Map<Integer,List>>)request.getAttribute("allProjectsCategory");
Map<Integer,List> firstMap = allProjectsCategory.get(CMCCConstant.FIRST_ACCOUNT);
Map<Integer,List> secondMap = allProjectsCategory.get(CMCCConstant.SECOND_ACCOUNT);
List firstCapexList = firstMap.get(CMCCConstant.CAPEX_PROJECT);
List firstOpexList = firstMap.get(CMCCConstant.OPEX_PROJECT);
List secondCapexList = secondMap.get(CMCCConstant.CAPEX_PROJECT);
List secondOpexList = secondMap.get(CMCCConstant.OPEX_PROJECT);
Integer[] capexCount = new Integer[allProjectsCategory.size()+1];
Integer[] opexCount = new Integer[allProjectsCategory.size()+1];
Double[] capexMoney = new Double[allProjectsCategory.size()+1];
Double[] opexMoney = new Double[allProjectsCategory.size()+1];
capexCount[0] = (Integer)firstCapexList.get(1);
capexCount[1] = (Integer)secondCapexList.get(1);
capexCount[2] = capexCount[0] + capexCount[1];
opexCount[0] = (Integer)firstOpexList.get(1);
opexCount[1] = (Integer)secondOpexList.get(1);
opexCount[2] = opexCount[0] + opexCount[1];
capexMoney[0] = (Double)firstCapexList.get(0);
capexMoney[1] = (Double)secondCapexList.get(0);
capexMoney[2] = capexMoney[0] + capexMoney[1];
opexMoney[0] = (Double)firstOpexList.get(0);
opexMoney[1] = (Double)secondOpexList.get(0);
opexMoney[2] = opexMoney[0] + opexMoney[1];
Double firstMoney = capexMoney[0] + opexMoney[0];
Double secondMoney = capexMoney[1] + opexMoney[1];
Double totalMoney = firstMoney + secondMoney;
Integer firstCount = capexCount[0] + opexCount[0];
Integer secondCount = capexCount[1] + opexCount[1];
Integer totalCount = firstCount + secondCount;
String[] moneyNames = new String[]{"一级集采金额","二级集采金额","总采购金额"};
String[] projectNames = new String[]{"一级集采项目","二级集采项目","总采购项目"};
%>
<table style="width: 100%; height: 100%;">
	<tr>
		<td width="50%">
			<div style="border-right: 1px solid #CACFD4;" id="totalMoney"></div>
		</td>
		<td width="50%">
			<div id="totalProject"></div>
		</td>
	</tr>
	<tr>
		<td>
			<table style="margin-left: 72px; width: 420px;">
				<tr
					style="line-height: 22px; font-weight: bold; vertical-align: top;">
					<%
						Double firstmoneyPer = 0d;
						Double secondmoneyPer = 0d;
						if(totalMoney!=0){
							firstmoneyPer = firstMoney/totalMoney;
							secondmoneyPer = secondMoney/totalMoney;
						}
						if(firstmoneyPer>1){
							firstmoneyPer = 1.0;
						}
						if(secondmoneyPer>1){
							secondmoneyPer = 1.0;
						}
					%>
					<td align="center" width="33.3%;"><%=TypeUtils.formatWanMoney(firstMoney) %><br><%=TypeUtils.formatPercent(firstmoneyPer) %></td>
					<td align="center" width="33.3%;"><%=TypeUtils.formatWanMoney(secondMoney) %><br><%=TypeUtils.formatPercent(secondmoneyPer) %></td>
					<td align="center" width="33.3%;"><%=TypeUtils.formatWanMoney(totalMoney) %></td>
				</tr>
			</table>
		</td>
		<td>
			<table style="margin-left: 60px; width: 432px;">
				<tr
					style="line-height: 22px; font-weight: bold; vertical-align: top;">
					<%
						Double firstcountPer = 0d;
						Double secondcountPer = 0d;
						if(totalCount!=0){
							firstcountPer = firstCount*1.0/totalCount;
							secondcountPer = secondCount*1.0/totalCount;
						}
						if(firstcountPer>1){
							firstcountPer = 1.0;
						}
						if(secondcountPer>1){
							secondcountPer = 1.0;
						}
					%>
					<td align="center" width="33.3%;"><%=firstCount %><br><%=TypeUtils.formatPercent(firstcountPer) %></td>
					<td align="center" width="33.3%;"><%=secondCount %><br><%=TypeUtils.formatPercent(secondcountPer) %></td>
					<td align="center" width="33.3%;"><%=totalCount %></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<jsp:include page="/WEB-INF/jsp/common/viewChangeTime.jsp">
	<jsp:param name="lastUpdateDIV" value="caigouTotalInfoDIVTimeDIV" />
</jsp:include>
<script type="text/javascript">
$('#totalMoney').highcharts({
    title: {
        text:'采购金额',
        align:'left',
        style: {
            fontWeight: 'bold',
            fontSize:'14px'
        }
    },
    chart:{
    	type:'column'
    },
    credits:{
		enabled:false
	},
    xAxis: {
        categories: <%=JSONArray.fromObject(moneyNames)%>,
	 	lineColor: '#C0D0E0',
        lineWidth: 1,
        tickWidth:1,
        max:2
    },
    yAxis: {
        title: {
            text: '单位:万元',
            align:'high',
            rotation:0,
            y:-8,
            x:70
        },
        min:0,
        gridLineWidth: 0,
        lineColor: '#C0D0E0',
        lineWidth: 1,
        labels: { 
        	enabled:false, 
            formatter: function() {//去掉Y轴的刻度显示  
                return Highcharts.numberFormat(this.value/10000);
            }  
        }
    },
    plotOptions: {
        series: {
            dataLabels: {
                enabled: true,
                formatter:function(){
                	return Highcharts.numberFormat(this.y/10000,2);
                }
            }
        },
        column:{
        	pointWidth:30
        }
    },
    legend: {
        align: 'right',
        verticalAlign: 'top',
        x: -20,
        y: 10,
        floating: true,
        borderWidth: 0,
        shadow: false
    },
    tooltip: {
        formatter: function () {
            return this.x + ': ' + Highcharts.numberFormat(this.y/10000,2);
        }
    },
    series: [{
        name: 'CAPEX',
        data: [<%=StringUtils.join(capexMoney, ",")%>]
    },{
        name: 'OPEX',
        data: [<%=StringUtils.join(opexMoney, ",")%>]
    }]
});

$('#totalProject').highcharts({
    title: {
        text:'采购项目数',
        align:'left',
        style: {
            fontWeight: 'bold',
            fontSize:'14px'
        }
    },
    chart:{
    	type:'column'
    },
    credits:{
		enabled:false
	},
    xAxis: {
        categories: <%=JSONArray.fromObject(projectNames)%>,
	 	lineColor: '#C0D0E0',
        lineWidth: 1,
        tickWidth:1,
        max:2
    },
    yAxis: {
        title: {
            text: '单位:个',
            align:'high',
            rotation:0,
            y:-8,
            x:70
        },
        min:0,
        lineColor: '#C0D0E0',
        lineWidth: 1,
        gridLineWidth: 0,
        labels:{
        	enabled:false
        }
    },
    plotOptions: {
        series: {
            dataLabels: {
                enabled: true
            }
        },
        column:{
        	pointWidth:30
        }
    },
    tooltip: {
        formatter: function () {
            return this.x + ': ' + this.y + '个';
        }
    },
    legend: {
        align: 'right',
        verticalAlign: 'top',
        x: -20,
        y: 10,
        floating: true,
        borderWidth: 0,
        shadow: false
    },
    series: [{
        name: 'CAPEX',
        data: [<%=StringUtils.join(capexCount, ",")%>]
    },{
        name: 'OPEX',
        data: [<%=StringUtils.join(opexCount, ",")%>]
    }]
});
</script>