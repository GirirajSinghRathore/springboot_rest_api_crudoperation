package com.example.crud.service;

import java.util.List;

import com.example.crud.model.Books;

public interface BooksService {
	List<Books> getAllBooks();

	Books getBooks(int bookid);

	void deletebooks(int bookid);

	void saveOrUpdate(Books books);
	
	
}
