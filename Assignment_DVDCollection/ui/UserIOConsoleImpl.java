package Assignment_DVDCollection.ui;

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO{

    Scanner userInput = new Scanner(System.in);

    public UserIOConsoleImpl(){}

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
        String i = userInput.nextLine();
        return Integer.parseInt(i);
    }

    @Override
    public int readInt(String prompt, int min, int max){
        System.out.println(prompt + min + " and " + max + ":");
        String i = userInput.nextLine();
        while(Integer.parseInt(i) < min && Integer.parseInt(i) > max){
            System.out.println("Sorry: out of range.");
            System.out.println(prompt + min + " and " + max + ":");
            i = userInput.nextLine();
        }
        return Integer.parseInt(i);
    }
}
