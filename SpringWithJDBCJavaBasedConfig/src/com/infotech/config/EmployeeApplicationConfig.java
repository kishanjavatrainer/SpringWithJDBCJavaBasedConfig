package com.infotech.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource(value = { "classpath:database.properties" })
@ComponentScan(basePackages={"com.infotech.service.impl","com.infotech.dao.impl"})
public class EmployeeApplicationConfig {

	@Value(value = "${db.driverClassName}")
	private String driverClassName;
	
	@Value(value = "${db.url}")
	private String url;
	
	@Value(value = "${db.username}")
	private String userName;
	
	@Value(value = "${db.password}")
	private String password;
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new  DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(userName);
		dataSource.setPassword(password);
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(){
		return new JdbcTemplate(dataSource());
	}
	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
		return new PropertySourcesPlaceholderConfigurer();
	}
	
}
