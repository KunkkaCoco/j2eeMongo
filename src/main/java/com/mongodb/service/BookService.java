package com.mongodb.service;

import java.util.List;

import com.mongodb.model.Book;

public interface BookService {

	List<Book> findBooks() throws Exception;

}
