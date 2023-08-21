package ru.javaops.bootjava.error;

public class NotFoundException extends AppException {
    public NotFoundException(String msg) {
        super(msg);
    }
}