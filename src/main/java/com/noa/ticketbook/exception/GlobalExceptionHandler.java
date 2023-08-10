package com.noa.ticketbook.exception;

import com.noa.ticketbook.exception.message.CommonMessage;
import com.noa.ticketbook.models.ResponseObject;
import com.noa.ticketbook.untils.ResponseFactoryUtils;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DataAccessResourceFailureException.class)
    public ResponseEntity<ResponseObject> handleDatabaseConnectionException(DataAccessResourceFailureException e) {
        // Xử lý lỗi kết nối, ví dụ: trả về phản hồi lỗi
        return ResponseFactoryUtils.failWithDomainException(new DomainException(CommonMessage.INTERNAL_SERVER_ERROR));
    }
}
