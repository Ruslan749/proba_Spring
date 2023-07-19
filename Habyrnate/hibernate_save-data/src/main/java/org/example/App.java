package org.example;


import org.example.modal.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            // создаем объекты людей
            Person person1 = new Person("test1", 30);
            Person person2 = new Person("test2", 40);
            Person person3 = new Person("test3", 50);

            // сохраняем людей в базу данных
            session.save(person1);
            session.save(person2);
            session.save(person3);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
