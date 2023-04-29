package com.mio.spring6.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CheckoutBookServiceImpl implements CheckoutBookService {
	
	@Autowired
	private BookService bookService;
	
	//买多本书的方法
	@Transactional
	@Override
	public void checkout(Integer[] bookIds, Integer userId) {
		for(Integer bookId : bookIds) {
			//调用 service 方法
			bookService.buyBook(bookId, userId);
		}
	}
}
