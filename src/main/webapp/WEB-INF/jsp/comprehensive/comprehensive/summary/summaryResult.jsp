<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = request.getContextPath();
Role department=(Role)request.getAttribute("department");
CMCCDepart newDepart = (CMCCDepart)request.getAttribute("newDepart");
boolean isRoot=department.getId()==Role.ROOT_DEPARTMENT_ID;
Integer index=(Integer)request.getAttribute("index");
String subOperation=(String)request.getAttribute("subOperation");
%>
<%if("shouRuSummary".equals(subOperation)){%>
	<%if(isRoot){ 
		double shouRu=(Double)request.getAttribute("shouRu");
		double target=(Double)request.getAttribute("target");
		Double perDouble=target!=0?shouRu/target*100:null;
		List<CommonCode> typeList=(List<CommonCode>)request.getAttribute("typeList");
		Map<Integer,Double> shouRuTypeMap=(Map<Integer,Double>)request.getAttribute("shouRuTypeMap");
	%>
<div style="height:160px;padding-top:10px;position: relative;" >
	<div style="position:absolute;right:-5px; top:-5px;" >
					<div class="showHelpe" onclick="showSummaryShouRuTip(this)"></div>
			</div>
			<div class="helpFloatDIV" id="showSummaryShouRuTipDIV" style="line-height: 22px;">
				<div class="showHelpeContent" style="line-height: 23px;">
					<div>当年收入：指本年分公司真实收入，取自分公司财务报表的收入</div>
				</div>
			</div>
	<div style="width:150px;height:100%;float:left" id="shouRuSummaryChart">
	</div>
	<div style="margin-left:160px;margin-top: 20px;">
		<table style="width: 90%">
			
			<tr>
				<td align="right">
					<div style="margin-top:10px;line-height: 22px;float: right;">
						<div style='height:10px;width:10px;display: inline-block;background-color:#09CC4A '/>&nbsp;&nbsp;实际完成&nbsp;:
					</div>
				</td>
			</tr>
			<tr>
				<td align="right">
					<b style="font-size: 14px;"><%=TypeUtils.formatWanMoney(shouRu)%></b>
				</td>
			</tr>
			<tr>
				<td align="right">
					<b style="font-size: 14px;"><%=perDouble!=null?TypeUtils.double2String(perDouble):"0.00" %>%</b>
				</td>
			</tr>
		</table>
	</div>
</div>
<script type="text/javascript">
		$("#shouRuSummaryChart").highcharts({
	        title: {
	            text:'总额<br><%=TypeUtils.formatWanMoney(target) %>',
	            y:65,
	            x:0,
	            style:{
	            	fontSize: '16px',
	            	fontWeight:'bold'
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
 	                return ""+Highcharts.numberFormat(this.y,2,".",",");
        		 },
        		enabled:<%=shouRu!=0||target!=0%>,
 	        },
	        plotOptions:{
	        	pie:{
	        		showInLegend: false,
		        	shadow:false,
		        	allowPointSelect:<%=shouRu!=0||target!=0%>,
		        	innerSize:'80%',
		        	size:130,
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
	        	      
	        	      <%if(shouRu!=0||target!=0){%>
	        	      {
	        	    	name:'未完成',
	        	    	color:'#CCCCCC',
	        	    	y:<%= target-shouRu>0?(target-shouRu)/10000:0%>
	        	      },
	        	      {
	        	    	name:'完成',
	        	    	color:'#09CC4A',
	        	    	y:<%=shouRu/10000%>
		        	   }
	        	      <%}else{%>
	        	      {y:1,color:'<%=HighChartData.COLOR_GRAY%>'}
	        	      <%}%>
	        	    ]
	        }]
	    });
	
	</script>
	
	<%}else{ %>
		<%if(TypeUtils.getIntFromString(newDepart.getEnum03())==2){ 
			double capexValue=(Double)request.getAttribute("capexValue");
			double opexValue=(Double)request.getAttribute("opexValue");
		%>
			<div style="height:160px;padding-top:10px;" >
			<div style="width:140px;height:100%;float:left;" id="newSummary1">
			</div>
			<div style="margin-left:142px;margin-top: 20px;">
				<table style="width: 90%">
					<tr>
						<td align="right">
							<div style="line-height: 22px;">
								<div style='height:10px;width:10px;display: inline-block;background-color:#05ADF7'> </div>&nbsp;&nbsp;CAPEX&nbsp;:
							</div>
						</td>
					</tr>
					<tr>
						<td align="right">
							<b style="font-size: 14px;line-height: 22px;"><%=TypeUtils.formatWanMoney(capexValue)%></b>
						</td>
					</tr>
					<tr>
						<td align="right">
							<div style="line-height: 22px;">
								<div style='height:10px;width:10px;display: inline-block;background-color:#F8C403'> </div>&nbsp;&nbsp;OPEX&nbsp;:
							</div>
						</td>
					</tr>
					<tr>
						<td align="right">
							<b style="font-size: 14px;line-height: 22px;"><%=TypeUtils.formatWanMoney(opexValue)%></b>
						</td>
					</tr>
				</table>
			</div>
		</div>
		
			<script type="text/javascript">
				$("#newSummary1").highcharts({
			        title: {
			            text:'总额<br><%=TypeUtils.formatWanMoney(capexValue+opexValue) %>',
			            y:65,
			            x:0,
			            style:{
			            	fontSize: '16px',
			            	fontWeight:'bold'
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
		 	                return ""+Highcharts.numberFormat(this.y,2,".",",");
		        		 },
		        		enabled:<%=capexValue!=0||opexValue!=0%>
		 	        },
		            legend: {
			            enabled: true,
			            layout: 'vertical', 
			            align:'right',
			            margin:3,
		 	        	padding:3,
		 	        	itemMarginBottom:5,
		 	        	itemMarginTop:6,
			            verticalAlign: 'middle',
			            labelFormatter:function(){
			            	return this.name +":"+"<br/><b>"+Highcharts.numberFormat(this.y,2,".",",")+"</b>";
			            }
			        },
			        plotOptions:{
			        	pie:{
			        		showInLegend: false,
				        	shadow:false,
				        	allowPointSelect:false,
				        	innerSize:'80%',
				        	size:130,
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
			        	      <%if(capexValue!=0||opexValue!=0){%>
			        	      {
			        	    	name:'CAPEX',
			        	    	color:'#05ADF7',
			        	    	y:<%=capexValue/10000%>
			        	      },
			        	      {
			        	    	name:'OPEX',
			        	    	color:'#F8C403',
			        	    	y:<%=opexValue/10000%>
				        	   }
			        	      <%}else{%>
			        	     	 {y:1,color:'<%=HighChartData.COLOR_GRAY%>'}
			        	      <%}%>
			        	    ]
			        }]
			    });
			</script>
		<%}else{ 
			double shouRu=(Double)request.getAttribute("shouRu");
			double target=(Double)request.getAttribute("target");
			Double perDouble=target!=0?shouRu/target*100:null;
			List<CommonCode> typeList=(List<CommonCode>)request.getAttribute("typeList");
			Map<Integer,Double> shouRuTypeMap=(Map<Integer,Double>)request.getAttribute("shouRuTypeMap");
		%>
		<div style='width:90%;margin:0 auto;position: relative;'>
		
			<div style="position:absolute;right:-15px; top:-5px;" >
					<div class="showHelpe" onclick="showSummaryShouRuTip(this)"></div>
			</div>
			<div class="helpFloatDIV" id="showSummaryShouRuTipDIV" style="line-height: 22px;max-width:700px;">
				<div class="showHelpeContent" style="line-height: 23px;">
					<div>
					部门收入：分部门的销售支撑、运营支撑、产品销售、产品合作收入的汇总值。<br>
销售支撑收入：政企分公司直接签约销售全网产品与省公司产品，销售收入全额结算给省公司，省公司从成本中支出销售收入的5%作为销售支撑费结算给政企。<br>
运营支撑收入：政企分公司面向省公司提供涉及全网集中运营产品（需总部认定）、重点项目（如双跨IMS、行业WLAN、视频监控、和对讲(POC)、云MAS等）的统一运营支撑，省公司从成本中支出运营支撑费结算给政企。<br>
产品销售收入：政企签约销售政企自有产品，政企分公司100%确认收入，使用省公司/其他公司（铁通、国际公司等）资源的部分，从分公司成本中支出资源成本价给相关单位。<br>
产品合作收入：省公司签约销售政企自有产品，各省按照结算方案采取收入分成或成本结算模式结算给政企（不同产品具体结算方案不一样）<br>
					</div>
				</div>
			</div>
			<div style='font-size:16px;text-align: center;padding:3px;font-weight: bold;'><%=TypeUtils.formatWanMoney(shouRu) %></div>
			<div style='width:95%;margin:3px auto;height:8px;background-color:#E8E9ED;'>
					<div style=' height:100%;width:<%=perDouble!=null?(perDouble<100?perDouble:100):"0"%>%;background-color:#0ACC4B'></div>
			</div>
			<table style="width:98%"><tr><td width="45%">计划&nbsp;:&nbsp;</td><td width="55%" align="right"><b style="font-size: 14px;"><%=TypeUtils.formatWanMoney(target) %> </b></td></tr>
			<tr><td width="45%">
				完成比例&nbsp;:&nbsp;</td><td align="right"><b style="font-size: 14px;"><%=perDouble!=null?TypeUtils.double2String(perDouble):"0.00" %>%</b></td></tr>
			<tr><td colspan="2"><div style="border-bottom:1px solid #EBE8EF"/></td></tr>
			<%for(int i=0,j=typeList.size();i<j&&i<4;i++){ 
			CommonCode c=typeList.get(i);
			Double v=shouRuTypeMap.get(c.getId());
			%>
			<tr><td width="45%"><%=TypeUtils.xmlEncoderForIE(c.getName()) %>:</td><td align="right"><b style="font-size: 14px;"><%=v!=null?TypeUtils.formatWanMoney(v, TypeUtils.MONEY_P)+"":"0"%> </b></td></tr>
			<%} %>
			</table>
		</div>
		<%} %>
	<%} %>
	<jsp:include page="/WEB-INF/jsp/common/viewChangeTime.jsp">
			<jsp:param  name="lastUpdateDIV" value="shouRuSummaryTime"/>
		</jsp:include>
<%}else if("doTouzhiSummary".equals(subOperation)){
	if(TypeUtils.getIntFromString(newDepart.getEnum03())==2){
		int capexCount=(Integer)request.getAttribute("capexCount");
		int opexCount=(Integer)request.getAttribute("opexCount");
	%>
<div style="height:160px;padding-top:10px;position: relative;" >
	<div style="position:absolute;right:-5px; top:-5px;" >
		<div class="showHelpe" onclick="showTouziSummaryTip(this)"></div>
	</div>
	<div class="helpFloatDIV" id="showTouziSummaryTipDIV" style="line-height: 22px;">
		<div class="showHelpeContent" style="line-height: 23px;">
			<div>OPEX:包含立项制项</div>
		</div>
	</div>
	<div style="width:140px;height:100%;float:left;" id="newSummary2">
	</div>
	<div style="margin-left:142px;margin-top: 20px;">
		<table style="width: 90%">
			<tr>
				<td align="right">
					<div style="line-height: 22px;">
						<div style='height:10px;width:10px;display: inline-block;background-color:#05ADF7'> </div>&nbsp;&nbsp;CAPEX&nbsp;: 
					</div>
				</td>
			</tr>
			<tr>
				<td align="right">
					新建&nbsp;<b style="font-size: 14px;line-height: 22px;"><%=capexCount%></b>&nbsp;项
				</td>
			</tr>
			<tr>
				<td align="right">
					<div style="line-height: 22px;">
						<div style='height:10px;width:10px;display: inline-block;background-color:#F8C403'> </div>&nbsp;&nbsp;OPEX&nbsp;: 
					</div>
				</td>
			</tr>
			<tr>
				<td align="right">
					全部&nbsp;<b style="font-size: 14px;line-height: 22px;"><%=opexCount%></b>&nbsp;项
				</td>
			</tr>
		</table>
	</div>
</div>
	<script type="text/javascript">
		$("#newSummary2").highcharts({
	        title: {
	            text:'总数<br><%=capexCount+opexCount %>项',
	            y:65,
	            x:0,
	            style:{
	            	fontSize: '16px',
	            	fontWeight:'bold'
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
 	                return ""+this.series.data[this.index]["count"]+"项" ;
        		 },
        		enabled:<%=capexCount!=0||opexCount!=0%>
 	        },
            legend: {
	            enabled: true,
	            layout: 'vertical', 
	            align:'right',
	            margin:3,
 	        	padding:3,
 	        	itemMarginBottom:5,
 	        	itemMarginTop:6,
	            verticalAlign: 'middle',
	            labelFormatter:function(){
	            	return this.name +":<b>"+this.series.data[this.index]["count"]+"</b>项";
	            }
	        },
	        plotOptions:{
	        	pie:{
	        		showInLegend: false,
		        	shadow:false,
		        	allowPointSelect:false,
		        	innerSize:'80%',
		        	size:130,
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
	        	      <%if(capexCount!=0||opexCount!=0){%>
	        	      {
	        	    	name:'CAPEX',
	        	    	color:'#05ADF7',
	        	    	y:<%=capexCount%>
	        	      	,count:<%=capexCount%>
	        	      },
	        	      {
	        	    	name:'OPEX',
	        	    	color:'#F8C403',
	        	    	y:<%=opexCount%>
	        	      	,count:<%=opexCount%>
		        	   }
	        	      <%}else{%>
	        	     	 {y:1,color:'<%=HighChartData.COLOR_GRAY%>'}
	        	      <%}%>
	        	    ]
	        }]
	    });
	</script>
	<%}else{
		double capexValue=(Double)request.getAttribute("capexValue");
		double opexValue=(Double)request.getAttribute("opexValue");
		int capexCount=(Integer)request.getAttribute("capexCount");
		int opexCount=(Integer)request.getAttribute("opexCount");
	%>
<div style="height:160px;padding-top:10px;position: relative;" >
	<div style="position:absolute;right:-5px; top:-5px;" >
		<div class="showHelpe" onclick="showTouziSummaryTip(this)"></div>
	</div>
	<div class="helpFloatDIV" id="showTouziSummaryTipDIV" style="line-height: 22px;">
		<div class="showHelpeContent" style="line-height: 23px;">
			<div>OPEX:包含立项制项</div>
		</div>
	</div>
	<div style="width:140px;height:100%;float:left;" id="touziChart">
	</div>
	<div style="margin-left:142px;margin-top: 20px;">
		<table style="width: 90%">
			<tr>
				<td align="right">
					<div style="line-height: 22px;">
						<div style='height:10px;width:10px;display: inline-block;background-color:#05ADF7'> </div>&nbsp;&nbsp;CAPEX&nbsp;: 
					</div>
				</td>
			</tr>
			<tr>
				<td align="right">
					新建&nbsp;<b style="font-size: 14px;line-height: 22px;"><%=capexCount%></b>&nbsp;项
				</td>
			</tr>
			<tr>
				<td align="right">
					<b style="font-size: 14px;line-height: 22px;"><%=TypeUtils.formatWanMoney(capexValue)%></b>
				</td>
			</tr>
			<tr>
				<td align="right">
					<div style="line-height: 22px;">
						<div style='height:10px;width:10px;display: inline-block;background-color:#F8C403'> </div>&nbsp;&nbsp;OPEX&nbsp;: 
					</div>
				</td>
			</tr>
			<tr>
				<td align="right">
					全部&nbsp;<b style="font-size: 14px;line-height: 22px;"><%=opexCount%></b>&nbsp;项
				</td>
			</tr>
			<tr>
				<td align="right">
					<b style="font-size: 14px;line-height: 22px;"><%=TypeUtils.formatWanMoney(opexValue)%></b>
				</td>
			</tr>
		</table>
	</div>
</div>
	<script type="text/javascript">
		$("#touziChart").highcharts({
	        title: {
	            text:'总额<br><%=TypeUtils.formatWanMoney(capexValue+opexValue) %>',
	            y:65,
	            x:0,
	            style:{
	            	fontSize: '16px',
	            	fontWeight:'bold'
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
 	                return ""+Highcharts.numberFormat(this.y,2,".",",")+"<br/>"+this.series.data[this.index]["count"]+"项" ;
        		 },
        		enabled:<%=capexValue!=0||opexValue!=0%>
 	        },
            legend: {
	            enabled: true,
	            layout: 'vertical', 
	            align:'right',
	            margin:3,
 	        	padding:3,
 	        	itemMarginBottom:5,
 	        	itemMarginTop:6,
	            verticalAlign: 'middle',
	            labelFormatter:function(){
	            	return this.name +":<b>"+this.series.data[this.index]["count"]+"</b>项<br/><b>"+Highcharts.numberFormat(this.y,2,".",",")+"</b>";
	            }
	        },
	        plotOptions:{
	        	pie:{
	        		showInLegend: false,
		        	shadow:false,
		        	allowPointSelect:false,
		        	innerSize:'80%',
		        	size:130,
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
	        	      <%if(capexValue!=0||opexValue!=0){%>
	        	      {
	        	    	name:'CAPEX',
	        	    	color:'#05ADF7',
	        	    	y:<%=capexValue/10000%>
	        	      	,count:<%=capexCount%>
	        	      },
	        	      {
	        	    	name:'OPEX',
	        	    	color:'#F8C403',
	        	    	y:<%=opexValue/10000%>
	        	      	,count:<%=opexCount%>
		        	   }
	        	      <%}else{%>
	        	     	 {y:1,color:'<%=HighChartData.COLOR_GRAY%>'}
	        	      <%}%>
	        	    ]
	        }]
	    });
	
	</script>
	<%} %>
	<jsp:include page="/WEB-INF/jsp/common/viewChangeTime.jsp">
		<jsp:param  name="lastUpdateDIV" value="doTouzhiSummaryTime"/>
</jsp:include>
<%}else if("doTouziProcessSummary".equals(subOperation)){
	double capexValue=(Double)request.getAttribute("capexValue");
	double opexValue=(Double)request.getAttribute("opexValue");
	double capexProcess=(Double)request.getAttribute("capexProcess");
	double opexProcess=(Double)request.getAttribute("opexProcess");
%>
	<div style="width:95%;margin:0px auto;">
			<div style="padding-top:10px;">
				<%
					Double capexPercent=capexValue!=0?capexProcess/capexValue*100:null;
					capexPercent = capexPercent!=null?capexPercent>100?100:capexPercent:0;
				%>
				<div>新建项目投资计划进度&nbsp;:</div>
				<div style="width: 100%;text-align: right;"><b style="font-size: 20px;"><%=TypeUtils.formatNumber(capexPercent, 2) %>%</b></div>
				<div style='width:100%;height:8px;background-color:#E8E9ED;margin: 10px auto;'>
					<div style='height:100%;width:<%=capexPercent%>%;background-color:#0ACC4B;''></div>
				</div>
			 
			 	<%
					Double opexPercent=opexValue!=0?opexProcess/opexValue*100:null;
					opexPercent = opexPercent!=null?opexPercent>100?100:opexPercent:0;
				%>
			 	<div style="margin-top: 20px;">预算进度&nbsp;:</div>
				<div style="width: 100%;text-align: right;"><b style="font-size: 20px;"><%=TypeUtils.formatNumber(opexPercent, 2) %>%</b></div>
				<div style='width:100%;height:8px;background-color:#E8E9ED;margin: 10px auto;'>
					<div style='height:100%;width:<%=opexPercent%>%;background-color:#0ACC4B;'></div>
				</div>
		 </div>
	</div>
	<jsp:include page="/WEB-INF/jsp/common/viewChangeTime.jsp">
		<jsp:param  name="lastUpdateDIV" value="doTouziProcessSummaryTime"/>
	</jsp:include>
<%}else if("kaizhiAndZhuanZhiSummary".equals(subOperation)){%>
	<div style="width:94%;margin:0px auto;height:100%">
		<%
		double kaizhiTotal=(Double)request.getAttribute("kaizhiTotal");
		double kaizhiPlan=(Double)request.getAttribute("kaizhiPlan");
		double kaizhiActual=(Double)request.getAttribute("kaizhiActual");
		Double kaizhiPerCenter=kaizhiPlan!=0?kaizhiActual/kaizhiPlan*100:null;
		if(isRoot){
			kaizhiPerCenter = kaizhiTotal!=0?kaizhiActual/kaizhiTotal*100:null;
		}
		kaizhiPerCenter = kaizhiPerCenter!=null?kaizhiPerCenter>100?100:kaizhiPerCenter:0;
		
		double opexPlan=(Double)request.getAttribute("opexPlan");
		double opexActual=(Double)request.getAttribute("opexActual");
		Double opexPerCenter=opexPlan!=0?opexActual/opexPlan*100:null;
		opexPerCenter = opexPerCenter!=null?opexPerCenter>100?100:opexPerCenter:0;
		
		double zhuanziPlan=(Double)request.getAttribute("zhuanziPlan");
		double zhuanziTotal=(Double)request.getAttribute("zhuanziTotal");
		double zhuanziActual=(Double)request.getAttribute("zhuanziActual");
		Double zhuanziPerCenter=zhuanziPlan!=0?zhuanziActual/zhuanziPlan*100:null;
		if(isRoot){
			zhuanziPerCenter = zhuanziTotal!=0?zhuanziActual/zhuanziTotal*100:null;
		}
		zhuanziPerCenter = zhuanziPerCenter!=null?zhuanziPerCenter>100?100:zhuanziPerCenter:0;
		
		%>
		<table style="width: 100%;height: 100%">
			<tr>
				<td width="60%">
					<div style="line-height: 23px;">资本开支实际&nbsp;:</div>
				</td>
				<td width="40%" align="right">
					<b style="font-size: 14px;"><%=TypeUtils.formatWanMoney(kaizhiActual) %></b>
				</td>
			</tr>
			<tr style="border-bottom:1px solid  #D9D9D9;">
				<td>
					<div style='height:8px;background-color:#E8E9ED;'>
						<div style='height:100%;width:<%=kaizhiPerCenter%>%;background-color:#0ACC4B;''></div>
					</div>
				</td>
				<td align="right">
					<div style="color:#0ACC4B;">
						<b style="font-size: 14px;"><%=TypeUtils.formatNumber(kaizhiPerCenter, 2) %>%</b>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div style="line-height: 23px;">转资实际&nbsp;:</div>
				</td>
				<td align="right">
					<b style="font-size: 14px;"><%=TypeUtils.formatWanMoney(zhuanziActual) %></b>
				</td>
			</tr>
			<tr style="border-bottom:1px solid  #D9D9D9;">
				<td>
					<div style='height:8px;background-color:#E8E9ED;'>
						<div style='height:100%;width:<%=zhuanziPerCenter%>%;background-color:#0ACC4B;''></div>
					</div>
				</td>
				<td align="right">
					<div style="color:#0ACC4B;">
						<b style="font-size: 14px;"><%=TypeUtils.formatNumber(zhuanziPerCenter, 2) %>%</b>
					</div>
				</td>
			</tr>
			
			<tr>
				<td>
					<div style="line-height: 23px;">成本开支实际&nbsp;:</div>
				</td>
				<td align="right">
					<b style="font-size: 14px;"><%=TypeUtils.formatWanMoney(opexActual) %></b>
				</td>
			</tr>
			<tr>
				<td>
					<div style='height:8px;background-color:#E8E9ED;'>
						<div style='height:100%;width:<%=opexPerCenter%>%;background-color:#0ACC4B;''></div>
					</div>
				</td>
				<td align="right">
					<div style="color:#0ACC4B;">
						<b style="font-size: 14px;"><%=TypeUtils.formatNumber(opexPerCenter, 2) %>%</b>
					</div>
				</td>
			</tr>
		</table>
	</div>	
	<jsp:include page="/WEB-INF/jsp/common/viewChangeTime.jsp">
		<jsp:param  name="lastUpdateDIV" value="kaizhiAndZhuanZhiSummaryTime"/>
	</jsp:include>
<%}%>
