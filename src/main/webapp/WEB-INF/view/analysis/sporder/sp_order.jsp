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
	<link rel="stylesheet" href="${root}/resources/vendor/jquery/pagination/mricode.pagination.css">
	<script src="${root}/resources/vendor/jquery/pagination/mricode.pagination.js"></script>
	<style>
		#jpagination {margin: 8px 0; float: right}
	</style>
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
    <div ng-controller="tableController">
        <table class="table-list table-border">
            <thead class="table-thead">
 				<tr class="table-header">
			      <th ng-repeat="a in cn_keys">{{a}}</th>
			    </tr>
		    </thead>
	        <tbody class="table-tbody">
	            <tr ng-repeat="d_row in key_dataList"> 
	                <td ng-repeat="b in d_row track by $index">{{b}}</td>
	            </tr>
	        </tbody>
       </table>
    </div>
    <div id="jpagination">
    	<ul class="m-pagination-page" style="">
	    	<li class="active"><a data-page-index="0">1</a></li>
	    	<li><a data-page-index="1">2</a></li>
	    	<li><a data-page-index="2">3</a></li>
	    	<li><a data-page-index="3">4</a></li>
	    	<li><a data-page-index="1">下一页</a></li>
	    	<li><a data-page-index="6050">尾页</a></li>
    	</ul>
    <div class="m-pagination-size" style="display: none;">
	    <select data-page-btn="size">
		    <option value="5">5</option>
		    <option value="10" selected="">10</option>
		    <option value="15">15</option>
		    <option value="20">20</option>
	    </select>
    </div>
    <div class="m-pagination-jump" style="">
	    <div class="m-pagination-group">
	   		 <input data-page-btn="jump" type="text"><button data-page-btn="jump" type="button">Go</button>
	    </div>
    </div>
    <div class="m-pagination-info" style="display: none;">1 ~ 10 of 60507 entires</div></div>
</div>
<!-- 全局统计列表end -->
<script>

	var tableController_url = '<%=request.getContextPath() %>/api/sp_order/spOrderList.do';
/* 	var app = angular.module('orderTable', []); // 第二个参数定义了Module依赖 */
	var app = angular.module('orderTable', [], function ($httpProvider) {
	    // Use x-www-form-urlencoded Content-Type
	    $httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';

	    /**
	    * The workhorse; converts an object to x-www-form-urlencoded serialization.
	    * @param {Object} obj
	    * @return {String}
	    */
	    var param = function (obj) {
	        var query = '', name, value, fullSubName, subName, subValue, innerObj, i;

	        for (name in obj) {
	            value = obj[name];

	            if (value instanceof Array) {
	                for (i = 0; i < value.length; ++i) {
	                    subValue = value[i];
	                    fullSubName = name + '[' + i + ']';
	                    innerObj = {};
	                    innerObj[fullSubName] = subValue;
	                    query += param(innerObj) + '&';
	                }
	            }
	            else if (value instanceof Object) {
	                for (subName in value) {
	                    subValue = value[subName];
	                    fullSubName = name + '[' + subName + ']';
	                    innerObj = {};
	                    innerObj[fullSubName] = subValue;
	                    query += param(innerObj) + '&';
	                }
	            }
	            else if (value !== undefined && value !== null)
	                query += encodeURIComponent(name) + '=' + encodeURIComponent(value) + '&';
	        }

	        return query.length ? query.substr(0, query.length - 1) : query;
	    };

	    // Override $http service's default transformRequest
	    $httpProvider.defaults.transformRequest = [function (data) {
	        return angular.isObject(data) && String(data) !== '[object File]' ? param(data) : data;
	    } ];
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
		
		var postData= ({type:'text/plain'});
		//下面这一行会被当成参数附加到URL后面，所以post请求最终会变成/api/user?id=5  
		var config = {params: {id: '5'}};  
		$http.post(tableController_url, postData, config).success(function(data, status, headers, config) {  
			 $scope.cn_keys = data.key_cn; 
			 $scope.key_dataList = data.key_dataList; 
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
	
 	app.controller('query_order', ['$scope', '$http', function($scope, $http) {
		$scope.queryOrders = function(){
		    alert("query!"); 	
		}
	}]);
	
</script>
</body>
</html>