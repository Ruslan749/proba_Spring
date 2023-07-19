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
            // обновление людей

           Person person = session.get(Person.class, 2); // получаем человека с индексом 2 и ложем его в объект

            person.setName("New name"); // вызываем метод и меняем в объекте имя у объекта
            session.delete(person); // удаляем объект из таблицы


            // добавление человека и получение id  при созранении

            Person person1 = new Person("Some name",60);
            session.save(person1);

            session.getTransaction().commit();

            System.out.println(person1.getId()); // получение id только что созданного человека

        } finally {
            sessionFactory.close();
        }
    }
}
