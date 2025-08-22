package com.workshop_spring_boot_mongodb.workshop.services.exception;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(String msg) {
        super(msg);
    }
}
