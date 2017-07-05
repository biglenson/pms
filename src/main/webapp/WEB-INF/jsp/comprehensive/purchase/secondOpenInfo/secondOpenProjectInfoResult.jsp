<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = request.getContextPath();
Map<String,List> allOpenData = (Map<String,List>)request.getAttribute("allOpenData");
Set<String> categoryNames = allOpenData.keySet();
List openData = allOpenData.get("公开类");
List unOpenData = allOpenData.get("非公开类");
Integer[] count = new Integer[categoryNames.size()];
count[0] = (Integer)openData.get(1);
count[1] = (Integer)unOpenData.get(1);
%>
<div style="height: 320px;" id="openTotalProject"></div>
<jsp:include page="/WEB-INF/jsp/common/viewChangeTime.jsp">
	<jsp:param name="lastUpdateDIV" value="secondOpenProjectInfoDIVTimeDIV" />
</jsp:include>
<script type="text/javascript">
$('#openTotalProject').highcharts({
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
            text: '单位:个',
            align:'high',
            rotation:0,
            y:8,
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
    legend:{
    	enabled:false
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
    series: [{
    	name:'项目数',
        data: [<%=StringUtils.join(count, ",")%>]
    }]
});
</script>