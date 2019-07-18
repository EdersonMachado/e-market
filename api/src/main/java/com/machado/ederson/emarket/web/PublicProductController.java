package com.machado.ederson.emarket.web;

import com.machado.ederson.emarket.domain.Product;
import com.machado.ederson.emarket.domain.Type;
import com.machado.ederson.emarket.service.product.ListProductService;
import com.machado.ederson.emarket.service.product.ListProductWithNameService;
import com.machado.ederson.emarket.service.product.ListProductWithTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public/products")
public class PublicProductController {

    @Autowired
    private ListProductService listProductService;

    @Autowired
    private ListProductWithTypeService listProductWithTypeService;

    @Autowired
    private ListProductWithNameService listProductWithNameService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Product> list(@PageableDefault Pageable pageable){

        return listProductService.list(pageable);

    }

    @GetMapping("/type/{type}")
    @ResponseStatus(HttpStatus.OK)
    public Page<Product> listFilterType(@PageableDefault Pageable pageable,
                                        @PathVariable("type") Type type){

        return listProductWithTypeService.list(type, pageable);

    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Page<Product> listFilterName(@PageableDefault Pageable pageable,
                                        @PathVariable("name") String name){

        return listProductWithNameService.list(name, pageable);

    }

}
