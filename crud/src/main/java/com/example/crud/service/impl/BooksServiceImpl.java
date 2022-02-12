package com.example.crud.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.model.Books;
import com.example.crud.repository.BooksRepository;
import com.example.crud.service.BooksService;
@Service
public class BooksServiceImpl implements BooksService{
	@Autowired
	private BooksRepository booksRepository;
	@Override
	public List<Books> getAllBooks() {
		List<Books> list = new ArrayList<>();
		booksRepository.findAll().forEach(a -> list.add(a));
		return list;
	}

	@Override
	public Books getBooks(int bookid) {
		return booksRepository.findById(bookid).get();
	}

	@Override
	public void deletebooks(int bookid) {
		// TODO Auto-generated method stub
		booksRepository.deleteById(bookid);
	}

	@Override
	public void saveOrUpdate(Books books) {
		// TODO Auto-generated method stub
		booksRepository.save(books);
	}

}
