package com.example.webshop.utill;

public class PersonNotCreatedException extends  RuntimeException{
    public PersonNotCreatedException(String msg){
        super(msg);
    }
}
