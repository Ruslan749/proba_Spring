package org.example;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class JazzMusic implements Music{
    @PostConstruct
    public void doMyInit(){
        System.out.println("начинаю инициализацию");
    }
    @PreDestroy
    public void doMyDestroy(){
        System.out.println("Заканчиваю инициализацию");
    }
    @Override
    public String getSong() {
        return "Moon River";
    }
}
