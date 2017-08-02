<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%@ page import="com.zq.commons.result.HighChartData"%>
<%@page import="net.sf.json.JSONArray"%>
<%
String path = request.getContextPath();
Integer totalCount = (Integer)request.getAttribute("totalCount");
List<HighChartData> countDatas = (List<HighChartData>)request.getAttribute("countDatas");
%>
<div class="tabContent">
	<div style="height: 300px; margin: 26px auto; width: 100%;"
		id="caigouProject"></div>
</div>
<script type="text/javascript">
$('#caigouProject').highcharts({
    chart: {
    	type: 'pie'
    },
    title: {
    	verticalAlign:'middle',
        text: '总数<br>'+<%=totalCount%>,
        y:15,
        x:-90
    },
    subtitle:{
    	text:'<b>采购项目数</b>(单位:个)',
      	style:{
      		fontSize:'14px'
      	},
      	x:-20
    },
    legend:{
    	align:'right',
        verticalAlign:'middle',
        layout: 'vertical',
        x:-30
    },
    tooltip: {
    	enabled:<%=totalCount==0?false:true%>,
        pointFormat: '{point.percentage:.2f}%'
    },
    plotOptions: {
    	pie: {
        	size:130,
            innerSize:'80%',
            dataLabels: {
            	enabled: true,
                formatter:function(){
                	<%if(totalCount!=0){%>
                   		return this.point.name+'('+this.y+')';
                   	<%}else{%>
                   		return this.point.name+'(0)';
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
    		<%if(totalCount != 0){%>
            	<%=JSONArray.fromObject(countDatas)%>
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