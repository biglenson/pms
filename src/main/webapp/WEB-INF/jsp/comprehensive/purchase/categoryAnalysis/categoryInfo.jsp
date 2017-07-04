<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = request.getContextPath();
%>
<script type="text/javascript">
	function changeCategoryAnalysis(index){
		$.ajax({
			url:"<%=path%>/CaiGouAction.do?operation=categoryInfo",
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
	<jsp:include  page="categoryAnalysisTab.jsp">
		 	<jsp:param value="0" name="index"/>
	</jsp:include>
	<div style="height:300px;" class="tabContent">
		<div class="loaddingClass">
		</div>
	</div>
	</div>
</div>
<div id="categoryInfoDIVTimeDIV" class="viewChangeTime marginTopTime"></div>
	