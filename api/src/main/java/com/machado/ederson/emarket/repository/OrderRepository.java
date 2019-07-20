package com.machado.ederson.emarket.repository;

import com.machado.ederson.emarket.domain.Order;
import com.machado.ederson.emarket.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findAllByUser(User user);

}
