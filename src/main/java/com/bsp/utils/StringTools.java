package com.bsp.utils;

import java.io.ByteArrayInputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.google.common.base.Strings;

/**
 * @author Kevin Jiang
 *
 */
/**
 * @author Kevin Jiang
 *
 */
public class StringTools {
	private static MessageDigest message = null;
	private static char[] digit = { '0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F' };
	private static SimpleDateFormat secondFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	private static SimpleDateFormat secondFormat_ = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat hourFormat = new SimpleDateFormat("HH");
	private static DecimalFormat numFormat_2   = new DecimalFormat("#.00");
	private static DecimalFormat numFormat_4   = new DecimalFormat("0000");
	
	static{
		try{
		   message = MessageDigest.getInstance("MD5");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean isNum(String str) {
		if (str == null || "".equals(str.trim())) return false;
		Pattern p = Pattern.compile("[0-9]*(\\.[0-9]*)?");
		Matcher m = p.matcher(str.trim());
		return m.matches();
	}
	
	public static boolean isPhoneNum(String str) {
		Matcher m = Pattern.compile("(13|14|15|18)[0-9]{9}").matcher(str);
		return m.matches();
	}
	
	
	
	
	public static String getMD5(String src){
		message.update(src.getBytes());
        byte[] b = new byte[16];
        b = message.digest();
        String digestHexStr = "";
        for (int i = 0; i < 16; i++){
           digestHexStr += byteHEX(b[i]);
        }
        return digestHexStr;
	}
	
	public static String getSHA256(String src) {
		message.update(src.getBytes());
		byte[] b = new byte[16];
		b = message.digest();
		String digestHexStr = "";
		for (int i = 0; i < 16; i++) {
			digestHexStr += byteHEX(b[i]);
		}
		return digestHexStr;
	}
	
	public static String byteHEX(byte ib){
        char [] ob = new char[2];
        ob[0] = digit[(ib >>> 4) & 0X0F];
        ob[1] = digit[ib & 0X0F];
        String s = new String(ob);
        return s;
    }
	
	public static String getMessageDigest(byte[] buffer, String key) {
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance(key);
			digest.update(buffer);
			return bytes2Hex(digest.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String bytes2Hex(byte[] bts) {
		String des = "";
		String tmp = null;
		for (int i = 0; i < bts.length; i++) {
			tmp = (Integer.toHexString(bts[i] & 0xFF));
			if (tmp.length() == 1) {
				des += "0";
			}
			des += tmp;
		}
		return des;
	}

	public static Integer toNum(String str,Integer def){
		try{
			if(str==null || str.isEmpty()) return def;
			return Integer.valueOf(str);
		}catch (Exception e) {
			return def;
		}
	}
	

	public static String getStr(Object object,String defVal){
		String string = (String)object;
		if(Strings.isNullOrEmpty(string))
			return defVal;
		return string;
	}
	
	public static double strToDouble(String str){
		try {
			if(!Strings.isNullOrEmpty(str)){
				return Double.parseDouble(str);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return 0.00;
	}
	
	
	public static String ebToRmb(String ebString){
		try {
			if(!Strings.isNullOrEmpty(ebString)){
				return Math.floor(Double.parseDouble(ebString)/100)+"";
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return "0";
	}
	
	public static String getSpecVlaue(String src,String spec1,String spec2){
		int offset1 = src.indexOf(spec1);
		if(spec1.equals("")) offset1 = 0;
		if(offset1==-1) return "";
		int offset2 = src.indexOf(spec2,offset1+spec1.length());
		if(spec2.equals("")) offset2 = src.length();
		if(offset2==-1 || offset1>offset2){
			return "";
		}else{
			return src.substring(offset1+spec1.length(), offset2);
		}
		
	}
	
	public static void main2(String[] args) {
		String string = "<notify><trade_status>TRADE_FINISHED</trade_status><total_fee>0.90</total_fee><subject>123456</subject><out_trade_no>1118060201-7555</out_trade_no><notify_reg_time>2010-11-1814:02:43.000</notify_reg_time><trade_no>2010111800209965</trade_no></notify>";
		parserSimpleXmlStr(string);
	}
	
	
	/**
	 * 只能解析一层的xml结构字符串 ，类似<Root><E1>V1</E1><E2>V2</E2></Root> , key名称全部为小写；
	 * @param xmlString
	 * @return
	 */
	public static  HashMap<String, String> parserSimpleXmlStr(String xmlString ) {
		if(xmlString==null || xmlString.isEmpty())
			return null;
		SAXReader saxReader = new SAXReader();
		HashMap<String, String> map = new HashMap<String, String>();
		try {
			ByteArrayInputStream stream = new ByteArrayInputStream(xmlString.getBytes("UTF-8"));
			Document document = saxReader.read(stream);
			Element root = document.getRootElement();
			for (Iterator<?> i = root.elementIterator(); i.hasNext();) {
				Element element = (Element) i.next();
				map.put(element.getName(), element.getTextTrim());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public static SimpleDateFormat getSecondFormat() {
		return secondFormat;
	}

	public static void setSecondFormat(SimpleDateFormat secondFormat) {
		StringTools.secondFormat = secondFormat;
	}

	public static SimpleDateFormat getSecondFormat_() {
		return secondFormat_;
	}

	public static void setSecondFormat_(SimpleDateFormat secondFormat_) {
		StringTools.secondFormat_ = secondFormat_;
	}
	
	
	public static String urlEncode(String str) {
		try {
			return URLEncoder.encode(str, "UTF-8");
		} catch (Exception e) {
			return "";
		}
	}
	
	public static String DisEncode(String str) {
		try {
			return URLDecoder.decode(str, "UTF-8");
		} catch (Exception e) {
			return "";
		}
	}
	
	public static int strToInt(String str,int defVal){
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			return defVal;
		}
	}

	public static DecimalFormat getNumFormat_2() {
		return numFormat_2;
	}

	public static void setNumFormat_2(DecimalFormat numFormat_2) {
		StringTools.numFormat_2 = numFormat_2;
	}

	public static SimpleDateFormat getHourFormat() {
		return hourFormat;
	}

	public static void setHourFormat(SimpleDateFormat hourFormat) {
		StringTools.hourFormat = hourFormat;
	}
	

	
	/**
	 * 获取一个编码过的URL
	 * */
	public static synchronized String getEncodedUrl(TreeMap<String,String> map) throws Exception{
		StringBuffer sb = new StringBuffer();
		for(Map.Entry<String,String> entity : map.entrySet()){
			sb.append(entity.getKey()).append("=").append(URLEncoder.encode(entity.getValue(),"UTF-8")).append("&");
		}
		if(sb.length()>0) sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}

	public static DecimalFormat getNumFormat_4() {
		return numFormat_4;
	}

	public static void setNumFormat_4(DecimalFormat numFormat_4) {
		StringTools.numFormat_4 = numFormat_4;
	}
	
	
	/**
	 * 正则验证邮箱
	 * @param email
	 * @return
	 */
	public static boolean checkEmail(String email) {
		if (StringUtils.isBlank(email)) return false;
		
		String regular = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
		Pattern pattern = Pattern.compile(regular, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);
		
		return matcher.matches();
	}
	
}
