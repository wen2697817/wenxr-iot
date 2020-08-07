var flag = {
	password : false,
	password1 : false,
	password2 : false
};
$(function() {
	// 验证原用户名
	$("#password").blur(checkPassword);
	// 验证新密码
	$("#password1").blur(checkPassword1);
	// 验证确认新密码
	$("#password2").blur(checkPassword2);
});
//验证原密码
var checkPassword = function() {
	var password = $("#password").val();
	if (password) {
		$.ajax({
			type:"post",
			url:"user-User-checkPassword.action",
			data:{
				password:password
			},
			dataType : "json",
			success : function(data) {
				if(data.code=="200"){
					flag.password = true;
					$('#check_password').html('');
				}else{
					flag.password = false;
					$('#check_password').html(data.msg);
				}
			}
		});
		
	} else {
		flag.password = false;
		$('#check_password').html('原密码不能为空！');
	}
};
//验证新密码
var checkPassword1 = function() {
	var password = $("#password").val();
	var password1 = $("#password1").val();
	var password2 = $("#password2").val();
	if (password1) {
		if(password==password1){
			flag.password1 = false;
			$('#check_password1').html('新密码与原密码相同！');
		}else{
			if(password2){
				if(password2==password1){
					flag.password1 = true;
					$('#check_password1').html('');
				}else{
					flag.password1 = false;
					$('#check_password1').html('密码输入不一致');
				}
			}
			
		}
	}else{
		flag.password1 = false;
		$('#check_password1').html('新密码不能为空！');
	}
}
//验证确认新密码
var checkPassword2 = function() {
	var password1 = $("#password1").val();
	var password2 = $("#password2").val();
	if (password2) {
		if(password1){
			if(password1==password2){
				flag.password2 = true;
				$('#check_password2').html('');
			}else{
				flag.password2 = false;
				$('#check_password2').html('确认密码输入不一致');
			}
		}
	}else{
		flag.password2 = false;
		$('#check_password2').html('新密码不能为空！');
	}
}
function toupdate() {
	
	$('#myModal').modal({
		backdrop : 'static'
	});
	var h = ($('#center').height() + 85 - $('#modalH').height()) / 2;
	$('#myModal').css({
		top : h
	});
}
function save() {
	checkPassword();
	checkPassword1();
	checkPassword2();
	if(flag.password&&flag.password1&&flag.password2){
		var password1 = $("#password1").val();
		$.ajax({
			type:"post",
			url:"user-User-updatePsw.action",
			data:{
				password1:password1
			},
			dataType : "json",
			success : function(data) {
				if(data.code=="200"){
					$('#myModal').modal('toggle');
					alert("密码修改成功！");
					top.location = "login-Login-logout.action";
				}
			}
		});
		
	}
	
}