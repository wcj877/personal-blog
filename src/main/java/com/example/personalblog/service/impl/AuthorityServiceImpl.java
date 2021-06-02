package com.example.personalblog.service.impl;

import com.example.personalblog.entity.Authority;
import com.example.personalblog.repository.AuthorityRepository;
import com.example.personalblog.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    AuthorityRepository authorityRepository;

    @Override
    public void save(Authority authority) {
        authorityRepository.save(authority);
    }

    @Override
    public List<Authority> findAuthority(String email) {
//        return authorityRepository.findAllByEmail(email);
        return null;
    }
}
