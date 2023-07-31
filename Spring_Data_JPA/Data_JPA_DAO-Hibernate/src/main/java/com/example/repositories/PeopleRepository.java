package com.example.repositories;

import com.example.modals.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JpaRepository<Person,Integer>  -- какую сущность реализовывает репозиторий и какой первичный ключ
@Repository
public interface PeopleRepository extends JpaRepository<Person,Integer> {
}
