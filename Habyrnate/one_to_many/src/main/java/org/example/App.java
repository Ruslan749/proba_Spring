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

/*
            // **** получение всех товаров по id человека

            Person person = session.get(Person.class,3); // получаем человека с id 3
            System.out.println(person);

            List<Item> items = person.getItems(); // выводим все товары этого человека
            System.out.println(items);
*/
            // **** добавление товаров для человека с определенным id

/*             хорошей практикой является при создании нового поля задавать отношения с двух сторон,
             так как hibernate кэширует данные и при новом использовании этого объекта
             он не выдаст новые данные хотя они и будут в таблице
*/

//            Person person = session.get(Person.class, 2); // получаем человека с id 2
//
//            Item newItem = new Item("Item from hibernate",person); // создаем новое название в item
//            // и присваиваем ему значение нашего полученного человека
//
//
//
//            session.save(newItem); // записываем новое значение в таблицу item
//            person.getItems().add(newItem); // задаем человеку, что у него появился товар

            // **** создание нового человека с одним заказом

//            Person person = new Person("Test person", 30); // создаем человека
//
//            Item newItem2 = new Item("items from hibernate 2",person); // создаем список товаров для этого человека
//
//            person.setItems(new ArrayList<>(Collections.singletonList(newItem2))); // создаем список с одним элементом
//
//            session.save(person);
//            session.save(newItem2);

            // **** удаление товаров у человека

//            Person person = session.get(Person.class, 3); // получаем человека
//            List<Item> items = person.getItems(); // получаем список его товаров
//
//            for (Item item: items) { // перебираем весь список товаров и удаляем их
//                session.remove(item);
//            }
//
//            person.getItems().clear(); // очищаем список товаров у самого человека (очищаем кэш)

            // **** удаляем человека

//            Person person = session.get(Person.class,2);
//
//            session.remove(person); // удаляем человека
//
//            person.getItems().forEach(i-> i.setOwner(null));  // проходимся по каждому человеку и списку его товаров назначаем null
//

            // **** меняем владельца у существующего товара

            Person person = session.get(Person.class,4);
            Item item = session.get(Item.class,2);

            item.getOwner().getItems().remove(item); // получаем старого владельца и удаляем у него этот товар

            item.setOwner(person); // присваиваем товару нового владельца
            person.getItems().add(item); // добавляем владельцу новый товар

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
