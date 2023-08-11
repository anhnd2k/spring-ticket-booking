package com.noa.ticketbook.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 255)
    @NotNull(message = "Tên đăng nhập không được để trống!")
    private String userName;
    @Column(nullable = false, length = 255)
    @NotNull(message = "Mật khẩu không được để trống!")
    private String passWord;
    @Column(length = 255)
    private String email;
    private Boolean enabled;
}
