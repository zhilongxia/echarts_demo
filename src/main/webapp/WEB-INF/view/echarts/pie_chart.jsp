<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>ECharts pie 实例</title>
</head>
<body>
	<div id="main" style="height: 400px"></div>
	<script src="<%=request.getContextPath()%>/resources/js/echarts/echarts.js"></script>
	<script type="text/javascript"> 
	    require.config({  
	        paths: {  
	            echarts: '<%=request.getContextPath()%>/resources/js/echarts'
			}
		});

		require(
		[ 
	          'echarts', 'echarts/chart/pie' // 使用柱状图就加载bar模块，按需加载
		], 
		function(ec) {
			// 基于准备好的dom，初始化echarts图表
			myChart = ec.init(document.getElementById('main'));

			var option = {
				title : {
					text : 'ECharts实例',
					subtext : '饼图（Pie Chart）',
					x : 'center'
				},
				tooltip : {
					trigger : 'item',
					formatter : "{a} <br/>{b} : {c} ({d}%)"
				},
				legend : {
					orient : 'vertical',
					x : 'left',
					data : [ 'part1', 'part2', 'part3', 'part4' ]
				},
				toolbox : {
					show : true,
					feature : {
						//mark : {show: true},
						//dataView : {show: true, readOnly: false},
						restore : {
							show : true
						},
					//saveAsImage : {show: true}
					}
				},
				calculable : false,
				series : [ {
					name : '饼图实例',
					type : 'pie',
					radius : '55%',
					center : [ '50%', '60%' ],
					data : [ {
						value : 100,
						name : 'part1'
					}, {
						value : 200,
						name : 'part2'
					}, {
						value : 300,
						name : 'part3'
					}, {
						value : 400,
						name : 'part4'
					} ]
				} ]
			};
			// 为echarts对象加载数据 
			myChart.setOption(option);
		});
	</script>
</body>
</html>