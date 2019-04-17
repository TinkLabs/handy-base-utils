package com.tinklabs.handy.base.cache.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.tinklabs.handy.base.util.BeanUtil;

/**
 * @description: 实体数据缓存操作类，主要封装对实体的hash操作，以及后续的一级缓存扩展
 * @company: tinklabs
 * @author: pengtao
 * @date: 2019 2019年4月1日 下午4:08:00
 */
@Service
public class EntityCacheService {
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	public void putAll(String entityKey, Map<String, String> entity) {
		stringRedisTemplate.opsForHash().putAll(entityKey, entity);
	}

	public void put(String entityKey, String fieldKey, String value) {
		stringRedisTemplate.opsForHash().put(entityKey, fieldKey, value);
	}
	
	public void setStringValue(String key, String value) {
		stringRedisTemplate.opsForValue().set(key, value);
	}
	
	public Map<Object, Object> getAll(String entityKey) {
		return stringRedisTemplate.opsForHash().entries(entityKey);
	}
	
	public Object get(String entityKey, String fieldKey) {
		return stringRedisTemplate.opsForHash().get(entityKey, fieldKey);
	}
	
	public Object getStringValue(String key) {
		return stringRedisTemplate.opsForValue().get(key);
	}
	
	public Set<Object> keys(String entityKey) {
		return stringRedisTemplate.opsForHash().keys(entityKey);
	}

	public void delete(String entityKey) {
		stringRedisTemplate.delete(entityKey);
	}
	
	public Set<String> getSetValus(String key) {
		return stringRedisTemplate.opsForSet().members(key);
	}
	
	public void putSetValues(String key,String ... values) {
		stringRedisTemplate.opsForSet().add(key, values);
	}
	
	public void removeSetValue(String key,Object ... values) {
		stringRedisTemplate.opsForSet().remove(key, values);
	}
	
	public <T> T execute(CacheCallback<T> action,Class<T> c,String key) {
		
		Map<Object, Object> map = getAll(key);
		if (map != null && !map.isEmpty()) {
			System.out.println("in cache........");
			return BeanUtil.mapToBean(map, c);
		}
		T result = action.doSearch();
		if(result!=null) {
			putAll(key, BeanUtil.beanToMap(result));
		}
		return result;
	}
	
	public <T> List<T> getByRef(Class<T> c,String key,String valuePrefix) {
		//根据关联关系的key查询关联关系id集合
		Set<String> refKeys = getSetValus(key);
		if (refKeys != null && !refKeys.isEmpty()) {
			System.out.println("in cache........");
			//如果不为空，以pipeline方式查询每一个关联key对应的hash对象
			List<Object> result = stringRedisTemplate.executePipelined(new RedisCallback<Map<String,String>>() {

				@Override
				public Map<String,String> doInRedis(RedisConnection connection) throws DataAccessException {
					refKeys.stream().forEach(k->{
						connection.hGetAll(BeanUtil.genKey(valuePrefix, k).getBytes());
					} );
					return null;
				}
				
			});
			return transferMapToBeanOfList(c, result);
		}
		//如果没有查到关联key，返回空
		return null;
	}
	
	public <T> List<T> getByIds(Class<T> c,List<String> ids,String keyPrefix) {
		System.out.println("in cache........");
		//如果不为空，以pipeline方式查询每一个关联key对应的hash对象
		List<Object> result = stringRedisTemplate.executePipelined(new RedisCallback<Map<String,String>>() {

			@Override
			public Map<String,String> doInRedis(RedisConnection connection) throws DataAccessException {
				ids.stream().forEach(id->{
					connection.hGetAll(BeanUtil.genKey(keyPrefix, id).getBytes());
				} );
				return null;
			}
			
		});
		return transferMapToBeanOfList(c, result);
	}
	
	/**
	 * @description: 转换Map集合为bean集合
	 * @company: tinklabs
	 * @author: pengtao
	 * @date: 2019 2019年4月17日 下午5:16:39
	 * @param c
	 * @param result
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private <T> List<T> transferMapToBeanOfList(Class<T> c, List<Object> result) {
		if(result!=null && !result.isEmpty()) {
			//遍历转换hash对象为业务对象类型
			List<T> beanList = new ArrayList<T>();
			result.stream().forEach(m->{
				Map<Object,Object> map = (Map<Object,Object>)m;
				if(map.get("id")!=null) {
					T bean = BeanUtil.mapToBean(map, c);
					beanList.add(bean);
				}
			});
			//返回转换后的bean集合
			return beanList;
		}
		return null;
	}
	

}
