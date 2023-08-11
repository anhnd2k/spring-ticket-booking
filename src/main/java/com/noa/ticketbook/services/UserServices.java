package com.noa.ticketbook.services;

import com.noa.ticketbook.entity.UsersEntity;
import com.noa.ticketbook.exception.DomainException;
import com.noa.ticketbook.exception.message.CommonMessage;
import com.noa.ticketbook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    UserRepository userRepository;
    public List<UsersEntity> getListUser(){
        return userRepository.findAll();
    }

    public UsersEntity saveUser(UsersEntity user) {
        return userRepository.save(user);
    }

    public UsersEntity getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new DomainException(
                        "",
                        "Người dùng không tồn tại",
                        HttpStatus.BAD_REQUEST
                ));
    }
    public UsersEntity updateUser(UsersEntity updatedUser) {
        // Update user properties based on updatedUser
        return userRepository.save(updatedUser);
    }

    public void deleteUserById(Long userId){
        userRepository.deleteById(userId);
    }
}
