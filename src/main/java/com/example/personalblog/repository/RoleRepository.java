package com.example.personalblog.repository;

import com.example.personalblog.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query("from Role where roleName = :roleName")
    Role getRoleByRoleName(@Param("roleName") String roleName);
}
