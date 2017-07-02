<%@ page language="java"  pageEncoding="UTF-8"%>
<div class="content-wrap" id="bodyStart__content_Wrap" style="left:0px;">
		<div class="content-empty"></div>
		<div class="content-main">
<form name="frm" action="/ZongheAction.do" method="post">  
<input type="hidden" name="operation" value="dashBoard">
<input type="hidden" name="year" value="2017">
<input type="hidden" name="menuID" value="55">
<input type="hidden" name="page" value="">
<input type="hidden" name="isDialog" value="false">
<div class="cmccTopTitle">
<div style="height:34px;width: 1000px;margin: 0px auto;">	
	<div style="float:left;font-size: 24px;font-weight: bold;color: #4C4C4C;">中国移动政企分公司</div>
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
					jprevObj.attr("src","/static/images/16x16/cmcc_left_disable.png");
					jprevObj.removeAttr("overImg");
				}else{
					jprevObj.removeClass("disable");
					jprevObj.attr("src","/static/images/16x16/cmcc_left.png");					
				}
				if(yearInput.value == maxYear){
					jnextObj.addClass("disable");
					jnextObj.attr("src","/static/images/16x16/cmcc_right_disable.png");
					jnextObj.removeAttr("overImg");
				}else{
					jnextObj.removeClass("disable");
					jnextObj.attr("src","/static/images/16x16/cmcc_left.png");
					//jnextObj.attr("overImg","/static/images/16x16/arrow_next_over.png");
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
				jnextObj.attr("src","/static/images/16x16/cmcc_right.png");
				//jnextObj.attr("overImg","/static/images/16x16/arrow_next_over.png");
			}
			if(!obj.hasClass("disable")){
				var yearValue=parseInt(yearInput.value,10);
				yearValue--;
				if(yearValue>=yearStart){
					yearInput.value=yearValue;
					if(yearValue == yearStart){
						obj.addClass("disable");
						obj.attr("src","/static/images/16x16/cmcc_left_disable.png");
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
				jprevObj.attr("src","/static/images/16x16/cmcc_left.png");
				//jprevObj.attr("overImg","/static/images/16x16/arrow_prev_over.png");
			}
			if(!obj.hasClass("disable")){
				var yearValue=parseInt(yearInput.value,10);
				yearValue++;
				if(yearValue<=maxYear){
					yearInput.value=yearValue;
					if(yearValue == maxYear){
						obj.addClass("disable");
						obj.attr("src","/static/images/16x16/cmcc_right_disable.png");
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
		<img class="  yearSelectPrev " src="/static/images/16x16/cmcc_left.png">
			<span style="font-size: 12px;" class="showYearSelectSpan  ">
					<span>2017</span>
					<img src="/static/images/yearSelect.png">
			</span>
			<img class="  yearSelectNext  " src="/static/images/16x16/cmcc_right.png">
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
	<div class="cmcc_textImgDIV" style="float:right;">
		<input type="hidden" name="departmentID" value="69">
		<input type="text" style="outline: none;" name="departmentName" value="中国移动政企分公司" autocomplete="off">
		<img src="/static/images/16x16/cmcc_down.png" style="cursor: pointer;">
	</div>
	<script type="text/javascript">
		var config={noEmpty:true};
		var values=[];
		config.values=values;
		config.selectEvent=function(){
			document.frm.action="/ZongheAction.do";
			document.frm.submit();
		}
		
			values.push({
				id:69
				,value:"\u4E2D\u56FD\u79FB\u52A8\u653F\u4F01\u5206\u516C\u53F8"
			});
			
			
		
			values.push({
				id:1000
				,value:"\u7EFC\u5408\u90E8"
			});
			
			
		
			values.push({
				id:1040
				,value:"\u8D22\u52A1\u90E8"
			});
			
			
		
			values.push({
				id:1002
				,value:"\u4EBA\u529B\u8D44\u6E90\u90E8"
			});
			
			
		
			values.push({
				id:1003
				,value:"\u5E02\u573A\u7ECF\u8425\u90E8"
			});
			
			
		
			values.push({
				id:1004
				,value:"\u515A\u653F\u519B\u5BA2\u6237\u89E3\u51B3\u65B9\u6848\u90E8"
			});
			
			
		
			values.push({
				id:1005
				,value:"\u91D1\u878D\u884C\u4E1A\u89E3\u51B3\u65B9\u6848\u90E8"
			});
			
			
		
			values.push({
				id:1006
				,value:"\u4E92\u8054\u7F51\u89E3\u51B3\u65B9\u6848\u90E8"
			});
			
			
		
			values.push({
				id:1007
				,value:"\u519C\u5546\u884C\u4E1A\u89E3\u51B3\u65B9\u6848\u90E8"
			});
			
			
		
			values.push({
				id:1008
				,value:"\u4EA7\u54C1\u4E2D\u5FC3"
			});
			
			
		
			values.push({
				id:1009
				,value:"\u4E91\u8BA1\u7B97\u4E2D\u5FC3"
			});
			
			
		
			values.push({
				id:1010
				,value:"\u6559\u80B2\u884C\u4E1A\u89E3\u51B3\u65B9\u6848\u90E8"
			});
			
			
		
			values.push({
				id:1011
				,value:"\u533B\u7597\u884C\u4E1A\u89E3\u51B3\u65B9\u6848\u90E8"
			});
			
			
		
			values.push({
				id:1012
				,value:"\u4EA4\u901A\u884C\u4E1A\u89E3\u51B3\u65B9\u6848\u90E8"
			});
			
			
		
			values.push({
				id:1013
				,value:"\u79FB\u52A8\u529E\u516C\u521B\u65B0\u4E2D\u5FC3"
			});
			
			
		
			values.push({
				id:1014
				,value:"\u4F01\u4E1A\u7BA1\u7406\u521B\u65B0\u4E2D\u5FC3"
			});
			
			
		
			values.push({
				id:1015
				,value:"\u8BA1\u5212\u91C7\u8D2D\u90E8"
			});
			
			
		
			values.push({
				id:1016
				,value:"\u89E3\u51B3\u65B9\u6848\u4E2D\u5FC3"
			});
			
			
		
			values.push({
				id:1017
				,value:"\u670D\u52A1\u652F\u6491\u4E2D\u5FC3"
			});
			
			
		
			values.push({
				id:1018
				,value:"\u4E1A\u52A1\u652F\u6491\u4E2D\u5FC3"
			});
			
			
		
			values.push({
				id:1019
				,value:"\u767E\u5EA6\u9879\u76EE\u5DE5\u7A0B\u529E\u516C\u5BA4"
			});
			
			
		
			values.push({
				id:1020
				,value:"\u5168\u901A\u6539\u9769\u9886\u5BFC\u5C0F\u7EC4"
			});
			
			
		
			values.push({
				id:1042
				,value:"\u53D1\u5C55\u6218\u7565\u90E8"
			});
			
			
		
			values.push({
				id:1044
				,value:"\u515A\u7FA4\u5DE5\u4F5C\u90E8"
			});
			
			
		
			values.push({
				id:1046
				,value:"\u516C\u53F8\u7EDF\u7B79"
			});
			
			
		
			values.push({
				id:317013
				,value:"\u4E1A\u52A1\u90E8"
			});
			
			
		
			values.push({
				id:317015
				,value:"\u8C03\u5EA6\u5B9E\u65BD\u4E2D\u5FC3"
			});
			
			
		
			values.push({
				id:317017
				,value:"IDC\u8FD0\u8425\u4E2D\u5FC3"
			});
			
			
		
			values.push({
				id:317019
				,value:"\u8425\u9500\u4E2D\u5FC3"
			});
			
			
		
			values.push({
				id:325909
				,value:"\u5DE5\u4E1A\u548C\u80FD\u6E90\u884C\u4E1A\u89E3\u51B3\u65B9\u6848\u90E8"
			});
			
			
		
		ET.FormSelectSearch(document.frm.departmentID,document.frm.departmentName,config);
	</script>
	<div style="clear:both;"></div>
</div>		
	<div style="font-size:12px;line-height: 25px;text-align: right;margin:0px auto;width: 1000px;">单位:万元</div>
</div>	