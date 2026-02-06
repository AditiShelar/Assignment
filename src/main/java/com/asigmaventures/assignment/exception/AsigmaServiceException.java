package com.asigmaventures.assignment.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.util.Map;

@Getter
public class AsigmaServiceException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -6907996719611457114L;
    HttpStatus statusCode= HttpStatus.BAD_REQUEST;

    private String code;
    private String fallbackMessage;
    private String[] args;

    private Map<String,String> intErrors;

    public AsigmaServiceException(String message){
        super(message);
    }
    public AsigmaServiceException(String code, String message){
        this(message);
        this.code = code;
    }

    public AsigmaServiceException(ErrorMessageEnum error) {
        this(error.getCode(), error.getMessage());
        this.statusCode = HttpStatus.valueOf(Integer.parseInt(error.getHttpCode()));
    }

    public AsigmaServiceException(String code, String message, String[] args, Map<String,String> intErrors, String fallbackMessage, Throwable th){
        super(message,th);
        this.code = code;
        this.args = args;
        this.intErrors = intErrors;
        this.fallbackMessage = fallbackMessage;
    }

}
