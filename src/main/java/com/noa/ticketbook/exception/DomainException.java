package com.noa.ticketbook.exception;

import com.noa.ticketbook.exception.message.CommonMessage;
import com.noa.ticketbook.exception.message.DomainMessage;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DomainException extends RuntimeException{

    private static final long serialVersionUID = 2376491613927254481L;

    //  @Transient
    private final transient DomainMessage error;

    private List<Object> args = new ArrayList<>();

    public DomainException() {
        this.error = CommonMessage.INTERNAL_SERVER_ERROR;
    }

    public DomainException(String message) {
        super(message);
        this.error = CommonMessage.INTERNAL_SERVER_ERROR;
    }

    public DomainException(String code, String message, HttpStatus status) {
        this(code, message, status, new ArrayList<>());
    }

    public DomainException(String code, String message, HttpStatus status, List<Object> args) {
        super(message);
        this.error = new DomainMessage() {
            @Override
            public HttpStatus getStatusCode() {
                return status;
            }

            @Override
            public String getCode() {
                return code;
            }

            @Override
            public String getMessage() {
                return message;
            }
        };
        this.args = args;
    }

    public DomainException(DomainMessage error) {
        this(error, new ArrayList<>());
    }

    public DomainException(DomainMessage error, List<Object> args) {
        super(error.getMessage());
        this.error = error;
        this.args = args;
    }
}
