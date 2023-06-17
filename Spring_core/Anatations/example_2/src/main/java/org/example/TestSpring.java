package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
/*         ClassPathXmlApplicationContext -- возьмет файл конфигурации
         прочтет и примет к проекту из класса springConfig */

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            springConfig.class
        );

/*         вызовет экземпляр объекта и применин настройки конфигурации
        ( id  конфигурации, экземпляр класа на что применить изменения) */

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        System.out.println(musicPlayer.playMusic());




        // закрытия контекста
       context.close();
    }
}
