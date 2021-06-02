package com.example.personalblog.service;

import com.example.personalblog.entity.Authority;
import com.example.personalblog.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface AuthorityService {

    void save(Authority authority);

    List<Authority> findAuthority(String email);

}
