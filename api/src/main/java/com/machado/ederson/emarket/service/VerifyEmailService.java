package com.machado.ederson.emarket.service;

import com.machado.ederson.emarket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerifyEmailService {

    @Autowired
    private UserRepository repository;

    public boolean verify(String email) {
        return repository.existsByEmail(email);
    }

}
