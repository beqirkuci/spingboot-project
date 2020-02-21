package com.internet.base.application.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.internet.base.application.model.Users;



public interface UserRepository extends JpaRepository <Users, Long> {

	boolean existsByEmail(String email);

	@Query(value = "SELECT * FROM users WHERE id = :id", nativeQuery = true)
	Users findOne(@Param("id") Long id);
}
