package com.mio.spring6.xmltx.dao;

public interface BookDao {

	Integer getBookPriceByBookId(Integer bookId);

	void updateStock(Integer bookId);

	void updateUserBalance(Integer userId, Integer price);

}
