package com.example.personalblog.repository;

import com.example.personalblog.entity.Classify;
import com.sun.tracing.dtrace.ProviderAttributes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ClassifyRepository extends JpaRepository<Classify, Integer> {

    @Modifying
    @Transactional
    void deleteByClid(int clid);


    Classify findByClid(int clid);

    @Modifying
    @Transactional
    @Query("update Classify set className=:name where clid=:id")
    void update(@Param("name") String name,@Param("id") int id);
}
