package lesson3_ABSTRACT_CLASS;

public class Pig extends Animal{

    private String name;
    private int age;

    public Pig(String n, int a){
        this.name = n;
        this.age = a;
    }

    public void animalSound() {
        // The body of animalSound() is provided here
        System.out.println("The pig says: wee wee");
    }

}
