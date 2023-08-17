package com.noa.ticketbook.controllers.authen;

import com.noa.ticketbook.entity.UsersEntity;
import com.noa.ticketbook.exception.DomainException;
import com.noa.ticketbook.models.AuthRequest;
import com.noa.ticketbook.models.AuthResponse;
import com.noa.ticketbook.repository.UserRepository;
import com.noa.ticketbook.services.UserServices;
import com.noa.ticketbook.untils.ResponseFactoryUtils;
import com.noa.ticketbook.untils.authen.JwtTokenUtil;
import com.noa.ticketbook.untils.hasErrMess.ErrDefaultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserServices userServices;


    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody @Valid AuthRequest authRequest, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return ErrDefaultMessage.ErrMessage(bindingResult, HttpStatus.BAD_REQUEST);
        }
        UsersEntity user = userRepository.findByUsername(authRequest.getUsername());
        if (user != null && passwordMatches(authRequest.getPassword(), user.getPassword())) {
            final UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    new ArrayList<>()
            );
            final String token = jwtTokenUtil.generateToken(userDetails);
            return ResponseEntity.ok(new AuthResponse(token));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUpAccount (@RequestBody @Valid UsersEntity userBody, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseFactoryUtils.failWithDomainException(
                    new DomainException(
                            "",
                            bindingResult.getFieldError().getDefaultMessage(),
                            HttpStatus.BAD_REQUEST
                    )
            );
        }
        UsersEntity user = new UsersEntity(
                userBody.getUsername(),
                encoder.encode(userBody.getPassword()),
                userBody.getEmail(),
                userBody.getEnabled() == null ? true : userBody.getEnabled()
        );
        userServices.saveUser(user);
        return ResponseFactoryUtils.success();
    }

    private boolean passwordMatches(String rawPassword, String encodedPassword) {
        return rawPassword.equals(encodedPassword);
    }
}

