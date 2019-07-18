package com.machado.ederson.emarket.repository;

import com.machado.ederson.emarket.domain.Product;
import com.machado.ederson.emarket.domain.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

    Page<Product> findAllByActiveTrue(Pageable pageable);

    Page<Product> findAllByActiveTrueAndType(Type type, Pageable pageable);

    Page<Product> findAllByNameContainsAndActiveTrue(String name, Pageable pageable);

}
