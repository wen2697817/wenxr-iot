<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<HTML >
	<HEAD>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<%@ include file="/commons/website.jsp" %>
	<link rel="stylesheet" type="text/css" href="<%=basePath %>css/index.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/reset.css" />
		<script type="text/javascript" src="<%=basePath %>js/index.js"></script>
		<base href="<%=basePath %>"/>
		<TITLE>功能菜单</TITLE>
	</HEAD>
	<script type="text/javascript">
	function user(){
		parent.window.frames['contentFrame'].location.href = basePath+"user/userList.jsp";
	}
	function equipment(){
		parent.window.frames['contentFrame'].location.href = basePath+"equipment/equipment.jsp";
	}
	function run(){
		parent.window.frames['contentFrame'].location.href = basePath+"run/run.jsp";
	}
	function history(){
		parent.window.frames['contentFrame'].location.href = basePath+"history/history.jsp";
	}
	function monitor(){
		parent.window.frames['contentFrame'].location.href = basePath+"monitor/monitor.jsp";
	}
	
	</script>
	<BODY >
	<div>
			<div class="left-menu">
				<ul>
					<li id="collect">
						<h4><span></span><i class="iconfont" >&#xe7ba;</i><a href="javascript:void(0)" onclick="monitor();">监控</a></h4>
					</li>
					<li id="collect2">
						<h4><span></span><i class="iconfont" >&#xe729;</i><a href="javascript:void(0)" onclick="run();">运行</a></h4>
					</li>
					<s:if test='#session.loginInfoBean.role.roleId=="1"'>
					<li id="collect3">
						<h4>
							<span></span><i class="iconfont">&#xe61e;</i><a
								href="javascript:void(0)" onclick="equipment();">设备管理</a>
						</h4>
					</li>
					<li id="collect4">
						<h4>
							<span></span><i class="iconfont">&#xe685;</i><a
								href="javascript:void(0)" onclick="history();">历史信息</a>
						</h4>
					</li>

					<li>
							<h4><span></span><i class="iconfont" >&#xe604;</i><a href="javascript:void(0)" onclick="user();">用户管理</a></h4>
						</li>
					</s:if>
					
				</ul>	
			</div>
		</div>
	
	</BODY>
</HTML>
