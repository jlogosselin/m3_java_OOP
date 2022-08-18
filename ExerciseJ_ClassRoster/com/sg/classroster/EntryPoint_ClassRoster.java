package ExerciseJ_ClassRoster.com.sg.classroster;

import ExerciseJ_ClassRoster.com.sg.classroster.controller.ClassRosterController;
import ExerciseJ_ClassRoster.com.sg.classroster.dao.ClassRosterDao;
import ExerciseJ_ClassRoster.com.sg.classroster.dao.ClassRosterDaoFileImpl;
import ExerciseJ_ClassRoster.com.sg.classroster.ui.ClassRosterView;
import ExerciseJ_ClassRoster.com.sg.classroster.ui.UserIO;
import ExerciseJ_ClassRoster.com.sg.classroster.ui.UserIOConsoleImpl;

public class EntryPoint_ClassRoster {

    public static void main(String[] args) {

        /*
        Following the DEPENDENCY INJECTION we have implemented on our VIEW and CONTROLLER classes,
        we will need more than simply create an object of CONTROLLER class (below) and
        invoke its RUN() method (see code commented in below).
        */

        //ClassRosterController controller = new ClassRosterController();
        //controller.run();

        /*
        We will need to create instances of USER, VIEW and DAO classes, before passing these as parameters
        to the CONTROLLER's constructor.

        The MAIN therefore is where we configure, instantiate, and assemble the classes in our application.

        Our MAIN therefore requires the following:
        - Declare a UserIO variable and initialize it with a UserIOConsoleImpl reference.
        - Declare and instantiate a ClassRosterView object, passing the UserIO created
            in the previous step into the constructor.
        - Declare a ClassRosterDao variable and initialize it with a ClassRosterDaoFileImpl
            reference.
        - Instantiate a ClassRosterController, passing the ClassRosterDao and
            ClassRosterView object into the constructor.
        Call the run method on the controller to kick things off.
         */

        UserIO myIo = new UserIOConsoleImpl();
        ClassRosterView myView = new ClassRosterView(myIo);
        ClassRosterDao myDao = new ClassRosterDaoFileImpl();
        ClassRosterController controller = new ClassRosterController(myView, myDao);
        controller.run();

    }
}
