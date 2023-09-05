package com.eazyschool.repository;

import com.eazyschool.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Role, Integer> {

    Role getByRoleName(String roleName);
}
