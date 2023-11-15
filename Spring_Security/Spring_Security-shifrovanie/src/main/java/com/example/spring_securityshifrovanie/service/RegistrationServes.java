package com.example.spring_securityshifrovanie.service;

import com.example.spring_securityshifrovanie.modals.Person;
import com.example.spring_securityshifrovanie.repositories.PeopleRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationServes {
    private final PeopleRepositories peopleRepositories;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public RegistrationServes(PeopleRepositories peopleRepositories,
                              PasswordEncoder passwordEncoder) {
        this.peopleRepositories = peopleRepositories;
        this.passwordEncoder = passwordEncoder;
    }
    @Transactional
    public void register(Person person){
        String encodedPassword = passwordEncoder.encode(person.getPassword()); // шифруем пороль
        person.setPassword(encodedPassword); // обнавляем пороль на уже зашифрованный
        peopleRepositories.save(person);
    }
}
