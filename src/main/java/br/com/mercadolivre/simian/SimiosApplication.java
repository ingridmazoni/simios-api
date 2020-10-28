package br.com.mercadolivre.simian;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.LocaleResolver;

@SpringBootApplication
@ConfigurationProperties
@EnableTransactionManagement
@EnableJpaRepositories
public class SimiosApplication extends SpringBootServletInitializer {
		
	@Value("${spring.datasource.url}")
	private String dbUrl;
	
	  @Bean
	    public DataSource dataSource(){
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();

	        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	        dataSource.setUrl(dbUrl);
	       

	        
	        return dataSource;  
	 }

	@Bean
	public LocaleResolver localeResolver() {
	return new org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver();
	}

	@Bean
	@Primary
	public ResourceBundleMessageSource resourceBundle() {
	ResourceBundleMessageSource rb = new org.springframework.context.support.ResourceBundleMessageSource();
	rb.setBasename("messages");
	return rb;
	}


	
	
	public static void main(String[] args) {
				
		SpringApplication.run(SimiosApplication.class, args);
				
	}
	
	
	
	
	
}
