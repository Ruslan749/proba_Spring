package com.example.modals;

import javax.validation.constraints.*;

public class Person {
    private int id;
    @NotEmpty(message  = "Name not be empty")
    @Size(min=2, max=30, message = "Name > 2 and name < 30")
    private String name;

    @Min(value = 0, message = " min age not < 0")
    private int age;

    @NotEmpty(message = "email not be empty")
    @Email (message = "email not validation")
    private String email;

    // Страна, город, почтовый индекс (из 3 цифр)
    // Russian, Moscow, 123456
    @Pattern(regexp = "[A-Z]\\w+, [A-Z]\\w+, \\d{6}", message = "Your address should be in this format: Russian, Moscow, 123456")
    private String address;

    public Person() {
    }

    public Person(int id, String name, int age, String email, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
