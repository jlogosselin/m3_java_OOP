package Exercise3_SimpleCalculator;

import java.util.Scanner;

public class EntryPoint_Main {

    public static void main(String[] args) {

        Scanner userInp = new Scanner(System.in);
        App obj1 = new App();
        int c = 0;
        int n1 = 0;
        int n2 = 0;

        obj1.printIntroMessage();

        do{
            obj1.printMenu();
            c = Integer.parseInt(userInp.nextLine());
            obj1.setChoice(c);

            if(c != 5){

                System.out.println("Enter two values: ");
                n1 = Integer.parseInt(userInp.nextLine());
                n2 = Integer.parseInt(userInp.nextLine());

                obj1.setValues(n1, n2);
                obj1.applyOperation();
                obj1.getResult();
            }

        }while(c != 5);

        obj1.exitMessage();

    }
}
