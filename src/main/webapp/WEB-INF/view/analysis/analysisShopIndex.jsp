<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="zh">
<head>  
    <meta charset="UTF-8">
    <title>街坊店宝</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
    <%@ include file="../common/head.jsp"%>
</head>  
<body>  
<div class="wrap-bd">
	<div class="mb-default" id="J_tab">
		<span class="pills pills-active J_pills">商铺核心数据汇总</span>
		<span class="pills J_pills">商铺销售明细报表</span>
	</div>
	<div class="J_content">
		<jsp:include page="analysisShopList.jsp"></jsp:include>
	</div>
	<div class="J_content hidden">
		<jsp:include page="analysisShopSaleList.jsp"></jsp:include>
	</div>
</div>  
<script>
	$(function() {
		$('#J_tab').on('click', '.J_pills', function() {
			$(this).addClass('pills-active').siblings('.J_pills').removeClass('pills-active');
			var ii = $('.J_pills').index(this);
			$('.J_content').eq(ii).show().siblings('.J_content').hide();
		});
	});
</script>  
</body>  
</html>  