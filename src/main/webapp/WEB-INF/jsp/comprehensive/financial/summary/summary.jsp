<%@page import="com.zq.commons.utils.TypeUtils"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
int year = TypeUtils.getIntFromString(request.getParameter("year"));
%>
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
<div >
	<table style='width:1000px;margin:10px auto;'>
		<td style='width:25%;vertical-align: top;'>
			<div style='margin-right:10px;' >
				<div class="sumTitle"  onclick="">
					本年分公司真实收入
				</div>
				<div class='sumContainer1' style="height: 220px;" id="shouru">
					<div  class="loaddingClass">
					</div>
				</div>
				<div id="caiwuchengbenTimeDIV" class="viewChangeTime"></div>
			</div>
		</td>
		
		<td style='width:25%;vertical-align: top;'>
			<div style='margin-right:10px;' >
				<div class="sumTitle"  onclick="">
					本年成本
				</div>
				<div class='sumContainer1' style="height: 220px;" id="chengben">
					<div  class="loaddingClass">
					</div>
				</div>
				<div id="caiwukaizhizhuanziTimeDIV" class="viewChangeTime"></div>
			</div>
		</td>
		<td style='width:25%;vertical-align: top;'>
			<div style='margin-right:10px;'>
				<div class="sumTitle"  onclick="">
					投资/预算总额
				</div>
				<div class='sumContainer1' style="height: 220px;" id="touziyusuantotal">
					<div  class="loaddingClass">
					</div>
				</div>
				<div id="caiwushouruTimeDIV" class="viewChangeTime"></div>
			</div>
		</td>
		<td style='width:25%;vertical-align: top;'>
			<div>
				<div class="sumTitle"  onclick="">
					开支、转资进度
				</div>
				<div class='sumContainer1' style="height: 220px;" id="kaizhizhuanzijindu">
					<div  class="loaddingClass" style="height:100%">
					</div>
				</div>
				<div id="caiwutouziyusuanTimeDIV" class="viewChangeTime"></div>
			</div>
		</td>
	</table>
</div>
<script type="text/javascript">
	jQuery(document).ready(function(){
		$.ajax({
			url:"<%=path%>/financialview/realIncome",
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
			url:"<%=path%>/OPEXAction.do?operation=chengben",
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
			url:"<%=path%>/OPEXAction.do?operation=touziyusuantotal",
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
			url:"<%=path%>/OPEXAction.do?operation=kaizhizhuanzijindu",
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
