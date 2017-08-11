//-----DomUtils------------------------------------------------------------------------------------------------------
function DomUtils(){
	this.getScrollEx=function(obj){
		var elmt=obj;
	    var scrollLeft = elmt.scrollLeft; 
	    var scrollTop = elmt.scrollTop; 
	    while(elmt = elmt.offsetParent){ 
	        scrollLeft += elmt.scrollLeft; 
	        scrollTop += elmt.scrollTop;
	    }
	    return { 
	    	scrollLeft: scrollLeft,
	    	scrollTop: scrollTop
	    }; 
	}
	this.getAbsoluteLocationEx=function(obj){
		var elmt=obj;
	    var offsetTop = elmt.offsetTop; 
	    var offsetLeft = elmt.offsetLeft; 
	    while(elmt = elmt.offsetParent){ 
	        offsetTop += elmt.offsetTop; 
	        offsetLeft += elmt.offsetLeft;
	    }
	    return { 
	    	absoluteTop: offsetTop,
	    	absoluteLeft: offsetLeft
	    };
	}
	this.hideElement=function( elmID, overDiv ){
		var objs = document.getElementsByTagName(elmID);
		for( i = 0; i < objs.length; i++ ){
			obj = objs[i];
	      	if( !obj || !obj.offsetParent || obj.notToHidden){
	        	continue;
	      	}
	      	var locationEx = this.getAbsoluteLocationEx(obj);
			var absoluteTop=locationEx.absoluteTop;
	    	var absoluteLeft=locationEx.absoluteLeft;
	      	if(( overDiv.offsetLeft + overDiv.offsetWidth ) <= absoluteLeft );
	      	else if(( overDiv.offsetTop + overDiv.offsetHeight ) <= absoluteTop );
	      	else if( overDiv.offsetTop >= ( absoluteTop + obj.offsetHeight ));
	      	else if( overDiv.offsetLeft >= ( absoluteLeft + obj.offsetWidth ));
	      	else{
				obj.style.visibility = "hidden";
			}
		}
	}
	this.showElement=function(elmID){
		var objs = document.getElementsByTagName(elmID);
		for( i = 0; i < objs.length; i++ ){
	    	obj = objs[i];
	      	if( !obj || !obj.offsetParent || obj.notToHidden ){
	        	continue;
	      	}
			obj.style.visibility = "";
	    }
	}
}
var domUtils;
if (typeof domUtils == "undefined") {
	domUtils = new DomUtils();
}
//---------Float--------------------------------------------------------------------------------------------------------
function ET_FloatController() {
	this.bShow = false;//标记
	this.floatDIV;
	this._constructor = function () {
		ET.Utils.addEvent(window.document, "keypress", this.onKeyPress);
		ET.Utils.addEvent(window.document, "click", this.onClick);
	};
	this.hide = function () {
		if(typeof this.floatDIV == 'undefined'){
			this.floatDIV=document.getElementById('floatDIV');
		}
		
		if(this.floatDIV==null||this.floatDIV.style.visibility != "visible"){
			return;
		}
		this.floatDIV.style.visibility = "hidden";
		domUtils.showElement( 'select', this.floatDIV);
		domUtils.showElement( 'applet', this.floatDIV );	
	};
	this.onKeyPress = function (event) {//这个方法不能带this
		if (event.keyCode == 27) {
			floatController.hide();
		}
	};
	this.onClick = function (event) {//这个方法不能带this
		if (!floatController.bShow) {
			floatController.hide();
		}
		floatController.bShow = false;
	};

	this.popup = function (textInput,width) {
		if (this.floatDIV && this.floatDIV.style.visibility == "visible") {
			return;
		}
		if(typeof this.floatDIV == 'undefined'||this.floatDIV==null){
			this.floatDIV=document.getElementById('floatDIV');
		}
		if(typeof width!="undefined"){
			this.floatDIV.style.width=width+"px";
		}else{
			this.floatDIV.style.width=textInput.offsetWidth+"px";
		}
		var popObj=textInput;
		if(textInput.parentNode.tagName.toLowerCase()=='div'){
			popObj=textInput.parentNode;
			
		}
		var locationEx = popObj.getBoundingClientRect();
		var scrollEx=domUtils.getScrollEx(popObj);
		var absoluteTop=locationEx.top;
    	var absoluteLeft=locationEx.left;
    	var scrollLeft=0;
    	var scrollTop=0;
    	var calTop;
    	var calLeft;
		if ((document.body.offsetHeight - (absoluteTop-scrollTop + popObj.offsetHeight)) < this.floatDIV.offsetHeight) {
			calTop = absoluteTop -scrollTop- this.floatDIV.offsetHeight;
			if(calTop<0){
				calTop=1;
			}
		} else {
			calTop = absoluteTop -scrollTop + popObj.offsetHeight+1;
		}
		if(document.body.offsetWidth-(absoluteLeft-scrollLeft) - 10 < this.floatDIV.offsetWidth) {
			calLeft= document.body.offsetWidth - 10 - this.floatDIV.offsetWidth;
		} else{
			calLeft= absoluteLeft-scrollLeft;
		}
		if(calLeft<0){
			calLeft=0;			
		}
		this.floatDIV.style.left = calLeft+"px"; ;
		this.floatDIV.style.top = calTop+"px";;
		this.floatDIV.style.visibility = "visible";
		domUtils.hideElement( 'select', this.floatDIV);
		domUtils.hideElement( 'applet', this.floatDIV);
		this.bShow=true;
	};
		//资源类型INPUT多出5个像素问题
	this.popup1 = function (textInput,width) {
		if (this.floatDIV && this.floatDIV.style.visibility == "visible") {
			return;
		}
		if(typeof this.floatDIV == 'undefined'){
			this.floatDIV=document.getElementById('floatDIV');
		}
		if(typeof width!="undefined"){
			this.floatDIV.style.width=width+"px";
		}else{
			this.floatDIV.style.width=textInput.offsetWidth+"px";
		}
		var locationEx = domUtils.getAbsoluteLocationEx(textInput);
		var scrollEx=domUtils.getScrollEx(textInput);
		var absoluteTop=locationEx.absoluteTop;
    	var absoluteLeft=locationEx.absoluteLeft+10;
    	var scrollLeft=scrollEx.scrollLeft;
    	var scrollTop=scrollEx.scrollTop;
    	var calTop;
    	var calLeft;
		if ((document.body.offsetHeight - (absoluteTop-scrollTop + textInput.offsetHeight)) < this.floatDIV.offsetHeight) {
			calTop = absoluteTop -scrollTop- this.floatDIV.offsetHeight;
			if(calTop<0){
				calTop=1;
			}
		} else {
			calTop = absoluteTop -scrollTop + textInput.offsetHeight+1;
		}
		if(document.body.offsetWidth-(absoluteLeft-scrollLeft) - 10 < this.floatDIV.offsetWidth) {
			calLeft= document.body.offsetWidth - 10 - this.floatDIV.offsetWidth;
		} else{
			calLeft= absoluteLeft-scrollLeft;
		}
		if(calLeft<0){
			calLeft=0;			
		}
		this.floatDIV.style.left = calLeft+"px"; ;
		this.floatDIV.style.top = calTop+"px";;
		this.floatDIV.style.visibility = "visible";
		domUtils.hideElement( 'select', this.floatDIV);
		domUtils.hideElement( 'applet', this.floatDIV);
		this.bShow=true;
	};
	this._constructor();
}
var floatController;
if (typeof floatController == "undefined") {
	floatController = new ET_FloatController();
}
ET.Utils.addEvent(window,'load',function(){
	var div=document.createElement('div');
	document.body.appendChild(div);
	div.outerHTML="<div id=\"floatDIV\" class=\"floatDIV\" style=\"width:200px;height:180px\" onclick=\"floatController.bShow=true\"></div>";
});
//document.write("<div id=\"floatDIV\" class=\"floatDIV\" style=\"width:200px;height:180px\" onclick=\"floatController.bShow=true\"></div>");


//------------------ModelDialog-----------------------------------------------------------------------------
function ET_ModelDialog() {
	this.coverDIV ;//覆盖块
	this.hide = function (modelDIV) {
		modelDIV.style.visibility = "hidden";
		this.coverDIV.style.visibility = "hidden";
		domUtils.showElement( 'select', modelDIV);
		domUtils.showElement( 'applet', modelDIV );
	};
	
	this.popup=function(modelDIV){
		if(typeof this.coverDIV =="undefined"){
			this.coverDIV=document.getElementById("coverDIV");
		}
		if (this.coverDIV && this.coverDIV.style.visibility == "visible"){
			return ;
		}
		var bodyWidth=document.body.offsetWidth;
		var bodyHeight=document.body.offsetHeight;
		var calLeft=(bodyWidth-modelDIV.offsetWidth)/2;
		var calTop=(bodyHeight-modelDIV.offsetHeight)/2;
		
		modelDIV.style.left = calLeft+"px"; ;
		modelDIV.style.top = calTop+"px";
		modelDIV.style.visibility = "visible";
		this.coverDIV.style.visibility = "visible";
		domUtils.hideElement( 'select', this.coverDIV);
		domUtils.hideElement( 'applet', this.coverDIV);	
	}
}
var modelDialog;
if (typeof modelDialog == "undefined") {
	modelDialog = new ET_ModelDialog();
}

ET.Utils.addEvent(window,'load',function(){
	var div=document.createElement('div');
	document.body.appendChild(div);
	div.outerHTML="<div id=\"coverDIV\" class=\"coverDIV\"></div>";
});
//document.write("<div id=\"coverDIV\" class=\"coverDIV\"></div>");



//-----AjaxTree--------------------------------------------------------------------------------------------------------------
function AJAXTree(){
	this.currentNodeSpan;
	this.currentNodeID;
	this.func;
	this.treeName="";
	this.doSubFun=function(obj,nodeID){
		var subContainer=document.getElementById(this.treeName+'subContainer_'+nodeID);
		if(obj.tagName.toLowerCase()=='img'){
			if(obj.src.lastIndexOf('minus')==-1){
				var newSrc=obj.src.replace(/plus/g,'minus');
				obj.src=newSrc;
				subContainer.style.display='block';
			}else{
				var newSrc=obj.src.replace(/minus/g,'plus');
				obj.src=newSrc;
				subContainer.style.display='none';
			}
		}else{
			if(ET.Utils.hasClass(obj,'tree_close_icon')){
				ET.Utils.removeClass(obj,'tree_close_icon');
				ET.Utils.addClass(obj,'tree_open_icon');
				subContainer.style.display='block';
			}else{
				ET.Utils.removeClass(obj,'tree_open_icon');
				ET.Utils.addClass(obj,'tree_close_icon');
				subContainer.style.display='none';
			}
		}
	}
	this.clickNodeSpan=function(nodeID,isClickGroupNode){
		ET.isSelectedGroupNode=isClickGroupNode;
		var nodeSpan=null;
		if(ET.isSelectedGroupNode && isClickGroupNode){
			nodeSpan=document.getElementById(this.treeName+'groupNodeSpan_'+nodeID)
		}else{
			nodeSpan=document.getElementById(this.treeName+'nodeSpan_'+nodeID)
		}
		if(typeof this.currentNodeSpan!='undefined'){
			this.currentNodeSpan.style.fontWeight='';
		}
		if(nodeSpan!=null){
			nodeSpan.style.fontWeight='bold';
			this.currentNodeSpan=nodeSpan;
		}
		this.currentNodeID=nodeID;
		if(typeof this.func!="undefined"){
			setTimeout(this.func,0);
		}
	}
	this.mutilCheck=function(checkDom){
		var idField=this.currentIDField;
		var nameField=this.currentNameField;
		var idArray=[];
		var nameArray=[];
		var checked=checkDom.checked;
		var inputTemp=null;
		var spanTemp;
		var childDIV=document.getElementById("subContainer_"+checkDom.value );
		if(childDIV!=null){
			var childInput=childDIV.getElementsByTagName('input');
			for(var i=0,j=childInput.length;i<j;i++){
				inputTemp=childInput[i];
				if(inputTemp.type=='checkbox'){
					inputTemp.checked=checked;
				}
			}
		}
		var currentContainerDIV=this.currentContainerDIV;
		var floatDIV=document.getElementById('floatDIV');
		if(currentContainerDIV!=null){
			floatDIV=currentContainerDIV;
		}
		var inputArray=floatDIV.getElementsByTagName('input');
		var nodeSpanName = ""
		for(var i=0,j=inputArray.length;i<j;i++){
				inputTemp=inputArray[i];
				if(inputTemp.type=='checkbox'&& inputTemp.checked){
					spanTemp=document.getElementById('nodeSpan_'+inputTemp.value );
					if(spanTemp!=null){
						idArray.push(inputTemp.value);
						if(spanTemp.textContent!=undefined){
							nodeSpanName=spanTemp.textContent;//处理使用在Firefox浏览器
						}else{
							nodeSpanName=spanTemp.innerText;
						}
						nameArray.push(nodeSpanName);
					}
				}
		}
		if(idField!=null){
			idField.value=idArray.join(',');
		}
		if(nameField!=null){
			nameField.value=nameArray.join(',');
		}
	}
	/**
	 * by chenhao
	 */
	this.onNodeSpan=function(nodeID){
		var nodeSpan=document.getElementById(this.treeName+'nodeSpan_'+nodeID);
		if(nodeSpan==null){
			return;
		}
	}
	
	/**
	 * by chenhao
	 */
	this.offNodeSpan=function(nodeID){
		var nodeSpan=document.getElementById(this.treeName+'nodeSpan_'+nodeID);
		if(nodeSpan==null){
			return;
		}
	}
}
var ajaxTree=new AJAXTree();
if (typeof ajaxTree == "undefined") {
	ajaxTree = new AJAXTree();
}

var ajaxTreeForSchearch=new AJAXTree();
if (typeof ajaxTreeForSchearch == "undefined") {
	ajaxTreeForSchearch = new AJAXTree();
}

//-----------TreeSelect-----------------------------------------------------------------------------------------

function ET_TreeSelectUtils(){
	this.showDefTreeSelect=function(idField,nameField,data,width){
		var oldid = idField.value;
		var oldname = nameField.value;
		if(width==undefined){
			width=nameField.parentNode.clientWidth;
		}
		floatController.popup(nameField,width);
		floatController.floatDIV.innerHTML=data;
		ajaxTree.func=function(){
			idField.value=ajaxTree.currentNodeID;
			nameField.value=ajaxTree.currentNodeSpan.innerHTML;
			if(document.all){
   			 	nameField.fireEvent("onchange");
			}else{
  				 var  evt = document.createEvent( 'HTMLEvents');
   				 evt.initEvent('change',true,true);
  				 nameField.dispatchEvent(evt);
			}
			floatController.hide();
			floatController.floatDIV.innerHTML='';
			ajaxTree.func=null;
			try{
			  //选择之后执行此方法，如果此方法不存在则不做任何事
			  afterselect(idField,nameField,oldid,oldname);
			}catch(e){
			}
		}
	}
	
	this.showTreeSelect=function(idField,nameField,type,rootID,width){//此方法中floatController.floatDIV做为tree的容器
		if(width==undefined){
			width=nameField.parentNode.clientWidth;
		}
//		floatController.popup(nameField,width);
//		UserAction.ajaxTreeHTML(type,rootID,function(data){
//			floatController.floatDIV.innerHTML=data;
//			ajaxTree.func=function(){
//				idField.value=ajaxTree.currentNodeID;
//				nameField.value=ajaxTree.currentNodeSpan.innerHTML;
//				if(document.all){
//       			 	nameField.fireEvent("onchange");
//				}else{
//      				 var  evt = document.createEvent( 'HTMLEvents');
//       				 evt.initEvent('change',true,true);
//      				 nameField.dispatchEvent(evt);
//				}
//				floatController.hide();
//				floatController.floatDIV.innerHTML='';
//				ajaxTree.func=null;
//			}
//		});
		
		var showFun=function(){
			var arg={};
			arg.src = ET.etPath+"/../../../UserAction.do?operation=showTreeSelect&_id="+Math.random()  ;
			arg.src+="&type="+type;
			arg.src+="&rootID="+rootID;
			//arg.src+="&searchKye="+encodeURIComponent(nameField.value);
			arg.src+="&selectNode="+idField.value;
			arg.height=360;
			arg.theme = 'search';
			arg.width=380;
			top.ET.showModalWindow(arg, function (ret) { 
				if(typeof ret!="undefined" && ret!=null){
					idField.value=ret.currentNodeID;
					nameField.value=ret.currentNodeSpanName;
				}
			});
		}
		showFun();
		
	}
	this.showMultiCheckListSelect=function(idField,nameField,width){//
		if(width==undefined){
			width=nameField.parentNode.clientWidth;
		}
		floatController.popup(nameField,width);
		floatController.floatDIV.idField=idField;
		floatController.floatDIV.nameField=nameField;
		floatController.floatDIV.innerHTML=document.getElementById(idField.getAttribute("name")+"_multiCheckList").innerHTML;
		var checks = floatController.floatDIV.getElementsByTagName("input");
		var idFields = ","+idField.value+",";
		for(var i=0;i<checks.length;i++){
			ET.Utils.addEvent(checks[i], "click", this.showMultiCheckItemClick);
			if(idFields.indexOf(","+checks[i].value+",")>=0){
				checks[i].checked=true;
			}
		}
	}
	this.showMultiCheckItemClick=function(){
		var idField = floatController.floatDIV.idField;
		var nameField = floatController.floatDIV.nameField;
		var checks = floatController.floatDIV.getElementsByTagName("input");
		var ids ="";
		var names = "";
		for(var i=0;i<checks.length;i++){
			if(checks[i].checked){
				if(ids.length>0){
					ids+=",";
				}
				if(names.length>0){
					names+=",";
				}
				ids+=checks[i].value;
				names+=checks[i].parentElement.children[2].innerHTML;
			}
		}
		idField.value=ids;
		nameField.value=names;
	}
	this.showTeamTreeSelect=function(idField,nameField,projectID,rootID){//此方法中floatController.floatDIV做为tree的容器
		floatController.popup(nameField,name.parentNode.clientWidth);
		ProjectAction.ajaxTeamTreeHTML(projectID,rootID,function(data){
			floatController.floatDIV.innerHTML=data;
			ajaxTree.func=function(){
				idField.value=ajaxTree.currentNodeID;
				nameField.value=ajaxTree.currentNodeSpan.innerHTML;
				if(document.all){
       			 	nameField.fireEvent("onchange");
				}else{
      				 var  evt = document.createEvent( 'HTMLEvents');
       				 evt.initEvent('change',true,true);
      				 nameField.dispatchEvent(evt);
				}
				floatController.hide();
				floatController.floatDIV.innerHTML='';
				ajaxTree.func=null;
			}
		});
	}
	
	this.showSpecTreeSelect=function(idField,nameField,type,projectID,width){//此方法中floatController.floatDIV做为tree的容器
		if(width==undefined){
			width=nameField.parentNode.clientWidth;
		}
		floatController.popup(nameField,width);
		ALMAction.ajaxTreeHTML(type,projectID,function(data){
			floatController.floatDIV.innerHTML=data;
			ajaxTree.func=function(){
				idField.value=ajaxTree.currentNodeID;
				nameField.value=ajaxTree.currentNodeSpan.innerHTML;
				if(document.all){
	   			 	nameField.fireEvent("onchange");
				}else{
	  				 var  evt = document.createEvent( 'HTMLEvents');
	   				 evt.initEvent('change',true,true);
	  				 nameField.dispatchEvent(evt);
				}
				floatController.hide();
				floatController.floatDIV.innerHTML='';
				ajaxTree.func=null;
			}
		});
	}
	
	this.showFunctionTreeSelect=function(idField,nameField,type,projectID,width){//此方法中floatController.floatDIV做为tree的容器
		if(width==undefined){
			width=nameField.parentNode.clientWidth;
		}
		floatController.popup(nameField,width);
		ALMAction.ajaxFunctionTreeHTML(type,projectID,function(data){
			floatController.floatDIV.innerHTML=data;
			ajaxTree.func=function(){
				idField.value=ajaxTree.currentNodeID;
				nameField.value=ajaxTree.currentNodeSpan.innerHTML;
				if(document.all){
	   			 	nameField.fireEvent("onchange");
				}else{
	  				 var  evt = document.createEvent( 'HTMLEvents');
	   				 evt.initEvent('change',true,true);
	  				 nameField.dispatchEvent(evt);
				}
				floatController.hide();
				floatController.floatDIV.innerHTML='';
				ajaxTree.func=null;
			}
		});
	}
	
	//只在项目搜索处 多选组合，部门，表单中的部门，是不支持部门查询的
	this.showMutilTreeSelect=function(idField,nameField,type,rootID){//此方法中floatController.floatDIV做为tree的容器
		floatController.popup(nameField,nameField.offsetWidth);
		var loadData= {
			'checkedIDSet': idField.value
		};
		ajaxTree.currentIDField=idField;
		ajaxTree.currentNameField=nameField;
		if(type==7&&top.document.frm&&top.document.frm.menuID){
			var topMenuID=top.document.frm.menuID.value;
			if(topMenuID==16){//部门管理
				rootID=top.document.frm.departmentID.value;
			}
		}else if(type==40&&top.document.frm&&top.document.frm.menuID){//组合模块
			var topMenuID=top.document.frm.menuID.value; //组合管理
			if(topMenuID==4){
				rootID=top.document.frm.portfolioID.value;
			}
		}
		UserAction.ajaxMutilTreeHTML(type,rootID,loadData,function(data){
			floatController.floatDIV.innerHTML=data;
			ajaxTree.func=function(){
				floatController.hide();
				floatController.floatDIV.innerHTML='';
				ajaxTree.func=null;
			}
		});
	}
	this.showTreeSelectForProjectChoosePortfolio=function(idField,nameField,type,rootID,needAccess){//此方法中floatController.floatDIV做为tree的容器
//		floatController.popup(nameField,nameField.parentNode.clientWidth);
//		UserAction.ajaxTreeHTMLForProjectChoosePortfolio(type,rootID,needAccess,function(data){
//			floatController.floatDIV.innerHTML=data;
//			ajaxTree.func=function(){
//				idField.value=ajaxTree.currentNodeID;
//				nameField.value=ajaxTree.currentNodeSpan.innerHTML;
//				if(document.all){
//      			 	nameField.fireEvent("onchange");
//				}else{
//					var  evt = document.createEvent( 'HTMLEvents');
//					evt.initEvent('change',true,true);
//					nameField.dispatchEvent(evt);
//				}
//				floatController.hide();
//				floatController.floatDIV.innerHTML='';
//				ajaxTree.func=null;
//			}
//		});

		var showDIVFun=function(){
			var arg={};
			arg.src = ET.etPath+"/../../../UserAction.do?operation=showTreeSelect&_id="+Math.random()  ;
			arg.src+="&type="+type;
			arg.src+="&rootID="+rootID;
			//arg.src+="&searchKye="+encodeURIComponent(nameField.value);
			arg.src+="&selectNode="+idField.value;
			arg.height=380;
			arg.width=380;
			top.ET.showModalWindow(arg, function (ret) { 
				if(typeof ret!="undefined" && ret!=null){
					idField.value=ret.currentNodeID;
					nameField.value=ret.currentNodeSpanName;
				}
			});
		}
		showDIVFun();
	}
	
	this.showTreeSelectForIframe=function(idField,nameField,type,rootID,needAccess,funtion){//此方法中floatController.floatDIV做为tree的容器
		floatController.popup(nameField);
		UserAction.ajaxTreeHTMLForProjectChoosePortfolio(type,rootID,needAccess,function(data){
			floatController.floatDIV.innerHTML=data;
			ajaxTree.func=function(){
				idField.value=ajaxTree.currentNodeID;
				nameField.value=ajaxTree.currentNodeSpan.innerHTML;
				if(document.all){
       			 	nameField.fireEvent("onchange");
				}else{
					var  evt = document.createEvent( 'HTMLEvents');
					evt.initEvent('change',true,true);
					nameField.dispatchEvent(evt);
				}
				floatController.hide();
				floatController.floatDIV.innerHTML='';
				ajaxTree.func=null;
				if(typeof funtion!='undefined'){
					funtion(idField);
				}
			}
		});
	}
	
	/**
	 * by chenhao
	 * 只需要前面两个参数，其余参数为兼容历史问题
	 * 默认为多选，isMulti显示设置为false才单选
	 */
	this.showUserSelect=function(idField,nameField,roleType,rootID,isMulti,defaultNodeID,resourceType,funtion){
		parent.ET.currentIDField=idField;
		var arg = new Array();
	 	var sUrl="";

		if(typeof roleType == "undefined"){//缺省为选择用户组件
			roleType = 7;
		}
		sUrl += "&roleType="+roleType;
		sUrl += "&rootID="+rootID;
		
		if(typeof isMulti == "undefined"){//缺省为多选组件
			isMulti=true;
		}
		sUrl +="&isMulti="+isMulti;
		
		if(typeof defaultNodeID!='undefined'){
			sUrl +="&defaultNodeID="+defaultNodeID;
		}
		
		if(typeof resourceType!='undefined'){
			sUrl +="&resourceTypeID="+resourceType;
		}
		sUrl +="&onlyShowNotResource="+ET.onlyShowNotResource;
		sUrl +="&isShowContact="+ET.isShowContact;
		var showProject=false;
		if(document.frm&&document.frm['user_select_projectIDHidden']){
			showProject=true;
			sUrl +="&isShowProject=true&projectID="+document.frm['user_select_projectIDHidden'].value;
		}
		if(!showProject){
			if(top.document&&top.document.frm&&top.document.frm.menuID){
				var topMenuID=top.document.frm.menuID.value;
				var topSubMenuID=top.document.frm.subMenuID.value;
				if(topMenuID==3&&topSubMenuID!=304&& ET.showUserSelectSelectProject!=false){
					showProject=true;
					sUrl +="&isShowProject=true&projectID="+top.document.frm.projectID.value;
					//arg.src = ET.etPath+"/../../../jsp/profile/UserSelectProjectCommon.jsp?projectID="+top.document.frm.projectID.value
				}
			}
		}
		arg.theme="search";
	    /*arg.src = ET.etPath+"/../../../UserAction.do?operation=userSelectCommon2&_id="+Math.random() + sUrl;*/
	    arg.src = "/datamap/userSelectCommon?_id="+Math.random();
		if(isMulti){
			arg.width = 630;
			arg.height =430;
		}else{
			arg.width = 630;
			arg.height = 430;
		}
		parent.ET.showModalWindow(arg, function (oRet){
			if (oRet!=null) {
				if(typeof idField!='undefined' && idField!=null){
					idField.value=oRet.userIds;
				}
				if(typeof nameField!='undefined' && nameField!=null){
					nameField.value=oRet.userNames;
				}
			}
			if(typeof(parent.onSelectUserOKFun)!='undefined'&&typeof(funtion)=='undefined'){
				parent.onSelectUserOKFun(idField);
			}else if(typeof(funtion)!='undefined'){
				funtion(idField);
			}
		});
	}
	this.showUserSelect1=function(idField,nameField,hiddenUserIDStr,roleType,rootID,isMulti,defaultNodeID,resourceType,funtion){
		parent.ET.currentIDField=idField;
		var arg = new Array();
	 	var sUrl="";

		if(typeof roleType == "undefined"){//缺省为选择用户组件
			roleType = 7;
		}
		sUrl += "&roleType="+roleType;
		sUrl += "&rootID="+rootID;
		
		if(typeof isMulti == "undefined"){//缺省为多选组件
			isMulti=true;
		}
		sUrl +="&isMulti="+isMulti;
		
		if(typeof defaultNodeID!='undefined'){
			sUrl +="&defaultNodeID="+defaultNodeID;
		}
		
		if(typeof resourceType!='undefined'){
			sUrl +="&resourceTypeID="+resourceType;
		}
		if(typeof hiddenUserIDStr!='undefined'){
			sUrl +="&hiddenUserIDStr="+hiddenUserIDStr;
		}
		
		sUrl +="&onlyShowNotResource="+ET.onlyShowNotResource;
		sUrl +="&isShowContact="+ET.isShowContact;
		arg.src = ET.etPath+"/../../../UserAction.do?operation=userSelectCommon&_id="+Math.random() + sUrl;
		if(isMulti){
			arg.width = 600;
			arg.height = 360;
		}else{
			arg.width = 420;
			arg.height = 360;
		}
		parent.ET.showModalWindow(arg, function (oRet){
			if (oRet!=null) {
				idField.value=oRet.userIds;
				if(typeof nameField!='undefined' && nameField!=null){
					nameField.value=oRet.userNames;
				}
				if(typeof(onSelectUserOKFun)=='function'){
					onSelectUserOKFun(idField);
				}else if(typeof(funtion)=='function'){
					funtion(idField);
				}
			}
		});
	}
	
	/**
	 * by chenhao
	 * 只需要前面两个参数，其余参数为兼容历史问题
	 * 默认为多选，isMulti显示设置为false才单选
	 */
	this.showUserProfileSelect=function(idField,nameField,roleType,rootID,isMulti,defaultNodeID,resourceType,resourceCategory,funtion){
		parent.ET.currentIDField=idField;
		var arg = new Array();
	 	var sUrl="";

		if(typeof roleType == "undefined"){//缺省为选择用户组件
			roleType = 7;
		}
		sUrl += "&roleType="+roleType;
		sUrl += "&rootID="+rootID;
		
		if(typeof isMulti == "undefined"){//缺省为多选组件
			isMulti=true;
		}
		sUrl +="&isMulti="+isMulti;
		
		if(typeof defaultNodeID!='undefined'){
			sUrl +="&defaultNodeID="+defaultNodeID;
		}
		
		if(typeof resourceType!='undefined'){
			sUrl +="&resourceTypeID="+resourceType;
		}
		if(typeof resourceCategory!='undefined'){
			sUrl +="&resourceCategory="+resourceCategory;
		}
		
		sUrl +="&onlyShowNotResource="+ET.onlyShowNotResource;
		sUrl +="&isShowContact="+ET.isShowContact;
		arg.src = ET.etPath+"/../../../UserAction.do?operation=userSelectCommon&_id="+Math.random() + sUrl;
		if(isMulti){
			arg.width = 600;
			arg.height = 350;
		}else{
			arg.width = 420;
			arg.height = 350;
		}
		parent.ET.showModalWindow(arg, function (oRet){
			if (oRet!=null) {
				idField.value=oRet.userIds;
				if(typeof nameField!='undefined' && nameField!=null){
					nameField.value=oRet.userNames;
				}
				if(typeof(parent.onSelectUserOKFun)!='undefined'&&typeof(funtion)=='undefined'){
					parent.onSelectUserOKFun(idField);
				}else if(typeof(funtion)!='undefined'){
					funtion(idField);
				}
			}
		});
	}
	
	
	this.toGoogleSearch=function(){
		var googleSearchInput=document.getElementById('googleSearchInput');
		var value=googleSearchInput.value;
		value=value.trim();
		var toBeSelectedImg=document.getElementById('toBeSelectedImg');
		var toBeSelected=document.getElementById('toBeSelected');
		if(ET.lastNodeID!=ET.currentNodeID&&googleSearchInput.getAttribute("lastValue")==value){
			toBeSelected.style.display="";
			toBeSelectedImg.style.display="none";
			ET.lastNodeID=ET.currentNodeID;
			googleSearchInput.setAttribute("lastValue",value);
			return;
		}
		ET.googleSearchID=setTimeout(this.googleSearch,500);
	}
	
	this.toGoogleSearchRight=function(){
		if(ET.googleSearchIDRightID!=null){
			clearTimeout(ET.googleSearchIDRightID);
		}
		ET.googleSearchIDRightID=setTimeout(this.googleSearchRight,500);
	}
	
	this.init=function(){
		ET.canMoveLeftIDs=new Array();
		ET.canMoveRightIDs=new Array();
		ET.userIDArray2=new Array();
		if(ET.isMulti){
			var alreadySelectedOptions=document.getElementById('alreadySelected').options;
			for(var i=0;i<alreadySelectedOptions.length;i++){
				ET.userIDArray2.push(alreadySelectedOptions[i].value);
			}	
		}
		this.googleSearch();
	}
	
	this.googleSearch=function(){
		var callBackArray=this.callBackArray;
		if(callBackArray==undefined){
			callBackArray=[];
		}
		var googleSearchInput=document.getElementById('googleSearchInput');
		var value=googleSearchInput.value;
		value=value.trim();
		var toBeSelectedImg=document.getElementById('toBeSelectedImg');
		var toBeSelected=document.getElementById('toBeSelected');
		
		if(ET.googleSearchID!=null){
			clearTimeout(ET.googleSearchID);
			ET.googleSearchID=null;
		}
		if(treeSelectUtils.loadUserTimeoutID!=null){
			clearTimeout(treeSelectUtils.loadUserTimeoutID);
			treeSelectUtils.loadUserTimeoutID=null;
		}
		treeSelectUtils.toScrollData=null;
		if(toBeSelectedImg!=null&&toBeSelected!=null ){
			toBeSelectedImg.style.display="block";
			toBeSelected.style.display="none";
		}
		
//		if(!ET.isSelectedGroupNode&&value==""){
//			toBeSelected.innerHTML="";
//			if(toBeSelectedImg!=null ){
//				toBeSelectedImg.style.display="none";
//				toBeSelected.style.display="";
//			}
//			return;
//		}
		var userIDArray=new Array();
		ET.canMoveLeftIDs=new Array();
		
		var resourceTypeID=0;
		
		if(typeof ET.currentResourceType!='undefined'){
			resourceTypeID=ET.currentResourceType;
		}
		var hiddenUserIDStr="";
		if(typeof ET.hiddenUserIDStr!='undefined'){
			hiddenUserIDStr=ET.hiddenUserIDStr;
		}
		var resourceCategory=0;
		if(typeof ET.resourceCategory!='undefined'){
			resourceCategory=ET.resourceCategory;
		}
		for(var i=0,j=callBackArray.length;i<j;i++){
			callBackArray[i].istimeout=true;
		}
		var callBackFun=function(data){
			if(callBackFun.istimeout==undefined){
				displayGoogleSearchData(data);
			}
		}
		callBackArray=[];
		callBackArray.push(callBackFun);
		this.callBackArray=callBackArray;
		var googleSearchInput2=document.getElementById('googleSearchInput2');
		if(googleSearchInput2=='undefined' || googleSearchInput2==null){
			if(ET.isMulti){
				var alreadySelectedOptions=document.getElementById('alreadySelected').options;
				for(var i=0;i<alreadySelectedOptions.length;i++){
					userIDArray.push(alreadySelectedOptions[i].value);
				}	
			}
			if(ET.currentType==40){//组合
				ProjectAction.googleSearch(ET.currentNodeID,value,userIDArray,ET.checkAccess,callBackFun);
			}else if(ET.currentType==41){//部门
				ProjectAction.googleDepartmentSearch(ET.currentNodeID,value,userIDArray,ET.checkAccess,callBackFun);
			}else if(ET.isSelectedGroupNode){
				GroupAction.googleSearch(ET.currentType,ET.currentNodeID,value,userIDArray,callBackFun);
			}else{
				if(resourceCategory!=0){
					ResourceAction.googleSearch(ET.currentType,ET.currentNodeID,value,userIDArray,ET.onlyShowNotResource,resourceTypeID,ET.isSetContact,resourceCategory,callBackFun);
				}else{
					UserAction.googleSearch(ET.currentType,ET.currentNodeID,value,userIDArray,ET.onlyShowNotResource,resourceTypeID,ET.isSetContact,hiddenUserIDStr,callBackFun);
				}
			}
		}else{
			var value2=googleSearchInput2.value;
			if(ET.currentType==40){//组合
				
			}else if(ET.currentType==41){//部门
				
			}else if(ET.isSelectedGroupNode){
				
			}else{
				if(resourceCategory!=0){
					
				}else{
					UserAction.googleSearch2(ET.currentType,ET.currentNodeID,value,value2,ET.userIDArray2,ET.onlyShowNotResource,resourceTypeID,ET.isSetContact,hiddenUserIDStr,callBackFun);
				}
			}
		}
		
	}
	
	this.googleSearchRight=function(){
		var googleSearchInput2=document.getElementById('googleSearchInput2');
		var value2=googleSearchInput2.value;
		var alreadySelectedImg=document.getElementById('alreadySelectedImg');
		if(alreadySelectedImg!=null){
			alreadySelectedImg.style.display="block";
		}
		var alreadySelected=document.getElementById('alreadySelected');
		alreadySelected.style.display="none";
		var hiddenUserIDStr="";
		if(typeof ET.hiddenUserIDStr!='undefined'){
			hiddenUserIDStr=ET.hiddenUserIDStr;
		}
		var resourceCategory=0;
		if(typeof ET.resourceCategory!='undefined'){
			resourceCategory=ET.resourceCategory;
		}
		
		if(ET.currentType==40){//组合
			
		}else if(ET.currentType==41){//部门
			
		}else if(ET.isSelectedGroupNode){
			
		}else{
			if(resourceCategory!=0){
				
			}else{
				UserAction.googleSearchRight(value2,ET.userIDArray2,ET.canMoveRightIDs,hiddenUserIDStr,function(data){
					displayGoogleSearchDataRight(data);
				});
			}
		}
	}
	function displayGoogleSearchData(data){
		var toBeSelected=document.getElementById('toBeSelected');
		var toBeSelectedImg=document.getElementById('toBeSelectedImg');
		var leftUserList=data[0];
		ET.canMoveLeftIDs=data[1];
		var googleSearchInput2=document.getElementById('googleSearchInput2');
		if(googleSearchInput2!='undefined'){
			ET.canMoveRightIDs=data[2];
		}
	
		toBeSelected.innerHTML='';
		var temp=null;
		var option=null;
		var frag=document.createDocumentFragment();
		var toScrollData=null;
		var loadMaxSize=500;
		var max=leftUserList.length;
		if(max>loadMaxSize){
			max=loadMaxSize;
		}
		for(var i=0,j=max;i<j;i++){
			temp=leftUserList[i];
			option=document.createElement('option');
			option.value=temp.id;
			option.innerText=temp.name;
			option.textContent=temp.name;
			if(temp.tips!=undefined&&temp.tips!=null&&temp.tips!="" ){
				option.title=temp.tips;
			}
			frag.appendChild(option);
		}
		toBeSelected.appendChild(frag);
		treeSelectUtils.toScrollData=null;
		if(toBeSelectedImg!=null){
			toBeSelectedImg.style.display="none";
		}
		toBeSelected.style.display="";
		if(leftUserList.length>loadMaxSize){
			toScrollData=leftUserList.splice(loadMaxSize-1,leftUserList.length-loadMaxSize);
			treeSelectUtils.toScrollData=toScrollData;
			treeSelectUtils.loadUserTimeoutID=window.setTimeout(treeSelectUtils.loadOtherUserDataFunction,50);
		}
	}
	this.loadOtherUserDataFunction=function(){
		var toBeSelected=document.getElementById('toBeSelected');
		var  toScrollData= treeSelectUtils.toScrollData;
		if(toScrollData!=null&&toScrollData.length>0){
			var currentScrollData=null;
			if(toScrollData.length>100){
				currentScrollData=toScrollData.splice(0,100);
				treeSelectUtils.toScrollData=toScrollData;
			}else{
				currentScrollData=toScrollData;
				treeSelectUtils.toScrollData=null;
			}
			var frag=document.createDocumentFragment();
			for(var i=0,j=currentScrollData.length;i<j;i++){
				var temp=currentScrollData[i];
				option=document.createElement('option');
				option.value=temp.id;
				option.innerText=temp.name;
				option.textContent=temp.name;
				if(temp.tips!=undefined&&temp.tips!=null&&temp.tips!="" ){
					option.title=temp.tips;
				}
				frag.appendChild(option);
			}
			toBeSelected.appendChild(frag);
			window.clearTimeout(treeSelectUtils.loadUserTimeoutID);
			treeSelectUtils.loadUserTimeoutID=window.setTimeout(treeSelectUtils.loadOtherUserDataFunction,20);
		}else{
			window.clearTimeout(treeSelectUtils.loadUserTimeoutID);
		}
	}
	
	function displayGoogleSearchDataRight(data){
		var alreadySelected=document.getElementById('alreadySelected');
		var alreadySelectedImg=document.getElementById('alreadySelectedImg');
		var rightUserList=data[0];
		ET.canMoveRightIDs=data[1];
		alreadySelected.innerHTML='';
		alreadySelected.options.length=0;
		var temp=null;
		var option=null;
		var frag=document.createDocumentFragment();
		for(var i=0,j=rightUserList.length;i<j;i++){
			temp=rightUserList[i];
			option=document.createElement('option');
			option.value=temp.id;
			option.innerText=temp.name;
			option.textContent=temp.name;
			if(temp.tips!=undefined&&temp.tips!=null&&temp.tips!="" ){
				option.title=temp.tips;
			}
			frag.appendChild(option);
		}
		alreadySelected.appendChild(frag);
		if(alreadySelectedImg!=null){
			alreadySelected.style.display="block";
			alreadySelectedImg.style.display="none";
		}
	}
	
	this.selectToRight=function(){
		if(ET.isMulti){
			var toBeSelected=document.getElementById('toBeSelected');
			var alreadySelected=document.getElementById('alreadySelected');
			var leftOptions=toBeSelected.options;
			var rightOptions=alreadySelected.options;
			var frag=document.createDocumentFragment(); 
			for (var i=leftOptions.length-1;i>=0;i--) {
				var temp=leftOptions[i];
				if (temp.selected&&temp.value!=-1) {
					var value = temp.value;
					temp.selected=false;
					frag.appendChild(temp);
					ET.canMoveLeftIDs.push(value);
				}
			}
			alreadySelected.appendChild(frag);
			if(leftOptions.length>0){
				leftOptions[0].selected = true;
			}
		}else{
			this.selectOK();
		}
	}
	
	this.selectToLeft=function(){
		var toBeSelected=document.getElementById('toBeSelected');
		var alreadySelected=document.getElementById('alreadySelected');
		var leftOptions=toBeSelected.options;
		var rightOptions=alreadySelected.options;
		var frag=document.createDocumentFragment();
		for (var i=rightOptions.length-1;i>=0;i--) {
			var temp=rightOptions[i];
			if (temp.selected) {
				var value = temp.value;
				var text = temp.text;
				var canMoveLeft=false;
				for(var j=0;j<ET.canMoveLeftIDs.length;j++){
					if(value==ET.canMoveLeftIDs[j]){
						canMoveLeft=true;
						break;
					}
				}
				if(canMoveLeft){
					temp.selected=false;
					frag.appendChild(temp);
					//leftOptions[leftOptions.length] = option;
					//toBeSelected.appendChild()
				}else{
					alreadySelected.removeChild(rightOptions[i]);
				}
			}
		}
		toBeSelected.appendChild(frag);
	}
	this.selectOK=function(){
		var alreadySelected=document.getElementById('alreadySelected');
		var rightOptions=alreadySelected.options;
		var toBeSelected=document.getElementById('toBeSelected');
		var leftOptions=toBeSelected.options;
		if(ET.isMulti){
			var userIDArray=new Array();
			var userNameArray=new Array();
			for(var i=0;i<rightOptions.length;i++){
				userNameArray.push(rightOptions[i].text);
				userIDArray.push(rightOptions[i].value);
			}
			ET.currentIDField.value=userIDArray.join(',');
			ET.currentNameField.value=userNameArray.join(',');
		}else{
			var hasSelected=false;
			for(var i=0;i<leftOptions.length;i++){
				if(leftOptions[i].selected){
					ET.currentIDField.value=leftOptions[i].value;
					ET.currentNameField.value=leftOptions[i].text;
					hasSelected=true;
					break;
				}
			}
			if(!hasSelected){
				ET.currentIDField.value='';
				ET.currentNameField.value='';
			}
		}
		if(document.all){
       		ET.currentNameField.fireEvent("onchange");
		}else{
		 	var  evt = document.createEvent( 'HTMLEvents');
			evt.initEvent('change',true,true);
		 	ET.currentNameField.dispatchEvent(evt);
		}
	//	ET.currentNameField.fireEvent("onchange");
		modelDialog.hide(document.getElementById('modelDIV'));
		toBeSelected.innerHTML='';
		alreadySelected.innerHTML='';
		document.getElementById('ajaxTreeDIV').innerHTML='';
		if(typeof onSelectUserOKFun!='undefined'){
			onSelectUserOKFun();
		}
	}
	this.close=function(){
		var alreadySelected=document.getElementById('alreadySelected');
		var toBeSelected=document.getElementById('toBeSelected');
		toBeSelected.innerHTML='';
		alreadySelected.innerHTML='';
		document.getElementById('ajaxTreeDIV').innerHTML='';
		modelDialog.hide(document.getElementById('modelDIV'));
	}
}

ET.canMoveLeftIDs;
ET.canMoveRightIDs=new Array();
ET.alreadyMoveLeftIDs;
ET.googleSearchID=null;
ET.currentIDField;
ET.currentNameField;
ET.currentType;
ET.resourceCategory;
ET.currentNodeID;
ET.isMulti;
ET.checkAccess;
ET.currentResourceType;
ET.hiddenUserIDStr;
ET.onlyShowNotResource=false;//只显示非资源的用户
ET.isShowContact=true;//组件缺省显示联系人
ET.isSetContact=false;//组件缺省不是设置联系人.用来过滤常用联系人
ET.isSelectedGroupNode=false;//当前选中节点是否是联系人分组节点
ET.userIDArray2=new Array();//右侧所有的节点，不只是显示出来的

var treeSelectUtils;
if(typeof treeSelectUtils=="undefined"){
	treeSelectUtils=new ET_TreeSelectUtils();
}


var OpacityTipDIV = function(content){
	this.div;
	this.subDiv;
	this.content = "";
	if(content != undefined && content != null){
		this.content = content;
	}
	this.show = function(){
		if(this.div == undefined || this.div == null){
			this.div = document.createElement("DIV");
			this.div.id = "tipOpacityDIV";
			this.div.className = "tipOpacityDIV";
			document.body.appendChild(this.div);
		}
		if( this.subDiv == undefined || this.subDiv == null){
			this.subDiv = document.createElement("DIV");
			this.subDiv.id = "subTipDIV";
			this.subDiv.className = "subTipDIV";
			document.body.appendChild(this.subDiv);
		}
		this.subDiv.innerHTML = "<div style='position: relative;margin: 0px auto;background-color:#fff;width:200px;border:1px solid #ccc;padding-left:10px;padding-right:20px;'><p style='padding-top:20px;'>" +
			 "<img src='" + ET.etPath + "../../images/32x32/Loading.gif'/></p><p style='color:black;padding-bottom:20px;'>" + this.content + "</p><div>";
		this.div.style.display = "block";
		this.subDiv.style.display = "block";
	}
	this.hide = function(){
		if(this.div != undefined && this.div != null){
			this.div.style.display = "none";
		}
		if(this.subDiv != undefined && this.subDiv != null){
			this.subDiv.style.display = "none";
		}
	}
};
var opacityTipDIV;
if(typeof opacityTipDIV == "undefined"){
	opacityTipDIV = new OpacityTipDIV();
}

