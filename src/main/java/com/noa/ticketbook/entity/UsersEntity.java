package com.noa.ticketbook.entity;

import lombok.*;

import javax.persistence.*;

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
    private String userName;
    @Column(nullable = false, length = 255)
    private String passWord;
    @Column(length = 255)
    private String email;
    private Boolean enabled;
}
