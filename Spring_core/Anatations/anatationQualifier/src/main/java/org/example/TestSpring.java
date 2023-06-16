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

/*      MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
      musicPlayer.playMusic(); */

        Computer computer = context.getBean("computer", Computer.class);
        System.out.println(computer);
        // закрытия контекста
       context.close();
    }
}
