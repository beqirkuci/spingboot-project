package com.internet.base.application.service;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.internet.base.application.model.DeviceType;

public interface DeviceTypeService {
	public DeviceType addDevice(DeviceType deviceType);
	public Iterable<DeviceType> getDeviceTypes();
	public ResponseEntity<?> updateDeviceType(Long devicetypeId, @Valid DeviceType deviceType);
	public ResponseEntity<?> deleteDeviceType(Long devicetypeId);
	public ResponseEntity<?> getOrdersById(Long productsId);

}
