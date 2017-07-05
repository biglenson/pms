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
<link href="/static/css/style_admin.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript" src="/static/js/firefox/et.js"></script>
<script type="text/javascript"
	src="/static/js/firefox/FloatAndDialog.js"></script>
<script type="text/javascript"
	src="/static/js/jquery/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="/static/js/lable_message.js"></script>
<script type="text/javascript">
	ET.current_app_ID=3; //保存当前的appID ,在弹出框的时候 ，模板中自动加载特殊的css 
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


<script type="text/javascript" src="/static/js/firefox/DataTableAll.js"></script>
<script type="text/javascript"
	src="/static/js/webuploader/webuploader.min.js"></script>


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
	var height = parseInt("3");
	height = height * 30 + 190;
	if(height < 300) height = 400;
	if(height > 700) height = 700;
	var arg = new Array();
	arg.src = "/pm/SimpleFormAction.do?operation=search&type=0&schemaID="+document.frm.schemaID.value+"&height="+height+"&_id="+Math.random();
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
		arg.src = "/pm/SimpleFormAction.do?operation=new&type=1&schemaID=1080&referenceID=0"+"&_id="+Math.random();
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
	arg.src = "/pm/SimpleFormAction.do?operation=open&type=1&formID="+id+"&schemaID="+document.frm.schemaID.value+"&_id="+Math.random();
	arg.src+="&versionNo="+document.frm.versionNo.value
	arg.title = "部门";
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
	arg.src = "/pm/ExportExcelAction.do?operation=dialog&exportID=538&schemaID="+document.frm.schemaID.value+"&_id=" + Math.random();
	arg.title = "导出";
	arg.theme="search";
	arg.width = 440;
	arg.height =340;
	top.ET.showModalWindow(arg, function (ret) { 
		if(typeof ret!="undefined"){
			document.frm.isExport.value="true";
			document.frm.action="/pm/CMCCAction.do";
			document.frm.operation.value="cmccExport";
			document.frm.fields.value=ret;
			document.frm.submit();
			revertFun();
		}
	});
}

function revertFun(){
	document.frm.action="/pm/CMCCAction.do";
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
	document.frm.action.value="/pm/CMCCAction.do";
	document.frm.operation.value="downLoadExportLog";
	document.frm.submit();
	
}
function importExcelFun(){
	var arg = new Array();
	arg.src = "/pm/ExcelImportFormAction.do?operation=excelImportFormNew&schemaID="+document.frm.schemaID.value+"&referenceID=" +document.frm.referenceID.value+"&_id=" + Math.random();
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
			schemaID:1080
		},function(ret){
			revertFun();
			etSubmit(document.frm);
		})
	}
}

function compareFeeVersionFun(){
	var arg = new Array();
	arg.src = "/pm/CMCCAction.do?operation=compareFeeList&schemaID="+document.frm.schemaID.value+"&referenceID=" +document.frm.referenceID.value+"&_id=" + Math.random();
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
			,"function":'compareVersion(2017)'
			,'label':"2017年度部门"
		};
		arry.push(item);
	
		item={
			type:'item'	
			,"function":'compareVersion(2016)'
			,'label':"2016年度部门"
		};
		arry.push(item);
	
		item={
			type:'item'	
			,"function":'compareVersion(2015)'
			,'label':"2015年度部门"
		};
		arry.push(item);
	
		item={
			type:'item'	
			,"function":'compareVersion(2014)'
			,'label':"2014年度部门"
		};
		arry.push(item);
	
  popupMenu(targetObj,baselineMenu,"",true);
}
function compareVersion(compareVersion){
	var arg = new Array();
	arg.src = "/pm/CMCCAction.do?operation=compareList&schemaID="+document.frm.schemaID.value+"&referenceID=" +document.frm.referenceID.value+"&_id=" + Math.random();
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
	arg.src = "/pm/CMCCAction.do?operation=toCheckIn&schemaID=1080&objectID="+objectID+"&_id="+Math.random();
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
	arg.src = "/pm/CMCCAction.do?operation=deleteMoreForm&schemaID="+document.frm.schemaID.value+"&referenceID=" +document.frm.referenceID.value+"&_id=" + Math.random();
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
	arg.src = "/pm/SimpleFormAction.do?operation=edit&type=1&formID="+id+"&schemaID="+document.frm.schemaID.value+"&_id="+Math.random();
	arg.title = "部门";
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
	arg.src = "/pm/SimpleFormAction.do?operation=transfer&schemaID="+document.frm.schemaID.value+"&formID="+id+"&_id=" + Math.random();
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
	arg.src = "/pm/SimpleFormAction.do?operation=selectProject&action=copy&referenceID=" + referenceID + "&schemaID="+document.frm.schemaID.value+"&formID="+id+"&_id="+Math.random();
	arg.title = "选择项目";
	arg.width = 720;
	arg.theme="search";
	arg.height =360;
	ET.showModalWindow(arg, function (ret) { 
		if(ret != null && ret != "0"){
			arg = new Array();
			arg.src = "/pm/SimpleFormAction.do?operation=copy&action=copy&referenceID=" + ret + "&schemaID="+document.frm.schemaID.value+"&formID="+id+"&_id="+Math.random();
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
	arg.src = "/pm/SimpleFormAction.do?operation=selectProject&action=move&referenceID=" + referenceID+ "&schemaID="+document.frm.schemaID.value+"&formID="+id+"&_id="+Math.random();
	arg.title = "选择项目";
	arg.width = 720;
	arg.theme="search";
	arg.height =360;
	ET.showModalWindow(arg, function (ret) { 
		if(ret != null && ret != "0"){
			arg = new Array();
			arg.src = "/pm/SimpleFormAction.do?operation=move&action=copy&referenceID=" + ret + "&schemaID="+document.frm.schemaID.value+"&formID="+id+"&_id="+Math.random();
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
				arg.src = "/pm/SimpleFormAction.do?operation=changeStatus&actionID=" + actionID+"&schemaID="+document.frm.schemaID.value+"&formID="+id+"&status="+status+"&actionType=1&_id=" + Math.random();
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
				arg.src = "/pm/SimpleFormAction.do?operation=changeStatus&actionID=" + actionID+"&schemaID="+document.frm.schemaID.value+"&formID="+id+"&status="+status+"&actionType=1&_id=" + Math.random();
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
}</script>
</head>
<body>
	<%-- 输出系统顶级模块的菜单 --%>
	<jsp:include page="../../common/TopMenu.jsp">
		<jsp:param name="appid" value="3" />
	</jsp:include>
	<div class="container  " id="bodyStart_container">
		<div class="leftAllDIV  null" id="bodyLeftAllDIV">
			<div class="leftsidebar null" id="bodyStart_leftsidebar">
				<div class="sidebar" id="bodyStart__menuDIV">
					<div id="defaultLeftMenuDIV"
						style="position: absolute; top: 0px; bottom: 37px; width: 100%; overflow: hidden;"
						class=" dumascroll">
						<div class="dumascroll_area">
							<div uid="6801" id="6801MenuDIVSpan" parentid="68" level="1"
								childsize="0"
								url="/CMCCAction.do?operation=cmccList&amp;&amp;schemaID=1080"
								class="menuDIV menuLevel1 menuSelected " style="display:">
								<img id="6801urlImgOn" class="sidebarimg"
									src="/static/images/16x16/structure_.png" style="display: none"><img
									id="6801urlImgOff" class="sidebarimg"
									src="/static/images/16x16/structure__on.png" style="display:">部门

							</div>

							<div uid="6802" id="6802MenuDIVSpan" parentid="68" level="1"
								childsize="0" url="/UserAction.do?operation=userList"
								class="menuDIV menuLevel1  " style="display:">
								<img id="6802urlImgOn" class="sidebarimg"
									src="/static/images/16x16/person_.png" style=""><img
									id="6802urlImgOff" class="sidebarimg"
									src="/static/images/16x16/person__on.png"
									style="display: none;">用户

							</div>

							<div uid="6803" id="6803MenuDIVSpan" parentid="68" level="1"
								childsize="0" url="/CMCCAction.do?operation=departFun"
								class="menuDIV menuLevel1  " style="display:">
								<img id="6803urlImgOn" class="sidebarimg"
									src="/static/images/16x16/policy_.png" style="display:"><img
									id="6803urlImgOff" class="sidebarimg"
									src="/static/images/16x16/policy__on.png" style="display: none">数据权限

							</div>


						</div>
						<div class="dumascroll_barY" style="display: none;">
							<div class="dumascroll_arrow_up"></div>
							<div class="dumascroll_handleY"></div>
							<div class="dumascroll_arrow_down"></div>
						</div>
						<div class="dumascroll_barX" style="display: none;">
							<div class="dumascroll_arrow_left"></div>
							<div class="dumascroll_handleX"></div>
							<div class="dumascroll_arrow_right"></div>
						</div>
						<div class="duma_rightButtom"></div>
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

					<div class="simpleLevelMenu  menuSelected" uid="6801"
						id="6801simpleLevelMenu" parentid="68"
						url="/CMCCAction.do?operation=cmccList&amp;&amp;schemaID=1080">
						<div showimg="true" class="simpleMenuImgDIV  menuSelected"
							uid="6801">
							<img class="simpleLevelMenuImg" id="6801SimpleUrlImgOn"
								src="/static/images/16x16/structure_.png" style="display: none">
							<img class="simpleLevelMenuImg" id="6801SimpleUrlImgOff"
								src="/static/images/16x16/structure__on.png" style="display:">
						</div>
						<div class="simpleLevelMenuChildren onlyOne "
							name="level2Container" id="6801simpleLevelMenuChildren">

							<div class="level2SimpleOnly" level="1" uid="6801"
								id="6801SimpleMenuDIVSpan" childsize="0"
								url="/CMCCAction.do?operation=cmccList&amp;&amp;schemaID=1080">
								<div>部门</div>
							</div>

						</div>
					</div>

					<div class="simpleLevelMenu  " uid="6802" id="6802simpleLevelMenu"
						parentid="68" url="/UserAction.do?operation=userList">
						<div showimg="true" class="simpleMenuImgDIV  " uid="6802">
							<img class="simpleLevelMenuImg" id="6802SimpleUrlImgOn"
								src="/static/images/16x16/person_.png" style="display:"> <img
								class="simpleLevelMenuImg" id="6802SimpleUrlImgOff"
								src="/static/images/16x16/person__on.png" style="display: none">
						</div>
						<div class="simpleLevelMenuChildren onlyOne "
							name="level2Container" id="6802simpleLevelMenuChildren">

							<div class="level2SimpleOnly" level="1" uid="6802"
								id="6802SimpleMenuDIVSpan" childsize="0"
								url="/UserAction.do?operation=userList">
								<div>用户</div>
							</div>

						</div>
					</div>

					<div class="simpleLevelMenu  " uid="6803" id="6803simpleLevelMenu"
						parentid="68" url="/CMCCAction.do?operation=departFun">
						<div showimg="true" class="simpleMenuImgDIV  " uid="6803">
							<img class="simpleLevelMenuImg" id="6803SimpleUrlImgOn"
								src="/static/images/16x16/policy_.png" style="display:"> <img
								class="simpleLevelMenuImg" id="6803SimpleUrlImgOff"
								src="/static/images/16x16/policy__on.png" style="display: none">
						</div>
						<div class="simpleLevelMenuChildren onlyOne "
							name="level2Container" id="6803simpleLevelMenuChildren">

							<div class="level2SimpleOnly" level="1" uid="6803"
								id="6803SimpleMenuDIVSpan" childsize="0"
								url="/CMCCAction.do?operation=departFun">
								<div>数据权限</div>
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
				部门
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
				,"function":'goVersion(2017)'
				,'label':"2017年度部门"
			};
			arry.push(item);
		
			item={
				type:'item'	
				,"function":'goVersion(2016)'
				,'label':"2016年度部门"
			};
			arry.push(item);
		
			item={
				type:'item'	
				,"function":'goVersion(2015)'
				,'label':"2015年度部门"
			};
			arry.push(item);
		
			item={
				type:'item'	
				,"function":'goVersion(2014)'
				,'label':"2014年度部门"
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
				<form name="frm" action="/pm/CMCCAction.do" method="post">
					<input type="hidden" name="operation" value="cmccList"> <input
						type="hidden" name="orderBy" value="a.enum02"> <input
						type="hidden" name="orderType" value="ASC"> <input
						type="hidden" name="schemaID" value="1080"> <input
						type="hidden" name="formID" value=""> <input type="hidden"
						name="page" value="1"> <input type="hidden"
						name="referenceID" value=""> <input type="hidden"
						name="exportID" value="538"> <input type="hidden"
						name="fields" value=""> <input type="hidden" name="type"
						value=""> <input type="hidden" name="isExport" value="">
					<input type="hidden" name="searchType" value=""> <input
						type="hidden" name="myFormType" value="myForm"> <input
						type="hidden" name="menuID" value="68"> <input
						type="hidden" name="subMenuID" value="6801"> <input
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
										nowrap=""><div class="ET_ToolbarButtonContainer"
											onclick="javascript:newFun();">
											<span id="ET_ToolbarButtonLabel" class=" labelNoImg  ">添加</span>
										</div></td>

									<td id="ET_ToolbarButton" class="toolbarEnable" align="center"
										nowrap=""><div class="ET_ToolbarButtonContainer "
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
										nowrap=""><div class="ET_ToolbarButtonContainer"
											onclick="javascript:showMore(this);">
											<span id="ET_ToolbarButtonLabel" class=" labelNoImg  ">更多...</span>
										</div></td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="Toolbar-spacing"></div>
					<div class="barListSplitLine"></div>
					<div style="height: 45px; overflow: hidden; position: relative;">
						<div
							style="height: 100%; overflow: auto; position: absolute; top: 0px; left: 0px; display: block; bottom: 0px; width: 100%;"
							id="formListTablebody_tbody">
							<table border="0" width="440" cellpadding="0" cellspacing="0"
								bgcolor="#FFFFFF" class="listTable dataTable" id="formListTable">
								<thead>
									<tr>
										<th><div style="width: 20px;">
												<img src="/static/images/16x16/action_open.gif" title="快速审批">
											</div></th>
										<th onclick="orderDocList(&quot;a.title&quot;);"
											style="cursor: pointer;"><div style="width: 200px;">部门名称</div></th>
										<th
											onclick="orderDocList(&quot; cast(a.enum02  as  decimal(18,2)) &quot;);"
											style="cursor: pointer;"><div style="width: 100px;">
												部门序号<img class="orderByImgClass"
													src="/static/images/list/up.png" border="0">
											</div></th>
										<th onclick="orderDocList(&quot;a.enum03&quot;);"
											style="cursor: pointer;"><div style="width: 100px;">部门是否有收入</div></th>
									</tr>
								</thead>
								<tbody>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '1000');"></td>
										<td class="linkURL"
											onclick="javascript:openForm(&quot;1000&quot;);"
											style="cursor: pointer">综合部</td>
										<td onclick="javascript:openForm(&quot;1000&quot;);"
											style="cursor: pointer" align="center">1</td>
										<td onclick="javascript:openForm(&quot;1000&quot;);"
											style="cursor: pointer">无收入</td>
									</tr>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '1040');"></td>
										<td class="linkURL"
											onclick="javascript:openForm(&quot;1040&quot;);"
											style="cursor: pointer">财务部</td>
										<td onclick="javascript:openForm(&quot;1040&quot;);"
											style="cursor: pointer" align="center">2</td>
										<td onclick="javascript:openForm(&quot;1040&quot;);"
											style="cursor: pointer">无收入</td>
									</tr>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '1002');"></td>
										<td class="linkURL"
											onclick="javascript:openForm(&quot;1002&quot;);"
											style="cursor: pointer">人力资源部</td>
										<td onclick="javascript:openForm(&quot;1002&quot;);"
											style="cursor: pointer" align="center">3</td>
										<td onclick="javascript:openForm(&quot;1002&quot;);"
											style="cursor: pointer">无收入</td>
									</tr>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '1003');"></td>
										<td class="linkURL"
											onclick="javascript:openForm(&quot;1003&quot;);"
											style="cursor: pointer">市场经营部</td>
										<td onclick="javascript:openForm(&quot;1003&quot;);"
											style="cursor: pointer" align="center">4</td>
										<td onclick="javascript:openForm(&quot;1003&quot;);"
											style="cursor: pointer">无收入</td>
									</tr>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '1004');"></td>
										<td class="linkURL"
											onclick="javascript:openForm(&quot;1004&quot;);"
											style="cursor: pointer">党政军客户解决方案部</td>
										<td onclick="javascript:openForm(&quot;1004&quot;);"
											style="cursor: pointer" align="center">5</td>
										<td onclick="javascript:openForm(&quot;1004&quot;);"
											style="cursor: pointer">有收入</td>
									</tr>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '1005');"></td>
										<td class="linkURL"
											onclick="javascript:openForm(&quot;1005&quot;);"
											style="cursor: pointer">金融行业解决方案部</td>
										<td onclick="javascript:openForm(&quot;1005&quot;);"
											style="cursor: pointer" align="center">6</td>
										<td onclick="javascript:openForm(&quot;1005&quot;);"
											style="cursor: pointer">有收入</td>
									</tr>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '1006');"></td>
										<td class="linkURL"
											onclick="javascript:openForm(&quot;1006&quot;);"
											style="cursor: pointer">互联网解决方案部</td>
										<td onclick="javascript:openForm(&quot;1006&quot;);"
											style="cursor: pointer" align="center">7</td>
										<td onclick="javascript:openForm(&quot;1006&quot;);"
											style="cursor: pointer">有收入</td>
									</tr>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '1007');"></td>
										<td class="linkURL"
											onclick="javascript:openForm(&quot;1007&quot;);"
											style="cursor: pointer">农商行业解决方案部</td>
										<td onclick="javascript:openForm(&quot;1007&quot;);"
											style="cursor: pointer" align="center">8</td>
										<td onclick="javascript:openForm(&quot;1007&quot;);"
											style="cursor: pointer">有收入</td>
									</tr>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '1008');"></td>
										<td class="linkURL"
											onclick="javascript:openForm(&quot;1008&quot;);"
											style="cursor: pointer">产品中心</td>
										<td onclick="javascript:openForm(&quot;1008&quot;);"
											style="cursor: pointer" align="center">9</td>
										<td onclick="javascript:openForm(&quot;1008&quot;);"
											style="cursor: pointer">有收入</td>
									</tr>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '1009');"></td>
										<td class="linkURL"
											onclick="javascript:openForm(&quot;1009&quot;);"
											style="cursor: pointer">云计算中心</td>
										<td onclick="javascript:openForm(&quot;1009&quot;);"
											style="cursor: pointer" align="center">10</td>
										<td onclick="javascript:openForm(&quot;1009&quot;);"
											style="cursor: pointer">有收入</td>
									</tr>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '1010');"></td>
										<td class="linkURL"
											onclick="javascript:openForm(&quot;1010&quot;);"
											style="cursor: pointer">教育行业解决方案部</td>
										<td onclick="javascript:openForm(&quot;1010&quot;);"
											style="cursor: pointer" align="center">11</td>
										<td onclick="javascript:openForm(&quot;1010&quot;);"
											style="cursor: pointer">有收入</td>
									</tr>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '1011');"></td>
										<td class="linkURL"
											onclick="javascript:openForm(&quot;1011&quot;);"
											style="cursor: pointer">医疗行业解决方案部</td>
										<td onclick="javascript:openForm(&quot;1011&quot;);"
											style="cursor: pointer" align="center">12</td>
										<td onclick="javascript:openForm(&quot;1011&quot;);"
											style="cursor: pointer">有收入</td>
									</tr>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '1012');"></td>
										<td class="linkURL"
											onclick="javascript:openForm(&quot;1012&quot;);"
											style="cursor: pointer">交通行业解决方案部</td>
										<td onclick="javascript:openForm(&quot;1012&quot;);"
											style="cursor: pointer" align="center">13</td>
										<td onclick="javascript:openForm(&quot;1012&quot;);"
											style="cursor: pointer">有收入</td>
									</tr>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '1013');"></td>
										<td class="linkURL"
											onclick="javascript:openForm(&quot;1013&quot;);"
											style="cursor: pointer">移动办公创新中心</td>
										<td onclick="javascript:openForm(&quot;1013&quot;);"
											style="cursor: pointer" align="center">14</td>
										<td onclick="javascript:openForm(&quot;1013&quot;);"
											style="cursor: pointer">无收入</td>
									</tr>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '1014');"></td>
										<td class="linkURL"
											onclick="javascript:openForm(&quot;1014&quot;);"
											style="cursor: pointer">企业管理创新中心</td>
										<td onclick="javascript:openForm(&quot;1014&quot;);"
											style="cursor: pointer" align="center">15</td>
										<td onclick="javascript:openForm(&quot;1014&quot;);"
											style="cursor: pointer">无收入</td>
									</tr>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '1015');"></td>
										<td class="linkURL"
											onclick="javascript:openForm(&quot;1015&quot;);"
											style="cursor: pointer">计划采购部</td>
										<td onclick="javascript:openForm(&quot;1015&quot;);"
											style="cursor: pointer" align="center">16</td>
										<td onclick="javascript:openForm(&quot;1015&quot;);"
											style="cursor: pointer">无收入</td>
									</tr>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '1016');"></td>
										<td class="linkURL"
											onclick="javascript:openForm(&quot;1016&quot;);"
											style="cursor: pointer">解决方案中心</td>
										<td onclick="javascript:openForm(&quot;1016&quot;);"
											style="cursor: pointer" align="center">17</td>
										<td onclick="javascript:openForm(&quot;1016&quot;);"
											style="cursor: pointer">有收入</td>
									</tr>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '1017');"></td>
										<td class="linkURL"
											onclick="javascript:openForm(&quot;1017&quot;);"
											style="cursor: pointer">服务支撑中心</td>
										<td onclick="javascript:openForm(&quot;1017&quot;);"
											style="cursor: pointer" align="center">18</td>
										<td onclick="javascript:openForm(&quot;1017&quot;);"
											style="cursor: pointer">有收入</td>
									</tr>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '1018');"></td>
										<td class="linkURL"
											onclick="javascript:openForm(&quot;1018&quot;);"
											style="cursor: pointer">业务支撑中心</td>
										<td onclick="javascript:openForm(&quot;1018&quot;);"
											style="cursor: pointer" align="center">19</td>
										<td onclick="javascript:openForm(&quot;1018&quot;);"
											style="cursor: pointer">无收入</td>
									</tr>
									<tr class="listTableTR">
										<td align="center"><img name="action-open" id="actionImg"
											src="/static/images/16x16/action_open.gif" title="快速审批" 动作=""
											style="cursor: pointer"
											onclick="javascript:showFormActionMenu(this, '1019');"></td>
										<td class="linkURL"
											onclick="javascript:openForm(&quot;1019&quot;);"
											style="cursor: pointer">百度项目工程办公室</td>
										<td onclick="javascript:openForm(&quot;1019&quot;);"
											style="cursor: pointer" align="center">20</td>
										<td onclick="javascript:openForm(&quot;1019&quot;);"
											style="cursor: pointer">无收入</td>
									</tr>
								</tbody>
							</table>
						</div>
						<div
							style="height: auto; overflow: hidden; position: absolute; display: block; bottom: auto; left: 0px; top: 0px; width: 1308px;"
							id="formListTablebody_theadContainer">
							<table border="0" width="440" cellpadding="0" cellspacing="0"
								bgcolor="#FFFFFF" class="listTable dataTable"
								id="formListTablebody_theadTable" style="width: 440px;">
								<thead>
									<tr>
										<th><div style="width: 20px;">
												<img src="/static/images/16x16/action_open.gif" title="快速审批">
											</div></th>
										<th onclick="orderDocList(&quot;a.title&quot;);"
											style="cursor: pointer;"><div style="width: 200px;">部门名称</div></th>
										<th
											onclick="orderDocList(&quot; cast(a.enum02  as  decimal(18,2)) &quot;);"
											style="cursor: pointer;"><div style="width: 100px;">
												部门序号<img class="orderByImgClass"
													src="/static/images/list/up.png" border="0">
											</div></th>
										<th onclick="orderDocList(&quot;a.enum03&quot;);"
											style="cursor: pointer;"><div style="width: 100px;">部门是否有收入</div></th>
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
								<option value="2">2</option></select>
							<div class="pageCount">/2页</div> <a
							class="pageToolBarLink page_next"
							href="javascript:changePage('2');"><img
								src="/static/images/16x16/arrow_next.png"
								overimg="/static/images/16x16/arrow_next_over.png" border="0"
								outimg="/static/images/16x16/arrow_next.png"></a><a
							class="pageToolBarLink page_end"
							href="javascript:changePage('2');"><img
								src="/static/images/16x16/arrow_last.png"
								overimg="/static/images/16x16/arrow_last_over.png" border="0"
								outimg="/static/images/16x16/arrow_last.png"></a></span><span
							class="pageText">共32条</span>
					</div>
				</form>
				<script type="text/javascript">
	window['formListTable']=new EasyTrack.DataTable("formListTable",{
		need_alignTableHead:true
	});
	
	
	ET.addToggleLeftEvent(function(){	
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