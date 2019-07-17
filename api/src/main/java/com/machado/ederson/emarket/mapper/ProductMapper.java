package com.machado.ederson.emarket.mapper;

import com.machado.ederson.emarket.domain.Product;
import com.machado.ederson.emarket.web.request.ProductRequest;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product map(ProductRequest request, boolean active){

        Product response = new Product();

        response.setName(request.getName());
        response.setDescription(request.getDescription());
        response.setManufacturer(request.getManufacturer());
        response.setPrice(request.getPrice());
        response.setQuantity(request.getQuantity());
        response.setType(request.getType());
        response.setActive(active);

        return response;
    }

}
