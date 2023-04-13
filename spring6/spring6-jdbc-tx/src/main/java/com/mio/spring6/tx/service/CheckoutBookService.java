package com.mio.spring6.tx.service;

public interface CheckoutBookService {
	public void checkout(Integer[] bookIds, Integer userId);
}
