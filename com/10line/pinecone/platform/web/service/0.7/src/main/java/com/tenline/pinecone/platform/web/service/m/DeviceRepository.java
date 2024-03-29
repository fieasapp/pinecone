/**
 * 
 */
package com.tenline.pinecone.platform.web.service.m;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tenline.pinecone.platform.model.Device;

/**
 * @author Bill
 *
 */
@Repository
@RequestMapping("/device")
@Transactional(readOnly = true)
public class DeviceRepository {
	
	@PersistenceContext
	private EntityManager manager;
	
	private Random random = new Random();
	private ObjectMapper mapper = new ObjectMapper();

	@RequestMapping(value = "/search/codes", method = RequestMethod.GET)
	public @ResponseBody String findByCode(@RequestParam(value = "code") String code, HttpServletRequest request) throws Exception {
		List<Device> devices = manager.createQuery("from Device where code='" + code + "'", Device.class).getResultList();
		String result = null; 
		if (devices.size() >= 1) { 
			String[] location = getLatLngFromIP(request.getRemoteAddr());
			Device device = devices.get(0); device.setLatitude(location[0]);
			device.setLongitude(location[1]); manager.flush(); 
			result = "{\"id\":\"" + devices.get(0).getId() + "\"}"; 
		} return result;
	}
	
	private String[] getLatLngFromIP(String ip) throws Exception {
		String url = "http://api.map.baidu.com/location/ip?ak=1af0e35225715e9a9ce90c757e6eb394&ip="+ip+"&coor=bd09ll";
		HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
		connection.connect(); JsonNode root = mapper.readTree(connection.getInputStream());
		JsonNode point = root.findValue("point"); connection.disconnect();
		String latitude = point.get("y").asText(); String longitude = point.get("x").asText();
		List<Device> devices = manager.createQuery("from Device where latitude='"+latitude+"' AND longitude='"+longitude+"'", Device.class).getResultList();
		if(devices.size() >= 1) {return new String[]{calculateOffset(latitude), calculateOffset(longitude)};} 
		else {return new String[]{latitude, longitude};}
	}
	
	private String calculateOffset(String input) {
		String result = String.valueOf(Integer.valueOf(input.substring(input.lastIndexOf(".") + 1)) + random.nextInt(11) * 10000);
		return input.substring(0, input.lastIndexOf(".") + 1) + result;
	}
	
	@RequestMapping(value = "/search/activation/codes", method = RequestMethod.GET)
	public @ResponseBody boolean findByCode(@RequestParam(value = "devicecode") String code) {
		List<Device> devices = manager.createQuery("from Device where code='" + code + "'", Device.class).getResultList();
		if(devices.size() > 0) return true; else return false;
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody String create(@RequestBody Device device, HttpServletRequest request) throws Exception {
		String[] location = getLatLngFromIP(request.getRemoteAddr());
		device.setLatitude(location[0]); device.setLongitude(location[1]);
		manager.persist(device); manager.flush(); return "{\"id\":\"" + device.getId() + "\"}";
	}

}
