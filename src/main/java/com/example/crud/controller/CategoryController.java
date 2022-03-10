package com.example.crud.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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

import com.example.crud.exception.ResourceNotFoundException;
import com.example.crud.model.Category;
import com.example.crud.service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	@GetMapping("/category")
	public ResponseEntity<Page<Category>> getAllCategory(@RequestParam int pageSize,@RequestParam(required = false,defaultValue = "0") int pageNo){
		return new ResponseEntity<Page<Category>>(categoryService.findAll(pageSize,pageNo), HttpStatus.OK);
	}
	// create
	@PostMapping("/category")
	public ResponseEntity<Category> createCategory(@RequestBody Category category) {
		return new ResponseEntity<Category>(categoryService.createCategory(category), HttpStatus.CREATED);
	}

	// update
	@PutMapping("/category/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable("id") long id, @RequestBody Category category) {
		Category categoryNew = categoryService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found Category with id = " + id));

		categoryNew.setName(category.getName());

		return new ResponseEntity<>(categoryService.save(categoryNew), HttpStatus.OK);
	}

	// read
	@GetMapping("/category/{id}")
	public ResponseEntity<Category> findCategoryById(@PathVariable("id") long id) {
		Category cat = categoryService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));

		return new ResponseEntity<>(cat, HttpStatus.OK);
	}

	// delete
	@DeleteMapping("/category/{id}")
	  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		categoryService.deleteById(id);
	    
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }
}
