package com.noa.ticketbook.untils.hasErrMess;

import com.noa.ticketbook.exception.DomainException;
import com.noa.ticketbook.models.ResponseObject;
import com.noa.ticketbook.untils.ResponseFactoryUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

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

    public static Map<String, Object> createErrorResponse(String message) {
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("data", null);
        responseData.put("message", message);
        responseData.put("status", HttpStatus.UNAUTHORIZED.value());
        return responseData;
    }
}
