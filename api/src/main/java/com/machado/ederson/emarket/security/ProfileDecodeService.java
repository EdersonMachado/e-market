package com.machado.ederson.emarket.security;

import com.machado.ederson.emarket.domain.Profile;
import org.springframework.stereotype.Service;

@Service
public class ProfileDecodeService {

    private static final String ADMINISTRATOR_CREDENTIAL = "SWORDFISH";

    public Profile decode(String adminPassword){

        return ADMINISTRATOR_CREDENTIAL.equals(adminPassword) ? Profile.ADMINISTRATOR : Profile.USER;

    }

}
