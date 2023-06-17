package org.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MusicList {
    List<Music> musicList = new ArrayList<>();
    public MusicList(@Qualifier("rockMusic") Music music1,
                       @Qualifier("clasicalMusic") Music music2,
                       @Qualifier("clasicalMusic") Music music3) {
        musicList.add(music1);
        musicList.add(music2);
        musicList.add(music3);

    }

    public List<Music> getMusicList() {
        return musicList;
    }
}
