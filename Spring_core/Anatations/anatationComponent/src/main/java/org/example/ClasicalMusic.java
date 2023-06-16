package org.example;

import org.springframework.stereotype.Component;

@Component("musicBean")
public class ClasicalMusic implements Music{
    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }
}
