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
    public UsersEntity(String username, String password, String email, Boolean enabled) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.enabled = enabled;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 255)
    @NotNull(message = "Tên đăng nhập không được để trống!")
    private String username;
    @Column(nullable = false, length = 255)
    @NotNull(message = "Mật khẩu không được để trống!")
    private String password;
    @Column(length = 255)
    private String email;
    private Boolean enabled;
}
