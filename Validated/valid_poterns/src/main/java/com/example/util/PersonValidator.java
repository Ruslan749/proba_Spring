package com.example.util;


import com.example.dao.PersonDAO;
import com.example.modals.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {
    private final PersonDAO personDAO;

    @Autowired
    public PersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        // указываем на какой класс будет производиться валидация
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
         Person person = (Person) target; // получаем нужный нам объект в переменную

        // смотрим есть ли такой же человек с таким же email
        // в нашей базе данных

       /* errors.rejectValue вызывает ошибку и принимает 3 аргумента
       *  1) поле на котором вызвана ошибка
       *  2) код ошибки
       *  3) сообщение ошибки
       *
       * isPresent() --  метод который существует у объекта Optional
       * который проверяет есть ли такой объект или нет
       * */

        if (personDAO.show(person.getEmail()).isPresent()){
            errors.rejectValue("email","","This email is already taken");
        }




    }
}

