package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class secondController {
    @GetMapping("/exit")
    public String exit(){
        return "second/exit";
    }
}
