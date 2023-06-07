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
       TestBean testBean = context.getBean("testBean", TestBean.class);
        // вызов экземпляра объекта
       System.out.println(testBean.getName());
        // закрытия контекста
       context.close();
    }
}
