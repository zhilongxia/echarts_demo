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
<%-- 	<%@ include file="../common/autocomplete.jsp"%> --%>
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
       <form action="${root}/analysis/store/getPagerList.do" name="orderid" method="post" id="stoteForm">
	        <label class="ml-default">查询时间：</label>
	        <input type="text" name="startTime" id="startTime" value="${storeVo.startTime}" class="input input-search-date J_DATE_START" placeholder="" />
	        &nbsp;至&nbsp;
	        <input type="text" name="endTime" id="endTime" value="${storeVo.endTime}" class="input input-search-date mr-small J_DATE_END" placeholder="" />
	        <input type="button" id="queryButton" value="搜索" class="input input-search-button ml-default">
	        <input type="button" class="input input-search-button ml-default"  id="btnExport" value="导出"/>
       </form>
    </div>
    <div>
       <table class="table-list table-border" id="tblProductList">
         <thead class="table-thead">
			<tr>						
				<th>区域</th>
				<th>店铺编码</th>
				<th>店铺名称</th>
				<th>店铺老板</th>
				<th>店铺电话</th>
				<th>店铺地址</th>
				<th>注册时间</th>
				<th>商铺定格</th>
				<th>业务员电话</th>
				<th>业务员名称</th>
				<th>店铺状态</th>
				<th>营业执照</th>
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
				 $("#stoteForm").attr("action","${root}/analysis/store/export.do");
				 $("#stoteForm").submit();
			 }
		});
});


	$("#jpagination").pagination({
	    pageSize: 10,
	    remote: {
	        url: '${root}/analysis/store/getPagerList.do',
	        params: $('#stoteForm').serializeArray(),
	        success: function(data) {
	            var html='';
	            //原来列表的查询条件
	            var startTime = data.map.storeVo.startTime;
	            var endTime = data.map.storeVo.endTime;
	            var areaId = data.map.storeVo.areaId;
	            
	            $.each(data.list, function(i,item) {
	            	var areaName = item.areaName==null?"":item.areaName;
	            	html+='<tr>'
		                +'<td>'+areaName+'</td>'
		                +'<td>'+item.id+'</td>'
		                +'<td>'+item.name+'</td>'
		                +'<td>'+item.contact+'</td>'
		                +'<td>'+item.shopTel+'</td>'
		                +'<td>'+item.address+'</td>'
		                +'<td>'+item.addTime+'</td>'
		                +'<td>'+item.shopRatedName+'</td>'
		                +'<td>'+item.yewuRenTel+'</td>'
		                +'<td>'+item.yewuRenName+'</td>'
		                +'<td>'+item.status+'</td>'
		                +'<td>'+item.licenseNum+'</td>'
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
		$("#stoteForm").attr("action","${root}/analysis/store/getPagerList.do");
      	 $("#jpagination").pagination('setParams', $('#stoteForm').serializeArray());
      	 $("#jpagination").pagination('setPageIndex', 0);
      	 $("#jpagination").pagination('remote');
     });
	
	function getProductDetail(id){
		
	}
</script>
<!-- 库存列表end -->

</body>
</html>