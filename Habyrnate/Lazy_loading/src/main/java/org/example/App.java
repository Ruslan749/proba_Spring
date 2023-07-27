package org.example;


import org.example.modal.Item;
import org.example.modal.Person;
import org.hibernate.Hibernate;
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

            Person person = session.get(Person.class,1);
            System.out.println("получим связанные сущности");

            // по умолчанию стоит ленивая загрузка
            System.out.println(person.getItems());

            Hibernate.initialize(person.getItems()); // чтоб не использовать System.out.println()
            // и явно указать какие данные мы подгружаем

            // конец сессии
            session.getTransaction().commit();
            System.out.println(person.getItems()); // подгрузили данные в сессии и можем их использовать

            // **** открываем вторую сессию
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            System.out.println("внутри второй транзакции");

            person = (Person) session.merge(person); // возвращается объект класса Object
            // по этому явно указываем к какому нашему объекту он относиться

            Hibernate.initialize(person.getName());

            session.getTransaction().commit(); // заканчиваем вторую сессию

            System.out.println("после второй сессии");

            System.out.println(person.getName());



        } finally {
            sessionFactory.close();
        }
    }
}
