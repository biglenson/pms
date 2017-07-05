<%@page import="com.zq.commons.utils.TypeUtils"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String department=(String)request.getAttribute("department");
%>
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
<%-- 	function loadProductAndDepart(subOperation){
		var data={
				year:document.frm.year.value
				,departmentID:"<%= department.getId() %>"
				,operation:subOperation
			};
		if(subOperation=="productAndDepart_Product"){
			var ProductOrderType=$("#ProductOrderType");
			data.orderType=ProductOrderType.hasClass("DESC")?"DESC":"ASC";
		}
		$.ajax({
			url:"<%=path%>/OPEXAction.do",
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
	}) --%>
	
</script>

<table style='width: 1000px; margin: 26px auto;'>
	<td style='width: 51%; vertical-align: top;'>
		<div style='margin-right: 10px;'>
			<div class="cmccDashTitle">
				<div id="ProductOrderType" class='orderbyImg DESC'></div>
				<div class="showMoreSpan showMoreColor productMore"
					style="font-weight: normal;" onclick="openProductSummaryList()">更多</div>
				<span>产品累计收入排名(Top 10)</span>
			</div>
			<div class='sumContainer1' style="height: 380px;">
				<div style="text-align: right;">
					<div style="float: right; margin-top: 7px;" class="showHelpe"
						onclick="showTips(this,'productTipNameDIV')"></div>
					<div class="shouRuClass"
						style='height: 10px; width: 10px; margin: 10px 5px; float: right;'></div>
					<div style="margin: 5px; float: right;">收入</div>

					<div class="chengBenClass"
						style='height: 10px; width: 10px; margin: 10px 5px; float: right;'></div>
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
					<div class="loaddingClass"></div>
				</div>
			</div>
			<div id="caiwu_productAndDepart_ProductTime" class="viewChangeTime" />
		</div>
	</td>
	<td style='width: 49%; vertical-align: top;'>
		<div>
			<div class="cmccDashTitle">
				<div class="showMoreSpan showMoreColor productMore"
					style="font-weight: normal;" onclick="openDepartmentSummaryList()">更多</div>
				<span>部门成本情况</span>
			</div>
			<div class='sumContainer1' style="height: 380px;">
				<div style="text-align: right;">
					<div style="float: right; margin-top: 7px;" class="showHelpe"
						onclick="showTips(this,'departmentTipNameDIV')"></div>
					<div class="shouRuClass"
						style='height: 10px; width: 10px; margin: 10px 5px; float: right;'></div>
					<div style="margin: 5px; float: right;">收入</div>

					<div class="chengBenClass"
						style='height: 10px; width: 10px; margin: 10px 5px; float: right;'></div>
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
					<div class="loaddingClass"></div>
				</div>
			</div>
			<div id="caiwu_productAndDepart_departTime" class="viewChangeTime" />
		</div>
	</td>
</table>


