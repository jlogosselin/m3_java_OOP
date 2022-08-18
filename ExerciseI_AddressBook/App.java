package ExerciseI_AddressBook;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        AddressBookController myBook = new AddressBookController();
        String answer = "";
        do{
            myBook.execute();
            System.out.println("\n-------------- Do you wish to continue with this address book? (y/n)");
            answer = userInput.nextLine();
        }while(answer.toLowerCase().equals("y"));
        System.out.println("Thank you, bye!");
    }
}
