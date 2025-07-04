package com.bytehistory.services.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("Milestone not found");
    }
}
