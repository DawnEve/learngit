package com.mio.spring6.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mio.spring6.tx.dao.BookDao;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDao bookDao;

	//买书的过程
	@Override
	public void buyBook(Integer bookId, Integer userId) {
		//1 根据图书id查看图书价格
		Integer price=bookDao.getBookPriceByBookId(bookId);
		
		//2 更新图书库存量 -1
		bookDao.updateStock(bookId);
		
		//3 更新用户余额：-图书价格
		bookDao.updateUserBalance(userId, price);
	}
}
