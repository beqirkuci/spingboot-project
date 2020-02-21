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

import com.internet.base.application.model.Users;
import com.internet.base.application.service.UserService;

@RestController
@RequestMapping(value = "/api")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/users")
	public Users addUser(@RequestBody Users users) {
		return userService.addUser(users);

	}

	@GetMapping("/users")
	public List<Users> getUsers() {
		return userService.getUsers();

	}

	@GetMapping("/users/{usersId}")
	public ResponseEntity<?> getTechById(@PathVariable Long usersId) {
		return userService.getUserById(usersId);

	}

	@PutMapping("/users/{usersId}")
	public ResponseEntity<?> updateUser(@PathVariable Long usersId, @Valid @RequestBody Users userRequest) {

		return userService.updateUser(usersId, userRequest);
	}

	@DeleteMapping("/users/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable Long userId) {

		return userService.deleteUser(userId);

	}

}
