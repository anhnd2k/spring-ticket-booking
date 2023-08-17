package com.noa.ticketbook.untils.hasErrMess;

import com.noa.ticketbook.exception.DomainException;
import com.noa.ticketbook.models.ResponseObject;
import com.noa.ticketbook.untils.ResponseFactoryUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public class ErrDefaultMessage {


    public static ResponseEntity<ResponseObject> ErrMessage(BindingResult bindingResult, HttpStatus status) {
        return ResponseFactoryUtils.failWithDomainException(
                new DomainException(
                        "",
                        bindingResult.getFieldError().getDefaultMessage(),
                        status
                )
        );
    }
}
