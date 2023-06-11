package org.example;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
    private List<Music> musicList = new ArrayList<>();
    private String name;
    private int volume;
    public MusicPlayer(List<Music> music){
        this.musicList = music ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return volume;
    }

    public void setValue(int volume) {
        this.volume = volume;
    }

    public MusicPlayer() {
    }

    public void setMusicList(List<Music> music) {
        this.musicList = music;
    }

    public void playMusic(){
        for (int i = 0; i <musicList.size(); i++){
            System.out.println("Playing: " + musicList.get(i).getSong());
        }

    }
}
