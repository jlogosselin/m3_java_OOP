package Assignment_DVDCollection.dao;

import Assignment_DVDCollection.dto.DVDItem;

import java.io.*;
import java.util.*;

public class DVDCollectionDaoFileImpl implements DVDCollectionDao{

    private Map<String, DVDItem> allDVDsStoredInMemory = new HashMap<>();
    public static final String DVD_COLLECTION_FILE = "dvd_collection.txt";
    public static final String DELIMITER = "::";

    public DVDCollectionDaoFileImpl(){}

    @Override
    public DVDItem addDVD(String title, DVDItem dvd) throws DVDCollectionDaoException {
        loadDVDCollectionFromFileToMemory();
        DVDItem newDVD = this.allDVDsStoredInMemory.put(title, dvd); //put() is a built-in method for hashmaps
        writeDVDCollectionFromMemoryToFile();
        return newDVD;
    }

    @Override
    public List<DVDItem> getAllDVDs() throws DVDCollectionDaoException {
        loadDVDCollectionFromFileToMemory();
        return new ArrayList(this.allDVDsStoredInMemory.values()); //values() is a built-in method for hashmaps
    }

    @Override
    public DVDItem getSingleDVD(String title) throws DVDCollectionDaoException {
        loadDVDCollectionFromFileToMemory();
        return this.allDVDsStoredInMemory.get(title); //get() is a built-in method for hashmaps
    }

    @Override
    public DVDItem removeDVD(String title) throws DVDCollectionDaoException {
        loadDVDCollectionFromFileToMemory();
        DVDItem removedDVD = this.allDVDsStoredInMemory.remove(title); //remove() is a built-in method for hashmaps
        writeDVDCollectionFromMemoryToFile();
        return removedDVD;
    }

    @Override
    public DVDItem editDVDinCollection(int choice, String title, DVDItem newDVDEntry) throws DVDCollectionDaoException {
        /*
        REMEMBER: it is impossible rename/modify the hashmap key once added
        Only way is to delete/remove the key and insert with new key and value pair.
        Reason : In hashmap internal implementation the Hashmap key modifier marked as final
         */
        loadDVDCollectionFromFileToMemory();
        DVDItem editedDVD;

        if(choice == 1){
            //step 1: removing old version of specific DVD data:
            this.allDVDsStoredInMemory.remove(title);
            //step 2: adding new version of specific DVD:
            this.allDVDsStoredInMemory.put(newDVDEntry.getTitle(), newDVDEntry);
            editedDVD = newDVDEntry;
        }
        else editedDVD = this.allDVDsStoredInMemory.replace(title, newDVDEntry); //replace() is a built-in method for hashmaps

        writeDVDCollectionFromMemoryToFile();
        return editedDVD;
    }

    private DVDItem unmarshallDVD(String dvdAsText){

        // dvdAsText is expecting a line read in from our file.
        // For example, it might look like this:
        // The Mission::1986-10-01::PG-13::Roland Joffe::Warner Bros::Excellent movie!
        //
        // We then split that line on our DELIMITER - which we are using as ::
        // Leaving us with an array of Strings, stored in dvdTokens.
        // Which should look like this:
        // _______________________________________________________________________
        // |           |          |     |            |           |
        // |The Mission|1986-10-01|PG-13|Roland Joffe|Warner Bros|Excellent movie!
        // |           |          |     |            |           |
        // -----------------------------------------------------------------------
        //      [0]         [1]     [2]      [3]          [4]          [5]

        String[] dvdTokens = dvdAsText.split(DELIMITER);
        String title = dvdTokens[0];
        DVDItem dvdFromFile = new DVDItem(title);
        dvdFromFile.setReleaseDate(dvdTokens[1]);
        dvdFromFile.setMpaRating(dvdTokens[2]);
        dvdFromFile.setDirectorName(dvdTokens[3]);
        dvdFromFile.setStudioName(dvdTokens[4]);
        dvdFromFile.setUserRating(dvdTokens[5]);

        return dvdFromFile;
    }

    private void loadDVDCollectionFromFileToMemory() throws DVDCollectionDaoException {

        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(DVD_COLLECTION_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDCollectionDaoException(
                    "-_- Could not DVD collection data into memory.", e);
        }

        String currentLine;
        DVDItem currentDVD;


        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentDVD = unmarshallDVD(currentLine);
            this.allDVDsStoredInMemory.put(currentDVD.getTitle(), currentDVD);
        }
        scanner.close();
    }

    private String marshallDVD(DVDItem aDVD){

        // For example, we need an in-memory object to end up in this file format:
        // The Mission::1986-10-01::PG-13::Roland Joffe::Warner Bros::Excellent movie!

        String dvdAsText = aDVD.getTitle() + DELIMITER;
        dvdAsText += aDVD.getReleaseDate() + DELIMITER;
        dvdAsText += aDVD.getMpaRating() + DELIMITER;
        dvdAsText += aDVD.getDirectorName() + DELIMITER;
        dvdAsText += aDVD.getStudioName() + DELIMITER;
        dvdAsText += aDVD.getUserRating();
        return dvdAsText;
    }

    /**
     * Writes all dvds in the collection out to a DVD_COLLECTION_FILE.
     *
     * @throws DVDCollectionDaoException if an error occurs writing to the file
     */
    private void writeDVDCollectionFromMemoryToFile() throws DVDCollectionDaoException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(DVD_COLLECTION_FILE));
        } catch (IOException e) {
            throw new DVDCollectionDaoException(
                    "Could not save DVD data from memory to file.", e);
        }

        String dvdAsText;
        List<DVDItem> dvdList = this.getAllDVDs();
        for (DVDItem currentDVD : dvdList) {
            dvdAsText = marshallDVD(currentDVD);
            out.println(dvdAsText);
            out.flush();
        }
        // Clean up
        out.close();
    }


}
