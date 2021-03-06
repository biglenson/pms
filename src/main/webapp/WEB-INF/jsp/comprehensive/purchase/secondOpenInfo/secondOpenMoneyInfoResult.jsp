<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%@ page import="net.sf.json.JSONArray"%>
<%@ page import="com.zq.commons.utils.StringUtils"%>
<%
String path = request.getContextPath();
Map<String,List> allOpenData = (Map<String,List>)request.getAttribute("allOpenData");
Set<String> categoryNames = allOpenData.keySet();
List openData = allOpenData.get("公开类");
List unOpenData = allOpenData.get("非公开类");
Double[] money = new Double[categoryNames.size()];
money[0] = (Double)openData.get(0);
money[1] = (Double)unOpenData.get(0);
%>
<div style="height: 320px;" id="openTotalMoney"></div>
<jsp:include page="/WEB-INF/jsp/common/viewChangeTime.jsp">
	<jsp:param name="lastUpdateDIV" value="secondOpenMoneyInfoDIVTimeDIV" />
</jsp:include>
<script type="text/javascript">
$('#openTotalMoney').highcharts({
    title: {
        text:'',
        align:'left',
        style: {
            fontWeight: 'bold',
            fontSize:'15px'
        }
    },
    chart:{
    	type:'column'
    },
    credits:{
		enabled:false
	},
    xAxis: {
        categories: <%=JSONArray.fromObject(categoryNames)%>
    },
    yAxis: {
        title: {
            text: '单位:万元',
            align:'high',
            rotation:0,
            y:8,
            x:70
        },
        min:0,
        lineColor: '#C0D0E0',
        lineWidth: 1,
        gridLineWidth: 0,
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
    legend:{
    	enabled:false
    },
    tooltip: {
        formatter: function () {
            return this.x + ': ' + Highcharts.numberFormat(this.y/10000,2);
        }
    },
    series: [{
    	name:'金额',
        data: [<%=StringUtils.join(money, ",")%>]
    }]
});
</script>