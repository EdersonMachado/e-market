package com.machado.ederson.emarket.service.product;

import com.machado.ederson.emarket.domain.Product;
import com.machado.ederson.emarket.exception.BusinessRuleException;
import com.machado.ederson.emarket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoveQuantityProductService {

    private static final int MINIMUM_QUANTITY = 0;

    @Autowired
    private ProductRepository repository;

    @Autowired
    private SearchProductService searchProductService;

    public void remove(Long id, int quantity) {

        Product product = searchProductService.search(id);

        boolean invalidQuantity = product.getQuantity() - quantity < MINIMUM_QUANTITY;

        if (invalidQuantity) {
            throw new BusinessRuleException("Quantidade informada superior a existente no banco");
        }

        int newQuantity = product.getQuantity() - quantity;

        product.setQuantity(newQuantity);

        repository.save(product);

    }

}
