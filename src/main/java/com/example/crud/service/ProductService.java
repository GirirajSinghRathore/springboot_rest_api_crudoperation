package com.example.crud.service;

import java.util.Optional;

import com.example.crud.model.Category;
import com.example.crud.model.Product;

public interface ProductService {

	Product createProduct(Long categoryId, Product product);

	Optional<Product> findById(Long id);

	void deleteById(long id);




}
