package com.machado.ederson.emarket.service;

import com.machado.ederson.emarket.domain.Perfil;
import com.machado.ederson.emarket.domain.User;
import com.machado.ederson.emarket.exception.BusinessRuleException;
import com.machado.ederson.emarket.mapper.UserMapper;
import com.machado.ederson.emarket.repository.UserRepository;
import com.machado.ederson.emarket.web.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService {

    private static final int MINIMUM_PASSWORD_SIZE = 8;

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User register(UserRequest request) {

        boolean userRegistred = repository.existsByEmail(request.getEmail());

        if(userRegistred){
            throw new BusinessRuleException("E-mail já cadastrado");
        }

        boolean minimumValidPasswordSize = request.getPassword().length() >= MINIMUM_PASSWORD_SIZE;

        if(minimumValidPasswordSize){
            throw new BusinessRuleException("Senha não possui a quantidade minima de caracteres necessários");
        }

        User user = mapper.mapper(request, true, Perfil.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        repository.save(user);

        return user;
    }
}
