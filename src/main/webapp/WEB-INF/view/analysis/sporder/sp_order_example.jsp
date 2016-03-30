<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../common/taglib.jsp"%>
<% request.setAttribute("root", request.getContextPath());%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>街坊店宝</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
	<%@ include file="../../common/head.jsp"%>
 	<script src="<%=request.getContextPath() %>/resources/js/echarts/echarts.js"></script>
	<script src="<%=request.getContextPath() %>/resources/js/jquery/jquery-1.9.1.min.js"></script>
	<link src="${root}/resources/vendor/My97DatePicker/skin/WdatePicker.css">
	<script src="${root}/resources/vendor/My97DatePicker/WdatePicker.js"></script>
	<script src="${root}/resources/js/comm.js"></script>
	<script src="${root}/resources/analysis/globalStatisList.js"></script>
	<script src="<%=request.getContextPath() %>/resources/js/angular/angular.js"></script>
    <style>
    	.sxedit {visibility: hidden;}
    	tr:hover .sxedit {visibility: visible;}
		.colora {color: #ed4b1c;}
		.colorb {color: #06ada3;}
    </style>
</head>
<body>
<!-- 全局统计列表begin -->
<div class="wrap-bd" ng-app="orderTable">
    <div class="mb-default">
        <span class="crumb">全局统计</span><span class="crumb-active">核心数据汇总</span>
    </div>
    <div class="mb-small clearfix" ng-controller="query_order">
       <form action="${root}/analysis/statis/getStatisList.do" method="post" id="searchForm">
        <label>查询时间</label>
        <input type="text" name="startTime" id="startTime" value="${statisVo.startTime}" class="input input-search-date J_DATE_START" placeholder="" />
        &nbsp;至&nbsp;
        <input type="text" name="endTime" id="endTime" value="${statisVo.endTime}" class="input input-search-date mr-small J_DATE_END" placeholder="" />
        <input type="button" class="input input-search-button ml-default"  id="btnQuery" value="搜索"  ng-click="queryOrders()"/>
        <input type="button" class="input input-search-button ml-default"  id="btnExport" value="导出"/>
       </form>
    </div>
    <div>
        <table class="table-list table-border" ng-controller="tableController">
            <thead class="table-thead">
 				<tr class="table-header">
			      <th ng-repeat="a in cn_keys">{{a}}</th>
			    </tr>
		    </thead>
         <tbody class="table-tbody">
         </tbody>
       </table>
    </div>
    <%@ include file="../../common/pagination.jsp"%>
</div>
<!-- 全局统计列表end -->
<script>

	var tableController = '<%=request.getContextPath() %>/api/sp_order/spOrderList.do';
	var app = angular.module('orderTable', []); // 第二个参数定义了Module依赖
	
	
	app.config(function($httpProvider) {
        //删除AngularJS默认的X-Request-With头
        delete $httpProvider.default.headers.common['X-Requested-With'];
        //为所有GET请求设置DO NOT TRACK
        $httpProvider.default.headers.get['DNT'] = '1';
	});
	//添加controller
/* 	app.config(['$routeProvider',function ($routeProvider) {
	      $routeProvider
	      .when('/list', {
	        templateUrl: 'views/route/list.html',
	        controller: 'RouteListCtl'
	      })
	      .when('/list/:id', {
	          templateUrl: 'views/route/detail.html',
	          controller: 'RouteDetailCtl'
	      })
	      .otherwise({
	        redirectTo: '/list'
	      });
	}]); */
	
	//添加controller
	app.controller("tableController", ['$scope','$http', function($scope, $http) {
		
		var postData = {text:'long blob of text'};  
		//下面这一行会被当成参数附加到URL后面，所以post请求最终会变成/api/user?id=5  
		var config = {params: {id: '5'}};  
		$http.post(tableController, postData, config).success(function(data, status, headers, config) {  
			 $scope.cn_keys = data; 
		}).error(function(data, status, headers, config) {  
			 alert("an unexpected error ocurred!");
		});  
<%-- 		
		
		$http.post('<%=request.getContextPath() %>/api/sp_order/spOrderList.do').success(function(data){
	        $scope.cn_keys = data;
	    }).error(function(){
	        alert("an unexpected error ocurred!");
	    }); --%>
		
		/* $scope.items = [
            {name: "雷柏（Rapoo） V500 机械游戏键盘 机械黄轴", quantity: 1, price: 199.00},
            {name: "雷柏（Rapoo） V20 光学游戏鼠标 黑色烈焰版", quantity: 1, price: 139.00},
            {name: "AngularJS权威教程", quantity: 2, price: 84.20}
        ]; */
	}]);
	
 	app.controller('query_order', ['$scope','$http', function($scope, $http) {
		$scope.queryOrders = function(){
		    alert("query!"); 	
		}
	}]);
	
</script>
</body>
</html>