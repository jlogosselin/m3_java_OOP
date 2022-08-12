package Abstract_Class_Example;

public abstract class Animal {

    //this method to be defined and implemented in the non-abstract class Pig
    public abstract void animalSound();

    public void sleep() {
        System.out.println("The animal is sleeping...");
    }
}
