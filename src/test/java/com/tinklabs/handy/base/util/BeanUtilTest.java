package com.tinklabs.handy.base.util;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;
import org.springframework.beans.BeanUtils;

import com.tinklabs.handy.base.cache.service.Device;
import com.tinklabs.handy.base.cache.service.User;

public class BeanUtilTest {

	@Test
	public void testBeanToMap() {
		Device d1 = initEntity();
		Map<String, String> map = BeanUtil.beanToMap(d1);
		System.out.println(map);
		assertNotNull(map);
		assertEquals(d1.getId()+"",map.get("id"));
		assertEquals(d1.getD_user(),map.get("d_user"));
	}
	
	@Test
	public void testBeanToMap2() {
		Device d1 = initEntity();
		User u = new User();
		u.setId(123l);
		u.setName("user");
		d1.setD_user(u);
		Map<String, String> map = BeanUtil.beanToMap(d1);
		
		System.out.println(map);
		assertNotNull(map);
		assertEquals(d1.getId()+"",map.get("id"));
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testMapToBean() {
		Map map = BeanUtil.beanToMap(initEntity());
		Device d1 = BeanUtil.mapToBean(map, Device.class);
		assertNotNull(d1);
		assertEquals(map.get("id"),d1.getId()+"");
		assertEquals(map.get("d_user"),d1.getD_user());
	}
	
	private Device initEntity() {
		Device d1 = new Device();
		d1.setId(1106292l);
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
	
}
