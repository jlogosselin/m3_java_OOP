package Exercise6_UserIO_Interface;

import java.util.Scanner;

public class UserIO_Implementation implements UserIO{

    Scanner userInput = new Scanner(System.in);

    public UserIO_Implementation(){}

    //below: implementing the methods listed in the interface
    //this is done by using the @Override annotation

    @Override
    public void print(String message){
        System.out.println(message);
    }

    @Override
    public String readString(String prompt){
        System.out.println(prompt);
        String s = userInput.nextLine();
        return s;
    }

    @Override
    public int readInt(String prompt){
        System.out.println(prompt);
        int i = userInput.nextInt();
        return i;
    }

    @Override
    public int readInt(String prompt, int min, int max){
        System.out.println(prompt + min + " and " + max + ":");
        int i = userInput.nextInt();
        while(i < min && i > max){
            System.out.println("Sorry: out of range.");
            System.out.println(prompt + min + " and " + max + ":");
            i = userInput.nextInt();
        }
        return i;
    }

    @Override
    public double readDouble(String prompt){
        System.out.println(prompt);
        double d = userInput.nextInt();
        return d;
    }

    @Override
    public double readDouble(String prompt, double min, double max){
        System.out.println(prompt + min + " and " + max + ":");
        double d = userInput.nextInt();
        while(d < min && d > max){
            System.out.println("Sorry: out of range.");
            System.out.println(prompt + min + " and " + max + ":");
            d = userInput.nextInt();
        }
        return d;
    }

    @Override
    public float readFloat(String prompt){
        System.out.println(prompt);
        float f = userInput.nextFloat();
        return f;
    }

    @Override
    public float readFloat(String prompt, float min, float max){
        System.out.println(prompt);
        float f = userInput.nextFloat();
        while(f < min && f > max){
            System.out.println("Sorry: out of range.");
            System.out.println(prompt + min + " and " + max + ":");
            f = userInput.nextInt();
        }
        return f;
    }

    @Override
    public long readLong(String prompt){
        System.out.println(prompt);
        long l = userInput.nextLong();
        return l;
    }

    @Override
    public long readLong(String prompt, long min, long max){
        System.out.println(prompt);
        long l = userInput.nextLong();
        while(l < min && l > max){
            System.out.println("Sorry: out of range.");
            System.out.println(prompt + min + " and " + max + ":");
            l = userInput.nextLong();
        }
        return l;
    }
}
