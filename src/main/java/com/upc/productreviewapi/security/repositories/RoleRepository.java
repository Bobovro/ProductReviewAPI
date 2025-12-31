package com.upc.productreviewapi.security.repositories;

import com.upc.productreviewapi.security.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
