package com.ojs.ordemservico.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class ResourceForbidenException extends Exception {
    private static final long serialVersionUID = 1L;

    public ResourceForbidenException(String message) {
        super(message);
    }
}
