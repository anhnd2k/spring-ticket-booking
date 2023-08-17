package com.noa.ticketbook.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users"
//        uniqueConstraints = {
//                @UniqueConstraint(columnNames = "userName"),
//                @UniqueConstraint(columnNames = "email")
//        }
)
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
    private String username;
    @Column(nullable = false, length = 255)
    @NotNull(message = "Mật khẩu không được để trống!")
    private String password;
    @Column(length = 255)
    private String email;
    private Boolean enabled;

    public UsersEntity(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles = new HashSet<>();
}
