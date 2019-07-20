package com.machado.ederson.emarket.service.order;

import com.machado.ederson.emarket.domain.Order;
import com.machado.ederson.emarket.domain.Product;
import com.machado.ederson.emarket.domain.User;
import com.machado.ederson.emarket.repository.OrderRepository;
import com.machado.ederson.emarket.service.product.SearchProductService;
import com.machado.ederson.emarket.service.user.SearchUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddOrderService {

    @Autowired
    private SearchProductService searchProductService;

    @Autowired
    private SearchUserService searchUserService;

    @Autowired
    private OrderRepository repository;

    public void add(Long idProduct, int quantity, Long idUser) {

        Product product = searchProductService.search(idProduct);

        User user = searchUserService.search(idUser);

        Order order = new Order();

        order.setUser(user);
        order.setProduct(product);
        order.setQuantity(quantity);

        repository.save(order);

    }
}
