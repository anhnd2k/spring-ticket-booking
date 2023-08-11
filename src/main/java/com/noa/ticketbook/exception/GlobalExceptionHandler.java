package com.noa.ticketbook.exception;

import com.noa.ticketbook.exception.message.CommonMessage;
import com.noa.ticketbook.models.ResponseObject;
import com.noa.ticketbook.untils.ResponseFactoryUtils;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(DataAccessResourceFailureException.class)
    public ResponseEntity<ResponseObject> handleDatabaseConnectionException(DataAccessResourceFailureException e) {
        return ResponseFactoryUtils.failWithDomainException(new DomainException(CommonMessage.INTERNAL_SERVER_ERROR));
    }

    // exception not connect to db
    @ExceptionHandler(SQLException.class)
    @ResponseBody
    public ResponseEntity<ResponseObject> handleSQLException(SQLException ex) {
        return ResponseFactoryUtils.failWithDomainException(new DomainException(CommonMessage.INTERNAL_SERVER_ERROR));
    }

//    @ExceptionHandler
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity<ResponseObject> handleValidationExceptions(MethodArgumentNotValidException ex) {
//        BindingResult result = ex.getBindingResult();
//        String errorMessage = result.getFieldErrors().stream()
//                .map(fieldError -> fieldError.getDefaultMessage())
//                .findFirst()
//                .orElse("Lỗi không xác định");
//        return ResponseFactoryUtils.failWithDomainException(new DomainException(
//                "",
//                errorMessage,
//                HttpStatus.BAD_REQUEST
//        ));
//    }
}
