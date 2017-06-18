<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="header-box " id="headerDIV">
<%-- 输出系统顶级模块的菜单 --%>
<div class="header-down ">	 
	<div class="header_changeApp " id="moduleDIV_changeTopSystemID" onclick="showTopSystemWitch(this);" title="应用"></div>
		<div class="Nav " id="NavMenu">
			<ul>
				<li class="topon"><a href="/comprehensiveview">综合视图</a></li>
				<li><a href="/financialview">财务视图</a></li>
				<li><a href="/purchaseview">采购视图</a></li>
				<li><a href="/projectview">工程视图</a></li>
				<li><a href="/multianalysis">报表</a></li>
			</ul>
			<div class="NavSelectHiddenDIV" id="Nav_NavSelectHiddenDIV" style="display: none;">
				<img src="/images/16x16/icon-changeMenu.png">
			</div>
		</div>
	</div>
	<div class="loginUserDetail" id="NavSelectContainer" style="visibility: hidden; display: none; left: 0px; top: 0px;">
		<div class="loginUserContent" id="NavSelectContainerContent"></div>
	</div>
</div>
<div class="top_header_searchDIV">
	<div class="top_header_Exit" onclick="exit();">退出</div>
	<div class="top_header_userName">zhengqi1</div>	
		<div class="top_header_searchInputDIV">
			<input type="text" placeholder="请输入关键字搜索" id="top_header_searchInputDIVInput">
			<img src="/images/newui/search.png">
		</div>
		 <div class="top_header_searchTypeDIV" id="top_header_searchTypeDIV" typeid="1011">
			<span class="spanType">产品</span>
			<img src="/images/16x16/toolbar-dropDown.png">
		</div>	
</div>
<div class="top_header_top_typeSelect" id="top_header_top_typeSelect">	
		<div class="item  selected" typeid="1011">产品</div>
		<div class="item " typeid="1080">部门</div>
		<div class="item " typeid="1041">项目</div>	
		<div class="item " typeid="1029">CAPEX</div>	
		<div class="item " typeid="1030">OPEX</div>	
		<div class="item " typeid="-80">报表</div>	
</div>
<div id="top_header_top_searchResult" class="top_header_top_searchResult">
	<div id="top_headerReult" class=" dumascroll" style="overflow: hidden;"><div class="dumascroll_area">
	</div><div class="dumascroll_barY" style="display: none;"><div class="dumascroll_arrow_up"></div><div class="dumascroll_handleY"></div><div class="dumascroll_arrow_down"></div></div><div class="dumascroll_barX" style="display: none;"><div class="dumascroll_arrow_left"></div><div class="dumascroll_handleX"></div><div class="dumascroll_arrow_right"></div></div><div class="duma_rightButtom"></div></div>
	<div id="top_header_top_searchLoading">
		<div class="loaddingClass"></div>
	</div>
</div>
<script type="text/javascript">
	function javal_openTopSeachReportView(pathFile,title,isFenye){
		var arg={};
		arg.src = "/ReportServer?reportlet="+pathFile;
		//if(!isFenye){
		//	arg.src+="&op=view";
		//}
		arg.src+="&_id="+Math.random();
		arg.title = title;
		arg.containerClass="fineReport";
		top.ET.showNewWindow(arg, function (ret) { 
		})
	}
	function java_openTopSeachView(id,categoryID){
		function openView(name ,url){
			var arg = new Array();
			arg.src=url;
			arg.src+="&isDialog=true";
			arg.src+="&_id="+Math.random();
			//arg.title = name;
			top.ET.showNewWindow(arg, function (ret) { 
			});
		}
		if(categoryID==1011){
			openView("产品全视图","/ProductAction.do?operation=dashBoard&productID="+id);
		}else if(categoryID==1029){
			openView("CAPEX全视图","/CAPEXAction.do?operation=capexMain&projectID="+id);
		}else if(categoryID==1030){
			openView("OPEX全视图","/OPEXAction.do?operation=opexMain&projectID="+id);
		}else if(categoryID==1041){
			openView("项目全视图","/CMCCItemSetAction.do?operation=itemSetMain&itemID="+id);
		}else if(categoryID==1080){
			var arg = new Array();
			arg.src = "/ZongheAction.do?operation=dashBoard";
			arg.src+="&departmentID="+id;
			arg.src+="&isDialog=true";
			arg.title = undefined;
			top.ET.showNewWindow(arg, function (ret) { 
				if(ret != null){
					
				}
			});
		}
	}
	$(document).ready(function(){
		var firstItem=$("#top_header_top_typeSelect").find(".item:first");
		firstItem.addClass("selected");
		var top_header_searchTypeDIV=$("#top_header_searchTypeDIV");
		top_header_searchTypeDIV.attr("typeID",firstItem.attr("typeID"));
		top_header_searchTypeDIV.find("span.spanType").text(firstItem.text());
		var scrollResult=new ET.ScrollBar("top_headerReult");
		var top_header_searchInputDIVInput=$("#top_header_searchInputDIVInput");
		var typeSelect=new ET.FloatDIV("top_header_top_typeSelect");
		top_header_searchTypeDIV.on("click",function(event){
			typeSelect.popup(this,{
				y:6
			})
		});
		$(typeSelect.sourceElement).on("click",".item",function(event){
			var typeID=$(this).attr("typeID");
			$(typeSelect.sourceElement).find(".item").removeClass("selected");
			$(this).addClass("selected");
			top_header_searchTypeDIV.attr("typeID",typeID);
			top_header_searchTypeDIV.find("span.spanType").text($(this).text());
			typeSelect.hide();
		});
		
		var lastAjax=null;
		var callBackFun=[];
		var do_searchFun=function(){
			if(lastAjax!=null){
				try{
					lastAjax.abort();
				}catch (e) {
					
				}
			}
			for(var i=0,j=callBackFun.length;i<j;i++){
				callBackFun[i].isTimeout=true;
			}
			var top_header_top_searchLoading=$("#top_header_top_searchLoading");
			top_header_top_searchLoading.show();
			var backFun=function(html){
				if(!backFun.isTimeout){
					scrollResult.contentDIV.innerHTML=html;
					scrollResult.resize();
					top_header_top_searchLoading.hide();
				}
			}
			callBackFun=[];
			callBackFun.push(backFun);
			lastAjax=$.ajax({
				url:"/CMCCAction.do?operation=topSearch"
				,method:"POST"
				,data:{
					typeID:top_header_searchTypeDIV.attr("typeID")
					,search:top_header_searchInputDIVInput.val()
				}
				,success:backFun
			});
			
		}
		$(scrollResult.contentDIV).on("click",".resultItem.linkURL",function(){
			top_header_top_searchResult.hide();
		});
		var top_header_top_searchResult=new ET.FloatDIV("top_header_top_searchResult");
		top_header_searchInputDIVInput.on('keyup  click',function(event){
			window.clearTimeout(top_header_searchInputDIVInput.timeoutID);
			top_header_searchInputDIVInput.timeoutID=window.setTimeout(function(){
				top_header_top_searchResult.popupPosition({
					top:50
				    ,right:1
				});
				$(document.body).click();
				do_searchFun();
			},200)
		})
	})
</script>  
<div id="topHeader_changeSys" class="topHeader_changeSys">
	<div class="topHeader_changeSysWrap">
			<table><tbody><tr>					
					<td><div class="topHeader_changeProduct " onclick="systemWitch(1)">
						<img src="/images/app/PPM.png">
						<div class="productName">综合视图</div>
					</div></td>					
					<td><a href="generalGRUDform"><div class="topHeader_changeProduct ">
						<img src="/images/app/CM.png">
						<div class="productName">数据管理</div>
					</div></a></td>					
					<td><div class="topHeader_changeProduct " onclick="systemWitch(3)">
						<img src="/images/app/Admin.png">
						<div class="productName">系统管理</div>
					</div></td>					
				</tr></tbody></table>
	</div>
</div>
<script type="text/javascript">
function showTopSystemWitch(obj) {
	var systemFloat=window.systemFloatObj;
	if(systemFloat==undefined){
		systemFloat=new ET.FloatDIV('topHeader_changeSys',{
			onHide:function(){
				var moduleDIV_changeTopSystemID=document.getElementById('moduleDIV_changeTopSystemID');
				ET.Utils.removeClass(moduleDIV_changeTopSystemID,'header_changeAppOver');
			}
		});
		window.systemFloatObj=systemFloat;
	}
	systemFloat.popupPosition({
		left:200
		,top:54
	});
	//systemFloat.sourceElement.style.zIndex=2147483647;
}
ET.Utils.addEvent(window,'load',function(event){
	var moduleDIV_changeTopSystemID=document.getElementById('moduleDIV_changeTopSystemID');
	if(moduleDIV_changeTopSystemID!=null){
		var floatDIV=document.getElementById('topHeader_changeSys');
		ET.Utils.addEvent(floatDIV,'mouseover',function(){
			ET.Utils.addClass(moduleDIV_changeTopSystemID,'header_changeAppOver');
		})
	}
})
</script>