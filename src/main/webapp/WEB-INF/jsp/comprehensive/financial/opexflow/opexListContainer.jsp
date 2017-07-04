<%-- <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%  
	String path=request.getContextPath();
	Locale locale = (Locale) session.getAttribute("org.apache.struts.action.LOCALE");
%>
<script type="text/javascript"> 
	function openOPEXMain(projectID){
	 	var arg = new Array();
		arg.src = "<%=path%>/OPEXAction.do?operation=opexMain"
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
		ET.ajax.request('<%=path%>/CMCCDashboardAction.do?operation=changeOpexListTab&viewBoard=yusuanProjectList&year='+year+'&thisPage='+document.getElementById("thisPage").value,parameter);
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
		ET.ajax.request('<%=path%>/CMCCDashboardAction.do?operation=changeOpexListTab&viewBoard=opexProjectList&year='+year+'&thisPage='+document.getElementById("thisPage").value,parameter);
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
<% request.setAttribute("selectedTab", 1); %>
<%@include file="opexListTab.jsp" %>
</div>
 --%>