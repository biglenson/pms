<%@page import="net.sf.json.JSONArray"%>
<%@page import="com.easytrack.framework.dashboard.Bean.HighChartData"%>
<%@page import="com.easytrack.customization.cmcc.action.FormBaseResove"%>
<%@page import="com.easytrack.commons.util.TypeUtils"%>
<%@page import="com.easytrack.component.ComponentFactory"%>
<%@page import="com.easytrack.customization.cmcc.bean.CAPEXProject"%>
<%@page import="com.easytrack.component.profile.*"%>
<%@page import="com.easytrack.platform.ui.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
SessionManager webMgr = new SessionManager();
webMgr.init(session);
User user = webMgr.getCurrentUser();
Locale locale = webMgr.getCurrentLocale();
Integer index=(Integer)request.getAttribute("index");
%>
<%if(index==0){
	double allValue=(Double)request.getAttribute("allValue");
	double yearValue=(Double)request.getAttribute("yearValue");
	boolean delay=yearValue>allValue;//false;
%>
	<div  class="sumValue" style="color:<%=delay?"#BF100F":"#0ACC4B" %>;" >
		<%=FormBaseResove.formatWanMoney(yearValue) %>
	</div>
	<div style='width:97%;margin:15px auto;height:8px;background-color:#E8E9ED;'>
		<%Double percent=allValue!=0?yearValue/allValue*100:null; %>
		<div style=' height:100%;width:<%=percent!=null?percent>100?100:percent.intValue():0%>%;background-color:<%=delay?"#BF100F":"#0ACC4B" %>;''></div>
	</div>
	
	
	<div style='width:96%;margin:0px auto;line-height: 23px;height: 50%'>
		<table style="width: 100%;height:100%;">
			<tr>
				<td width="85px" >
					<div><span class='tipSpan '>投资总额&nbsp;:</span></div>
				</td>
				<td width="100%" align="right">
					<b style="font-size: 14px;"><%=FormBaseResove.formatWanMoney(allValue,"")%></b>
				</td>
			</tr>
			<tr>
				<td >
					<div><span class='tipSpan '>投资计划执行进度&nbsp;:</span></div>
				</td>
				<td align="right">
					<b style="font-size: 14px;"><%=percent!=null?TypeUtils.double2String(percent):"0.00"%>%</b>
				</td>
			</tr>
		</table>
	</div>
	<jsp:include page="/jsp/viewChangeTime.jsp">
		<jsp:param  name="lastUpdateDIV" value="gongchengSummary0TimeDIV"/>
	</jsp:include>
<%}else if(index==1){
	double allValue=(Double)request.getAttribute("allValue");
	double projectValue=(Double)request.getAttribute("projectValue");
	double yuZhuanValue=(Double)request.getAttribute("yuZhuanValue");
	double leftValue=(Double)request.getAttribute("leftValue");
%>
<div style="height:100%;" >
	<div style="width:125px;height:100%;float:left" id="zizhuJinSummaryChart">
	</div>
	<div style="margin-left:125px;padding-top:5px;line-height: 22px;margin-right: 2px;">
		<div style='height:8px;width:8px;display: inline-block;background-color:#46C6EF '> </div>
		立项金额 :
		<div style="padding-bottom:3px;text-align: right;"><b style="font-size: 14px;"><%=FormBaseResove.formatWanMoney(projectValue)%></b></div>
		
		<div style='height:8px;width:8px;display: inline-block;background-color:#0080CC '> </div>
		预占未立项金额 :
		<div style="padding-bottom:3px;text-align: right;"><b style="font-size: 14px;"><%=FormBaseResove.formatWanMoney(yuZhuanValue)%></b></div>
		
		<div style='height:8px;width:8px;display: inline-block;background-color:#0ACC4B '> </div>
		剩余金额 :
		<div style="padding-bottom:3px;text-align: right;"><b style="font-size: 14px;"><%=FormBaseResove.formatWanMoney(leftValue)%></b></div>
	</div>
</div>
<jsp:include page="/jsp/viewChangeTime.jsp">
		<jsp:param  name="lastUpdateDIV" value="gongchengSummary1TimeDIV"/>
	</jsp:include>
<script type="text/javascript">
		$("#zizhuJinSummaryChart").highcharts({
	        title: {
	            text:'自主资金池总额<br><b><%=FormBaseResove.formatWanMoney(allValue) %></b>',
	            y:70,
	            x:0,
	            style:{
	            	fontSize: '14px'
	            },
	            floating:true,
	            align:'center'
	        },
	        margin:[2,2,2,2],
	        chart:{
	        	type:'pie'
	        },
	        credits:{
        		enabled:false
        	},
        	 tooltip: {
        		 pointFormatter:function(){
 	                return Highcharts.numberFormat(this.y/10000,2,".",",")+" " ;
        		 },
        		enabled:<%=allValue!=0%>,
 	        },
	        plotOptions:{
	        	pie:{
	        		showInLegend: false,
		        	shadow:false,
		        	allowPointSelect:<%=allValue!=0%>,
		        	innerSize:'80%',
		        	size:120,
		        	states: {
						hover: {
							enabled: false
						}
					},
	        		dataLabels:{
	        			enabled:false
	        		}
	        	}
	        },
	        series: [{
	        	type:'pie',
	        	data:[
	        	      <%if(allValue!=0){%>
	        	      {
	        	    	name:'立项金额',
	        	    	color:'#46C6EF',
	        	    	y:<%=projectValue%>
	        	      },
	        	      {
	        	    	name:'预占未立项金额',
	        	    	color:'#0080CC',
	        	    	y:<%=yuZhuanValue%>
		        	   },
		        	   {
		        	    	name:'剩余金额',
		        	    	color:'#0ACC4B',
		        	    	y:<%=leftValue%>
			        	}
		        	   <%}else{%>
		        	  	 {y:1,color:'<%=HighChartData.COLOR_GRAY%>'}
	        	     	<%}%>
	        	    ]
	        }]
	    });
	
	</script>
<%}else if(index==2){
	int allValue=(Integer)request.getAttribute("allValue");
	int newValue=(Integer)request.getAttribute("newValue");
	int xuValue=(Integer)request.getAttribute("xuValue");
	List<HighChartData> dataList=(List<HighChartData>)request.getAttribute("dataList");
%>
	<div style='width:100%;height:100%;' id="summaryProjectChart">
	</div>
	<jsp:include page="/jsp/viewChangeTime.jsp">
		<jsp:param  name="lastUpdateDIV" value="gongchengSummary3TimeDIV"/>
	</jsp:include>
	<script type="text/javascript">
		$("#summaryProjectChart").highcharts({
	        title: {
	            text:'总数: <b><%=allValue%></b><br/>新建: <b><%=newValue%></b><br/>续建: <b><%=xuValue%><br/></b>',
	            y:55,
	            x:-85,
	            style:{
	            	fontSize: '14px'
	            },
	            floating:true,
	            align:'center'
	        },
	        margin:[2,2,2,2],
	        chart:{
	        	type:'pie'
	        },
	        credits:{
        		enabled:false
        	},
        	legend:{
	        	align:'right',
	            verticalAlign:'middle',
	            layout: 'vertical',
	            labelFormatter:function(){
	              <%if(allValue!=0){%>
       				return this.name+"("+Highcharts.numberFormat(this.y,0,".",",")+")";
       				  <%}else{%>
	                return this.name;
	             <%}%>
       			},
       			x:12
	        },
        	tooltip: {
        		 pointFormatter:function(){
 	                return Highcharts.numberFormat(this.y,0,".",",")+"个 " ;
        		 },
        		enabled:<%=allValue!=0%>,
 	        },
	        plotOptions:{
	        	pie:{
	        		showInLegend: false,
		        	shadow:false,
		        	allowPointSelect:<%=allValue!=0%>,
		        	innerSize:'80%',
		        	size:130,
		        	states: {
						hover: {
							enabled: false
						}
					},
					showInLegend: true,
	        		dataLabels:{
	        			enabled:false
	        		}
	        	}
	        },
	        series: [{
	        	type:'pie',
	        	startAngle: <%=allValue!=0?30:0%>,
	            data: <%if(allValue!=0){%>
	             <%=JSONArray.fromObject(dataList)%> 
	             <%}else{%>
	             [{name:'本 年 暂 无 相 关 数 据!',y:1,color:'<%=HighChartData.COLOR_GRAY%>'}]
	             <%}%>
	             
	        }]
	    });
	
	</script>
<%}else if(index==3){
	double kaizhiTotal=(Double)request.getAttribute("kaizhiTotal");
	double kaizhiActual=(Double)request.getAttribute("kaizhiActual");
	Double kaizhiPerCenter = kaizhiTotal!=0?kaizhiActual/kaizhiTotal*100:0;
	kaizhiPerCenter = kaizhiPerCenter>100?100:kaizhiPerCenter;
	
	double zhuanZiTotal=(Double)request.getAttribute("zhuanZiTotal");
	double zhuanZiActual=(Double)request.getAttribute("zhuanZiActual");
	Double zhuanZiPerCenter = zhuanZiTotal!=0?zhuanZiActual/zhuanZiTotal*100:0;
	zhuanZiPerCenter = zhuanZiPerCenter>100?100:zhuanZiPerCenter;
%>
	<table style="width: 90%;height:100%;margin: 0 auto;">
		<tr>
			<td width="60%">
				<div>资本开支实际&nbsp;:</div>
			</td>
			<td align="right" width="40%">
				<b style="font-size: 14px;"><%=FormBaseResove.formatWanMoney(kaizhiActual,"") %></b>
			</td>
		</tr>
		<tr style="border-bottom:1px solid #D9D9D9;">
			<td>
				<div style='height:8px;background-color:#E8E9ED;'>
					<div style='height:100%;width:<%=kaizhiPerCenter%>%;background-color:#0ACC4B;''></div>
				</div>
			</td>
			<td align="right">
				<div style="color:#0ACC4B;"><b style="font-size: 14px;"><%=TypeUtils.formatNumber(kaizhiPerCenter, 2) %>%</b></div>
			</td>
		</tr>
		<tr>
			<td>
				<div>转资实际&nbsp;:</div>
			</td>
			<td align="right">
				<b style="font-size: 14px;"><%=FormBaseResove.formatWanMoney(zhuanZiActual,"") %></b>
			</td>
		</tr>
		<tr>
			<td>
				<div style='height:8px;background-color:#E8E9ED;'>
					<div style='height:100%;width:<%=zhuanZiPerCenter%>%;background-color:#0ACC4B;''></div>
				</div>
			</td>
			<td align="right">
				<div style="color:#0ACC4B;"><b style="font-size: 14px;"><%=TypeUtils.formatNumber(zhuanZiPerCenter, 2) %>%</b></div>
			</td>
		</tr>
	</table>
	<jsp:include page="/jsp/viewChangeTime.jsp">
		<jsp:param  name="lastUpdateDIV" value="gongchengSummary2TimeDIV"/>
	</jsp:include>
<%}%>