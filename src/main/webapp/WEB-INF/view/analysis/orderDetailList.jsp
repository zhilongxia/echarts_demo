<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<% request.setAttribute("root", request.getContextPath());%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8">
    <title>街坊店宝</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
	<%@ include file="../common/head.jsp"%>
	<script src="${root}/resources/vendor/My97DatePicker/WdatePicker.js"></script>
	<script src="${root}/resources/js/comm.js"></script>
	<script src="${root}/resources/vendor/layer/layer.js"></script>
	<script src="${root}/resources/vendor/jquery/validation/jquery.validate.min.js"></script> 
	<script src="${root}/resources/vendor/jquery/validation/localization/messages_zh.min.js"></script>
	<link src="${root}/resources/vendor/My97DatePicker/skin/WdatePicker.css">
    <style>
    	.sxedit {visibility: hidden;}
    	tr:hover .sxedit {visibility: visible;}
    </style>
</head>
<body>
<!-- 库存列表begin -->
<div class="wrap-bd">
    <div class="mb-default">
        <div>商品数据汇总</div>
    </div>
    <div class="mb-small clearfix">
       <form action="${root}/analysis/orderList/getPagerList.do" method="post" id="orderListForm">
	        <label class="ml-default">查询时间：</label>
	        <input type="text" name="startTime" id="startTime" value="${orderVo.startTime}" class="input input-search-date J_DATE_START" placeholder="" />
	        &nbsp;至&nbsp;
	        <input type="text" name="endTime" id="endTime" value="${orderVo.endTime}" class="input input-search-date mr-small J_DATE_END" placeholder="" />
	        <input type="button" id="queryButton" value="搜索" class="input input-search-button ml-default">
	        <input type="button" class="input input-search-button ml-default"  id="btnExport" value="导出"/>
       </form>
    </div>
    <div>
       <table class="table-list table-border" id="tblProductList">
         <thead class="table-thead">
			<tr>		
				<th>区域</th>
				<th>下单时间</th>
				<th>父订单号</th>
				<th>订单号</th>
				<th>商铺名称</th>
				<th>商铺联系人</th>
				<th>店铺电话</th>
				<th>店铺地址</th>
				<th>商品价格</th>
				<th>订单价格</th>
				<th>商品编码</th>
				<th>品牌</th>
				<th>商品ID</th>
				<th>商品名称</th>
				<th>商品规格</th>
				<th>商品单价</th>
				<th>商品数量</th>
				<th>商品金额</th>
				<th>总毛利</th>
				<th>批发商ID</th>
				<th>商铺定格ID</th>
				<th>商铺定格</th>
				<th>小分类</th>
				<th>大分类</th>
				<th>订单状态</th>
				<th>支付状态</th>
				<th>优惠券金额</th>
				<th>满减</th>
			</tr>
		</thead>
         <tbody class="table-tbody">
         </tbody>
       </table>
    </div>
    <%@ include file="../common/pagination.jsp"%>
</div>
<script>
$(document).ready(function(){
	  //日期初始化加载
	 dateRangeSimple('.J_DATE_START', '.J_DATE_END');
	  
		$("#btnExport").click(function(){
			 if(confirm("确定要导出用户数据吗？")){
				 $("#orderListForm").attr("action","${root}/analysis/orderList/export.do");
				 $("#orderListForm").submit();
			 }
		});
});


	$("#jpagination").pagination({
	    pageSize: 10,
	    remote: {
	        url: '${root}/analysis/orderList/getPagerList.do',
	        params: $('#orderListForm').serializeArray(),
	        success: function(data) {
	            var html='';
	            
	            $.each(data.list, function(i,item) {
	            	var areaName = item.areaName==null?"":item.areaName;
	            	html+='<tr>'
		                +'<td>'+areaName+'</td>'
		                +'<td>'+item.addTime+'</td>'
		                +'<td>'+item.orderId+'</td>'
		                +'<td>'+item.orderId2+'</td>'
		                +'<td>'+item.storeName+'</td>'
		                +'<td>'+item.consignee+'</td>'
		                +'<td>'+item.mobile+'</td>'
		                +'<td>'+item.address+'</td>'
		                +'<td>'+item.goodsPrice+'</td>'
		                +'<td>'+item.orderPrice+'</td>'
		                +'<td>'+item.barCode+'</td>'
		                +'<td>'+item.brand+'</td>'
		                +'<td>'+item.productId+'</td>'
		                +'<td>'+item.productName+'</td>'
		                +'<td>'+item.spec+'</td>'
		                +'<td>'+item.price+'</td>'
		                +'<td>'+item.quantity+'</td>'
		                +'<td>'+item.totalPrice+'</td>'
		                +'<td>'+item.zmaoli+'</td>'
		                +'<td>'+item.supplierId+'</td>'
		                +'<td>'+item.spGroupId+'</td>'
		                +'<td>'+item.spGroupName+'</td>'
		                +'<td>'+item.smCategory+'</td>'
		                +'<td>'+item.bgCategory+'</td>'
		                +'<td>'+item.status+'</td>'
		                +'<td>'+item.supportmetho+'</td>'
		                +'<td>'+item.coupon+'</td>'
		                +'<td>'+item.rebate+'</td>'
	            	    +'</tr>'; 
	            });
	            
                if(html == "") {
                 	html = '<tr><td colspan="8" class="no-data"></td></tr>';
                }
	            $('#tblProductList .table-tbody').html(html);
	        },
            totalName:'totalSize',
            pageParams: function (data) {
               	return {
               			pageIndex: data.pageIndex + 1,
               			pageSize: data.pageSize
               		}
            }
	    }
	});
	
	//条件验证
	$('#queryButton').on('click', function(e) {
		 $("#orderListForm").attr("action","${root}/analysis/orderList/getPagerList.do");
      	 $("#jpagination").pagination('setParams', $('#orderListForm').serializeArray());
      	 $("#jpagination").pagination('setPageIndex', 0);
      	 $("#jpagination").pagination('remote');
     });
	
</script>
<!-- 库存列表end -->

</body>
</html>