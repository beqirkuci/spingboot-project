package com.internet.base.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.internet.base.application.model.Orders;
import com.internet.base.application.model.Users;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

	@Query(value = "SELECT * FROM Orders WHERE id = :ordersId", nativeQuery = true)
	Orders findOne(@Param("ordersId") Long ordersId);


	@Query(value="select * FROM Orders AS c WHERE c.created_at BETWEEN :date_from AND :date_to  and user_id = :users ",nativeQuery = true)
	List<Orders> findallBetweenDates(String date_from, String date_to, Users users);

	
	//List<Orders> findByDates(Date dateFrom , dateTo);
}
