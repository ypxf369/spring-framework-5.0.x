package com.yp;

import com.yp.spring_mybatis.annotation.MyMapperScan;
import com.yp.spring_mybatis.spring.MyImportBeanDefinitionRegistrar;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by yepeng on 2019/03/20.
 */
@ComponentScan(value = "com.yp")
@Configuration
@MyMapperScan(packageName = "com.yp.spring_mybatis.dao.mapper")
public class AppConfig {

	/**
	 * 数据源配置
	 */
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("123456");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=true");
		return driverManagerDataSource;
	}

	/**
	 * SqlSessionFactory的实例化
	 */
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		return sqlSessionFactoryBean;
	}
}
