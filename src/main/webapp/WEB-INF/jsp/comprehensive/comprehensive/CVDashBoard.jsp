<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- 输出head模块 --%>
<jsp:include page="../../common/Head.jsp" />
<body>
	<%-- 输出系统顶级模块的菜单 --%>
	<jsp:include page="../../common/TopMenu.jsp">
		<jsp:param name="appid" value="1" />
		<jsp:param name="url" value="/comprehensiveview" />
	</jsp:include>
	<div class="container  " id="bodyStart_container" style="top: 50px">
<%-- 		<jsp:include page="../../common/Banner.jsp" /> --%>
		<div id="propDIV" class="yibiao_start dumascroll"
			style="overflow: hidden; height: 10px;">
			<div class=" dumascroll_area showYScroll">
				<div style="width: 1000px; margin: 0 auto;">
					<style>
.tipSpan {
	text-align: right;
	padding-left: 10px;
	padding-right: 10px;
	white-space: nowrap;
	line-height: 23px;
}

.tipSpan2 {
	font-weight: bold;
}

.sumTitle {
	font-size: 14px;
	line-height: 40px;
	font-weight: bold;
	color: #FFF;
	background-color: #03A9F4;
	text-align: center;
}

.sumValue {
	line-height: 24px;
	padding-top: 10px;
	text-align: center;
	color: #0ACC4B;
	font-size: 14px;
}

.sumContainer1 {
	border: 1px solid #D9D9D9;
	border-top: none;
}

.capexColumn {
	text-align: center;
	line-height: 30px;
	font-size: 14px;
}

.infoLabel {
	padding-left: 10px;
	white-space: nowrap;
	line-height: 25px;
	padding-right: 10px;
}

.tdBorder {
	margin: 4px 0px;
	border-bottom: 1px dotted #D9D9D9;
}
</style>
					<div>
						<table style="width: 1000px; margin: 10px auto;">
							<tbody>
								<tr>
									<td style="width: 27%; vertical-align: top;">
										<div style="margin-right: 10px;">
											<div class="sumTitle">本年分公司真实收入</div>
											<div class="sumContainer1" style="height: 170px;"
												id="shouRuSummary">
												<div
													style="height: 160px; padding-top: 10px; position: relative;">
													<div style="position: absolute; right: -5px; top: -5px;">
														<div class="showHelpe"
															onclick="showSummaryShouRuTip(this)"></div>
													</div>
													<div class="helpFloatDIV" id="showSummaryShouRuTipDIV"
														style="line-height: 22px;">
														<div class="showHelpeContent" style="line-height: 23px;">
															<div>当年收入：指本年分公司真实收入，取自分公司财务报表的收入</div>
														</div>
													</div>
													<div style="width: 150px; height: 100%; float: left"
														id="shouRuSummaryChart" data-highcharts-chart="0">
														<div class="highcharts-container" id="highcharts-0"
															style="position: relative; overflow: hidden; width: 150px; height: 160px; text-align: left; line-height: normal; z-index: 0; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);">
															<svg version="1.1"
																style="font-family: &amp; quot; Lucida Grande&amp;quot; , &amp; quot; Lucida Sans Unicode&amp;quot; , Arial , Helvetica, sans-serif; font-size: 12px;"
																xmlns="http://www.w3.org/2000/svg" width="150"
																height="160">
																<desc>Created with Highcharts 4.1.3</desc>
																<defs>
																<clipPath id="highcharts-1">
																<rect x="0" y="0" width="130" height="135"></rect></clipPath></defs>
																<rect x="0" y="0" width="150" height="160"
																	strokeWidth="0" fill="#FFFFFF"
																	class=" highcharts-background"></rect>
																<g class="highcharts-series-group" zIndex="3">
																<g class="highcharts-series highcharts-tracker"
																	visibility="visible" zIndex="0.1"
																	transform="translate(10,10) scale(1 1)" style="">
																<path fill="#D8D8D8"
																	d="M 64.98676124175981 2.5000013481901675 A 65 65 0 1 1 64.90971630402535 2.500062701151464 L 64.92777304322027 15.50005016092117 A 52 52 0 1 0 64.98940899340785 15.500001078552131 Z"
																	stroke="#FFFFFF" stroke-width="1"
																	stroke-linejoin="round" transform="translate(0,0)"></path></g>
																<g class="highcharts-markers" visibility="visible"
																	zIndex="0.1" transform="translate(10,10) scale(1 1)"></g></g>
																<text x="75" text-anchor="middle"
																	class="highcharts-title" zIndex="4"
																	style="color:#333333;font-size:16px;font-weight:bold;fill:#333333;width:86px;"
																	y="75">
																<tspan>总额</tspan>
																<tspan x="75" dy="19">0</tspan></text>
																<g class="highcharts-legend" zIndex="7">
																<g zIndex="1">
																<g></g></g></g></svg>
														</div>
													</div>
													<div style="margin-left: 160px; margin-top: 20px;">
														<table style="width: 90%">
															<tbody>
																<tr>
																	<td align="right">
																		<div
																			style="margin-top: 10px; line-height: 22px; float: right;">
																			<div
																				style="height: 10px; width: 10px; display: inline-block; background-color: #09CC4A"></div>
																			&nbsp;&nbsp;实际完成&nbsp;:
																		</div>
																	</td>
																</tr>
																<tr>
																	<td align="right"><b style="font-size: 14px;">0</b>
																	</td>
																</tr>
																<tr>
																	<td align="right"><b style="font-size: 14px;">0.00%</b>
																	</td>
																</tr>
															</tbody>
														</table>
													</div>
												</div>
												<script type="text/javascript">
		$("#shouRuSummaryChart").highcharts({
	        title: {
	            text:'总额<br>0',
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
        		enabled:false,
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
	        	      
	        	      
	        	      {y:1,color:'#D8D8D8'}
	        	      
	        	    ]
	        }]
	    });
	
</script>
												<script type="text/javascript">
	$("#shouRuSummaryTime").html("").append($("#shouRuSummaryTimeSpan"));
</script>
											</div>
											<div id="shouRuSummaryTime" class="viewChangeTime"></div>
										</div>
									</td>

									<td style="width: 27%; vertical-align: top;">
										<div style="margin-right: 10px;">

											<div class="sumTitle">新建项目投资/OPEX预算</div>

											<div class="sumContainer1" style="height: 170px;"
												id="doTouzhiSummary">
												<div
													style="height: 160px; padding-top: 10px; position: relative;">
													<div style="position: absolute; right: -5px; top: -5px;">
														<div class="showHelpe" onclick="showTouziSummaryTip(this)"></div>
													</div>
													<div class="helpFloatDIV" id="showTouziSummaryTipDIV"
														style="line-height: 22px;">
														<div class="showHelpeContent" style="line-height: 23px;">
															<div>OPEX:包含立项制项</div>
														</div>
													</div>
													<div style="width: 140px; height: 100%; float: left;"
														id="touziChart" data-highcharts-chart="1">
														<div class="highcharts-container" id="highcharts-2"
															style="position: relative; overflow: hidden; width: 140px; height: 160px; text-align: left; line-height: normal; z-index: 0; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);">
															<svg version="1.1"
																style="font-family: &amp; quot; Lucida Grande&amp;quot; , &amp; quot; Lucida Sans Unicode&amp;quot; , Arial , Helvetica, sans-serif; font-size: 12px;"
																xmlns="http://www.w3.org/2000/svg" width="140"
																height="160">
																<desc>Created with Highcharts 4.1.3</desc>
																<defs>
																<clipPath id="highcharts-3">
																<rect x="0" y="0" width="120" height="135"></rect></clipPath></defs>
																<rect x="0" y="0" width="140" height="160"
																	strokeWidth="0" fill="#FFFFFF"
																	class=" highcharts-background"></rect>
																<g class="highcharts-series-group" zIndex="3">
																<g class="highcharts-series highcharts-tracker"
																	visibility="visible" zIndex="0.1"
																	transform="translate(10,10) scale(1 1)" style="">
																<path fill="#05ADF7"
																	d="M 59.986761241759815 2.5000013481901675 A 65 65 0 0 1 124.99987000004333 67.62999991333335 L 111.99989600003467 67.60399993066667 A 52 52 0 0 0 59.98940899340785 15.500001078552131 Z"
																	stroke="#FFFFFF" stroke-width="1"
																	stroke-linejoin="round" transform="translate(0,0)"></path>
																<path fill="#F8C403"
																	d="M 124.99970750021937 67.69499970750013 A 65 65 0 1 1 59.909716304025345 2.500062701151464 L 59.92777304322028 15.50005016092117 A 52 52 0 1 0 111.9997660001755 67.6559997660001 Z"
																	stroke="#FFFFFF" stroke-width="1"
																	stroke-linejoin="round" transform="translate(0,0)"></path></g>
																<g class="highcharts-markers" visibility="visible"
																	zIndex="0.1" transform="translate(10,10) scale(1 1)"></g></g>
																<text x="70" text-anchor="middle"
																	class="highcharts-title" zIndex="4"
																	style="color:#333333;font-size:16px;font-weight:bold;fill:#333333;width:76px;"
																	y="75">
																<tspan>总额</tspan>
																<tspan x="70" dy="19">296,112.52</tspan>
																<title>总额296,112.52</title></text>
																<g class="highcharts-legend" zIndex="7">
																<g zIndex="1">
																<g></g></g></g>
																<g class="highcharts-tooltip" zIndex="8"
																	style="cursor:default;padding:0;white-space:nowrap;"
																	transform="translate(0,-9999)">
																<path fill="none"
																	d="M 3 0 L 13 0 C 16 0 16 0 16 3 L 16 13 C 16 16 16 16 13 16 L 3 16 C 0 16 0 16 0 13 L 0 3 C 0 0 0 0 3 0"
																	isShadow="true" stroke="black"
																	stroke-opacity="0.049999999999999996" stroke-width="5"
																	transform="translate(1, 1)"></path>
																<path fill="none"
																	d="M 3 0 L 13 0 C 16 0 16 0 16 3 L 16 13 C 16 16 16 16 13 16 L 3 16 C 0 16 0 16 0 13 L 0 3 C 0 0 0 0 3 0"
																	isShadow="true" stroke="black"
																	stroke-opacity="0.09999999999999999" stroke-width="3"
																	transform="translate(1, 1)"></path>
																<path fill="none"
																	d="M 3 0 L 13 0 C 16 0 16 0 16 3 L 16 13 C 16 16 16 16 13 16 L 3 16 C 0 16 0 16 0 13 L 0 3 C 0 0 0 0 3 0"
																	isShadow="true" stroke="black" stroke-opacity="0.15"
																	stroke-width="1" transform="translate(1, 1)"></path>
																<path fill="rgba(249, 249, 249, .85)"
																	d="M 3 0 L 13 0 C 16 0 16 0 16 3 L 16 13 C 16 16 16 16 13 16 L 3 16 C 0 16 0 16 0 13 L 0 3 C 0 0 0 0 3 0"></path>
																<text x="8" zIndex="1"
																	style="font-size:12px;color:#333333;fill:#333333;"
																	y="20"></text></g></svg>
														</div>
													</div>
													<div style="margin-left: 142px; margin-top: 20px;">
														<table style="width: 90%">
															<tbody>
																<tr>
																	<td align="right">
																		<div style="line-height: 22px;">
																			<div
																				style="height: 10px; width: 10px; display: inline-block; background-color: #05ADF7">
																			</div>
																			&nbsp;&nbsp;CAPEX&nbsp;:
																		</div>
																	</td>
																</tr>
																<tr>
																	<td align="right">新建&nbsp;<b
																		style="font-size: 14px; line-height: 22px;">0</b>&nbsp;项
																	</td>
																</tr>
																<tr>
																	<td align="right"><b
																		style="font-size: 14px; line-height: 22px;">74,156.20</b>
																	</td>
																</tr>
																<tr>
																	<td align="right">
																		<div style="line-height: 22px;">
																			<div
																				style="height: 10px; width: 10px; display: inline-block; background-color: #F8C403">
																			</div>
																			&nbsp;&nbsp;OPEX&nbsp;:
																		</div>
																	</td>
																</tr>
																<tr>
																	<td align="right">全部&nbsp;<b
																		style="font-size: 14px; line-height: 22px;">387</b>&nbsp;项
																	</td>
																</tr>
																<tr>
																	<td align="right"><b
																		style="font-size: 14px; line-height: 22px;">221,956.32</b>
																	</td>
																</tr>
															</tbody>
														</table>
													</div>
												</div>
												<script type="text/javascript">
		$("#touziChart").highcharts({
	        title: {
	            text:'总额<br>296,112.52',
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
        		enabled:true
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
	        	      
	        	      {
	        	    	name:'CAPEX',
	        	    	color:'#05ADF7',
	        	    	y:74156.2
	        	      	,count:0
	        	      },
	        	      {
	        	    	name:'OPEX',
	        	    	color:'#F8C403',
	        	    	y:221956.32354800004
	        	      	,count:387
		        	   }
	        	      
	        	    ]
	        }]
	    });
	
	</script>
												<script type="text/javascript">
	$("#doTouzhiSummaryTime").html("").append($("#doTouzhiSummaryTimeSpan"));
</script>

											</div>
											<div id="doTouzhiSummaryTime" class="viewChangeTime">
												<span id="doTouzhiSummaryTimeSpan" class="viewChangeSpan  ">数据更新时间:2小时前</span>
											</div>
										</div>
									</td>
									<td style="width: 23%; vertical-align: top;">
										<div style="margin-right: 10px;">
											<div class="sumTitle">投资计划/预算执行进度</div>
											<div class="sumContainer1" style="height: 170px;"
												id="doTouziProcessSummary">
												<div style="width: 95%; margin: 0px auto;">
													<div style="padding-top: 10px;">

														<div>新建项目投资计划进度&nbsp;:</div>
														<div style="width: 100%; text-align: right;">
															<b style="font-size: 20px;">0.00%</b>
														</div>
														<div
															style="width: 100%; height: 8px; background-color: #E8E9ED; margin: 10px auto;">
															<div
																style="height: 100%; width: 0.0%; background-color: #0ACC4B;"'=""></div>
														</div>


														<div style="margin-top: 20px;">预算进度&nbsp;:</div>
														<div style="width: 100%; text-align: right;">
															<b style="font-size: 20px;">8.60%</b>
														</div>
														<div
															style="width: 100%; height: 8px; background-color: #E8E9ED; margin: 10px auto;">
															<div
																style="height: 100%; width: 8.604813009920704%; background-color: #0ACC4B;"></div>
														</div>
													</div>
												</div>
												<script type="text/javascript">
	$("#doTouziProcessSummaryTime").html("").append($("#doTouziProcessSummaryTimeSpan"));
</script>

											</div>
											<div id="doTouziProcessSummaryTime" class="viewChangeTime">
												<span id="doTouziProcessSummaryTimeSpan"
													class="viewChangeSpan  ">数据更新时间:1天前</span>
											</div>
										</div>
									</td>
									<td style="width: 23%; vertical-align: top;">
										<div>
											<div class="sumTitle">开支、转资进度</div>
											<div class="sumContainer1" style="height: 170px;"
												id="kaizhiAndZhuanZhiSummary">
												<div style="width: 94%; margin: 0px auto; height: 100%">

													<table style="width: 100%; height: 100%">
														<tbody>
															<tr>
																<td width="60%">
																	<div style="line-height: 23px;">资本开支实际&nbsp;:</div>
																</td>
																<td width="40%" align="right"><b
																	style="font-size: 14px;">43,013.83</b></td>
															</tr>
															<tr style="border-bottom: 1px solid #D9D9D9;">
																<td>
																	<div style="height: 8px; background-color: #E8E9ED;">
																		<div
																			style="height: 100%; width: 0.0%; background-color: #0ACC4B;"'=""></div>
																	</div>
																</td>
																<td align="right">
																	<div style="color: #0ACC4B;">
																		<b style="font-size: 14px;">0.00%</b>
																	</div>
																</td>
															</tr>
															<tr>
																<td>
																	<div style="line-height: 23px;">转资实际&nbsp;:</div>
																</td>
																<td align="right"><b style="font-size: 14px;">27,318.35</b>
																</td>
															</tr>
															<tr style="border-bottom: 1px solid #D9D9D9;">
																<td>
																	<div style="height: 8px; background-color: #E8E9ED;">
																		<div
																			style="height: 100%; width: 0.0%; background-color: #0ACC4B;"'=""></div>
																	</div>
																</td>
																<td align="right">
																	<div style="color: #0ACC4B;">
																		<b style="font-size: 14px;">0.00%</b>
																	</div>
																</td>
															</tr>

															<tr>
																<td>
																	<div style="line-height: 23px;">成本开支实际&nbsp;:</div>
																</td>
																<td align="right"><b style="font-size: 14px;">0</b>
																</td>
															</tr>
															<tr>
																<td>
																	<div style="height: 8px; background-color: #E8E9ED;">
																		<div
																			style="height: 100%; width: 0.0%; background-color: #0ACC4B;"'=""></div>
																	</div>
																</td>
																<td align="right">
																	<div style="color: #0ACC4B;">
																		<b style="font-size: 14px;">0.00%</b>
																	</div>
																</td>
															</tr>
														</tbody>
													</table>
												</div>
												<script type="text/javascript">
	$("#kaizhiAndZhuanZhiSummaryTime").html("").append($("#kaizhiAndZhuanZhiSummaryTimeSpan"));
</script>

											</div>
											<div id="kaizhiAndZhuanZhiSummaryTime" class="viewChangeTime">
												<span id="kaizhiAndZhuanZhiSummaryTimeSpan"
													class="viewChangeSpan  ">数据更新时间:2017-05-07</span>
											</div>
										</div>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					<script type="text/javascript">
function showSummaryShouRuTip(obj){
	var detaiObj=obj.detaiObj;
	if(detaiObj==null){
		detaiObj=new ET.FloatDIV("showSummaryShouRuTipDIV");
		obj.detaiObj=detaiObj;
		ET.Utils.addEvent(detaiObj.sourceElement,'mouseover',function(){
			window.clearTimeout(detaiObj.hideID);
		})
		ET.Utils.addEvent(detaiObj.sourceElement,'mouseout',function(){
			detaiObj.hideID=window.setTimeout(function(){
				detaiObj.hide();
			},500)
		})
	}
	detaiObj.popup(obj,{
		x:2,
		y:3
	})
	
}
function showTouziSummaryTip(obj){
	var detaiObj=obj.detaiObj;
	if(detaiObj==null){
		detaiObj=new ET.FloatDIV("showTouziSummaryTipDIV");
		obj.detaiObj=detaiObj;
		ET.Utils.addEvent(detaiObj.sourceElement,'mouseover',function(){
			window.clearTimeout(detaiObj.hideID);
		})
		ET.Utils.addEvent(detaiObj.sourceElement,'mouseout',function(){
			detaiObj.hideID=window.setTimeout(function(){
				detaiObj.hide();
			},500)
		})
	}
	detaiObj.popup(obj,{
		x:2,
		y:3
	})
	
}

/* jQuery(document).ready(function(){
	var doAjax=function(subOperation){
		$.ajax({
			url:"/ZongheAction.do?operation=summary",
			method:"POST",
			data:{
				year:document.frm.year.value
				,'subOperation':subOperation
				,departmentID:69
			},
			success:function(html){
				var div=$("#"+subOperation);
				div.html(html);
			}
		});
	};
	doAjax("shouRuSummary");
	doAjax("doTouzhiSummary");
	doAjax("doTouziProcessSummary");
	doAjax("kaizhiAndZhuanZhiSummary");
}) */
</script>
					<style type="text/css">
#productResultTable.listTable  tbody tr td {
	border: none;
}

#departmentResultTable.listTable  tbody tr td {
	border: none;
}

#productResultTable th {
	
}

.chengBenClass {
	width: auto;
	height: 12px;
	float: right;
	position: relative;
	background-color: #047ad4;
}

.shouRuClass {
	width: auto;
	height: 12px;
	position: relative;
	background-color: #0acc4b;
}

.liRunLine {
	height: 100%;
	background-color: #ED842C;
	width: 1px;
	position: absolute;
	left: 0px;
}
</style>
					<script type="text/javascript">
	/* function loadProductAndDepart(subOperation){
		var data={
				year:document.frm.year.value
				,departmentID:"69"
				,operation:subOperation
			};
		if(subOperation=="productAndDepart_Product"){
			var ProductOrderType=$("#ProductOrderType");
			data.orderType=ProductOrderType.hasClass("DESC")?"DESC":"ASC";
		}
		$.ajax({
			url:"/ZongheAction.do",
			method:"POST",
			data:data,
			success:function(html){
				var div=$("#"+subOperation);
				div.html(html);
			}
		});
	} */
	jQuery(document).ready(function(){
		loadProductAndDepart("productAndDepart_Product");
		loadProductAndDepart("productAndDepart_Depart");
		$("#ProductOrderType").on("click",function(event){
			var obj=$(this);
			obj.toggleClass("DESC");
			loadProductAndDepart("productAndDepart_Product");
		})
	})
	
	function showCapexPhaseTip1(obj,divName){
	var detaiObj=obj.detaiObj;
	if(detaiObj==null){
		detaiObj=new ET.FloatDIV(divName);
		obj.detaiObj=detaiObj;
		ET.Utils.addEvent(detaiObj.sourceElement,'mouseover',function(){
			window.clearTimeout(detaiObj.hideID);
		})
		ET.Utils.addEvent(detaiObj.sourceElement,'mouseout',function(){
			detaiObj.hideID=window.setTimeout(function(){
				detaiObj.hide();
			},500)
		})
	}
	detaiObj.popup(obj,{
		x:2,
		y:3
	})
}
</script>

					<table style="width: 1000px; margin: 26px auto;">
						<tbody>
							<tr>
								<td style="width: 51%; vertical-align: top;">
									<div style="margin-right: 10px;">
										<div class="cmccDashTitle">
											<div id="ProductOrderType" class="orderbyImg DESC"></div>
											<div class="showMoreSpan showMoreColor productMore"
												style="font-weight: normal;"
												onclick="openProductSummaryList()">更多</div>
											<span>产品累计收入排名(Top 10)</span>
										</div>
										<div class="sumContainer1" style="height: 380px;">
											<div style="text-align: right;">
												<div style="float: right; margin-top: 7px;"
													class="showHelpe"
													onclick="showCapexPhaseTip1(this,'productTipNameDIV')"></div>
												<div class="shouRuClass"
													style="height: 10px; width: 10px; margin: 10px 5px; float: right;"></div>
												<div style="margin: 5px; float: right;">收入</div>

												<div class="chengBenClass"
													style="height: 10px; width: 10px; margin: 10px 5px; float: right;"></div>
												<div style="margin: 5px; float: right;">成本</div>
												<div style="clear: both;"></div>

											</div>
											<div class="helpFloatDIV" id="productTipNameDIV"
												style="line-height: 22px;">
												<div class="showHelpeContent" style="line-height: 23px;">
													<div>产品毛利润计算方式为：产品收入-产品成本(OPEX成本+CAPEX折旧)</div>
												</div>
											</div>
											<div id="productAndDepart_Product" style="min-height: 250px;">









												<div style="width: 100%; margin: 0px auto;">
													<table id="productResultTable" class="listTable"
														style="margin: 10px auto;" cellpadding="0" cellspacing="0"
														border="0">
														<thead>
															<tr>
																<th width="100%"><div style="width: 90px">产品</div></th>

																<th><div style="width: 36.66666666666667px">成本</div></th>
																<th><div style="width: 183.33333333333334px">收入</div></th>
																<th><div style="width: 80px">毛利润</div></th>
																<th><div style="width: 90px">资本投入</div></th>
															</tr>
														</thead>
														<tbody>

															<tr>
																<td><div
																		style="width: 90px; text-align: left; padding-left: 10px;"
																		class="nowrapText linkURL" title="入驻MAS"
																		onclick="openProduct(294029)">入驻MAS</div></td>
																<td style="border-right: 1px solid #D9D9D9;">
																	<div class="chengBenClass" title="成本：16,801.08"
																		style="width: 42.24754099840413%;"></div>

																</td>
																<td>
																	<div class="shouRuClass" title="收入：198,840.93"
																		style="width: 100.0%;">

																		<div class="liRunLine"
																			style="margin-left: -1px; left: 8.449508199680826%;"></div>

																	</div>

																</td>

																<td><div style="width: 80px; text-align: center;"
																		class="nowrapText" title="182,039.85">182,039.85</div></td>
																<td><div style="width: 80px; text-align: center;"
																		class="nowrapText" title="4,051.51">4,051.51</div></td>

															</tr>

															<tr>
																<td><div
																		style="width: 90px; text-align: left; padding-left: 10px;"
																		class="nowrapText linkURL" title="Blackberry"
																		onclick="openProduct(294030)">Blackberry</div></td>
																<td style="border-right: 1px solid #D9D9D9;">
																	<div class="chengBenClass" title="成本：3,466.87"
																		style="width: 8.717700317372543%;"></div>

																</td>
																<td>
																	<div class="shouRuClass" title="收入：9,776.54"
																		style="width: 4.916765807097841%;">

																		<div class="liRunLine"
																			style="margin-left: -1px; left: 35.46111675600932%;"></div>

																	</div>

																</td>

																<td><div style="width: 80px; text-align: center;"
																		class="nowrapText" title="6,309.67">6,309.67</div></td>
																<td><div style="width: 80px; text-align: center;"
																		class="nowrapText" title="0">0</div></td>

															</tr>

															<tr>
																<td><div
																		style="width: 90px; text-align: left; padding-left: 10px;"
																		class="nowrapText linkURL" title="IDC"
																		onclick="openProduct(294042)">IDC</div></td>
																<td style="border-right: 1px solid #D9D9D9;">
																	<div class="chengBenClass" title="成本：9,857.16"
																		style="width: 24.786536735268292%;">

																		<div class="liRunLine"
																			style="left: auto; right: 86.62074887456468%; margin-right: 1px;"></div>

																	</div>

																</td>
																<td>
																	<div class="shouRuClass" title="收入：8,538.34"
																		style="width: 4.294056748031695%;"></div>

																</td>

																<td><div style="width: 80px; text-align: center;"
																		class="nowrapText" title="-1,318.81">-1,318.81</div></td>
																<td><div style="width: 80px; text-align: center;"
																		class="nowrapText" title="82,788.08">82,788.08</div></td>

															</tr>

															<tr>
																<td><div
																		style="width: 90px; text-align: left; padding-left: 10px;"
																		class="nowrapText linkURL" title="移动400"
																		onclick="openProduct(294031)">移动400</div></td>
																<td style="border-right: 1px solid #D9D9D9;">
																	<div class="chengBenClass" title="成本：1,615.23"
																		style="width: 4.061613602660319%;"></div>

																</td>
																<td>
																	<div class="shouRuClass" title="收入：7,422.59"
																		style="width: 3.732927795906249%;">

																		<div class="liRunLine"
																			style="margin-left: -1px; left: 21.76100811333413%;"></div>

																	</div>

																</td>

																<td><div style="width: 80px; text-align: center;"
																		class="nowrapText" title="5,807.36">5,807.36</div></td>
																<td><div style="width: 80px; text-align: center;"
																		class="nowrapText" title="636.53">636.53</div></td>

															</tr>

															<tr>
																<td><div
																		style="width: 90px; text-align: left; padding-left: 10px;"
																		class="nowrapText linkURL" title="专线"
																		onclick="openProduct(294041)">专线</div></td>
																<td style="border-right: 1px solid #D9D9D9;">
																	<div class="chengBenClass" title="成本：8,369.80"
																		style="width: 21.04646943011447%;">

																		<div class="liRunLine"
																			style="left: auto; right: 81.1529476996832%; margin-right: 1px;"></div>

																	</div>

																</td>
																<td>
																	<div class="shouRuClass" title="收入：6,792.34"
																		style="width: 3.415966065850122%;"></div>

																</td>

																<td><div style="width: 80px; text-align: center;"
																		class="nowrapText" title="-1,577.46">-1,577.46</div></td>
																<td><div style="width: 80px; text-align: center;"
																		class="nowrapText" title="1,135.51">1,135.51</div></td>

															</tr>

															<tr>
																<td><div
																		style="width: 90px; text-align: left; padding-left: 10px;"
																		class="nowrapText linkURL" title="行业手机报"
																		onclick="openProduct(294035)">行业手机报</div></td>
																<td style="border-right: 1px solid #D9D9D9;">
																	<div class="chengBenClass" title="成本：5,048.65"
																		style="width: 12.695188093169495%;"></div>

																</td>
																<td>
																	<div class="shouRuClass" title="收入：6,191.04"
																		style="width: 3.113566614885135%;">

																		<div class="liRunLine"
																			style="margin-left: -1px; left: 81.54756048884373%;"></div>

																	</div>

																</td>

																<td><div style="width: 80px; text-align: center;"
																		class="nowrapText" title="1,142.40">1,142.40</div></td>
																<td><div style="width: 80px; text-align: center;"
																		class="nowrapText" title="0">0</div></td>

															</tr>

															<tr>
																<td><div
																		style="width: 90px; text-align: left; padding-left: 10px;"
																		class="nowrapText linkURL" title="手机邮箱"
																		onclick="openProduct(294032)">手机邮箱</div></td>
																<td style="border-right: 1px solid #D9D9D9;">
																	<div class="chengBenClass" title="成本：992.72"
																		style="width: 2.4962669500843657%;"></div>

																</td>
																<td>
																	<div class="shouRuClass" title="收入：4,818.88"
																		style="width: 2.4234836836463347%;">

																		<div class="liRunLine"
																			style="margin-left: -1px; left: 20.60064993982978%;"></div>

																	</div>

																</td>

																<td><div style="width: 80px; text-align: center;"
																		class="nowrapText" title="3,826.16">3,826.16</div></td>
																<td><div style="width: 80px; text-align: center;"
																		class="nowrapText" title="0">0</div></td>

															</tr>

															<tr>
																<td><div
																		style="width: 90px; text-align: left; padding-left: 10px;"
																		class="nowrapText linkURL" title="K12和校园"
																		onclick="openProduct(407842)">K12和校园</div></td>
																<td style="border-right: 1px solid #D9D9D9;">
																	<div class="chengBenClass" title="成本：5,602.43"
																		style="width: 14.087713561462511%;">

																		<div class="liRunLine"
																			style="left: auto; right: 62.995310117088955%; margin-right: 1px;"></div>

																	</div>

																</td>
																<td>
																	<div class="shouRuClass" title="收入：3,529.27"
																		style="width: 1.7749197692901013%;"></div>

																</td>

																<td><div style="width: 80px; text-align: center;"
																		class="nowrapText" title="-2,073.16">-2,073.16</div></td>
																<td><div style="width: 80px; text-align: center;"
																		class="nowrapText" title="5,955.44">5,955.44</div></td>

															</tr>

															<tr>
																<td><div
																		style="width: 90px; text-align: left; padding-left: 10px;"
																		class="nowrapText linkURL" title="行业WLAN"
																		onclick="openProduct(294037)">行业WLAN</div></td>
																<td style="border-right: 1px solid #D9D9D9;">
																	<div class="chengBenClass" title="成本：7,120.12"
																		style="width: 17.904051240332368%;">

																		<div class="liRunLine"
																			style="left: auto; right: 45.01472868907706%; margin-right: 1px;"></div>

																	</div>

																</td>
																<td>
																	<div class="shouRuClass" title="收入：3,205.10"
																		style="width: 1.6118920180377903%;"></div>

																</td>

																<td><div style="width: 80px; text-align: center;"
																		class="nowrapText" title="-3,915.02">-3,915.02</div></td>
																<td><div style="width: 80px; text-align: center;"
																		class="nowrapText" title="4,534.20">4,534.20</div></td>

															</tr>

															<tr>
																<td><div
																		style="width: 90px; text-align: left; padding-left: 10px;"
																		class="nowrapText linkURL" title="移动云"
																		onclick="openProduct(294046)">移动云</div></td>
																<td style="border-right: 1px solid #D9D9D9;">
																	<div class="chengBenClass" title="成本：13,859.83"
																		style="width: 34.85155336804956%;">

																		<div class="liRunLine"
																			style="left: auto; right: 16.924515473027775%; margin-right: 1px;"></div>

																	</div>

																</td>
																<td>
																	<div class="shouRuClass" title="收入：2,345.71"
																		style="width: 1.179691308473216%;"></div>

																</td>

																<td><div style="width: 80px; text-align: center;"
																		class="nowrapText" title="-11,514.12">-11,514.12</div></td>
																<td><div style="width: 80px; text-align: center;"
																		class="nowrapText" title="40,445.10">40,445.10</div></td>

															</tr>

														</tbody>
													</table>

												</div>















												<script type="text/javascript">
	$("#productAndDepart_ProductTime").html("").append($("#productAndDepart_ProductTimeSpan"));
</script>
											</div>
										</div>
										<div id="productAndDepart_ProductTime" class="viewChangeTime">
											<span id="productAndDepart_ProductTimeSpan"
												class="viewChangeSpan  ">数据更新时间:1天前</span>
										</div>
									</div>
								</td>
								<td style="width: 49%; vertical-align: top;">
									<div>
										<div class="cmccDashTitle">
											<div class="showMoreSpan showMoreColor productMore"
												style="font-weight: normal;"
												onclick="openDepartmentSummaryList()">更多</div>
											<span>部门成本收入情况</span>
										</div>
										<div class="sumContainer1" style="height: 380px;">
											<div style="text-align: right;">
												<div style="float: right; margin-top: 7px;"
													class="showHelpe"
													onclick="showCapexPhaseTip1(this,'departmentTipNameDIV')"></div>
												<div class="shouRuClass"
													style="height: 10px; width: 10px; margin: 10px 5px; float: right;"></div>
												<div style="margin: 5px; float: right;">收入</div>

												<div class="chengBenClass"
													style="height: 10px; width: 10px; margin: 10px 5px; float: right;"></div>
												<div style="margin: 5px; float: right;">成本</div>
												<div style="clear: both;"></div>
											</div>
											<div class="helpFloatDIV" id="departmentTipNameDIV"
												style="line-height: 22px;">
												<div class="showHelpeContent" style="line-height: 23px;">
													<div>优先展示有收入的部门，再按OA部门排序</div>
												</div>
											</div>
											<div id="productAndDepart_Depart" style="min-height: 250px;">








												<div style="width: 100%; margin: 0px auto;">
													<table id="departmentResultTable" class="listTable"
														style="margin: 10px auto;" cellpadding="0" cellspacing="0"
														border="0">
														<thead>
															<tr>
																<th width="100%"><div style="width: 80px">部门</div></th>

																<th><div style="width: 150.0px">成本</div></th>
																<th><div style="width: 150.0px">收入</div></th>
																<th><div style="width: 80px">非流动性资产</div></th>
															</tr>
														</thead>
														<tbody>

															<tr>
																<td><div
																		style="width: 90px; text-align: left; padding-left: 10px;"
																		title="互联网解决方案部" class="nowrapText linkURL"
																		onclick="openDepartmentView(1006)">互联网解决方案部</div></td>
																<td style="border-right: 1px solid #D9D9D9;">
																	<div class="chengBenClass" title="成本：179.55"
																		style="width: 1.043733863617753%;">

																		<div class="liRunLine"
																			style="left: auto; right: 0.0%; margin-right: 1px;"></div>

																	</div>

																</td>
																<td>
																	<div class="shouRuClass" title="收入：0"
																		style="width: 0.0%;"></div>

																</td>

																<td><div style="width: 80px; text-align: center;"
																		class="nowrapText" title="0">0</div></td>
															</tr>

															<tr>
																<td><div
																		style="width: 90px; text-align: left; padding-left: 10px;"
																		title="产品中心" class="nowrapText linkURL"
																		onclick="openDepartmentView(1008)">产品中心</div></td>
																<td style="border-right: 1px solid #D9D9D9;">
																	<div class="chengBenClass" title="成本：393.22"
																		style="width: 2.2858662110433507%;">

																		<div class="liRunLine"
																			style="left: auto; right: 0.0%; margin-right: 1px;"></div>

																	</div>

																</td>
																<td>
																	<div class="shouRuClass" title="收入：0"
																		style="width: 0.0%;"></div>

																</td>

																<td><div style="width: 80px; text-align: center;"
																		class="nowrapText" title="1,414.46">1,414.46</div></td>
															</tr>

															<tr>
																<td><div
																		style="width: 90px; text-align: left; padding-left: 10px;"
																		title="云计算中心" class="nowrapText linkURL"
																		onclick="openDepartmentView(1009)">云计算中心</div></td>
																<td style="border-right: 1px solid #D9D9D9;">
																	<div class="chengBenClass" title="成本：-39.62"
																		style="width: -0.23034588458511265%;"></div>

																</td>
																<td>
																	<div class="shouRuClass" title="收入：0"
																		style="width: 0.0%;"></div>

																</td>

																<td><div style="width: 80px; text-align: center;"
																		class="nowrapText" title="3,016.19">3,016.19</div></td>
															</tr>

															<tr>
																<td><div
																		style="width: 90px; text-align: left; padding-left: 10px;"
																		title="医疗行业解决方案部" class="nowrapText linkURL"
																		onclick="openDepartmentView(1011)">医疗行业解决方案部</div></td>
																<td style="border-right: 1px solid #D9D9D9;">
																	<div class="chengBenClass" title="成本：24.14"
																		style="width: 0.1403322298338469%;">

																		<div class="liRunLine"
																			style="left: auto; right: 0.0%; margin-right: 1px;"></div>

																	</div>

																</td>
																<td>
																	<div class="shouRuClass" title="收入：0"
																		style="width: 0.0%;"></div>

																</td>

																<td><div style="width: 80px; text-align: center;"
																		class="nowrapText" title="409.41">409.41</div></td>
															</tr>

															<tr>
																<td><div
																		style="width: 90px; text-align: left; padding-left: 10px;"
																		title="交通行业解决方案部" class="nowrapText linkURL"
																		onclick="openDepartmentView(1012)">交通行业解决方案部</div></td>
																<td style="border-right: 1px solid #D9D9D9;">
																	<div class="chengBenClass" title="成本：145.89"
																		style="width: 0.8480791377196811%;">

																		<div class="liRunLine"
																			style="left: auto; right: 0.0%; margin-right: 1px;"></div>

																	</div>

																</td>
																<td>
																	<div class="shouRuClass" title="收入：0"
																		style="width: 0.0%;"></div>

																</td>

																<td><div style="width: 80px; text-align: center;"
																		class="nowrapText" title="0">0</div></td>
															</tr>

															<tr>
																<td><div
																		style="width: 90px; text-align: left; padding-left: 10px;"
																		title="移动办公创新中心" class="nowrapText linkURL"
																		onclick="openDepartmentView(1013)">移动办公创新中心</div></td>
																<td style="border-right: 1px solid #D9D9D9;">
																	<div class="chengBenClass" title="成本：-42.89"
																		style="width: -0.2493284803266811%;"></div>

																</td>
																<td>
																	<div class="shouRuClass" title="收入：0"
																		style="width: 0.0%;"></div>

																</td>

																<td><div style="width: 80px; text-align: center;"
																		class="nowrapText" title="305.51">305.51</div></td>
															</tr>

															<tr>
																<td><div
																		style="width: 90px; text-align: left; padding-left: 10px;"
																		title="服务支撑中心" class="nowrapText linkURL"
																		onclick="openDepartmentView(1017)">服务支撑中心</div></td>
																<td style="border-right: 1px solid #D9D9D9;">
																	<div class="chengBenClass" title="成本：364.21"
																		style="width: 2.1172472670341627%;">

																		<div class="liRunLine"
																			style="left: auto; right: 0.0%; margin-right: 1px;"></div>

																	</div>

																</td>
																<td>
																	<div class="shouRuClass" title="收入：0"
																		style="width: 0.0%;"></div>

																</td>

																<td><div style="width: 80px; text-align: center;"
																		class="nowrapText" title="745.18">745.18</div></td>
															</tr>

															<tr>
																<td><div
																		style="width: 90px; text-align: left; padding-left: 10px;"
																		title="工业和能源行业解决方案部" class="nowrapText linkURL"
																		onclick="openDepartmentView(325909)">工业和能源行业解决方案部</div></td>
																<td style="border-right: 1px solid #D9D9D9;">
																	<div class="chengBenClass" title="成本：43.09"
																		style="width: 0.25046873497404193%;">

																		<div class="liRunLine"
																			style="left: auto; right: 0.0%; margin-right: 1px;"></div>

																	</div>

																</td>
																<td>
																	<div class="shouRuClass" title="收入：0"
																		style="width: 0.0%;"></div>

																</td>

																<td><div style="width: 80px; text-align: center;"
																		class="nowrapText" title="0">0</div></td>
															</tr>

														</tbody>
													</table>
												</div>















												<script type="text/javascript">
	$("#productAndDepart_departTime").html("").append($("#productAndDepart_departTimeSpan"));
</script>
											</div>
										</div>
										<div id="productAndDepart_departTime" class="viewChangeTime">
											<span id="productAndDepart_departTimeSpan"
												class="viewChangeSpan  ">数据更新时间:1天前</span>
										</div>
									</div>
								</td>
							</tr>
						</tbody>
					</table>












					<script type="text/javascript">

	/* function loadProjectSetFun(){
		var data={
				year:document.frm.year.value
				,departmentID:document.frm.departmentID.value
			};
		$.ajax({
			url:"/ZongheAction.do?operation=projectSetResult",
			method:"POST",
			data:data,
			success:function(html){
				var div=$("#projectSetRequestJSP");
				div.html(html);
			}
		});
	}
	jQuery(document).ready(function(){
		loadProjectSetFun();
	}) */
</script>
					<div class="chartContainerDIV cmccViewContainer"
						style="margin: 26px auto;">
						<div class="tabMore linkURL" onclick="openProjectSetSummaryList()">更多</div>

						<div class="tabTitle">
							<ul>
								<li onclick="loadProjectSetFun()" class="on">项目执行情况</li>
							</ul>
						</div>
						<div style="min-height: 120px;" class="tabContent"
							id="projectSetRequestJSP">









							<div
								style="margin: 10px auto; max-height: 250px; overflow: hidden; height: 250px; position: relative;"
								id="projectsetDIV">

								<div
									style="margin: 10px auto; max-height: 250px; overflow: auto; height: 100%; position: absolute; top: 0px; left: 0px; display: block; bottom: 0px; width: 100%;"
									id="projectSetResultTablebody_tbody">
									<table id="projectSetResultTable" class="listTable dataTable"
										cellpadding="0" cellspacing="0" border="0">
										<thead>
											<tr>
												<th width="100%"><div style="width: 100%">项目名称</div></th>
												<th><div style="width: 200px">需求部门</div></th>
												<!-- 
				<th><div style='width:120px'>包含的CAPEX总数</div></th>
				 -->
												<th><div style="width: 150px">成本开支总额</div></th>
												<th><div style="width: 150px">资本开支总额</div></th>
												<th><div style="width: 150px">转资总额</div></th>
											</tr>
										</thead>
										<tbody>

											<tr>
												<td align="center"><div class="nowrapText linkURL"
														onclick="openItemSet(311380)" style="width: 200px;"
														title="统一信息平台">统一信息平台</div></td>
												<td align="center">移动办公创新中心</td>

												<!-- 
					<td>
						
						&nbsp;
					</td>
					 -->
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">296.93</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>

											</tr>

											<tr>
												<td align="center"><div class="nowrapText linkURL"
														onclick="openItemSet(311384)" style="width: 200px;"
														title="ERP接口平台">ERP接口平台</div></td>
												<td align="center">企业管理创新中心</td>

												<!-- 
					<td>
						
						&nbsp;
					</td>
					 -->
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>

											</tr>

											<tr>
												<td align="center"><div class="nowrapText linkURL"
														onclick="openItemSet(311358)" style="width: 200px;"
														title="国开行统一通信二期项目">国开行统一通信二期项目</div></td>
												<td align="center">解决方案中心</td>

												<!-- 
					<td>
						
						&nbsp;
					</td>
					 -->
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>

											</tr>

											<tr>
												<td align="center"><div class="nowrapText linkURL"
														onclick="openItemSet(311359)" style="width: 200px;"
														title="交行满天星项目">交行满天星项目</div></td>
												<td align="center">产品中心</td>

												<!-- 
					<td>
						
						3
					</td>
					 -->
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>

											</tr>

											<tr>
												<td align="center"><div class="nowrapText linkURL"
														onclick="openItemSet(311376)" style="width: 200px;"
														title="国际信息港辅助用房建设">国际信息港辅助用房建设</div></td>
												<td align="center">云计算中心</td>

												<!-- 
					<td>
						
						&nbsp;
					</td>
					 -->
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>

											</tr>

											<tr>
												<td align="center"><div class="nowrapText linkURL"
														onclick="openItemSet(311372)" style="width: 200px;"
														title="百度亦庄数据中心合建项目">百度亦庄数据中心合建项目</div></td>
												<td align="center">云计算中心</td>

												<!-- 
					<td>
						
						&nbsp;
					</td>
					 -->
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>

											</tr>

											<tr>
												<td align="center"><div class="nowrapText linkURL"
														onclick="openItemSet(311385)" style="width: 200px;"
														title="报账管理系统">报账管理系统</div></td>
												<td align="center">企业管理创新中心</td>

												<!-- 
					<td>
						
						&nbsp;
					</td>
					 -->
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>

											</tr>

											<tr>
												<td align="center"><div class="nowrapText linkURL"
														onclick="openItemSet(311379)" style="width: 200px;"
														title="ERP系统">ERP系统</div></td>
												<td align="center">企业管理创新中心</td>

												<!-- 
					<td>
						
						&nbsp;
					</td>
					 -->
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>

											</tr>

											<tr>
												<td align="center"><div class="nowrapText linkURL"
														onclick="openItemSet(311377)" style="width: 200px;"
														title="呼和浩特数据中心及云计算工程">呼和浩特数据中心及云计算工程</div></td>
												<td align="center">云计算中心</td>

												<!-- 
					<td>
						
						&nbsp;
					</td>
					 -->
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>

											</tr>

											<tr>
												<td align="center"><div class="nowrapText linkURL"
														onclick="openItemSet(311364)" style="width: 200px;"
														title="最高人民法院专线项目">最高人民法院专线项目</div></td>
												<td align="center">解决方案中心</td>

												<!-- 
					<td>
						
						&nbsp;
					</td>
					 -->
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>

											</tr>

											<tr>
												<td align="center"><div class="nowrapText linkURL"
														onclick="openItemSet(311368)" style="width: 200px;"
														title="民航地空项目">民航地空项目</div></td>
												<td align="center">解决方案中心</td>

												<!-- 
					<td>
						
						&nbsp;
					</td>
					 -->
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>

											</tr>

											<tr>
												<td align="center"><div class="nowrapText linkURL"
														onclick="openItemSet(311360)" style="width: 200px;"
														title="深圳平安通信WLAN">深圳平安通信WLAN</div></td>
												<td align="center">产品中心</td>

												<!-- 
					<td>
						
						2
					</td>
					 -->
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">49.14</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>

											</tr>

											<tr>
												<td align="center"><div class="nowrapText linkURL"
														onclick="openItemSet(311361)" style="width: 200px;"
														title="烟草总局通信骨干网">烟草总局通信骨干网</div></td>
												<td align="center">解决方案中心</td>

												<!-- 
					<td>
						
						&nbsp;
					</td>
					 -->
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>

											</tr>

											<tr>
												<td align="center"><div class="nowrapText linkURL"
														onclick="openItemSet(311363)" style="width: 200px;"
														title="中信建投WLAN项目">中信建投WLAN项目</div></td>
												<td align="center">产品中心</td>

												<!-- 
					<td>
						
						&nbsp;
					</td>
					 -->
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>

											</tr>

											<tr>
												<td align="center"><div class="nowrapText linkURL"
														onclick="openItemSet(311362)" style="width: 200px;"
														title="中化工移动办公项目">中化工移动办公项目</div></td>
												<td align="center"></td>

												<!-- 
					<td>
						
						&nbsp;
					</td>
					 -->
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>

											</tr>

											<tr>
												<td align="center"><div class="nowrapText linkURL"
														onclick="openItemSet(311370)" style="width: 200px;"
														title="腾讯国际专线项目">腾讯国际专线项目</div></td>
												<td align="center">解决方案中心</td>

												<!-- 
					<td>
						
						&nbsp;
					</td>
					 -->
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>

											</tr>

											<tr>
												<td align="center"><div class="nowrapText linkURL"
														onclick="openItemSet(311371)" style="width: 200px;"
														title="建行国际专线项目">建行国际专线项目</div></td>
												<td align="center">解决方案中心</td>

												<!-- 
					<td>
						
						&nbsp;
					</td>
					 -->
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>

											</tr>

											<tr>
												<td align="center"><div class="nowrapText linkURL"
														onclick="openItemSet(311373)" style="width: 200px;"
														title="哈尔滨数据中心工程项目">哈尔滨数据中心工程项目</div></td>
												<td align="center">云计算中心</td>

												<!-- 
					<td>
						
						&nbsp;
					</td>
					 -->
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>

											</tr>

											<tr>
												<td align="center"><div class="nowrapText linkURL"
														onclick="openItemSet(311369)" style="width: 200px;"
														title="中组部党员手机报">中组部党员手机报</div></td>
												<td align="center">服务支撑中心</td>

												<!-- 
					<td>
						
						&nbsp;
					</td>
					 -->
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>

											</tr>

											<tr>
												<td align="center"><div class="nowrapText linkURL"
														onclick="openItemSet(311366)" style="width: 200px;"
														title="求是杂志社办公系统">求是杂志社办公系统</div></td>
												<td align="center"></td>

												<!-- 
					<td>
						
						&nbsp;
					</td>
					 -->
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>

											</tr>

											<tr>
												<td align="center"><div class="nowrapText linkURL"
														onclick="openItemSet(311381)" style="width: 200px;"
														title="供应链与电子招投标">供应链与电子招投标</div></td>
												<td align="center"></td>

												<!-- 
					<td>
						
						&nbsp;
					</td>
					 -->
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>

											</tr>

											<tr>
												<td align="center"><div class="nowrapText linkURL"
														onclick="openItemSet(311382)" style="width: 200px;"
														title="服务台及网络维护服务">服务台及网络维护服务</div></td>
												<td align="center"></td>

												<!-- 
					<td>
						
						&nbsp;
					</td>
					 -->
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>

											</tr>

											<tr>
												<td align="center"><div class="nowrapText linkURL"
														onclick="openItemSet(311383)" style="width: 200px;"
														title="集中灾备系统">集中灾备系统</div></td>
												<td align="center"></td>

												<!-- 
					<td>
						
						1
					</td>
					 -->
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>

											</tr>

											<tr>
												<td align="center"><div class="nowrapText linkURL"
														onclick="openItemSet(311378)" style="width: 200px;"
														title="湖南长沙分公司数据中心">湖南长沙分公司数据中心</div></td>
												<td align="center"></td>

												<!-- 
					<td>
						
						&nbsp;
					</td>
					 -->
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>
												<td align="center"><div
														style="width: 110px; padding-right: 10px;"
														class="nowrapText">0</div></td>

											</tr>

										</tbody>
									</table>
								</div>
								<div
									style="margin: 10px auto; max-height: 250px; overflow: hidden; height: auto; position: absolute; display: block; bottom: auto; left: 0px; top: 0px; width: 973px;"
									id="projectSetResultTablebody_theadContainer">
									<table id="projectSetResultTablebody_theadTable"
										class="listTable dataTable" cellpadding="0" cellspacing="0"
										border="0" style="width: 973px;">
										<thead>
											<tr>
												<th width="100%"><div style="width: 100%">项目名称</div></th>
												<th><div style="width: 200px">需求部门</div></th>
												<!-- 
				<th><div style='width:120px'>包含的CAPEX总数</div></th>
				 -->
												<th><div style="width: 150px">成本开支总额</div></th>
												<th><div style="width: 150px">资本开支总额</div></th>
												<th><div style="width: 150px">转资总额</div></th>
											</tr>
										</thead>
									</table>
								</div>
							</div>















							<script type="text/javascript">
	$("#projectSetRequestJSPTime").html("").append($("#projectSetRequestJSPTimeSpan"));
</script>
							<script type="text/javascript">
	var div=document.getElementById("projectsetDIV");
	if(div.scrollHeight>div.offsetHeight){
		div.style.height="250px";
		window.projectResultTableObj=new EasyTrack.DataTable("projectSetResultTable",{
			autoHeight:false
		})
	}
	
</script>
						</div>
					</div>
					<div id="projectSetRequestJSPTime"
						class="viewChangeTime marginTopTime">
						<span id="projectSetRequestJSPTimeSpan" class="viewChangeSpan  ">数据更新时间:1小时前</span>
					</div>









					<script type="text/javascript">
	/* function loadTouziDetialFun(index){
		var data={
				year:document.frm.year.value
				,departmentID:document.frm.departmentID.value
				,index:index
			};
		$.ajax({
			url:"/ZongheAction.do?operation=touziDetail",
			method:"POST",
			data:data,
			success:function(html){
				var div=$("#touziDetailDIV");
				div.html(html);
			}
		});
	}
	jQuery(document).ready(function(){
		loadTouziDetialFun(0);
	}) */
</script>
					<div class="chartContainerDIV cmccViewContainer">
						<div id="touziDetailDIV">



















							<div class="tabMore linkURL" onclick="openTouzizhixingDetail()">更多</div>



							<div class="tabTitle">
								<ul>
									<li onclick="loadTouziDetialFun(0)" class="on">投资计划执行情况</li>
									<li onclick="loadTouziDetialFun(1)" class="">预算执行</li>
								</ul>
							</div>












							<div id="touziDetailCapexDIV" class="tabContent">
								<div style="width: 190px; margin-left: 10px; float: left">
									<div style="margin-top: 8px;">
										<div style="padding-bottom: 8px;">新建项目投资执行进度&nbsp;:</div>
										<div
											style="padding-bottom: 8px; font-size: 16px; font-weight: bold;">0</div>
										<div
											style="width: 95%; margin: 10px auto; height: 8px; background-color: #E8E9ED;">
											<div
												style="height: 100%; width: 0.0%; background-color: #0ACC4B"></div>
										</div>
										<div
											style="padding-bottom: 18px; border-bottom: 1px solid #EBE8EF;">
											投资计划总额&nbsp;: <b style="font-size: 14px;">74,156.20</b>
										</div>
									</div>


									<div style="margin-top: 15px;">
										<div style="padding-bottom: 10px;">自主资金使用&nbsp;:</div>
										<div
											style="padding-bottom: 10px; font-size: 16px; font-weight: bold;">0</div>
										<div
											style="width: 95%; margin: 10px auto; height: 8px; background-color: #E8E9ED;">
											<div
												style="height: 100%; width: 0.0%; background-color: #0ACC4B"></div>
										</div>
										<div style="padding-bottom: 8px;">
											自主资金池总额&nbsp;: <b style="font-size: 14px;">0</b>
										</div>
									</div>
								</div>
								<div id="touziDetialCapexDepartDIV" style="margin-left: 220px;">
									<div
										style="height: 250px; overflow: hidden; position: relative;">

										<div
											style="height: 100%; overflow: auto; position: absolute; top: 0px; left: 0px; display: block; bottom: 0px; width: 100%;"
											id="touziDetialCapexDepartDIVTablebody_tbody">
											<table id="touziDetialCapexDepartDIVTable"
												class="listTable dataTable" cellpadding="0" cellspacing="0"
												border="0">
												<thead>
													<tr>
														<th width="100%"><div style="width: 100%">部门名称</div></th>
														<th><div style="width: 180px">投资计划总额</div></th>
														<th><div style="width: 180px">立项批复金额</div></th>
														<th><div style="width: 150px">投资计划使用进度</div></th>
													</tr>
												</thead>
												<tbody>

												</tbody>
											</table>
										</div>
										<div
											style="height: auto; overflow: hidden; position: absolute; display: block; bottom: auto; left: 0px; top: 0px; width: 770px;"
											id="touziDetialCapexDepartDIVTablebody_theadContainer">
											<table id="touziDetialCapexDepartDIVTablebody_theadTable"
												class="listTable dataTable" cellpadding="0" cellspacing="0"
												border="0" style="width: 770px;">
												<thead>
													<tr>
														<th width="100%"><div style="width: 100%">部门名称</div></th>
														<th><div style="width: 180px">投资计划总额</div></th>
														<th><div style="width: 180px">立项批复金额</div></th>
														<th><div style="width: 150px">投资计划使用进度</div></th>
													</tr>
												</thead>
											</table>
										</div>
									</div>
								</div>
								<div style="clear: both;"></div>
							</div>
							<script type="text/javascript">
	window.touziDetialCapexDepartDIVTableObj=new EasyTrack.DataTable("touziDetialCapexDepartDIVTable",{
		autoHeight:false
	})
</script>















							<script type="text/javascript">
	$("#touziDetailDIVTime").html("").append($("#touziDetailDIVTimeSpan"));
</script>
						</div>
					</div>
					<div id="touziDetailDIVTime" class="viewChangeTime marginTopTime"></div>











					<style type="text/css">
</style>
					<div class="chartContainerDIV" style="margin: 26px auto;">
						<div style="text-align: right">
							<div class="showHelpe" onclick="showCapexPhaseTip(this)"></div>
						</div>
						<div class="helpFloatDIV" id="pahseTipNameDIV"
							style="line-height: 22px;">
							<div class="showHelpeContent" style="line-height: 23px;">
								<div>投资计划项目数量：年度项目总数量</div>
								<div>各阶段项目数量：项目阶段为当前环节的项目数量</div>
								<div>需求阶段：需求提交-需求冻结</div>
								<div>立项/可研阶段：需求冻结-可研批复</div>
								<div>采购阶段：可研批复-采购完成</div>
								<div>设计阶段：采购完成-设计批复</div>
								<div>工程建设阶段：设计批复-试运行</div>
								<div>试运行阶段：试运行-终验批复</div>
								<div>竣工投产：终验批复后</div>
							</div>
						</div>
						<div id="capex_phaseStatusDIV" style="min-height: 220px;">








							<div>
								<table class="statusTable" style="margin: 0 auto;" border="0"
									cellspacing="0" cellpadding="0">
									<tbody>
										<tr>
											<td style="vertical-align: top;"><div
													class="cmcc_phase_column" style="font-weight: bold;">CAPEX项目流程:</div></td>
											<td>
												<div style="padding-bottom: 20px;">
													<img src="/static/images/cmcc/liucheng.png">
												</div>
											</td>
										</tr>

										<tr>
											<td><div class="cmcc_phase_column">项目总数</div></td>
											<td>
												<div class="cmcc_phase_kuang" style="width: 826px;">
													<div class="cmcc_phase_valueDIV linkURL"
														onclick="openCapexProjectList(-1,0);">0</div>

													<div class="cmcc_phase_valueDIV linkURL"
														onclick="openCapexProjectList(0,0);">0</div>

													<div class="cmcc_phase_valueDIV linkURL"
														onclick="openCapexProjectList(1,0);">0</div>

													<div class="cmcc_phase_valueDIV linkURL"
														onclick="openCapexProjectList(2,0);">0</div>

													<div class="cmcc_phase_valueDIV linkURL"
														onclick="openCapexProjectList(3,0);">0</div>

													<div class="cmcc_phase_valueDIV linkURL"
														onclick="openCapexProjectList(4,0);">0</div>

													<div class="cmcc_phase_valueDIV linkURL"
														onclick="openCapexProjectList(5,0);">0</div>

													<div class="cmcc_phase_valueDIV linkURL"
														onclick="openCapexProjectList(6,0);">0</div>

													<div style="clear: both;"></div>
												</div>
											</td>
										</tr>
										<tr>
											<td style="height: 10px;"></td>
										</tr>
										<tr>
											<td><div class="cmcc_phase_column">新建项目数</div></td>
											<td>
												<div class="cmcc_phase_kuang" style="width: 826px;">
													<div class="cmcc_phase_valueDIV linkURL"
														onclick="openCapexProjectList(-1,1);">0</div>

													<div class="cmcc_phase_valueDIV linkURL"
														onclick="openCapexProjectList(0,1);">0</div>

													<div class="cmcc_phase_valueDIV linkURL"
														onclick="openCapexProjectList(1,1);">0</div>

													<div class="cmcc_phase_valueDIV linkURL"
														onclick="openCapexProjectList(2,1);">0</div>

													<div class="cmcc_phase_valueDIV linkURL"
														onclick="openCapexProjectList(3,1);">0</div>

													<div class="cmcc_phase_valueDIV linkURL"
														onclick="openCapexProjectList(4,1);">0</div>

													<div class="cmcc_phase_valueDIV linkURL"
														onclick="openCapexProjectList(5,1);">0</div>

													<div class="cmcc_phase_valueDIV linkURL"
														onclick="openCapexProjectList(6,1);">0</div>

													<div style="clear: both;"></div>
												</div>
											</td>
										</tr>
										<tr>
											<td style="height: 10px;"></td>
										</tr>
										<tr>
											<td></td>
											<td>
												<div style="width: 826px;">

													<div class="cmcc_phase_moenyTip">投资计划金额</div>

													<div class="cmcc_phase_moenyTip">&nbsp;</div>

													<div class="cmcc_phase_moenyTip">立项决策总金额</div>

													<div class="cmcc_phase_moenyTip">合同不含税总金额</div>

													<div class="cmcc_phase_moenyTip">设计批复金额</div>

													<div style="clear: both;"></div>
												</div>
											</td>
										</tr>
										<tr>
											<td>&nbsp;&nbsp;</td>
											<td><div style="width: 826px;">

													<div class="cmcc_phase_moneyValue">0&nbsp;</div>

													<div class="cmcc_phase_moneyValue">&nbsp;</div>

													<div class="cmcc_phase_moneyValue">0&nbsp;</div>

													<div class="cmcc_phase_moneyValue">0&nbsp;</div>

													<div class="cmcc_phase_moneyValue">0&nbsp;</div>

													<div style="clear: both;"></div>
												</div></td>
										</tr>
										<tr>
											<td style="height: 10px;"></td>
										</tr>
									</tbody>
								</table>

								<span class="openViewButton" onclick="openGongCheng();">CAPEX年度视图</span>

							</div>













							<script type="text/javascript">
	$("#capex_phaseStatusDIVTimeDIV").html("").append($("#capex_phaseStatusDIVTimeDIVSpan"));
</script>
						</div>
					</div>
					<div id="capex_phaseStatusDIVTimeDIV"
						class="viewChangeTime marginTopTime"></div>

					<script type="text/javascript">
/* $(document).ready(function(){
	$.ajax({
		url:"/ZongheAction.do?operation=capexPhaseStatus",
		method:"POST",
		data:{
			year:document.frm.year.value
			,departmentID:69
		},
		success:function(html){
			var div=$("#capex_phaseStatusDIV");
			div.html(html);
		}
	});
})
function showCapexPhaseTip(obj){
	var detaiObj=obj.detaiObj;
	if(detaiObj==null){
		detaiObj=new ET.FloatDIV("pahseTipNameDIV");
		obj.detaiObj=detaiObj;
		ET.Utils.addEvent(detaiObj.sourceElement,'mouseover',function(){
			window.clearTimeout(detaiObj.hideID);
		})
		ET.Utils.addEvent(detaiObj.sourceElement,'mouseout',function(){
			detaiObj.hideID=window.setTimeout(function(){
				detaiObj.hide();
			},500)
		})
	}
	detaiObj.popup(obj,{
		x:2,
		y:3
	})
} */
</script>








					<div class="chartContainerDIV" style="margin: 26px auto;">
						<div style="text-align: right">
							<div class="showHelpe" onclick="showOpexPhaseTip(this)"></div>
						</div>
						<div class="helpFloatDIV" id="opexPhaseTipNameDIV"
							style="line-height: 22px;">
							<div class="showHelpeContent" style="line-height: 23px;">
								<div>预算项目数量：年度立项制OPEX项目总数量</div>
								<div>各阶段项目数量：项目阶段为当前环节的项目数量</div>
								<div>需求阶段：需求提交-需求确认</div>
								<div>项目决策阶段：需求确认-项目决策</div>
								<div>采购阶段：项目决策-采购完成</div>
								<div>执行阶段：采购完成-报账开始</div>
								<div>报账阶段：报账开始-入账开始</div>
								<div>入账阶段：入账开始后</div>
							</div>
						</div>
						<div id="opexProjectStatusDIV">







							<div>
								<table class="statusTable" style="margin: 0 auto;" border="0"
									cellspacing="0" cellpadding="0">
									<tbody>
										<tr>
											<td style="vertical-align: top;"><div
													class="cmcc_phase_column"
													style="width: 119px; font-weight: bold;">OPEX项目流程：</div></td>
											<td>
												<div style="padding-bottom: 20px;">
													<img src="/static/images/cmcc/liucheng2.png">
												</div>
											</td>
										</tr>
										<tr>
											<td style="height: 10px;"></td>
										</tr>
										<tr>
											<td><div class="cmcc_phase_column" style="width: 119px;">项目总数：</div></td>
											<td>
												<div class="cmcc_phase_kuang"
													style="background-position: 15px 0px">
													<div class="cmcc_phase_valueDIV linkURL"
														style="width: 119px;" onclick="openOpexProjectList(-1);">387</div>

													<div class="cmcc_phase_valueDIV linkURL"
														style="width: 119px;" onclick="openOpexProjectList(0);">387</div>

													<div class="cmcc_phase_valueDIV linkURL"
														style="width: 119px;" onclick="openOpexProjectList(1);">0</div>

													<div class="cmcc_phase_valueDIV linkURL"
														style="width: 119px;" onclick="openOpexProjectList(2);">0</div>

													<div class="cmcc_phase_valueDIV linkURL"
														style="width: 119px;" onclick="openOpexProjectList(3);">0</div>

													<div class="cmcc_phase_valueDIV linkURL"
														style="width: 119px;" onclick="openOpexProjectList(4);">0</div>

													<div class="cmcc_phase_valueDIV linkURL"
														style="width: 119px;" onclick="openOpexProjectList(5);">0</div>

												</div>
											</td>
										</tr>
										<tr>
											<td style="height: 10px;"></td>
										</tr>
										<tr>
											<td></td>
											<td>
												<div style="width: 954px;">
													<div class="cmcc_phase_moenyTip" style="width: 119px;">预算金额</div>

													<div class="cmcc_phase_moenyTip" style="width: 119px;">&nbsp;</div>

													<div class="cmcc_phase_moenyTip" style="width: 119px;">立项决策金额&nbsp;</div>

													<div class="cmcc_phase_moenyTip" style="width: 119px;">合同不含税金额&nbsp;</div>

													<div class="cmcc_phase_moenyTip" style="width: 119px;">累计工时&nbsp;</div>

													<div class="cmcc_phase_moenyTip" style="width: 119px;">报账金额&nbsp;</div>

													<div class="cmcc_phase_moenyTip" style="width: 119px;">入账金额&nbsp;</div>

												</div>
											</td>
										</tr>
										<tr>
											<td>&nbsp;</td>
											<td style="text-align: center; vertical-align: top">
												<div style="width: 954px;">
													<div class="cmcc_phase_moneyValue" style="width: 119px;">0&nbsp;</div>


													<div class="cmcc_phase_moneyValue" style="width: 119px;">&nbsp;</div>



													<div class="cmcc_phase_moneyValue" style="width: 119px;">171,171.96&nbsp;</div>



													<div class="cmcc_phase_moneyValue" style="width: 119px;">0&nbsp;</div>




													<div class="cmcc_phase_moneyValue" style="width: 119px;">
														初级：0.0人天<br> 中级：0.0人天<br> 高级：0.0人天<br>
														服务：0次
													</div>




													<div class="cmcc_phase_moneyValue" style="width: 119px;">0&nbsp;</div>



													<div class="cmcc_phase_moneyValue" style="width: 119px;">0&nbsp;</div>


												</div>
											</td>
										</tr>
										<tr>
											<td style="height: 10px;"></td>
										</tr>
									</tbody>
								</table>

								<span class="openViewButton" onclick="openCaiwu();">OPEX年度视图</span>

							</div>















							<script type="text/javascript">
	$("#opexProjectStatusDIVTime").html("").append($("#opexProjectStatusDIVTimeSpan"));
</script>
						</div>
					</div>
					<div id="opexProjectStatusDIVTime"
						class="viewChangeTime marginTopTime">
						<span id="opexProjectStatusDIVTimeSpan" class="viewChangeSpan  ">数据更新时间:2小时前</span>
					</div>

					<script type="text/javascript">
/* $(document).ready(function(){
	$.ajax({
		url:"/ZongheAction.do?operation=opexProjectStatus",
		method:"POST",
		data:{
			year:document.frm.year.value
			,showOpexView:true
			,departmentID:document.frm.departmentID.value
		},
		success:function(html){
			var div=$("#opexProjectStatusDIV");
			div.html(html);
		}
	});
	
}) */
function showOpexPhaseTip(obj){
	var detaiObj=obj.detaiObj;
	if(detaiObj==null){
		detaiObj=new ET.FloatDIV("opexPhaseTipNameDIV");
		obj.detaiObj=detaiObj;
		ET.Utils.addEvent(detaiObj.sourceElement,'mouseover',function(){
			window.clearTimeout(detaiObj.hideID);
		})
		ET.Utils.addEvent(detaiObj.sourceElement,'mouseout',function(){
			detaiObj.hideID=window.setTimeout(function(){
				detaiObj.hide();
			},500)
		})
	}
	detaiObj.popup(obj,{
		x:2,
		y:3
	})
}
</script>
				</div>
			</div>
			<div class="dumascroll_barY">
				<div class="dumascroll_arrow_up"></div>
				<div class="dumascroll_handleY" style="height: 5px; top: 0px;"></div>
				<div class="dumascroll_arrow_down"></div>
			</div>
			<div class="dumascroll_barX showYScroll" style="display: none;">
				<div class="dumascroll_arrow_left"></div>
				<div class="dumascroll_handleX"></div>
				<div class="dumascroll_arrow_right"></div>
			</div>
			<div class="duma_rightButtom showYScroll"></div>
		</div>
		<script type="text/javascript">
		var  scrollbar2=new ET.ScrollBar('propDIV',{
			destoryHtml:false
		});
		window.dashScrollBar=scrollbar2;
		function scrollBoardDIV(){
			var dashBoardDIV=EventUtil.$ID("propDIV");
			
			//dashBoardDIV.style.overflow="auto";
			var bodyHeight=0;
			if(document.compatMode=='CSS1Compat'){
				bodyHeight=document.documentElement.clientHeight;
			}else{
				bodyHeight=document.body.clientHeight;
			}
			var height=bodyHeight-dashBoardDIV.getBoundingClientRect().top-0;
			if(height<=0){
				height=0;
			}
			dashBoardDIV.style.height=height+"px";
			scrollbar2.resize();
			//setSummaryJiao(oldIndexArray[oldIndex-1]);
	}
	EventUtil.addHandler(window,'resize',scrollBoardDIV);
	ET.addToggleLeftEvent(scrollBoardDIV);
	ET.Utils.addOnloadEvent(scrollBoardDIV);
	</script>
		</form>




	</div>
	</div>
	</div>





	<div style="display: none;">
		<img src="/static/images/16x16/empty.png" id="checkbox_img_clonenode"
			onclick="checkboxIMG_clickFun(this,event)"
			onmouseover="checkboxIMG_onmouseover(this)"
			onmouseout="checkboxIMG_onmouseout(this)">
	</div>
	<div id="floatDIV" class="floatDIV" style="width: 200px; height: 180px"
		onclick="floatController.bShow=true"></div>
	<div id="coverDIV" class="coverDIV"></div>
</body>
</html>