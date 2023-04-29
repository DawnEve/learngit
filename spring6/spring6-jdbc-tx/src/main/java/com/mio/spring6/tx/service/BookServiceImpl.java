package com.mio.spring6.tx.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mio.spring6.tx.dao.BookDao;

//事务支持
//@Transactional(readOnly = true)
//@Transactional(timeout = 3)
//@Transactional(noRollbackFor = ArithmeticException.class) 
	//或使用全类名 noRollbackForClassName="java.lang.ArithmeticException"
//@Transactional(isolation = Isolation.SERIALIZABLE) 
//@Transactional(propagation = Propagation.REQUIRED) //使用前一个的事务，如果没有则新建一个
@Transactional(propagation = Propagation.REQUIRES_NEW) //不管前面有没有事务，每次都自己新建一个事务；和前面事务没有嵌套关系；前面事务挂起
@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDao bookDao;

	//买书的过程
	@Override
	public void buyBook(Integer bookId, Integer userId) {
		//TODO 模拟超时效果
//		try {
//			TimeUnit.SECONDS.sleep(5);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		//1 根据图书id查看图书价格
		Integer price=bookDao.getBookPriceByBookId(bookId);
		
		//2 更新图书库存量 -1
		bookDao.updateStock(bookId);
		
		//3 更新用户余额：-图书价格
		bookDao.updateUserBalance(userId, price);
		
		
		
		//添加一个不回滚的异常
		//System.out.println(1/0);
	}
}
