package com.tinklabs.handy.base.exception;

public enum BaseErrors implements IError {

	SUCCESS("0","success"),
	PARAMS_EMPTY("100001","parameter(s) can not be empty."),
	UNKNOW_EXCEPTION("100002","unknowed exception."),
	BUSINESS_EXCEPTION("10003", "business exception"),
	BAECODE_IS_NOT_EXIST("20000","barcode is not exist."),
	SYSTEM_EXCEPTION("500","server internal error."),
	AUTHENTICATION_EXCEPTION("403","no auth.");


	private String code;

	private String msg;

	BaseErrors(String code,String msg) {
		this.code = code;
		this.msg = msg;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getMsg() {
		return msg;
	}

}
