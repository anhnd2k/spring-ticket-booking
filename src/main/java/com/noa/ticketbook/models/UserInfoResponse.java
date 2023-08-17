package com.noa.ticketbook.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@With
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoResponse {
    public Long id;
    public String email;
    public String username;
    public List roles;
}
