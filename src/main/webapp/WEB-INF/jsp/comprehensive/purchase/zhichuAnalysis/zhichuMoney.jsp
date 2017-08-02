<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%@ page import="com.zq.commons.result.HighChartData"%>
<%@page import="net.sf.json.JSONArray"%>
<%
String path = request.getContextPath();
Double totalMoney = (Double)request.getAttribute("totalMoney");
List<HighChartData> moneyDatas = (List<HighChartData>)request.getAttribute("moneyDatas");
%>
<div class="tabContent">
	<div style="margin: 26px auto; width: 100%; height: 300px;"
		id="methodMoney"></div>
</div>
<script type="text/javascript">
	$('#methodMoney').highcharts({
	    chart: {
            type: 'pie'
        },
        title: {
        	verticalAlign:'middle',
            text: '总数<br>'+<%=TypeUtils.double2String(totalMoney/10000)%>,
            y:15,
            x:-80
        },
        subtitle:{
        	text:'<b>采购金额</b>(单位:万元)',
        	style:{
        		fontSize:'14px'
        	},
        	x:-50
        },
        legend:{
        	align:'right',
            verticalAlign:'middle',
            layout: 'vertical',
            x:-30
        },
        tooltip: {
        	enabled:<%=totalMoney==0?false:true%>,
            formatter: function () {
                return this.point.name + ': ' + Highcharts.numberFormat(this.point.percentage,2)+'%';
        	}
        },
        plotOptions: {
            pie: {
                size:130,
                innerSize:'80%',
                dataLabels: {
                    enabled: true,
                    formatter:function(){
                    	<%if(totalMoney!=0){%>
                    		return this.point.name+'('+Highcharts.numberFormat(this.y/10000,2)+')';
                    	<%}else{%>
                    		return this.point.name+'('+Highcharts.numberFormat(0,2)+')';
                    	<%}%>
                    }
                },
                showInLegend: true
            },
            series: {
				states: {
					hover: {
						enabled: false
					}
				}
			}
        },
        credits: {
            enabled: false
        },
        series: [{
            data: 
            <%if(totalMoney != 0){%>
            	<%=JSONArray.fromObject(moneyDatas)%>
            <%}else{%>
    	     	[
            	{y:1,name:'单一来源'}
            	,{y:1,name:'公开招标'}
            	,{y:1,name:'邀请招标'}
            	,{y:1,name:'公开比选'}
            	,{y:1,name:'邀请比选'}
            	,{y:1,name:'公开询价'}
            	,{y:1,name:'邀请询价'}
            	,{y:1,name:'竞争性谈判'}
            	,{y:1,name:'单一来源谈判'}
    	     	]
    	    <%}%>
        }]
	});
</script>
