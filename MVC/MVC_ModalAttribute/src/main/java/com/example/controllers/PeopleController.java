package com.example.controllers;

import com.example.dao.PersonDAO;
import com.example.modals.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PersonDAO personDAO;
    // внедряем зависимость PersonDAO в поле
    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    //получим всех людей из DAO на отображение в представлении
    @GetMapping()
    public String index(Model model){
        model.addAttribute("people", personDAO.index());

        return "people/index";
    }

    // получим одного человека по его id из DAO из
    // передадим его на представление
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model ){
        model.addAttribute("person",personDAO.show(id));
        return "people/show";
    }
    // возвращет данные полей формы если данных нет
    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("person", new Person());
        return "people/new";
    }
    // получаем данные из Post запроса добавляем данные в базу данных
    @PostMapping()
    public String create(@ModelAttribute("person") Person person){
        personDAO.save(person);
        return "redirect:/people";
    }
}
