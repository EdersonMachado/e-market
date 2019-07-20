package com.machado.ederson.emarket.validator;

import com.machado.ederson.emarket.domain.Order;
import com.machado.ederson.emarket.domain.User;
import com.machado.ederson.emarket.exception.BusinessRuleException;
import org.springframework.stereotype.Component;

@Component
public class UserOrderValidator {

    public void orderFromTheSameUser(Order order, User user){

        boolean sameUser = order.getUser().equals(user);

        if (!sameUser) {
            throw new BusinessRuleException("O pedido não corresponde ao usuário");
        }

    }

}
