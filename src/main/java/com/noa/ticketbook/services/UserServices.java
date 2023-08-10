package com.noa.ticketbook.services;

import com.noa.ticketbook.entity.UsersEntity;
import com.noa.ticketbook.exception.DomainException;
import com.noa.ticketbook.exception.message.CommonMessage;
import com.noa.ticketbook.repository.UserRepository;
import com.noa.ticketbook.untils.ResponseFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserServices {
    @Autowired
    UserRepository userRepository;
    public List<UsersEntity> getListUser(){
        return userRepository.findAll();
    }

    public Object saveUser(UsersEntity user) {
        return userRepository.save(user);
    }
}
