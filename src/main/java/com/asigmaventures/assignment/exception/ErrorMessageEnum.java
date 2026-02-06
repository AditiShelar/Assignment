package com.asigmaventures.assignment.exception;

import lombok.Getter;

@Getter
public enum ErrorMessageEnum {

    RECORD_NOT_FOUND("404", "ERR_ASG_00251", "Record Not Found"),;
    private final String httpCode;

    private final String code;

    private final String message;

    ErrorMessageEnum(String httpCode, String code, String message) {
        this.httpCode = httpCode;
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return httpCode + ": " + code + ": " + message;
    }
}
