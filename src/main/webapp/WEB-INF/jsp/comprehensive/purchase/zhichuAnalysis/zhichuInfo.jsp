<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = request.getContextPath();
%>
<script type="text/javascript">
	function changeZhichuAnalysis(index){
		$.ajax({
			url:"<%=path%>/CaiGouAction.do?operation=zhichuInfo",
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
<div class="cmccViewContainer" style="width: 1000px; margin: 26px auto;">
	<div id="zhichuInfoDIV">
		<jsp:include page="zhichuAnalysisTab.jsp">
			<jsp:param value="0" name="index" />
		</jsp:include>
		<div style="height: 300px; width: 100%" class="tabContent">
			<div class="loaddingClass"></div>
		</div>
	</div>
</div>
<div id="zhichuInfoDIVTimeDIV" class="viewChangeTime marginTopTime"></div>
