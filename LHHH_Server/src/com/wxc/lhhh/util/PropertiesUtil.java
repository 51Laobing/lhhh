package com.wxc.lhhh.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * ��ȡ�����ļ�
 * 
 * 
 */
public class PropertiesUtil {

	private static Properties properties = new Properties();

	public static void loadCodeDip() {
		try {
			properties.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("db.properties"));
		} catch (IOException e) {
		}
	}

	/**
	 * ��ȡֵ
	 * 
	 * @param key
	 * @return
	 */
	public static String getPropertyValue(String key) {
		loadCodeDip();
		String value = (String) properties.get(key);
		if (value != null && !value.equals("")) {
			try {
				value = new String(value.getBytes("GBK"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} else {
			value = "";
		}
		return value;
	}
}