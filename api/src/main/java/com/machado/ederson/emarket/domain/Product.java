package com.machado.ederson.emarket.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
public class Product {

    @Id
    private Long id;

    private String name;

    private BigDecimal price;

    private int quantity;

    private int description;

    private String manufacturer;

    @Enumerated(EnumType.STRING)
    private Type type;

}
