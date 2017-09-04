/** 选择联系人核心处理文件 */
ET.SelectUser = function(config) {
	var opts = $.extend({}, ET.SelectUser.defaultConfig, config);     
	this.config = opts;
	this.initial();
};
ET.SelectUser.defaultConfig = {
	path: "/pm",
	/**
	 * 搜索结果显示区域 的ID
	 */
	resultSelect: 'resultDIV',  //搜索结果展示区域
	userSelect: '.userItem',    //
	searchValue: 'searchValue', //搜索框里的检索字段值
	/**
	 * 是否多选
	 */
	isMutil: true,
	
	/**
	 * 已选的显示区域
	 */
	alreadySelect: 'already_selectDIV', //已选择的联系人展示区域
	selectCountTag: 'selectCountTag',   //已选择的人员总数
	clearAllTag: 'clearAll',            //清空所有
	rootDepartmentID: 69,
	loadMore: '加载更多',
	loadMoreBatch: 100,
	scrollLoadBatch: 30
};
/** 
 * 已选择的总数 
 */
ET.SelectUser.prototype.freshTotal = function() {
	var _self = this;
	_self.selectCountTag.text(_self.getSelectSize());
};
/** 
 * 获取已选择的总数 
 */
ET.SelectUser.prototype.getSelectSize = function() {
	var _self = this;
	var size = _self.alreadySelectCacheArray.length;
	return size;
};
/**
 * 初始化拖拽
 */
ET.SelectUser.prototype.initialDrag = function(select) {
	
};
/**
 * 懒加载（滚动）事件
 */
ET.SelectUser.prototype._addScrollDataEvent = function() {
	var _self = this;
	var $ = jQuery;
	var resultScrollYEvent = function( ){
		var scrollData = _self.toScrollData;
		if(scrollData!=null && scrollData.length>0){
			var data = null;
			var eachDataArray = scrollData.splice(0, scrollData.length > _self.config.scrollLoadBatch ? _self.config.scrollLoadBatch : scrollData.length);
			for(var i=0,j=eachDataArray.length; i<j; i++){
				data = eachDataArray[i];
				var html = [];
				html.push("<div class='userItem'   id=\"resultDIV" + data.userID + "\">");
					html.push("<div  class=\"userPhoto\">");
					html.push("<img src=\"" + _self.config.path + "/AttachAction.do?operation=readUserPhoto&userID=" + data.userID + "\"  />");
					html.push("</div>");
					var checked = _self.alreadySelectCache[data.userID] != undefined;
					html.push("<div  class=\"checkUser " + (checked?" checked":"") + "\"   ></div>");
					html.push("<div   class=\"userNameDepart\"   >");
						html.push("<div  class=\" nowrapText user-name-div\"  ></div>");
						html.push("<div   class=\" nowrapText user-depart-div\"  ></div>");
					html.push("</div>");
				html.push("</div>");
				var div = $(html.join(""));
				div.attr("data-userID", data.userID).attr("data-displayName", data.displayName).attr("data-name", data.userName).attr("data-departName", data.departName).attr("data-depart", data.depart);
				div.find(" .userNameDepart .user-name-div").attr("title", data.userName).text(data.displayName);
				if(_self.searchType != "project"){
					div.find(" .userNameDepart .user-depart-div").attr("title", data.departName).text(data.departName);
				}else{
					div.find(" .userNameDepart .user-depart-div").attr("title", data.roleName).text(data.roleName);
				}
				_self.resultSelectBarDIV.append(div);
			}
			_self.resultSelectBar.resize();
		}
	};
	_self.resultSelectBar.config.scrollYEvent = function() {
		window.clearTimeout(resultScrollYEvent.timeoutID);
		resultScrollYEvent.timeoutID = window.setTimeout(function() {
			resultScrollYEvent();
		}, 20);
	};
	
	var alreadyScrollYEvent = function( ){
		var scrollData = _self.alreadyScrollData;
		if(scrollData!=null && scrollData.length>0){
			var data = null;
			var eachDataArray = scrollData.splice(0, scrollData.length > _self.config.scrollLoadBatch ? _self.config.scrollLoadBatch : scrollData.length);
			for(var i=0,j=eachDataArray.length; i<j; i++){
				data = eachDataArray[i];
				var html = [];
				html.push("<div class='userItem'   id=\"already_selectDIV" + data.userID + "\">");
					html.push("<div  class=\"userPhoto\">");
					html.push("<img src=\"" + _self.config.path + "/AttachAction.do?operation=readUserPhoto&userID=" + data.userID + "\"  />");
					html.push("</div>");
					var checked = _self.alreadySelectCache[data.userID] != undefined;
					html.push("<div  class=\"deleteUser\"   ></div>");
					html.push("<div   class=\"userNameDepart\"   >");
						html.push("<div  class=\" nowrapText user-name-div\"  ></div>");
						html.push("<div   class=\" nowrapText user-depart-div\"  ></div>");
					html.push("</div>");
				html.push("</div>");
				var div = $(html.join(""));
				div.attr("data-userID", data.userID).attr("data-displayName", data.displayName).attr("data-name", data.userName).attr("data-departName", data.departName).attr("data-depart", data.depart);
				div.find(" .userNameDepart .user-name-div").attr("title", data.userName).text(data.displayName);
				div.find(" .userNameDepart .user-depart-div").attr("title", data.departName).text(data.departName);
				_self.alreadySelectBarDIV.append(div);
			}
			_self.alreadySelectBarDIV.resize();
		}
	};
	_self.alreadySelectBar.config.scrollYEvent = function() {
		window.clearTimeout(alreadyScrollYEvent.timeoutID);
		alreadyScrollYEvent.timeoutID = window.setTimeout(function() {
			alreadyScrollYEvent();
		}, 20);
	};
};
/**
 * 初始化
 */
ET.SelectUser.prototype.initial = function() {
	var _self = this;
	var config = _self.config;
	var $ = jQuery;
	//获取搜索结果展示区域的DIV
	_self.resultSelect = $("#" + config.resultSelect);
	_self.resultSelectBar = new ET.ScrollBar(_self.resultSelect.get(0).id, {
		resizeAble: false
	});
	//获取配置项信息，是否支持多选
	var isMutil = _self.config.isMutil;
	//获取已选择的结果展示区域DIV
	_self.alreadySelect = $("#" + config.alreadySelect);
	_self.alreadySelectBar = new ET.ScrollBar(_self.alreadySelect.get(0).id, {
		resizeAble: false
	});
	//_self.initialDrag(_self.config.userSelect);
	//右边结果展示域顶部的Bar条(已选择)
	_self.alreadySelectBarDIV = $(_self.alreadySelectBar.contentDIV);
	var selectCountTag = $("#" + config.selectCountTag);
	_self.selectCountTag = selectCountTag;
	//改变已选择的总数量(显示--顶部Bar)
	var changeSelectAll = function(){
		_self.freshTotal();
	};
	//左边结果展示域顶部的Bar条(待选择)
	_self.resultSelectBarDIV = $(_self.resultSelectBar.contentDIV);
	_self.alreadySelectCache = _self.config.alreadySelectCache||{};
	_self.searchValue = $("#" + config.searchValue);
	var searchValueEvent = function() {
		_self.doSearch();
	};
	//左边顶部搜索框键盘事件监听
	_self.searchValue.on('keyup', function(event) {
		var value = jQuery.trim(this.value);
		if(this.lastValue==null || value!=this.lastValue) {
			window.clearTimeout(searchValueEvent.timeoutID);
			this.lastValue = value;
			searchValueEvent.timeoutID = window.setTimeout(function() {
				searchValueEvent();
			}, 200);
		}
	});
	//懒加载（滚动）事件
	_self._addScrollDataEvent();
	
	//右边已选择顶部点击事件(清空已选择的)
	var clearAllObj = $("#"+_self.config.clearAllTag);
	clearAllObj.on('click', function() {
		for(var userID in _self.alreadySelectCache) {
			//var dom=$("#"+_self.config.alreadySelect +userID);
			$("#" + _self.config.resultSelect+userID).find('.checkUser').removeClass('checked');
			//dom.remove();
		}
		_self.alreadySelectBarDIV.html("");
		//存储已选择的用户map
		_self.alreadySelectCache = {};
		//存储已选择的用户数组
		_self.alreadySelectCacheArray = [];
		//存储需要懒加载的数据
		_self.alreadyScrollData = [];
		_self.alreadySelectBar.resize();
		//改变已选择的总数量(显示--顶部Bar)
		changeSelectAll();
	});
	
	//加载(按部门筛选)
	var loadDepartUser = function(departID) {
		var childrenDIV = $("#departchildren" + departID);
		var departUserData = _self.departUserLoadData[departID];
		var departArray = _self.departLoadData[departID].children;
		
		//创建片段装载用户数据(用户列表项)
		if(departUserData!=null && departUserData.length>0){
			var userFrag = $(document.createDocumentFragment());
			var size = _self.config.loadMoreBatch - departArray.length;
			var addUserData = departUserData.splice(0, Math.min(size, departUserData.length ));
			for(var i=0, j=addUserData.length; i<j; i++){
				var userData = addUserData[i];
				var html = [];
				html.push("<div id='resultDIV" + userData.userID + "' class='userItem'><span class='user-name-div'></span> ");
				html.push("<div class='checkUser' ></div></div>");
				var dom = $(html.join(''));
				dom.attr("data-userID", userData.userID);
				dom.attr("data-displayName", userData.displayName);
				dom.attr("data-name", userData.userName);
				dom.attr("data-depart", userData.depart	);
				dom.attr("data-departName", userData.departName	);
				dom.find(".user-name-div").text(userData.displayName).attr("title", userData.userName);
				var checked = _self.alreadySelectCache[userData.userID] != undefined;
				if(checked){
					dom.find("div.checkUser").addClass('checked');
				}
				userFrag.append(dom);
			}
			var haseLoadMore = $("#departUserMore" + departID);
			if(haseLoadMore.size() == 0){
				var html = "<div id='departUserMore" + departID + "' class='user-loadMorm'  departID='" + departID + "' ></div>";
				haseLoadMore = $(html);
				haseLoadMore.text(_self.config.loadMore);
				childrenDIV.append(haseLoadMore);
			}
			if(addUserData.length>0){
				userFrag.insertBefore(haseLoadMore);
			}
			if(departUserData.length == 0){
				haseLoadMore.hide();
			}
		}
	}
	var loadProjectUser = function(departID) {}
	
	var matchDepart = function(departID) {
		var matchDepartArray=_self.matchDepartArray;
		if(matchDepartArray!=null&&matchDepartArray.length>0){
			for(var i=0,j=matchDepartArray.length;i<j;i++){
				if(matchDepartArray[i]==departID){
					matchDepartArray.splice(i,1);
					return true;
				}
			}	
		}
		return false;
	}
	
	//加载(所有人)
	var loadDepartAndUser = function(depart){
		var departID = depart.attr('departID');
		var departArray = _self.departLoadData[departID].children;
		
		var frag = $(document.createDocumentFragment());
		for(var i=0,j=departArray.length; i<j; i++){
			var subDepart = departArray[i];
			if(subDepart.load){
				continue;
			}
			var html = [];
			html.push("<div class='depart-item " + (matchDepart(subDepart.id)?"depart-match":"") + " ' departID='" + subDepart.id + "'  id='depart-item" + subDepart.id + "'  >");
			html.push("<span class='depart_toogleImg ' ></span><span class='depart_name '></span></div>");
			html.push("<div id='departchildren" + subDepart.id + "' class='departchildren' ></div>" );
			var dom = $(html.join(''));
			dom.find(".depart_name").attr("title", subDepart.name).text(subDepart.name);
			frag.append(dom);
			subDepart.load = true;
		}
		 var childrenDIV = $("#departchildren" + departID);
		 childrenDIV.append(frag);
		 loadDepartUser(departID);
	}
	
	
	_self.resultSelect.on('click',' .depart-item', function(event){
		var departName = $(this);
		var dom = departName.find('.depart_toogleImg');
		var departID = departName.attr('departID');
		var children = $("#departchildren" + departID);
		if(dom.hasClass('open')) {
			dom.removeClass('open');
			children.hide();
		}else {
			dom.addClass('open');
			loadDepartAndUser(departName);
			children.show();
		}
		_self.resultSelectBar.resize();
	});
	
	//待选择(所有人)面板区域的点击事件
	_self.resultSelect.on('click', '.user-loadMorm', function(event){
		var departID = $(this).attr('departID');
		loadDepartUser(departID);
		_self.resultSelectBar.resize();
	});
	
	//删除已经选择的用户
	var deleteUser = function(userID){
		var index = -1;
		var temp = null;
		var _arry = _self.alreadySelectCacheArray;
		for(var i=0,j=_arry.length; i<j; i++){
			temp = _arry[i];
			if(temp.userID == userID){
				index = i;
				break;
			}
		}
		if(index != -1){
			_arry.splice(index, 1);
		}
	}
	
	_self.resultSelect.on('click',_self.config.userSelect,function(event){
		var dom=$(this);
		var userID=dom.attr('data-userID');
		var userCheck=dom.find('.checkUser');
		if(userCheck.hasClass('checked')){ //已经被选中 ，删除右侧被选中的
			userCheck.removeClass('checked');
			// #already_selectDIV
			$("#"+_self.config.alreadySelect +userID).remove();
			delete _self.alreadySelectCache[userID];
			deleteUser(userID);
			changeSelectAll();
		}else{
			//添加被选中的
			userCheck.addClass('checked');
			if(!isMutil){
				for(var key in  _self.alreadySelectCache){
					$("#" + _self.config.alreadySelect+key).remove();
					$("#" + _self.config.resultSelect+key).find('.checkUser').removeClass('checked');
				}
				 _self.alreadySelectCache = {};
				 _self.alreadySelectCacheArray = [];
			}
			var dataObj = {
				 userID: userID,
				 displayName: dom.attr('data-displayName'),
				 userName: dom.attr('data-name'),
		 		 depart: dom.attr('data-depart'),
		 		 departName: dom.attr('data-departName')
			}
			 _self.alreadySelectCacheArray.push(dataObj);
			 _self.alreadySelectCache[userID] = dataObj;
			 if(_self.alreadyScrollData && _self.alreadyScrollData.length>0) {
				 _self.alreadyScrollData.push(dataObj);
			 }else {
				 var cloneDom = null;
				 var data = dataObj;
				 if(dom.parent().hasClass('departchildren')) {
					 var html = [];
						html.push("<div class='userItem'   id=\"already_selectDIV" + data.userID + "\">");
							html.push("<div  class=\"userPhoto\">");
							html.push("<img src=\"" + _self.config.path + "/AttachAction.do?operation=readUserPhoto&userID=" + data.userID + "\"  />");
							html.push("</div>");
							
							html.push("<div  class=\"deleteUser\"   ></div>");
							html.push("<div   class=\"userNameDepart\"   >");
								html.push("<div  class=\" nowrapText user-name-div\" ></div>");
								html.push("<div   class=\" nowrapText user-depart-div\" ></div>");
							html.push("</div>");
						html.push("</div>");
						var div = $(html.join(""));
						div.attr("data-userID", data.userID).attr("data-displayName", data.displayName).attr("data-name", data.userName).attr("data-departName", data.departName).attr("data-depart", data.depart);
						div.find(" .userNameDepart .user-name-div").attr("title", data.userName).text(data.displayName);
						div.find(" .userNameDepart .user-depart-div").attr("title", data.departName).text(data.departName);
						cloneDom = div; 
				 }else {
					 cloneDom = dom.clone();
					 cloneDom.attr("id", _self.config.alreadySelect + userID);
					 if(_self.searchType == "project"){
						 cloneDom.find(" .userNameDepart .user-depart-div").attr("title", data.departName).text(data.departName);
					 }
					 cloneDom.find('.checkUser').removeClass('checkUser').addClass('deleteUser');
				 }
				 _self.alreadySelectBarDIV.append(cloneDom);
				 _self.alreadySelectBar.changeYScroll(cloneDom.outerHeight());
				 _self.alreadySelectBar.resize();
			 }
			 changeSelectAll();
			 _self.initialDrag(cloneDom);
		}
	});
	
	//已选择用户区域的点击事件(右边)
	_self.alreadySelect.on('click', _self.config.userSelect + ' .deleteUser ', function(event){
		var dom = $(this).parent(_self.config.userSelect);
		var userID = dom.attr('data-userID');
		$("#resultDIV" + userID).find('.checkUser').removeClass('checked');
		delete _self.alreadySelectCache[userID];
		deleteUser(userID);
		dom.remove();
		_self.alreadySelectBar.resize();
		changeSelectAll();
	});
}
/**
 * 获取最终选择的用户数据
 */
ET.SelectUser.prototype.getOldAlreadySelect = function() {
	var result = {};
	var _self = this;
	var userID = [];
	var userName = [];
	for(var i=0,j= _self.alreadySelectCacheArray.length; i<j; i++){
		var temp = _self.alreadySelectCacheArray[i];
		var cache = _self.alreadySelectCache[temp.userID];
		if(cache) {
			userID.push(temp.userID);
			userName.push(temp.displayName);
		}
	}
	result.userIds = userID.join(",");
	result.userNames = userName.join(",");
	result.userObj = {
		userID: userID,
		userName: userName
	}
	return result;
}
/**
 * 正在加载(转圈浮层)
 */
ET.SelectUser.prototype.showSearchLoading = function() {
	var _self = this;
	_self.resultSelectBarDIV.html("<div class='loadding'></div>");
	_self.resultSelectBar.resize();
};
/**
 * 搜索核心处理
 */
ET.SelectUser.prototype.doSearch = function() {
	var _self = this;
	var $ = jQuery;
	_self.showSearchLoading();
	_self.toScrollData = [];
	window.clearTimeout(_self.timeoutID);
	var ajaxRequestList = _self.ajaxRequestList;
	if(ajaxRequestList != null){
		for(var i=0,j=ajaxRequestList.length; i<j; i++){
			ajaxRequestList[i].abort(); //取消以前的未完成的请求
		}
	}
	ajaxRequestList = [];
	_self.ajaxRequestList = ajaxRequestList;
	_self.timeoutID = window.setTimeout(function() {
		var checkUser = [];
		for(var key in _self.alreadySelectCache) {
			checkUser.push(key);
		}
		
		var data = {
			searchType: _self.searchType,
			searchValue: _self.searchValue.size()==0?"": _self.searchValue.val(),
			checkUserIDArray: checkUser.join(','),
			requestRandom: Math.random()
		};
		if(_self.searchType == "project"){
			data.projectID = document.frm.projectID.value
		}
		var obj = jQuery.ajax({
			url: _self.config.path+"/UserAction.do?operation=doSearchUser",
			type: 'POST',
			data: data,
			dataType: 'html',
			success: function(html) {
				_self.resultSelectBarDIV.html($(html));
				_self.resultSelectBar.resize();
				evalScripts(html);
				if(_self.searchType == "depart"){
					if(_self.searchValue.val() == ""){
						var userDepartPath = _self.userDepartPath;
						if(userDepartPath.length > 0){
							for(var i=userDepartPath.length-1; i>=0; i--){
								$("#depart-item"+userDepartPath[i]).click();
							}
							window.setTimeout(function() {
								var currentDIV = document.getElementById("departchildren" + userDepartPath[0]);
								if(currentDIV != null) {
									currentDIV.scrollIntoView(false);
									_self.resultSelectBar.resize();
								}
							}, 200);
						}
					}else {
						//$("#depart-item"+_self.config.rootDepartmentID).find('.depart_toogleImg').click();
						var departSizeAndUserSize = 0;
						for(var key in  _self.departLoadData) {
							departSizeAndUserSize++;
						}
						for(var key in  _self.departUserLoadData) {
							departSizeAndUserSize += _self.departUserLoadData[key].length;
						}
						var loadChildren = function(depart){
							var div = $("#depart-item"+depart);
							var toogle = div.find(".depart_toogleImg");
							if(!toogle.hasClass('open')) {
								toogle.click();
							}
							var children = _self.departLoadData[depart].children;
							for(var i=0,j=children.length; i<j; i++){
								loadChildren(children[i].id);
							}
						}
						//计算部门，用户的总数
						if(departSizeAndUserSize < 300) { 
							if($("#depart-item" + _self.config.rootDepartmentID).size() == 1) {
								loadChildren(_self.config.rootDepartmentID);
								_self.resultSelectBar.resize();
							}
						}else {
							var div = $("#depart-item" + _self.config.rootDepartmentID);
							div.click();
						}
					}
				}
			}
		});
		ajaxRequestList.push(obj);
	}, 20);
};