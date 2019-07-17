package com.machado.ederson.emarket.service.product;

import com.machado.ederson.emarket.domain.Product;
import com.machado.ederson.emarket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class EditPriceProductService {

    @Autowired
    private SearchProductService searchProductService;

    @Autowired
    private ProductRepository repository;

    public void edit(Long id, BigDecimal value) {

        Product product = searchProductService.search(id);

        product.setPrice(value);

        repository.save(product);

    }
}
