<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<% request.setAttribute("root", request.getContextPath());%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>街坊店宝</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
    <%@ include file="../common/head.jsp"%>
    <link rel="stylesheet" href="${root}/resources/css/login.css?v">
	<!--[if lt IE 8 ]>
		<script>alert("建议您升级浏览器或更换浏览器获得更好的体验！祝您生活愉快！");</script>
	<![endif]-->
</head>
<body>
<div class="contontbox">
	<div class="wrap login-info">
		<div class="login">
			<div class="loginbox">
				<h1>修改密码</h1>
				<div class="tip" style="display:none"></div>
				<form id="updatePwdform" >
				    <div class="text"><input type="text" class="form-control" id="mobile" value="${customer.mobile}" placeholder="帐号"></div>
					<div class="text"><input type="text" class="form-control" id="userName" name="userName" value="${customer.userName}" placeholder="用户名"></div>
					<div class="text"><input type="password" class="form-control" id="password" name="password" placeholder="密码"></div>
					<button type="button" class="login-btn" id="J_submitBtn">登　录</button>
				</form>
		     </div>
		</div>
	</div>
</div>
<script>
	$(function() {
		$('#J_submitBtn').on('click', function() {
			var username = $("#userName").val().trim();
			var password = $("#password").val().trim();
			if("" == username) {
				$('.tip').text("用户名不能为空");
		    	$('.tip').show();
		    	return false;
			} else if ("" == password) {
				$('.tip').text("密码不能为空");
		    	$('.tip').show();
		    	return false;
			} else {
				$.ajax({
					type: "POST",
					url: "${root}/analysis/authority/editKefuPassword.do",
					async: true,
					data: encodeURI($("#updatePwdform").serialize()),
					success: function(date) {
						if(date.success) {
							$('.tip').text("密码修改成功！");
					    	$('.tip').show();
						} else {
							$(".tip").text(date.message);
							$(".tip").show();
						}
					},
					error: function(date) {
					}
				});
			}
		});
		$("input").on("focus", function(e) {
			$(".tip").hide();
		});
		// 回车
		document.onkeydown = function(e) {
			var ev = document.all ? window.event : e;
		    if(ev.keyCode==13) {
		    	$("#J_submitBtn").click();
			}
		}
	});
</script>
</body>
</html>