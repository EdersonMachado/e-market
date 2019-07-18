package com.machado.ederson.emarket.service.product;

import com.machado.ederson.emarket.domain.Product;
import com.machado.ederson.emarket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListProductService {

    @Autowired
    private ProductRepository repository;

    public Page<Product> list(Pageable pageable) {

        return repository.findAllByActiveTrue(pageable);

    }
}
