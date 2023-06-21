package com.example.controllers;

import com.example.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
