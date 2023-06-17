package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;


@Configuration
//@ComponentScan("org.example")
@PropertySource("classpath:musicPlayer.properties")
public class springConfig {
    // оздание бинов в ручную (объектов)
    @Bean
    public ClasicalMusic clasicalMusic(){
        return new ClasicalMusic();
    }

    @Bean
    public RockMusic rockMusic(){
        return new RockMusic();
    }
    @Bean
    JazzMusic jazzMusic(){
        return new JazzMusic();
    }


    @Bean
    public MusicList musicList(){
        return new MusicList(rockMusic(), clasicalMusic(),jazzMusic());
    }

    @Bean
    public MusicPlayer musicPlayer(){
        return new MusicPlayer(musicList().getMusicList());
    }

    @Bean
    public Computer computer(){
        return new Computer(musicPlayer());
    }
}
