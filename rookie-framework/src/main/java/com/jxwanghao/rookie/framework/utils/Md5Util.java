package com.jxwanghao.rookie.framework.utils;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/**
 * Md5工具类
 * 
 * @author jiangmy
 * @date 2016-08-04 15:44:50
 * @since v1.0.0
 */
public class Md5Util {

	public final static String md5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] btInput = s.getBytes(Charset.forName("UTF-8"));
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(btInput);
			byte[] md = mdInst.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str).toLowerCase();
//			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 短md5,摘取第9至24位字符
	 * 
	 * @author jiangmy
	 * @date 2016-11-28 16:45:10
	 * @since v1.0.0
	 * @param s
	 * @return
	 */
	public final static String smd5(String s) {
		try {
			return md5(s).substring(8, 24);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
