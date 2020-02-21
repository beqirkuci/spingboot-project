package com.internet.base.application.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.internet.base.application.model.Users;

public interface UserService3 {
	public Users addUser(Users users);
	public List<Users> getUsers();
	public ResponseEntity<?> getUserById( Long usersId);
	public ResponseEntity<?> updateUser(Long usersId,Users userRequest);
	public ResponseEntity<?> deleteUser(Long userId);

}
