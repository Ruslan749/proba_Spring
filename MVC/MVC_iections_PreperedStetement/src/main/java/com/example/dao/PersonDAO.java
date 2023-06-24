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
        Person person = null;

        try {

            // создаем запрос в базу данных Person где id = указанному числу
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM Person WHERE id=?");

            // передаем id в условие
            preparedStatement.setInt(1, id);

            // отправляем запрос и получаем ответ в виде объекта resultSet
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next(); // если объект с таким id один – то мы получим одного если объектов несколько – то получим первого

            person = new Person();

            // передаем данные в объект person для чтения
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setEmail(resultSet.getString("email"));
            person.setAge(resultSet.getInt("age"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return person;
    }

    // сохраняет данные в нашей БД объекты класса Person
    public void save(Person person){
        try {

//            // Старый и не надежный способ делать запрос в базу данных

//            Statement statement = connection.createStatement(); // создаем запрос к базе данных (старый способ)
//            String SQL = "INSERT INTO person values (" + 1 +  ",'" + person.getName()  + "'," + person.getAge()
//                    + ",'" + person.getEmail() + "')";


            // создаем запрос к базе данных
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO person values(1,?,?,?)");

            // передаем данные из объекта Person в БД
            preparedStatement.setString(1, person.getName());
            preparedStatement.setInt(2,person.getAge());
            preparedStatement.setString(3, person.getEmail());

            // сохранение данных в базу данных
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // метод для обновления данных в нашей БД
    public void update(int id, Person updatedPerson){
        try {

            // Создаем запрос на обновления, где обновляем значения колонок по заданному id
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE Person SET name=?, age=?, email=? WHERE id=?");

            // передаем данные из объекта Person в БД
            preparedStatement.setString(1, updatedPerson.getName());
            preparedStatement.setInt(2,updatedPerson.getAge());
            preparedStatement.setString(3, updatedPerson.getEmail());
            preparedStatement.setInt(4,id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
}

    // удаление объекта Person из базы данных
    public void delete(int id){
        try {
            // отправляем запрос на удаление из базы данных если id = заданному
            PreparedStatement preparedStatement =
                    connection.prepareStatement("DELETE FROM Person WHERE id=?");

            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
