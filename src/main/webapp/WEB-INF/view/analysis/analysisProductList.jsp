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
       <form action="${root}/analysis/product/getPagerList.do" name="orderid" method="post" id="productForm">
       		<label>查询区域：</label>
            <select class="select" name="areaId" id="areaId">
				<option value="" <c:if test="${productVo.areaId eq ''}">selected</c:if>>全部区域</option>
				<option value="705" <c:if test="${productVo.areaId eq '705'}">selected</c:if>>福田区</option>
				<option value="707" <c:if test="${productVo.areaId eq '707'}">selected</c:if>>南山区</option>
				<option value="708" <c:if test="${productVo.areaId eq '708'}">selected</c:if>>宝安区</option>
				<option value="709" <c:if test="${productVo.areaId eq '709'}">selected</c:if>>龙岗区</option>
				<option value="3406" <c:if test="${productVo.areaId eq '3406'}">selected</c:if>>坪山区</option>
				<option value="3407" <c:if test="${productVo.areaId eq '3407'}">selected</c:if>>横岗区</option>
		    </select>
	        <label class="ml-default">查询时间：</label>
	        <input type="text" name="startTime" id="startTime" value="${productVo.startTime}" class="input input-search-date J_DATE_START" placeholder="" />
	        &nbsp;至&nbsp;
	        <input type="text" name="endTime" id="endTime" value="${productVo.endTime}" class="input input-search-date mr-small J_DATE_END" placeholder="" />
	        <input type="text" name="spmc" id="spmc" value="${productVo.spmc}" placeholder="商品名称/商品条码" class="input input-search-text ml-default">
	        <input type="button" id="queryButton" value="搜索" class="input input-search-button ml-default">
	        <input type="button" class="input input-search-button ml-default"  id="btnExport" value="导出"/>
       </form>
    </div>
    <div>
       <table class="table-list table-border" id="tblProductList">
         <thead class="table-thead">
			<tr>															
				<th>区域</th>
				<th>商品条码</th>
				<th>一级分类</th>
				<th>二级分类</th>
				<th>商品名称</th>
				<th>规格</th>
				<th>市场价</th>
				<th>合作商进货价</th>
				<th>合作商出货价</th>
				<th>合作商毛利</th>
				<th>下单次数</th>
				<th>销售数量</th>
				<th>销售金额</th>
				<th>商品费用</th>
				<th>费用率</th>
				<th>操作</th>
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
				 $("#productForm").attr("action","${root}/analysis/product/export.do");
				 $("#productForm").submit();
			 }
		});
});


	$("#jpagination").pagination({
	    pageSize: 10,
	    remote: {
	        url: '${root}/analysis/product/getPagerList.do',
	        params: $('#productForm').serializeArray(),
	        success: function(data) {
	            var html='';
	            //原来列表的查询条件
	            var startTime = data.map.productVo.startTime;
	            var endTime = data.map.productVo.endTime;
	            var areaId = data.map.productVo.areaId;
	            
	            $.each(data.list, function(i,item) {
	            	var areaName = item.areaName==null?"":item.areaName;
	            	var sptm = item.sptm==null?"":item.sptm;
	            	var yjfl = item.yjfl==null?"":item.yjfl;
	            	var ejfl = item.ejfl==null?"":item.ejfl;
	            	var spmc = item.spmc==null?"":item.spmc;
	            	
	            	var spec = item.spec==null?"":item.spec;
	            	var scj = item.scj==null?"":item.scj;
	            	var hzsjhj = item.hzsjhj==null?"":item.hzsjhj;
	            	
	            	var hzschj = item.hzschj==null?"":item.hzschj;
	            	
	            	var maoli = item.maoli==null?"":item.maoli;
	            	
	            	var xdcs = item.xdcs==null?"":item.xdcs;
	            	var xssl = item.xssl==null?"":item.xssl;
	            	var xsje = item.xsje==null?"":item.xsje;
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
		                +'<td>'+sptm+'</td>'
		                +'<td>'+yjfl+'</td>'
		                +'<td>'+ejfl+'</td>'
		                +'<td>'+spmc+'</td>'
		                +'<td>'+spec+'</td>'
		                +'<td>'+scj+'</td>'
		                +'<td>'+hzsjhj+'</td>'
		                +'<td>'+hzschj+'</td>'
		                +'<td>'+maoli+'</td>'
		                +'<td>'+xdcs+'</td>'
		                +'<td>'+xssl+'</td>'
		                +'<td class="colora">'+xsje+'</td>'
		                +'<td class="colorb">'+fyje+'</td>'
		                +'<td>'+flVal+'%</td>'
// 	            	    +'<td><a data-id="" data-area=""  data-endtime="" onclick="getProductDetail('+item.id+');">查看</a></td>'
	            	    +'<td><a href="${root}/analysis/product/getProductDetailById.do?id='+item.id+'&areaId='+areaId+'&startTime='+startTime+'&endTime='+endTime+'" target="_blank">查看</a></td>'
	            	    +'</tr>'; 
	            });
	            
                if(html == "") {
                 	html = '<tr><td colspan="8" class="no-data"></td></tr>';
                }
	            $('#tblProductList .table-tbody').html(html);
	        },
	        totalName:'totalSize',
	        
	    }
	});
	
	//条件验证
	$('#queryButton').on('click', function(e) {
		$("#productForm").attr("action","${root}/analysis/product/getPagerList.do");
      	 $("#jpagination").pagination('setParams', $('#productForm').serializeArray());
      	 $("#jpagination").pagination('setPageIndex', 0);
      	 $("#jpagination").pagination('remote');
     });
	
	function getProductDetail(id){
		
	}
</script>
<!-- 库存列表end -->

</body>
</html>