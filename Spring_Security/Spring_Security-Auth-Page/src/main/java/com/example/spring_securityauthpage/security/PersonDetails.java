package com.example.spring_securityauthpage.security;

import com.example.spring_securityauthpage.modals.Person;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class PersonDetails implements UserDetails { // UserDetails -- интерфейс для spring security

    private final Person person;

    public PersonDetails(Person person) {
        this.person = person;
    }

    // метод для авторизации (получаем колекцию прав для пользователя)
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
    // метод для получения пороля пользователя
    @Override
    public String getPassword() {
        return this.person.getPassword();
    }
    // метод который реализует получение логина пользователя
    @Override
    public String getUsername() {
        return this.person.getUsername();
    }
    // активная ли сущность
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    // заблокированая ли сущность
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    // пороль не просрочен
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    // включен ли аккаунт
    @Override
    public boolean isEnabled() {
        return true;
    }
    // нужно для получение данных аутентицифицированого пользователя
    public Person getPerson(){
        return this.person;
    }

}
