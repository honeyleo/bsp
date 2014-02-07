package com.bsp.utils;

import java.util.Properties;

public class Config {
	public static final String PRO_IMG_DOMAIN_KEY = "boxwan.imgHost";
	
	public static final String PRO_RES_DOMAIN_KEY = "boxwan.resHost";
	
	public static final String DOWNLOAD_KEY = "boxwan.des_key";
	
	private static final String API_CONFIG_FILENAME = "config/config.properties";

	private static Properties properties;

	private synchronized static void loadProperties() {
		if (properties == null) {
			properties = new Properties();
			try {
				properties.load(Thread.currentThread().getContextClassLoader()
						.getResourceAsStream(API_CONFIG_FILENAME));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static String getProperty(String name) {
		loadProperties();
		String value = properties.getProperty(name);
		return value;
	}
}
