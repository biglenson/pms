<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%@ page import="com.zq.commons.result.HighChartData"%>
<%@ page import="com.zq.commons.result.ColorHighChartData"%>
<%@ page import="net.sf.json.JSONArray"%>
<%
String path = request.getContextPath();
Integer index=(Integer)request.getAttribute("index");
%>
<%if(index==0){
	List<ColorHighChartData> startDatas = (List<ColorHighChartData>)request.getAttribute("startDatas");
	int startAllCount = (Integer)request.getAttribute("startAllCount");
	int startCount = (Integer)request.getAttribute("startCount");
	int delayStartCount = (Integer)request.getAttribute("delayStartCount");
	double totalDelayDays = (Double)request.getAttribute("totalDelayDays");
	double pingjunDays = 0.0;
	if(delayStartCount != 0){
		pingjunDays = totalDelayDays/delayStartCount;
	}
%>
<div style="height: 100%; float: left; width: 50%; border: none;"
	id="startProjectsContainer"></div>
<div style="height: 100%; float: left; width: 50%; border: none;">
	<table style="border: none; margin-top: 40px; line-height: 24px;">
		<tr>
			<td colspan="2"><div class="blodDIV">采购项目总数:</div></td>
			<td><div class="blodDIV"><%=startAllCount %>
					个
				</div></td>
		</tr>
		<tr>
			<td><div class="tipDIV" style="background-color: #a8da72;">&nbsp;</div></td>
			<td><div class="blodDIV">及时启动项目数:</div></td>
			<td><div class="blodDIV"><%=startCount %>
					个
				</div></td>
		</tr>
		<tr>
			<td><div class="tipDIV" style="background-color: #fe902c;">&nbsp;</div></td>
			<td><div class="blodDIV">延期启动项目数:</div></td>
			<td><div class="blodDIV"><%=delayStartCount %>
					个
				</div></td>
		</tr>
		<tr>
			<td colspan="2"><div>延期项目平均延期时间:</div></td>
			<td><div style="margin-left: 4px; font-weight: bold;"><%=TypeUtils.formatNumber(pingjunDays, TypeUtils.DEFAULT_WORKTIME_FORMAT)%>
					天
				</div></td>
		</tr>
	</table>
	<div class="tabMore linkURL" style="margin-top: 20px;"
		onclick="openMoreCaigouStartDetail()">更多详情</div>
</div>
<jsp:include page="/WEB-INF/jsp/common/viewChangeTime.jsp">
	<jsp:param name="lastUpdateDIV" value="summary_startDIVTimeDIV" />
</jsp:include>
<script type="text/javascript">
		$('#startProjectsContainer').highcharts({
		    chart: {
	            type: 'pie'
	        },
	        title: {
	            verticalAlign:'middle',
	            text: '采购项目总数<br>'+<%=startAllCount%>+' 个',
	            y:5,
	            style:{
        			fontSize:'14px',
        			fontWeight:'bold'
        		}
	        },
	        xAxis: {
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: ''
	            }
	        },
	        tooltip: {
	        	enabled:<%=startAllCount!=0%>,
	            pointFormat: '<b>{point.percentage:.2f}%</b>'
	        },
	        plotOptions: {
	            pie: {
	                size:150,
	                innerSize:'80%',
	                dataLabels: {
	                    enabled: false
	                }
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
	            <%if(startCount != 0 || delayStartCount != 0){%>
	            	<%=JSONArray.fromObject(startDatas)%>
	            <%}else{%>
       	     	 	[{y:1,color:'<%=HighChartData.COLOR_GRAY%>'}]
       	      	<%}%>
	        }]
		});
	</script>

<%}else if(index==1){
	List<ColorHighChartData> finishDatas = (List<ColorHighChartData>)request.getAttribute("finishDatas");
	int finishAllCount = (Integer)request.getAttribute("finishAllCount");
	int finishCount = (Integer)request.getAttribute("finishCount");
	int delayFinishCount = (Integer)request.getAttribute("delayFinishCount");
	double totalDelayFinishDays = (Double)request.getAttribute("totalDelayFinishDays");
	double everageDays = 0.0;
	if(delayFinishCount != 0){
		everageDays = totalDelayFinishDays/delayFinishCount;
	}
%>
<div style="height: 100%; float: left; width: 50%; border: none;"
	id="finishProjectsContainer"></div>
<div style="height: 100%; float: left; width: 50%; border: none;">
	<table style="border: none; margin-top: 40px; line-height: 24px;">
		<tr>
			<td colspan="2"><div class="blodDIV">采购项目总数:</div></td>
			<td><div class="blodDIV"><%=finishAllCount %>
					个
				</div></td>
		</tr>
		<tr>
			<td><div class="tipDIV" style="background-color: #a8da72;">&nbsp;</div></td>
			<td><div class="blodDIV">及时完成项目数:</div></td>
			<td><div class="blodDIV"><%=finishCount %>
					个
				</div></td>
		</tr>
		<tr>
			<td><div class="tipDIV" style="background-color: #fe902c;">&nbsp;</div></td>
			<td><div class="blodDIV">延期完成项目数:</div></td>
			<td><div class="blodDIV"><%=delayFinishCount %>
					个
				</div></td>
		</tr>
		<tr>
			<td colspan="2"><div>延期项目平均延期时间:</div></td>
			<td><div style="margin-left: 4px; font-weight: bold;"><%=TypeUtils.formatNumber(everageDays, TypeUtils.DEFAULT_WORKTIME_FORMAT) %>
					天
				</div></td>
		</tr>
	</table>
	<div class="tabMore linkURL" style="margin-top: 20px;"
		onclick="openMoreCaigouFinishDetail()">更多详情</div>
</div>
<jsp:include page="/WEB-INF/jsp/common/viewChangeTime.jsp">
	<jsp:param name="lastUpdateDIV" value="summary_finishDIVTimeDIV" />
</jsp:include>
<script type="text/javascript">
		$('#finishProjectsContainer').highcharts({
		    chart: {
	            type: 'pie'
	        },
	        title: {
	        	verticalAlign:'middle',
	            text: '采购项目总数<br>'+<%=finishAllCount%>+' 个',
	            y:5,
	            style:{
        			fontSize:'14px',
        			fontWeight:'bold'
        		}
	        },
	        xAxis: {
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: ''
	            }
	        },
	        tooltip: {
	        	enabled:<%=finishAllCount!=0%>,
	            pointFormat: '<b>{point.percentage:.2f}%</b>'
	        },
	        plotOptions: {
	            pie: {
	                size:150,
	                innerSize:'80%',
	                dataLabels: {
	                    enabled: false
	                }
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
	            <%if(finishCount != 0 || delayFinishCount != 0){%>
	            	<%=JSONArray.fromObject(finishDatas)%>
	            <%}else{%>
       	     	 	[{y:1,color:'<%=HighChartData.COLOR_GRAY%>'}]
       	      	<%}%>
	        }]
		});
	</script>
<%}%>
