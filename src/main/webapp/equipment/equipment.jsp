<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>设备</title>
<%@ include file="/commons/website.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/index.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/reset.css" />
<script type="text/javascript" src="<%=basePath%>js/index.js"></script>
<script type="text/javascript" src="<%=basePath%>equipment/js/equipment.js"></script>
<script type="text/javascript">
	var userName = "<s:property value="#session.loginInfoBean.userName"/>";
</script>

</head>
<body>
	<div class="personnel">
		<div class="content">
			<div class="title-bj"></div>
			<h2 class="mb50">设备管理</h2>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<form id="frmMain" name="frmMain" action="" method="post">
			<input type="hidden" name="pageVo.start" value="0">
			<div class="form-inline">
				<label>设备编号：</label> <input
						class="form-control" type="text"
						style="border-radius: 0px; width: 100px;" name="equipmentCode1"
						id="equipmentCode1">
				<label>设备名称：</label> <input
				class="form-control" type="text"
				style="border-radius: 0px; width: 200px;" name="equipmentName1"
				id="equipmentName1">
				<input type="button" class="btn btn-info"
						style="width: 80px; margin-left: 10px;" id="button" value="查询" />
				<button type="button" class="btn btn-info"
				style="width: 100px; margin-left: 20px;" onclick="toSave();">增加用户</button>
			</div>
				<table class="mt10 ml20">
					<thead>
						<tr>
							<th>序号</th>
							<th>设备编号</th>
							<th>设备名称</th>
							<th>所属用户</th>
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
								style="font-weight: bold;">新增设备</h4>
						</div>
						<div class="modal-body">
							<form id="addForm" name="addForm" method="post"
								action="<%=basePath%>equipment-Equipment-saveEquipment.action">
								<input type="hidden" id="equipmentId" name="equipment.equipmentId">
								<div class="user-form">
									<label>设备编号：</label> <input type="text" id="equipmentCode"
										name="equipment.equipmentCode" maxlength="25">&nbsp;&nbsp;<span
										style="color: red;">*</span>
									<div id="check_equipmentCode"
										style="color: red; width: 200px; height: 30px; margin-left: 100px; margin-top: -30px; position: relative;"></div>
									<label>设备名称：</label> <input type="text" id="equipmentName"
										name="equipment.equipmentName" maxlength="25">
									<div></div>
									<label>所属用户：</label> <select id="user" name="equipment.user.userId"
										style="width: 180px; height: 32px; line-height: 32px; margin-bottom: 25px;">
										<option value="">请选择</option>
									</select>&nbsp;&nbsp;<span style="color: red;">*</span>	
									<div id="check_user"
										style="color: red; width: 200px; height: 30px; margin-left: 100px; margin-top: -30px; position: relative;"></div>								
									<label>显示顺序：</label> <input type="text" id="orderNumber"
										name="equipment.orderNumber" maxlength="5"><br>

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