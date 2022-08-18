package ExerciseI_AddressBook;

//helper used by the VIEW class to interact with the console

import java.util.Scanner;

public class UserIO {

    private Scanner userInput;

    public UserIO(){
        userInput = new Scanner(System.in);
    }

    public void menu(){
        System.out.println("\n\n************************* WELCOME TO JL's ADDRESS BOOK APP *******************\n");
        System.out.println("                   enter (1) to input address data from data file                 \n");
        System.out.println("                   enter (2) to input address data manually                       \n");
        System.out.println("                        enter (3) to print address data                           \n");
        System.out.println("**********************************************************************************");
    }

    public int verifyUserChoice(){
        String n;
        boolean r1, r2 = false;
        int flag;
        do {
            flag = 0;
            n = userInput.nextLine();
            r1 = isNumeric(n);
            if (r1) {
                flag = 1;
                if (Integer.parseInt(n) >= 1 && Integer.parseInt(n) <= 4) {
                    r1 = true;
                    r2 = true;
                    flag = 2;
                }
            }
            if (flag == 0) System.out.println("Error: your input is not an integer. Try again.");
            else if (flag == 1) System.out.println("Error: your integer is not in range. Try again.");
        } while (r1 == false || r2 == false);
        return Integer.parseInt(n);
    }

    public boolean isNumeric(String s) {
        boolean result = s.matches("-?\\d+");
        return result;
    }

    public boolean stringContainsNumericCharacters(String s){
        boolean result = false;
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c : chars){
            if(Character.isDigit(c)){
                result = true;
                break;
            }
        }
        return result;
    }

    public String enterData(int i){
        boolean r = false;
        String s = "";
        if(i == 0 || i == 1 || i == 3 || i == 4){
            do{
                if(i == 0) System.out.println("Enter first name: ");
                else if (i == 1) System.out.println("Enter last name: ");
                else if (i == 3) System.out.println("Enter city name: ");
                else if (i == 4) System.out.println("Enter state name: ");
                s = userInput.nextLine();
                r = stringContainsNumericCharacters(s);
                if(r == true){
                    System.out.println("Error: the string contains numeric characters.");
                }
            }while(r == true);
        }
        else if(i == 2 || i == 5){
            if(i == 2) System.out.println("Enter street address: ");
            else if (i == 5) System.out.println("Enter zip: ");
            s = userInput.nextLine();
        }
        return s;
    }

}
