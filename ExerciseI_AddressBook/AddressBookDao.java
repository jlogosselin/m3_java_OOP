package ExerciseI_AddressBook;

import java.util.*;

public class AddressBookDao {

    private List<Address> addressBookList;

    public AddressBookDao(){
        addressBookList = new ArrayList<Address>();
    }

    public void addAddress(Address inputAddress){
        addressBookList.add(inputAddress);
    }

    public void getAddressBookData(){
        for (Address a: addressBookList) {
            System.out.println(a.getFirstName() +
                    ", " + a.getLastName() +
                    ", " + a.getStreetAddress() +
                    ", " + a.getCity() +
                    ", " + a.getState() +
                    ", " + a.getZip());
        }
    }

}
