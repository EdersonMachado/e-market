package com.machado.ederson.emarket.service.product;

import com.machado.ederson.emarket.domain.Product;
import com.machado.ederson.emarket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddQuantityProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private SearchProductService searchProductService;

    public void add(Long id, int quantity) {

        Product product = searchProductService.search(id);

        int newQuantity = product.getQuantity() + quantity;

        product.setQuantity(newQuantity);

        repository.save(product);

    }
}
