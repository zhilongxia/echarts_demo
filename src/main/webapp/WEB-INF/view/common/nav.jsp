<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% request.setAttribute("root", request.getContextPath()); %>
<nav id="nav">
    <a href="${root}/toMainPage.do" target="mainiframe"><h1></h1></a>
    <ul>
       <%--  <li>
            <div class="category active"><a href="${root}/scms/orderctl/test.do" target="mainiframe"><i class="icon icon-home"></i>我的工作台</a></div>
        </li>
        <li>
            <div class="category" data-direction="down"><i class="icon icon-order"></i>供货单管理<i class="icon-direction"></i></div>
            <div class="subcategory">
                <a href="${root}/scms/orderctl/GetSpOrderInfos.do?status=2" target="mainiframe">转角订单</a>
                <a href="${root}/scms/orderctl/listPage.do?staging=0" target="mainiframe">线下订单</a>
            </div>
        </li>
        <li>
            <div class="category" data-direction="down"><i class="icon icon-goods"></i>商品库管理<i class="icon-direction"></i></div>
            <div class="subcategory">
                <a href="${root}/scms/plantItem/toProductIndex.do" target="mainiframe">商品管理</a>
                <a href="${root}/scms/plantItem/plantItemPage.do" target="mainiframe">商品库存</a>
            </div>
        </li>
        <li>
            <div class="category"><a href="${root}/scms/store/scmshome.do" target="mainiframe"><i class="icon icon-custom"></i>客户管理</a></div>
        </li>
        <li>
            <div class="category"><a href="${root}/scms/sp/toSpWalletIndex.do" target="mainiframe"><i class="icon icon-wallet"></i>我的钱包</a></div>
        </li>
         
         
        <li>
            <div class="category"><a href="${root}/analysis/report/toReportPage.do" target="mainiframe"><i class="icon icon-wallet"></i>合作商数据分析</a></div>
        </li>
        --%>
        <li>
            <div class="category"><a href="${root}/analysis/statis/toStatisPage.do" target="mainiframe"><i class="icon icon-wallet"></i>全局统计</a></div>
        </li>
        <li>
            <div class="category"><a href="${root}/analysis/product/toProductPage.do" target="mainiframe"><i class="icon icon-wallet"></i>商品数据分析</a></div>
        </li>
        <li>
            <div class="category"><a href="${root}/analysis/shop/toShopPage.do" target="mainiframe"><i class="icon icon-wallet"></i>商铺数据分析</a></div>
        </li>
        <li>
            <div class="category"><a href="${root}/analysis/supplier/toSupplierPage.do" target="mainiframe"><i class="icon icon-wallet"></i>合作商数据分析</a></div>
        </li>
        
        <li>
            <div class="category"><a href="${root}/analysis/order/toOrderPage.do" target="mainiframe"><i class="icon icon-wallet"></i>订单数据分析</a></div>
        </li>
        <c:if test="${logInVo.userName eq 'admin' or logInVo.userName eq 'qingqing' or logInVo.userName eq 'huawuque' or logInVo.userName eq 'jiangxiaoyu'}">
	        <li>
	            <div class="category"><a href="${root}/analysis/store/toStorePage.do" target="mainiframe"><i class="icon icon-wallet"></i>店铺信息查询</a></div>
	        </li>
	        <li>
	            <div class="category"><a href="${root}/analysis/orderList/toOrderListPage.do" target="mainiframe"><i class="icon icon-wallet"></i>订单明细查询</a></div>
	        </li>
        </c:if>
    </ul>
</nav>