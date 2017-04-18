package com.trophonix.trunk.api.exceptions;

/**
 * Created by Lucas on 4/12/17.
 */
public class APIRegisterException extends Exception {

    private final String message;

    public APIRegisterException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
