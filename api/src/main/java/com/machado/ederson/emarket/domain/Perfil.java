package com.machado.ederson.emarket.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum Perfil {

    ADMINISTRATOR("ROLE_ADMIN"),

    USER("ROLE_USER");

    private final String role;

}
