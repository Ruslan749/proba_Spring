package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {


// ***** Назаначение зависимости через поле
/*    @Autowired
    @Qualifier("clasicalMusic")
    private Music music;*/


    //****** Назначение нескольким полям аргументов через конструктор
    private Music music1;
    private Music music2;
    @Autowired
    public MusicPlayer(@Qualifier("rockMusic") Music music1,
                       @Qualifier("clasicalMusic") Music music2) {
        this.music1 = music1;
        this.music2 = music2;
    }

    public String playMusic(){
        return "Playing: " + music1.getSong() + " " + music2.getSong();
    }
}
