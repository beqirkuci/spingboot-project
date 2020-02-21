package com.internet.base.application.service.Impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.internet.base.application.model.Orders;
import com.internet.base.application.model.Products;
import com.internet.base.application.repository.OrdersRepository;
import com.internet.base.application.repository.ProductRepository;

@Service
public class OrdersService {

	@Autowired
	private OrdersRepository ordersRepository;

	@Autowired
	private ProductRepository productRepository;

	public ResponseEntity<?> addOrder(Orders orders) {

		Products product = productRepository.findOne(orders.getProduct_id());

		if (product != null && orders.getQuantity() <= product.getProduct_quantity()) {
			
			orders.setCreatedAt(new Date());
			orders.setTotalPrice(orders.getQuantity()*product.getPrice());
			ordersRepository.save(orders);

			product.setProduct_quantity(product.getProduct_quantity() - orders.getQuantity());
			productRepository.save(product);

			Map<String, Orders> result = new HashMap<String, Orders>();
			result.put("Orders created ", orders);
			return new ResponseEntity<Map<String, Orders>>(result, HttpStatus.OK);
		} else {
			Map<String, Long> result = new HashMap<String, Long>();
			result.put("Select a lower quantity, available product for you ", product.getProduct_quantity());
			return new ResponseEntity<Map<String, Long>>(result, HttpStatus.NOT_FOUND);
		}
	}

	public List<Orders> getOrders() {

		return ordersRepository.findAll();
	}

	public ResponseEntity<?> updateOrder(Long ordersId, @Valid Orders orders) {
		Orders order = ordersRepository.findOne(ordersId);
		if (order != null) {

			//order.setPrice(orders.getPrice());
			order.setQuantity(orders.getQuantity());
			order.setUpdatedAt(new Date());

			ordersRepository.save(order);

			Map<String, Orders> result = new HashMap<String, Orders>();
			result.put("Orders Updated ", order);
			return new ResponseEntity<Map<String, Orders>>(result, HttpStatus.OK);
		} else {
			Map<String, Long> result = new HashMap<String, Long>();
			result.put("not found order with Id ", ordersId);
			return new ResponseEntity<Map<String, Long>>(result, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> deleteorder(Long ordersId) {
		Orders order = ordersRepository.findOne(ordersId);
		if (order != null) {

			ordersRepository.delete(order);

			Map<String, Long> result = new HashMap<String, Long>();
			result.put("Successfully deleted order with Id: ", ordersId);
			return new ResponseEntity<Map<String, Long>>(result, HttpStatus.OK);

		} else {
			Map<String, Long> result = new HashMap<String, Long>();
			result.put("not found order with Id ", ordersId);
			return new ResponseEntity<Map<String, Long>>(result, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> getOrders(Long ordersId) {
		Orders order = ordersRepository.findOne(ordersId);
		if (order != null) {

			Map<String, Orders> result = new HashMap<String, Orders>();
			result.put("Order found: ", order);
			return new ResponseEntity<Map<String, Orders>>(result, HttpStatus.OK);

		} else {
			Map<String, Long> result = new HashMap<String, Long>();
			result.put("Not found order with Id ", ordersId);
			return new ResponseEntity<Map<String, Long>>(result, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> getOrdersByDates(Orders orders, String dateFrom, String dateTo) {
		Map<String, String> result = new HashMap<String, String>();
		result.put(dateFrom, dateTo);
		return new ResponseEntity<Map<String, String>>(result, HttpStatus.OK);
	}

	public ResponseEntity<?> getOrdersBetweenDates(String date_from, String date_to, Orders orders) {

		if (date_from != null && date_to != null) {


			List<Orders> orders1 = ordersRepository.findallBetweenDates(date_from, date_to,orders.getUsers());
			if (orders1 != null) {
				Map<String, List<Orders>> result = new HashMap<String, List<Orders>>();
				result.put("Orders between dates provided: ", orders1);
				return new ResponseEntity<Map<String, List<Orders>>>(result, HttpStatus.NOT_FOUND);
			} else {
				Map<String, String> result = new HashMap<String, String>();
				result.put("Not found Orders between given  ", "Dates");
				return new ResponseEntity<Map<String, String>>(result, HttpStatus.NOT_FOUND);
			}
		} else {
			List<Orders> orders1 = ordersRepository.findAll();

			Map<String, List<Orders>> result = new HashMap<String, List<Orders>>();
			result.put("Select a lower quantity, available product for you ", orders1);
			return new ResponseEntity<Map<String, List<Orders>>>(result, HttpStatus.NOT_FOUND);
		}
	}

}
