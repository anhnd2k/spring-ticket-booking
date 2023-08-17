package com.noa.ticketbook.repository;

import com.noa.ticketbook.entity.RoleEntity;
import com.noa.ticketbook.models.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByName(ERole name);
}
