package br.com.mercadolivre.simian.exception;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiErrorException extends Exception {
    
	 /**
	 * 
	 */
	private static final long serialVersionUID = 625797497908490710L;
		private Throwable cause;
		private HttpStatus status;
	    private String message;
	    private List<String> errors;
	    private StackTraceElement[] stackTrace;
	   
	    

	    public ApiErrorException(HttpStatus status, String message,StackTraceElement[] stackTrace, Throwable cause ) {
	        super();
	        this.status = status;
	        this.message = message;
	        this.cause = cause;
	        this.stackTrace = stackTrace;
	    }

	    public ApiErrorException(HttpStatus status, String message, String error) {
	        super();
	        this.status = status;
	        this.message = message;
	        errors = Arrays.asList(error);
	    }

		public HttpStatus getStatus() {
			return status;
		}

		public void setStatus(HttpStatus status) {
			this.status = status;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public List<String> getErrors() {
			return errors;
		}

		public void setErrors(List<String> errors) {
			this.errors = errors;
		}

		public StackTraceElement[] getStackTrace() {
			return stackTrace;
		}

		public void setStackTrace(StackTraceElement[] stackTrace) {
			this.stackTrace = stackTrace;
		}

		public Throwable getCause() {
			return cause;
		}

		public void setCause(Throwable cause) {
			this.cause = cause;
		}

		
		
		

		
	    
	    
}