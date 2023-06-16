package org.example;

public class ClasicalMusic implements Music{
    // создаем приватный конструктор
    // для того чтоб использовать фабричный метод
    private ClasicalMusic(){}
    // cоздаем метод который будет создавать новый объект  как будет
    // вызван метод
    public static ClasicalMusic getClassicalMusic(){
        return new ClasicalMusic();
    }
    public void doMyInit(){
        System.out.println(" делаю мою инциализацию");
    }
    public void doMyDestroy(){
        System.out.println("Проважу уничтожение");
    }
    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }
}
