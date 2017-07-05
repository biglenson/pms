<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%  
	String path=request.getContextPath();
	Locale locale = (Locale) session.getAttribute("org.apache.struts.action.LOCALE");
%>
<script type="text/javascript">
 function openCAPEXMain(projectID){
	 
 	var arg = new Array();
	arg.src = "<%=path%>/CAPEXAction.do?operation=capexMain"
		+"&projectID="+projectID
		+"&_id="+Math.random();
	arg.src += "&isDialog=true";
	//arg.title = "项目全生命周期视图";
	ET.showNewWindow(arg, function (ret) { 
		if(ret != null){
			
		}
	});
 }
	function A_changeList(index){
		$.ajax({
			url:"<%=path%>/GongchengAction.do?operation=gongchengListResult",
			method:"POST",
			data:{
				year:document.frm.year.value
				,index:index
				,thisPage:document.getElementById("thisPage").value
			},
			success:function(html){
				var div=$("#capexListContainer");
				div.html(html);
			}
		});
	}
	jQuery(document).ready(function(){
		A_changeList(0);
	})


	function changeCapexProjectPage(val){
		document.getElementById("thisPage").value = val;
		A_changeList(1);
	}
	
	function changeTouziplanPage(val){
		document.getElementById("thisPage").value = val;
		A_changeList(0);
	}
	
</script>
<div class="chartContainerDIV cmccViewContainer"
	style="margin: 26px auto;">
	<div id="capexListContainer">
		<jsp:include page="capexListTab.jsp">
			<jsp:param value="0" name="index" />
		</jsp:include>
		<div class="tabContent" style='height: 150px;'>
			<div class="loaddingClass"></div>
		</div>
	</div>
</div>
<div id="gongchengListTimeDIV" class="viewChangeTime marginTopTime"></div>
