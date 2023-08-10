package com.noa.ticketbook.models;
import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ToString
@With
@AllArgsConstructor
@NoArgsConstructor
public class ResponseObject {
    private HttpStatus status;
    private String message;
    private Object data;
}

