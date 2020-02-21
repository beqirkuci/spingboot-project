package com.internet.base.application.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.internet.base.application.model.TechnologyType;
import com.internet.base.application.repository.TechnologyTypeRepository;

@Service
public class TechnologyTypeService {

	@Autowired
	private TechnologyTypeRepository technologyTypeRepository;

	public TechnologyType addTechnology(TechnologyType technology) {
		return technologyTypeRepository.save(technology);

	}

	public List<TechnologyType> getTechnologies() {
		return technologyTypeRepository.findAll();

	}

	public ResponseEntity<?> updateTechnology(Long technologyId, @Valid TechnologyType technologyType) {
		TechnologyType technology = technologyTypeRepository.findOne(technologyId);
		if (technology != null) {

			technology.setName(technologyType.getName());

			technologyTypeRepository.save(technology);

			Map<String, TechnologyType> result = new HashMap<String, TechnologyType>();
			result.put("TechnologyType Updated ", technology);
			return new ResponseEntity<Map<String, TechnologyType>>(result, HttpStatus.OK);
		} else {
			Map<String, Long> result = new HashMap<String, Long>();
			result.put("not found technology with Id ", technologyId);
			return new ResponseEntity<Map<String, Long>>(result, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> deleteTechnology(Long technologyId) {
		TechnologyType technology = technologyTypeRepository.findOne(technologyId);
		if (technology != null) {

			technologyTypeRepository.delete(technology);

			Map<String, Long> result = new HashMap<String, Long>();
			result.put("Successfully deleted technology with Id: ", technologyId);
			return new ResponseEntity<Map<String, Long>>(result, HttpStatus.OK);

		} else {
			Map<String, Long> result = new HashMap<String, Long>();
			result.put("not found technology with Id ", technologyId);
			return new ResponseEntity<Map<String, Long>>(result, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> getTechById(Long technologyId) {
		TechnologyType technology = technologyTypeRepository.findOne(technologyId);
		if (technology != null) {

			Map<String, TechnologyType> result = new HashMap<String, TechnologyType>();
			result.put("technology found: ", technology);
			return new ResponseEntity<Map<String, TechnologyType>>(result, HttpStatus.OK);

		} else {
			Map<String, Long> result = new HashMap<String, Long>();
			result.put("not found technology with Id ", technologyId);
			return new ResponseEntity<Map<String, Long>>(result, HttpStatus.NOT_FOUND);
		}
	}

}
