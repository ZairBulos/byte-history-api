package com.bytehistory.services.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("Tech milestone for today not found");
    }
}
