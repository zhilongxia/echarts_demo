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
	<h2 class="heading" style="padding-left:240px;">${baseInfo.areaName}-${baseInfo.supplierName} 基本信息</h2>
	<table class="table-list table-border" style="width: 75%;">
		<tbody>
			<tr class="thead theadb">
				<td rowspan="2">批发商编号</td>
				<td rowspan="2">批发商名称</td>
				<td rowspan="2">配送定格</td>
				<td rowspan="2">负责业代</td>
				<td rowspan="2">配送终端数</td>
				<td rowspan="2">订单数量</td>
				<td rowspan="2">销量</td>
				<td colspan="3">销售总数</td>
				<td colspan="3">费用商品</td>
				<td colspan="3">平价商品</td>
				<td colspan="3">盈利商品</td>
			</tr>
			<tr>
				<td>销售金额</td>
				<td>盈利商品销售</td>
				<td>费用率</td>
				<td>销售金额</td>
				<td>商品费用</td>
				<td>费用率</td>
				<td>销售金额</td>
				<td>商品费用</td>
				<td>费用率</td>
				<td>销售金额</td>
				<td>商品费用</td>
				<td>费用率</td>
			</tr>
			<c:forEach var="baseList" items="${baseList}">
			<tr>
				<td>${baseList.supplierCode}</td>
				<td>${baseList.supplierName}</td>
				<td></td>
				<td></td>
				<td></td>
				<td>${baseList.ddsl}</td>
				<td>${baseList.xssl}</td>
				<td class="colora">${baseList.xsje}</td>
				<td class="colora">${baseList.ylspxse}</td>
				<td>
					<fmt:formatNumber type="number" value="${baseList.fyje/baseList.xsje*100}" maxFractionDigits="2"/>%
				</td>
				<td class="colora">${baseList.fyspxse}</td>
				<td class="colorb">${baseList.fyspfy}</td>
				<td>
					<fmt:formatNumber type="number" value="${baseList.fyspfy/baseList.fyspxse*100}" maxFractionDigits="2"/>%
				</td>
				<td class="colora">${baseList.pjspxse}</td>
				<td class="colorb">0</td>
				<td>0</td>
				<td class="colora">${baseList.ylspxse}</td>
				<td class="colorb">${baseList.ylspfy}</td>
				<td>
					<fmt:formatNumber type="number" value="${baseList.ylspfy/baseList.ylspxse*100}" maxFractionDigits="2"/>%
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div>
	<h2 class="heading" style="padding-left:240px;">${baseInfo.supplierName}&nbsp;${supplierVo.startTime}至${supplierVo.endTime}&nbsp;销售订单明细报表</h2>
	<table class="table-list table-border" style="width: 75%;">
		<tbody>
			<tr class="thead theadb">
				<td>商铺编号</td>
				<td>商铺名称</td>
				<td>下单次数</td>
				<td>下单SKU</td>
				<td>销量</td>
				<td>销售金额</td>
				<td>盈利商品销售额</td>
				<td>盈利商品利润</td>
				<td>费用</td>
				<td>费用率</td>
			</tr>
			<c:forEach var="detailList" items="${detailList}">
				<tr>
					<td>${detailList.supplierCode}</td>
					<td>${detailList.supplierName}</td>
					<td>${detailList.xdcs}</td>
					<td>${detailList.xdsku}</td>
					<td>${detailList.xssl}</td>
					<td class="colora">${detailList.xsje}</td>
					<td class="colora">${detailList.ylspxse}</td>
					<td class="colora">${detailList.ylsplr}</td>
					<td class="colorb">${detailList.fyje}</td>
					<td>
						<c:choose>
							<c:when test="${!empty detailList.fyje and !empty detailList.xsje}">
								<fmt:formatNumber type="number" value="${(detailList.fyje/detailList.xsje)*100}" maxFractionDigits="2"/>%
							</c:when>
							<c:otherwise>
								0%
							</c:otherwise>
						</c:choose>
						
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>