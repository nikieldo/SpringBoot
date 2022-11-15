package com.ust.student.ust.exception;

public class InvalidEmailException extends BusinessException{
    public InvalidEmailException() {
        super("invalid email format");
    }
}
