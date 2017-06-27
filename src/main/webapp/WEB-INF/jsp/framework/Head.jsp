<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>项目全流程</title>
<link rel="icon" href="favicon.ico" type="image/x-icon">
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="/static/css/style_new.css" rel="stylesheet" type="text/css">
<link href="/static/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/static/js/firefox/et.js"></script>
<script type="text/javascript" src="/static/js/firefox/FloatAndDialog.js"></script>
<script type="text/javascript" src="/static/js/jquery/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="/static/js/lable_message.js"></script>
<script type="text/javascript">
	ET.current_app_ID=1; //保存当前的appID ,在弹出框的时候 ，模板中自动加载特殊的css 
	ET.path="/";
	ET.language="GB";
	ET.i18n="zh";
	ET.label={};
	ET.label["LeaveWithoutSavingConfirm"]="您确定不保存就离开吗?";
	ET.label["SessionTimeoutException"]="com.easytrack.commons.exception.SessionTimeoutException";
	ET.label["profile.SessionTimeOut.Reason"]="您需要重新登录系统:\n超时或者您已经登录";
	ET.label["ConfirmLogout"]="您确定要退出?";
	ET.label["about"]="关于EasyTrack";
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
				url="/MyHomeAction.do?operation=openMyHome";
			}else if(systemFlag==2){
				url="/WikiDocumentAction.do?operation=goWikiMain";
			}else if(systemFlag==3){
				url="/SystemMonitorAction.do?operation=monitorDashboard&menuID=9&subMenuID=901";
			}else if(systemFlag==6){
				url="/DemandAction.do?operation=goAlmMain";
			}else if(systemFlag==8){
				url="/ETAgileAction.do?operation=goMain";
			}else if(systemFlag==7){
				url="/ContractAction.do?operation=goCmMain";
			}
			MenuAction.changeSystemFlag(systemFlag,function(data){
				form.action=url;form.submit();
			});
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
</script>
<script type="text/javascript" src="/static/js/firefox/DataTableAll.js"></script>
<script type="text/javascript" src="/static/js/Highcharts/highcharts.js"></script>
<script type="text/javascript">
Highcharts.setOptions({
   colors: ['#46c6f0', '#a8da72', '#7be4d8', '#fde485', '#fe902c', '#fe5151', '#db8ebf', '#f6c468', '#5db1e2'],
    yAxis: {
           gridLineDashStyle:'ShortDot'
     }
});

if(!Array.indexOf){
	Array.prototype.indexOf=function(object){
		for(var i=0,j=this.length;i<j;i++){
			if(this[i]==object){
				return i;
			}
		}
		return -1;
	}
}
function changeyear(year){
	CMCCAction.checkDepart({
		year:year
	    ,deparmentID:document.frm.departmentID.value
	},function(ret){
		if(ret){
			document.frm.year.value=year;
			document.frm.action="/ZongheAction.do";
			document.frm.submit();
		}else{
			alert("此部门是历史部门,在"+year+"年不存在");
		}
	})
	
}
$(document).ajaxSuccess(function(){
	window.dashScrollBar.resize();
})
function openItemSet(itemID){
	
	var arg = new Array();
	arg.src = "/CMCCItemSetAction.do?operation=itemSetMain"
		+"&itemID="+itemID
		+"&_id="+Math.random();
	arg.src+="&isDialog=true";
	//arg.title = "项目全视图";
	ET.showNewWindow(arg, function (ret) { 
		if(ret != null){
			
		}
	});
}
function openGongCheng(){
	var arg = new Array();
	arg.showTitle=false;
	arg.src = "/CMCCAction.do?operation=gongcheng&menuID=58&year="+document.frm.year.value;
	arg.src+="&_id="+Math.random();
	arg.src+="&isDialog=true";
	arg.title = "CAPEX"+document.frm.year.value+"年视图";
	ET.showNewWindow(arg, function (ret) { 
		if(ret != null){
			
		}
	});
}
function openCaiwu(){
	var arg = new Array();
	arg.showTitle=false;
	arg.src = "/CMCCAction.do?operation=caiWu&menuID=56&year="+document.frm.year.value;
	arg.src+="&_id="+Math.random();
	arg.src+="&isDialog=true";
	arg.title = "OPEX"+document.frm.year.value+"年视图";
	ET.showNewWindow(arg, function (ret) { 
		if(ret != null){
			
		}
	});
}
function openProduct(productID){
	var arg = new Array();
	arg.src = "/ProductAction.do?operation=dashBoard";
	arg.src+="&productID="+productID;
	arg.src+="&isDialog=true";
	//arg.title = "产品全视图";
	ET.showNewWindow(arg, function (ret) { 
		if(ret != null){
			
		}
	});
}

function openDepartmentView(departmentID){
	var arg = new Array();
	arg.src = "/ZongheAction.do?operation=dashBoard";
	arg.src+="&departmentID="+departmentID;
	arg.src+="&isDialog=true";
	arg.title = undefined;
	ET.showNewWindow(arg, function (ret) { 
		if(ret != null){
			
		}
	});
}
function returnLastWindow(){
	parent.ET.closeModalWindow();
}

function openOpexProjectList(index){
	var arg = new Array();
	 var departmentID=document.frm.departmentName.value;
	top.ET.currentDepartmentID=departmentID; 
	arg.src = "/CMCCReportServer?reportlet=财务报表/OPEX多项目列表.cpt&_id="+Math.random();
	if(index!=-1){
		arg.src += "&opexStatus="+index;
	}
	arg.title = "OPEX多项目列表";
	arg.containerClass="fineReport";
	top.ET.showNewWindow(arg, function (ret) { 
	})
}

function openCapexProjectList(index,flag){
    var departmentID=document.frm.departmentName.value;
	top.ET.currentDepartmentID=departmentID;
	var arg = new Array();
	arg.containerClass="fineReport";
	arg.src = "/CMCCReportServer?reportlet=工程报表/CAPEX多项目列表.cpt&_id="+Math.random();
	if(index!=-1){
		top.ET.capexStatus = index;
	}else{
		top.ET.capexStatus=null;
	}
	if(flag== 1){
		top.ET.capexShuxing ="新建";
	}else{
		top.ET.capexShuxing =null;
	}
	
	arg.title = "CAPEX多项目列表";
	top.ET.showNewWindow(arg, function (ret) { 
	})
}

function openProductSummaryList(){
	var departmentID=document.frm.departmentName.value;
	top.ET.currentDepartmentID=departmentID;
	var arg = new Array();
	arg.src = "/CMCCReportServer?reportlet=综合报表/产品综合报表.cpt&_id="+Math.random();
	arg.title = "产品综合报表";
	arg.containerClass="fineReport";
	top.ET.showNewWindow(arg, function (ret) { 
	})
}

function openDepartmentSummaryList(){
	var arg = new Array();
	arg.src = "/CMCCReportServer?reportlet=多维分析报表/分部门收入及成本使用表.cpt&_id="+Math.random();
	arg.title = "分部门收入及成本使用表";
	arg.containerClass="fineReport";
	top.ET.showNewWindow(arg, function (ret) { 
	})
}

function openProjectSetSummaryList(){
	var departmentID=document.frm.departmentName.value;
	top.ET.currentDepartmentID=departmentID;
	
	var arg = new Array();
	arg.src = "/CMCCReportServer?reportlet=综合报表/项目综合报表.cpt&_id="+Math.random();
	arg.title = "项目综合报表";
	arg.containerClass="fineReport";
	top.ET.showNewWindow(arg, function (ret) { 
	})
}

function openTouzizhixingDetail(){
	var arg = new Array();
	arg.src = "/CMCCReportServer?reportlet=工程报表/年度投资计划执行情况表.cpt&_id="+Math.random();
	arg.title = "年度投资计划执行情况表";
	arg.containerClass="fineReport";
	top.ET.showNewWindow(arg, function (ret) { 
	})
}

function openYusuanFenjie(){
	var arg = new Array();
	arg.src = "/CMCCReportServer?reportlet=财务报表/分部门预算分解情况表.cpt&_id="+Math.random();
	arg.title = "分部门预算分解情况表";
	arg.containerClass="fineReport";
	top.ET.showNewWindow(arg, function (ret) { 
	})
}

function openduoxiangmucapexDetail(){
	var arg = new Array();
	arg.src = "/CMCCReportServer?reportlet=工程报表/多项目资本开支、转资情况汇总表.cpt&_id="+Math.random();
	arg.title = "多项目资本开支、转资情况汇总表";
	arg.containerClass="fineReport";
	top.ET.showNewWindow(arg, function (ret) { 
	})
}

function openduoxiangmuopex(){
	var arg = new Array();
	arg.src = "/CMCCReportServer?reportlet=财务报表/多项目成本开支情况表.cpt&_id="+Math.random();
	var departmentID=document.frm.departmentName.value;
	top.ET.currentDepartmentID=departmentID;
	arg.title = "多项目成本开支情况表";
	arg.containerClass="fineReport";
	top.ET.showNewWindow(arg, function (ret) { 
	})
}
</script>

<style type="text/css">
	.showMoreColor{
		color: #fff;
	}
</style>
</head>