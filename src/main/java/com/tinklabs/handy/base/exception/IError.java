package com.tinklabs.handy.base.exception;

/**
 * @description: 错误信息接口定义
 * @company: tinklabs
 * @author: pengtao
 * @date: 2019 2019年3月31日 下午8:29:40
 */
public interface IError {
	
	/**
	 * @description: 错误编码
	 * @company: tinklabs
	 * @author: pengtao
	 * @date: 2019 2019年3月31日 下午8:30:17
	 * @return
	 */
	String getCode();
	
	/**
	 * @description: 错误信息
	 * @company: tinklabs
	 * @author: pengtao
	 * @date: 2019 2019年3月31日 下午8:30:29
	 * @return
	 */
	String getMsg();
	
}
