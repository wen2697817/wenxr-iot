<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	    <%@ include file="/commons/meta2.jsp" %>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>登录</title>
        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="assets/css/form-elements.css">
        <link rel="stylesheet" href="assets/css/style.css">
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
	$
	.ajax({
		type : "post",
		async : false,
		url : basePath+"login-Login-checkLogin.action",
		data : {
			userName : $("#userName").val(),
			password:$("#pswd").val()
		},
		dataType : "json",
		success : function(data) {
			if(data.code!="200"){
				alert(data.msg);
				return;
			}else{
				mainForm.action= basePath + "login-Login-login.action";
				mainForm.submit();
			}
		}
	});
	
};

</script>
    </head>

    <body>
	<input type="hidden" id="msg" value="<s:property value="msg"/>">
        <!-- Top content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1><strong>科耀后台管理系统</strong></h1>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3>登录系统</h3>
                            		<p>请输入用户名和密码:</p>
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-key"></i>
                        		</div>
                            </div>
                            <div class="form-bottom">
			                    <form id="mainForm" name="mainForm" method="post">
			                    	<div class="form-group">
			                    		<label class="sr-only" for="form-username">Username</label>
			                        	<input type="text"  placeholder="请输入帐号" id="userName" name="userName" class="form-username form-control">
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">Password</label>
			                        	<input type="password" placeholder="请输入密码" id="pswd" name="password"  class="form-password form-control">
			                        </div>
			                        <button id="submitBtn" class="btn" onclick="loginFunc();">立即登录</button>
			                    </form>
		                    </div>
                        </div>
                    </div>
                    
                </div>
            </div>
            
        </div>


        <!-- Javascript -->
        <script src="assets/js/jquery-1.11.1.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.backstretch.min.js"></script>
        <script src="assets/js/scripts.js"></script>
        
        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

    </body>

</html>