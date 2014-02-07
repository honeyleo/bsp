package com.bsp.model;

import java.io.Serializable;

public class ResponseMessage implements Serializable {
	
	private static final long serialVersionUID = -3206844652371982650L;
	
	private int code;
	private String msg;
	private Object data;
	
	
	public ResponseMessage(Object data) {
		this.data = data;
	}

	public ResponseMessage(String message, Object data) {
		this.msg = message;
		this.data = data;
	}

	public ResponseMessage(int code, String message, Object data) {
		this.code = code;
		this.msg = message;
		this.data = data;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return msg;
	}
	public void setMessage(String message) {
		this.msg = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	

}
