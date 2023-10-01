package com.example.spring_securityregistration.controller;
/*
create table Person(
    id int primary key generated by default as identity ,
    username varchar(100) not null ,
    year_of_birth int not null ,
    password varchar not null
);

insert into Person(username, year_of_birth, password) values ('test_user1',1960,'test_password');
insert into Person(username, year_of_birth, password) values ('test_user2',1960,'test_password');
 */
import com.example.spring_securityregistration.security.PersonDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String sayHello(){
        return "hello";
    }

    @GetMapping("/showUserInfo")
    public String showUserInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        System.out.println(personDetails.getPerson());

        return "hello";
    }
}
