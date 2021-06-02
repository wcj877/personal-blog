package com.example.personalblog.repository;

import com.example.personalblog.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface LabelRepository extends JpaRepository<Label, Integer> {

    void deleteByLid(int lid);

    @Modifying
    @Transactional
    @Query("update Label set labelName=:name where lid=:id")
    void updateLabel(@Param("id") int id, @Param("name") String name);

    Label findByLid(int lid);
}
