
// 翻页函数
function go(sign) {
	var curPage = document.getElementById("curPage");
	if (curPage.selectedIndex == -1) {
		return;
	}
	if (sign == 1) {// 后翻一页
		if (curPage.selectedIndex == curPage.options.length - 1)
			return;
		curPage.selectedIndex = curPage.selectedIndex + 1;
	} else if (sign == -1) {
		if (curPage.selectedIndex == 0)
			return;
		curPage.selectedIndex = curPage.selectedIndex - 1;
	} else if (sign == 0) {
	} else {
		return;
	}
	document.frmMain.submit();
}

/**
 * 格式化日期（不含时间）
 */
function formatterDate(date) {
	var datetime = date.getFullYear() + "-"// "年"
			+ ((date.getMonth() + 1) > 10 ? (date.getMonth() + 1) : "0" + (date.getMonth() + 1)) + "-"// "月"
			+ (date.getDate() < 10 ? "0" + date.getDate() : date.getDate());
	return datetime;
}
/**
 * 格式化日期（含时间"00:00:00"）
 */
function formatterDate2(date) {
	var datetime = date.getFullYear() + "-"// "年"
			+ ((date.getMonth() + 1) > 10 ? (date.getMonth() + 1) : "0" + (date.getMonth() + 1)) + "-"// "月"
			+ (date.getDate() < 10 ? "0" + date.getDate() : date.getDate()) + " " + "00:00:00";
	return datetime;
}
/**
 * 格式化去日期（含时间）
 */
function formatterDateTime(date) {
	var datetime = date.getFullYear()
			+ "-"// "年"
			+ ((date.getMonth() + 1) > 10 ? (date.getMonth() + 1) : "0" + (date.getMonth() + 1))
			+ "-"// "月"
			+ (date.getDate() < 10 ? "0" + date.getDate() : date.getDate()) + " " + (date.getHours() < 10 ? "0" + date.getHours() : date.getHours()) + ":"
			+ (date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes()) + ":" + (date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds());
	return datetime;
}

/**
 * 校验是否手机号
 * 
 * @param {}
 *            text
 * @return {Boolean}
 */
function isMobile(text) {
	var reMobile = /^0?(13|14|15|18|17)[0-9]{9}$/;
	if (reMobile.test(text)) {
		return true;
	} else {
		return false;
	}
}

/**
 * 校验是否电话号码
 * 
 * @param {}
 *            str
 */
function isPhone(str) {
	var re = /^0\d{2,3}-?\d{7,8}$/;
	if (re.test(str)) {
		return true;
	} else {
		return false;
	}
}

/**
 * 用途：检查输入字符串是否符合正整数格式 输入： s：字符串 返回： 如果通过验证返回true,否则返回false
 * 
 */
function isNumber(s) {
	var regu = "^[0-9]+$";
	var re = new RegExp(regu);
	if (s.search(re) != -1) {
		return true;
	} else {
		return false;
	}
}

/**
 * 用途：检查输入字符串是否是带小数的数字格式,可以是负数 输入： s：字符串 返回： 如果通过验证返回true,否则返回false
 * 
 */
function isDecimal(str) {
	if (isInteger(str))
		return true;
	var re = /^[-]{0,1}(\d+)[\.]+(\d+)$/;
	if (re.test(str)) {
		if (RegExp.$1 == 0 && RegExp.$2 == 0)
			return false;
		return true;
	} else {
		return false;
	}
}
/**
 * 用途：检查输入对象的值是否符合E-Mail格式 输入：str 输入的字符串 返回：如果通过验证返回true,否则返回false
 * 
 */
function isEmail(str) {
	var myReg = /^[-_A-Za-z0-9]+@([_A-Za-z0-9]+\.)+[A-Za-z0-9]{2,3}$/;
	if (myReg.test(str))
		return true;
	return false;
}

/**
 * 用途：检查输入字符串是否符合金额格式 格式定义为带小数的正数，小数点后最多三位 输入： s：字符串 返回： 如果通过验证返回true,否则返回false
 * 
 */
function isMoney(s) {
	var regu = "^[0-9]+[\.][0-9]{0,3}$";
	var re = new RegExp(regu);
	if (re.test(s)) {
		return true;
	} else {
		return false;
	}
}
/**
 * 用途：检查输入字符串是否只由英文字母和数字和下划线组成 输入： s：字符串 返回： 如果通过验证返回true,否则返回false
 * 
 */
function isNumberOr_Letter(s) {// 判断是否是数字或字母

	var regu = "^[0-9a-zA-Z\_]+$";
	var re = new RegExp(regu);
	if (re.test(s)) {
		return true;
	} else {
		return false;
	}
}
/**
 * 用途：检查输入字符串是否只由英文字母和数字组成 输入： s：字符串 返回： 如果通过验证返回true,否则返回false
 * 
 */
function isNumberOrLetter(s) {// 判断是否是数字或字母

	var regu = "^[0-9a-zA-Z]+$";
	var re = new RegExp(regu);
	if (re.test(s)) {
		return true;
	} else {
		return false;
	}
}
/**
 * 用途：检查输入字符串是否只由汉字、字母、数字组成 输入： value：字符串 返回： 如果通过验证返回true,否则返回false
 * 
 */
function isChinaOrNumbOrLett(s) {// 判断是否是汉字、字母、数字组成

	var regu = "^[0-9a-zA-Z\u4e00-\u9fa5]+$";
	var re = new RegExp(regu);
	if (re.test(s)) {
		return true;
	} else {
		return false;
	}
}

/**
 * 用途：判断是否是日期 输入：date：日期；fmt：日期格式 返回：如果通过验证返回true,否则返回false
 */
function isDate(date, fmt) {
	if (fmt == null)
		fmt = "yyyyMMdd";
	var yIndex = fmt.indexOf("yyyy");
	if (yIndex == -1)
		return false;
	var year = date.substring(yIndex, yIndex + 4);
	var mIndex = fmt.indexOf("MM");
	if (mIndex == -1)
		return false;
	var month = date.substring(mIndex, mIndex + 2);
	var dIndex = fmt.indexOf("dd");
	if (dIndex == -1)
		return false;
	var day = date.substring(dIndex, dIndex + 2);
	if (!isNumber(year) || year > "2100" || year < "1900")
		return false;
	if (!isNumber(month) || month > "12" || month < "01")
		return false;
	if (day > getMaxDay(year, month) || day < "01")
		return false;
	return true;
}
/**
 * 时间格式化
 * @param {} date
 * @param {} format
 * @return {}
 */
function dateFormat(date, format) {
	var o = {
		"M+" : date.getMonth() + 1, // month
		"d+" : date.getDate(), // day
		"h+" : date.getHours(), // hour
		"m+" : date.getMinutes(), // minute
		"s+" : date.getSeconds(), // second
		"q+" : Math.floor((date.getMonth() + 3) / 3), // quarter
		"S" : date.getMilliseconds()
		// millisecond
	}
	if (/(y+)/.test(format))
		format = format.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
	for (var k in o)
		if (new RegExp("(" + k + ")").test(format))
			format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
	return format;
}
function checkFileType(fileName, fileType) {
	if (typeof fileType == "string") {
		fileType = [fileType];
	}
	var extStart = fileName.lastIndexOf(".") + 1;
	var ext = fileName.substring(extStart).toUpperCase();
	for (var i = 0; i < fileType.length; i++) {
		if (fileType[i].toUpperCase() == ext) {
			return true;
		}
	}
	return false;
}

/**
 * 
 * @param {}
 *            id
 * @param {}
 *            msg
 * @param {}
 *            css 可选
 */
function showSuccess(id, msg, css) {
	var cs = "alert alert-success";
	if (css) {
		cs += " " + css;
	}
	_show(id, msg, cs);
}
/**
 * 
 * @param {}
 *            id
 * @param {}
 *            msg
 * @param {}
 *            css 可选
 */
function showInfo(id, msg, css) {
	var cs = "alert alert-info";
	if (css) {
		cs += " " + css;
	}
	_show(id, msg, cs);
}
/**
 * 
 * @param {}
 *            id
 * @param {}
 *            msg
 * @param {}
 *            css 可选
 */
function showWarning(id, msg, css) {
	var cs = "alert alert-warning";
	if (css) {
		cs += " " + css;
	}
	_show(id, msg, cs);
}
/**
 * 
 * @param {}
 *            id
 * @param {}
 *            msg
 * @param {}
 *            css 可选
 */
function showError(id, msg, css) {
	var cs = "alert alert-danger";
	if (css) {
		cs += " " + css;
	}
	_show(id, msg, cs);
}

/**
 * 
 * @param {}
 *            id
 * @param {}
 *            msg
 * @param {}
 *            css
 */
function _show(id, msg, css) {
	var sel = $("#" + id);
	sel.html(msg);
	if (css) {
		sel.addClass(css);
	}
	sel.show();

}

/**
 * 将长字符串转换为zoomSize+sign的方式，sign默认为...
 * 
 * @param {}
 *            text
 * @param {}
 *            zoomSize
 * @param {}
 *            sign
 */
function zoomText(text, zoomSize, sign) {
	if (!text || text.length <= zoomSize) {
		return textToHtml(text);
	}
	return textToHtml(text.substring(0, zoomSize) + (sign || "..."));
}

/**
 * 日期加减若干天后的返回值
 * 
 * @param {}
 *            date 日期，格式'2001-08-08'
 * @param {}
 *            days 要加减的天数，整型
 * @return {} 日期字符串，格式'2001-08-08'
 */
function addDate(date, days) {
	var d = new Date(date);
	d.setDate(d.getDate() + days);
	var m = d.getMonth() + 1;
	return d.getFullYear() + '-' + (m < 10 ? ("0" + m) : m) + '-' + (d.getDate() < 10 ? ("0" + d.getDate()) : d.getDate());
}
/**
 * 将文本中的HTML字符转义
 * 
 * @param {}
 *            sourcestr
 * @return {String}
 */
function textToHtml(sourcestr) {
	if (!sourcestr) {
		return "";
	}
	return sourcestr.replace(/</g, "&lt;").replace(/>/g, "&gt;").replace(/ /g, "&nbsp;").replace(/\r\n/g, "<br>").replace(/\r/g, "<br>").replace(/\n/g, "<br>");
}

var simpleOpenWin = null;
// 居中打开一个窗口
function openWinCenter(url, name, width, height) {
	if (simpleOpenWin != null && simpleOpenWin.open && !simpleOpenWin.closed) {
		simpleOpenWin.close();
		simpleOpenWin = null;
	}
	if (!width) {
		width = screen.availWidth;
	}
	if (!height) {
		height = screen.availHeight;
	}
	height = height - 60;
	width = width - 10;
	var str = "height=" + height;
	str += ",width=" + width;
	if (window.screen) {
		var ah = screen.availHeight - 60;
		var aw = screen.availWidth - 10;
		var xc = (aw - width) / 2;
		var yc = (ah - height) / 2;
		ah = ah < 0 ? 0 : ah;
		aw = aw < 0 ? 0 : aw;
		xc = xc < 0 ? 0 : xc;
		yc = yc < 0 ? 0 : yc;
		str += ",left=" + xc;
		str += ",top=" + yc;
		str += ",resizable=yes";
		str += ",status=yes";
		str += ",scrollbars=yes";
		str += ",location=no";
		str += ",titlebar=no";
	}
	simpleOpenWin = window.open(url, name, str);
	return simpleOpenWin;
}
