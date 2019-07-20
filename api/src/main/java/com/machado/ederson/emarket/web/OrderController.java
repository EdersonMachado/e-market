package com.machado.ederson.emarket.web;

import com.machado.ederson.emarket.security.UserPrincipal;
import com.machado.ederson.emarket.service.order.AddOrderService;
import com.machado.ederson.emarket.service.order.ChangeQuantityService;
import com.machado.ederson.emarket.service.order.DeleteOrderService;
import com.machado.ederson.emarket.service.order.FinishOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private AddOrderService addOrderService;

    @Autowired
    private ChangeQuantityService changeQuantityService;

    @Autowired
    private DeleteOrderService deleteOrderService;

    @Autowired
    private FinishOrderService finishOrderService;

    @PostMapping("/{id}/{quantity}")
    @RolesAllowed({ "ROLE_USER" })
    @ResponseStatus(HttpStatus.OK)
    public void add(@PathVariable("id") Long id, @PathVariable("quantity") int quantity,
                    @AuthenticationPrincipal UserPrincipal currentUser){

        addOrderService.add(id, quantity, currentUser.getId());

    }

    @PostMapping("/quantity/{id}/{quantity}")
    @RolesAllowed({ "ROLE_USER" })
    @ResponseStatus(HttpStatus.OK)
    public void changeQuantity(@PathVariable("id") Long id, @PathVariable("quantity") int quantity,
                    @AuthenticationPrincipal UserPrincipal currentUser){

        changeQuantityService.change(id, quantity, currentUser.getId());

    }

    @DeleteMapping("/{id}")
    @RolesAllowed({ "ROLE_USER" })
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id,
                       @AuthenticationPrincipal UserPrincipal currentUser){

        deleteOrderService.delete(id, currentUser.getId());

    }

    @PutMapping
    @RolesAllowed( {"ROLE_USER"} )
    @ResponseStatus(HttpStatus.OK)
    public void finish(@AuthenticationPrincipal UserPrincipal currentUser){

        finishOrderService.finish(currentUser.getId());

    }

}
