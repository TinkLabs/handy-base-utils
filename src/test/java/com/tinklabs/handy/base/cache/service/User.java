package com.tinklabs.handy.base.cache.service;

import com.tinklabs.handy.base.vo.BaseVO;

public class User extends BaseVO{

	/**
	* @fields
	*/
	private static final long serialVersionUID = 5335907250681871155L;
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
