package Assignment_DVDCollection;


import Assignment_DVDCollection.controller.DVDCollectionController;
import Assignment_DVDCollection.dao.DVDCollectionDao;
import Assignment_DVDCollection.dao.DVDCollectionDaoFileImpl;
import Assignment_DVDCollection.ui.DVDCollectionView;
import Assignment_DVDCollection.ui.UserIO;
import Assignment_DVDCollection.ui.UserIOConsoleImpl;

public class EntryPoint_Assignment {

    public static void main(String[] args) {

        UserIO myIo = new UserIOConsoleImpl();
        DVDCollectionView myView = new DVDCollectionView(myIo);
        DVDCollectionDao myDao = new DVDCollectionDaoFileImpl();
        DVDCollectionController controller = new DVDCollectionController(myView, myDao);
        controller.run();

    }
}
