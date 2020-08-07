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
<script type="text/javascript" src="<%=basePath%>run/js/run.js"></script>
<script type="text/javascript">
	var userName = "<s:property value="#session.loginInfoBean.userName"/>";
</script>

</head>
<body>
	<div class="personnel">
		<div class="content">
			<div class="title-bj"></div>
			<h2 class="mb50">运行数据</h2>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<form id="frmMain" name="frmMain" action="" method="post">
			<input type="hidden" name="pageVo.start" value="0">
			<div class="form-inline">
				<label>客户编号：</label> <input
						class="form-control" type="text"
						style="border-radius: 0px; width: 100px;" name="userCode"
						id="userCode">
				<label>设备编号：</label> <input
						class="form-control" type="text"
						style="border-radius: 0px; width: 100px;" name="equipmentCode"
						id="equipmentCode">
				<label>架子id：</label> <input
				class="form-control" type="text"
				style="border-radius: 0px; width: 200px;" name="shelfId"
				id="shelfId">
				<label>程序名称：</label> <input
				class="form-control" type="text"
				style="border-radius: 0px; width: 200px;" name="programName"
				id="programName">
				<input type="button" class="btn btn-info"
						style="width: 80px; margin-left: 10px;" id="button" value="查询" />
			</div>
				<table class="mt10 ml20">
					<thead>
						<tr>
							<th>序号</th>
							<th>客户编号</th>
							<th>设备编号</th>
							<th>架子id</th>
							<th>程序名称</th>
							<th>站点位置</th>
							<th>步骤时间</th>
							<th>总时间</th>
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

		</div>
	</div>
</body>
</html>