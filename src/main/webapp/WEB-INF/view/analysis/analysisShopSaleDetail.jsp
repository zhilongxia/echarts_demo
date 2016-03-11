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
	<link rel="stylesheet" href="${root}/resources/css/order-detail.css">
	<script src="${root}/resources/js/china-cost.js"></script>
</head>
<body>
<div>
<!-- 	<div class="print-order-title ta-c">街坊店宝 > 数据分析 > 商品分析</div> -->
	<h2 class="heading" style="padding-left:240px;">${shopBaseVo.areaName}-${shopBaseVo.shopName} 基本信息</h2>
	<table class="table-list table-border" style="width: 75%;">
		<thead class="table-thead">
			<tr>
				<th>终端编号</th>
				<th>终端名称</th>
				<th>注册时间</th>
				<th>负责业代</th>
				<th>所属定格</th>
				<th>下单次数</th>
				<th>销量</th>
				<th>销售金额</th>
				<th>盈利商品销售金额</th>
				<th>盈利商品利润</th>
				<th>商品费用</th>
				<th>费用率</th>
			</tr>
			</thead>
			<tbody class="table-tbody">
			<tr>
				<td>${shopBaseVo.shopNo}</td>
				<td>${shopBaseVo.shopName}</td>
				<td><fmt:formatDate value="${shopBaseVo.addTime}" type="both"/></td>
				<td></td>
				<td></td>
				<td>${shopBaseVo.xdcs}</td>
				<td>${shopBaseVo.xssl}</td>
				<td>${shopBaseVo.xsje}</td>
				<td>${shopBaseVo.ylspxse}</td>
				<td>${shopBaseVo.ylsplr}</td>
				<td>${shopBaseVo.fyje}</td>
				<td>${shopBaseVo.fyje/shopBaseVo.xsje*100}%</td>
			</tr>
		</tbody>
	</table>
</div>
<div>
	<h2 class="heading" style="padding-left:240px;">${shopBaseVo.shopName}&nbsp;${shopSaleVo.startTime}至${shopSaleVo.endTime}&nbsp;销售订单明细报表</h2>
	<table class="table-list table-border" style="width: 75%;">
		<thead class="table-thead">
			<tr>
				<th>订单号</th>
				<th>下单时间</th>
				<th>到货时间</th>
				<th>销量</th>
				<th>销售金额</th>
				<th>盈利商品销售额</th>
				<th>盈利商品利润</th>
				<th>费用金额</th>
				<th>费用率</th>
			</tr>
			</thead>
			<tbody class="table-tbody">
			<c:forEach var="detailList" items="${shopDetailList}" varStatus="status">
			<tr>
				<td>${detailList.orderId}</td>
				<td><fmt:formatDate value="${detailList.addTime}" type="both"/></td>
				<td></td>
				<td></td>
				<td>${detailList.orderPrice}</td>
				<td></td>
				<td></td>
				<td>${detailList.zfee}</td>
				<td><fmt:formatNumber type="number" value="${detailList.fly*100}"  maxFractionDigits="2"/>%</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>