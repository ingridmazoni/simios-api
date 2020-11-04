package br.com.mercadolivre.simian.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.ConstraintViolation;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import br.com.mercadolivre.simian.exception.ApiErrorException;

@ControllerAdvice
@RestController
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	  @ExceptionHandler({ ConstraintViolationException.class }) public
	  ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) { 
		 
		  ApiErrorException apiError = new ApiErrorException(HttpStatus.BAD_REQUEST,  ex.getCause().getLocalizedMessage() ,
				  null , null); 
	  return new  ResponseEntity<Object>( apiError, apiError.getStatus());
	  
	  }
	  
	
	  
}
