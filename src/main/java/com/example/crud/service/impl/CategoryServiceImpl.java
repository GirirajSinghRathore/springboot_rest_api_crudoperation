package com.example.crud.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.model.Category;
import com.example.crud.repository.CategoryRepository;
import com.example.crud.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Optional<Category> findById(long id) {
		return categoryRepository.findById(id);
	}

	@Override
	public Category save(Category categoryNew) {
		return categoryRepository.save(categoryNew);
	}

	@Override
	public void deleteById(long id) {
		categoryRepository.deleteById(id);
	}

}
