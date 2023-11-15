package com.example.spring_securityshifrovanie.repositories;

import com.example.spring_securityshifrovanie.modals.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeopleRepositories extends JpaRepository<Person, Integer> {

    Optional<Person> findByUsername(String username);
}
