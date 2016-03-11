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
<%-- 	<%@ include file="../common/autocomplete.jsp"%> --%>
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
	<form id="shopSaleForm" name="shopSaleForm" method="post">
		<label class="ml-default">查询区域：</label>
            <select class="select" name="areaId" id="areaId">
				<option value="" <c:if test="${shopVo.areaId eq ''}">selected</c:if>>全部区域</option>
				<option value="705" <c:if test="${shopVo.areaId eq '705'}">selected</c:if>>福田区</option>
				<option value="707" <c:if test="${shopVo.areaId eq '707'}">selected</c:if>>南山区</option>
				<option value="708" <c:if test="${shopVo.areaId eq '708'}">selected</c:if>>宝安区</option>
				<option value="709" <c:if test="${shopVo.areaId eq '709'}">selected</c:if>>龙岗区</option>
				<option value="3406" <c:if test="${shopVo.areaId eq '3406'}">selected</c:if>>坪山区</option>
				<option value="3407" <c:if test="${shopVo.areaId eq '3407'}">selected</c:if>>横岗区</option>
		    </select>
		<label class="ml-default">查询时间</label>
		<input type="text" name="startTime" id="startTime" value="${shopVo.startTime}" class="input input-search-date J_DATE_START" placeholder="" />
		&nbsp;至&nbsp;
		<input type="text" name="endTime" id="endTime" value="${shopVo.endTime}" class="input input-search-date mr-small J_DATE_END" placeholder="" />
		<input type="text" name="shopNo" id="shopNo" value="${shopVo.shopNo}" placeholder="商铺名称/商铺编码"  class="input input-search-text ml-default">
		<input type="button" class="input input-search-button ml-default" id="queryShopSaleBtn" value="搜索" />
	</form>
    </div>
    <div>
       <table class="table-list table-border" id="tblShopSaleList">
         <thead class="table-thead">
			<tr>
				<th>区域</th>
				<th>商铺编号</th>
				<th>商铺名称</th>
				<th>下单次数</th>
				<th>销量</th>
				<th>销售金额</th>
				<th>盈利商品销售额</th>
				<th>盈利商品利润</th>
				<th>费用金额</th>
				<th>费用率</th>
				<th>详情</th>
			</tr>
		</thead>
         <tbody class="table-tbody">
         </tbody>
       </table>
    </div>
   	<%@ include file="../common/pagination.jsp"%>
</div>
<!-- 全局统计列表end -->
<script>
$(document).ready(function(){
	  //日期初始化加载
	 dateRangeSimple('.J_DATE_START', '.J_DATE_END');
});
$("#jpagination").pagination({
    pageSize: 10,
    remote: {
        url: '${root}/analysis/shop/getShopSaleList.do',
        params: $('#shopSaleForm').serializeArray(),
        success: function(data) {
            var html='';
            //原来列表的查询条件
            var startTime = data.map.shopSaleVo.startTime;
            var endTime = data.map.shopSaleVo.endTime;
            var areaId = data.map.shopSaleVo.areaId;
            
            $.each(data.list, function(i,item) {
            	var areaName = item.areaName==null?"":item.areaName;
            	var shopNo = item.shopNo==null?"":item.shopNo;
            	var shopName = item.shopName==null?"":item.shopName;
            	var xdcs = item.xdcs==null?"":item.xdcs;
            	var xssl = item.xssl==null?"":item.xssl;
            	var xsje = item.xsje==null?"":item.xsje;
            	var ylspxse = item.ylspxse==null?"":item.ylspxse;
            	var ylsplr = item.ylsplr==null?"":item.ylsplr;
            	var fyje = item.fyje==null?"":item.fyje;
            	var flVal= (fyje/xsje*100).toFixed(2);
            	//如果费率计算结果为NaN时，默认设置为0
            	if(isNaN(flVal)){
            		flVal = 0;
            	}else if(flVal == 0){
            		flVal = 0;
            	}
            	
            	html+='<tr>'
	                +'<td>'+areaName+'</td>'
	                +'<td>'+shopNo+'</td>'
	                +'<td>'+shopName+'</td>'
	                +'<td>'+xdcs+'</td>'
	                +'<td>'+xssl+'</td>'
	                +'<td>'+xsje+'</td>'
	                +'<td>'+ylspxse+'</td>'
	                +'<td>'+ylsplr+'</td>'
	                +'<td>'+fyje+'</td>'
	                +'<td>'+flVal+'%</td>'
            	    +'<td><a href="${root}/analysis/shop/getShopSaleDetail.do?id='+item.id+'&areaId='+areaId+'&startTime='+startTime+'&endTime='+endTime+'" target="_blank">查看</a></td>'
            	    +'</tr>'; 
            });
            
            if(html == "") {
             	html = '<tr><td colspan="8" class="no-data"></td></tr>';
            }
            $('#tblShopSaleList .table-tbody').html(html);
        },
        totalName:'totalSize',
        
    }
});

//条件验证
$('#queryShopSaleBtn').on('click', function(e) {
  	 $("#jpagination").pagination('setParams', $('#shopSaleForm').serializeArray());
  	 $("#jpagination").pagination('setPageIndex', 0);
  	 $("#jpagination").pagination('remote');
 });
</script>
</body>
</html>