package com.example.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.exception.ResourceNotFoundException;
import com.example.crud.model.Category;
import com.example.crud.model.Product;
import com.example.crud.service.CategoryService;
import com.example.crud.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	private ProductService productService;

	// create
	@PostMapping("/category/{categoryId}/product")
	public ResponseEntity<Product> createProduct(@PathVariable(value = "categoryId") Long categoryId,
			@RequestBody Product product) {

		return new ResponseEntity<>(productService.createProduct(categoryId, product), HttpStatus.CREATED);

	}

	// read

	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long id) {
		Product p = productService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found Product with id = " + id));

		return new ResponseEntity<>(p, HttpStatus.OK);
	}

	
	// delete
	@DeleteMapping("/product/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		productService.deleteById(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
