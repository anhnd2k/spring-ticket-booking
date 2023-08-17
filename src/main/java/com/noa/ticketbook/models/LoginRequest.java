package com.noa.ticketbook.models;

import lombok.*;

@Getter
@Setter
@ToString
@With
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    public String username;
    public String password;
}
