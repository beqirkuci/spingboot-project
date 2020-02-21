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

import com.internet.base.application.model.Products;
import com.internet.base.application.service.Impl.ProductsService;

@RestController
@RequestMapping(value = "/api")
public class ProductController {
	@Autowired
	private ProductsService productsService;

	@PostMapping("/products")
	public ResponseEntity<?> addProduct(@RequestBody Products products) {
		return productsService.addProduct(products);

	}

	@GetMapping("/products")
	public List<Products> getProducts() {
		return productsService.getProducts();

	}

	@GetMapping("/products/{productsId}")
	public ResponseEntity<?> getproductsById(@PathVariable Long productsId) {
		return productsService.getproductsById(productsId);

	}

	@PutMapping("/products/{productsId}")
	public ResponseEntity<?> updateProduct(@PathVariable Long productsId, @Valid @RequestBody Products products) {
		return productsService.updateProduct(productsId, products);
	}

	@DeleteMapping("/products/{productsId}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long productsId) {
		return productsService.deleteProduct(productsId);

	}

}
