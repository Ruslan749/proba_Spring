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
       Music music = context.getBean("musicBean", Music.class);

        // вручную внедряем зависимость
       MusicPlayer musicPlayer = new MusicPlayer(music);
        // вызов экземпляра объекта
       musicPlayer.playMusic();
        // закрытия контекста
       context.close();
    }
}
