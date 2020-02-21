package com.internet.base.application.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.internet.base.application.model.DeviceType;

public interface DeviceTypeRepository extends CrudRepository<DeviceType, Long> {

	@Query(value = "SELECT * FROM device_type WHERE id = :devicetypeId", nativeQuery = true)
	DeviceType findOne(@Param("devicetypeId") Long devicetypeId);

}
