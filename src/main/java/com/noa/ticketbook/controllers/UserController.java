package com.noa.ticketbook.controllers;

import com.noa.ticketbook.entity.UsersEntity;
import com.noa.ticketbook.exception.DomainException;
import com.noa.ticketbook.exception.message.CommonMessage;
import com.noa.ticketbook.models.ResponseObject;
import com.noa.ticketbook.services.UserServices;
import com.noa.ticketbook.untils.ResponseFactoryUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
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
    public ResponseEntity<ResponseObject> addUser(@RequestBody @Valid UsersEntity user, BindingResult bindingResult) {
        // handle err valid userName, passWord null.
        if (bindingResult.hasErrors()) {
            return ResponseFactoryUtils.failWithDomainException(new DomainException(
                    "",
                    bindingResult.getFieldError().getDefaultMessage(),
                    HttpStatus.BAD_REQUEST
            ));
        }
        if (user.getEnabled() == null) {
            user.setEnabled(true);
        }
        userServices.saveUser(user);
        return ResponseFactoryUtils.success();
    }

    @PutMapping("/{userId}")
    public ResponseEntity<ResponseObject> updateUser(
            @PathVariable Long userId,
            @RequestBody @Valid UsersEntity updatedUser,
            BindingResult bindingResult
            ) {
        UsersEntity userFind = userServices.getUserById(userId);
        if (bindingResult.hasErrors()) {
            return ResponseFactoryUtils.failWithDomainException(new DomainException(
                    "",
                    bindingResult.getFieldError().getDefaultMessage(),
                    HttpStatus.BAD_REQUEST
            ));
        }
        updatedUser.setId(userId);
        if(updatedUser.getEmail() == null && userFind.getEmail() != null){
            updatedUser.setEmail(userFind.getEmail());
        }
        if (updatedUser.getEnabled() == null) {
            updatedUser.setEnabled(true);
        }
        UsersEntity updatedUserData = userServices.updateUser(updatedUser);
        return ResponseFactoryUtils.success(updatedUserData);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ResponseObject> deleteUserById(@PathVariable Long userId) {
        UsersEntity user = userServices.getUserById(userId);
        userServices.deleteUserById(user.getId());
        return ResponseFactoryUtils.success();
    }
}
