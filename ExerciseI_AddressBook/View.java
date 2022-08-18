package ExerciseI_AddressBook;

//used by CONTROLLER to handle user interaction

public class View {

    private UserIO userIO;

    public View(){
        userIO = new UserIO();
    }

    public void showMenu(){
        userIO.menu();
    }

    public int takeUserChoice(){
        return userIO.verifyUserChoice();
    }

    public String[] enterUserDataManually(){
        String[] allData = new String[6];
        for(int i=0; i<6; i++){
            allData[i] = userIO.enterData(i);
        }
        return allData;
    }

}
