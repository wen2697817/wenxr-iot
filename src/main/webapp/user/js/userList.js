var pageBarHtml = null, pager = null;
var num = 1;
var flag = {
	userName : false,
	name : false,
	role : false
};
$(function() {
	// 验证用户名
	$("#userName").blur(checkUserName);
	// 验证姓名
	$("#name").blur(checkName);
	// 验证角色
	$("#role").blur(checkRole);
	$("#button").click(function() {
		loadOrderFormData();
	});
	var roleId = $("#roleId").val();
	$.post(basePath + "user-User-loadAllRole.action", {}, function(data) {
		category = data.data;
		$.each(category, function() {
			if (roleId == this.roleId) {
				$("#role").append(
						"<option selected = 'selected' value='" + this.roleId
								+ "'>" + this.name + "</option>");
			} else {
				$("#role").append(
						"<option value='" + this.roleId + "'>" + this.name
								+ "</option>");
			}
		});
	});
	$('#myModal').on('hide.bs.modal', function() {// 在调用 hide 后隐藏前触发
		$("#addForm")[0].reset();
		$('#check_userUserName').html("");
		$('#check_userName').html("");
		$('#check_userRole').html("");
	});
	$("#frmMain input[name='formType']").val(null);
	$("#frmMain input[name='formStatus']").val(null);
	$("#frmMain input[name='pageVo.start']").val("0");
	pageBarHtml = $("#pageBar").html();

	$(document).on("click", "#pageBar li:not(:first):not(:last) a", function() {
		var page = $(this).text();
		var start = (parseInt(page, 10) - 1) * pager.limit;
		num = start+1;
		if (start != $("#frmMain input[name='pageVo.start']").val()) {
			$("#frmMain input[name='pageVo.start']").val(start);
			$("#pageBar li:not(:first):not(:last)").removeClass();
			$(this).parent().addClass("active");
			loadOrderFormData(true);
			rePageBars(page, pager);
		}
	});

	$(document).on("click", "#pageBar li:first a", function() {

		if ($("#pageBar li:not(:first):not(:last)").size() <= 0) {
			return;
		}
		var curActive = $("#pageBar li:not(:first):not(:last).active a");
		var page = curActive.text();
		page = parseInt(page, 10);
		if (page == 1) {
			return;
		}
		page--;
		var start = (page - 1) * pager.limit;
		num = start+1;
		if (start != $("#frmMain input[name='pageVo.start']").val()) {
			$("#frmMain input[name='pageVo.start']").val(start);
			$("#pageBar li:not(:first):not(:last)").removeClass();
			$(curActive).parent().prev().addClass("active");
			loadOrderFormData(true);
			rePageBars(page, pager);
		}
	});

	$(document).on("click", "#pageBar li:last a", function() {

		if ($("#pageBar li:not(:first):not(:last)").size() <= 0) {
			return;
		}
		var curActive = $("#pageBar li:not(:first):not(:last).active a");
		var page = curActive.text();
		page = parseInt(page, 10);

		if (page == $("#pageBar li:not(:first):not(:last)").size()) {
			return;
		}
		page++;
		var start = (page - 1) * pager.limit;
		num = start+1;
		if (start != $("#frmMain input[name='pageVo.start']").val()) {
			$("#frmMain input[name='pageVo.start']").val(start);
			$("#pageBar li:not(:first):not(:last)").removeClass();
			$(curActive).parent().next().addClass("active");
			loadOrderFormData(true);
			rePageBars(page, pager);
		}
	});
	loadOrderFormData();
});
function loadOrderFormData(rePageBarFlag) {
	$('#loading').show();
	if (!rePageBarFlag) {
		$("#frmMain input[name='pageVo.start']").val("0");
	}
	$.post(basePath + "user-User-loadAllUser.action", $("#frmMain")
			.serialize(), function(data) {
		if (data.code != "200") {
			alert("登录超时，请重新登录！！");
			window.parent.parent.location.href=basePath;
			return;
		}
		$("#tbody0").children().remove();
		var list = data.data[0];
		if (list.length <= 0) {
			$("#tbody0").append("<p>无数据</p>");
		} else {
			if(!rePageBarFlag){
				num = 1;
			}

			$.each(list, function(i) {

				appendRequire(this);

			});
		}
		if (!rePageBarFlag) {

			pager = data.data[1];
			rePageBar(pager);
		}
		$('#loading').hide();
	});
	
}
//拼接html
function appendRequire(form) {
	var userId = form[0];
	var html = "<tr><td>" + (num++) + "</td><td>" + form[1] + "</td>"
			+ "<td>"+ form[2] + "</td><td>" + form[3] + "</td>"
			+ "<td>" + form[4] + "</td>";

	html = html
				+ "<td><a href='javascript:void(0);' onclick='update(\""
				+ form[0]
				+ "\");' title='编辑用户'><i class='iconfont edit'>&#xe605;</i></a>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;<a href='javascript:void(0);' onclick='resetPsw(\""
				+ form[0]
				+ "\");' title='密码重置'><i class='iconfont edit'>&#xe607;</i></a>"
				+ "</td></tr>";
	$("#tbody0").append(html);

	oTable = document.getElementById("tab");// 找表格
	aTr = document.getElementsByTagName("tr");// 找所有的行
	for (var i = 0; i < aTr.length; i++) {
		if (i % 2 == 0) {
			aTr[i].style.background = "#fff";
		} else {
			aTr[i].style.background = "#EEEEEE";
		}
	}
}
//进行分 ，循环输出页码。
var count = 4;
function rePageBar(page) {
	resetPageBar();
	var pageNum = Math.ceil(page.total / page.limit);
	pageNum = pageNum == 0 ? 1 : pageNum;
	var flag1 = false;
	for (var i = 1; i < pageNum; i++) {
		if (count <(i + 1) && (i + 1) < pageNum) {
			if (!flag1) {
				$('<li><a href="javascript:void(0);" class="slh">...</a></li>')
						.insertBefore("#pageBar li:last");
				flag1 = true;
			}
		} else {
			$('<li><a href="javascript:void(0);">' + (i + 1) + '</a></li>')
					.insertBefore("#pageBar li:last");
		}
	}

}
function rePageBars(page, pager) {
	resetPageBar();
	var nowPage=page;
	var pageNum = Math.ceil(pager.total / pager.limit);
	pageNum = pageNum == 0 ? 1 : pageNum;
	var leftCount = page - 1;// 左侧3
	var rightCount = pageNum - page;// 右侧5
	//左侧的分页
	if (leftCount <= count) {//左侧数量小于4最多显示页
		for (var i = 1; i <= leftCount; i++) {
			$('<li><a href="javascript:void(0);">' + (i + 1) + '</a></li>')
					.insertBefore("#pageBar li:last");
		}
	} else {//大于一次最多显示页
		var flag1 = false;
		var d = page - count;// 2个需要转为...
		nowPage = 5;
		for (var i = 1; i <= leftCount; i++) {
			if (i <= d) {
				if (!flag1) {
					$(
							'<li><a href="javascript:void(0);" class="slh">...</a></li>')
							.insertBefore("#pageBar li:last");
					flag1 = true;
				}
			} else {
				$('<li><a href="javascript:void(0);">' + (i + 1) + '</a></li>')
						.insertBefore("#pageBar li:last");
			}
		}
	}
	if (rightCount <= count) {
		for (var i = page; i < pageNum; i++) {
			$(
					'<li><a href="javascript:void(0);">' + (Number(i) + 1)
							+ '</a></li>').insertBefore("#pageBar li:last");
		}
	} else {
		var flag1 = false;
		var d = rightCount - count + 1;// 2
		for (var i = page; i < pageNum; i++) {
			if ((Number(i) + 1) >= (Number(pageNum) - Number(d))
					&& i < Number(pageNum) - 1) {
				if (!flag1) {
					$(
							'<li><a href="javascript:void(0);" class="slh">...</a></li>')
							.insertBefore("#pageBar li:last");
					flag1 = true;
				}
			} else {
				$(
						'<li><a href="javascript:void(0);">' + (Number(i) + 1)
								+ '</a></li>').insertBefore("#pageBar li:last");
			}
		}

	}
	$("#pageBar li:not(:first):not(:last)").removeClass();
	// alert(page);
	$("#pageBar li:eq(" + nowPage + ")").addClass("active");
}
function resetPageBar() {
	$("#pageBar").html(pageBarHtml);
}
function resetPsw(userId) {
	if (!confirm("你确定要重置用户密码吗？")) {
		return false;
	}
	$.ajax({
		type : "post",
		url : "user-User-resetPsw.action",
		data : {
			userId : userId
		},
		dataType : "json",
		success : function(data) {
			alert(data.msg);
			$("#frmMain").submit();
		}
	});
}
// 验证用户名
var checkUserName = function() {
	var userName = $("#userName").val();
	var userId = $("#userId").val();
	if (userName) {
		$.ajax({
			type:"post",
			url:"user-User-checkUserName.action",
			async:false, 
			data:{
				userId:userId,
				userName:userName
			},
			dataType : "json",
			success : function(data) {
				if(data.msg=="0"){
					flag.userName = true;
					$('#check_userUserName').html('');
				}else{
					flag.userName = false;
					$('#check_userUserName').html('用户名重复！');
				}
			}
		});
		
	} else {
		flag.userName = false;
		$('#check_userUserName').html('用户名不能为空！');
	}
};
// 验证姓名
var checkName = function() {
	var name = $("#name").val();
	if (name) {
		flag.name = true;
		$('#check_userName').html('');
	} else {
		flag.name = false;
		$('#check_userName').html('客户名称不能为空！');
	}
};
// 验证角色
var checkRole = function() {
	var role = $("#role").val();
	if (role) {
		flag.role = true;
		$('#check_userRole').html('');
	} else {
		flag.role = false;
		$('#check_userRole').html('请选择角色！');
	}
};
function toSave(){
	$("#userId").val("");
	$("#myModalLabel").html("新增用户信息");
	$('#myModal').modal('toggle');
}
/**
 * 保存
 */
function save() {
	$("#submit").attr({"disabled":"disabled"});
	checkUserName();
	checkName();
	checkRole();
	if (flag.userName && flag.name && flag.role) {
		$.post(basePath + "user-User-saveUser.action", $("#addForm")
				.serialize(), function(data) {
			$('#myModal').modal('toggle');
			$("#submit").removeAttr("disabled");//将按钮可用
			alert("保存成功！");
			$("#frmMain").submit();
		});
	}
	$("#submit").removeAttr("disabled");//将按钮可用
}
/**
 * 修改
 * @param userId 用户id
 */
function update(userId){
	$("#myModalLabel").html("修改用户信息");
	$.ajax({
		type : "post",
		url : "user-User-selectUserByUserId.action",
		data : {
			userId : userId
		},
		dataType : "json",
		success : function(data) {
			data = data.data;
			$("#userId").val(data.userId);
			$("#password").val(data.password);
			$("#userName").val(data.userName);
			$("#name").val(data.name);
			$("#role").val(data.role.roleId);
			$("#status").val(data.status);
			$('#myModal').modal('toggle');
		}
	});
}
/**
 * 删除
 * @param userId
 */
function deleteUser(userId){
	if (!confirm("你确定要删除该用户？")) {
		return false;
	}
	$.ajax({
		type : "post",
		url : "user-User-deleteUser.action",
		data : {
			userId : userId
		},
		dataType : "json",
		success : function(data) {
			alert(data.msg);
			$("#frmMain").submit();
		}
	});
}