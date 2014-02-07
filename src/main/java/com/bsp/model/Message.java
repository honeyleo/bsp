package com.bsp.model;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;

public class Message {

	private String ret;
	
	private String msg;
	
	private Object data;
	
	private Message(Builder builder) {
		this.ret = builder.ret;
		this.msg = builder.msg;
		if(!builder.data.isEmpty()) {
			this.data = builder.data;
		}
	}
	
	public static Builder newBuilder() {
		return new Builder("0","ok");
	}
	
	public String getRet() {
		return ret;
	}
	public String getMsg() {
		return msg;
	}
	

	public Object getData() {
		return data;
	}


	public static class Builder {
		
		private String ret;
		
		private String msg;
		
		private Map<String, Object> data = Maps.newLinkedHashMap();
		
		private Builder() {
			
		}
		private Builder(String ret, String msg) {
			this.ret = ret;
			this.msg = msg;
		}
		public Builder setRet(String ret) {
			this.ret = ret;
			return this;
		}
		public Builder setMsg(String msg) {
			this.msg = msg;
			return this;
		}
		public Builder setErrCode(ErrCode errCode) {
			this.ret = errCode.getRet();
			this.msg = errCode.getMsg();
			return this;
		}
		public Builder put(String key, Object value) {
			data.put(key, value);
			return this;
		}
		public Message build() {
			return new Message(this);
		}
	}
	public static void main(String[] args) {
		Message.Builder builder = Message.newBuilder();
		builder.setRet("0").setMsg("ok");
		String content = JSON.toJSONString(builder.build());
		System.out.println(content);
	}
	
}
