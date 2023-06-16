package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        // ClassPathXmlApplicationContext -- возьмет файл конфигурации
        // прочтет и примет к проекту

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        // вызовет экземпляр объекта и применин настройки конфигурации
        // ( id  конфигурации, экземпляр класа на что применить изменения)
       Music music1 = context.getBean("rockMusic", Music.class);

        // вручную внедряем зависимость
       MusicPlayer musicPlayer1 = new MusicPlayer(music1);
        // вызов экземпляра объекта
       musicPlayer1.playMusic();

       Music music2 = context.getBean("musicBean", Music.class);
       MusicPlayer musicPlayer2 = new MusicPlayer(music2);
       musicPlayer2.playMusic();

        Music music3 = context.getBean("jazzMusic",Music.class);
        MusicPlayer musicPlayer3 = new MusicPlayer(music3);
        musicPlayer3.playMusic();
        // закрытия контекста
       context.close();
    }
}
