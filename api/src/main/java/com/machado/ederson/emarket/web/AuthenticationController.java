package com.machado.ederson.emarket.web;

import com.machado.ederson.emarket.security.AuthenticationService;
import com.machado.ederson.emarket.web.request.LoginRequest;
import com.machado.ederson.emarket.web.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/public/authentication")
public class AuthenticationController {

    @Autowired
    private AuthenticationService service;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse login(@RequestBody @Valid LoginRequest request) {

        String username = request.getEmail();
        String password = request.getPassword();

        String token = service.authenticate(username, password);

        return new LoginResponse(token);
    }

}
