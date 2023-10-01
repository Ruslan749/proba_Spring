package com.example.spring_securityregistration.service;

import com.example.spring_securityregistration.modals.Person;
import com.example.spring_securityregistration.repositories.PeopleRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationServes {
    private final PeopleRepositories peopleRepositories;
    @Autowired
    public RegistrationServes(PeopleRepositories peopleRepositories) {
        this.peopleRepositories = peopleRepositories;
    }
    @Transactional
    public void register(Person person){
        peopleRepositories.save(person);
    }
}
