package com.machado.ederson.emarket.repository;

import com.machado.ederson.emarket.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
