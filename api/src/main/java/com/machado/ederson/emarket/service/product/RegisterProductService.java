package com.machado.ederson.emarket.service.product;

import com.machado.ederson.emarket.domain.Product;
import com.machado.ederson.emarket.mapper.ProductMapper;
import com.machado.ederson.emarket.repository.ProductRepository;
import com.machado.ederson.emarket.web.request.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterProductService {

    @Autowired
    private ProductMapper mapper;

    @Autowired
    private ProductRepository repository;

    public void register(ProductRequest request) {

        Product product = mapper.map(request, true);

        product.setName(product.getName().toLowerCase());

        repository.save(product);

    }

}
