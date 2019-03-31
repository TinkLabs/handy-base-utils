package com.tinklabs.handy.base.exception;

/**
 * @description: 未授权异常
 * @company: tinklabs
 * @author: pengtao
 * @date: 2019 2019年3月31日 下午9:34:00
 */
public class AuthenticationException extends Exception {

    /**
	* @fields
	*/
	private static final long serialVersionUID = 2330078516147949048L;
	
	public AuthenticationException() {
        super();
    }

    public AuthenticationException(String msg) {
        super(msg);
    }

}
