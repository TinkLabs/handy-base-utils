package com.tinklabs.handy.base.cache.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.tinklabs.handy.base.TestApp;
import com.tinklabs.handy.base.cache.service.EntityCacheService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApp.class)
public class EntityCacheServiceTest {
	
	@Autowired
	private EntityCacheService entityCacheService;
	
	@Autowired
	StringRedisTemplate stringRedisTemplate;
	
	@Test
	public void testPutAll() {
		String entityKey = "user_001";
		Map<String, String> entity = new HashMap<>();
		entity.put("name", "tom");
		entity.put("age", "1");
		entity.put("sex", "m");
		entityCacheService.putAll(entityKey, entity);
	}

	@Test
	public void testPut() {
		String entityKey = "user_001";
		entityCacheService.put(entityKey, "age", "3");
	}
	
	@Test
	public void testGetAll() {
		String entityKey = "user_001";
		Map<Object, Object> map = entityCacheService.getAll(entityKey);
		assertNotNull(map);
		assertNotNull(map.get("name"));
		
	}
	
	@Test
	public void testGet() {
		String entityKey = "user_001";
		Object name = entityCacheService.get(entityKey,"name");
		assertNotNull(name);
		assertNotNull(name);
	}
	
	@Test
	public void testKeys() {
		String entityKey = "user_001";
		Set<Object> fields = entityCacheService.keys(entityKey);
		assertNotNull(fields);
		assertEquals(3, fields.size());
	}

	@Test
	public void testDeletet() {
		String entityKey = "user_001";
		entityCacheService.delete(entityKey);
		
	}
	
	private Device initEntity() {
		Device d1 = new Device();
		d1.setId(1106292);
		d1.setZone_id(2);
		d1.setDevice_user_id(983581966);
		d1.setBarcode("355655090313877");
		d1.setToken("7775f762f8837c1e4668b7eca9584620");
		d1.setStatus("rented_out");
		d1.setModel("handy T2 EU");
		d1.setHotel_id(251);
		d1.setHotel_config_id(246);
		d1.setVersion("7.7.0,0.0,0.0,3.9.0,0.0,5.7.0,0.0,7.1.1,7.1.1,0.0,2.1.2,EU_1552568467,CN_1545840036");
		d1.setHotel_room_number("10001");
		d1.setHotel_hide(0);
		d1.setWifi_mac_address("5C:77:76:68:E8:9E");
		d1.setImsi("454070015123059");
		d1.setVirtual_extension("5110");
		d1.setLast_online("2019-04-02 14:00:06");
		d1.setBatterylv("89.0");
		d1.setLatitude("22.528343");
		d1.setLongitude("113.938372");
		d1.setLast_gps("2019-04-02 14:00:06");
		d1.setHotel_location("outside");
		d1.setDevice_sim_id("8985207170013649609");
		d1.setCreated("2018-12-03 22:10:12");
		d1.setModified("2019-04-02 14:06:00");
		d1.setAdb("0");
		d1.setSsid("<unknown ssid>");
		d1.setPush_type("pushy");
		d1.setPush_package_name("com.tinklabs.handy.pushservice");
		d1.setDevice_type("live");
		
		return d1;
	}
	
	@Test
	public void testPutDevice() {
		Device d1 = initEntity();
		String jsonStr = JSONObject.toJSONString(d1);
		Map m = JSONObject.parseObject(jsonStr, new TypeReference<Map<String,String>>(){});
		
		String key = "device_"+d1.getId();
		
		stringRedisTemplate.delete(key);
		entityCacheService.putAll(key, m);
	}

}
