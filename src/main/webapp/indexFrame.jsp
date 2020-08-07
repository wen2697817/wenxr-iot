<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>主页</title>
<%@ include file="/commons/website.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/index.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/reset.css" />
<script type="text/javascript" src="<%=basePath%>js/index.js"></script>
<script type="text/javascript" src="<%=basePath%>indexFrame.js"></script>
<s:if test="#session.loginInfoBean == null">
	<script type="text/javascript">
	var logout = "<s:property value="#request.logout"/>";
	if(logout){
	}else{
		alert("您还没有登录或登录超时！");
	}
		top.location = "<%=basePath%>";
	</script>
</s:if>
</head>
<body style="overflow-y: hidden">
<div style="width:100%;height:85px;position: fixed;padding: 0;margin: 0;" id="page_header">
	<iframe id="frame1" src="head.jsp" scrolling="no" height="85px" width="100%" frameborder="0"></iframe>
</div>
<div id="center" style="position: absolute;width: 100%;top: 85px;bottom: 0px;" id="page_content">
	<iframe src="mainFrame.jsp" scrolling="no" height="100%" width="100%" frameborder="0"></iframe>
</div>
<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true"
		data-backdrop="static">
		<div id="modalH" class="modal-dialog" style="width: 450px;height: 450px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel"
						style="font-weight: bold;">修改密码</h4>
				</div>
				<div class="modal-body">
					<form id="updateForm">
						<input type="hidden" id="userId" name="user.userId">
						<div class="user-form">
							<label>原密码：</label> <input type="password" id="password"
								name="password" maxlength="25">&nbsp;&nbsp;<span
								style="color: red;">*</span>
							<div id="check_password"
								style="color: red; width: 200px; height: 30px; margin-left: 100px; margin-top: -30px; position: relative;"></div>
							<label>新密码：</label> <input type="password" id="password1" name="password1"
								maxlength="25">&nbsp;&nbsp;<span style="color: red;">*</span>
							<div id="check_password1"
								style="color: red; width: 200px; height: 30px; margin-left: 100px; margin-top: -30px; position: relative;"></div>
							<label>确认新密码：</label> <input type="password" id="password2"
								name="password2" maxlength="25">&nbsp;&nbsp;<span
								style="color: red;">*</span>
							<div id="check_password2"
								style="color: red; width: 200px; height: 30px; margin-left: 100px; margin-top: -30px; position: relative;"></div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<input type="button" id="submit" class="btn btn-info"
						onclick="save();" style="width:100px;margin-right: 160px;" value="提交">
				</div>
			</div>
		</div>
	</div>
</body>
</html>