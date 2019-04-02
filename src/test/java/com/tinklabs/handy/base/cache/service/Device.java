package com.tinklabs.handy.base.cache.service;

import com.tinklabs.handy.base.vo.BaseVO;


public class Device  extends BaseVO{


    /**
	* @fields
	*/
	private static final long serialVersionUID = -3977598846155845429L;

	private Integer zone_id;

    private Integer device_user_id;

    private Integer devices_delivery_id;

    private String  barcode;

    private String  token;

    private String  softsim_key;

    private String  status;

    private String  model;

    private Integer hotel_id;

    private Integer hotel_config_id;

    private String  version;

    private String  section;

    private String  hotel_room_number;

    private Integer hotel_hide;

    private String  issue;

    private String  comment;

    private String  external_comment;

    private String  config;

    private String  debug;

    private String  debug_package;

    private String  wifi_mac_address;

    private String  service_provider;

    private String  sim_id;

    private String  imsi;

    private String  country_code;

    private String  phone_number;

    private String  virtual_extension;

    private String  last_online;

    private String  batterylv;

    private String  latitude;

    private String  longitude;

    private String  last_gps;

    private String  hotel_location;

    private String  upgrade_status;

    private String  device_sim_id;

    private String  created;

    private String  modified;

    private String  adb;

    private String  ssid;

    private String  nfc_id;

    private String  push_type;

    private String  push_package_name;

    private String  device_type;
    
    private User d_user;


    public Integer getZone_id() {
        return zone_id;
    }

    public void setZone_id(Integer zone_id) {
        this.zone_id = zone_id;
    }

    public Integer getDevice_user_id() {
        return device_user_id;
    }

    public void setDevice_user_id(Integer device_user_id) {
        this.device_user_id = device_user_id;
    }

    public Integer getDevices_delivery_id() {
        return devices_delivery_id;
    }

    public void setDevices_delivery_id(Integer devices_delivery_id) {
        this.devices_delivery_id = devices_delivery_id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSoftsim_key() {
        return softsim_key;
    }

    public void setSoftsim_key(String softsim_key) {
        this.softsim_key = softsim_key;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Integer hotel_id) {
        this.hotel_id = hotel_id;
    }

    public Integer getHotel_config_id() {
        return hotel_config_id;
    }

    public void setHotel_config_id(Integer hotel_config_id) {
        this.hotel_config_id = hotel_config_id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getHotel_room_number() {
        return hotel_room_number;
    }

    public void setHotel_room_number(String hotel_room_number) {
        this.hotel_room_number = hotel_room_number;
    }

    public Integer getHotel_hide() {
        return hotel_hide;
    }

    public void setHotel_hide(Integer hotel_hide) {
        this.hotel_hide = hotel_hide;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getExternal_comment() {
        return external_comment;
    }

    public void setExternal_comment(String external_comment) {
        this.external_comment = external_comment;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public String getDebug() {
        return debug;
    }

    public void setDebug(String debug) {
        this.debug = debug;
    }

    public String getDebug_package() {
        return debug_package;
    }

    public void setDebug_package(String debug_package) {
        this.debug_package = debug_package;
    }

    public String getWifi_mac_address() {
        return wifi_mac_address;
    }

    public void setWifi_mac_address(String wifi_mac_address) {
        this.wifi_mac_address = wifi_mac_address;
    }

    public String getService_provider() {
        return service_provider;
    }

    public void setService_provider(String service_provider) {
        this.service_provider = service_provider;
    }

    public String getSim_id() {
        return sim_id;
    }

    public void setSim_id(String sim_id) {
        this.sim_id = sim_id;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getVirtual_extension() {
        return virtual_extension;
    }

    public void setVirtual_extension(String virtual_extension) {
        this.virtual_extension = virtual_extension;
    }

    public String getLast_online() {
        return last_online;
    }

    public void setLast_online(String last_online) {
        this.last_online = last_online;
    }

    public String getBatterylv() {
        return batterylv;
    }

    public void setBatterylv(String batterylv) {
        this.batterylv = batterylv;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLast_gps() {
        return last_gps;
    }

    public void setLast_gps(String last_gps) {
        this.last_gps = last_gps;
    }

    public String getHotel_location() {
        return hotel_location;
    }

    public void setHotel_location(String hotel_location) {
        this.hotel_location = hotel_location;
    }

    public String getUpgrade_status() {
        return upgrade_status;
    }

    public void setUpgrade_status(String upgrade_status) {
        this.upgrade_status = upgrade_status;
    }

    public String getDevice_sim_id() {
        return device_sim_id;
    }

    public void setDevice_sim_id(String device_sim_id) {
        this.device_sim_id = device_sim_id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getAdb() {
        return adb;
    }

    public void setAdb(String adb) {
        this.adb = adb;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public String getNfc_id() {
        return nfc_id;
    }

    public void setNfc_id(String nfc_id) {
        this.nfc_id = nfc_id;
    }

    public String getPush_type() {
        return push_type;
    }

    public void setPush_type(String push_type) {
        this.push_type = push_type;
    }

    public String getPush_package_name() {
        return push_package_name;
    }

    public void setPush_package_name(String push_package_name) {
        this.push_package_name = push_package_name;
    }

    public String getDevice_type() {
        return device_type;
    }

    public void setDevice_type(String device_type) {
        this.device_type = device_type;
    }

	public User getD_user() {
		return d_user;
	}

	public void setD_user(User d_user) {
		this.d_user = d_user;
	}

}
