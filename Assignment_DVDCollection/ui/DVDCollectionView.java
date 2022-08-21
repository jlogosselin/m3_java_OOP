package Assignment_DVDCollection.ui;

import Assignment_DVDCollection.dto.DVDItem;
import java.util.List;

public class DVDCollectionView {

    private UserIO io;

    public DVDCollectionView(UserIO u){this.io = u;}

    //all banners

    public void displayCreateDVDBanner() {
        io.print("=== Creating a new DVD entry ===");
    }
    public void displayCreateSuccessBanner() {io.print("DVD entry successfully created!");}
    public String getDVDTitleID() {
        return io.readString("Please enter the DVD title.");
    }
    public void displayAllDVDBanner() {io.print("=== Displaying All DVDs ===");}
    public void displaySingleDVDBanner() {
        io.print("=== Displaying single DVD ===");
    }
    public void displayEditDVDBanner() {
        io.print("=== Editing single DVD ===");
    }
    public void displayRemoveDVDBanner () {
        io.print("=== Removing DVD entry ===");
    }
    public void displayRemoveResultBanner(DVDItem dvd) {if(dvd != null){io.print("DVD entry successfully removed!");}else{io.print("No such DVD exists in the collection.");}}
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }
    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
    public void displayErrorMessage(String errorMsg) {io.print("=== ERROR ===");io.print(errorMsg);}
    public void displayEditingSuccessBanner(DVDItem dvd) {
        if(dvd != null){io.print("DVD entry successfully edited!");}
    }

    //--------------------------------------------------------------------------------------------

    //all IO method implementations

    public int printMenuAndGetSelection() {
        io.print("\nMain Menu");
        io.print("1. List all DVD entries");
        io.print("2. Add new DVD entry");
        io.print("3. Edit DVD entry");
        io.print("4. View a specific DVD entry");
        io.print("5. Remove a DVD entry");
        io.print("6. Exit");
        return io.readInt("Please select from the above choices, between ", 1, 6);
    }

    public DVDItem enterNewDVDEntry() {
        String titleID = io.readString("Please enter movie title");
        String releaseDate = io.readString("Please enter movie's release date");
        String mpaRating = io.readString("Please enter MPA rating");
        String directorName = io.readString("Please enter director's name");
        String studioName = io.readString("Please enter name of studio");
        String userRating = io.readString("Please enter user rating (if any)");

        DVDItem currentDVD = new DVDItem(titleID);
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setMpaRating(mpaRating);
        currentDVD.setDirectorName(directorName);
        currentDVD.setStudioName(studioName);
        currentDVD.setUserRating(userRating);

        return currentDVD;
    }

    public void displayAllDVDs(List<DVDItem> dvdList) {
        for (DVDItem currentDVD : dvdList) {
            String dvdInfo = String.format("%s : %s, %s, %s, %s, %s",
                    currentDVD.getTitle(),
                    currentDVD.getReleaseDate(),
                    currentDVD.getMpaRating(),
                    currentDVD.getDirectorName(),
                    currentDVD.getStudioName(),
                    currentDVD.getUserRating());
            io.print(dvdInfo);
        }
    }

    public void displaySingleDVD(DVDItem dvd) {
        if (dvd != null) {
            io.print("Title: " + dvd.getTitle());
            io.print("Release date: " + dvd.getReleaseDate());
            io.print("MPA Rating: " + dvd.getMpaRating());
            io.print("Director's Name: " + dvd.getDirectorName());
            io.print("Producing movie studio: " + dvd.getStudioName());
            io.print("User rating (if any): " + dvd.getUserRating());
            io.print("");
        } else {
            io.print("No such DVD currently exists in the collection.");
        }
    }

    public int chooseDVDEditingOption (DVDItem dvd) {
        if (dvd != null) {
            io.print("What would you like to change in the DVD entry " + dvd.getTitle() + "?");
            io.print("1. title");
            io.print("2. release date");
            io.print("3. MPA rating");
            io.print("4. director name");
            io.print("5. studio name");
            io.print("6. user rating");
            return io.readInt("Please select from the above choices, between ", 1, 6);
        } else {
            io.print("No such DVD currently exists in the collection.");
            return 0;
        }
    }

    public String enterNewTitle(){
        String titleID = io.readString("Please enter new movie title");
        return titleID;
    }

    public String enterNewReleaseDate(){
        String releaseDate = io.readString("Please enter new release date");
        return releaseDate;
    }

    public String enterNewMPARating(){
        String mpaRating = io.readString("Please enter MPA rating");
        return mpaRating;
    }

    public String enterNewDirectorName(){
        String directorName = io.readString("Please enter director's name");
        return directorName;
    }

    public String enterNewStudioName(){
        String studioName = io.readString("Please enter name of studio");
        return studioName;
    }

    public String enterNewUserRating(){
        String userRating = io.readString("Please enter user rating (if any)");
        return userRating;
    }


}
