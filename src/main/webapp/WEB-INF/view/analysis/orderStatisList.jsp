<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<% request.setAttribute("root", request.getContextPath());%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>街坊店宝</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
	<%@ include file="../common/head.jsp"%>
	<link src="${root}/resources/vendor/My97DatePicker/skin/WdatePicker.css">
	<script src="${root}/resources/vendor/My97DatePicker/WdatePicker.js"></script>
	<script src="${root}/resources/js/comm.js"></script>
    <style>
    	.sxedit {visibility: hidden;}
    	tr:hover .sxedit {visibility: visible;}
		.colora {color: #ed4b1c;}
		.colorb {color: #06ada3;}
    </style>
</head>
<body>
<!-- 全局统计列表begin -->
<div class="wrap-bd">
    <div class="mb-default">
        <span class="crumb">全局统计</span><span class="crumb-active">核心数据汇总</span>
    </div>
    <div class="mb-small clearfix">
       <form action="${root}/analysis/order/getOrderList.do" method="post" id="searchForm">
        <label>查询时间</label>
        <input type="text" name="startTime" id="startTime" value="${orderVo.startTime}" class="input input-search-date J_DATE_START" placeholder="" />
        &nbsp;至&nbsp;
        <input type="text" name="endTime" id="endTime" value="${orderVo.endTime}" class="input input-search-date mr-small J_DATE_END" placeholder="" />
        <input type="button" class="input input-search-button ml-default"  id="btnQuery" value="搜索" />
        <input type="button" class="input input-search-button ml-default"  id="btnExport" value="导出"/>
       </form>
    </div>
    <div>
       <table class="table-list table-border" id="tblDataStatic">
         <thead class="table-thead">
			<tr>
				<th>区域</th>
				<th>定格名称</th>
				<th>商品名称</th>
				<th>商品规格</th>
				<th>本日金额</th>
				<th>本月金额</th>
			</tr>
		</thead>
         <tbody class="table-tbody">
          <c:forEach var="list" items="${list}">
            <tr>
                <td>${list.areaName}</td>
                <td>${list.shopRatedName }</td>
                <td>${list.productName }</td>
                <td>${list.productSpec }</td>
                <td>${list.dateTotalMoney }</td>
                <td>${list.monthTotalMoney}</td>
            </tr>
           </c:forEach> 
         </tbody>
       </table>
    </div>
    <%@ include file="../common/pagination.jsp"%>
</div>
<!-- 全局统计列表end -->
<script>
//页面载入时加载
$(document).ready(function(){
	
	//日期初始化加载
	dateRangeSimple('.J_DATE_START', '.J_DATE_END');
	  
	$("#btnExport").click(function(){
		 if(confirm("确定要导出订单统计数据吗？")){
			 $("#searchForm").attr("action","${root}/analysis/order/export.do");
			 $("#searchForm").submit();
		 }
	});
	
	$("#btnQuery").click(function(){
		$("#searchForm").attr("action","${root}/analysis/order/getOrderList.do");
		$("#searchForm").submit();
	});
});
</script>
</body>
</html>