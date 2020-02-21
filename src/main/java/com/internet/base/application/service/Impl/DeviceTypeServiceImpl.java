package com.internet.base.application.service.Impl;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.internet.base.application.model.DeviceType;
import com.internet.base.application.repository.DeviceTypeRepository;
import com.internet.base.application.service.DeviceTypeService;

@Service
public class DeviceTypeServiceImpl implements  DeviceTypeService{
	@Autowired
	private DeviceTypeRepository deviceTypeRepository;
	@Override
	public DeviceType addDevice(DeviceType deviceType) {
		return deviceTypeRepository.save(deviceType);

	}
	@Override
	public Iterable<DeviceType> getDeviceTypes() {
		return deviceTypeRepository.findAll();

	}
	@Override
	public ResponseEntity<?> updateDeviceType(Long devicetypeId, @Valid DeviceType deviceType) {
		DeviceType devicetype = deviceTypeRepository.findOne(devicetypeId);
		if (devicetype != null) {

			devicetype.setName(deviceType.getName());
			;

			deviceTypeRepository.save(devicetype);

			Map<String, DeviceType> result = new HashMap<String, DeviceType>();
			result.put("DeviceType Updated ", devicetype);
			return new ResponseEntity<Map<String, DeviceType>>(result, HttpStatus.OK);
		} else {
			Map<String, Long> result = new HashMap<String, Long>();
			result.put("not found DeviceType with Id ", devicetypeId);
			return new ResponseEntity<Map<String, Long>>(result, HttpStatus.NOT_FOUND);
		}
	}
	@Override
	public ResponseEntity<?> deleteDeviceType(Long devicetypeId) {
		DeviceType deviceType = deviceTypeRepository.findOne(devicetypeId);
		if (deviceType != null) {

			deviceTypeRepository.delete(deviceType);

			Map<String, Long> result = new HashMap<String, Long>();
			result.put("Successfully deleted deviceType with Id: ", devicetypeId);
			return new ResponseEntity<Map<String, Long>>(result, HttpStatus.OK);

		} else {
			Map<String, Long> result = new HashMap<String, Long>();
			result.put("not found deviceType with Id ", devicetypeId);
			return new ResponseEntity<Map<String, Long>>(result, HttpStatus.NOT_FOUND);
		}
	}
	@Override
	public ResponseEntity<?> getOrdersById(Long productsId) {
		DeviceType deviceType = deviceTypeRepository.findOne(productsId);
		if (deviceType != null) {

			Map<String, DeviceType> result = new HashMap<String, DeviceType>();
			result.put("deviceType found: ", deviceType);
			return new ResponseEntity<Map<String, DeviceType>>(result, HttpStatus.OK);

		} else {
			Map<String, Long> result = new HashMap<String, Long>();
			result.put("Not found deviceType with Id ", productsId);
			return new ResponseEntity<Map<String, Long>>(result, HttpStatus.NOT_FOUND);
		}
	}

}
