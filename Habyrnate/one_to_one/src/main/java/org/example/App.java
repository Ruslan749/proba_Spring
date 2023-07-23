package org.example;


import org.example.modal.Passport;
import org.example.modal.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Passport.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

//            Person person = new Person("Test person", 30);
//            Passport passport = new Passport( 12345);
//
//            person.setPassport(passport);
//            session.save(person);

            // чтения данных
            Person person1 = session.get(Person.class,1);
            System.out.println(person1.getPassport().getPassportNumber());

            Passport passport1 = session.get(Passport.class,1);
            System.out.println(passport1.getPerson().getName());

            // изменения данных паспорта

            Person person2 = session.get(Person.class, 1);
            person2.getPassport().setPassportNumber(1212121);

            // удаление человека

            Person person3 = session.get(Person.class, 4);
            session.remove(person3);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
