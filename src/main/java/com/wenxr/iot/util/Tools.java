package com.wenxr.iot.util;

import java.io.File;
import java.math.BigInteger;
import java.sql.Blob;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.hibernate.lob.BlobImpl;

/**
 * 描述：
 * 
 * <p>
 * &nbsp;&nbsp;&nbsp;&nbsp;工具类
 * </p>
 * 
 * 创建日期 2016-5-24
 * 
 * @author yanghl
 * @version 1.0
 * 
 */
public class Tools {

	private static String[] binaryArray = { "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111" };

	/**
	 * 此函数判断字符串是否为空
	 * 
	 * @param 需判断字符串
	 * @return boolean值
	 * @since 2003-6-23
	 */
	public static boolean isEmpty(String input) {
		if (input == null) {
			return true;
		}
		if ("".equals(input.trim())) {
			return true;
		}
		if ("null".equals(input.trim())) {
			return true;
		}
		return false;
	}

	/**
	 * 判断是否null或没有内容。
	 * 
	 * @param param
	 * @return
	 */
	public static boolean isNULL(String param) {
		if (param == null || param.trim().equals(""))
			return true;
		else
			return false;
	}

	/**
	 * 取以 sign 分隔的一部分，从0开始。
	 * 
	 * @param sign
	 *            分隔符
	 * @param index
	 *            取index部分，从0开始
	 * @return
	 */
	public static String subStringBySign(String src, char sign, int index) {
		if (index <= 0) {
			return null;
		}

		String ret = null;
		int i, begin = 0, count = 0;
		for (i = 0; i < src.length(); i++) {
			if (src.charAt(i) != sign) {
				continue;
			}
			if (count < index) {
				begin = i + 1;
				count++;
			} else {
				break;
			}
		}

		if (i < src.length()) {
			ret = src.substring(begin, i);
		} else if (i == src.length() && count == index) {
			ret = src.substring(begin, i);
		}

		return ret;
	}

	/**
	 * 取sign字符在src字符串中出现的次数
	 * 
	 * @param src
	 * @param sign
	 * @return
	 */
	public static int getSignCount(String src, char sign) {
		int ret = 0;

		for (int i = 0; i < src.length(); i++) {
			if (src.charAt(i) == sign)
				ret++;
		}

		return ret;
	}

	/**
	 * 将sourceStr字符串按splitStr字符串拆分
	 * 
	 * @param sourceStr
	 *            源字符串
	 * @param splitStr
	 *            拆分字符串
	 * @return 拆分后的字符串数组
	 */
	public static String[] split(String sourceStr, String splitStr) {
		if (sourceStr == null || sourceStr.equals(""))
			return null;
		int i = 0;
		int j = 0;
		int start = 0;
		String temp = "";
		Vector<String> v = new Vector<String>();
		int splitLen = splitStr.length();
		int end = sourceStr.length();
		while (i < end) {
			i = i + sourceStr.indexOf(splitStr);
			j = sourceStr.indexOf(splitStr);
			if (j == -1) {
				temp = sourceStr;
				v.addElement(temp);
				break;
			}
			temp = sourceStr.substring(start, j);
			v.addElement(temp);
			i++;
			start = j;
			sourceStr = sourceStr.substring(start + splitLen, sourceStr.length());
			start = 0;
		}
		int size = v.size();
		String[] returnData = new String[size];
		for (int n = 0; n < size; n++) {
			returnData[n] = (String) v.elementAt(n);
		}
		return returnData;
	}

	/**
	 * 将字符串sourceStr中出现的placedStr替换成placeStr字符串
	 * 
	 * @param sourcStr
	 *            源字符串
	 * @param placedStr
	 *            要替换的字符串
	 * @param placeStr
	 *            替换的字符串
	 * @return 替换后的字符串
	 */
	public static String replaceAll(String sourcStr, String placedStr, String placeStr) {
		int i = 0;
		String[] data = split(sourcStr, placedStr);
		if (data == null)
			return sourcStr;
		StringBuffer returnData = new StringBuffer("");
		if (data.length > 0) {
			for (i = 0; i < data.length - 1; i++) {
				returnData.append(data[i]).append(placeStr);
			}
			returnData.append(data[i]);

		}
		return returnData.toString();
	}

	/**
	 * 将字符串sourceStr中首个出现的placedStr替换成placeStr字符串
	 * 
	 * @param sourcStr
	 *            源字符串
	 * @param placedStr
	 *            要替换的字符串
	 * @param placeStr
	 *            替换的字符串
	 * @return 替换后的字符串
	 */
	public static String replaceFirst(String sourcStr, String placedStr, String placeStr) {
		if (sourcStr == null)
			return null;
		if (sourcStr.indexOf(placedStr) >= 0) {
			String tmp1 = sourcStr.substring(0, sourcStr.indexOf(placedStr));
			String tmp2 = sourcStr.substring(sourcStr.indexOf(placedStr) + placedStr.length());
			return tmp1 + placeStr + tmp2;
		} else {
			return sourcStr;
		}
	}

	/**
	 * 此函数返回需要转换的字符串转换后的字符串值，如为null则变为""，否则为原字符串
	 * 
	 * @param String
	 *            :需要转换的字符串
	 * @return 转换后的字符串
	 * @exception 无
	 */
	public static String convertNull(String input) {
		if (input == null || "null".equals(input)) {
			return "";
		} else {
			input = Tools.replaceAll(input, "00:00:00", "").trim();
			if ("null".equals(input)) {
				input = "";
			}
			return input;
		}
	}

	/**
	 * 此函数将数字返回格式为"###0.00（digit位）"的字串
	 * 
	 * @param 需转换的数字
	 * @return
	 */
	public static String numberFormat(double parameter, int digit) {
		StringBuffer temp = new StringBuffer();
		for (int i = 0; i < digit; i++) {
			temp.append("0");
		}
		DecimalFormat df2 = new DecimalFormat("###0." + temp.toString());
		return df2.format(parameter);
	}

	/**
	 * 此函数将数字返回格式为"###0.00（2位）"的字串
	 * 
	 * @param parameter
	 * @return
	 */
	public static String numberFormat(double parameter) {
		return Tools.numberFormat(parameter, 2);
	}

	/**
	 * 此函数将数字返回格式为"###0.00（digit位）"的double
	 * 
	 * @param parameter
	 * @return
	 */
	public static double numberFormatD(double parameter, int digit) {
		return Double.parseDouble(Tools.numberFormat(parameter, digit));
	}

	/**
	 * 此函数将数字返回格式为"###0.00（2位）"的double
	 * 
	 * @param parameter
	 * @return
	 */
	public static double numberFormatD(double parameter) {
		return Double.parseDouble(Tools.numberFormat(parameter));
	}

	/**
	 * 将文本域中输入的内容按照原格式显示出来
	 * 
	 * @param sourcestr
	 * @return
	 */
	public static String textToHtml(String sourcestr) {
		if (sourcestr == null)
			return "";
		String restring = sourcestr;
		restring = replaceAll(restring, "<", "&lt;");
		restring = replaceAll(restring, ">", "&gt;");
		restring = replaceAll(restring, "\"", "&quot;");
		restring = replaceAll(restring, "'", "&#039;");
		restring = replaceAll(restring, " ", "&nbsp;");
		restring = replaceAll(restring, "\r\n", "<br>");
		restring = replaceAll(restring, "\r", "<br>");
		restring = replaceAll(restring, "\n", "<br>");

		return restring == null ? "" : restring;
	}

	/**
	 * 获取文件名的扩展名
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getExtention(String fileName) {
		int pos = fileName.lastIndexOf(".");
		return pos < 0 ? "" : fileName.substring(pos);
	}

	/**
	 * 手机号验证
	 * 
	 * @param str
	 * @return 验证通过返回true
	 */
	public static boolean isMobile(String str) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile("^[1][3,4,5,8][0-9]{9}$"); // 验证手机号
		m = p.matcher(str);
		b = m.matches();
		return b;
	}

	/**
	 * 电话号码验证
	 * 
	 * @param str
	 * @return 验证通过返回true
	 */
	public static boolean isPhone(String str) {
		Pattern p1 = null, p2 = null;
		Matcher m = null;
		boolean b = false;
		p1 = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$"); // 验证带区号的
		p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$"); // 验证没有区号的
		if (str.length() > 9) {
			m = p1.matcher(str);
			b = m.matches();
		} else {
			m = p2.matcher(str);
			b = m.matches();
		}
		return b;
	}

	/**
	 * 判断是否是邮件
	 * 
	 * @param pInput
	 * @return
	 */
	public static boolean isEmail(String pInput) {
		if (Tools.isEmpty(pInput)) {
			return false;
		}
		String regEx = "([\\w[_-][\\.]]+@+[\\w[_-]]+\\.+[A-Za-z]{2,3})|([\\w[_-][\\.]]+@+[\\w[_-]]+\\.+[\\w[_-]]+\\.+[A-Za-z]{2,3})|"
				+ "([\\w[_-][\\.]]+@+[\\w[_-]]+\\.+[\\w[_-]]+\\.+[\\w[_-]]+\\.+[A-Za-z]{2,3})";
		Pattern p = Pattern.compile(regEx);
		Matcher matcher = p.matcher(pInput);
		return matcher.matches();
	}

	/**
	 * 获取IP
	 * 
	 * @param request
	 * @return
	 */
	public static String getRemoteHost(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
	}

	/**
	 * 创建指定数量的随机字符串
	 * 
	 * @param numberFlag
	 *            是否是数字
	 * @param length
	 * @return
	 */
	public static String genRandom(boolean numberFlag, int length) {
		String retStr = "";
		String strTable = numberFlag ? "1234567890" : "1234567890abcdefghijkmnopqrstuvwxyzABCDEFGHIJKMNOPQRSTUVWXYZ";
		int len = strTable.length();
		boolean bDone = true;
		do {
			retStr = "";
			int count = 0;
			for (int i = 0; i < length; i++) {
				double dblR = Math.random() * len;
				int intR = (int) Math.floor(dblR);
				char c = strTable.charAt(intR);
				if (('0' <= c) && (c <= '9')) {
					count++;
				}
				retStr += strTable.charAt(intR);
			}
			if (count >= 2) {
				bDone = false;
			}
		} while (bDone);

		return retStr;
	}

	/**
	 * 获取UUID，主键
	 * 
	 * @return
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 将String数组转换成，数组中各值组合的形式，用“,”分开
	 * 
	 * @param employeeShiftIds
	 * @return
	 */
	public static String arrayToString(String[] array) {
		if (array == null) {
			return "";
		}
		String rtStr = "";
		for (String s : array) {
			rtStr += "," + s;
		}
		return rtStr.equals("") ? "" : rtStr.substring(1);
	}

	/**
	 * 根据起止日期获取签约年限，不足一个月可看做一个月，返回格式为:x年x月、x年、x月
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static String getYearByDate(Date beginDate, Date endDate) {
		if (beginDate == null || endDate == null) {
			return "";
		}
		Calendar b = Calendar.getInstance();
		Calendar e = Calendar.getInstance();
		b.setTime(beginDate);
		e.setTime(endDate);
		int by = b.get(Calendar.YEAR);
		int ey = e.get(Calendar.YEAR);
		int bm = b.get(Calendar.MONTH);
		int em = e.get(Calendar.MONTH);
		int year = 0, month = 0;
		if (ey == by) {
			month = em - bm + 1;
		} else {
			year = ey - ey;
			month = (12 - bm + 1) + em;
		}
		if (month == 12) {
			year++;
			month = 0;
		} else if (month < 12) {
			year--;
			// 跨年但不足一年的情况
			if (year < 0) {
				year = 0;
			}
		}
		return year == 0 ? month + "月" : month == 0 ? year + "年" : year + "年" + month + "月";
	}

	/**
	 * 十六进制字符串转换成二进制字符串
	 * 
	 * @param hex
	 * @return
	 */
	public static String hex2Binary(String hex) {
		hex = hex.toLowerCase();
		hex = hex.startsWith("0x") ? hex.substring(2) : hex;
		StringBuffer a = new StringBuffer("");
		char[] c = hex.toCharArray();
		for (int i = 0; i < c.length; i++) {
			a.append(binaryArray[Integer.parseInt(String.valueOf(c[i]), 16)]);
		}
		return a.toString();
	}

	/**
	 * 二进制or操作
	 * 
	 * @param bin
	 * @return
	 */
	public static String binaryOr(String... bin) {
		if (bin.length == 0) {
			return null;
		}
		if (bin.length == 1) {
			return bin[0];
		}
		BigInteger b = new BigInteger(bin[0], 2);
		for (int i = 1; i < bin.length; i++) {
			if (Tools.isEmpty(bin[i])) {
				continue;
			}
			b = b.or(new BigInteger(bin[i], 2));
		}
		return b.toString(2);
	}

	/**
	 * 二进制and操作，用于页面标签调用
	 * 
	 * @param bin
	 * @param bin1
	 * @return
	 */
	public static String binaryAnds(String bin, String bin1) {
		return Tools.binaryAnd(new String[] { bin, bin1 });
	}

	/**
	 * 二进制and操作
	 * 
	 * @param bin
	 * @return
	 */
	public static String binaryAnd(String... bin) {
		if (bin.length == 0) {
			return null;
		}
		if (bin.length == 1) {
			return bin[0];
		}
		BigInteger b = new BigInteger(bin[0], 2);
		for (int i = 1; i < bin.length; i++) {
			if (Tools.isEmpty(bin[i])) {
				continue;
			}
			b = b.and(new BigInteger(bin[i], 2));
		}
		return b.toString(2);
	}

	/**
	 * 从binary中移除bin
	 * 
	 * @param binary
	 * @param bin
	 * @return
	 */
	public static String binaryRemove(String binary, String... bin) {
		if (Tools.isEmpty(binary) || bin.length == 0) {
			return binary;
		}
		String binOr = Tools.binaryOr(bin);
		BigInteger b = new BigInteger(binary, 2);
		BigInteger c = new BigInteger(binOr, 2);
		if (b.bitLength() < c.bitLength()) {
			c = new BigInteger(binOr.substring(c.toString(2).length() - b.toString(2).length()), 2);
		}
		b = b.not();
		b = b.or(c);

		return b.not().toString(2);
	}

	/**
	 * 将blob类型转换为String字符串
	 * 
	 * @param blog
	 * @return
	 */
	public static String blob2Base64Str(Blob blog) {
		if (blog == null) {
			return null;
		}
		try {
			return Base64.encodeBase64String(blog.getBytes(1l, (int) blog.length()));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 将file类型转换为String字符串
	 * 
	 * @param file
	 * @return
	 */
	public static String file2Base64Str(File file) {
		if (file == null) {
			return null;
		}
		try {
			return Base64.encodeBase64String(FileUtils.readFileToByteArray(file));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 将file类型字符串数组转换为String字符串
	 * 
	 * @param file
	 * @return
	 */
	public static String fileByteArr2Base64Str(byte[] byt) {
		if (byt == null) {
			return null;
		}
		try {
			return Base64.encodeBase64String(byt);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 将Base64转成blob
	 * 
	 * @param base64Str
	 * @return
	 */
	public static Blob base64Str2Blob(String base64Str) {
		if (Tools.isEmpty(base64Str)) {
			return null;
		}
		try {
			return new BlobImpl(Base64.decodeBase64(base64Str));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 获取随机数数组
	 * 
	 * @param scope随机数范围
	 * @param size
	 *            产生几个随机数
	 * @param allowRepeat
	 *            所产生的随机数是否允许重复
	 * @return
	 */
	public static synchronized int[] getRandom(int scope, int size, boolean allowRepeat) {
		int[] rand = new int[size];
		for (int i = 0; i < size; i++) {
			int num = (int) Math.floor(Math.random() * scope);
			if (allowRepeat) {
				rand[i] = num;
			} else {
				boolean isRepeat = false;
				for (int j = 0; j < i; j++) {
					if (num == rand[j]) {// 重复
						isRepeat = true;
						break;
					}
				}
				if (isRepeat) {
					i--;
					continue;
				} else {
					rand[i] = num;
				}
			}
		}
		return rand;
	}

	/**
	 * 根据经纬度计算距离
	 * 
	 * @param sLat
	 *            起点纬度
	 * @param sLon
	 *            起点经度
	 * @param eLat
	 *            终点纬度
	 * @param eLon
	 *            终点经度
	 * @param isKm
	 *            返回的距离单位
	 * @return 距离
	 */
	public static double getDistance(double sLat, double sLon, double eLat, double eLon, boolean isKm) {
		double distance = 0;
		if (sLat > 0 && sLon > 0 && eLat > 0 && eLon > 0)
			if (isKm)
				distance = Math.sqrt(Math.abs(sLat - eLat) * Math.abs(sLat - eLat) + Math.abs(sLon - eLon) * Math.abs(sLon - eLon)) * 100; // 公里
			else
				distance = Math.sqrt(Math.abs(sLat - eLat) * Math.abs(sLat - eLat) + Math.abs(sLon - eLon) * Math.abs(sLon - eLon)) * 100000; // 米
		return distance;
	}

	/**
	 * 读取文件最后修改时间
	 * 
	 * @param file
	 *            文件
	 * @param format
	 *            要求返回的时间格式，如：yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getModifiedTime(File file, String format) {
		Calendar cal = Calendar.getInstance();
		long time = file.lastModified();
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		cal.setTimeInMillis(time);
		return formatter.format(cal.getTime());
	}

	/**
	 * 获取某个日期前几天的日期
	 * 
	 * @param d
	 *            已知日期
	 * @param day
	 *            已知日期的前几天
	 * @param format
	 *            要求返回的时间格式，如：yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getDateBefore(Date d, int day, String format) {
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(now.getTime());
	}

	/**
	 * 比较两个字符串日期
	 * 
	 * @param date1
	 * @param date2
	 * @return 1：date1>date2 0:date1=date2 -1:date1<date2
	 */
	public static int compareDate(String date1, String date2) {
		String f = null;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date d1 = formatter.parse(date1);
			Date d2 = formatter.parse(date2);
			if (d1.getTime() > d2.getTime()) {
				f = "1";
			} else if (d1.getTime() < d2.getTime()) {
				f = "-1";
			} else if (d1.getTime() == d2.getTime()) {
				f = "0";
			}
		} catch (ParseException e) {
		}
		return Integer.parseInt(f);
	}

	public static String long2DateFormat(String time) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (!Tools.isEmpty(time)) {
			Long l = Long.parseLong(time);
			Date date = new Date(l);
			return formatter.format(date);
		}
		return "";
	}
}