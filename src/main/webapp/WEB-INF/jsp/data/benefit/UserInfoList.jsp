<%@ page import="org.apache.commons.io.filefilter.FalseFileFilter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import= "com.zq.commons.utils.UIUtils" %>
<%@ page import="com.zq.commons.utils.TypeUtils" %>
<%@ page import= "com.zq.vo.process.UserInfoVO" %>

<%
	String path = request.getContextPath();
	//获取联系人信息
	List<UserInfoVO> userInfoList = (List)request.getAttribute("userList");
%>

<style type="text/css">
li {list-style-type:none;}
.areas_list_one > a{background:1px 50% url('<%=path%>/static/images/benefit/tree_close.png') no-repeat; padding-left: 60px; cursor: pointer; display: inline-block;}
.areas_list_two{height: 0; overflow: hidden;padding-right:10px;padding-left: 28px;background:15px 0 url('<%=path%>/static/images/benefit/tree_line.png') repeat-y;transition: all 0.3s;}
.areas_list_two li{background:1px 50% url('<%=path%>/static/images/benefit/contact_on.png') no-repeat; padding:5px 0 5px 55px;}
.areas_list_two li span{ display: inline-block;width: 100%;background:100% 50% url('<%=path%>/static/images/benefit/select.png') no-repeat; cursor: pointer;height: 22px;}
.areas_list_two li span.hover{background:100% 50% url('<%=path%>/static/images/benefit/select_on.png') no-repeat;}
.areas_list_one.on > a{background:1px 50% url('<%=path%>/static/images/benefit/tree_open.png') no-repeat;}
ul.areas_list{ padding:0 10px;background:5px 0 url('<%=path%>/static/images/benefit/tree_line.png') repeat-y; }
</style>

<%-- 输出Head1模块 --%>
<jsp:include page="../../common/Head1.jsp" />

<script type="text/javascript">
//自动适配当前窗体高度
function autoContentHeight(){
	ET.MainScroll("contentDIV");
}
ET.Utils.addOnloadEvent(autoContentHeight);

//选择联系人核心处理器
jQuery(function($){
	//点击下拉联系人效果
	$('.areas_list').find('.areas_list_one > a').click(function() {
	    if($(this).parent().hasClass('on')){
	        $(this).parent().removeClass('on');
	        $(this).parent().next('.areas_list_two').css('height','0');
	    }else {
	        $(this).parent().addClass('on');
	        $(this).parent().next('.areas_list_two').css('height','auto');
	    }
	});
	//选中联系人
	$('.areas_list').find('.areas_list_two li').click(function() {
		//选择其他联系人前先清除已经选择的联系人
		$('.areas_list').find('.areas_list_two li').find('span').each(function(index, elem) {
			$(elem).removeClass('hover');
		}); 
		//对勾切换效果
		if(!$(this).find('span').hasClass('hover')){ 
			$(this).find('span').addClass('hover')
		}else {
			$(this).find('span').removeClass('hover');
		} 
	});
});

//确定
function OkFun() {
	console.log('================测试中==============>联系人已经被选定--');
	$('.areas_list').find('.areas_list_two li').find('span').each(function(index, elem) {
		if ($(elem).hasClass('hover')) {
			//返回下一步处理人(回调函数)
			parent.ET.closeModalWindow($(elem).text());
			return;
		}
	}); 
}

</script>

<div style="overflow: auto;" class='relativeDIV' id="contentDIV">
	<ul class="areas_list">
		<%if(userInfoList != null && userInfoList.size() > 0) {
			String tmpDeptName = "";
			int index = 1;
			for(UserInfoVO userInfo : userInfoList) {
				if(!tmpDeptName.equals(userInfo.getDeptName())) {
					tmpDeptName = userInfo.getDeptName();
					if(index == 1) {
						%>
						<li class="areas_list_one"><a><%=userInfo.getDeptName()%></a></li><ul class="areas_list_two">
						<%
					} else if(index == userInfoList.size()) { %>
						</ul>
					<%
					} else { %>
						</ul><li class="areas_list_one"><a><%=userInfo.getDeptName()%></a></li><ul class="areas_list_two">
					<% 	
					}
				} %>
					<li><span><%=userInfo.getUserName()%></span></li>
				<%
			index++;}
		}
		%>
	</ul>
</div>
<%=UIUtils.spacerDIV("5",request)%>
<div class="OKButtonBottom">
	<div class="OKButtonDIV">
		<input class="kbutton OKButton" type="button" value='确定' onclick='OkFun();'>
		<input name="cancelBtn" class="kbutton" type="button" value='关闭' onclick="parent.ET.closeModalWindow()">
	</div>
</div>
<%-- 输出公共BodyEnd模块 --%>
<jsp:include page="../../common/BodyEnd.jsp" />