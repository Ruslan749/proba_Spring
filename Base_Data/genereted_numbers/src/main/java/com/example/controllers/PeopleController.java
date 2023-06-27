package com.example.controllers;

import com.example.dao.PersonDAO;
import com.example.modals.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PersonDAO personDAO;
    // внедряем зависимость PersonDAO в поле
    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    // 1. получим всех людей из DAO на отображение в представлении
    @GetMapping()
    public String index(Model model){
        model.addAttribute("people", personDAO.index());

        return "people/index";
    }

    // 2. получим одного человека по его id из DAO из
    // передадим его на представление
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model ){
        model.addAttribute("person",personDAO.show(id));
        return "people/show";
    }
    // 3. возвращет данные полей формы если данных нет
    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("person", new Person());
        return "people/new";
    }
    // 3.1 получаем данные из Post запроса добавляем данные в базу данных
    // помечаем наш объект person  аннотацией @Valid  которая проверяет валидность
    // объекта и у которой есть интерфейс BindingResult который хранит message
    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult){
        // проверяем есть ли ошибки
        if (bindingResult.hasErrors()){
            return "people/new";
        }

        personDAO.save(person);
        return "redirect:/people";
    }
    // 4 получаем данные и обрисовываем форму запроса
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("person",personDAO.show(id));
        return "people/edit";
    }
    // 3.1 изменяем поля для конкретного объекта Person по его id
    // помечаем наш объект person  аннотацией @Valid  которая проверяет валидность
    // объекта и у которой есть интерфейс BindingResult который хранит message
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult,
                         @PathVariable("id") int id){

        // проверяем есть ли ошибки
        if (bindingResult.hasErrors()){
            return "people/edit";
        }

        personDAO.update(id,person);
        return "redirect:/people";
    }

    // 3.2 удаление человека
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        personDAO.delete(id);
        return "redirect:/people";
    }
}
