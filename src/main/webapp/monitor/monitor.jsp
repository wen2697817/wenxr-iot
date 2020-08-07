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
<script type="text/javascript" src="<%=basePath%>monitor/js/monitor.js"></script>
<script type="text/javascript">
	var userName = "<s:property value="#session.loginInfoBean.userName"/>";
</script>
<style>
	#tb {table-layout:fixed;}
</style>
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
					<label>客户编号：</label> <input class="form-control" type="text"
						style="border-radius: 0px; width: 100px;" name="userCode"
						id="userCode"> <label>设备编号：</label> <input
						class="form-control" type="text"
						style="border-radius: 0px; width: 100px;" name="equipmentCode"
						id="equipmentCode"> <input type="button"
						class="btn btn-info" style="width: 80px; margin-left: 10px;"
						id="button" value="查询" />
				</div>
				<div style="overflow-x: scroll;" class="mt10 ml20">
					<table id="tb" style="word-break:break-all; word-wrap:break-all;">
						<thead>
							<tr>
								<th width="50px">序号</th>
								<th width="80px">客户编号</th>
								<th width="80px">设备编号</th>
								<th width="100px">封片数量</th>
								<th width="100px">缸位1</th>
								<th width="100px">缸位2</th>
								<th width="100px">缸位3</th>
								<th width="100px">缸位4</th>
								<th width="100px">缸位5</th>
								<th width="100px">缸位6</th>
								<th width="100px">缸位7</th>
								<th width="100px">缸位8</th>
								<th width="100px">缸位9</th>
								<th width="100px">缸位10</th>
								<th width="100px">缸位11</th>
								<th width="100px">缸位12</th>
								<th width="100px">缸位13</th>
								<th width="100px">缸位14</th>
								<th width="100px">缸位15</th>
								<th width="100px">缸位16</th>
								<th width="100px">缸位17</th>
								<th width="100px">缸位18</th>
								<th width="100px">缸位19</th>
								<th width="100px">缸位20</th>
								<th width="100px">缸位21</th>
								<th width="100px">缸位22</th>
								<th width="100px">缸位23</th>
								<th width="100px">缸位24</th>
								<th width="100px">缸位25</th>
								<th width="100px">缸位26</th>
								<th width="100px">缸位27</th>
								<th width="100px">缸位28</th>
								<th width="100px">缸位29</th>
								<th width="100px">缸位30</th>
								<th width="100px">缸位31</th>
								<th width="100px">缸位32</th>
							</tr>
						</thead>
						<tbody id="tbody0">
						</tbody>
					</table>
				</div>
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