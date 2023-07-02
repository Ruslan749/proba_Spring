package com.example.controllers;

import com.example.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test-batch-update")
public class Batch_controller {

    private final PersonDAO personDAO;
    @Autowired
    public Batch_controller(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(){
        return "batch/index";
    }

    @GetMapping("/without")
    public String withoutBath(){
        personDAO.testMultipleUpdata();
        return "redirect:/people";
    }

    @GetMapping("/with")
    public String withBath(){
        personDAO.testBatchUpdata();
        return "redirect:/people";
    }
}
