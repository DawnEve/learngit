package com.mio.spring6.tx;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.mio.spring6.tx.controller.BookController;

@SpringJUnitConfig(locations = "classpath:beans-annotx.xml")
public class TestBookTx {
	
	@Autowired
	private BookController bookController;
	
	@Test
	public void testBook1() {
		bookController.buyBook(1, 1);
//		bookController.buyBook(2, 2);
		System.out.println("买书 结束");
	}
	
	@Test
	public void testCheckout() {
		Integer[] bookIds= {1,2};
		bookController.buyBooks(bookIds, 1);
		//uid=1的用户余额 550 元，要买书 book1 80元(库存5)，book2 500元(库存40)。
		System.out.println("买多本书 结束");
	}
}
