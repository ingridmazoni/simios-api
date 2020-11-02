package br.com.mercadolivre.simian.controller;
  
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
  

  @Configuration
  public class HomeController implements WebMvcConfigurer {
  
	  @Override
	    public void addViewControllers(ViewControllerRegistry registry) {
	        registry.addViewController("/").setViewName("forward:/index.html");
	    }


  
  }
 
