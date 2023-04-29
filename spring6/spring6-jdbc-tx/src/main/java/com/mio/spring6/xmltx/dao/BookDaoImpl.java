package com.mio.spring6.xmltx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	//获取价格
	@Override
	public Integer getBookPriceByBookId(Integer bookId) {
		String sql="select price from t_book where book_id=?";
		Integer price = jdbcTemplate.queryForObject(sql, Integer.class, bookId);
		return price;
	}

	//更新库存
	@Override
	public void updateStock(Integer bookId) {
		String sql="update t_book set stock=stock-1 where book_id=?";
		int rowNum = jdbcTemplate.update(sql, bookId);
		System.out.println("更新 库存 影响行数: "+rowNum);
	}

	//更新用户余额
	@Override
	public void updateUserBalance(Integer userId, Integer price) {
		String sql="update t_user set balance=balance-? where user_id=?";
		int rowNum = jdbcTemplate.update(sql, price, userId);
		System.out.println("更新 用户余额 影响行数: "+rowNum);
	}
}
