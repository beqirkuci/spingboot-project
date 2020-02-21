package com.internet.base.application.controller;

import java.util.List;

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

import com.internet.base.application.model.TechnologyType;
import com.internet.base.application.service.Impl.TechnologyTypeService;

@RestController
@RequestMapping(value = "/api")
public class TechnologyTypeController {
	@Autowired
	private TechnologyTypeService technologyTypeService;

	@PostMapping("/technology")
	public TechnologyType addTechnology(@RequestBody TechnologyType technology) {
		return technologyTypeService.addTechnology(technology);

	}

	@GetMapping("/technology")
	public List<TechnologyType> getTechnologies() {
		return technologyTypeService.getTechnologies();

	}

	@GetMapping("/technology/{technologyId}")
	public ResponseEntity<?> getTechById(@PathVariable Long technologyId) {
		return technologyTypeService.getTechById(technologyId);

	}

	@PutMapping("/technology/{technologyId}")
	public ResponseEntity<?> updateTechnology(@PathVariable Long technologyId,
			@Valid @RequestBody TechnologyType technologyType) {

		return technologyTypeService.updateTechnology(technologyId, technologyType);
	}

	@DeleteMapping("/technology/{technologyId}")
	public ResponseEntity<?> deleteTechnology(@PathVariable Long technologyId) {

		return technologyTypeService.deleteTechnology(technologyId);

	}
}
