package br.com.mercadolivre.simian;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.standard.processor.AbstractStandardAssertionTagProcessor;

@SpringBootApplication
@ConfigurationProperties
@EnableTransactionManagement
@EnableJpaRepositories
@ComponentScan(basePackageClasses = SwaggerConfig.class)
public class SimiosApplication extends SpringBootServletInitializer {
		
	  
	  @Bean
	  @Profile("prod")
	    public DataSource dataSource( @Value("${spring.datasource.url}") String dbUrl){
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        
	        dataSource.setDriverClassName("org.postgresql.Driver");
	        dataSource.setUrl(dbUrl);
	       

	     return dataSource;  
	 }
		
		  @Bean(name = "h2DataSource") 
		  @Profile("test")
		  public DataSource dataSourceh2(@Value("${spring.datasource.url}") String dbUrl){
			  	DriverManagerDataSource dataSource = new DriverManagerDataSource();
		  
			  	dataSource.setDriverClassName("org.h2.Driver");
				dataSource.setUrl(dbUrl); 
				dataSource.setPassword("");
				dataSource.setUsername("sa");
		
				
				
		  
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
	
	
	  @Override
	  protected SpringApplicationBuilder configure(
	       SpringApplicationBuilder builder) {
	         return builder.sources(SimiosApplication.class);
	  }
	
	
	
}
