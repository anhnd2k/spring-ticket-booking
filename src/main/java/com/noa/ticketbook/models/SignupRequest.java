package com.noa.ticketbook.models;

import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@With
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {
    private String username;
    private String email;
    private String password;
    private Set<String> roles;
}
