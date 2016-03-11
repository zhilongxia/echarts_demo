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
            'echarts/chart/line',  
        ],  
        //创建ECharts图表方法  
        function (ec) {  
            //--- 折柱 ---  
                //基于准备好的dom,初始化echart图表  
            var myChart = ec.init(document.getElementById('mainBar'));  
            //定义图表option  
            var option = {
       		    tooltip : {
       		        show: true,
       		        trigger: 'item'
       		    },
       		    legend: {
       		        data:['邮件营销','联盟广告','直接访问','搜索引擎']
       		    },
       		    toolbox: {
       		        show : true,
       		        feature : {
       		            mark : {show: true},
       		            dataView : {show: true, readOnly: false},
       		            magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
       		            restore : {show: true},
       		            saveAsImage : {show: true}
       		        }
       		    },
       		    calculable : true,
       		    xAxis : [
       		        {
       		            type : 'category',
       		            data : ['周一','周二','周三','周四','周五','周六','周日']
       		        }
       		    ],
       		    yAxis : [
       		        {
       		            type : 'value'
       		        }
       		    ],
       		    series : [
       		        {
       		            name:'邮件营销',
       		            type:'bar',
       		            itemStyle: {        // 系列级个性化样式，纵向渐变填充
       		                normal: {
       		                    barBorderColor:'red',
       		                    barBorderWidth: 0,
       		                    color : (function (){
       		                        var zrColor = require('zrender/tool/color');
       		                        return zrColor.getLinearGradient(
       		                            0, 400, 0, 300,
       		                            [[0, 'green'],[1, 'yellow']]
       		                        )
       		                    })()
       		                },
       		                emphasis: {
       		                    barBorderWidth: 0,
       		                    barBorderColor:'green',
       		                    color: (function (){
       		                        var zrColor = require('zrender/tool/color');
       		                        return zrColor.getLinearGradient(
       		                            0, 400, 0, 300,
       		                            [[0, 'red'],[1, 'orange']]
       		                        )
       		                    })(),
       		                    label : {
       		                        show : true,
       		                        position : 'top',
       		                        formatter : "{a} {b} {c}",
       		                        textStyle : {
       		                            color: 'blue'
       		                        }
       		                    }
       		                }
       		            },
       		            data:[220, 232, 101, 234, 190, 330, 210]
       		        },
       		        {
       		            name:'联盟广告',
       		            type:'bar',
       		            stack: '总量',
       		            data:[120, 90, 451, 134, 190, 230, 110]
       		        },
       		        {
       		            name:'直接访问',
       		            type:'bar',
       		            stack: '总量',
       		            itemStyle: {                // 系列级个性化
       		                normal: {
       		                    barBorderWidth: 0,
       		                    barBorderColor:'tomato',
       		                    color: 'red'
       		                },
       		                emphasis: {
       		                    barBorderColor:'red',
       		                    color: 'blue'
       		                }
       		            },
       		            data:[
       		                320, 332, 100, 334,
       		                {
       		                    value: 390,
       		                    symbolSize : 10,   // 数据级个性化
       		                    itemStyle: {
       		                        normal: {
       		                            color :'lime'
       		                        },
       		                        emphasis: {
       		                            color: 'skyBlue'
       		                        }
       		                    }
       		                },
       		                330, 320
       		            ]
       		        },
       		        {
       		            name:'搜索引擎',
       		            type:'bar',
       		            barWidth: 40,                   // 系列级个性化，柱形宽度
       		            itemStyle: {
       		                normal: {                   // 系列级个性化，横向渐变填充
       		                    borderRadius: 5,
       		                    color : (function (){
       		                        var zrColor = require('zrender/tool/color');
       		                        return zrColor.getLinearGradient(
       		                            0, 0, 1000, 0,
       		                            [[0, 'rgba(30,144,255,0.8)'],[1, 'rgba(138,43,26,0.8)']]
       		                        )
       		                    })(),
       		                    label : {
       		                        show : true,
       		                        textStyle : {
       		                            fontSize : '20',
       		                            fontFamily : '微软雅黑',
       		                            fontWeight : 'bold'
       		                        }
       		                    }
       		                }
       		            },
       		            data:[
       		                620, 732, 
       		                {
       		                    value: 701,
       		                    itemStyle : { normal: {label : {position: 'inside'}}}
       		                },
       		                734, 890, 930, 820
       		            ],
       		            markLine : {
       		                data : [
       		                    {type : 'average', name : '平均值'},
       		                    {type : 'max'},
       		                    {type : 'min'}
       		                ]
       		            }
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