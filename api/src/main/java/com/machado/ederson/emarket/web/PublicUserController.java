package com.machado.ederson.emarket.web;

import com.machado.ederson.emarket.domain.User;
import com.machado.ederson.emarket.service.RegisterUserService;
import com.machado.ederson.emarket.web.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/public/users")
public class PublicUserController {

    @Autowired
    private RegisterUserService registerUserService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User register(@Valid @RequestBody UserRequest request){
        return registerUserService.register(request);
    }

}
