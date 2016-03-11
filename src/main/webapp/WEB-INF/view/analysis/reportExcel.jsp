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
    	<script type="text/javascript">
		$(document).ready(function() {
			$("#btnExport").click(function(){
				
				 if(confirm("确定要导出用户数据吗？")){
					 $("#searchForm").attr("action","${root}/analysis/report/export.do");
					 $("#searchForm").submit();
				 }

			});
			$("#btnImport").click(function(){
				$.jBox($("#importBox").html(), {title:"导入数据", buttons:{"关闭":true}, 
					bottomText:"导入文件不能超过5M，仅允许导入“xls”或“xlsx”格式文件！"});
			});
		});
		function page(n,s){
			if(n) $("#pageNo").val(n);
			if(s) $("#pageSize").val(s);
			$("#searchForm").attr("action","${ctx}/sys/user/list");
			$("#searchForm").submit();
	    	return false;
	    }
	</script>
</head>
<body>
<!-- 全局统计列表begin -->
<div class="wrap-bd">
    <div class="mb-default">
        <span class="crumb">全局统计</span><span class="crumb-active">核心数据汇总</span>
    </div>
    <div class="mb-small clearfix">
       <form action="${root}/analysis/statis/getStatisList.do" name="orderid" method="post" id="searchForm">
        <label>查询时间</label>
        <input type="text" name="startTime" id="startTime" value="${statisVo.startTime}" class="input input-search-date J_DATE_START" placeholder="" />
        &nbsp;至&nbsp;
        <input type="text" name="endTime" id="endTime" value="${statisVo.endTime}" class="input input-search-date mr-small J_DATE_END" placeholder="" />
        
        <input type="submit" class="input input-search-button ml-default"  id="queryButton" value="搜索" />
        <input id="btnExport" class="input input-search-button ml-default" type="button" value="导出"/>
       </form>
    </div>
    <div>
       <table class="table-list table-border" id="tblDataStatic">
         <thead class="table-thead">
        	<tr class="table-header">
				<th rowspan="2">区域</th>
				<th colspan="3">商铺（家）</th>
				<th colspan="3">下单</th>
				<th colspan="3">销售金额（元）</th>
				<th colspan="2">费用</th>
			</tr>
			<tr>
				<th>新增商铺</th>
				<th>活跃商铺</th>
				<th>高频商铺</th>
				<th>下单次数</th>
				<th>下单SKU</th>
				<th>销量</th>
				<th>销售金额</th>
				<th>盈利产品销售额</th>
				<th>盈利商品利润</th>
				<th>费用金额（元）</th>
				<th>费用率</th>
			</tr>
		</thead>
         <tbody class="table-tbody">
          <c:forEach var="list" items="${list}">
            <tr>
                <td>${list.areaName}</td>
                <td>${list.xzzd }</td>
                <td>${list.hyzd }</td>
                <td>${list.gpzd }</td>
                <td>${list.xdcs }</td>
                <td>${list.xdsku}</td>
                <td>${list.xl}</td>
                <td class="colora"><fmt:formatNumber value="${list.xsje}" pattern="0.00"/></td>
                <td class="colora"><fmt:formatNumber value="${list.ylspxse}" pattern="0.00"/></td>
                <td class="colora"><fmt:formatNumber value="${list.ylsplr}" pattern="0.00"/></td>
                <td class="colorb"><fmt:formatNumber value="${list.fyje}" pattern="0.00"/></td>
                <td>
                	<fmt:formatNumber type="number" value="${list.fyje/list.xsje*100}" pattern="0.00" maxFractionDigits="2"/>%
                </td>
            </tr>
           </c:forEach> 
            <tr>
                <td>累计</td>
                <td id="xzzdTotal"></td>
                <td id="hyzdTotal"></td>
                <td id="gpzdTotal"></td>
                <td id="xdcsTotal"></td>
                
                
                <td id="xdskuTotal"></td>
                <td id="xlTotal"></td>
                <td id="xsjeTotal"    class="colora"></td>
                <td id="ylspxseTotal" class="colora"></td>
                <td id="ylsplrTotal"  class="colora"></td>
                <td id="fyjeTotal"    class="colorb"></td>
                <td id="fylTotal"></td>
            </tr>
         </tbody>
       </table>
       
       <div style="padding-top:10px;">
       		<span>全年累计终端 :${fullYearStat.qnljzd }</span> 
       		<span style="padding-left:80px;">累计销量 :${fullYearStat.ljxl }</span>
       		<span style="padding-left:80px;">累计销售额 :<fmt:formatNumber value="${fullYearStat.ljxse}" pattern="#,#00.00#"/></span>
       		<span style="padding-left:80px;">累计盈利商品销售额 :<fmt:formatNumber value="${fullYearStat.ljylspxse}" pattern="#,#00.00#"/></span>
       		<span style="padding-left:80px;">费用 :<fmt:formatNumber value="${fullYearStat.fy}" pattern="#,#00.00#"/></span>
       </div>
    </div>
    <%@ include file="../common/pagination.jsp"%>
</div>
<!-- 全局统计列表end -->
</body>
</html>