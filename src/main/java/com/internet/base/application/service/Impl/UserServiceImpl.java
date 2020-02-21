package com.internet.base.application.service.Impl;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.internet.base.application.model.Users;
import com.internet.base.application.repository.UserRepository;
import com.internet.base.application.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Override
	public Users addUser(Users users) {
		return userRepository.save(users);
	}
	@Override
	public List<Users> getUsers() {
		return userRepository.findAll();
	}
	@Override
	public ResponseEntity<?> updateUser(Long usersId, Users userRequest) {
		Users users = userRepository.findOne(usersId);
		if (users != null) {

			users.setEmail(userRequest.getEmail());
			users.setName(userRequest.getName());
			users.setSurname(userRequest.getSurname());

			userRepository.save(users);

			Map<String, Users> result = new HashMap<String, Users>();
			result.put("User Updated ", users);
			return new ResponseEntity<Map<String, Users>>(result, HttpStatus.OK);
		} else {
			Map<String, Long> result = new HashMap<String, Long>();
			result.put("not found User with Id ", usersId);
			return new ResponseEntity<Map<String, Long>>(result, HttpStatus.NOT_FOUND);
		}
	}
	@Override
	public ResponseEntity<?> deleteUser(Long userId) {
		Users users = userRepository.findOne(userId);
		if (users != null) {

			userRepository.delete(users);

			Map<String, Long> result = new HashMap<String, Long>();
			result.put("Successfully deleted user with Id: ", userId);
			return new ResponseEntity<Map<String, Long>>(result, HttpStatus.OK);

		} else {
			Map<String, Long> result = new HashMap<String, Long>();
			result.put("not found User with Id ", userId);
			return new ResponseEntity<Map<String, Long>>(result, HttpStatus.NOT_FOUND);
		}

	}
	@Override
	public ResponseEntity<?> getUserById(Long usersId) {
		Users users = userRepository.findOne(usersId);
		if (users != null) {

			Map<String, Users> result = new HashMap<String, Users>();
			result.put("User: ", users);
			return new ResponseEntity<Map<String, Users>>(result, HttpStatus.OK);

		} else {
			Map<String, Long> result = new HashMap<String, Long>();
			result.put("not found User with Id ", usersId);
			return new ResponseEntity<Map<String, Long>>(result, HttpStatus.NOT_FOUND);
		}
	}
	

	
}
