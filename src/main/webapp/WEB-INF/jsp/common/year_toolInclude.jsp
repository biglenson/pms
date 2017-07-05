<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%
String path = "/static";
String value="2014_2015_2016_2017_2018";
String[] years=value.split("_");
int yearStart=TypeUtils.getIntFromString(years[0]);
int yearEnd=TypeUtils.getIntFromString(years[1]);
int sYear=TypeUtils.nullToInt(session.getAttribute("year"));
int toolYear=Calendar.getInstance().get(Calendar.YEAR);
if(sYear!=0){
	toolYear=sYear;
}
%>
<script type="text/javascript">
	jQuery(document).ready(function(){
		var div=document.getElementById("${param.containerID}");
		var divContainerDIV=div;
		var jContainer=$(divContainerDIV);
		var yearSpan=jContainer.find(".showYearSelectSpan span");
		var maxYear=<%=yearEnd%>;
		var yearStart=<%=yearStart%>;
		var jprevObj = $(".yearSelectPrev");
		var jnextObj = $(".yearSelectNext");
		var yearInput=document.getElementById('${param.yearID}');
		var yearFloatObj=new ET.FloatDIV("${param.containerID }FloatDIV",{});
		var first=true;
		var floatDIV=jQuery("#${param.containerID }FloatDIV");
		floatDIV.on("click",".yearItem",function(event){
				var obj=$(this);
				floatDIV.find(".yearItem").filter(".selected").removeClass('selected');
				yearInput.value=obj.html();
				obj.addClass("selected");
				yearSpan.html(yearInput.value);
				${param.jsFunction}(yearInput.value);
				if(yearInput.value == yearStart){
					jprevObj.addClass("disable");
					jprevObj.attr("src","<%=path%>/images/16x16/cmcc_left_disable.png");
					jprevObj.removeAttr("overImg");
				}else{
					jprevObj.removeClass("disable");
					jprevObj.attr("src","<%=path%>/images/16x16/cmcc_left.png");
					
				}
				if(yearInput.value == maxYear){
					jnextObj.addClass("disable");
					jnextObj.attr("src","<%=path%>/images/16x16/cmcc_right_disable.png");
					jnextObj.removeAttr("overImg");
				}else{
					jnextObj.removeClass("disable");
					jnextObj.attr("src","<%=path%>/images/16x16/cmcc_left.png");
					//jnextObj.attr("overImg","<%=path%>/images/16x16/arrow_next_over.png");
				}
				floatDIV.hide();
		}).on("mouseenter",function(event){
			window.clearTimeout(yearFloatObj.hideTimeoutID);
		}).on("mouseleave",function(event){
			window.clearTimeout(yearFloatObj.showTimeoutID);
			yearFloatObj.showTimeoutID=undefined;
			yearFloatObj.hideTimeoutID=window.setTimeout(function(){
				yearFloatObj.hide();
			},500	);
		})
		var contentHeight=document.getElementById("${param.containerID}yearDIV").offsetHeight;
		var scrollyear=new ET.ScrollBar("${param.containerID}yearDIV");
		jContainer.on("click",".showYearSelectSpan",function(event){
			window.clearTimeout(yearFloatObj.hideTimeoutID);
			var obj=this;
			yearFloatObj.showTimeoutID=window.setTimeout(function(){
				var item= floatDIV.find(".yearItem").filter(".selected");
				var yearDIV=document.getElementById('${param.containerID}yearDIV');
				yearFloatObj.popup(obj,{
					y:4
				})
				var maxHeight=document.body.clientHeight-div.getBoundingClientRect().top+div.offsetHeight+2;
				var containerHeight=contentHeight;
				if(contentHeight>maxHeight){
					containerHeight=maxHeight;
				}
				scrollyear.container.style.height=containerHeight+"px";
				scrollyear.container.style.width=yearSpan.get(0).parentNode.offsetWidth+"px";
				scrollyear.resize(false);
				if(first){
					first=false;
					item.get(0).scrollIntoView(false);
				}
			},200	);
		}).on("mouseenter",".showYearSelectSpan",function(event){
			window.clearTimeout(yearFloatObj.hideTimeoutID);
		}).on("mouseleave",".showYearSelectSpan",function(event){
			window.clearTimeout(yearFloatObj.showTimeoutID);
			yearFloatObj.showTimeoutID=undefined;
			yearFloatObj.hideTimeoutID=window.setTimeout(function(){
				yearFloatObj.hide();
			},500	);
		}).on("click",".yearSelectPrev",function(event){
			var obj=$(this);
			if(jnextObj.hasClass("disable")){
				jnextObj.removeClass("disable");
				jnextObj.attr("src","<%=path%>/images/16x16/cmcc_right.png");
				//jnextObj.attr("overImg","<%=path%>/images/16x16/arrow_next_over.png");
			}
			if(!obj.hasClass("disable")){
				var yearValue=parseInt(yearInput.value,10);
				yearValue--;
				if(yearValue>=yearStart){
					yearInput.value=yearValue;
					if(yearValue == yearStart){
						obj.addClass("disable");
						obj.attr("src","<%=path%>/images/16x16/cmcc_left_disable.png");
						obj.removeAttr("overImg");
					}
				}
				yearSpan.html(yearValue);
				floatDIV.find(".yearItem").filter(".selected").removeClass('selected');
				floatDIV.find(".yearItem").filter("[year="+yearValue+"]").addClass('selected');
				${param.jsFunction}(yearInput.value);
			}
		}).on("click",".yearSelectNext",function(event){
			var obj=$(this);
			if(jprevObj.hasClass("disable")){
				jprevObj.removeClass("disable");
				jprevObj.attr("src","<%=path%>/images/16x16/cmcc_left.png");
				//jprevObj.attr("overImg","<%=path%>/images/16x16/arrow_prev_over.png");
			}
			if(!obj.hasClass("disable")){
				var yearValue=parseInt(yearInput.value,10);
				yearValue++;
				if(yearValue<=maxYear){
					yearInput.value=yearValue;
					if(yearValue == maxYear){
						obj.addClass("disable");
						obj.attr("src","<%=path%>/images/16x16/cmcc_right_disable.png");
						//obj.removeAttr("overImg");
					}
				}
				yearSpan.html(yearValue);
				floatDIV.find(".yearItem").filter(".selected").removeClass('selected');
				floatDIV.find(".yearItem").filter("[year="+yearValue+"]").addClass('selected');
				${param.jsFunction}(yearInput.value);
			}
		})
	})
	
</script>
<input type="hidden" name="toolYear" id="${param.yearID}"
	value="<%=toolYear%>" />
<div class="yearSelectDIV" id="${param.containerID }">
	<img class="  yearSelectPrev <%=toolYear==yearStart?"disable":"" %>"
		src="<%=path%>/images/16x16/<%=toolYear==yearStart?"cmcc_left_disable":"cmcc_left"%>.png">
	<span style="font-size: 12px;" class="showYearSelectSpan  "> <span><%=toolYear%></span>
		<img src="<%=path %>/images/yearSelect.png" />
	</span> <img class="  yearSelectNext  <%=toolYear==yearEnd?"disable":"" %>"
		src="<%=path%>/images/16x16/<%=toolYear==yearEnd?"cmcc_right_disable":"cmcc_right"%>.png">
</div>
<div class="yearFloatDIV" id="${param.containerID }FloatDIV">
	<div class="yearDIV" id="${param.containerID}yearDIV"
		style='width: 68px;'>
		<%for(int i=yearStart,j=yearEnd;i<=j;i++){ %>
		<div class="yearItem <%=toolYear==i?"selected":""%>" year="<%=i %>"><%=i %></div>
		<%} %>
	</div>
</div>

