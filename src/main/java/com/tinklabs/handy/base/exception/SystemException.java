package com.tinklabs.handy.base.exception;

/**
 * @description: 基类系统异常
 * @company: tinklabs
 * @author: pengtao
 * @date: 2019 2019年3月31日 下午9:27:04
 */
public class SystemException extends RuntimeException{

	/**
	* @fields
	*/
	private static final long serialVersionUID = 4129159317137792155L;
	
	public SystemException(String message) {
		super(message);
	}
	
	public SystemException(String message,Throwable cause) {
		super(message,cause);
	}
	
}
