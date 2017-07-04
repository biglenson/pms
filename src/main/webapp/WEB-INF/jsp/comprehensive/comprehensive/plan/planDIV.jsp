<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = request.getContextPath();
Locale locale = webMgr.getCurrentLocale();
%>
<script type="text/javascript">
	function A__changePlan(index){
		$.ajax({
			url:"<%=path%>/ZongheAction.do?operation=planResult",
			method:"POST",
			data:{
				year:document.frm.year.value
				,departmentID:document.frm.departmentID.value
				,index:index
			},
			success:function(html){
				var div=$("#gongcheng_planDIV");
				div.html(html);
			}
		});
	}
	jQuery(document).ready(function(){
		A__changePlan(0);
	})
	
	function showTipNames(obj,divName){
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
	<div  class="chartContainerDIV cmccViewContainer" style="margin: 26px auto;">
		<div id="gongcheng_planDIV" >
			<jsp:include  page="planDIVTab.jsp">
				 	<jsp:param value="0" name="index"/>
			</jsp:include>
			<div class="tabContent" style='height: 150px;' >
				<div  class="loaddingClass"></div>
			</div>
		</div>
	</div>
	<div id="planDIVDIVTimeDIV" class="viewChangeTime marginTopTime"></div>
	