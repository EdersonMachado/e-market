package com.machado.ederson.emarket.web.request;

import com.machado.ederson.emarket.domain.Type;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class ProductRequest {

    @NotEmpty(message = "O nome é obrigatório")
    private String name;

    @NotNull(message = "O preço é obrigatório")
    private BigDecimal price;

    @NotEmpty(message = "A quantidade é obrigatório")
    private int quantity;

    @NotEmpty(message = "A descrição é obrigatório")
    private int description;

    @NotEmpty(message = "O fabricante é obrigatório")
    private String manufacturer;

    @NotEmpty(message = "O tipo é obrigatório")
    @Enumerated(EnumType.STRING)
    private Type type;

}
