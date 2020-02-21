package com.internet.base.application.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.internet.base.application.model.Products;
import com.internet.base.application.repository.ProductRepository;

@Service
public class ProductsService {
	@Autowired
	private ProductRepository productRepository;

	public ResponseEntity<?> addProduct(Products products) {

		Products product = productRepository.findOne(products.getProducts_id());

		if (product != null) {

			Long product_Quantity = product.getProduct_quantity();
			Long Quantity_To_be_Added = products.getProduct_quantity();
			Long total = product_Quantity + Quantity_To_be_Added;

			product.setProduct_quantity(total);

			Products newProduct = productRepository.save(product);

			Map<String, Products> result = new HashMap<String, Products>();
			result.put("Products Added ", newProduct);
			return new ResponseEntity<Map<String, Products>>(result, HttpStatus.OK);
		} else {
			Products newProduct = new Products();
			newProduct.setDeviceType(products.getDeviceType());
			newProduct.setProduct_quantity(products.getProduct_quantity());
			newProduct.setProducts_id(products.getProducts_id());
			newProduct.setProductDescription(products.getProductDescription());
			newProduct.setTechnologyType(products.getTechnologyType());
			newProduct.setUsers(products.getUsers());
			newProduct.setPrice(products.getPrice());
			productRepository.save(newProduct);

			Map<String, Products> result = new HashMap<String, Products>();
			result.put("Product Added", newProduct);
			return new ResponseEntity<Map<String, Products>>(result, HttpStatus.OK);
		}

	}

	public List<Products> getProducts() {
		return productRepository.findAll();

	}

	public ResponseEntity<?> updateProduct(Long productsId, @Valid Products product) {
		if (product != null) {
			Products product1 = productRepository.findOne(productsId);
			if (product1 != null) {

				product1.setProductDescription(product.getProductDescription());

				productRepository.save(product1);

				Map<String, Products> result = new HashMap<String, Products>();
				result.put("Products Updated ", product1);
				return new ResponseEntity<Map<String, Products>>(result, HttpStatus.OK);
			} else {
				Map<String, Long> result = new HashMap<String, Long>();
				result.put("not found Products with Id ", productsId);
				return new ResponseEntity<Map<String, Long>>(result, HttpStatus.NOT_FOUND);
			}
		} else {
			Map<String, String> result = new HashMap<String, String>();
			result.put("not input body ", "");
			return new ResponseEntity<Map<String, String>>(result, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> deleteProduct(Long productsId) {
		Products product1 = productRepository.findOne(productsId);
		if (product1 != null) {

			productRepository.delete(product1);

			Map<String, Long> result = new HashMap<String, Long>();
			result.put("Successfully deleted Product with Id: ", productsId);
			return new ResponseEntity<Map<String, Long>>(result, HttpStatus.OK);

		} else {
			Map<String, Long> result = new HashMap<String, Long>();
			result.put("not found product with Id ", productsId);
			return new ResponseEntity<Map<String, Long>>(result, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> getproductsById(Long productsId) {
		Products product = productRepository.findOne(productsId);

		if (product != null) {

			Map<String, Products> result = new HashMap<String, Products>();
			result.put("Product found: ", product);
			return new ResponseEntity<Map<String, Products>>(result, HttpStatus.OK);

		} else {
			Map<String, Long> result = new HashMap<String, Long>();
			result.put("not found Product with Id ", productsId);
			return new ResponseEntity<Map<String, Long>>(result, HttpStatus.NOT_FOUND);
		}
	}

}
