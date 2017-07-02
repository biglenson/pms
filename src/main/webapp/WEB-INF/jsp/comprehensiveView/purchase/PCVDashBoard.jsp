<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- 输出head模块 --%>
<jsp:include  page="../../common/Head.jsp" />
<body>
<%-- 输出系统顶级模块的菜单 --%>
<jsp:include page="../../common/TopMenu.jsp" >
	<jsp:param name="appid" value="1" />
	<jsp:param name="url" value="/purchaseview" />
</jsp:include>
<div class="container" id="bodyStart_container" style="top:50px">
	<div class="content-wrap" id="bodyStart__content_Wrap" style="left:0px;">
		<div class="content-empty"></div>
		<div class="content-main">

<form name="frm" action="/pm/CMCCAction.do" method="post">  
<input type="hidden" name="operation" value="caiGou">
<input type="hidden" name="year" value="2017">
<input type="hidden" name="menuID" value="57">
<input type="hidden" name="page" value="">
<div class="cmccTopTitle">
<div style="height:34px;width: 1000px;margin: 0px auto;">
<div style="float:left;font-size: 24px;font-weight: bold;color: #4C4C4C;">采购视图</div>
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
</div>
<div style="font-size:12px;line-height: 25px;text-align: right;margin:0px auto;width: 1000px;">单位:万元</div>
</div>
<div id="propDIV" class="yibiao_start dumascroll" style="overflow: hidden; height: 88px;">
	<div class=" dumascroll_area showYScroll"><div style="width: 1000px;margin: 0 auto;">
		







<script type="text/javascript">
	jQuery(document).ready(function(){
		$.ajax({
			url:"/pm/CaiGouAction.do?operation=caiGouTotalMoneyInfo",
			method:"POST",
			data:{
				year:document.frm.year.value
			},
			success:function(html){
				var div=$("#totalMoneyInfoDIV");
				div.html(html);
			}
		});
		$.ajax({
			url:"/pm/CaiGouAction.do?operation=caiGouTotalProjectInfo",
			method:"POST",
			data:{
				year:document.frm.year.value
			},
			success:function(html){
				var div=$("#totalProjectInfoDIV");
				div.html(html);
			}
		});
	})
</script>
<div>
	<table style="width:1000px;margin:10px auto;">
		<tbody><tr><td style="width:50%;vertical-align: top;">
			<div style="margin-right:10px;">
				<div class="sumTitle">
					采购金额
				</div>
				<div class="tabContent" style="height: 470px;width:488px;" id="totalMoneyInfoDIV">










<table style="width: 100%;height: 100%;">
	<tbody><tr>
		<td>
			<div id="totalMoney" data-highcharts-chart="4"><div class="highcharts-container" id="highcharts-8" style="position: relative; overflow: hidden; width: 488px; height: 400px; text-align: left; line-height: normal; z-index: 0; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);"><svg version="1.1" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Arial, Helvetica, sans-serif;font-size:12px;" xmlns="http://www.w3.org/2000/svg" width="488" height="400"><desc>Created with Highcharts 4.1.3</desc><defs><clipPath id="highcharts-9"><rect x="0" y="0" width="406" height="349"></rect></clipPath></defs><rect x="0" y="0" width="488" height="400" strokeWidth="0" fill="#FFFFFF" class=" highcharts-background"></rect><g class="highcharts-grid" zIndex="1"></g><g class="highcharts-grid" zIndex="1"></g><g class="highcharts-axis" zIndex="2"><path fill="none" d="M 206.5 359 L 206.5 369" stroke="#C0D0E0" stroke-width="1" opacity="1"></path><path fill="none" d="M 342.5 359 L 342.5 369" stroke="#C0D0E0" stroke-width="1" opacity="1"></path><path fill="none" d="M 477.5 359 L 477.5 369" stroke="#C0D0E0" stroke-width="1" opacity="1"></path><path fill="none" d="M 71.5 359 L 71.5 369" stroke="#C0D0E0" stroke-width="1" opacity="1"></path><path fill="none" d="M 72 359.5 L 478 359.5" stroke="#C0D0E0" stroke-width="1" zIndex="7" visibility="visible"></path></g><g class="highcharts-axis" zIndex="2"><text x="132" zIndex="7" text-anchor="end" transform="translate(0,0)" class=" highcharts-yaxis-title" style="color:#707070;fill:#707070;" visibility="visible" y="10">单位:万元</text><path fill="none" d="M 71.5 10 L 71.5 359" stroke="#C0D0E0" stroke-width="1" zIndex="7" visibility="visible"></path></g><g class="highcharts-series-group" zIndex="3"><g class="highcharts-series highcharts-tracker" visibility="visible" zIndex="0.1" transform="translate(72,10) scale(1 1)" style="" clip-path="url(#highcharts-9)"><rect x="31.5" y="38.5" width="30" height="311" stroke="#FFFFFF" stroke-width="1" fill="#46c6f0" rx="0" ry="0"></rect><rect x="167.5" y="349.5" width="30" height="0" stroke="#FFFFFF" stroke-width="1" fill="#46c6f0" rx="0" ry="0"></rect><rect x="302.5" y="38.5" width="30" height="311" stroke="#FFFFFF" stroke-width="1" fill="#46c6f0" rx="0" ry="0"></rect></g><g class="highcharts-markers" visibility="visible" zIndex="0.1" transform="translate(72,10) scale(1 1)" clip-path="none"></g><g class="highcharts-series highcharts-tracker" visibility="visible" zIndex="0.1" transform="translate(72,10) scale(1 1)" style="" clip-path="url(#highcharts-9)"><rect x="72.5" y="349.5" width="30" height="0" stroke="#FFFFFF" stroke-width="1" fill="#a8da72" rx="0" ry="0"></rect><rect x="207.5" y="349.5" width="30" height="0" stroke="#FFFFFF" stroke-width="1" fill="#a8da72" rx="0" ry="0"></rect><rect x="343.5" y="349.5" width="30" height="0" stroke="#FFFFFF" stroke-width="1" fill="#a8da72" rx="0" ry="0"></rect></g><g class="highcharts-markers" visibility="visible" zIndex="0.1" transform="translate(72,10) scale(1 1)" clip-path="none"></g></g><g class="highcharts-data-labels highcharts-tracker" visibility="visible" zIndex="6" transform="translate(72,10) scale(1 1)" opacity="1" style=""><g zIndex="1" style="" transform="translate(24,11)"><text x="5" zIndex="1" style="font-size: 11px; font-weight: bold; color: rgb(0, 0, 0); fill: rgb(0, 0, 0); text-shadow: rgb(255, 255, 255) 0px 0px 6px, rgb(255, 255, 255) 0px 0px 3px;" y="17"><tspan>22.25</tspan></text></g><g zIndex="1" style="" transform="translate(164,322)"><text x="5" zIndex="1" style="font-size: 11px; font-weight: bold; color: rgb(0, 0, 0); fill: rgb(0, 0, 0); text-shadow: rgb(255, 255, 255) 0px 0px 6px, rgb(255, 255, 255) 0px 0px 3px;" y="17"><tspan>0.00</tspan></text></g><g zIndex="1" style="" transform="translate(295,11)"><text x="5" zIndex="1" style="font-size: 11px; font-weight: bold; color: rgb(0, 0, 0); fill: rgb(0, 0, 0); text-shadow: rgb(255, 255, 255) 0px 0px 6px, rgb(255, 255, 255) 0px 0px 3px;" y="17"><tspan>22.25</tspan></text></g></g><g class="highcharts-data-labels highcharts-tracker" visibility="visible" zIndex="6" transform="translate(72,10) scale(1 1)" opacity="1" style=""><g zIndex="1" style="" transform="translate(69,322)"><text x="5" zIndex="1" style="font-size: 11px; font-weight: bold; color: rgb(0, 0, 0); fill: rgb(0, 0, 0); text-shadow: rgb(255, 255, 255) 0px 0px 6px, rgb(255, 255, 255) 0px 0px 3px;" y="17"><tspan>0.00</tspan></text></g><g zIndex="1" style="" transform="translate(204,322)"><text x="5" zIndex="1" style="font-size: 11px; font-weight: bold; color: rgb(0, 0, 0); fill: rgb(0, 0, 0); text-shadow: rgb(255, 255, 255) 0px 0px 6px, rgb(255, 255, 255) 0px 0px 3px;" y="17"><tspan>0.00</tspan></text></g><g zIndex="1" style="" transform="translate(340,322)"><text x="5" zIndex="1" style="font-size: 11px; font-weight: bold; color: rgb(0, 0, 0); fill: rgb(0, 0, 0); text-shadow: rgb(255, 255, 255) 0px 0px 6px, rgb(255, 255, 255) 0px 0px 3px;" y="17"><tspan>0.00</tspan></text></g></g><g class="highcharts-legend" zIndex="7" transform="translate(311,-8)"><g zIndex="1"><g><g class="highcharts-legend-item" zIndex="1" transform="translate(8,3)"><text x="21" style="color:#333333;font-size:12px;font-weight:bold;cursor:pointer;fill:#333333;" text-anchor="start" zIndex="2" y="15">CAPEX</text><rect x="0" y="4" width="16" height="12" zIndex="3" fill="#46c6f0"></rect></g><g class="highcharts-legend-item" zIndex="1" transform="translate(87.421875,3)"><text x="21" y="15" style="color:#333333;font-size:12px;font-weight:bold;cursor:pointer;fill:#333333;" text-anchor="start" zIndex="2">OPEX</text><rect x="0" y="4" width="16" height="12" zIndex="3" fill="#a8da72"></rect></g></g></g></g><g class="highcharts-axis-labels highcharts-xaxis-labels" zIndex="7"><text x="139.66666666666669" style="color:#606060;cursor:default;font-size:11px;fill:#606060;width:146px;text-overflow:clip;" text-anchor="middle" transform="translate(0,0)" y="379" opacity="1">一级集采金额</text><text x="275" style="color:#606060;cursor:default;font-size:11px;fill:#606060;width:146px;text-overflow:clip;" text-anchor="middle" transform="translate(0,0)" y="379" opacity="1">二级集采金额</text><text x="410.33333333333337" style="color:#606060;cursor:default;font-size:11px;fill:#606060;width:146px;text-overflow:clip;" text-anchor="middle" transform="translate(0,0)" y="379" opacity="1">总采购金额</text></g><g class="highcharts-axis-labels highcharts-yaxis-labels" zIndex="7"></g><g class="highcharts-tooltip" zIndex="8" style="cursor:default;padding:0;white-space:nowrap;" transform="translate(0,-9999)"><path fill="none" d="M 3 0 L 13 0 C 16 0 16 0 16 3 L 16 13 C 16 16 16 16 13 16 L 3 16 C 0 16 0 16 0 13 L 0 3 C 0 0 0 0 3 0" isShadow="true" stroke="black" stroke-opacity="0.049999999999999996" stroke-width="5" transform="translate(1, 1)"></path><path fill="none" d="M 3 0 L 13 0 C 16 0 16 0 16 3 L 16 13 C 16 16 16 16 13 16 L 3 16 C 0 16 0 16 0 13 L 0 3 C 0 0 0 0 3 0" isShadow="true" stroke="black" stroke-opacity="0.09999999999999999" stroke-width="3" transform="translate(1, 1)"></path><path fill="none" d="M 3 0 L 13 0 C 16 0 16 0 16 3 L 16 13 C 16 16 16 16 13 16 L 3 16 C 0 16 0 16 0 13 L 0 3 C 0 0 0 0 3 0" isShadow="true" stroke="black" stroke-opacity="0.15" stroke-width="1" transform="translate(1, 1)"></path><path fill="rgba(249, 249, 249, .85)" d="M 3 0 L 13 0 C 16 0 16 0 16 3 L 16 13 C 16 16 16 16 13 16 L 3 16 C 0 16 0 16 0 13 L 0 3 C 0 0 0 0 3 0"></path><text x="8" zIndex="1" style="font-size:12px;color:#333333;fill:#333333;" y="20"></text></g></svg></div></div>
		</td>
	</tr>
	<tr>
		<td>
			<table style="margin-left: 68px;width: 420px;">
				<tbody><tr style="line-height: 22px;font-weight: bold;vertical-align: top;">
					
					<td align="center" width="33.3%;">22.25<br>100.00%</td>
					<td align="center" width="33.3%;">0<br>0.00%</td>
					<td align="center" width="33.3%;">22.25</td>
				</tr>
			</tbody></table>
		</td>
	</tr>
</tbody></table>













	

<script type="text/javascript">
	$("#caigouTotalMoneyInfoDIVTimeDIV").html("").append($("#caigouTotalMoneyInfoDIVTimeDIVSpan"));
</script>
<script type="text/javascript">
$('#totalMoney').highcharts({
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
        categories: ["一级集采金额","二级集采金额","总采购金额"],
	 	lineColor: '#C0D0E0',
        lineWidth: 1,
        tickWidth:1,
        max:2
    },
    yAxis: {
        title: {
            text: '单位:万元',
            align:'high',
            rotation:0,
            y:0,
            x:70
        },
        min:0,
        gridLineWidth: 0,
        lineColor: '#C0D0E0',
        lineWidth: 1,
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
    legend: {
        align: 'right',
        verticalAlign: 'top',
        x: -20,
        y: -18,
        floating: true,
        borderWidth: 0,
        shadow: false
    },
    tooltip: {
        formatter: function () {
            return this.x + ': ' + Highcharts.numberFormat(this.y/10000,2);
        }
    },
    series: [{
        name: 'CAPEX',
        data: [222545.40999999997,0.0,222545.40999999997]
    },{
        name: 'OPEX',
        data: [0.0,0.0,0.0]
    }]
});
</script></div>
				<div id="caigouTotalMoneyInfoDIVTimeDIV" class="viewChangeTime"><span id="caigouTotalMoneyInfoDIVTimeDIVSpan" class="viewChangeSpan  ">数据更新时间:2016-12-31</span></div>
			</div>
		</td>
		
		<td style="width:50%;vertical-align: top;">
			<div>
				<div class="sumTitle">
					采购项目数
				</div>
				<div class="tabContent" style="height: 470px;" id="totalProjectInfoDIV">










<table style="width: 100%;height: 100%;">
	<tbody><tr>
		<td>
			<div id="totalProject" data-highcharts-chart="1"><div class="highcharts-container" id="highcharts-2" style="position: relative; overflow: hidden; width: 478px; height: 400px; text-align: left; line-height: normal; z-index: 0; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);"><svg version="1.1" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Arial, Helvetica, sans-serif;font-size:12px;" xmlns="http://www.w3.org/2000/svg" width="478" height="400"><desc>Created with Highcharts 4.1.3</desc><defs><clipPath id="highcharts-3"><rect x="0" y="0" width="408" height="349"></rect></clipPath></defs><rect x="0" y="0" width="478" height="400" strokeWidth="0" fill="#FFFFFF" class=" highcharts-background"></rect><g class="highcharts-grid" zIndex="1"></g><g class="highcharts-grid" zIndex="1"></g><g class="highcharts-axis" zIndex="2"><path fill="none" d="M 195.5 359 L 195.5 369" stroke="#C0D0E0" stroke-width="1" opacity="1"></path><path fill="none" d="M 331.5 359 L 331.5 369" stroke="#C0D0E0" stroke-width="1" opacity="1"></path><path fill="none" d="M 468.5 359 L 468.5 369" stroke="#C0D0E0" stroke-width="1" opacity="1"></path><path fill="none" d="M 59.5 359 L 59.5 369" stroke="#C0D0E0" stroke-width="1" opacity="1"></path><path fill="none" d="M 60 359.5 L 468 359.5" stroke="#C0D0E0" stroke-width="1" zIndex="7" visibility="visible"></path></g><g class="highcharts-axis" zIndex="2"><text x="120" zIndex="7" text-anchor="end" transform="translate(0,0)" class=" highcharts-yaxis-title" style="color:#707070;fill:#707070;" visibility="visible" y="10">单位:个</text><path fill="none" d="M 59.5 10 L 59.5 359" stroke="#C0D0E0" stroke-width="1" zIndex="7" visibility="visible"></path></g><g class="highcharts-series-group" zIndex="3"><g class="highcharts-series highcharts-tracker" visibility="visible" zIndex="0.1" transform="translate(60,10) scale(1 1)" style="" clip-path="url(#highcharts-3)"><rect x="32.5" y="50.5" width="30" height="299" stroke="#FFFFFF" stroke-width="1" fill="#46c6f0" rx="0" ry="0"></rect><rect x="168.5" y="349.5" width="30" height="0" stroke="#FFFFFF" stroke-width="1" fill="#46c6f0" rx="0" ry="0"></rect><rect x="304.5" y="50.5" width="30" height="299" stroke="#FFFFFF" stroke-width="1" fill="#46c6f0" rx="0" ry="0"></rect></g><g class="highcharts-markers" visibility="visible" zIndex="0.1" transform="translate(60,10) scale(1 1)" clip-path="none"></g><g class="highcharts-series highcharts-tracker" visibility="visible" zIndex="0.1" transform="translate(60,10) scale(1 1)" style="" clip-path="url(#highcharts-3)"><rect x="72.5" y="349.5" width="30" height="0" stroke="#FFFFFF" stroke-width="1" fill="#a8da72" rx="0" ry="0"></rect><rect x="208.5" y="349.5" width="30" height="0" stroke="#FFFFFF" stroke-width="1" fill="#a8da72" rx="0" ry="0"></rect><rect x="344.5" y="349.5" width="30" height="0" stroke="#FFFFFF" stroke-width="1" fill="#a8da72" rx="0" ry="0"></rect></g><g class="highcharts-markers" visibility="visible" zIndex="0.1" transform="translate(60,10) scale(1 1)" clip-path="none"></g></g><g class="highcharts-data-labels highcharts-tracker" visibility="visible" zIndex="6" transform="translate(60,10) scale(1 1)" opacity="1" style=""><g zIndex="1" style="" transform="translate(39,23)"><text x="5" zIndex="1" style="font-size: 11px; font-weight: bold; color: rgb(0, 0, 0); fill: rgb(0, 0, 0); text-shadow: rgb(255, 255, 255) 0px 0px 6px, rgb(255, 255, 255) 0px 0px 3px;" y="17"><tspan>3</tspan></text></g><g zIndex="1" style="" transform="translate(175,322)"><text x="5" zIndex="1" style="font-size: 11px; font-weight: bold; color: rgb(0, 0, 0); fill: rgb(0, 0, 0); text-shadow: rgb(255, 255, 255) 0px 0px 6px, rgb(255, 255, 255) 0px 0px 3px;" y="17"><tspan>0</tspan></text></g><g zIndex="1" style="" transform="translate(311,23)"><text x="5" zIndex="1" style="font-size: 11px; font-weight: bold; color: rgb(0, 0, 0); fill: rgb(0, 0, 0); text-shadow: rgb(255, 255, 255) 0px 0px 6px, rgb(255, 255, 255) 0px 0px 3px;" y="17"><tspan>3</tspan></text></g></g><g class="highcharts-data-labels highcharts-tracker" visibility="visible" zIndex="6" transform="translate(60,10) scale(1 1)" opacity="1" style=""><g zIndex="1" style="" transform="translate(79,322)"><text x="5" zIndex="1" style="font-size: 11px; font-weight: bold; color: rgb(0, 0, 0); fill: rgb(0, 0, 0); text-shadow: rgb(255, 255, 255) 0px 0px 6px, rgb(255, 255, 255) 0px 0px 3px;" y="17"><tspan>0</tspan></text></g><g zIndex="1" style="" transform="translate(215,322)"><text x="5" zIndex="1" style="font-size: 11px; font-weight: bold; color: rgb(0, 0, 0); fill: rgb(0, 0, 0); text-shadow: rgb(255, 255, 255) 0px 0px 6px, rgb(255, 255, 255) 0px 0px 3px;" y="17"><tspan>0</tspan></text></g><g zIndex="1" style="" transform="translate(351,322)"><text x="5" zIndex="1" style="font-size: 11px; font-weight: bold; color: rgb(0, 0, 0); fill: rgb(0, 0, 0); text-shadow: rgb(255, 255, 255) 0px 0px 6px, rgb(255, 255, 255) 0px 0px 3px;" y="17"><tspan>0</tspan></text></g></g><g class="highcharts-legend" zIndex="7" transform="translate(301,-8)"><g zIndex="1"><g><g class="highcharts-legend-item" zIndex="1" transform="translate(8,3)"><text x="21" style="color:#333333;font-size:12px;font-weight:bold;cursor:pointer;fill:#333333;" text-anchor="start" zIndex="2" y="15">CAPEX</text><rect x="0" y="4" width="16" height="12" zIndex="3" fill="#46c6f0"></rect></g><g class="highcharts-legend-item" zIndex="1" transform="translate(87.421875,3)"><text x="21" y="15" style="color:#333333;font-size:12px;font-weight:bold;cursor:pointer;fill:#333333;" text-anchor="start" zIndex="2">OPEX</text><rect x="0" y="4" width="16" height="12" zIndex="3" fill="#a8da72"></rect></g></g></g></g><g class="highcharts-axis-labels highcharts-xaxis-labels" zIndex="7"><text x="128" style="color:#606060;cursor:default;font-size:11px;fill:#606060;width:143px;text-overflow:clip;" text-anchor="middle" transform="translate(0,0)" y="379" opacity="1">一级集采项目</text><text x="264" style="color:#606060;cursor:default;font-size:11px;fill:#606060;width:143px;text-overflow:clip;" text-anchor="middle" transform="translate(0,0)" y="379" opacity="1">二级集采项目</text><text x="400" style="color:#606060;cursor:default;font-size:11px;fill:#606060;width:143px;text-overflow:clip;" text-anchor="middle" transform="translate(0,0)" y="379" opacity="1">总采购项目</text></g><g class="highcharts-axis-labels highcharts-yaxis-labels" zIndex="7"></g><g class="highcharts-tooltip" zIndex="8" style="cursor:default;padding:0;white-space:nowrap;" transform="translate(0,-9999)"><path fill="none" d="M 3 0 L 13 0 C 16 0 16 0 16 3 L 16 13 C 16 16 16 16 13 16 L 3 16 C 0 16 0 16 0 13 L 0 3 C 0 0 0 0 3 0" isShadow="true" stroke="black" stroke-opacity="0.049999999999999996" stroke-width="5" transform="translate(1, 1)"></path><path fill="none" d="M 3 0 L 13 0 C 16 0 16 0 16 3 L 16 13 C 16 16 16 16 13 16 L 3 16 C 0 16 0 16 0 13 L 0 3 C 0 0 0 0 3 0" isShadow="true" stroke="black" stroke-opacity="0.09999999999999999" stroke-width="3" transform="translate(1, 1)"></path><path fill="none" d="M 3 0 L 13 0 C 16 0 16 0 16 3 L 16 13 C 16 16 16 16 13 16 L 3 16 C 0 16 0 16 0 13 L 0 3 C 0 0 0 0 3 0" isShadow="true" stroke="black" stroke-opacity="0.15" stroke-width="1" transform="translate(1, 1)"></path><path fill="rgba(249, 249, 249, .85)" d="M 3 0 L 13 0 C 16 0 16 0 16 3 L 16 13 C 16 16 16 16 13 16 L 3 16 C 0 16 0 16 0 13 L 0 3 C 0 0 0 0 3 0"></path><text x="8" zIndex="1" style="font-size:12px;color:#333333;fill:#333333;" y="20"></text></g></svg></div></div>
		</td>
	</tr>
	<tr>
		<td>
			<table style="margin-left: 60px;width: 418px;">
				<tbody><tr style="line-height: 22px;font-weight: bold;vertical-align: top;">
					
					<td align="center" width="33.3%;">3<br>100.00%</td>
					<td align="center" width="33.3%;">0<br>0.00%</td>
					<td align="center" width="33.3%;">3</td>
				</tr>
			</tbody></table>
		</td>
	</tr>
</tbody></table>













	

<script type="text/javascript">
	$("#caigouTotalProjectInfoDIVTimeDIV").html("").append($("#caigouTotalProjectInfoDIVTimeDIVSpan"));
</script>
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
        categories: ["一级集采项目","二级集采项目","总采购项目"],
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
        data: [3,0,3]
    },{
        name: 'OPEX',
        data: [0,0,0]
    }]
});
</script></div>
				<div id="caigouTotalProjectInfoDIVTimeDIV" class="viewChangeTime"><span id="caigouTotalProjectInfoDIVTimeDIVSpan" class="viewChangeSpan  ">数据更新时间:2016-12-31</span></div>
			</div>
		</td>
	</tr></tbody></table>
</div>
	
		







<script type="text/javascript">
	function changeCategoryAnalysis(index){
		$.ajax({
			url:"/pm/CaiGouAction.do?operation=categoryInfo",
			method:"POST",
			data:{
				year:document.frm.year.value,
				index:index
			},
			success:function(html){
				var div=$("#categoryInfoDIV");
				div.html(html);
			}
		});
	}
	jQuery(document).ready(function(){
		changeCategoryAnalysis(0);
	});
</script>
<div class="cmccViewContainer" style="width:1000px;margin: 26px auto;">
	<div id="categoryInfoDIV">




















<div class="tabTitle">
	 	<ul>
	 		<li onclick="changeCategoryAnalysis(0)" class="on">采购品类金额分析</li>
	 		<li onclick="changeCategoryAnalysis(1)" class="">采购品类项目数分析</li>
	 	</ul>
	 </div>	

	










<div class="tabContent">
<div style="height: 300px;margin:26px auto;width:100%;" id="cagtgoryMoney" data-highcharts-chart="5"><div class="highcharts-container" id="highcharts-10" style="position: relative; overflow: hidden; width: 988px; height: 300px; text-align: left; line-height: normal; z-index: 0; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);"><svg version="1.1" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Arial, Helvetica, sans-serif;font-size:12px;" xmlns="http://www.w3.org/2000/svg" width="988" height="300"><desc>Created with Highcharts 4.1.3</desc><defs><clipPath id="highcharts-11"><rect x="0" y="0" width="791" height="239"></rect></clipPath></defs><rect x="0" y="0" width="988" height="300" strokeWidth="0" fill="#FFFFFF" class=" highcharts-background"></rect><g class="highcharts-series-group" zIndex="3"><g class="highcharts-series highcharts-tracker" visibility="visible" zIndex="0.1" transform="translate(10,46) scale(1 1)" style=""><path fill="#46c6f0" d="M 395.48676124175984 54.50000134819017 A 65 65 0 0 1 430.56493671670904 64.7692936912633 L 423.5519493733672 75.71543495301064 A 52 52 0 0 0 395.48940899340784 67.50000107855213 Z" stroke="#FFFFFF" stroke-width="1" stroke-linejoin="round" transform="translate(0,0)"></path><path fill="#a8da72" d="M 430.6196498814291 64.80438598748673 A 65 65 0 0 1 454.6098407851249 92.462494154283 L 442.78787262809993 97.8699953234264 A 52 52 0 0 0 423.59571990514326 75.74350878998939 Z" stroke="#FFFFFF" stroke-width="1" stroke-linejoin="round" transform="translate(0,0)"></path><path fill="#7be4d8" d="M 454.6368487315465 92.52161750396827 A 65 65 0 0 1 459.8457704329748 128.69901230496546 L 446.97661634637984 126.85920984397237 A 52 52 0 0 0 442.8094789852372 97.91729400317462 Z" stroke="#FFFFFF" stroke-width="1" stroke-linejoin="round" transform="translate(0,0)"></path><path fill="#fde485" d="M 459.8365392493205 128.76335346516836 A 65 65 0 0 1 444.6661927240128 162.01688479916226 L 434.8329541792102 153.5135078393298 A 52 52 0 0 0 446.96923139945636 126.91068277213469 Z" stroke="#FFFFFF" stroke-width="1" stroke-linejoin="round" transform="translate(0,0)"></path><path fill="#fe902c" d="M 444.62365126320543 162.06602972525127 A 65 65 0 0 1 413.88725607491546 181.84507850693177 L 410.2098048599324 169.37606280554542 A 52 52 0 0 0 434.79892101056436 153.55282378020104 Z" stroke="#FFFFFF" stroke-width="1" stroke-linejoin="round" transform="translate(0,0)"></path><path fill="#fe5151" d="M 413.8249018131721 181.86343458740546 A 65 65 0 0 1 377.274444733774 181.89254070189594 L 380.9195557870192 169.41403256151673 A 52 52 0 0 0 410.1599214505377 169.3907476699244 Z" stroke="#FFFFFF" stroke-width="1" stroke-linejoin="round" transform="translate(0,0)"></path><path fill="#db8ebf" d="M 377.2120613162477 181.87428395339953 A 65 65 0 0 1 346.4015842726908 162.09513555640262 L 356.2212674181526 153.5761084451221 A 52 52 0 0 0 380.86964905299817 169.39942716271963 Z" stroke="#FFFFFF" stroke-width="1" stroke-linejoin="round" transform="translate(0,0)"></path><path fill="#f6c468" d="M 346.3590136934394 162.0460158512924 A 65 65 0 0 1 331.1689620087701 128.80148111705512 L 344.0351696070161 126.94118489364409 A 52 52 0 0 0 356.1872109547515 153.5368126810339 Z" stroke="#FFFFFF" stroke-width="1" stroke-linejoin="round" transform="translate(0,0)"></path><path fill="#5db1e2" d="M 331.1596926947196 128.73714543904558 A 65 65 0 0 1 336.3471728197186 92.55666990552653 L 348.17773825577484 97.94533592442123 A 52 52 0 0 0 344.02775415577565 126.88971635123644 Z" stroke="#FFFFFF" stroke-width="1" stroke-linejoin="round" transform="translate(0,0)"></path><path fill="#46c6f0" d="M 336.3741457217336 92.49753055986899 A 65 65 0 0 1 360.29328353067956 64.86038876923735 L 367.33462682454365 75.7883110153899 A 52 52 0 0 0 348.19931657738687 97.8980244478952 Z" stroke="#FFFFFF" stroke-width="1" stroke-linejoin="round" transform="translate(0,0)"></path><path fill="#a8da72" d="M 360.3479407361605 64.82520937843915 A 65 65 0 0 1 395.4097163040253 54.500062701151464 L 395.42777304322027 67.50005016092118 A 52 52 0 0 0 367.3783525889284 75.76016750275133 Z" stroke="#FFFFFF" stroke-width="1" stroke-linejoin="round" transform="translate(0,0)"></path></g><g class="highcharts-markers" visibility="visible" zIndex="0.1" transform="translate(10,46) scale(1 1)"></g></g><text x="404" text-anchor="middle" class="highcharts-title" zIndex="4" style="color:#333333;font-size:18px;fill:#333333;width:924px;" y="163"><tspan>总数</tspan><tspan x="404" dy="21">0</tspan></text><text x="444" text-anchor="middle" class="highcharts-subtitle" zIndex="4" style="color:#555555;font-size:14px;fill:#555555;width:924px;" y="26"><tspan style="font-weight:bold">采购金额</tspan><tspan dx="0">(单位:万元)</tspan></text><g class="highcharts-data-labels highcharts-tracker" visibility="visible" zIndex="6" transform="translate(10,46) scale(1 1)" opacity="1" style=""><path fill="none" d="M 427.26459289993585 24.5 C 422.26459289993585 24.5 420.01073244520444 36.02411129553873 416.9116743199487 46.5785340052982 L 413.81261619469296 57.132956715057674" stroke="#46c6f0" stroke-width="1"></path><path fill="none" d="M 472.29620956365454 57.28823027519792 C 467.29620956365454 57.28823027519792 461.2502129688204 62.52711614676019 452.9369676509236 69.73058422015833 L 444.62372233302676 76.93405229355648" stroke="#a8da72" stroke-width="1"></path><path fill="none" d="M 494.5330369786886 105.9800903640379 C 489.5330369786886 105.9800903640379 481.6144654436411 107.11860907022418 470.72642958295086 108.68407229123032 L 459.8383937222606 110.24953551223646" stroke="#7be4d8" stroke-width="1"></path><path fill="none" d="M 486.91503955867927 158.96442623517922 C 481.91503955867927 158.96442623517922 474.637983595843 155.64110613116412 464.63203164694335 151.07154098814337 L 454.62607969804367 146.50197584512262" stroke="#fde485" stroke-width="1"></path><path fill="none" d="M 451.86087765828177 199.4190856189622 C 446.86087765828177 199.4190856189622 442.53575111863694 192.68905735631276 436.5887021266254 183.43526849516977 L 430.6416531346138 174.18147963402677" stroke="#fe902c" stroke-width="1"></path><path fill="none" d="M 390.5 214.5 C 395.5 214.5 395.5 206.5 395.5 195.5 L 395.5 184.5" stroke="#fe5151" stroke-width="1"></path><path fill="none" d="M 306.83399734659247 164.5 C 311.83399734659247 164.5 348.464248881363 192.68905735631273 354.41129787337456 183.43526849516974 L 360.3583468653861 174.18147963402674" stroke="#db8ebf" stroke-width="1"></path><path fill="none" d="M 297.0334284356166 136.5 C 302.0334284356166 136.5 316.3620164041568 155.64110613116407 326.36796835305654 151.0715409881433 L 336.3739203019563 146.50197584512256" stroke="#f6c468" stroke-width="1"></path><path fill="none" d="M 296.4669630213114 105.98009036403785 C 301.4669630213114 105.98009036403785 309.3855345563589 107.11860907022414 320.27357041704914 108.68407229123028 L 331.1616062777394 110.24953551223642" stroke="#5db1e2" stroke-width="1"></path><path fill="none" d="M 318.7037904363455 57.28823027519786 C 323.7037904363455 57.28823027519786 329.7497870311796 62.52711614676015 338.0630323490764 69.73058422015829 L 346.37627766697324 76.93405229355643" stroke="#46c6f0" stroke-width="1"></path><path fill="none" d="M 363.7354071000643 24.5 C 368.7354071000643 24.5 370.9892675547958 36.02411129553868 374.08832568005147 46.57853400529816 L 377.18738380530715 57.13295671505764" stroke="#a8da72" stroke-width="1"></path><g zIndex="1" style="" transform="translate(432,15)"><text x="5" zIndex="1" style="font-size: 11px; font-weight: bold; color: rgb(0, 0, 0); fill: rgb(0, 0, 0); text-shadow: rgb(255, 255, 255) 0px 0px 6px, rgb(255, 255, 255) 0px 0px 3px;" y="17"><tspan>工程类固定资产(0.00)</tspan></text></g><g zIndex="1" style="" transform="translate(477,47)"><text x="5" zIndex="1" style="font-size: 11px; font-weight: bold; color: rgb(0, 0, 0); fill: rgb(0, 0, 0); text-shadow: rgb(255, 255, 255) 0px 0px 6px, rgb(255, 255, 255) 0px 0px 3px;" y="17"><tspan>管理类低值易耗品(0.00)</tspan></text></g><g zIndex="1" style="" transform="translate(500,96)"><text x="5" zIndex="1" style="font-size: 11px; font-weight: bold; color: rgb(0, 0, 0); fill: rgb(0, 0, 0); text-shadow: rgb(255, 255, 255) 0px 0px 6px, rgb(255, 255, 255) 0px 0px 3px;" y="17"><tspan>生产类低值易耗品(0.00)</tspan></text></g><g zIndex="1" style="" transform="translate(492,149)"><text x="5" zIndex="1" style="font-size: 11px; font-weight: bold; color: rgb(0, 0, 0); fill: rgb(0, 0, 0); text-shadow: rgb(255, 255, 255) 0px 0px 6px, rgb(255, 255, 255) 0px 0px 3px;" y="17"><tspan>研发类项目(0.00)</tspan></text></g><g zIndex="1" style="" transform="translate(457,189)"><text x="5" zIndex="1" style="font-size: 11px; font-weight: bold; color: rgb(0, 0, 0); fill: rgb(0, 0, 0); text-shadow: rgb(255, 255, 255) 0px 0px 6px, rgb(255, 255, 255) 0px 0px 3px;" y="17"><tspan>其他(0.00)</tspan></text></g><g zIndex="1" style="" transform="translate(259,205)"><text x="5" zIndex="1" style="font-size: 11px; font-weight: bold; color: rgb(0, 0, 0); fill: rgb(0, 0, 0); text-shadow: rgb(255, 255, 255) 0px 0px 6px, rgb(255, 255, 255) 0px 0px 3px;" y="17"><tspan>营销宣传类项目(0.00)</tspan></text></g><g zIndex="1" style="" transform="translate(175,155)"><text x="5" zIndex="1" style="font-size: 11px; font-weight: bold; color: rgb(0, 0, 0); fill: rgb(0, 0, 0); text-shadow: rgb(255, 255, 255) 0px 0px 6px, rgb(255, 255, 255) 0px 0px 3px;" y="17"><tspan>运营支撑类项目(0.00)</tspan></text></g><g zIndex="1" style="" transform="translate(190,127)"><text x="5" zIndex="1" style="font-size: 11px; font-weight: bold; color: rgb(0, 0, 0); fill: rgb(0, 0, 0); text-shadow: rgb(255, 255, 255) 0px 0px 6px, rgb(255, 255, 255) 0px 0px 3px;" y="17"><tspan>办公类项目(0.00)</tspan></text></g><g zIndex="1" style="" transform="translate(165,96)"><text x="5" zIndex="1" style="font-size: 11px; font-weight: bold; color: rgb(0, 0, 0); fill: rgb(0, 0, 0); text-shadow: rgb(255, 255, 255) 0px 0px 6px, rgb(255, 255, 255) 0px 0px 3px;" y="17"><tspan>管理咨询类项目(0.00)</tspan></text></g><g zIndex="1" style="" transform="translate(212,47)"><text x="5" zIndex="1" style="font-size: 11px; font-weight: bold; color: rgb(0, 0, 0); fill: rgb(0, 0, 0); text-shadow: rgb(255, 255, 255) 0px 0px 6px, rgb(255, 255, 255) 0px 0px 3px;" y="17"><tspan>终端类项目(0.00)</tspan></text></g><g zIndex="1" style="" transform="translate(293,15)"><text x="5" zIndex="1" style="font-size: 11px; font-weight: bold; color: rgb(0, 0, 0); fill: rgb(0, 0, 0); text-shadow: rgb(255, 255, 255) 0px 0px 6px, rgb(255, 255, 255) 0px 0px 3px;" y="17"><tspan>集成(0.00)</tspan></text></g></g><g class="highcharts-legend" zIndex="7" transform="translate(813,43)"><g zIndex="1"><g><g class="highcharts-legend-item" zIndex="1" transform="translate(8,3)"><text x="21" style="color:#333333;font-size:12px;font-weight:bold;cursor:pointer;fill:#333333;" text-anchor="start" zIndex="2" y="15">工程类固定资产</text><rect x="0" y="4" width="16" height="12" zIndex="3" fill="#46c6f0"></rect></g><g class="highcharts-legend-item" zIndex="1" transform="translate(8,21)"><text x="21" y="15" style="color:#333333;font-size:12px;font-weight:bold;cursor:pointer;fill:#333333;" text-anchor="start" zIndex="2">管理类低值易耗品</text><rect x="0" y="4" width="16" height="12" zIndex="3" fill="#a8da72"></rect></g><g class="highcharts-legend-item" zIndex="1" transform="translate(8,39)"><text x="21" y="15" style="color:#333333;font-size:12px;font-weight:bold;cursor:pointer;fill:#333333;" text-anchor="start" zIndex="2">生产类低值易耗品</text><rect x="0" y="4" width="16" height="12" zIndex="3" fill="#7be4d8"></rect></g><g class="highcharts-legend-item" zIndex="1" transform="translate(8,57)"><text x="21" y="15" style="color:#333333;font-size:12px;font-weight:bold;cursor:pointer;fill:#333333;" text-anchor="start" zIndex="2">研发类项目</text><rect x="0" y="4" width="16" height="12" zIndex="3" fill="#fde485"></rect></g><g class="highcharts-legend-item" zIndex="1" transform="translate(8,75)"><text x="21" y="15" style="color:#333333;font-size:12px;font-weight:bold;cursor:pointer;fill:#333333;" text-anchor="start" zIndex="2">其他</text><rect x="0" y="4" width="16" height="12" zIndex="3" fill="#fe902c"></rect></g><g class="highcharts-legend-item" zIndex="1" transform="translate(8,93)"><text x="21" y="15" style="color:#333333;font-size:12px;font-weight:bold;cursor:pointer;fill:#333333;" text-anchor="start" zIndex="2">营销宣传类项目</text><rect x="0" y="4" width="16" height="12" zIndex="3" fill="#fe5151"></rect></g><g class="highcharts-legend-item" zIndex="1" transform="translate(8,111)"><text x="21" y="15" style="color:#333333;font-size:12px;font-weight:bold;cursor:pointer;fill:#333333;" text-anchor="start" zIndex="2">运营支撑类项目</text><rect x="0" y="4" width="16" height="12" zIndex="3" fill="#db8ebf"></rect></g><g class="highcharts-legend-item" zIndex="1" transform="translate(8,129)"><text x="21" y="15" style="color:#333333;font-size:12px;font-weight:bold;cursor:pointer;fill:#333333;" text-anchor="start" zIndex="2">办公类项目</text><rect x="0" y="4" width="16" height="12" zIndex="3" fill="#f6c468"></rect></g><g class="highcharts-legend-item" zIndex="1" transform="translate(8,147)"><text x="21" y="15" style="color:#333333;font-size:12px;font-weight:bold;cursor:pointer;fill:#333333;" text-anchor="start" zIndex="2">管理咨询类项目</text><rect x="0" y="4" width="16" height="12" zIndex="3" fill="#5db1e2"></rect></g><g class="highcharts-legend-item" zIndex="1" transform="translate(8,165)"><text x="21" y="15" style="color:#333333;font-size:12px;font-weight:bold;cursor:pointer;fill:#333333;" text-anchor="start" zIndex="2">终端类项目</text><rect x="0" y="4" width="16" height="12" zIndex="3" fill="#46c6f0"></rect></g><g class="highcharts-legend-item" zIndex="1" transform="translate(8,183)"><text x="21" y="15" style="color:#333333;font-size:12px;font-weight:bold;cursor:pointer;fill:#333333;" text-anchor="start" zIndex="2">集成</text><rect x="0" y="4" width="16" height="12" zIndex="3" fill="#a8da72"></rect></g></g></g></g></svg></div></div>
</div>
<script type="text/javascript">
	$('#cagtgoryMoney').highcharts({
	    chart: {
            type: 'pie'
        },
        title: {
        	verticalAlign:'middle',
            text: '总数<br>'+0.00,
            y:15,
            x:-90
        },
        subtitle:{
        	text:'<b>采购金额</b>(单位:万元)',
        	style:{
        		fontSize:'14px'
        	},
        	x:-50
        },
        legend:{
        	align:'right',
            verticalAlign:'middle',
            layout: 'vertical',
            x:-30
        },
        tooltip: {
        	enabled:false,
            formatter: function () {
                return this.point.name + ': ' + Highcharts.numberFormat(this.point.percentage,2)+'%';
        	}
        },
        plotOptions: {
            pie: {
                size:130,
                innerSize:'80%',
                dataLabels: {
                    enabled: true,
                    formatter:function(){
                    	
                    		return this.point.name+'('+Highcharts.numberFormat(0,2)+')';
                    	
                    }
                },
                showInLegend: true,
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
    	    
        }]
	});
</script>	














<script type="text/javascript">
	$("#categoryInfoDIVTimeDIV").html("").append($("#categoryInfoDIVTimeDIVSpan"));
</script></div>
</div>
<div id="categoryInfoDIVTimeDIV" class="viewChangeTime marginTopTime"></div>
	
		







<script type="text/javascript">
	function changeZhichuAnalysis(index){
		$.ajax({
			url:"/pm/CaiGouAction.do?operation=zhichuInfo",
			method:"POST",
			data:{
				year:document.frm.year.value,
				index:index
			},
			success:function(html){
				var div=$("#zhichuInfoDIV");
				div.html(html);
			}
		});
	}
	jQuery(document).ready(function(){
		changeZhichuAnalysis(0);
	});
</script>
<div class="cmccViewContainer" style="width:1000px;margin: 26px auto;">
	<div id="zhichuInfoDIV">



















 
<div class="tabTitle">
	 	<ul>
	 		<li onclick="changeZhichuAnalysis(0)" class="on">采购方式金额分析</li>
	 		<li onclick="changeZhichuAnalysis(1)" class="">采购方式项目数分析</li>
	 	</ul>
	 </div>	

	










<div class="tabContent">
<div style="margin:26px auto;width:100%;height: 300px;" id="methodMoney" data-highcharts-chart="0"><div class="highcharts-container" id="highcharts-0" style="position: relative; overflow: hidden; width: 988px; height: 300px; text-align: left; line-height: normal; z-index: 0; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);"><svg version="1.1" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Arial, Helvetica, sans-serif;font-size:12px;" xmlns="http://www.w3.org/2000/svg" width="988" height="300"><desc>Created with Highcharts 4.1.3</desc><defs><clipPath id="highcharts-1"><rect x="0" y="0" width="816" height="239"></rect></clipPath></defs><rect x="0" y="0" width="988" height="300" strokeWidth="0" fill="#FFFFFF" class=" highcharts-background"></rect><g class="highcharts-series-group" zIndex="3"><g class="highcharts-series highcharts-tracker" visibility="visible" zIndex="0.1" transform="translate(10,46) scale(1 1)" style=""><path fill="#46c6f0" d="M 407.98676124175984 54.50000134819017 A 65 65 0 0 1 449.7146652675503 69.65136208865647 L 441.3717322140402 79.62108967092519 A 52 52 0 0 0 407.98940899340784 67.50000107855213 Z" stroke="#FFFFFF" stroke-width="1" stroke-linejoin="round" transform="translate(0,0)"></path><path fill="#a8da72" d="M 449.7644930398226 69.69310167128845 A 65 65 0 0 1 471.9958759981534 108.1189695005693 L 459.1967007985227 110.39517560045545 A 52 52 0 0 0 441.4115944318581 79.65448133703076 Z" stroke="#FFFFFF" stroke-width="1" stroke-linejoin="round" transform="translate(0,0)"></path><path fill="#7be4d8" d="M 472.0072250288207 108.18297105641626 A 65 65 0 0 1 464.31110136058544 151.96628810871172 L 453.0488810884683 145.47303048696938 A 52 52 0 0 0 459.20578002305655 110.446376845133 Z" stroke="#FFFFFF" stroke-width="1" stroke-linejoin="round" transform="translate(0,0)"></path><path fill="#fde485" d="M 464.2786069223394 152.02258296754442 A 65 65 0 0 1 430.27592089407005 180.56376460980056 L 425.82073671525603 168.35101168784047 A 52 52 0 0 0 453.0228855378715 145.51806637403553 Z" stroke="#FFFFFF" stroke-width="1" stroke-linejoin="round" transform="translate(0,0)"></path><path fill="#fe902c" d="M 430.21484600167804 180.58600999510222 A 65 65 0 0 1 385.82136074066443 180.59916497468896 L 390.25708859253155 168.37933197975116 A 52 52 0 0 0 425.77187680134244 168.36880799608178 Z" stroke="#FFFFFF" stroke-width="1" stroke-linejoin="round" transform="translate(0,0)"></path><path fill="#fe5151" d="M 385.76027267519163 180.5769557895461 A 65 65 0 0 1 351.74067758567753 152.05593097242513 L 362.992542068542 145.54474477794008 A 52 52 0 0 0 390.2082181401533 168.3615646316369 Z" stroke="#FFFFFF" stroke-width="1" stroke-linejoin="round" transform="translate(0,0)"></path><path fill="#db8ebf" d="M 351.7081497897899 151.99965538142322 A 65 65 0 0 1 343.9748320506271 108.2849267031108 L 356.7798656405017 110.52794136248863 A 52 52 0 0 0 362.96651983183193 145.49972430513859 Z" stroke="#FFFFFF" stroke-width="1" stroke-linejoin="round" transform="translate(0,0)"></path><path fill="#f6c468" d="M 343.98607913463616 108.22090715336847 A 65 65 0 0 1 366.15623482704933 69.75968118165142 L 374.5249878616395 79.70774494532114 A 52 52 0 0 0 356.78886330770894 110.47672572269478 Z" stroke="#FFFFFF" stroke-width="1" stroke-linejoin="round" transform="translate(0,0)"></path><path fill="#5db1e2" d="M 366.20599605945847 69.71786229360976 A 65 65 0 0 1 407.9097163040253 54.500062701151464 L 407.92777304322027 67.50005016092118 A 52 52 0 0 0 374.5647968475668 79.67428983488782 Z" stroke="#FFFFFF" stroke-width="1" stroke-linejoin="round" transform="translate(0,0)"></path></g><g class="highcharts-markers" visibility="visible" zIndex="0.1" transform="translate(10,46) scale(1 1)"></g></g><text x="414" text-anchor="middle" class="highcharts-title" zIndex="4" style="color:#333333;font-size:18px;fill:#333333;width:924px;" y="163"><tspan>总数</tspan><tspan x="414" dy="21">0</tspan></text><text x="444" text-anchor="middle" class="highcharts-subtitle" zIndex="4" style="color:#555555;font-size:14px;fill:#555555;width:924px;" y="26"><tspan style="font-weight:bold">采购金额</tspan><tspan dx="0">(单位:万元)</tspan></text><g class="highcharts-data-labels highcharts-tracker" visibility="visible" zIndex="6" transform="translate(10,46) scale(1 1)" opacity="1" style=""><path fill="none" d="M 445.49191361593853 30.229201025338714 C 440.49191361593853 30.229201025338714 437.7557524693332 37.746741991625974 433.9935308927508 48.08336082027097 L 430.23130931616845 58.41997964891596" stroke="#46c6f0" stroke-width="1"></path><path fill="none" d="M 495.2724133595217 72 C 490.2724133595217 72 483.3442101292462 76 473.8179306876174 81.5 L 464.29165124598853 87" stroke="#a8da72" stroke-width="1"></path><path fill="none" d="M 506.55673653615975 135.99657687835835 C 501.55673653615975 135.99657687835835 493.67827451206216 134.60739145702294 482.84538922892784 132.6972615026867 L 472.0125039457935 130.78713154835046" stroke="#7be4d8" stroke-width="1"></path><path fill="none" d="M 496.66600265340753 164.5 C 491.66600265340753 164.5 463.922522042729 186.14586655135105 456.85185833617703 177.7193776770423 L 449.7811946296251 169.29288880273356" stroke="#fde485" stroke-width="1"></path><path fill="none" d="M 413 214.5 C 408 214.5 408 206.5 408 195.5 L 408 184.5" stroke="#fe902c" stroke-width="1"></path><path fill="none" d="M 341.9351770797788 192.2742220963029 C 346.9351770797788 192.2742220963029 352.077477957271 186.14586655135105 359.14814166382297 177.7193776770423 L 366.2188053703749 169.29288880273356" stroke="#fe5151" stroke-width="1"></path><path fill="none" d="M 309.44326346384025 135.99657687835833 C 314.44326346384025 135.99657687835833 322.32172548793784 134.6073914570229 333.15461077107216 132.69726150268667 L 343.9874960542065 130.78713154835043" stroke="#db8ebf" stroke-width="1"></path><path fill="none" d="M 320.72758664047836 71.99999999999996 C 325.72758664047836 71.99999999999996 332.65578987075384 75.99999999999997 342.1820693123827 81.49999999999997 L 351.7083487540115 86.99999999999997" stroke="#f6c468" stroke-width="1"></path><path fill="none" d="M 370.5080863840616 30.22920102533867 C 375.5080863840616 30.22920102533867 378.2442475306669 37.746741991625946 382.00646910724925 48.08336082027094 L 385.7686906838316 58.419979648915934" stroke="#5db1e2" stroke-width="1"></path><g zIndex="1" style="" transform="translate(450,20)"><text x="5" zIndex="1" style="font-size: 11px; font-weight: bold; color: rgb(0, 0, 0); fill: rgb(0, 0, 0); text-shadow: rgb(255, 255, 255) 0px 0px 6px, rgb(255, 255, 255) 0px 0px 3px;" y="17"><tspan>单一来源(0.00)</tspan></text></g><g zIndex="1" style="" transform="translate(500,62)"><text x="5" zIndex="1" style="font-size: 11px; font-weight: bold; color: rgb(0, 0, 0); fill: rgb(0, 0, 0); text-shadow: rgb(255, 255, 255) 0px 0px 6px, rgb(255, 255, 255) 0px 0px 3px;" y="17"><tspan>公开招标(0.00)</tspan></text></g><g zIndex="1" style="" transform="translate(512,126)"><text x="5" zIndex="1" style="font-size: 11px; font-weight: bold; color: rgb(0, 0, 0); fill: rgb(0, 0, 0); text-shadow: rgb(255, 255, 255) 0px 0px 6px, rgb(255, 255, 255) 0px 0px 3px;" y="17"><tspan>邀请招标(0.00)</tspan></text></g><g zIndex="1" style="" transform="translate(502,155)"><text x="5" zIndex="1" style="font-size: 11px; font-weight: bold; color: rgb(0, 0, 0); fill: rgb(0, 0, 0); text-shadow: rgb(255, 255, 255) 0px 0px 6px, rgb(255, 255, 255) 0px 0px 3px;" y="17"><tspan>公开比选(0.00)</tspan></text></g><g zIndex="1" style="" transform="translate(418,205)"><text x="5" zIndex="1" style="font-size: 11px; font-weight: bold; color: rgb(0, 0, 0); fill: rgb(0, 0, 0); text-shadow: rgb(255, 255, 255) 0px 0px 6px, rgb(255, 255, 255) 0px 0px 3px;" y="17"><tspan>邀请比选(0.00)</tspan></text></g><g zIndex="1" style="" transform="translate(247,182)"><text x="5" zIndex="1" style="font-size: 11px; font-weight: bold; color: rgb(0, 0, 0); fill: rgb(0, 0, 0); text-shadow: rgb(255, 255, 255) 0px 0px 6px, rgb(255, 255, 255) 0px 0px 3px;" y="17"><tspan>公开询价(0.00)</tspan></text></g><g zIndex="1" style="" transform="translate(215,126)"><text x="5" zIndex="1" style="font-size: 11px; font-weight: bold; color: rgb(0, 0, 0); fill: rgb(0, 0, 0); text-shadow: rgb(255, 255, 255) 0px 0px 6px, rgb(255, 255, 255) 0px 0px 3px;" y="17"><tspan>邀请询价(0.00)</tspan></text></g><g zIndex="1" style="" transform="translate(214,62)"><text x="5" zIndex="1" style="font-size: 11px; font-weight: bold; color: rgb(0, 0, 0); fill: rgb(0, 0, 0); text-shadow: rgb(255, 255, 255) 0px 0px 6px, rgb(255, 255, 255) 0px 0px 3px;" y="17"><tspan>竞争性谈判(0.00)</tspan></text></g><g zIndex="1" style="" transform="translate(251,20)"><text x="5" zIndex="1" style="font-size: 11px; font-weight: bold; color: rgb(0, 0, 0); fill: rgb(0, 0, 0); text-shadow: rgb(255, 255, 255) 0px 0px 6px, rgb(255, 255, 255) 0px 0px 3px;" y="17"><tspan>单一来源谈判(0.00)</tspan></text></g></g><g class="highcharts-legend" zIndex="7" transform="translate(838,61)"><g zIndex="1"><g><g class="highcharts-legend-item" zIndex="1" transform="translate(8,3)"><text x="21" style="color:#333333;font-size:12px;font-weight:bold;cursor:pointer;fill:#333333;" text-anchor="start" zIndex="2" y="15">单一来源</text><rect x="0" y="4" width="16" height="12" zIndex="3" fill="#46c6f0"></rect></g><g class="highcharts-legend-item" zIndex="1" transform="translate(8,21)"><text x="21" y="15" style="color:#333333;font-size:12px;font-weight:bold;cursor:pointer;fill:#333333;" text-anchor="start" zIndex="2">公开招标</text><rect x="0" y="4" width="16" height="12" zIndex="3" fill="#a8da72"></rect></g><g class="highcharts-legend-item" zIndex="1" transform="translate(8,39)"><text x="21" y="15" style="color:#333333;font-size:12px;font-weight:bold;cursor:pointer;fill:#333333;" text-anchor="start" zIndex="2">邀请招标</text><rect x="0" y="4" width="16" height="12" zIndex="3" fill="#7be4d8"></rect></g><g class="highcharts-legend-item" zIndex="1" transform="translate(8,57)"><text x="21" y="15" style="color:#333333;font-size:12px;font-weight:bold;cursor:pointer;fill:#333333;" text-anchor="start" zIndex="2">公开比选</text><rect x="0" y="4" width="16" height="12" zIndex="3" fill="#fde485"></rect></g><g class="highcharts-legend-item" zIndex="1" transform="translate(8,75)"><text x="21" y="15" style="color:#333333;font-size:12px;font-weight:bold;cursor:pointer;fill:#333333;" text-anchor="start" zIndex="2">邀请比选</text><rect x="0" y="4" width="16" height="12" zIndex="3" fill="#fe902c"></rect></g><g class="highcharts-legend-item" zIndex="1" transform="translate(8,93)"><text x="21" y="15" style="color:#333333;font-size:12px;font-weight:bold;cursor:pointer;fill:#333333;" text-anchor="start" zIndex="2">公开询价</text><rect x="0" y="4" width="16" height="12" zIndex="3" fill="#fe5151"></rect></g><g class="highcharts-legend-item" zIndex="1" transform="translate(8,111)"><text x="21" y="15" style="color:#333333;font-size:12px;font-weight:bold;cursor:pointer;fill:#333333;" text-anchor="start" zIndex="2">邀请询价</text><rect x="0" y="4" width="16" height="12" zIndex="3" fill="#db8ebf"></rect></g><g class="highcharts-legend-item" zIndex="1" transform="translate(8,129)"><text x="21" y="15" style="color:#333333;font-size:12px;font-weight:bold;cursor:pointer;fill:#333333;" text-anchor="start" zIndex="2">竞争性谈判</text><rect x="0" y="4" width="16" height="12" zIndex="3" fill="#f6c468"></rect></g><g class="highcharts-legend-item" zIndex="1" transform="translate(8,147)"><text x="21" y="15" style="color:#333333;font-size:12px;font-weight:bold;cursor:pointer;fill:#333333;" text-anchor="start" zIndex="2">单一来源谈判</text><rect x="0" y="4" width="16" height="12" zIndex="3" fill="#5db1e2"></rect></g></g></g></g></svg></div></div>
</div>
<script type="text/javascript">
	$('#methodMoney').highcharts({
	    chart: {
            type: 'pie'
        },
        title: {
        	verticalAlign:'middle',
            text: '总数<br>'+0.00,
            y:15,
            x:-80
        },
        subtitle:{
        	text:'<b>采购金额</b>(单位:万元)',
        	style:{
        		fontSize:'14px'
        	},
        	x:-50
        },
        legend:{
        	align:'right',
            verticalAlign:'middle',
            layout: 'vertical',
            x:-30
        },
        tooltip: {
        	enabled:false,
            formatter: function () {
                return this.point.name + ': ' + Highcharts.numberFormat(this.point.percentage,2)+'%';
        	}
        },
        plotOptions: {
            pie: {
                size:130,
                innerSize:'80%',
                dataLabels: {
                    enabled: true,
                    formatter:function(){
                    	
                    		return this.point.name+'('+Highcharts.numberFormat(0,2)+')';
                    	
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
    	    
        }]
	});
</script>	














<script type="text/javascript">
	$("#zhichuInfoDIVTimeDIV").html("").append($("#zhichuInfoDIVTimeDIVSpan"));
</script></div>
</div>
<div id="zhichuInfoDIVTimeDIV" class="viewChangeTime marginTopTime"></div>
	
		







<script type="text/javascript">
	jQuery(document).ready(function(){
		$.ajax({
			url:"/pm/CaiGouAction.do?operation=costSavingInfo",
			method:"POST",
			data:{
				year:document.frm.year.value
			},
			success:function(html){
				var div=$("#costSavingInfoDIV");
				div.html(html);
			}
		});
	});
</script>
<div class="cmccViewContainer" style="width:1000px;margin: 26px auto;">
	<div class="tabTitle">
	 	<ul>
	 		<li class="on">二级集采采购节约成本</li>
	 	</ul>
	 </div>
	<div style="height:180px;" id="costSavingInfoDIV" class="tabContent">









<div class="totalDIV">合计采购节约成本:&nbsp;<b class="moneySize" style="color: #46c6f0;">-0.00</b>&nbsp;</div>
<div style="height:132px;width: 100%;border: none;">
	<table style="border: none;width: 100%;">
		<tbody><tr>
			<td width="15%" align="right"><div>&nbsp;</div></td>
			<td width="35%"><div style="margin-left: 8px;">CAPEX采购节约成本:&nbsp;<b class="moneySize" style="color: #46c6f0;">-0.00</b>&nbsp;</div></td>
			<td width="15%" align="right"><div>&nbsp;</div></td>
			<td width="35%"><div style="margin-left: 8px;">OPEX采购节约成本:&nbsp;<b class="moneySize" style="color: #46c6f0;">-0.00</b>&nbsp;</div></td>
		</tr>
		<tr>
			<td width="15%" align="right"><div>计划</div></td>
			<td width="35%">
				<div>
					<div class="colorDIV" style="width: 240px;background-color: #46c6f0;"></div>
					<div class="colorDIV">0.00&nbsp;</div>
				</div>
			</td>
			<td width="15%" align="right"><div>计划</div></td>
			<td width="35%">
				<div>
					<div class="colorDIV" style="width: 240px;background-color: #46c6f0;"></div>
					<div class="colorDIV">0.00&nbsp;</div>
				</div>
			</td>
		</tr>
		<tr>
			<td width="15%" align="right"><div>实际</div></td>
			<td width="35%">
				<div>
					
					<div class="colorDIV" style="width: NaNpx;background-color: #fe5151;"></div>
					<div class="colorDIV">0.00&nbsp;</div>
				</div>
			</td>
			<td width="15%" align="right"><div>实际</div></td>
			<td width="35%">
				<div>
					
					<div class="colorDIV" style="width: NaNpx;background-color: #fe5151;"></div>
					<div class="colorDIV">0.00&nbsp;</div>
				</div>
			</td>
		</tr>
	</tbody></table>
	<div class="tabMore linkURL" style="margin-top: 20px;" onclick="openjieyuechengbenDetail()">更多详情</div>
</div>













<script type="text/javascript">
	$("#costsavingInfoDIVTimeDIV").html("").append($("#costsavingInfoDIVTimeDIVSpan"));
</script></div>
</div>
<div id="costsavingInfoDIVTimeDIV" class="viewChangeTime marginTopTime"></div>
	
		







<script type="text/javascript">
	jQuery(document).ready(function(){
		$.ajax({
			url:"/pm/CaiGouAction.do?operation=secondOpenMoneyInfo",
			method:"POST",
			data:{
				year:document.frm.year.value
			},
			success:function(html){
				var div=$("#openMoneyInfoDIV");
				div.html(html);
			}
		});
		$.ajax({
			url:"/pm/CaiGouAction.do?operation=secondOpenProjectInfo",
			method:"POST",
			data:{
				year:document.frm.year.value
			},
			success:function(html){
				var div=$("#openProjectInfoDIV");
				div.html(html);
			}
		});
	})
</script>
<div>
	<table style="width:1000px;margin:26px auto;">
		<tbody><tr><td style="width:50%;vertical-align: top;">
			<div style="margin-right:10px;">
				<div class="sumTitle">
					二级集采金额公开统计
				</div>
				<div class="tabContent" style="height: 320px;width:500px;" id="openMoneyInfoDIV">










<div style="height:320px;" id="openTotalMoney" data-highcharts-chart="2"><div class="highcharts-container" id="highcharts-4" style="position: relative; overflow: hidden; width: 500px; height: 320px; text-align: left; line-height: normal; z-index: 0; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);"><svg version="1.1" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Arial, Helvetica, sans-serif;font-size:12px;" xmlns="http://www.w3.org/2000/svg" width="500" height="320"><desc>Created with Highcharts 4.1.3</desc><defs><clipPath id="highcharts-5"><rect x="0" y="0" width="418" height="269"></rect></clipPath></defs><rect x="0" y="0" width="500" height="320" strokeWidth="0" fill="#FFFFFF" class=" highcharts-background"></rect><g class="highcharts-grid" zIndex="1"></g><g class="highcharts-grid" zIndex="1"></g><g class="highcharts-axis" zIndex="2"><path fill="none" d="M 280.5 279 L 280.5 289" stroke="#C0D0E0" stroke-width="1" opacity="1"></path><path fill="none" d="M 490.5 279 L 490.5 289" stroke="#C0D0E0" stroke-width="1" opacity="1"></path><path fill="none" d="M 71.5 279 L 71.5 289" stroke="#C0D0E0" stroke-width="1" opacity="1"></path><path fill="none" d="M 72 279.5 L 490 279.5" stroke="#C0D0E0" stroke-width="1" zIndex="7" visibility="visible"></path></g><g class="highcharts-axis" zIndex="2"><text x="132" zIndex="7" text-anchor="end" transform="translate(0,0)" class=" highcharts-yaxis-title" style="color:#707070;fill:#707070;" visibility="visible" y="18">单位:万元</text><path fill="none" d="M 71.5 10 L 71.5 279" stroke="#C0D0E0" stroke-width="1" zIndex="7" visibility="visible"></path></g><g class="highcharts-series-group" zIndex="3"><g class="highcharts-series highcharts-tracker" visibility="visible" zIndex="0.1" transform="translate(72,10) scale(1 1)" style="" clip-path="url(#highcharts-5)"><rect x="89.5" y="135.5" width="30" height="0" stroke="#FFFFFF" stroke-width="1" fill="#46c6f0" rx="0" ry="0"></rect><rect x="298.5" y="135.5" width="30" height="0" stroke="#FFFFFF" stroke-width="1" fill="#46c6f0" rx="0" ry="0"></rect></g><g class="highcharts-markers" visibility="visible" zIndex="0.1" transform="translate(72,10) scale(1 1)" clip-path="none"></g></g><g class="highcharts-data-labels highcharts-tracker" visibility="visible" zIndex="6" transform="translate(72,10) scale(1 1)" opacity="1" style=""><g zIndex="1" style="" transform="translate(86,108)"><text x="5" zIndex="1" style="font-size: 11px; font-weight: bold; color: rgb(0, 0, 0); fill: rgb(0, 0, 0); text-shadow: rgb(255, 255, 255) 0px 0px 6px, rgb(255, 255, 255) 0px 0px 3px;" y="17"><tspan>0.00</tspan></text></g><g zIndex="1" style="" transform="translate(295,108)"><text x="5" zIndex="1" style="font-size: 11px; font-weight: bold; color: rgb(0, 0, 0); fill: rgb(0, 0, 0); text-shadow: rgb(255, 255, 255) 0px 0px 6px, rgb(255, 255, 255) 0px 0px 3px;" y="17"><tspan>0.00</tspan></text></g></g><g class="highcharts-axis-labels highcharts-xaxis-labels" zIndex="7"><text x="176.5" style="color:#606060;cursor:default;font-size:11px;fill:#606060;width:230px;text-overflow:clip;" text-anchor="middle" transform="translate(0,0)" y="299" opacity="1">公开类</text><text x="385.5" style="color:#606060;cursor:default;font-size:11px;fill:#606060;width:230px;text-overflow:clip;" text-anchor="middle" transform="translate(0,0)" y="299" opacity="1">非公开类</text></g><g class="highcharts-axis-labels highcharts-yaxis-labels" zIndex="7"></g><g class="highcharts-tooltip" zIndex="8" style="cursor:default;padding:0;white-space:nowrap;" transform="translate(0,-9999)"><path fill="none" d="M 3 0 L 13 0 C 16 0 16 0 16 3 L 16 13 C 16 16 16 16 13 16 L 3 16 C 0 16 0 16 0 13 L 0 3 C 0 0 0 0 3 0" isShadow="true" stroke="black" stroke-opacity="0.049999999999999996" stroke-width="5" transform="translate(1, 1)"></path><path fill="none" d="M 3 0 L 13 0 C 16 0 16 0 16 3 L 16 13 C 16 16 16 16 13 16 L 3 16 C 0 16 0 16 0 13 L 0 3 C 0 0 0 0 3 0" isShadow="true" stroke="black" stroke-opacity="0.09999999999999999" stroke-width="3" transform="translate(1, 1)"></path><path fill="none" d="M 3 0 L 13 0 C 16 0 16 0 16 3 L 16 13 C 16 16 16 16 13 16 L 3 16 C 0 16 0 16 0 13 L 0 3 C 0 0 0 0 3 0" isShadow="true" stroke="black" stroke-opacity="0.15" stroke-width="1" transform="translate(1, 1)"></path><path fill="rgba(249, 249, 249, .85)" d="M 3 0 L 13 0 C 16 0 16 0 16 3 L 16 13 C 16 16 16 16 13 16 L 3 16 C 0 16 0 16 0 13 L 0 3 C 0 0 0 0 3 0"></path><text x="8" zIndex="1" style="font-size:12px;color:#333333;fill:#333333;" y="20"></text></g></svg></div></div>













<script type="text/javascript">
	$("#secondOpenMoneyInfoDIVTimeDIV").html("").append($("#secondOpenMoneyInfoDIVTimeDIVSpan"));
</script>
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
        categories: ["公开类","非公开类"]
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
        data: [0.0,0.0]
    }]
});
</script></div>
				<div id="secondOpenMoneyInfoDIVTimeDIV" class="viewChangeTime"></div>
			</div>
		</td>
		<td style="width:49%;vertical-align: top;">
			<div>
				<div class="sumTitle">
					二级集采项目数公开统计
				</div>
				<div class="tabContent" style="height: 320px;" id="openProjectInfoDIV">










<div style="height:320px;" id="openTotalProject" data-highcharts-chart="7"><div class="highcharts-container" id="highcharts-14" style="position: relative; overflow: hidden; width: 466px; height: 320px; text-align: left; line-height: normal; z-index: 0; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);"><svg version="1.1" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Arial, Helvetica, sans-serif;font-size:12px;" xmlns="http://www.w3.org/2000/svg" width="466" height="320"><desc>Created with Highcharts 4.1.3</desc><defs><clipPath id="highcharts-15"><rect x="0" y="0" width="396" height="269"></rect></clipPath></defs><rect x="0" y="0" width="466" height="320" strokeWidth="0" fill="#FFFFFF" class=" highcharts-background"></rect><g class="highcharts-grid" zIndex="1"></g><g class="highcharts-grid" zIndex="1"></g><g class="highcharts-axis" zIndex="2"><path fill="none" d="M 257.5 279 L 257.5 289" stroke="#C0D0E0" stroke-width="1" opacity="1"></path><path fill="none" d="M 456.5 279 L 456.5 289" stroke="#C0D0E0" stroke-width="1" opacity="1"></path><path fill="none" d="M 59.5 279 L 59.5 289" stroke="#C0D0E0" stroke-width="1" opacity="1"></path><path fill="none" d="M 60 279.5 L 456 279.5" stroke="#C0D0E0" stroke-width="1" zIndex="7" visibility="visible"></path></g><g class="highcharts-axis" zIndex="2"><text x="120" zIndex="7" text-anchor="end" transform="translate(0,0)" class=" highcharts-yaxis-title" style="color:#707070;fill:#707070;" visibility="visible" y="18">单位:个</text><path fill="none" d="M 59.5 10 L 59.5 279" stroke="#C0D0E0" stroke-width="1" zIndex="7" visibility="visible"></path></g><g class="highcharts-series-group" zIndex="3"><g class="highcharts-series highcharts-tracker" visibility="visible" zIndex="0.1" transform="translate(60,10) scale(1 1)" style="" clip-path="url(#highcharts-15)"><rect x="83.5" y="135.5" width="30" height="0" stroke="#FFFFFF" stroke-width="1" fill="#46c6f0" rx="0" ry="0"></rect><rect x="281.5" y="135.5" width="30" height="0" stroke="#FFFFFF" stroke-width="1" fill="#46c6f0" rx="0" ry="0"></rect></g><g class="highcharts-markers" visibility="visible" zIndex="0.1" transform="translate(60,10) scale(1 1)" clip-path="none"></g></g><g class="highcharts-data-labels highcharts-tracker" visibility="visible" zIndex="6" transform="translate(60,10) scale(1 1)" opacity="1" style=""><g zIndex="1" style="" transform="translate(90,108)"><text x="5" zIndex="1" style="font-size: 11px; font-weight: bold; color: rgb(0, 0, 0); fill: rgb(0, 0, 0); text-shadow: rgb(255, 255, 255) 0px 0px 6px, rgb(255, 255, 255) 0px 0px 3px;" y="17"><tspan>0</tspan></text></g><g zIndex="1" style="" transform="translate(288,108)"><text x="5" zIndex="1" style="font-size: 11px; font-weight: bold; color: rgb(0, 0, 0); fill: rgb(0, 0, 0); text-shadow: rgb(255, 255, 255) 0px 0px 6px, rgb(255, 255, 255) 0px 0px 3px;" y="17"><tspan>0</tspan></text></g></g><g class="highcharts-axis-labels highcharts-xaxis-labels" zIndex="7"><text x="159" style="color:#606060;cursor:default;font-size:11px;fill:#606060;width:213px;text-overflow:clip;" text-anchor="middle" transform="translate(0,0)" y="299" opacity="1">公开类</text><text x="357" style="color:#606060;cursor:default;font-size:11px;fill:#606060;width:213px;text-overflow:clip;" text-anchor="middle" transform="translate(0,0)" y="299" opacity="1">非公开类</text></g><g class="highcharts-axis-labels highcharts-yaxis-labels" zIndex="7"></g><g class="highcharts-tooltip" zIndex="8" style="cursor:default;padding:0;white-space:nowrap;" transform="translate(0,-9999)"><path fill="none" d="M 3 0 L 13 0 C 16 0 16 0 16 3 L 16 13 C 16 16 16 16 13 16 L 3 16 C 0 16 0 16 0 13 L 0 3 C 0 0 0 0 3 0" isShadow="true" stroke="black" stroke-opacity="0.049999999999999996" stroke-width="5" transform="translate(1, 1)"></path><path fill="none" d="M 3 0 L 13 0 C 16 0 16 0 16 3 L 16 13 C 16 16 16 16 13 16 L 3 16 C 0 16 0 16 0 13 L 0 3 C 0 0 0 0 3 0" isShadow="true" stroke="black" stroke-opacity="0.09999999999999999" stroke-width="3" transform="translate(1, 1)"></path><path fill="none" d="M 3 0 L 13 0 C 16 0 16 0 16 3 L 16 13 C 16 16 16 16 13 16 L 3 16 C 0 16 0 16 0 13 L 0 3 C 0 0 0 0 3 0" isShadow="true" stroke="black" stroke-opacity="0.15" stroke-width="1" transform="translate(1, 1)"></path><path fill="rgba(249, 249, 249, .85)" d="M 3 0 L 13 0 C 16 0 16 0 16 3 L 16 13 C 16 16 16 16 13 16 L 3 16 C 0 16 0 16 0 13 L 0 3 C 0 0 0 0 3 0"></path><text x="8" zIndex="1" style="font-size:12px;color:#333333;fill:#333333;" y="20"></text></g></svg></div></div>













<script type="text/javascript">
	$("#secondOpenProjectInfoDIVTimeDIV").html("").append($("#secondOpenProjectInfoDIVTimeDIVSpan"));
</script>
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
        categories: ["公开类","非公开类"]
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
        data: [0,0]
    }]
});
</script></div>
				<div id="secondOpenProjectInfoDIVTimeDIV" class="viewChangeTime"></div>
			</div>
		</td>
	</tr></tbody></table>
</div>

		







<style>
	.tipDIV{
		margin:10px 5px;
		width:15px;
		height:15px;
	}
	.blodDIV{
		font-weight: bold;
	}
</style>
<div>
	<table style="width:1000px;margin:26px auto;">
		<tbody><tr><td style="width:50%;vertical-align: top;">
			<div style="margin-right:10px;">
				<div class="sumTitle">
					采购项目启动及时率
				</div>
				<div class="tabContent" style="height: 200px;width:500px;" id="summary_start">











	<div style="height:100%;float: left;width: 50%;border: none;" id="startProjectsContainer" data-highcharts-chart="3"><div class="highcharts-container" id="highcharts-6" style="position: relative; overflow: hidden; width: 250px; height: 200px; text-align: left; line-height: normal; z-index: 0; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);"><svg version="1.1" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Arial, Helvetica, sans-serif;font-size:12px;" xmlns="http://www.w3.org/2000/svg" width="250" height="200"><desc>Created with Highcharts 4.1.3</desc><defs><clipPath id="highcharts-7"><rect x="0" y="0" width="230" height="175"></rect></clipPath></defs><rect x="0" y="0" width="250" height="200" strokeWidth="0" fill="#FFFFFF" class=" highcharts-background"></rect><g class="highcharts-series-group" zIndex="3"><g class="highcharts-series highcharts-tracker" visibility="visible" zIndex="0.1" transform="translate(10,10) scale(1 1)" style=""><path fill="#D8D8D8" d="M 114.98472450972287 12.500001555604044 A 75 75 0 1 1 114.89582650464463 12.500072347482458 L 114.9166612037157 27.500057877985967 A 60 60 0 1 0 114.9877796077783 27.50000124448323 Z" stroke="#FFFFFF" stroke-width="1" stroke-linejoin="round" transform="translate(0,0)"></path></g><g class="highcharts-markers" visibility="visible" zIndex="0.1" transform="translate(10,10) scale(1 1)"></g></g><text x="125" text-anchor="middle" class="highcharts-title" zIndex="4" style="color:#333333;font-size:14px;font-weight:bold;fill:#333333;width:186px;" y="103"><tspan>采购项目总数</tspan><tspan x="125" dy="17">0 个</tspan></text><g class="highcharts-legend" zIndex="7"><g zIndex="1"><g></g></g></g></svg></div></div>
	<div style="height:100%;float: left;width: 50%;border: none;">
		<table style="border: none;margin-top:40px;line-height: 24px;">
			<tbody><tr>
				<td colspan="2"><div class="blodDIV">采购项目总数:</div></td>
				<td><div class="blodDIV">0 个</div></td>
			</tr>
			<tr>
				<td><div class="tipDIV" style="background-color: #a8da72;">&nbsp;</div></td>
				<td><div class="blodDIV">及时启动项目数:</div></td>
				<td><div class="blodDIV">0 个</div></td>
			</tr>
			<tr>
				<td><div class="tipDIV" style="background-color: #fe902c;">&nbsp;</div></td>
				<td><div class="blodDIV">延期启动项目数:</div></td>
				<td><div class="blodDIV">0 个</div></td>
			</tr>
			<tr>
				<td colspan="2"><div>延期项目平均延期时间:</div></td>
				<td><div style="margin-left: 4px;font-weight: bold;">0.0 天</div></td>
			</tr>
		</tbody></table>
		<div class="tabMore linkURL" style="margin-top: 20px;" onclick="openMoreCaigouStartDetail()">更多详情</div>
	</div>
	












<script type="text/javascript">
	$("#summary_startDIVTimeDIV").html("").append($("#summary_startDIVTimeDIVSpan"));
</script>
	<script type="text/javascript">
		$('#startProjectsContainer').highcharts({
		    chart: {
	            type: 'pie'
	        },
	        title: {
	            verticalAlign:'middle',
	            text: '采购项目总数<br>'+0+' 个',
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
	        	enabled:false,
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
	            
       	     	 	[{y:1,color:'#D8D8D8'}]
       	      	
	        }]
		});
	</script>
	

</div>
				<div id="summary_startDIVTimeDIV" class="viewChangeTime"></div>
			</div>
		</td>
		<td style="width:49%;vertical-align: top;">
			<div>
				<div class="sumTitle">
					采购项目完成及时率
				</div>
				<div class="tabContent" style="height: 200px;" id="summary_finish">











	<div style="height:100%;float: left;width:50%;border: none;" id="finishProjectsContainer" data-highcharts-chart="6"><div class="highcharts-container" id="highcharts-12" style="position: relative; overflow: hidden; width: 233px; height: 200px; text-align: left; line-height: normal; z-index: 0; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);"><svg version="1.1" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Arial, Helvetica, sans-serif;font-size:12px;" xmlns="http://www.w3.org/2000/svg" width="233" height="200"><desc>Created with Highcharts 4.1.3</desc><defs><clipPath id="highcharts-13"><rect x="0" y="0" width="213" height="175"></rect></clipPath></defs><rect x="0" y="0" width="233" height="200" strokeWidth="0" fill="#FFFFFF" class=" highcharts-background"></rect><g class="highcharts-series-group" zIndex="3"><g class="highcharts-series highcharts-tracker" visibility="visible" zIndex="0.1" transform="translate(10,10) scale(1 1)" style=""><path fill="#D8D8D8" d="M 106.48472450972287 12.500001555604044 A 75 75 0 1 1 106.39582650464463 12.500072347482458 L 106.4166612037157 27.500057877985967 A 60 60 0 1 0 106.4877796077783 27.50000124448323 Z" stroke="#FFFFFF" stroke-width="1" stroke-linejoin="round" transform="translate(0,0)"></path></g><g class="highcharts-markers" visibility="visible" zIndex="0.1" transform="translate(10,10) scale(1 1)"></g></g><text x="117" text-anchor="middle" class="highcharts-title" zIndex="4" style="color:#333333;font-size:14px;font-weight:bold;fill:#333333;width:169px;" y="103"><tspan>采购项目总数</tspan><tspan x="117" dy="17">0 个</tspan></text><g class="highcharts-legend" zIndex="7"><g zIndex="1"><g></g></g></g></svg></div></div>
	<div style="height:100%;float: left;width: 50%;border: none;">
		<table style="border: none;margin-top:40px;line-height: 24px;">
			<tbody><tr>
				<td colspan="2"><div class="blodDIV">采购项目总数:</div></td>
				<td><div class="blodDIV">0 个</div></td>
			</tr>
			<tr>
				<td><div class="tipDIV" style="background-color: #a8da72;">&nbsp;</div></td>
				<td><div class="blodDIV">及时完成项目数:</div></td>
				<td><div class="blodDIV">0 个</div></td>
			</tr>
			<tr>
				<td><div class="tipDIV" style="background-color: #fe902c;">&nbsp;</div></td>
				<td><div class="blodDIV">延期完成项目数:</div></td>
				<td><div class="blodDIV">0 个</div></td>
			</tr>
			<tr>
				<td colspan="2"><div>延期项目平均延期时间:</div></td>
				<td><div style="margin-left: 4px;font-weight: bold;">0.0 天</div></td>
			</tr>
		</tbody></table>
		<div class="tabMore linkURL" style="margin-top: 20px;" onclick="openMoreCaigouFinishDetail()">更多详情</div>
	</div>
	












<script type="text/javascript">
	$("#summary_finishDIVTimeDIV").html("").append($("#summary_finishDIVTimeDIVSpan"));
</script>
	<script type="text/javascript">
		$('#finishProjectsContainer').highcharts({
		    chart: {
	            type: 'pie'
	        },
	        title: {
	        	verticalAlign:'middle',
	            text: '采购项目总数<br>'+0+' 个',
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
	        	enabled:false,
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
	            
       	     	 	[{y:1,color:'#D8D8D8'}]
       	      	
	        }]
		});
	</script>

</div>
				<div id="summary_finishDIVTimeDIV" class="viewChangeTime"></div>
			</div>
		</td>
	</tr></tbody></table>
</div>
<script type="text/javascript">
jQuery(document).ready(function(){
	var doAjax=function(index,select){
		$.ajax({
			url:"/pm/CaiGouAction.do?operation=summary",
			method:"POST",
			data:{
				year:document.frm.year.value,
				index:index
			},
			success:function(html){
				var div=$(select);
				div.html(html);
			}
		});
	};
	doAjax(0,"#summary_start");
	doAjax(1,"#summary_finish");
})
</script>
		







<style>
</style>
<div>
	<table style="width:1000px;margin:26px auto;">
		<tbody><tr><td style="width:50%;vertical-align: top;">
			<div style="margin-right:10px;">
				<div class="sumTitle">
					超时合同TOP10
				</div>
				<div class="tabContent" style="height: 400px;width:500px;" id="contract_overtime">










<div style="height:100%;width: 100%;border: none;">
	<table style="border: none;width: 100%;">
		
		
			<tbody><tr><td colspan="2" style="padding-left:10px">暂无数据</td></tr>
		
	</tbody></table>
</div>













<script type="text/javascript">
	$("#contract_overtimeDIVTimeDIV").html("").append($("#contract_overtimeDIVTimeDIVSpan"));
</script>

</div>
				<div id="contract_overtimeDIVTimeDIV" class="viewChangeTime"></div>
			</div>
		</td>
		<td style="width:49%;vertical-align: top;">
			<div>
				<div class="sumTitle">
					即将超时合同TOP10
				</div>
				<div class="tabContent" style="height: 400px;" id="contract_overtimesoon">










<div style="height:100%;width: 100%;border: none;">
	<table style="border: none;width: 100%;">
		
		
			<tbody><tr><td colspan="2" style="padding-left:10px">暂无数据</td></tr>
		
	</tbody></table>
</div>













<script type="text/javascript">
	$("#contract_overtimesoonDIVTimeDIV").html("").append($("#contract_overtimesoonDIVTimeDIVSpan"));
</script>

</div>
				<div id="contract_overtimesoonDIVTimeDIV" class="viewChangeTime"></div>
			</div>
		</td>
	</tr></tbody></table>
</div>
<script type="text/javascript">
jQuery(document).ready(function(){
	var doAjax=function(index,select){
		$.ajax({
			url:"/pm/CaiGouAction.do?operation=contractInfo",
			method:"POST",
			data:{
				year:document.frm.year.value,
				index:index
			},
			success:function(html){
				var div=$(select);
				div.html(html);
			}
		});
	};
	doAjax(0,"#contract_overtime");
	doAjax(1,"#contract_overtimesoon");
})
</script>
		







<style>
</style>
<div>
	<table style="width:1000px;margin:26px auto;">
		<tbody><tr><td style="width:50%;vertical-align: top;">
			<div style="margin-right:10px;">
				<div class="sumTitle">
					超时订单TOP10
				</div>
				<div class="tabContent" style="height: 400px;width:500px;" id="order_overtime">










<div style="height:100%;width: 100%;border: none;">
	<table style="border: none;width: 100%;">
		
		
			<tbody><tr><td colspan="2" style="padding-left:10px">暂无数据</td></tr>
		
	</tbody></table>
</div>













<script type="text/javascript">
	$("#order_overtimeDIVTimeDIV").html("").append($("#order_overtimeDIVTimeDIVSpan"));
</script>

</div>
				<div id="order_overtimeDIVTimeDIV" class="viewChangeTime"></div>
			</div>
		</td>
		<td style="width:49%;vertical-align: top;">
			<div>
				<div class="sumTitle">
					即将超时订单TOP10
				</div>
				<div class="tabContent" style="height: 400px;" id="order_overtimesoon">










<div style="height:100%;width: 100%;border: none;">
	<table style="border: none;width: 100%;">
		
		
			<tbody><tr><td colspan="2" style="padding-left:10px">暂无数据</td></tr>
		
	</tbody></table>
</div>













<script type="text/javascript">
	$("#order_overtimesoonDIVTimeDIV").html("").append($("#order_overtimesoonDIVTimeDIVSpan"));
</script>

</div>
				<div id="order_overtimesoonDIVTimeDIV" class="viewChangeTime"></div>
			</div>
		</td>
	</tr></tbody></table>
</div>
<script type="text/javascript">
jQuery(document).ready(function(){
	var doAjax=function(index,select){
		$.ajax({
			url:"/pm/CaiGouAction.do?operation=orderInfo",
			method:"POST",
			data:{
				year:document.frm.year.value,
				index:index
			},
			success:function(html){
				var div=$(select);
				div.html(html);
			}
		});
	};
	doAjax(0,"#order_overtime");
	doAjax(1,"#order_overtimesoon");
})
</script>
	</div></div>
<div class="dumascroll_barY"><div class="dumascroll_arrow_up"></div><div class="dumascroll_handleY" style="height: 5px; top: 0px;"></div><div class="dumascroll_arrow_down"></div></div><div class="dumascroll_barX showYScroll" style="display: none;"><div class="dumascroll_arrow_left"></div><div class="dumascroll_handleX"></div><div class="dumascroll_arrow_right"></div></div><div class="duma_rightButtom showYScroll"></div></div>
<script type="text/javascript">
	var  scrollbar2=new ET.ScrollBar('propDIV',{
		destoryHtml:false
	});
	window.dashScrollBar=scrollbar2;
	function scrollBoardDIV(){
		var dashBoardDIV=EventUtil.$ID("propDIV");
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
}
EventUtil.addHandler(window,'resize',scrollBoardDIV);
ET.addToggleLeftEvent(scrollBoardDIV);
ET.Utils.addOnloadEvent(scrollBoardDIV);
</script>
</form>




	</div>
	</div>
</div>





<div style="display: none;"><img src="images/16x16/empty.png" id="checkbox_img_clonenode" onclick="checkboxIMG_clickFun(this,event)" onmouseover="checkboxIMG_onmouseover(this)" onmouseout="checkboxIMG_onmouseout(this)"></div><div id="floatDIV" class="floatDIV" style="width:200px;height:180px" onclick="floatController.bShow=true"></div><div id="coverDIV" class="coverDIV"></div></body></html>