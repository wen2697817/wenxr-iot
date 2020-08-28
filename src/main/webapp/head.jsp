<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<%@ include file="/commons/meta.jsp"%>
		<%@ page import="java.util.*"%> 
		<%@ page import="java.text.*"%> 
			<base href="<%=basePath %>"/>
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/index.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/reset.css" />
		<title>head</title>
	
	<script type="text/javascript">
		function user(){
			parent.window.frames['mainFrame'].location.href = basePath+"user-User-loadAllUser.action";
		}
		function keyaoProjectList(){
			parent.window.frames['mainFrame'].location.href = basePath+"keyaoProject/keyaoProjectList.jsp";
		}
		function statistics(){
			parent.window.frames['mainFrame'].location.href = basePath+"statistics/statisticsList.jsp";
		}
		function toupdate(){
			parent.window.toupdate();
		}
	</script>
	</head>
	<body>
	<div class="header">
		<div class="logo fl">察微后台管理系统</div>
		
		<div class="top-nav fr">
				<ul>
					<li class="u">欢迎您！ </li>
					<li class="u1"><s:property value="#session.loginInfoBean.name"/></li>					
					<li class="upassword"><a href="javascript:void(0);" onclick="toupdate();"><i class="iconfont sign">&#xe600;</i>修改密码</a></li>
					<li class="u"><a id="zhux" href="<%=basePath %>login-Login-logout.action"><i class="iconfont sign">&#xe603;</i>注销</a></li>
				</ul>
				<div class="time">
				  	<div id="time">
						<script>
							document.getElementById('time').innerHTML=new Date().toLocaleString()+' 周'+'日一二三四五六'.charAt(new Date().getDay());
							setInterval("document.getElementById('time').innerHTML=new Date().toLocaleString()+' 周'+'日一二三四五六'.charAt(new Date().getDay());",1000);
						</script>
					</div>
				</div>
				
			</div>
		</div>
	</body>
</html>
