package com.internet.base.application.controller;

import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.internet.base.application.model.Orders;
import com.internet.base.application.service.Impl.OrdersService;

@RestController
@RequestMapping(value = "/api")
public class OrdersController {
	@Autowired
	private OrdersService ordersService;

	@PostMapping("/orders")
	public ResponseEntity<?> addOrder(@RequestBody Orders orders) {
		return ordersService.addOrder(orders);

	} 
	
	@GetMapping("/orders")
	public List<Orders> getOrders() {
		return ordersService.getOrders();

	}
	
	@GetMapping("/orders/date")
	public ResponseEntity<?> getOrdersBetweenDates(
			@RequestParam(name= "date_from")String date_from, 
	        @RequestParam(name= "date_to")String date_to,
	        @RequestBody Orders orders
	        
	        ) {
		return ordersService.getOrdersBetweenDates(date_from,date_to,orders);

	}
	
	@GetMapping("/orders/{ordersId}")
	public ResponseEntity<?> getOrders(@PathVariable Long ordersId) {
		return ordersService.getOrders(ordersId);

	}

	@PutMapping("/orders/{ordersId}")
	public ResponseEntity<?> updateOrder(@PathVariable Long ordersId, @Valid @RequestBody Orders orders) {

		return ordersService.updateOrder(ordersId, orders);
	}

	@DeleteMapping("/orders/{ordersId}")
	public ResponseEntity<?> deleteorder(@PathVariable Long ordersId) {

		return ordersService.deleteorder(ordersId);

	}

}
