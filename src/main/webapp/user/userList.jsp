<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>用户</title>
<%@ include file="/commons/website.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/index.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/reset.css" />
<script type="text/javascript" src="<%=basePath%>js/index.js"></script>
<script type="text/javascript" src="<%=basePath%>user/js/userList.js"></script>
<script type="text/javascript">
	var userName = "<s:property value="#session.loginInfoBean.userName"/>";
</script>

</head>
<body>
	<div class="personnel">
		<div class="content">
			<div class="title-bj"></div>
			<h2 class="mb50">用户管理</h2>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<form id="frmMain" name="frmMain" action="" method="post">
			<input type="hidden" name="pageVo.start" value="0">
			<div class="form-inline">
				<label>用户名：</label> <input
						class="form-control" type="text"
						style="border-radius: 0px; width: 100px;" name="userName1"
						id="userName1">
				<label>客户名称：</label> <input
				class="form-control" type="text"
				style="border-radius: 0px; width: 200px;" name="name1"
				id="name1">
				<input type="button" class="btn btn-info"
						style="width: 80px; margin-left: 10px;" id="button" value="查询" />
				<button type="button" class="btn btn-info"
				style="width: 100px; margin-left: 20px;" onclick="toSave();">增加用户</button>
			</div>
				<table class="mt10 ml20">
					<thead>
						<tr>
							<th>序号</th>
							<th>用户名</th>
							<th>客户名称</th>
							<th>角色</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody id="tbody0">
						</tbody>
				</table>
				<div class="page" style="margin-right: 5px;">
					<ul class="pagination pull-right" id="pageBar">
						<li><a href="javascript:void(0); ">&laquo;</a></li>
						<li class="active"><a href="javascript:void(0);">1</a></li>
						<li><a href="javascript:void(0);">&raquo;</a></li>
					</ul>
				</div>
			</form>
			<!-- 模态框（Modal） -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true"
				data-backdrop="static">
				<div class="modal-dialog" style="width: 450px;">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel"
								style="font-weight: bold;">新增用户</h4>
						</div>
						<div class="modal-body">
							<form id="addForm" name="addForm" method="post"
								action="<%=basePath%>user-User-saveUser.action">
								<input type="hidden" id="userId" name="user.userId">
								<input type="hidden" id="password" name="user.password">
								<div class="user-form">
									<label>用户名：</label> <input type="text" id="userName"
										name="user.userName" maxlength="25">&nbsp;&nbsp;<span
										style="color: red;">*</span>
									<div id="check_userUserName"
										style="color: red; width: 200px; height: 30px; margin-left: 100px; margin-top: -30px; position: relative;"></div>
									<label>客户名称：</label> <input type="text" id="name"
										name="user.name" maxlength="25">&nbsp;&nbsp;<span
										style="color: red;">*</span>
									<div id="check_userName"
										style="color: red; width: 200px; height: 30px; margin-left: 100px; margin-top: -30px; position: relative;"></div>
									<label>角色：</label> <select id="role" name="user.role.roleId"
										style="width: 180px; height: 32px; line-height: 32px; margin-bottom: 25px;">
										<option value="">请选择</option>
									</select>&nbsp;&nbsp;<span style="color: red;">*</span>
									<div id="check_userRole"
										style="color: red; width: 200px; height: 30px; margin-left: 100px; margin-top: -28px; position: relative;"></div>
									<label>状态：</label> <select id="status" name="user.status"
										style="width: 180px; height: 32px; line-height: 32px; margin-bottom: 25px;">
										<option value="启用" selected="selected">启用</option>
										<option value="禁用">禁用</option>
									</select>&nbsp;&nbsp;<span style="color: red;">*</span><br>

								</div>
							</form>
						</div>
						<div class="modal-footer">
							<input type="button" id="submit" name="tijiao" class="btn btn-info"
								onclick="save();" style="margin-right: 160px;" value="保存">
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>