package com.mio.spring6.tx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mio.spring6.tx.service.BookService;
import com.mio.spring6.tx.service.CheckoutBookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private CheckoutBookService checkoutBookService;
	
	//买书方法
	public void buyBook(Integer bookId, Integer userId) {
		bookService.buyBook(bookId, userId);
	}

	//买多本书的方法
	public void buyBooks(Integer[] bookIds, Integer userId) {
		checkoutBookService.checkout(bookIds, userId);
	}
}
