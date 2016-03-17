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
    <!--Step:1 Prepare a dom for ECharts which (must) has size (width & hight)-->  
    <!--Step:1 为ECharts准备一个具备大小（宽高）的Dom-->  
    <div id="mainBar" style="height:500px;border:1px solid #ccc;padding:10px;"></div>  
      
    <!--Step:2 Import echarts.js-->  
    <!--Step:2 引入echarts.js-->  
    <script src="<%=request.getContextPath() %>/resources/js/echarts/echarts.js"></script>  
      
    <script type="text/javascript">  
    // Step:3 conifg ECharts's path, link to echarts.js from current page.  
    // Step:3 为模块加载器配置echarts的路径，从当前页面链接到echarts.js，定义所需图表路径  
    require.config({  
        paths: {  
            echarts: '<%=request.getContextPath() %>/resources/js/echarts'  
        }  
    });  
      
    // Step:4 require echarts and use it in the callback.  
    // Step:4 动态加载echarts然后在回调函数中开始使用，注意保持按需加载结构定义图表路径  
    require(  
        [  
            //这里的'echarts'相当于'./js'  
            'echarts',  
            'echarts/chart/bar',  
            'echarts/chart/line'
        ],  
        //创建ECharts图表方法  
        function (ec) {  
            //--- 折柱 ---  
                //基于准备好的dom,初始化echart图表  
            var myChart = ec.init(document.getElementById('mainBar'));  
            //定义图表option  
             var option = {
            		    title: {
            		        x: "left",
            		        y: "top",
            		        text: "核心数据汇总",
            		        link: "http://www.tqyb.com.cn/weatherLive/climateForecast/2014-01-26/157.html",
            		        subtext: "www.stepday.com",
            		        sublink: "http://www.stepday.com/myblog/?Echarts"
            		    },
            		    toolbox: {
            		        show: true,
            		        feature: {
            		            mark: {
            		                show: true,
            		                title: {
            		                    mark: "辅助线开关",
            		                    markClear: "清空辅助线",
            		                    markUndo: "删除辅助线"
            		                },
            		                lineStyle: {
            		                    color: "#1e90ff",
            		                    type: "dashed",
            		                    width: 2
            		                }
            		            },
            		            dataZoom: {
            		                show: true,
            		                title: {
            		                    dataZoom: "区域缩放",
            		                    dataZoomReset: "区域缩放后退"
            		                }
            		            },
            		            dataView: {
            		                show: true,
            		                title: "数据视图",
            		                readOnly: true,
            		                lang: [
            		                    "数据视图",
            		                    "关闭",
            		                    "刷新"
            		                ]
            		            },
            		            magicType: {
            		                show: true,
            		                title: {
            		                    line: "折线图切换",
            		                    stack: "堆积",
            		                    bar: "柱形图切换",
            		                    tiled: "平铺"
            		                },
            		                type: [
            		                    "line",
            		                    "bar",
            		                    "stack",
            		                    "tiled"
            		                ]
            		            },
            		            restore: {
            		                show: true,
            		                title: "还原"
            		            },
            		            saveAsImage: {
            		                show: true,
            		                title: "保存为图片",
            		                type: "png",
            		                lang: [
            		                    "点击保存"
            		                ]
            		            }
            		        }
            		    },
            		    tooltip: {
            		        trigger: "axis"
            		    },
            		    legend: {
            		        show: true,
            		        x: "center",
            		        y: "top",
            		        data: [
            		            "商铺（家）",
            		            "下单",
            		            "销售金额（元）",
            		            "费用"
            		        ]
            		    },
            		    xAxis: [
            		        {
            		            data: [
            		                "福田区",
            		                "南山区",
            		                "龙岗区",
            		                "坪山",
            		                "横岗",
            		                "南山转角",
            		                "龙岗转角",
            		                "石岩",
            		                "坂田",
            		                "龙华"
            		            ],
            		            show: true,
            		            type: "category"
            		        }
            		    ],
            		    yAxis: [
            		        {
            		            show: true,
            		            type: "value",
            		            splitArea: {
            		                show: true
            		            }
            		        }
            		    ],
            		    series: [
            		        {
            		            data: [2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3],
            		            name: "商铺（家）",
            		            type: "bar",
            		            stack: "下单"
            		        },
            		        {
            		        	data: [2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3],
            		            name: "下单",
            		            type: "bar"
            		        },
            		        {
            		        	data: [2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3],
            		            name: "销售金额（元）",
            		            type: "bar"
            		           
            		        },
            		        {
            		            data: [2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3],
            		            name: "费用",
            		            type: "bar"
            		           
            		        }
            		    ]
            		}; 
                  
            //为echarts对象加载数据              
            myChart.setOption(option);  
        }  
    );  
    </script>  
  </body>  
</html>  