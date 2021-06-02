package com.example.personalblog.repository;

import com.example.personalblog.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UsersRepository extends JpaRepository<Users,Integer> {
    //@Query 注解，并提供一个查询语句作为参数，Spring Data JPA 在创建代理对象时，便以提供的查询语句来实现其功能。
    @Query("from Users where email = :email")
    Users findUser(@Param("email") String email);

    @Transactional
    @Modifying
    @Query("update Users set state=:state where id = :id")
    void updateState(@Param("state") int state, @Param("id") int id);
}
