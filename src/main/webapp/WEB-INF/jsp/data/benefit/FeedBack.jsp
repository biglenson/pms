<%@ page import="org.apache.commons.io.filefilter.FalseFileFilter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import= "com.zq.commons.utils.UIUtils" %>
<%
	String path = request.getContextPath();
	//获取服务器反馈信息
	String feedback = (String)request.getAttribute("feedback");
%>

<style type="text/css">
	.g_box {
        width: 240px;
    }
    .g_title {
        height: 25px;
        background: #fff;
        border-radius: 5px 5px 0 0;
        border-bottom: 1px solid #eef0f1;
        line-height: 20px;
        padding-left: 10px;
        font-size: 14px;
        font-weight: 700;
        color: #535e66;
    }
    .g_msg {
        position: relative;
        top: -10px;
        font-size: 13px;
    }   
    .g_cont {
	    height: 45px;
	    background: #fff;
	    padding-top: 30px;
	    text-align: center;
	}
	.g_buttom {
        border-top: 1px solid #eef0f1;
        border-radius: 0px 0px 5px 5px;
        background: #fff;
        line-height: 60px;
    }    
    .OKButton {
	    text-align: right;
	    background-color: #FFF;
	    padding-right: 15px;
	    margin-top: 5px;
	}
</style>

<%-- 输出Head1模块 --%>
<jsp:include page="../../common/Head1.jsp" />

<!-- 内容主体 -->
<form name="frm" action="" method="GET" id="feedback">
<input type="hidden" name="operation" value="">
<input type="hidden" name="evalInfo" value="">

<div id="contentDIV">
	<div class="g_box">
        <div class="g_title">提示</div>
        <div class="g_cont">
        	<span class="g_msg"><%=feedback%></span>
        </div>
	</div>
</div>
<div class="OKButtonBottom">
	<div class="g_buttom">
         <div class="OKButton">
		<input class="kbutton OKButton" type="button" value='确定' onclick="parent.ET.closeModalWindow()">
	</div>
    </div>
</div>
</form>

<%-- 输出公共BodyEnd模块 --%>
<jsp:include page="../../common/BodyEnd.jsp" />