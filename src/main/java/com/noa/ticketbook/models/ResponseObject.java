package com.noa.ticketbook.models;
import lombok.*;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
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

