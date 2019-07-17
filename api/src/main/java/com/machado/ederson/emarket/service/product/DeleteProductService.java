package com.machado.ederson.emarket.service.product;

import com.machado.ederson.emarket.domain.Product;
import com.machado.ederson.emarket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private SearchProductService searchProductService;

    public void delete(Long id) {

        Product product = searchProductService.search(id);

        product.setActive(false);

        repository.save(product);

    }

}
