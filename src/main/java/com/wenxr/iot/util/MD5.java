package com.wenxr.iot.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * 描述：
 * <p>
 * &nbsp;&nbsp;&nbsp;&nbsp;MD5工具类
 * </p>
 * 创建日期 2011-12-28
 * 
 * @author yanghl
 * @version 1.0
 * 
 */
public class MD5 {
	/**
	 * 用来将字节转换成 16 进制表示的字符
	 */
	private static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7',
			'8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	/**
	 * 把字符串生成MD5摘要
	 * 
	 * @param source
	 *            要生成MD5摘要的字符串
	 * @return MD5摘要的字符串
	 */
	public static String getMD5(String source) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			return byteToHexString(md.digest(source.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 把原串用MD5加密后是否相同
	 * 
	 * @param source
	 *            原串
	 * @param strMD5
	 *            MD5加密后的串
	 * @return
	 * @throws Exception
	 */
	public static boolean isMached(String source, String strMD5)
			throws Exception {
		if (getMD5(source).equals(strMD5)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 把byte[]数组转换成十六进制字符串表示形式
	 * 
	 * @param tmp
	 *            要转换的byte[]
	 * @return 十六进制字符串表示形式
	 */
	private static String byteToHexString(byte[] tmp) {
		String s;
		/*- 
		 * 用字节表示就是 16 个字节 
		 * 每个字节用 16 进制表示的话，使用两个字符， 所以表示成 16 进制需要 32 个字符
		 */
		char str[] = new char[16 * 2];
		int k = 0; // 表示转换结果中对应的字符位置
		for (int i = 0; i < 16; i++) {
			/*
			 * 从第一个字节开始，对 MD5 的每一个字节 // 转换成 16 进制字符的转换
			 */
			byte byte0 = tmp[i]; // 取第 i 个字节
			str[k++] = hexDigits[byte0 >>> 4 & 0xf];
			/*
			 * 取字节中高 4 位的数字转换, >>> * 为逻辑右移，将符号位一起右移
			 */
			str[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
		}
		s = new String(str); // 换后的结果转换为字符串

		return s;
	}

}
