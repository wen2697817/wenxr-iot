package com.wenxr.iot.util;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * 描述：
 * <p>
 * &nbsp;&nbsp;&nbsp;&nbsp;日历tool
 * </p>
 * 创建日期 2016-5-24
 * 
 * @author wxr
 * @version 1.0
 * 
 */
public class SitDateTime implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3952295904837624831L;
	/** 程序逻辑错误(7113)-非法的日 **/
	public static final int leInvalidDay = 7113;
	/** 程序逻辑错误(7112)-非法的月份 **/
	public static final int leInvalidMonth = 7112;
	/** 程序逻辑错误(7114)-每周的第一天不是星期一 **/
	public static final int leMondayNotFirstDayOfWeek = 7114;
	/** 程序逻辑错误(7115)-日期小于系统允许的最小日期 **/
	public static final int leLessThanMinimumDate = 7115;
	/** 程序逻辑错误(7116)-日期大于系统允许的最大日期 **/
	public static final int leMoreThanMaximumDate = 7116;
	/** 程序逻辑错误(7115)-时间小于系统允许的最小时间 **/
	public static final int leLessThanMinimumTime = 7117;
	/** 程序逻辑错误(7116)-时间大于系统允许的最大时间 **/
	public static final int leMoreThanMaximumTime = 7118;
	/** 最大日期 **/
	public static final int maxDate = 29991231;
	/** 最小日期 **/
	public static final int minDate = 18991231;
	/** 空日期(使用最小日期)-字符串型 **/
	public static final String strDateNull = "18991231";
	/** SQL空日期(使用最小日期, 已有单引号)-字符串型 **/
	public static final String strSqlDateNull = "'18991231'";
	/** 月份-1月份 **/
	public static final int monthJanuary = 1;
	/** 月份-2月份 **/
	public static final int monthFebruary = 2;
	/** 月份-3月份 **/
	public static final int monthMarch = 3;
	/** 月份-4月份 **/
	public static final int monthApril = 4;
	/** 月份-5月份 **/
	public static final int monthMay = 5;
	/** 月份-6月份 **/
	public static final int monthJune = 6;
	/** 月份-7月份 **/
	public static final int monthJuly = 7;
	/** 月份-8月份 **/
	public static final int monthAugust = 8;
	/** 月份-9月份 **/
	public static final int monthSeptember = 9;
	/** 月份-10月份 **/
	public static final int monthOctober = 10;
	/** 月份-11月份 **/
	public static final int monthNovember = 11;
	/** 月份-12月份 **/
	public static final int monthDecember = 12;
	/** 周-星期日 **/
	public static final char weekSunday = '7';
	/** 周-星期一 **/
	public static final char weekMonday = '1';
	/** 周-星期二 **/
	public static final char weekTuesday = '2';
	/** 周-星期三 **/
	public static final char weekWednesday = '3';
	/** 周-星期四 **/
	public static final char weekThursday = '4';
	/** 周-星期五 **/
	public static final char weekFriday = '5';
	/** 周-星期六 **/
	public static final char weekSaturday = '6';
	/** 周-每周的第一天是星期一 **/
	public static final char weekFirstDayOfWeek = '1';
	/** 最大时间 **/
	public static final int maxTime = 235959;
	/** 最小时间 **/
	public static final int minTime = 0;
	/** 空时间(使用最小时间)-字符串型 **/
	public static final String strTimeNull = "0";
	/** SQL空时间(使用最小时间, 已有单引号)-字符串型 **/
	public static final String strSqlTimeNull = "'0'";
	private int nDate;
	private int nTime;
	private Calendar calendar = Calendar.getInstance();

	/**
	 * 日期时间构造函数 使用日期整数构造日期 注意: 该日期整数必须与通过UtDate.getDate() 方式得到的日期格式相同
	 * 
	 * @param 整数日期
	 * @param 整数时间
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public SitDateTime(int iDate, int iTime) {
		calendar.setFirstDayOfWeek(2);
		nDate = iDate;
		nTime = iTime;
		validDate(nDate);
		validTime(iTime);
		setCalendarProperty(calendar, nDate, nTime);
	}

	/**
	 * 日期时间构造函数 使用日期整数构造日期 注意: 该日期整数必须与通过UtDate.getDate() 方式得到的日期格式相同
	 * 
	 * @param 整数日期
	 * @param
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public SitDateTime(int iDate) {
		calendar.setFirstDayOfWeek(2);
		nDate = iDate;
		nTime = 0;
		validDate(nDate);
		validTime(0);
		setCalendarProperty(calendar, nDate, nTime);
	}

	/**
	 * 日期时间构造函数 使用年、月、日、时、分、秒构造日期时间
	 * 
	 * @param 年
	 * @param 月
	 * @param 日
	 * @param 时
	 * @param 分
	 * @param 秒
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public SitDateTime(int year, int month, int day, int hour, int minute,
			int second) {
		calendar.clear();
		calendar.setFirstDayOfWeek(2);
		calendar.set(year, month - 1, day, hour, minute, second);
		setIntegerProperty();
		validDate(nDate);
		validTime(nTime);
	}

	/**
	 * 日期时间构造函数 使用年、月、日、时、分、秒构造日期时间
	 * 
	 * @param 年
	 * @param 月
	 * @param 日
	 * @param 时
	 * @param 分
	 * @param 秒
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public SitDateTime(int year, int month, int day) {
		calendar.clear();
		calendar.setFirstDayOfWeek(2);
		calendar.set(year, month - 1, day);
		setIntegerProperty();
		validDate(nDate);
		validTime(nTime);
	}

	/**
	 * 日期时间构造函数 使用时间戳构造日期
	 * 
	 * @param 时间戳
	 * @return 返回值说明
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public SitDateTime(long l) {
		Date date = new Date(l);
		calendar.setFirstDayOfWeek(2);
		calendar.setTime(date);
		setIntegerProperty();
		validDate(nDate);
		validTime(nTime);
	}

	/**
	 * 日期时间构造函数 使用字符串对象构造日期 此构造函数可以处理两种类型的日期字符串 日期型字符串, 格式是"YYYYMMDD","HHMMSS"
	 * 其中YYYY-年(4位); MM-月(取值1至12, 不足两位时左补0); DD-日(不足两位时, 左补0) HH-时 MM-分 SS-秒
	 * 
	 * @param 日期
	 * @param 时间
	 * @return 返回值说明
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public SitDateTime(String sDate, String sTime) {
		if (sDate.indexOf("/") != -1) {
			sDate = Tools.replaceAll(sDate, "/", "");
		}
		;
		calendar.setFirstDayOfWeek(2);
		if (sDate.length() == 17) {
			nDate = Integer.parseInt(sDate.substring(0, 8));
		} else {
			nDate = Integer.parseInt(sDate);
		}
		if (sTime.length() == 17) {
			nTime = Integer.parseInt(sTime.substring(0, 6));
		} else {
			nTime = Integer.parseInt(sTime);
		}
		validDate(nDate);
		validTime(nTime);
		setCalendarProperty(calendar, nDate, nTime);
	}

	/**
	 * 日期时间构造函数 使用字符串对象构造日期 此构造函数可以处理两种类型的日期字符串 日期型字符串, 格式是"YYYYMMDD","HHMMSS"
	 * 其中YYYY-年(4位); MM-月(取值1至12, 不足两位时左补0); DD-日(不足两位时, 左补0)
	 * 
	 * @param 日期
	 * @param
	 * @return 返回值说明
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public SitDateTime(String sDate) {
		// "2004-01-05"
		if (sDate.indexOf("-") != -1) {
			sDate = Tools.replaceAll(sDate, "-", "");
		}

		calendar.setFirstDayOfWeek(2);
		if (sDate.length() == 17) {
			nDate = Integer.parseInt(sDate.substring(0, 8));
		} else {
			nDate = Integer.parseInt(sDate);
		}

		nTime = 0;

		validDate(nDate);
		validTime(nTime);
		setCalendarProperty(calendar, nDate, nTime);
	}

	/**
	 * 日期时间构造函数 使用java.util.Calendar对象构造日期时间 注意: 如果提供的日期为空(null), 则取当前系统时间
	 * 
	 * @param 日历类
	 * @return 返回值说明
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public SitDateTime(Calendar calendar) {
		if (calendar != null)
			this.calendar = calendar;
		setIntegerProperty();
	}

	/**
	 * 日期时间构造函数
	 * 
	 * 取当前系统时间
	 * 
	 * @see 参考类#类方法或类属性
	 */
	public SitDateTime() {
		setIntegerProperty();
	}

	/**
	 * 在当前日期的基础上加指定天数 注意, 此方法改变了对象的当前日期
	 * 
	 * @param 天数
	 * @return 改变后的日期
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public int addDay(int i) {
		calendar.add(5, i);
		setIntegerProperty();
		return nDate;
	}

	/**
	 * 在当前日期的基础上加指定半年数 注意, 此方法改变了对象的当前日期
	 * 
	 * @param 半年数
	 * @return 改变后的日期
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public int addHalfYear(int i) {
		calendar.add(2, i * 6);
		setIntegerProperty();
		return nDate;
	}

	/**
	 * 在当前日期的基础上加指定月数 注意, 此方法改变了对象的当前日期
	 * 
	 * @param 月数
	 * @return 改变后的日期
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public int addMonth(int i) {
		calendar.add(2, i);
		setIntegerProperty();
		return nDate;
	}

	/**
	 * 在当前日期的基础上加指定季数 注意, 此方法改变了对象的当前日期
	 * 
	 * @param 季数
	 * @return 改变后的日期
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public int addQuarter(int i) {
		calendar.add(2, i * 3);
		setIntegerProperty();
		return nDate;
	}

	/**
	 * 在当前日期的基础上加指定旬数 注意, 此方法改变了对象的当前日期
	 * 
	 * @param 旬数
	 * @return 改变后的日期
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public int addTenDay(int i) {
		calendar.add(2, i / 3);
		i %= 3;
		// System.out.println("addTenDay() amount=" + i);
		if (i > 0) {
			if (nDate + i * 10 > getEndOfMonth()) {
				calendar.add(2, 1);
				calendar.add(5, (i - 3) * 10);
			} else
				calendar.add(5, i * 10);
		} else if (i < 0) {
			if (getDay() + i * 10 <= 0) {
				calendar.add(2, -1);
				calendar.add(5, (3 - i) * 10);
			} else
				calendar.add(5, i * 10);
		}
		setIntegerProperty();
		return nDate;
	}

	/**
	 * 在当前日期的基础上加指定周数 注意, 此方法改变了对象的当前日期
	 * 
	 * @param 周数
	 * @return 改变后的日期
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public int addWeek(int i) {
		calendar.add(5, i * 7);
		setIntegerProperty();
		return nDate;
	}

	/**
	 * 在当前日期的基础上加指定年数 注意, 此方法改变了对象的当前日期
	 * 
	 * @param 年数
	 * @return 改变后的日期
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public int addYear(int i) {
		calendar.add(1, i);
		setIntegerProperty();
		return nDate;
	}

	/**
	 * 比较两个日期, 返回两个日期之间的天数
	 * 
	 * @param 数值型日期
	 * @return 两日期之间的天数
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public int compareTo(int iDate) {
		long l = this.calendar.getTime().getTime();
		Calendar calendar = Calendar.getInstance();
		setCalendarProperty(calendar, iDate);
		long l_12_ = calendar.getTime().getTime();
		return (int) ((l - l_12_) / 86400000L);
	}

	/**
	 * 比较两个日期, 返回两个日期之间的天数
	 * 
	 * @param 日期之间的天数
	 * @return 要比较的日期
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public int compareTo(SitDateTime utdate_13_) {
		long l = this.calendar.getTime().getTime();
		Calendar calendar = Calendar.getInstance();
		setCalendarProperty(calendar, utdate_13_.getDate());
		long l_14_ = calendar.getTime().getTime();
		return (int) ((l - l_14_) / 86400000L);
	}

	/**
	 * 生成日期时间型字符串 使用当前对象的日期与给定时间戳的时间 (忽略时间戳的日期)拼出新的日期时间型字符串
	 * 生成的日期时间型字符串格式为"YYYYMMDDhhmmssiii", 其中: YYYY - 年 MM - 月 DD - 日 hh - 时 mm -
	 * 分 ss - 秒 iii - 毫秒
	 * 
	 * @param 时间戳
	 * @return 格式为"YYYYMMDDhhmmssiii"的日期时间型字符串
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public String createDatetime(long l) {
		DecimalFormat decimalformat = new DecimalFormat("000");
		DecimalFormat decimalformat_15_ = new DecimalFormat("00");
		Date date = new Date(l);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return ("" + getDate()
				+ decimalformat_15_.format((long) calendar.get(11))
				+ decimalformat_15_.format((long) calendar.get(12))
				+ decimalformat_15_.format((long) calendar.get(13)) + decimalformat
				.format((long) calendar.get(14)));
	}

	/**
	 * 取整数型日期 注意: 整数型日期可以直接用于比较两个日期的大小, 但不能通过直接相减整数型日期计算两个日期的间隔天数
	 * 
	 * @return 日期
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public int getDate() {
		return nDate;
	}

	/**
	 * 取日
	 * 
	 * @return 日
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public int getDay() {
		return nDate - nDate / 100 * 100;
	}

	/**
	 * 取日，不足2位补0
	 * 
	 * @return
	 */
	public String getDayStr() {
		int d = getDay();
		return d < 10 ? ("0" + d) : ("" + d);
	}

	/**
	 * 取当 前日期是星期几
	 * 
	 * @param
	 * @return 星期几
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public int getDayOfWeek() {
		int i = calendar.get(7);
		switch (i) {
		case 1:
			return 7;
		case 2:
			return 1;
		case 3:
			return 2;
		case 4:
			return 3;
		case 5:
			return 4;
		case 6:
			return 5;
		default:
			return 6;
		}
	}

	public String getWeekString() {

		int i = calendar.get(7);
		switch (i) {
		case 1:
			return "星期天";
		case 2:
			return "星期一";
		case 3:
			return "星期二";
		case 4:
			return "星期三";
		case 5:
			return "星期四";
		case 6:
			return "星期五";
		default:
			return "星期六";
		}
		// return weekString;
	}

	/**
	 * 取当前日期所在半年的最后一天的日期
	 * 
	 * @param
	 * @return 日期
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public int getEndOfHalfYear() {
		if (getMonth() <= 6)
			return getYear() * 10000 + 630;
		return getYear() * 10000 + 1231;
	}

	/**
	 * 取当前日期所在月份的最后一天的日期
	 * 
	 * @param
	 * @return 日期
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public int getEndOfMonth() {
		int i = getYear();
		int i_11_ = getMonth();
		switch (i_11_) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return i * 10000 + i_11_ * 100 + 31;
		case 2:
			if (isLeapYear(i))
				return i * 10000 + i_11_ * 100 + 29;
			return i * 10000 + i_11_ * 100 + 28;
		case 4:
		case 6:
		case 9:
		case 11:
			return i * 10000 + i_11_ * 100 + 30;
		default:
			throw new IllegalStateException("错误的月份：" + i_11_);
		}
	}

	/**
	 * 取当前日期所在季度的最后一天的日
	 * 
	 * @param
	 * @return 日期
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public int getEndOfQuarter() {
		if (getMonth() <= 3)
			return getYear() * 10000 + 331;
		if (getMonth() <= 6)
			return getYear() * 10000 + 630;
		if (getMonth() <= 9)
			return getYear() * 10000 + 930;
		return getYear() * 10000 + 1231;
	}

	/**
	 * 取当前日期所在旬的最后一天的日期
	 * 
	 * @param
	 * @return 参数说明
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public int getEndOfTenDays() {
		if (getDay() <= 10)
			return getYear() * 10000 + getMonth() * 100 + 10;
		if (getDay() <= 20)
			return getYear() * 10000 + getMonth() * 100 + 20;
		return getEndOfMonth();
	}

	/**
	 * 取当前日期所在周的最后一天(周日)的日期
	 * 
	 * @param
	 * @return 日期
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public int getEndOfWeek() {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.setFirstDayOfWeek(2);
		calendar.set(getYear(), getMonth() - 1, getDay());
		switch (calendar.get(7)) {
		case 2:
			calendar.add(5, 6);
			break;
		case 3:
			calendar.add(5, 5);
			break;
		case 4:
			calendar.add(5, 4);
			break;
		case 5:
			calendar.add(5, 3);
			break;
		case 6:
			calendar.add(5, 2);
			break;
		case 7:
			calendar.add(5, 1);
			break;
		}
		return (calendar.get(1) * 10000 + (calendar.get(2) + 1) * 100 + calendar
				.get(5));
	}

	/**
	 * 取当前日期所在年的最后一天的日期
	 * 
	 * @param
	 * @return 日期
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public int getEndOfYear() {
		return getYear() * 10000 + 1231;
	}

	/**
	 * 取月
	 * 
	 * @param
	 * @return 月
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public int getMonth() {
		return (nDate - nDate / 10000 * 10000) / 100;
	}

	/**
	 * 取月，不足2位补零
	 * 
	 * @return
	 */
	public String getMonthStr() {
		int m = getMonth();
		return m < 10 ? ("0" + m) : (m + "");
	}

	/**
	 * 取分钟
	 * 
	 * @param 参数说明
	 * @return 返回值说明
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public int getMinute() {
		return (nTime - nTime / 10000 * 10000) / 100;
	}

	/**
	 * 取秒
	 * 
	 * @param 参数说明
	 * @return 返回值说明
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public int getSecond() {
		return nTime - nTime / 100 * 100;
	}

	/**
	 * 取年
	 * 
	 * @param 参数说明
	 * @return 返回值说明
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public int getYear() {
		return nDate / 10000;
	}

	/**
	 * 取小时
	 * 
	 * @param 参数说明
	 * @return 返回值说明
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public int getHour() {
		return nTime / 10000;
	}

	/**
	 * 检查当前日期的年份是否是闰年
	 * 
	 * @param 参数说明
	 * @return 返回值说明
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public boolean isLeapYear() {
		return isLeapYear(getYear());
	}

	/**
	 * 检查所给的年份是否是闰年
	 * 
	 * @param 参数说明
	 * @return 返回值说明
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public static boolean isLeapYear(int i) {
		if (i / 4 * 4 != i)
			return false;
		if (i / 100 * 100 != i)
			return true;
		if (i / 400 * 400 != i)
			return false;
		return true;
	}

	/**
	 * 把当前日期改到所在半年的最后一天的日期
	 * 
	 * @param 参数说明
	 * @return 返回值说明
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public void movetoEndOfHalfYear() {
		nDate = getEndOfHalfYear();
		setCalendarProperty(calendar, nDate);
	}

	/**
	 * 把当前日期改到所在月份的最后一天的日期
	 * 
	 * @param 参数说明
	 * @return 返回值说明
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public void movetoEndOfMonth() {
		nDate = getEndOfMonth();
		setCalendarProperty(calendar, nDate);
	}

	/**
	 * 把当前日期改到所在季度的最后一天的日期
	 * 
	 * @param 参数说明
	 * @return 返回值说明
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public void movetoEndOfQuarter() {
		nDate = getEndOfQuarter();
		setCalendarProperty(calendar, nDate);
	}

	/**
	 * 把当前日期改到所在旬的最后一天的日期
	 * 
	 * @param 参数说明
	 * @return 返回值说明
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public void movetoEndOfTenDays() {
		nDate = getEndOfTenDays();
		setCalendarProperty(calendar, nDate);
	}

	/**
	 * 把当前日期改到所在周的最后一天(周日)的日期
	 * 
	 * @param 参数说明
	 * @return 返回值说明
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public void movetoEndOfWeek() {
		nDate = getEndOfWeek();
		setCalendarProperty(calendar, nDate);
	}

	/**
	 * 把当前日期改到所在年的最后一天的日期
	 * 
	 * @param 参数说明
	 * @return 返回值说明
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public void movetoEndOfYear() {
		nDate = getEndOfYear();
		setCalendarProperty(calendar, nDate);
	}

	/**
	 * 
	 * 
	 * @param 参数说明
	 * @return 返回值说明
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	private void setCalendarProperty(Calendar calendar, int iDate, int iTime) {
		int year = iDate / 10000;
		int month = (iDate - year * 10000) / 100;
		int day = iDate - year * 10000 - month * 100;

		int hour = iTime / 10000;
		int minute = (iTime - hour * 10000) / 100;
		int second = iTime - hour * 10000 - minute * 100;

		calendar.clear();
		calendar.setFirstDayOfWeek(2);
		calendar.set(year, month - 1, day, hour, minute, second);
	}

	/**
	 * 
	 * 
	 * @param 参数说明
	 * @return 返回值说明
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	private void setCalendarProperty(Calendar calendar, int iDate) {
		setCalendarProperty(calendar, iDate, 0);
	}

	/**
	 * 日期设置函数 使用日期整数设置日期
	 * 
	 * @param 参数说明
	 * @return 返回值说明
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public void setDate(int i) {
		nDate = i;
		validDate(nDate);
		setCalendarProperty(calendar, nDate);
	}

	/**
	 * 日期设置函数 使用年、月、日设置日期
	 * 
	 * @param 参数说明
	 * @return 返回值说明
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public void setDate(int i, int i_5_, int i_6_) {
		calendar.clear();
		calendar.setFirstDayOfWeek(2);
		calendar.set(i, i_5_ - 1, i_6_);
		setIntegerProperty();
		validDate(nDate);
	}

	/**
	 * 日期设置函数 使用字符串对象设置日期 字符串内的日期格式必须是 YYYYMMDD 格式, 说明如下 YYYY 四位数字, 表示年 MM 两位数字,
	 * 表示月, 不足两位时, 左补0 DD 两位数字, 表示日, 不足两位时, 左补0
	 * 
	 * @param 参数说明
	 * @return 返回值说明
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public void setDate(String string) {
		nDate = Integer.parseInt(string);
		validDate(nDate);
		setCalendarProperty(calendar, nDate);
	}

	/**
	 * 日期设置函数 使用java.util.Date对象设置日期
	 * 
	 * @param 参数说明
	 * @return 返回值说明
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public void setDate(Date date) {
		calendar.clear();
		calendar.setTime(date);
		setIntegerProperty();
		validDate(nDate);
	}

	/**
	 * 
	 * 
	 * @param 参数说明
	 * @return 返回值说明
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	private void setIntegerProperty() {
		nDate = (calendar.get(1) * 10000 + (calendar.get(2) + 1) * 100 + calendar
				.get(5));
		nTime = (calendar.get(11) * 10000 + calendar.get(12) * 100 + calendar
				.get(13));
	}

	/**
	 * 获取当前日期的毫秒数
	 * 
	 * @return
	 */
	public long getTimeInMillis() {
		return calendar.getTimeInMillis();
	}

	/**
	 * 返回两个日期的天数差额
	 * 
	 * @param s2
	 * @return
	 */
	public int getDaySub(SitDateTime s2) {
		return this.getDay() - s2.getDay();
	}

	/**
	 * 返回两个日期的小时数差额
	 * 
	 * @param s2
	 * @return
	 */
	public int getHourSub(SitDateTime s2) {
		return this.getHour() - s2.getHour();
	}

	/**
	 * 返回两个日期的分钟数差额
	 * 
	 * @param s2
	 * @return
	 */
	public int getMinuteSub(SitDateTime s2) {
		return this.getMinute() - s2.getMinute();
	}

	/**
	 * 取符合SQL日期格式的字符串型日期 取到的SQL格式日期, 仅可用于数据库操作的SQL语句中, 不要用于其它用途;
	 * 此方法返回的字符串已经用单引号括起
	 * 
	 * @param 参数说明
	 * @return 返回值说明
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public String sqlDateFormat() {
		return "'" + nDate + "'";
	}

	/**
	 * 转换成字符串, 格式是"9999年99月99日"
	 * 
	 * @param 参数说明
	 * @return 返回值说明
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public String toString() {
		StringBuffer stringbuffer = new StringBuffer(11);
		stringbuffer.append(getYear());
		stringbuffer.append("年");
		if (getMonth() < 10)
			stringbuffer.append(' ');
		stringbuffer.append(getMonth());
		stringbuffer.append("月");
		if (getDay() < 10)
			stringbuffer.append(' ');
		stringbuffer.append(getDay());
		stringbuffer.append("日");
		return stringbuffer.toString();
	}

	/**
	 *检查所给日期是否是有效的日期
	 * 
	 * @param 参数说明
	 * @return 返回值说明
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public static void validDate(int i) {
		if (i > 29991231) {
			IllegalArgumentException illegalargumentexception = (new IllegalArgumentException(
					"日期大于系统允许的最大日期！系统允许的最大日期是: 29991231, 用户提供的日期是: " + i));
			throw illegalargumentexception;
		}
		if (i < 18991231) {
			IllegalArgumentException illegalargumentexception = (new IllegalArgumentException(
					"日期小于系统允许的最小日期！系统允许的最小日期是: 18991231, 用户提供的日期是: " + i));
			throw illegalargumentexception;
		}
		int i_7_ = i / 10000;
		int i_8_ = (i - i_7_ * 10000) / 100;
		if (i_8_ > 12) {
			IllegalArgumentException illegalargumentexception = (new IllegalArgumentException(
					"非法的月份！用户提供的日期是:" + i + ", 月份值是: " + i_8_));
			throw illegalargumentexception;
		}
		int i_9_ = i - i_7_ * 10000 - i_8_ * 100;
		int i_10_;
		switch (i_8_) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			i_10_ = 31;
			break;
		case 2:
			if (isLeapYear(i_7_))
				i_10_ = 29;
			else
				i_10_ = 28;
			break;
		default:
			i_10_ = 30;
		}
		if (i_9_ > i_10_) {
			IllegalArgumentException illegalargumentexception = (new IllegalArgumentException(
					"非法的日！用户提供的日期是:" + i + ", 日是: " + i_9_));
			throw illegalargumentexception;
		}
	}

	/**
	 *检查所给时间是否是有效的时间
	 * 
	 * @param 参数说明
	 * @return 返回值说明
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public static void validTime(int i) {
		if (i > maxTime) {
			IllegalArgumentException illegalargumentexception = (new IllegalArgumentException(
					"时间大于系统允许的最大时间！系统允许的最大时间是: " + maxTime + ", 用户提供的时间是: " + i));
			throw illegalargumentexception;
		}
		if (i < minTime) {
			IllegalArgumentException illegalargumentexception = (new IllegalArgumentException(
					"时间小于系统允许的最小时间！系统允许的最小时间是: " + minTime + ", 用户提供的时间是: " + i));
			throw illegalargumentexception;
		}
	}

	/**
	 * 取得时间
	 * 
	 * @param 参数说明
	 * @return 返回值说明
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public int getTime() {
		return nTime;
	}

	/**
	 * 设置时间
	 * 
	 * @param 参数说明
	 * @return 返回值说明
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public void setTime(int i) {
		nTime = i;
		validTime(nTime);
	}

	/**
	 * 设置时间
	 * 
	 * @param 参数说明
	 * @return 返回值说明
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public void setTime(String string) {
		nTime = Integer.parseInt(string);
		validTime(nTime);
	}

	/**
	 * 设置时间
	 * 
	 * @param 参数说明
	 * @return 返回值说明
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public void setTime(Date time) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		nTime = (calendar.get(11) * 10000 + calendar.get(12) * 100 + calendar
				.get(13));
		validTime(nTime);
	}

	/**
	 * 取符合SQL时间格式的字符串型时间 取到的SQL格式时间, 仅可用于数据库操作的SQL语句中, 不要用于其它用途;
	 * 此方法返回的字符串已经用单引号括起
	 * 
	 * @param 参数说明
	 * @return 返回值说明
	 * @throws SitException
	 *             是系统异常的根类
	 * @see 参考类#类方法或类属性
	 */
	public String sqlTimeFormat() {
		return "'" + String.valueOf(nTime) + "'";
	}

	/**
	 * 取得时分秒的组合，例如：02:12:08
	 * 
	 * @return
	 */
	public String getTimeString() {
		String timeString = "";
		int hour = this.getHour();// 取得小时
		int minute = this.getMinute();// 取得分钟
		int second = this.getSecond();// 取得秒
		if (hour > 9) {
			timeString += hour + ":";
		} else {
			timeString += "0" + hour + ":";
		}

		if (minute > 9) {
			timeString += minute + ":";
		} else {
			timeString += "0" + minute + ":";
		}

		if (second > 9) {
			timeString += second;
		} else {
			timeString += "0" + second;
		}
		return timeString;
	}

	/**
	 * 取得两时间的差
	 * 
	 * @param cTime
	 * @return
	 */
	public int getTimeConverSion(int cTime) {
		int hour = this.getHour();// 取得小时
		int minute = this.getMinute();// 取得分钟
		int second = this.getSecond();// 取得秒

		SitDateTime sdate = new SitDateTime(this.calendar);
		sdate.setTime(cTime);

		hour = hour - sdate.getHour();
		minute = minute - sdate.getMinute();
		second = second - sdate.getSecond();

		int t = Math.abs(hour) * 60 + Math.abs(minute) * 1;

		return t;
	}

	/**
	 * 取得两时间的差
	 * 
	 * @param cTime
	 * @return
	 */
	public int getTimeConverSion(String cTime) {
		int hour = this.getHour();// 取得小时
		int minute = this.getMinute();// 取得分钟
		int second = this.getSecond();// 取得秒

		SitDateTime sdate = new SitDateTime(this.calendar);
		sdate.setTime(cTime);

		hour = hour - sdate.getHour();
		minute = minute - sdate.getMinute();
		second = second - sdate.getSecond();

		int t = Math.abs(hour) * 60 + Math.abs(minute) * 1;

		return t;
	}
}
