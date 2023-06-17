package org.example;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class MusicPlayer {
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    List<Music> musicList;

    //****** Назначение нескольким полям аргументов через конструктор

    public MusicPlayer(List<Music> musicList) {
        this.musicList = musicList;
    }


    public String playMusic(){
        Random random = new Random();
        return "Playing: " + musicList.get(random.nextInt(3)).getSong();
    }
}
