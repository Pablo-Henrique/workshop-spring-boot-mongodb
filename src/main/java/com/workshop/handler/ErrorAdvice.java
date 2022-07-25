package com.workshop.handler;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Data
@AllArgsConstructor
public class ErrorAdvice implements Serializable {

    @Serial
    private static final long serialVersionUID = -8036968508091746352L;

    private Instant timestamp;
    private String path;
    private Integer statusCode;
    private String exception;
    private String message;

}
