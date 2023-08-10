package com.noa.ticketbook.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthoritiesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 255)
    private String authority;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsersEntity usersEntity;
}
