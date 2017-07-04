<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = request.getContextPath();
int year = TypeUtils.getIntFromString(request.getParameter("year"));
%>
<style>
	.colorDIV{
		width: 10px;
		height:10px;
	}
</style>
<script type="text/javascript">
	function changeYusuanzhixing(index){
		$.ajax({
			url:"<%=path%>/OPEXAction.do?operation=yusuanzhixingResult",
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
	<div class="subTabTitle">&nbsp;</div>
	<jsp:include  page="yusuanzhixingTab.jsp">
		 	<jsp:param value="0" name="index"/>
		</jsp:include>
	<div class="tabContent" style='height: 150px;' >
				<div  class="loaddingClass"></div>
			</div>
	</div>
</div>
<div id="caiwuYusuanzhixingDIVTimeDIV" class="viewChangeTime marginTopTime"></div>
	