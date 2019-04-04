package com.tinklabs.handy.base.util;

import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.tinklabs.handy.base.context.AppHolder;

import cn.hutool.core.bean.BeanDesc.PropDesc;

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
//		String jsonStr = JSONObject.toJSONString(bean);
//		return JSONObject.parseObject(jsonStr, new TypeReference<Map<String,String>>(){});
		
		if (bean == null) {
			return null;
		}
		Map<String, String> targetMap = new HashMap<>();
		final Collection<PropDesc> props = cn.hutool.core.bean.BeanUtil.getBeanDesc(bean.getClass()).getProps();

		String key;
		Method getter;
		Object value;
		for (PropDesc prop : props) {
			key = prop.getFieldName();
			// 过滤class属性
			// 得到property对应的getter方法
			getter = prop.getGetter();
			if (null != getter) {
				// 只读取有getter方法的属性
				try {
					value = getter.invoke(bean);
				} catch (Exception ignore) {
					continue;
				}
				if (null != value && false == value.equals(bean)) {
					if (null != key) {
						targetMap.put(key, value.toString());
					}
				}
			}
		}
		return targetMap;
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
	public static <T> T mapToBean(Map<Object,Object> map,Class<T> c){
		return cn.hutool.core.bean.BeanUtil.mapToBean(map, c, false);
	}
	
	/**
	 * @description: 生成缓存KEY
	 * @company: tinklabs
	 * @author: pengtao
	 * @date: 2019 2019年4月3日 下午2:56:36
	 * @param appName
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
		return MessageFormat.format(KEY_PATTERN, appName,type,id);
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
	public static String genKey(String type,String id){
		if(StringUtils.isEmpty(type) || 
				StringUtils.isEmpty(id)) {
			return null;
		}
		return MessageFormat.format(KEY_PATTERN, AppHolder.getAppName(),type,id);
	}
	
	
}
