if (typeof ET == "undefined") {
	ET = function () {
	};
}
if (!String.prototype.trim ) {
	String.prototype.trim=function(){
	     return this.replace(/(^\s*)|(\s*$)/g, '');
	}
};
if (!Array.prototype.indexOf)
{
  Array.prototype.indexOf = function(elt /*, from*/)
  {
    var len = this.length >>> 0;
    var from = Number(arguments[1]) || 0;
    from = (from < 0)
         ? Math.ceil(from)
         : Math.floor(from);
    if (from < 0)
      from += len;
    for (; from < len; from++)
    {
      if (from in this &&
          this[from] === elt)
        return from;
    }
    return -1;
  };
}
if (!Function.prototype.bind) {
  Function.prototype.bind = function (oThis) {
    if (typeof this !== "function") {
      // closest thing possible to the ECMAScript 5 internal IsCallable function
      throw new TypeError("Function.prototype.bind - what is trying to be bound is not callable");
    }

    var aArgs = Array.prototype.slice.call(arguments, 1), 
        fToBind = this, 
        fNOP = function () {},
        fBound = function () {
          return fToBind.apply(this instanceof fNOP && oThis
                                 ? this
                                 : oThis || window,
                               aArgs.concat(Array.prototype.slice.call(arguments)));
        };

    fNOP.prototype = this.prototype;
    fBound.prototype = new fNOP();

    return fBound;
  };
}
if (!window.JSON) {
  window.JSON = {
    parse: function(sJSON) { return eval('(' + sJSON + ')'); },
    stringify: (function () {
      var toString = Object.prototype.toString;
      var isArray = Array.isArray || function (a) { return toString.call(a) === '[object Array]'; };
      var escMap = {'"': '\\"', '\\': '\\\\', '\b': '\\b', '\f': '\\f', '\n': '\\n', '\r': '\\r', '\t': '\\t'};
      var escFunc = function (m) { return escMap[m] || '\\u' + (m.charCodeAt(0) + 0x10000).toString(16).substr(1); };
      var escRE = /[\\"\u0000-\u001F\u2028\u2029]/g;
      return function stringify(value) {
        if (value == null) {
          return 'null';
        } else if (typeof value === 'number') {
          return isFinite(value) ? value.toString() : 'null';
        } else if (typeof value === 'boolean') {
          return value.toString();
        } else if (typeof value === 'object') {
          if (typeof value.toJSON === 'function') {
            return stringify(value.toJSON());
          } else if (isArray(value)) {
            var res = '[';
            for (var i = 0; i < value.length; i++)
              res += (i ? ', ' : '') + stringify(value[i]);
            return res + ']';
          } else if (toString.call(value) === '[object Object]') {
            var tmp = [];
            for (var k in value) {
              if (value.hasOwnProperty(k))
                tmp.push(stringify(k) + ': ' + stringify(value[k]));
            }
            return '{' + tmp.join(', ') + '}';
          }
        }
        return '"' + value.toString().replace(escRE, escFunc) + '"';
      };
    })()
  };
}


ET.findChildByTagName = function(parentObj,tagName,childIdOrName){
	var oRet = null;
	var objs = parentObj.getElementsByTagName(tagName);
	for(var i=0;i<objs.length;i++){
		if(objs[i].id==childIdOrName||objs[i].getAttribute("name")==childIdOrName){
			oRet = objs[i];
			break;
		}
	}
	return oRet;
}

ET.iteratorChild = function(idOrName,context,oRet){
	var childItems = context.childNodes;
	if(childItems&&childItems.length>0){
		for(var i=0;i<childItems.length;i++){
			if(childItems[i].nodeType != 1)continue;
			if(childItems[i].id==idOrName||childItems[i].getAttribute("name")==idOrName){
				oRet.push(childItems[i]);
				break;
			}
		}
		if(oRet.length==0){
			for(var i=0;i<childItems.length;i++){
				if(childItems[i].nodeType != 1)continue;
				ET.iteratorChild(idOrName,childItems[i],oRet);
				if(oRet.length>0)break;
			}
		}
	}
}
document.onkeydown = function (event) {
	event=event||window.event;
	var keyCode=0;
	if(typeof event.charCode =='number'){
		keyCode=event.charCode;
	}else{
		keyCode=event.keyCode;
	}
	if (keyCode == 8) { //Backspace
		var target=event.srcElement||event.target;
		var tagName = target.tagName.toLowerCase();
		var typeName =target.type!=null? target.type.toLowerCase():"";
		if (((tagName == "input" || tagName == "textarea") &&target.readOnly) || (tagName == "input" && (typeName == "checkbox" || typeName == "radio")) || tagName == "select") {
			if(event.preventDefault){
				event.preventDefault();
			}else{
				event.returnValue = false;
			}
		}
	}
};
(function(){
	_$ = window.$;
	window.$ = function(id, context,tagName){
		if(context&&tagName) {
			return ET.findChildByTagName(context,tagName,id);
		}
		if(context&&!tagName){
			var oRet = [];
			if(!context)return null;
			ET.iteratorChild(id,context,oRet);
			return oRet[0];
		}
		var a = document.getElementsByName(id);
		if(a.length > 0) {
			if(a.length == 1) {
				return a[0];
			} else if (a.length > 1){
				return a;
			} 
		}
		return document.getElementById(id);
	}
})();
var getObject = ET.getObject = window.$;

ET.version = "10-01";
ET.is_opera = /opera/i.test(navigator.userAgent);
ET.is_ie = (/msie/i.test(navigator.userAgent) && !ET.is_opera);
ET.is_ie6 = (ET.is_ie && /msie 6\.0/i.test(navigator.userAgent));
ET.is_ie7 = (ET.is_ie && /msie 7\.0/i.test(navigator.userAgent));
ET.is_ie8 = (ET.is_ie && /msie 8\.0/i.test(navigator.userAgent));
ET.is_ie9 = (ET.is_ie && /msie 9\.0/i.test(navigator.userAgent));
ET.is_ie10 = (ET.is_ie && /msie 10\.0/i.test(navigator.userAgent));
ET.is_ie11 = (ET.is_ie && /msie 11\.0/i.test(navigator.userAgent));
ET.is_ie12 = (ET.is_ie && /msie 12\.0/i.test(navigator.userAgent));
ET.is_chrome = /Chrome/i.test(navigator.userAgent);
ET.is_safari = /Safari/i.test(navigator.userAgent);
ET.is_firefox = /firefox/i.test(navigator.userAgent);
ET.is_mac_ie = (/msie.*mac/i.test(navigator.userAgent) && !ET.is_opera);
ET.is_khtml = /Chrome|Safari|Konqueror|AppleWebKit|KHTML/i.test(navigator.userAgent);
ET.is_konqueror = /Konqueror/i.test(navigator.userAgent);
ET.is_gecko = /Gecko/i.test(navigator.userAgent);
ET.is_webkit = /WebKit/i.test(navigator.userAgent);
ET.webkitVersion = ET.is_webkit ? parseInt(navigator.userAgent.replace(/.+WebKit\/([0-9]+)\..+/, "$1")) : -1;
if (typeof etDoNotInclude == "undefined") {
	etDoNotInclude = 0;
}
if (typeof etDoNotLoadThemes == "undefined") {
	etDoNotLoadThemes = 0;
}
if (ET.doNotInclude) {
	etDoNotInclude = 1;
}
if (typeof etDict != "function") {
	etDict = ET.Dict = function () {
	};
	ET.Dict.phrases = {};
	ET.Dict.set = function (oDict) {
		var aPhrases = etDict.phrases;
		function fFlatten(prefix, values) {
			if (typeof values == "string") {
				aPhrases[prefix] = values;
				return;
			}
			if (prefix != "") {
				prefix += ".";
			}
			for (var sKey in values) {
				fFlatten(prefix + sKey, values[sKey]);
			}
		}
		fFlatten("", oDict);
	};
	etTranslate = ET.translate = ET.Dict.translate = function (sPhrase) {
		var oPhrases = etDict.phrases;
		if (oPhrases[sPhrase]) {
			sPhrase = oPhrases[sPhrase];
		}
		if (arguments.length > 1 && typeof (sPhrase) == "string") {
			for (var ii = 1; ii < arguments.length; ii++) {
				var re = new RegExp("(^|([^\\\\]))%" + ii);
				sPhrase = sPhrase.replace(re, "$2" + arguments[ii]);
			}
		}
		return sPhrase;
	};
	etTranslateArray = ET.translateArray = ET.Dict.translateArray = function (aArray) {
		var iLen = aArray.length;
		for (var iItem = 0; iItem < iLen; iItem++) {
			aArray[iItem] = etTranslate(aArray[iItem]);
		}
		return aArray;
	};
}
if (typeof ET.etPath == "undefined") {
	ET.etPath = function () {
		if (document.documentElement) {
			var aTokens = document.documentElement.innerHTML.match(/<script[^>]+src="([^"]*et(-src)?\.js[^"]*)"/i);
			if (aTokens && aTokens.length >= 2) {
				aTokens = aTokens[1].split("?");
				aTokens = aTokens[0].split("/");
				if (Array.prototype.pop) {
					aTokens.pop();
				} else {
					aTokens.length -= 1;
				}
				return aTokens.length ? aTokens.join("/") + "/" : "";
			}
		}
		return "";
	}();
}
ET.getCurrentlanguage=function(){
	var lan = "zh";
	if(ET.i18n){
		lan=ET.i18n;
	}else if(window.top.ET.i18n){
		lan=window.top.ET.i18n;
	}
	if(lan=="undefined"||lan==""){
		lan = "zh";
	}
	return lan;
}
if (typeof etUtils != "function") {
	ET.Utils = function () {
	};
	etUtils = ET.Utils;
	ET.Utils.throttle=function(method,delay,duration){
		var timer=null, begin=new Date();
        return function(){
            var context=this, args=arguments, current=new Date();;
            clearTimeout(timer);
            if(current-begin>=duration){
                 method.apply(context,args);
                 begin=current;
            }else{
                timer=setTimeout(function(){
                    method.apply(context,args);
                },delay);
            }
        }
	};
	ET.Utils.getElementOffset = function (oEl) {
		if (!oEl) {
			return;
		}
		var iLeft = iTop = iWidth = iHeight = 0;
		var sTag;
		if (typeof oEl.getBoundingClientRect == "function") {
			var oRect = oEl.getBoundingClientRect();
			iLeft = oRect.left;
			iTop = oRect.top;
			iWidth = oRect.right - iLeft;
			iHeight = oRect.bottom - iTop;
			iLeft += etUtils.getPageScrollX();
			iTop += etUtils.getPageScrollY();
			if (ET.is_ie) {
				iLeft -= 2;
				iTop -= 2;
			}
		} else {
			iWidth = oEl.offsetWidth;
			iHeight = oEl.offsetHeight;
			var sPos = ET.Utils.getStyleProperty(oEl, "position");
			if (sPos == "fixed") {
				iLeft = oEl.offsetLeft + ET.Utils.getPageScrollX();
				iTop = oEl.offsetTop + ET.Utils.getPageScrollY();
			} else {
				if (sPos == "absolute") {
					while (oEl) {
						sTag = oEl.tagName;
						if (sTag) {
							sTag = sTag.toLowerCase();
							if (sTag != "body" && sTag != "html" || ET.is_khtml) {
								iLeft += parseInt(oEl.offsetLeft, 10) || 0;
								iTop += parseInt(oEl.offsetTop, 10) || 0;
							}
						}
						oEl = oEl.offsetParent;
						sTag = oEl ? oEl.tagName : null;
						if (sTag) {
							sTag = sTag.toLowerCase();
							if (sTag != "body" && sTag != "html") {
								iLeft -= oEl.scrollLeft;
								iTop -= oEl.scrollTop;
							}
						}
					}
				} else {
					var bMoz = (ET.is_gecko && !ET.is_khtml);
					var fStyle = ET.Utils.getStyleProperty;
					var oP = oEl;
					while (oP) {
						if (bMoz) {
							sTag = oP.tagName;
							if (sTag) {
								sTag = sTag.toLowerCase();
								if (sTag == "body" && !(fStyle(oP, "-moz-box-sizing") == "border-box")) {
									iLeft += parseInt(fStyle(oP, "border-left-width"));
									iTop += parseInt(fStyle(oP, "border-top-width"));
								}
							}
						}
						iLeft += parseInt(oP.offsetLeft, 10) || 0;
						iTop += parseInt(oP.offsetTop, 10) || 0;
						oP = oP.offsetParent;
					}
					oP = oEl;
					while (oP.parentNode) {
						oP = oP.parentNode;
						sTag = oP.tagName;
						if (sTag) {
							sTag = sTag.toLowerCase();
							if (sTag != "body" && sTag != "html" && sTag != "tr") {
								iLeft -= oP.scrollLeft;
								iTop -= oP.scrollTop;
							}
						}
					}
				}
			}
		}
		return {left:iLeft, top:iTop, x:iLeft, y:iTop, width:iWidth, height:iHeight};
	};
	etUtilsGetElementOffset = ET.Utils.getElementOffset;
	ET.Utils.getElementOffsetScrollable = function (oEl) {
		var oOffset = etUtilsGetElementOffset(oEl);
		if (!oOffset) {
			return;
		}
		if (oEl.scrollLeft) {
			oOffset.left -= oEl.scrollLeft;
			oOffset.x = oOffset.left;
		}
		if (oEl.scrollTop) {
			oOffset.top -= oEl.scrollTop;
			oOffset.y = oOffset.top;
		}
		return oOffset;
	};
	ET.Utils.getElementOffsetRelative = function (oEl) {
		var fOffset = etUtils.getElementOffsetScrollable;
		var oOffset = fOffset(oEl);
		if (!oOffset) {
			return;
		}
		var oEl = oEl.offsetParent;
		while (oEl) {
			var sPosition = etUtils.getStyleProperty(oEl, "position");
			if (sPosition != "static") {
				var oOffsetParent = fOffset(oEl);
				oOffset.left -= oOffsetParent.left;
				oOffset.x = oOffset.left;
				oOffset.top -= oOffsetParent.top;
				oOffset.y = oOffset.top;
				return oOffset;
			}
			oEl = oEl.offsetParent;
		}
		return oOffset;
	};
	ET.Utils.fixBoxPosition = function (box, leave) {
		var screenX = ET.Utils.getPageScrollX();
		var screenY = ET.Utils.getPageScrollY();
		var sizes = ET.Utils.getWindowSize();
		leave = parseInt(leave, 10) || 0;
		if (box.x < screenX) {
			box.x = screenX + leave;
		}
		if (box.y < screenY) {
			box.y = screenY + leave;
		}
		if (box.x + box.width > screenX + sizes.width) {
			box.x = screenX + sizes.width - box.width - leave;
		}
		if (box.y + box.height > screenY + sizes.height) {
			box.y = screenY + sizes.height - box.height - leave;
		}
	};
	ET.Utils.isRelated = function (el, evt) {
		evt || (evt = window.event);
		var related = evt.relatedTarget;
		if (!related) {
			var type = evt.type;
			if (type == "mouseover") {
				related = evt.fromElement;
			} else {
				if (type == "mouseout") {
					related = evt.toElement;
				}
			}
		}
		try {
			while (related) {
				if (related == el) {
					return true;
				}
				related = related.parentNode;
			}
		}
		catch (e) {
		}
		return false;
	};
	ET.Utils.removeClass = function (el, className) {
		var result=false;
		if (!(el && el.className)) {
			return result;
		}
		var cls = el.className.split(" ");
		for (var i = cls.length; i > 0; ) {
			if (cls[--i] == className) {
				cls.splice(i, 1);
				result=true;
			}
		}
		el.className = cls.join(" ");
		return true;
	};
	ET.Utils.hasClass = function (el, className) {
		var cls = el.className.split(" ");
		for (var i = cls.length; i > 0; ) {
			if (cls[--i] == className) {
				return true;
			}
		}
		return false;
	};
	ET.Utils.addClass = function (el, className) {
		ET.Utils.removeClass(el, className);
		el.className += " " + className;
	};
	ET.Utils.replaceClass = function (el, className, withClassName) {
		if (!ET.isHtmlElement(el) || !className) {
			return false;
		}
		el.className = el.className.replace(className, withClassName);
	};
	ET.Utils.getElement = function (ev) {
		if (ET.is_ie) {
			if (window.event) {
				return window.event.srcElement;
			} else {
				return null;
			}
		} else {
			return ev.currentTarget;
		}
	};
	ET.Utils.getTargetElement = function (ev) {
		if (ET.is_ie) {
			if (window.event) {
				return window.event.srcElement;
			} else {
				return null;
			}
		} else {
			return ev.target;
		}
	};
	ET.Utils.getMousePos = function (oEv) {
		oEv || (oEv = window.event);
		var oPos = {pageX:0, pageY:0, clientX:0, clientY:0};
		if (oEv) {
			var bIsPageX = (typeof oEv.pageX != "undefined");
			var bIsClientX = (typeof oEv.clientX != "undefined");
			if (bIsPageX || bIsClientX) {
				if (bIsPageX) {
					oPos.pageX = oEv.pageX;
					oPos.pageY = oEv.pageY;
				} else {
					oPos.pageX = oEv.clientX + ET.Utils.getPageScrollX();
					oPos.pageY = oEv.clientY + ET.Utils.getPageScrollY();
				}
				if (bIsClientX) {
					oPos.clientX = oEv.clientX;
					oPos.clientY = oEv.clientY;
				} else {
					oPos.clientX = oEv.pageX - ET.Utils.getPageScrollX();
					oPos.clientY = oEv.pageY - ET.Utils.getPageScrollY();
				}
			}
		}
		return oPos;
	};
	ET.Utils.stopEvent = function (oEvent) {
		oEvent || (oEvent = window.event);
		if (oEvent) {
			if (oEvent.stopPropagation) {
				oEvent.stopPropagation();
			}
			oEvent.cancelBubble = true;
			if (oEvent.preventDefault) {
				oEvent.preventDefault();
			}
			oEvent.returnValue = false;
		}
		return false;
	};
	ET.Utils.removeOnUnload = [];
	
	ET.Utils.windowResizeEvents=[];
	
	ET.Utils.windowResize=function(){
		for(var i=0,j=ET.Utils.windowResizeEvents.length;i<j;i++){
			try{
				ET.Utils.windowResizeEvents[i]();
			}catch(ex){
			}
		}
	}
	
	ET.Utils.addEvent = function (oElement, sEvent, fListener, bUseCapture, bRemoveOnUnload) {
		if(oElement==window&& sEvent=='resize'){
			ET.Utils.windowResizeEvents.push(fListener);
		}
		if (oElement.addEventListener) {
			if (!bUseCapture) {
				bUseCapture = false;
			}
			oElement.addEventListener(sEvent, fListener, bUseCapture);
		} else {
			if (oElement.attachEvent) {
				oElement.detachEvent("on" + sEvent, fListener);
				oElement.attachEvent("on" + sEvent, fListener);
				if (bUseCapture) {
					oElement.setCapture(false);
				}
			}
		}
		if (typeof bRemoveOnUnload == "undefined") {
			bRemoveOnUnload = true;
		}
		if (bRemoveOnUnload) {
			etUtils.removeOnUnload.push({"element":oElement, "event":sEvent, "listener":fListener, "capture":bUseCapture});
		}
	};
	ET.Utils.removeEvent = function (oElement, sEvent, fListener, bUseCapture) {
		if (oElement.removeEventListener) {
			if (!bUseCapture) {
				bUseCapture = false;
			}
			oElement.removeEventListener(sEvent, fListener, bUseCapture);
		} else {
			if (oElement.detachEvent) {
				oElement.detachEvent("on" + sEvent, fListener);
			}
		}
		for (var iLis = ET.Utils.removeOnUnload.length - 1; iLis >= 0; iLis--) {
			var oParams = ET.Utils.removeOnUnload[iLis];
			if (!oParams) {
				continue;
			}
			if (oElement == oParams["element"] && sEvent == oParams["event"] && fListener == oParams["listener"] && bUseCapture == oParams["capture"]) {
				ET.Utils.removeOnUnload[iLis] = null;
				ET.Utils.removeEvent(oParams["element"], oParams["event"], oParams["listener"], oParams["capture"]);
			}
		}
	};
	ET.Utils.onloadEvents = [];
	ET.Utils.addOnloadEvent = function (sEvent) {
		if(typeof sEvent=='string'){
			ET.Utils.onloadEvents[ET.Utils.onloadEvents.length] = function(){
				window.eval(sEvent);
			};
		}else{
			ET.Utils.onloadEvents[ET.Utils.onloadEvents.length]=sEvent;
		}
	};
	ET.Utils.onloadEvent = function () {
		for (var i = 0,j= ET.Utils.onloadEvents.length;i<j; i++) {
			ET.Utils.onloadEvents[i]();
		}
	};
	ET.Utils.createElement = function (type, parent, selectable) {
		var el = null;
		if (document.createElementNS) {
			el = document.createElementNS("http://www.w3.org/1999/xhtml", type);
		} else {
			el = document.createElement(type);
		}
		if (typeof parent != "undefined" && parent != null) {
			parent.appendChild(el);
		}
		if (!selectable) {
			if (ET.is_ie) {
				el.setAttribute("unselectable", true);
			}
			if (ET.is_gecko) {
				el.style.setProperty("-moz-user-select", "none", "");
			}
		}
		return el;
	};
	ET.Utils.writeCookie = function (name, value, domain, path, exp_days) {
		value = escape(value);
		var ck = name + "=" + value, exp;
		if (domain) {
			ck += ";domain=" + domain;
		}
		if (path) {
			ck += ";path=" + path;
		}
		if (exp_days) {
			exp = new Date();
			exp.setTime(exp_days * 86400000 + exp.getTime());
			ck += ";expires=" + exp.toGMTString();
		}
		document.cookie = ck;
	};
	ET.Utils.getCookie = function (name) {
		var pattern = name + "=";
		var tokenPos = 0;
		while (tokenPos < document.cookie.length) {
			var valuePos = tokenPos + pattern.length;
			if (document.cookie.substring(tokenPos, valuePos) == pattern) {
				var endValuePos = document.cookie.indexOf(";", valuePos);
				if (endValuePos == -1) {
					endValuePos = document.cookie.length;
				}
				return unescape(document.cookie.substring(valuePos, endValuePos));
			}
			tokenPos = document.cookie.indexOf(" ", tokenPos) + 1;
			if (tokenPos == 0) {
				break;
			}
		}
		return null;
	};
	ET.Utils.makePref = function (obj) {
		function stringify(val) {
			if (typeof val == "object" && !val) {
				return "null";
			} else {
				if (typeof val == "number" || typeof val == "boolean") {
					return val;
				} else {
					if (typeof val == "string") {
						return "\"" + val.replace(/\x22/, "\\22") + "\"";
					} else {
						return null;
					}
				}
			}
		}
		var txt = "", i;
		for (i in obj) {
			txt += (txt ? ",'" : "'") + i + "':" + stringify(obj[i]);
		}
		return txt;
	};
	ET.Utils.loadPref = function (sCookie) {
		var oCookie = etTransport.parseJson({strJson:"{" + sCookie + "}"});
		if (!oCookie || typeof oCookie != "object") {
			oCookie = {};
		}
		return oCookie;
	};
	ET.Utils.mergeObjects = function (dest, src) {
		for (var i in src) {
			dest[i] = src[i];
		}
	};
	ET.Utils.__wch_id = 0;
	ET.Utils.createWCH = function (oEl) {
		if (!ET.is_ie || ET.is_ie5 || ET.is_ie7 || ET.is_ie8|| ET.is_ie10) {
			return null;
		}
		var sId = "WCH" + (++ET.Utils.__wch_id);
		var sIframe = ["<iframe id=\"", sId, "\" scrolling=\"no\" frameborder=\"0\" style=\"z-index:0;position:absolute;visibility:hidden;filter:progid:DXImageTransform.Microsoft.alpha(style=0,opacity=0);border:0;top:0;left:0;width:0;height:0\" src=\"javascript:false\"></iframe>"].join("");
		if (!oEl) {
			oEl = document.body;
		}
		if (ET.windowLoaded) {
			oEl.insertAdjacentHTML("beforeEnd", sIframe);
		} else {
			ET.Utils.addEvent(window, "load", function () {
				oEl.insertAdjacentHTML("beforeEnd", sIframe);
				oEl = null;
			});
		}
		return document.getElementById(sId);
	};
	ET.Utils.setupWCH_el = function (f, el, el2) {
		if (f) {
			var pos = etUtils.getElementOffsetRelative(el), X1 = pos.x, Y1 = pos.y, X2 = X1 + el.offsetWidth, Y2 = Y1 + el.offsetHeight;
			if (el2) {
				var p2 = etUtils.getElementOffsetRelative(el2), XX1 = p2.x, YY1 = p2.y, XX2 = XX1 + el2.offsetWidth, YY2 = YY1 + el2.offsetHeight;
				if (X1 > XX1) {
					X1 = XX1;
				}
				if (Y1 > YY1) {
					Y1 = YY1;
				}
				if (X2 < XX2) {
					X2 = XX2;
				}
				if (Y2 < YY2) {
					Y2 = YY2;
				}
			}
			ET.Utils.setupWCH(f, X1, Y1, X2 - X1, Y2 - Y1);
		}
	};
	ET.Utils.setupWCH = function (f, x, y, w, h) {
		if (f) {
			var s = f.style;
			(typeof x != "undefined") && (s.left = x + "px");
			(typeof y != "undefined") && (s.top = y + "px");
			(typeof w != "undefined") && (s.width = w + "px");
			(typeof h != "undefined") && (s.height = h + "px");
			s.visibility = "inherit";
		}
	};
	ET.Utils.hideWCH = function (f) {
		if (f) {
			f.style.visibility = "hidden";
		}
	};
	ET.Utils.getPageScrollY = function () {
		if (window.pageYOffset) {
			return window.pageYOffset;
		} else {
			if (document.body && document.body.scrollTop) {
				return document.body.scrollTop;
			} else {
				if (document.documentElement && document.documentElement.scrollTop) {
					return document.documentElement.scrollTop;
				}
			}
		}
		return 0;
	};
	ET.Utils.getPageScrollX = function () {
		if (window.pageXOffset) {
			return window.pageXOffset;
		} else {
			if (document.body && document.body.scrollLeft) {
				return document.body.scrollLeft;
			} else {
				if (document.documentElement && document.documentElement.scrollLeft) {
					return document.documentElement.scrollLeft;
				}
			}
		}
		return 0;
	};
	ET.ScrollWithWindow = {};
	ET.ScrollWithWindow.list = [];
	ET.ScrollWithWindow.stickiness = 0.25;
	ET.ScrollWithWindow.register = function (oElement) {
		var iTop = oElement.offsetTop || 0;
		var iLeft = oElement.offsetLeft || 0;
		ET.ScrollWithWindow.list.push({node:oElement, origTop:iTop, origLeft:iLeft});
		if (!ET.ScrollWithWindow.interval) {
			ET.ScrollWithWindow.on();
		}
	};
	ET.ScrollWithWindow.unregister = function (oElement) {
		for (var iItem = 0; iItem < ET.ScrollWithWindow.list.length; iItem++) {
			var oItem = ET.ScrollWithWindow.list[iItem];
			if (oElement == oItem.node) {
				ET.ScrollWithWindow.list.splice(iItem, 1);
				if (!ET.ScrollWithWindow.list.length) {
					ET.ScrollWithWindow.off();
				}
				return;
			}
		}
	};
	ET.ScrollWithWindow.moveTop = function (iTop) {
		ET.ScrollWithWindow.top += (iTop - ET.ScrollWithWindow.top) * ET.ScrollWithWindow.stickiness;
		if (Math.abs(ET.ScrollWithWindow.top - iTop) <= 1) {
			ET.ScrollWithWindow.top = iTop;
		}
		for (var iItem = 0; iItem < ET.ScrollWithWindow.list.length; iItem++) {
			var oItem = ET.ScrollWithWindow.list[iItem];
			var oElement = oItem.node;
			oElement.style.position = "absolute";
			if (!oItem.origTop && oItem.origTop !== 0) {
				oItem.origTop = parseInt(oElement.style.top) || 0;
			}
			oElement.style.top = oItem.origTop + parseInt(ET.ScrollWithWindow.top) + "px";
		}
	};
	ET.ScrollWithWindow.moveLeft = function (iLeft) {
		ET.ScrollWithWindow.left += (iLeft - ET.ScrollWithWindow.left) * ET.ScrollWithWindow.stickiness;
		if (Math.abs(ET.ScrollWithWindow.left - iLeft) <= 1) {
			ET.ScrollWithWindow.left = iLeft;
		}
		for (var iItem = 0; iItem < ET.ScrollWithWindow.list.length; iItem++) {
			var oItem = ET.ScrollWithWindow.list[iItem];
			var oElement = oItem.node;
			oElement.style.position = "absolute";
			if (!oItem.origLeft && oItem.origLeft !== 0) {
				oItem.origLeft = parseInt(oElement.style.left) || 0;
			}
			oElement.style.left = oItem.origLeft + parseInt(ET.ScrollWithWindow.left) + "px";
		}
	};
	ET.ScrollWithWindow.cycle = function () {
		var iTop = ET.Utils.getPageScrollY();
		var iLeft = ET.Utils.getPageScrollX();
		if (iTop != ET.ScrollWithWindow.top) {
			ET.ScrollWithWindow.moveTop(iTop);
		}
		if (iLeft != ET.ScrollWithWindow.left) {
			ET.ScrollWithWindow.moveLeft(iLeft);
		}
	};
	ET.ScrollWithWindow.on = function () {
		if (ET.ScrollWithWindow.interval) {
			return;
		}
		ET.ScrollWithWindow.top = ET.Utils.getPageScrollY();
		ET.ScrollWithWindow.left = ET.Utils.getPageScrollX();
		ET.ScrollWithWindow.interval = setInterval(ET.ScrollWithWindow.cycle, 50);
	};
	ET.ScrollWithWindow.off = function () {
		if (!ET.ScrollWithWindow.interval) {
			return;
		}
		clearInterval(ET.ScrollWithWindow.interval);
		ET.ScrollWithWindow.interval = null;
	};
	ET.FixateOnScreen = {};
	ET.FixateOnScreen.getExpression = function (coord, direction) {
		return "ET.Utils.getPageScroll" + direction.toUpperCase() + "() + " + coord;
	};
	ET.FixateOnScreen.parseCoordinates = function (element) {
		if (!this.isRegistered(element)) {
			return false;
		}
		var x = 0;
		var y = 0;
		var style = element.style;
		if (ET.is_ie && !ET.is_ie7 && !ET.is_ie8) {
			x = style.getExpression("left").split(" ");
			x = parseInt(x[x.length - 1], 10);
			y = style.getExpression("top").split(" ");
			y = parseInt(y[y.length - 1], 10);
		} else {
			x = parseInt(style.left, 10);
			y = parseInt(style.top, 10);
		}
		x += ET.Utils.getPageScrollX();
		y += ET.Utils.getPageScrollY();
		return {x:x, y:y};
	};
	ET.FixateOnScreen.correctCoordinates = function (x, y) {
		position = {x:x, y:y};
		if (position.x || position.x === 0) {
			position.x -= ET.Utils.getPageScrollX();
			if (ET.is_ie && !ET.is_ie7 && !ET.is_ie8) {
				position.x = this.getExpression(position.x, "X");
			} else {
				position.x += "px";
			}
		}
		if (position.y || position.y === 0) {
			position.y -= ET.Utils.getPageScrollY();
			if (ET.is_ie && !ET.is_ie7 && !ET.is_ie8) {
				position.y = this.getExpression(position.y, "Y");
			} else {
				position.y += "px";
			}
		}
		return position;
	};
	ET.FixateOnScreen.register = function (element) {
		if (!ET.isHtmlElement(element)) {
			return false;
		}
		if (this.isRegistered(element)) {
			return true;
		}
		var pos = ET.Utils.getElementOffset(element);
		pos = {x:parseInt(element.style.left, 10) || pos.x, y:parseInt(element.style.top, 10) || pos.y};
		pos = this.correctCoordinates(pos.x, pos.y);
		if (!ET.is_ie || ET.is_ie7 || ET.is_ie8) {
			var restorer = element.restorer;
			if (!restorer || !restorer.getObject || restorer.getObject() != element) {
				restorer = element.restorer = new ET.SRProp(element);
			}
			restorer.saveProp("style.position");
			element.style.position = "fixed";
			element.style.left = pos.x;
			element.style.top = pos.y;
		} else {
			element.style.setExpression("left", pos.x);
			element.style.setExpression("top", pos.y);
		}
		element.zpFixed = true;
		return true;
	};
	ET.FixateOnScreen.unregister = function (element) {
		if (!ET.isHtmlElement(element)) {
			return false;
		}
		var pos = this.parseCoordinates(element);
		if (pos === false) {
			return true;
		}
		if (ET.is_ie && !ET.is_ie7 && !ET.is_ie8) {
			element.style.removeExpression("left");
			element.style.removeExpression("top");
		}
		element.style.left = pos.x + "px";
		element.style.top = pos.y + "px";
		if (!ET.is_ie || ET.is_ie7 || ET.is_ie8) {
			element.restorer.restoreProp("style.position", true);
		}
		element.zpFixed = false;
		return true;
	};
	ET.FixateOnScreen.isRegistered = function (element) {
		if (element.zpFixed) {
			return true;
		}
		return false;
	};
	ET.Utils.destroy = function (el) {
		if (el && el.parentNode) {
			el.parentNode.removeChild(el);
		}
	};
	ET.Utils.newCenteredWindow = function (url, windowName, width, height, scrollbars) {
		var leftPosition = 0;
		var topPosition = 0;
		if (screen.width) {
			leftPosition = (screen.width - width) / 2;
		}
		if (screen.height) {
			topPosition = (screen.height - height) / 2;
		}
		var winArgs = "height=" + height + ",width=" + width + ",top=" + topPosition + ",left=" + leftPosition + ",scrollbars=" + scrollbars + ",resizable";
		var win = window.open(url, windowName, winArgs);
		return win;
	};
	ET.Utils.getWindowSize = function () {
		var iWidth = 0;
		var iHeight = 0;
		try {
			if (ET.is_khtml) {
				iWidth = window.innerWidth || 0;
				iHeight = window.innerHeight || 0;
			} else {
				if (document.compatMode && document.compatMode == "CSS1Compat") {
					iWidth = document.documentElement.clientWidth || 0;
					iHeight = document.documentElement.clientHeight || 0;
				} else {
					iWidth = document.body.clientWidth || 0;
					iHeight = document.body.clientHeight || 0;
				}
			}
		}
		catch (oException) {
		}
		return {width:iWidth, height:iHeight};
	};
	ET.Utils.getWindowDimensions = function () {
		var oSize = etUtils.getWindowSize();
		try {
			var iScrollX = window.pageXOffset || document.body.scrollLeft || document.documentElement.scrollLeft || 0;
			var iScrollY = window.pageYOffset || document.body.scrollTop || document.documentElement.scrollTop || 0;
			return {width:oSize.width - iScrollX, height:oSize.height - iScrollY};
		}
		catch (oException) {
			return oSize;
		}
	};
	ET.Utils.selectOption = function (sel, val, call_default) {
		var a = sel.options, i, o;
		for (i = a.length; --i >= 0; ) {
			o = a[i];
			o.selected = (o.value == val);
		}
		sel.value = val;
		if (call_default) {
			if (typeof sel.onchange == "function") {
				sel.onchange();
			} else {
				if (typeof sel.onchange == "string") {
					eval(sel.onchange);
				}
			}
		}
	};
	ET.Utils.getNextSibling = function (el, tag, alternateTag) {
		el = el.nextSibling;
		if (!tag) {
			return el;
		}
		tag = tag.toLowerCase();
		if (alternateTag) {
			alternateTag = alternateTag.toLowerCase();
		}
		while (el) {
			if (el.nodeType == 1 && (el.tagName.toLowerCase() == tag || (alternateTag && el.tagName.toLowerCase() == alternateTag))) {
				return el;
			}
			el = el.nextSibling;
		}
		return el;
	};
	ET.Utils.getPreviousSibling = function (el, tag, alternateTag) {
		el = el.previousSibling;
		if (!tag) {
			return el;
		}
		tag = tag.toLowerCase();
		if (alternateTag) {
			alternateTag = alternateTag.toLowerCase();
		}
		while (el) {
			if (el.nodeType == 1 && (el.tagName.toLowerCase() == tag || (alternateTag && el.tagName.toLowerCase() == alternateTag))) {
				return el;
			}
			el = el.previousSibling;
		}
		return el;
	};
	ET.Utils.getFirstChild = function (el, tag, alternateTag) {
		if (!el) {
			return null;
		}
		el = el.firstChild;
		if (!el) {
			return null;
		}
		if (!tag) {
			return el;
		}
		tag = tag.toLowerCase();
		if (el.nodeType == 1) {
			if (el.tagName.toLowerCase() == tag) {
				return el;
			} else {
				if (alternateTag) {
					alternateTag = alternateTag.toLowerCase();
					if (el.tagName.toLowerCase() == alternateTag) {
						return el;
					}
				}
			}
		}
		return ET.Utils.getNextSibling(el, tag, alternateTag);
	};
	ET.Utils.getLastChild = function (el, tag, alternateTag) {
		if (!el) {
			return null;
		}
		el = el.lastChild;
		if (!el) {
			return null;
		}
		if (!tag) {
			return el;
		}
		tag = tag.toLowerCase();
		if (el.nodeType == 1) {
			if (el.tagName.toLowerCase() == tag) {
				return el;
			} else {
				if (alternateTag) {
					alternateTag = alternateTag.toLowerCase();
					if (el.tagName.toLowerCase() == alternateTag) {
						return el;
					}
				}
			}
		}
		return ET.Utils.getPreviousSibling(el, tag, alternateTag);
	};
	ET.Utils.getChildText = function (objNode) {
		if (objNode == null) {
			return "";
		}
		var arrText = [];
		var objChild = objNode.firstChild;
		while (objChild != null) {
			if (objChild.nodeType == 3) {
				arrText.push(objChild.data);
			}
			objChild = objChild.nextSibling;
		}
		return arrText.join(" ");
	};
	ET.Utils.insertAfter = function (oldNode, newNode) {
		if (oldNode.nextSibling) {
			oldNode.parentNode.insertBefore(newNode, oldNode.nextSibling);
		} else {
			oldNode.parentNode.appendChild(newNode);
		}
	};
	ET.Utils._ids = {};
	ET.Utils.generateID = function (code, id) {
		if (typeof id == "undefined") {
			if (typeof this._ids[code] == "undefined") {
				this._ids[code] = 0;
			}
			id = ++this._ids[code];
		}
		return "et-" + code + "-" + id;
	};
	ET.Utils.addTooltip = function (target, tooltip) {
		return new ET.Tooltip({target:target, tooltip:tooltip});
	};
	ET.isLite = true;
	ET.Utils.checkLinks = function () {
		var anchors = document.getElementsByTagName("A");
		for (var ii = 0; ii < anchors.length; ii++) {
			if (ET.Utils.checkLink(anchors[ii])) {
				return true;
			}
		}
		return false;
	};
	ET.Utils.checkLink = function (lnk) {
		if (!lnk) {
			return false;
		}
		if (!/^https?:\/\/((dev|www)\.)?et\.com/i.test(lnk.href)) {
			return false;
		}
		var textContent = "";
		for (var ii = 0; ii < lnk.childNodes.length; ii++) {
			if (lnk.childNodes[ii].nodeType == 3) {
				textContent += lnk.childNodes[ii].nodeValue;
			}
		}
		if (textContent.length < 4) {
			return false;
		}
		var parent = lnk;
		while (parent && parent.nodeName.toLowerCase() != "html") {
			if (ET.Utils.getStyleProperty(parent, "display") == "none" || ET.Utils.getStyleProperty(parent, "visibility") == "hidden" || ET.Utils.getStyleProperty(parent, "opacity") == "0" || ET.Utils.getStyleProperty(parent, "-moz-opacity") == "0" || /alpha\(opacity=0\)/i.test(ET.Utils.getStyleProperty(parent, "filter"))) {
				return false;
			}
			parent = parent.parentNode;
		}
		var coords = ET.Utils.getElementOffset(lnk);
		if (coords.left < 0 || coords.top < 0) {
			return false;
		}
		return true;
	};
	ET.Utils.clone = function (oSrc) {
		if (typeof oSrc == "object" && oSrc) {
			var oClone = new oSrc.constructor();
			var fClone = ET.Utils.clone;
			for (var sProp in oSrc) {
				oClone[sProp] = fClone(oSrc[sProp]);
			}
			return oClone;
		}
		return oSrc;
	};
	ET.Utils.arrIndexOf = function (aArr, vSearchEl, iFromInd) {
		if (!(aArr instanceof Array)) {
			return -1;
		}
		if (Array.prototype.indexOf) {
			return aArr.indexOf(vSearchEl, iFromInd);
		}
		if (!iFromInd) {
			iFromInd = 0;
		}
		var iEls = aArr.length;
		for (var iEl = iFromInd; iEl < iEls; iEl++) {
			if (aArr[iEl] == vSearchEl) {
				return iEl;
			}
		}
		return -1;
	};
	ET.Log = function (objArgs) {
		if (!objArgs) {
			return;
		}
		var strMessage = objArgs.description;
		if (objArgs.severity) {
			strMessage = objArgs.severity + ":\n" + strMessage;
		}
		if (objArgs.type != "warning") {
			if (ET.Debug) {
				ET.Debug.log.error(strMessage);
			} else {
				alert(strMessage);
			}
		}
	};
	ET.Utils.Array = {};
	ET.Utils.Array.insertBefore = function (arr, el, key, nextKey) {
		var tmp = new Array();
		for (var i in arr) {
			if (i == nextKey) {
				if (key) {
					tmp[key] = el;
				} else {
					tmp.push(el);
				}
			}
			tmp[i] = arr[i];
		}
		return tmp;
	};
	ET.inherit = function (oSubClass, oSuperClass, oArg) {
		var Inheritance = function () {
		};
		Inheritance.prototype = oSuperClass.prototype;
		oSubClass.prototype = new Inheritance();
		oSubClass.prototype.constructor = oSubClass;
		oSubClass.SUPERconstructor = oSuperClass;
		oSubClass.SUPERclass = oSuperClass.prototype;
		if (typeof oSuperClass.path != "undefined") {
			if (oArg && oArg.keepPath) {
				oSubClass.path = oSuperClass.path;
			} else {
				oSubClass.path = ET.getPath(oSubClass.id);
			}
		}
	};
	ET.getPath = function (sId) {
		var sSrc;
		if (typeof sId == "string") {
			var oScript = document.getElementById(sId);
			if (oScript) {
				sSrc = oScript.getAttribute("src");
			}
		}
		if (!sSrc) {
			if (typeof ET.lastLoadedModule == "string") {
				return ET.lastLoadedModule;
			}
			if (document.documentElement) {
				var sHtml = document.documentElement.innerHTML;
				var aMatch = sHtml.match(/<script[^>]+src=[^>]+>/gi);
				if (aMatch && aMatch.length) {
					sHtml = aMatch[aMatch.length - 1];
					aMatch = sHtml.match(/src="([^"]+)/i);
					if (aMatch && aMatch.length == 2) {
						sSrc = aMatch[1];
					}
				}
			}
			if (!sSrc) {
				return "";
			}
		}
		sSrc = sSrc.replace(/\\/g, "/");
		var aTokens = sSrc.split("?");
		aTokens = aTokens[0].split("/");
		aTokens = aTokens.slice(0, -1);
		if (!aTokens.length) {
			return "";
		}
		return aTokens.join("/") + "/";
	};
	ET.Utils.setWindowEvent = function (oEvent) {
		if (oEvent) {
			window.event = oEvent;
		}
	};
	ET.Utils.emulateWindowEvent = function (aEvents) {
		if (document.addEventListener) {
			var iEvents = aEvents.length;
			var oUtils = ET.Utils;
			var iEvent;
			for (iEvent = 0; iEvent < iEvents; iEvent++) {
				document.addEventListener(aEvents[iEvent], oUtils.setWindowEvent, true);
			}
		}
	};
	ET.Utils.isWindowLoaded = function () {
		return typeof (document.readyState) != "undefined" ? (document.readyState == "loaded" || document.readyState == "complete") : document.getElementsByTagName != null && typeof (document.getElementsByTagName("body")[0]) != "undefined";
	};
	ET.windowLoaded = ET.Utils.isWindowLoaded();
	ET.Utils.addEvent(window, "load", function () {
		ET.windowLoaded = true;
	});
	ET.Utils.warnUnload = function (msg, win) {
		ET.Utils.warnUnloadFlag = true;
		if (typeof (msg) != "string") {
			msg = "All your changes will be lost.";
		}
		if (typeof (win) == "undefined") {
			win = window;
		}
		ET.Utils.addEvent(win, "beforeunload", function (ev) {
			if (ET.Utils.warnUnloadFlag != true) {
				return true;
			}
			if (typeof (ev) == "undefined") {
				ev = window.event;
			}
			ev.returnValue = msg;
			if (ET.is_khtml) {
				return msg;
			} else {
				return false;
			}
		});
	};
	ET.Utils.unwarnUnload = function (msg, win) {
		ET.Utils.warnUnloadFlag = false;
	};
	ET.Utils.warnUnloadFlag = false;
	ET.Utils.getMaxZindex = function () {
		if (window.opera || ET.is_khtml) {
			return 2147483583;
		} else {
			if (ET.is_ie) {
				return 2147483647;
			} else {
				return 10737418239;
			}
		}
	};
	ET.Utils.maxZindex = etUtils.getMaxZindex();
	etUtilsMaxZindex = etUtils.maxZindex;
	ET.Utils.correctCssLength = function (val) {
		if (typeof val == "undefined" || (typeof val == "object" && !val)) {
			return "auto";
		}
		val += "";
		if (!val.length) {
			return "auto";
		}
		if (/\d$/.test(val)) {
			val += "px";
		}
		return val;
	};
	ET.Utils.destroyOnUnload = [];
	ET.Utils.addDestroyOnUnload = function (objElement, strProperty) {
		ET.Utils.destroyOnUnload.push([objElement, strProperty]);
	};
	ET.Utils.createProperty = function (objElement, strProperty, val) {
		objElement[strProperty] = val;
		ET.Utils.addDestroyOnUnload(objElement, strProperty);
	};
	ET.Utils.addEvent(window, "unload", function () {
		for (var iObj = ET.Utils.destroyOnUnload.length - 1; iObj >= 0; iObj--) {
			var objDestroy = ET.Utils.destroyOnUnload[iObj];
			objDestroy[0][objDestroy[1]] = null;
			objDestroy[0] = null;
		}
		for (var iLis = ET.Utils.removeOnUnload.length - 1; iLis >= 0; iLis--) {
			var oParams = ET.Utils.removeOnUnload[iLis];
			if (!oParams) {
				continue;
			}
			ET.Utils.removeOnUnload[iLis] = null;
			ET.Utils.removeEvent(oParams["element"], oParams["event"], oParams["listener"], oParams["capture"]);
		}
	});
	ET.Utils.htmlEncode = function (str) {
		if (str == null || typeof (str.replace) != "function") {
			return "";
		}
		str = str.replace(/&/ig, "&amp;");
		str = str.replace(/</ig, "&lt;");
		str = str.replace(/>/ig, "&gt;");
		str = str.replace(/\x22/ig, "&quot;");
		return str;
	};
	ET.Utils.applyStyle = function (elRef, style) {
		if (typeof (elRef) == "string") {
			elRef = document.getElementById(elRef);
		}
		if (elRef == null || style == null || elRef.style == null) {
			return null;
		}
		if (ET.is_opera) {
			var pairs = style.split(";");
			for (var ii = 0; ii < pairs.length; ii++) {
				var kv = pairs[ii].split(":");
				if (!kv[1]) {
					continue;
				}
				var value = kv[1].replace(/^\s*/, "").replace(/\s*$/, "");
				var key = "";
				for (var jj = 0; jj < kv[0].length; jj++) {
					if (kv[0].charAt(jj) == "-") {
						jj++;
						if (jj < kv[0].length) {
							key += kv[0].charAt(jj).toUpperCase();
						}
						continue;
					}
					key += kv[0].charAt(jj);
				}
				switch (key) {
				  case "float":
					key = "cssFloat";
					break;
				}
				try {
					elRef.style[key] = value;
				}
				catch (e) {
				}
			}
		} else {
			elRef.style.cssText = style;
		}
		return true;
	};
	ET.Utils.getStyleProperty = function (oEl, sPr) {
		var oDV = document.defaultView;
		if (oDV && oDV.getComputedStyle) {
			var oCS = oDV.getComputedStyle(oEl, "");
			if (oCS) {
				sPr = sPr.replace(/([A-Z])/g, "-$1").toLowerCase();
				return oCS.getPropertyValue(sPr);
			}
		} else {
			if (oEl.currentStyle) {
				return oEl.currentStyle[sPr];
			}
		}
		return oEl.style[sPr];
	};
	ET.Utils.getPrecision = function (dFloat) {
		return (dFloat + "").replace(/^-?\d*\.*/, "").length;
	};
	ET.Utils.setPrecision = function (dFloat, iPrecision) {
		dFloat *= 1;
		if (dFloat.toFixed) {
			return dFloat.toFixed(iPrecision) * 1;
		}
		var iPow = Math.pow(10, iPrecision);
		return parseInt(dFloat * iPow, 10) / iPow;
	};
	ET.Utils.setPrecisionString = function (dFloat, iPrecision) {
		var sFloat = ET.Utils.setPrecision(dFloat, iPrecision) + "";
		var iOldPrecision = ET.Utils.getPrecision(sFloat);
		var iZeros = iPrecision - iOldPrecision;
		if (iZeros) {
			if (!iOldPrecision) {
				sFloat += ".";
			}
			for (var iZero = 0; iZero < iZeros; iZero++) {
				sFloat += "0";
			}
		}
		return sFloat;
	};
	ET.Utils.createNestedHash = function (parent, keys, value) {
		if (parent == null || keys == null) {
			return null;
		}
		var tmp = parent;
		for (var ii = 0; ii < keys.length; ii++) {
			if (typeof (tmp[keys[ii]]) == "undefined") {
				tmp[keys[ii]] = {};
			}
			if (ii == keys.length - 1 && typeof (value) != "undefined") {
				tmp[keys[ii]] = value;
			}
			tmp = tmp[keys[ii]];
		}
	};
	ET.implement = function (classOrObject, interfaceStr) {
		if (typeof interfaceStr != "string") {
			return false;
		}
		if (typeof classOrObject == "function") {
			classOrObject = classOrObject.prototype;
		}
		if (!classOrObject || typeof classOrObject != "object") {
			return false;
		}
		var interfaceObj = window;
		var objs = interfaceStr.split(".");
		try {
			for (var i = 0; i < objs.length; ++i) {
				interfaceObj = interfaceObj[objs[i]];
			}
		}
		catch (e) {
			return false;
		}
		if (typeof classOrObject.interfaces != "object") {
			classOrObject.interfaces = {};
			classOrObject.interfaces[interfaceStr] = true;
		} else {
			if (classOrObject.interfaces[interfaceStr] !== true) {
				classOrObject.interfaces = ET.Utils.clone(classOrObject.interfaces);
				classOrObject.interfaces[interfaceStr] = true;
			} else {
				return true;
			}
		}
		for (var iProp in interfaceObj) {
			classOrObject[iProp] = interfaceObj[iProp];
		}
		classOrObject.hasInterface = function (interfaceStr) {
			if (this.interfaces[interfaceStr] === true) {
				return true;
			}
			return false;
		};
		classOrObject.requireInterface = function (interfaceStr) {
			if (!this.hasInterface(interfaceStr)) {
				ET.Log({description:"The object with ID '" + this.id + "' has no " + interfaceStr + " interface!"});
				return false;
			}
			return true;
		};
		interfaceObj.setNamedProperty = classOrObject.setNamedProperty = function (name, val) {
			this[name] = val;
		};
		interfaceObj.getNamedProperty = classOrObject.getNamedProperty = function (name) {
			return this[name];
		};
		return true;
	};
	ET.Utils.getCharFromEvent = function (evt) {
		if (!evt) {
			evt = window.event;
		}
		var response = {};
		if (ET.is_gecko && !ET.is_khtml && evt.type != "keydown" && evt.type != "keyup") {
			if (evt.charCode) {
				response.chr = String.fromCharCode(evt.charCode);
			} else {
				response.charCode = evt.keyCode;
			}
		} else {
			response.charCode = evt.keyCode || evt.which;
			response.chr = String.fromCharCode(response.charCode);
		}
		if (ET.is_opera && response.charCode == 0) {
			response.charCode = null;
			response.chr = null;
		}
		if (ET.is_khtml && response.charCode == 63272) {
			response.charCode = 46;
			response.chr = null;
		}
		return response;
	};
	ET.Utils.convertHTML2DOM = function (txt) {
		if (!txt) {
			return null;
		}
		var el = document.createElement("div");
		el.innerHTML = txt;
		var currEl = el.firstChild;
		while (!currEl.nodeType || currEl.nodeType != 1) {
			currEl = currEl.nextSibling;
		}
		ET.Utils.destroy(currEl);
		return currEl;
	};
	ET.Utils.escapeRegExp = function (s) {
		return s.replace(/([.*+?^${}()|[\]\/\\])/g, "\\$1");
	};
	ET.Utils.getRadioValue = function (oGroup) {
		if (!oGroup) {
			return "";
		}
		if (typeof oGroup.selectedIndex == "number") {
			return oGroup[oGroup.selectedIndex].value;
		} else {
			var iItems = oGroup.length;
			if (!iItems) {
				return "";
			}
			var oItem;
			for (var iItem = 0; iItem < iItems; iItem++) {
				oItem = oGroup[iItem];
				if (oItem.checked) {
					return oItem.value;
				}
			}
		}
		return "";
	};
	ET.Utils.setRadioValue = function (oGroup, sValue) {
		if (!oGroup) {
			return;
		}
		var iItems = oGroup.length;
		if (!iItems) {
			return;
		}
		var oItem;
		for (var iItem = 0; iItem < iItems; iItem++) {
			oItem = oGroup[iItem];
			if (oItem.value == sValue) {
				if (typeof oGroup.selectedIndex == "number") {
					oGroup.selectedIndex = iItem;
				} else {
					oItem.checked = "checked";
				}
				return;
			}
		}
	};
	etUtilsRegexpSpacePlus = ET.Utils.utilsRegexpSpacePlus = /\s+/g;
	ET.Utils.utilsRegexpSpaceLeft = /^\s+/;
	ET.Utils.utilsRegexpSpaceRight = /\s+$/;
	ET.Utils.trim = function (sVal) {
		return sVal.replace(etUtils.utilsRegexpSpaceLeft, "").replace(etUtils.utilsRegexpSpaceRight, "");
	};
	ET.Utils.multispacekill = function (sVal) {
		return etUtils.trim(sVal).replace(etUtilsRegexpSpacePlus, " ");
	};
	ET.Utils.spacekill = function (sVal) {
		return sVal.replace(etUtilsRegexpSpacePlus, "");
	};
	ET.Utils.mozTextOverflow = function (oEl) {
		setTimeout(function () {
			etUtils.mozTextOverflowEllipsis(oEl);
		}, 0);
	};
	ET.Utils.mozTextOverflowEllipsis = function (oEl) {
		oEl.style.position = "relative";
		var oEllipsis = oEl.zpEllipsis = document.createElement("div");
		oEllipsis.innerHTML = "&hellip;";
		var oStyle = oEllipsis.style;
		oStyle.position = "absolute";
		oStyle.right = "0";
		oStyle.bottom = "0";
		oStyle.background = "inherit";
		oStyle.textDecoration = "none";
		oStyle.display = "none";
		oEl.appendChild(oEllipsis);
		oEl.addEventListener("overflow", function (oEv) {
			var oEl = oEv.currentTarget;
			var oEllipsis = oEl.zpEllipsis;
			if (oEllipsis) {
				oEllipsis.style.display = "block";
			}
		}, false);
		oEl.addEventListener("underflow", function (oEv) {
			var oEl = oEv.currentTarget;
			var oEllipsis = oEl.zpEllipsis;
			if (oEllipsis) {
				oEllipsis.style.display = "none";
			}
		}, false);
	};
	ET.Utils.compareInt = function (vLeft, vRight) {
		vLeft = parseInt(vLeft);
		vRight = parseInt(vRight);
		return (vLeft > vRight) - (vLeft < vRight);
	};
}
ET.EventDriven = function () {
};
etEventDriven = ET.EventDriven;
ET.EventDriven.prototype.init = function () {
	this.events = {};
};
ET.EventDriven.prototype.addEventListener = function (sEvent, fListener, bOnetime) {
	if (typeof fListener != "function") {
		return false;
	}
	var oEvents = this.events;
	var oEvent = oEvents[sEvent];
	if (!oEvent) {
		oEvents[sEvent] = {listeners:[]};
		oEvent = oEvents[sEvent];
	} else {
		this.removeEventListener(sEvent, fListener);
	}
	if (bOnetime) {
		oEvent.listeners.push({listener:fListener, onetime:true});
	} else {
		oEvent.listeners.push(fListener);
	}
};
ET.EventDriven.prototype.addOnetimeEventListener = function (sEvent, fListener) {
	return this.addEventListener(sEvent, fListener, true);
};
ET.EventDriven.prototype.unshiftEventListener = function (sEvent, fListener) {
	if (typeof fListener != "function") {
		return false;
	}
	var oEvents = this.events;
	var oEvent = oEvents[sEvent];
	if (!oEvent) {
		oEvents[sEvent] = {listeners:[]};
		oEvent = oEvents[sEvent];
	} else {
		this.removeEventListener(sEvent, fListener);
	}
	oEvent.listeners.unshift(fListener);
};
ET.EventDriven.prototype.removeEventListener = function (sEvent, fListener) {
	var oEvents = this.events;
	if (!oEvents[sEvent]) {
		return 0;
	}
	var aListeners = oEvents[sEvent].listeners;
	var iRemoved = 0;
	var oListener;
	for (var iListener = aListeners.length - 1; iListener >= 0; iListener--) {
		oListener = aListeners[iListener];
		if (oListener == fListener || oListener.listener == fListener) {
			aListeners.splice(iListener, 1);
			iRemoved++;
		}
	}
	return iRemoved;
};
ET.EventDriven.prototype.removeOnetimeEventListeners = function (sEvent) {
	var oEvents = this.events;
	if (!oEvents[sEvent]) {
		return 0;
	}
	var aListeners = oEvents[sEvent].listeners;
	var iRemoved = 0;
	for (var iListener = aListeners.length - 1; iListener >= 0; iListener--) {
		if (aListeners[iListener].onetime) {
			aListeners.splice(iListener, 1);
			iRemoved++;
		}
	}
	return iRemoved;
};
ET.EventDriven.prototype.getEventListeners = function (sEvent) {
	var oEvents = this.events;
	if (!oEvents[sEvent]) {
		return [];
	}
	return oEvents[sEvent].listeners;
};
ET.EventDriven.prototype.isEventListener = function (sEvent, fListener) {
	var oEvents = this.events;
	if (!oEvents[sEvent]) {
		return false;
	}
	var aListeners = oEvents[sEvent].listeners;
	var oListener;
	for (var iListener = aListeners.length - 1; iListener >= 0; iListener--) {
		oListener = aListeners[iListener];
		if (oListener == fListener || oListener.listener == fListener) {
			return true;
		}
	}
	return false;
};
ET.EventDriven.prototype.isEvent = function (sEvent) {
	if (this.events[sEvent]) {
		return true;
	}
	return false;
};
ET.EventDriven.prototype.removeEvent = function (sEvent) {
	var oEvents = this.events;
	if (oEvents[sEvent]) {
		var undef;
		oEvents[sEvent] = undef;
	}
};
ET.EventDriven.prototype.fireEvent = function (sEvent) {
	var oEvents = this.events;
	if (!oEvents[sEvent]) {
		return;
	}
	var aListeners = oEvents[sEvent].listeners.slice();
	var iListeners = aListeners.length;
	var aArgs, oListener;
	for (var iListener = 0; iListener < iListeners; iListener++) {
		aArgs = [].slice.call(arguments, 1);
		oListener = aListeners[iListener];
		if (typeof oListener == "function") {
			oListener.apply(this, aArgs);
		} else {
			oListener.listener.apply(this, aArgs);
		}
	}
	this.removeOnetimeEventListeners(sEvent);
};
ET.EventDriven.events = {};
ET.EventDriven.addEventListener = function (sEvent, fListener, bOnetime) {
	if (typeof fListener != "function") {
		return false;
	}
	var oEvents = etEventDriven.events;
	var oEvent = oEvents[sEvent];
	if (!oEvent) {
		oEvents[sEvent] = {listeners:[]};
		oEvent = oEvents[sEvent];
	} else {
		etEventDriven.removeEventListener(sEvent, fListener);
	}
	if (bOnetime) {
		oEvent.listeners.push({listener:fListener, onetime:true});
	} else {
		oEvent.listeners.push(fListener);
	}
};
ET.EventDriven.addOnetimeEventListener = function (sEvent, fListener) {
	return etEventDriven.addEventListener(sEvent, fListener, true);
};
ET.EventDriven.unshiftEventListener = function (sEvent, fListener) {
	if (typeof fListener != "function") {
		return false;
	}
	var oEvents = etEventDriven.events;
	var oEvent = oEvents[sEvent];
	if (!oEvent) {
		oEvents[sEvent] = {listeners:[]};
		oEvent = oEvents[sEvent];
	} else {
		etEventDriven.removeEventListener(sEvent, fListener);
	}
	oEvent.listeners.unshift(fListener);
};
ET.EventDriven.removeEventListener = function (sEvent, fListener) {
	var oEvents = etEventDriven.events;
	if (!oEvents[sEvent]) {
		return 0;
	}
	var iRemoved = 0;
	var aListeners = oEvents[sEvent].listeners;
	var oListener;
	for (var iListener = aListeners.length - 1; iListener >= 0; iListener--) {
		oListener = aListeners[iListener];
		if (oListener == fListener || oListener.listener == fListener) {
			aListeners.splice(iListener, 1);
			iRemoved++;
		}
	}
	return iRemoved;
};
ET.EventDriven.removeOnetimeEventListeners = function (sEvent) {
	var oEvents = etEventDriven.events;
	if (!oEvents[sEvent]) {
		return 0;
	}
	var aListeners = oEvents[sEvent].listeners;
	var iRemoved = 0;
	for (var iListener = aListeners.length - 1; iListener >= 0; iListener--) {
		if (aListeners[iListener].onetime) {
			aListeners.splice(iListener, 1);
			iRemoved++;
		}
	}
	return iRemoved;
};
ET.EventDriven.getEventListeners = function (sEvent) {
	var oEvents = etEventDriven.events;
	if (!oEvents[sEvent]) {
		return [];
	}
	return oEvents[sEvent].listeners;
};
ET.EventDriven.isEventListener = function (sEvent, fListener) {
	var oEvents = etEventDriven.events;
	if (!oEvents[sEvent]) {
		return false;
	}
	var aListeners = oEvents[sEvent].listeners;
	var oListener;
	for (var iListener = aListeners.length - 1; iListener >= 0; iListener--) {
		oListener = aListeners[iListener];
		if (oListener == fListener || oListener.listener == fListener) {
			return true;
		}
	}
	return false;
};
ET.EventDriven.isEvent = function (sEvent) {
	if (etEventDriven.events[sEvent]) {
		return true;
	}
	return false;
};
ET.EventDriven.removeEvent = function (sEvent) {
	var oEvents = etEventDriven.events;
	if (oEvents[sEvent]) {
		var undef;
		oEvents[sEvent] = undef;
	}
};
ET.EventDriven.fireEvent = function (sEvent) {
	var oEvents = etEventDriven.events;
	var oEvent = oEvents[sEvent];
	if (!oEvent) {
		return;
	}
	var aListeners = oEvent.listeners.slice();
	var iListeners = aListeners.length;
	var oListener, aArgs;
	for (var iListener = 0; iListeners--; iListener++) {
		aArgs = [].slice.call(arguments, 1);
		oListener = aListeners[iListener];
		if (typeof oListener == "function") {
			oListener.apply(oListener, aArgs);
		} else {
			oListener.listener.apply(oListener, aArgs);
		}
	}
	ET.EventDriven.removeOnetimeEventListeners(sEvent);
};
etImagePreloader = ET.ImagePreloader = function (objArgs) {
	this.job = null;
	this.image = null;
	if (arguments.length > 0) {
		this.init(objArgs);
	}
};
ET.ImagePreloader.prototype.init = function (objArgs) {
	if (!objArgs || !objArgs.job) {
		return;
	}
	this.job = objArgs.job;
	this.image = new Image();
	this.job.images.push(this.image);
	var objPreloader = this;
	this.image.onload = function () {
		objPreloader.job.loadedUrls.push(objArgs.url);
		setTimeout(function () {
			objPreloader.onLoad();
		}, 0);
	};
	this.image.onerror = function () {
		objPreloader.job.invalidUrls.push(objArgs.url);
		objPreloader.onLoad();
	};
	this.image.onabort = function () {
		objPreloader.job.abortedUrls.push(objArgs.url);
		objPreloader.onLoad();
	};
	this.image.src = objArgs.url;
	if (typeof objArgs.timeout == "number") {
		setTimeout(function () {
			if (objPreloader.job) {
				if (objPreloader.image.complete) {
					objPreloader.job.loadedUrls.push(objArgs.url);
				} else {
					objPreloader.job.abortedUrls.push(objArgs.url);
				}
				objPreloader.onLoad();
			}
		}, objArgs.timeout);
	}
};
ET.ImagePreloader.prototype.onLoad = function () {
	if (!this.job) {
		return;
	}
	this.image.onload = null;
	this.image.onerror = null;
	this.image.onabort = null;
	var objJob = this.job;
	this.job = null;
	objJob.leftToLoad--;
	if (objJob.leftToLoad == 0 && typeof objJob.onLoad == "function") {
		var funcOnLoad = objJob.onLoad;
		objJob.onLoad = null;
		funcOnLoad(objJob);
	}
};
etPreloadImages = ET.PreloadImages = function (objArgs) {
	this.images = [];
	this.leftToLoad = 0;
	this.loadedUrls = [];
	this.invalidUrls = [];
	this.abortedUrls = [];
	this.onLoad = null;
	if (arguments.length > 0) {
		this.init(objArgs);
	}
};
ET.PreloadImages.prototype.init = function (objArgs) {
	if (!objArgs) {
		return;
	}
	if (!objArgs.urls || !objArgs.urls.length) {
		if (typeof objArgs.onLoad == "function") {
			objArgs.onLoad(this);
		}
		return;
	}
	this.images = [];
	this.leftToLoad = objArgs.urls.length;
	this.loadedUrls = [];
	this.invalidUrls = [];
	this.abortedUrls = [];
	this.onLoad = objArgs.onLoad;
	for (var iUrl = 0; iUrl < objArgs.urls.length; iUrl++) {
		new ET.ImagePreloader({job:this, url:objArgs.urls[iUrl], timeout:objArgs.timeout});
	}
};
ET.StyleSheet = function (bUseLast) {
	if (bUseLast) {
		if (document.createStyleSheet) {
			if (document.styleSheets.length) {
				this.styleSheet = document.styleSheets[document.styleSheets.length - 1];
			}
		} else {
			var aStyleSheets = document.getElementsByTagName("style");
			if (aStyleSheets.length) {
				this.styleSheet = aStyleSheets[aStyleSheets.length - 1];
			}
		}
	}
	if (!this.styleSheet) {
		if (document.createStyleSheet) {
			try {
				this.styleSheet = document.createStyleSheet();
			}
			catch (oException) {
				this.styleSheet = document.styleSheets[document.styleSheets.length - 1];
			}
		} else {
			this.styleSheet = document.createElement("style");
			this.styleSheet.type = "text/css";
			var oHead = document.getElementsByTagName("head")[0];
			if (!oHead) {
				oHead = document.documentElement;
			}
			if (oHead) {
				oHead.appendChild(this.styleSheet);
			}
		}
	}
};
ET.StyleSheet.prototype.addRule = function (strSelector, strDeclarations) {
	if (!this.styleSheet) {
		return;
	}
	if (document.createStyleSheet) {
		this.styleSheet.cssText += strSelector + " { " + strDeclarations + " }";
	} else {
		this.styleSheet.appendChild(document.createTextNode(strSelector + " { " + strDeclarations + " }"));
	}
};
ET.StyleSheet.prototype.removeRules = function () {
	if (!this.styleSheet) {
		return;
	}
	if (document.createStyleSheet) {
		var iRules = this.styleSheet.rules.length;
		for (var iRule = 0; iRule < iRules; iRule++) {
			this.styleSheet.removeRule();
		}
	} else {
		while (this.styleSheet.firstChild) {
			this.styleSheet.removeChild(this.styleSheet.firstChild);
		}
	}
};
ET.StyleSheet.prototype.addParse = function (strStyleSheet) {
	var arrClean = [];
	var arrTokens = strStyleSheet.split("/*");
	for (var iTok = 0; iTok < arrTokens.length; iTok++) {
		var arrTails = arrTokens[iTok].split("*/");
		arrClean.push(arrTails[arrTails.length - 1]);
	}
	strStyleSheet = arrClean.join("");
	strStyleSheet = strStyleSheet.replace(/@[^{]*;/g, "");
	if (!ET.is_opera) {
		this.addRules(strStyleSheet);
	} else {
		var arrStyles = strStyleSheet.split("}");
		for (var iStl = 0; iStl < arrStyles.length; iStl++) {
			var arrRules = arrStyles[iStl].split("{");
			if (arrRules[0] && arrRules[1]) {
				var arrSelectors = arrRules[0].split(",");
				for (var iSel = 0; iSel < arrSelectors.length; iSel++) {
					this.addRule(arrSelectors[iSel], arrRules[1]);
				}
			}
		}
	}
};
ET.StyleSheet.prototype.addRules = function (cssStr) {
	if (!cssStr || ET.is_opera) {
		return;
	}
	if (ET.is_ie) {
		if (this.styleSheet.disabled) {
			var self = this;
			setTimeout(function () {
				self.styleSheet.cssText = cssStr;
			}, 10);
		} else {
			this.styleSheet.cssText = cssStr;
		}
	} else {
		var cssText = document.createTextNode(cssStr);
		this.styleSheet.appendChild(cssText);
	}
};
if (typeof etTransport != "function") {
	etTransport = ET.Transport = function () {
	};
	if (typeof ActiveXObject != "undefined") {
		ET.Transport.XMLDOM = null;
		ET.Transport.XMLHTTP = null;
		ET.Transport.pickActiveXVersion = function (aVersions) {
			for (var iVn = 0; iVn < aVersions.length; iVn++) {
				try {
					var oDoc = new ActiveXObject(aVersions[iVn]);
					if (oDoc) {
						return aVersions[iVn];
					}
				}
				catch (oExpn) {
				}
			}
			return null;
		};
		ET.Transport.XMLDOM = etTransport.pickActiveXVersion(["Msxml2.DOMDocument.4.0", "Msxml2.DOMDocument.3.0", "MSXML2.DOMDocument", "MSXML.DOMDocument", "Microsoft.XMLDOM"]);
		ET.Transport.XMLHTTP = etTransport.pickActiveXVersion(["Msxml2.XMLHTTP.4.0", "MSXML2.XMLHTTP.3.0", "MSXML2.XMLHTTP", "Microsoft.XMLHTTP"]);
		ET.Transport.pickActiveXVersion = null;
	}
	ET.Transport.createXmlHttpRequest = function () {
		if (typeof ActiveXObject != "undefined") {
			try {
				return new ActiveXObject(etTransport.XMLHTTP);
			}
			catch (oExpn) {
			}
		}
		if (typeof XMLHttpRequest != "undefined") {
			return new XMLHttpRequest();
		}
		return null;
	};
	ET.Transport.isBusy = function (oArg) {
		var oContr = oArg.busyContainer;
		if (typeof oContr == "string") {
			oContr = document.getElementById(oContr);
		}
		if (!oContr) {
			return;
		}
		var sImage = oArg.busyImage;
		if (typeof sImage != "string") {
			sImage = "";
		}
		sImage = sImage.split("/").pop();
		if (!sImage.length) {
			sImage = "zpbusy.gif";
		}
		var oFC = oContr.firstChild;
		if (oFC) {
			oFC = oFC.firstChild;
			if (oFC) {
				oFC = oFC.firstChild;
				if (oFC && oFC.tagName && oFC.tagName.toLowerCase() == "img") {
					var sSrc = oFC.getAttribute("src");
					if (typeof sSrc == "string" && sSrc.length) {
						sSrc = sSrc.split("/").pop();
						if (sSrc == sImage) {
							return true;
						}
					}
				}
			}
		}
		return false;
	};
	ET.Transport.showBusy = function (oArg) {
		if (etTransport.isBusy(oArg)) {
			return;
		}
		var oContr = oArg.busyContainer;
		if (typeof oContr == "string") {
			oContr = document.getElementById(oContr);
		}
		if (!oContr) {
			return;
		}
		var sImage = oArg.busyImage;
		var sImageWidth = oArg.busyImageWidth;
		var sImageHeight = oArg.busyImageHeight;
		if (typeof sImage != "string" || !sImage.length) {
			sImage = "zpbusy.gif";
		} else {
			if (typeof sImageWidth == "number" || (typeof sImageWidth == "string" && /\d$/.test(sImageWidth))) {
				sImageWidth += "px";
			}
			if (typeof sImageHeight == "number" || (typeof sImageHeight == "string" && /\d$/.test(sImageHeight))) {
				sImageHeight += "px";
			}
		}
		if (!sImageWidth) {
			sImageWidth = "65px";
		}
		if (!sImageHeight) {
			sImageHeight = "35px";
		}
		var sPath = "";
		if (sImage.indexOf("/") < 0) {
			if (ET.etPath) {
				sPath = ET.etPath;
			} else {
				sPath = etTransport.getPath("transport.js");
			}
		}
		var aImg = [];
		aImg.push("<img src=\"");
		aImg.push(sPath);
		aImg.push(sImage);
		aImg.push("\"");
		if (sImageWidth || sImageHeight) {
			aImg.push(" style=\"");
			if (sImageWidth) {
				aImg.push("width:");
				aImg.push(sImageWidth);
				aImg.push(";");
			}
			if (sImageHeight) {
				aImg.push("height:");
				aImg.push(sImageHeight);
			}
			aImg.push("\"");
		}
		aImg.push(" />");
		var iContainerWidth = oContr.offsetWidth;
		var iContainerHeight = oContr.offsetHeight;
		var oBusyContr = etUtils.createElement("div");
		oBusyContr.style.position = "relative";
		oBusyContr.style.zIndex = 2147483583;
		var oBusy = etUtils.createElement("div", oBusyContr);
		oBusy.style.position = "absolute";
		oBusy.innerHTML = aImg.join("");
		oContr.insertBefore(oBusyContr, oContr.firstChild);
		var iBusyWidth = oBusy.offsetWidth;
		var iBusyHeight = oBusy.offsetHeight;
		if (iContainerWidth > iBusyWidth) {
			oBusy.style.left = oContr.scrollLeft + (iContainerWidth - iBusyWidth) / 2 + "px";
		}
		if (iContainerHeight > iBusyHeight) {
			oBusy.style.top = oContr.scrollTop + (iContainerHeight - iBusyHeight) / 2 + "px";
		}
	};
	ET.Transport.removeBusy = function (oArg) {
		var oContr = oArg.busyContainer;
		if (typeof oContr == "string") {
			oContr = document.getElementById(oContr);
		}
		if (!oContr) {
			return;
		}
		if (etTransport.isBusy(oArg)) {
			oContr.removeChild(oContr.firstChild);
		}
	};
	ET.Transport.fetch = function (oArg) {
		if (oArg == null || typeof oArg != "object") {
			return null;
		}
		if (!oArg.url) {
			return null;
		}
		if (!oArg.method) {
			oArg.method = "GET";
		}
		if (typeof oArg.async == "undefined") {
			oArg.async = true;
		}
		if (!oArg.contentType && oArg.method.toUpperCase() == "POST") {
			oArg.contentType = "application/x-www-form-urlencoded";
		}
		if (!oArg.content) {
			oArg.content = null;
		}
		if (!oArg.onLoad) {
			oArg.onLoad = null;
		}
		if (!oArg.onError) {
			oArg.onError = null;
		}
		var oRequest = etTransport.createXmlHttpRequest();
		if (oRequest == null) {
			return null;
		}
		etTransport.showBusy(oArg);
		var bErrorDisplayed = false;
		var funcOnReady = function () {
			etTransport.removeBusy(oArg);
			try {
				if (oRequest.status == 200 || oRequest.status == 304 || (location.protocol == "file:" && !oRequest.status)) {
					if (typeof oArg.onLoad == "function") {
						oArg.onLoad(oRequest);
					}
				} else {
					if (!bErrorDisplayed) {
						bErrorDisplayed = true;
						etTransport.displayError(oRequest.status, "Error: Can't fetch " + oArg.url + ". " + (oRequest.statusText || ""), oArg.onError);
					}
				}
			}
			catch (oExpn) {
				if (oExpn.name == "NS_ERROR_NOT_AVAILABLE") {
					if (!bErrorDisplayed) {
						bErrorDisplayed = true;
						etTransport.displayError(0, "Error: Can't fetch " + oArg.url + ". File not found.", oArg.onError);
					}
				} else {
					throw (oExpn);
				}
			}
		};
		try {
			if (typeof oArg.username != "undefined" && typeof oArg.password != "undefined") {
				oRequest.open(oArg.method, oArg.url, oArg.async, oArg.username, oArg.password);
			} else {
				oRequest.open(oArg.method, oArg.url, oArg.async);
			}
			if (oArg.async) {
				oRequest.onreadystatechange = function () {
					if (oRequest.readyState == 4) {
						funcOnReady();
						oRequest.onreadystatechange = {};
					}
				};
			}
			if (oArg.contentType) {
				oRequest.setRequestHeader("Content-Type", oArg.contentType);
			}
			oRequest.send(oArg.content);
			if (!oArg.async) {
				funcOnReady();
			}
			return oRequest;
		}
		catch (oExpn) {
			etTransport.removeBusy(oArg);
			if (oExpn.name && oExpn.name == "NS_ERROR_FILE_NOT_FOUND") {
				if (!bErrorDisplayed) {
					bErrorDisplayed = true;
					etTransport.displayError(0, "Error: Can't fetch " + oArg.url + ". File not found.", oArg.onError);
				}
			} else {
				throw (oExpn);
			}
		}
		return null;
	};
	ET.Transport.parseHtml = function (sHtml, oContainer) {
		sHtml += "";
		sHtml = sHtml.replace(/^\s+/g, "");
		var oTmpContr;
		if (document.createElementNS) {
			oTmpContr = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
		} else {
			oTmpContr = document.createElement("div");
		}
		oTmpContr.innerHTML = sHtml;
		if (oContainer) {
			var oEl = oTmpContr.firstChild;
			while (oEl) {
				oContainer.appendChild(oEl);
				oEl = oTmpContr.firstChild;
			}
		} else {
			return oTmpContr;
		}
	};
	ET.Transport.evalGlobalScope = function (sScript) {
		if (typeof sScript != "string" || !sScript.match(/\S/)) {
			return;
		}
		if (window.execScript) {
			window.execScript(sScript, "javascript");
		} else {
			if (window.eval) {
				window.eval(sScript);
			}
		}
	};
	ET.Transport.setInnerHtml = function (oArg) {
		if (!oArg || typeof oArg.html != "string") {
			return;
		}
		var sHtml = oArg.html;
		var oContr = null;
		if (typeof oArg.container == "string") {
			oContr = document.getElementById(oArg.container);
		} else {
			if (typeof oArg.container == "object") {
				oContr = oArg.container;
			}
		}
		var aScripts = [];
		if (sHtml.match(/<\s*\/\s*script\s*>/i)) {
			var aTokens = sHtml.split(/<\s*\/\s*script\s*>/i);
			var aHtml = [];
			for (var iToken = aTokens.length - 1; iToken >= 0; iToken--) {
				var sToken = aTokens[iToken];
				if (sToken.match(/\S/)) {
					var aMatch = sToken.match(/<\s*script([^>]*)>/i);
					if (aMatch) {
						var aCouple = sToken.split(/<\s*script[^>]*>/i);
						while (aCouple.length < 2) {
							if (sToken.match(/^<\s*script[^>]*>/i)) {
								aCouple.unshift("");
							} else {
								aCouple.push("");
							}
						}
						aHtml.unshift(aCouple[0]);
						var sAttrs = aMatch[1];
						var srtScript = aCouple[1];
						if (sAttrs.match(/\s+src\s*=/i)) {
							srtScript = "";
						} else {
							srtScript = srtScript.replace(/function\s+([^(]+)/g, "$1=function");
						}
						aScripts.push([sAttrs, srtScript]);
					} else {
						if (iToken < aTokens.length - 1) {
							aTokens[iToken - 1] += "</script>" + sToken;
						} else {
							aHtml.unshift(sToken);
						}
					}
				} else {
					aHtml.unshift(sToken);
				}
			}
			sHtml = aHtml.join("");
		}
		if (oContr) {
			if (window.opera) {
				oContr.innerHTML = "<form></form>";
			}
			oContr.innerHTML = sHtml;
		}
		for (var iScript = 0; iScript < aScripts.length; iScript++) {
			if (aScripts[iScript][1].length) {
				etTransport.evalGlobalScope(aScripts[iScript][1]);
			}
			var sAttrs = aScripts[iScript][0];
			sAttrs = etUtils.multispacekill(sAttrs).replace(/ = /g, "=");
			if (sAttrs.indexOf("src=") >= 0) {
				var oContr = document.body;
				if (!oContr) {
					oContr = document.getElementsByTagName("head")[0];
					if (!oContr) {
						oContr = document;
					}
				}
				var aAttrs = sAttrs.split(" ");
				var oScript = etUtils.createElement("script");
				for (var iAttr = 0; iAttr < aAttrs.length; iAttr++) {
					var aAttr = aAttrs[iAttr].split("=");
					if (aAttr.length > 1) {
						oScript.setAttribute(aAttr[0], aAttr[1].match(/^[\s|"|']*([\s|\S]*[^'|"])[\s|"|']*$/)[1]);
					} else {
						oScript.setAttribute(aAttr[0], aAttr[0]);
					}
				}
				oContr.appendChild(oScript);
			}
		}
	};
	ET.Transport.fetchXmlDoc = function (oArg) {
		if (oArg == null || typeof oArg != "object") {
			return null;
		}
		if (!oArg.url) {
			return null;
		}
		if (typeof oArg.async == "undefined") {
			oArg.async = true;
		}
		if (!oArg.onLoad) {
			oArg.onLoad = null;
		}
		if (!oArg.onError) {
			oArg.onError = null;
		}
		if (!oArg.method && typeof oArg.username == "undefined" && typeof oArg.password == "undefined") {
			if (document.implementation && document.implementation.createDocument) {
				var oDoc = null;
				if (!oArg.reliable) {
					oArg.reliable = false;
				}
				var oFetchArg = {};
				for (var sKey in oArg) {
					oFetchArg[sKey] = oArg[sKey];
				}
				if (oArg.async) {
					oFetchArg.onLoad = function (oRequest) {
						oFetchArg.onLoad = null;
						var parser = new DOMParser();
						oDoc = parser.parseFromString(oRequest.responseText, "text/xml");
						etTransport.removeBusy(oArg);
						etTransport.onXmlDocLoad(oDoc, oArg.onLoad, oArg.onError);
					};
				} else {
					oFetchArg.onLoad = null;
				}
				var oRequest = etTransport.fetch(oFetchArg);
				if (oRequest) {
					if (oArg.async) {
						return oRequest;
					} else {
						var parser = new DOMParser();
						oDoc = parser.parseFromString(oRequest.responseText, "text/xml");
						etTransport.removeBusy(oArg);
						etTransport.onXmlDocLoad(oDoc, oArg.onLoad, oArg.onError);
						return oDoc;
					}
				}
				return null;
			}
			if (typeof ActiveXObject != "undefined") {
				etTransport.showBusy(oArg);
				try {
					var oDoc = new ActiveXObject(etTransport.XMLDOM);
					oDoc.async = oArg.async;
					if (oArg.async) {
						oDoc.onreadystatechange = function () {
							if (oDoc.readyState == 4) {
								etTransport.removeBusy(oArg);
								etTransport.onXmlDocLoad(oDoc, oArg.onLoad, oArg.onError);
								oDoc.onreadystatechange = {};
							}
						};
					}
					oDoc.load(oArg.url);
					if (!oArg.async) {
						etTransport.removeBusy(oArg);
						etTransport.onXmlDocLoad(oDoc, oArg.onLoad, oArg.onError);
					}
					return oDoc;
				}
				catch (oExpn) {
					etTransport.removeBusy(oArg);
				}
			}
		}
		var oFetchArg = {};
		for (var sKey in oArg) {
			oFetchArg[sKey] = oArg[sKey];
		}
		if (oArg.async) {
			oFetchArg.onLoad = function (oRequest) {
				etTransport.parseXml({strXml:oRequest.responseText, onLoad:oArg.onLoad, onError:oArg.onError});
			};
		} else {
			oFetchArg.onLoad = null;
		}
		var oRequest = etTransport.fetch(oFetchArg);
		if (oRequest) {
			if (oArg.async) {
				return oRequest;
			} else {
				return etTransport.parseXml({strXml:oRequest.responseText, onLoad:oArg.onLoad, onError:oArg.onError});
			}
		}
		return null;
	};
	ET.Transport.parseXml = function (oArg) {
		if (oArg == null || typeof oArg != "object") {
			return null;
		}
		if (!oArg.strXml) {
			return null;
		}
		if (!oArg.onLoad) {
			oArg.onLoad = null;
		}
		if (!oArg.onError) {
			oArg.onError = null;
		}
		if (window.DOMParser) {
			try {
				var oDoc = (new DOMParser()).parseFromString(oArg.strXml, "text/xml");
				etTransport.onXmlDocLoad(oDoc, oArg.onLoad, oArg.onError);
				return oDoc;
			}
			catch (oExpn) {
				etTransport.displayError(0, "Error: Cannot parse. String does not appear to be a valid XML fragment.", oArg.onError);
			}
			return null;
		}
		if (typeof ActiveXObject != "undefined") {
			try {
				var oDoc = new ActiveXObject(etTransport.XMLDOM);
				oDoc.loadXML(oArg.strXml);
				etTransport.onXmlDocLoad(oDoc, oArg.onLoad, oArg.onError);
				return oDoc;
			}
			catch (oExpn) {
			}
		}
		return null;
	};
	ET.Transport.onXmlDocLoad = function (oDoc, onLoad, onError) {
		var sError = null;
		if (oDoc.parseError) {
			sError = oDoc.parseError.reason;
			if (oDoc.parseError.srcText) {
				sError += "Location: " + oDoc.parseError.url + "\nLine number " + oDoc.parseError.line + ", column " + oDoc.parseError.linepos + ":\n" + oDoc.parseError.srcText + "\n";
			}
		} else {
			if (oDoc.documentElement && oDoc.documentElement.tagName == "parsererror") {
				sError = oDoc.documentElement.firstChild.data + "\n" + oDoc.documentElement.firstChild.nextSibling.firstChild.data;
			} else {
				if (!oDoc.documentElement) {
					sError = "String does not appear to be a valid XML fragment.";
				}
			}
		}
		if (sError) {
			etTransport.displayError(0, "Error: Cannot parse. " + sError, onError);
		} else {
			if (typeof onLoad == "function") {
				onLoad(oDoc);
			}
		}
	};
	ET.Transport.serializeXmlDoc = function (oDoc) {
		if (window.XMLSerializer) {
			return (new XMLSerializer).serializeToString(oDoc);
		}
		if (oDoc.xml) {
			return oDoc.xml;
		}
	};
	ET.Transport.fetchJsonObj = function (oArg) {
		if (oArg == null || typeof oArg != "object") {
			return null;
		}
		if (!oArg.url) {
			return null;
		}
		if (typeof oArg.async == "undefined") {
			oArg.async = true;
		}
		if (!oArg.reliable) {
			oArg.reliable = false;
		}
		var oFetchArg = {};
		for (var sKey in oArg) {
			oFetchArg[sKey] = oArg[sKey];
		}
		if (oArg.async) {
			oFetchArg.onLoad = function (oRequest) {
				etTransport.parseJson({strJson:oRequest.responseText, reliable:oArg.reliable, onLoad:oArg.onLoad, onError:oArg.onError});
			};
		} else {
			oFetchArg.onLoad = null;
		}
		var oRequest = etTransport.fetch(oFetchArg);
		if (oRequest) {
			if (oArg.async) {
				return oRequest;
			} else {
				return etTransport.parseJson({strJson:oRequest.responseText, reliable:oArg.reliable, onLoad:oArg.onLoad, onError:oArg.onError});
			}
		}
		return null;
	};
	ET.Transport.parseJson = function (oArg) {
		if (oArg == null || typeof oArg != "object") {
			return null;
		}
		if (!oArg.reliable) {
			oArg.reliable = false;
		}
		if (!oArg.onLoad) {
			oArg.onLoad = null;
		}
		if (!oArg.onError) {
			oArg.onError = null;
		}
		var oJson = null;
		if (typeof (oArg.strJson) == "string" && oArg.strJson.length > 0) {
			try {
				if (oArg.reliable) {
					if (oArg.strJson) {
						oJson = eval("(" + oArg.strJson + ")");
					}
				} else {
					oJson = etTransport.parseJsonStr(oArg.strJson);
				}
			}
			catch (oExpn) {
				var sError = "Error: Cannot parse. String does not appear to be a valid JSON fragment: " + oExpn.message;
				if (typeof oExpn.text == "string") {
					sError += "\n" + oExpn.text;
				}
				sError += "\n" + oArg.strJson;
				etTransport.displayError(0, sError, oArg.onError);
				return null;
			}
		}
		if (typeof oArg.onLoad == "function") {
			oArg.onLoad(oJson);
		}
		return oJson;
	};
	ET.Transport.parseJsonStr = function (text) {
		var p = /^\s*(([,:{}\[\]])|"(\\.|[^\x00-\x1f"\\])*"|-?\d+(\.\d*)?([eE][+-]?\d+)?|true|false|null)\s*/, token, operator;
		function error(m, t) {
			throw {name:"JSONError", message:m, text:t || operator || token};
		}
		function next(b) {
			if (b && b != operator) {
				error("Expected '" + b + "'");
			}
			if (text) {
				var t = p.exec(text);
				if (t) {
					if (t[2]) {
						token = null;
						operator = t[2];
					} else {
						operator = null;
						try {
							token = eval(t[1]);
						}
						catch (e) {
							error("Bad token", t[1]);
						}
					}
					text = text.substring(t[0].length);
				} else {
					error("Unrecognized token", text);
				}
			} else {
				token = operator = null;
			}
		}
		function val() {
			var k, o;
			switch (operator) {
			  case "{":
				next("{");
				o = {};
				if (operator != "}") {
					for (; ; ) {
						if (operator || typeof token != "string") {
							error("Missing key");
						}
						k = token;
						next();
						next(":");
						o[k] = val();
						if (operator != ",") {
							break;
						}
						next(",");
					}
				}
				next("}");
				return o;
			  case "[":
				next("[");
				o = [];
				if (operator != "]") {
					for (; ; ) {
						o.push(val());
						if (operator != ",") {
							break;
						}
						next(",");
					}
				}
				next("]");
				return o;
			  default:
				if (operator !== null) {
					error("Missing value");
				}
				k = token;
				next();
				return k;
			}
		}
		next();
		return val();
	};
	ET.Transport.serializeJsonObj = function (v, bAllowFunctions) {
		var a = [];
		var e = function (s) {
			a[a.length] = s;
		};
		var g = function (x) {
			var c, i, l, v;
			switch (typeof x) {
			  case "object":
				if (x) {
					if (x instanceof Array) {
						e("[");
						l = a.length;
						for (i = 0; i < x.length; i += 1) {
							if (l < a.length) {
								e(",");
							}
							g(x[i]);
						}
						e("]");
						return;
					} else {
						if (x instanceof Date) {
							e("\"");
							e(x.toString());
							e("\"");
							return;
						} else {
							if (typeof x.toString != "undefined") {
								e("{");
								l = a.length;
								for (i in x) {
									v = x[i];
									if (x.hasOwnProperty(i) && typeof v != "undefined" && (bAllowFunctions || typeof v != "function")) {
										if (l < a.length) {
											e(",");
										}
										g(i);
										e(":");
										g(v);
									}
								}
								e("}");
								return;
							}
						}
					}
				}
				e("null");
				return;
			  case "number":
				e(isFinite(x) ? +x : "null");
				return;
			  case "string":
				l = x.length;
				e("\"");
				for (i = 0; i < l; i += 1) {
					c = x.charAt(i);
					if (c >= " ") {
						if (c == "\\" || c == "\"") {
							e("\\");
						}
						e(c);
					} else {
						switch (c) {
						  case "\b":
							e("\\b");
							break;
						  case "\f":
							e("\\f");
							break;
						  case "\n":
							e("\\n");
							break;
						  case "\r":
							e("\\r");
							break;
						  case "\t":
							e("\\t");
							break;
						  default:
							c = c.charCodeAt();
							e("\\u00" + Math.floor(c / 16).toString(16) + (c % 16).toString(16));
						}
					}
				}
				e("\"");
				return;
			  case "boolean":
				e(String(x));
				return;
			  case "function":
				if (bAllowFunctions) {
					e(x.toString().replace(/function anonymous/g, "function"));
				} else {
					e("null");
				}
				return;
			  default:
				e("null");
				return;
			}
		};
		g(v);
		return a.join("");
	};
	ET.Transport.displayError = function (iErrCode, sError, onError) {
		if (typeof onError == "function") {
			onError({errorCode:iErrCode, errorDescription:sError});
		} else {
			if (typeof etDebug == "function") {
				etDebug.log.error("ET.Transport: " + sError);
			}
		}
	};
	ET.Transport.translateUrl = function (oArg) {
		if (!oArg || !oArg.url) {
			return null;
		}
		var aFullUrl = oArg.url.split("?", 2);
		var sUrl = aFullUrl[0];
		if (sUrl.indexOf(":") >= 0) {
			aFullUrl[0] = etTransport.fixUrl(sUrl);
			return aFullUrl.join("?");
		}
		var oLocation = document.location;
		var sPort = oLocation.port;
		if (sPort) {
			sPort = ":" + sPort;
		}
		if (sUrl.charAt(0) == "/") {
			aFullUrl[0] = [oLocation.protocol, "//", oLocation.hostname, sPort, etTransport.fixUrl(sUrl)].join("");
		} else {
			var sLocation;
			if (sPort) {
				sLocation = [oLocation.protocol, "//", oLocation.hostname, sPort, oLocation.pathname].join("");
			} else {
				sLocation = oLocation.toString();
			}
			var sRelativeTo;
			if (typeof oArg.relativeTo != "string") {
				sRelativeTo = sLocation.split("?", 2)[0];
			} else {
				sRelativeTo = oArg.relativeTo.split("?", 2)[0];
				if (sRelativeTo.indexOf("/") < 0) {
					sRelativeTo = sLocation.split("?", 2)[0];
				} else {
					if (sRelativeTo.charAt(0) != "/" && sRelativeTo.indexOf(":") < 0) {
						sRelativeTo = etTransport.translateUrl({url:sRelativeTo});
					}
				}
			}
			sRelativeTo = sRelativeTo.split("#")[0];
			sRelativeTo = sRelativeTo.split("/");
			sRelativeTo.pop();
			sRelativeTo = sRelativeTo.join("/");
			aFullUrl[0] = etTransport.fixUrl(sRelativeTo + "/" + sUrl);
		}
		return aFullUrl.join("?");
	};
	ET.Transport.fixUrl = function (sUrl) {
		var aTokens = sUrl.split("/");
		var aUrl = [];
		var iTokens = aTokens.length;
		var sToken;
		for (var iToken = 0; iToken < iTokens; iToken++) {
			sToken = aTokens[iToken];
			if (sToken == "..") {
				aUrl.pop();
			} else {
				if (sToken != ".") {
					aUrl.push(sToken);
				}
			}
		}
		return aUrl.join("/");
	};
	ET.Transport.loading = {};
	ET.Transport.setupEvents = function (oArg) {
		if (!oArg) {
			return {};
		}
		if (oArg.force || !ET.EventDriven || !oArg.url) {
			return {onLoad:oArg.onLoad, onError:oArg.onError};
		}
		var sUrl = oArg.url;
		if (typeof oArg.onLoad == "function") {
			ET.EventDriven.addEventListener("zpTransportOnLoad" + sUrl, oArg.onLoad);
		}
		if (typeof oArg.onError == "function") {
			ET.EventDriven.addEventListener("zpTransportOnError" + sUrl, oArg.onError);
		}
		if (etTransport.loading[sUrl]) {
			return {loading:true};
		} else {
			etTransport.loading[sUrl] = true;
			return {onLoad:new Function("ET.EventDriven.fireEvent('zpTransportOnLoad" + sUrl + "');ET.EventDriven.removeEvent('zpTransportOnLoad" + sUrl + "');ET.EventDriven.removeEvent('zpTransportOnError" + sUrl + "');etTransport.loading['" + sUrl + "'] = false;"), onError:new Function("oError", "ET.EventDriven.fireEvent('zpTransportOnError" + sUrl + "',oError);ET.EventDriven.removeEvent('zpTransportOnLoad" + sUrl + "');ET.EventDriven.removeEvent('zpTransportOnError" + sUrl + "');etTransport.loading['" + sUrl + "'] = false;")};
		}
	};
	ET.Transport.loadedJS = {};
	ET.Transport.isLoadedJS = function (sUrl, sAbsUrl) {
		if (typeof sAbsUrl == "undefined") {
			sAbsUrl = etTransport.translateUrl({url:sUrl});
		}
		if (etTransport.loadedJS[sAbsUrl]) {
			return true;
		}
		var aScripts = document.getElementsByTagName("script");
		for (var iScript = 0; iScript < aScripts.length; iScript++) {
			var sSrc = aScripts[iScript].getAttribute("src") || "";
			if (sSrc == sUrl) {
				etTransport.loadedJS[sAbsUrl] = true;
				return true;
			}
		}
		return false;
	};
	ET.Transport.getPath = function (sScriptFileName) {
		var aScripts = document.getElementsByTagName("script");
		for (var iScript = aScripts.length - 1; iScript >= 0; iScript--) {
			var sSrc = aScripts[iScript].getAttribute("src") || "";
			var aTokens = sSrc.split("/");
			var sLastToken = aTokens.pop();
			if (sLastToken == sScriptFileName) {
				return aTokens.length ? aTokens.join("/") + "/" : "";
			}
		}
		for (var sSrc in etTransport.loadedJS) {
			var aTokens = sSrc.split("/");
			var sLastToken = aTokens.pop();
			if (sLastToken == sScriptFileName) {
				return aTokens.length ? aTokens.join("/") + "/" : "";
			}
		}
		return "";
	};
	ET.Transport.include = function (sSrc, sId, bForce) {
		if (etDoNotInclude) {
			return;
		}
		var sAbsUrl = etTransport.translateUrl({url:sSrc});
		if (!bForce && etTransport.isLoadedJS(sSrc, sAbsUrl)) {
			return;
		}
		document.write("<script type=\"text/javascript\" src=\"" + sSrc + (typeof sId == "string" ? "\" id=\"" + sId : "") + "\"></script>");
		etTransport.loadedJS[sAbsUrl] = true;
	};
	ET.include = etTransport.include;
	ET.Transport.includeJS = function (sSrc, sId) {
		setTimeout(function () {
			var oContr = document.body;
			if (!oContr) {
				oContr = document.getElementsByTagName("head")[0];
				if (!oContr) {
					oContr = document;
				}
			}
			var oScript = document.createElement("script");
			oScript.type = "text/javascript";
			oScript.src = sSrc;
			if (typeof sId == "string") {
				oScript.id = sId;
			}
			oContr.appendChild(oScript);
		}, 0);
	};
	ET.Transport.loadJS = function (oArg) {
		if (!(oArg instanceof Object)) {
			return;
		}
		if (typeof oArg.async == "undefined") {
			oArg.async = true;
		}
		var sUrl = null;
		if (oArg.url) {
			sUrl = oArg.url;
		} else {
			if (oArg.module) {
				var sPath = "";
				if (typeof oArg.path != "undefined") {
					sPath = oArg.path;
				} else {
					if (typeof ET.etPath != "undefined") {
						sPath = ET.etPath;
					}
				}
				sUrl = sPath + oArg.module + ".js";
			} else {
				return;
			}
		}
		var sAbsUrl = etTransport.translateUrl({url:sUrl});
		if (!oArg.onLoad) {
			oArg.onLoad = null;
		}
		if (!oArg.onError) {
			oArg.onError = null;
		}
		if (etDoNotInclude || (!oArg.force && etTransport.isLoadedJS(sUrl, sAbsUrl))) {
			if (typeof oArg.onLoad == "function") {
				oArg.onLoad();
			}
			return;
		}
		var oHandlers = etTransport.setupEvents({url:sAbsUrl, force:oArg.force, onLoad:oArg.onLoad, onError:oArg.onError});
		if (oHandlers.loading) {
			return;
		}
		etTransport.fetch({url:sUrl, async:oArg.async, onLoad:function (oRequest) {
			if (oArg.force || !etTransport.loadedJS[sAbsUrl]) {
				var aTokens = sUrl.split("/");
				var sLastToken = aTokens.pop();
				ET.lastLoadedModule = aTokens.join("/") + "/";
				etTransport.evalGlobalScope(oRequest.responseText);
				ET.lastLoadedModule = null;
				etTransport.loadedJS[sAbsUrl] = true;
			}
			if (typeof oHandlers.onLoad == "function") {
				oHandlers.onLoad();
			}
		}, onError:oHandlers.onError});
	};
	ET.Transport.includeCSS = function (sHref) {
		var oContr = document.getElementsByTagName("head")[0];
		if (!oContr) {
			return;
		}
		var oLink = document.createElement("link");
		oLink.setAttribute("rel", "stylesheet");
		oLink.setAttribute("type", "text/css");
		oLink.setAttribute("href", sHref);
		oContr.appendChild(oLink);
	};
	ET.Transport.loadedCss = {};
	ET.Transport.loadCss = function (oArg) {
		if (!(oArg instanceof Object)) {
			return;
		}
		if (!oArg.url) {
			return;
		}
		if (typeof oArg.async == "undefined") {
			oArg.async = true;
		}
		var sAbsUrl = etTransport.translateUrl({url:oArg.url});
		if (!oArg.force) {
			if (etTransport.loadedCss[sAbsUrl]) {
				if (typeof oArg.onLoad == "function") {
					oArg.onLoad();
				}
				return;
			}
			var aLinks = document.getElementsByTagName("link");
			for (var iLnk = 0; iLnk < aLinks.length; iLnk++) {
				var sHref = aLinks[iLnk].getAttribute("href") || "";
				sHref = etTransport.translateUrl({url:sHref});
				if (sHref == sAbsUrl) {
					etTransport.loadedCss[sAbsUrl] = true;
					if (typeof oArg.onLoad == "function") {
						oArg.onLoad();
					}
					return;
				}
			}
		}
		var oHandlers = etTransport.setupEvents({url:sAbsUrl, force:oArg.force, onLoad:oArg.onLoad, onError:oArg.onError});
		if (oHandlers.loading) {
			return;
		}
		etTransport.fetch({url:sAbsUrl, async:oArg.async, onLoad:function (oRequest) {
			var sCss = oRequest.responseText;
			var aResultCss = [];
			var aImgUrls = [];
			var aCssUrls = [];
			var iPos = 0;
			var iNextPos = sCss.indexOf("url(", iPos);
			while (iNextPos >= 0) {
				iNextPos += 4;
				var sToken = sCss.substring(iPos, iNextPos);
				var bIsImport = /@import\s+url\($/.test(sToken);
				aResultCss.push(sToken);
				iPos = iNextPos;
				iNextPos = sCss.indexOf(")", iPos);
				if (iNextPos >= 0) {
					var sImgUrl = sCss.substring(iPos, iNextPos);
					sImgUrl = sImgUrl.replace(/['"]/g, "");
					sImgUrl = etTransport.translateUrl({url:sImgUrl, relativeTo:oArg.url});
					sImgUrl = etTransport.translateUrl({url:sImgUrl});
					aResultCss.push(sImgUrl);
					if (bIsImport) {
						aCssUrls.push(sImgUrl);
					} else {
						aImgUrls.push(sImgUrl);
					}
					iPos = iNextPos;
					iNextPos = sCss.indexOf("url(", iPos);
				}
			}
			aResultCss.push(sCss.substr(iPos));
			sCss = aResultCss.join("");
			etTransport.loadCssList({urls:aCssUrls, async:oArg.async, onLoad:function () {
				(new ET.StyleSheet()).addParse(sCss);
				if (typeof oHandlers.onLoad == "function") {
					oHandlers.onLoad();
				}
			}});
			etTransport.loadedCss[sAbsUrl] = true;
			etTransport.preloadImages({urls:aImgUrls, timeout:60000});
		}, onError:oHandlers.onError});
	};
	ET.Transport.loadCssList = function (oArg) {
		if (!(oArg instanceof Object)) {
			return;
		}
		if (typeof oArg.async == "undefined") {
			oArg.async = true;
		}
		if (!oArg.onLoad) {
			oArg.onLoad = null;
		}
		if (!oArg.onError) {
			oArg.onError = null;
		}
		if (!oArg.urls || !oArg.urls.length) {
			if (typeof oArg.onLoad == "function") {
				oArg.onLoad();
			}
			return;
		}
		var sUrl = oArg.urls.shift();
		var funcOnLoad = function () {
			etTransport.loadCssList({urls:oArg.urls, async:oArg.async, force:oArg.force, onLoad:oArg.onLoad, onError:oArg.onError});
		};
		etTransport.loadCss({url:sUrl, async:oArg.async, force:oArg.force, onLoad:funcOnLoad, onError:function (oError) {
			etTransport.displayError(oError.errorCode, oError.errorDescription, oArg.onError);
			funcOnLoad();
		}});
	};
	ET.Transport.imagePreloads = [];
	ET.Transport.preloadImages = function (oArg) {
		if (typeof etPreloadImages == "function") {
			etTransport.imagePreloads.push(new etPreloadImages(oArg));
		}
	};
}
ET.Drag = function () {
};
etDrag = ET.Drag;
etUtils.emulateWindowEvent(["mousedown", "mousemove", "mouseup"]);
ET.Drag.currentId = null;
ET.Drag.start = function (oEv, sId, oArg) {
	var oEl = etWidgetGetElementById(sId);
	if (!oEl || oEl.zpDragArgs) {
		return true;
	}
	if (!oArg) {
		oArg = {};
	}
	var oPos = etUtils.getMousePos(oEv || window.event);
	etEventDriven.fireEvent("dragStart", {el:oEl, event:oEv, args:oArg});
	oEl.zpDragArgs = {};
	var oDragArgs = oEl.zpDragArgs;
	oDragArgs.args = oArg;
	oDragArgs.resize = oArg.resize;
	if (oArg.resize == "bottom-right") {
		oDragArgs.resizeBottomRight = true;
	} else {
		if (oArg.resize == "top-left") {
			oDragArgs.resizeTopLeft = true;
		}
	}
	oDragArgs.pageX = oPos.pageX;
	oDragArgs.pageY = oPos.pageY;
	oDragArgs.width = oEl.clientWidth;
	oDragArgs.height = oEl.clientHeight;
	oDragArgs.prevWidth = oDragArgs.width;
	oDragArgs.prevHeight = oDragArgs.height;
	var sTag;
	var oOffsetParent = oEl.offsetParent;
	if (oOffsetParent) {
		sTag = oOffsetParent.tagName.toLowerCase();
	}
	if (sTag && sTag != "body" && sTag != "html") {
		oPos = etUtils.getElementOffset(oEl);
		var oPosParent = etUtils.getElementOffset(oOffsetParent);
		oDragArgs.left = oPos.left - oPosParent.left;
		oDragArgs.top = oPos.top - oPosParent.top;
	} else {
		oDragArgs.left = oEl.offsetLeft;
		oDragArgs.top = oEl.offsetTop;
	}
	oDragArgs.right = oDragArgs.left + oDragArgs.width;
	oDragArgs.bottom = oDragArgs.top + oDragArgs.height;
	oDragArgs.prevLeft = oDragArgs.prevRealLeft = oDragArgs.left;
	oDragArgs.prevTop = oDragArgs.prevRealTop = oDragArgs.top;
	oDragArgs.vertical = oArg.vertical;
	oDragArgs.horizontal = oArg.horizontal;
	oDragArgs.limitTop = typeof oArg.limitTop == "number" ? oArg.limitTop : -Infinity;
	oDragArgs.limitBottom = typeof oArg.limitBottom == "number" ? oArg.limitBottom : Infinity;
	oDragArgs.limitLeft = typeof oArg.limitLeft == "number" ? oArg.limitLeft : -Infinity;
	oDragArgs.limitRight = typeof oArg.limitRight == "number" ? oArg.limitRight : Infinity;
	if (typeof oArg.step == "number") {
		oDragArgs.stepVertical = oDragArgs.stepHorizontal = oArg.step;
	}
	if (typeof oArg.stepVertical == "number") {
		oDragArgs.stepVertical = oArg.stepVertical;
	}
	if (typeof oArg.stepHorizontal == "number") {
		oDragArgs.stepHorizontal = oArg.stepHorizontal;
	}
	etDrag.currentId = sId;
	etUtils.addEvent(document, "mousemove", etDrag.move);
	etUtils.addEvent(document, "mouseup", etDrag.end);
	return true;
};
ET.Drag.move = function (oEv) {
	oEv || (oEv = window.event);
	if (!etDrag.currentId) {
		return etUtils.stopEvent(oEv);
	}
	var oEl = document.getElementById(etDrag.currentId);
	if (!(oEl && oEl.zpDragArgs)) {
		return etUtils.stopEvent(oEv);
	}
	var oDragArgs = oEl.zpDragArgs;
	var oStyle = oEl.style;
	var oPos = etUtils.getMousePos(oEv);
	var oParam = {el:oEl, startLeft:oDragArgs.left, startTop:oDragArgs.top, prevLeft:oDragArgs.prevLeft, prevTop:oDragArgs.prevTop, left:oDragArgs.prevLeft, top:oDragArgs.prevTop, realLeft:oDragArgs.prevRealLeft, realTop:oDragArgs.prevRealTop, startWidth:oDragArgs.width, startHeight:oDragArgs.height, prevWidth:oDragArgs.prevWidth, prevHeight:oDragArgs.prevHeight, width:oDragArgs.prevWidth, height:oDragArgs.prevHeight, event:oEv, args:oDragArgs.args};
	var iOffset, iPos, iStep, iSize;
	iOffset = oPos.pageX - oDragArgs.pageX;
	oParam.realLeft = oDragArgs.prevRealLeft = oDragArgs.left + iOffset;
	iStep = oDragArgs.stepHorizontal;
	if (iStep) {
		iOffset = Math.round(Math.round(iOffset / iStep) * iStep);
	}
	iPos = oDragArgs.left + iOffset;
	if (!oDragArgs.vertical) {
		if (oDragArgs.limitLeft <= iPos && oDragArgs.limitRight >= iPos) {
			if (oStyle.right) {
				oStyle.right = "";
			}
			if (oDragArgs.resize) {
				iPos = oDragArgs.left;
				if (oDragArgs.resizeBottomRight) {
					iSize = oDragArgs.width + iOffset;
				} else {
					if (oDragArgs.resizeTopLeft) {
						iSize = oDragArgs.width - iOffset;
						if (iSize > 0) {
							iPos = oDragArgs.right - iSize;
						}
					} else {
						if (iOffset > 0) {
							iSize = oDragArgs.width + iOffset;
						} else {
							iSize = oDragArgs.width - iOffset;
							iPos = oDragArgs.right - iSize;
						}
					}
				}
				if (iSize > 0) {
					oStyle.width = iSize + "px";
					oParam.width = oDragArgs.prevWidth = iSize;
				}
			}
			oStyle.left = iPos + "px";
			oParam.left = oDragArgs.prevLeft = iPos;
		}
	}
	iOffset = oPos.pageY - oDragArgs.pageY;
	oParam.realTop = oDragArgs.prevRealTop = oDragArgs.top + iOffset;
	iStep = oDragArgs.stepVertical;
	if (iStep) {
		iOffset = Math.round(Math.floor(iOffset / iStep) * iStep);
	}
	iPos = oDragArgs.top + iOffset;
	if (!oDragArgs.horizontal) {
		if (oDragArgs.limitTop <= iPos && oDragArgs.limitBottom >= iPos) {
			if (oStyle.bottom) {
				oStyle.bottom = "";
			}
			if (oDragArgs.resize) {
				iPos = oDragArgs.top;
				if (oDragArgs.resizeBottomRight) {
					iSize = oDragArgs.height + iOffset;
				} else {
					if (oDragArgs.resizeTopLeft) {
						iSize = oDragArgs.height - iOffset;
						if (iSize > 0) {
							iPos = oDragArgs.bottom - iSize;
						}
					} else {
						if (iOffset > 0) {
							iSize = oDragArgs.height + iOffset;
						} else {
							iSize = oDragArgs.height - iOffset;
							iPos = oDragArgs.bottom - iSize;
						}
					}
				}
				if (iSize > 0) {
					oStyle.height = iSize + "px";
					oParam.height = oDragArgs.prevHeight = iSize;
				}
			}
			oStyle.top = iPos + "px";
			oParam.top = oDragArgs.prevTop = iPos;
		}
	}
	etEventDriven.fireEvent("dragMove", oParam);
	return etUtils.stopEvent(oEv);
};
ET.Drag.end = function (oEv) {
	oEv || (oEv = window.event);
	if (!etDrag.currentId) {
		return etUtils.stopEvent(oEv);
	}
	var oEl = document.getElementById(etDrag.currentId);
	if (!(oEl && oEl.zpDragArgs)) {
		return etUtils.stopEvent(oEv);
	}
	var oDragArgs = oEl.zpDragArgs;
	etUtils.removeEvent(document, "mousemove", etDrag.move);
	etUtils.removeEvent(document, "mouseup", etDrag.end);
	var oParam = {el:oEl, startLeft:oDragArgs.left, startTop:oDragArgs.top, left:oDragArgs.prevLeft, top:oDragArgs.prevTop, realLeft:oDragArgs.prevRealLeft, realTop:oDragArgs.prevRealTop, startWidth:oDragArgs.width, startHeight:oDragArgs.height, width:oDragArgs.prevWidth, height:oDragArgs.prevHeight, event:oEv, args:oDragArgs.args};
	etDrag.currentId = null;
	oEl.zpDragArgs = null;
	etEventDriven.fireEvent("dragEnd", oParam);
	return etUtils.stopEvent(oEv);
};
ET.Widget = function (oArg) {
	this.arg = oArg;
	this.config = {};
	etWidget.SUPERconstructor.call(this);
	this.init(oArg);
};
etWidget = ET.Widget;
ET.inherit(etWidget, etEventDriven);
ET.Widget.id = "ET.Widget";
ET.Widget.path = ET.getPath("ET.Widget");
ET.Widget.prototype.init = function (oArg) {
	etWidget.SUPERclass.init.call(this);
	if (typeof this.id == "undefined") {
		var iId = 0;
		while (etWidgetAll[iId]) {
			iId++;
		}
		this.id = iId;
		etWidgetAll[iId] = this;
	}
	this.configure(oArg);
	this.addUserEventListeners();
	this.addStandardEventListeners();
	this.initLang();
	this.loadTheme();
	this.loadTemplate();
};
ET.Widget.prototype.reconfigure = function (oArg) {
	this.configure(oArg);
	this.loadTheme();
	this.loadTemplate();
	if (oArg && (oArg.lang || oArg.langCountryCode || oArg.langEncoding)) {
		this.langStr = this.config.lang;
		if (this.config.langCountryCode && this.config.langCountryCode.length > 0) {
			this.langStr += "_" + this.config.langCountryCode;
		}
		if (this.config.langEncoding && this.config.langEncoding.length > 0) {
			this.langStr += "-" + this.config.langEncoding;
		}
	}
	if (this.config.lang && this.config.lang.length > 0 && !(ET.Langs[this.config.langId] && ET.Langs[this.config.langId][this.langStr])) {
		this.debug(this.config.lang + (this.config.langCountryCode ? " and country code " + this.config.langCountryCode : "") + (this.config.langEncoding ? " and encoding " + this.config.langEncoding : ""));
		this.config.lang = null;
		this.config.langEncoding = null;
		this.langStr = null;
	}
};
ET.Widget.prototype.reset = function () {
	this.config = {};
	this.reconfigure(this.arg);
};
ET.Widget.prototype.configure = function (oArg) {
	this.defineConfigOption("theme", "default");
	this.defineConfigOption("templateFile", "default");
	var sPath = this.constructor.path;
	if (typeof sPath != "undefined") {
		this.defineConfigOption("themePath", etTransport.translateUrl({url:"./themes/", relativeTo:sPath}));
		this.defineConfigOption("templateFilePath", etTransport.translateUrl({url:"./templates/", relativeTo:sPath}));
	} else {
		this.defineConfigOption("templateFilePath", "./templates/");
	}
	this.defineConfigOption("templates");
	this.defineConfigOption("asyncTheme", false);
	this.defineConfigOption("source");
	this.defineConfigOption("sourceType", "html");
	this.defineConfigOption("sourceFetchMethod", "GET");
	this.defineConfigOption("sourceFetchContentType");
	this.defineConfigOption("sourceFetchContent");
	this.defineConfigOption("callbackSource");
	this.defineConfigOption("asyncSource", true);
	this.defineConfigOption("reliableSource", true);
	this.defineConfigOption("callbackConvertSource");
	this.defineConfigOption("eventListeners", {});
	this.defineConfigOption("langId");
	this.defineConfigOption("lang");
	this.defineConfigOption("langCountryCode");
	this.defineConfigOption("langEncoding");
	var oConfig = this.config;
	var sOption;
	if (oArg) {
		for (sOption in oArg) {
			if (typeof oConfig[sOption] != "undefined") {
				oConfig[sOption] = oArg[sOption];
			} else {
				this.debug("Unknown config option: " + sOption + ".", "warn");
			}
		}
	}
	var sConstructorId = this.constructor.id;
	if (sConstructorId) {
		var oCookie = etTransport.parseJson({strJson:etUtils.getCookie("ET.Config")});
		if (oCookie) {
			oCookie = oCookie[sConstructorId];
			if (oCookie) {
				for (sOption in oCookie) {
					if (typeof oConfig[sOption] != "undefined") {
						oConfig[sOption] = oCookie[sOption];
					}
				}
			}
		}
	}
};
ET.Widget.prototype.getConfiguration = function () {
	return this.config;
};
ET.Widget.all = [];
etWidgetAll = etWidget.all;
ET.Widget.getWidgetById = function (iId) {
	return etWidgetAll[iId];
};
etWidgetGetWidgetById = etWidget.getWidgetById;
ET.Widget.prototype.addCircularRef = function (oElement, sProperty) {
	if (!this.widgetCircularRefs) {
		this.widgetCircularRefs = [];
	}
	this.widgetCircularRefs.push([oElement, sProperty]);
};
ET.Widget.prototype.createProperty = function (oElement, sProperty, val) {
	oElement[sProperty] = val;
	this.addCircularRef(oElement, sProperty);
};
ET.Widget.prototype.removeCircularRefs = function () {
	if (!this.widgetCircularRefs) {
		return;
	}
	for (var iRef = this.widgetCircularRefs.length - 1; iRef >= 0; iRef--) {
		var oRef = this.widgetCircularRefs[iRef];
		try {
			oRef[0][oRef[1]] = null;
		}
		catch (e) {
		}
		oRef[0] = null;
	}
};
ET.Widget.prototype.discard = function () {
	this.discardEventHandlers();
	this.discardControls();
	this.discardTemplates();
	this.arg = null;
	this.config = null;
	etWidgetAll[this.id] = null;
	this.removeCircularRefs();
};
ET.Widget.removeCircularRefs = function () {
	var oWidget;
	for (var iWidget = etWidgetAll.length - 1; iWidget >= 0; iWidget--) {
		oWidget = etWidgetAll[iWidget];
		if (oWidget && typeof oWidget.discard == "function") {
			oWidget.discard();
		}
	}
};
etUtils.addEvent(window, "unload", etWidget.removeCircularRefs);
ET.Widget.prototype.defineConfigOption = function (sOption, val) {
	if (typeof this.config[sOption] == "undefined") {
		if (typeof val == "undefined") {
			this.config[sOption] = null;
		} else {
			this.config[sOption] = val;
		}
	}
};
ET.Widget.prototype.addUserEventListeners = function () {
	var oListeners = this.config.eventListeners;
	var fListener, iListeners, iListener;
	for (var sEvent in oListeners) {
		if (oListeners.hasOwnProperty(sEvent)) {
			vListener = oListeners[sEvent];
			if (vListener instanceof Array) {
				iListeners = vListener.length;
				for (iListener = 0; iListener < iListeners; iListener++) {
					this.addEventListener(sEvent, vListener[iListener]);
				}
			} else {
				this.addEventListener(sEvent, vListener);
			}
		}
	}
};
ET.Widget.prototype.addStandardEventListeners = function () {
	this.addEventListener("fetchSourceError", etWidget.loadSourceError);
	this.addEventListener("loadThemeError", etWidget.loadThemeError);
	this.addEventListener("loadTemplateError", etWidget.loadTemplateError);
};
ET.Widget.loadThemeError = function (oError) {
	this.debug("Cannot load theme: " + (oError && oError.errorDescription ? oError.errorDescription : "") + ".");
};
ET.Widget.loadTemplateError = function (oError) {
	this.debug("Cannot load template: " + (oError && oError.errorDescription ? oError.errorDescription : "") + ".");
};
ET.Widget.loadSourceError = function (oError) {
	this.debug("Cannot load source: " + (oError && oError.errorDescription ? oError.errorDescription : "") + ".");
};
ET.Widget.prototype.loadTheme = function () {
	var oConfig = this.config;
	if (typeof oConfig.theme == "string" && oConfig.theme.length) {
		var iPos = oConfig.theme.lastIndexOf("/");
		if (iPos >= 0) {
			iPos++;
			oConfig.themePath = oConfig.theme.substring(0, iPos);
			oConfig.theme = oConfig.theme.substring(iPos);
		}
		iPos = oConfig.theme.lastIndexOf(".");
		if (iPos >= 0) {
			oConfig.theme = oConfig.theme.substring(0, iPos);
		}
		oConfig.theme = oConfig.theme.toLowerCase();
		if (oConfig.theme == "auto") {
			var sUserAgent = navigator.userAgent;
			if (sUserAgent.indexOf("Windows NT 6") != -1) {
				oConfig.theme = "winvista";
			} else {
				if (sUserAgent.indexOf("Windows NT 5") != -1) {
					oConfig.theme = "winxp";
				} else {
					if (sUserAgent.indexOf("Win") != -1) {
						oConfig.theme = "win2k";
					} else {
						if (sUserAgent.indexOf("Mac") != -1) {
							oConfig.theme = "macosx";
						} else {
							oConfig.theme = "default";
						}
					}
				}
			}
		}
	} else {
		oConfig.theme = "";
	}
	if (oConfig.theme) {
		this.fireEvent("loadThemeStart");
		if (etDoNotLoadThemes) {
			this.themeLoaded = true;
			this.fireEvent("loadThemeEnd");
		} else {
			this.themeLoaded = false;
			var oWidget = this;
			etTransport.loadCss({url:oConfig.themePath + oConfig.theme + ".css", async:oConfig.asyncTheme, onLoad:function () {
				if (!oWidget) {
					return;
				}
				oWidget.themeLoaded = true;
				oWidget.fireEvent("loadThemeEnd");
				oWidget = null;
			}, onError:function (oError) {
				if (!oWidget) {
					return;
				}
				oWidget.themeLoaded = true;
				oWidget.fireEvent("loadThemeEnd");
				oWidget.fireEvent("loadThemeError", oError);
				oWidget = null;
			}});
		}
	}
};
ET.Widget.prototype.loadTemplate = function () {
	var oConfig = this.config;
	if (typeof oConfig.templateFile == "string" && oConfig.templateFile.length) {
		var iPos = oConfig.templateFile.lastIndexOf("/");
		if (iPos >= 0) {
			iPos++;
			oConfig.templateFilePath = oConfig.templateFile.substring(0, iPos);
			oConfig.templateFile = oConfig.templateFile.substring(iPos);
		}
		iPos = oConfig.templateFile.lastIndexOf(".");
		if (iPos >= 0) {
			oConfig.templateFile = oConfig.templateFile.substring(0, iPos);
		}
		oConfig.templateFile = oConfig.templateFile.toLowerCase();
	} else {
		oConfig.templateFile = "";
	}
	if (oConfig.templateFile && oConfig.templates) {
		this.fireEvent("loadTemplateStart");
		this.templateLoaded = false;
		var sTemplateFile = this.constructor.templateFiles;
		if (sTemplateFile) {
			sTemplateFile = sTemplateFile[oConfig.templateFile];
		}
		if (sTemplateFile) {
			this.parseTemplate(sTemplateFile);
		} else {
			var oWidget = this;
			etTransport.fetch({url:oConfig.templateFilePath + oConfig.templateFile + ".html" + (typeof etDebug == "function" ? "?" + Math.random() : ""), onLoad:function (oRequest) {
				if (!oWidget) {
					return;
				}
				oWidget.parseTemplate(oRequest.responseText);
				oWidget = null;
			}, onError:function (oError) {
				if (!oWidget) {
					return;
				}
				oWidget.templateLoaded = true;
				oWidget.fireEvent("loadTemplateEnd");
				oWidget.fireEvent("loadTemplateError", oError);
				oWidget = null;
			}});
		}
	}
};
ET.Widget.prototype.parseTemplate = function (sHtml) {
	var oContainer = etTransport.parseHtml(sHtml);
	oContainer.style.display = "none";
	document.body.insertBefore(oContainer, document.body.firstChild);
	this.initTemplates();
	document.body.removeChild(oContainer);
	oContainer = null;
	this.templateLoaded = true;
	this.fireEvent("loadTemplateEnd");
	this.display();
};
ET.Widget.prototype.initTemplates = function () {
	this.discardControls();
	this.discardTemplates();
	this.templates = {};
	var oTemplates = this.templates;
	var oTemplateContainers = this.config.templates;
	if (!oTemplateContainers) {
		this.debug("Missing config option \"templates\".");
		return;
	}
	if (!etTemplate) {
		this.debug("Cannot find ET.Template class.");
		return;
	}
	var sTplContainer, sTplContainerId;
	for (sTplContainer in oTemplateContainers) {
		sTplContainerId = oTemplateContainers[sTplContainer];
		if (typeof sTplContainerId == "string" && sTplContainerId.length) {
			oTemplates[sTplContainer] = new etTemplate({source:sTplContainerId, sourceType:"html"});
		}
	}
};
ET.Widget.prototype.discardTemplates = function () {
	var oTemplates = this.templates;
	if (oTemplates) {
		var sTpl, oTpl;
		for (sTpl in oTemplates) {
			oTpl = oTemplates[sTpl];
			if (oTpl && typeof oTpl.discard == "function") {
				oTpl.discard();
				oTemplates[sTpl] = null;
			}
		}
	}
};
ET.Widget.prototype.display = function () {
	if (!this.templates) {
		this.debug("Templates are not loaded.");
	}
};
ET.Widget.prototype.initControls = function () {
	this.discardControls();
	this.controls = {};
};
ET.Widget.prototype.discardControls = function () {
	var oControls = this.controls;
	if (oControls) {
		var sControl, oControl;
		for (sControl in oControls) {
			oControl = oControls[sControl];
			if (oControl && typeof oControl.discard == "function") {
				oControl.discard();
				oControls[sControl] = null;
			}
		}
	}
};
ET.Widget.prototype.setEventHandlers = function () {
	this.discardEventHandlers();
	this.eventHandlers = {};
};
ET.Widget.prototype.addEventHandler = function (sHandlerName, oElement, sEvent, fListener, bUseCapture, bRemoveOnUnload) {
	if (!this.eventHandlers) {
		this.setEventHandlers();
	}
	this.removeEventHandler(sHandlerName);
	etUtils.addEvent(oElement, sEvent, fListener);
	this.eventHandlers[sHandlerName] = {element:oElement, event:sEvent, handler:fListener};
};
ET.Widget.prototype.removeEventHandler = function (sHandlerName) {
	if (!this.eventHandlers || !this.eventHandlers[sHandlerName]) {
		return;
	}
	var oHandler = this.eventHandlers[sHandlerName];
	var oEl = oHandler.element;
	var sEvent = oHandler.event;
	var fHandler = oHandler.handler;
	if (oEl && typeof sEvent == "string" && typeof fHandler == "function") {
		etUtils.removeEvent(oEl, sEvent, fHandler);
		oHandler.element = null;
		oHandler.handler = null;
		this.eventHandlers[sHandlerName] == null;
	}
};
ET.Widget.prototype.discardEventHandlers = function () {
	var oHandlers = this.eventHandlers;
	if (oHandlers) {
		var sHandler;
		for (sHandler in oHandlers) {
			this.removeEventHandler(sHandler);
		}
	}
};
ET.Widget.prototype.getClassName = function (oArg) {
	var aClassName = [];
	if (oArg && oArg.prefix) {
		aClassName.push(oArg.prefix);
	}
	var sTheme = this.config.theme;
	if (sTheme != "") {
		aClassName.push(sTheme.charAt(0).toUpperCase());
		aClassName.push(sTheme.substr(1));
	}
	if (oArg && oArg.suffix) {
		aClassName.push(oArg.suffix);
	}
	return aClassName.join("");
};
ET.Widget.prototype.formElementId = function (oArg) {
	var aId = [];
	if (oArg && oArg.prefix) {
		aId.push(oArg.prefix);
	} else {
		aId.push("zpWidget");
	}
	aId.push(this.id);
	if (oArg && oArg.suffix) {
		aId.push(oArg.suffix);
	} else {
		aId.push("-");
	}
	if (typeof this.widgetUniqueIdCounter == "undefined") {
		this.widgetUniqueIdCounter = 0;
	} else {
		this.widgetUniqueIdCounter++;
	}
	aId.push(this.widgetUniqueIdCounter);
	return aId.join("");
};
ET.Widget.prototype.showContainer = function (effects, animSpeed, onFinish) {
	return this.showHideContainer(effects, animSpeed, onFinish, true);
};
ET.Widget.prototype.hideContainer = function (effects, animSpeed, onFinish) {
	return this.showHideContainer(effects, animSpeed, onFinish, false);
};
ET.Widget.prototype.showHideContainer = function (effects, animSpeed, onFinish, show) {
	if (this.container == null) {
		return null;
	}
	if (effects && effects.length > 0 && typeof (ET.Effects) == "undefined") {
		var self = this;
		etTransport.loadJS({url:ET.etPath + "./effects.js", onLoad:function () {
			self.showHideContainer(effects, animSpeed, onFinish, show);
		}});
		return false;
	}
	if (animSpeed == null && isNaN(parseInt(animSpeed))) {
		animSpeed = 5;
	}
	if (!effects || effects.length == 0) {
		if (show) {
			this.container.style.display = "";
		} else {
			this.container.style.display = "none";
		}
		if (onFinish) {
			onFinish();
		}
	} else {
		if (show) {
			ET.Effects.show(this.container, animSpeed, effects, onFinish);
		} else {
			ET.Effects.hide(this.container, animSpeed, effects, onFinish);
		}
	}
	return true;
};
ET.Widget.prototype.loadData = function (oArg) {
	var oConfig = this.config;
	if (typeof oConfig.callbackSource == "function") {
		var oSource = oConfig.callbackSource.call(this, oArg);
		if (oSource) {
			if (typeof oSource.source != "undefined") {
				oConfig.source = oSource.source;
			}
			if (typeof oSource.sourceType != "undefined") {
				oConfig.sourceType = oSource.sourceType;
			}
			if (typeof oSource.method != "undefined") {
				oConfig.sourceFetchMethod = oSource.method;
			}
			if (typeof oSource.contentType != "undefined") {
				oConfig.sourceFetchContentType = oSource.contentType;
			}
			if (typeof oSource.content != "undefined") {
				oConfig.sourceFetchContent = oSource.content;
			}
		}
	}
	var vSource = oConfig.source;
	var sSourceType = oConfig.sourceType;
	var fConvert = oConfig.callbackConvertSource;
	if (typeof fConvert != "function") {
		fConvert = function (obj) {
			return obj;
		};
	}
	if (vSource && typeof sSourceType == "string") {
		sSourceType = sSourceType.toLowerCase();
		if (sSourceType == "html") {
			this.fireEvent("loadDataStart");
			vSource = fConvert(vSource);
			this.loadDataHtml(etWidget.getElementById(vSource));
			this.fireEvent("loadDataEnd");
		} else {
			if (sSourceType == "html/text") {
				this.fireEvent("loadDataStart");
				vSource = fConvert(vSource);
				this.loadDataHtmlText(vSource);
				this.fireEvent("loadDataEnd");
			} else {
				if (sSourceType == "html/url") {
					this.fireEvent("fetchSourceStart");
					var oWidget = this;
					this.dataRequest = etTransport.fetch({url:vSource, method:oConfig.sourceFetchMethod, async:oConfig.asyncSource, contentType:oConfig.sourceFetchContentType, content:oConfig.sourceFetchContent, onLoad:function (oRequest) {
						oWidget.dataRequest = null;
						oWidget.fireEvent("fetchSourceEnd");
						oWidget.fireEvent("loadDataStart");
						oWidget.loadDataHtmlText(fConvert(oRequest.responseText));
						oWidget.fireEvent("loadDataEnd");
						oWidget = null;
					}, onError:function (oError) {
						oWidget.dataRequest = null;
						oWidget.fireEvent("fetchSourceError", oError);
						oWidget.fireEvent("fetchSourceEnd");
						oWidget.fireEvent("loadDataEnd");
						oWidget = null;
					}});
				} else {
					if (sSourceType == "json") {
						this.fireEvent("loadDataStart");
						if (typeof vSource == "string") {
							if (oConfig.reliableSource) {
								vSource = eval(["(", vSource, ")"].join(""));
							} else {
								vSource = etTransport.parseJson({strJson:vSource});
							}
						}
						vSource = fConvert(vSource);
						this.loadDataJson(vSource);
						this.fireEvent("loadDataEnd");
					} else {
						if (sSourceType == "json/url") {
							this.fireEvent("fetchSourceStart");
							var oWidget = this;
							this.dataRequest = etTransport.fetchJsonObj({url:vSource, method:oConfig.sourceFetchMethod, async:oConfig.asyncSource, contentType:oConfig.sourceFetchContentType, content:oConfig.sourceFetchContent, reliable:oConfig.reliableSource, onLoad:function (oResult) {
								oWidget.dataRequest = null;
								oWidget.fireEvent("fetchSourceEnd");
								oWidget.fireEvent("loadDataStart");
								oResult = fConvert(oResult);
								oWidget.loadDataJson(oResult);
								oWidget.fireEvent("loadDataEnd");
								oWidget = null;
							}, onError:function (oError) {
								oWidget.dataRequest = null;
								oWidget.fireEvent("fetchSourceError", oError);
								oWidget.fireEvent("fetchSourceEnd");
								oWidget.fireEvent("loadDataEnd");
								oWidget = null;
							}});
						} else {
							if (sSourceType == "xml") {
								this.fireEvent("loadDataStart");
								if (typeof vSource != "object") {
									vSource = etTransport.parseXml({strXml:vSource});
								}
								vSource = fConvert(vSource);
								this.loadDataXml(vSource);
								this.fireEvent("loadDataEnd");
							} else {
								if (sSourceType == "xml/url") {
									this.fireEvent("fetchSourceStart");
									var oWidget = this;
									this.dataRequest = etTransport.fetchXmlDoc({url:vSource, method:oConfig.sourceFetchMethod, async:oConfig.asyncSource, contentType:oConfig.sourceFetchContentType, content:oConfig.sourceFetchContent, onLoad:function (oResult) {
										oWidget.dataRequest = null;
										oWidget.fireEvent("fetchSourceEnd");
										oWidget.fireEvent("loadDataStart");
										oResult = fConvert(oResult);
										oWidget.loadDataXml(oResult);
										oWidget.fireEvent("loadDataEnd");
										oWidget = null;
									}, onError:function (oError) {
										oWidget.dataRequest = null;
										oWidget.fireEvent("fetchSourceError", oError);
										oWidget.fireEvent("fetchSourceEnd");
										oWidget.fireEvent("loadDataEnd");
										oWidget = null;
									}});
								}
							}
						}
					}
				}
			}
		}
	} else {
		this.fireEvent("loadDataStart");
		vSource = fConvert(etWidget.getElementById(vSource));
		this.loadDataHtml(vSource);
		this.fireEvent("loadDataEnd");
	}
};
ET.Widget.prototype.loadDataHtml = function (oSource) {
};
ET.Widget.prototype.loadDataHtmlText = function (sSource) {
	var oTempContainer = etTransport.parseHtml(sSource);
	this.loadDataHtml(oTempContainer.firstChild);
};
ET.Widget.prototype.loadDataJson = function (oSource) {
};
ET.Widget.prototype.loadDataXml = function (oSource) {
};
ET.Widget.prototype.loadDataAbort = function () {
	var oRequest = this.dataRequest;
	if (oRequest) {
		this.dataRequest = null;
		oRequest.onreadystatechange = function () {
		};
		oRequest.abort();
	}
};
ET.Widget.prototype.receiveData = function (oArg) {
	if (!oArg) {
		oArg = {};
	}
	this.dataSender = oArg.widget;
	this.fireEvent("receiveData", oArg);
};
ET.Widget.prototype.replyData = function () {
	return null;
};
ET.Widget.prototype.replyDataCancel = function () {
	this.fireEvent("replyDataCancel");
	if (typeof this.hide == "function") {
		this.hide();
	}
	this.dataSender = null;
};
ET.Widget.prototype.replyDataReturn = function (oArg) {
	if (!oArg) {
		oArg = {};
	}
	this.fireEvent("replyDataReturn", oArg);
	var oWidget = oArg.widget;
	if (!oWidget) {
		oWidget = this.dataSender;
	}
	if (!oWidget || typeof oWidget.acceptData != "function") {
		return;
	}
	oWidget.acceptData({widget:this, data:this.replyData()});
	this.replyDataCancel();
};
ET.Widget.prototype.acceptData = function (oArg) {
	this.fireEvent("acceptData", oArg);
};
ET.Widget.prototype.initLang = function () {
	this.langStr = this.config.lang;
	if (this.config.langCountryCode && this.config.langCountryCode.length > 0) {
		this.langStr += "_" + this.config.langCountryCode;
	}
	if (this.config.langEncoding && this.config.langEncoding.length > 0) {
		this.langStr += "-" + this.config.langEncoding;
	}
	if (this.config.lang && this.config.lang.length > 0 && !(ET.Langs[this.config.langId] && ET.Langs[this.config.langId][this.langStr])) {
		this.debug("No language data found for language " + this.config.lang + (this.config.langCountryCode ? " and country code " + this.config.langCountryCode : "") + (this.config.langEncoding ? " and encoding " + this.config.langEncoding : ""));
		this.config.lang = null;
		this.config.langCountryCode = null;
		this.config.langEncoding = null;
		this.langStr = null;
	}
};
ET.Widget.prototype.getMessage = function (key) {
	if (arguments.length == 0) {
		return null;
	}
	if (!ET.Langs[this.config.langId] || !ET.Langs[this.config.langId][this.langStr] || !ET.Langs[this.config.langId][this.langStr][key]) {
		return key;
	}
	var res = ET.Langs[this.config.langId][this.langStr][key];
	if (arguments.length > 1 && typeof (res) == "string") {
		for (var ii = 1; ii < arguments.length; ii++) {
			var re = new RegExp("(^|([^\\\\]))%" + ii);
			res = res.replace(re, "$2" + arguments[ii]);
		}
	}
	return res;
};
ET.Widget.callMethod = function (iWidgetId, sMethod) {
	var oWidget = etWidgetGetWidgetById(iWidgetId);
	if (oWidget && typeof oWidget[sMethod] == "function") {
		var aArgs = [].slice.call(arguments, 2);
		return oWidget[sMethod].apply(oWidget, aArgs);
	}
};
etWidgetCallMethod = etWidget.callMethod;
ET.Widget.getElementById = function (element) {
	if (typeof element == "string") {
		return document.getElementById(element);
	}
	return element;
};
etWidgetGetElementById = etWidget.getElementById;
ET.Widget.getStyle = function (element) {
	var style = element.getAttribute("style") || "";
	if (typeof style == "string") {
		return style;
	}
	return style.cssText;
};
ET.Widget.windowDimensions = null;
ET.Widget.onWindowResize = function () {
	var oWindowDimensions = etWidget.windowDimensions;
	if (!oWindowDimensions) {
		return;
	}
	var oNewDimensions = etUtils.getWindowDimensions();
	if (oWindowDimensions.width == oNewDimensions.width && oWindowDimensions.height == oNewDimensions.height) {
		return;
	}
	etWidget.windowDimensions = oNewDimensions;
	etEventDriven.fireEvent("windowResized");
};
etWidget.windowDimensions = etUtils.getWindowDimensions();
etUtils.addEvent(window, "resize", etWidget.onWindowResize, false, true);
ET.Widget.debug = function (sMsg, sType) {
	if (typeof etDebug == "function") {
		etDebug.log[sType || "error"](sMsg);
	}
};
ET.Widget.prototype.debug = function (sMsg, sType) {
	etWidget.debug(this.constructor.id + "[" + this.id + "]: " + sMsg, sType);
};
ET.Button = function (objArgs) {
	if (arguments.length == 0) {
		objArgs = {};
	}
	ET.Button.SUPERconstructor.call(this, objArgs);
};
ET.Button.id = "ET.Button";
ET.inherit(ET.Button, ET.Widget);
ET.Button.prototype.init = function (objArgs) {
	this.config.image = null;
	this.config.width = null;
	this.config.height = null;
	this.config.className = null;
	this.config.style = null;
	this.config.text = "";
	this.config.preloadImages = true;
	this.config.overStyle = null;
	this.config.overClass = null;
	this.config.overImage = null;
	this.config.overAction = null;
	this.config.outAction = null;
	this.config.downStyle = null;
	this.config.downClass = null;
	this.config.downImage = null;
	this.config.downAction = null;
	this.config.downActionDelay = 500;
	this.config.repeatEnabled = true;
	this.config.repeatAcceleration = 0.8;
	this.config.repeatStartSpeed = 55;
	this.config.repeatMaxSpeed = 5;
	this.config.clickAction = null;
	this.config.idPrefix = null;
	this.config.themePath = ET.etPath + "./themes/button/";
	ET.Button.SUPERclass.init.call(this, objArgs);
	if (!this.config.idPrefix) {
		this.config.idPrefix = "zpButton" + this.id;
	}
	this.container = null;
	this.statusContainer = null;
	this.internalContainer = null;
	this.img = null;
	this.enabled = true;
	this.isPressed = false;
	this.createButton();
};
ET.Button.prototype.createButton = function () {
	this.container = ET.Utils.createElement("span");
	this.addCircularRef(this, "container");
	this.container.id = this.config.idPrefix + "Container";
	this.statusContainer = ET.Utils.createElement("span");
	this.addCircularRef(this, "statusContainer");
	this.statusContainer.className = "mouseOut";
	this.statusContainer.id = this.config.idPrefix + "Status";
	this.container.appendChild(this.statusContainer);
	this.internalContainer = ET.Utils.createElement("span");
	this.addCircularRef(this, "container");
	this.internalContainer.className = "internalContainer";
	this.internalContainer.id = this.config.idPrefix + "Internal";
	this.statusContainer.appendChild(this.internalContainer);
	ET.Utils.addClass(this.container, this.getClassName({prefix:"zpButton" + (this.config.image != null ? "Image" : ""), suffix:"Container"}));
	if (this.config.width != null) {
		this.internalContainer.style.width = this.config.width + "px";
	}
	if (this.config.height != null) {
		this.internalContainer.style.width = this.config.height + "px";
	}
	if (this.config.className != null) {
		ET.Utils.addClass(this.internalContainer, this.config.className);
	}
	if (this.config.style != null) {
		this.applyStyle(this.config.style);
	}
	var self = this;
	this.container.onmouseover = function (ev) {
		return self.onmouseover(ev, false);
	};
	this.addCircularRef(this.container, "onmouseover");
	this.container.onmouseout = function (ev) {
		return self.onmouseout(ev);
	};
	this.addCircularRef(this.container, "onmouseout");
	this.container.onmousedown = function (ev) {
		return self.onmousedown(ev);
	};
	this.addCircularRef(this.container, "onmousedown");
	this.container.onmouseup = function (ev) {
		return self.onmouseover(ev, true);
	};
	this.addCircularRef(this.container, "onmouseup");
	this.setEventHandlers();
	var func = function (ev) {
		self._mousedown = false;
	};
	ET.Utils.addEvent(document, "mouseup", func, null, false);
	this.eventHandlers.documentMouseup = {element:document, event:"mouseup", handler:func};
	this.container.onclick = function (ev) {
		return self.onclick(ev);
	};
	this.addCircularRef(this.container, "onclick");
	if (this.config.image != null) {
		this.img = document.createElement("img");
		this.addCircularRef(this, "img");
		this.img.src = this.config.image;
		this.img.alt = this.config.text;
		this.img.title = this.config.text;
		this.internalContainer.appendChild(this.img);
	} else {
		this.internalContainer.innerHTML = this.config.text;
		this.internalContainer.style.whiteSpace = "nowrap";
	}
	if (this.config.preloadImages == true) {
		this.preloadImages();
	}
};
ET.Button.prototype.onmouseover = function (ev, mouseup) {
	if (!this.isEnabled()) {
		return false;
	}
	if (typeof (ev) == "undefined") {
		ev = window.event;
	}
	if (mouseup) {
		this._mousedown = false;
	}
	this.toggleClass("mouseOver");
	if (this.config.image != null && this.config.overImage != null) {
		this.img.src = this.config.overImage;
	}
	if (this.config.overClass != null) {
		ET.Utils.addClass(this.internalContainer, this.config.overClass);
	}
	if (this.config.overStyle != null) {
		this.applyStyle(this.config.overStyle);
	}
	if (this._timeoutId) {
		clearTimeout(this._timeoutId);
	}
	if (this._mousedown && this.config.repeatEnabled) {
		this._repeatDownAction();
	}
	if (this.config.overAction != null) {
		return this.config.overAction(ev, this);
	}
	return true;
};
ET.Button.prototype.onmouseout = function (ev) {
	if (!this.isEnabled()) {
		return false;
	}
	if (typeof (ev) == "undefined") {
		ev = window.event;
	}
	if (!this.isPressed) {
		this.toggleClass("mouseOut");
		if (this.config.image != null) {
			this.img.src = this.config.image;
		}
		if (this.config.outClass != null) {
			ET.Utils.addClass(this.internalContainer, this.config.outClass);
		}
	} else {
		this.toggleClass("mouseDown");
		if (this.config.image != null && this.config.downImage != null) {
			this.img.src = this.config.downImage;
		}
		if (this.config.downClass != null) {
			ET.Utils.addClass(this.internalContainer, this.config.downClass);
		}
	}
	if (this.config.style != null) {
		this.applyStyle(this.config.style);
	}
	if (this._mousedown) {
		this._pauseRepeat();
	}
	if (this.config.outAction != null) {
		return this.config.outAction(ev, this);
	}
	return true;
};
ET.Button.prototype.onmousedown = function (ev) {
	if (!this.isEnabled()) {
		return false;
	}
	var self = this;
	if (typeof (ev) == "undefined") {
		ev = window.event;
	}
	this._mousedown = true;
	this.toggleClass("mouseDown");
	if (this.config.image != null && this.config.downImage != null) {
		this.img.src = this.config.downImage;
	}
	if (this.config.downClass != null) {
		ET.Utils.addClass(this.internalContainer, this.config.downClass);
	}
	if (this.config.downStyle != null) {
		this.applyStyle(this.config.downStyle);
	}
	if (this.config.downAction != null) {
		this._timeoutId = setTimeout(function () {
			self._repeatSpeed = self.config.repeatStartSpeed;
			self._repeatDownAction(ev);
		}, this.config.downActionDelay);
		return this.config.downAction(ev, this);
	}
	return true;
};
ET.Button.prototype.onclick = function (ev) {
	if (!this.isEnabled()) {
		return false;
	}
	if (typeof (ev) == "undefined") {
		ev = window.event;
	}
	if (this._timeoutId) {
		clearTimeout(this._timeoutId);
	}
	this._timeoutId = null;
	this._mousedown = false;
	if (this.config.clickAction != null) {
		return this.config.clickAction(ev, this);
	}
	return true;
};
ET.Button.prototype._repeatDownAction = function (ev) {
	if (this.config.downAction != null) {
		this.config.downAction(ev, this);
	}
	if (this.config.repeatEnabled) {
		if (this._repeatSpeed > this.config.repeatMaxSpeed) {
			this._repeatSpeed = Math.round(this.config.repeatAcceleration * this._repeatSpeed);
		}
		var self = this;
		this._timeoutId = setTimeout(function () {
			self._repeatDownAction();
		}, this._repeatSpeed);
	}
};
ET.Button.prototype._pauseRepeat = function () {
	if (this._timeoutId) {
		clearTimeout(this._timeoutId);
		this._timeoutId = null;
	}
};
ET.Button.prototype.preloadImages = function () {
	if (this.config.image != null) {
		var images = [this.config.image];
		if (this.config.overImage != null) {
			images.push(this.config.overImage);
		}
		if (this.config.downImage != null) {
			images.push(this.config.downImage);
		}
		ET.Transport.preloadImages({urls:images});
	}
};
ET.Button.prototype.setPressed = function (isPressed) {
	this.isPressed = isPressed;
	if (isPressed) {
		this.toggleClass("mouseDown");
	} else {
		this.toggleClass("mouseOut");
	}
};
ET.Button.prototype.toggleClass = function (className) {
	ET.Utils.removeClass(this.statusContainer, "mouseOver");
	ET.Utils.removeClass(this.statusContainer, "mouseOut");
	ET.Utils.removeClass(this.statusContainer, "mouseDown");
	ET.Utils.removeClass(this.statusContainer, "disabled");
	ET.Utils.removeClass(this.internalContainer, this.config.overClass);
	ET.Utils.removeClass(this.internalContainer, this.config.downClass);
	if (className != null) {
		ET.Utils.addClass(this.statusContainer, className);
	}
};
ET.Button.prototype.getContainer = function () {
	return this.container;
};
ET.Button.prototype.applyStyle = function (style) {
	ET.Utils.applyStyle(this.internalContainer, style);
};
ET.Button.prototype.isEnabled = function () {
	return this.enabled;
};
ET.Button.prototype.enable = function () {
	this.enabled = true;
	this.toggleClass("mouseOut");
};
ET.Button.prototype.disable = function () {
	this.enabled = false;
	this.toggleClass("disabled");
};
ET.Button.prototype.setText = function (text) {
	this.internalContainer.innerHTML = text;
};
ET.Button.prototype.getText = function () {
	return this.internalContainer.innerHTML;
};
ET.Button.setup = function (elRef, config) {
	elRef = ET.Widget.getElementById(elRef);
	if (elRef == null) {
		return null;
	}
	elRef.zpHasButton = true;
	if (config == null) {
		config = {};
	}
	var nodeName = elRef.nodeName.toLowerCase();
	var oldOverAction = config.overAction != null ? config.overAction : function () {
		return true;
	};
	config.overAction = function (ev) {
		return ((elRef.onmouseover != null ? elRef.onmouseover.call(ev) : true) && oldOverAction(ev));
	};
	var oldOutAction = config.outAction != null ? config.outAction : function () {
		return true;
	};
	config.outAction = function (ev) {
		return ((elRef.onmouseout != null ? elRef.onmouseout.call(ev) : true) && oldOutAction(ev));
	};
	var oldDownAction = config.downAction != null ? config.downAction : function () {
		return true;
	};
	config.downAction = function (ev) {
		return ((elRef.onmousedown != null ? elRef.onmousedown.call(ev) : true) && oldDownAction(ev));
	};
	var oldClickAction = config.clickAction != null ? config.clickAction : function () {
		return true;
	};
	config.clickAction = function (ev) {
		return ((elRef.onclick != null ? elRef.onclick.call(ev) : true) && oldClickAction(ev));
	};
	var submitAction = function (ev) {
		if (elRef.form != null && elRef.zpHidden == null) {
			var hidden = document.createElement("input");
			hidden.type = "hidden";
			hidden.name = elRef.name;
			hidden.value = elRef.value;
			hidden.style.display = "none";
			ET.Utils.insertAfter(elRef, hidden);
			elRef.zpHidden = hidden;
		}
		if (elRef.form && elRef.form.onSubmit != null) {
			elRef.form.onSubmit();
		}
		return ((elRef.onclick != null ? elRef.onclick.call(ev) : true) && oldClickAction(ev) && (elRef.form != null ? elRef.form.submit() : true));
	};
	if (nodeName == "button") {
		config.text = elRef.value;
	} else {
		if (nodeName == "img") {
			config.image = elRef.src;
			config.text = elRef.title || elRef.title;
		} else {
			if (nodeName == "div" || nodeName == "span") {
				config.text = elRef.innerHTML;
			} else {
				if (nodeName == "input") {
					config.text = elRef.value;
					if (elRef.type.toLowerCase() == "image") {
						config.image = elRef.src;
						config.clickAction = submitAction;
					} else {
						if (elRef.type.toLowerCase() == "button") {
						} else {
							if (elRef.type.toLowerCase() == "submit") {
								config.clickAction = submitAction;
							} else {
								if (elRef.type.toLowerCase() == "reset") {
									config.clickAction = function (ev) {
										(elRef.onclick != null ? elRef.onclick.call(ev) : true) && oldClickAction(ev) && (elRef.form != null ? elRef.form.reset() : true);
									};
								} else {
									return null;
								}
							}
						}
					}
				} else {
					return null;
				}
			}
		}
	}
	var button = new ET.Button(config);
	ET.Utils.insertAfter(elRef, button.getContainer());
	elRef.disabled = true;
	elRef.style.display = "none";
	return button;
};
ET.Button.setupAll = function (elRef, config) {
	if (typeof (elRef) == "string") {
		elRef = document.getElementById(elRef);
	}
	if (elRef == null) {
		return null;
	}
	var childs = elRef.all ? elRef.all : elRef.getElementsByTagName("*");
	function cloneConfig() {
		var cfg = {};
		for (var option in config) {
			cfg[option] = config[option];
		}
		return cfg;
	}
	for (var ii = 0; ii < childs.length; ii++) {
		var child = childs[ii];
		if (child.nodeType == 1 && (child.nodeName.toLowerCase() == "button" || child.nodeName.toLowerCase() == "input" && (child.type.toLowerCase() == "image" || child.type.toLowerCase() == "button" || child.type.toLowerCase() == "submit" || child.type.toLowerCase() == "reset")) && !child.zpHasButton) {
			ET.Button.setup(child, cloneConfig());
		}
	}
};
ET.Button.prototype.destroy = function () {
	if (!this.container) {
		return;
	}
	this.container.onmouseover = null;
	this.container.onmouseout = null;
	this.container.onmousedown = null;
	this.container.onmouseup = null;
	this.container.onclick = null;
	this.internalContainer = null;
	this.statusContainer = null;
	this.container = null;
	return null;
};
ET.Array = function (arr) {
	if (!ET.isArray(arr)) {
		var array = [];
		for (var i = 0; i < arguments.length; ++i) {
			array.push(arguments[i]);
		}
		arr = array;
	}
	arr.clear = function () {
		ET.Array.clear(this);
	};
	arr.compact = function () {
		var compact = ET.Array.compact(this);
		return ET.Array(compact);
	};
	arr.indexOf = function (value) {
		return ET.Array.indexOf(this, value);
	};
	arr.without = function () {
		var args = [].slice.call(arguments, 0);
		args.unshift(this);
		var without = ET.Array.without.apply(ET.Array, args);
		return ET.Array(without);
	};
	arr.remove = function () {
		var args = [].slice.call(arguments, 0);
		args.unshift(this);
		var cut = ET.Array.remove.apply(ET.Array, args);
		return ET.Array(cut);
	};
	arr.each = function (func, reverse) {
		var result;
		for (var index = reverse ? this.length - 1 : 0; reverse ? (index >= 0) : (index < this.length); reverse ? --index : ++index) {
			if (typeof func == "function") {
				result = func(index, this[index], this);
				if (result == "break") {
					break;
				}
			}
		}
		if (result == "break") {
			return false;
		}
		return true;
	};
	arr.isZpArray = true;
	return arr;
};
ET.Array.compact = function (arr) {
	var newArr = [];
	for (var item = 0; item < arr.length; ++item) {
		if (arr[item] !== null && typeof arr[item] != "undefined") {
			newArr.push(arr[item]);
		}
	}
	return newArr;
};
ET.Array.clear = function (arr) {
	arr.length = 0;
};
ET.Array.indexOf = function (arr, value) {
	for (var item = 0; item < arr.length; ++item) {
		if (arr[item] === value) {
			return item;
		}
	}
	return -1;
};
ET.Array.without = function (arr) {
	var newArr = [], without;
	for (var item = 0; item < arr.length; ++item) {
		without = false;
		for (var value = 1; value < arguments.length; ++value) {
			if (arr[item] === arguments[value]) {
				without = true;
				break;
			}
		}
		if (!without) {
			newArr.push(arr[item]);
		}
	}
	return newArr;
};
ET.Array.remove = function (arr) {
	var newArr = [], without, value, start = 1;
	if (arguments[1] && arguments[1].length && typeof arguments[1] == "object") {
		args = arguments[1];
		start = 0;
	} else {
		args = arguments;
	}
	for (var item = 0; item < arr.length; ++item) {
		without = false;
		for (value = start; value < args.length; ++value) {
			if (item === args[value]) {
				without = true;
				break;
			}
		}
		if (!without) {
			newArr.push(arr[item]);
		}
	}
	return newArr;
};
ET.Hash = function (hash) {
	if (!hash || typeof hash != "object") {
		hash = {};
	}
	hash.hashRemove = function () {
		var args = [].slice.call(arguments, 0);
		args.unshift(this);
		var without = ET.Hash.remove.apply(ET.Hash, args);
		return ET.Hash(without);
	};
	hash.hashEach = function (func) {
		var result = null;
		for (var prop in this) {
			if (prop == "hashRemove" || prop == "hashEach" || prop == "hashIsEmpty" || prop == "isZpHash") {
				continue;
			}
			if (typeof Object.prototype[prop] != "undefined") {
				continue;
			}
			result = func(prop, this[prop], this);
			if (result == "break") {
				break;
			}
		}
		if (result == "break") {
			return false;
		}
		return true;
	};
	hash.hashIsEmpty = function () {
		var empty = true;
		this.hashEach(function () {
			empty = false;
			return "break";
		});
		return empty;
	};
	hash.isZpHash = true;
	return hash;
};
ET.Hash.remove = function (hash) {
	var newHash = {}, without, value, start = 1;
	if (arguments[1] && arguments[1].length && typeof arguments[1] == "object") {
		args = arguments[1];
		start = 0;
	} else {
		args = arguments;
	}
	for (var item in hash) {
		without = false;
		for (value = start; value < args.length; ++value) {
			if (item === args[value]) {
				without = true;
				break;
			}
		}
		if (!without) {
			newHash[item] = hash[item];
		}
	}
	return newHash;
};
ET.Hash.getByPath = function (hash, path) {
	if (!path || typeof path != "string") {
		ET.Log({description:"Not a path passed to ET.Hash.getByPath function!", type:"warning"});
		return {result:false};
	}
	var paths = path.split(".");
	if (!paths.length) {
		ET.Log({description:"Wrong path passed to ET.Hash.getByPath function!", type:"warning"});
		return {result:false};
	}
	var item = 0;
	var value = hash;
	var name = "";
	var scope = null;
	while (paths[item]) {
		if (value === null || typeof value == "undefined") {
			ET.Log({description:"Incorrect path passed to ET.Hash.getByPath function!", type:"warning"});
			return {result:false};
		}
		name = paths[item].replace(/(\(\)|\[[^\[\]]+\])+/, "");
		try {
			scope = value;
			value = value[name];
		}
		catch (e) {
			ET.Log({description:"Incorrect path passed to ET.Hash.getByPath function!", type:"warning"});
			return {result:false};
		}
		paths[item] = paths[item].replace(name, "");
		while (paths[item] != "") {
			name = paths[item].match(/(\(\)|\[[^\[\]]+\])/)[1];
			if (name && /\(\)$/.test(name)) {
				try {
					value = value.call(scope || value);
					scope = null;
				}
				catch (e) {
					ET.Log({description:"Incorrect path passed to ET.Hash.getByPath function!", type:"warning"});
					return {result:false};
				}
			} else {
				if (name && /\[["']?[^\[\]"']+["']?\]$/.test(name)) {
					try {
						value = value[name.match(/\[["']?([^\[\]"']+)["']?\]/)[1]];
						scope = null;
					}
					catch (e) {
						ET.Log({description:"Incorrect path passed to ET.Hash.getByPath function!", type:"warning"});
						return {result:false};
					}
				}
			}
			paths[item] = paths[item].replace(name, "");
		}
		++item;
	}
	if (typeof value == "undefined") {
		ET.Log({description:"Incorrect path passed to ET.Hash.getByPath function!", type:"warning"});
		return {result:false};
	}
	return {result:true, value:value};
};
ET.Hash.setByPath = function (hash, path, val) {
	if (!path || typeof path != "string") {
		ET.Log({description:"Not a path passed to ET.Hash.setByPath function!", type:"warning"});
		return false;
	}
	var paths = path.split(".");
	if (!paths.length) {
		ET.Log({description:"Wrong path passed to ET.Hash.setByPath function!", type:"warning"});
		return false;
	}
	var lastItem = paths[paths.length - 1];
	var obj = hash;
	var getPath = paths.slice(0, -1).join(".");
	var arrIndexReg = /\[[^\[\]]+\]$/;
	if (arrIndexReg.test(lastItem)) {
		getPath += (getPath == "" ? "" : ".") + lastItem.replace(arrIndexReg, "");
		lastItem = lastItem.match(/\[["']?([^\[\]"']+)["']?\]$/)[1];
	}
	if (getPath != "") {
		var obj = ET.Hash.getByPath(hash, getPath).value;
	}
	try {
		obj[lastItem] = val;
	}
	catch (e) {
		ET.Log({description:"Incorrect path passed to ET.Hash.setByPath function!", type:"warning"});
		return false;
	}
	return true;
};
ET.isHtmlElement = function (el) {
	if (!el || el.nodeType != 1) {
		return false;
	}
	return true;
};
ET.isSizableObj = function (obj) {
	if (obj && obj.hasInterface && obj.hasInterface("ET.Sizable")) {
		return true;
	}
	return false;
};
ET.isMovableObj = function (obj) {
	if (obj && obj.hasInterface && obj.hasInterface("ET.Movable")) {
		return true;
	}
	return false;
};
ET.isArray = function (arr) {
	if (arr && typeof arr == "object" && arr.constructor == Array) {
		return true;
	}
	return false;
};
ET.isDate = function (date) {
	if (date && typeof date == "object" && date.constructor == Date) {
		return true;
	}
	return false;
};
ET.SRProp = function (obj) {
	this.obj = obj;
	this.savedProps = new ET.Hash();
	ET.Utils.createProperty(obj, "restorer", this);
};
ET.SRProp.prototype.getSavedProps = function () {
	return this.savedProps;
};
ET.SRProp.prototype.getObject = function () {
	return this.obj;
};
ET.SRProp.prototype.saveProp = function (propName) {
	if (typeof propName != "string") {
		return false;
	}
	var value = ET.Hash.getByPath(this.getObject(), propName);
	if (value.result) {
		if (typeof this.getProp(propName) != "undefined") {
			var prop = this.getSavedProps()[propName] = ET.Array(this.getSavedProps()[propName]);
			prop.push(value.value);
			prop.combination = true;
			ET.Log({description:"The property '" + propName + "' now contains more than one value!", type:"warning"});
		} else {
			this.getSavedProps()[propName] = value.value;
		}
		return true;
	} else {
		return false;
	}
};
ET.SRProp.prototype.saveProps = function () {
	var result = [];
	for (var i = 0; i < arguments.length; ++i) {
		if (this.saveProp(arguments[i])) {
			result.push(arguments[i]);
		}
	}
	return result;
};
ET.SRProp.prototype.restoreProp = function (propName) {
	if (typeof propName != "string" || typeof this.getSavedProps()[propName] == "undefined") {
		return false;
	}
	var prop = this.getSavedProps()[propName];
	var combination = false, nextSibling = null;
	if (ET.isArray(prop) && prop.combination) {
		prop = prop[prop.length - 1];
		combination = true;
	}
	if (propName.match(/parentNode$/) !== null && prop && typeof prop == "object" && prop.appendChild) {
		nextSibling = this.getSavedProps()[propName.replace(/parentNode/, "nextSibling")] || null;
		if (nextSibling && nextSibling.parentNode == prop) {
			prop.insertBefore(this.getObject(), nextSibling);
		} else {
			prop.appendChild(this.getObject());
		}
		this.savedProps = this.getSavedProps().hashRemove(propName.replace(/parentNode/, "nextSibling"));
	} else {
		if (!ET.Hash.setByPath(this.getObject(), propName, prop)) {
			return false;
		}
	}
	if (!combination) {
		this.savedProps = this.getSavedProps().hashRemove(propName);
	} else {
		prop = this.getSavedProps()[propName];
		this.getSavedProps()[propName] = ET.Array.without(prop, prop.length - 1);
	}
	return true;
};
ET.SRProp.prototype.restoreProps = function (propName) {
	var result = [];
	for (var i = 0; i < arguments.length; ++i) {
		if (this.restoreProp(arguments[i])) {
			result.push(arguments[i]);
		}
	}
	return result;
};
ET.SRProp.prototype.restoreAll = function () {
	var self = this;
	this.getSavedProps().hashEach(function (i) {
		self.restoreProp(i);
	});
};
ET.SRProp.prototype.getProp = function (propName) {
	return this.getSavedProps()[propName];
};
ET.SRProp.prototype.isEmpty = function () {
	return this.getSavedProps().hashIsEmpty();
};
ET.SRProp.prototype.destroy = function () {
	this.getObject().restorer = null;
	for (var iProp in this) {
		this[iProp] = null;
	}
	return null;
};
ET.CommandEvent = {};
ET.CommandEvent.fireEvent = function (strEvent) {
	if (!this.events[strEvent]) {
		return;
	}
	var arrListeners = this.events[strEvent].listeners.slice();
	this._setReturnedValue(null);
	this._setEventPropagation(true);
	for (var iListener = 0; iListener < arrListeners.length; iListener++) {
		var arrArgs = [].slice.call(arguments, 1);
		arrListeners[iListener].apply(this, arrArgs);
		var result = this._getReturnedValue();
		if (!this._getEventPropagation()) {
			return result;
		}
		if (result == "re-execute") {
			this.fireEvent(strEvent);
			break;
		} else {
			if (result == "parent-re-execute") {
				return result;
			}
		}
	}
	return this._getReturnedValue();
};
ET.CommandEvent.returnValue = function (val) {
	this._setReturnedValue(val);
};
ET.CommandEvent._setReturnedValue = function (val) {
	this.returnedValue = val;
};
ET.CommandEvent._getReturnedValue = function () {
	return this.returnedValue;
};
ET.CommandEvent.stopPropagation = function () {
	this._setEventPropagation(false);
};
ET.CommandEvent._setEventPropagation = function (on) {
	this.eventPropagation = on;
};
ET.CommandEvent._getEventPropagation = function () {
	return this.eventPropagation;
};
ET.GlobalEvents = new ET.EventDriven();
ET.implement(ET.GlobalEvents, "ET.CommandEvent");
ET.GlobalEvents.init();
ET.Utils.getWidth = function (el) {
	if (!ET.isHtmlElement(el)) {
		return false;
	}
	return el.offsetWidth;
};
ET.Utils.getHeight = function (el) {
	if (!ET.isHtmlElement(el)) {
		return false;
	}
	return el.offsetHeight;
};
ET.Utils.setWidth = function (el, width) {
	width = Math.round(width);
	if (!ET.isHtmlElement(el) || width <= 0) {
		return false;
	}
	var oldWidth = el.style.width, newWidth;
	el.style.width = width + "px";
	if (ET.Utils.getWidth(el) != width) {
		newWidth = width - (ET.Utils.getWidth(el) - width);
		if (newWidth > 0) {
			el.style.width = newWidth + "px";
			if (ET.Utils.getWidth(el) != width) {
				el.style.width = oldWidth;
				ET.Log({description:"Can't set the width - " + width + "px!", type:"warning"});
				return false;
			}
		} else {
			el.style.width = oldWidth;
			ET.Log({description:"Can't set the width - " + width + "px!", type:"warning"});
			return false;
		}
	}
	return true;
};
ET.Utils.setHeight = function (el, height) {
	height = Math.round(height);
	if (!ET.isHtmlElement(el) || height <= 0) {
		return false;
	}
	var oldHeight = el.style.height, newHeight;
	el.style.height = height + "px";
	if (ET.Utils.getHeight(el) != height) {
		newHeight = height - (ET.Utils.getHeight(el) - height);
		if (newHeight > 0) {
			el.style.height = newHeight + "px";
			if (ET.Utils.getHeight(el) != height) {
				el.style.height = oldHeight;
				ET.Log({description:"Can't set the height - " + height + "px!", type:"warning"});
				return false;
			}
		} else {
			el.style.height = oldHeight;
			ET.Log({description:"Can't set the height - " + height + "px!", type:"warning"});
			return false;
		}
	}
	return true;
};
ET.Utils.fixateWidth = function (el) {
	return ET.Utils.setWidth(el, ET.Utils.getWidth(el));
};
ET.Utils.fixateHeight = function (el) {
	return ET.Utils.setHeight(el, ET.Utils.getHeight(el));
};
ET.Utils.makeSafelySizable = function (el, restorer) {
	if (el.sizable) {
		return true;
	}
	if (!ET.isHtmlElement(el)) {
		return false;
	}
	if (!restorer) {
		restorer = el.restorer;
	}
	if (!restorer || !restorer.getObject || restorer.getObject() != el) {
		restorer = new ET.SRProp(el);
	}
	restorer.saveProps("style.width", "style.height", "style.overflow");
	ET.Utils.fixateWidth(el);
	ET.Utils.fixateHeight(el);
	var overflow = ET.Utils.getStyleProperty(el, "overflow");
	if (overflow == "" || overflow == "visible") {
		ET.Log({description:"There is the chance that this element with overflow visible will not be sized correctly!", type:"warning"});
	}
	el.sizable = true;
	return true;
};
ET.Utils.restoreOfSizing = function (el) {
	if (!el || !el.restorer || !el.sizable) {
		return false;
	}
	el.restorer.restoreProps("style.width", "style.height", "style.overflow");
	if (el.restorer.isEmpty()) {
		el.restorer.destroy();
	}
	el.sizable = false;
	return true;
};
ET.Utils.makeSafelyMovable = function (el, within, restorer) {
	if (!ET.isHtmlElement(el)) {
		return false;
	}
	if (!within) {
		within = document.body;
	}
	if (el.within == within) {
		return true;
	}
	if (!restorer) {
		restorer = el.restorer;
	}
	if (!restorer || !restorer.getObject || restorer.getObject() != el) {
		restorer = new ET.SRProp(el);
	}
	el.within = within;
	if (within != document.body && within.style.position != "absolute") {
		restorer.saveProp("within.style.position");
		within.style.position = "relative";
	}
	if (within != document.body) {
		var pos1 = ET.Utils.getElementOffset(within);
	} else {
		var pos1 = {x:0, y:0};
	}
	var pos2 = ET.Utils.getElementOffset(el);
	var x = pos2.x - pos1.x;
	var y = pos2.y - pos1.y;
	restorer.saveProps("style.left", "style.top");
	el.style.left = x + "px";
	el.style.top = y + "px";
	if (el.style.position != "absolute") {
		restorer.saveProp("style.position");
		el.style.position = "absolute";
	}
	if (el.parentNode != within) {
		restorer.saveProps("parentNode", "nextSibling");
		within.appendChild(el);
	}
	restorer.saveProp("style.margin");
	el.style.margin = "0px";
	return true;
};
ET.Utils.moveTo = function (el, x, y) {
	if (!ET.isHtmlElement(el)) {
		return false;
	}
	var pos = null;
	if (ET.FixateOnScreen.isRegistered(el)) {
		pos = ET.FixateOnScreen.correctCoordinates(x, y);
		if (ET.is_ie && !ET.is_ie7) {
			el.style.setExpression("left", pos.x);
			el.style.setExpression("top", pos.y);
			return true;
		}
	} else {
		pos = {x:parseInt(x, 10) + "px", y:parseInt(y, 10) + "px"};
	}
	if (x || x === 0) {
		el.style.left = pos.x;
	}
	if (y || y === 0) {
		el.style.top = pos.y;
	}
	return true;
};
ET.Utils.getPos = function (el) {
	if (!ET.isHtmlElement(el)) {
		return false;
	}
	var pos = null;
	if (pos = ET.FixateOnScreen.parseCoordinates(el)) {
		return pos;
	}
	return {x:el.offsetLeft, y:el.offsetTop};
};
ET.Utils.moveFor = function (el, offsetX, offsetY) {
	var oldPos = ET.Utils.getPos(el);
	if (oldPos) {
		return ET.Utils.moveTo(el, oldPos.x + offsetX, oldPos.y + offsetY);
	} else {
		return false;
	}
};
ET.Utils.restoreOfMove = function (el) {
	if (!el.within) {
		return false;
	}
	if (!el || !el.restorer) {
		return false;
	}
	el.restorer.restoreProps("style.position", "parentNode", "style.margin", "nextSibling", "within.style.position", "style.left", "style.top");
	if (el.restorer.isEmpty()) {
		el.restorer.destroy();
	}
	el.within = null;
	return true;
};
ET.Utils.getElementsByAttribute = function (attribute, value, within, recursive, match) {
	if (!attribute) {
		return false;
	}
	within = ET.Widget.getElementById(within);
	within || (within = document.body);
	var element = within.firstChild;
	result = [];
	while (element) {
		if (element[attribute]) {
			if (typeof value == "undefined" || element[attribute] == value) {
				result.push(element);
			} else {
				if (match && typeof element[attribute] == "string" && element[attribute].indexOf(value) != -1) {
					result.push(element);
				}
			}
		}
		if (recursive && element.hasChildNodes()) {
			result = result.concat(ET.Utils.getElementsByAttribute(attribute, value, element, recursive, match));
		}
		element = element.nextSibling;
	}
	return ET.Array(result);
};
ET.Utils.applyToElements = function (constructor, elements, config, configOption) {
	if (typeof constructor != "function" || !ET.isArray(elements)) {
		return false;
	}
	elements = ET.Array(elements);
	if (!configOption) {
		configOption = "container";
	}
	if (!config || typeof config != "object") {
		config = {};
	}
	var result = ET.Array();
	elements.each(function (index, element) {
		config[configOption] = element;
		result.push(new constructor(config));
	});
	return result;
};
ET.Utils.img2div = function (el) {
	if (!ET.isHtmlElement(el)) {
		return null;
	}
	if ((/img/i).test(el.nodeName)) {
		var div = document.createElement("div");
		var objImage = new Image();
		objImage.onload = function () {
			div.style.width = objImage.width + "px";
			div.style.height = objImage.height + "px";
			div.style.fontSize = "0px";
			objImage.onload = null;
		};
		objImage.src = el.src;
		div.style.backgroundImage = "url(" + el.src + ")";
		div.style.bgColor = "transparent";
		var id = el.id;
		var className = el.className;
		el.parentNode.replaceChild(div, el);
		div.id = id;
		div.className = className;
		return div;
	} else {
		return el;
	}
};
ET.Utils.getElementPath = function (element, parent) {
	if (!ET.isHtmlElement(element) || !ET.isHtmlElement(parent)) {
		return false;
	}
	var res = [];
	var el = element;
	while (el && el != parent) {
		var number = 1;
		while (el.previousSibling) {
			++number;
			el = el.previousSibling;
		}
		res.unshift(number);
		el = el.parentNode;
	}
	return res.join("-");
};
ET.Utils.cover = ET.Utils.createElement("div");
ET.Utils.cover.style.overflow = "hidden";
ET.Utils.cover.style.position = "absolute";
ET.Utils.cover.style.backgroundImage = "url(" + ET.etPath + "zpempty.gif)";
ET.Utils.cover.style.display = "none";
ET.Utils.cover.id = "zpCoverControl";
ET.Utils.cover.show = function (zIndex, cursor, mouseMoveHandler, mouseUpHandler) {
	if (!this.parentNode) {
		document.body.appendChild(this);
	}
	if (this.style.display != "none") {
		this.hide();
	}
	this.style.display = "block";
	ET.Utils.makeSafelyMovable(this, null, document.body);
	var x = 0;
	var y = 0;
	y += ET.Utils.getPageScrollY();
	x += ET.Utils.getPageScrollX();
	ET.Utils.moveTo(this, x, y);
	var dim = ET.Utils.getWindowSize();
	this.style.width = dim.width + "px";
	this.style.height = dim.height + "px";
	//ET.FixateOnScreen.register(this);
	this.style.zIndex = zIndex;
	this.style.cursor = cursor;
	if (typeof mouseMoveHandler == "function") {
		ET.Utils.addEvent(this, "mousemove", mouseMoveHandler);
	}
	if (typeof mouseUpHandler == "function") {
		ET.Utils.addEvent(this, "mouseup", mouseUpHandler);
	}
	this.mouseMoveHandler = mouseMoveHandler;
	this.mouseUpHandler = mouseUpHandler;
};
ET.Utils.cover.hide = function () {
	//ET.FixateOnScreen.unregister(this);
	if (typeof this.mouseMoveHandler == "function") {
		ET.Utils.removeEvent(this, "mousemove", this.mouseMoveHandler);
	}
	if (typeof this.mouseUpHandler == "function") {
		ET.Utils.removeEvent(this, "mouseup", this.mouseUpHandler);
	}
	this.mouseMoveHandler = null;
	this.mouseUpHandler = null;
	this.style.zIndex = "";
	this.style.cursor = "";
	this.style.display = "none";
};
ET.Movable = {};
ET.Movable.setPosition = function (x, y) {
	if (!this.isMovableSafely()) {
		ET.Log({description:"The object with ID '" + this.id + "' was not prepared for moving! Use obj.makeMovable() to do so!", type:"warning"});
		return false;
	}
	var msgValue = null, moveConfig = this.getMoveConfig();
	if (x || x === 0) {
		msgValue = x;
		x = this._parseCoordinate(x, "x", moveConfig.moveLayer);
		if (!x && x !== 0) {
			ET.Log({description:"The X coordinate " + msgValue + " can not be set for object with ID '" + this.id + "'!", type:"warning"});
			return false;
		}
	}
	if (y || y === 0) {
		msgValue = y;
		y = this._parseCoordinate(y, "y", moveConfig.moveLayer);
		if (!y && y !== 0) {
			ET.Log({description:"The Y coordinate " + msgValue + " can not be set for object with ID '" + this.id + "'!", type:"warning"});
			return false;
		}
	}
	var elements = ET.Array(this.getMovableElements());
	if (this.fireEvent("beforePositionChange", x, y) === false) {
		return false;
	}
	if (ET.GlobalEvents.fireEvent("beforePositionChange", x, y, this) === false) {
		return false;
	}
	this._proceedElementsCoords(x, y, elements);
	if (this.isMoving()) {
		this.fireEvent("onMove", x || this.getPosition().x, y || this.getPosition().y);
		ET.GlobalEvents.fireEvent("onMove", x || this.getPosition().x, y || this.getPosition().y, this);
	}
	this.fireEvent("onPositionChange", x || this.getPosition().x, y || this.getPosition().y);
	ET.GlobalEvents.fireEvent("onPositionChange", x || this.getPosition().x, y || this.getPosition().y, this);
	return true;
};
ET.Movable.setOrientedPosition = function (x, y) {
	switch (this.getMoveConfig().orientation) {
	  case "vertical":
		return this.setPosition(y, x);
	  case "horizontal":
		return this.setPosition(x, y);
	}
	return false;
};
ET.Movable.setPagePosition = function (x, y) {
	var moveConfig = this.getMoveConfig();
	if (moveConfig.moveLayer == document.body) {
		return this.setPosition(x, y);
	}
	var msgValue = null;
	if (x || x === 0) {
		msgValue = x;
		x = this._parseCoordinate(x, "x", document.body);
		if (!x && x !== 0) {
			ET.Log({description:"The X page coordinate " + msgValue + " can not be set for object with ID '" + this.id + "'!", type:"warning"});
			return false;
		}
	}
	if (y || y === 0) {
		msgValue = y;
		y = this._parseCoordinate(y, "y", document.body);
		if (!y && y !== 0) {
			ET.Log({description:"The Y page coordinate " + msgValue + " can not be set for object with ID '" + this.id + "'!", type:"warning"});
			return false;
		}
	}
	var pos = ET.Utils.getElementOffset(moveConfig.moveLayer);
	return this.setPosition((x || x === 0) ? (x - pos.x) : x, (y || y === 0) ? (y - pos.y) : y);
};
ET.Movable.setScreenPosition = function (x, y) {
	var moveConfig = this.getMoveConfig();
	var msgValue = null;
	if (x || x === 0) {
		msgValue = x;
		x = this._parseCoordinate(x, "x", window);
		if (!x && x !== 0) {
			ET.Log({description:"The X screen coordinate " + msgValue + " can not be set for object with ID '" + this.id + "'!", type:"warning"});
			return false;
		}
	}
	if (y || y === 0) {
		msgValue = y;
		y = this._parseCoordinate(y, "y", window);
		if (!y && y !== 0) {
			ET.Log({description:"The Y screen coordinate " + msgValue + " can not be set for object with ID '" + this.id + "'!", type:"warning"});
			return false;
		}
	}
	if (moveConfig.moveLayer != document.body) {
		var pos = ET.Utils.getElementOffset(moveConfig.moveLayer);
	} else {
		var pos = {x:0, y:0};
	}
	return this.setPosition((x || x === 0) ? (x - pos.x) : x, (y || y === 0) ? (y - pos.y) : y);
};
ET.Movable.moveFor = function (offsetLeft, offsetTop) {
	var pos = this.getPosition();
	return this.setPosition(offsetLeft == null ? null : pos.x + offsetLeft, offsetTop == null ? null : pos.y + offsetTop);
};
ET.Movable.getPosition = function () {
	var el = this.getMovableMeasurement();
	if (ET.isHtmlElement(el) || (el && typeof el == "object" && typeof el.x == "number" && typeof el.y == "number")) {
		return ET.Utils.getPos(el) || el;
	}
	ET.Log({description:"Can't calculate position for object with ID '" + this.id + "'!", type:"warning"});
	return false;
};
ET.Movable.getPagePosition = function () {
	var el = this.getMovableMeasurement();
	if (ET.isHtmlElement(el) || (el && typeof el == "object" && typeof el.x == "number" && typeof el.y == "number")) {
		return ET.Utils.getElementOffset(el) || el;
	}
	ET.Log({description:"Can't calculate screen position for object with ID '" + this.id + "'!", type:"warning"});
	return false;
};
ET.Movable.getScreenPosition = function () {
	var pos = this.getPagePosition();
	pos.x -= ET.Utils.getPageScrollX();
	pos.y -= ET.Utils.getPageScrollY();
	return pos;
};
ET.Movable.startMove = function () {
	if (!this.isMovableSafely()) {
		ET.Log({description:"The object with ID '" + this.id + "' was not prepared for moving! Use obj.makeMovable() to do so!", type:"warning"});
		return false;
	}
	this.fireEvent("moveStart");
	ET.GlobalEvents.fireEvent("moveStart", this);
	this._setMovingState(true);
	return true;
};
ET.Movable.endMove = function () {
	if (!this.isMoving()) {
		ET.Log({description:"The moving for object with ID '" + this.id + "' was not started!", type:"warning"});
		return false;
	}
	this.fireEvent("moveEnd");
	ET.GlobalEvents.fireEvent("moveEnd", this);
	this._setMovingState(false);
	return true;
};
ET.Movable.isMoving = function () {
	return this.movingState;
};
ET.Movable._setMovingState = function (on) {
	this.movingState = on;
};
ET.Movable.isMovableSafely = function () {
	return this.safelyMovable;
};
ET.Movable._setMovableSafely = function (on) {
	this.safelyMovable = on;
};
ET.Movable.makeMovable = function () {
	if (!this.requireInterface("ET.CommandEvent")) {
		return false;
	}
	if (this.isMovableSafely()) {
		return true;
	}
	var elements = ET.Array(this.getMovableElements()), self = this, moveConfig = this.getMoveConfig();
	success = elements.each(function (index, movable) {
		if (ET.isHtmlElement(movable)) {
			if (moveConfig.preserveSizes && !ET.Utils.makeSafelySizable(movable)) {
				return "break";
			}
			if (!ET.Utils.makeSafelyMovable(movable, moveConfig.moveLayer)) {
				return "break";
			}
			self.createProperty(movable, "moveObj", self);
		} else {
			if (ET.isMovableObj(movable)) {
				if (!movable.makeMovable()) {
					return "break";
				}
			}
		}
	});
	if (!success) {
		this.restoreOfMove();
		ET.Log({description:"Can not make the object with ID '" + this.id + "' movable!"});
		return false;
	}
	this._setMovableSafely(true);
	return true;
};
ET.Movable.restoreOfMove = function () {
	if (!this.isMovableSafely()) {
		return true;
	}
	var elements = ET.Array(this.getMovableElements());
	var self = this;
	elements.each(function (index, movable) {
		if (ET.isHtmlElement(movable)) {
			ET.Utils.restoreOfMove(movable);
			if (self.getMoveConfig().preserveSizes) {
				ET.Utils.restoreOfSizing(movable);
			}
			movable.moveObj = null;
		} else {
			if (ET.isMovableObj(movable)) {
				movable.restoreOfMove();
			}
		}
	}, true);
	this._setMovableSafely(false);
	return true;
};
ET.Movable.getMovableMeasurement = function () {
	return this.getContainer();
};
ET.Movable.getMoveConfig = function () {
	return this.getConfiguration();
};
ET.Movable.setMoveConfig = function (config) {
	this.reconfigure(config);
};
ET.Movable.getMovableElements = function () {
	return this.getContainer();
};
ET.Movable.getContainer = function () {
	return this.getMoveConfig().container;
};
ET.Movable._parseCoordinate = function (coord, dimension, within) {
	switch (true) {
	  case (typeof coord == "number"):
		if (within == window) {
			coord += ET.Utils["getPageScroll" + dimension.toUpperCase()]();
		}
		break;
	  case ((/^\d+px$/).test(String(coord))):
		coord = parseInt(coord, 10);
		if (within == window) {
			coord += ET.Utils["getPageScroll" + dimension.toUpperCase()]();
		}
		break;
	  case ((/^(left|top|bottom|right|center)$/i).test(String(coord))):
		coord = this._parseWordCoordinate(coord, dimension, within);
		break;
	}
	return this._canSetCoordinate(coord, dimension, within);
};
ET.Movable._parseWordCoordinate = function (coord, dimension, within) {
	if ((/(left|right)/i).test(String(coord)) && dimension.toUpperCase() != "X") {
		return false;
	}
	if ((/(top|bottom)/i).test(String(coord)) && dimension.toUpperCase() != "Y") {
		return false;
	}
	var dim = (dimension.toUpperCase() == "X") ? "Left" : "Top";
	var sizeDim = (dimension.toUpperCase() == "X") ? "Width" : "Height";
	var parsedCoord = 0;
	var wSize = null;
	if (ET.isHtmlElement(within)) {
		parsedCoord = within["scroll" + dim];
		wSize = ET.Utils["get" + sizeDim](within);
	} else {
		if (within == window) {
			parsedCoord = ET.Utils["getPageScroll" + dimension.toUpperCase()]();
			wSize = ET.Utils.getWindowSize()[sizeDim.toLowerCase()];
		} else {
			if (within && typeof within == "object") {
				parsedCoord += within["scroll" + dim] || 0;
				wSize = within[sizeDim.toLowerCase()];
			} else {
				return false;
			}
		}
	}
	var measurement = this.getMovableMeasurement();
	var mSize = null;
	if (ET.isHtmlElement(measurement)) {
		mSize = ET.Utils["get" + sizeDim](measurement);
	} else {
		if (measurement && typeof measurement == "object") {
			mSize = measurement[sizeDim.toLowerCase()];
		}
	}
	switch (coord) {
	  case "left":
	  case "top":
		break;
	  case "LEFT":
	  case "TOP":
		parsedCoord -= mSize;
		break;
	  case "right":
	  case "bottom":
		parsedCoord += wSize - mSize;
		break;
	  case "RIGHT":
	  case "BOTTOM":
		parsedCoord += wSize;
		break;
	  case "center":
		parsedCoord += Math.round((wSize - mSize) / 2);
		break;
	  case "CENTER":
		parsedCoord += Math.round(wSize / 2);
		break;
	  default:
		parsedCoord = null;
		break;
	}
	if (!parsedCoord && parsedCoord !== 0) {
		return false;
	} else {
		return parsedCoord;
	}
};
ET.Movable._canSetCoordinate = function (coord, dimension, within) {
	if (typeof coord != "number") {
		return false;
	}
	var moveConfig = this.getMoveConfig();
	if (within != moveConfig.moveLayer) {
		return coord;
	}
	var limitObj = moveConfig.limit;
	var dim = dimension.toUpperCase();
	var direction = moveConfig.direction.toLowerCase();
	var correction = this._getMovableShape();
	if (dim == "X" && direction == "vertical") {
		return this._handleCoordOverflow(this.getPosition().x);
	} else {
		if (dim == "Y" && direction == "horizontal") {
			return this._handleCoordOverflow(this.getPosition().y);
		}
	}
	if ((limitObj["min" + dim] || limitObj["min" + dim] === 0) && coord < limitObj["min" + dim] + correction["min" + dim]) {
		return this._handleCoordOverflow(limitObj["min" + dim] + correction["min" + dim]);
	}
	if ((limitObj["max" + dim] || limitObj["max" + dim] === 0) && coord > limitObj["max" + dim] + correction["max" + dim]) {
		return this._handleCoordOverflow(limitObj["max" + dim] + correction["max" + dim]);
	}
	return coord;
};
ET.Movable._handleCoordOverflow = function (limit, dimension) {
	return false;
};
ET.Movable._getMovableShape = function () {
	var measurement = this.getMovableMeasurement();
	var obj = {minX:0, maxX:0, minY:0, maxY:0};
	switch (this.getMoveConfig().followShape) {
	  case (true):
		if (!ET.isHtmlElement(measurement)) {
			return obj;
		}
		obj.maxX = -ET.Utils.getWidth(measurement);
		obj.maxY = -ET.Utils.getHeight(measurement);
		return obj;
	  default:
		return obj;
	}
};
ET.Movable.getMovingPoint = function () {
	return this.getScreenPosition();
};
ET.Movable._proceedElementsCoords = function (x, y, elements) {
	elements = ET.Array(elements);
	var measurement = this.getMovableMeasurement();
	var pos = null;
	if (ET.isHtmlElement(measurement)) {
		pos = ET.Utils.getPos(measurement);
	} else {
		if (measurement && typeof measurement == "object") {
			pos = {x:(typeof measurement.x == "number") ? measurement.x : null, y:(typeof measurement.y == "number") ? measurement.y : null};
			if (!measurement.x || !measurement.y) {
				pos = null;
			}
		}
	}
	elements.each(function (index, movable) {
		var mX = x, mY = y;
		if (pos) {
			var mPos = null;
			if (ET.isHtmlElement(movable)) {
				mPos = ET.Utils.getPos(movable);
			} else {
				if (ET.isMovableObj(movable)) {
					mPos = movable.getPosition();
				} else {
					return;
				}
			}
			if (x || x === 0) {
				mX = mPos.x + (x - pos.x);
			}
			if (y || y === 0) {
				mY = mPos.y + (y - pos.y);
			}
		}
		if (ET.isHtmlElement(movable)) {
			ET.Utils.moveTo(movable, mX, mY);
		} else {
			if (ET.isMovableObj(movable)) {
				movable.setPosition(mX, mY);
			}
		}
	});
};
ET.Movable.sortElementsByPath = function (elements) {
	elements = ET.Array(elements);
	elements.each(function (index, element) {
		var path = ET.Utils.getElementPath(element, document.body);
		if (!path) {
			return;
		}
		path = ET.Array(path.split("-"));
		for (var i = index; i < elements.length; ++i) {
			var compPath = ET.Utils.getElementPath(elements[i], document.body);
			if (!compPath) {
				continue;
			}
			compPath = ET.Array(compPath.split("-"));
			path.each(function (k, pathPiece, whole) {
				if (parseInt(pathPiece, 10) > (parseInt(compPath[k], 10) || 0)) {
					return "break";
				} else {
					if (parseInt(pathPiece, 10) < parseInt(compPath[k], 10)) {
						var el = elements[index];
						elements[index] = elements[i];
						elements[i] = el;
						path = compPath;
						return "break";
					}
				}
			});
		}
	});
	return true;
};
ET.Utils.Movable = function (config) {
	ET.Utils.Movable.SUPERconstructor.call(this, config);
};
ET.Utils.Movable.id = "ET.Utils.Movable";
ET.inherit(ET.Utils.Movable, ET.Widget);
ET.implement(ET.Utils.Movable, "ET.CommandEvent");
ET.implement(ET.Utils.Movable, "ET.Movable");
ET.Utils.Movable.prototype.init = function (config) {
	ET.Utils.Movable.SUPERclass.init.call(this, config);
	var self = this;
	var elements = null;
	if (this.getConfiguration().makeMovable) {
		this.makeMovable();
	} else {
		elements = ET.Array(this.getMovableElements());
		elements.each(function (index, movable) {
			if (ET.isHtmlElement(movable)) {
				self.createProperty(movable, "moveObj", self);
			}
		});
	}
};
ET.Utils.Movable.prototype.configure = function (config) {
	this.defineConfigOption("synchronize", []);
	this.defineConfigOption("container", null);
	this.defineConfigOption("limit", {minX:null, maxX:null, minY:null, maxY:null});
	this.defineConfigOption("direction", "both");
	this.defineConfigOption("moveLayer", document.body);
	this.defineConfigOption("followShape", "LT");
	this.defineConfigOption("preserveSizes", true);
	this.defineConfigOption("makeMovable", true);
	this.defineConfigOption("theme", null);
	ET.Utils.Movable.SUPERclass.configure.call(this, config);
	config = this.getConfiguration();
	if (!config.limit || typeof config.limit != "object") {
		config.limit = {minX:null, maxX:null, minY:null, maxY:null};
	}
	var self = this;
	config.synchronize = ET.Array(config.synchronize);
	config.synchronize.each(function (index, element) {
		if (element === null) {
			return;
		}
		element = ET.Widget.getElementById(element);
		element = ET.Utils.img2div(element);
		if (!element) {
			ET.Log({description:"Wrong element in synchronize array for the movable object with ID '" + self.id + "'!"});
		} else {
			config.synchronize[index] = element;
		}
	});
	config.container = ET.Widget.getElementById(config.container);
	config.container = ET.Utils.img2div(config.container);
	if (!ET.isHtmlElement(config.container)) {
		ET.Log({description:"Wrong element passed as container for the movable object with ID '" + self.id + "'!"});
	}
	this.movableElements = ET.Array(config.synchronize.concat(config.container));
	if (this.movableElements.length > 1) {
		this.sortElementsByPath(this.movableElements);
	}
	if (!ET.isHtmlElement(config.moveLayer = ET.Widget.getElementById(config.moveLayer))) {
		config.moveLayer = document.body;
	}
};
ET.Utils.Movable.prototype.reconfigure = function (config) {
	ET.Utils.Movable.SUPERclass.reconfigure.call(this, config);
};
ET.Utils.Movable.prototype.getMovableElements = function () {
	return this.movableElements;
};
ET.Draggable = {};
ET.Draggable.makeDraggable = function () {
	if (!this.requireInterface("ET.Movable")) {
		return false;
	}
	if (!this.requireInterface("ET.CommandEvent")) {
		return false;
	}
	var draggables = ET.Array(this.getDraggableElements());
	var hooks = ET.Array(this._getDraggableHooks());
	var self = this, result = false;
	var config = this.getDragConfig();
	if (config.method != "cut") {
		this.setDragConfig({eventCapture:false});
	}
	var listenersObj = this._getRestorer().getSavedProps()["dragListeners"] = {mousedown:function (ev) {
		return self.dragStart(ev);
	}, mousemove:function (ev) {
		if (self.isDragging()) {
			return self.dragMove(ev);
		}
	}, mouseup:function (ev) {
		if (self.isDragging()) {
			return self.dragEnd(ev);
		}
	}};
	hooks.each(function (index, hook) {
		if (!ET.isHtmlElement(hook)) {
			return;
		}
		result = true;
		if (ET.is_gecko) {
			hook.style.setProperty("-moz-user-select", "none", "");
		}
		ET.Utils.addEvent(hook, "mousedown", listenersObj.mousedown);
		if (config.eventCapture) {
			ET.Utils.addEvent(hook, "mousemove", listenersObj.mousemove);
			ET.Utils.addEvent(hook, "mouseup", listenersObj.mouseup);
		}
	});
	draggables.each(function (index, draggable) {
		if (!ET.isHtmlElement(draggable)) {
			return;
		}
		self.createProperty(draggable, "dragObj", self);
	});
	return result;
};
ET.Draggable.dragStart = function (ev) {
	if (!this.canDrag()) {
		return true;
	}
	ev = ev || window.event;
	var iButton = ev.button || ev.which;
	if (iButton > 1) {
		return false;
	}
	var self = this;
	var config = this.getDragConfig();
	if (this.fireEvent("beforeDragInit", ev) === false) {
		return true;
	}
	if (ET.GlobalEvents.fireEvent("beforeDragInit", ev, this) === false) {
		return true;
	}
	this._setDragging(true);
	if (config.eventCapture && (config.method == "dummy" || config.method == "copy")) {
		var draggables = ET.Array(this.getDraggableElements());
		draggables.each(function (index, draggable) {
			draggable.restorer.saveProp("style.zIndex");
			draggable.style.zIndex = 2000001;
		});
	}
	this._proceedDraggableElements("dragStart");
	var oPos = ET.Utils.getMousePos(ev);
	var mouseX = oPos.pageX;
	var mouseY = oPos.pageY;
	this.makeMovable();
	this.startMove();
	var elements = ET.Array(this.getMovableElements());
	elements.each(function (index, movable) {
		if (ET.isHtmlElement(movable)) {
			movable.restorer.saveProp("style.zIndex");
			movable.style.zIndex = 1000000 + (parseInt(movable.style.zIndex, 10) || 0);
			self._proceedDragStyles(movable, "dragStart");
			if (config.eventCapture) {
				movable.restorer.saveProp("style.cursor");
				movable.style.cursor = "move";
			}
		} else {
			if (ET.isMovableObj(movable)) {
				var elems = ET.Array(movable.getMovableElements());
				elems.each(arguments.calee);
			}
		}
	});
	ET.Utils.cover.show(config.eventCapture ? 999999 : 2000000, "move", function (ev) {
		return self.dragMove(ev);
	}, function (ev) {
		return self.dragEnd(ev);
	});
	this._setMovingPoint(mouseX, mouseY);
	this.fireEvent("onDragInit", ev);
	ET.GlobalEvents.fireEvent("onDragInit", ev, this);
	if (config.stopEvent) {
		return ET.Utils.stopEvent(ev);
	} else {
		return true;
	}
};
ET.Draggable.dragMove = function (ev) {
	if (!this.isDragging()) {
		return true;
	}
	ev = ev || window.event;
	if (this.fireEvent("beforeDragMove", ev) === false) {
		return true;
	}
	if (ET.GlobalEvents.fireEvent("beforeDragMove", ev, this) === false) {
		return true;
	}
	if (ET.Utils.cover.style.zIndex != 2000000) {
		var config = this.getDragConfig();
		if (config.eventCapture && (config.method == "dummy" || config.method == "copy")) {
			var draggables = ET.Array(this.getDraggableElements());
			draggables.each(function (index, draggable) {
				draggable.restorer.restoreProp("style.zIndex");
			});
		}
		ET.Utils.cover.style.zIndex = 2000000;
	}
	var oPos = ET.Utils.getMousePos(ev);
	var mouseX = oPos.pageX;
	var mouseY = oPos.pageY;
	var movePoint = this.getMovingPoint();
	this.moveFor(mouseX - movePoint.x, mouseY - movePoint.y);
	this._setMovingPoint(mouseX, mouseY);
	this.fireEvent("onDragMove", ev);
	ET.GlobalEvents.fireEvent("onDragMove", ev, this);
	return ET.Utils.stopEvent(ev);
};
ET.Draggable.dragEnd = function (ev) {
	if (!this.isDragging()) {
		return true;
	}
	ev = ev || window.event;
	var self = this;
	if (this.fireEvent("beforeDragEnd", ev) === false) {
		return true;
	}
	if (ET.GlobalEvents.fireEvent("beforeDragEnd", ev, this) === false) {
		return true;
	}
	var config = this.getDragConfig();
	if (config.eventCapture && (config.method == "dummy" || config.method == "copy")) {
		var draggables = ET.Array(this.getDraggableElements());
		draggables.each(function (index, draggable) {
			draggable.restorer.restoreProp("style.zIndex", true);
		});
	}
	var elements = ET.Array(this.getMovableElements());
	elements.each(function (index, movable) {
		if (ET.isHtmlElement(movable)) {
			movable.restorer.restoreProp("style.zIndex");
			movable.restorer.restoreProp("style.cursor");
			self._proceedDragStyles(movable, "dragEnd");
		} else {
			if (ET.isMovableObj(movable)) {
				var elems = ET.Array(movable.getMovableElements());
				elems.each(arguments.calee);
			}
		}
	});
	this._proceedDraggableElements("dragEnd");
	ET.Utils.cover.hide();
	this._setMovingPoint(null, null);
	this._setDragging(false);
	this.endMove();
	this.fireEvent("onDragEnd", ev);
	ET.GlobalEvents.fireEvent("onDragEnd", ev, this);
	return ET.Utils.stopEvent(ev);
};
ET.Draggable.restorePos = function () {
	this.restoreOfMove();
};
ET.Draggable.restoreOfDrag = function () {
	var listenersObj = this._getRestorer().getSavedProps()["dragListeners"];
	if (!listenersObj) {
		return false;
	}
	this.restoreOfMove();
	var hooks = ET.Array(this._getDraggableHooks());
	var draggables = ET.Array(this.getDraggableElements());
	var self = this;
	var config = this.getDragConfig();
	hooks.each(function (index, hook) {
		if (!ET.isHtmlElement(hook)) {
			return;
		}
		if (ET.is_gecko) {
			hook.style.setProperty("-moz-user-select", "", "");
		}
		ET.Utils.removeEvent(hook, "mousedown", listenersObj.mousedown);
		if (config.eventCapture) {
			ET.Utils.removeEvent(hook, "mousemove", listenersObj.mousemove);
			ET.Utils.removeEvent(hook, "mouseup", listenersObj.mouseup);
		}
	});
	draggables.each(function (index, draggable) {
		if (!ET.isHtmlElement(draggable)) {
			return;
		}
		draggable.dragObj = null;
	});
	return true;
};
ET.Draggable.getDraggableElements = function () {
	return this.getContainer();
};
ET.Draggable._getDraggableHooks = function () {
	return this.getContainer();
};
ET.Draggable.getContainer = function () {
	return this.getDragConfig().container;
};
ET.Draggable.isDragging = function () {
	return this.dragging;
};
ET.Draggable.canDrag = function () {
	return this.canDrag;
};
ET.Draggable._setCanDrag = function (on) {
	this.canDrag = on;
};
ET.Draggable.getDragConfig = function () {
	return this.getConfiguration();
};
ET.Draggable.setDragConfig = function (config) {
	this.reconfigure(config);
};
ET.Draggable._setDragging = function (on) {
	this.dragging = on;
};
ET.Draggable._handleCoordOverflow = function (limit, dimension) {
	if (!this.isDragging()) {
		ET.Movable._handleCoordOverflow.call(this, limit, dimension);
	}
	return limit;
};
ET.Draggable._getRestorer = function () {
	if (!this.restorer) {
		this.restorer = new ET.SRProp(this);
	}
	return this.restorer;
};
ET.Draggable._proceedDraggableElements = function (dragState) {
	var config = this.getDragConfig(), restorer = this._getRestorer(), copies = null, measurement = null, self = this, listenersObj = restorer.getProp("dragListeners");
	function toggleEvents(action, hooks, listenersObj) {
		hooks.each(function (index, hook) {
			ET.Utils[action + "Event"](hook, "mousedown", listenersObj.mousedown);
			if (config.eventCapture) {
				ET.Utils[action + "Event"](hook, "mousemove", listenersObj.mousemove);
				ET.Utils[action + "Event"](hook, "mouseup", listenersObj.mouseup);
			}
		});
	}
	switch (config.method) {
	  case "copy":
	  case "dummy":
		if (dragState == "dragStart") {
			var elements = ET.Array(this.getDraggableElements());
			var hooks = ET.Array(this._getDraggableHooks());
			copies = ET.Array();
			toggleEvents("remove", hooks, listenersObj);
			elements.each(function (index, movable) {
				if (ET.isHtmlElement(movable)) {
					var newNode = movable.cloneNode(config.copyChilds);
					newNode.dragObj = self;
					if (config.eventCapture) {
						ET.Utils.addEvent(newNode, "mousemove", listenersObj.mousemove);
						ET.Utils.addEvent(newNode, "mouseup", listenersObj.mouseup);
					}
					movable.parentNode.insertBefore(newNode, movable);
					newNode.style.visibility = "visible";
					copies.push(newNode);
					if (movable == self.getMovableMeasurement()) {
						measurement = newNode;
					}
				} else {
					if (ET.isMovableObj(movable)) {
						var elems = ET.Array(movable.getMovableElements());
						elems.each(arguments.calee);
					}
				}
			});
			toggleEvents("add", hooks, listenersObj);
			if (!measurement) {
				measurement = this.getMovableMeasurement();
			}
			restorer.saveProp("getMovableElements");
			restorer.saveProp("isMovableSafely()");
			this._setMovableSafely(false);
			this.getMovableElements = function (resetArray) {
				var arr = copies;
				copies = resetArray ? null : copies;
				return arr;
			};
			restorer.saveProp("getMovableMeasurement");
			this.getMovableMeasurement = function () {
				return measurement;
			};
		} else {
			if (dragState == "dragEnd") {
				var elements = ET.Array(this.getMovableElements(true));
				elements.each(function (index, movable) {
					if (config.method == "dummy") {
						movable.parentNode.removeChild(movable);
					}
					movable.dragObj = null;
					if (config.eventCapture) {
						ET.Utils.removeEvent(movable, "mousemove", listenersObj.mousemove);
						ET.Utils.removeEvent(movable, "mouseup", listenersObj.mouseup);
					}
				});
				this.restoreOfMove();
				restorer.restoreProp("getMovableElements");
				this._setMovableSafely(restorer.getProp("isMovableSafely()"));
				restorer.restoreProp("isMovableSafely()");
				restorer.restoreProp("getMovableMeasurement");
			}
		}
		break;
	  default:
		break;
	}
};
ET.Draggable._proceedDragStyles = function (movable, dragState) {
	var config = this.getDragConfig();
	if (config.overwriteCSS) {
		if (dragState == "dragStart") {
			movable.restorer.saveProp("className");
			movable.className = config.overwriteCSS;
		} else {
			if (dragState == "dragEnd") {
				movable.restorer.restoreProp("className");
			}
		}
	}
	if (config.dragCSS) {
		if (dragState == "dragStart") {
			ET.Utils.addClass(movable, config.dragCSS);
		} else {
			if (dragState == "dragEnd") {
				ET.Utils.removeClass(movable, config.dragCSS);
			}
		}
	}
};
ET.Draggable._setMovingPoint = function (x, y) {
	var movingPoint = this._getMovingPointObject();
	if (x === null || y === null) {
		movingPoint.x = null;
		movingPoint.y = null;
		movingPoint.offsetX = null;
		movingPoint.offsetY = null;
		return;
	}
	if (movingPoint.x === null || movingPoint.y === null) {
		var pos = this.getPagePosition();
		movingPoint.x = x;
		movingPoint.y = y;
		movingPoint.offsetX = x - pos.x;
		movingPoint.offsetY = y - pos.y;
	} else {
		var pos = this.getPagePosition();
		movingPoint.x = pos.x + movingPoint.offsetX;
		movingPoint.y = pos.y + movingPoint.offsetY;
	}
	return;
};
ET.Draggable.getMovingPoint = function () {
	var movingPoint = this._getMovingPointObject();
	return {x:movingPoint.x, y:movingPoint.y};
};
ET.Draggable._getMovingPointObject = function () {
	if (!this.movingPoint || typeof this.movingPoint != "object") {
		this.movingPoint = {x:null, y:null, offsetX:null, offsetY:null};
	}
	return this.movingPoint;
};
ET.Utils.Draggable = function (config) {
	if (arguments.length > 1) {
		var args = arguments[1];
		args.container = config;
		config = args;
	}
	if (typeof config.left != "undefined" || typeof config.right != "undefined" || typeof config.top != "undefined" || typeof config.bottom != "undefined") {
		config.limit = {minX:config.left, maxX:config.right, minY:config.top, maxY:config.bottom};
	}
	if (config.dragLayer) {
		config.moveLayer = config.dragLayer;
	}
	if (!config.eventListeners) {
		config.eventListeners = {};
	}
	if (config.beforeDragInit) {
		config.eventListeners.beforeDragInit = config.beforeDragInit;
	}
	if (config.beforeDragMove) {
		config.eventListeners.beforeDragMove = config.beforeDragMove;
	}
	if (config.beforeDragEnd) {
		config.eventListeners.beforeDragEnd = config.beforeDragEnd;
	}
	if (config.onDragInit) {
		config.eventListeners.onDragInit = config.onDragInit;
	}
	if (config.onDragMove) {
		config.eventListeners.onDragMove = config.onDragMove;
	}
	if (config.onDragEnd) {
		config.eventListeners.onDragEnd = config.onDragEnd;
	}
	if (config.stopEv) {
		config.stopEvent = config.stopEv;
	}
	config = ET.Hash.remove(config, "left", "top", "right", "bottom", "dragLayer", "beforeDragInit", "beforeDragMove", "beforeDragEnd", "onDragInit", "onDragMove", "onDragEnd", "stopEv");
	ET.Utils.Draggable.SUPERconstructor.call(this, config);
};
ET.Utils.Draggable.id = "ET.Utils.Draggable";
ET.inherit(ET.Utils.Draggable, ET.Utils.Movable);
ET.implement(ET.Utils.Draggable, "ET.Draggable");
ET.Utils.Draggable.prototype.init = function (config) {
	ET.Utils.Draggable.SUPERclass.init.call(this, config);
	this.makeDraggable();
};
ET.Utils.Draggable.prototype.configure = function (config) {
	this.defineConfigOption("method", "cut");
	this.defineConfigOption("stopEvent", true);
	this.defineConfigOption("eventCapture", false);
	this.defineConfigOption("handler", null);
	this.defineConfigOption("dragCSS", null);
	this.defineConfigOption("overwriteCSS", null);
	this.defineConfigOption("copyChilds", true);
	this.defineConfigOption("makeMovable", false);
	ET.Utils.Draggable.SUPERclass.configure.call(this, config);
	config = this.getConfiguration();
	if (ET.is_opera) {
		config.eventCapture = true;
	}
	config.handler = ET.Widget.getElementById(config.handler);
	config.handler = ET.Utils.img2div(config.handler);
	if (!ET.isHtmlElement(config.handler)) {
		config.handler = config.container;
	}
};
ET.Utils.Draggable.prototype.reconfigure = function (config) {
	ET.Utils.Draggable.SUPERclass.reconfigure.call(this, config);
};
ET.Utils.Draggable.prototype.getDraggableElements = function () {
	return this.movableElements;
};
ET.Utils.Draggable.prototype._getDraggableHooks = function () {
	return this.getConfiguration().handler;
};
ET.Utils.initDragObjects = function (className, el, recursive, config) {
	if (!className) {
		return;
	}
	var elements = ET.Utils.getElementsByAttribute("className", className, el, recursive, true);
	return ET.Utils.applyToElements(ET.Utils.Draggable, elements, config);
};
ET.Sizable = {};
ET.Sizable.setWidth = function (width) {
	return this._setDimension(width, "width");
};
ET.Sizable.setHeight = function (height) {
	return this._setDimension(height, "height");
};
ET.Sizable.setOrientedWidth = function (width) {
	if (!this.getOrientation) {
		return false;
	}
	switch (this.getOrientation()) {
	  case "vertical":
		return this._setDimension(width, "height");
	  case "horizontal":
		return this._setDimension(width, "width");
	}
};
ET.Sizable.setOrientedHeight = function (height) {
	if (!this.getOrientation) {
		return false;
	}
	switch (this.getOrientation()) {
	  case "vertical":
		return this._setDimension(height, "width");
	  case "horizontal":
		return this._setDimension(height, "height");
	}
};
ET.Sizable._setDimension = function (val, dimension) {
	var evDim = dimension.charAt(0).toUpperCase() + dimension.slice(1);
	if (!this.isSizableSafely(dimension)) {
		ET.Log({description:"The object " + dimension + " ID '" + this.id + "' was not prepared for sizing! Use obj.makeSizable() to do so!", type:"warning"});
		return false;
	}
	var msgValue = val + "";
	val = this._parseSize(val, dimension);
	if (!val) {
		ET.Log({description:"The " + dimension + " " + msgValue + " can not be set for object with ID '" + this.id + "'!", type:"warning"});
		return false;
	}
	var elements = ET.Array(this.getSizableElements(dimension));
	var toRestore = [], self = this;
	if (this.fireEvent("before" + evDim + "Change", val) === false) {
		return false;
	}
	if (ET.GlobalEvents.fireEvent("before" + evDim + "Change", val, this) === false) {
		return false;
	}
	if (!this._proceedElementsSizes(val, dimension, elements, toRestore)) {
		this._rollBackSizing(toRestore, dimension);
		this.fireEvent(dimension + "ChangeFailure", val);
		ET.GlobalEvents.fireEvent(dimension + "ChangeFailure", val, this);
		ET.Log({description:"Impossible to set the " + dimension + " " + msgValue + " for the object with ID '" + this.id + "'!", type:"warning"});
		return false;
	} else {
		if (this.isSizing()) {
			if (dimension == "width") {
				this.fireEvent("onSizing", val, this.getHeight());
				ET.GlobalEvents.fireEvent("onSizing", val, this.getHeight(), this);
			} else {
				this.fireEvent("onSizing", this.getWidth(), val);
				ET.GlobalEvents.fireEvent("onSizing", this.getWidth(), val, this);
			}
		}
		this.fireEvent("on" + evDim + "Change", val);
		ET.GlobalEvents.fireEvent("on" + evDim + "Change", val, this);
	}
	return true;
};
ET.Sizable.startSizing = function () {
	if (!this.isSizableSafely()) {
		ET.Log({description:"The object with ID '" + this.id + "' was not prepared for sizing! Use obj.makeSizable() to do so!", type:"warning"});
		return false;
	}
	this.fireEvent("sizingStart");
	ET.GlobalEvents.fireEvent("sizingStart", this);
	this._setSizingState(true);
	return true;
};
ET.Sizable.endSizing = function () {
	if (!this.isSizing()) {
		ET.Log({description:"The sizing for object with ID '" + this.id + "' was not started!", type:"warning"});
		return false;
	}
	this.fireEvent("sizingEnd");
	ET.GlobalEvents.fireEvent("sizingEnd", this);
	this._setSizingState(false);
	return true;
};
ET.Sizable.isSizing = function () {
	return this.sizingState;
};
ET.Sizable._setSizingState = function (on) {
	this.sizingState = on;
};
ET.Sizable.getWidth = function () {
	var el = this.getSizableMeasurement("width");
	if (ET.isHtmlElement(el) || typeof el == "number") {
		return ET.Utils.getWidth(el) || el;
	}
	ET.Log({description:"Can't calculate width for object with ID '" + this.id + "'!", type:"warning"});
	return false;
};
ET.Sizable.getHeight = function () {
	var el = this.getSizableMeasurement("height");
	if (ET.isHtmlElement(el) || typeof el == "number") {
		return ET.Utils.getHeight(el) || el;
	}
	ET.Log({description:"Can't calculate height for object with ID '" + this.id + "'!", type:"warning"});
	return false;
};
ET.Sizable.isSizableSafely = function (dimension) {
	return this.safelySizable;
};
ET.Sizable.makeSizable = function () {
	if (!this.hasInterface("ET.CommandEvent")) {
		ET.Log({description:"The object with ID '" + this.id + "' has no ET.CommandEvent interface!"});
		return false;
	}
	if (this.isSizableSafely()) {
		return true;
	}
	var elements = ET.Array(this.getSizableElements()), success = true, self = this;
	elements.each(function (index, sizable) {
		sizable = ET.Array(sizable);
		sizable.each(function (index, sizable) {
			if (ET.isHtmlElement(sizable)) {
				if (!ET.Utils.makeSafelySizable(sizable)) {
					success = false;
					return "break";
				}
				self.createProperty(sizable, "sizingObj", self);
			} else {
				if (ET.isSizableObj(sizable)) {
					if (!sizable.makeSizable()) {
						success = false;
						return "break";
					}
				}
			}
		});
	});
	if (!success) {
		this.restoreOfSizing();
		ET.Log({description:"Can not make the object with ID '" + this.id + "' sizable!"});
		return false;
	}
	this._setSizableSafely(true);
	return true;
};
ET.Sizable.restoreOfSizing = function () {
	if (!this.isSizableSafely()) {
		return true;
	}
	var elements = ET.Array(this.getSizableElements());
	elements.each(function (index, sizable) {
		sizable = ET.Array(sizable);
		sizable.each(function (index, sizable) {
			if (ET.isHtmlElement(sizable)) {
				ET.Utils.restoreOfSizing(sizable);
				sizable.sizingObj = null;
			} else {
				if (ET.isSizableObj(sizable)) {
					sizable.restoreOfSizing();
				}
			}
		});
	});
	this._setSizableSafely(false);
	return true;
};
ET.Sizable.replaceWithSizable = function (element, withEl) {
	if (!ET.isHtmlElement(element) || !ET.isHtmlElement(withEl)) {
		return false;
	}
	var width = ET.Utils.getWidth(element);
	var height = ET.Utils.getHeight(element);
	element.parentNode.insertBefore(withEl, element.nextSibling);
	if (ET.is_ie) {
		element.style.display = "none";
	} else {
		element.parentNode.removeChild(element);
	}
	if (!ET.Utils.makeSafelySizable(withEl)) {
		return false;
	}
	if (ET.Utils.setWidth(withEl, width) && ET.Utils.setHeight(withEl, height)) {
		return true;
	}
	return false;
};
ET.Sizable._setSizableSafely = function (on) {
	this.safelySizable = on;
};
ET.Sizable._parseSize = function (size, dimension) {
	switch (true) {
	  case (size == "auto"):
		size = this._parseAutoSize(dimension);
		break;
	  case ((/^\d+px$/).test(String(size))):
		size = parseInt(size, 10);
		break;
	  case ((/^\d+%$/).test(String(size))):
		size = this._parsePercentSize(size, dimension);
		break;
	  case (typeof size == "number"):
		break;
	}
	return this._canSetSize(size, dimension);
};
ET.Sizable._parseAutoSize = function (dimension) {
	var measurement = this.getSizableMeasurement(dimension);
	var autoSizable = this._getAutoSizableElement(dimension);
	if (!ET.isHtmlElement(autoSizable)) {
		return null;
	}
	var dim = dimension.charAt(0).toUpperCase() + dimension.slice(1).toLowerCase();
	var diff = 0;
	if (ET.isHtmlElement(measurement) || typeof measurement == "number") {
		diff = (ET.Utils["get" + dim](measurement) || measurement) - ET.Utils["get" + dim](autoSizable);
	}
	var el = autoSizable;
	if (el.tagName.toLowerCase() == "iframe") {
		try {
			if (el.contentDocument != null) {
				el = el.contentDocument.body;
			} else {
				if (el.contentWindow.document != null) {
					el = el.contentWindow.document.body;
				}
			}
			if (!ET.isHtmlElement(el)) {
				throw "No element to calculate auto size!";
			}
		}
		catch (e) {
			ET.Log({description:"Can't calculate auto size for the IFRAME in the object with ID '" + this.id + "'!", type:"warning"});
			return null;
		}
	}
	return el["scroll" + dim] + diff;
};
ET.Sizable._parsePercentSize = function (value, dimension) {
	var sizableParent = this._getSizableParent(dimension);
	if (!ET.isHtmlElement(sizableParent)) {
		return null;
	}
	var dim = dimension.charAt(0).toUpperCase() + dimension.slice(1).toLowerCase();
	value = parseInt(value, 10);
	return Math.round((value / 100) * ET.Utils["get" + dim](sizableParent));
};
ET.Sizable._canSetSize = function (value, dimension) {
	if (typeof value != "number") {
		return false;
	}
	var dim = dimension.charAt(0).toUpperCase() + dimension.slice(1).toLowerCase();
	var sizingConfig = this.getSizingConfig();
	var limit = sizingConfig.limit;
	var direction = sizingConfig.direction;
	if (dim == "Width" && direction == "vertical") {
		return this._handleSizeOverflow(this.getWidth());
	}
	if (dim == "Height" && direction == "horizontal") {
		return this._handleSizeOverflow(this.getHeight());
	}
	if (typeof limit["min" + dim] == "number" && value < limit["min" + dim]) {
		return this._handleSizeOverflow(limit["min" + dim]);
	}
	if (typeof limit["max" + dim] == "number" && value > limit["max" + dim]) {
		return this._handleSizeOverflow(limit["max" + dim]);
	}
	return value;
};
ET.Sizable._handleSizeOverflow = function (limit, dimension) {
	return false;
};
ET.Sizable.getSizingConfig = function () {
	return this.getConfiguration();
};
ET.Sizable.setSizingConfig = function (config) {
	this.reconfigure(config);
};
ET.Sizable._getAutoSizableElement = function (dimension) {
	return this.getContainer();
};
ET.Sizable._getSizableParent = function (dimension) {
	return this.getContainer().parentNode;
};
ET.Sizable.getSizableMeasurement = function (dimension) {
	return this.getContainer();
};
ET.Sizable.getSizableElements = function (dimension) {
	return this.getContainer();
};
ET.Sizable.getContainer = function () {
	return this.getSizingConfig().container;
};
ET.Sizable._setElementSize = function (size, sizable, dimension) {
	var dim = dimension.charAt(0).toUpperCase() + dimension.slice(1).toLowerCase();
	if (ET.isHtmlElement(sizable)) {
		if (ET.Utils["set" + dim](sizable, size)) {
			return true;
		} else {
			return false;
		}
	} else {
		if (ET.isSizableObj(sizable)) {
			if (sizable["set" + dim](size)) {
				return true;
			} else {
				return false;
			}
		}
	}
	return true;
};
ET.Sizable._proceedElementsSizes = function (value, dimension, elArr, restArr) {
	var diff = null, self = this, sizes = ET.Array();
	var measurement = this.getSizableMeasurement(dimension);
	var dim = dimension.charAt(0).toUpperCase() + dimension.slice(1).toLowerCase();
	if (typeof measurement == "number" || ET.isHtmlElement(measurement)) {
		diff = value - (ET.Utils["get" + dim](measurement) || measurement);
	}
	elArr = ET.Array(elArr);
	elArr.each(function (row, val) {
		var oneDiff = diff, size = value;
		val = ET.Array(val);
		if (diff) {
			oneDiff = Math.round(oneDiff / val.length);
		} else {
			size = Math.round(size / val.length);
		}
		sizes[row] = [];
		val.each(function (index, sizable) {
			var setSize = null;
			var elSize = null;
			if (ET.isHtmlElement(sizable)) {
				elSize = ET.Utils["get" + dim](sizable);
			} else {
				if (ET.isSizableObj(sizable)) {
					elSize = sizable["get" + dim]();
				} else {
					return;
				}
			}
			if (oneDiff || oneDiff === 0) {
				if (index != val.length - 1) {
					setSize = elSize + oneDiff;
				} else {
					setSize = elSize + (diff - oneDiff * index);
				}
			} else {
				if (index != val.length - 1) {
					setSize = size;
				} else {
					setSize = value - size * index;
				}
			}
			sizes[row][index] = {setSize:setSize, elSize:elSize};
		});
	});
	var res = elArr.each(function (row, val) {
		val = ET.Array(val);
		var res = val.each(function (index, sizable) {
			if (!sizes[row][index]) {
				return;
			}
			var res = self._setElementSize(sizes[row][index].setSize, sizable, dimension);
			if (!res && res === false) {
				return "break";
			} else {
				restArr.push({sizable:sizable, oldSize:sizes[row][index].elSize});
			}
		});
		if (!res && res === false) {
			return "break";
		}
	});
	return res;
};
ET.Sizable._rollBackSizing = function (rollBackArr, dimension) {
	var dim = dimension.charAt(0).toUpperCase() + dimension.slice(1).toLowerCase();
	rollBackArr = ET.Array(rollBackArr);
	rollBackArr.each(function (index, obj) {
		if (ET.isHtmlElement(obj.sizable)) {
			ET.Utils["set" + dim](obj.sizable, obj.oldSize);
		} else {
			if (ET.isSizableObj(obj.sizable)) {
				obj.sizable["set" + dim](obj.oldSize);
			}
		}
	});
};
ET.Utils.Sizable = function (config) {
	ET.Utils.Sizable.SUPERconstructor.call(this, config);
};
ET.Utils.Sizable.id = "ET.Utils.Sizable";
ET.inherit(ET.Utils.Sizable, ET.Widget);
ET.implement(ET.Utils.Sizable, "ET.CommandEvent");
ET.implement(ET.Utils.Sizable, "ET.Sizable");
ET.Utils.Sizable.prototype.init = function (config) {
	ET.Utils.Sizable.SUPERclass.init.call(this, config);
	this.makeSizable();
};
ET.Utils.Sizable.prototype.configure = function (config) {
	this.defineConfigOption("syncVertically", []);
	this.defineConfigOption("syncHorizontally", []);
	this.defineConfigOption("container", null);
	this.defineConfigOption("direction", "both");
	this.defineConfigOption("limit", {minWidth:10, maxWidth:null, minHeight:10, maxHeight:null});
	this.defineConfigOption("theme", null);
	ET.Utils.Sizable.SUPERclass.configure.call(this, config);
	config = this.getConfiguration();
	if (!config.limit || typeof config.limit != "object") {
		config.limit = {minWidth:null, maxWidth:null, minHeight:null, maxHeight:null};
	}
	var self = this;
	config.syncVertically = ET.Array(config.syncVertically);
	config.syncVertically.each(function (index, subArr) {
		config.syncVertically[index] = ET.Array(subArr);
		config.syncVertically[index].each(function (elIndex, element) {
			if (element === null) {
				return;
			}
			element = ET.Widget.getElementById(element);
			if (!element) {
				ET.Log({description:"Wrong element in syncVertically array for the sizable object with ID '" + self.id + "'!"});
			} else {
				config.syncVertically[index][elIndex] = element;
			}
		});
	});
	config.syncHorizontally = ET.Array(config.syncHorizontally);
	config.syncHorizontally.each(function (index, subArr) {
		config.syncHorizontally[index] = ET.Array(subArr);
		config.syncHorizontally[index].each(function (elIndex, element) {
			if (element === null) {
				return;
			}
			element = ET.Widget.getElementById(element);
			if (!element) {
				ET.Log({description:"Wrong element in syncHorizontally array for the sizable object with ID '" + self.id + "'!"});
			} else {
				config.syncHorizontally[index][elIndex] = element;
			}
		});
	});
	if (!ET.isHtmlElement(config.container = ET.Widget.getElementById(config.container))) {
		config.container = null;
	}
};
ET.Utils.Sizable.prototype.reconfigure = function (config) {
	ET.Utils.Sizable.SUPERclass.reconfigure.call(this, config);
};
ET.Utils.Sizable.prototype.getSizableElements = function (dimension) {
	var config = this.getConfiguration();
	if (dimension && dimension.toLowerCase() == "width") {
		return config.syncHorizontally.concat(config.container);
	} else {
		if (dimension && dimension.toLowerCase() == "height") {
			return config.syncVertically.concat(config.container);
		} else {
			return config.syncVertically.concat(config.syncHorizontally).concat(config.container);
		}
	}
};
ET.Resizable = {};
ET.Resizable.makeResizable = function () {
	if (!this.requireInterface("ET.Sizable")) {
		return false;
	}
	if (!this.requireInterface("ET.CommandEvent")) {
		return false;
	}
	var hooks = ET.Array(this._getResizableHooks());
	var measurement = this.getSizableMeasurement();
	var self = this, result = false;
	var config = this.getResizeConfig();
	if (/(vertical|horizontal|top|left|all)/.test(config.direction) && !this.hasInterface("ET.Movable")) {
		ET.Log({description:"The object with ID '" + this.id + "' has no ET.Movable interface so can not be resizable!"});
		return false;
	}
	var listenersObj = this._getRestorer().getSavedProps()["resizeListeners"] = {mousedown:function (ev) {
		return self.resizeStart(ev);
	}, hover:function (ev) {
		if (!self.isResizing() && self.canResize()) {
			self._toggleResizeCursor(ev);
		}
	}, mouseover:function (ev) {
		if (self.hasInterface("ET.Draggable")) {
			self._setCanDrag(false);
		}
	}, mouseout:function (ev) {
		if (self.hasInterface("ET.Draggable")) {
			self._setCanDrag(true);
		}
	}};
	hooks.each(function (index, hook) {
		if (!ET.isHtmlElement(hook)) {
			return;
		}
		result = true;
		if (ET.is_gecko) {
			hook.style.setProperty("-moz-user-select", "none", "");
		}
		ET.Utils.addEvent(hook, "mousedown", listenersObj.mousedown);
		ET.Utils.addEvent(hook, "mouseover", listenersObj.mouseover);
		ET.Utils.addEvent(hook, "mouseout", listenersObj.mouseout);
	});
	if (!result) {
		if (!ET.isHtmlElement(measurement)) {
			return false;
		}
		result = true;
		ET.Utils.addEvent(measurement, "mousedown", listenersObj.mousedown);
		ET.Utils.addEvent(measurement, "mousemove", listenersObj.hover);
	}
	return result;
};
ET.Resizable._toggleResizeCursor = function (ev) {
	ev = ev || window.event;
	var el = this.getSizableMeasurement();
	var config = this.getResizeConfig();
	var oPos = ET.Utils.getMousePos(ev);
	var posX = oPos.pageX;
	var posY = oPos.pageY;
	var pos = ET.Utils.getElementOffset(el);
	var left = pos.x, right = pos.x + ET.Utils.getWidth(el);
	var top = pos.y, bottom = pos.y + ET.Utils.getHeight(el);
	var borderThickness = config.borderThickness;
	var cornerThickness = config.cornerThickness;
	function inRect(x, y, left, top, right, bottom) {
		if ((x > left) && (x < right) && (y > top) && (y < bottom)) {
			return true;
		}
		return false;
	}
	function inRange(value, minVal, maxVal) {
		if ((value > minVal) && (value < maxVal)) {
			return true;
		}
		return false;
	}
	var self = this;
	function toggleResizing(cursor) {
		el.style.cursor = cursor;
		if (self.hasInterface("ET.Draggable")) {
			self._setCanDrag((cursor === "") ? true : false);
		}
	}
	switch (true) {
	  case (inRect(posX, posY, left, top, left + borderThickness, top + borderThickness)):
		toggleResizing("nw-resize");
		break;
	  case (inRect(posX, posY, right - cornerThickness, bottom - cornerThickness, right, bottom)):
		toggleResizing("se-resize");
		break;
	  case (inRect(posX, posY, right - cornerThickness, top, right, top + borderThickness)):
		toggleResizing("ne-resize");
		break;
	  case (inRect(posX, posY, left, bottom - cornerThickness, left + cornerThickness, bottom)):
		toggleResizing("sw-resize");
		break;
	  case (inRange(posX, left, left + borderThickness)):
		toggleResizing("w-resize");
		break;
	  case (inRange(posX, right - borderThickness, right)):
		toggleResizing("e-resize");
		break;
	  case (inRange(posY, top, top + borderThickness)):
		toggleResizing("n-resize");
		break;
	  case (inRange(posY, bottom - borderThickness, bottom)):
		toggleResizing("s-resize");
		break;
	  default:
		toggleResizing("");
		break;
	}
	el.style.cursor = this._correctDirection(el.style.cursor);
	if (el.style.cursor == "") {
		if (this.hasInterface("ET.Draggable")) {
			this._setCanDrag(true);
		}
	}
};
ET.Resizable._correctDirection = function (direction) {
	var config = this.getResizeConfig();
	direction = direction.replace("-resize", "");
	for (var i = 0; i < direction.length; ++i) {
		switch (direction.charAt(i)) {
		  case "n":
			if (!/(all|vertical|top)/.test(config.direction)) {
				direction = direction.replace("n", "");
			}
		  case "s":
			if (!/(all|vertical|bottom)/.test(config.direction)) {
				direction = direction.replace("s", "");
			}
		  case "w":
			if (!/(all|horizontal|left)/.test(config.direction)) {
				direction = direction.replace("w", "");
			}
		  case "e":
			if (!/(all|horizontal|right)/.test(config.direction)) {
				direction = direction.replace("e", "");
			}
		}
	}
	if (direction != "") {
		return direction + "-resize";
	}
	return "";
};
ET.Resizable.resizeStart = function (ev, deb) {
	if (!this.canResize()) {
		return true;
	}
	ev = ev || window.event;
	var iButton = ev.button || ev.which;
	if (iButton > 1) {
		return true;
	}
	var self = this;
	var config = this.getResizeConfig();
	var target = ev.currentTarget || ev.srcElement;
	while (target != document.body && target.style.cursor.indexOf("resize") == -1) {
		target = target.parentNode;
	}
	if (target.style.cursor.indexOf("resize") == -1) {
		return true;
	}
	var direction = this._correctDirection(target.style.cursor);
	if (direction == "") {
		return true;
	}
	if (this.fireEvent("beforeResizeInit", ev) === false) {
		return true;
	}
	if (ET.GlobalEvents.fireEvent("beforeResizeInit", ev, this) === false) {
		return true;
	}
	this._setResizing(true);
	this._proceedResizableElements("resizeStart");
	var oPos = ET.Utils.getMousePos(ev);
	var mouseX = oPos.pageX;
	var mouseY = oPos.pageY;
	this.makeSizable();
	this.startSizing();
	if (/(vertical|horizontal|top|left|all)/.test(config.direction)) {
		this.makeMovable();
		this.startMove();
	}
	ET.Utils.cover.show(1000001, direction, function (ev) {
		return self.resizeMove(ev);
	}, function (ev) {
		return self.resizeEnd(ev);
	});
	this._setResizingPoint(mouseX, mouseY, direction.replace("-resize", ""));
	this.fireEvent("onResizeInit", ev);
	ET.GlobalEvents.fireEvent("onResizeInit", ev, this);
	if (config.stopEvent) {
		return ET.Utils.stopEvent(ev);
	} else {
		return true;
	}
};
ET.Resizable.resizeMove = function (ev) {
	if (!this.isResizing()) {
		return true;
	}
	ev = ev || window.event;
	if (this.fireEvent("beforeResize", ev) === false) {
		return true;
	}
	if (ET.GlobalEvents.fireEvent("beforeResize", ev, this) === false) {
		return true;
	}
	var oPos = ET.Utils.getMousePos(ev);
	var x = oPos.pageX;
	var y = oPos.pageY;
	var movePoint = this.getResizingPoint();
	var direction = ET.Utils.cover.style.cursor;
	direction = direction.replace("-resize", "");
	if (direction.indexOf("w") > -1) {
		var width = this.getWidth();
		this.setWidth(width + (movePoint.x - x));
		if (width != this.getWidth()) {
			this.moveFor(width - this.getWidth(), null);
		}
	}
	if (direction.indexOf("e") > -1) {
		this.setWidth(this.getWidth() + (x - movePoint.x));
	}
	if (direction.indexOf("n") > -1) {
		var height = this.getHeight();
		this.setHeight(height + (movePoint.y - y));
		if (height != this.getHeight()) {
			this.moveFor(null, height - this.getHeight());
		}
	}
	if (direction.indexOf("s") > -1) {
		this.setHeight(this.getHeight() + (y - movePoint.y));
	}
	this._setResizingPoint(x, y, direction);
	this.fireEvent("onResize", ev);
	ET.GlobalEvents.fireEvent("onResize", ev, this);
	return ET.Utils.stopEvent(ev);
};
ET.Resizable.resizeEnd = function (ev) {
	if (!this.isResizing()) {
		return true;
	}
	ev = ev || window.event;
	var self = this;
	var config = this.getResizeConfig();
	if (this.fireEvent("beforeResizeEnd", ev) === false) {
		return true;
	}
	if (ET.GlobalEvents.fireEvent("beforeResizeEnd", ev, this) === false) {
		return true;
	}
	this._proceedResizableElements("resizeEnd");
	ET.Utils.cover.hide();
	this._setResizingPoint(null, null);
	this._setResizing(false);
	this.endSizing();
	if (/(vertical|horizontal|top|left|all)/.test(config.direction)) {
		this.endMove();
	}
	this.fireEvent("onResizeEnd", ev);
	ET.GlobalEvents.fireEvent("onResizeEnd", ev, this);
	return ET.Utils.stopEvent(ev);
};
ET.Resizable.restoreOfResize = function () {
	var config = this.getResizeConfig();
	this.restoreOfSizing();
	if (/(vertical|horizontal|top|left|all)/.test(config.direction)) {
		this.restoreOfMove();
	}
	var hooks = ET.Array(this._getResizableHooks());
	var self = this;
	var result = false;
	var listenersObj = this._getRestorer().getSavedProps()["resizeListeners"];
	hooks.each(function (index, hook) {
		if (!ET.isHtmlElement(hook)) {
			return;
		}
		result = true;
		if (ET.is_gecko) {
			hook.style.setProperty("-moz-user-select", "", "");
		}
		ET.Utils.removeEvent(hook, "mousedown", listenersObj.mousedown);
		ET.Utils.removeEvent(hook, "mouseover", listenersObj.mouseover);
		ET.Utils.removeEvent(hook, "mouseout", listenersObj.mouseout);
	});
	if (!result) {
		var measurement = this.getSizableMeasurement();
		if (!ET.isHtmlElement(measurement)) {
			return false;
		}
		if (listenersObj) {
			ET.Utils.removeEvent(measurement, "mousedown", listenersObj.mousedown);
			ET.Utils.removeEvent(measurement, "mousemove", listenersObj.hover);
		}
	}
	return true;
};
ET.Resizable._getResizableHooks = function () {
	if (this.getContainer) {
		return this.getContainer();
	} else {
		return null;
	}
};
ET.Resizable.isResizing = function () {
	return this.resizing;
};
ET.Resizable.canResize = function () {
	return this.canResize;
};
ET.Resizable._setCanResize = function (on) {
	this.canResize = on;
};
ET.Resizable.getResizeConfig = function () {
	return this.getConfiguration();
};
ET.Resizable.setResizeConfig = function (config) {
	this.reconfigure(config);
};
ET.Resizable._setResizing = function (on) {
	this.resizing = on;
};
ET.Resizable._handleSizeOverflow = function (limit, dimension) {
	if (!this.isResizing()) {
		ET.Sizable._handleSizeOverflow.call(this, limit, dimension);
	}
	return limit;
};
ET.Resizable._getRestorer = function () {
	if (!this.restorer || this.restorer.constructor != ET.SRProp) {
		this.restorer = new ET.SRProp(this);
	}
	return this.restorer;
};
ET.Resizable._proceedResizableElements = function (resizeState) {
	var config = this.getResizeConfig(), copy = null, measurement = null, self = this;
	switch (config.method) {
	  case "copy":
		if (resizeState == "resizeStart") {
			var measurement = this.getSizableMeasurement();
			if (!ET.isHtmlElement(measurement)) {
				return false;
			}
			copy = measurement.cloneNode(false);
			measurement.parentNode.insertBefore(copy, measurement);
			this._getRestorer().saveProp("getSizableElements");
			this.getSizableElements = function () {
				return copy;
			};
			this._getRestorer().saveProp("getSizableMeasurement");
			this.getSizableMeasurement = function () {
				return copy;
			};
			if (/(vertical|horizontal|top|left|all)/.test(config.direction)) {
				this._getRestorer().saveProp("getMovableElements");
				this.getMovableElements = function (resetArray) {
					return copy;
				};
				this._getRestorer().saveProp("getMovableMeasurement");
				this.getMovableMeasurement = function () {
					return copy;
				};
			}
		} else {
			if (resizeState == "resizeEnd") {
				copy = this.getMovableElements();
				var width = this.getWidth();
				var height = this.getHeight();
				var pos = null;
				if (/(vertical|horizontal|top|left|all)/.test(config.direction)) {
					pos = this.getPosition();
				}
				copy.parentNode.removeChild(copy);
				this._getRestorer().restoreProp("getSizableElements");
				this._getRestorer().restoreProp("getSizableMeasurement");
				this._getRestorer().restoreProp("getMovableElements");
				this._getRestorer().restoreProp("getMovableMeasurement");
				this.setWidth(width);
				this.setHeight(height);
				if (pos) {
					this.setPosition(pos.x, pos.y);
				}
			}
		}
		break;
	  default:
		break;
	}
};
ET.Resizable._setResizingPoint = function (x, y, direction) {
	var resizingPoint = this._getResizingPointObject();
	if (x === null || y === null) {
		resizingPoint.x = null;
		resizingPoint.y = null;
		resizingPoint.offsetX = null;
		resizingPoint.offsetY = null;
		return;
	}
	if (resizingPoint.x === null || resizingPoint.y === null) {
		resizingPoint.x = x;
		resizingPoint.y = y;
		var width = this.getWidth();
		var height = this.getHeight();
		if (direction.match(/(n|w)/)) {
			var pos = this.getScreenPosition();
		}
		if (direction.indexOf("n") != -1) {
			resizingPoint.offsetY = y - pos.y;
		}
		if (direction.indexOf("w") != -1) {
			resizingPoint.offsetX = x - pos.x;
		}
		if (direction.indexOf("e") != -1) {
			resizingPoint.offsetX = x - width;
		}
		if (direction.indexOf("s") != -1) {
			resizingPoint.offsetY = y - height;
		}
		resizingPoint.offsetX = resizingPoint.offsetX || 0;
		resizingPoint.offsetY = resizingPoint.offsetY || 0;
	} else {
		var diffX = 0;
		var diffY = 0;
		var width = this.getWidth();
		var height = this.getHeight();
		if (direction.match(/(n|w)/)) {
			var pos = this.getScreenPosition();
		}
		if (direction.indexOf("n") != -1) {
			diffY = pos.y;
		}
		if (direction.indexOf("w") != -1) {
			diffX = pos.x;
		}
		if (direction.indexOf("e") != -1) {
			diffX = width;
		}
		if (direction.indexOf("s") != -1) {
			diffY = height;
		}
		resizingPoint.x = diffX + resizingPoint.offsetX;
		resizingPoint.y = diffY + resizingPoint.offsetY;
	}
	return;
};
ET.Resizable.getResizingPoint = function () {
	var resizingPoint = this._getResizingPointObject();
	return {x:resizingPoint.x, y:resizingPoint.y};
};
ET.Resizable._getResizingPointObject = function () {
	if (!this.resizingPoint || typeof this.resizingPoint != "object") {
		this.resizingPoint = {x:null, y:null, offsetX:null, offsetY:null};
	}
	return this.resizingPoint;
};
ET.Utils.Resizable = function (config) {
	ET.Utils.Resizable.SUPERconstructor.call(this, config);
};
ET.Utils.Resizable.id = "ET.Utils.Resizable";
ET.inherit(ET.Utils.Resizable, ET.Utils.Sizable);
ET.implement(ET.Utils.Resizable, "ET.Movable");
ET.implement(ET.Utils.Resizable, "ET.Resizable");
ET.Utils.Resizable.prototype.init = function (config) {
	ET.Utils.Resizable.SUPERclass.init.call(this, config);
	this.restoreOfSizing();
	this.makeResizable();
};
ET.Utils.Resizable.prototype.configure = function (config) {
	this.defineConfigOption("method", "self");
	this.defineConfigOption("stopEvent", true);
	this.defineConfigOption("handlers", null);
	this.defineConfigOption("borderThickness", 10);
	this.defineConfigOption("cornerThickness", 10);
	this.defineConfigOption("direction", "all");
	ET.Utils.Resizable.SUPERclass.configure.call(this, config);
	config = this.getConfiguration();
	config.handlers = ET.Array(config.handlers);
	config.handlers.each(function (index, handler) {
		handler = ET.Widget.getElementById(handler);
		handler = ET.Utils.img2div(handler);
		config.handlers[index] = handler;
	});
};
ET.Utils.Resizable.prototype.reconfigure = function (config) {
	ET.Utils.Resizable.SUPERclass.reconfigure.call(this, config);
};
ET.Utils.Resizable.prototype._getResizableHooks = function () {
	return this.getConfiguration().handlers;
};
ET.Modal = function (config) {
	if (arguments.length == 0) {
		config = {};
	}
	this.visible = false;
	ET.Modal.SUPERconstructor.call(this, config);
};
ET.Modal.id = "ET.Indicator";
ET.inherit(ET.Modal, ET.Widget);
ET.Modal.prototype.init = function (config) {
	ET.Modal.SUPERclass.init.call(this, config);
};
ET.Modal.prototype.configure = function (config) {
	this.defineConfigOption("zIndex", 1000);
	this.defineConfigOption("x", null);
	this.defineConfigOption("y", null);
	this.defineConfigOption("width", null);
	this.defineConfigOption("height", null);
	this.defineConfigOption("container", window);
	this.defineConfigOption("fixed", false);
	this.defineConfigOption("themePath", ET.etPath + "./themes/indicator/");
	ET.Modal.SUPERclass.configure.call(this, config);
	config = this.getConfiguration();
	if (config.container != window) {
		config.x = null;
		config.y = null;
		config.width = null;
		config.height = null;
		config.fixed = false;
	}
};
ET.Modal.prototype.create = function () {
	var config = this.getConfiguration();
	config.container = ET.Widget.getElementById(config.container) || window;
	this.WCH = ET.Utils.createWCH();
	if (ET.is_ie && !ET.Utils.isWindowLoaded() && document.readyState != "interactive") {
		document.write("<div id=\"zpModalContainer\"></div>");
		this.container = document.getElementById("zpModalContainer");
	} else {
		this.container = ET.Utils.createElement("div", document.body);
	}
	this.container.className = this.getClassName({prefix:"zpModal" + (ET.is_opera ? "Opera" : "")});
	var st = this.container.style;
	st.display = "none";
	st.position = "absolute";
	st.zIndex = config.zIndex;
};
ET.Modal.prototype.show = function (zIndex) {
	if (!this.container) {
		this.create();
	}
	zIndex = zIndex || this.config.zIndex;
	this.container.style.zIndex = zIndex;
	if (this.WCH) {
		this.WCH.style.visibility = "";
		this.WCH.style.zIndex = zIndex - 1;
	}
	this.container.style.display = "block";
	this.visible = true;
	var config = this.getConfiguration();
	if (config.container != window) {
		var self = this;
		var update = function () {
			self.update();
		};
		if (!this.interval) {
			this.interval = setInterval(update, 100);
		}
		this.update();
	} else {
		var dim = ET.Utils.getWindowSize();
		var width = config.width || dim.width;
		var height = config.height || dim.height;
		var x = config.x || ET.Utils.getPageScrollX();
		var y = config.y || ET.Utils.getPageScrollY();
		this.setWidth(width);
		this.setHeight(height);
		this.setPosition(x, y);
	}
	if (this.config.fixed == true) {
		ET.FixateOnScreen.register(this.container);
		if (this.WCH) {
			ET.FixateOnScreen.register(this.WCH);
		}
	}
};
ET.Modal.prototype.update = function () {
	var config = this.getConfiguration();
	if (config.container != window && this.visible) {
		var offs = ET.Utils.getElementOffset(config.container);
		this.setWidth(offs.width);
		this.setHeight(offs.height);
		this.setPosition(offs.x, offs.y);
	}
};
ET.Modal.prototype.hide = function (destroy) {
	var config = this.getConfiguration();
	if (!config) {
		return;
	}
	if (config.fixed == true) {
		ET.FixateOnScreen.unregister(this.container);
		if (this.WCH) {
			ET.FixateOnScreen.unregister(this.WCH);
		}
	}
	if (config.container != window) {
		clearInterval(this.interval);
		this.interval = null;
	}
	if (this.container) {
		this.container.style.display = "none";
	}
	ET.Utils.hideWCH(this.WCH);
	if (destroy) {
		if (this.WCH) {
			if (this.WCH.outerHTML) {
				this.WCH.outerHTML = "";
			} else {
				ET.Utils.destroy(this.WCH);
			}
		}
		if (this.container.outerHTML) {
			this.container.outerHTML = "";
		} else {
			ET.Utils.destroy(this.container);
		}
		this.WCH = null;
		this.container = null;
	}
	this.visible = false;
};
ET.Modal.prototype.setWidth = function (width) {
	if (!this.container) {
		return;
	}
	if (ET.Utils.setWidth) {
		ET.Utils.setWidth(this.container, width);
		ET.Utils.setWidth(this.WCH, width);
	} else {
		this.container.style.width = width + "px";
		if (this.WCH) {
			this.WCH.style.width = width + "px";
		}
	}
};
ET.Modal.prototype.setHeight = function (height) {
	if (!this.container) {
		return;
	}
	if (ET.Utils.setHeight) {
		ET.Utils.setHeight(this.container, height);
		ET.Utils.setHeight(this.WCH, height);
	} else {
		this.container.style.height = height + "px";
		if (this.WCH) {
			this.WCH.style.height = height + "px";
		}
	}
};
ET.Modal.prototype.setPosition = function (x, y) {
	if (!this.container) {
		return;
	}
	if (ET.Utils.moveTo) {
		ET.Utils.moveTo(this.container, x, y);
		ET.Utils.moveTo(this.WCH, x, y);
	} else {
		this.container.style.left = x + "px";
		this.container.style.top = y + "px";
		if (this.WCH) {
			this.WCH.style.left = x + "px";
			this.WCH.style.top = y + "px";
		}
	}
};
ET.Indicator = function (config) {
	if (arguments.length == 0) {
		config = {};
	}
	this.active = false;
	ET.Indicator.SUPERconstructor.call(this, config);
};
ET.Indicator.id = "ET.Indicator";
ET.inherit(ET.Indicator, ET.Modal);
ET.Indicator.prototype.init = function (config) {
	ET.Indicator.SUPERclass.init.call(this, config);
};
ET.Indicator.prototype.configure = function (config) {
	this.defineConfigOption("themePath", ET.etPath + "./themes/indicator/");
	ET.Indicator.SUPERclass.configure.call(this, config);
};
ET.Indicator.prototype.create = function () {
	ET.Indicator.SUPERclass.create.call(this);
	this.indicator = ET.Utils.createElement("div", this.container);
	this.indicator.className = "zpIndicator";
	var st = this.indicator.style;
	st.position = "absolute";
	st.zIndex = this.getConfiguration().zIndex;
	st.bgColor = "#aaaaaa";
	st.fontWeight = "bold";
	st.color = "black";
};
ET.Indicator.prototype.setWidth = function (width) {
	if (!this.container) {
		return;
	}
	ET.Indicator.SUPERclass.setWidth.call(this, width);
	var left = Math.round((this.container.offsetWidth - this.indicator.offsetWidth) / 2);
	this.indicator.style.left = left + "px";
};
ET.Indicator.prototype.setHeight = function (height) {
	if (!this.container) {
		return;
	}
	ET.Indicator.SUPERclass.setHeight.call(this, height);
	var top = Math.round((this.container.offsetHeight - this.indicator.offsetHeight) / 2);
	this.indicator.style.top = top + "px";
};
ET.Indicator.prototype.hide = function (destroy) {
	if (destroy) {
		this.indicator = null;
	}
	ET.Indicator.SUPERclass.hide.call(this, destroy);
};
ET.Indicator.prototype.start = function (message) {
	this.active = true;
	if (!this.indicator) {
		this.create();
	}
	this.indicator.innerHTML = message;
	this.show();
};
ET.Indicator.prototype.stop = function () {
	this.active = false;
	this.hide(true);
};
ET.Indicator.prototype.isActive = function () {
	return this.active;
};
ET.Pane = function (objArgs) {
	this.config = {};
	if (arguments.length == 0) {
		objArgs = {};
	}
	this.widgetType = "pane";
	this.ready = false;
	this.loading = false;
	this.prepared = false;
	ET.Utils.createProperty(this, "container", null);
	ET.Utils.createProperty(this, "contentElement", null);
	ET.Utils.createProperty(this, "iframeDocument", null);
	ET.Pane.SUPERconstructor.call(this, objArgs);
};
ET.Pane.id = "ET.Pane";
ET.inherit(ET.Pane, ET.Widget);
ET.Pane.prototype.init = function (objArgs) {
	ET.Utils.createProperty(this.config, "parent", document.body);
	this.config.theme = null;
	this.config.width = null;
	this.config.height = null;
	this.config.containerType = "div";
	this.config.sourceType = null;
	this.config.source = null;
	this.config.autoContentWidth = false;
	this.config.autoContentHeight = false;
	this.config.onlyInit = false;
	this.config.showLoadingIndicator = true;
	this.config.overflow = "auto";
	this.config.iframeScrolling = null;
	this.config.removeBorder = false;
	this.config.id = null;
	ET.Pane.SUPERclass.init.call(this, objArgs);
	if (this.config.containerType == null) {
		this.config.containerType = "div";
	}
	if (!this.config.onlyInit) {
		this.create(this.config.width, this.config.height);
	}
	var self = this;
	function update() {
		if (self.loader) {
			self.loader.update();
		}
	}
	this.addEventListener("fetchSourceStart", update);
	this.addEventListener("fetchSourceEnd", update);
};
ET.Pane.prototype.prepareHtml = function () {
	if (this.config.containerType.toLowerCase() == "iframe") {
		var iframe = document.createElement("iframe");
		if (this.config.iframeScrolling) {
			iframe.scrolling = this.config.iframeScrolling;
		}
		iframe.frameBorder="0";
		iframe.scrolling = "no";
		iframe.src = ET.etPath + "blank.html#" + this.id;
		this.container = iframe;
		iframe = null;
	} else {
		if (this.config.containerType.toLowerCase() == "div") {
			this.container = document.createElement("div");
			if (this.config.id) {
				this.container.id = this.config.id;
			}
			this.contentElement = this.container;
		} else {
			if (this.config.parent && this.config.parent.nodeType == 1) {
				this.container = this.config.parent;
				this.contentElement = this.container;
			}
		}
	}
	this.prepared = true;
	if (this.config.removeBorder) {
		this.removeBorder();
	}
};
ET.Pane.prototype.create = function (width, height) {
	if (!this.prepared) {
		this.prepareHtml();
	}
	if (!(this.config.parent = ET.Widget.getElementById(this.config.parent))) {
		ET.Log({description:"No reference to parent element."});
		return null;
	}
	if (this.config.parent.requestParentFor && !(this.config.parent = this.config.parent.requestParentFor(this))) {
		ET.Log({description:"No reference to parent element after request to the Parent Widget!"});
		return null;
	}
	if (this.config.containerType.toLowerCase() == "div" || this.config.containerType.toLowerCase() == "iframe") {
		this.ready = false;
		this.config.parent.appendChild(this.container);
		if (this.config.containerType.toLowerCase() != "iframe") {
			this.initPane();
		}
	} else {
		if (this.config.containerType.toLowerCase() == "current") {
			this.container = this.config.parent;
			this.contentElement = this.container;
			this.initPane();
		} else {
			ET.Log({description:"Unknown container type: " + this.config.containerType + ". Possible values: iframe|div"});
		}
	}
	ET.Utils.addClass(this.container, this.getClassName({prefix:"zpPane"}));
	if (width || this.config.width) {
		this.setWidth(width || this.config.width);
	}
	if (height || this.config.height) {
		this.setHeight(height || this.config.height);
	}
	this.getContainer().style.display = "block";
	this.setPaneContent();
};
ET.Pane.prototype.initPane = function () {
	if (this.config.containerType.toLowerCase() == "iframe") {
		var doc = null;
		var sameDomain = true;
		var url = this.container.src;
		var anchorEl = document.createElement("a");
		var protocolSeparatorPos = url.indexOf("://");
		if (protocolSeparatorPos != -1) {
			var domainSeparatorPos = url.indexOf("/", protocolSeparatorPos + 3);
			var domain = url.substring((protocolSeparatorPos > 0 ? protocolSeparatorPos + 3 : 0), (domainSeparatorPos > 0 ? domainSeparatorPos : url.length));
			if (domain != window.location.host) {
				sameDomain = false;
			}
		}
		if (sameDomain) {
			if (this.container.contentDocument != null) {
				doc = this.container.contentDocument;
			} else {
				if (this.container.contentWindow && this.container.contentWindow.document != null) {
					doc = this.container.contentWindow.document;
				}
			}
			var self = this;
			anchorEl.href = url;
			url = anchorEl.href;
			if (doc == null || doc.body == null || (ET.is_gecko && url != this.container.contentWindow.location.href)) {
				setTimeout(function () {
					self.initPane();
				}, 50);
				return false;
			}
			this.iframeDocument = doc;
			this.contentElement = doc.body;
			if (typeof this.container.contentWindow.ET != "object" && typeof this.container.contentWindow.ET != "function") {
				this.container.contentWindow.ET = {};
				this.container.contentWindow.ET.windowLoaded = typeof (doc.readyState) != "undefined" ? (doc.readyState == "loaded" || doc.readyState == "complete") : doc.getElementsByTagName != null && typeof (doc.getElementsByTagName("body")[0]) != "undefined";
				ET.Utils.addEvent(this.container.contentWindow, "load", function () {
					self.container.contentWindow.ET.windowLoaded = true;
				}, false, false);
			}
			if (!this.container.contentWindow.ET || !this.container.contentWindow.ET.windowLoaded) {
				setTimeout(function () {
					self.initPane();
				}, 50);
				return false;
			}
			doc = null;
		}
	}
	if (this.config.overflow) {
		this.getContainer().style.overflow = this.config.overflow;
	}
	this.ready = true;
	this.fireEvent("onReady", this);
	this.hideIndicator();
	this.loading = false;
	this.removeEvent("onReady");
};
ET.Pane.prototype.getContainer = function () {
	return this.container;
};
ET.Pane.prototype.getIframeDocument = function () {
	return this.iframeDocument;
};
ET.Pane.prototype.getContentElement = function () {
	return this.contentElement;
};
ET.Pane.prototype.isReady = function () {
	return this.ready;
};
ET.Pane.prototype.loadDataJson = function (objSource) {
	return objSource != null ? this.setContent(objSource.content) : null;
};
ET.Pane.prototype.setContent = function (content) {
	if (!this.isReady()) {
		var self = this;
		setTimeout(function () {
			self.setContent(content);
		}, 50);
		return null;
	}
	this.loading = false;
	if (!this.getContentElement()) {
		this.hideIndicator();
		return false;
	}
	if (content === null) {
		this.hideIndicator();
		return null;
	} else {
		if (this.config.containerType.toLowerCase() != "iframe") {
			var oldOverflow = this.getContainer().style.overflow;
			if (this.config.autoContentWidth) {
				this.getContainer().style.overflow = "visible";
				this.getContainer().style.width = "auto";
			}
			if (this.config.autoContentHeight) {
				this.getContainer().style.overflow = "visible";
				this.getContainer().style.height = "auto";
			}
		}
		if (typeof (content) == "string") {
			ET.Transport.setInnerHtml({container:this.getContentElement(), html:content});
		} else {
			try {
				if ((ET.is_ie || ET.is_opera) && this.config.containerType.toLowerCase() == "iframe") {
					ET.Transport.setInnerHtml({container:this.getContentElement(), html:content.outerHTML});
				} else {
					if (content.parentNode != this.getContentElement()) {
						this.getContentElement().innerHTML = "";
						this.getContentElement().appendChild(content);
					}
				}
			}
			catch (ex) {
				this.hideIndicator();
				return null;
			}
		}
		if (this.config.containerType.toLowerCase() != "iframe") {
			var newWidth = this.getWidth();
			var newHeight = this.getHeight();
		} else {
			var newWidth = this.getContentElement().scrollWidth + 5;
			var newHeight = this.getContentElement().scrollHeight + 5;
		}
		if (typeof oldOverflow != "undefined") {
			this.getContainer().style.overflow = oldOverflow;
		}
		if (this.config.autoContentWidth) {
			this.setWidth(newWidth);
		}
		if (this.config.autoContentHeight) {
			this.setHeight(newHeight);
		}
	}
	this.fireEvent("contentLoaded", this);
	this.hideIndicator();
	return true;
};
ET.Pane.prototype.loadDataHtml = ET.Pane.prototype.loadDataXml = ET.Pane.prototype.setContent;
ET.Pane.prototype.loadDataHtmlText = function (content) {
	this.setContent(content);
};
ET.Pane.prototype.setWidth = function (width) {
	var self = this;
	this.fireWhenReady(function () {
		if (width >= 0) {
			self.getContainer().style.width = width + "px";
		}
		if (self.getContainer().offsetWidth != width) {
			var newWidth = width - (self.getContainer().offsetWidth - width);
			if (newWidth < 0) {
				newWidth = 0;
			}
			self.getContainer().style.width = newWidth + "px";
		}
	});
};
ET.Pane.prototype.getWidth = function () {
	return this.getContainer().offsetWidth;
};
ET.Pane.prototype.setHeight = function (height) {
	var self = this;
	this.fireWhenReady(function () {
		if (height >= 0) {
			self.getContainer().style.height = height + "px";
		}
		if (self.getContainer().offsetHeight != height) {
			var newHeight = height - (self.getContainer().offsetHeight - height);
			if (newHeight < 0) {
				newHeight = 0;
			}
			self.getContainer().style.height = newHeight + "px";
		}
	});
};
ET.Pane.prototype.getHeight = function () {
	return this.getContainer().offsetHeight;
};
ET.Pane.prototype.removeBorder = function () {
	if (this.config.containerType.toLowerCase() != "iframe") {
		return false;
	}
	var self = this;
	this.fireWhenReady(function () {
		if (!ET.is_ie) {
			self.getContainer().style.border = "none";
		} else {
			if (self.getContentElement()) {
				self.getContentElement().style.border = "none";
			}
		}
	});
};
ET.Pane.prototype.setPaneContent = function (content, type) {
	if (!content && content !== "") {
		content = this.config.source;
	}
	if (!type) {
		type = this.config.sourceType;
	}
	this.config.source = content;
	this.config.sourceType = type;
	var self = this;
	if (this.config.showLoadingIndicator) {
		this.showIndicator();
		this.loading = true;
	}
	if (this.config.containerType.toLowerCase() == "iframe" && type == "html/url") {
		this.ready = false;
		this.fireWhenReady(function () {
			if (self.getContentElement()) {
				try {
					var newWidth = self.getContentElement().scrollWidth;
					var newHeight = self.getContentElement().scrollHeight;
					if (self.config.autoContentWidth) {
						self.setWidth(newWidth);
					}
					if (self.config.autoContentHeight) {
						self.setHeight(newHeight);
					}
				}
				catch (e) {
				}
			}
			self.fireEvent("contentLoaded", self);
			if (self.events["contentLoaded"]) {
				self.events["contentLoaded"].listeners = [];
			}
		});
		this.getContainer().src = content;
		setTimeout(function () {
			self.initPane();
		}, 50);
		return true;
	}
	if (this.config.containerType.toLowerCase() == "iframe" && this.getContainer().src.indexOf((ET.etPath + "blank.html#" + this.id).replace(/\.\.\//g, "")) < 0) {
		this.ready = false;
		this.getContainer().src = ET.etPath + "blank.html#" + this.id;
	}
	this.loadData();
	return true;
};
ET.Pane.prototype.show = function () {
	this.getContainer().style.display = "";
	if (this.loading) {
		this.showIndicator();
	}
};
ET.Pane.prototype.hide = function () {
	this.getContainer().style.display = "none";
	if (this.loading) {
		this.hideIndicator();
	}
};
ET.Pane.prototype.showIndicator = function (message) {
	if (ET.Indicator) {
		this.hideIndicator();
		if (!this.loader) {
			this.loader = new ET.Indicator({container:this.container, themePath:ET.etPath + "./themes/indicator/"});
		}
		this.loader.start(message || "loading");
	}
};
ET.Pane.prototype.hideIndicator = function () {
	if (this.loader && this.loader.isActive()) {
		this.loader.stop();
	}
};
ET.Pane.prototype.fireWhenReady = function (func) {
	if (!this.isReady()) {
		this.addEventListener("onReady", func);
	} else {
		func.call(this, this);
	}
};
ET.Pane.prototype.destroy = function () {
	if (!this.config) {
		return;
	}
	this.hideIndicator();
	this.contentElement = null;
	this.iframeDocument = null;
	if (ET.is_ie && this.config.containerType.toLowerCase() == "iframe") {
		this.container.src = "javascript:void(0)";
	}
	if (this.container.outerHTML) {
		this.container.outerHTML = "";
	} else {
		ET.Utils.destroy(this.container);
	}
	this.container = null;
	this.ready = false;
	this.prepared = false;
};
ET.xmlEncodeForIE = function (str) {
	if (str == null || str == "") {
		return "";
	}
	str = str.replace(/&/g, "&amp;");
	str = str.replace(/</g, "&lt;");
	str = str.replace(/>/g, "&gt;");
	str = str.replace(/"/g, "&quot;");
	// res_str=strReplace(res_str,"'", "&acute;");
	return str;
};
ET.htmlCode4Print = function (str) {
	if (str == null || str == "") {
		return "";
	}
	str = str.replace(/\r\n/g, "<br>");
	str = str.replace(/\r/g, "<br>;");
	str = str.replace(/\n/g, "<br>");
	return str;
};

/**
* -----------------------------------------------------------------------------------------------------------------
*表格 行高亮 
*/
function on(o) {
	var colorValue = o.style.backgroundColor;
	if (colorValue != "#ffffe0"&&colorValue !="#FFFFE0"&&colorValue!="lightyellow"&&colorValue!="rgb(255, 255, 224)" ) {
		o.style.backgroundColor = "#f0f0f0";
	}
}
function off(o) {
	var colorValue = o.style.backgroundColor;
	if (colorValue!= "#ffffe0"&&colorValue !="#FFFFE0"&&colorValue!="lightyellow"&&colorValue!="rgb(255, 255, 224)" ) {
		o.style.backgroundColor = "";
	}
}
function menuon(o) {
	if (o.className!="disablePopItem") {
		o.style.color = "#ffffff";
	}
	o.style.backgroundColor = "#3593c9";
}
function menuoff(o) {
	if (o.className!="disablePopItem") {
		o.style.color = "#000000";
	}
	o.style.backgroundColor = "";
}
function togglePanel(obj) {
	var row = obj.parentElement.parentElement.parentElement.rows[1];
	if (row.style.display != "none") {
		row.style.display = "none";
		obj.src = "images/16x16/arrow_expand.gif";
	} else {
		row.style.display = "";
		obj.src = "images/16x16/arrow_close.gif";
	}
}
ET.toggleFormTitlePanel=function(obj){
	var div=jQuery(obj);
	var row=div.closest('tr');
	var img=div.find('.toogleFormImg');
	var table=row.closest('table');
	var nextAllRow=row.nextAll('tr');
	var allFormTitleRow=table.find('.formTitleRow');
	var titleIndex=allFormTitleRow.index(div);
	var findRowJQuery=null;
	if(titleIndex<allFormTitleRow.size()-1){
		findRowJQuery=allFormTitleRow.eq(titleIndex+1).closest('tr');
	}else{
		findRowJQuery=null;
	}
	var findRow=findRowJQuery==null?null:findRowJQuery.get(0);
	var currentOpen=!img.hasClass('toogleFormImgClose');
	var display=currentOpen?"none":"";
	nextAllRow.each(function(index,el){
		if(el!=findRow){
			el.style.display=display;
		}else{
			return false;
		}
	})
	img.toggleClass('toogleFormImgClose');
};
function togglePanelNew(obj){
	var div=obj;
	var contentDIV=div.parentNode.nextSibling;
	var img=obj.rows[0].cells[0].firstChild;//  jQuery(div).find('.toogleFormImg');
	var currentOpen=!ET.Utils.hasClass(img,'toogleFormImgClose');
	var display=currentOpen?"none":"block";
	if(currentOpen){
		ET.Utils.addClass(img,'toogleFormImgClose');
	}else{
		ET.Utils.removeClass(img,'toogleFormImgClose');
	}
	contentDIV.style.display=display;
} 
function changeParent(obj) {
	if (obj.checked) {
		obj.parentElement.children[0].value = "1";
	} else {
		obj.parentElement.children[0].value = "0";
	}
}

function getSelectedCheckboxNum(BoxName) {
	var theNum = 0;
	var TheCheckboxes = document.getElementsByName(BoxName);
	for (var i = 0; i < TheCheckboxes.length; i++) {
		if (TheCheckboxes[i].checked) {
			theNum++;
		}
	}
	return theNum;
}
function getArray(obName) {
	var oRet;
	if (obName != null && (typeof (obName) == "object"||typeof (obName) == "function") && typeof (obName.name) == "undefined" && typeof (obName.length) != "undefined") {
		var count = obName.length;
		oRet = new Array(count);
		for (var i = 0; i < count; i++) {
			oRet[i] = obName[i];
		}
	} else {
		if (obName != null && typeof (obName) == "object") {
			oRet = new Array(1);
			oRet[0] = obName;
		} else {
			oRet = new Array(0);
		}
	}
	return oRet;
}
function selectAll(focusField, obName) {
	var parm = getArray(obName);
	for (var i = 0; i < parm.length; i++) {
		if (parm[i].disabled != true) {
			parm[i].checked = focusField.checked;
		}
	}
}
function clear(obj) {
	l = obj.length;
	for (i = 0; i < l; i++) {
		obj.options[0] = null;
	}
}
function getCheckedCount(frm, name) {
	var checkedCount = 0;
	for (i = 0; i < frm.elements.length; i++) {
		if (frm.elements[i].type == "checkbox" && frm.elements[i].name == name && frm.elements[i].checked == true) {
			checkedCount++;
		}
	}
	return checkedCount;
}

function checkSpecificChar(fieldValue) {
	var specificChars = /%|\?|:|\&|\<|\>|\\|\'|\"|\||\//g;
	var reg=/^\./g;
   	return !(specificChars.test(fieldValue)||reg.test(fieldValue)); 
}
function checkFromDate(fromObj, toObj, str) {
	if (typeof fromObj == "undefined" || typeof toObj == "undefined") {
		return true;
	}
	var fromDate = fromObj.value;
	var toDate = toObj.value;
	if (fromDate != "" && toDate != "") {
		var f = new Date(fromDate.substring(5, 10) + "-" + fromDate.substring(0, 4));
		var t = new Date(toDate.substring(5, 10) + "-" + toDate.substring(0, 4));
		if (t.getTime() < f.getTime()) {
			alert(str);
			gotoFocus(toObj);
			return false;
		}
	}
	return true;
}
function setReadOnly() {
	var len = document.all.length;
	for (i = 0; i < len; i++) {
		elem = document.all[i];
		if (elem.tagName.toUpperCase() == "INPUT") {
			if (elem.type.toUpperCase() == "TEXT") {
				elem.readOnly = true;
				elem.onclick = "";
				elem.ondblclick = "";
				elem.onblur = "";
				//elem.style.bgColor='#E3E3E3';
			} else {
				if (elem.type.toUpperCase() == "BUTTON" && elem.name != "editButton" && elem.name != "closeButton" && elem.name != "view" && elem.name != "printableView" && elem.name != "enableButton" && elem.name != "masterView") {
					elem.disabled = true;
				} else {
					if (elem.type.toUpperCase() == "CHECKBOX") {
						elem.disabled = true;
					}
				}
			}
		} else {
			if (elem.tagName.toUpperCase() == "SELECT") {
				elem.disabled = true;
			}
		}
	}
}
/**
* This function is to get if all necessary inputs have been inputted.
* Please give the NecessaryInput a property named "altStr".This property will be alert when it has not been inputed.
* For Example, 
*   This is a necessary input:<input altStr="Name">
*   This is not a necessary input:<input altStr="Name">
*/
function getArray1(elements, name) {
	var iCount = 0;
	var oRet = new Array();
	for (var i = 0; i < elements.length; i++) {
		if (elements[i].name == name) {
			oRet[iCount] = elements[i];
			iCount++;
		}
	}
	return oRet;
}
function gotoFocus(obj) {
	if (obj.type != "hidden" && obj.style.display != "none" && obj.parentElement.style.display != "none") {
		obj.focus();
		if(obj.type.search(/select/) == -1) {
			obj.select();
		}
	}
}
function checkAllNecessaryFormInputs(formObj, charset) {
	if (formObj == null) {
		formObj = document.forms[0];
	}
	var elements = formObj.elements;
	for (var i = 0; i < elements.length; i++) {
		if (elements[i].type == "checkbox" || elements[i].type == "radio") {
			var iNum = 0;
			var oList = getArray1(elements, elements[i].name);
			for (var j = 0; j < oList.length; j++) {
				if (oList[j].checked) {
					iNum++;
				}
			}
			var inputStr=elements[i];
			
			if ((elements[i].getAttribute("altStr") != undefined && elements[i].getAttribute("altStr") != "") && (iNum == 0) && (elements[i].disabled == false || elements[i].disabled == undefined)) {
				if (charset == "EN") {
					alert("Please input: " + elements[i].getAttribute("altStr") + "!");
				} else {
					if (charset == "GB") {
						alert("\u8bf7\u8f93\u5165" + elements[i].getAttribute("altStr") + "!");
					}
				}
				gotoFocus(elements[i]);
				return false;
			}
		} else {
			var inputStr=elements[i];
			/*****这里特殊处理表单 OPEX需求那种***/
			var wfTableDIV= document.getElementById("wfTableDIV");
			if((inputStr.name=="operatorName" ||inputStr.name=="actPlanenddate" ||inputStr.name=="actActualenddate") && wfTableDIV!=null&&wfTableDIV.clientHeight==0 ){
				continue;
			}
			
			if ((elements[i].getAttribute("altStr") != undefined && elements[i].getAttribute("altStr") != "") && ((/^\s*$/g).test(elements[i].value)) && (elements[i].disabled == false || elements[i].disabled == undefined)) {
				if (charset == "EN") {
					alert("Please input: " + elements[i].getAttribute("altStr") + "!");
				} else {
					if (charset == "GB") {
						alert("\u8bf7\u8f93\u5165" + elements[i].getAttribute("altStr") + "!");
					}
				}
				gotoFocus(elements[i]);
				return false;
			}
		}
		if (elements[i].getAttribute("contentType") != undefined && elements[i].getAttribute("contentType") != "" && (/D/g).test(elements[i].getAttribute("contentType"))) {
			if (checkDateInput(charset, elements[i]) == false) {
				return false;
			}
		}else if(elements[i].getAttribute("contentType") != undefined && elements[i].getAttribute("contentType") != "" && 'url'==elements[i].getAttribute("contentType")) {
			if (checkUrlInput(charset, elements[i]) == false) {
				return false;
			}
		} else {
			if (elements[i].getAttribute("contentType") != undefined && elements[i].getAttribute("contentType") != "" && (/N\d/g).test(elements[i].getAttribute("contentType"))) {
				if ((/(\-|\+)?N\d/g).test(elements[i].getAttribute("contentType"))) {
					if ((/\-/g).test(elements[i].getAttribute("contentType"))) {
						var iNum = elements[i].getAttribute("contentType").substr(2, 10).split(".");
						if (iNum.length > 1) {
							if (checkNumberInput(charset, elements[i], true, false, iNum[0], iNum[1]) == false) {
								return false;
							}
						} else {
							if (checkNumberInput(charset, elements[i], true, false, iNum[0]) == false) {
								return false;
							}
						}
					} else {
						if ((/\+/g).test(elements[i].getAttribute("contentType"))) {
							var iNum = elements[i].getAttribute("contentType").substr(2, 10).split(".");
							if (iNum.length > 1) {
								if (checkNumberInput(charset, elements[i], false, true, iNum[0], iNum[1]) == false) {
									return false;
								}
							} else {
								if (checkNumberInput(charset, elements[i], false, true, iNum[0]) == false) {
									return false;
								}
							}
						} else {
							var iNum = elements[i].getAttribute("contentType").substr(1, 10).split(".");
							if (iNum.length > 1) {
								if (checkNumberInput(charset, elements[i], false, false, iNum[0], iNum[1]) == false) {
									return false;
								}
							} else {
								if (checkNumberInput(charset, elements[i], false, false, iNum[0]) == false) {
									return false;
								}
							}
						}
					}
				}
			} else {
				if (elements[i].type == "textarea") {
					if (checkTextAreaInput(charset, elements[i]) == false) {
						return false;
					}
				}
			}
		}
	}
	return true;
}
function checkAllNecessaryInputs(formObj, charset) {
	if (formObj == null) {
		formObj = document.forms[0];
	}
	var firstField = null;
	var sAlert = "";
	var elements = formObj.elements;
	for (var i = 0,j= elements.length;i<j; i++) {
		if ((elements[i].getAttribute("altStr") != undefined && elements[i].getAttribute("altStr") != "") && ((/^\s*$/g).test(elements[i].value)) && (elements[i].disabled == false || elements[i].disabled == undefined)) {
			sAlert += elements[i].getAttribute("altStr");
			if (firstField == null) {
				firstField = elements[i];
			}
			break;
		}
	}
	if (firstField != null) {
		if (charset == "EN") {
			alert("Please input: " + sAlert + ".");
		} else {
			if (charset == "GB") {
				alert("\u8bf7\u8f93\u5165" + sAlert + ".");
			}
		}
		gotoFocus(firstField);
		return false;
	}
	for (var i = 0; i < elements.length; i++) {
		if (elements[i].getAttribute("contentType") != undefined && elements[i].getAttribute("contentType") != "" && (/D/g).test(elements[i].getAttribute("contentType"))) {
			if (checkDateInput(charset, elements[i]) == false) {
				return false;
			}
		} else {
			if (elements[i].getAttribute("contentType") != undefined && elements[i].getAttribute("contentType") != "" && (/(\-)?N\d/g).test(elements[i].getAttribute("contentType"))) {
				if ((/(\-|\+)?N\d/g).test(elements[i].getAttribute("contentType"))) {
					if ((/\-/g).test(elements[i].getAttribute("contentType"))) {
						var iNum = elements[i].getAttribute("contentType").substr(2, 10).split(".");
						if (iNum.length > 1) {
							if (checkNumberInput(charset, elements[i], true, false, iNum[0], iNum[1]) == false) {
								return false;
							}
						} else {
							if (checkNumberInput(charset, elements[i], true, false, iNum[0]) == false) {
								return false;
							}
						}
					} else {
						if ((/\+/g).test(elements[i].getAttribute("contentType"))) {
							var iNum = elements[i].getAttribute("contentType").substr(2, 10).split(".");
							if (iNum.length > 1) {
								if (checkNumberInput(charset, elements[i], false, true, iNum[0], iNum[1]) == false) {
									return false;
								}
							} else {
								if (checkNumberInput(charset, elements[i], false, true, iNum[0]) == false) {
									return false;
								}
							}
						} else {
							var iNum = elements[i].getAttribute("contentType").substr(1, 10).split(".");
							if (iNum.length > 1) {
								if (checkNumberInput(charset, elements[i], false, false, iNum[0], iNum[1]) == false) {
									return false;
								}
							} else {
								if (checkNumberInput(charset, elements[i], false, false, iNum[0]) == false) {
									return false;
								}
							}
						}
					}
				}
			} else {
				if (elements[i].type == "textarea") {
					if (checkTextAreaInput(charset, elements[i]) == false) {
						return false;
					}
				}
			}
		}
	}
	return true;
}
function checkTextAreaInput(charset, inputObj) {
	var value = inputObj.value;
	var str = "";
	if (charset == "EN") {
		str = "Input data length can not be more than ";
	} else {
		str = "\u8f93\u5165\u6570\u636e\u957f\u5ea6\u4e0d\u80fd\u8d85\u8fc7 ";
	}
	if (inputObj.getAttribute("maxlength") == undefined) {
		return true;
	}
	var length = parseInt(inputObj.getAttribute("maxlength"));
	if (value != null && value.length > length) {
		str += length + ".";
		alert(str);
		gotoFocus(inputObj);
		return false;
	}
	return true;
}
/**
*canMinus ??ˉ??|??ˉ??￥??oè′?,
*onlyPlus ??ˉ??|????????o?-￡
*/
function checkNumberInput(charset, inputObj, canMinus, onlyPlus, len, precision) {
	if (len == null) {
		len = 10;
	}//For default 
	if (precision == null) {
		precision = 0;
	}//For default
	var value = inputObj.value;
	var str = "";
	if (charset == "EN") {
		str = "Please input a number as format: ";
	} else {
		if (charset == "GB") {
			str = "\u8bf7\u6309\u4ee5\u4e0b\u683c\u5f0f\u8f93\u5165\u6570\u5b57: ";
		}
	}
	for (var i = 0; i < len - precision; i++) {
		str += "X";
	}
	if (precision > 0) {
		str += ".";
		for (var i = 0; i < precision; i++) {
			str += "X";
		}
		str += "!";
	} else {
		if (precision == 0) {
			if (charset == "EN") {
				str = "Please input an integer.";
			} else {
				if (charset == "GB") {
					str = "\u8bf7\u8f93\u5165" + len + "\u4f4d\u6574\u6570!";
				}
			}
		}
	}
	if (value == "") {
		return true;
	}
	if (isNaN(value) || (/[x\s]/g).test(value)) {
		alert(str);
		gotoFocus(inputObj);
		return false;
	} else {
		if ((precision == 0) && ((/\./g).test(value))) {
			alert(str);
			gotoFocus(inputObj);
			return false;
		} else {
			if ((precision == 0) && (value.length > len)) {
				alert(str);
				gotoFocus(inputObj);
				return false;
			} else {
				if (precision > 0) {
					if ((value.split(".")[0].length > len - precision) || (value.split(".")[1] != null) && (value.split(".")[1].length > precision)) {
						alert(str);
						gotoFocus(inputObj);
						return false;
					}
				}
			}
		}
	}
	if (!canMinus) {
		if ((/\-/g).test(value)) {
			if (charset == "GB") {
				alert("\u8bf7\u8f93\u5165\u4e00\u4e2a\u4e0d\u5c0f\u4e8e0\u7684\u6570!");
			} else {
				alert("Please input a number not less than 0 !");
			}
			gotoFocus(inputObj);
			return false;
		}
	}
	if (onlyPlus) {
		var num = parseFloat(value);
		if (num <= 0) {
			if (charset == "GB") {
				alert("\u8bf7\u8f93\u5165\u4e00\u4e2a\u5927\u4e8e0\u7684\u6570!");
			} else {
				alert("Please input a number greater than 0 !");
			}
			gotoFocus(inputObj);
			return false;
		}
	}
	return true;
}
/**
*canMinus ??ˉ??|??ˉ??￥??oè′?,
*onlyPlus ??ˉ??|????????o?-￡
*/
function checkNumberInput1(inputObj, canMinus, onlyPlus, len, precision) {
	if (len == null) {
		len = 10;
	}//For default 
	if (precision == null) {
		precision = 0;
	}//For default
	var value = inputObj.value;
	if (value == "") {
		return true;
	}
	if (isNaN(value) || (/[x\s]/g).test(value)) {
		return false;
	} else {
		if ((precision == 0) && ((/\./g).test(value))) {
			return false;
		} else {
			if ((precision == 0) && (value.length > len)) {
				return false;
			} else {
				if (precision > 0) {
					if ((value.split(".")[0].length > len - precision) || (value.split(".")[1] != null) && (value.split(".")[1].length > precision)) {
						return false;
					}
				}
			}
		}
	}
	if (!canMinus) {
		if ((/\-/g).test(value)) {
			return false;
		}
	}
	if (onlyPlus) {
		var num = parseFloat(value);
		if (num <= 0) {
			return false;
		}
	}
	return true;
}
/**
 * This function is to check url input
 */
function checkUrlInput(charset,inputObj){
	
	var value=inputObj.value;
	if(value==""){
		return true;
	}
 	var strRegex = "^((https|http|ftp|rtsp|mms)?://)" 
  	 	+ "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp的user@ 
          + "(([0-9]{1,3}\.){3}[0-9]{1,3}" // IP形式的URL- 199.194.52.184 
          + "|" // 允许IP和DOMAIN（域名）
          + "([0-9a-z_!~*'()-]+\.)*" // 域名- www. 
          + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\." // 二级域名 
          + "[a-z]{2,6})" // first level domain- .com or .museum 
          + "(:[0-9]{1,4})?" // 端口- :80 
          + "((/?)|" // a slash isn't required if there is no file name 
          + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$" ; 
    var re=new RegExp(strRegex);     
    if(re.test(value)){
    	return true;
    }else{
    	var pleaseInputADateStr = "";
    	if (charset == "EN") {
			pleaseInputADateStr = "Please input a url !";
		} else {
			if (charset == "GB") {
			pleaseInputADateStr = "\u8bf7\u6309\u4ee5\u4e0b\u683c\u5f0f\u8f93\u5165\u65e5\u671f!";
		}
    	alert(pleaseInputADateStr);
    	gotoFocus(inputObj);
    	return false;
    }
	
    }
}
/**
* This function is to check Date input.
*/
function checkDateInput(charset, inputObj) {
	var value=inputObj.value;
	if(value==""){
		return true;
	}
	var contentType = inputObj.getAttribute("contentType");
	var showHour;
	var format;
	var reg;
	if ((/0$/g).test(contentType) || (/1$/g).test(contentType)) {
		showHour=true;
		format = "yyyy-MM-dd HH:mm";
		reg=/^\d{4}\-\d{2}\-\d{2} \d{2}:\d{2}$/g;
	}else{
		showHour=false;
		format = "yyyy-MM-dd";
		reg=/^\d{4}\-\d{2}\-\d{2}$/g;
	}
	var pleaseInputADateStr = "";
	if (charset == "EN") {
		pleaseInputADateStr = "Please input a date as format: " + format + "!";
	} else {
		if (charset == "GB") {
			pleaseInputADateStr = "\u8bf7\u6309\u4ee5\u4e0b\u683c\u5f0f\u8f93\u5165\u65e5\u671f: " + format + "!";
		}
	}
	
	if(!reg.test(value)){
		alert(pleaseInputADateStr);
		gotoFocus(inputObj);
		return false;
	}
	var year=parseInt(value.substring(0,4),10);
	var month=parseInt(value.substring(5,7),10);
	var day=parseInt(value.substring(8,10),10);
	if(month>12||day>31){
		alert(pleaseInputADateStr);
		gotoFocus(inputObj);
		return false;
	}
	var returnValue=true;
	if(month==4||month==6||month==9||month==11){
		if(day>30){
			returnValue=false;
		}
	}else if (month==2){
		var isLeap=false;//é?°?1′
		if(year%4==0 && year%400!=0){
			isLeap=true;
		}
		if(isLeap){
			if(day>29){
				returnValue=false;
			}
		}else{
			if(day>28){
				returnValue=false;
			}
		}
	}else{
		if(day>31){
			returnValue=false;
		}
	}
	if(!returnValue){
		alert(pleaseInputADateStr);
		gotoFocus(inputObj);
		return false;
	}
	//?ˉ1??????
	if(showHour){
		var hour=parseInt(value.substring(11,13));
		var minute=parseInt(value.substring(14,16));
		if(hour>23 || minute>59){
			alert(pleaseInputADateStr);
			gotoFocus(inputObj);
			return false;
		}
	}
	return true;
}
function checkDateInput1(inputObj) {
	var value=inputObj.value;
	if(value==""){
		return true;
	}
	var reg=/^\d{4}\-\d{2}\-\d{2}$/g;
	if(!reg.test(value)){
		return false;
	}
	var year=parseInt(value.substring(0,4),10);
	var month=parseInt(value.substring(5,7),10);
	var day=parseInt(value.substring(8,10),10);
	if(month>12||day>31){
		return false;
	}
	if(month==4||month==6||month==9||month==11){
		if(day>30){
			return false;
		}
	}else if (month==2){
		var isLeap=false;//é?°?1′
		if(year%4==0 && year%400!=0){
			isLeap=true;
		}
		if(isLeap){
			if(day>29){
				return false;
			}
		}else{
			if(day>28){
				return false;
			}
		}
	}else{
		if(day>31){
			return false;
		}
	}
	return true;
}
/**
* This function is to check No or Name input.
*/
function checkNoOrNameInput(inputObj) {
	var value = inputObj.value;
	if (value == "") {
		return true;
	}
	if (value.replace(/\w|-|\./g, "") != "") {
		alert("Please don't input any char out of a-z,A-Z,1-9,.,-,_");
		gotoFocus(inputObj);
		return false;
	}
}
/**
* This function is to check if a form has been changed.
* formObj:the checked form
* exceptObjName:the name of whitch need not be checked;
* For example:isFormChangedFun(document.frm,"ACheckbox,BRadio,CSelect");
*/
function isFormChanged(formObj, exceptObjName) {
	if (formObj == null) {
		formObj = document.forms[0];
	}
	if (exceptObjName == null) {
		exceptObjName == "";
	}
	var selectObjs = formObj.getElementsByTagName("SELECT");//For Select Obj
	for (var i = 0; i < selectObjs.length; i++) {
		if ((selectObjs[i].name == "") || (eval("/(^|,)" + selectObjs[i].name + "(,|$)/g").test(exceptObjName))) {
			continue;
		}
		for (var j = 1; j < selectObjs[i].length; j++) {
			if (selectObjs[i].options[j].defaultSelected != selectObjs[i].options[j].selected) {
				return true;
			}
		}
	}
	var inputObjs = formObj.getElementsByTagName("INPUT");//For Select Obj
	for (var i = 0; i < inputObjs.length; i++) {
		if ((inputObjs[i].name == "") || (eval("/(^|,)" + inputObjs[i].name + "(,|$)/g").test(exceptObjName))) {
			continue;
		}
		if ((inputObjs[i].type.toUpperCase() == "TEXT") && (inputObjs[i].defaultValue != inputObjs[i].value)) {
			return true;
		} else {
			if (((inputObjs[i].type.toUpperCase() == "RADIO") || (inputObjs[i].type.toUpperCase() == "CHECKBOX")) && (inputObjs[i].defaultChecked != inputObjs[i].checked)) {
				return true;
			}
		}
	}
	var textareaObjs = formObj.getElementsByTagName("TEXTAREA");//For Select Obj
	for (var i = 0; i < textareaObjs.length; i++) {
		if ((textareaObjs[i].name == "") || (eval("/(^|,)" + textareaObjs[i].name + "(,|$)/g").test(exceptObjName))) {
			continue;
		}
		if (textareaObjs[i].defaultValue != textareaObjs[i].value) {
			return true;
		}
	}
	return false;
}
function getToDayInt() {
	var vToday = new Date();
	var defaultYear = vToday.getFullYear();
	var defaultMonth = parseInt(vToday.getMonth()) + 1;
	var defaultDay = vToday.getDate();
	if (parseInt(defaultMonth) < 10) {
		defaultMonth = "0" + defaultMonth;
	}
	if (parseInt(defaultDay) < 10) {
		defaultDay = "0" + defaultDay;
	}
	var system_date = defaultYear.toString() + defaultMonth.toString() + defaultDay.toString();
	return parseInt(system_date);
}
function getInputDateInt(fieldValue) {
	if (fieldValue == "") {
		return "";
	}
	if (fieldValue.length != 10) {
		return "";
	}
	var input_date = fieldValue.substring(6, fieldValue.length) + fieldValue.substring(0, 2) + fieldValue.substring(3, 5);
	return parseInt(input_date);
}
function isBeforeOrEqualToday(focusFld) {
	var fieldValue = focusFld.value;
	if (fieldValue == "") {
		return true;
	}
	if (fieldValue.length != 10) {
		return false;
	}
	if (getInputDateInt(fieldValue) > getToDayInt()) {
		alert("Please input a date Today or Before Today in focus field.");
		focusFld.focus();
		return false;
	}
	return true;
}
function isAfterToday(focusFld) {
	var fieldValue = focusFld.value;
	if (fieldValue == "") {
		return true;
	}
	if (fieldValue.length != 10) {
		return false;
	}
	if (getInputDateInt(fieldValue) <= getToDayInt()) {
		alert("Please input a date After Today in focus field.");
		focusFld.focus();
		return false;
	}
	return true;
}
function isInOneYear(focusFld) {
	var fieldValue = focusFld.value;
	if (fieldValue == "") {
		return true;
	}
	if (fieldValue.length != 10) {
		return false;
	}
	if (getInputDateInt(fieldValue) >= (getToDayInt() + 10000)) {
		alert("Input date must be within 1 year.");
		focusFld.focus();
		return false;
	}
	return true;
}
function GetObjID(ObjName) {
	for (var ObjID = 0; ObjID < document.frm.elements.length; ObjID++) {
		if (document.frm.elements[ObjID].name == ObjName) {
			return (ObjID);
		}
	}
	return (-1);
}
function addMultiItem(fromObj, toObj) {
	var i;
	var moveArray=new Array();
	for (i = fromObj.options.length - 1; i >= 0; i--) {
		if (fromObj.options[i].selected) {
			var sCode = fromObj.options[i].value;
			var sText = fromObj.options[i].text;
			moveArray.push(new Option(sText, sCode));
			//j = toObj.length;
			//toObj.options[toObj.length] = new Option(sText, sCode);
			fromObj.options[i] = null;
		}
	}
	for(var m=moveArray.length-1;m>=0;m--){
		j = toObj.length;
		toObj.options[toObj.length] =moveArray[m];
	}
	i = fromObj.length - 1;
	if (i >= 0) {
		fromObj.options[0].selected = true;
	}
}
function deleteMultiItem(fromObj, toObj) {
	var i;
	var moveArray=new Array();
	for (i = toObj.options.length - 1; i >= 0; i--) {
		if (toObj.options[i].selected) {
			var sCode = toObj.options[i].value;
			var sText = toObj.options[i].text;
			moveArray.push(new Option(sText, sCode));
			//fromObj.options[fromObj.length] = new Option(sText, sCode);
			toObj.options[i] = null;
		}
	}
	for(var m=moveArray.length-1;m>=0;m--){
		fromObj.options[fromObj.length] =moveArray[m];
	}
	i = toObj.length - 1;
	if (i >= 0) {
		toObj.options[0].selected = true;
	}
}
function getMultiList(obj) {
	var str = "";
	var i;
	for (i = 0; i < obj.options.length; i++) {
		str += obj.options[i].value;
		if (i < obj.options.length - 1) {
			str += ",";
		}
	}
	return str;
}
function getlist(ObjName) {
	objID = GetObjID(ObjName);
	obj = document.frm.elements[objID];
	var str = "";
	for (li_i = 0; li_i < obj.options.length; li_i++) {
		if (str == "") {
			str = obj.options[li_i].value;
		} else {
			str = str + "," + obj.options[li_i].value;
		}
	}
	return str;
}
function expandTree(obj) {
	var expand = true;
	if (obj.src.search(/expanded/) != -1) {
		obj.src = obj.src.replace(/expanded/, "close");
		expand = false;
	} else {
		obj.src = obj.src.replace(/close/, "expanded");
		expand = true;
	}
	var tr=obj.parentNode;
	while(tr.tagName.toLowerCase()!='tr'){
		tr=tr.parentNode;
	}
	var OID=tr.getAttribute('OID');
	var table=tr.parentNode.parentNode;
	var rows=table.rows;
	var NodeArray = rows ,row=null;
	var iCount = 0;
	for (var i = 0,j= NodeArray.length; i<j;i++) {
		row=NodeArray[i];
		if(row.getAttribute('name')=='treeRow'){
			if(row.getAttribute('OID')==OID){
				iCount=i;
				break;
			}
		}
	}
	processChildrens(NodeArray, tr, iCount, expand);
}
function processChildrens(NodeArray, node, iCount, expand) {
	var row=null,OID=node.getAttribute('OID');
	for (var i = iCount + 1,m= NodeArray.length;i<m; i++) {
		row=NodeArray[i];
		if (row.getAttribute('parentID') ==OID) {
			var img = ET.findChildByTagName(row,"img","expandImg");
			if (expand) {
				row.style.display = "";
				if (img) {
					img.src = img.src.replace(/close/, "expanded");
				}
			} else {
				row.style.display = "none";
				if (img) {
					img.src = img.src.replace(/expanded/, "close");
				}
			}
			processChildrens(NodeArray, row, i, expand);
		}
	}
}
function compile(code) {
	var s = "";
	for (var i = 0; i < code.length; i++) {
		s += String.fromCharCode(code.charCodeAt(i) + code.length);
	}
	return s;
}
function uncompile(code) {
	var s = "";
	for (var i = 0; i < code.length; i++) {
		s += String.fromCharCode(code.charCodeAt(i) - code.length);
	}
	return s;
}
ET.ETMenu=function(sourceElment,config){
	this.config=config||{};
	this.config.resizeAble=false;
	var floatDIV=new ET.FloatDIV(sourceElment,this.config);
	this.floatDIV=floatDIV;
	this.crossObj=floatDIV.sourceElement;
	this.contentDIV=this.crossObj.children[0];
};
ET.ETMenu.prototype.hideMenu =function(){
	this.floatDIV.hide();
};
ET.ETMenu.prototype.isDisabled=function(index){
	if (this.disabledItems && this.disabledItems.length > 0) {
		for (var i = 0; i < this.disabledItems.length; i++) {
			if (this.disabledItems[i] && this.disabledItems[i].length > 0) {
				var ind = parseInt(this.disabledItems[i]) - 1;
				if (index == ind) {
					return true;
				}
			}
		}
	}
	return false;
};
ET.ETMenu.prototype.setContent=function(ctl,divWidth){
	var width = "140px";
	if(divWidth&&!isNaN(divWidth)){
		width=divWidth+"px";
	}
	var _self=this;
	var sHTML="";
	var reg=/['\"]/g;
	for (var i = 0; i < ctl.items.length; i++) {
		var item = ctl.items[i];
		if (item["type"] == "item") {
			if( item.disable==true||item.disable=="true"||this.isDisabled(i) || item["function"] == "") {
				sHTML += "<div class='NewPopmenuItem NewPopmenuItemDisable'  >";
				sHTML += item["label"] + "</div>";
			} else {
				sHTML += "<div class='NewPopmenuItem  ";
				if(item["check"]!=undefined&&(item["check"]==true||item["check"]=='true')){
					sHTML+=' ItemCheck ';
				}
				sHTML+=" ' ";
				var fun=item['function'];
				fun=fun.replace(reg,"&quot;");
				sHTML += "onclick=\"menuObj.hideMenu();menuObj.bShow = false;" + fun +"\" >";
				sHTML +=  item["label"] ;
				if(item["check"]!=undefined&& item["check"]){
					sHTML+="<img class=\"NewPopmenuItemCheckImg\" src=\""+ET.path+"/images/16x16/app-check.png\" \>";
				}
				sHTML +="</div>";
			}
		} else {
			if (item["type"] == "split") {
				sHTML += "<div style='border-bottom: 1px solid #e2e2e2;margin:5px 0px;'></div>";
			}else if(item["type"]=="text"){
				sHTML += "<div class='NewPopmenuItemText'>"+item["label"] +"</div>";
			}
		}
	}
	_self.contentDIV.innerHTML = sHTML;
};
ET.ETMenu.prototype.showMenu=function(obj){
	var _self=this;
	_self.floatDIV.sourceElement.style.display="block";
	if (_self.crossObj && _self.crossObj.style.visibility == "visible") {
		_self.floatDIV.hide();
	}
//	_self.floatDIV.sourceElement.style.width="150px";
//	_self.floatDIV.sourceElement.style.height="104px";
	var xy={x:5,y:5};
	var result=_self.floatDIV.popup(obj,xy);
	
};

ET.ETMenu.prototype.popupMenu = function (obj, ctl, disableItems, dropdown,divWidth) {
		var _self=this;
		_self.floatDIV.sourceElement.style.display="block";
		if (_self.crossObj && _self.crossObj.style.visibility == "visible") {
			_self.floatDIV.hide();
		}
		if(!disableItems){
			disableItems="";
		}
		
		this.disabledItems = disableItems.split(",");
		_self.setContent(ctl,divWidth);
		_self.contentDIV.style.height="";
		var xy={x:0,y:5};
		
		var result=_self.floatDIV.popup(obj,xy);
		
		if(result.top){
			var parseTop=parseInt(ET.Utils.getStyleProperty(_self.floatDIV.sourceElement,'top'),10);
			if(parseTop<0){
				_self.floatDIV.sourceElement.style.top="0px";
			}
			
		}else{
			var parseTop=parseInt(ET.Utils.getStyleProperty(_self.floatDIV.sourceElement,'top'),10);
			var height=_self.floatDIV.sourceElement.getBoundingClientRect().bottom;
			var bodyHeight=document.body.clientHeight;
			if(bodyHeight<height){
				_self.floatDIV.sourceElement.style.top=(parseTop-(height-bodyHeight))+"px";
				 var offsetHeight=_self.floatDIV.sourceElement.clientHeight;
				 if(bodyHeight<offsetHeight){
				 	_self.floatDIV.sourceElement.style.top="0px";
					_self.contentDIV.style.height=(bodyHeight-30)+"px";
					_self.contentDIV.style.overflowX="hidden";
					_self.contentDIV.style.overflowY="auto";
				 }
			}
		}
};

var menuObj;
function popupMenu(obj, ctl, disableItems, dropdown,divWidth) {
	if(typeof menuObj == "undefined"){
		var div=document.createElement('div');
		ET.Utils.addClass(div,'NewPopmenuContainer');
		div.innerHTML="<div class='NewPopmenuContent'></div>";
		document.body.appendChild(div);
		menuObj=new ET.ETMenu(div,{
		});
		ET.Utils.addEvent(menuObj.floatDIV.sourceElement,'click',function(event){
			window.menuObj.isCurrentClickFlag=true;
		})
	}
	menuObj.bindObj=obj;
	menuObj.popupMenu(obj, ctl, disableItems, dropdown,divWidth);
}
ET.showPopMenu=function(obj,ctl,config){
	if(typeof menuObj == "undefined"){
		var div=document.createElement('div');
		ET.Utils.addClass(div,'NewPopmenuContainer');
		div.innerHTML="<div class='NewPopmenuContent'></div>";
		document.body.appendChild(div);
		menuObj=new ET.ETMenu(div);
	}
	var config=config||{};
	var width=config.width||190;
	menuObj.setContent(ctl,width);
	var x=config.x||5;
	var y=config.y||6;
	var xy={x:x,y:y}
	menuObj.floatDIV.popup(obj,xy);
	return menuObj;
}
ET.getScrollEx=function(obj){
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
ET.getAbsoluteLocationEx=function(obj){
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

ET.disableAllButton=function(){
	var buttons=document.getElementsByName('ET_ToolbarButton');
	for(var i=0;i<buttons.length;i++){
		buttons[i].style.cursor='';
		buttons[i].onclick='';		
	}
	var labels=document.getElementsByName('ET_ToolbarButtonLabel');
	for(var i=0;i<labels.length;i++){
		labels[i].style.color='#999999';
		labels[i].onmouseover ='';
		labels[i].onmouseout='';
	}
}

//----- Left Menu --------------------------------------------------------------------------------------------------------------
ET.LeftMenu = function () {
};
function floatOn(obj){
	obj.style.visibility="visible";
}
function floatOff(obj){
	obj.style.visibility="hidden";
}
function mouseover(obj) {
	if (obj.style.backgroundColor != "lightyellow") {
		obj.style.backgroundColor = "#FFFFFF";
	}
}
function mouseout(obj) {
	obj.style.backgroundColor = "";
}



ET.initLeftMenu = function () {
	insertHtml("afterBegin",document.body,"<div id=\"subMenu\" style=\"position:absolute;visibility:hidden;z-index:999;\" menuID=\"\" class=\"leftSubMenuDIV\" onmouseover='floatOn(this)' onmouseout='floatOff(this)'></div>");
	var out = new Array();
	var outI = 0;
	var currentMenuID=ET.LeftMenu.currentMenuID+"";
	var currentSubID =ET.LeftMenu.currentSubMenuID+"";
	var length=currentMenuID.length+2;
	out[outI++] = "<h3 class=\"leftTitle\">&nbsp;&nbsp;" + ET.LeftMenu.menuName + "</h3>";
	out[outI++] = "<ul class=\"leftBoxMenu\" id=\"leftBoxMenu\">";
	for (var i = 0; i < ET.LeftMenu.menus.length; i++) {
		var menu = ET.LeftMenu.menus[i];
		out[outI++] = "<li class=\"menuItem";
		
		if(ET.LeftMenu.currentSubMenuID == menu[0] || currentSubID.substring(0,length) == menu[0]) {
			out[outI++] = " selected";
		}
		if(menu[6].length > 0) {
			out[outI++] = " second";
		}
		out[outI++] = "\" menuID=\"" + menu[0];
		out[outI++] = "\" parentID=\"" + menu[1];
		out[outI++] = "\" type=\"" + menu[5];
		out[outI++] = "\" url=\"" + ET.path + menu[2]+"\"";
		
		out[outI++] = " onMouseOver=\"";
		out[outI++] = "mouseover(this);";
		if(menu[6].length > 0) {
			out[outI++] = "popSubMenu(this);";
		}
		out[outI++] = "\"";
		out[outI++] = " onMouseOut=\"";		
		out[outI++] = "mouseout(this);";
		if(menu[6].length > 0) {
			out[outI++] = "hideSubMenu(this);";
		}
		out[outI++] = "\"";
			
		if(menu[6].length == 0) {
		 	out[outI++] = " onclick=\"changeSubMenu(this);\"";
		}
		out[outI++] = "><img src=\"" + ET.path + menu[3] + "\" >";
		out[outI++] = "<span class=\"leftMenuText\" style=\"width:160px;\">"+menu[4]+ "</span>";
		out[outI++] = "</li>";
	}
	out[outI++] = "</ul>";
	document.getElementById("leftMenu").innerHTML = out.join("");
	
	//initMenu();
}
function hideSubMenu(obj) {
	document.getElementById("subMenu").style.visibility = "hidden";
}
function getSubMenu(menuID) {
	for (var i = 0; i < ET.LeftMenu.menus.length; i++) {
		var menu = ET.LeftMenu.menus[i];
		if(menu[0] == menuID) {
			return menu[6];
		}
	}
	return null;
}
function popSubMenu(obj) {
	var menuID = obj.getAttribute("menuID");
	var subs = getSubMenu(menuID);
	var subMenu = document.getElementById("subMenu");
	if(subMenu.getAttribute("menuID") != menuID) {
		var out = new Array();
		var outI = 0;
		out[outI++] = "<ul style=\"display:block;\">";
		for (var j = 0; j < subs.length; j++) {
			var sub = subs[j];
			out[outI++] = "<li class=\"menuItem\" menuID=\"" + sub[0];
			out[outI++] = "\" parentID=\"" + sub[1];
			out[outI++] = "\" type=\"" + sub[5];
			out[outI++] = "\" subMenu=\"" +1;
			out[outI++] = "\" url=\"" + ET.path + sub[2]+"\" onMouseOver=\"mouseover(this);\" onMouseOut=\"mouseout(this);\" onclick=\"changeSubMenu(this);\">";
			out[outI++] = "<img src=\"" + ET.path + sub[3] + "\" >";
			out[outI++] = "<span class=\"leftMenuText\" style=\"width:160px;\">"+sub[4]+ "</span>";
			out[outI++] = "</li>";
		}
		out[outI++] = "</ul>";
		subMenu.innerHTML = out.join("");
		subMenu.setAttribute("menuID",menuID);
	}
	var offsetPos = obj.getBoundingClientRect();
	subMenu.style.left = (offsetPos.left+198)+"px";
	subMenu.style.top = (offsetPos.top)+"px";
	var maxHeight = document.body.offsetHeight - offsetPos.top;
	var contentUL = subMenu.childNodes[0];
	var contentHeight = (contentUL.childNodes.length*22);
	if(contentHeight > maxHeight) {
		subMenu.style.height = maxHeight+"px";
		subMenu.style.overflowY = "auto";
	}else{
		subMenu.style.height = contentHeight+"px";
	}
	subMenu.style.visibility = "visible";			
}

ET.toggleLeftEvent=[];
ET.addToggleLeftEvent=function(fun){
	ET.toggleLeftEvent.push(fun);
};
ET.dwrErrorEvent=[];
ET.addDwrErrorEvent=function(fun){
	ET.dwrErrorEvent.push(fun);
};
ET.dwrErrorFun=function(msg,exc){
	for(var i=0,j=ET.dwrErrorEvent.length;i<j;i++){
		var fun=ET.dwrErrorEvent[i];
		if(typeof(fun)=='string'){
		window.eval(fun);
	}else if(typeof(fun)=='function'){
			fun(msg,exc);
		}
	}
};
ET.changeToolbar=function(toolbarTd,flagOn,enable){
	if(flagOn){
		if(enable){
			toolbarTd.style.color="#C61140";
		}
		var img=getObject('toolbarImg',toolbarTd,'img');
		if(img!=null){
			var oldImg=img.src;
			var imgeOn=img.getAttribute('imgeOn');
			try{
				img.src=img.getAttribute('path')+"/images/16x16/"+imgeOn;
			}catch(ex){
				img.src=oldImg;
			}
		}
	}else{
		if(enable){
			toolbarTd.style.color="";
		}
		var img=getObject('toolbarImg',toolbarTd,'img');
		if(img!=null){
			var oldImg=img.src;
			var imgeOff=img.getAttribute('imgeOff');
			try{
				img.src=img.getAttribute('path')+"/images/16x16/"+imgeOff;
			}catch(ex){
				img.src=oldImg;
			}
		}
	}
};

//事件绑定函数 el-window元素,eventName事件,fn事件执行函数
function bind(el,eventName,fn) {   
	if (window.addEventListener) {   
	    el.addEventListener(eventName, fn,false);   
	} else if (window.attachEvent) {   
	    el.attachEvent("on" + eventName, fn);   
	}    
}

/**
 * where：插入位置。包括beforeBegin,beforeEnd,afterBegin,afterEnd。
 * el：用于参照插入位置的html元素对象
 * html：要插入的html代码
 */
function insertHtml(where, el, html){
    where = where.toLowerCase();
    if(el.insertAdjacentHTML){
        switch(where){
            case "beforebegin":
		        el.insertAdjacentHTML('BeforeBegin', html);
		        return el.previousSibling;
		    case "afterbegin":
		        el.insertAdjacentHTML('AfterBegin', html);
		        return el.firstChild;
		    case "beforeend":
		        el.insertAdjacentHTML('BeforeEnd', html);
		        return el.lastChild;
		    case "afterend":
		        el.insertAdjacentHTML('AfterEnd', html);
		        return el.nextSibling;
    }
    throw 'Illegal insertion point -> "' + where + '"';
        }
  var range = el.ownerDocument.createRange();
        var frag;
        switch(where){
             case "beforebegin":
        range.setStartBefore(el);
        frag = range.createContextualFragment(html);
        el.parentNode.insertBefore(frag, el);
        return el.previousSibling;
     case "afterbegin":
        if(el.firstChild){
            range.setStartBefore(el.firstChild);
            frag = range.createContextualFragment(html);
            el.insertBefore(frag, el.firstChild);
            return el.firstChild;
        }else{
            el.innerHTML = html;
            return el.firstChild;
        }
    case "beforeend":
        if(el.lastChild){
            range.setStartAfter(el.lastChild);
            frag = range.createContextualFragment(html);
            el.appendChild(frag);
            return el.lastChild;
        }else{
            el.innerHTML = html;
            return el.lastChild;
        }
    case "afterend":
        range.setStartAfter(el);
        frag = range.createContextualFragment(html);
        el.parentNode.insertBefore(frag, el.nextSibling);
        return el.nextSibling;
    }
    throw 'Illegal insertion point -> "' + where + '"';
}
ET.zIndex=100; //浮动层开始的zIndex ,每弹出一次会增加的(防止被其他的浮动层遮住了)
	ET.FloatDIV=function(sourceElement, config){
		var $this=this;
		this._isCurrentShow=false;
		this.config=config||{};	
		if( typeof sourceElement =='string'){
			sourceElement=document.getElementById(sourceElement);
		}	
		this.sourceElement=sourceElement;
		//ESC 键隐藏浮动层（好像只支持IE）
		ET.Utils.addEvent(document,'keypress',function(event){
			var event=event ? event : window.event;
			var keyCode=typeof event.keyCode == "number"?event.keyCode:event.charCode;
			if(keyCode==27){
				$this.hide(event);
				//window.console.log('document keypress hide');
			}
		});
		function showFunction(){
			//此语句是必不可少的少,否则会导致 弹出后一直是弹出的，不能点击其他的地方被关闭,确定下次点击其他的地方被关闭。。
			$this._isCurrentShow=true;
		}
		ET.Utils.addEvent(document,'click',function(event){
			var src = event.target || window.event.srcElement; 
			if( typeof(isCalenarSelf)!='undefined' &&  isCalenarSelf(src)==true){
				return;
			}
			var stop=false;
			if($this.config.bodyClickFun!=null&& typeof $this.config.bodyClickFun=='function'){
				stop=$this.config.bodyClickFun.call($this,event);
			}
			if(stop!=true){
				//alert('bodyClick==='+$this._isCurrentShow);
				if(!$this._isCurrentShow){
					$this.hide(event);
					//window.console.log('document hide');
				}
				$this._isCurrentShow=false;
				//此语句是必不可少的少,否	则会导致 弹出后一直是弹出的，不能点击其他的地方被关闭,确定下次点击其他的地方被关闭。。
			}
		});
		ET.Utils.addEvent($this.sourceElement,'click',function(event){
			//此语句是必不可少的少
			$this._isCurrentShow=true;
			//window.console.log('sourceElement click');
		});
		
		ET.Utils.addEvent(window,'resize',function(event){
			if($this.config.resizeAble!=false){
				//重新计算浮动层位置。。。
				if($this._lastTargetElement!=undefined &&$this.sourceElement.style.visibility!="hidden"){
					$this.cacluatePostion($this._lastTargetElement,$this._lastPosition);
				}else  if($this._lastpopupPosition!=undefined &&$this.sourceElement.style.visibility!="hidden"){
					$this.popupPosition($this._lastpopupPosition);
				}
			}
			
		});
	};
	/*
	 *隐藏浮动层
	 */
	ET.FloatDIV.prototype.hide=function(event){
		var $this=this;
		var hiddenTimeOut=$this.config.hiddenTimeOut||0;
		$this._hideTimeOutID=window.setTimeout(function(){
			$this._isCurrentShow=false;
			if($this.sourceElement.style.visibility!="hidden"){
				$this.sourceElement.style.visibility = "hidden";
				$this.sourceElement.style.display = "none";
				$this.sourceElement.style.left="0px";
				$this.sourceElement.style.top="0px";
				if( typeof $this.config.onHide =='function'){
					$this.config.onHide.call($this,$this.sourceElement,event);
				}
			}
		},hiddenTimeOut);
	};
	/*
	 * 将此浮动层 浮动到 targetElement 处 ,position x,y 的偏移量
	 */ 
	ET.FloatDIV.prototype.popup=function(targetElement,position){
		var $this=this;
		//存储起来，让在window resize 时 重新计算位置
		$this._lastTargetElement=targetElement;
		$this._lastPosition=position;
		if($this.sourceElement.parentNode!=document.body){
			document.body.appendChild($this.sourceElement);
		}
		$this.sourceElement.style.display="block";
		$this.sourceElement.style.position="absolute";
		$this.sourceElement.style.visibility="visible";
		$this.sourceElement.style.zIndex=ET.zIndex++;
		
		if( typeof targetElement =='string'){
			targetElement=document.getElementById(targetElement);
		}
		if( typeof $this.config.onShow =='function'){
			$this.config.onShow.call($this,$this.sourceElement);
		}
		var result=$this.cacluatePostion(targetElement,position);
		if( typeof $this.config.afterShow =='function'){
			$this.config.afterShow.call($this,$this.sourceElement);
		}
		$this._isCurrentShow=true;
		if($this._hideTimeOutID!=undefined){
			window.clearTimeout($this._hideTimeOutID);
		}
		return result;
	};
	
	/*
	 * 相对于 body 来显示弹出层。 通过position 的 left (x),right(y),top,bottom 来定位弹出层
	 */
	ET.FloatDIV.prototype.popupPosition=function(position){
		var $this=this;
		//存储起来，让在window resize 时 重新计算位置
		$this._lastpopupPosition=position;
		$this._lastTargetElement=undefined;
		if($this.sourceElement.parentNode!=document.body){
			document.body.appendChild($this.sourceElement);
		}
		$this.sourceElement.style.display="block";
		$this.sourceElement.style.position="absolute";
		$this.sourceElement.style.visibility="visible";
		$this.sourceElement.style.zIndex=ET.zIndex++;
		
		if( typeof $this.config.onShow =='function'){
			$this.config.onShow.call($this,$this.sourceElement);
		}
		if(position!=undefined&&position.x!=undefined){
			position.left=position.x;
		}
		if(position!=undefined&&position.y!=undefined){
			position.top=position.y;
		}
		if(position!=undefined&&position.left!=undefined){
			$this.sourceElement.style.left=position.left+"px";
		}else{
			$this.sourceElement.style.left="auto";
		}
		if(position!=undefined&&position.top!=undefined){
			$this.sourceElement.style.top=position.top+"px";
		}else{
			$this.sourceElement.style.top="auto";
		}
		if(position!=undefined&&position.bottom!=undefined){
			$this.sourceElement.style.bottom=position.bottom+"px";
		}else{
			$this.sourceElement.style.bottom="auto";
		}
		if(position!=undefined&&position.right!=undefined){
			$this.sourceElement.style.right=position.right+"px";
		}else{
			$this.sourceElement.style.right="auto";
		}
		if( typeof $this.config.afterShow =='function'){
			$this.config.afterShow.call($this,$this.sourceElement);
		}
		$this._isCurrentShow=true;
	};
	/*
	 * 将此浮动层层 绑定到事件 event 的发生处，通过position x,y 来调整偏移量
	 */
	ET.FloatDIV.prototype.popupEvent=function(event,position){
		var $this=this;
		var event=event ? event : window.event;
		var x=position!=undefined&&position.x!=undefined?position.x:0;
		var y=position!=undefined&&position.y!=undefined?position.y:0;
		var pageX=event.pageX||event.clientX;
		var pageY=event.pageY||event.clientY;
		$this.popupPosition({left:pageX+x,top:pageY+y});
	};
	/*
	 * 默认的的计算出 浮动层 浮动到 targetElement 处的定位算法
	 */
	ET.FloatDIV.prototype.cacluatePostion=function(targetElement,position){
		var $this=this;
		if(typeof $this.config.cacluatePostion  =='function'){
			$this.config.cacluatePostion.call($this,targetElement,position);
			return ;
		}
		var targetRect=targetElement.getBoundingClientRect();
		var documentHeight=0;
		var documentWidth=0;
		if(document.compatMode=='CSS1Compat'){
			documentHeight=document.documentElement.clientHeight;
			documentWidth=document.documentElement.clientWidth;
		}else{
			documentHeight=document.body.clientHeight;
			documentWidth=document.body.clientWidth;
		}
		
		var result={};
		var x=position!=undefined&&position.x!=undefined?position.x:0;
		var y=position!=undefined&&position.y!=undefined?position.y:0;
		//x ，左对齐的话 ，x>0向右移动 x 像素 ||右对齐的话 x>0,向左移动 x像素
		//y , 向下伸展，y>0 向下移动 y 像素 ||  向上伸展 ，x>0 向上移动 x像素  
		//自动根据宽度相对与元素 left，bottom || right,bottom ||left ,top ||right:bottom
		//注意此处永远只设置 top, left 这两个值来定位层的位置。。。
		if(targetRect.bottom+y+ $this.sourceElement.offsetHeight>documentHeight){
			var canShowHeight1=documentHeight-(targetRect.bottom+y); //向下对齐能显示的内容高度
			var canShowHeight2= targetRect.top-targetElement.offsetHeight-y; //向上对齐能显示的内容高度
			if(canShowHeight1>=canShowHeight2){
				$this.sourceElement.style.top=(targetRect.bottom+y)+"px";
			}else{
				$this.sourceElement.style.top = (targetRect.top-$this.sourceElement.offsetHeight-y) +"px";
				result.top=true;
			}
		}else{
			$this.sourceElement.style.top=(targetRect.bottom+y) +"px";
			
		}
		$this.sourceElement.style.bottom="auto";
		if(targetRect.left+x+$this.sourceElement.offsetWidth>documentWidth){
			var canShowWidth1=documentWidth-(targetRect.left+x); //向左对齐能显示的内容宽度
			var canShowWidth2= targetRect.right-x; //向右对齐能显示的内容宽度
			if(canShowWidth1>=canShowWidth2){
				$this.sourceElement.style.left=(targetRect.left+x)+"px";
			}else{
				$this.sourceElement.style.left=(targetRect.right-$this.sourceElement.offsetWidth-x)+"px";
				result.right=true;
			}
		}else{
			$this.sourceElement.style.left=(targetRect.left+x)+"px";
		}
		$this.sourceElement.style.right="auto";
		return result;
	};
	
ET.ScrollBar=function(container,config){
	if(typeof container=='string'){
		container=document.getElementById(container);
	}
	this.config=config||{};
	this.container=container;
	
	if(this.config.overflow!=undefined){
		this.overflowY=this.overflowX=this.config.overflow;
	}
	if(this.config.overflowX!=undefined){
		this.overflowX=this.config.overflowX;
	}
	
	if(this.config.overflowY!=undefined){
		this.overflowY=this.config.overflowY;
	}
	if(this.overflowX==undefined){
		this.overflowX="auto";
	}
	if(this.overflowY==undefined){
		this.overflowY="auto";
	}
	this._initalBar();
	this._initalEvent();
	
	/**
	 * config 主要配置 ：
	 * 1. overflow:hidden 隐藏所有的滚动条，scroll总是显示所有的滚动条，其他则是自动显示或者隐藏
	 * 2. overflowX:  hidden, 则不显示水平滚动条,scroll 总是显示 ，默认是自动显示或隐藏（注意容器默认的overflow 是visible)
	 * 3. overflowY:  hidden, 则不显示竖直滚动条,scroll 总是显示 ，默认是自动
	 * 4.水平滚动条滚动时事件 scrollXEvent:function (conentScrollLeft, xbarScrollLeft )
	 *  (conentScrollLeft 内容水平滚动值， xbarScrollLeft水平滚动条左侧滚动值)
	 * 5.竖直滚动条滚动时事件 scrollYEvent:function (conentScrollTop, xbarScrollTop )
	 *  (conentScrollTop  内容竖直滚动值， xbarScrollTop 竖直滚动条向下滚动值)
	 * 6.keyScrollValue ，按住上下 左右键 滚动的距离 默认是50
	 * 7.enableKeyScroll 是否允许 上下 左右键 来滚动内容，默认是允许的
	 * 8.resizeAble: 是否需要在window 改变时重新计算
	 * 9.initialResize 初始化后是否需要立即resize ,默认是需要的
	 * 10 scrollLeftHandler:function(conentScrollLeft,xbarScrollLeft) 调用此组件的方法里 设置 contentDIV.scrollLeft 会触发
	 * 11 scrollTopHandler  调用此组件的方法里 设置 contentDIV.scrollTop 会触发 ，调用频率高，注意不要太重量级
	 */
};
ET.ScrollBar.prototype._initalBar=function(){
	var self=this,container=self.container;
	var innerHTML=container.innerHTML;
	ET.Utils.addClass(container,'dumascroll');
	container.style.overflow="hidden";
	var destoryHtml=self.config.destoryHtml;
	if(destoryHtml==false){
		var oldChildren=container.children;
		var length=oldChildren.length;
		var div_dumascroll_area=document.createElement("div");
		ET.Utils.addClass(div_dumascroll_area,"dumascroll_area");
		if(length>0){
			container.insertBefore(div_dumascroll_area,oldChildren[0]);
		}else{
			container.appendChild(div_dumascroll_area);
		}
		oldChildren=container.children;
		while(oldChildren.length>1){
			div_dumascroll_area.appendChild(oldChildren[1]);
		}
		
		var div=document.createElement("div");
		div.innerHTML='<div class="dumascroll_barY">' +
				'<div class="dumascroll_arrow_up"></div>' + //0
				'<div class="dumascroll_handleY"></div>' +//1
				'<div class="dumascroll_arrow_down"></div>' + //2
		'</div>'+
		'<div class="dumascroll_barX">' +
				'<div class="dumascroll_arrow_left"></div>' + //0
				'<div class="dumascroll_handleX"></div>' +//1
				'<div class="dumascroll_arrow_right"></div>' + //2
		'</div>'+
		'<div class="duma_rightButtom"></div>';
		oldChildren=div.children;
		while(oldChildren.length>0){
			container.appendChild(oldChildren[0]);
		}
	}else{
		container.innerHTML = '<div  class="dumascroll_area">' + innerHTML + '</div>' +
		'<div class="dumascroll_barY">' +
				'<div class="dumascroll_arrow_up"></div>' + //0
				'<div class="dumascroll_handleY"></div>' +//1
				'<div class="dumascroll_arrow_down"></div>' + //2
		'</div>'+
		'<div class="dumascroll_barX">' +
				'<div class="dumascroll_arrow_left"></div>' + //0
				'<div class="dumascroll_handleX"></div>' +//1
				'<div class="dumascroll_arrow_right"></div>' + //2
		'</div>'+
		'<div class="duma_rightButtom"></div>' //右下角的填充DIV
		;
	}
	
	var allDIV= container.children ;
	self.contentDIV=allDIV[0];		
	self.bar_Y_DIV=allDIV[1];
	self.bar_X_DIV=allDIV[2];
	self.rightBottomDIV=allDIV[3];
//	self.contentDIV.style.padding=self.getStyle(container).padding;
//	self.contentDIV.style.margin=self.getStyle(container).margin;
	/*此处可以对比自定义滚动条 ，和系统原始滚动条的效果 */
	//self.contentDIV.style.marginTop="0px";
	//self.contentDIV.style.marginRight="1px";
	//self.contentDIV.style.marginBottom="1px";
	var bar_Y_DIVArea=self.bar_Y_DIV.getElementsByTagName('div');
	var bar_X_DIVArea=self.bar_X_DIV.getElementsByTagName('div');
	var upDIV=bar_Y_DIVArea[0];
	var leftDIV=bar_X_DIVArea[0];
	var scroll_Y_DIV=bar_Y_DIVArea[1];
	var scroll_X_DIV=bar_X_DIVArea[1];
	var downDIV=bar_Y_DIVArea[2];
	var rightDIV=bar_X_DIVArea[2];
	self.upDIV=upDIV;
	self.leftDIV=leftDIV;
	self.scroll_Y_DIV=scroll_Y_DIV;
	self.scroll_X_DIV=scroll_X_DIV;
	self.downDIV=downDIV;
	self.rightDIV=rightDIV;
	var position=self.getStyle(container).position;
	if(position=='static'){
		container.style.position="relative";
	}
	self.upDIVHeight=parseInt(self.getStyle(upDIV).height,10);
	self.downDIVHeight=parseInt(self.getStyle(downDIV).height,10 );
	self.leftDIVWidth=parseInt(self.getStyle(leftDIV).width,10);
	self.rightDIVWidth=parseInt(self.getStyle(rightDIV).width ,10);
	self.barWidth=scroll_Y_DIV.offsetWidth;
	self.barHeight=scroll_X_DIV.offsetHeight; //好的情况barHeight= barWidth 相等
	self.isIE7=ET.is_ie7;
	if(self.config.initialResize!=false){
		self.resize();
	}
};
ET.ScrollBar.prototype.resize=function(){
	var self=this,contentDIV=self.contentDIV;
	var overflowX=self.overflowX,overflowY=self.overflowY;
	if(overflowY=='scroll'){
		ET.Utils.addClass(contentDIV,'showYScroll'); //内容区域一定有滚动条，宽度减小
	}else {
		ET.Utils.removeClass(contentDIV,'showYScroll'); //恢复原始状态
	}
	if(overflowX=='scroll'){
		ET.Utils.addClass(contentDIV,'showXScroll');
	}else {
		ET.Utils.removeClass(contentDIV,'showXScroll'); //恢复原始状态
	}	
	var height=!self.isIE7?contentDIV.offsetHeight:contentDIV.clientHeight;
	var width=!self.isIE7?contentDIV.offsetWidth:contentDIV.clientWidth;
	//设置有横向滚动条的css 标识，以减小内容区域，如果此时 小区域出现滚动内容，则必有滚动条，否则一定没有滚动条
	if(overflowY=='hidden'||( overflowY!='scroll'&&contentDIV.scrollHeight<=height) ){ 
		self._hideYBar();
	}else {
		self._showYBar();
		//self.caculateYBarHeight();
	}
	if(overflowX=='hidden'||(overflowX!='scroll'&&contentDIV.scrollWidth<=width)){ 
		self._hideXBar();
	}else{
		self._showXBar();
		//self.caculateXBarWidth();
	}
};

ET.ScrollBar.prototype.getStyle=function(o){
	return o.currentStyle||document.defaultView.getComputedStyle(o,null);
};
/* 计算 竖直滚动条的长度*/
ET.ScrollBar.prototype.caculateYBarHeight=function(){
	var self=this,contentDIV=self.contentDIV;
	var offsetHeight=!self.isIE7?contentDIV.offsetHeight:contentDIV.clientHeight;
	var scrollHeight=contentDIV.scrollHeight;
	var handleHeight=0;
	if(scrollHeight>offsetHeight){
		var rate=(offsetHeight+0.0)/contentDIV.scrollHeight;
		var canScrollDIVHeight=self.bar_Y_DIV.offsetHeight-self.upDIVHeight-self.downDIVHeight;
		 handleHeight=parseFloat(rate*canScrollDIVHeight,10);
		var minHandleHeight=self.config.minHandleHeight||5;
		minHandleHeight=parseFloat(minHandleHeight,10);
		if(handleHeight<minHandleHeight){
			handleHeight=minHandleHeight;
		}
	}
	self.scroll_Y_DIV.style.height=handleHeight+"px";
	return handleHeight;
};
/* 计算 水平滚动条的长度*/
ET.ScrollBar.prototype.caculateXBarWidth=function(){
	var self=this,contentDIV=self.contentDIV;
	var offsetWidth=!self.isIE7?contentDIV.offsetWidth:contentDIV.clientWidth;
	var scrollWidth=contentDIV.scrollWidth;
	var handleWidth=0;
	if(scrollWidth>offsetWidth ){
		var rate=(offsetWidth+0.0)/contentDIV.scrollWidth;
		var canScrollDIVWidth=self.bar_X_DIV.offsetWidth-self.leftDIVWidth-self.rightDIVWidth;
		handleWidth=parseFloat(rate*canScrollDIVWidth,10);
		var minHandleWidth=self.config.minHandleWidth||5;
		minHandleWidth=parseFloat(minHandleWidth,10);
		if(handleWidth<minHandleWidth){
			handleWidth=minHandleWidth
		}
	}
	self.scroll_X_DIV.style.width=handleWidth+"px";
	return handleWidth;
};
ET.ScrollBar.prototype._hideYBar=function(){
	var self=this;
	self.bar_Y_DIV.style.display="none";
	ET.Utils.removeClass(self.contentDIV,'showYScroll');
	ET.Utils.removeClass(self.bar_X_DIV,'showYScroll');
	ET.Utils.removeClass(self.rightBottomDIV,'showYScroll');
	self.showYBar=false;
};
ET.ScrollBar.prototype._hideXBar=function(){
	var self=this;
	self.bar_X_DIV.style.display="none";
	ET.Utils.removeClass(self.contentDIV,'showXScroll');
	ET.Utils.removeClass(self.bar_Y_DIV,'showXScroll');
	ET.Utils.removeClass(self.rightBottomDIV,'showXScroll');
	self.showXBar=false;
};
ET.ScrollBar.prototype._showYBar=function(){
	var self=this;
	self.bar_Y_DIV.style.display="";
	ET.Utils.addClass(self.contentDIV,'showYScroll');
	ET.Utils.addClass(self.bar_X_DIV,'showYScroll');
	ET.Utils.addClass(self.rightBottomDIV,'showYScroll');	
	self.changeYScroll(0);
	self.showYBar=true;
};
ET.ScrollBar.prototype._showXBar=function(){
	var self=this;
	self.bar_X_DIV.style.display="";
	ET.Utils.addClass(self.contentDIV,'showXScroll');
	ET.Utils.addClass(self.bar_Y_DIV,'showXScroll');
	ET.Utils.addClass(self.rightBottomDIV,'showXScroll');	
	self.changeXScroll(0);
	self.showXBar=true;
};
ET.ScrollBar.prototype.caculateYBarPosition=function(){
	var self=this ,contentDIV=self.contentDIV;
	var offsetHeight=self.isIE7? contentDIV.offsetHeight:contentDIV.clientHeight;
	var topHeightValue=self.upDIVHeight;
	var contentScrollHeight= contentDIV.scrollHeight-offsetHeight;
	var YBarHeight=self.caculateYBarHeight();
	if(contentScrollHeight>0){
		var canScrollDIVHeight=self.bar_Y_DIV.offsetHeight-self.upDIVHeight-self.downDIVHeight-YBarHeight;
		var contentScrollTop=contentDIV.scrollTop;
		topHeightValue+= contentScrollTop/(contentScrollHeight)*canScrollDIVHeight;
	}
	self.scroll_Y_DIV.style.top= topHeightValue+"px";
	return topHeightValue;
};
ET.ScrollBar.prototype.caculateXBarPosition=function(){
	var self=this ,contentDIV=self.contentDIV;
	var offsetWidth=self.isIE7? contentDIV.offsetWidth:contentDIV.clientWidth;
	var contentScrollWidth=contentDIV.scrollWidth-offsetWidth ;
	var XBarWidth=self.caculateXBarWidth();
	var leftWidthValue=self.leftDIVWidth;
	if(contentScrollWidth>0){
		var canScrollDIVWidth=self.bar_X_DIV.offsetWidth-self.leftDIVWidth-self.rightDIVWidth-XBarWidth;
		var contentScrollLeft=contentDIV.scrollLeft;
		leftWidthValue+=contentScrollLeft/(contentScrollWidth)*canScrollDIVWidth;
	}
	self.scroll_X_DIV.style.left= leftWidthValue+"px";
	return leftWidthValue;
};
/**
 *  改变竖直 滚动条的高度 changeBarValue
 */
ET.ScrollBar.prototype.changeYBarPosition=function(changeBarValue){
	//window.console.log(changeBarValue);
	var self=this,contentDIV=self.contentDIV;
	var scrollTop=parseFloat(self.getStyle(self.scroll_Y_DIV).top,10);
	if(isNaN(scrollTop)){
		scrollTop=0;
	}
	var oldScrollTop=scrollTop;
	var barHeight=self.caculateYBarHeight();
	var offsetHeight=self.isIE7? contentDIV.offsetHeight:contentDIV.clientHeight;
	var contentScrollHeight= contentDIV.scrollHeight-offsetHeight;
	var maxScrollTop=contentScrollHeight>0? self.bar_Y_DIV.offsetHeight-self.downDIVHeight-barHeight:0;
	scrollTop+=changeBarValue;
	if(scrollTop>maxScrollTop){
		scrollTop=maxScrollTop;
	}
	if(isNaN(scrollTop)||scrollTop<self.upDIVHeight){
		scrollTop=self.upDIVHeight;
	}
	self.scroll_Y_DIV.style.top=scrollTop+"px";
	var contentScrollTopValue=0;
	if( contentScrollHeight>0){
		var canScrollDIVHeight=self.bar_Y_DIV.offsetHeight-self.upDIVHeight-self.downDIVHeight-barHeight;
		contentScrollTopValue=(scrollTop-self.upDIVHeight )*(contentDIV.scrollHeight-offsetHeight)/canScrollDIVHeight
	};
	self.contentDIV.scrollTop=contentScrollTopValue;
	var scrollTopHandler= self.config.scrollTopHandler;
	if(scrollTopHandler!=undefined&& typeof scrollTopHandler=='function'){
		scrollTopHandler(contentScrollTopValue,scrollTop);
	}
	
	if(oldScrollTop!=scrollTop){
		self.fireScrollYEvent();
	}
};
/**
 *  改变水平 滚动条的高度 changeBarValue
 */
ET.ScrollBar.prototype.changeXBarPosition=function(changeBarValue){
	//window.console.log(changeBarValue);
	var self=this,contentDIV=self.contentDIV;
	var scrollLeft=parseFloat(self.getStyle(self.scroll_X_DIV).left,10);
	if(isNaN(scrollLeft)){
		scrollLeft=0;
	}
	var oldScrollLeft=scrollLeft;
	var barWidth=self.caculateXBarWidth();
	var offsetWidth=self.isIE7? contentDIV.offsetWidth:contentDIV.clientWidth;
	var contentScrollWidth= contentDIV.scrollWidth-offsetWidth;
	var maxScrollLeft=contentScrollWidth>0? self.bar_X_DIV.offsetWidth-self.rightDIVWidth-barWidth:0;
	scrollLeft+=changeBarValue;
	if(scrollLeft>maxScrollLeft){
		scrollLeft=maxScrollLeft;
	}
	if(isNaN(scrollLeft)|| scrollLeft<self.leftDIVWidth){
		scrollLeft=self.leftDIVWidth;
	}
	self.scroll_X_DIV.style.left=scrollLeft+"px";
	var contentScrollLeftValue=0;
	if(contentScrollWidth>0){
		var canScrollDIVWidth=self.bar_X_DIV.offsetWidth-self.leftDIVWidth-self.rightDIVWidth-barWidth;
		contentScrollLeftValue=(scrollLeft-self.leftDIVWidth )*(contentScrollWidth)/canScrollDIVWidth ;
	}
	self.contentDIV.scrollLeft=contentScrollLeftValue;
	var scrollLeftHandler= self.config.scrollLeftHandler;
	if(scrollLeftHandler!=undefined&& typeof scrollLeftHandler=='function'){
		scrollLeftHandler(contentScrollLeftValue,scrollLeft);
	}
	if(oldScrollLeft!=scrollLeft){
		self.fireScrollXEvent();
	}
};
/*
 *  竖直方向 内容滚动改变 scrollValue （大于 向下）
 */
ET.ScrollBar.prototype.changeYScroll=function(scrollValue){
	var self=this,contentDIV=self.contentDIV;
	var offsetHeight=self.isIE7? contentDIV.offsetHeight:contentDIV.clientHeight;
	var maxScrollTop=contentDIV.scrollHeight - offsetHeight;
	var oldScrollTop=contentDIV.scrollTop;
	var scrollTop=oldScrollTop;
	if(scrollTop>maxScrollTop){
		scrollTop=maxScrollTop;
	}else {
		scrollTop+=scrollValue;
		if(scrollTop>=maxScrollTop){
			scrollTop=maxScrollTop;
		}
		if(scrollTop<0){
			scrollTop=0;
		}
		contentDIV.scrollTop=scrollTop;
		var barTop=self.caculateYBarPosition();
		var scrollTopHandler= self.config.scrollTopHandler;
		if(scrollTopHandler!=undefined&& typeof scrollTopHandler=='function'){
			scrollTopHandler(scrollTop,barTop);
		}
	}
	if(scrollTop!=oldScrollTop){
		self.fireScrollYEvent();
	}
};
ET.ScrollBar.prototype.scrollToEnd=function(){
	var self=this,contentDIV=self.contentDIV;
	var offsetHeight=self.isIE7? contentDIV.offsetHeight:contentDIV.clientHeight;
	var maxScrollTop=contentDIV.scrollHeight - offsetHeight;
	self.changeYScroll(maxScrollTop);
}
ET.ScrollBar.prototype.scrollYToValue=function(value){
	
	var self=this;
	var currentTop=self.contentDIV.scrollTop;
	var change=value-currentTop;
	self.changeYScroll(change);
}
ET.ScrollBar.prototype.scrollXToValue=function(value){
	
	var self=this;
	var currentLeft=self.contentDIV.scrollLeft;
	var change=value-currentLeft;
	self.changeXScroll(change);
}
/*
 *  水平方向 内容滚动改变 scrollValue （大于 向右）
 */
ET.ScrollBar.prototype.changeXScroll=function(scrollValue){
	var self=this, contentDIV=self.contentDIV;
	var offsetWidth=self.isIE7? contentDIV.offsetWidth:contentDIV.clientWidth;
	var maxScrollLeft=contentDIV.scrollWidth - offsetWidth;
	var oldScrollLeft=contentDIV.scrollLeft;
	var scrollLeft=oldScrollLeft;
	if(scrollLeft>maxScrollLeft){
		scrollLeft=maxScrollLeft;
	}else {
		scrollLeft+=scrollValue;
		if(scrollLeft>=maxScrollLeft){
			scrollLeft=maxScrollLeft;
		}
		if(scrollLeft<0){
			scrollLeft=0;
		}
		contentDIV.scrollLeft=scrollLeft;
		var barLeft=self.caculateXBarPosition();
		var scrollLeftHandler= self.config.scrollLeftHandler;
		if(scrollLeftHandler!=undefined&& typeof scrollLeftHandler=='function'){
			scrollLeftHandler(scrollLeft,barLeft);
		}
	}
	if(scrollLeft!=oldScrollLeft){
		self.fireScrollXEvent();
	}
};
ET.ScrollBar.prototype.fireScrollXEvent=function(){
	var self=this;
	var scrollXEvent=self.config.scrollXEvent;
	if(scrollXEvent!=undefined&& typeof scrollXEvent=='function'){
		scrollXEvent.call(self.scroll_X_DIV,self.contentDIV.scrollLeft,parseFloat(self.getStyle(self.scroll_X_DIV).left,10) );
	}
};
ET.ScrollBar.prototype.fireScrollYEvent=function(){
	var self=this;
	var scrollYEvent=self.config.scrollYEvent;
	if(scrollYEvent!=undefined&& typeof scrollYEvent=='function'){
		scrollYEvent.call(self.scroll_Y_DIV,self.contentDIV.scrollTop,parseFloat(self.getStyle(self.scroll_Y_DIV).top,10) );
	}
};
ET.ScrollBar.prototype._initalEvent=function(){
	var self=this,container=self.container;
	var scrollYStartFlag=false;
	var containerScrollStartFunction=function(){
		if(self.config.containerScrollStart!=undefined&& typeof self.config.containerScrollStart =='function'){
			self.config.containerScrollStart.call(self);
		}
	}
	var containerScrollEndFunction=function(){
		if(self.config.containerScrollEnd!=undefined&& typeof self.config.containerScrollEnd =='function'){
			self.config.containerScrollEnd.call(self);
		}
	}
	var eDir=0;
	self.scrollTimelength==self.config.scrollTimelength||20;
	var containerScroll=function(e){
		containerScrollStartFunction();
		e=e||window.event;
		//模拟滚动开始
		if(e.wheelDelta){ 
			eDir = e.wheelDelta/120;
		} else if(e.detail) { 
		 	eDir = -e.detail/3; 
		}
		self.changeYScroll( eDir > 0? -80:80);
		window.clearTimeout(containerScrollEndFunction.timeoutID);
		containerScrollEndFunction.timeoutID=window.setTimeout( containerScrollEndFunction,self.scrollTimelength); //模拟滚动结束
	};
	var containerScrollEvent=function(e){
		containerScrollEvent.timeoutID=window.setTimeout(containerScroll)
		
	}
	ET.Utils.addEvent(container,'mousewheel',containerScroll);
	ET.Utils.addEvent(container,'DOMMouseScroll',containerScroll);
	
	var touchStartX=0;
	var touchStartY=0;
	ET.Utils.addEvent(container,'touchstart',function(event){
		event=event||window.event;
		var touch=event.touches[0];
		touchStartX=touch.clientX;
		touchStartY=touch.clientY;
	});
	ET.Utils.addEvent(container,'touchmove',function(event){
		event=event||window.event;
		var touch=event.touches[0];
		var newX=touch.clientX;
		var newY=touch.clientY;
		var changeX=touchStartX-newX;
		var changeY=touchStartY-newY;
		//alert(newX +" ;"+newY);
		self.changeXScroll(changeX);
		self.changeYScroll(changeY);
		touchStartX=newX;
		touchStartY=newY;
		if(event.preventDefault){
			event.preventDefault();
		}else{
			event.returnValue = false;
		}
	});
	
	
	ET.Utils.addEvent(container,'mouseover',function(evnet){
		self.currentMouseOver=true;
	});
	ET.Utils.addEvent(container,'mouseout',function(evnet){
		self.currentMouseOver=false;
	});
	keyTimeoutID=null;
	var keyEvent=function(event){
		if(self.currentMouseOver){
			if(self.config.enableKeyScroll!=false){
				var e = event || window.event,
		        ek = e.keyCode || e.which;
		        var y=false;var x=false;
		        var value=self.config.keyScrollValue||20;
		        var changeValue=0;
		        switch (ek) {
		        	case 40:
		        		y=true;
		        		changeValue=value;
		        		break;
					case 38:
						y=true;
		        		changeValue=0-value;
		        		break;
		        	case 37:
		        		x=true;
		        		changeValue=0-value;
		        		break;
		        	case 39:
		        		x=true;
		        		changeValue=value;
		        		break;
		        	default:
		        		break;
		        }
		        window.clearTimeout(keyTimeoutID);
		       keyTimeoutID= window.setTimeout(function(){
		        	if(y){
		        		//containerScrollStartFunction();
		         		self.changeYScroll(changeValue);
		         		//containerScrollEndFunction();
		        	 }else if(x){
		         		self.changeXScroll(changeValue);
		        	 }
		        },self.scrollTimelength)
		         
			}
		}
	};
	ET.Utils.addEvent(document,'keydown',keyEvent);
	ET.Utils.addEvent(self.upDIV,'click',function(event){
		containerScrollStartFunction();
		self.changeYScroll(-self.contentDIV.clientHeight/3);
		window.clearTimeout(containerScrollEndFunction.timeoutID);
		containerScrollEndFunction.timeoutID=window.setTimeout( containerScrollEndFunction,self.scrollTimelength);
	});
	ET.Utils.addEvent(self.downDIV,'click',function(event){
		containerScrollStartFunction();
		self.changeYScroll(self.contentDIV.clientHeight/3);
		window.clearTimeout(containerScrollEndFunction.timeoutID);
		containerScrollEndFunction.timeoutID=window.setTimeout( containerScrollEndFunction,self.scrollTimelength);
	});
	ET.Utils.addEvent(self.leftDIV,'click',function(event){
		self.changeXScroll(-self.contentDIV.clientWidth/3);
	});
	ET.Utils.addEvent(self.rightDIV,'click',function(event){
		self.changeXScroll(self.contentDIV.clientWidth/3);
	});
	var resizeFun=function(){
		if(self.container.offsetWidth>0&&self.container.offsetHeight){
			self.resize();
		}
	}
	ET.Utils.addEvent(window,'resize',function(){
		if(self.config.resizeAble!=false){
			window.clearTimeout(resizeFun.timeoutID);
			resizeFun.timeoutID=window.setTimeout(resizeFun,100 );
		}
	});
	var self=this,contentDIV=self.contentDIV;
	var barHeight, maxScrollTop,canScrollDIVHeight,scrollHeight,contentHeight;
	ET.Utils.addEvent(self.scroll_Y_DIV,'mousedown',function(event){
		event=event||window.event;
		if(event.preventDefault){
			event.preventDefault();
		}else{
			event.returnValue = false;
		}
		if(self.scroll_Y_DIV.setCapture){
			self.scroll_Y_DIV.setCapture();
		}else{
			window.captureEvents(Event.MOUSEMOVE|Event.MOUSEUP);
		}
		if(self.config.dragYStart!=undefined&& typeof self.config.dragYStart=='function' ){
			self.config.dragYStart.call(self);
		}
		self.lastTimeRelY=event.clientY;
		ET.Utils.removeEvent(document,'mousemove',startYDrag);
		ET.Utils.removeEvent(document,'mouseup',releaseYDrag);
		ET.Utils.addEvent(document,'mousemove',startYDrag);
		ET.Utils.addEvent(document,'mouseup',releaseYDrag);
	});
	
	var Y_timeOutID=null;
	var startYDrag=function(event){
		event = event || window.event;
        var y= event.clientY ;
        if(event.preventDefault){
			event.preventDefault();
		}else{
			event.returnValue = false;
		}
        if(self.lastTimeRelY!=undefined){
        	Y_timeOutID=window.setTimeout(function(){
        		var changeBarValue=y-self.lastTimeRelY;
        		self.changeYBarPosition(changeBarValue);
				self.lastTimeRelY=y;
        	},10)
        }
	};
	var releaseYDrag=function(event){
//		console.log('releaseDrag');
		event=event||window.event;
		if(event.preventDefault){
			event.preventDefault();
		}else{
			event.returnValue = false;
		}
       	if(document.releaseCapture){//拖动释放
			document.releaseCapture();
		}else if(window.releaseEvents){
			window.releaseEvents(Event.MOUSEMOVE|Event.MOUSEUP);
		}
		if(self.config.dragYEnd!=undefined&& typeof self.config.dragYEnd=='function' ){
			self.config.dragYEnd.call(self);
		}		
		delete self.lastTimeRelY;
		window.clearTimeout(Y_timeOutID);
		self.changeYScroll(0);
		ET.Utils.removeEvent(document,'mousemove',startYDrag );
		ET.Utils.removeEvent(document,'mouseup',releaseYDrag );
	}
	
	var barWidth, maxScrollLeft,canScrollDIVWidth,scrollWidth,contentWidth;
	ET.Utils.addEvent(self.scroll_X_DIV,'mousedown',function(event){
		event=event||window.event;
		if(event.preventDefault){
			event.preventDefault();
		}else{
			event.returnValue = false;
		}
		if(self.scroll_X_DIV.setCapture){
			self.scroll_X_DIV.setCapture();
		}else{
			window.captureEvents(Event.MOUSEMOVE|Event.MOUSEUP);
		}
		if(self.config.dragXStart!=undefined&& typeof self.config.dragXStart=='function' ){
			self.config.dragXStart.call(self);
		}
		self.lastTimeRelX=event.clientX;
//		window.console.log('lastTimeRelX==='+self.lastTimeRelX);
		ET.Utils.removeEvent(document,'mousemove',startXDrag);
		ET.Utils.removeEvent(document,'mousemove',releaseXDrag);
		ET.Utils.addEvent(document,'mousemove',startXDrag);
		ET.Utils.addEvent(document,'mouseup',releaseXDrag);
	});
	var X_timeOutID=null;
	var startXDrag=function(event){
		event= event || window.event;
        var x= event.clientX;
        if(event.preventDefault){
			event.preventDefault();
		}else{
			event.returnValue = false;
		}
        if(event.stopPropagation) event.stopPropagation();
            else event.cancelBubble=true;
        if(self.lastTimeRelX!=undefined){
        	X_timeOutID=window.setTimeout(function(){
        		window.clearTimeout(X_timeOutID);
        		var changeBarValue=x-self.lastTimeRelX;
//        		window.console.log('xxx==='+x);
        		self.changeXBarPosition(changeBarValue);
				self.lastTimeRelX=x;
        	},10)
        }
	};
	
	var releaseXDrag=function(event){
//		console.log('releaseDrag');
		event=event||window.event;
		if(event.preventDefault){
			event.preventDefault();
		}else{
			event.returnValue = false;
		}
       	if(document.releaseCapture){//拖动释放
			document.releaseCapture();
		}else if(window.releaseEvents){
			window.releaseEvents(Event.MOUSEMOVE|Event.MOUSEUP);
		}
		delete self.lastTimeRelX;
		window.clearTimeout(X_timeOutID);
		
		if(self.config.dragXEnd!=undefined&& typeof self.config.dragXEnd=='function' ){
			self.config.dragXEnd.call(self);
		}
		self.changeXScroll(0);
		ET.Utils.removeEvent(document,'mousemove',startXDrag );
		ET.Utils.removeEvent(document,'mouseup',releaseXDrag );
	}
};

	function etSubmit(obj) {
		var operation= obj.operation;
		if( operation==null || operation.value==null  || operation.value.indexOf("word")!=-1 || operation.value.indexOf("Word")!=-1  || operation.value.indexOf("export")!=-1 
			 || operation.value.indexOf("Excel")!=-1  || operation.value.indexOf("excel")!=-1  || operation.value.indexOf("download")!=-1
			 || operation.value.indexOf("PDF")!=-1|| operation.value.indexOf("pdf")!=-1 ){
			
			obj.submit();
		}else{
			var loader = window._current_loader;
			if(loader==null){
				var div=document.createElement('div');
				ET.Utils.addClass(div,"submitMaskDIV");
				var language_waiting = " Processing,Please Wait ... ";
			    if ("GB"===ET.language) {
					language_waiting = '执行中，请稍侯。。。';
				}
				div.innerHTML="<div class='submitGlobalMaskDIV'>" + language_waiting + "</div>";
				loader = window._current_loader=new ET.EasyTrack.MaskDIV(div,{
					globalZIndx:true
				});
			}
			obj.submit();
			if(loader && obj.operation) {
				loader.show();
				var old_operation = obj.operation.value;
				window.setTimeout(function(){
					if(window._current_loader!=null){
						window._current_loader.hide();
					}	
				},100*600);
			}
			return loader;
		}
		
	};


ET.EasyTrack={};
ET.EasyTrack.MaskDIV=function(element,config){
	if(typeof element=="string"){
		element=document.getElementById(element);
	}
	this.config=config==undefined?{}:config;
	this.content=element;
	ET.Utils.addClass(element,"uiDom maskDIV");
	var _self=this;
	ET.Utils.addEvent(window,'resize',function(){
		if(_self._isShow&&_self.config.resize!=false){
			_self._caclultePosition();
		}
	})
};
ET.EasyTrack.MaskDIV.prototype.show=function(element,offsetXy){
	var _self=this;
	if(_self.config.maxZIndex!=undefined&&_self.config.maxZIndex==true ){
		_self.content.style.zIndex=2147483647;
	}else{
		if(_self.config.globalZIndx){
			_self.content.style.zIndex=window.top!=null?top.ET.zIndex++:ET.zIndex++;
		}else{
			_self.content.style.zIndex=ET.zIndex++;
		}
	}
	document.body.appendChild(_self.content);
	if(element==undefined){
		element=document.body;
	}else if(typeof element =="string" ){
		element=document.getElementById(element);
	}
	_self._maskElement=element;
	_self._offsetXy=offsetXy;
	_self.content.style.display="block";
	_self.content.style.position="absolute";
	_self._caclultePosition();
	if(_self.config.afterShow!=undefined && typeof _self.config.afterShow =='function'){
		_self.config.afterShow.call(_self);
	}
	_self._isShow=true;
};
ET.EasyTrack.MaskDIV.prototype._caclultePosition=function(){
	var _self=this,element=this._maskElement;
	if(element!=null){
		var offsetXy=_self._offsetXy;
		if(offsetXy==null){
			offsetXy={};
		}
		var clientRect=element.getBoundingClientRect();
		var top=clientRect.top+(offsetXy.top==undefined?0:offsetXy.top);
		var left=clientRect.left+(offsetXy.left==undefined?0:offsetXy.left);
		_self.content.style.left=left+"px";
		_self.content.style.top=top+"px";
		if(element!=document.body){
			_self.content.style.width=(clientRect.right-clientRect.left)+"px";
			_self.content.style.height=(clientRect.bottom-clientRect.top)+"px";
			_self.content.style.right="auto";
			_self.content.style.bottom="auto";
		}else{
			_self.content.style.right="0px";
			_self.content.style.bottom="0px";
		}
	}
};

ET.EasyTrack.MaskDIV.prototype.hide=function(){
	var _self=this;
	_self.content.style.display="none";
	if(_self.config.afterHide!=undefined && typeof _self.config.afterHide =='function'){
		_self.config.afterHide.call(_self);
	}
	_self._isShow=false;
};
ET.EasyTrack.MaskDIV.prototype.destory=function(){
	var _self=this;
	_self.content.parentNode.removeChild(_self.content);
};
ET.EasyTrack.window=function(container,config){
	if(typeof container== 'string'){
		container=document.getElementById(container);
	}
	var containerParent=null;
	config=config||{};
	if(config.containerParent==null){
		containerParent=document.body;
	}else {
		if(typeof config.containerParent== 'string'){
			containerParent=document.getElementById(config.containerParent);
		}else{
			containerParent=config.containerParent;
		}
	}
	this.containerParent=containerParent;
	this.config=config;
	this.container=container;
	this._inital();
};
ET.EasyTrack.window.prototype._inital=function(){
	var _self=this;
	ET.Utils.addClass(_self.container,"uiDom window");
	_self._initalTitleContainer();
};
ET.EasyTrack.window.prototype._initalTitleContainer=function(){
	var _self=this;
	var config=_self.config;
	//初始化 window 的头
	var title=config.title;
	var titleContainer=null;
	if(typeof title=='string'){
		titleContainer=document.createElement('div');
		titleContainer.innerHTML=title;
	}else{
		titleContainer=title;
	}
	_self.titleContainer=titleContainer;
	if(titleContainer!=null){
		ET.Utils.addClass(titleContainer,'titleContainer');
		if(titleContainer.parentNode!=_self.container){
			if(_self.container.children.length>0){
				_self.container.insertBefore(titleContainer,_self.container.children[0]);
			}else{
				_self.container.appendChild(titleContainer);
			}
		}
		var lastTimeRelY=undefined;
		var lastTimeRelX=undefined;
		ET.Utils.addEvent(titleContainer,'mousedown',function(event){
			event=event||window.event;
			if(event.preventDefault){
				event.preventDefault();
			}else{
				event.returnValue = false;
			}
			if(titleContainer.setCapture){
				titleContainer.setCapture();
			}else{
				window.captureEvents(Event.MOUSEMOVE|Event.MOUSEUP);
			}
			lastTimeRelY=event.clientY;
			lastTimeRelX=event.clientX;
			//拖动开始 自定义调用接口 dragTitleStart
			if(_self.config.dragTitleStart!=undefined&& typeof _self.config.dragTitleStart=='function' ){
				_self.config.dragTitleStart.call(_self,lastTimeRelX,lastTimeRelY);
			}
			ET.Utils.removeEvent(document,'mousemove',startDragTitle);
			ET.Utils.removeEvent(document,'mouseup',releaseDragTitle);
			ET.Utils.addEvent(document,'mousemove',startDragTitle);
			ET.Utils.addEvent(document,'mouseup',releaseDragTitle);
		});
		var startDragTitle=function(event){
			event = event || window.event;
			 if(event.preventDefault){
				event.preventDefault();
			}else{
				event.returnValue = false;
			}
			var currentX=event.clientX;
			var currentY=event.clientY;
			var changeX=currentX-lastTimeRelX;
			var changeY=currentY-lastTimeRelY ;
			var bodyHeight=0;
			var bodyWidth=0;
			if(document.compatMode=='CSS1Compat'){
				bodyHeight=document.documentElement.clientHeight;
				bodyWidth=document.documentElement.clientWidth;
			}else{
				bodyHeight=document.body.clientHeight;
				bodyWidth=document.body.clientWidth;
			}
			if(_self.config.dragTitle!=undefined&& typeof _self.config.dragTitle=='function' ){
				_self.config.dragTitle(event,currentX,currentY);
			}else{
				var left=parseInt(ET.Utils.getStyleProperty(_self.container,"left"));
				var top=parseInt(ET.Utils.getStyleProperty(_self.container,"top"));
				left+=changeX;
				top+=changeY;
				if(top<=0){
					top=0;
				}else if(top>bodyHeight-10){
					top=bodyHeight-10;
				}
				if(left<10-_self.container.clientWidth){
					left=10-_self.container.clientWidth;
				}else if(left>=bodyWidth-10){
					left=bodyWidth-10;
				}
				_self.container.style.left=left+"px";
				_self.container.style.top=top+"px";
				
				lastTimeRelY=currentY;
				lastTimeRelX=currentX;
			}
		}
		
		var releaseDragTitle=function(event){
			event=event||window.event;
			if(event.preventDefault){
				event.preventDefault();
			}else{
				event.returnValue = false;
			}
	       	if(document.releaseCapture){//拖动释放
				document.releaseCapture();
			}else if(window.releaseEvents){
				window.releaseEvents(Event.MOUSEMOVE|Event.MOUSEUP);
			}
			lastTimeRelX=undefined;
			lastTimeRelY=undefined;
			if(_self.config.dragTitleEnd!=undefined&& typeof _self.config.dragTitleEnd=='function' ){
				_self.config.dragTitleEnd(event);
			}
			ET.Utils.removeEvent(document,'mousemove',startDragTitle );
			ET.Utils.removeEvent(document,'mouseup',releaseDragTitle );
		}
	}
	
};

ET.EasyTrack.window.prototype.show=function(showConfig){
	var _self=this;
	_self.showAgain();
	showConfig=showConfig||{};
	var clientRect=_self.container.getBoundingClientRect();
	var bodyHeight=0;
	var bodyWidth=0;
	if(document.compatMode=='CSS1Compat'){
		bodyHeight=document.documentElement.clientHeight;
		bodyWidth=document.documentElement.clientWidth;
	}else{
		bodyHeight=document.body.clientHeight;
		bodyWidth=document.body.clientWidth;
	}
	var x=showConfig.x;
	var y=showConfig.y;
	if(x==undefined){
		var left=(bodyWidth-(clientRect.right-clientRect.left))/2;
		if(left<0){
			left=0;
		}
		_self.container.style.left= left+"px";
	}else{
		_self.container.style.left=x+"px";
	}
	if(y==undefined){
		var top= (bodyHeight-(clientRect.bottom-clientRect.top))/2;
		if(top<0){
			top=0;
		}
		_self.container.style.top=top+"px";
	}else{
		_self.container.style.top=y+"px";
	}
};
ET.EasyTrack.window.prototype.showAgain=function(){
	var _self=this;
	if(_self.config.needMask!=false){
		var maskDIV=_self.maskDIV;
		if(maskDIV==undefined){
			maskDIV=new ET.EasyTrack.MaskDIV(document.createElement('div'));
			_self.maskDIV=maskDIV;
		} 
		maskDIV.show();
	}
	if(_self.container.parentNode!=_self.containerParent){
		_self.containerParent.appendChild(_self.container);
	}
//	document.body.appendChild(_self.container);
	_self.container.style.display="block";
	_self.container.style.visibility="visible";
	_self.container.style.zIndex=ET.zIndex++;
};
ET.EasyTrack.window.prototype.hide=function(){
	var _self=this;
	if(_self.maskDIV!=null){
		_self.maskDIV.hide();
	}
	_self.container.style.display="none";
	_self.container.style.visibility="hidden";
};

ET.EasyTrack.window.prototype.destory=function(){
	var _self=this;
	if(_self.maskDIV!=null){
		_self.maskDIV.destory();	
	}
	_self.container.parentNode.removeChild(_self.container);
};

ET.popWindows = [];
ET.showModalWindow=function(arg,func){
	var canShow=arg.canShow;
	var projectDashboard=arg.projectDashboard;
	var div=document.createElement('div');
	var modalHTMl="<div class='titleContainer' ></div>"
				+"<div class='windowCloseAble'></div>"
				+"<div class='windowContent'><div class='windowContentFrameDIV'></div></div>";
	div.innerHTML=modalHTMl;
	document.body.appendChild(div);
	var children=div.children;
	var titleDIV=children[0];
	var enterProjectManager;
	var closeAble=children[1];
	var iframeDIV=children[2].children[0];
	var iframe=document.createElement('iframe');
	var length=arguments.length;
	
	var theme=arg.theme;
	if(theme!=null){
		ET.Utils.addClass(div,theme);
	}
	var loadCallFun=arg.loadFun;
	
	//这些浏览器如果第一次就设置src ，后台会显示有两次调用
	var is_first=ET.is_ie9||ET.is_ie10||ET.is_chrome;
	if(!is_first){
		iframe.src=arg.src;
	}
	iframe.frameBorder="0";
	iframe.style.backgroundColor="white";
	iframe.scrolling ="no";
	//支持iframe 里面 全屏查看视频，文档
	iframe.allowFullscreen=true;
	ET.Utils.addClass(iframe,'windowContentIFrame');
	iframeDIV.appendChild(iframe);
	var height=arg.height;
	var width=arg.width;
	/***IE7 问题奇怪 **/
	titleDIV.style.maxWidth=(width-45)+"px";
	titleDIV.style.maxHeight="44px";
	if(ET.is_ie7){
		titleDIV.style.width=(width-65)+"px";
	}
	var topHeight=document.body.clientHeight;
	if(document.compatMode=='CSS1Compat'){
		topHeight=document.documentElement.clientHeight;
	}
	if(height+titleDIV.offsetHeight+68>topHeight){
		height=topHeight-titleDIV.offsetHeight-68;
	}
	titleDIV.innerHTML=arg.title!=undefined&&arg.title!=""?arg.title:"&nbsp;&nbsp;&nbsp;";
	iframeDIV.style.height=height+"px";
	iframeDIV.style.width=(width)+"px";
	//此处几个值的计算 是兼容原来的弹出框
	var config={};
	for(key in arg){
		if(config[key]==undefined){
			config[key]=arg[key];
		}
	}
	config.title=titleDIV;
	var _currentWindow=new ET.EasyTrack.window(div,config);
	_currentWindow.isEasyTrackWindow=true; //标识是原始 弹出层window
	_currentWindow.iframeDIV=iframeDIV;
	_currentWindow.iframe=iframe;
	_currentWindow.titleDIV=titleDIV;
	_currentWindow.show();
	if(is_first){ 
		iframe.src=arg.src;
	}
	
	var loadFun=function(){
		try{
			var iWindow=iframe.contentWindow;
			var popBodyDIV=iWindow.document.body.children[0];
			if(top.ET.appStylePath!=null&&iWindow.ET.loadAppStyle){
				iWindow.ET.loadAppStyle(top.ET.appStylePath);
			}
			if (typeof loadCallFun === 'function') {
				loadCallFun(); 
		    } 
		}catch(ex){
			
		} 
	}
	ET.Utils.addEvent(iframe,'load',loadFun);
	_currentWindow.closeAbleDIV=closeAble;
	_currentWindow._closeFun=func;
	ET.popWindows.push(_currentWindow);
	ET.Utils.addEvent(closeAble,'click',function(event){
		var newArray=[];
		for(var i=0,j=ET.popWindows.length;i<j;i++){
			if(ET.popWindows[i]!=_currentWindow){
				newArray.push(ET.popWindows[i]);
			}
		}
		ET.popWindows=newArray;
		var returnValue=_currentWindow.returnValue;
		_currentWindow.destory();
		if(_currentWindow._closeFun!=null&& typeof _currentWindow._closeFun=='function'){
			_currentWindow._closeFun(returnValue);
		}
	});
	if(canShow!=undefined&&canShow){
		var ePM=document.createElement('div');
		ePM.className="enterProjectManager";
		ePM.innerHTML=arg.projectDashboard;
		div.insertBefore(ePM,closeAble);
		ET.Utils.addEvent(ePM,'click',function(){
			document.frm.action=arg.path+"/ProjectAction.do?operation=dashboard&projectID="+arg.projectID;
			etSubmit(document.frm);
		});
	}
};


ET.closeModalWindow=function(result){
	if(ET.popWindows.length > 0) {
		var w = ET.popWindows.pop();
		if (w) {
			if(w.iframe.loadFun!=undefined){
				ET.Utils.removeEvent(w.iframe,'load',w.iframe.loadFun);
			}
			w.iframe.src="";
			w.iframe.parentNode.removeChild(w.iframe);
			if(w.isEasyTrackWindow){
				w.destory();
			}else{
				w.divObj.parentNode.removeChild(w.divObj);
			}
			//if(result!=undefined){
				w.returnValue=result;
				if(w._closeFun!=null&& typeof w._closeFun=='function'){
					w._closeFun(w.returnValue);
				}
			//}
		}
	}
};
ET.setModalWindowReturnValue =function(ret){
	if(ET.popWindows.length > 0) {
		var w = ET.popWindows[ET.popWindows.length - 1];
		if (w) {
			w.returnValue=ret;
		}	
	}
};
ET.getModalWindowReturnValue =function(){
	if(ET.popWindows.length > 0) {
		var w = ET.popWindows[ET.popWindows.length - 1];
		if (w) {
			return w.returnValue;
		}	
	}
	return null;
};
ET.evalModalWindowReturn=function(ret){
	if(ET.popWindows.length > 0) {
		var w = ET.popWindows[ET.popWindows.length - 1];
		if (w) {
			w.returnValue=ret;
			if(w._closeFun!=null&& typeof w._closeFun=='function'){
				w._closeFun(w.returnValue);
			}
		}	
	}
};

ET.setModalWindowTitle=function(titleHtml){
	if(ET.popWindows.length > 0) {
		var w = ET.popWindows[ET.popWindows.length - 1];
		if (w) {
			if(w.titleContainer!=undefined){
				w.titleContainer.innerHTML=titleHtml;
			}
		}	
	}
};
ET.setModalWindowTheme=function(theme){
	if(ET.popWindows.length > 0) {
		var w = ET.popWindows[ET.popWindows.length - 1];
		if (w) {
			ET.Utils.addClass(w.container,theme);
		}	
	}
};

ET.setModalWindowSize=function(width,height){
	if(ET.popWindows.length > 0) {
		var w = ET.popWindows[ET.popWindows.length - 1];
		if (w) {
			if(w.isEasyTrackWindow){
				w.iframeDIV.style.height= (height-w.titleDIV.offsetHeight-24)+"px";
				w.iframeDIV.style.width=(width-10)+"px";
			}
		}	
	}
};
ET.loadAppStyle=function(stylePath){
	var link = document.createElement('link');
	link.type = "text/css";
	link.rel = 'stylesheet';
	link.href=stylePath;
	var head=document.getElementsByTagName('head')[0];
	head.appendChild(link);
	return link;
}
ET.showNewWindow=function(arg,func, callFun){
	/**
	 * arg：加载路径 ，title
	 * func :关闭回调函数
	 * callFun：可选参数，加载后页面回调函数 ，也可以通过arg.loadFun 配置
	 */
	var div=document.createElement('div');
	var length=arguments.length;
	var loadCallFun=arg.loadFun;
	if(length==3){
		loadCallFun=arguments[2];
	}
	var showTitle=arg.title!=undefined;
	if(arg.showTitle!=undefined){
		showTitle=arg.showTitle;
	}
	var modalHTMl= showTitle?"<div class='titleContianerDIV' ><div class='titleContainer'></div><div class='windowCloseAble'></div></div>":"";
				modalHTMl+="<div class='windowContent'><div class='windowContentFrameDIV'></div></div>";
	div.innerHTML=modalHTMl;
	div.className="uiDom uiWindowNew";
	if(arg.containerClass!=null){
		ET.Utils.addClass(div,arg.containerClass);
	}
	//div.style.zIndex=ET.zIndex++;
	var children=div.children;
	var titleDIV=showTitle? children[0].children[0]:null;
	var closeAble=showTitle?children[0].children[1]:null;
	if(showTitle){
		var returnBackTitle=arg.returnBackTitle;
		if(returnBackTitle==undefined){
			returnBackTitle=ET.label["WindowReturnList"];
		}
		closeAble.innerHTML=returnBackTitle;
	}
	var iframeDIV=showTitle?children[1].children[0]:children[0].children[0];
	var iframe=document.createElement('iframe');
	//这些浏览器如果第一次就设置src ，后台会显示有两次调用
	var is_first=ET.is_ie9||ET.is_ie10||ET.is_chrome;
	if(!is_first){
		iframe.src=arg.src;
	}
	iframe.frameBorder="0";
	iframe.style.backgroundColor="white";
	iframe.scrolling ="no";
	
	var doc=document;
	var loadFun=function(){
		var iWindow=iframe.contentWindow;
		var popBodyDIV=iWindow.document.body.children[0];
		try{
			if(top.ET.appStylePath!=null&&iWindow.ET.loadAppStyle){
				iWindow.ET.loadAppStyle(top.ET.appStylePath);
			}
			if(iWindow.ET.Utils.hasClass(popBodyDIV,'popBodyDIV')){
				ET.Utils.addClass(popBodyDIV,'popBodyDIVNew');
			}
			
			iWindow.ET.Utils.addEvent(iWindow.document.body,'click',function(event){
				if(doc.body.click){
					doc.body.click();
				}else{
					if(doc.createEvent){
						var event=doc.createEvent('HTMLEvents');
			　　			event.initEvent('click',true,true);
			　　		iframe.parentNode.dispatchEvent(event);
					}
				}
			});
		}catch(ex){
			
		} 
		if( document.createEvent) {
			var event = iWindow.document.createEvent ("HTMLEvents");
			event.initEvent("resize", true, true);
			iWindow.dispatchEvent(event);
		} else {
			iWindow.ET.Utils.windowResize();
		}
		if (typeof loadCallFun === 'function') {
			loadCallFun(); 
	    } 
	}
	iframe.loadFun=loadFun;
	if(showTitle){
		ET.Utils.addClass(iframeDIV.parentNode,'showTitle');
	}
	//支持iframe 里面 全屏查看视频，文档
	iframe.allowFullscreen=true;
	ET.Utils.addClass(iframe,'windowContentIFrame');
	iframeDIV.appendChild(iframe);
	
	var showContainerID=arg.containerID;
	var contentDIV=null;
	if(showContainerID==undefined){
		showContainerID='bodyStart__content_Wrap';
	}
	if(typeof showContainerID=='string'){
		contentDIV=document.getElementById(showContainerID);
	}else{
		contentDIV=showContainerID;
	}
	if(contentDIV==null){
		contentDIV=document.body;
	}
	contentDIV.appendChild(div);
	var isIE7=ET.is_ie7;
	if(isIE7){
		var resizeFun=function(){
			iframe.style.width=iframeDIV.clientWidth+"px";
			iframe.style.height=iframeDIV.clientHeight+"px";
		}
		resizeFun();
		ET.addToggleLeftEvent(resizeFun);
		ET.Utils.addEvent(window,'resize',resizeFun);
	}
	//此处几个值的计算 是兼容原来的弹出框
	var config={};
	for(key in arg){
		if(config[key]==undefined){
			config[key]=arg[key];
		}
	}
	var _currentWindow={};
	_currentWindow.titleContainer=titleDIV;
	_currentWindow.divObj=div;
	_currentWindow.closeAbleDIV=closeAble;
	ET.popWindows.push(_currentWindow);
	if(showTitle){
		titleDIV.innerHTML=arg.title!=undefined&&arg.title!=""?arg.title:"&nbsp;&nbsp;&nbsp;";
		config.title=titleDIV;
		_currentWindow.titleDIV=titleDIV;
	}
	_currentWindow.iframeDIV=iframeDIV;
	_currentWindow.iframe=iframe;
	if(is_first){ 
		iframe.src=arg.src;
	}
	ET.Utils.addEvent(iframe,'load',loadFun);
	_currentWindow._closeFun=func;
	if(showTitle){
		ET.Utils.addEvent(closeAble,'click',function(event){
			ET.Utils.addClass(closeAble,'windowCloseAbleHover');
			window.setTimeout(function(){
				var newArray=[];
				for(var i=0,j=ET.popWindows.length;i<j;i++){
					if(ET.popWindows[i]!=_currentWindow){
						newArray.push(ET.popWindows[i]);
					}
				}
				ET.popWindows=newArray;
				var returnValue=_currentWindow.returnValue;
				_currentWindow.iframe.parentNode.removeChild(_currentWindow.iframe);
				_currentWindow.divObj.parentNode.removeChild(_currentWindow.divObj);
				if(_currentWindow._closeFun!=null&& typeof _currentWindow._closeFun=='function'){
					_currentWindow._closeFun(returnValue);
				}
			},100	);
			
		});
	}
	var canShow=arg.canShow;
	if(canShow!=undefined&&canShow){
		var ePM=document.createElement('div');
		ePM.className="enterProjectManager";
		ePM.innerHTML=arg.projectDashboard;
		div.insertBefore(ePM,closeAble);
		ET.Utils.addEvent(ePM,'click',function(){
			document.frm.action=arg.path+"/ProjectAction.do?operation=dashboard&projectID="+arg.projectID;
			etSubmit(document.frm);
		});
	}
	var returnListTitleShow=arg.returnListTitleShow;
	var isApproval=arg.isApproval;
	if(returnListTitleShow!=undefined&&returnListTitleShow){
		var rlTitle=document.createElement("div");
		rlTitle.className="returnListTitle";
		rlTitle.innerHTML=arg.returnListTitle;
		div.insertBefore(rlTitle,closeAble);
		ET.Utils.addEvent(rlTitle,'click',function(){
			var operation ="listExpenses";
			if(isApproval!=undefined&&isApproval){
				operation ="myExpenses";
			}
			document.frm.action=arg.path+"/ExpenseSheetAction.do?operation="+operation;
			etSubmit(document.frm);
		});
	}
};
ET.showNewUserSelect=function(config){
	var defaultConfig={
		isMulti:true
		,canReturnNull:false
		,isShowProject:false
		,callBack:function(ret){
		}
	};
	var url=[];
	var showConfig={};
	for(var key in defaultConfig){
		if(config[key]==undefined){
			showConfig[key]=defaultConfig[key];
			if( typeof showConfig[key]!='object' && typeof showConfig[key]!='function'){
				url.push(key+"="+encodeURIComponent(showConfig[key]));
			}
		}
	}
	if(config!=null){
		for(var key in config){
			showConfig[key]=config[key];
			if( typeof showConfig[key]!='object' && typeof showConfig[key]!='function'){
				url.push(key+"="+encodeURIComponent(showConfig[key]));
			}
		}
	}
	if(config.currentIDField!=null){
		top.ET.currentIDField=config.currentIDField;
	}
	top.ET.showModalWindow({
		theme:'search',
		width:630||showConfig['width']
		,height:430||showConfig['height']
		,src:ET.etPath+"/../../../UserAction.do?operation=userSelectCommon2&_id="+Math.random()+"&"+url.join("&")
	},function(ret){
		showConfig.callBack(ret);
	})
};
ET.MainScroll=function(scrollDIV,config){
	config=config||{};
	var div=document.getElementById(scrollDIV);
	function srollFun(){
		var bodyHeight=0;
		if(document.compatMode=='CSS1Compat'){
			bodyHeight=document.documentElement.clientHeight;
		}else{
			bodyHeight=document.body.clientHeight;
		}
		var bottomHeight=config.bottomHeight||0;
		var height=bodyHeight-div.getBoundingClientRect().top-bottomHeight;
		if(height<=0){
			height=0;
		}
		div.style.height=height+"px";
		div.style.overflow="auto";
		div.resizeFun=srollFun;
	}
	ET.Utils.addEvent(window,'load',srollFun);
	if(div.resizeFun==null){
		ET.Utils.addEvent(window,'resize',srollFun);
	}
	srollFun();
};
ET.SearchScroll=function(div,config){
	config=config||{
		destoryHtml:false
	};
	if(typeof div=="string"){
		div=document.getElementById(div);
	}
	var bodyHeight=0;
	if(document.compatMode=='CSS1Compat'){
		bodyHeight=document.documentElement.clientHeight;
	}else{
		bodyHeight=document.body.clientHeight;
	}
	var height=bodyHeight-div.getBoundingClientRect().top-0;
	var bottomHeight=57||config.bottomHeight;
	height-=bottomHeight;
	if(height<=0){
		height=0;
	}
	div.style.height=height+"px";
	var scrollBar=new ET.ScrollBar(div,config);
	parent.ET.setModalWindowTheme("search");
	return scrollBar;
}
ET.ajax = function() {
	return {
		/**
		 * 向url发送ajax请求
		 * @param url
		 * @param ajaxOptions
		 */
		request:function(url, ajaxOptions) {
            var ajaxRequest = creatAjaxRequest(),
                //是否超时
                timeIsOut = false,
                //默认参数
                defaultAjaxOptions = {
                    method:"POST",
                    timeout:15000,
                    async:true,
                    data:{},//需要传递对象的话只能覆盖
                    onsuccess:function() {
                    },
                    onerror:function() {
                    }
                };

			if (typeof url === "object") {
				ajaxOptions = url;
				url = ajaxOptions.url;
			}
			if (!ajaxRequest || !url) return;
			if(ajaxOptions!=null){
				for(var key in defaultAjaxOptions){
					if(ajaxOptions[key]==undefined){
						ajaxOptions[key]=defaultAjaxOptions[key];
					}
				}
			}else{
				ajaxOptions=defaultAjaxOptions;
			}
			var ajaxOpts=ajaxOptions;
			var submitStr = json2str(ajaxOpts);  // { name:"Jim",city:"Beijing" } --> "name=Jim&city=Beijing"
			//如果用户直接通过data参数传递json对象过来，则也要将此json对象转化为字符串
			if (typeof(ajaxOpts.data)=='Object'){
                submitStr += (submitStr? "&":"") + json2str(ajaxOpts.data);
			}
			//ajaxRequest.timeout=ajaxOpts.timeout;
            //超时检测
            var timerID = setTimeout(function() {
                if (ajaxRequest.readyState != 4) {
                    timeIsOut = true;
                    ajaxRequest.abort();
                    clearTimeout(timerID);
                }
            }, ajaxOpts.timeout);
            
			var method = ajaxOpts.method.toUpperCase();
            var str = url + (url.indexOf("?")==-1?"?":"&") + (method=="POST"?"":submitStr+ "&noCache=" + +new Date);
			ajaxRequest.open(method, str, ajaxOpts.async);
			ajaxRequest.onreadystatechange = function() {
				if (ajaxRequest.readyState == 4) {
					if (!timeIsOut && ajaxRequest.status == 200) {
						ajaxOpts.onsuccess(ajaxRequest);
					} else {
						ajaxOpts.onerror(ajaxRequest);
					}
				}
			};
			
			if (method == "POST") {
				ajaxRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
				var headerObj=ajaxOpts.header;
				if (typeof headerObj=='object'){
	                for(var header in headerObj ){
	                		if (!((typeof headerObj[key]).toLowerCase() == "function" || (typeof headerObj[key]).toLowerCase() == "object")) {
								ajaxRequest.setRequestHeader(header, headerObj[header]);
	                		}
	                }
				}
				ajaxRequest.send(submitStr);
			} else {
				ajaxRequest.send(null);
			}
			return ajaxRequest;
		}
		
	};

	/**
	 * 将json参数转化成适合ajax提交的参数列表
	 * @param json
	 */
	function json2str(json) {
		var strArr = [];
		for (var i in json) {
			//忽略默认的几个参数
			if(i=="method" || i=="timeout" || i=="async" ||  i=="header") continue;
			//传递过来的对象和函数不在提交之列
			if (!((typeof json[i]).toLowerCase() == "function" || (typeof json[i]).toLowerCase() == "object")) {
				strArr.push( encodeURIComponent(i) + "="+encodeURIComponent(json[i]) );
			}
		}
		return strArr.join("&");
	}

	/**
	 * 创建一个ajaxRequest对象
	 */
	function creatAjaxRequest() {
		var xmlHttp = null;
		if (window.XMLHttpRequest) {
			xmlHttp = new XMLHttpRequest();
		} else {
			try {
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
				}
			}
		}
		return xmlHttp;
	}
}();


function et_attention_button_initFun(){
	var $=jQuery;
	$("#attention_hidden_div > .ET_ToolbarButtonContainer").css("margin","0px");
	$("#attention_hidden_div span").css("padding","0px");
	$("#attention_hidden_div .ET_ToolbarButtonImg").css({"margin-left":"0px","margin-right":"3px"});
	
	var jQcloseAble = $(".windowCloseAble",window.parent.document);
	var curJQcloseAble = jQcloseAble[jQcloseAble.length-1]; //多重弹框的时候会生成多个.windowCloseAble,最上层弹框的.windowCloseAble在最后面
	if($("#attention_hidden_div").length>0){
		$("#attention_hidden_div",curJQcloseAble.parentNode).remove(); //删除当前弹框或者页面中的attention_hidden_div，避免从一个有关注的页面切到另一个有关注的页面生成两个关注图标
	}
	if($("#attention_hidden_div",window.parent.document).length>0){
		$("#attention_hidden_div",curJQcloseAble.parentNode).remove();//删除当前弹框或者页面中的attention_hidden_div，避免从一个有关注的页面切到另一个有关注的页面生成两个关注图标
	}
	$(curJQcloseAble).before($("#attention_hidden_div")); 
//	$(".windowCloseAble",window.parent.document).before($("#attention_hidden_div"));
	
	$("#attention_hidden_div",window.parent.document).css("right","46px");
	if($(".windowCloseAble",window.parent.document).width()>20){
		$("#attention_hidden_div",window.parent.document).css("right","85px");
		$("#attention_hidden_div",window.parent.document).offset({top:$(".windowCloseAble",window.parent.document).offset().top});
		$("#attention_hidden_div > .ET_ToolbarButtonContainer",window.parent.document).css("height","29px");
	}
}
function toogleAttrention(obj,path,objectId,objectType,objectSubType){
	_toogleAttention(path, objectId, objectType, objectSubType, function(ajaxRequest){
		if(obj){
			var jq_obj = $(obj);
	   		var cls=jq_obj.attr("class");
	    	if(cls.indexOf("attentedBigImg")>-1){
	    		jq_obj.removeClass("attentedBigImg");
	    		jq_obj.addClass("noAttentedBigImg");
	    		jq_obj.attr("title",ET.label["task_attention"]);
	    		
	    		var jq_attentionObj = $("[name='attentionObj_"+objectId+"']");
	    		if(jq_attentionObj[0]){
	    			jq_attentionObj.removeClass("attentedImg");
	    			jq_attentionObj.addClass("noAttentedImg" );
	    			jq_attentionObj.attr("title",ET.label["task_attention"]);
	    			jq_attentionObj.css("visibility","hidden");
	    		}
	    	}else{
	    		jq_obj.removeClass("noAttentedBigImg");
	    		jq_obj.addClass("attentedBigImg" );
	    		jq_obj.attr("title",ET.label["attented"]);
				
				var jq_attentionObj = $("[name='attentionObj_"+objectId+"']");
	    		if(jq_attentionObj[0]){
	    			jq_attentionObj.removeClass("noAttentedImg");
	    			jq_attentionObj.addClass("attentedImg" );
	    			jq_attentionObj.attr("title",ET.label["attented"]);
	    			jq_attentionObj.css("visibility","visible");
	    		}
			}
		}
	});
}

function toogleAttrentionInList(obj,path,objectId,objectType,objectSubType){
	_toogleAttention(path, objectId, objectType, objectSubType, function(ajaxRequest){
		if(obj){
			var jq_obj = $(obj);
			var cls=jq_obj.attr("class");
	    	if(cls.indexOf("attentedImg")>-1){
	    		jq_obj.removeClass("attentedImg");
	    		jq_obj.addClass("noAttentedImg" );
	    		jq_obj.attr("title",ET.label["task_attention"]);
	    	}else{
	    		jq_obj.removeClass("noAttentedImg");
	    		jq_obj.addClass("attentedImg" );
	    		jq_obj.attr("title",ET.label["attented"]);
			}
		}
	});
}

function _toogleAttention(path,objectId,objectType,objectSubType,successFun){
	var paramter = {"objectID": objectId,
		       		"objectType":objectType,
		       		"objectSubType":objectSubType,
		       url : path+"/CommunicationAction.do?operation=interactive&_t=" + Math.random()
	};
	
	ET.ajax.request(paramter);
	paramter.onsuccess = successFun;
}
function getAllCheckbox(){
	var domList = document.getElementsByTagName('input')  // checkbox属于input，所以通过getElementsByTagName即标签名获取所有的input数组，包含文本框text，单选按钮radio，复选框checkbox等等
	var checkBoxList = [];  // 定义一个存储checkbox的空数组
	var len = domList.length;　　//缓存到局部变量  // 第一步获取的数组的长度
	while (len--) {　　//使用while的效率会比for循环更高   // 开始循环判断
	　　if (domList[len].type == 'checkbox') {   // 如果类型为checkbox即为题目所需的复选框
	  　　checkBoxList.push(domList[len]);          // 就把那个元素加入到上面定义的数组中
	　　}  
	}
	return checkBoxList;
}
function checkbox_bindIMG(){
	var checkBoxList=getAllCheckbox();
	for(var i=0;i<checkBoxList.length;i++){
		var cb=checkBoxList[i];
		if(cb.style.display=="none"){
			continue;
		}
		cb.style.display="none";
		var cbImg=document.getElementById("checkbox_img_clonenode").cloneNode(true);
		cbImg.removeAttribute("id");
		var className='checkbox_imgDIV  ';
		cbImg.className=className;
		if(cb.checked){
			if(cb.disabled){
				ET.Utils.addClass(cbImg,"checkbox_disable_checked");
			}else{
				ET.Utils.addClass(cbImg,"checkbox_checked");
			}
		}else{
			if(cb.disabled){
				ET.Utils.addClass(cbImg,"checkbox_disable_nochecked");
			}else{
				ET.Utils.addClass(cbImg,"checkbox_nochecked");
			}
		}
	   // IE8 IE7 选择器无法支持input[type='checkbox']:checked所以使用onpropertychange事件监听
	    cb.setAttribute("onpropertychange","checkbox_property_change(this)");
		if (cb.parentNode.lastChild == cb) {
	        cb.parentNode.appendChild(cbImg);
	    } else {
	        cb.parentNode.insertBefore(cbImg, cb.nextSibling);
	    }
	}
}
function checkbox_property_change(obj){
	var cbImg=obj.nextSibling;
	if(obj.disabled){
		return;
	}
	ET.Utils.removeClass(cbImg,"checkbox_moveover");
	if(obj.checked){
		ET.Utils.removeClass(cbImg,"checkbox_nochecked");
		ET.Utils.addClass(cbImg,"checkbox_checked");
	}else{
		ET.Utils.removeClass(cbImg,"checkbox_checked");
		ET.Utils.addClass(cbImg,"checkbox_nochecked");
	}
}
function checkboxIMG_onmouseover(obj){
	if(!obj.previousSibling.checked &&　!obj.previousSibling.disabled){
		ET.Utils.addClass(obj,"checkbox_moveover");
	}
}
function checkboxIMG_onmouseout(obj){
	if(!obj.previousSibling.checked &&　!obj.previousSibling.disabled){
		ET.Utils.removeClass(obj,"checkbox_moveover");
	}
}
function checkboxIMG_clickFun(obj,event){
	if(!obj.previousSibling.disabled){
		if(!obj.previousSibling.checked){
			ET.Utils.removeClass(obj,"checkbox_moveover");
		}
		obj.previousSibling.click();
	}
}

ET.Utils.addEvent(window,'load',function(){
	var div=document.createElement("div");
	div.style.display="none";
	div.innerHTML="<img  src=\"/static/images/16x16/empty.png\"  id=\"checkbox_img_clonenode\"  onclick=\"checkboxIMG_clickFun(this,event)\" onmouseover=\"checkboxIMG_onmouseover(this)\" onmouseout=\"checkboxIMG_onmouseout(this)\"/>";
	document.body.appendChild(div);
	checkbox_bindIMG();
});

ET.FormSelectSearch=function(idField,nameField,config){
	var input=idField;
	config=config||{};
	var values=config.values||{};
	var selectEvent=config.selectEvent;
	function getData(searchValue){
		var data=[];
		searchValue=searchValue.toLowerCase().trim();
		if(config.noEmpty!=true){
			data.push("<div class='formSelectSearchItem' attr_id=\"\">&nbsp;</div>");
		}
		for(var i=0,j=values.length;i<j;i++){
			var name=values[i].value;
			if(""==searchValue|| name.toLowerCase().indexOf(searchValue)>=0){
				data.push("<div class='formSelectSearchItem' attr_id=\"");
				data.push(values[i].id);
				data.push("\" ");
				data.push(">");
				data.push(name);
				data.push("</div>");
			}
		}
		return data.join("");
	}
	var callBack=function(searchValue){
		window.clearTimeout(nameField.timeoutID);
		nameField.timeoutID=window.setTimeout(function(){
			var width=nameField.parentNode.clientWidth;
			floatController.popup(nameField,width-5);
			floatController.floatDIV.innerHTML=getData(searchValue);
			$(floatController.floatDIV).css("border-color",$(nameField).parent("div").css("border-color")).css("padding-left",5);
			var items=$(floatController.floatDIV).find(".formSelectSearchItem");
			items.on("click.itemClick",function(event){
				var id=$(this).attr("attr_id");
				input.value=id;
				nameField.value=$(this).text();
				floatController.hide();
				floatController.floatDIV.innerHTML='';	
				if(selectEvent!=null&&typeof selectEvent=="function"){
					selectEvent();
				}
			})
		},100);
	}

	$(nameField).on("keyup ",function(){
		var searchValue=nameField.value;
		callBack(searchValue);
	}).css("outline","none").attr("autocomplete","off");
	
	var img=$(input).parent("div").find("img");
	img.css("cursor","pointer");
	img.on("click",function(){
		callBack("");
	});
}

