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
	<script src="${root}/resources/vendor/My97DatePicker/WdatePicker.js"></script>
	<script src="${root}/resources/js/comm.js"></script>
	<script src="${root}/resources/vendor/layer/layer.js"></script>
	<script src="${root}/resources/vendor/jquery/validation/jquery.validate.min.js"></script> 
	<script src="${root}/resources/vendor/jquery/validation/localization/messages_zh.min.js"></script>
<!-- 	说明：analysisShopList.js文件在jsp:include中属于静态文件不起作用，所以把这部分的内容放页面中 -->
<%-- 	<script src="${root}/resources/analysis/analysisShopList.js"></script> --%>
	<link src="${root}/resources/vendor/My97DatePicker/skin/WdatePicker.css">
    <style>
    	.sxedit {visibility: hidden;}
    	tr:hover .sxedit {visibility: visible;}
		.colora {color: #ed4b1c;}
		.colorb {color: #06ada3;}
    </style>
</head>
<body>
<!-- 全局统计列表begin -->
<div>
    <div class="mb-small clearfix">
       <form action="${root}/analysis/shop/getShopList.do" name="orderid" method="post" id="shopForm">
        <label>查询时间</label>
        <input type="text" name="startTime" id="startTime" value="${shopVo.startTime}" class="input input-search-date J_DATE_START" placeholder="" />
        &nbsp;至&nbsp;
        <input type="text" name="endTime" id="endTime" value="${shopVo.endTime}" class="input input-search-date mr-small J_DATE_END" placeholder="" />
        
        <input type="submit" class="input input-search-button ml-default"  id="queryShopBtn" value="搜索" />
       </form>
    </div>
    <div>
       <table class="table-list table-border" id="tblShopAnalysis">
         <thead class="table-thead">
        	<tr class="table-header">
				<th rowspan="2">区域</th>
				<th rowspan="2">商铺数量（家）</th>
				<th colspan="10">下单次数（家）</th>
				<th colspan="8">销售额（家）</th>
			</tr>
			<tr>
				<th>未下单</th>
				<th>占比</th>
				<th>1次下单</th>
				<th>占比</th>
				<th>2次下单</th>
				<th>占比</th>
				<th>3次下单</th>
				<th>占比</th>
				<th>3次以上下单</th>
				<th>占比</th>
				<th>0-5000</th>
				<th>占比</th>
				<th>5000-10000</th>
				<th>占比</th>
				<th>10000-30000</th>
				<th>占比</th>
				<th>大于30000</th>
				<th>占比</th>
			</tr>
		</thead>
         <tbody class="table-tbody">
          <c:forEach var="shopList" items="${shopList}">
         	 <tr>
				<td>${shopList.areaName}</td>
				<td>${shopList.zdsl}</td>
				<c:set var="tmpWxd" value="${shopList.zdsl-shopList.xd1-shopList.xd2-shopList.xd3-shopList.xd4}"/>
				<td><c:out value="${tmpWxd}"></c:out> </td>
				<td>
					<fmt:formatNumber type="number" value="${tmpWxd/shopList.zdsl*100}" maxFractionDigits="2"/>%
				</td>
				<td>${shopList.xd1}</td>
				<td><fmt:formatNumber type="number" value="${shopList.xd1/shopList.zdsl*100}"  maxFractionDigits="2"/>%</td>
				<td>${shopList.xd2}</td>
				<td><fmt:formatNumber type="number" value="${shopList.xd2/shopList.zdsl*100}"  maxFractionDigits="2"/>%</td>
				<td>${shopList.xd3}</td>
				<td><fmt:formatNumber type="number" value="${shopList.xd3/shopList.zdsl*100}"  maxFractionDigits="2"/>%</td>
				<td>${shopList.xd4}</td>
				<td><fmt:formatNumber type="number" value="${shopList.xd4/shopList.zdsl*100}"  maxFractionDigits="2"/>%</td>
				<td>${shopList.xse1}</td>
				<td><fmt:formatNumber type="number" value="${shopList.xse1/shopList.zdsl*100}"  maxFractionDigits="2"/>%</td>
				<td>${shopList.xse2}</td>
				<td><fmt:formatNumber type="number" value="${shopList.xse2/shopList.zdsl*100}"  maxFractionDigits="2"/>%</td>
				<td>${shopList.xse3}</td>
				<td><fmt:formatNumber type="number" value="${shopList.xse3/shopList.zdsl*100}" maxFractionDigits="2"/>%</td>
				<td>${shopList.xse4}</td>
				<td><fmt:formatNumber type="number" value="${shopList.xse4/shopList.zdsl*100}"  maxFractionDigits="2"/>%</td>
			</tr>
           </c:forEach> 
            <tr>
                <td>合计</td>
                <td id="zdslTotal"></td>
                <td id="wxdTotal"></td>
                <td id="wxdzbTotal"></td>
                <td id="xd1Total"></td>
                <td id="xd1zbTotal"></td>
                <td id="xd2Total"></td>
                <td id="xd2zbTotal"  class="colora"></td>
                <td id="xd3Total"    class="colora"></td>
                <td id="xd2zbTotal"  class="colora"></td>
                <td id="xd4Total"    class="colorb"></td>
                <td id="xd4zbTotal"></td>
             	<td id="xse1Total"></td>
                <td id="xse1zbTotal"></td>
                <td id="xse2Total"></td>
                <td id="xse2zbTotal"  class="colora"></td>
                <td id="xse3Total"    class="colora"></td>
                <td id="xse3zbTotal"  class="colora"></td>
                <td id="xse4Total"    class="colorb"></td>
                <td id="xse4zbTotal"></td>
            </tr>
         </tbody>
       </table>
    </div>
</div>
<!-- 全局统计列表end -->
<script>
//页面载入时加载
$(document).ready(function(){
	  //日期初始化加载
	 dateRangeSimple('.J_DATE_START', '.J_DATE_END');
	 //统计表格每一列的累加结果
	 initTdTotal();
});
 
/** 
 * 加法运算，统计表格每一列的累加结果。 
 */ 
 function initTdTotal(){
	 //1、存储变量声明
	 var zdslTotal = 0,wxdTotal = 0,xd1Total = 0,xd2Total = 0,xd3Total = 0,
	 	 xd4Total = 0,xse1Total=0,xse2Total=0,xse3Total=0,xse4Total=0;
	 
	var wxdzbTotal = 0,xd1zbTotal = 0,xd2zbTotal = 0,xd3zbTotal = 0,
		xd4zbTotal = 0,xse1zbTotal=0,xse2zbTotal=0,xse3zbTotal=0,xse4zbTotal=0;
	 //2.计算td列的信息累加
	 $("#tblShopAnalysis .table-tbody").find('tr').each(function(){
        var tmpZdslVal = $(this).find('td').eq(1).text();
        var tmpWxdVal = $(this).find('td').eq(2).text();
        var tmpXd1Val = $(this).find('td').eq(4).text();
        var tmpXd2Val = $(this).find('td').eq(6).text();
        var tmpXd3Val = $(this).find('td').eq(8).text();
        var tmpXd4Val = $(this).find('td').eq(10).text();
        var tmpXse1Val = $(this).find('td').eq(12).text();
        var tmpXse2Val = $(this).find('td').eq(14).text();
        var tmpXse3Val = $(this).find('td').eq(16).text();
        var tmpXse4Val = $(this).find('td').eq(18).text();
        
		if(tmpZdslVal != null && tmpZdslVal !=''){
			zdslTotal = numAdd(zdslTotal,tmpZdslVal);
		}
		if(tmpWxdVal != null && tmpWxdVal !=''){
			wxdTotal = numAdd(wxdTotal,tmpWxdVal);
		}
		if(tmpXd1Val != null && tmpXd1Val !=''){
			xd1Total = numAdd(xd1Total,tmpXd1Val);
		}
		if(tmpXd2Val != null && tmpXd2Val !=''){
			xd2Total = numAdd(xd1Total,tmpXd2Val);
		}
		if(tmpXd3Val != null && tmpXd3Val !=''){
			xd3Total = numAdd(xd3Total,tmpXd3Val);
		}
		if(tmpXd4Val != null && tmpXd4Val !=''){
			xd4Total = numAdd(xd4Total,tmpXd4Val);
		}
		if(tmpXse1Val != null && tmpXse1Val !=''){
			xse1Total = numAdd(xse1Total,tmpXse1Val);
		}
		if(tmpXse2Val != null && tmpXse2Val !=''){
			xse2Total = numAdd(xse2Total,tmpXse2Val);
		}
		if(tmpXse3Val != null && tmpXse3Val !=''){
			xse3Total = numAdd(xse3Total,tmpXse3Val);
		}
		if(tmpXse4Val != null && tmpXse4Val !=''){
			xse4Total = numAdd(xse4Total,tmpXse4Val);
		}
    })
    //4.填充累加的结果都最后一列中
    $("#zdslTotal").text(zdslTotal);
	$("#wxdTotal").text(wxdTotal);
	$("#xd1Total").text(xd1Total);
	$("#xd2Total").text(xd2Total);
	$("#xd3Total").text(xd3Total);
	$("#xd4Total").text(xd4Total);
	$("#xse1Total").text(xse1Total);
	$("#xse2Total").text(xse2Total);
	$("#xse3Total").text(xse3Total);
	$("#xse4Total").text(xse4Total);
	
	//5.计算下单和占比的百分比
	wxdzbTotal = wxdTotal/zdslTotal*100;
	xd1zbTotal = xd1Total/zdslTotal*100;
	xd2zbTotal = xd2Total/zdslTotal*100;
	xd3zbTotal = xd3Total/zdslTotal*100;
	xd4zbTotal = xd4Total/zdslTotal*100;
	
	xse1zbTotal = xse1Total/zdslTotal*100;
	xse2zbTotal = xse2Total/zdslTotal*100;
	xse3zbTotal = xse3Total/zdslTotal*100;
	xse4zbTotal = xse4Total/zdslTotal*100;
	
	//6.回填占比结果到最后一列中
	if(!isNaN(wxdzbTotal)){
		$("#wxdzbTotal").text(wxdzbTotal.toFixed(2)+"%");
	}
	if(!isNaN(xd1zbTotal)){
		$("#xd1zbTotal").text(xd1zbTotal.toFixed(2)+"%");
	}
	if(!isNaN(xd2zbTotal)){
		$("#xd2zbTotal").text(xd2zbTotal.toFixed(2)+"%");
	}
	if(!isNaN(xd3zbTotal)){
		$("#xd3zbTotal").text(xd3zbTotal.toFixed(2)+"%");
	}
	if(!isNaN(xd4zbTotal)){
		$("#xd4zbTotal").text(xd4zbTotal.toFixed(2)+"%");
	}
	
	if(!isNaN(xse1zbTotal)){
		$("#xse1zbTotal").text(xse1zbTotal.toFixed(2)+"%");
	}
	if(!isNaN(xse2zbTotal)){
		$("#xse2zbTotal").text(xse2zbTotal.toFixed(2)+"%");
	}
	if(!isNaN(xse3zbTotal)){
		$("#xse3zbTotal").text(xse3zbTotal.toFixed(2)+"%");
	}
	if(!isNaN(xse4zbTotal)){
		$("#xse4zbTotal").text(xse4zbTotal.toFixed(2)+"%");
	}
 }
 
 /** 
 * 加法运算，避免数据相加小数点后产生多位数和计算精度损失。 
 * 
 * @param num1加数1 | num2加数2 
 */ 
 function numAdd(num1, num2) { 
     var baseNum, baseNum1, baseNum2; 
     try { 
     	baseNum1 = num1.toString().split(".")[1].length; 
     } catch (e) { 
     	baseNum1 = 0; 
     } 
     try { 
    	 baseNum2 = num2.toString().split(".")[1].length; 
     } catch (e) { 
    	 baseNum2 = 0; 
     } 
     baseNum = Math.pow(10, Math.max(baseNum1, baseNum2)); 
     return (num1 * baseNum + num2 * baseNum) / baseNum; 
 }

</script>
</body>
</html>