package com.machado.ederson.emarket.repository;

import com.machado.ederson.emarket.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByEmail(String username);

    boolean existsByEmail(String email);

}
