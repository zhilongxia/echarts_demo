<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <base href="<%=basePath%>">  
    <title>ECharts实例</title>  
  </head>  
  <body>  
    <div id="mainBar" style="height:500px;border:1px solid #ccc;padding:10px;"></div>  
    
    <script src="<%=request.getContextPath() %>/resources/js/echarts/echarts.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/jquery/jquery-1.9.1.min.js"></script>
    
      
   <script type="text/javascript">  
	
		var loadUrl = '<%=request.getContextPath() %>/gateway/getGraphJson';
	
		// 配置路径  
	    require.config({  
	        paths: {  
	            echarts: '<%=request.getContextPath() %>/resources/js/echarts'  
	        }  
	    });  
	      
	    // 按需加载  
	    require(  
	    	 [  
	             //这里的'echarts'相当于'./js'  
	             'echarts',  
	             'echarts/chart/bar',  
	             'echarts/chart/line',  
	         ],  
	        function (ec) {  
	    		var echart = ec.init(document.getElementById('mainBar'));  
	            echart.showLoading({  
	                text: '正在努力加载中...'  
	            });  
	               
	            var values = [];  
	              
	            // 同步执行  
	            $.ajaxSettings.async = false;  
	              
	            // 加载数据  
	            $.getJSON(loadUrl, function (json) {  
	                values = json;  
	            });  
	              
	            var option = values;  
	              
	            echart.setOption(option);  
	            echart.hideLoading();  
	        }  
	    );  
    </script>
  </body>  
</html>  