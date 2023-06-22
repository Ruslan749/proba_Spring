package com.example.dao;

import com.example.modals.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Tom"));
        people.add(new Person(++PEOPLE_COUNT, "Bob"));
        people.add(new Person(++PEOPLE_COUNT, "Mike"));
        people.add(new Person(++PEOPLE_COUNT, "Katy"));
    }
    // метод для показа всех объектов класса Person
    public List<Person> index(){
        return people;
    }

    // метода для показа отдельного экземпляра объекта класса Person по его Id
    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id)
                .findAny().orElse(null);
    }

    // сохраняет данные в нашей БД объекты класса Person
    public void save(Person person){
        person.setId(++ PEOPLE_COUNT);
        people.add(person);
    }

    // метод для обновления данных в нашей БД
    public void update(int id, Person updatetedPerson){
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatetedPerson.getName());
    }

    // удаление объекта Person из базы данных

    public void delete(int id){
        people.removeIf(person -> person.getId() == id);
    }
}
