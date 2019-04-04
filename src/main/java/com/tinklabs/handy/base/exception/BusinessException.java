package com.tinklabs.handy.base.exception;

/**
 * @description: 业务异常基类
 * @company: tinklabs
 * @author: pengtao
 * @date: 2019 2019年3月31日 下午9:22:00
 */
public class BusinessException extends RuntimeException{

	/**
	* @fields
	*/
	private static final long serialVersionUID = 5147558184138455123L;
	
	/**
	 * 错误定义
	 */
	private IError error;
	
	public BusinessException(IError error) {
		super(error.getMsg());
		this.error = error;
	}
	
	public BusinessException(IError error,String msg) {
		super(msg);
		this.error = error;
	}
	
	public BusinessException(IError error, Throwable cause) {
        super(error.getMsg(), cause);
        this.error = error;
    }
	
	public String getCode() {
		return error.getCode();
	}
	
	public String getMessage() {
		return error.getMsg();
	}

	public IError getError() {
		return error;
	}
}
