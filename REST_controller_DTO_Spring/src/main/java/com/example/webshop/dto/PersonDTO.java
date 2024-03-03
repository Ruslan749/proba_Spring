package com.example.webshop.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class PersonDTO {

    @NotEmpty(message = "имя не должно быть пустым")
    @Size(min = 2,max = 30,message = "имя не долэно быть меньше 2 символов и больше 30")
    private String name;


    @Min(value = 0,message = "Имя не должно быть пустым")
    private int age;


    @Email
    @NotEmpty(message = "mail не должен быть пустым")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
