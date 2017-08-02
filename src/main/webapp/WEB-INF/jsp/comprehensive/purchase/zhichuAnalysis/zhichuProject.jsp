<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%@ page import="com.zq.commons.utils.StringUtils"%>
<%@ page import="com.zq.commons.result.HighChartData"%>
<%@page import="net.sf.json.JSONArray"%>
<%
String path = request.getContextPath();
Integer totalCount = (Integer)request.getAttribute("totalCount");
List<HighChartData> countDatas = (List<HighChartData>)request.getAttribute("countDatas");
%>
<div class="tabContent">
	<div style="margin: 26px auto; width: 100%; height: 300px;"
		id="methodProject"></div>
</div>
<script type="text/javascript">
$('#methodProject').highcharts({
    chart: {
    	type: 'pie'
    },
    title: {
    	verticalAlign:'middle',
        text: '总数<br>'+<%=totalCount%>,
        y:15,
        x:-80
    },
    subtitle:{
    	text:'<b>采购项目数</b>(单位:个)',
      	style:{
      		fontSize:'14px'
      	},
      	x:-30
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