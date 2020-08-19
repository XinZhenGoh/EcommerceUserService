package com.usermanagement.dao;

import com.usermanagement.dto.Role;
import com.usermanagement.dto.RoleEnumList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleEnumList name);
}
