package com.mio.spring6.tx.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration //配置类
@ComponentScan("com.mio.spring6.tx") //开启包扫描
@EnableTransactionManagement  //开启事务管理
public class SpringConfig {
	@Bean
	public DataSource getDataSource() {
		//1 创建连接池
		DruidDataSource dataSource = new DruidDataSource();
		//设置数据源
//		dataSource.setUrl("jdbc:mysql://localhost:3306/spring?serverTimezone=UTC");
		dataSource.setUrl("jdbc:mysql://localhost:3306/spring?characterEncoding=utf8&useSSL=false&serverTimezone=UTC");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
		
	}

	@Bean(name="jdbcTemplate")
	public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		return jdbcTemplate;		
	}
	
	//事务管理器
	@Bean
	public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource) {
		DataSourceTransactionManager manager=new DataSourceTransactionManager();
		manager.setDataSource(dataSource);
		return manager;
	}
	
}
