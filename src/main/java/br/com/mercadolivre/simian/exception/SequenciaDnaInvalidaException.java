package br.com.mercadolivre.simian.exception;

public class SequenciaDnaInvalidaException extends Exception {
    
    private static final long serialVersionUID = 1149241039409861914L;


    public SequenciaDnaInvalidaException(String msg){
        super(msg);
    }

  
    public SequenciaDnaInvalidaException(String msg, Throwable cause){
        super(msg, cause);
    }
}