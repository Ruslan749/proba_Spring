package com.example.dao;

import com.example.modals.Person;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class PersonDAO {
    private final EntityManager entityManager;

    public PersonDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(readOnly = true)

    // делаеться каждый запрос к каждому человеку и получение списков его товаров, что порождает проблему N+1
    public void testNPlus1(){

        Session session = entityManager.unwrap(Session.class);

        // 1 запрос
        List<Person> people = session.createQuery("SELECT p FROM Person p", Person.class)
                .getResultList();

        // N запросов к БД
        for (Person person: people){
            System.out.println("Person " + person.getName() + " has " + person.getItems());
        }
    }

    public void notTestNPlus1(){
        Session session = entityManager.unwrap(Session.class);

        // HashSet -- используем чтоб убрать дублирование

// объединяем 2 таблицы
        Set<Person> people = new HashSet<Person>(session.createQuery("SELECT p FROM Person p LEFT JOIN FETCH p.items", Person.class)
                .getResultList());

        for (Person person: people){
            System.out.println("Person " + person.getName() + " has " + person.getItems());
        }
    }
}
