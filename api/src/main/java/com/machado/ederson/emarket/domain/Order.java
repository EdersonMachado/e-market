package com.machado.ederson.emarket.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "orders")
@EqualsAndHashCode(of = "id")
@SequenceGenerator(name = "SEQ_O", sequenceName = "SEQ_ORDER", allocationSize = 1)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_O")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    private int quantity;

}
