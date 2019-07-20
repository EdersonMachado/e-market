package com.machado.ederson.emarket.service.order;

import com.machado.ederson.emarket.domain.Order;
import com.machado.ederson.emarket.exception.NotFoundException;
import com.machado.ederson.emarket.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SearchOrderService {

    @Autowired
    private OrderRepository repository;

    public Order search(Long id){

        Optional<Order> order = repository.findById(id);

        return order.orElseThrow(
                () -> new NotFoundException("Pedido não encontrado"));

    }

}
