package com.tinklabs.handy.base.util;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

/**
 * @description: BEAN 工具类
 * @company: tinklabs
 * @author: pengtao
 * @date: 2019 2019年4月2日 下午3:56:08
 */
public class BeanUtil {

	/**
	 * @description: 将BEAN转成Map<String, String>，主要给redis hash用
	 * @company: tinklabs
	 * @author: pengtao
	 * @date: 2019 2019年4月2日 下午3:56:23
	 * @param bean
	 * @return
	 */
	public static Map<String, String> beanToMap(Object bean){
		String jsonStr = JSONObject.toJSONString(bean);
		return JSONObject.parseObject(jsonStr, new TypeReference<Map<String,String>>(){});
	}
	
	/**
	 * @description: 将Map转成BEAN
	 * @company: tinklabs
	 * @author: pengtao
	 * @date: 2019 2019年4月2日 下午4:00:03
	 * @param map
	 * @param c
	 * @return
	 */
	public static <T> T mapToBean(Map<String,Object> map,Class<T> c){
		String jsonStr = JSONObject.toJSONString(map);
		return JSONObject.parseObject(jsonStr,c);
	}
	
	
}
