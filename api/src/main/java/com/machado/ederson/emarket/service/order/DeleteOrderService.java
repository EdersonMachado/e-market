package com.machado.ederson.emarket.service.order;

import com.machado.ederson.emarket.domain.Order;
import com.machado.ederson.emarket.domain.User;
import com.machado.ederson.emarket.exception.BusinessRuleException;
import com.machado.ederson.emarket.repository.OrderRepository;
import com.machado.ederson.emarket.service.user.SearchUserService;
import com.machado.ederson.emarket.validator.UserOrderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteOrderService {

    @Autowired
    private SearchUserService searchUserService;

    @Autowired
    private SearchOrderService searchOrderService;

    @Autowired
    private UserOrderValidator validator;

    @Autowired
    private OrderRepository repository;

    public void delete(Long idOrder, Long idUser) {

        User user = searchUserService.search(idUser);

        Order order = searchOrderService.search(idOrder);

        validator.orderFromTheSameUser(order, user);

        repository.delete(order);

    }
}
