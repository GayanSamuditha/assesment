package com.demo.api.exceptions;

/**
 * @author Gayan Samuditha
 * @created 12/09/2020 - 1:35 PM
 */
public class ItemServiceException extends Exception {

    private static final long serialVersionUID = -470180507998010368L;

    public ItemServiceException() {
        super();
    }

    public ItemServiceException(final String message) {
        super(message);

    }


}
