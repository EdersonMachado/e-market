package com.machado.ederson.emarket.service.user;

import com.machado.ederson.emarket.domain.Profile;
import com.machado.ederson.emarket.domain.User;
import com.machado.ederson.emarket.exception.BusinessRuleException;
import com.machado.ederson.emarket.mapper.UserMapper;
import com.machado.ederson.emarket.repository.UserRepository;
import com.machado.ederson.emarket.security.ProfileDecodeService;
import com.machado.ederson.emarket.web.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ProfileDecodeService profileDecodeService;

    public User register(UserRequest request) {

        boolean userRegistred = repository.existsByEmail(request.getEmail());

        if(userRegistred){
            throw new BusinessRuleException("E-mail já cadastrado");
        }

        Profile profile = profileDecodeService.decode(request.getAdministratorCredentials());

        User user = mapper.map(request, true, profile);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        repository.save(user);

        return user;
    }
}
