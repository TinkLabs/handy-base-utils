package com.tinklabs.handy.base.util;

import java.text.MessageFormat;
import java.util.Map;

import org.springframework.util.StringUtils;

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
	 * 缓存KEY模式， app:entitytype:entityid
	 */
	private static final String KEY_PATTERN = "{0}:{1}:{2}";

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
	
	/**
	 * @description: 生成缓存KEY
	 * @company: tinklabs
	 * @author: pengtao
	 * @date: 2019 2019年4月3日 下午2:56:36
	 * @param type
	 * @param id
	 * @return
	 */
	public static String genKey(String appName,String type,String id){
		if(StringUtils.isEmpty(type) || 
				StringUtils.isEmpty(id) ||
					StringUtils.isEmpty(appName)) {
			return null;
		}
		return MessageFormat.format(KEY_PATTERN, type,id);
	}
	
	
}
