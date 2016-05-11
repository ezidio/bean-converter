package br.com.tavares.el.converter.exception;

/**
 * Exception thrown on convert process
 */
public class BeanConverterException extends Exception {
    public BeanConverterException(Throwable e) {
        super(e);
    }

    public BeanConverterException(String message) {
        super(message);
    }
}
