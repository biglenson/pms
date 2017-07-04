<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = request.getContextPath();
%>
<script type="text/javascript">
	jQuery(document).ready(function(){
		$.ajax({
			url:"<%=path%>/CaiGouAction.do?operation=costSavingInfo",
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
		<div class="loaddingClass">
		</div>
	</div>
</div>
<div id="costsavingInfoDIVTimeDIV" class="viewChangeTime marginTopTime"></div>
	