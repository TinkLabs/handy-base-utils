package com.tinklabs.handy.base.vo;

import java.io.Serializable;

import com.tinklabs.handy.base.exception.BaseErrors;
import com.tinklabs.handy.base.exception.IError;

/**
 * @description: 返回对象VO
 * @company: tinklabs
 * @author: pengtao
 * @date: 2019 2019年3月13日 下午7:38:50
 */
public class ResultVO implements Serializable{

	/**
	* @fields
	*/
	private static final long serialVersionUID = 3315745598718701972L;

	/**
	 * 返回编码
	 */
	private String code;
	/**
	 * 返回消息
	 */
	private String msg;
	/**
	 * 返回数据对象
	 */
	private Object data;
	
	public static final ResultVO SUCCESS = new ResultVO(BaseErrors.SUCCESS,null);
	
	public ResultVO() {}
	
	
	public ResultVO(IError error, Object data) {
		super();
		this.code = error.getCode();
		this.msg = error.getMsg();
		this.data = data;
	}

	/**
	 * @description: 构建成功返回对象
	 * @company: tinklabs
	 * @author: pengtao
	 * @date: 2019 2019年3月13日 下午7:43:48
	 * @param data
	 * @return
	 */
	public static ResultVO success(Object data) {
		return new ResultVO(BaseErrors.SUCCESS,data);
	}
	
	public static ResultVO fail(IError error) {
		return new ResultVO(error,null);
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
}