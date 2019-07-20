package com.machado.ederson.emarket.service.order;

import com.machado.ederson.emarket.domain.Order;
import com.machado.ederson.emarket.domain.User;
import com.machado.ederson.emarket.repository.OrderRepository;
import com.machado.ederson.emarket.repository.ProductRepository;
import com.machado.ederson.emarket.service.product.SearchProductService;
import com.machado.ederson.emarket.service.user.SearchUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinishOrderService {

    @Autowired
    private SearchUserService searchUserService;

    @Autowired
    private SearchProductService searchProductService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    public void finish(Long idUser) {

        User user = searchUserService.search(idUser);

        List<Order> cart = orderRepository.findAllByUser(user);

    }
}
