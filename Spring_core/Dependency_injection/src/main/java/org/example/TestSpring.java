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

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

        // вызов экземпляра объекта
       musicPlayer.playMusic();

       System.out.println(musicPlayer.getName());
       System.out.println(musicPlayer.getValue());
        // закрытия контекста
       context.close();
    }
}
