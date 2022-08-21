package Assignment_DVDCollection.dao;

import Assignment_DVDCollection.dto.DVDItem;

import java.io.*;
import java.util.*;

public class DVDCollectionDaoFileImpl implements DVDCollectionDao{

    private Map<String, DVDItem> dvds = new HashMap<>();
    public static final String DVD_COLLECTION_FILE = "dvd_collection.txt";
    public static final String DELIMITER = "::";

    public DVDCollectionDaoFileImpl(){}

    @Override
    public DVDItem addDVD(String title, DVDItem dvd) throws DVDCollectionDaoException {
        loadDVDCollectionFromFileToMemory();
        DVDItem newDVD = this.dvds.put(title, dvd);
        writeDVDCollectionFromMemoryToFile();
        return newDVD;
    }

    @Override
    public List<DVDItem> getAllDVDs() throws DVDCollectionDaoException {
        loadDVDCollectionFromFileToMemory();
        return new ArrayList(this.dvds.values());
    }

    @Override
    public DVDItem getSingleDVD(String title) throws DVDCollectionDaoException {
        loadDVDCollectionFromFileToMemory();
        return this.dvds.get(title);
    }

    @Override
    public DVDItem removeDVD(String title) throws DVDCollectionDaoException {
        loadDVDCollectionFromFileToMemory();
        DVDItem removedDVD = this.dvds.remove(title);
        writeDVDCollectionFromMemoryToFile();
        return removedDVD;
    }

    ///////////////////////////////////////////////////////////////

    //below is a method that can translate a line of text from a txt file
    // into a DVDItem object

    private DVDItem unmarshallStudent(String dvdAsText){

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
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentStudent holds the most recent student unmarshalled
        DVDItem currentDVD;

        // Go through DVD_COLLECTION_FILE line by line, decoding each line into a
        // DVDItem object by calling the unmarshallStudent method.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a Student
            currentDVD = unmarshallStudent(currentLine);

            // We are going to use the student id as the map key for our student object.
            // Put currentStudent into the map using student id as the key
            this.dvds.put(currentDVD.getTitle(), currentDVD);
        }
        // close scanner
        scanner.close();
    }

    //the method below organizes student information from an in-memory object
    // into a line of text, so that it can then be written properly into a file.

    private String marshallDVD(DVDItem aDVD){

        // We need to turn a DVDItem object into a line of text for our file.
        // For example, we need an in memory object to end up like this:
        // The Mission::1986-10-01::PG-13::Roland Joffe::Warner Bros::Excellent movie!

        // It's not a complicated process. Just get out each property,
        // and concatenate with our DELIMITER as a kind of spacer.

        // Start with the title, since that's supposed to be first.
        String dvdAsText = aDVD.getTitle() + DELIMITER;

        // add the rest of the properties in the correct order:

        // Release Date
        dvdAsText += aDVD.getReleaseDate() + DELIMITER;

        // MPA Rating
        dvdAsText += aDVD.getMpaRating() + DELIMITER;

        // Director Name
        dvdAsText += aDVD.getDirectorName() + DELIMITER;

        // Studio Name
        dvdAsText += aDVD.getStudioName() + DELIMITER;

        // User Rating - don't forget to skip the DELIMITER here.
        dvdAsText += aDVD.getUserRating();

        // We have now turned a student to text! Return it!
        return dvdAsText;
    }

    //the method below writes the student information from memory to a file:

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
            // turn a Student into a String
            dvdAsText = marshallDVD(currentDVD);
            // write the Student object to the file
            out.println(dvdAsText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }


}
