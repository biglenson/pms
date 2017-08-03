<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<head>
<title>TEST</title>
<link rel="icon" href="favicon.ico" type="image/x-icon">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="/static/css/style_new.css" rel="stylesheet" type="text/css">
<link href="/static/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="/static/js/jquery/jquery-1.7.2.min.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
<%! String str = "Hello Lenson !"; %>

<h1> TEST <%= str %> sg</h1>
<h1><c:out value="${message}" /></h1>
<h1><c:out value="${taskName}" /></h1>
</body>
</html>
