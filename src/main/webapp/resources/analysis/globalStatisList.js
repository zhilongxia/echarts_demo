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
		 var xzzdTotal = 0,hyzdTotal =0,gpzdTotal =0,xdcsTotal=0,xdskuTotal=0,
		 	 xlTotal=0,xsjeTotal=0,ylspxseTotal=0,   ylsplrTotal=0,fyjeTotal=0;

		 $(".table-tbody").find('tr').each(function(){
	        var tmpXzzdVal = $(this).find('td').eq(1).text();
	        var tmpHyzdVal = $(this).find('td').eq(2).text();
	        var tmpGpzdVal = $(this).find('td').eq(3).text();
	        var tmpXdcsVal = $(this).find('td').eq(4).text();
	        var tmpXdskuVal = $(this).find('td').eq(5).text();
	        var tmpXlVal = $(this).find('td').eq(6).text();
	        
	        var tmpXsjeVal = $(this).find('td').eq(7).text();
	        var tmpYlspxseVal = $(this).find('td').eq(8).text();
	        var tmpYlsplrVal = $(this).find('td').eq(9).text();
	        var tmpFyjeVal = $(this).find('td').eq(10).text();
	        
  			if(tmpXzzdVal != null && tmpXzzdVal !=''){
	        	xzzdTotal = numAdd(xzzdTotal,tmpXzzdVal);
  			}
  			if(tmpHyzdVal != null && tmpHyzdVal !=''){
  				hyzdTotal = numAdd(hyzdTotal,tmpHyzdVal);
  			}
  			if(tmpGpzdVal != null && tmpGpzdVal !=''){
  				gpzdTotal = numAdd(gpzdTotal,tmpGpzdVal);
  			}
  			if(tmpXdcsVal != null && tmpXdcsVal !=''){
  				xdcsTotal = numAdd(xdcsTotal,tmpXdcsVal);
  			}
  			if(tmpXdskuVal != null && tmpXdskuVal !=''){
  				xdskuTotal = numAdd(xdskuTotal,tmpXdskuVal);
  			}
  			
  			if(tmpXlVal != null && tmpXlVal !=''){
  				xlTotal = numAdd(xlTotal,tmpXlVal);
  			}
  			if(tmpXsjeVal != null && tmpXsjeVal !=''){
  				xsjeTotal = numAdd(xsjeTotal,tmpXsjeVal);
  			}
  			if(tmpYlspxseVal != null && tmpYlspxseVal !=''){
  				ylspxseTotal = numAdd(ylspxseTotal,tmpYlspxseVal);
  			}
  			
  			if(tmpYlsplrVal != null && tmpYlsplrVal !=''){
  				ylsplrTotal = numAdd(ylsplrTotal,tmpYlsplrVal);
  			}
  			if(tmpFyjeVal != null && tmpFyjeVal !=''){
  				fyjeTotal = numAdd(fyjeTotal,tmpFyjeVal);
  			}
	    })
	    $("#xzzdTotal").text(xzzdTotal);
		$("#hyzdTotal").text(hyzdTotal);
		$("#gpzdTotal").text(gpzdTotal);
		$("#xdcsTotal").text(xdcsTotal);
		$("#xdskuTotal").text(xdskuTotal);
		$("#xlTotal").text(xlTotal);
		$("#xsjeTotal").text(xsjeTotal.toFixed(2));
		$("#ylspxseTotal").text(ylspxseTotal.toFixed(2));
		$("#ylsplrTotal").text(ylsplrTotal.toFixed(2));
		$("#fyjeTotal").text(fyjeTotal.toFixed(2));
		var fylVal = fyjeTotal/xsjeTotal*100;
		if(!isNaN(fylVal)){
			$("#fylTotal").text(fylVal.toFixed(2)+"%");
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
	