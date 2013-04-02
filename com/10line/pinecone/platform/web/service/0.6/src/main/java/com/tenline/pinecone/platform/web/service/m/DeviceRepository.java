/**
 * 
 */
package com.tenline.pinecone.platform.web.service.m;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
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
public class DeviceRepository {
	
	@PersistenceContext
	private EntityManager manager;

	@RequestMapping(value = "/search/codes", method = RequestMethod.GET)
	public @ResponseBody String findByCode(@RequestParam(value = "code") String code) {
		List<Device> devices = manager.createQuery("from Device where code='" + code + "'", Device.class).getResultList();
		String result = null; if (devices.size() == 1) { result = "{\"id\":\"" + devices.get(0).getId() + "\"}"; } return result;
	}

}
