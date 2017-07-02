<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>项目全流程</title>
<link rel="icon" href="favicon.ico" type="image/x-icon">
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="/static/css/style_new.css" rel="stylesheet" type="text/css">
<link href="/static/css/style.css" rel="stylesheet" type="text/css">
<link href="/static/css/style_cm.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/static/js/firefox/et.js"></script>
<script type="text/javascript" 	src="/static/js/firefox/FloatAndDialog.js"></script>
<script type="text/javascript" 	src="/static/js/jquery/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="/static/js/lable_message.js"></script>
<script type="text/javascript">
	ET.current_app_ID=2; //保存当前的appID ,在弹出框的时候 ，模板中自动加载特殊的css 
	ET.path="<%=request.getContextPath()%>";
	ET.language="GB";
	ET.i18n="zh";
	ET.label={};
	ET.label["LeaveWithoutSavingConfirm"]="您确定不保存就离开吗?";
	ET.label["SessionTimeoutException"]="com.pm.commons.exception.SessionTimeoutException";
	ET.label["profile.SessionTimeOut.Reason"]="您需要重新登录系统:\n超时或者您已经登录";
	ET.label["ConfirmLogout"]="您确定要退出?";
	ET.label["about"]="关于项目全流程";
	ET.label["webServerInfo"]="web服务器信息";
	ET.label["WindowReturnList"]="返回上一层";
	ET.label["task_attention"]="关注";
	ET.label["attented"]="已关注";

	function newMessageItemFun() {
		var arg = new Array();arg.src = "/CommunicationAction.do?operation=newMessage"+"&_id="+Math.random();
		arg.title = "新消息 ";
		arg.width = 640;
		arg.height = 350;
		ET.showModalWindow(arg, function (ret) {
		});
	}
	function newBulletinItemFun() {
		var arg = new Array();
		arg.src = "/CommunicationAction.do?operation=newBulletin"+"&_id="+Math.random();
		arg.title = "新公告 ";
		arg.width = 840;arg.height = document.body.clientHeight - 20;
		ET.showModalWindow(arg, function (ret) {});}
	 
		function showNewItemMenu(obj) {
			var listMenu = new Array();listMenu.id = "listMenu";
			listMenu.items = new Array();
			var i = 0;
			listMenu.items[i] = new Array();listMenu.items[i]["type"]= 'item';
			listMenu.items[i]["function"]	= 'newMessageItemFun()';
			listMenu.items[i]["image"]		= 'empty.gif';
			listMenu.items[i]["label"]		= '消息';
			i++;
			listMenu.items[i] = new Array();listMenu.items[i]["type"]= 'item';
			listMenu.items[i]["function"]	= 'newBulletinItemFun()';
			listMenu.items[i]["image"]		= 'empty.gif';
			listMenu.items[i]["label"]= '公告';
			var disabled = '';
			popupMenu(obj, listMenu, disabled);
		}
		function systemWitch(systemFlag){
			if(!isLeave()){
				return;
			}
			var form = document.frm;
			if(form==null||!form){
				return;
			}
			var url="";
			var elements = document.frm.elements;
			for (var i = 0; elements && i < elements.length; i++) {
				elements[i].value = "";
			}if(systemFlag==1){
				url="/comprehensiveview";
			}else if(systemFlag==2){
				url="/datamanager";
			}else if(systemFlag==3){
				url="/systemmanager";
			}
			
			form.action=url;
			form.submit();
			
		}

		function initialLayoutFunction(){
			if(ET.is_ie7){
				var bodyHeight=0;
				if(document.compatMode=='CSS1Compat'){
					bodyHeight=document.documentElement.clientHeight;
				}else{
					bodyHeight=document.body.clientHeight;
				}
				var bodyStart_container=document.getElementById('bodyStart_container');
				var height=bodyHeight-bodyStart_container.getBoundingClientRect().top+2;
				if(height<0){
					height=0;
				}
				bodyStart_container.style.height=height+"px";
			}
			
		}
	
		ET.Utils.addEvent(window,'load',initialLayoutFunction);
		ET.Utils.addEvent(window,'resize',initialLayoutFunction);
		ET.Utils.addEvent(window,'load',function(){
		ET.Utils.onloadEvent();		
		initialLayoutFunction();		
	});

	
	function script_clickMenuFun(span){
		script_changeUrl(span);
	}
	function script_changeUrl(span){
		var clickSubMenuID=span.getAttribute('uid');
		var objectID=script_getFunctionObjectID();
		script_freshPage(objectID,clickSubMenuID );
	}
	function script_getFunctionObjectID(){
		var etObjectID=0;
		
		return etObjectID;
	}
	function script_setFunctionObjectID(etObjectID,ret){
		
	}
	function changeSubMenuTabPanel(newSubMenuID){
		script_freshPage(undefined,newSubMenuID);
	}
	function script_freshPageFun(etObjectID,clickSubMenuID){
		var menuID=81;
		if(etObjectID==undefined){
			etObjectID=script_getFunctionObjectID();
		}
		var subMenuID=document.frm.subMenuID.value;
		if(clickSubMenuID!=undefined){
			subMenuID=clickSubMenuID;
		}
		MenuAction.getChangeObjectUrl(menuID,subMenuID,etObjectID,function(ret){
			if(ret!=null){
			    document.frm.action='/pm'+ret.url;
				var elements = document.frm.elements;
				for (var i = 0,j= elements.length;i<j; i++) {
						
					elements[i].value = "";
				}
				document.frm.menuID.value=menuID;
				document.frm.subMenuID.value=ret.subMenuID;
				script_setFunctionObjectID(etObjectID,ret);
				MenuAction.storeUserLastMenu(menuID,ret.subMenuID,etObjectID,function(){
						etSubmit(document.frm);	
					},function(){
						etSubmit(document.frm);	
					} );
			}else{
				alert("您的权限不足，在此模块找不到合适的菜单!");
			}
		})
	}
	function script_freshPage(etObjectID,clickSubMenuID){
		if(!isLeave()){
			return ;
		}
		script_freshPageFun(etObjectID,clickSubMenuID);
	}

	function menu_ScrollBar_resizeFun(){
		
		if(window['menu_Scroll_Bar']!=null){
			window['menu_Scroll_Bar'].resize();
		}
	}
	
	function initalSimpelMenuFun(){
		var div=document.getElementById("bodyStart_simpleMenuDiv");
		if(div==null){
			return;
		}
		var spanOnMouseOver=function(){
			var span=this;
			window.clearTimeout(span.mouseOutTimeout);
			var imgOn=document.getElementById(span.getAttribute('uid')+"SimpleUrlImgOn");
			var imgOff=document.getElementById(span.getAttribute('uid')+"SimpleUrlImgOff");
				span.mouseOverTimeout=window.setTimeout(function(){
					ET.Utils.addClass(span,'spanHover');
					if(!ET.Utils.hasClass(span,'menuSelected')){
						if(imgOn!=null&&imgOn.clientWidth>0){	
							imgOff.style.display="";
							imgOn.style.display="none";
						}
					}
				},200);
		}
		var spanOnMouseOut=function(){
			var span=this;
			window.clearTimeout(span.mouseOverTimeout);
			var imgOn=document.getElementById(span.getAttribute('uid')+"SimpleUrlImgOn");
			var imgOff=document.getElementById(span.getAttribute('uid')+"SimpleUrlImgOff");
				span.mouseOutTimeout=window.setTimeout(function(){
					ET.Utils.removeClass(span,'spanHover');
					if(!ET.Utils.hasClass(span,'menuSelected')){
						if(imgOff!=null&&imgOff.clientWidth>0 ){
							imgOff.style.display="none";
							imgOn.style.display="";
						}
					}
				},200);
		}
	
		var divs=div.getElementsByTagName('div');
		for(var i=0,j=divs.length;i<j;i++){
			var tempDIV=divs[i];
			var url=tempDIV.getAttribute("url");
			if(url!=null&&url!=""){
				tempDIV.onclick=function(event){
					var clickDIV=this;
					if(ET.Utils.hasClass(clickDIV,'menuSelected')){
						script_freshPage();
					}else{
						script_clickMenuFun(clickDIV);
					}
				}
			}
			var showImg=tempDIV.getAttribute("showImg");
			if(showImg!=null&&showImg=="true"){
				tempDIV.onmouseover=spanOnMouseOver;
				tempDIV.onmouseout=spanOnMouseOut;
			}
		}
	}
	ET.Utils.addEvent(window,'load',function(){
		 initalSimpelMenuFun();
	});	
	
	function initialMenuFunction(){
		if(window.menu_Scroll_Bar==null){
			window['menu_Scroll_Bar']=new ET.ScrollBar("bodyStart_leftsidebar");
		}
		var menuDIV=document.getElementById('bodyStart__menuDIV');
		var script_subMenuIDSpan=document.getElementById('81MenuDIVSpan');
		var script_level=script_subMenuIDSpan!=null?parseInt(script_subMenuIDSpan.getAttribute('level'),10):1;
		
		var spanClick=function(){
			var span=this;
			var spanLevel=parseInt(span.getAttribute('level'),10);
			var  childSize=parseInt(span.getAttribute('childSize'),10);
			var uid=span.getAttribute('uid');
			
			if(ET.Utils.hasClass(span,"menuSelected")){
				script_freshPage();
			}else{
				script_clickMenuFun(span);
			}
			menu_ScrollBar_resizeFun();
		}
		var spanOnMouseOver=function(){
			var obj=this;
			window.clearTimeout(obj.outTimeoutID);
			obj.overTimeoutID=window.setTimeout(function(){
				if(!ET.Utils.hasClass(obj,'menuSelected')){
					ET.Utils.addClass(obj,'spanHover');
					var span=obj;
					var imgOn=document.getElementById(span.getAttribute('uid')+"urlImgOn");
					var imgOff=document.getElementById(span.getAttribute('uid')+"urlImgOff");
					if(imgOff!=null){
						imgOff.style.display="";
						imgOn.style.display="none";
					}
				}
			},100)
		}
		var spanOnMouseOut=function(){
			var obj=this;
			window.clearTimeout(obj.overTimeoutID);
			obj.outTimeoutID=window.setTimeout(function(){
				if(!ET.Utils.hasClass(obj,'menuSelected')){
					ET.Utils.removeClass(obj,'spanHover');
					var span=obj;
					var imgOn=document.getElementById(span.getAttribute('uid')+"urlImgOn");
					var imgOff=document.getElementById(span.getAttribute('uid')+"urlImgOff");
					if(imgOff!=null){
						imgOff.style.display="none";
						imgOn.style.display="";
					}
				}
			})
		}
		var urlSpan=menuDIV.getElementsByTagName('div');
		var temUrlSpan=null;
		
		for(var i=0,j=urlSpan.length;i<j;i++){
			temUrlSpan=urlSpan[i];
			if(temUrlSpan.getAttribute('uid')==null){
				continue;
			}
			
				temUrlSpan.onclick=spanClick;
			
			temUrlSpan.onmouseover=spanOnMouseOver;
			temUrlSpan.onmouseout=spanOnMouseOut;
		}
	}

	 
	
	function toggleLeft(){
		var simpleMenuDIV= document.getElementById("bodyStart_simpleMenuDiv");
		var className="closeContainer";
		if(simpleMenuDIV==null){
			className="closeContainerNoMenu";
		}
		var bodyStart_container=document.getElementById('bodyStart_container');
		var open=ET.Utils.hasClass(bodyStart_container, className);
		var bodyLeftAllDIV=jQuery("#bodyLeftAllDIV");
		var bodyStart_dragDIV=jQuery("#bodyStart_dragDIV");
		var contentDIV=jQuery("#bodyStart__content_Wrap");
		if(open){
			ET.Utils.removeClass(bodyStart_container,className);
			var width=bodyLeftAllDIV.data("old_Width");
			bodyLeftAllDIV.css("width",width);
			bodyStart_dragDIV.css("display","block");
			contentDIV.css("left",width+11	);
			
			MenuAction.updateUIState("0", "0", "1", function (data) {
			});
		}else{
			bodyLeftAllDIV.data("old_Width",bodyLeftAllDIV.width()	);
			bodyLeftAllDIV.css("width",54);
			bodyStart_dragDIV.css("display","none");
			contentDIV.css("left",67);
			ET.Utils.addClass(bodyStart_container,className);
			MenuAction.updateUIState("0", "0", "0", function (data) {
			});
		}
		window.toogle_close_flag=!window.toogle_close_flag;
		for(var i=0,j=ET.toggleLeftEvent.length;i<j;i++){
			var fun=ET.toggleLeftEvent[i];
			if(typeof(fun)=='string'){
				window.eval(fun);
			}else if(typeof(fun)=='function'){
				fun();
			}
		}
	}
	
	ET.Utils.addEvent(window,'load',initialMenuFunction);	
	ET.Utils.addEvent(window,'load',function(){
		ET.Utils.onloadEvent();		
		ET.addToggleLeftEvent(menu_ScrollBar_resizeFun);		
		initialLayoutFunction();		
	});
</script>
<script type="text/javascript" src="/js/firefox/DataTableAll.js"></script>
<script type="text/javascript" src="/js/webuploader/webuploader.min.js"></script>
<script type="text/javascript">
var listMenu ={};
listMenu.id = "listMenu";
var arrays=[];
listMenu.items=arrays;
var obj=null;
obj={
		type:'item',
		'function':"allSearchFun('')"
		,'check':true
		,'label':"查询全部"
}
arrays.push(obj);

obj={
		type:'item',
		'function':"searchFun()"
		,'check':false
		,'label':"高级查询"
}
arrays.push(obj);

function allSearchFun(){
	document.frm.searchType.value = "";
	revertFun();
	etSubmit(document.frm);
}
function searchFun() {
	var height = parseInt("7");
	height = height * 30 + 190;
	if(height < 300) height = 400;
	if(height > 700) height = 700;
	var arg = new Array();
	arg.src = "/SimpleFormAction.do?operation=search&type=0&schemaID="+document.frm.schemaID.value+"&height="+height+"&_id="+Math.random();
	arg.title = "高级查询";
	arg.width = 640;
	arg.theme="search";
	arg.height = height;
	ET.showModalWindow(arg, function (ret) { 
		if(ret == "1"){
			document.frm.searchType.value = "search";
			revertFun();
			etSubmit(document.frm);
		} 
	})
}

function showMenu(obj) {
	popupMenu(obj, listMenu, "");
}
function deleteFun() {
	var iNum = 0;
	var oList = getArray(document.frm.id);
	var ids = "";
	for(var i=0;i<oList.length;i++) {
		if(oList[i].checked) {
			iNum++;
			if(ids != "") ids += ",";
			ids += oList[i].value;
		}
	}
	if(iNum==0) {
		alert("没有选中要删除的表单");
		return false;
	}
	if(confirm("您确定要删除吗？")) {
		SimpleFormAction.deleteSimpleForm(ids, document.frm.schemaID.value, function(data) {
			etSubmit(document.frm);
		});
	}
}

function newFun() {
	
		var arg = new Array();
		arg.src = "/SimpleFormAction.do?operation=new&type=1&schemaID=1031&referenceID=0"+"&_id="+Math.random();
		arg.title = "";
		arg.width = 840;
		arg.height = document.body.clientHeight - 20;
		parent.ET.showNewWindow(arg, function (ret) { 
			if(ret != null){
				etSubmit(document.frm);
			}
		});
	
	
}

function orderDocList(column) {
	var orderType = document.frm.orderType.value;
	if(column == document.frm.orderBy.value) {
		if(orderType == "ASC") 
			orderType = "DESC";
		else 
			orderType = "ASC";
	} else {
		orderType = "ASC";
	}
	document.frm.page.value = "1";
	document.frm.orderBy.value = column;
	document.frm.orderType.value = orderType;
	etSubmit(document.frm);			
}
function changePage(page) {
	document.frm.page.value = page;
	etSubmit(document.frm);			
}
function openForm(id) {
	var arg = new Array();
	arg.src = "/SimpleFormAction.do?operation=open&type=1&formID="+id+"&schemaID="+document.frm.schemaID.value+"&_id="+Math.random();
	arg.src+="&versionNo="+document.frm.versionNo.value
	arg.title = "CAPEX投资计划";
	arg.width = 840;
	arg.height = parent.document.body.clientHeight - 20;
	parent.ET.showNewWindow(arg, function (ret) { 
		SimpleFormAction.unlockMySelf(id, function(data) {
			if(ret != null){
				etSubmit(document.frm);
			}
		});
	});
}
function exportExcelFun(){
	var arg = new Array();
	arg.src = "/ExportExcelAction.do?operation=dialog&exportID=538&schemaID="+document.frm.schemaID.value+"&_id=" + Math.random();
	arg.title = "导出";
	arg.theme="search";
	arg.width = 440;
	arg.height =340;
	top.ET.showModalWindow(arg, function (ret) { 
		if(typeof ret!="undefined"){
			document.frm.isExport.value="true";
			document.frm.action="/CMCCAction.do";
			document.frm.operation.value="cmccExport";
			document.frm.fields.value=ret;
			document.frm.submit();
			revertFun();
		}
	});
}

function revertFun(){
	document.frm.action="/CMCCAction.do";
	document.frm.operation.value="cmccList";
}


function showMore (obj){
	var listMenu = new Array();
	listMenu.items = new Array();
	var i=0;
	
		
		listMenu.items[i] = new Array();
		listMenu.items[i]["type"] 		= 'item';
		listMenu.items[i]["function"]	= 'importExcelFun()';
		listMenu.items[i]["label"]		= '从Excel导入';
		listMenu.items[i]['disable'] = 'false';
		i++;
	
	listMenu.items[i] = new Array();
	listMenu.items[i]["type"] 		= 'item';
	listMenu.items[i]["function"]	= 'exportExcelFun()';
	listMenu.items[i]["label"]		= '导出到 MS Excel';
	listMenu.items[i]['disable'] = 'false';

	i++;
	popupMenu(obj, listMenu, "");
	
}

function downLoadExportLog(modeID){
	document.frm.formID.value=modeID;
	document.frm.action.value="/CMCCAction.do";
	document.frm.operation.value="downLoadExportLog";
	document.frm.submit();
	
}
function importExcelFun(){
	var arg = new Array();
	arg.src = "/ExcelImportFormAction.do?operation=excelImportFormNew&schemaID="+document.frm.schemaID.value+"&referenceID=" +document.frm.referenceID.value+"&_id=" + Math.random();
	arg.src+="&isCmcc=true";
	arg.title = "从Excel导入";
	arg.width = 440;
	arg.theme="search";
	arg.height =340;
	ET.showModalWindow(arg, function (ret) { 
		if(typeof ret!="undefined"){
			revertFun();
			etSubmit(document.frm);
		}
	});
}
function saveAsVersionLine(){
	if(window.confirm("您确定要保存基线吗?")){
		CMCCAction.saveAsVersionLine({
			schemaID:1031
		},function(ret){
			revertFun();
			etSubmit(document.frm);
		})
	}
}

function compareFeeVersionFun(){
	var arg = new Array();
	arg.src = "/CMCCAction.do?operation=compareFeeList&schemaID="+document.frm.schemaID.value+"&referenceID=" +document.frm.referenceID.value+"&_id=" + Math.random();
	arg.title = "跟原始版本比较";
	ET.showNewWindow(arg, function (ret) { 
		if(typeof ret!="undefined"){
			revertFun();
			etSubmit(document.frm);
		}
	});
}

function compareVersionFun(targetObj){
	var baselineMenu=new Array;
	baselineMenu.id="baseLineMenu";
	var arry=baselineMenu.items=[];
	var item={
		type:'text'	
		,'label':"选择被比较基线"
	};
	arry.push(item);
	var item={
			type:'split'	
	};
	arry.push(item);
	var item={
		type:'item'	
		,"function":'compareVersion(0)'
		,'label':"当前版本"
	};
	arry.push(item);
	
		item={
			type:'item'	
			,"function":'compareVersion(1)'
			,'label':"基线1(2017-01-16)"
		};
		arry.push(item);
	
  popupMenu(targetObj,baselineMenu,"",true);
}
function compareVersion(compareVersion){
	var arg = new Array();
	arg.src = "/CMCCAction.do?operation=compareList&schemaID="+document.frm.schemaID.value+"&referenceID=" +document.frm.referenceID.value+"&_id=" + Math.random();
	arg.src+="&versionNo="+document.frm.versionNo.value
	arg.src+="&versionNo2="+compareVersion
	arg.title = "基线比较";
	ET.showNewWindow(arg, function (ret) { 
		if(typeof ret!="undefined"){
			revertFun();
			etSubmit(document.frm);
		}
	});
}

function checkInPingGuFile(objectID){
	var arg = new Array();
	arg.src = "/CMCCAction.do?operation=toCheckIn&schemaID=1031&objectID="+objectID+"&_id="+Math.random();
	arg.title = "更新评估文件";
	arg.theme="search";
	arg.width = 450;
	arg.height = 220;
	parent.ET.showModalWindow(arg, function (ret) { 
		if(ret != null){
			if(ret==1){
				alert("更新成功");
			}else if(ret==0){
				alert("更新失败");
			}
		}
	});
}

function deleteMoreFun(){
	var arg = new Array();
	arg.src = "/CMCCAction.do?operation=deleteMoreForm&schemaID="+document.frm.schemaID.value+"&referenceID=" +document.frm.referenceID.value+"&_id=" + Math.random();
	arg.src+="&isCmcc=true";
	arg.title = "删除选择";
	arg.width = 440;
	arg.theme="search";
	arg.height =200;
	ET.showModalWindow(arg, function (ret) { 
		if(typeof ret!="undefined"){
			revertFun();
			etSubmit(document.frm);
		}
	});
}

</script>

<script type="text/javascript">

function showFormActionMenu(obj,id){
	DWREngine.setAsync(false);
	SimpleFormAction.getFormActionButtonList(id,document.frm.schemaID.value,function(data){
		if(typeof data!="undefined"){
			eval(data);
		}
	});
	DWREngine.setAsync(true);
}
function editFun(id) {
	var arg = new Array();
	arg.src = "/SimpleFormAction.do?operation=edit&type=1&formID="+id+"&schemaID="+document.frm.schemaID.value+"&_id="+Math.random();
	arg.title = "CAPEX投资计划";
	arg.width = 840;
	arg.height = document.body.clientHeight - 20
	ET.showNewWindow(arg, function (ret) { 
		SimpleFormAction.unlock(id, function(data) {});
		if(ret != null){
			revertFun();
			etSubmit(document.frm);
		}
	});

		
}
function deleteItemFun(id) {
	if(confirm("您确定要删除吗？")) {
		SimpleFormAction.deleteSimpleForm(id, document.frm.schemaID.value, function(data) {
			etSubmit(document.frm);
		});
	}
}
function transferFun(id) {
	var arg = new Array();
	arg.src = "/SimpleFormAction.do?operation=transfer&schemaID="+document.frm.schemaID.value+"&formID="+id+"&_id=" + Math.random();
	arg.title = '传阅';
	arg.width = 640;
	arg.theme = 'search';
	arg.height = 350;
	ET.showModalWindow(arg, function (a) { 
		if(a != null) {
		}
	});
}
function copyFun(id,referenceID) {
	var arg = new Array();
	arg.src = "/SimpleFormAction.do?operation=selectProject&action=copy&referenceID=" + referenceID + "&schemaID="+document.frm.schemaID.value+"&formID="+id+"&_id="+Math.random();
	arg.title = "选择项目";
	arg.width = 720;
	arg.theme="search";
	arg.height =360;
	ET.showModalWindow(arg, function (ret) { 
		if(ret != null && ret != "0"){
			arg = new Array();
			arg.src = "/SimpleFormAction.do?operation=copy&action=copy&referenceID=" + ret + "&schemaID="+document.frm.schemaID.value+"&formID="+id+"&_id="+Math.random();
			arg.title = "选择项目";
			arg.width = 840;
			if(document.frm.isDialog.value){
				arg.height = parent.document.body.clientHeight - 20;
				parent.ET.showModalWindow(arg, function (ret) {
					if(ret != null && ret != "0"){
							revertFun();
						etSubmit(document.frm);
					}
				}); 
			}else{
				arg.height = document.body.clientHeight - 20;
				ET.showModalWindow(arg, function (ret) { 
					if(ret != null && ret != "0"){
							revertFun();
						etSubmit(document.frm);
					}
				});
			}
				
			
		}
	});
}
function moveFun(id,referenceID) {
	var arg = new Array();
	arg.src = "/SimpleFormAction.do?operation=selectProject&action=move&referenceID=" + referenceID+ "&schemaID="+document.frm.schemaID.value+"&formID="+id+"&_id="+Math.random();
	arg.title = "选择项目";
	arg.width = 720;
	arg.theme="search";
	arg.height =360;
	ET.showModalWindow(arg, function (ret) { 
		if(ret != null && ret != "0"){
			arg = new Array();
			arg.src = "/SimpleFormAction.do?operation=move&action=copy&referenceID=" + ret + "&schemaID="+document.frm.schemaID.value+"&formID="+id+"&_id="+Math.random();
			arg.title = "选择项目";
			arg.width = 840;
			if(document.frm.isDialog.value){
				arg.height = parent.document.body.clientHeight - 20;
				parent.ET.showModalWindow(arg, function (ret) { 
					if(ret != null && ret != "0"){
							revertFun();
						etSubmit(document.frm);
					}
				});
			}else{
				arg.height = document.body.clientHeight - 20;
				ET.showModalWindow(arg, function (ret) { 
					if(ret != null && ret != "0"){
							revertFun();
						etSubmit(document.frm);
					}
				});
			}
				
		}
	});
}
function changeState(id,status, actionID,alertType,lastUpdateTime) {
	SimpleFormAction.checkModified(document.frm.schemaID.value, id, lastUpdateTime, function(data) {
		var errNo = data.substring(0,1);
		if(errNo == "0"){
			alert(data.substring(1));
			parent.ET.closeModalWindow("1");
		} else if(errNo == "1"){
			alert(data.substring(1));		
			revertFun();
			etSubmit(document.frm);
		}else if(errNo == "2"){
			alert(data.substring(1));		
		} else {
			if(alertType==1){
				var arg = new Array();
				arg.src = "/SimpleFormAction.do?operation=changeStatus&actionID=" + actionID+"&schemaID="+document.frm.schemaID.value+"&formID="+id+"&status="+status+"&actionType=1&_id=" + Math.random();
				arg.title = '快速审批';
				arg.width = 400;
				arg.height = 220;
				ET.showModalWindow(arg, function (a) {
					if(a != null) {
						revertFun();
						etSubmit(document.frm);
					}else{
						SimpleFormAction.unlock(id, function(data) {});
					}
				});
			}else{
				var arg = new Array();
				arg.src = "/SimpleFormAction.do?operation=changeStatus&actionID=" + actionID+"&schemaID="+document.frm.schemaID.value+"&formID="+id+"&status="+status+"&actionType=1&_id=" + Math.random();
				arg.title = '审批';
				arg.width = 840;
				if(document.frm.isDialog.value){
					arg.height = parent.document.body.clientHeight - 20;
					parent.ET.showModalWindow(arg, function (a) { 
						if(a != null) {
							revertFun();
							etSubmit(document.frm);
						}else{
							SimpleFormAction.unlock(id, function(data) {});
						}
					});
				}else{
					arg.height = document.body.clientHeight - 20;
					ET.showModalWindow(arg, function (a) { 
						if(a != null) {
							revertFun();
							etSubmit(document.frm);
						}else{
							SimpleFormAction.unlock(id, function(data) {});
						}
					});
				}
					
			}
		}
	});
}
</script>
</head>
<body>
<%-- 输出系统顶级模块的菜单 --%>
<jsp:include page="../../common/TopMenu.jsp">
	<jsp:param name="appid" value="2" />
</jsp:include>
	<div class="container  " id="bodyStart_container">
		<div class="leftAllDIV  null" id="bodyLeftAllDIV">
			<div class="leftsidebar null" id="bodyStart_leftsidebar">
				<div class="sidebar" id="bodyStart__menuDIV">
					<div id="defaultLeftMenuDIV"
						style="position: absolute; top: 0px; bottom: 37px; width: 100%; overflow: hidden;"
						class=" dumascroll">
						<div class="dumascroll_area showYScroll">
							<div uid="8101" id="8101MenuDIVSpan" parentid="81" level="1"
								childsize="0"
								url="/CMCCAction.do?operation=cmccList&amp;schemaID=1031"
								class="menuDIV menuLevel1 menuSelected " style="display:">
								<img id="8101urlImgOn" class="sidebarimg"
									src="/static/images/16x16/projectProposalAdmin_.png"
									style="display: none"><img id="8101urlImgOff"
									class="sidebarimg"
									src="/static/images/16x16/projectProposalAdmin__on.png"
									style="display:">CAPEX投资计划

							</div>
							<div uid="8106" id="8106MenuDIVSpan" parentid="81" level="1"
								childsize="0"
								url="/CMCCAction.do?operation=cmccList&amp;schemaID=1042"
								class="menuDIV menuLevel1  " style="display:">
								<img id="8106urlImgOn" class="sidebarimg"
									src="/static/images/16x16/projectProposalAdmin_.png"
									style="display:"><img id="8106urlImgOff"
									class="sidebarimg"
									src="/static/images/16x16/projectProposalAdmin__on.png"
									style="display: none">CAPEX自主资金池

							</div>

							<div uid="8103" id="8103MenuDIVSpan" parentid="81" level="1"
								childsize="0"
								url="/CMCCAction.do?operation=cmccList&amp;schemaID=1043"
								class="menuDIV menuLevel1  " style="display:">
								<img id="8103urlImgOn" class="sidebarimg"
									src="/static/images/16x16/projectProposalAdmin_.png"
									style="display:"><img id="8103urlImgOff"
									class="sidebarimg"
									src="/static/images/16x16/projectProposalAdmin__on.png"
									style="display: none">CAPEX需求

							</div>
							<div uid="8102" id="8102MenuDIVSpan" parentid="81" level="1"
								childsize="0"
								url="/CMCCAction.do?operation=cmccList&amp;schemaID=1029"
								class="menuDIV menuLevel1  " style="display:">
								<img id="8102urlImgOn" class="sidebarimg"
									src="/static/images/16x16/projectProposalAdmin_.png"
									style="display:"><img id="8102urlImgOff"
									class="sidebarimg"
									src="/static/images/16x16/projectProposalAdmin__on.png"
									style="display: none">CAPEX项

							</div>
							<div uid="6617" id="6617MenuDIVSpan" parentid="81" level="1"
								childsize="0"
								url="/CMCCAction.do?operation=cmccList&amp;&amp;schemaID=1079"
								class="menuDIV menuLevel1  " style="display:">
								<img id="6617urlImgOn" class="sidebarimg"
									src="/static/images/16x16/expense_info_template_.png"
									style="display:"><img id="6617urlImgOff"
									class="sidebarimg"
									src="/static/images/16x16/expense_info_template__on.png"
									style="display: none">CAPEX项与投资计划

							</div>
							<div uid="8105" id="8105MenuDIVSpan" parentid="81" level="1"
								childsize="0"
								url="/CMCCAction.do?operation=cmccList&amp;schemaID=1044"
								class="menuDIV menuLevel1  " style="display:">
								<img id="8105urlImgOn" class="sidebarimg"
									src="/static/images/16x16/projectProposalAdmin_.png"
									style="display:"><img id="8105urlImgOff"
									class="sidebarimg"
									src="/static/images/16x16/projectProposalAdmin__on.png"
									style="display: none">CAPEX资本开支计划

							</div>
							<div uid="8104" id="8104MenuDIVSpan" parentid="81" level="1"
								childsize="0"
								url="/CMCCAction.do?operation=cmccList&amp;schemaID=1046"
								class="menuDIV menuLevel1  " style="display:">
								<img id="8104urlImgOn" class="sidebarimg"
									src="/static/images/16x16/projectProposalAdmin_.png"
									style="display:"><img id="8104urlImgOff"
									class="sidebarimg"
									src="/static/images/16x16/projectProposalAdmin__on.png"
									style="display: none">CAPEX转资计划

							</div>
							<div uid="8108" id="8108MenuDIVSpan" parentid="81" level="1"
								childsize="0"
								url="/CMCCAction.do?operation=cmccList&amp;schemaID=1073"
								class="menuDIV menuLevel1  " style="display:">
								<img id="8108urlImgOn" class="sidebarimg"
									src="/static/images/16x16/projectProposalAdmin_.png"
									style="display:"><img id="8108urlImgOff"
									class="sidebarimg"
									src="/static/images/16x16/projectProposalAdmin__on.png"
									style="display: none">投资计划总额信息管理

							</div>
						</div>
						<div class="dumascroll_barY" style="">
							<div class="dumascroll_arrow_up"></div>
							<div class="dumascroll_handleY"
								style="height: 69.0313px; top: 0px;"></div>
							<div class="dumascroll_arrow_down"></div>
						</div>
						<div class="dumascroll_barX showYScroll" style="display: none;">
							<div class="dumascroll_arrow_left"></div>
							<div class="dumascroll_handleX"></div>
							<div class="dumascroll_arrow_right"></div>
						</div>
						<div class="duma_rightButtom showYScroll"></div>
					</div>
					<div id="leftMenuSettingDIV">
						<div id="leftMenu_splitOpen" class="split_Open"
							onclick="toggleLeft();"></div>
					</div>
					<script type="text/javascript">
		function outMenuWrapScrollBar_Fun(){
			var divMenu1=document.getElementById("defaultLeftMenuDIV");
			var divMenu2=document.getElementById('leftMenuSettingDIV');
			var height= divMenu2!=null?divMenu2.offsetHeight:0;
			if(height<20&&divMenu2!=null){
				height=36;
			}
			divMenu1.style.bottom=height+"px";
			var leftScrollDIVID="defaultLeftMenuDIV";
			
			window.menu_Scroll_Bar=new ET.ScrollBar(leftScrollDIVID);
		}
		outMenuWrapScrollBar_Fun();

	</script>
				</div>
			</div>

			<div id="bodyStart_simpleMenuDiv" class="simpleMenuDiv  null">
				<div class="simpleContainer">
					<div class="simpleLevelMenu  menuSelected" uid="8101"
						id="8101simpleLevelMenu" parentid="81"
						url="/CMCCAction.do?operation=cmccList&amp;schemaID=1031">
						<div showimg="true" class="simpleMenuImgDIV  menuSelected"
							uid="8101">
							<img class="simpleLevelMenuImg" id="8101SimpleUrlImgOn"
								src="/static/images/16x16/projectProposalAdmin_.png"
								style="display: none"> <img class="simpleLevelMenuImg"
								id="8101SimpleUrlImgOff"
								src="/static/images/16x16/projectProposalAdmin__on.png"
								style="display:">
						</div>
						<div class="simpleLevelMenuChildren onlyOne "
							name="level2Container" id="8101simpleLevelMenuChildren">

							<div class="level2SimpleOnly" level="1" uid="8101"
								id="8101SimpleMenuDIVSpan" childsize="0"
								url="/CMCCAction.do?operation=cmccList&amp;schemaID=1031">
								<div>CAPEX投资计划</div>
							</div>

						</div>
					</div>

					<div class="simpleLevelMenu  " uid="8106" id="8106simpleLevelMenu"
						parentid="81"
						url="/CMCCAction.do?operation=cmccList&amp;schemaID=1042">
						<div showimg="true" class="simpleMenuImgDIV  " uid="8106">
							<img class="simpleLevelMenuImg" id="8106SimpleUrlImgOn"
								src="/static/images/16x16/projectProposalAdmin_.png"
								style="display:"> <img class="simpleLevelMenuImg"
								id="8106SimpleUrlImgOff"
								src="/static/images/16x16/projectProposalAdmin__on.png"
								style="display: none">
						</div>
						<div class="simpleLevelMenuChildren onlyOne "
							name="level2Container" id="8106simpleLevelMenuChildren">

							<div class="level2SimpleOnly" level="1" uid="8106"
								id="8106SimpleMenuDIVSpan" childsize="0"
								url="/CMCCAction.do?operation=cmccList&amp;schemaID=1042">
								<div>CAPEX自主资金池</div>
							</div>

						</div>
					</div>

					<div class="simpleLevelMenu  " uid="8103" id="8103simpleLevelMenu"
						parentid="81"
						url="/CMCCAction.do?operation=cmccList&amp;schemaID=1043">
						<div showimg="true" class="simpleMenuImgDIV  " uid="8103">
							<img class="simpleLevelMenuImg" id="8103SimpleUrlImgOn"
								src="/static/images/16x16/projectProposalAdmin_.png"
								style="display:"> <img class="simpleLevelMenuImg"
								id="8103SimpleUrlImgOff"
								src="/static/images/16x16/projectProposalAdmin__on.png"
								style="display: none">
						</div>
						<div class="simpleLevelMenuChildren onlyOne "
							name="level2Container" id="8103simpleLevelMenuChildren">

							<div class="level2SimpleOnly" level="1" uid="8103"
								id="8103SimpleMenuDIVSpan" childsize="0"
								url="/CMCCAction.do?operation=cmccList&amp;schemaID=1043">
								<div>CAPEX需求</div>
							</div>

						</div>
					</div>

					<div class="simpleLevelMenu  " uid="8102" id="8102simpleLevelMenu"
						parentid="81"
						url="/CMCCAction.do?operation=cmccList&amp;schemaID=1029">
						<div showimg="true" class="simpleMenuImgDIV  " uid="8102">
							<img class="simpleLevelMenuImg" id="8102SimpleUrlImgOn"
								src="/static/images/16x16/projectProposalAdmin_.png"
								style="display:"> <img class="simpleLevelMenuImg"
								id="8102SimpleUrlImgOff"
								src="/static/images/16x16/projectProposalAdmin__on.png"
								style="display: none">
						</div>
						<div class="simpleLevelMenuChildren onlyOne "
							name="level2Container" id="8102simpleLevelMenuChildren">

							<div class="level2SimpleOnly" level="1" uid="8102"
								id="8102SimpleMenuDIVSpan" childsize="0"
								url="/CMCCAction.do?operation=cmccList&amp;schemaID=1029">
								<div>CAPEX项</div>
							</div>

						</div>
					</div>

					<div class="simpleLevelMenu  " uid="6617" id="6617simpleLevelMenu"
						parentid="81"
						url="/CMCCAction.do?operation=cmccList&amp;&amp;schemaID=1079">
						<div showimg="true" class="simpleMenuImgDIV  " uid="6617">
							<img class="simpleLevelMenuImg" id="6617SimpleUrlImgOn"
								src="/static/images/16x16/expense_info_template_.png"
								style="display:"> <img class="simpleLevelMenuImg"
								id="6617SimpleUrlImgOff"
								src="/static/images/16x16/expense_info_template__on.png"
								style="display: none">
						</div>
						<div class="simpleLevelMenuChildren onlyOne "
							name="level2Container" id="6617simpleLevelMenuChildren">

							<div class="level2SimpleOnly" level="1" uid="6617"
								id="6617SimpleMenuDIVSpan" childsize="0"
								url="/CMCCAction.do?operation=cmccList&amp;&amp;schemaID=1079">
								<div>CAPEX项与投资计划</div>
							</div>

						</div>
					</div>

					<div class="simpleLevelMenu  " uid="8105" id="8105simpleLevelMenu"
						parentid="81"
						url="/CMCCAction.do?operation=cmccList&amp;schemaID=1044">
						<div showimg="true" class="simpleMenuImgDIV  " uid="8105">
							<img class="simpleLevelMenuImg" id="8105SimpleUrlImgOn"
								src="/static/images/16x16/projectProposalAdmin_.png"
								style="display:"> <img class="simpleLevelMenuImg"
								id="8105SimpleUrlImgOff"
								src="/static/images/16x16/projectProposalAdmin__on.png"
								style="display: none">
						</div>
						<div class="simpleLevelMenuChildren onlyOne "
							name="level2Container" id="8105simpleLevelMenuChildren">

							<div class="level2SimpleOnly" level="1" uid="8105"
								id="8105SimpleMenuDIVSpan" childsize="0"
								url="/CMCCAction.do?operation=cmccList&amp;schemaID=1044">
								<div>CAPEX资本开支计划</div>
							</div>

						</div>
					</div>

					<div class="simpleLevelMenu  " uid="8104" id="8104simpleLevelMenu"
						parentid="81"
						url="/CMCCAction.do?operation=cmccList&amp;schemaID=1046">
						<div showimg="true" class="simpleMenuImgDIV  " uid="8104">
							<img class="simpleLevelMenuImg" id="8104SimpleUrlImgOn"
								src="/static/images/16x16/projectProposalAdmin_.png"
								style="display:"> <img class="simpleLevelMenuImg"
								id="8104SimpleUrlImgOff"
								src="/static/images/16x16/projectProposalAdmin__on.png"
								style="display: none">
						</div>
						<div class="simpleLevelMenuChildren onlyOne "
							name="level2Container" id="8104simpleLevelMenuChildren">

							<div class="level2SimpleOnly" level="1" uid="8104"
								id="8104SimpleMenuDIVSpan" childsize="0"
								url="/CMCCAction.do?operation=cmccList&amp;schemaID=1046">
								<div>CAPEX转资计划</div>
							</div>

						</div>
					</div>

					<div class="simpleLevelMenu  " uid="8108" id="8108simpleLevelMenu"
						parentid="81"
						url="/CMCCAction.do?operation=cmccList&amp;schemaID=1073">
						<div showimg="true" class="simpleMenuImgDIV  " uid="8108">
							<img class="simpleLevelMenuImg" id="8108SimpleUrlImgOn"
								src="/static/images/16x16/projectProposalAdmin_.png"
								style="display:"> <img class="simpleLevelMenuImg"
								id="8108SimpleUrlImgOff"
								src="/static/images/16x16/projectProposalAdmin__on.png"
								style="display: none">
						</div>
						<div class="simpleLevelMenuChildren onlyOne "
							name="level2Container" id="8108simpleLevelMenuChildren">

							<div class="level2SimpleOnly" level="1" uid="8108"
								id="8108SimpleMenuDIVSpan" childsize="0"
								url="/CMCCAction.do?operation=cmccList&amp;schemaID=1073">
								<div>投资计划总额信息管理</div>
							</div>

						</div>
					</div>

					<div id="simpleContainer2">

						<div
							style="border-top: 1px solid #BAC4CC; height: 36px; position: relative; cursor: pointer;"
							onclick="toggleLeft();">
							<div id="leftMenu_splitClose" class=" split_close"></div>
						</div>
					</div>
				</div>

			</div>

		</div>


		<script type="text/javascript">
		window.toogle_close_flag=false;
	</script>
		<div class="content-wrap" id="bodyStart__content_Wrap">
			<div class="content-empty"></div>
			<div class="newTitleDIV">
				<script type="text/javascript">
	function goVersion(versionNo){
		document.frm.versionNo.value=versionNo;
		revertFun();
		etSubmit(document.frm);
	}
	function showBaselineMenuFun(targetObj){
		var baselineMenu=new Array;
		baselineMenu.id="baseLineMenu";
		var arry=baselineMenu.items=[];
		var item={
			type:'item'	
			,"function":'goVersion(0)'
			,'label':"当前版本"
		};
		arry.push(item);
		
			item={
				type:'item'	
				,"function":'goVersion(1)'
				,'label':"基线1(2017-01-16)"
			};
			arry.push(item);
		
		
		popupMenu(targetObj,baselineMenu,"",true);
	}
</script>
				<style type="text/css">
.textTitleDIV {
	display: inline-block;
	width: 100px;
	height: 28px;
	font-size: 12px;
	position: relative;
	top: 7px;
}
</style>
				<div class="textTitleDIV">
					<table class="toolbarTable" cellspacing="0" cellpadding="0">
						<tbody>
							<tr>
								<td id="ET_ToolbarButton" class="toolbarEnable" align="center"
									nowrap=""><div
										class="ET_ToolbarButtonContainer  ET_ToolbarButtonContainerNoBackGround"
										onclick="javascript:showBaselineMenuFun(this)">
										<span id="ET_ToolbarButtonLabel" class=" labelNoImg  ">当前版本</span><span
											class="dropDowImg"><img
											src="/static/images/16x16/toolbar-dropDown.png"></span>
									</div></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="content-main">
				<form name="frm" action="/CMCCAction.do" method="post">
					<input type="hidden" name="operation" value="cmccList"> <input
						type="hidden" name="orderBy" value="a.code"> <input
						type="hidden" name="orderType" value="ASC"> <input
						type="hidden" name="schemaID" value="1031"> <input
						type="hidden" name="formID" value=""> <input type="hidden"
						name="page" value="1"> <input type="hidden"
						name="referenceID" value=""> <input type="hidden"
						name="exportID" value="538"> <input type="hidden"
						name="fields" value=""> <input type="hidden" name="type"
						value=""> <input type="hidden" name="isExport" value="">
					<input type="hidden" name="searchType" value=""> <input
						type="hidden" name="myFormType" value="myForm"> <input
						type="hidden" name="menuID" value="81"> <input
						type="hidden" name="subMenuID" value="8101"> <input
						type="hidden" name="versionNo" value="0"> <input
						type="hidden" name="isDialog" value="false">
					<div class="toolbar" id="toolbarDIV">
						<table class="toolbarTable" cellspacing="0" cellpadding="0">
							<tbody>
								<tr>
									<td id="ET_ToolbarButton" class="toolbarEnable" align="center"
										nowrap=""><div class="ET_ToolbarButtonContainer "
											onclick="showMenu(this);">
											<span class="ET_ToolbarButtonImg"><img
												src="/static/images/newui/search.png "></span><span
												id="ET_ToolbarButtonLabel" class=" labelSearch ">查询全部</span>
										</div></td>



									<td id="ET_ToolbarButton" class="toolbarEnable" align="center"
										nowrap=""><div class="ET_ToolbarButtonContainer "
											onclick="javascript:newFun();">
											<span id="ET_ToolbarButtonLabel" class=" labelNoImg  ">添加</span>
										</div></td>

									<td id="ET_ToolbarButton" class="toolbarEnable" align="center"
										nowrap=""><div class="ET_ToolbarButtonContainer"
											onclick="javascript:saveAsVersionLine();">
											<span id="ET_ToolbarButtonLabel" class=" labelNoImg  ">保存基线</span>
										</div></td>



									<td id="ET_ToolbarButton" class="toolbarEnable" align="center"
										nowrap=""><div
											class="ET_ToolbarButtonContainer  ET_ToolbarButtonContainerNoBackGround"
											onclick="javascript:compareVersionFun(this);">
											<span id="ET_ToolbarButtonLabel" class=" labelNoImg  ">基线比较</span><span
												class="dropDowImg"><img
												src="/static/images/16x16/toolbar-dropDown.png"></span>
										</div></td>


									<td width="100%"></td>
									<td id="ET_ToolbarButton" class="toolbarEnable" align="center"
										nowrap=""><div class="ET_ToolbarButtonContainer "
											onclick="javascript:showMore(this);">
											<span id="ET_ToolbarButtonLabel" class=" labelNoImg  ">更多...</span>
										</div></td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="Toolbar-spacing"></div>
					<div class="barListSplitLine"></div>
					<div style="height: 63px; overflow: hidden; position: relative;">



						<div
							style="height: 100%; overflow: auto; position: absolute; top: 0px; left: 0px; display: block; bottom: 0px; width: 100%;"
							id="formListTablebody_tbody">
							<table border="0" width="840" cellpadding="0" cellspacing="0"
								bgcolor="#FFFFFF" class="listTable dataTable" id="formListTable">
								<thead>
									<tr>
										<th><div style="width: 20px;">
												<img src="/static/images/16x16/action_open.gif" title="快速审批">
											</div></th>
										<th onclick="orderDocList(&quot;a.code&quot;);"
											style="cursor: pointer;"><div style="width: 100px;">
												投资计划编号<img class="orderByImgClass"
													src="/static/images/list/up.png" border="0">
											</div></th>
										<th onclick="orderDocList(&quot;a.str18&quot;);"
											style="cursor: pointer;"><div style="width: 200px;">投资项目集/项目名称</div></th>
										<th onclick="orderDocList(&quot;a.str01&quot;);"
											style="cursor: pointer;"><div style="width: 100px;">投资项目集/项目编码</div></th>
										<th
											onclick="orderDocList(&quot; cast(a.num02  as  decimal(18,2)) &quot;);"
											style="cursor: pointer;"><div style="width: 100px;">项目集总投资（元）</div></th>
										<th
											onclick="orderDocList(&quot; cast(a.num01  as  decimal(18,2)) &quot;);"
											style="cursor: pointer;"><div style="width: 100px;">年份</div></th>
										<th onclick="orderDocList(&quot;a.enum01&quot;);"
											style="cursor: pointer;"><div style="width: 100px;">一级专业</div></th>
										<th onclick="orderDocList(&quot;a.enum04&quot;);"
											style="cursor: pointer;"><div style="width: 100px;">属性</div></th>
									</tr>
								</thead>
								<tbody>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '421515');"></td>
										<td onclick="javascript:openForm(&quot;421515&quot;);"
											style="cursor: pointer" align="center">17000004</td>
										<td onclick="javascript:openForm(&quot;421515&quot;);"
											style="cursor: pointer">徐晓秋</td>
										<td onclick="javascript:openForm(&quot;421515&quot;);"
											style="cursor: pointer">ssss</td>
										<td onclick="javascript:openForm(&quot;421515&quot;);"
											style="cursor: pointer"></td>
										<td onclick="javascript:openForm(&quot;421515&quot;);"
											style="cursor: pointer" align="center">2017</td>
										<td onclick="javascript:openForm(&quot;421515&quot;);"
											style="cursor: pointer" align="center"></td>
										<td onclick="javascript:openForm(&quot;421515&quot;);"
											style="cursor: pointer">其他</td>
									</tr>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '316954');"></td>
										<td onclick="javascript:openForm(&quot;316954&quot;);"
											style="cursor: pointer" align="center">T14000001</td>
										<td onclick="javascript:openForm(&quot;316954&quot;);"
											style="cursor: pointer">中国移动管理信息系统集中灾备中心三期工程</td>
										<td onclick="javascript:openForm(&quot;316954&quot;);"
											style="cursor: pointer">ZQS143431004</td>
										<td onclick="javascript:openForm(&quot;316954&quot;);"
											style="cursor: pointer">7,180,000.00</td>
										<td onclick="javascript:openForm(&quot;316954&quot;);"
											style="cursor: pointer" align="center">2014</td>
										<td onclick="javascript:openForm(&quot;316954&quot;);"
											style="cursor: pointer" align="center">支撑网</td>
										<td onclick="javascript:openForm(&quot;316954&quot;);"
											style="cursor: pointer">新建</td>
									</tr>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '316955');"></td>
										<td onclick="javascript:openForm(&quot;316955&quot;);"
											style="cursor: pointer" align="center">T14000002</td>
										<td onclick="javascript:openForm(&quot;316955&quot;);"
											style="cursor: pointer">总部XBRL报表编制系统二期工程</td>
										<td onclick="javascript:openForm(&quot;316955&quot;);"
											style="cursor: pointer">ZQS143431804</td>
										<td onclick="javascript:openForm(&quot;316955&quot;);"
											style="cursor: pointer">750,000.00</td>
										<td onclick="javascript:openForm(&quot;316955&quot;);"
											style="cursor: pointer" align="center">2014</td>
										<td onclick="javascript:openForm(&quot;316955&quot;);"
											style="cursor: pointer" align="center">支撑网</td>
										<td onclick="javascript:openForm(&quot;316955&quot;);"
											style="cursor: pointer">新建</td>
									</tr>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '316956');"></td>
										<td onclick="javascript:openForm(&quot;316956&quot;);"
											style="cursor: pointer" align="center">T14000003</td>
										<td onclick="javascript:openForm(&quot;316956&quot;);"
											style="cursor: pointer">OA文档内容安全一期工程</td>
										<td onclick="javascript:openForm(&quot;316956&quot;);"
											style="cursor: pointer">ZQS143431809</td>
										<td onclick="javascript:openForm(&quot;316956&quot;);"
											style="cursor: pointer">15,040,000.00</td>
										<td onclick="javascript:openForm(&quot;316956&quot;);"
											style="cursor: pointer" align="center">2014</td>
										<td onclick="javascript:openForm(&quot;316956&quot;);"
											style="cursor: pointer" align="center">支撑网</td>
										<td onclick="javascript:openForm(&quot;316956&quot;);"
											style="cursor: pointer">新建</td>
									</tr>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '316957');"></td>
										<td onclick="javascript:openForm(&quot;316957&quot;);"
											style="cursor: pointer" align="center">T14000004</td>
										<td onclick="javascript:openForm(&quot;316957&quot;);"
											style="cursor: pointer">“营改增”二阶段项目财务集中管理系统建设</td>
										<td onclick="javascript:openForm(&quot;316957&quot;);"
											style="cursor: pointer">ZQS143432803</td>
										<td onclick="javascript:openForm(&quot;316957&quot;);"
											style="cursor: pointer">6,110,000.00</td>
										<td onclick="javascript:openForm(&quot;316957&quot;);"
											style="cursor: pointer" align="center">2014</td>
										<td onclick="javascript:openForm(&quot;316957&quot;);"
											style="cursor: pointer" align="center">支撑网</td>
										<td onclick="javascript:openForm(&quot;316957&quot;);"
											style="cursor: pointer">新建</td>
									</tr>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '316958');"></td>
										<td onclick="javascript:openForm(&quot;316958&quot;);"
											style="cursor: pointer" align="center">T14000005</td>
										<td onclick="javascript:openForm(&quot;316958&quot;);"
											style="cursor: pointer">总部财务集中管理三期项目建设</td>
										<td onclick="javascript:openForm(&quot;316958&quot;);"
											style="cursor: pointer">ZQS143432804</td>
										<td onclick="javascript:openForm(&quot;316958&quot;);"
											style="cursor: pointer">5,640,000.00</td>
										<td onclick="javascript:openForm(&quot;316958&quot;);"
											style="cursor: pointer" align="center">2014</td>
										<td onclick="javascript:openForm(&quot;316958&quot;);"
											style="cursor: pointer" align="center">支撑网</td>
										<td onclick="javascript:openForm(&quot;316958&quot;);"
											style="cursor: pointer">新建</td>
									</tr>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '316872');"></td>
										<td onclick="javascript:openForm(&quot;316872&quot;);"
											style="cursor: pointer" align="center">T14000006</td>
										<td onclick="javascript:openForm(&quot;316872&quot;);"
											style="cursor: pointer">政企客户分公司业务体验厅建设项目</td>
										<td onclick="javascript:openForm(&quot;316872&quot;);"
											style="cursor: pointer">ZQS143512005</td>
										<td onclick="javascript:openForm(&quot;316872&quot;);"
											style="cursor: pointer">8,000,000.00</td>
										<td onclick="javascript:openForm(&quot;316872&quot;);"
											style="cursor: pointer" align="center">2014</td>
										<td onclick="javascript:openForm(&quot;316872&quot;);"
											style="cursor: pointer" align="center">局房土建及动力配套</td>
										<td onclick="javascript:openForm(&quot;316872&quot;);"
											style="cursor: pointer">新建</td>
									</tr>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '316875');"></td>
										<td onclick="javascript:openForm(&quot;316875&quot;);"
											style="cursor: pointer" align="center">T14000007</td>
										<td onclick="javascript:openForm(&quot;316875&quot;);"
											style="cursor: pointer">中国移动国际信息港集装箱式机房二期工程</td>
										<td onclick="javascript:openForm(&quot;316875&quot;);"
											style="cursor: pointer">ZQS143564012</td>
										<td onclick="javascript:openForm(&quot;316875&quot;);"
											style="cursor: pointer">8,680,000.00</td>
										<td onclick="javascript:openForm(&quot;316875&quot;);"
											style="cursor: pointer" align="center">2014</td>
										<td onclick="javascript:openForm(&quot;316875&quot;);"
											style="cursor: pointer" align="center">局房土建及动力配套</td>
										<td onclick="javascript:openForm(&quot;316875&quot;);"
											style="cursor: pointer">新建</td>
									</tr>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '316877');"></td>
										<td onclick="javascript:openForm(&quot;316877&quot;);"
											style="cursor: pointer" align="center">T14000008</td>
										<td onclick="javascript:openForm(&quot;316877&quot;);"
											style="cursor: pointer">自主安排投资</td>
										<td onclick="javascript:openForm(&quot;316877&quot;);"
											style="cursor: pointer">ZQS143631003</td>
										<td onclick="javascript:openForm(&quot;316877&quot;);"
											style="cursor: pointer">104,410,000.00</td>
										<td onclick="javascript:openForm(&quot;316877&quot;);"
											style="cursor: pointer" align="center">2014</td>
										<td onclick="javascript:openForm(&quot;316877&quot;);"
											style="cursor: pointer" align="center">其他</td>
										<td onclick="javascript:openForm(&quot;316877&quot;);"
											style="cursor: pointer">新建</td>
									</tr>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '316959');"></td>
										<td onclick="javascript:openForm(&quot;316959&quot;);"
											style="cursor: pointer" align="center">T14000009</td>
										<td onclick="javascript:openForm(&quot;316959&quot;);"
											style="cursor: pointer">业务数据交换与组件支撑平台一期</td>
										<td onclick="javascript:openForm(&quot;316959&quot;);"
											style="cursor: pointer">ZQS143431808</td>
										<td onclick="javascript:openForm(&quot;316959&quot;);"
											style="cursor: pointer">6,770,000.00</td>
										<td onclick="javascript:openForm(&quot;316959&quot;);"
											style="cursor: pointer" align="center">2014</td>
										<td onclick="javascript:openForm(&quot;316959&quot;);"
											style="cursor: pointer" align="center">支撑网</td>
										<td onclick="javascript:openForm(&quot;316959&quot;);"
											style="cursor: pointer">新建</td>
									</tr>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '316960');"></td>
										<td onclick="javascript:openForm(&quot;316960&quot;);"
											style="cursor: pointer" align="center">T14000010</td>
										<td onclick="javascript:openForm(&quot;316960&quot;);"
											style="cursor: pointer">中国移动资金管理系统一期工程</td>
										<td onclick="javascript:openForm(&quot;316960&quot;);"
											style="cursor: pointer">ZQS143432800</td>
										<td onclick="javascript:openForm(&quot;316960&quot;);"
											style="cursor: pointer">37,600,000.00</td>
										<td onclick="javascript:openForm(&quot;316960&quot;);"
											style="cursor: pointer" align="center">2014</td>
										<td onclick="javascript:openForm(&quot;316960&quot;);"
											style="cursor: pointer" align="center">支撑网</td>
										<td onclick="javascript:openForm(&quot;316960&quot;);"
											style="cursor: pointer">新建</td>
									</tr>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '316961');"></td>
										<td onclick="javascript:openForm(&quot;316961&quot;);"
											style="cursor: pointer" align="center">T14000011</td>
										<td onclick="javascript:openForm(&quot;316961&quot;);"
											style="cursor: pointer">内控内审管理系统三期工程</td>
										<td onclick="javascript:openForm(&quot;316961&quot;);"
											style="cursor: pointer">ZQS143434801</td>
										<td onclick="javascript:openForm(&quot;316961&quot;);"
											style="cursor: pointer">8,120,000.00</td>
										<td onclick="javascript:openForm(&quot;316961&quot;);"
											style="cursor: pointer" align="center">2014</td>
										<td onclick="javascript:openForm(&quot;316961&quot;);"
											style="cursor: pointer" align="center">支撑网</td>
										<td onclick="javascript:openForm(&quot;316961&quot;);"
											style="cursor: pointer">新建</td>
									</tr>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '316962');"></td>
										<td onclick="javascript:openForm(&quot;316962&quot;);"
											style="cursor: pointer" align="center">T14000012</td>
										<td onclick="javascript:openForm(&quot;316962&quot;);"
											style="cursor: pointer">内控内审管理系统四期工程（纪检系统）</td>
										<td onclick="javascript:openForm(&quot;316962&quot;);"
											style="cursor: pointer">ZQS143434802</td>
										<td onclick="javascript:openForm(&quot;316962&quot;);"
											style="cursor: pointer">7,520,000.00</td>
										<td onclick="javascript:openForm(&quot;316962&quot;);"
											style="cursor: pointer" align="center">2014</td>
										<td onclick="javascript:openForm(&quot;316962&quot;);"
											style="cursor: pointer" align="center">支撑网</td>
										<td onclick="javascript:openForm(&quot;316962&quot;);"
											style="cursor: pointer">新建</td>
									</tr>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '316963');"></td>
										<td onclick="javascript:openForm(&quot;316963&quot;);"
											style="cursor: pointer" align="center">T14000013</td>
										<td onclick="javascript:openForm(&quot;316963&quot;);"
											style="cursor: pointer">总部AB座一卡通改造</td>
										<td onclick="javascript:openForm(&quot;316963&quot;);"
											style="cursor: pointer">ZQS143551801</td>
										<td onclick="javascript:openForm(&quot;316963&quot;);"
											style="cursor: pointer">8,280,000.00</td>
										<td onclick="javascript:openForm(&quot;316963&quot;);"
											style="cursor: pointer" align="center">2014</td>
										<td onclick="javascript:openForm(&quot;316963&quot;);"
											style="cursor: pointer" align="center">局房土建及动力配套</td>
										<td onclick="javascript:openForm(&quot;316963&quot;);"
											style="cursor: pointer">新建</td>
									</tr>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '316867');"></td>
										<td onclick="javascript:openForm(&quot;316867&quot;);"
											style="cursor: pointer" align="center">T14000014</td>
										<td onclick="javascript:openForm(&quot;316867&quot;);"
											style="cursor: pointer">中国移动IDC运营管理平台二期工程</td>
										<td onclick="javascript:openForm(&quot;316867&quot;);"
											style="cursor: pointer">ZQS143341004</td>
										<td onclick="javascript:openForm(&quot;316867&quot;);"
											style="cursor: pointer">9,080,000.00</td>
										<td onclick="javascript:openForm(&quot;316867&quot;);"
											style="cursor: pointer" align="center">2014</td>
										<td onclick="javascript:openForm(&quot;316867&quot;);"
											style="cursor: pointer" align="center">业务网</td>
										<td onclick="javascript:openForm(&quot;316867&quot;);"
											style="cursor: pointer">新建</td>
									</tr>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '316859');"></td>
										<td onclick="javascript:openForm(&quot;316859&quot;);"
											style="cursor: pointer" align="center">T14000015</td>
										<td onclick="javascript:openForm(&quot;316859&quot;);"
											style="cursor: pointer">中国移动全网一卡通业务运营平台一期工程</td>
										<td onclick="javascript:openForm(&quot;316859&quot;);"
											style="cursor: pointer">ZQS143313018</td>
										<td onclick="javascript:openForm(&quot;316859&quot;);"
											style="cursor: pointer">3,630,000.00</td>
										<td onclick="javascript:openForm(&quot;316859&quot;);"
											style="cursor: pointer" align="center">2014</td>
										<td onclick="javascript:openForm(&quot;316859&quot;);"
											style="cursor: pointer" align="center">业务网</td>
										<td onclick="javascript:openForm(&quot;316859&quot;);"
											style="cursor: pointer">新建</td>
									</tr>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '316964');"></td>
										<td onclick="javascript:openForm(&quot;316964&quot;);"
											style="cursor: pointer" align="center">T14000016</td>
										<td onclick="javascript:openForm(&quot;316964&quot;);"
											style="cursor: pointer">中国移动综合信息网四期工程</td>
										<td onclick="javascript:openForm(&quot;316964&quot;);"
											style="cursor: pointer">ZQS143431001</td>
										<td onclick="javascript:openForm(&quot;316964&quot;);"
											style="cursor: pointer">7,360,000.00</td>
										<td onclick="javascript:openForm(&quot;316964&quot;);"
											style="cursor: pointer" align="center">2014</td>
										<td onclick="javascript:openForm(&quot;316964&quot;);"
											style="cursor: pointer" align="center">支撑网</td>
										<td onclick="javascript:openForm(&quot;316964&quot;);"
											style="cursor: pointer">新建</td>
									</tr>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '316965');"></td>
										<td onclick="javascript:openForm(&quot;316965&quot;);"
											style="cursor: pointer" align="center">T14000017</td>
										<td onclick="javascript:openForm(&quot;316965&quot;);"
											style="cursor: pointer">总部安全加固工程</td>
										<td onclick="javascript:openForm(&quot;316965&quot;);"
											style="cursor: pointer">ZQS143431802</td>
										<td onclick="javascript:openForm(&quot;316965&quot;);"
											style="cursor: pointer">4,510,000.00</td>
										<td onclick="javascript:openForm(&quot;316965&quot;);"
											style="cursor: pointer" align="center">2014</td>
										<td onclick="javascript:openForm(&quot;316965&quot;);"
											style="cursor: pointer" align="center">支撑网</td>
										<td onclick="javascript:openForm(&quot;316965&quot;);"
											style="cursor: pointer">新建</td>
									</tr>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '316966');"></td>
										<td onclick="javascript:openForm(&quot;316966&quot;);"
											style="cursor: pointer" align="center">T14000018</td>
										<td onclick="javascript:openForm(&quot;316966&quot;);"
											style="cursor: pointer">中国移动企业级移动应用集中化服务平台一期工程</td>
										<td onclick="javascript:openForm(&quot;316966&quot;);"
											style="cursor: pointer">ZQS143431806</td>
										<td onclick="javascript:openForm(&quot;316966&quot;);"
											style="cursor: pointer">15,020,000.00</td>
										<td onclick="javascript:openForm(&quot;316966&quot;);"
											style="cursor: pointer" align="center">2014</td>
										<td onclick="javascript:openForm(&quot;316966&quot;);"
											style="cursor: pointer" align="center">支撑网</td>
										<td onclick="javascript:openForm(&quot;316966&quot;);"
											style="cursor: pointer">新建</td>
									</tr>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '316967');"></td>
										<td onclick="javascript:openForm(&quot;316967&quot;);"
											style="cursor: pointer" align="center">T14000019</td>
										<td onclick="javascript:openForm(&quot;316967&quot;);"
											style="cursor: pointer">中国移动管理信息系统支撑网测试平台二期工程</td>
										<td onclick="javascript:openForm(&quot;316967&quot;);"
											style="cursor: pointer">ZQS143431810</td>
										<td onclick="javascript:openForm(&quot;316967&quot;);"
											style="cursor: pointer">3,760,000.00</td>
										<td onclick="javascript:openForm(&quot;316967&quot;);"
											style="cursor: pointer" align="center">2014</td>
										<td onclick="javascript:openForm(&quot;316967&quot;);"
											style="cursor: pointer" align="center">支撑网</td>
										<td onclick="javascript:openForm(&quot;316967&quot;);"
											style="cursor: pointer">新建</td>
									</tr>
								</tbody>
							</table>
						</div>
						<div
							style="height: auto; overflow: hidden; position: absolute; display: block; bottom: auto; left: 0px; top: 0px; width: 1692px;"
							id="formListTablebody_theadContainer">
							<table border="0" width="840" cellpadding="0" cellspacing="0"
								bgcolor="#FFFFFF" class="listTable dataTable"
								id="formListTablebody_theadTable" style="width: 840px;">
								<thead>
									<tr>
										<th><div style="width: 20px;">
												<img src="/static/images/16x16/action_open.gif" title="快速审批">
											</div></th>
										<th onclick="orderDocList(&quot;a.code&quot;);"
											style="cursor: pointer;"><div style="width: 100px;">
												投资计划编号<img class="orderByImgClass"
													src="/static/images/list/up.png" border="0">
											</div></th>
										<th onclick="orderDocList(&quot;a.str18&quot;);"
											style="cursor: pointer;"><div style="width: 212px;">投资项目集/项目名称</div></th>
										<th onclick="orderDocList(&quot;a.str01&quot;);"
											style="cursor: pointer;"><div style="width: 100px;">投资项目集/项目编码</div></th>
										<th
											onclick="orderDocList(&quot; cast(a.num02  as  decimal(18,2)) &quot;);"
											style="cursor: pointer;"><div style="width: 100px;">项目集总投资（元）</div></th>
										<th
											onclick="orderDocList(&quot; cast(a.num01  as  decimal(18,2)) &quot;);"
											style="cursor: pointer;"><div style="width: 100px;">年份</div></th>
										<th onclick="orderDocList(&quot;a.enum01&quot;);"
											style="cursor: pointer;"><div style="width: 100px;">一级专业</div></th>
										<th onclick="orderDocList(&quot;a.enum04&quot;);"
											style="cursor: pointer;"><div style="width: 100px;">属性</div></th>
									</tr>
								</thead>
							</table>
						</div>
					</div>
					<script type="text/javascript">function changePage (page) {document.frm.page.value=page;document.frm.submit();}</script>
					<div class="pageFooter" id="pageToolbarDIV">
						<span><a class="pageToolBarLink page_first "> <img
								src="/static/images/16x16/arrow_first_disable.png" border="0"></a><a
							class="pageToolBarLink page_prev"><img
								src="/static/images/16x16/arrow_prev_disable.png" border="0"></a><select
							name="pageNo" onchange="changePage(this.value);"><option
									value="1" selected="">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
								<option value="11">11</option>
								<option value="12">12</option>
								<option value="13">13</option>
								<option value="14">14</option>
								<option value="15">15</option>
								<option value="16">16</option>
								<option value="17">17</option>
								<option value="18">18</option>
								<option value="19">19</option>
								<option value="20">20</option>
								<option value="21">21</option></select>
							<div class="pageCount">/21页</div> <a
							class="pageToolBarLink page_next"
							href="javascript:changePage('2');"><img
								src="/static/images/16x16/arrow_next.png"
								overimg="/static/images/16x16/arrow_next_over.png" border="0"></a><a
							class="pageToolBarLink page_end"
							href="javascript:changePage('21');"><img
								src="/static/images/16x16/arrow_last.png"
								overimg="/static/images/16x16/arrow_last_over.png" border="0"></a></span><span
							class="pageText">共404条</span>
					</div>
				</form>
				<script type="text/javascript">
	window['formListTable']=new EasyTrack.DataTable("formListTable",{
		need_alignTableHead:true
	});	ET.addToggleLeftEvent(function(){	
		window['formListTable'].resize(true);
	});
	
</script>
			</div>
		</div>
	</div>
	<div style="display: none;">
		<img src="/static/images/16x16/empty.png" id="checkbox_img_clonenode"
			onclick="checkboxIMG_clickFun(this,event)"
			onmouseover="checkboxIMG_onmouseover(this)"
			onmouseout="checkboxIMG_onmouseout(this)">
	</div>
	<div id="floatDIV" class="floatDIV" style="width: 200px; height: 180px"
		onclick="floatController.bShow=true"></div>
	<div id="coverDIV" class="coverDIV"></div>
</body>
</html>