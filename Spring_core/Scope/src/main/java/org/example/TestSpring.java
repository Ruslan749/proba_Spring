package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        // ClassPathXmlApplicationContext -- возьмет файл конфигурации
        // прочтет и примет к проекту

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

       /* // вызовет экземпляр объекта и применин настройки конфигурации
        // ( id  конфигурации, экземпляр класа на что применить изменения)
       Music music = context.getBean("musicBean", Music.class);
       // передаем аргумента
       MusicPlayer musicPlayer = new MusicPlayer(music);*/

        MusicPlayer firstMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer secondMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

        // сравниваем переменные на какие объекты они указаны
        boolean compression = firstMusicPlayer == secondMusicPlayer;
        System.out.println(compression);

        System.out.println(firstMusicPlayer);
        System.out.println(secondMusicPlayer);

        firstMusicPlayer.setValue(10);

        System.out.println(firstMusicPlayer.getValue());
        System.out.println(secondMusicPlayer.getValue());

        // вызов экземпляра объекта
//       musicPlayer.playMusic();
//
//       System.out.println(musicPlayer.getName());
//       System.out.println(musicPlayer.getValue());
        // закрытия контекста
       context.close();
    }
}
