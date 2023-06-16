package org.example;

public class RockMusic implements Music{
    public void doMyInit(){
        System.out.println(" делаю мою инциализацию");
    }
    public void doMyDestroy(){
        System.out.println("Проважу уничтожение");
    }

    @Override
    public String getSong() {
        return "Wind cries Mary";
    }
}
