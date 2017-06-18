<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<input type="hidden" name="operation" value="analySis">
	<div id="propDIV" class=" dumascroll" style="overflow: hidden; height: 178px;">
		<div class=" dumascroll_area showYScroll"><div style="width: 1000px;margin: 10px auto;">
		
		
		   <div class="bbtype">
			    <p class="baobiao">综合报表</p>
			    <div class="linkURL1">
			    	<a class="linkURL" style="font-size: 14px;" onclick="openReport(this)"><img alt="#" src="/pm/images/icon_Excel_01.png"> 部门综合报表</a>
			    	<div class="reportDesrc">展示部门收入、成本和资金使用情况</div>
			    </div>
			    <div class="linkURL1">
			    	<a class="linkURL" style="font-size: 14px;" onclick="fenye(this)"><img alt="#" src="/pm/images/icon_Excel_01.png"> 产品综合报表</a>
			    	<div class="reportDesrc">展示产品收入、成本、资本投入等情况</div>
			    </div>
			    <div class="linkURL1">
			    	<a class="linkURL" style="font-size: 14px;" onclick="openReport(this)"><img alt="#" src="/pm/images/icon_Excel_01.png"> 项目综合报表</a>
			    	<div class="reportDesrc">展示项目投入、开支、转资进度情况</div>
			    </div>
		    </div>
		
		
		   <div class="bbtype">
			    <p class="baobiao">财务报表</p>
			    <div class="linkURL1">
			    	<a class="linkURL" style="font-size: 14px;" onclick="openReport(this)"><img alt="#" src="/pm/images/icon_Excel_01.png"> 分部门预算分解情况表</a>
			    	<div class="reportDesrc">预算按部分分解情况</div>
			    </div>
			    <div class="linkURL1">
			    	<a class="linkURL" style="font-size: 14px;" onclick="openReport(this)"><img alt="#" src="/pm/images/icon_Excel_01.png"> 预算分解情况</a>
			    	<div class="reportDesrc">预算科目分解情况</div>
			    </div>
			    <div class="linkURL1">
			    	<a class="linkURL" style="font-size: 14px;" onclick="openReport(this)"><img alt="#" src="/pm/images/icon_Excel_01.png"> 预算项目列表</a>
			    	<div class="reportDesrc">预算项目分解情况</div>
			    </div>
			    <div class="linkURL1">
			    	<a class="linkURL" style="font-size: 14px;" onclick="fenye(this)"><img alt="#" src="/pm/images/icon_Excel_01.png"> OPEX多项目列表</a>
			    	<div class="reportDesrc">展示公司OPEX项目情况</div>
			    </div>
			    <div class="linkURL1">
			    	<a class="linkURL" style="font-size: 14px;" onclick="fenye(this)"><img alt="#" src="/pm/images/icon_Excel_01.png"> 多项目成本开支情况表</a>
			    	<div class="reportDesrc">展示OPEX项目成本开支计划和执行情况</div>
			    </div>
			    <div class="linkURL1">
			    	<a class="linkURL" style="font-size: 14px;" onclick="openReport(this)"><img alt="#" src="/pm/images/icon_Excel_01.png"> 成本费用预算预计完成情况</a>
			    	<div class="reportDesrc">展示成本费用完成情况</div>
			    </div>
		    </div>
		    
		    
		   <div class="bbtype">
			    <p class="baobiao">采购报表</p>
			    <div class="linkURL1">
			    	<a class="linkURL" style="font-size: 14px;" onclick="fenye(this)"><img alt="#" src="/pm/images/icon_Excel_01.png"> 采购项目启动及时率</a>
			    	<div class="reportDesrc">统计采购项目启动及时情况</div>
			    </div>
			    <div class="linkURL1">
			    	<a class="linkURL" style="font-size: 14px;" onclick="fenye(this)"><img alt="#" src="/pm/images/icon_Excel_01.png"> 采购项目完成及时率</a>
			    	<div class="reportDesrc">统计采购项目完成及时情况</div>
			    </div>
			    <div class="linkURL1">
			    	<a class="linkURL" style="font-size: 14px;" onclick="openReport(this)"><img alt="#" src="/pm/images/icon_Excel_01.png"> 单一来源采购场景分析（2016.4.15后）</a>
			    	<div class="reportDesrc">统计分析单一来源各场景情况（2016.4.15后）</div>
			    </div>
			    <div class="linkURL1">
			    	<a class="linkURL" style="font-size: 14px;" onclick="openReport(this)"><img alt="#" src="/pm/images/icon_Excel_01.png"> 单一来源采购场景分析（2016.4.15前）</a>
			    	<div class="reportDesrc">统计分析单一来源各场景情况（2016.4.15前）</div>
			    </div>
			    <div class="linkURL1">
			    	<a class="linkURL" style="font-size: 14px;" onclick="fenye(this)"><img alt="#" src="/pm/images/icon_Excel_01.png"> 二级集采采购节约成本</a>
			    	<div class="reportDesrc">统计二级集采成本节约情况</div>
			    </div>
			    <div class="linkURL1">
			    	<a class="linkURL" style="font-size: 14px;" onclick="fenye(this)"><img alt="#" src="/pm/images/icon_Excel_01.png"> 采购项目绩效统计</a>
			    	<div class="reportDesrc">部门内采购绩效统计--采购项目</div>
			    </div>
			    <div class="linkURL1">
			    	<a class="linkURL" style="font-size: 14px;" onclick="fenye(this)"><img alt="#" src="/pm/images/icon_Excel_01.png"> 框架下采购项目绩效统计</a>
			    	<div class="reportDesrc">部门内采购绩效统计--框架下采购</div>
			    </div>
			    <div class="linkURL1">
			    	<a class="linkURL" style="font-size: 14px;" onclick="openReport(this)"><img alt="#" src="/pm/images/icon_Excel_01.png"> OPEX各需求部门需求提交情况</a>
			    	<div class="reportDesrc">展示各需求部门OPEX需求提交情况</div>
			    </div>
			    <div class="linkURL1">
			    	<a class="linkURL" style="font-size: 14px;" onclick="openReport(this)"><img alt="#" src="/pm/images/icon_Excel_01.png"> OPEX各品类需求提交情况</a>
			    	<div class="reportDesrc">展示OPEX各品类需求提交情况</div>
			    </div>
			    <div class="linkURL1">
			    	<a class="linkURL" style="font-size: 14px;" onclick="openReport(this)"><img alt="#" src="/pm/images/icon_Excel_01.png"> OPEX已提交需求未完成项目执行情况</a>
			    	<div class="reportDesrc">展示OPEX已提交需求未完成项目执行情况</div>
			    </div>
		    </div>
		    
		
			<div class="bbtype">
			    <p class="baobiao">工程报表</p>
			    <div class="linkURL1">
			    	<a class="linkURL" style="font-size: 14px;" onclick="fenye(this)"><img alt="#" src="/pm/images/icon_Excel_01.png"> 年度投资计划表</a>
			    	<div class="reportDesrc">展示公司年度投资计划信息</div>
			    </div>
			    <div class="linkURL1">
			    	<a class="linkURL" style="font-size: 14px;" onclick="fenye(this)"><img alt="#" src="/pm/images/icon_Excel_01.png"> 年度投资计划执行情况表</a>
			    	<div class="reportDesrc">展示公司投资计划执行情况</div>
			    </div>
			    <div class="linkURL1">
			    	<a class="linkURL" style="font-size: 14px;" onclick="fenye(this)"><img alt="#" src="/pm/images/icon_Excel_01.png"> CAPEX多项目列表</a>
			    	<div class="reportDesrc">展示公司CAPEX项目情况</div>
			    </div>
			    <div class="linkURL1">
			    	<a class="linkURL" style="font-size: 14px;" onclick="fenye(this)"><img alt="#" src="/pm/images/icon_Excel_01.png"> 多项目资本开支、转资情况汇总表</a>
			    	<div class="reportDesrc">展示CAPEX项目资本开支、转资情况</div>
			    </div>
			    <div class="linkURL1">
			    	<a class="linkURL" style="font-size: 14px;" onclick="openReport(this)"><img alt="#" src="/pm/images/icon_Excel_01.png"> CAPEX通报表</a>
			    	<div class="reportDesrc">展示CAPEX通报表</div>
			    </div>
		    </div>
		    
			
			<div class="bbtype">
			    <p class="baobiao">多维分析报表</p>
			    <div class="linkURL1">
			    	<a class="linkURL" style="font-size: 14px;" onclick="openReport(this)"><img alt="#" src="/pm/images/icon_Excel_01.png"> 分公司利润表</a>
			    	<div class="reportDesrc">当年及去年同期各项收入情况展示、对比</div>
			    </div>
			    <div class="linkURL1">
			    	<a class="linkURL" style="font-size: 14px;" onclick="openReport(this)"><img alt="#" src="/pm/images/icon_Excel_01.png"> 分公司资产负债表</a>
			    	<div class="reportDesrc">年初、期末负债情况及上年同期情况展示、对比</div>
			    </div>
			    <div class="linkURL1">
			    	<a class="linkURL" style="font-size: 14px;" onclick="openReport(this)"><img alt="#" src="/pm/images/icon_Excel_01.png"> 分公司收入结构表（按模式）</a>
			    	<div class="reportDesrc">当年和去年同期不同收入类型收入情况</div>
			    </div>
			    <div class="linkURL1">
			    	<a class="linkURL" style="font-size: 14px;" onclick="openReport(this)"><img alt="#" src="/pm/images/icon_Excel_01.png"> 分公司收入结构表（按部门）</a>
			    	<div class="reportDesrc">当年各部门收入情况及全年目标完成情况</div>
			    </div>
			    <div class="linkURL1">
			    	<a class="linkURL" style="font-size: 14px;" onclick="openReport(this)"><img alt="#" src="/pm/images/icon_Excel_01.png"> 分公司收入结构表（按行业）</a>
			    	<div class="reportDesrc">本年度及去年全年各行业收入情况</div>
			    </div>
			    <div class="linkURL1">
			    	<a class="linkURL" style="font-size: 14px;" onclick="openReport(this)"><img alt="#" src="/pm/images/icon_Excel_01.png"> 分公司收入结构表（按产品）</a>
			    	<div class="reportDesrc">当年各产品收入情况及全年目标完成情况</div>
			    </div>
			    <div class="linkURL1">
			    	<a class="linkURL" style="font-size: 14px;" onclick="openReport(this)"><img alt="#" src="/pm/images/icon_Excel_01.png"> 分公司成本结构表</a>
			    	<div class="reportDesrc">当年及去年同期各费用项目情况展示、对比</div>
			    </div>
			    <div class="linkURL1">
			    	<a class="linkURL" style="font-size: 14px;" onclick="openReport(this)"><img alt="#" src="/pm/images/icon_Excel_01.png"> 分部门收入及成本使用表</a>
			    	<div class="reportDesrc">各部门收入、成本、占用非流动资产情况</div>
			    </div>
			    <div class="linkURL1">
			    	<a class="linkURL" style="font-size: 14px;" onclick="openReport(this)"><img alt="#" src="/pm/images/icon_Excel_01.png"> 分部门开支规划及实际进度表</a>
			    	<div class="reportDesrc">各部门预算完成情况</div>
			    </div>
			    <div class="linkURL1">
			    	<a class="linkURL" style="font-size: 14px;" onclick="openReport(this)"><img alt="#" src="/pm/images/icon_Excel_01.png"> 分产品利润表概览</a>
			    	<div class="reportDesrc">各产品当年、累计收入、成本、利润、投入概况</div>
			    </div>
			    <div class="linkURL1">
			    	<a class="linkURL" style="font-size: 14px;" onclick="openReport(this)"><img alt="#" src="/pm/images/icon_Excel_01.png"> 分产品利润表</a>
			    	<div class="reportDesrc">各产品当年、累计收入、成本、利润、投入明细</div>
			    </div>
			    <div class="linkURL1">
			    	<a class="linkURL" style="font-size: 14px;" onclick="openReport(this)"><img alt="#" src="/pm/images/icon_Excel_01.png"> 分项目利润表概览</a>
			    	<div class="reportDesrc">各项目当年、累计收入、成本、利润、投入概况</div>
			    </div>
			    <div class="linkURL1">
			    	<a class="linkURL" style="font-size: 14px;" onclick="openReport(this)"><img alt="#" src="/pm/images/icon_Excel_01.png"> 分项目利润表</a>
			    	<div class="reportDesrc">各项目当年、累计收入、成本、利润、投入、间接效益明细</div>
			    </div>
		    </div>
		    
	 	</div></div>
	 <div class="dumascroll_barY"><div class="dumascroll_arrow_up"></div><div class="dumascroll_handleY" style="height: 17.534px; top: 0px;"></div><div class="dumascroll_arrow_down"></div></div><div class="dumascroll_barX showYScroll" style="display: none;"><div class="dumascroll_arrow_left"></div><div class="dumascroll_handleX"></div><div class="dumascroll_arrow_right"></div></div><div class="duma_rightButtom showYScroll"></div></div>
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