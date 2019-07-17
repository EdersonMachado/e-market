package com.machado.ederson.emarket.service.product;

import com.machado.ederson.emarket.domain.Product;
import com.machado.ederson.emarket.exception.NotFoundException;
import com.machado.ederson.emarket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SearchProductService {

    @Autowired
    private ProductRepository repository;

    public Product search(Long id){

        Optional<Product> product = repository.findById(id);

        return product.orElseThrow(
                () -> new NotFoundException("Produto não encontrado"));
    }
}
