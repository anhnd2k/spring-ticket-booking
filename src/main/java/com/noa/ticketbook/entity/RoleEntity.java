package com.noa.ticketbook.entity;

import com.noa.ticketbook.models.ERole;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class RoleEntity {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO.IDENTITY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;
}
