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
<div >
<!-- 	<div class="print-order-title ta-c">街坊店宝 > 数据分析 > 商品分析</div> -->
	<h2 style="padding-left:240px;">${info.areaName} ${info.spmc} 基本信息</h2>
	<table class="table-list table-border" style="width: 75%;">
		<thead class="table-thead">
			<tr>
				<th>序号</th>
				<th>商品条码</th>
				<th>一级分类</th>
				<th>二级分类</th>
				<th>商品名称</th>
				<th>规格</th>
				<th>市场价</th>
				<th>批发商出货价</th>
				<th>批发商毛利</th>
				<th>下单次数</th>
				<th>销量</th>
				<th>销售金额</th>
				<th>商品费用</th>
				<th>费用率</th>
			</tr>
			</thead>
			<tbody class="table-tbody">
			<c:forEach var="proList" items="${proList}" varStatus="status">
			<tr>
				<td>${status.index+1}</td>
				<td>${proList.sptm}</td>
				<td>${proList.yjfl}</td>
				<td>${proList.ejfl}</td>
				<td class="colorc">${proList.areaName}</td>
				<td>${proList.spec}</td>
				<td>${proList.scj}</td>
				<td>${proList.hzschj}</td>
				<td>${proList.maoli}</td>
				<td>${proList.xdcs}</td>
				<td>${proList.xssl}</td>
				<td class="colora">${proList.xsje}</td>
				<td class="colorb">${proList.fyje}</td>
				<td>${proList.fyje/proList.xsje*100}%</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

</body>
</html>