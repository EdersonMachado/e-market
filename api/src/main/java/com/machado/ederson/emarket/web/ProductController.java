package com.machado.ederson.emarket.web;

import com.machado.ederson.emarket.service.product.*;
import com.machado.ederson.emarket.web.request.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.math.BigDecimal;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private RegisterProductService registerProductService;

    @Autowired
    private EditPriceProductService editPriceProductService;

    @Autowired
    private AddQuantityProductService addQuantityProductService;

    @Autowired
    private RemoveQuantityProductService removeQuantityProductService;

    @Autowired
    private DeleteProductService deleteProductService;

    @PostMapping("/register")
    @RolesAllowed({ "ROLE_ADMIN" })
    @ResponseStatus(HttpStatus.OK)
    public void register(@RequestBody ProductRequest request){

        registerProductService.register(request);

    }

    @PutMapping("/price/{id}/{value}")
    @RolesAllowed({ "ROLE_ADMIN" })
    @ResponseStatus(HttpStatus.OK)
    public void editPrice(@PathVariable("id") Long id,
                          @PathVariable("value") BigDecimal value){

      editPriceProductService.edit(id, value);

    }

    @PutMapping("/add/{id}/{quantity}")
    @RolesAllowed({ "ROLE_ADMIN" })
    @ResponseStatus(HttpStatus.OK)
    public void addQuantity(@PathVariable("id") Long id, @PathVariable("quantity") int quantity){

        addQuantityProductService.add(id, quantity);

    }

    @PutMapping("/remove/{id}/{quantity}")
    @RolesAllowed({ "ROLE_ADMIN" })
    @ResponseStatus(HttpStatus.OK)
    public void removeQuantity(@PathVariable("id") Long id, @PathVariable("quantity") int quantity){

        removeQuantityProductService.remove(id, quantity);

    }

    @DeleteMapping("/{id}")
    @RolesAllowed({ "ROLE_ADMIN" })
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id){

        deleteProductService.delete(id);

    }

}
