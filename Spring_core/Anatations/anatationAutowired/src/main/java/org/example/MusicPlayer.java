package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
// ****** Внедрение зависимости через поле
//    @Autowired
//    private Music music;

// ****** Внедрение зависимости через конструктор
//    @Autowired
//    public MusicPlayer(Music music ){
//        this.music = music;
//    }


// ****** Внедрение зависимости через set
//    public MusicPlayer(Music music ){
//        this.music = music;
//    }
//
//    @Autowired
//    public void setMusic(Music music) {
//        this.music = music;
//    }

private ClasicalMusic clasicalMusic;
private RockMusic rockMusic;
    @Autowired
    public MusicPlayer(ClasicalMusic clasicalMusic, RockMusic rockMusic) {
        this.clasicalMusic = clasicalMusic;
        this.rockMusic = rockMusic;
    }

    public String playMusic(){
        return "Playing: " + clasicalMusic.getSong();
//        System.out.println("Playing: " + clasicalMusic.getSong());
//        System.out.println("Playing: " + rockMusic.getSong());
    }
}
