package org.example;

import org.springframework.stereotype.Component;

@Component()
public class ClasicalMusic implements Music{
    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }
}
