package com.example.personalblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.personalblog.entity.Authority;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

    @Query("from Authority where email = :email")
    List<Authority> findAllByEmail(@Param("email") String email);

}
