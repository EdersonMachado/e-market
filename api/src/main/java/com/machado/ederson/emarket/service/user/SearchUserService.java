package com.machado.ederson.emarket.service.user;

import com.machado.ederson.emarket.domain.User;
import com.machado.ederson.emarket.exception.NotFoundException;
import com.machado.ederson.emarket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SearchUserService {

    @Autowired
    private UserRepository repository;

    public User search(Long id){

        Optional<User> user = repository.findById(id);

        return user.orElseThrow(
                () -> new NotFoundException("Usuário não encontrado"));

    }

}
