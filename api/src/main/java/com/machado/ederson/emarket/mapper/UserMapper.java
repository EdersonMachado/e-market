package com.machado.ederson.emarket.mapper;

import com.machado.ederson.emarket.domain.Perfil;
import com.machado.ederson.emarket.domain.User;
import com.machado.ederson.emarket.web.request.UserRequest;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User map(UserRequest request, boolean active, Perfil perfil){

        User response = new User();

        response.setName(request.getName());
        response.setEmail(request.getEmail());
        response.setPhotoUrl(request.getPhotoUrl());
        response.setPassword(request.getPassword());
        response.setActive(active);
        response.setPerfil(perfil);

        return response;

    }
}
