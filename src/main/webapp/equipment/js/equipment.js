var pageBarHtml = null, pager = null;
var num = 1;
var flag = {
	equipmentCode : false,
	user : false
};
$(function() {
	// 验证设备编号
	$("#equipmentCode").blur(checkEquipmentCode);
	// 验证用户
	$("#user").blur(checkUser);
	$("#button").click(function() {
		loadOrderFormData();
	});
	$.post(basePath + "user-User-loadAllUserNoPage.action", {}, function(data) {
		category = data.data;
		$.each(category,
				function() {
					$("#user").append(
							"<option value='" + this[0] + "'>" + this[1]
									+ "</option>");
				});
	});
	$('#myModal').on('hide.bs.modal', function() {// 在调用 hide 后隐藏前触发
		$("#addForm")[0].reset();
		$('#check_equipmentCode').html("");
		$('#check_equipmentName').html("");

	});
	$("#frmMain input[name='formType']").val(null);
	$("#frmMain input[name='formStatus']").val(null);
	$("#frmMain input[name='pageVo.start']").val("0");
	pageBarHtml = $("#pageBar").html();

	$(document).on("click", "#pageBar li:not(:first):not(:last) a", function() {
		var page = $(this).text();
		var start = (parseInt(page, 10) - 1) * pager.limit;
		num = start + 1;
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
		num = start + 1;
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
		num = start + 1;
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
	$.post(basePath + "equipment-Equipment-loadAllEquipment.action", $(
			"#frmMain").serialize(), function(data) {
		if (data.code != "200") {
			alert("登录超时，请重新登录！！");
			window.parent.parent.location.href = basePath;
			return;
		}
		$("#tbody0").children().remove();
		var list = data.data[0];
		if (list.length <= 0) {
			$("#tbody0").append("<p>无数据</p>");
		} else {
			if (!rePageBarFlag) {
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
// 拼接html
function appendRequire(form) {
	var userId = form[0];
	var html = "<tr><td>" + (num++) + "</td><td>" + form[2] + "</td>" + "<td>"
			+ form[3] + "</td><td>" + form[1] + "</td>";

	html = html
			+ "<td><a href='javascript:void(0);' onclick='update(\""
			+ form[0]
			+ "\");' title='编辑设备'><i class='iconfont edit'>&#xe605;</i></a>"
			+ "&nbsp;&nbsp;&nbsp;&nbsp;<a href='javascript:void(0);' onclick='deleteE(\""
			+ form[0]
			+ "\");' title='删除设备'><i class='iconfont edit'>&#xe60a;</i></a>"
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
// 进行分 ，循环输出页码。
var count = 4;
function rePageBar(page) {
	resetPageBar();
	var pageNum = Math.ceil(page.total / page.limit);
	pageNum = pageNum == 0 ? 1 : pageNum;
	var flag1 = false;
	for (var i = 1; i < pageNum; i++) {
		if (count < (i + 1) && (i + 1) < pageNum) {
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
	var nowPage = page;
	var pageNum = Math.ceil(pager.total / pager.limit);
	pageNum = pageNum == 0 ? 1 : pageNum;
	var leftCount = page - 1;// 左侧3
	var rightCount = pageNum - page;// 右侧5
	// 左侧的分页
	if (leftCount <= count) {// 左侧数量小于4最多显示页
		for (var i = 1; i <= leftCount; i++) {
			$('<li><a href="javascript:void(0);">' + (i + 1) + '</a></li>')
					.insertBefore("#pageBar li:last");
		}
	} else {// 大于一次最多显示页
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
// 验证用户名
var checkEquipmentCode = function() {
	var equipmentId = $("#equipmentId").val();
	var equipmentCode = $("#equipmentCode").val();
	if (equipmentCode) {
		$.ajax({
			type : "post",
			url : "equipment-Equipment-checkEquipmentCode.action",
			async : false,
			data : {
				equipmentId : equipmentId,
				equipmentCode : equipmentCode
			},
			dataType : "json",
			success : function(data) {
				if (data.msg == "0") {
					flag.equipmentCode = true;
					$('#check_equipmentCode').html('');
				} else {
					flag.equipmentCode = false;
					$('#check_equipmentCode').html('设备编号重复！');
				}
			}
		});

	} else {
		flag.equipmentCode = false;
		$('#check_equipmentCode').html('设备编号不能为空！');
	}
};
// 验证角色
var checkUser = function() {
	var user = $("#user").val();
	if (user) {
		flag.user = true;
		$('#check_user').html('');
	} else {
		flag.role = false;
		$('#check_user').html('请选择用户！');
	}
};
function toSave() {
	$("#equipmentId").val("");
	$("#myModalLabel").html("新增设备信息");
	$('#myModal').modal('toggle');
}
/**
 * 保存
 */
function save() {
	$("#submit").attr({
		"disabled" : "disabled"
	});
	checkEquipmentCode();
	checkUser();
	if (flag.equipmentCode && flag.user) {
		$.post(basePath + "equipment-Equipment-saveEquipment.action", $(
				"#addForm").serialize(), function(data) {
			$('#myModal').modal('toggle');
			$("#submit").removeAttr("disabled");// 将按钮可用
			alert("保存成功！");
			$("#frmMain").submit();
		});
	}
	$("#submit").removeAttr("disabled");// 将按钮可用
}
/**
 * 修改
 * 
 * @param equipment
 *            设备id
 */
function update(equipmentId) {
	$("#myModalLabel").html("修改设备信息");
	$.ajax({
		type : "post",
		url : "equipment-Equipment-selectEquipmentById.action",
		data : {
			equipmentId : equipmentId
		},
		dataType : "json",
		success : function(data) {
			data = data.data;
			$("#equipmentId").val(data.equipmentId);
			$("#equipmentCode").val(data.equipmentCode);
			$("#equipmentName").val(data.equipmentName);
			$("#user").val(data.user.userId);
			$("#orderNumber").val(data.orderNumber);
			$('#myModal').modal('toggle');
		}
	});
}
/**
 * 删除
 * 
 * @param userId
 */
function deleteE(equipmentId) {
	if (!confirm("你确定要删除该设备？")) {
		return false;
	}
	$.ajax({
		type : "post",
		url : "equipment-Equipment-deleteEquipment.action",
		data : {
			equipmentId : equipmentId
		},
		dataType : "json",
		success : function(data) {
			alert(data.msg);
			$("#frmMain").submit();
		}
	});
}