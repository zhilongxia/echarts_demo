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
	<script src="<%=request.getContextPath() %>/resources/js/echarts/echarts.js"></script>
	<script src="<%=request.getContextPath() %>/resources/js/jquery/jquery-1.9.1.min.js"></script>
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
</head>
<body>
<!-- 全局统计列表begin -->
<div class="wrap-bd">
    <div class="mb-default">
        <span class="crumb">全局统计</span><span class="crumb-active">核心数据汇总</span>
    </div>
    <div class="mb-small clearfix">
       <form action="${root}/analysis/statis/getStatisList.do" method="post" id="searchForm">
        <label>查询时间</label>
        <input type="text" name="startTime" id="startTime" value="${statisVo.startTime}" class="input input-search-date J_DATE_START" placeholder="" />
        &nbsp;至&nbsp;
        <input type="text" name="endTime" id="endTime" value="${statisVo.endTime}" class="input input-search-date mr-small J_DATE_END" placeholder="" />
        <input type="button" class="input input-search-button ml-default"  id="btnQuery" value="搜索" />
        <input type="button" class="input input-search-button ml-default"  id="btnExport" value="导出"/>
       </form>
    </div>
    <div>
       <table class="table-list table-border" id="tblDataStatic">
         	 <div id="mainBar" style="height:800px;border:1px solid #ccc;padding:10px;"></div>  
         </tbody>
       </table>
    </div>
    <%@ include file="../common/pagination.jsp"%>
</div>
<!-- 全局统计列表end -->
<script>
	
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