var pageBarHtml = null, pager = null;
var num = 1;
$(function() {
	$("#button").click(function() {
		loadOrderFormData();
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
	$.post(basePath + "monitor-Monitor-loadAllMonitor.action", $("#frmMain")
			.serialize(), function(data) {
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
	var html = "<tr><td width='50px'>" + (num++) + "</td><td width='80px'>"
			+ form[0] + "</td>" + "<td width='80px'>" + form[1] + "</td>"
			+ "<td width='100px'>" + form[2] + "</td><td width='100px'>"
			+ (form[3] == null ? '' : form[3]) + "</td><td width='100px'>"
			+ (form[4] == null ? '' : form[4]) + "</td><td width='100px'>"
			+ (form[5] == null ? '' : form[5]) + "</td><td width='100px'>"
			+ (form[6] == null ? '' : form[6]) + "</td><td width='100px'>"
			+ (form[7] == null ? '' : form[7]) + "</td><td width='100px'>"
			+ (form[8] == null ? '' : form[8]) + "</td><td width='100px'>"
			+ (form[9] == null ? '' : form[9]) + "</td><td width='100px'>"
			+ (form[10] == null ? '' : form[10]) + "</td><td width='100px'>"
			+ (form[11] == null ? '' : form[11]) + "</td><td width='100px'>"
			+ (form[12] == null ? '' : form[12]) + "</td><td width='100px'>"
			+ (form[13] == null ? '' : form[13]) + "</td><td width='100px'>"
			+ (form[14] == null ? '' : form[14]) + "</td><td width='100px'>"
			+ (form[15] == null ? '' : form[15]) + "</td><td width='100px'>"
			+ (form[16] == null ? '' : form[16]) + "</td><td width='100px'>"
			+ (form[17] == null ? '' : form[17]) + "</td><td width='100px'>"
			+ (form[18] == null ? '' : form[18]) + "</td><td width='100px'>"
			+ (form[19] == null ? '' : form[19]) + "</td><td width='100px'>"
			+ (form[20] == null ? '' : form[20]) + "</td><td width='100px'>"
			+ (form[21] == null ? '' : form[21]) + "</td><td width='100px'>"
			+ (form[22] == null ? '' : form[22]) + "</td><td width='100px'>"
			+ (form[23] == null ? '' : form[23]) + "</td><td width='100px'>"
			+ (form[24] == null ? '' : form[24]) + "</td><td width='100px'>"
			+ (form[25] == null ? '' : form[25]) + "</td><td width='100px'>"
			+ (form[26] == null ? '' : form[26]) + "</td><td width='100px'>"
			+ (form[27] == null ? '' : form[27]) + "</td><td width='100px'>"
			+ (form[28] == null ? '' : form[28]) + "</td><td width='100px'>"
			+ (form[29] == null ? '' : form[29]) + "</td><td width='100px'>"
			+ (form[30] == null ? '' : form[30]) + "</td><td width='100px'>"
			+ (form[31] == null ? '' : form[31]) + "</td><td width='100px'>"
			+ (form[32] == null ? '' : form[32]) + "</td><td width='100px'>"
			+ (form[33] == null ? '' : form[33]) + "</td><td width='100px'>"
			+ (form[34] == null ? '' : form[34]) + "</td></tr>";
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