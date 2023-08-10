package com.noa.ticketbook.exception.message;

import org.springframework.http.HttpStatus;

public interface DomainMessage {
    String getCode();

    String getMessage();

    HttpStatus getStatusCode();
}