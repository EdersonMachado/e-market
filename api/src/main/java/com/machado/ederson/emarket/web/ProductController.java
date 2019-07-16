package com.machado.ederson.emarket.web;

import com.machado.ederson.emarket.service.RegisterProductService;
import com.machado.ederson.emarket.web.request.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private RegisterProductService registerProductService;

    @PostMapping("/register")
    @RolesAllowed({ "ROLE_ADMIN" })
    @ResponseStatus(HttpStatus.OK)
    public void registerProduct(@RequestBody ProductRequest request){

        registerProductService.register(request);

    }

}
