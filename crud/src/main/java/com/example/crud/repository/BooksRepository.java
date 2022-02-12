package com.example.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.crud.model.Books;
public interface BooksRepository extends CrudRepository<Books, Integer> {

}
