package com.workshop.handler.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String id) {
        super("O Recurso não foi encontrado! id: " + id);
    }
}
