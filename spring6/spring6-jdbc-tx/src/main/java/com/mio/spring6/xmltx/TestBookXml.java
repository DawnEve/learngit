package com.mio.spring6.xmltx;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.mio.spring6.xmltx.controller.BookController;

@SpringJUnitConfig(locations = "classpath:beans-xmltx.xml")
public class TestBookXml {
	
	@Autowired
	private BookController bookController;
	
	@Test
	public void testBook1() {
//		bookController.buyBook(1, 1);
		bookController.buyBook(2, 2);
		System.out.println("买书 结束");
	}
	
}