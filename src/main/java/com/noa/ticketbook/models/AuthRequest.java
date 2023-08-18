package com.noa.ticketbook.models;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@With
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {
    @NotNull(message = "Tên đăng nhập không được để trống!")
    @Size(min = 1, message = "Tên đăng nhập không được để trống!")
    private String username;
    @NotNull(message = "Mật khẩu không được để trống!")
    @Size(min = 1, message = "Mật khẩu không được để trống!")
    private String password;

    // Getters and setters
}

