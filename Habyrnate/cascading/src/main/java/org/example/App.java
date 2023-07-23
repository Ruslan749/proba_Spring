package org.example;


import org.example.modal.Item;
import org.example.modal.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person person = new Person("Test",30); // создаем нового человека

            // создаем новый товар для человека
            person.addItem(new Item("item 1")); // создаем новый товар для человека
            person.addItem(new Item("item 2"));
            person.addItem(new Item("item 3"));

            session.save(person);


            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
