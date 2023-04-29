package com.mio.spring6.xmltx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mio.spring6.xmltx.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
		
	//买书方法
	public void buyBook(Integer bookId, Integer userId) {
		bookService.buyBook(bookId, userId);
	}
}