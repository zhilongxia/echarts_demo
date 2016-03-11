$(document).ready(function(){
	  //日期初始化加载
	 dateRangeSimple('.J_DATE_START', '.J_DATE_END');
});

/** 
 * 商铺销售明细报表分页查询
 */ 
function queryShopSaleList(){
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
	            	    +'<td><a href="${root}/analysis/product/getProductDetailById.do?id='+item.id+'&areaId='+areaId+'&startTime='+startTime+'&endTime='+endTime+'" target="_blank">查看</a></td>'
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
}