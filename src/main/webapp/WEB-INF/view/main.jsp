<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./common/taglib.jsp"%>

<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<title>街坊店宝</title>
<meta name="description" content="">
<meta name="keywords" content="">
<%@ include file="./common/head.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/layout.css?v1216000">
<script src="<%=request.getContextPath() %>/resources/js/layout.js?v1216000"></script>
</head>
<body>
	<%@ include file="./common/header.jsp"%>
	<%@ include file="./common/nav.jsp"%>
	<main id="main">
	<article id="article">
		<iframe id="mainiframe" name="mainiframe" src="<%=request.getContextPath() %>/analysis/authority/toMainPage.do" width="100%" height="100%" frameborder="0"></iframe>
	</article>
	</main>
</body>
</html>