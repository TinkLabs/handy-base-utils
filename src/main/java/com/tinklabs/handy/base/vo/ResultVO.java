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
public class ResultVO<T> implements Serializable{

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
	private T data;

	public static final ResultVO SUCCESS = new ResultVO(BaseErrors.SUCCESS,null);

	public ResultVO() {}

	public ResultVO(IError error) {
		super();
		this.code = error.getCode();
		this.msg = error.getMsg();
	}

	public ResultVO(IError error, T data) {
		super();
		this.code = error.getCode();
		this.msg = error.getMsg();
		this.data = data;
	}

	public ResultVO(IError error, String msg) {
		super();
		this.code = error.getCode();
		this.msg = msg;
	}

	/**
	 * @description: 构建成功返回对象
	 * @company: tinklabs
	 * @author: pengtao
	 * @date: 2019 2019年3月13日 下午7:43:48
	 * @param data
	 * @return
	 */
	public static <T> ResultVO<T> success(T data) {
		return new ResultVO(BaseErrors.SUCCESS,data);
	}

	public static ResultVO fail(IError error) {
		return new ResultVO(error);
	}

	public static ResultVO fail(IError error, String msg) {
		return new ResultVO(error,msg);
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}


}
