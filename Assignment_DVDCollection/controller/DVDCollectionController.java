package Assignment_DVDCollection.controller;

import Assignment_DVDCollection.dao.DVDCollectionDao;
import Assignment_DVDCollection.dao.DVDCollectionDaoException;
import Assignment_DVDCollection.dto.DVDItem;
import Assignment_DVDCollection.ui.DVDCollectionView;

import java.util.List;

public class DVDCollectionController {

    private DVDCollectionView view;
    private DVDCollectionDao dao;

    public DVDCollectionController(){}
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

    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////

    //for later...
    private void editDVD() throws DVDCollectionDaoException{
        System.out.println("Not available yet");
    }

    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////


    private void removeDVD() throws DVDCollectionDaoException {
        view.displayRemoveDVDBanner();
        String title = view.getDVDTitleID();
        DVDItem removedDVD = dao.removeDVD(title);
        view.displayRemoveResult(removedDVD);
    }


    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

}
