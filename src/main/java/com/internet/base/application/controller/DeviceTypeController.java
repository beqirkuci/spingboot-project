package com.internet.base.application.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internet.base.application.model.DeviceType;
import com.internet.base.application.service.DeviceTypeService;

@RestController
@RequestMapping(value = "/api")
public class DeviceTypeController {
	@Autowired
	private DeviceTypeService deviceTypeService;

	@PostMapping("/devicetype")
	public DeviceType addDevice(@RequestBody DeviceType deviceType) {
		return deviceTypeService.addDevice(deviceType);

	}

	@GetMapping("/devicetype")
	public Iterable<DeviceType> getDeviceTypes() {
		return deviceTypeService.getDeviceTypes();

	}

	@GetMapping("/devicetype/{devicetypeId}")
	public ResponseEntity<?> getOrdersById(@PathVariable Long devicetypeId) {
		return deviceTypeService.getOrdersById(devicetypeId);

	}

	@PutMapping("/devicetype/{devicetypeId}")
	public ResponseEntity<?> updateDeviceType(@PathVariable Long devicetypeId,
			@Valid @RequestBody DeviceType deviceType) {

		return deviceTypeService.updateDeviceType(devicetypeId, deviceType);
	}

	@DeleteMapping("/devicetype/{devicetypeId}")
	public ResponseEntity<?> deleteDeviceType(@PathVariable Long devicetypeId) {

		return deviceTypeService.deleteDeviceType(devicetypeId);

	}

}
