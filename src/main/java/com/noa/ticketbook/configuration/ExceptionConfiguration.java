package com.noa.ticketbook.configuration;

import com.noa.ticketbook.exception.DomainException;
import com.noa.ticketbook.exception.message.CommonMessage;
import com.noa.ticketbook.models.ResponseObject;
import com.noa.ticketbook.untils.ResponseFactoryUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j //simple logging facade for java
@RestControllerAdvice
public class ExceptionConfiguration {

    @ExceptionHandler(value = DomainException.class)
    public ResponseEntity<ResponseObject> handleDomainException(DomainException exception) {
        log.error(exception.getMessage(), exception);
        return ResponseFactoryUtils.failWithDomainException(exception);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseObject> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        log.error(exception.getMessage(), exception);
        return ResponseFactoryUtils.failWithDomainException(
                new DomainException(CommonMessage.BAD_REQUEST));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ResponseObject> handleMethodNotAllowedException(
            HttpRequestMethodNotSupportedException exception) {
        log.error(exception.getMessage(), exception);
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseObject> handleHttpMessageNotReadableException(
            HttpMessageNotReadableException e) {
        log.error(e.getMessage(), e);
        return ResponseFactoryUtils.failWithDomainException(new DomainException());
    }

//  @ExceptionHandler(value = AccessDeniedException.class)
//  public ResponseEntity<ApiResponse> handleAccessDeniedException(
//      org.springframework.security.access.AccessDeniedException e) {
//    log.error(e.getMessage(), e);
//    return ResponseFactoryUtils.failWithDomainException(
//        new DomainException(CommonMessage.FORBIDDEN));
//  }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ResponseObject> handleMethodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException e) {
        Class<?> type = e.getRequiredType();
        String message = CommonMessage.BAD_REQUEST.getMessage();
        if (type != null && type.isEnum()) {
            Object[] enumConstants = type.getEnumConstants();
            List<String> enumValues = Arrays.stream(enumConstants)
                    .map(Object::toString)
                    .collect(Collectors.toList());
            String enumValuesStr = String.join(",", enumValues);
            message = "Request field [" + e.getName() + "] must have a value among : [" + enumValuesStr + "]";
        }
        log.error(message);
        return ResponseFactoryUtils.failWithDomainException(CommonMessage.BAD_REQUEST.getStatusCode(),
                message, CommonMessage.BAD_REQUEST.getStatusCode());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ResponseObject> handleException(Exception exception) {
        log.error(exception.getMessage(), exception);
        return ResponseFactoryUtils.failWithDomainException(
                new DomainException(CommonMessage.INTERNAL_SERVER_ERROR));
    }
}

