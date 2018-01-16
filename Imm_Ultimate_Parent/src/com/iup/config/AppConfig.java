package com.iup.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.iup.exception.GenericException;

@Configuration
@ComponentScan(basePackages = "com.iup")
@ImportResource("classpath:applicationcontext.xml")
@PropertySource("mysql.properties")
@EnableTransactionManagement
public class AppConfig {

	@Autowired
	private Environment environment;

	private final String DBURL = "db.url";
	private final String DBUSERNAME = "db.username";
	private final String DBPASSWORD = "db.password";
	private final String DBDRIVERCLASS = "db.driverclass";

	@Bean
	public DataSource dataSource() throws GenericException {
		System.out.println("IUPConfiguration - dataSource - entered.");
		String errorMsg = "Couldn't process your transaction. Please contact your administrator.";
		try {
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName(environment.getProperty(DBDRIVERCLASS));
			// System.out.println("Property - DB URL:
			// "+environment.getProperty(DBURL));
			dataSource.setUrl(environment.getProperty(DBURL));
			dataSource.setUsername(environment.getProperty(DBUSERNAME));
			dataSource.setPassword(environment.getProperty(DBPASSWORD));
			return dataSource;
		} catch (CannotCreateTransactionException e) {
			throw new GenericException(errorMsg);
		} catch (Exception ex) {
			throw new GenericException(errorMsg);
		}
	}

	@Bean
	public JdbcTemplate jdbcTemplate() throws GenericException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		return jdbcTemplate;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean(name = "transactionManager")
	public DataSourceTransactionManager transactionMgr() throws GenericException {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource());
		transactionManager.setDefaultTimeout(60);
		return transactionManager;
	}
}
