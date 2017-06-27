<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%-- 输出head模块 --%>
<jsp:include  page="../framework/Head.jsp" /> 
<body>
<%-- 输出系统顶级模块的菜单 --%>
<jsp:include  page="../framework/TopMenu.jsp" /> 

<div class="container  " id="bodyStart_container" style="top:50px">
	<div class="content-wrap" id="bodyStart__content_Wrap" style="left:0px;">
		<div class="content-empty"></div>
		<div class="content-main">

<form name="frm" action="/pm/CMCCAction.do" method="post">  
<input type="hidden" name="operation" value="caiWu">
<input type="hidden" name="year" value="2017">
<input type="hidden" name="menuID" value="56">
<input type="hidden" name="page" value="">
<input type="hidden" name="isDialog" value="false">
<div class="cmccTopTitle">
<div style="width: 1000px;margin: 0px auto;">
<div style="float:left;font-size: 24px;font-weight: bold;color: #4C4C4C;">财务视图</div>
</div>
<div style="height:34px;width: 1000px;margin: 0px auto;">	
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
</div>
<div style="font-size:12px;line-height: 25px;text-align: right;margin:0px auto;width: 1000px;">单位:万元</div>
</div>
<div id="propDIV" class="yibiao_start dumascroll" style="overflow: hidden; height: 88px;">
	<div class=" dumascroll_area showYScroll"><div style="width: 1000px;margin: 0 auto;">
		




<style>
	.tipSpan{
		white-space: nowrap;
		line-height:18px;
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
</style>
<script type="text/javascript">
</script>
<div>
	<table style="width:1000px;margin:10px auto;">
		<tbody><tr><td style="width:25%;vertical-align: top;">
			<div style="margin-right:10px;">
				<div class="sumTitle" onclick="">
					本年分公司真实收入
				</div>
				<div class="sumContainer1" style="height: 220px;" id="shouru">







<div style="position: relative;">				
	<div class="sumValue" style="color:#0ACC4B">
		<b>0</b>&nbsp;
	</div>
	<div style="width:90%;margin:3px auto;height:8px;background-color:#E8E9ED;">
	
		<div style=" height:100%;width:0%;background-color:#0ACC4B;" '=""></div>
	</div>
	<div style="width:90%;margin:5px auto;height:70%">
		<table style="width:100%;height:100%;">
			<tbody><tr>
				<td width="40%" class="tipSpan" align="left"><span>计划值&nbsp;:</span></td>
				<td width="60%" align="right"><span class="tipSpan2">0</span></td>
			</tr>
			<tr>
				<td class="tipSpan"><span>完成比例&nbsp;:</span></td>
				<td align="right"><span class="tipSpan2">�%</span></td>
			</tr>
		</tbody></table>						
	</div>
	<div style="width:90%;margin:2px auto;height:1px;background-color:#E8E9ED;"></div>	
	<div style="width:90%;margin:15px auto;">
		<table style="width:100%;">
			
				<tbody><tr>
					<td width="40%" class="tipSpan" align="left"><span>销售支撑收入&nbsp;:</span></td>
					<td width="60%" align="right"><span class="tipSpan2">0</span></td>
				</tr>
			
				<tr>
					<td width="40%" class="tipSpan" align="left"><span>运营支撑收入&nbsp;:</span></td>
					<td width="60%" align="right"><span class="tipSpan2">0</span></td>
				</tr>
			
				<tr>
					<td width="40%" class="tipSpan" align="left"><span>产品销售收入&nbsp;:</span></td>
					<td width="60%" align="right"><span class="tipSpan2">0</span></td>
				</tr>
			
				<tr>
					<td width="40%" class="tipSpan" align="left"><span>产品合作收入&nbsp;:</span></td>
					<td width="60%" align="right"><span class="tipSpan2">0</span></td>
				</tr>
			
		</tbody></table>						
	</div>
	<div style="position:absolute;right:-5px; top:-5px;">
		<div class="showHelpe" onclick="showSummaryShouRuTip(this)"></div>
	</div>
	<div class="helpFloatDIV" id="showSummaryShouRuTipDIV" style="line-height: 22px;">
		<div class="showHelpeContent" style="line-height: 23px;max-width:700px;">
			<div>本年分公司真实收入：取自分公司财务报表的收入，包括以下四类。<br>
			销售支撑收入：政企分公司直接签约销售全网产品与省公司产品，销售收入全额结算给省公司，省公司从成本中支出销售收入的5%作为销售支撑费结算给政企。<br>
			运营支撑收入：政企分公司面向省公司提供涉及全网集中运营产品（需总部认定）、重点项目（如双跨IMS、行业WLAN、视频监控、和对讲(POC)、云MAS等）的统一运营支撑，省公司从成本中支出运营支撑费结算给政企。<br>
			产品销售收入：政企签约销售政企自有产品，政企分公司100%确认收入，使用省公司/其他公司（铁通、国际公司等）资源的部分，从分公司成本中支出资源成本价给相关单位。<br>
			产品合作收入：省公司签约销售政企自有产品，各省按照结算方案采取收入分成或成本结算模式结算给政企（不同产品具体结算方案不一样）</div>
		</div>
	</div>
</div>













<script type="text/javascript">
	$("#caiwushouruTimeDIV").html("").append($("#caiwushouruTimeDIVSpan"));
</script></div>
				<div id="caiwuchengbenTimeDIV" class="viewChangeTime"><span id="caiwuchengbenTimeDIVSpan" class="viewChangeSpan  ">数据更新时间:2天前</span></div>
			</div>
		</td>
		
		<td style="width:25%;vertical-align: top;">
			<div style="margin-right:10px;">
				<div class="sumTitle" onclick="">
					本年成本
				</div>
				<div class="sumContainer1" style="height: 220px;" id="chengben">






					
	<div class="sumValue" style="color:#0ACC4B">
		<b>2,030.28</b>&nbsp;
	</div>
	<div style="width:90%;margin:3px auto;height:8px;background-color:#E8E9ED;">
	
		<div style=" height:100%;width:1%;background-color:#0ACC4B;" '=""></div>
	</div>
	<div style="width:90%;margin:5px auto;">
		<table style="width:100%;">
			<tbody><tr>
				<td width="60%" class="tipSpan" style="text-align: left;"><span>计划值&nbsp;:</span></td>
				<td width="40%" align="right"><span class="tipSpan2">107,709.29</span></td>
			</tr>
			<tr>
				<td class="tipSpan" style="text-align: left;"><span> 完成比例&nbsp;:</span></td>
				<td align="right"><span class="tipSpan2">1.88%</span></td>
			</tr>
		</tbody></table>						
	</div>
	<div style="width:90%;margin:2px auto;height:1px;background-color:#E8E9ED;"></div>	
	<div style="width:90%;margin:5px auto;">
		<table style="width:100%;">
			
				<tbody><tr>
					<td width="60%" class="tipSpan" style="text-align: left;"><span>人工类成本&nbsp;:</span></td>
					<td width="40%" align="right"><span class="tipSpan2">0</span></td>
				</tr>
			
				<tr>
					<td width="60%" class="tipSpan" style="text-align: left;"><span>资产类成本&nbsp;:</span></td>
					<td width="40%" align="right"><span class="tipSpan2">834.91</span></td>
				</tr>
			
				<tr>
					<td width="60%" class="tipSpan" style="text-align: left;"><span>营销类成本&nbsp;:</span></td>
					<td width="40%" align="right"><span class="tipSpan2">328.57</span></td>
				</tr>
			
				<tr>
					<td width="60%" class="tipSpan" style="text-align: left;"><span>业务发展类成本&nbsp;:</span></td>
					<td width="40%" align="right"><span class="tipSpan2">-67.08</span></td>
				</tr>
			
				<tr>
					<td width="60%" class="tipSpan" style="text-align: left;"><span>行政管理类成本&nbsp;:</span></td>
					<td width="40%" align="right"><span class="tipSpan2">933.88</span></td>
				</tr>
			
				<tr>
					<td width="60%" class="tipSpan" style="text-align: left;"><span>终端销售成本&nbsp;:</span></td>
					<td width="40%" align="right"><span class="tipSpan2">0</span></td>
				</tr>
			
		</tbody></table>						
	</div>
	












	

<script type="text/javascript">
	$("#caiwuchengbenTimeDIV").html("").append($("#caiwuchengbenTimeDIVSpan"));
</script></div>
				<div id="caiwukaizhizhuanziTimeDIV" class="viewChangeTime"><span id="caiwukaizhizhuanziTimeDIVSpan" class="viewChangeSpan  ">数据更新时间:2017-05-07</span></div>
			</div>
		</td>
		<td style="width:25%;vertical-align: top;">
			<div style="margin-right:10px;">
				<div class="sumTitle" onclick="">
					投资/预算总额
				</div>
				<div class="sumContainer1" style="height: 220px;" id="touziyusuantotal">





					
	<div class="sumValue">
		<b>296112.52</b>
	</div>
	<div style="width:90%;margin:5px auto;height:8px;background-color:#E8E9ED;">
	
		<div style="float:left;height:100%;width:25%;background-color:#0ACC4B;" '=""></div>
		<div style="float:left;height:100%;width:75%;background-color:#fe902c;" '=""></div>
	</div>
	<div style="width:90%;margin:10px auto;">
		<table style="width:100%;">
			<tbody><tr>
				<td width="50%" class="tipSpan" style="text-align: center;border-right:#E8E9ED solid 1px;padding-left: 5px;"><span>CAPEX</span><br><span class="tipSpan2">74156.20</span></td>
				<td width="50%" class="tipSpan" style="text-align: center;padding-left: 5px;"><span>OPEX</span><br><span class="tipSpan2">221956.32</span></td>
			</tr>
		</tbody></table>						
	</div>
	<div style="width:100%;margin:25px auto;height:1px;background-color:#D9D9D9;"></div>
	<div style="width:90%;margin:10px auto;">
		<table style="width:100%;">
			<tbody><tr>
				<td width="55%" align="center" style="font-size: 18px;font-weight: bold;">成本占收比：</td>
				<td align="center" style="font-size: 24px;font-weight: bold;">0.00%</td>
			</tr>
		</tbody></table>						
	</div>
	












	

<script type="text/javascript">
	$("#caiwutouziyusuanTimeDIV").html("").append($("#caiwutouziyusuanTimeDIVSpan"));
</script>			
</div>
				<div id="caiwushouruTimeDIV" class="viewChangeTime"></div>
			</div>
		</td>
		<td style="width:25%;vertical-align: top;">
			<div>
				<div class="sumTitle" onclick="">
					开支、转资进度
				</div>
				<div class="sumContainer1" style="height: 220px;" id="kaizhizhuanzijindu">






<table style="width: 90%;margin: 0 auto;height:100%">
	<tbody><tr>
		<td width="60%">
			<div style="line-height: 23px;">资本开支实际&nbsp;:</div>
		</td>
		<td width="40%" align="right">
			<b style="font-size: 14px;">43,013.83</b>
		</td>
	</tr>
	<tr style="border-bottom: 1px solid  #D9D9D9;">
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
			<div style="line-height: 23px;">转资实际&nbsp;:</div>
		</td>
		<td align="right">
			<b style="font-size: 14px;">27,318.35</b>
		</td>
	</tr>
	<tr style="border-bottom: 1px solid  #D9D9D9;">
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
			<div style="line-height: 23px;">成本开支实际&nbsp;:</div>
		</td>
		<td align="right">
			<b style="font-size: 14px;">0</b>
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
	$("#caiwukaizhizhuanziTimeDIV").html("").append($("#caiwukaizhizhuanziTimeDIVSpan"));
</script>

</div>
				<div id="caiwutouziyusuanTimeDIV" class="viewChangeTime"><span id="caiwutouziyusuanTimeDIVSpan" class="viewChangeSpan  ">数据更新时间:2天前</span></div>
			</div>
		</td>
	</tr></tbody></table>
</div>
<script type="text/javascript">
	jQuery(document).ready(function(){
		$.ajax({
			url:"/pm/OPEXAction.do?operation=shouru",
			method:"POST",
			data:{
				year:document.frm.year.value
			},
			success:function(html){
				var div=$("#shouru");
				div.html(html);
			}
		});
		$.ajax({
			url:"/pm/OPEXAction.do?operation=chengben",
			method:"POST",
			data:{
				year:document.frm.year.value
			},
			success:function(html){
				var div=$("#chengben");
				div.html(html);
			}
		});
		$.ajax({
			url:"/pm/OPEXAction.do?operation=touziyusuantotal",
			method:"POST",
			data:{
				year:document.frm.year.value
			},
			success:function(html){
				var div=$("#touziyusuantotal");
				div.html(html);
			}
		});
		$.ajax({
			url:"/pm/OPEXAction.do?operation=kaizhizhuanzijindu",
			method:"POST",
			data:{
				year:document.frm.year.value
			},
			success:function(html){
				var div=$("#kaizhizhuanzijindu");
				div.html(html);
			}
		});
	})
	
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
</script>

		







<style type="text/css">
	#productResultTable.listTable  tbody tr td{
		border: none;
	}
	
	#departmentResultTable.listTable  tbody tr td{
		border: none;
	}
	#productResultTable th{
		
	}
	.chengBenClass{
		width:auto;
		height:12px;
		float:right;
		position:relative;
		background-color: #047ad4;
	}
	.shouRuClass{
		width:auto;
		height:12px;
		position:relative;
		background-color: #0acc4b;
	}
	.liRunLine{
		height: 100%;
		background-color: #ED842C;
		width:1px;
		position: absolute;
		left:0px;
	}
</style>
<script type="text/javascript">
	function loadProductAndDepart(subOperation){
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
			url:"/pm/OPEXAction.do",
			method:"POST",
			data:data,
			success:function(html){
				var div=$("#"+subOperation);
				div.html(html);
			}
		});
	}
	jQuery(document).ready(function(){
		loadProductAndDepart("productAndDepart_Product");
		loadProductAndDepart("productAndDepart_Depart");
		$("#ProductOrderType").on("click",function(event){
			var obj=$(this);
			obj.toggleClass("DESC");
			loadProductAndDepart("productAndDepart_Product");
		})
	})
	
</script>

	<table style="width:1000px;margin:26px auto;">
		<tbody><tr><td style="width:51%;vertical-align:top;">
			<div style="margin-right:10px;">
				<div class="cmccDashTitle">
					<div id="ProductOrderType" class="orderbyImg DESC"></div>
					<div class="showMoreSpan showMoreColor productMore" style="font-weight: normal;" onclick="openProductSummaryList()">更多</div>
					<span>产品累计收入排名(Top 10)</span>
				</div>
				<div class="sumContainer1" style="height:380px;">
					<div style="text-align:right;">
						<div style="float:right;margin-top:7px;" class="showHelpe" onclick="showTips(this,'productTipNameDIV')"></div>
						<div class="shouRuClass" style="height:10px;width:10px;margin:10px 5px;float:right;"></div>
						<div style="margin:5px;float:right;">收入</div>
						
						<div class="chengBenClass" style="height:10px;width:10px;margin:10px 5px;float:right;"></div>
						<div style="margin:5px;float:right;">成本</div>
						<div style="clear:both;"></div>
						
					</div>
					<div class="helpFloatDIV" id="productTipNameDIV" style="line-height: 22px;">
						<div class="showHelpeContent" style="line-height: 23px;">
							<div>产品毛利润计算方式为：产品收入-产品成本(OPEX成本+CAPEX折旧)</div>
						</div>
					</div>
					<div id="productAndDepart_Product" style="min-height:250px;">









<div style="width:100%;margin:0px auto;">
	<table id="productResultTable" class="listTable" style="margin:10px auto;" cellpadding="0" cellspacing="0" border="0">
		<thead>
			<tr>
				<th width="100%"><div style="width:90px">产品</div></th>
				
				<th><div style="width:36.66666666666667px">成本</div></th>
				<th><div style="width:183.33333333333334px">收入</div></th>
				<th><div style="width:80px">毛利润</div></th>
				<th><div style="width:90px">资本投入</div></th>
			</tr>
		</thead>
		<tbody>
			
				<tr>
					<td><div style="width:90px;text-align: left;padding-left: 10px;" class="nowrapText linkURL" title="入驻MAS" onclick="openProduct(294029)">入驻MAS</div></td>
					<td style="border-right:1px solid #D9D9D9; ">
							<div class="chengBenClass" title="成本：16,801.08" style="width:42.24754099840413%;">
								
							</div>
						
					</td>
					<td>
							<div class="shouRuClass" title="收入：198,840.93" style="width:100.0%;">
							
								<div class="liRunLine" style="margin-left:-1px;left:8.449508199680826%;"></div>
							
							</div>
						
					</td>
					
					<td><div style="width:80px;text-align: center;" class="nowrapText" title="182,039.85">182,039.85</div></td>
					<td><div style="width:80px;text-align: center;" class="nowrapText" title="4,051.51">4,051.51</div></td>
					
				</tr>
			
				<tr>
					<td><div style="width:90px;text-align: left;padding-left: 10px;" class="nowrapText linkURL" title="Blackberry" onclick="openProduct(294030)">Blackberry</div></td>
					<td style="border-right:1px solid #D9D9D9; ">
							<div class="chengBenClass" title="成本：3,466.87" style="width:8.717700317372543%;">
								
							</div>
						
					</td>
					<td>
							<div class="shouRuClass" title="收入：9,776.54" style="width:4.916765807097841%;">
							
								<div class="liRunLine" style="margin-left:-1px;left:35.46111675600932%;"></div>
							
							</div>
						
					</td>
					
					<td><div style="width:80px;text-align: center;" class="nowrapText" title="6,309.67">6,309.67</div></td>
					<td><div style="width:80px;text-align: center;" class="nowrapText" title="0">0</div></td>
					
				</tr>
			
				<tr>
					<td><div style="width:90px;text-align: left;padding-left: 10px;" class="nowrapText linkURL" title="IDC" onclick="openProduct(294042)">IDC</div></td>
					<td style="border-right:1px solid #D9D9D9; ">
							<div class="chengBenClass" title="成本：9,857.16" style="width:24.786536735268292%;">
								
									<div class="liRunLine" style="left:auto;right:86.62074887456468%;margin-right:1px;"></div>
								
							</div>
						
					</td>
					<td>
							<div class="shouRuClass" title="收入：8,538.34" style="width:4.294056748031695%;">
							
							</div>
						
					</td>
					
					<td><div style="width:80px;text-align: center;" class="nowrapText" title="-1,318.81">-1,318.81</div></td>
					<td><div style="width:80px;text-align: center;" class="nowrapText" title="82,788.08">82,788.08</div></td>
					
				</tr>
			
				<tr>
					<td><div style="width:90px;text-align: left;padding-left: 10px;" class="nowrapText linkURL" title="移动400" onclick="openProduct(294031)">移动400</div></td>
					<td style="border-right:1px solid #D9D9D9; ">
							<div class="chengBenClass" title="成本：1,615.23" style="width:4.061613602660319%;">
								
							</div>
						
					</td>
					<td>
							<div class="shouRuClass" title="收入：7,422.59" style="width:3.732927795906249%;">
							
								<div class="liRunLine" style="margin-left:-1px;left:21.76100811333413%;"></div>
							
							</div>
						
					</td>
					
					<td><div style="width:80px;text-align: center;" class="nowrapText" title="5,807.36">5,807.36</div></td>
					<td><div style="width:80px;text-align: center;" class="nowrapText" title="636.53">636.53</div></td>
					
				</tr>
			
				<tr>
					<td><div style="width:90px;text-align: left;padding-left: 10px;" class="nowrapText linkURL" title="专线" onclick="openProduct(294041)">专线</div></td>
					<td style="border-right:1px solid #D9D9D9; ">
							<div class="chengBenClass" title="成本：8,369.80" style="width:21.04646943011447%;">
								
									<div class="liRunLine" style="left:auto;right:81.1529476996832%;margin-right:1px;"></div>
								
							</div>
						
					</td>
					<td>
							<div class="shouRuClass" title="收入：6,792.34" style="width:3.415966065850122%;">
							
							</div>
						
					</td>
					
					<td><div style="width:80px;text-align: center;" class="nowrapText" title="-1,577.46">-1,577.46</div></td>
					<td><div style="width:80px;text-align: center;" class="nowrapText" title="1,135.51">1,135.51</div></td>
					
				</tr>
			
				<tr>
					<td><div style="width:90px;text-align: left;padding-left: 10px;" class="nowrapText linkURL" title="行业手机报" onclick="openProduct(294035)">行业手机报</div></td>
					<td style="border-right:1px solid #D9D9D9; ">
							<div class="chengBenClass" title="成本：5,048.65" style="width:12.695188093169495%;">
								
							</div>
						
					</td>
					<td>
							<div class="shouRuClass" title="收入：6,191.04" style="width:3.113566614885135%;">
							
								<div class="liRunLine" style="margin-left:-1px;left:81.54756048884373%;"></div>
							
							</div>
						
					</td>
					
					<td><div style="width:80px;text-align: center;" class="nowrapText" title="1,142.40">1,142.40</div></td>
					<td><div style="width:80px;text-align: center;" class="nowrapText" title="0">0</div></td>
					
				</tr>
			
				<tr>
					<td><div style="width:90px;text-align: left;padding-left: 10px;" class="nowrapText linkURL" title="车联网" onclick="openProduct(311387)">车联网</div></td>
					<td style="border-right:1px solid #D9D9D9; ">
							<div class="chengBenClass" title="成本：11,441.92" style="width:28.771534814446824%;">
								
									<div class="liRunLine" style="left:auto;right:44.50977714863066%;margin-right:1px;"></div>
								
							</div>
						
					</td>
					<td>
							<div class="shouRuClass" title="收入：5,092.77" style="width:2.5612292056301937%;">
							
							</div>
						
					</td>
					
					<td><div style="width:80px;text-align: center;" class="nowrapText" title="-6,349.15">-6,349.15</div></td>
					<td><div style="width:80px;text-align: center;" class="nowrapText" title="1,028.81">1,028.81</div></td>
					
				</tr>
			
				<tr>
					<td><div style="width:90px;text-align: left;padding-left: 10px;" class="nowrapText linkURL" title="手机邮箱" onclick="openProduct(294032)">手机邮箱</div></td>
					<td style="border-right:1px solid #D9D9D9; ">
							<div class="chengBenClass" title="成本：992.72" style="width:2.4962669500843657%;">
								
							</div>
						
					</td>
					<td>
							<div class="shouRuClass" title="收入：4,818.88" style="width:2.4234836836463347%;">
							
								<div class="liRunLine" style="margin-left:-1px;left:20.60064993982978%;"></div>
							
							</div>
						
					</td>
					
					<td><div style="width:80px;text-align: center;" class="nowrapText" title="3,826.16">3,826.16</div></td>
					<td><div style="width:80px;text-align: center;" class="nowrapText" title="0">0</div></td>
					
				</tr>
			
				<tr>
					<td><div style="width:90px;text-align: left;padding-left: 10px;" class="nowrapText linkURL" title="K12和校园" onclick="openProduct(407842)">K12和校园</div></td>
					<td style="border-right:1px solid #D9D9D9; ">
							<div class="chengBenClass" title="成本：5,602.43" style="width:14.087713561462511%;">
								
									<div class="liRunLine" style="left:auto;right:62.995310117088955%;margin-right:1px;"></div>
								
							</div>
						
					</td>
					<td>
							<div class="shouRuClass" title="收入：3,529.27" style="width:1.7749197692901013%;">
							
							</div>
						
					</td>
					
					<td><div style="width:80px;text-align: center;" class="nowrapText" title="-2,073.16">-2,073.16</div></td>
					<td><div style="width:80px;text-align: center;" class="nowrapText" title="5,955.44">5,955.44</div></td>
					
				</tr>
			
				<tr>
					<td><div style="width:90px;text-align: left;padding-left: 10px;" class="nowrapText linkURL" title="行业WLAN" onclick="openProduct(294037)">行业WLAN</div></td>
					<td style="border-right:1px solid #D9D9D9; ">
							<div class="chengBenClass" title="成本：7,120.12" style="width:17.904051240332368%;">
								
									<div class="liRunLine" style="left:auto;right:45.01472868907706%;margin-right:1px;"></div>
								
							</div>
						
					</td>
					<td>
							<div class="shouRuClass" title="收入：3,205.10" style="width:1.6118920180377903%;">
							
							</div>
						
					</td>
					
					<td><div style="width:80px;text-align: center;" class="nowrapText" title="-3,915.02">-3,915.02</div></td>
					<td><div style="width:80px;text-align: center;" class="nowrapText" title="4,534.20">4,534.20</div></td>
					
				</tr>
			
		</tbody>
	</table>
</div>













	

<script type="text/javascript">
	$("#caiwu_productAndDepart_ProductTime").html("").append($("#caiwu_productAndDepart_ProductTimeSpan"));
</script></div>
				</div>
				<div id="caiwu_productAndDepart_ProductTime" class="viewChangeTime"><span id="caiwu_productAndDepart_ProductTimeSpan" class="viewChangeSpan  ">数据更新时间:2天前</span></div>
		</div></td>
		<td style="width:49%;vertical-align:top;">
			<div>
				<div class="cmccDashTitle">
					<div class="showMoreSpan showMoreColor productMore" style="font-weight: normal;" onclick="openDepartmentSummaryList()">更多</div>
					<span>部门成本情况</span>
				</div>
				<div class="sumContainer1" style="height:380px;">
					<div style="text-align:right;">
							<div style="float:right;margin-top: 7px;" class="showHelpe" onclick="showTips(this,'departmentTipNameDIV')"></div>
							<div class="shouRuClass" style="height:10px;width:10px;margin:10px 5px;float:right;"></div>
							<div style="margin:5px;float:right;">收入</div>
							
							<div class="chengBenClass" style="height:10px;width:10px;margin:10px 5px;float:right;"></div>
							<div style="margin:5px;float:right;">成本</div>
							<div style="clear:both;"></div>
						</div>
						<div class="helpFloatDIV" id="departmentTipNameDIV" style="line-height: 22px;">
							<div class="showHelpeContent" style="line-height: 23px;">
								<div>优先展示有收入的部门，再按OA部门排序</div>
							</div>
						</div>
					<div id="productAndDepart_Depart" style="min-height:250px;">








<div style="width:100%;margin:0px auto;">
	<table id="departmentResultTable" class="listTable" style=" margin:10px auto;" cellpadding="0" cellspacing="0" border="0">
		<thead>
			<tr>
				<th width="100%"><div style="width:80px">部门</div></th>
				
				<th><div style="width:150.0px">成本</div></th>
				<th><div style="width:150.0px">收入</div></th>
				<th><div style="width:80px">非流动性资产</div></th>
			</tr>
		</thead>
		<tbody>
			
				<tr>
					<td><div style="width:99px;text-align: left;padding-left: 10px;" title="互联网解决方案部" class="nowrapText linkURL" onclick="openDepartmentView(1006)">互联网解决方案部</div></td>
					<td style="border-right:1px solid #D9D9D9; ">
							<div class="chengBenClass" title="成本：179.55" style="width:1.043733863617753%;">
								
									<div class="liRunLine" style="left:auto;right:0.0%;margin-right:1px;"></div>
								
							</div>
						
					</td>
					<td>
						<div class="shouRuClass" title="收入：0" style="width:0.0%;">
						
						</div>
						
					</td>
					
					<td><div style="width:80px;text-align: center;" class="nowrapText" title="0">0</div></td>
				</tr>
			
				<tr>
					<td><div style="width:99px;text-align: left;padding-left: 10px;" title="产品中心" class="nowrapText linkURL" onclick="openDepartmentView(1008)">产品中心</div></td>
					<td style="border-right:1px solid #D9D9D9; ">
							<div class="chengBenClass" title="成本：393.22" style="width:2.2858662110433507%;">
								
									<div class="liRunLine" style="left:auto;right:0.0%;margin-right:1px;"></div>
								
							</div>
						
					</td>
					<td>
						<div class="shouRuClass" title="收入：0" style="width:0.0%;">
						
						</div>
						
					</td>
					
					<td><div style="width:80px;text-align: center;" class="nowrapText" title="1,414.46">1,414.46</div></td>
				</tr>
			
				<tr>
					<td><div style="width:99px;text-align: left;padding-left: 10px;" title="云计算中心" class="nowrapText linkURL" onclick="openDepartmentView(1009)">云计算中心</div></td>
					<td style="border-right:1px solid #D9D9D9; ">
							<div class="chengBenClass" title="成本：-39.62" style="width:-0.23034588458511265%;">
								
							</div>
						
					</td>
					<td>
						<div class="shouRuClass" title="收入：0" style="width:0.0%;">
						
						</div>
						
					</td>
					
					<td><div style="width:80px;text-align: center;" class="nowrapText" title="3,016.19">3,016.19</div></td>
				</tr>
			
				<tr>
					<td><div style="width:99px;text-align: left;padding-left: 10px;" title="医疗行业解决方案部" class="nowrapText linkURL" onclick="openDepartmentView(1011)">医疗行业解决方案部</div></td>
					<td style="border-right:1px solid #D9D9D9; ">
							<div class="chengBenClass" title="成本：24.14" style="width:0.1403322298338469%;">
								
									<div class="liRunLine" style="left:auto;right:0.0%;margin-right:1px;"></div>
								
							</div>
						
					</td>
					<td>
						<div class="shouRuClass" title="收入：0" style="width:0.0%;">
						
						</div>
						
					</td>
					
					<td><div style="width:80px;text-align: center;" class="nowrapText" title="409.41">409.41</div></td>
				</tr>
			
				<tr>
					<td><div style="width:99px;text-align: left;padding-left: 10px;" title="交通行业解决方案部" class="nowrapText linkURL" onclick="openDepartmentView(1012)">交通行业解决方案部</div></td>
					<td style="border-right:1px solid #D9D9D9; ">
							<div class="chengBenClass" title="成本：145.89" style="width:0.8480791377196811%;">
								
									<div class="liRunLine" style="left:auto;right:0.0%;margin-right:1px;"></div>
								
							</div>
						
					</td>
					<td>
						<div class="shouRuClass" title="收入：0" style="width:0.0%;">
						
						</div>
						
					</td>
					
					<td><div style="width:80px;text-align: center;" class="nowrapText" title="0">0</div></td>
				</tr>
			
				<tr>
					<td><div style="width:99px;text-align: left;padding-left: 10px;" title="移动办公创新中心" class="nowrapText linkURL" onclick="openDepartmentView(1013)">移动办公创新中心</div></td>
					<td style="border-right:1px solid #D9D9D9; ">
							<div class="chengBenClass" title="成本：-42.89" style="width:-0.2493284803266811%;">
								
							</div>
						
					</td>
					<td>
						<div class="shouRuClass" title="收入：0" style="width:0.0%;">
						
						</div>
						
					</td>
					
					<td><div style="width:80px;text-align: center;" class="nowrapText" title="305.51">305.51</div></td>
				</tr>
			
				<tr>
					<td><div style="width:99px;text-align: left;padding-left: 10px;" title="服务支撑中心" class="nowrapText linkURL" onclick="openDepartmentView(1017)">服务支撑中心</div></td>
					<td style="border-right:1px solid #D9D9D9; ">
							<div class="chengBenClass" title="成本：364.21" style="width:2.1172472670341627%;">
								
									<div class="liRunLine" style="left:auto;right:0.0%;margin-right:1px;"></div>
								
							</div>
						
					</td>
					<td>
						<div class="shouRuClass" title="收入：0" style="width:0.0%;">
						
						</div>
						
					</td>
					
					<td><div style="width:80px;text-align: center;" class="nowrapText" title="745.18">745.18</div></td>
				</tr>
			
				<tr>
					<td><div style="width:99px;text-align: left;padding-left: 10px;" title="工业和能源行业解决方案部" class="nowrapText linkURL" onclick="openDepartmentView(325909)">工业和能源行业解决方案部</div></td>
					<td style="border-right:1px solid #D9D9D9; ">
							<div class="chengBenClass" title="成本：43.09" style="width:0.25046873497404193%;">
								
									<div class="liRunLine" style="left:auto;right:0.0%;margin-right:1px;"></div>
								
							</div>
						
					</td>
					<td>
						<div class="shouRuClass" title="收入：0" style="width:0.0%;">
						
						</div>
						
					</td>
					
					<td><div style="width:80px;text-align: center;" class="nowrapText" title="0">0</div></td>
				</tr>
			
		</tbody>
	</table>
</div>













	

<script type="text/javascript">
	$("#caiwu_productAndDepart_departTime").html("").append($("#caiwu_productAndDepart_departTimeSpan"));
</script></div>
				 </div>
				 <div id="caiwu_productAndDepart_departTime" class="viewChangeTime"><span id="caiwu_productAndDepart_departTimeSpan" class="viewChangeSpan  ">数据更新时间:2天前</span></div>
		</div></td>
	</tr></tbody></table>

	
	
		







<style>
	.colorDIV{
		width: 10px;
		height:10px;
	}
</style>
<script type="text/javascript">
	function changeYusuanzhixing(index){
		$.ajax({
			url:"/pm/OPEXAction.do?operation=yusuanzhixingResult",
			method:"POST",
			data:{
				year:document.frm.year.value,
				index:index
			},
			success:function(html){
				var div=$("#yusuanzhixingDIV");
				div.html(html);
			}
		});
	}
	jQuery(document).ready(function(){
		changeYusuanzhixing(0);
	})
</script>
<div style="margin: 26px auto;" class="chartContainerDIV cmccViewContainer">
	<div id="yusuanzhixingDIV">







	







<div class="tabMore linkURL" onclick="openchengbenfeiyongDetail()">更多</div>

 
 <div class="tabTitle">
 	<ul>
 		<li onclick="changeYusuanzhixing(0)" class="on">预算执行情况</li>
 		<li onclick="changeYusuanzhixing(1)" class="">分部门预算执行情况</li>
 	</ul>	 
</div>	
	
		











<script type="text/javascript">
	function expandedFun(imgObj,parentID){
		var display=null;
		if(imgObj.src.lastIndexOf("expanded.png")==-1){//说明现在的状态为close的
			var newSrc=imgObj.src.replace(/close\.png/g,"expanded.png");
			imgObj.src=newSrc;		
			display="";
		}else{
			var newSrc=imgObj.src.replace(/expanded\.png/g,"close.png");
			imgObj.src=newSrc;		
			display="none";
		}
		var tbodyObj = document.getElementById(parentID);
		if(display=="none"){
			tbodyObj.style.display="none";
		}else{
			tbodyObj.style.display="";
		}
		yusuanzhixingDetailTable.resize(true);
	}
</script>
<div class="tabContent">
<div style="text-align:right">
	<div class="showHelpe" onclick="showTips(this,'caiwuYusuanTipNameDIV')"></div>
</div>
<div class="helpFloatDIV" id="caiwuYusuanTipNameDIV" style="line-height: 22px;">
	<div class="showHelpeContent" style="line-height: 23px;">
		<div>与预算差额：累计完成额度-预算额度</div>
		<div>完成进度：累计完成额度/预算额度</div>
	</div>
</div>
<div style="height: 250px; overflow: hidden; position: relative;">
	
<div style="height: 100%; overflow: auto; position: absolute; top: 0px; left: 0px; display: block; bottom: 0px; width: 100%;" id="yusuanzhixingDetailTablebody_tbody"><table id="yusuanzhixingDetailTable" class="listTable dataTable" cellpadding="0" cellspacing="0" border="0">
		<thead>
			<tr>
				<th width="100%"><div style="width:170px">费用类别</div></th>
				<th><div style="width:120px">预算额度</div></th>
				<th><div style="width:120px">预算完成</div></th>
				<th><div style="width:120px">累计完成额度</div></th>
				<th><div style="width:120px">与预算差额</div></th>
				<th><div style="width:200px">完成进度</div></th>
			</tr>
		</thead>
		
			<tbody><tr>
				<td>
	  				<img src="/pm/images/newui/close.png" border="0" onclick="javascript:expandedFun(this,294105);" style="cursor: pointer">
	  				<b>人工类成本</b>
			  	</td>
				<td align="center">95,700.50</td>
				<td align="center">95,700.50</td>
				<td align="center">0</td>
				<td align="center">-95,700.50</td>
				<td>
					<div style="width:80%;margin:5px auto;height:8px;background-color:#E8E9ED;">
					
						<div style="height:100%;width:0%;background-color:#0ACC4B;" '=""></div>
					</div>
				</td>
			</tr>
			
				</tbody><tbody id="294105" style="display: none;">
					
						<tr>
							<td align="left">
								<div style="margin-left:55px;">
									劳动保护费
								</div>
							</td>
							<td align="center">815.10</td>
							<td align="center">815.10</td>
							<td align="center">0</td>
							<td align="center">-815.10</td>
							<td>
								<div style="width:80%;margin:5px auto;height:8px;background-color:#E8E9ED;">
								
									<div style="height:100%;width:0%;background-color:#0ACC4B;" '=""></div>
								</div>
							</td>
						</tr>
					
						<tr>
							<td align="left">
								<div style="margin-left:55px;">
									工会经费
								</div>
							</td>
							<td align="center">729.30</td>
							<td align="center">729.30</td>
							<td align="center">0</td>
							<td align="center">-729.30</td>
							<td>
								<div style="width:80%;margin:5px auto;height:8px;background-color:#E8E9ED;">
								
									<div style="height:100%;width:0%;background-color:#0ACC4B;" '=""></div>
								</div>
							</td>
						</tr>
					
						<tr>
							<td align="left">
								<div style="margin-left:55px;">
									人工成本
								</div>
							</td>
							<td align="center">94,156.10</td>
							<td align="center">94,156.10</td>
							<td align="center">0</td>
							<td align="center">-94,156.10</td>
							<td>
								<div style="width:80%;margin:5px auto;height:8px;background-color:#E8E9ED;">
								
									<div style="height:100%;width:0%;background-color:#0ACC4B;" '=""></div>
								</div>
							</td>
						</tr>
					
				</tbody>
			
		
			<tbody><tr>
				<td>
	  				<img src="/pm/images/newui/close.png" border="0" onclick="javascript:expandedFun(this,294109);" style="cursor: pointer">
	  				<b>资产类成本</b>
			  	</td>
				<td align="center">108.00</td>
				<td align="center">108.00</td>
				<td align="center">0</td>
				<td align="center">-108.00</td>
				<td>
					<div style="width:80%;margin:5px auto;height:8px;background-color:#E8E9ED;">
					
						<div style="height:100%;width:0%;background-color:#0ACC4B;" '=""></div>
					</div>
				</td>
			</tr>
			
				</tbody><tbody id="294109" style="display: none;">
					
						<tr>
							<td align="left">
								<div style="margin-left:55px;">
									物业管理费
								</div>
							</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td>
								<div style="width:80%;margin:5px auto;height:8px;background-color:#E8E9ED;">
								
									<div style="height:100%;width:0%;background-color:#0ACC4B;" '=""></div>
								</div>
							</td>
						</tr>
					
						<tr>
							<td align="left">
								<div style="margin-left:55px;">
									车辆运行费
								</div>
							</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td>
								<div style="width:80%;margin:5px auto;height:8px;background-color:#E8E9ED;">
								
									<div style="height:100%;width:0%;background-color:#0ACC4B;" '=""></div>
								</div>
							</td>
						</tr>
					
						<tr>
							<td align="left">
								<div style="margin-left:55px;">
									维保费
								</div>
							</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td>
								<div style="width:80%;margin:5px auto;height:8px;background-color:#E8E9ED;">
								
									<div style="height:100%;width:0%;background-color:#0ACC4B;" '=""></div>
								</div>
							</td>
						</tr>
					
						<tr>
							<td align="left">
								<div style="margin-left:55px;">
									业务费
								</div>
							</td>
							<td align="center">108.00</td>
							<td align="center">108.00</td>
							<td align="center">0</td>
							<td align="center">-108.00</td>
							<td>
								<div style="width:80%;margin:5px auto;height:8px;background-color:#E8E9ED;">
								
									<div style="height:100%;width:0%;background-color:#0ACC4B;" '=""></div>
								</div>
							</td>
						</tr>
					
						<tr>
							<td align="left">
								<div style="margin-left:55px;">
									低值易耗品-生产用
								</div>
							</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td>
								<div style="width:80%;margin:5px auto;height:8px;background-color:#E8E9ED;">
								
									<div style="height:100%;width:0%;background-color:#0ACC4B;" '=""></div>
								</div>
							</td>
						</tr>
					
						<tr>
							<td align="left">
								<div style="margin-left:55px;">
									经营租赁费
								</div>
							</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td>
								<div style="width:80%;margin:5px auto;height:8px;background-color:#E8E9ED;">
								
									<div style="height:100%;width:0%;background-color:#0ACC4B;" '=""></div>
								</div>
							</td>
						</tr>
					
						<tr>
							<td align="left">
								<div style="margin-left:55px;">
									低值易耗品-管理用
								</div>
							</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td>
								<div style="width:80%;margin:5px auto;height:8px;background-color:#E8E9ED;">
								
									<div style="height:100%;width:0%;background-color:#0ACC4B;" '=""></div>
								</div>
							</td>
						</tr>
					
						<tr>
							<td align="left">
								<div style="margin-left:55px;">
									动力水电取暖
								</div>
							</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td>
								<div style="width:80%;margin:5px auto;height:8px;background-color:#E8E9ED;">
								
									<div style="height:100%;width:0%;background-color:#0ACC4B;" '=""></div>
								</div>
							</td>
						</tr>
					
						<tr>
							<td align="left">
								<div style="margin-left:55px;">
									维修费
								</div>
							</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td>
								<div style="width:80%;margin:5px auto;height:8px;background-color:#E8E9ED;">
								
									<div style="height:100%;width:0%;background-color:#0ACC4B;" '=""></div>
								</div>
							</td>
						</tr>
					
						<tr>
							<td align="left">
								<div style="margin-left:55px;">
									折旧及摊销
								</div>
							</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td>
								<div style="width:80%;margin:5px auto;height:8px;background-color:#E8E9ED;">
								
									<div style="height:100%;width:0%;background-color:#0ACC4B;" '=""></div>
								</div>
							</td>
						</tr>
					
				</tbody>
			
		
			<tbody><tr>
				<td>
	  				<img src="/pm/images/newui/close.png" border="0" onclick="javascript:expandedFun(this,294139);" style="cursor: pointer">
	  				<b>业务发展类成本</b>
			  	</td>
				<td align="center">11,483.86</td>
				<td align="center">11,483.86</td>
				<td align="center">0</td>
				<td align="center">-11,483.86</td>
				<td>
					<div style="width:80%;margin:5px auto;height:8px;background-color:#E8E9ED;">
					
						<div style="height:100%;width:0%;background-color:#0ACC4B;" '=""></div>
					</div>
				</td>
			</tr>
			
				</tbody><tbody id="294139" style="display: none;">
					
						<tr>
							<td align="left">
								<div style="margin-left:55px;">
									出售终端成本
								</div>
							</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td>
								<div style="width:80%;margin:5px auto;height:8px;background-color:#E8E9ED;">
								
									<div style="height:100%;width:0%;background-color:#0ACC4B;" '=""></div>
								</div>
							</td>
						</tr>
					
						<tr>
							<td align="left">
								<div style="margin-left:55px;">
									项目集成费
								</div>
							</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td>
								<div style="width:80%;margin:5px auto;height:8px;background-color:#E8E9ED;">
								
									<div style="height:100%;width:0%;background-color:#0ACC4B;" '=""></div>
								</div>
							</td>
						</tr>
					
						<tr>
							<td align="left">
								<div style="margin-left:55px;">
									研究开发费
								</div>
							</td>
							<td align="center">3,911.64</td>
							<td align="center">3,911.64</td>
							<td align="center">0</td>
							<td align="center">-3,911.64</td>
							<td>
								<div style="width:80%;margin:5px auto;height:8px;background-color:#E8E9ED;">
								
									<div style="height:100%;width:0%;background-color:#0ACC4B;" '=""></div>
								</div>
							</td>
						</tr>
					
						<tr>
							<td align="left">
								<div style="margin-left:55px;">
									业务支撑费
								</div>
							</td>
							<td align="center">7,563.18</td>
							<td align="center">7,563.18</td>
							<td align="center">0</td>
							<td align="center">-7,563.18</td>
							<td>
								<div style="width:80%;margin:5px auto;height:8px;background-color:#E8E9ED;">
								
									<div style="height:100%;width:0%;background-color:#0ACC4B;" '=""></div>
								</div>
							</td>
						</tr>
					
						<tr>
							<td align="left">
								<div style="margin-left:55px;">
									业务招待费
								</div>
							</td>
							<td align="center">3.08</td>
							<td align="center">3.08</td>
							<td align="center">0</td>
							<td align="center">-3.08</td>
							<td>
								<div style="width:80%;margin:5px auto;height:8px;background-color:#E8E9ED;">
								
									<div style="height:100%;width:0%;background-color:#0ACC4B;" '=""></div>
								</div>
							</td>
						</tr>
					
						<tr>
							<td align="left">
								<div style="margin-left:55px;">
									机房租赁费
								</div>
							</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td>
								<div style="width:80%;margin:5px auto;height:8px;background-color:#E8E9ED;">
								
									<div style="height:100%;width:0%;background-color:#0ACC4B;" '=""></div>
								</div>
							</td>
						</tr>
					
						<tr>
							<td align="left">
								<div style="margin-left:55px;">
									电路及网元租赁费
								</div>
							</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td>
								<div style="width:80%;margin:5px auto;height:8px;background-color:#E8E9ED;">
								
									<div style="height:100%;width:0%;background-color:#0ACC4B;" '=""></div>
								</div>
							</td>
						</tr>
					
						<tr>
							<td align="left">
								<div style="margin-left:55px;">
									主营业务税金
								</div>
							</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td>
								<div style="width:80%;margin:5px auto;height:8px;background-color:#E8E9ED;">
								
									<div style="height:100%;width:0%;background-color:#0ACC4B;" '=""></div>
								</div>
							</td>
						</tr>
					
						<tr>
							<td align="left">
								<div style="margin-left:55px;">
									邮寄运杂费
								</div>
							</td>
							<td align="center">5.96</td>
							<td align="center">5.96</td>
							<td align="center">0</td>
							<td align="center">-5.96</td>
							<td>
								<div style="width:80%;margin:5px auto;height:8px;background-color:#E8E9ED;">
								
									<div style="height:100%;width:0%;background-color:#0ACC4B;" '=""></div>
								</div>
							</td>
						</tr>
					
				</tbody>
			
		
			<tbody><tr>
				<td>
	  				<img src="/pm/images/newui/close.png" border="0" onclick="javascript:expandedFun(this,294150);" style="cursor: pointer">
	  				<b>行政管理类成本</b>
			  	</td>
				<td align="center">358.84</td>
				<td align="center">358.84</td>
				<td align="center">0</td>
				<td align="center">-358.84</td>
				<td>
					<div style="width:80%;margin:5px auto;height:8px;background-color:#E8E9ED;">
					
						<div style="height:100%;width:0%;background-color:#0ACC4B;" '=""></div>
					</div>
				</td>
			</tr>
			
				</tbody><tbody id="294150" style="display: none;">
					
						<tr>
							<td align="left">
								<div style="margin-left:55px;">
									会议费
								</div>
							</td>
							<td align="center">115.13</td>
							<td align="center">115.13</td>
							<td align="center">0</td>
							<td align="center">-115.13</td>
							<td>
								<div style="width:80%;margin:5px auto;height:8px;background-color:#E8E9ED;">
								
									<div style="height:100%;width:0%;background-color:#0ACC4B;" '=""></div>
								</div>
							</td>
						</tr>
					
						<tr>
							<td align="left">
								<div style="margin-left:55px;">
									审计费
								</div>
							</td>
							<td align="center">40.66</td>
							<td align="center">40.66</td>
							<td align="center">0</td>
							<td align="center">-40.66</td>
							<td>
								<div style="width:80%;margin:5px auto;height:8px;background-color:#E8E9ED;">
								
									<div style="height:100%;width:0%;background-color:#0ACC4B;" '=""></div>
								</div>
							</td>
						</tr>
					
						<tr>
							<td align="left">
								<div style="margin-left:55px;">
									差旅费
								</div>
							</td>
							<td align="center">179.05</td>
							<td align="center">179.05</td>
							<td align="center">0</td>
							<td align="center">-179.05</td>
							<td>
								<div style="width:80%;margin:5px auto;height:8px;background-color:#E8E9ED;">
								
									<div style="height:100%;width:0%;background-color:#0ACC4B;" '=""></div>
								</div>
							</td>
						</tr>
					
						<tr>
							<td align="left">
								<div style="margin-left:55px;">
									办公费
								</div>
							</td>
							<td align="center">23.00</td>
							<td align="center">23.00</td>
							<td align="center">0</td>
							<td align="center">-23.00</td>
							<td>
								<div style="width:80%;margin:5px auto;height:8px;background-color:#E8E9ED;">
								
									<div style="height:100%;width:0%;background-color:#0ACC4B;" '=""></div>
								</div>
							</td>
						</tr>
					
						<tr>
							<td align="left">
								<div style="margin-left:55px;">
									招聘费
								</div>
							</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td>
								<div style="width:80%;margin:5px auto;height:8px;background-color:#E8E9ED;">
								
									<div style="height:100%;width:0%;background-color:#0ACC4B;" '=""></div>
								</div>
							</td>
						</tr>
					
						<tr>
							<td align="left">
								<div style="margin-left:55px;">
									出国人员费
								</div>
							</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td>
								<div style="width:80%;margin:5px auto;height:8px;background-color:#E8E9ED;">
								
									<div style="height:100%;width:0%;background-color:#0ACC4B;" '=""></div>
								</div>
							</td>
						</tr>
					
						<tr>
							<td align="left">
								<div style="margin-left:55px;">
									资料费
								</div>
							</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td>
								<div style="width:80%;margin:5px auto;height:8px;background-color:#E8E9ED;">
								
									<div style="height:100%;width:0%;background-color:#0ACC4B;" '=""></div>
								</div>
							</td>
						</tr>
					
						<tr>
							<td align="left">
								<div style="margin-left:55px;">
									培训费
								</div>
							</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td>
								<div style="width:80%;margin:5px auto;height:8px;background-color:#E8E9ED;">
								
									<div style="height:100%;width:0%;background-color:#0ACC4B;" '=""></div>
								</div>
							</td>
						</tr>
					
						<tr>
							<td align="left">
								<div style="margin-left:55px;">
									其它费用
								</div>
							</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td align="center">0</td>
							<td>
								<div style="width:80%;margin:5px auto;height:8px;background-color:#E8E9ED;">
								
									<div style="height:100%;width:0%;background-color:#0ACC4B;" '=""></div>
								</div>
							</td>
						</tr>
					
						<tr>
							<td align="left">
								<div style="margin-left:55px;">
									管理咨询费
								</div>
							</td>
							<td align="center">1.00</td>
							<td align="center">1.00</td>
							<td align="center">0</td>
							<td align="center">-1.00</td>
							<td>
								<div style="width:80%;margin:5px auto;height:8px;background-color:#E8E9ED;">
								
									<div style="height:100%;width:0%;background-color:#0ACC4B;" '=""></div>
								</div>
							</td>
						</tr>
					
				</tbody>
			
		
		
	</table></div><div style="height: auto; overflow: hidden; position: absolute; display: block; bottom: auto; left: 0px; top: 0px; width: 990px;" id="yusuanzhixingDetailTablebody_theadContainer"><table id="yusuanzhixingDetailTablebody_theadTable" class="listTable dataTable" cellpadding="0" cellspacing="0" border="0" style="width: 990px;"><thead>
			<tr>
				<th width="100%"><div style="width:170px">费用类别</div></th>
				<th><div style="width:120px">预算额度</div></th>
				<th><div style="width:120px">预算完成</div></th>
				<th><div style="width:120px">累计完成额度</div></th>
				<th><div style="width:120px">与预算差额</div></th>
				<th><div style="width:200px">完成进度</div></th>
			</tr>
		</thead></table></div></div>
</div>
<script type="text/javascript">
	window.yusuanzhixingDetailTable=new EasyTrack.DataTable("yusuanzhixingDetailTable",{
		autoHeight:false
	})
</script>
	
	












	

<script type="text/javascript">
	$("#caiwuYusuanzhixingDIVTimeDIV").html("").append($("#caiwuYusuanzhixingDIVTimeDIVSpan"));
</script>
</div>
</div>
<div id="caiwuYusuanzhixingDIVTimeDIV" class="viewChangeTime marginTopTime"><span id="caiwuYusuanzhixingDIVTimeDIVSpan" class="viewChangeSpan  ">数据更新时间:2017-05-09</span></div>
	
		







<script type="text/javascript">
	function openOpexProjectList(index){
		var arg = new Array();
		arg.src = "/pm/CMCCReportServer?reportlet=财务报表/OPEX多项目列表.cpt&_id="+Math.random();
		if(index!=-1){
			arg.src += "&opexStatus="+index;
		}
		arg.title = "OPEX多项目列表";
		arg.containerClass="fineReport";
		top.ET.showNewWindow(arg, function (ret) { 
		})
	}
</script>
<div class="chartContainerDIV" style="margin: 26px auto;">
	<div style="text-align:right">
		<div class="showHelpe" onclick="showTips(this,'opexPhaseTipNameDIV')"></div>
	</div>
	<div class="helpFloatDIV" id="opexPhaseTipNameDIV" style="line-height: 22px;">
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
<table class="statusTable" style="margin:0 auto;" border="0" cellspacing="0" cellpadding="0">
	<tbody><tr>
		<td style="vertical-align: top;"><div class="cmcc_phase_column" style="width:119px;font-weight: bold;">OPEX项目流程：</div></td>
		<td>
			<div style="padding-bottom:20px;"><img src="/pm/images/cmcc/liucheng2.png"></div>
		</td>
	</tr>
	<tr><td style="height:10px;"></td></tr>
	<tr>
		<td><div class="cmcc_phase_column" style="width:119px;">项目总数：</div></td>
		<td>
			<div class="cmcc_phase_kuang" style="background-position: 15px  0px">
				<div class="cmcc_phase_valueDIV linkURL" style="width:119px;" onclick="openOpexProjectList(-1);">387</div>
				
				<div class="cmcc_phase_valueDIV linkURL" style="width:119px;" onclick="openOpexProjectList(0);">387</div>
				
				<div class="cmcc_phase_valueDIV linkURL" style="width:119px;" onclick="openOpexProjectList(1);">0</div>
				
				<div class="cmcc_phase_valueDIV linkURL" style="width:119px;" onclick="openOpexProjectList(2);">0</div>
				
				<div class="cmcc_phase_valueDIV linkURL" style="width:119px;" onclick="openOpexProjectList(3);">0</div>
				
				<div class="cmcc_phase_valueDIV linkURL" style="width:119px;" onclick="openOpexProjectList(4);">0</div>
				
				<div class="cmcc_phase_valueDIV linkURL" style="width:119px;" onclick="openOpexProjectList(5);">0</div>
				
			</div>
	</td></tr>
	<tr><td style="height:10px;"></td></tr>
	<tr>
		<td></td>
		<td>
		<div style="width:954px;">
			<div class="cmcc_phase_moenyTip" style="width:119px;">预算金额</div>
			
			<div class="cmcc_phase_moenyTip" style="width:119px;">&nbsp;</div>
			
			<div class="cmcc_phase_moenyTip" style="width:119px;">立项决策金额&nbsp;</div>
			
			<div class="cmcc_phase_moenyTip" style="width:119px;">合同不含税金额&nbsp;</div>
			
			<div class="cmcc_phase_moenyTip" style="width:119px;">累计工时&nbsp;</div>
			
			<div class="cmcc_phase_moenyTip" style="width:119px;">报账金额&nbsp;</div>
			
			<div class="cmcc_phase_moenyTip" style="width:119px;">入账金额&nbsp;</div>
			
		</div>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td style="text-align:center;vertical-align: top">
		<div style="width:954px;">
			<div class="cmcc_phase_moneyValue" style="width:119px;">0&nbsp;</div>
			
				
					<div class="cmcc_phase_moneyValue" style="width:119px;">&nbsp;</div>
				
			
				
					<div class="cmcc_phase_moneyValue" style="width:119px;">171,171.96&nbsp;</div>
				
			
				
					<div class="cmcc_phase_moneyValue" style="width:119px;">0&nbsp;</div>
				
			
				
					
						<div class="cmcc_phase_moneyValue" style="width:119px;">
							初级：0.0人天<br>
							中级：0.0人天<br>
							高级：0.0人天<br>
							服务：0次
						</div>
					
				
			
				
					<div class="cmcc_phase_moneyValue" style="width:119px;">0&nbsp;</div>
				
			
				
					<div class="cmcc_phase_moneyValue" style="width:119px;">0&nbsp;</div>
				
			
			</div>
		</td>
	</tr>
	<tr><td style="height:10px;"></td></tr>
</tbody></table>

</div>













	

<script type="text/javascript">
	$("#opexProjectStatusDIVTime").html("").append($("#opexProjectStatusDIVTimeSpan"));
</script></div>
</div>
<div id="opexProjectStatusDIVTime" class="viewChangeTime marginTopTime"><span id="opexProjectStatusDIVTimeSpan" class="viewChangeSpan  ">数据更新时间:2小时前</span></div>
<script type="text/javascript">
$(document).ready(function(){
	$.ajax({
		url:"/pm/ZongheAction.do?operation=opexProjectStatus",
		method:"POST",
		data:{
			year:document.frm.year.value
			,departmentID:69
			,showOpexView:false
		},
		success:function(html){
			var div=$("#opexProjectStatusDIV");
			div.html(html);
		}
	});
	
})
</script>
					
		<!-- 
		







	

<script type="text/javascript"> 
	function openOPEXMain(projectID){
	 	var arg = new Array();
		arg.src = "/pm/OPEXAction.do?operation=opexMain"
			+"&projectID="+projectID
			+"&_id="+Math.random();
		arg.title = "全生命周期视图";
		ET.showNewWindow(arg, function (ret) { 
			if(ret != null){
			}
		});
	 }

	function yusuanProjectList(){
		var year = document.frm.year.value;
		var parameter = {
		}
		parameter.onsuccess=function(ajaxRequest){
			var html=ajaxRequest.responseText;
			document.getElementById("opexListContainer").innerHTML=html;
			EasyTrack.loadScript(html);
		}
		parameter.onerror=function(){
			
		}
		ET.ajax.request('/pm/CMCCDashboardAction.do?operation=changeOpexListTab&viewBoard=yusuanProjectList&year='+year+'&thisPage='+document.getElementById("thisPage").value,parameter);
	}
	
	function opexProjectList(){
		var year = document.frm.year.value;
		var parameter = {
		}
		parameter.onsuccess=function(ajaxRequest){
			var html=ajaxRequest.responseText;
			document.getElementById("opexListContainer").innerHTML=html;
			EasyTrack.loadScript(html);
		}
		parameter.onerror=function(){
			
		}
		ET.ajax.request('/pm/CMCCDashboardAction.do?operation=changeOpexListTab&viewBoard=opexProjectList&year='+year+'&thisPage='+document.getElementById("thisPage").value,parameter);
	}


	function changeOpexProjectPage(val){
		document.getElementById("thisPage").value = val;
		opexProjectList();
	}
	
	function changeYusuanProjectPage(val){
		document.getElementById("thisPage").value = val;
		yusuanProjectList();
	}
	ET.Utils.addOnloadEvent(yusuanProjectList);
</script>
<div id="opexListContainer" class="chartContainerDIV" style="border:none;width: 1000px;">
<div class="subTabTitle">&nbsp;</div>









<div class='topnav' > <div class='hd' >   <ul>
<li  class=' on ' > <a  >预算项目</a></li>
<li  class='' > <a  href='javascript:opexProjectList()' >OPEX项目</a></li>
</ul> </div></div>
<input type="hidden" id="thisPage" name="thisPage" value = "1"/>

</div>

		







<style>
	.colorDIV{
		width: 10px;
		height:10px;
	}
</style>
<script type="text/javascript">
	function changeAllCapital(index){
		$.ajax({
			url:"/pm/OPEXAction.do?operation=allCapitalResult",
			method:"POST",
			data:{
				year:document.frm.year.value,
				index:index
			},
			success:function(html){
				var div=$("#capitalDIV");
				div.html(html);
			}
		});
	}
	jQuery(document).ready(function(){
		changeAllCapital(0);
	})
</script>
<div id="capitalDIV" style="margin-top:20px;" class="chartContainerDIV" style="border:none">
	<div class="subTabTitle">&nbsp;</div>
	








<div class='topnav' > <div class='hd' >   <ul>
	<li  class=' on ' > <a  >部门预算</a></li>
	<li  class='' > <a  href='javascript:changeAllCapital(1)' >成本开支</a></li>
</ul> </div></div>
	
	<div style="height:150px;" class="loaddingClass">
	</div>
</div>
	
		 -->
	</div></div>
<div class="dumascroll_barY"><div class="dumascroll_arrow_up"></div><div class="dumascroll_handleY" style="height: 5.23243px; top: 0px;"></div><div class="dumascroll_arrow_down"></div></div><div class="dumascroll_barX showYScroll" style="display: none;"><div class="dumascroll_arrow_left"></div><div class="dumascroll_handleX"></div><div class="dumascroll_arrow_right"></div></div><div class="duma_rightButtom showYScroll"></div></div>
<script type="text/javascript">
	//var oldIndexArray=['milestone','workProduct','task','WorkItem'];
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

