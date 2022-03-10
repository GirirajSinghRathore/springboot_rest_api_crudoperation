package com.example.crud.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.exception.ResourceNotFoundException;
import com.example.crud.model.Category;
import com.example.crud.model.Product;
import com.example.crud.repository.CategoryRepository;
import com.example.crud.repository.ProductRepository;
import com.example.crud.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;


	@Override
	public Product createProduct(Long categoryId, Product product) {
		return categoryRepository.findById(categoryId).map(c -> {
			product.setCategory(c);
		      return productRepository.save(product);
		    }).orElseThrow(() -> new ResourceNotFoundException("Not found Category with id = " + categoryId));

	}


	@Override
	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);
	}


	@Override
	public void deleteById(long id) {
		productRepository.deleteById(id);
		
	}
}
