package com.mio.spring6.tx;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mio.spring6.tx.config.SpringConfig;
import com.mio.spring6.tx.controller.BookController;

public class TestAnnoTx {

	@Test
	public void test02() {
		ApplicationContext context=
				new AnnotationConfigApplicationContext(SpringConfig.class);
		BookController bookController = context.getBean(BookController.class);
		bookController.buyBook(1, 2);
		System.out.println("买书 结束");
	}
}
