<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/commons/meta2.jsp" %>

<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>首页</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/login.css" />
<link rel="stylesheet" type="text/css"  href="<%=basePath %>css/reset.css" />
 <script type="text/javascript">
$(function() {
	$(window).keydown(function(event) {
				if (event.keyCode == 13) {
					loginFunc();
				}
			});
	
	if($("#msg").val()){
		alert($("#msg").val());
	}
});

function loginFunc() {
	if (!$("#userName").val()) {
		alert("请输入用户名");
		return;
	}
	if (!$("#pswd").val()) {
		alert("请输入密码");
		return;
	}
	mainForm.action= basePath + "login-Login-login.action";
	mainForm.submit();
};

</script>
 </head>
	<body>
	<input type="hidden" id="msg" value="<s:property value="msg"/>">
		<div class="login-bj">
		<div class="box">
			<div class="login">
				<h3>登录</h3>
				<form id="mainForm" name="mainForm" method="post">
					<input type="text" placeholder="请输入帐号" id="userName" name="userName" /><i class="iconfont">&#xe617;</i>
					<input type="password" placeholder="请输入密码" id="pswd" name="password" /><i class="iconfont">&#xe692;</i>
			   </form>
					<input type="button" id="submitBtn" class="ml20" onclick="loginFunc();" value="立即登录">
					
			</div>
			</div>
		</div>
	</body>
</html>