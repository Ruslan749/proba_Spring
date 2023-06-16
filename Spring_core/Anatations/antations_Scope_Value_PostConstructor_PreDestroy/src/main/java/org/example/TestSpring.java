package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        // ClassPathXmlApplicationContext -- возьмет файл конфигурации
        // прочтет и примет к проекту

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

/*         вызовет экземпляр объекта и применин настройки конфигурации
        ( id  конфигурации, экземпляр класа на что применить изменения) */

        // Назначение полей через Value
        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        System.out.println(musicPlayer.getName());
        System.out.println(musicPlayer.getVolume());

        // Работа Scope
        ClasicalMusic clasicalMusic1 = context.getBean("clasicalMusic", ClasicalMusic.class);
        ClasicalMusic clasicalMusic2 = context.getBean("clasicalMusic", ClasicalMusic.class);

        System.out.println(clasicalMusic1 == clasicalMusic2);

        RockMusic rockMusic1 = context.getBean("rockMusic", RockMusic.class);
        RockMusic rockMusic2 = context.getBean("rockMusic", RockMusic.class);

        System.out.println(rockMusic1 == rockMusic2);

        // методы начала и конца инициализации
        JazzMusic jazzMusic = context.getBean("jazzMusic", JazzMusic.class);

        // закрытия контекста
       context.close();
    }
}
