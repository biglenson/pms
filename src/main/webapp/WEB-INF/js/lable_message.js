jQuery(document).ready(function(){
	//IE BUG ,readyOnly 输入 BackSpace 键，会返回历史页面
	jQuery("input[type=text][readOnly]").on("keydown",function(event){
		if(event.which==8){ // BackSpace 键
			event.preventDefault();
		}
	});
	var Nav_NavSelectHiddenDIV=jQuery("#Nav_NavSelectHiddenDIV");
	var header_liList=jQuery(".header-box .Nav li ");
	if(Nav_NavSelectHiddenDIV.size()>0){
			var	detaiObjFx=new ET.FloatDIV("NavSelectContainer",{
				onHide:function(){
					Nav_NavSelectHiddenDIV.removeClass('over');
					Nav_NavSelectHiddenDIV.removeClass('click');
				}
			});
			Nav_NavSelectHiddenDIV.data("detaiObj",detaiObjFx);
			Nav_NavSelectHiddenDIV.on('mouseover',function(event){
					Nav_NavSelectHiddenDIV.addClass('over');
			}).on('mouseout',function(event){
				if(!Nav_NavSelectHiddenDIV.hasClass('click')){
					Nav_NavSelectHiddenDIV.removeClass('over');
				}
			}).on('click',function(event){
				var detaiObj=Nav_NavSelectHiddenDIV.data("detaiObj");
				var position=Nav_NavSelectHiddenDIV[0].getBoundingClientRect();
				detaiObj.popupPosition({
					top:54,
					left:0
				})
				detaiObj.sourceElement.style.left=position.right-detaiObj.sourceElement.offsetWidth+"px";
				Nav_NavSelectHiddenDIV.addClass("click");
				
				var login_detaiObj=jQuery("#logInfoDIV_HelpDetail").data("detaiObj");
				if(login_detaiObj!=null){
					login_detaiObj.hide();
				}
		});
		jQuery(document.body).on("click",'#NavSelectContainerContent .topHeader_content.menuTitle,  #module_changeSplitMenuID .module_changeSplitMenuItem',function(event){
			var obj=$(this);
			var link=obj.attr("link");
			window.location.href=link;
		});
		var NavSelectHiddenFun=function(){
		var showNavSelect=false;
		var module_changeSplitMenuID=jQuery("#module_changeSplitMenuID");
		var contentDIV=	jQuery("#NavSelectContainerContent");
		var html=[];
		for(var i=0,j=header_liList.size();i<j;i++){
			var obj=header_liList[i];
			if(obj.getBoundingClientRect().top==0){
				continue;
			}
			if($(obj).find("a").size()==0){
				var menuID=$(obj).find("span").attr("menuID");
				html.push("<div class='topHeader_content  menuHeadTitle' >"+$(obj).find("span").html()+"</div>");
				var links=module_changeSplitMenuID.find("tr[menuID='"+menuID+"'] td div.module_changeSplitMenuItem");
				links.each(function(index,obj){
					var $this=$(this);
					var div="<div class='topHeader_content subMenu menuTitle' link='"+$this.attr("link")+"'  >"+$this.html()+"</div>"	;
					html.push(div);
				})
				if(links.size()>0){
					var div="<div class='topHeader_content menuLineSplit'  ></div>"	;
					html.push(div);
				}
			}else{
				if($(obj).hasClass("topon")){
					continue;
				}
				if(obj.getBoundingClientRect().top>0){
					showNavSelect=true;
					var div="<div class='topHeader_content menuTitle' link='"+$(obj).find("a").attr("href")+"'  >"+$(obj).find("a").html()+"</div>"	;
					html.push(div);
				}
			}
			contentDIV.html(html.join(""));
		}
		Nav_NavSelectHiddenDIV.css("display",showNavSelect?"block":"none");
		Nav_NavSelectHiddenDIV.data("detaiObj").hide();
	}
	NavSelectHiddenFun();
	jQuery(window).on('resize',NavSelectHiddenFun);
	}
	
	var bodyStart_dragDIV=document.getElementById("bodyStart_dragDIV");
	if(bodyStart_dragDIV!=null){
		(function() {
			var jDrag=jQuery(bodyStart_dragDIV);
			var doc=jQuery(document);
			var bodyAllLeft=jQuery("#bodyLeftAllDIV");
			var contentDIV=jQuery("#bodyStart__content_Wrap");
			var dragStartX=undefined;
			var oldWidth=null;
			var firstWidth=bodyAllLeft.width();
			jDrag.data("resoteLeft",jDrag.css("left"));
			contentDIV.data("resoteLeft",contentDIV.css("width"));
			bodyAllLeft.data("resoteWidth",bodyAllLeft.css("width"));
			var maxWidth=null;
			var minWidth=ET.leftMinWidth||70;
			jDrag.on('mousedown touchstart ',function(event){
				var type=event.type;
				event.preventDefault();
				if(ET.popWindows.length>0){
					var opacityHidden=contentDIV.data('opacityHidden');
					if(opacityHidden==null){
						opacityHidden=jQuery("<div class='opacityHidden' />");
						opacityHidden.appendTo(contentDIV);
						contentDIV.data("opacityHidden",opacityHidden);
					}
					opacityHidden.css(
								{"zIndex":ET.zIndex++,
								"display":"block"}
						);
				}
				
				if(bodyStart_dragDIV.setCapture){
					bodyStart_dragDIV.setCapture();
				}else{
					window.captureEvents(Event.MOUSEMOVE|Event.MOUSEUP);
				}
				maxWidth=jQuery(document.body).width()*3/4;
				dragStartX=event.pageX;
				oldWidth=bodyAllLeft.width();
				doc.off("mousemove touchmove",startDrag).on("mousemove touchmove",startDrag);
				doc.off("mouseup touchend",releaseDrag).on("mouseup touchend",releaseDrag);
			});
			var startDrag=function(event){
				event.preventDefault();
				var currentX=event.type!='touchmove'?event.pageX:event.originalEvent[touches].pageX;
				if(dragStartX!=undefined){
					var changeWidth=currentX-dragStartX;
					var newWidth=oldWidth+changeWidth;
					if(newWidth>minWidth&& newWidth<maxWidth){
						bodyAllLeft.css("width",parseInt(bodyAllLeft.css("width"),10)+changeWidth );
						jDrag.css("left",parseInt(jDrag.css("left"),10)+changeWidth);
						contentDIV.css("left",parseInt(contentDIV.css("left"),10)+changeWidth);
						dragStartX=currentX;
						oldWidth=parseInt(bodyAllLeft.css("width"),10);
					}else{
						//releaseDrag(event);
					}
				}
			}
			function releaseDrag(event){
				event.preventDefault();
		       	if(bodyStart_dragDIV.releaseCapture){//拖动释放
		       		bodyStart_dragDIV.releaseCapture();
				}else if(window.releaseEvents){
					window.releaseEvents(Event.MOUSEMOVE|Event.MOUSEUP);
				}
				dragStartX=undefined;
				//oldWidth=null;
				doc.off('mousemove touchmove',startDrag );
				doc.off('mouseup touchend',releaseDrag );
				
				var opacityHidden=contentDIV.data('opacityHidden');
				if(opacityHidden){
					opacityHidden.css('display',"none");
				}
				//ET.Utils.writeCookie("changWidth"+document.frm.menuID.value, parseInt(bodyAllLeft.css("width"),10)-firstWidth);
				for(var i=0,j=ET.toggleLeftEvent.length;i<j;i++){
					var fun=ET.toggleLeftEvent[i];
					if(typeof(fun)=='string'){
						window.eval(fun	);
					}else if(typeof(fun)=='function'){
						fun();
					}
				}
			}
		})();
	}
	var _lastToolBarClickObj=null;
	var _lastTooBarTarget=null;
	jQuery('img[overImg]').on('mouseenter',function(event){
		var element=this;
		var src=element.src;
		var overImg=element.getAttribute("overImg");
		if(overImg!=null&&overImg!=src){
			if(element.getAttribute("outImg")==null){
				element.setAttribute("outImg",src);
			}
			element.src=overImg;
		}
	}).on('mouseleave',function(event){
		var element=this;
		var src=element.src;
		var outImg=element.getAttribute("outImg");
		if(outImg!=null&& outImg!=undefined&&outImg!=src){
			element.src=outImg;
		}
	});
	jQuery("div.ET_ToolbarButtonContainer").on('mouseenter',function(event){
			var obj=jQuery(this);
			if(!obj.hasClass('labelDisable')){
				obj.addClass("ET_ToolbarButtonContainerHover");
				var img=obj.find('.ET_ToolbarButtonImg img');
				img.each(function(index,element){
					var src=element.src;
					var overImg=element.getAttribute("overImg");
					if(overImg!=null&&overImg!=src){
						if(element.getAttribute("outImg")==null){
							element.setAttribute("outImg",src);
						}
						element.src=overImg;
					}
				})
			}
	}).on('mouseleave',function(event){
		var obj=jQuery(this);
		if(!obj.hasClass('labelDisable')){
			obj.removeClass("ET_ToolbarButtonContainerHover");
			var img=obj.find('.ET_ToolbarButtonImg img');
			img.each(function(index,element){
				var src=element.src;
				var outImg=element.getAttribute("outImg");
				if(outImg!=null&& outImg!=undefined&&outImg!=src){
					element.src=outImg;
				}
			})
		}
	}).on('click',function(event){
		var obj=jQuery(this);
		if(!obj.hasClass('labelDisable')) {
			if(_lastToolBarClickObj!=null){
				jQuery(_lastToolBarClickObj).removeClass('currentClickButton');
			}
			obj.addClass('currentClickButton');
			_lastToolBarClickObj=this;
			_lastTooBarTarget=event.target; //标识是事件源
		}
	})
	
	jQuery(document.body).on('click',function(event){
		var target=event.target;
		if(_lastToolBarClickObj&&_lastTooBarTarget!=target){//是不同事件源
			if(!(window.menuObj&&window.menuObj.isCurrentClickFlag)){ //如果是点击浮动层
				var clicObj=jQuery(target).parent('div.ET_ToolbarButtonContainer');
				if(clicObj.length==0){
					window.setTimeout(function(){
						jQuery(_lastToolBarClickObj).removeClass('currentClickButton');
					},500);
				}
			}
		}
		if(window.menuObj){
			window.menuObj.isCurrentClickFlag=false;
		}
		_lastTooBarTarget=null;//重置事件源
	})
});

function isLeave() {
	var doc=document;
	var win=window;
	var pop_windows= ET.popWindows;
	if(pop_windows.length>0){
		var lastIframe=pop_windows[pop_windows.length-1].iframe;
		doc= lastIframe.contentDocument||lastIframe.contentWindow.document;
		win=lastIframe.contentWindow;
	}
	if(doc.frm&&doc.frm.pleaseUnlock != null) {
		if(confirm(ET.label.LeaveWithoutSavingConfirm)) {
			 if(doc.frm.pleaseUnlock.value=='needUnlock'){
			 	if(typeof win['needUnlock'] =='function'){ win.needUnlock(); }
			 }
			 doc.frm.pleaseUnlock.value='yes';
			 return true;
		} else {
		 	return false; 
		}
	}
 	return true;
} 
function topScript_gotoUrl(url){
	window.location.href=url;
}
function dwr_errh(msg, exc) {
	if(exc.javaClassName ==ET.label["SessionTimeoutException"]) {
  		alert(ET.label["profile.SessionTimeOut.Reason"]);
  		parent.location.href =ET.path+ "/logout.jsp";
  	} else {
  	}
}
function onloadForDWR(){
	if(window.dwr.engine!=undefined){
		ET.addDwrErrorEvent(dwr_errh);
		dwr.engine.setErrorHandler(function(msg,exc){
			ET.dwrErrorFun(msg,exc);
		});
	}
}
ET.Utils.addEvent(window,'load',onloadForDWR);

function exit() {
	if(confirm(ET.label["ConfirmLogout"])) {
		 window.location =ET.path+"/LoginAction.do?operation=logout";
	}
}
function about() {
  	var arg=new Array();arg.src=ET.path+"/jsp/about.jsp";
  	arg.title=ET.label["about"];
  	arg.width=300;
  	arg.height=200;
  	ET.showModalWindow(arg);
 }

function serverInfo(){
	var arg=new Array();arg.src=ET.path+"/jsp/serverInfo.jsp";
		arg.title=ET.label["webServerInfo"];
		arg.width=300;
		arg.height=200;
		ET.showModalWindow(arg);
}