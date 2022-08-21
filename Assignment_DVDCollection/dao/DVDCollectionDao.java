package Assignment_DVDCollection.dao;

import Assignment_DVDCollection.dto.DVDItem;

import java.util.List;

public interface DVDCollectionDao {

    /**
     * Adds the given DVD to the collection and associates it with the given
     * title. If there is already a DVD associated with the given
     * title id it will return that DVD object, otherwise it will
     * return null.
     * @param title used to check if DVD is already in the collection
     * @param dvd to be added to the collection
     * @return the DVDItem object previously associated with the given
     * title if it exists, null otherwise
     * @throws DVDCollectionDaoException
     */
    DVDItem addDVD(String title, DVDItem dvd)
            throws DVDCollectionDaoException;

    /**
     * Returns a List of all DVDs in the collection.
     *
     * @return DVD List containing all DVDs in the collection.
     * @throws DVDCollectionDaoException
     */
    List<DVDItem> getAllDVDs()
            throws DVDCollectionDaoException;

    /**
     * Returns the student object associated with the given student id.
     * Returns null if no such student exists
     *
     * @param title ID of the DVD to retrieve
     * @return the DVD object associated with the given title,
     * null if no such DVD exists
     * @throws DVDCollectionDaoException
     */
    DVDItem getSingleDVD(String title)
            throws DVDCollectionDaoException;

    /**
     * Removes from the collection the DVD associated with the given title.
     * Returns the DVD object that is being removed or null if
     * there is no DVD associated with the given title
     *
     * @param title id of DVD to be removed
     * @return DVD object that was removed or null if no DVD
     * was associated with the given title
     * @throws DVDCollectionDaoException
     */
    DVDItem removeDVD(String title)
            throws DVDCollectionDaoException;


    /**
     * Edits from the collection the DVD associated with the given title.
     * Returns the DVD object that is being edited or null if
     * there is no DVD associated with the given title
     * @param choice option chosen by the user
     * @param oldTitle title of DVD to be edited
     * @param newDVDEntry DVD item to be edited
     * @return DVD object that was edited or null if no DVD
     * was associated with the given title
     * @throws DVDCollectionDaoException
     */
    DVDItem editDVDinCollection(int choice, String oldTitle, DVDItem newDVDEntry)
            throws DVDCollectionDaoException;


}
