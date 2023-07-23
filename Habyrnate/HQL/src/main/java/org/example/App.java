package org.example;


import org.example.modal.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            // создаем запрос (HQL не знает таблиц он, знает только сущности) и
            // и записываем это в лист для хранения данных
            // like -- это регулярные вырожения для базы данных

//            List<Person> people = session.createQuery("FROM Person where name like 'T%'").getResultList();
//
//            // выводим на экран список объектов и БД
//            for (Person person: people){
//                System.out.println(person.toString());
//            }

            // пример написания запроса на изменения данных по условию

            session.createQuery("UPDATE Person set name='Test' where age < 40 ").executeUpdate();

            // удаляем данные из таблицы
            session.createQuery("DELETE from  Person where age < 40 ").executeUpdate();

            session.getTransaction().commit();


        } finally {
            sessionFactory.close();
        }
    }
}
