<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = request.getContextPath();
%>
<style type="text/css">
	#productDepartResultTable.listTable  tbody tr td{
		border: none;
	}
	#productDepartResultTable th{
		
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
	function loadProductFun(){
		$.ajax({
			url:"<%=path%>/ZongheAction.do?operation=productResult",
			method:"POST",
			data:{
				year:document.frm.year.value
				,departmentID:document.frm.departmentID.value
				,showYearLiRun:true
				,orderType:$("#ProductOrderType2").hasClass("DESC")?"DESC":"ASC"
			},
			success:function(html){
				var div=$("#productDIV_ID_Depart");
				div.html(html);
			}
		});
	}
	jQuery(document).ready(function(){
		loadProductFun();
		$("#ProductOrderType2").on("click",function(event){
			var obj=$(this);
			obj.toggleClass("DESC");
			loadProductFun();
		})
	})
	
	function showCapexPhaseTip2(obj,divName){
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
	<div   class="chartContainerDIV" style="margin:26px auto;">
		<div class="cmccDashTitle">
			<div id="ProductOrderType2" class='orderbyImg DESC'></div>
			<div class="showMoreSpan showMoreColor productMore" onclick="openProductSummaryList()">更多</div>
			<span >产品累计收入排名(Top 10)</span>
		</div>
		<div style="text-align:right;">
					<div style="float:right;margin-top:7px;" class="showHelpe" onclick="showCapexPhaseTip2(this,'productTipNameDIV')"></div>
					<div class="shouRuClass" style='height:10px;width:10px;margin:10px 5px;float:right;'></div>
					<div style="margin:5px;float:right;">收入</div>
					
					<div class="chengBenClass" style='height:10px;width:10px;margin:10px 5px;float:right;'></div>
					<div style="margin:5px;float:right;">成本</div>
				</div>
				<div class="helpFloatDIV" id="productTipNameDIV" style="line-height: 22px;">
					<div class="showHelpeContent" style="line-height: 23px;">
						<div>产品毛利润计算方式为：产品收入-产品成本(OPEX成本+CAPEX折旧)</div>
					</div>
				</div>
		<div id="productDIV_ID_Depart">
			<div style="height:150px;" class="loaddingClass">
			</div>
		</div>
	</div>
	<div id="productTimeDIV" class="viewChangeTime marginTopTime"></div>
	