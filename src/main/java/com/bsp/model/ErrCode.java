package com.bsp.model;

public interface ErrCode {

	String getRet();
	
	String getMsg();
	
	
	public static final ErrCode SUCCESS = new ErrCode() {
		
		@Override
		public String getRet() {
			return "0";
		}
		
		@Override
		public String getMsg() {
			return "ok";
		}
	};
	
	
	public static final ErrCode FAIL = new ErrCode() {
		
		@Override
		public String getRet() {
			return "-1";
		}
		
		@Override
		public String getMsg() {
			return "fail";
		}
	};
	
}
