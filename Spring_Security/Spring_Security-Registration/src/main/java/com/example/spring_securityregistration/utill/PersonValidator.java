package com.example.spring_securityregistration.utill;

import com.example.spring_securityregistration.modals.Person;
import com.example.spring_securityregistration.service.PersonDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class PersonValidator implements Validator {
    private final PersonDetailsService personDetailsService;

    public PersonValidator(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    // для какого класса служит валидация
    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors e) {
        Person person = (Person) target;


        try{
            personDetailsService.loadUserByUsername(person.getUsername());
        }catch (UsernameNotFoundException ignored){
            return; // странныей код все ок
        }

        e.rejectValue("username","","Человек с таким именем уже есть ");
    }
}
