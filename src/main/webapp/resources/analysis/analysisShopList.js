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
		 var zdslTotal = 0,wxdTotal = 0,xd1Total = 0,xd2Total = 0,xd3Total = 0,xd4Total = 0,xse1Total=0,xse2Total=0,xse3Total=0,xse4Total=0;

		 $("#tblShopAnalysis .table-tbody").find('tr').each(function(){
	        var tmpZdslVal = $(this).find('td').eq(1).text();
	        alert(tmpZdslVal);
	        
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
		
		var wxdzbTotal = 0,xd1zbTotal = 0,xd2zbTotal = 0,xd3zbTotal = 0,xd4zbTotal = 0,xse1zbTotal=0,xse2zbTotal=0,xse3zbTotal=0,xse4zbTotal=0;
		wxdzbTotal = wxdTotal/zdslTotal*100;
		xd1zbTotal = xd1Total/zdslTotal*100;
		xd2zbTotal = xd2Total/zdslTotal*100;
		xd3zbTotal = xd3Total/zdslTotal*100;
		xd4zbTotal = xd4Total/zdslTotal*100;
		
		xse1zbTotal = xd1Total/zdslTotal*100;
		xse2zbTotal = xd2Total/zdslTotal*100;
		xse3zbTotal = xd3Total/zdslTotal*100;
		xse4zbTotal = xd4Total/zdslTotal*100;
		
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
		
		/*var fylVal = fyjeTotal/xsjeTotal*100;
		if(!isNaN(fylVal)){
			$("#fylTotal").text(fylVal.toFixed(2)+"%");
		}*/
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
	