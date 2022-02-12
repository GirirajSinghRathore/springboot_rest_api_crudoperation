package com.example.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.model.Books;
import com.example.crud.service.BooksService;
import com.example.crud.service.impl.BooksServiceImpl;

@RestController
@RequestMapping("/bookscontroller")
public class BooksController {
	@Autowired
	private BooksServiceImpl booksService;

	@GetMapping("book")
	private List<Books> getAllBooks() {
		return booksService.getAllBooks();
	}

	@GetMapping("book/{id}")
	private Books getBooks(@PathVariable("bookid") int bookid) {
		return booksService.getBooks(bookid);
	}

	@DeleteMapping("book/{id}")
	private void deleteBook(@PathVariable("bookid") int bookid) {
		booksService.deletebooks(bookid);
	}

	@PostMapping("/books")
	private int saveBook(@RequestBody Books books) {
		booksService.saveOrUpdate(books);
		return books.getBookid();
	}

	@PutMapping("/books")
	private Books update(@RequestBody Books books) {
		booksService.saveOrUpdate(books);
		return books;
	}

}
