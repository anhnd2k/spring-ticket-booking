package com.noa.ticketbook.untils;

import com.noa.ticketbook.exception.DomainException;
import com.noa.ticketbook.exception.message.CommonMessage;
import com.noa.ticketbook.models.ResponseObject;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResponseFactoryUtils {

    public static ResponseEntity<ResponseObject> success(){
        return ResponseEntity.ok(
                new ResponseObject()
                        .withStatus(CommonMessage.SUCCESS.getStatusCode())
                        .withMessage(
                            CommonMessage.SUCCESS.getMessage()
                        )
        );
    }

    public static ResponseEntity<ResponseObject> success(Object data){
        return ResponseEntity.ok(
                new ResponseObject()
                    .withStatus(CommonMessage.SUCCESS.getStatusCode())
                    .withMessage(CommonMessage.SUCCESS.getMessage())
                    .withData(data)
        );
    }

    public static ResponseEntity<ResponseObject> failWithDomainException(DomainException e){
        return ResponseEntity.status(e.getError().getStatusCode())
                .body( new ResponseObject()
                        .withStatus(e.getError().getStatusCode())
                        .withMessage(e.getError().getMessage())
        );
    }

    public static ResponseEntity<ResponseObject> failWithDomainException(HttpStatus code, String message,
                                                                      HttpStatus statusCode) {
        return ResponseEntity.status(statusCode)
                .body(new ResponseObject().withStatus(code).withMessage(message));
    }

}
