package com.demo.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Gayan Samuditha
 */


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{

    private static final long serialVersionUID = -9079454849611061074L;

    public ResourceNotFoundException() {

        super();
    }

    public ResourceNotFoundException(final String message) {

        super(message);
    }
}
