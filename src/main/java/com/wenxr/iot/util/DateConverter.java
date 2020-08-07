package com.wenxr.iot.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

/**
 * 描述：
 * 
 * <p>
 * &nbsp;&nbsp;&nbsp;&nbsp;struts的全局日期转换器
 * </p>
 * 
 * 创建日期 2016-5-24
 * 
 * @author wxr
 * @version 1.0
 * 
 */
public class DateConverter extends StrutsTypeConverter {
	private static String DATE_TIME_FOMART = "yyyy-MM-dd HH:mm:ss";
	private static String DATE_FOMART = "yyyy-MM-dd";
	private static String TIME_FOMART = "HH:mm:ss";

	@SuppressWarnings("rawtypes")
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		Date date = null;
		if (arg1.length > 0) {
			String dateStr = arg1[0];
			dateStr = dateStr.replace("/", "-");
			try {
				if ((dateStr != null) && (dateStr.length() == 10)) {
					SimpleDateFormat sdf = new SimpleDateFormat(DATE_FOMART);
					date = sdf.parse(dateStr);
				} else if ((dateStr != null) && (dateStr.length() == 8)) {
					SimpleDateFormat sdf = new SimpleDateFormat(TIME_FOMART);
					Date tempDate = sdf.parse(dateStr);
					Calendar tempCal = Calendar.getInstance();
					tempCal.setTime(tempDate);
					Calendar calNow = Calendar.getInstance();
					tempCal.set(1, calNow.get(1));
					tempCal.set(2, calNow.get(2));
					tempCal.set(5, calNow.get(5));
					date = tempCal.getTime();
				} else if (dateStr != null) {
					SimpleDateFormat sdf = new SimpleDateFormat(
							DATE_TIME_FOMART);
					date = sdf.parse(dateStr);
				}
			} catch (ParseException localParseException) {
			}
		}
		return date == null ? null : new Timestamp(date.getTime());
	}

	@SuppressWarnings("rawtypes")
	public String convertToString(Map arg0, Object arg1) {
		Date date = (Date) arg1;
		String dStr = date.toString();
		String dateStr = null;
		if ((dStr != null) && (dStr.length() == 10)) {
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FOMART);
			dateStr = sdf.format(date);
		} else if ((dStr != null) && (dStr.length() == 8)) {
			SimpleDateFormat sdf = new SimpleDateFormat(TIME_FOMART);
			dateStr = sdf.format(date);
		} else if (dStr != null) {

			SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FOMART);
			dateStr = sdf.format(date);
		}
		return Tools.convertNull(dateStr);
	}

	public String convertToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FOMART);
		String dateStr = sdf.format(date);
		return dateStr;
	}
}