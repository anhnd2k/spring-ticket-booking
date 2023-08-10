package com.noa.ticketbook.controllers;

import com.noa.ticketbook.entity.UsersEntity;
import com.noa.ticketbook.exception.DomainException;
import com.noa.ticketbook.exception.message.CommonMessage;
import com.noa.ticketbook.models.ResponseObject;
import com.noa.ticketbook.services.UserServices;
import com.noa.ticketbook.untils.ResponseFactoryUtils;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServices userServices;

    @GetMapping("/")
    public ResponseEntity<?> getListUser(){
        List<UsersEntity> userList = userServices.getListUser();
        return ResponseFactoryUtils.success(userList);
    }

    @PostMapping("/")
    public ResponseEntity<ResponseObject> addUser(@Validated @RequestBody UsersEntity user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Xử lý lỗi validation và trả về response chứa thông tin lỗi
            System.out.print("ccccccccccccccccc");
            return ResponseFactoryUtils.failWithDomainException(
                    new DomainException(CommonMessage.ERR_APPROVAL_PROCESS_NOT_FOUND));
        }
        userServices.saveUser(user);
        return ResponseFactoryUtils.success();
    }
}
