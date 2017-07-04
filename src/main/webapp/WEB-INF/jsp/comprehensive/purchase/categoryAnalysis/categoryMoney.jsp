<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = request.getContextPath();
Double totalMoney = (Double)request.getAttribute("totalMoney");
List<HighChartData> moneyDatas = (List<HighChartData>)request.getAttribute("moneyDatas");
%>
<div class="tabContent">
<div style="height: 300px;margin:26px auto;width:100%;" id="cagtgoryMoney" >
</div>
</div>
<script type="text/javascript">
	$('#cagtgoryMoney').highcharts({
	    chart: {
            type: 'pie'
        },
        title: {
        	verticalAlign:'middle',
            text: '总数<br>'+<%=TypeUtils.double2String(totalMoney/10000)%>,
            y:15,
            x:-90
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
                showInLegend: true,
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
            	{y:1,name:'工程类固定资产'}
            	,{y:1,name:'管理类低值易耗品'}
            	,{y:1,name:'生产类低值易耗品'}
            	,{y:1,name:'研发类项目'}
            	,{y:1,name:'其他'}
            	,{y:1,name:'营销宣传类项目'}
            	,{y:1,name:'运营支撑类项目'}
            	,{y:1,name:'办公类项目'}
            	,{y:1,name:'管理咨询类项目'}
            	,{y:1,name:'终端类项目'}
            	,{y:1,name:'集成'}
    	     	]
    	    <%}%>
        }]
	});
</script>	