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
	<script src="${root}/resources/analysis/globalStatisList.js"></script>
    <style>
    	.sxedit {visibility: hidden;}
    	tr:hover .sxedit {visibility: visible;}
		.colora {color: #ed4b1c;}
		.colorb {color: #06ada3;}
    </style>
</head>
<body>
<!-- 合作商数据分析列表begin -->
<div class="wrap-bd">
    <div class="mb-default">
        <span class="crumb">街坊店宝</span><span class="crumb">数据分析</span><span class="crumb-active">合作商数据分析</span>
    </div>
    <div class="mb-small clearfix">
       <form action="${root}/analysis/supplier/getSupplierList.do" method="post" id="supplierForm">
       		<label>查询区域：</label>
            <select class="select" name="areaId" id="areaId">
				<option value="" <c:if test="${supplierVo.areaId eq ''}">selected</c:if>>全部区域</option>
				<option value="705" <c:if test="${supplierVo.areaId eq '705'}">selected</c:if>>福田区</option>
				<option value="707" <c:if test="${supplierVo.areaId eq '707'}">selected</c:if>>南山区</option>
				<option value="708" <c:if test="${supplierVo.areaId eq '708'}">selected</c:if>>宝安区</option>
				<option value="709" <c:if test="${supplierVo.areaId eq '709'}">selected</c:if>>龙岗区</option>
				<option value="3406" <c:if test="${supplierVo.areaId eq '3406'}">selected</c:if>>坪山区</option>
				<option value="3407" <c:if test="${supplierVo.areaId eq '3407'}">selected</c:if>>横岗区</option>
		    </select>
	        <label class="ml-default">查询时间：</label>
	        <input type="text" name="startTime" id="startTime" value="${supplierVo.startTime}" class="input input-search-date J_DATE_START" placeholder="" />
	        &nbsp;至&nbsp;
	        <input type="text" name="endTime" id="endTime" value="${supplierVo.endTime}" class="input input-search-date mr-small J_DATE_END" placeholder="" />
	        <input type="text" name="supplierCode" id="supplierCode" value="${supplierVo.supplierCode}" placeholder="请输入批发商名称/批发商编号" class="input input-search-text ml-default">
	        <input type="button" class="input input-search-button ml-default"  id="btnQuery" value="搜索" />
            <input type="button" class="input input-search-button ml-default"  id="btnExport" value="导出"/>
       </form>
    </div>
    <div>
       <table class="table-list table-border" id="tblDataStatic">
         <thead class="table-thead">
			<tr>
				<th>所属区域</th>
				<th>合作商编号</th>
				<th>合作商名称</th>
				<th>配送商铺数</th>
				<th>订单数量</th>
				<th>销量</th>
				<th>销售金额</th>
				<th>盈利商品销售额</th>
				<th>盈利商品利润</th>
				<th>费用</th>
				<th>费用率</th>
				<th>详情</th>
			</tr>
		</thead>
         <tbody class="table-tbody">
          <c:forEach var="list" items="${supplierList}">
            <tr>
                <td>${list.areaName}</td>
                <td>${list.supplierCode }</td>
                <td>${list.supplierName }</td>
                <td>${list.pssps }</td>
                <td>${list.ddsl }</td>
                <td>${list.xssl}</td>
                <td class="colora"><fmt:formatNumber value="${list.xsje}" pattern="0.00"/></td>
                <td class="colora"><fmt:formatNumber value="${list.ylspxse}" pattern="0.00"/></td>
                <td class="colora"><fmt:formatNumber value="${list.ylsplr}" pattern="0.00"/></td>
                <td class="colorb"><fmt:formatNumber value="${list.fyje}" pattern="0.00"/></td>
                <td>
                	<fmt:formatNumber type="number" value="${list.fyje/list.xsje*100}" maxFractionDigits="2"/>%
                </td>
                <td><a href="${root}/analysis/supplier/getSupplierDetailById.do?id=${list.id}&startTime=${supplierVo.startTime}&endTime=${supplierVo.endTime}" target="_blank">查看</a></td>
            </tr>
           </c:forEach> 
         </tbody>
       </table>
    </div>
</div>
<!-- 合作商数据分析列表end -->
<script>
//页面载入时加载
$(document).ready(function(){
	$("#btnExport").click(function(){
		 if(confirm("确定要导出用户数据吗？")){
			 $("#supplierForm").attr("action","${root}/analysis/supplier/export.do");
			 $("#supplierForm").submit();
		 }
	});
	
	$("#btnQuery").click(function(){
		$("#supplierForm").attr("action","${root}/analysis/supplier/getSupplierList.do");
		$("#supplierForm").submit();
	});
});
</script>
</body>
</html>