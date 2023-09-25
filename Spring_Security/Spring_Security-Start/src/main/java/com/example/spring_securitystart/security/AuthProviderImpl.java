package com.example.spring_securitystart.security;

import com.example.spring_securitystart.service.PersonDetailsService;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class AuthProviderImpl implements AuthenticationProvider {

    private final PersonDetailsService personDetailsService;
    @Autowired
    public AuthProviderImpl(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    // логика аунтефикации
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName(); // получаем логин
        UserDetails personDetails = personDetailsService.loadUserByUsername(username);

        String password = authentication.getCredentials().toString();

        if(!password.equals(personDetails.getPassword())){
            throw new BadCredentialsException("пороли не совпадают");
        }
        return new UsernamePasswordAuthenticationToken(personDetails, password, Collections.emptyList());

    }

    // нужен чтобы понять для какого объекта он работает
    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
