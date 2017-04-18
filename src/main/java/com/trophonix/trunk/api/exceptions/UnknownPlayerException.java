package com.trophonix.trunk.api.exceptions;

/**
 * Created by Lucas on 4/13/17.
 */
public class UnknownPlayerException extends Exception {

    private final String name;

    public UnknownPlayerException(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
