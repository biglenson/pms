<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<script type="text/javascript"
	src="/static/js/firefox/FloatAndDialog.js"></script>
<script type="text/javascript"
	src="/static/js/jquery/jquery-1.12.0.min.js"></script>
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