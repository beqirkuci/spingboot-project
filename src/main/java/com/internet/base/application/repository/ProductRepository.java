package com.internet.base.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.internet.base.application.model.Products;

public interface ProductRepository extends JpaRepository<Products, Long> {

	@Query(value = "SELECT * FROM Products WHERE products_id = :productsId", nativeQuery = true)
	Products findOne(Long productsId);
}
