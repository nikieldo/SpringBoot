package com.ust.student.ust.exception;

public class BusinessException extends RuntimeException {
    public BusinessException(String invalid_email_format) {
        super(invalid_email_format);
    }
}
