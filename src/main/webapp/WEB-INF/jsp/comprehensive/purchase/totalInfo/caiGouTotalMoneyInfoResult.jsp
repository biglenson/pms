<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%@page import="net.sf.json.JSONArray"%>
<%@ page import="com.zq.commons.utils.StringUtils"%>
<%
String path = request.getContextPath();
Map<String,Double> firstBillMoney = (Map<String,Double>)request.getAttribute("firstBillMoney");
Map<String,Double> secondBillMoney = (Map<String,Double>)request.getAttribute("secondBillMoney");
Double[] capexMoney = new Double[3];
Double[] opexMoney = new Double[3];
capexMoney[0] = (Double)firstBillMoney.get("capexMoney");
capexMoney[1] = (Double)secondBillMoney.get("capexMoney");
capexMoney[2] = capexMoney[0] + capexMoney[1];
opexMoney[0] = (Double)firstBillMoney.get("opexMoney");
opexMoney[1] = (Double)secondBillMoney.get("opexMoney");
opexMoney[2] = opexMoney[0] + opexMoney[1];
Double firstMoney = capexMoney[0] + opexMoney[0];
Double secondMoney = capexMoney[1] + opexMoney[1];
Double totalMoney = firstMoney + secondMoney;
String[] moneyNames = new String[]{"一级集采金额","二级集采金额","总采购金额"};
%>
<table style="width: 100%; height: 100%;">
	<tr>
		<td>
			<div id="totalMoney"></div>
		</td>
	</tr>
	<tr>
		<td>
			<table style="margin-left: 68px; width: 420px;">
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
	</tr>
</table>
<jsp:include page="/WEB-INF/jsp/common/viewChangeTime.jsp">
	<jsp:param name="lastUpdateDIV" value="caigouTotalMoneyInfoDIVTimeDIV" />
</jsp:include>
<script type="text/javascript">
$('#totalMoney').highcharts({
    title: {
        text:'',
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
            y:0,
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
        y: -18,
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
</script>