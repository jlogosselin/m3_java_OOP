package Assignment_DVDCollection.controller;

import Assignment_DVDCollection.dao.DVDCollectionDao;
import Assignment_DVDCollection.dao.DVDCollectionDaoException;
import Assignment_DVDCollection.dto.DVDItem;
import Assignment_DVDCollection.ui.DVDCollectionView;

import java.util.List;

public class DVDCollectionController {

    private DVDCollectionView view;
    private DVDCollectionDao dao;

    public DVDCollectionController(DVDCollectionView v, DVDCollectionDao d){
        this.view = v;
        this.dao = d;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        listDVDs();
                        break;
                    case 2:
                        addDVD();
                        break;
                    case 3:
                        editDVD();
                        break;
                    case 4:
                        viewDVD();
                        break;
                    case 5:
                        removeDVD();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (DVDCollectionDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void addDVD() throws DVDCollectionDaoException {
        view.displayCreateDVDBanner();
        DVDItem newDVD = view.enterNewDVDEntry();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayCreateSuccessBanner();
    }

    private void listDVDs() throws DVDCollectionDaoException {
        view.displayAllDVDBanner();
        List<DVDItem> dvdList = dao.getAllDVDs();
        view.displayAllDVDs(dvdList);
    }

    private void viewDVD() throws DVDCollectionDaoException {
        view.displaySingleDVDBanner();
        String title = view.getDVDTitleID();
        DVDItem dvd = dao.getSingleDVD(title);
        view.displaySingleDVD(dvd);
    }

    private void editDVD() throws DVDCollectionDaoException{
        //asking the user which DVD they want to edit:
        view.displayEditDVDBanner();
        String title = view.getDVDTitleID();
        DVDItem dvd = dao.getSingleDVD(title);
        //asking the user what attribute they wish to edit in this DVD:
        int choice = view.chooseDVDEditingOption(dvd);
        switch(choice){
            case 1:
                dvd.setTitle(view.enterNewTitle());
                break;
            case 2:
                dvd.setReleaseDate(view.enterNewReleaseDate());
                break;
            case 3:
                dvd.setMpaRating(view.enterNewMPARating());
                break;
            case 4:
                dvd.setDirectorName(view.enterNewDirectorName());
                break;
            case 5:
                dvd.setStudioName(view.enterNewStudioName());
                break;
            case 6:
                dvd.setUserRating(view.enterNewUserRating());
                break;
        }
        DVDItem editedDVD = dao.editDVDinCollection(choice, title, dvd);

        view.displayEditingSuccessBanner(editedDVD);
    }

    private void removeDVD() throws DVDCollectionDaoException {
        view.displayRemoveDVDBanner();
        String title = view.getDVDTitleID();
        DVDItem removedDVD = dao.removeDVD(title);
        view.displayRemoveResultBanner(removedDVD);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    private void exitMessage() {
        view.displayExitBanner();
    }

}
