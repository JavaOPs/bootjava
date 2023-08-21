package ru.javaops.bootjava.error;

import org.springframework.lang.NonNull;

public class AppException extends RuntimeException {

    public AppException(@NonNull String message) {
        super(message);
    }
}
