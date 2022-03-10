package com.example.crud.service;

import java.util.Optional;

import com.example.crud.model.Category;

public interface CategoryService {

	Category createCategory(Category category);

	Optional<Category> findById(long id);

	Category save(Category categoryNew);

	void deleteById(long id);
	
}
