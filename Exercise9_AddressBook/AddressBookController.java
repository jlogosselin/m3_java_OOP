package Exercise9_AddressBook;

//this class orchestrates the program

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AddressBookController {

    private AddressBookDao addressBookDao;
    private View view;
    private int userChoice;

    public AddressBookController(){
        addressBookDao = new AddressBookDao();
        view = new View();
    }

    public void execute(){
        view.showMenu();
        int choice = view.takeUserChoice();
        if(choice == 1) enterAddressBookFromDataFile();
        else if (choice == 2) enterAddressBookDataFromUser();
        else if (choice == 3) printAddressBook();
    }

    public void enterAddressBookFromDataFile(){
        try (BufferedReader br = new BufferedReader(new FileReader("initialAddressBookData.txt"))){
            String currentLine;
            while ((currentLine = br.readLine()) != null){
                String[] arr = currentLine.split("::");
                Address newFullAddress = new Address(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]);
                addressBookDao.addAddress(newFullAddress);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void enterAddressBookDataFromUser(){
        String[] data = view.enterUserDataManually();
        Address newFullAddress = new Address(data[0], data[1], data[2], data[3], data[4], data[5]);
        addressBookDao.addAddress(newFullAddress);
    }

    public void printAddressBook(){
        addressBookDao.getAddressBookData();
    }

}
