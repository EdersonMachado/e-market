package com.machado.ederson.emarket.service.product;

import com.machado.ederson.emarket.domain.Product;
import com.machado.ederson.emarket.domain.Type;
import com.machado.ederson.emarket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListProductWithTypeService {

    @Autowired
    private ProductRepository repository;

    public Page<Product> list(Type type, Pageable pageable) {

        return repository.findAllByActiveTrueAndType(type, pageable);

    }
}
