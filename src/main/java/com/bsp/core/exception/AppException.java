package com.bsp.core.exception;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class AppException extends RuntimeException {

	private static final long serialVersionUID = 8633328680035195765L;
	
	private String code;
	private String msg;
	private Exception exception;

	public AppException(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public AppException(String code, String msg, Exception exception) {
		this.code = code;
		this.msg = msg;
		this.exception = exception;
	}
	
	public String getMessage() {
		return this.msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public Map<String, Object> getExceptionMap(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", this.code);
		map.put("msg", this.msg);
		return map;
	}
	
	public String getJsonString(){
		return JSON.toJSONString(getExceptionMap());
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}
}
