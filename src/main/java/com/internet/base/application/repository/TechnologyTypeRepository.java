package com.internet.base.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.internet.base.application.model.TechnologyType;

public interface TechnologyTypeRepository extends JpaRepository<TechnologyType, Long> {

	@Query(value = "SELECT * FROM technology_type WHERE id = :technologyId", nativeQuery = true)
	TechnologyType findOne(@Param("technologyId") Long technologyId);

}
