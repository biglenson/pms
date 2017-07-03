<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- 输出head模块 --%>
<jsp:include  page="../../common/Head.jsp" />
<body>
<%-- 输出系统顶级模块的菜单 --%>
<jsp:include page="../../common/TopMenu.jsp" >
	<jsp:param name="appid" value="1" />
	<jsp:param name="url" value="/projectview" />
</jsp:include>
<div class="container  " id="bodyStart_container" style="top:50px">
	<div class="content-wrap" id="bodyStart__content_Wrap" style="left:0px;">
		<div class="content-empty"></div>
		<div class="content-main">

<form name="frm" action="/pm/CMCCAction.do" method="post">  
<input type="hidden" name="operation" value="gongcheng">
<input type="hidden" name="year" value="2017">
<input type="hidden" name="menuID" value="58">
<input type="hidden" name="isDialog" value="false">
<input type="hidden" name="page" value="">


<div class="cmccTopTitle">
<div style="height:34px;width: 1000px;margin: 0px auto;">
<div style="float:left;font-size: 24px;font-weight: bold;color: #4C4C4C;">工程视图</div>
	
	<div class="HighChartYearSelect">
			









<script type="text/javascript">
	jQuery(document).ready(function(){
		var div=document.getElementById("departContainer");
		var divContainerDIV=div;
		var jContainer=$(divContainerDIV);
		var yearSpan=jContainer.find(".showYearSelectSpan span");
		var maxYear=2018;
		var yearStart=2014;
		var jprevObj = $(".yearSelectPrev");
		var jnextObj = $(".yearSelectNext");
		var yearInput=document.getElementById('yearID');
		var yearFloatObj=new ET.FloatDIV("departContainerFloatDIV",{});
		var first=true;
		var floatDIV=jQuery("#departContainerFloatDIV");
		floatDIV.on("click",".yearItem",function(event){
				var obj=$(this);
				floatDIV.find(".yearItem").filter(".selected").removeClass('selected');
				yearInput.value=obj.html();
				obj.addClass("selected");
				yearSpan.html(yearInput.value);
				changeyear(yearInput.value);
				if(yearInput.value == yearStart){
					jprevObj.addClass("disable");
					jprevObj.attr("src","/pm/images/16x16/cmcc_left_disable.png");
					jprevObj.removeAttr("overImg");
				}else{
					jprevObj.removeClass("disable");
					jprevObj.attr("src","/pm/images/16x16/cmcc_left.png");
					
				}
				if(yearInput.value == maxYear){
					jnextObj.addClass("disable");
					jnextObj.attr("src","/pm/images/16x16/cmcc_right_disable.png");
					jnextObj.removeAttr("overImg");
				}else{
					jnextObj.removeClass("disable");
					jnextObj.attr("src","/pm/images/16x16/cmcc_left.png");
					//jnextObj.attr("overImg","/pm/images/16x16/arrow_next_over.png");
				}
				floatDIV.hide();
		}).on("mouseenter",function(event){
			window.clearTimeout(yearFloatObj.hideTimeoutID);
		}).on("mouseleave",function(event){
			window.clearTimeout(yearFloatObj.showTimeoutID);
			yearFloatObj.showTimeoutID=undefined;
			yearFloatObj.hideTimeoutID=window.setTimeout(function(){
				yearFloatObj.hide();
			},500	);
		})
		var contentHeight=document.getElementById("departContaineryearDIV").offsetHeight;
		var scrollyear=new ET.ScrollBar("departContaineryearDIV");
		jContainer.on("click",".showYearSelectSpan",function(event){
			window.clearTimeout(yearFloatObj.hideTimeoutID);
			var obj=this;
			yearFloatObj.showTimeoutID=window.setTimeout(function(){
				var item= floatDIV.find(".yearItem").filter(".selected");
				var yearDIV=document.getElementById('departContaineryearDIV');
				yearFloatObj.popup(obj,{
					y:4
				})
				var maxHeight=document.body.clientHeight-div.getBoundingClientRect().top+div.offsetHeight+2;
				var containerHeight=contentHeight;
				if(contentHeight>maxHeight){
					containerHeight=maxHeight;
				}
				scrollyear.container.style.height=containerHeight+"px";
				scrollyear.container.style.width=yearSpan.get(0).parentNode.offsetWidth+"px";
				scrollyear.resize(false);
				if(first){
					first=false;
					item.get(0).scrollIntoView(false);
				}
			},200	);
		}).on("mouseenter",".showYearSelectSpan",function(event){
			window.clearTimeout(yearFloatObj.hideTimeoutID);
		}).on("mouseleave",".showYearSelectSpan",function(event){
			window.clearTimeout(yearFloatObj.showTimeoutID);
			yearFloatObj.showTimeoutID=undefined;
			yearFloatObj.hideTimeoutID=window.setTimeout(function(){
				yearFloatObj.hide();
			},500	);
		}).on("click",".yearSelectPrev",function(event){
			var obj=$(this);
			if(jnextObj.hasClass("disable")){
				jnextObj.removeClass("disable");
				jnextObj.attr("src","/pm/images/16x16/cmcc_right.png");
				//jnextObj.attr("overImg","/pm/images/16x16/arrow_next_over.png");
			}
			if(!obj.hasClass("disable")){
				var yearValue=parseInt(yearInput.value,10);
				yearValue--;
				if(yearValue>=yearStart){
					yearInput.value=yearValue;
					if(yearValue == yearStart){
						obj.addClass("disable");
						obj.attr("src","/pm/images/16x16/cmcc_left_disable.png");
						obj.removeAttr("overImg");
					}
				}
				yearSpan.html(yearValue);
				floatDIV.find(".yearItem").filter(".selected").removeClass('selected');
				floatDIV.find(".yearItem").filter("[year="+yearValue+"]").addClass('selected');
				changeyear(yearInput.value);
			}
		}).on("click",".yearSelectNext",function(event){
			var obj=$(this);
			if(jprevObj.hasClass("disable")){
				jprevObj.removeClass("disable");
				jprevObj.attr("src","/pm/images/16x16/cmcc_left.png");
				//jprevObj.attr("overImg","/pm/images/16x16/arrow_prev_over.png");
			}
			if(!obj.hasClass("disable")){
				var yearValue=parseInt(yearInput.value,10);
				yearValue++;
				if(yearValue<=maxYear){
					yearInput.value=yearValue;
					if(yearValue == maxYear){
						obj.addClass("disable");
						obj.attr("src","/pm/images/16x16/cmcc_right_disable.png");
						//obj.removeAttr("overImg");
					}
				}
				yearSpan.html(yearValue);
				floatDIV.find(".yearItem").filter(".selected").removeClass('selected');
				floatDIV.find(".yearItem").filter("[year="+yearValue+"]").addClass('selected');
				changeyear(yearInput.value);
			}
		})
	})
	
</script>
<input type="hidden" name="toolYear" id="yearID" value="2017">
<div class="yearSelectDIV" id="departContainer">
		<img class="  yearSelectPrev " src="/pm/images/16x16/cmcc_left.png">
			<span style="font-size: 12px;" class="showYearSelectSpan  ">
					<span>2017</span>
					<img src="/pm/images/yearSelect.png">
			</span>
			<img class="  yearSelectNext  " src="/pm/images/16x16/cmcc_right.png">
</div>
<div class="yearFloatDIV" id="departContainerFloatDIV">
	<div class="yearDIV dumascroll" id="departContaineryearDIV" style="width: 68px; overflow: hidden;"><div class="dumascroll_area showYScroll">
		
				<div class="yearItem " year="2014">2014</div>
		
				<div class="yearItem " year="2015">2015</div>
		
				<div class="yearItem " year="2016">2016</div>
		
				<div class="yearItem selected" year="2017">2017</div>
		
				<div class="yearItem " year="2018">2018</div>
		
	</div><div class="dumascroll_barY"><div class="dumascroll_arrow_up"></div><div class="dumascroll_handleY" style="height: 5px; top: 0px;"></div><div class="dumascroll_arrow_down"></div></div><div class="dumascroll_barX showYScroll" style="display: none;"><div class="dumascroll_arrow_left"></div><div class="dumascroll_handleX"></div><div class="dumascroll_arrow_right"></div></div><div class="duma_rightButtom showYScroll"></div></div>
</div>


	</div>
	<div style="clear:both;"></div>
	












<script type="text/javascript">
	$("#gongchengListDIVTimeDIV").html("").append($("#gongchengListDIVTimeDIVSpan"));
</script>
</div>	
	<div style="font-size:12px;line-height: 25px;text-align: right;margin:0px auto;width: 1000px;">单位:万元</div>
	</div>
	<div id="propDIV" class="yibiao_start dumascroll" style="overflow: hidden; height: 88px;"> 
		<div class=" dumascroll_area showYScroll"><div style="width: 1000px;margin: 0 auto;">
			







<style>
	.tipSpan{
		white-space: nowrap;
		line-height:23px;
	}
	.tipSpan2{
		font-weight: bold;
		font-size: 14px;
	}
	.sumTitle{
		font-size: 14px;
		line-height: 40px;
		font-weight: bold;
		color:#FFF;
		background-color: #03A9F4;
		text-align: center;
	}
	.sumValue{
		line-height:24px;
		padding-top:10px; 
		text-align: center;
		color:#0ACC4B;
		font-size:24px;
		font-weight: bold;
	}
	.sumContainer1{
		border:1px solid #D9D9D9;
		border-top:none;
	}
	.infoLabel{
		padding-left:10px;
		white-space:nowrap;
		line-height:25px;
		padding-right: 10px;
	}
	.tdBorder{
		margin:4px 0px;
		border-bottom:1px dotted #D9D9D9;
	}
</style>
<div>
	<table style="width:1000px;margin:10px auto;">
		<tbody><tr>
			<td style="width:20%;vertical-align: top;">
				<div style="margin-right:10px;">
					<div class="sumTitle">
						投资使用进度
					</div>
					<div class="sumContainer1" style="height:160px;" id="summary_touzi">










	<div class="sumValue" style="color:#0ACC4B;">
		0
	</div>
	<div style="width:97%;margin:15px auto;height:8px;background-color:#E8E9ED;">
		
		<div style=" height:100%;width:0%;background-color:#0ACC4B;" '=""></div>
	</div>
	
	
	<div style="width:96%;margin:0px auto;line-height: 23px;height: 50%">
		<table style="width: 100%;height:100%;">
			<tbody><tr>
				<td width="85px">
					<div><span class="tipSpan ">投资总额&nbsp;:</span></div>
				</td>
				<td width="100%" align="right">
					<b style="font-size: 14px;">74,156.20</b>
				</td>
			</tr>
			<tr>
				<td>
					<div><span class="tipSpan ">投资计划执行进度&nbsp;:</span></div>
				</td>
				<td align="right">
					<b style="font-size: 14px;">0.00%</b>
				</td>
			</tr>
		</tbody></table>
	</div>
	












<script type="text/javascript">
	$("#gongchengSummary0TimeDIV").html("").append($("#gongchengSummary0TimeDIVSpan"));
</script>
</div>
					<div id="gongchengSummary0TimeDIV" class="viewChangeTime"></div>
				</div>
			</td>
			<td style="width:25%;vertical-align: top;">
				<div style="margin-right:10px;">
					<div class="sumTitle">
						自主资金池使用情况
					</div>
					<div class="sumContainer1" style="height:160px;" id="summary_zizhuJin">










<div style="height:100%;">
	<div style="width:125px;height:100%;float:left" id="zizhuJinSummaryChart" data-highcharts-chart="1"><div class="highcharts-container" id="highcharts-2" style="position: relative; overflow: hidden; width: 125px; height: 160px; text-align: left; line-height: normal; z-index: 0; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);"><svg version="1.1" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Arial, Helvetica, sans-serif;font-size:12px;" xmlns="http://www.w3.org/2000/svg" width="125" height="160"><desc>Created with Highcharts 4.1.3</desc><defs><clipPath id="highcharts-3"><rect x="0" y="0" width="105" height="135"></rect></clipPath></defs><rect x="0" y="0" width="125" height="160" strokeWidth="0" fill="#FFFFFF" class=" highcharts-background"></rect><g class="highcharts-series-group" zIndex="3"><g class="highcharts-series highcharts-tracker" visibility="visible" zIndex="0.1" transform="translate(10,10) scale(1 1)" style=""><path fill="#D8D8D8" d="M 52.487779607778286 7.500001244483229 A 60 60 0 1 1 52.416661203715705 7.500057877985967 L 52.43332896297256 19.500046302388768 A 48 48 0 1 0 52.490223686222635 19.500000995586582 Z" stroke="#FFFFFF" stroke-width="1" stroke-linejoin="round" transform="translate(0,0)"></path></g><g class="highcharts-markers" visibility="visible" zIndex="0.1" transform="translate(10,10) scale(1 1)"></g></g><text x="63" text-anchor="middle" class="highcharts-title" zIndex="4" style="color:#333333;font-size:14px;fill:#333333;width:61px;" y="80"><tspan>自主资金池总额</tspan><tspan style="font-weight:bold" x="63" dy="17">0</tspan><title>自主资金池总额0</title></text><g class="highcharts-legend" zIndex="7"><g zIndex="1"><g></g></g></g></svg></div></div>
	<div style="margin-left:125px;padding-top:5px;line-height: 22px;margin-right: 2px;">
		<div style="height:8px;width:8px;display: inline-block;background-color:#46C6EF "> </div>
		立项金额 :
		<div style="padding-bottom:3px;text-align: right;"><b style="font-size: 14px;">0</b></div>
		
		<div style="height:8px;width:8px;display: inline-block;background-color:#0080CC "> </div>
		预占未立项金额 :
		<div style="padding-bottom:3px;text-align: right;"><b style="font-size: 14px;">0</b></div>
		
		<div style="height:8px;width:8px;display: inline-block;background-color:#0ACC4B "> </div>
		剩余金额 :
		<div style="padding-bottom:3px;text-align: right;"><b style="font-size: 14px;">0</b></div>
	</div>
</div>













<script type="text/javascript">
	$("#gongchengSummary1TimeDIV").html("").append($("#gongchengSummary1TimeDIVSpan"));
</script>
<script type="text/javascript">
		$("#zizhuJinSummaryChart").highcharts({
	        title: {
	            text:'自主资金池总额<br><b>0</b>',
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
        		enabled:false,
 	        },
	        plotOptions:{
	        	pie:{
	        		showInLegend: false,
		        	shadow:false,
		        	allowPointSelect:false,
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
	        	      
		        	  	 {y:1,color:'#D8D8D8'}
	        	     	
	        	    ]
	        }]
	    });
	
	</script>
</div>
					<div id="gongchengSummary1TimeDIV" class="viewChangeTime"></div>
				</div>
			</td>
			<td style="width:21%;vertical-align: top;">
				<div style="margin-right:10px;">
					<div class="sumTitle">
						开支、转资进度
					</div>
					<div class="sumContainer1" style="height:160px;" id="sumary_kaizhi">










	<table style="width: 90%;height:100%;margin: 0 auto;">
		<tbody><tr>
			<td width="60%">
				<div>资本开支实际&nbsp;:</div>
			</td>
			<td align="right" width="40%">
				<b style="font-size: 14px;">43,013.83</b>
			</td>
		</tr>
		<tr style="border-bottom:1px solid #D9D9D9;">
			<td>
				<div style="height:8px;background-color:#E8E9ED;">
					<div style="height:100%;width:0.0%;background-color:#0ACC4B;" '=""></div>
				</div>
			</td>
			<td align="right">
				<div style="color:#0ACC4B;"><b style="font-size: 14px;">0.00%</b></div>
			</td>
		</tr>
		<tr>
			<td>
				<div>转资实际&nbsp;:</div>
			</td>
			<td align="right">
				<b style="font-size: 14px;">27,318.35</b>
			</td>
		</tr>
		<tr>
			<td>
				<div style="height:8px;background-color:#E8E9ED;">
					<div style="height:100%;width:0.0%;background-color:#0ACC4B;" '=""></div>
				</div>
			</td>
			<td align="right">
				<div style="color:#0ACC4B;"><b style="font-size: 14px;">0.00%</b></div>
			</td>
		</tr>
	</tbody></table>
	












	

<script type="text/javascript">
	$("#gongchengSummary2TimeDIV").html("").append($("#gongchengSummary2TimeDIVSpan"));
</script>
</div>
					<div id="gongchengSummary2TimeDIV" class="viewChangeTime"><span id="gongchengSummary2TimeDIVSpan" class="viewChangeSpan  ">数据更新时间:2017-05-07</span></div>
				</div>
			</td>
			<td style="width:32%;vertical-align: top;">
				<div>
					<div class="sumTitle">
							CAPEX项目数量
						</div>
						<div class="sumContainer1" style="height:160px;" id="summary_projectCount">










	<div style="width:100%;height:100%;" id="summaryProjectChart" data-highcharts-chart="0"><div class="highcharts-container" id="highcharts-0" style="position: relative; overflow: hidden; width: 325px; height: 160px; text-align: left; line-height: normal; z-index: 0; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);"><svg version="1.1" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Arial, Helvetica, sans-serif;font-size:12px;" xmlns="http://www.w3.org/2000/svg" width="325" height="160"><desc>Created with Highcharts 4.1.3</desc><defs><clipPath id="highcharts-1"><rect x="0" y="0" width="140" height="135"></rect></clipPath></defs><rect x="0" y="0" width="325" height="160" strokeWidth="0" fill="#FFFFFF" class=" highcharts-background"></rect><g class="highcharts-series-group" zIndex="3"><g class="highcharts-series highcharts-tracker" visibility="visible" zIndex="0.1" transform="translate(10,10) scale(1 1)" style=""><path fill="#D8D8D8" d="M 69.98676124175981 2.5000013481901675 A 65 65 0 1 1 69.90971630402535 2.500062701151464 L 69.92777304322027 15.50005016092117 A 52 52 0 1 0 69.98940899340785 15.500001078552131 Z" stroke="#FFFFFF" stroke-width="1" stroke-linejoin="round" transform="translate(0,0)"></path></g><g class="highcharts-markers" visibility="visible" zIndex="0.1" transform="translate(10,10) scale(1 1)"></g></g><text x="78" text-anchor="middle" class="highcharts-title" zIndex="4" style="color:#333333;font-size:14px;fill:#333333;width:261px;" y="65"><tspan>总数: </tspan><tspan style="font-weight:bold" dx="0">0</tspan><tspan x="78" dy="17">新建: </tspan><tspan style="font-weight:bold" dx="0">0</tspan><tspan x="78" dy="17">续建: </tspan><tspan style="font-weight:bold" dx="0">0</tspan></text><g class="highcharts-legend" zIndex="7" transform="translate(162,63)"><g zIndex="1"><g><g class="highcharts-legend-item" zIndex="1" transform="translate(8,3)"><text x="21" style="color:#333333;font-size:12px;font-weight:bold;cursor:pointer;fill:#333333;" text-anchor="start" zIndex="2" y="15"><tspan>本 年 暂 无 相 关 数 据!</tspan></text><rect x="0" y="4" width="16" height="12" zIndex="3" fill="#D8D8D8"></rect></g></g></g></g></svg></div></div>
	












<script type="text/javascript">
	$("#gongchengSummary3TimeDIV").html("").append($("#gongchengSummary3TimeDIVSpan"));
</script>
	<script type="text/javascript">
		$("#summaryProjectChart").highcharts({
	        title: {
	            text:'总数: <b>0</b><br/>新建: <b>0</b><br/>续建: <b>0<br/></b>',
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
	              
	                return this.name;
	             
       			},
       			x:12
	        },
        	tooltip: {
        		 pointFormatter:function(){
 	                return Highcharts.numberFormat(this.y,0,".",",")+"个 " ;
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
					showInLegend: true,
	        		dataLabels:{
	        			enabled:false
	        		}
	        	}
	        },
	        series: [{
	        	type:'pie',
	        	startAngle: 0,
	            data: 
	             [{name:'本 年 暂 无 相 关 数 据!',y:1,color:'#D8D8D8'}]
	             
	             
	        }]
	    });
	
	</script>
</div>
						<div id="gongchengSummary3TimeDIV" class="viewChangeTime"></div>
				</div>
			</td>
		</tr>
	</tbody></table>
</div>
<script type="text/javascript">
jQuery(document).ready(function(){
	var doAjax=function(index,select){
		$.ajax({
			url:"/pm/GongchengAction.do?operation=summary2",
			method:"POST",
			data:{
				year:document.frm.year.value
				,departmentID:69
				,index:index
			},
			success:function(html){
				var div=$(select);
				div.html(html);
			}
		});
	};
	doAjax(0,"#summary_touzi");
	doAjax(1,"#summary_zizhuJin");
	doAjax(2,"#summary_projectCount");
	doAjax(3,"#sumary_kaizhi");
})
</script>
			








<div class="chartContainerDIV" style="margin:26px auto;">
	<div style="text-align:right">
		<div class="showHelpe" onclick="showCapexPhaseTip(this)"></div>
	</div>
	<div class="helpFloatDIV" id="pahseTipNameDIV" style="line-height: 22px;">
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
	<div id="capex_phaseStatusDIV" style="min-height:120px;">








<div>
<table class="statusTable" style="margin:0 auto;" border="0" cellspacing="0" cellpadding="0">
	<tbody><tr>
		<td style="vertical-align: top;"><div class="cmcc_phase_column" style="font-weight: bold;">CAPEX项目流程:</div></td>
		<td>
			<div style="padding-bottom:20px;"><img src="/pm/images/cmcc/liucheng.png"></div>
		</td>
	</tr>
	
	<tr>
		<td><div class="cmcc_phase_column">项目总数</div></td>
		<td>
			<div class="cmcc_phase_kuang" style="width:826px;">
				<div class="cmcc_phase_valueDIV linkURL" onclick="openCapexProjectList(-1,0);">0</div>
				
				<div class="cmcc_phase_valueDIV linkURL" onclick="openCapexProjectList(0,0);">0</div>
				
				<div class="cmcc_phase_valueDIV linkURL" onclick="openCapexProjectList(1,0);">0</div>
				
				<div class="cmcc_phase_valueDIV linkURL" onclick="openCapexProjectList(2,0);">0</div>
				
				<div class="cmcc_phase_valueDIV linkURL" onclick="openCapexProjectList(3,0);">0</div>
				
				<div class="cmcc_phase_valueDIV linkURL" onclick="openCapexProjectList(4,0);">0</div>
				
				<div class="cmcc_phase_valueDIV linkURL" onclick="openCapexProjectList(5,0);">0</div>
				
				<div class="cmcc_phase_valueDIV linkURL" onclick="openCapexProjectList(6,0);">0</div>
				
				<div style="clear: both;"></div>
			</div>
		</td>
	</tr>
	<tr><td style="height:10px;"></td></tr>
	<tr>
		<td><div class="cmcc_phase_column">新建项目数</div></td>
		<td>
		<div class="cmcc_phase_kuang" style="width:826px;">
			<div class="cmcc_phase_valueDIV linkURL" onclick="openCapexProjectList(-1,1);">0</div>
			
				<div class="cmcc_phase_valueDIV linkURL" onclick="openCapexProjectList(0,1);">0</div>
			
				<div class="cmcc_phase_valueDIV linkURL" onclick="openCapexProjectList(1,1);">0</div>
			
				<div class="cmcc_phase_valueDIV linkURL" onclick="openCapexProjectList(2,1);">0</div>
			
				<div class="cmcc_phase_valueDIV linkURL" onclick="openCapexProjectList(3,1);">0</div>
			
				<div class="cmcc_phase_valueDIV linkURL" onclick="openCapexProjectList(4,1);">0</div>
			
				<div class="cmcc_phase_valueDIV linkURL" onclick="openCapexProjectList(5,1);">0</div>
			
				<div class="cmcc_phase_valueDIV linkURL" onclick="openCapexProjectList(6,1);">0</div>
			
			<div style="clear: both;"></div>
		</div></td>
	</tr>
	<tr><td style="height:10px;">
	
	</td></tr><tr>
		<td></td>
		<td>
			<div style="width:826px;">
				
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
		<td> 
			&nbsp;&nbsp;
		</td>
		<td><div style="width:826px;">
			
				<div class="cmcc_phase_moneyValue">0&nbsp;</div>
			
				<div class="cmcc_phase_moneyValue">&nbsp;</div>
			
				<div class="cmcc_phase_moneyValue">0&nbsp;</div>
			
				<div class="cmcc_phase_moneyValue">0&nbsp;</div>
			
				<div class="cmcc_phase_moneyValue">0&nbsp;</div>
			
			<div style="clear: both;"></div>
		</div></td>
	</tr>
	<tr><td style="height:10px;"></td></tr>
</tbody></table>

</div>













<script type="text/javascript">
	$("#capex_phaseStatusDIVTimeDIV").html("").append($("#capex_phaseStatusDIVTimeDIVSpan"));
</script></div>
</div>
<div id="capex_phaseStatusDIVTimeDIV" class="viewChangeTime marginTopTime"></div>
<script type="text/javascript">
$(document).ready(function(){
	$.ajax({
		url:"/pm/ZongheAction.do?operation=capexPhaseStatus",
		method:"POST",
		data:{
			year:document.frm.year.value
			,departmentID:69
			,showCapexView:false
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
}
</script>
			







<script type="text/javascript">
	function A__changePlan(index){
		$.ajax({
			url:"/pm/GongchengAction.do?operation=planResult",
			method:"POST",
			data:{
				year:document.frm.year.value
				,index:index
			},
			success:function(html){
				var div=$("#gongcheng_planDIV");
				div.html(html);
			}
		});
	}
	jQuery(document).ready(function(){
		A__changePlan(0);
	})
	function showZhuanziTip(obj,divName){
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
	<div class="chartContainerDIV cmccViewContainer" style="margin: 26px auto;">
		<div id="gongcheng_planDIV">
		








<div class="tabMore linkURL" onclick="openTouzizhixingDetail()">更多</div>

<div style="height:10px;"></div>

<div class="tabTitle">
 	<ul>
 		<li onclick="A__changePlan(0)" class="on">投资计划</li>
 		<li onclick="A__changePlan(1)" class="">资本开支</li>
 		<li onclick="A__changePlan(2)" class="">转资</li>
 	</ul>
 </div>
		<div class="tabContent" style="height: 150px;">
				<div class="loaddingClass"></div>
			</div>
		</div>
	</div>
	<div id="gongchengPlanDIVTimeDIV" class="viewChangeTime marginTopTime"></div>
	
			








	

<script type="text/javascript">
 function openCAPEXMain(projectID){
	 
 	var arg = new Array();
	arg.src = "/pm/CAPEXAction.do?operation=capexMain"
		+"&projectID="+projectID
		+"&_id="+Math.random();
	arg.src += "&isDialog=true";
	//arg.title = "项目全生命周期视图";
	ET.showNewWindow(arg, function (ret) { 
		if(ret != null){
			
		}
	});
 }
	function A_changeList(index){
		$.ajax({
			url:"/pm/GongchengAction.do?operation=gongchengListResult",
			method:"POST",
			data:{
				year:document.frm.year.value
				,index:index
				,thisPage:document.getElementById("thisPage").value
			},
			success:function(html){
				var div=$("#capexListContainer");
				div.html(html);
			}
		});
	}
	jQuery(document).ready(function(){
		A_changeList(0);
	})


	function changeCapexProjectPage(val){
		document.getElementById("thisPage").value = val;
		A_changeList(1);
	}
	
	function changeTouziplanPage(val){
		document.getElementById("thisPage").value = val;
		A_changeList(0);
	}
	
</script>
<div class="chartContainerDIV cmccViewContainer" style="margin: 26px auto;">
	<div id="capexListContainer">







	
		











	












	<div class="tabMore linkURL" onclick="openniandutouziplan()">更多</div>


 <div class="tabTitle">
 	<ul>
 		<li onclick="A_changeList(0)" class="on">投资计划</li>
 		<li onclick="A_changeList(1)" class="">CAPEX项目</li>
 	</ul>
 </div>
 
<input type="hidden" id="thisPage" name="thisPage" value="1">

<div id="listDIV" class="tabContent"> 
	<table border="0" cellpadding="0" cellspacing="0" class="listTable" id="entryTable">
    	<thead>
			<tr>
				<th width="100%"><div style="width:100%">项目集/项目名称</div></th>
				<th><div style="width:250px;">项目集/项目编码</div></th>
				<th><div style="width:80px;">专业</div></th>
				<th><div style="width:80px;">属性</div></th>
				<th><div style="width:91px;">项目集总投资</div></th>
				<th><div style="width:90px;">上年底累计完成资本开支</div></th>
				<th><div style="width:90px;">项目集结转资本开支</div></th>	
			</tr>
		</thead>
		<tbody>
			
				<tr class="listTableTR">
					<td align="center">徐晓秋</td>
					<td align="center">ssss</td>
					<td align="center"></td>
					<td align="center">其他</td>
					<td align="center">
						
					</td>
					<td align="center">
						
					</td>
					<td align="center">
						
					</td>
				</tr>
			
				<tr class="listTableTR">
					<td align="center">IMS域核心网扩容四期工程</td>
					<td align="center">ZQS173123500</td>
					<td align="center">移动通信网</td>
					<td align="center">新建</td>
					<td align="center">
						727.00
					</td>
					<td align="center">
						
					</td>
					<td align="center">
						218.10
					</td>
				</tr>
			
				<tr class="listTableTR">
					<td align="center">行业网关八期工程</td>
					<td align="center">ZQS173313504</td>
					<td align="center">业务网</td>
					<td align="center">新建</td>
					<td align="center">
						1,300.00
					</td>
					<td align="center">
						
					</td>
					<td align="center">
						390.00
					</td>
				</tr>
			
				<tr class="listTableTR">
					<td align="center">物联卡管理平台二期工程</td>
					<td align="center">ZQS173313505</td>
					<td align="center">业务网</td>
					<td align="center">新建</td>
					<td align="center">
						300.00
					</td>
					<td align="center">
						
					</td>
					<td align="center">
						300.00
					</td>
				</tr>
			
				<tr class="listTableTR">
					<td align="center">行业WLAN平台四期工程</td>
					<td align="center">ZQS173313506</td>
					<td align="center">业务网</td>
					<td align="center">新建</td>
					<td align="center">
						500.00
					</td>
					<td align="center">
						
					</td>
					<td align="center">
						500.00
					</td>
				</tr>
			
				<tr class="listTableTR">
					<td align="center">和对讲平台四期工程</td>
					<td align="center">ZQS173313507</td>
					<td align="center">业务网</td>
					<td align="center">新建</td>
					<td align="center">
						1,200.00
					</td>
					<td align="center">
						
					</td>
					<td align="center">
						600.00
					</td>
				</tr>
			
				<tr class="listTableTR">
					<td align="center">XXXx</td>
					<td align="center">XXXXXXX111</td>
					<td align="center"></td>
					<td align="center">其他</td>
					<td align="center">
						
					</td>
					<td align="center">
						
					</td>
					<td align="center">
						
					</td>
				</tr>
			
				<tr class="listTableTR">
					<td align="center">徐晓秋</td>
					<td align="center">xxxxxx</td>
					<td align="center"></td>
					<td align="center">其他</td>
					<td align="center">
						
					</td>
					<td align="center">
						
					</td>
					<td align="center">
						
					</td>
				</tr>
			
				<tr class="listTableTR">
					<td align="center">千里眼平台二期工程</td>
					<td align="center">ZQS173313508</td>
					<td align="center">业务网</td>
					<td align="center">新建</td>
					<td align="center">
						800.00
					</td>
					<td align="center">
						
					</td>
					<td align="center">
						560.00
					</td>
				</tr>
			
				<tr class="listTableTR">
					<td align="center">移动终端管理平台二期工程</td>
					<td align="center">ZQS173313509</td>
					<td align="center">业务网</td>
					<td align="center">新建</td>
					<td align="center">
						280.00
					</td>
					<td align="center">
						
					</td>
					<td align="center">
						280.00
					</td>
				</tr>
			
			
			
		</tbody>
	</table>
<div class="pageFooter" id="pageToolbarDIV"><span><a class="pageToolBarLink page_first "> <img src="/pm/images/16x16/arrow_first_disable.png" border="0"></a><a class="pageToolBarLink page_prev"><img src="/pm/images/16x16/arrow_prev_disable.png" border="0"></a><select name="pageNo" onchange="changeTouziplanPage(this.value);"><option value="1" selected="">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option><option value="6">6</option><option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option><option value="11">11</option><option value="12">12</option><option value="13">13</option><option value="14">14</option></select> <div class="pageCount">/14页</div><a class="pageToolBarLink page_next" href="javascript:changeTouziplanPage('2');"><img src="/pm/images/16x16/arrow_next.png" overimg="/pm/images/16x16/arrow_next_over.png" border="0"></a><a class="pageToolBarLink page_end" href="javascript:changeTouziplanPage('14');"><img src="/pm/images/16x16/arrow_last.png" overimg="/pm/images/16x16/arrow_last_over.png" border="0"></a></span><span class="pageText">共132条</span></div>
<div style="height:10px;"></div>
</div>

	
	












	

<script type="text/javascript">
	$("#gongchengListTimeDIV").html("").append($("#gongchengListTimeDIVSpan"));
</script>
</div>
</div>
<div id="gongchengListTimeDIV" class="viewChangeTime marginTopTime"><span id="gongchengListTimeDIVSpan" class="viewChangeSpan  ">数据更新时间:2017-05-09</span></div>

		</div></div>
	<div class="dumascroll_barY"><div class="dumascroll_arrow_up"></div><div class="dumascroll_handleY" style="height: 6.10726px; top: 0px;"></div><div class="dumascroll_arrow_down"></div></div><div class="dumascroll_barX showYScroll" style="display: none;"><div class="dumascroll_arrow_left"></div><div class="dumascroll_handleX"></div><div class="dumascroll_arrow_right"></div></div><div class="duma_rightButtom showYScroll"></div></div>
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
				//dashBoardDIV.style.width=(document.body.clientWidth-dashBoardDIV.getBoundingClientRect().left)+"px";
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





<div style="display: none;"><img src="images/16x16/empty.png" id="checkbox_img_clonenode" onclick="checkboxIMG_clickFun(this,event)" onmouseover="checkboxIMG_onmouseover(this)" onmouseout="checkboxIMG_onmouseout(this)"></div><div id="floatDIV" class="floatDIV" style="width:200px;height:180px" onclick="floatController.bShow=true"></div><div id="coverDIV" class="coverDIV"></div></body>
</html>