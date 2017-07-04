<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%@ page import="com.zq.commons.utils.StringUtils"%>
<%
String path = request.getContextPath();
int year=(Integer)request.getAttribute("year");
Double []plan=(Double[])request.getAttribute("plan");
Double []actual=(Double[])request.getAttribute("actual");

Double allPlan=(Double)request.getAttribute("allPlan");
Double allActual=(Double)request.getAttribute("allActual");
Double monthPlan=(Double)request.getAttribute("monthPlan");
Double monthActual=(Double)request.getAttribute("monthActual");
Double distance=monthActual-monthPlan;
Double percent=monthPlan!=0? monthActual/monthPlan*100:null;
%>
<div  class="tabContent"><div style="position: relative;">
	<div style='width:190px;float:left;margin-left: 10px;'>
		<div class="sumValue" style="color:<%=distance<0?"#BF100F":"#0ACC4B"%>">
			<b style="font-size: 18px;"><%=TypeUtils.formatWan2Money(monthActual,"") %></b>
		</div>
		<div style='width:100%;margin:5px auto;height:8px;background-color:#E8E9ED;'>
			<div style=' height:100%;width:<%=monthPlan!=0? monthActual/monthPlan*100:0%>%;background-color:<%=distance<0?"#BF100F":"#0ACC4B"%>;'></div>
		</div>
		<table style='width:100%;margin:10px auto;'>
			<tr><td class='tipSpan' style="text-align: left;padding-left: 0px;"><span> 到本月完成率&nbsp;:</span></td><td class='tipSpan2' width='100%'><span style='color:<%=distance<0?"#BF100F":"black"%>;font-size:24px;'><%=percent!=null?TypeUtils.double2String(percent):"0.00"%>%</span></td></tr>
			<tr><td class='tipSpan' style="text-align: left;padding-left: 0px;"><span> 全年计划&nbsp;:</span></td><td class='tipSpan2' width='100%'><span style=''><%=TypeUtils.formatWan2Money(allPlan,"") %></span></td></tr>
			<tr><td class='tipSpan' style="text-align: left;padding-left: 0px;"><span> 到本月计划&nbsp;:</span></td><td class='tipSpan2' width='100%'><span style=''><%=TypeUtils.formatWan2Money(monthPlan,"") %></span></td></tr>
			<tr><td class='tipSpan' style="text-align: left;padding-left: 0px;"><span> 到本月实际&nbsp;:</span></td><td class='tipSpan2' width='100%'><span style=''><%=TypeUtils.formatWan2Money(monthActual,"") %></span></td></tr>
			<tr style="display:none;"><td class='tipSpan'><span> 到本月偏差&nbsp;:</span></td><td class='tipSpan2' width='100%'><span style='color:<%=distance<0?"#BF100F":"black"%>'><%=TypeUtils.formatWan2Money(distance,"") %></span></td></tr>
		</table>	
	</div>
	<div style="margin-left:200px;">
		<div style="height:220px;width:750px;margin:10px auto;" id="kaizhiplanChar">
		</div>
		<div style="clear:both;margin-left: 40px;">
			<table style="margin-left:auto;margin-right:auto;" class="listTable" border="0" cellpadding="0" cellspacing="0"border="0" >
				<thead>
					<tr>
						<th><div style='width:30px;'></div></th>
						<%for(int i=1;i<=12;i++){ %>
						<th><div style='width:55px;'><%=year %>-<%=i<10?"0":"" %><%=i %></div></th>
						<%} %>
					</tr>
				</thead>
				<tbody>
					<tr class="listTableTR">
						<td align="center">计划</td>
						<%for(int i=0;i<12;i++){ %>
							<td align="center" title="<%=TypeUtils.formatWan2Money(plan[i])%>">
								<%=allPlan!=0?TypeUtils.formatPercent(plan[i]/allPlan):"" %>
							</td>
						<%}%>
					</tr>
					<tr>
						<td align="center">执行</td>
						<%for(int i=0;i<12;i++){ %>
							<td align="center" title="<%=TypeUtils.formatWan2Money(actual[i])%>" style="color:<%=(actual[i]- plan[i])>=0?"#55B366":"#F05B5A"%>">
								<%=allActual!=0?TypeUtils.formatPercent(actual[i]/allPlan):"" %>
							</td>
						<%}%>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div style="position:absolute;right:10px; top:16px;" >
		<div class="showHelpe" onclick="showZhuanziTip(this,'zhuanziTipNameDIV')"></div>
	</div>
	<div class="helpFloatDIV" id="zhuanziTipNameDIV" style="line-height: 22px;">
		<div class="showHelpeContent" style="line-height: 23px;">
			<div>绿色:表示正常</div>
			<div>红色:实际&lt;计划</div>
		</div>
	</div>
	<div style="clear:both;"></div>
	</div>
</div>
<script type="text/javascript">
$('#kaizhiplanChar').highcharts({
    title: {
    	 text: '',
         rotation:0,
         x:40
    },
    chart:{
    	type:'column'
    },
    credits:{
		enabled:false
	},
    xAxis: {
        categories: ['一月', '二月', '三月', '四月', '五月', '六月',
                     '七月', '八月', '九月', '十月', '十一月', '十二月'],
	 	lineColor: '#C0D0E0',
        lineWidth: 1,
        tickWidth:1,
        max:11
    },
    yAxis: {
        title: {
            text: ''
        },
        min:0,
        lineColor: '#C0D0E0',
        lineWidth: 1,
        plotLines: [{
            value: 0,
            width: 1,
            color: '#808080'
        }],
        labels: {  
            formatter: function() {//去掉Y轴的刻度显示  
                return Highcharts.numberFormat(this.value);
            }  
        }
    },
    legend: {
        layout: 'horizontal',
        align: 'right',
        verticalAlign: 'top',
        x: -40,
        y: 10,
        borderWidth: 0,
        backgroundColor: ((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'),
        shadow: false
    },
    tooltip: {
    	formatter: function () {
            var s = '<b>' + this.x + '</b>';
            $.each(this.points, function () {
                s += '<br/>' + this.series.name + ':' +
                Highcharts.numberFormat(this.y,2,".",",") + '万元';
            });
            return s;
        },
        shared: true
    },
    series: [{
        name: '计划',
        data: [<%=StringUtils.join(plan, ",")%>]
    },{
        name: '执行',
        data: [<%=StringUtils.join(actual, ",")%>]
    }]
});
	
</script>