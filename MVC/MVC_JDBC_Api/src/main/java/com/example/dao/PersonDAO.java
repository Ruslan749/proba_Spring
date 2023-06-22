package com.example.dao;

import com.example.modals.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    //статическая переменная для образования номера id
    private static int PEOPLE_COUNT;

    // данные для подключения к базе данных
    private static final String URL = "jdbc:postgresql://localhost:5433/first_db";
    private static final String USERNAME="postgres";
    private static final String PASSWORD="postgres";

    // создаем соединение с нашей базой данных через jdbs
    private static Connection connection;
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // метод для показа всех объектов класса Person
    public List<Person> index(){
        List<Person> people = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();// создаем запрос к базе данных
            String SQL = "SELECT * FROM Person"; // пишем команду для запроса
            ResultSet resultSet = statement.executeQuery(SQL); // передаем команду в запрос и получаем строки в виде объектов

            while (resultSet.next()){ // проходимся по каждому объекту из SQL
                Person person = new Person();

                person.setId(resultSet.getInt("id")); // получаем id из колонки и записываем его в объект Person
                person.setName(resultSet.getString("name")); // получаем name из колонки и записываем его в объект Person
                person.setEmail(resultSet.getString("email")); // получаем email из колонки и записываем его в объект Person
                person.setAge(resultSet.getInt("age")); // получаем age из колонки и записываем его в объект Person

                people.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return people;
    }

    // метода для показа отдельного экземпляра объекта класса Person по его Id
    public Person show(int id){
//        return people.stream().filter(person -> person.getId() == id)
//                .findAny().orElse(null);
        return null;
    }

    // сохраняет данные в нашей БД объекты класса Person
    public void save(Person person){
        try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO person values (" + 1 +  ",'" + person.getName()  + "'," + person.getAge()
                    + ",'" + person.getEmail() + "')";

            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // метод для обновления данных в нашей БД
    public void update(int id, Person updatedPerson){
//        Person personToBeUpdated = show(id);
//
//        personToBeUpdated.setName(updatedPerson.getName());
//        personToBeUpdated.setAge(updatedPerson.getAge());
//        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    // удаление объекта Person из базы данных

    public void delete(int id){
//        people.removeIf(person -> person.getId() == id);
    }
}
