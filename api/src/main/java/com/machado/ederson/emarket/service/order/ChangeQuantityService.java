package com.machado.ederson.emarket.service.order;

import com.machado.ederson.emarket.domain.Order;
import com.machado.ederson.emarket.domain.User;
import com.machado.ederson.emarket.exception.BusinessRuleException;
import com.machado.ederson.emarket.repository.OrderRepository;
import com.machado.ederson.emarket.service.product.SearchProductService;
import com.machado.ederson.emarket.service.user.SearchUserService;
import com.machado.ederson.emarket.validator.UserOrderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChangeQuantityService {

    @Autowired
    private SearchUserService searchUserService;

    @Autowired
    private SearchOrderService searchOrderService;

    @Autowired
    private OrderRepository repository;

    @Autowired
    private UserOrderValidator validator;

    public void change(Long idOrder, int quantity, Long idUser) {

        User user = searchUserService.search(idUser);

        Order order = searchOrderService.search(idOrder);

        validator.orderFromTheSameUser(order, user);

        order.setQuantity(quantity);

        repository.save(order);

    }
}
