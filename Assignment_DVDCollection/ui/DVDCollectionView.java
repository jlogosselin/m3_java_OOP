package Assignment_DVDCollection.ui;

import Assignment_DVDCollection.dto.DVDItem;
import java.util.List;

public class DVDCollectionView {

    private UserIO io;

    public DVDCollectionView(UserIO u){this.io = u;}

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List all DVD entries");
        io.print("2. Add new DVD entry");
        io.print("3. Edit DVD entry");
        io.print("4. View a specific DVD entry");
        io.print("5. Remove a DVD entry");
        io.print("6. Exit");
        return io.readInt("Please select from the above choices.", 1, 6);
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

    public void displayCreateDVDBanner() {
        io.print("=== Create DVD entry ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString(
                "DVD entry successfully created.  Please hit enter to continue");
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
        io.readString("Please hit enter to continue.");
    }

    public void displayAllDVDBanner() {io.print("=== Display All DVDs ===");}

    public void displaySingleDVDBanner() {
        io.print("=== Display single DVD ===");
    }

    public String getDVDTitleID() {
        return io.readString("Please enter the DVD title.");
    }

    public void displaySingleDVD(DVDItem dvd) {
        if (dvd != null) {
            io.print(dvd.getTitle());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getMpaRating());
            io.print(dvd.getDirectorName());
            io.print(dvd.getStudioName());
            io.print(dvd.getUserRating());
            io.print("");
        } else {
            io.print("No such DVD exists.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveDVDBanner () {
        io.print("=== Remove DVD entry ===");
    }

    public void displayRemoveResult(DVDItem dvd) {
        if(dvd != null){
            io.print("DVD successfully removed.");
        }else{
            io.print("No such DVD exists.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
