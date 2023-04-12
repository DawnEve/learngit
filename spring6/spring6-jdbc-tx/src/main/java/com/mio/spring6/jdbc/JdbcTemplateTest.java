package com.mio.spring6.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.alibaba.druid.pool.DruidDataSource;

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class JdbcTemplateTest {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	//添加、修改、删除操作：调用同一个方法
	@Test
	public void testUpdate() {
		//添加操作
		//1 编写sql语句
		String sql="insert into t_emp values(NULL,?,?,?)";
		
		//2 调用 JdbcTemplate 的方法，传入相关参数
		int updateRows = jdbcTemplate.update(sql, "小明", 20, "M");
		System.out.println(updateRows);
	}

	
	
	
	public static void main2(String[] args) {
//		demo1();
		demo2();
	}
	//使用配置文件
	private static void demo2() {
		ApplicationContext context=
				new ClassPathXmlApplicationContext("beans.xml");
		
		JdbcTemplate jdbcTemplate2 = context.getBean(JdbcTemplate.class);
		jdbcTemplate2.execute("select * from t_emp;");
		System.out.println(jdbcTemplate2);
	}

	//最原始的方式
	private static void demo1() {
		//1 创建数据源 对象
		DruidDataSource dataSource=new DruidDataSource();
//		dataSource.setUrl("jdbc:mysql://localhost:3306/spring?serverTimezone=UTC");
		dataSource.setUrl("jdbc:mysql://localhost:3306/spring?characterEncoding=utf8&useSSL=false&serverTimezone=UTC");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		//2 创建 JdbcTemplate 对象
		JdbcTemplate jdbcTemplate2=new JdbcTemplate(dataSource);
		System.out.println(jdbcTemplate2);
		//jdbcTemplate2.execute("select * from t_emp;");
		
		//3 编写sql语句
		String sql="insert into t_emp values(NULL,?,?,?)";
		
		//4 调用 JdbcTemplate 的方法，传入相关参数
		int updateRows = jdbcTemplate2.update(sql, "小明", 22, "M");
		System.out.println(updateRows);		
	}

}
