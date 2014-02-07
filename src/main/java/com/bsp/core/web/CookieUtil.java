package com.bsp.core.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bsp.utils.Base64;
import com.bsp.utils.StringTools;

/**
 * cookie工具类
 * 先进行Base64Encode再进行URLEncode
 * @author Kevin Jiang
 *
 */
public class CookieUtil {
	private static final Logger logger =  LoggerFactory.getLogger(CookieUtil.class);
	
	private static final String JAVA_NULL_COOKIE = "\"\"";
	
	/**
	 * @param response
	 * @param name
	 * @param value
	 * @param maxAge seconds
	 */
	public static void addCookie(HttpServletResponse response, String name, String value, int maxAge){
		String nameStr = null;
		String valueStr = null;
		try {
			nameStr = URLEncoder.encode(Base64.encode(name.getBytes()), "utf-8");
			if(!(value == null || "".equals(value))) {
				valueStr = URLEncoder.encode(Base64.encode(value.getBytes()), "utf-8");
			}
		} catch (UnsupportedEncodingException e) {
		}
	    Cookie cookie = new Cookie(nameStr, valueStr);
	    String domain = WebConstants.COOKIE_DOMAIN;
	    if(domain != null && !"".equals(domain)) {
	    	cookie.setDomain(domain);
	    }
	    cookie.setPath("/");
	    if(maxAge > 0) {
	    	cookie.setMaxAge(maxAge);
	    }
	    response.addCookie(cookie);
	}

	public static void removeCookie(HttpServletResponse response, String name, int maxAge){
		String nameStr = null;
		try {
			nameStr = URLEncoder.encode(Base64.encode(name.getBytes()), "utf-8");
		} catch (UnsupportedEncodingException e) {
		}
		Cookie cookie = new Cookie(nameStr, null);
		String domain = WebConstants.COOKIE_DOMAIN;
	    if(domain != null && !"".equals(domain)) {
	    	cookie.setDomain(domain);
	    }
		cookie.setPath("/");
	    if(maxAge > 0) {
	    	cookie.setMaxAge(maxAge);
	    }
		response.addCookie(cookie);
	}
	
	public static Cookie getCookieByName(HttpServletRequest request,String name){
	    Map<String,Cookie> cookieMap = readCookieMap(request);
	    String nameStr = null;
		try {
			nameStr = URLEncoder.encode(Base64.encode(name.getBytes()), "utf-8");
		} catch (UnsupportedEncodingException e) {
		}
	    if(cookieMap.containsKey(nameStr)){
	        Cookie cookie = (Cookie)cookieMap.get(nameStr);
	        return cookie;
	    }else{
	        return null;
	    }   
	}
	
	public static String getCookieValueByName(HttpServletRequest request,String name) {
		Cookie cookie = getCookieByName(request, name);
		String value = null;
		if(cookie != null && !("".equals(cookie.getValue())) && !(JAVA_NULL_COOKIE.equals(cookie.getValue()))) {
			try {
				value = new String(Base64.decode(URLDecoder.decode(cookie.getValue(), "utf-8")));
			} catch (UnsupportedEncodingException e) {
				logger.error("cookie base64解码错误。name:" + name + " | value:" + value);
			}
		} 
		return value;
	}
	
	private static Map<String,Cookie> readCookieMap(HttpServletRequest request){  
	    Map<String,Cookie> cookieMap = new HashMap<String,Cookie>();
	    Cookie[] cookies = request.getCookies();
	    if(null!=cookies){
	        for(Cookie cookie : cookies){
	            cookieMap.put(cookie.getName(), cookie);
	        }
	    }
	    return cookieMap;
	}
	
	
	//构造cookie加密部分
	public static String buildCookieMD5(String message, long timestamp) {
		String md5Key = WebConstants.COOKIE_KEY;		
		String newUserInfo = message + "&" + timestamp + "&" + md5Key;
		String md5UserInfo = StringTools.getMD5(newUserInfo).toLowerCase();
		
		return md5UserInfo;
	}
	
	
	
}
