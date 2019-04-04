package com.tinklabs.handy.base.vo;

import java.io.Serializable;

/**
 * @description: 抽取公共属性的基类bean
 * @company: tinklabs
 * @author: pengtao
 * @date: 2019 2019年3月28日 下午5:47:49
 */
public class BaseVO implements Serializable {

	/**
	* @fields
	*/
	private static final long serialVersionUID = 1251824293861123300L;
	
	/**
	 * 主键
	 */
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
