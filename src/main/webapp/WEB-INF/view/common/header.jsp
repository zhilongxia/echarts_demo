<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<% request.setAttribute("root", request.getContextPath());%>
<header id="header">
    <img src="${root}/resources/images/logo-top.png" alt="">&nbsp;转角街坊
    <div class="info">
    	<span class="username">${logInVo.userName}</span>欢迎回来 
    	|<a class="ml-small" href="${root}/analysis/authority/doLoginOut.do">注销</a>
<%--     	|<a class="ml-small" href="${root}/analysis/authority/toEditPwdPage.do" target="mainiframe">修改密码</a> --%>
    </div>
</header>