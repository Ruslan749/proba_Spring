package com.example.spring_securityregistration.repositories;

import com.example.spring_securityregistration.modals.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeopleRepositories extends JpaRepository<Person, Integer> {

    Optional<Person> findByUsername(String username);
}
