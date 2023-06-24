package com.example.dao;

import com.example.modals.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    // создаем переменную под JdbcTemplate
    private final JdbcTemplate jdbcTemplate;
    // создаем конструктор для применения конфигураций из файла SpringConfig под JdbcTemplate
    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    // метод для показа всех объектов класса Person

    /*
        new PersonMapper() --  созданный нами объект, который при прочтении каждой строки из БД
    создает новый объект Person

        new BeanPropertyRowMapper<>(Person.class) -- если пол из БД совпадают с полями из объекта
    то можно использовать этот метод и передать туда наш объект для записи данных
    */
    public List<Person> index(){
        return jdbcTemplate.query("SELECT * FROM Person",new BeanPropertyRowMapper<>(Person.class));
    }

    // метода для показа отдельного экземпляра объекта класса Person по его Id

    /*new Object[]{id} -- объект который передает jdbcTemplate значение id
    findAny() -- проверяет наличие такого объекта в БД если его нет то вызываеться orElse(null)
    orElse(null) -- который может принимать как аргумент любой объект
    */
    public Person show(int id){
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id}, new PersonMapper())
                .stream().findAny().orElse(null);
    }

    // сохраняет данные в нашей БД объекты класса Person
    public void save(Person person){
        jdbcTemplate.update("INSERT INTO person VALUES(1,?,?,?)", person.getName(), person.getAge(),
                person.getEmail());
    }

    // метод для обновления данных в нашей БД
    public void update(int id, Person updatedPerson){
        jdbcTemplate.update("UPDATE Person SET name=?, age=?, email=? WHERE id=?", updatedPerson.getName(),
                updatedPerson.getAge(),updatedPerson.getEmail());
    }

    // удаление объекта Person из базы данных
    public void delete(int id){
        jdbcTemplate.update("DELETE FROM Person WHERE id=?",id);
    }
}
