package br.com.mercadolivre.simian;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig{

	
	@Bean
	public Docket productApi() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())              
		        .paths(PathSelectors.any()) 
		        .build()
		        .apiInfo(this.apiInfo());
		          
		
		
	}
	
	
	 
	 private ApiInfo apiInfo() {
		 
	        ApiInfo apiInfo = new ApiInfoBuilder()
	                .title ("API de Validação de DNA dos Simons ")
	                .description ("Essa é a API de verificação do DNA .")
	                .license("Apache License Version 2.0")
	                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
	                .termsOfServiceUrl("http://swagger.io/terms/")
	                .version("1.0.0")
	                .contact(new Contact("Ingrid Mazoni","https://www.linkedin.com/in/ingridmazoni/", "ingridmazoni@outlook.com"))
	                .build();
	 
	        return apiInfo;
	    }
		
	 
		/*
		 * @Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
		 * registry.addResourceHandler("/swagger-ui/**")
		 * .addResourceLocations("classpath:/swagger-ui/");
		 * 
		 * }
		 */																									

}
