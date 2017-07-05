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
capexCount[0] = (Integer)firstCapexList.get(1);
capexCount[1] = (Integer)secondCapexList.get(1);
capexCount[2] = capexCount[0] + capexCount[1];
opexCount[0] = (Integer)firstOpexList.get(1);
opexCount[1] = (Integer)secondOpexList.get(1);
opexCount[2] = opexCount[0] + opexCount[1];
Integer firstCount = capexCount[0] + opexCount[0];
Integer secondCount = capexCount[1] + opexCount[1];
Integer totalCount = firstCount + secondCount;
String[] projectNames = new String[]{"一级集采项目","二级集采项目","总采购项目"};
%>
<table style="width: 100%; height: 100%;">
	<tr>
		<td>
			<div id="totalProject"></div>
		</td>
	</tr>
	<tr>
		<td>
			<table style="margin-left: 60px; width: 418px;">
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
	<jsp:param name="lastUpdateDIV"
		value="caigouTotalProjectInfoDIVTimeDIV" />
</jsp:include>
<script type="text/javascript">
$('#totalProject').highcharts({
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
            y:0,
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
        y: -18,
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