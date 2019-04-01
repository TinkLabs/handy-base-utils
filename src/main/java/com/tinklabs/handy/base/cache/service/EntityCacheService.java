package com.tinklabs.handy.base.cache.service;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

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
	
	public Map<Object, Object> getAll(String entityKey) {
		return stringRedisTemplate.opsForHash().entries(entityKey);
	}
	
	public Object get(String entityKey, String fieldKey) {
		return stringRedisTemplate.opsForHash().get(entityKey, fieldKey);
	}
	
	public Set<Object> keys(String entityKey) {
		return stringRedisTemplate.opsForHash().keys(entityKey);
	}

	public void delete(String entityKey) {
		stringRedisTemplate.delete(entityKey);
	}

}
