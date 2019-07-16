package com.machado.ederson.emarket.web.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class UserRequest {

    @NotEmpty(message = "O nome é obrigatório")
    private String name;

    @NotEmpty
    @Email(message = "O e-mail deve estar em um formato válido")
    private String email;

    @NotEmpty
    private String password;

    @NotEmpty(message = "A foto é obrigatória")
    private String photoUrl;

}
