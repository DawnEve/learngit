package com.mio.spring6.jdbc;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
		int updateRows = jdbcTemplate.update(sql, "Lily", 22, "F");
		System.out.println(updateRows);
	}
	
	//另一个写法
	@Test
	public void testUpdate2() {
		//添加操作
		//1 编写sql语句
		String sql="insert into t_emp values(NULL,?,?,?)";
		
		//2 调用 JdbcTemplate 的方法，传入相关参数
		Object[] params= {"小明", 21, "M"};
		int updateRows = jdbcTemplate.update(sql, params);
		System.out.println(updateRows);
	}
	
	@Test
	public void testUpdate3() {
		//修改操作
		//1 编写sql语句
		String sql="update t_emp set name=? where id=?";
		
		//2 调用 JdbcTemplate 的方法，传入相关参数
		Object[] params= {"Tom", 2};
		int updateRows = jdbcTemplate.update(sql, params);
		System.out.println(updateRows);
	}
	
	
	@Test
	public void testUpdate4() {
		//修改操作
		//1 编写sql语句
		String sql="update t_emp set name=?, gender=? where id=?";
		
		//2 调用 JdbcTemplate 的方法，传入相关参数
		Object[] params= {"Lucy", "F", 2};
		int updateRows = jdbcTemplate.update(sql, params);
		System.out.println(updateRows);
	}
	
	@Test
	public void testUpdate5() {
		//删除操作
		//1 编写sql语句
		String sql="delete from t_emp where id=?";
		
		//2 调用 JdbcTemplate 的方法，传入相关参数
		Object[] params= {2};
		int updateRows = jdbcTemplate.update(sql, params);
		System.out.println(updateRows);
	}
	
	
	// 查询：返回对象
	@Test
	public void testSelectObj() {
		//1 编写sql语句
		String sql="select * from t_emp where id=?";
		
		//2 调用 JdbcTemplate 的方法，传入相关参数
		/* 有一个三个参数的查询函数
		 * 参数1: sql语句
		 * 参数2 RowMapper<Emp> rowMapper: 是一个封装类，根据返回结果rs，封装好返回的对象，就是查询的结果
		 * 参数3: sql语句中的未知参数赋值
		 * */
		Emp empObj = jdbcTemplate.queryForObject(sql,
				//使用java8中的lambda表达式
				//太繁琐，写着很不方便
				(rs, rowNum)->{
					System.out.println("查询结果: "+rowNum);
					Emp emp=new Emp();
					emp.setId( rs.getInt("id"));
					emp.setName( rs.getString("name"));
					emp.setAge( rs.getInt("age"));
					emp.setGender(rs.getString("gender"));
					return emp;
				},	1);
		System.out.println(empObj);
		
		//写法2: 使用Spring的封装类
		Emp empObj2 = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Emp.class), 1);
		System.out.println(empObj2);
	}
	
	
	
	//查询：返回list
	@Test
	public void testSelectList() {
		//1 编写sql语句
		String sql="select * from t_emp;";
		//2 查询
		List<Emp> list = jdbcTemplate.query(sql, 
				new BeanPropertyRowMapper<>(Emp.class));
		//3. 输出
		for(Emp emp: list) {
			System.out.println(emp);
		}
	}
	
	//查询：返回单个值
	@Test
	public void testSelectValue() {
		//1 编写sql语句
		String sql="select count(*) from t_emp;";
		//2 查询
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println("当前表的总行数: "+count);
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
