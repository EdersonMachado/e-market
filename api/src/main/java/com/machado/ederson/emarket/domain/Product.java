package com.machado.ederson.emarket.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name="products")
@SequenceGenerator(name = "SEQ", sequenceName = "SEQ_PRODUCT", allocationSize = 1)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    private Long id;

    private String name;

    private BigDecimal price;

    private int quantity;

    private int description;

    private String manufacturer;

    @Enumerated(EnumType.STRING)
    private Type type;

}
