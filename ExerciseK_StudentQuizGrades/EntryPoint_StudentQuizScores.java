package ExerciseK_StudentQuizGrades;

import ExerciseK_StudentQuizGrades.controller.StudentQuizGradesController;
import ExerciseK_StudentQuizGrades.dao.StudentQuizGradesDao;
import ExerciseK_StudentQuizGrades.dao.StudentQuizGradesDaoImpl;
import ExerciseK_StudentQuizGrades.ui.StudentQuizGradesView;
import ExerciseK_StudentQuizGrades.ui.UserIO;
import ExerciseK_StudentQuizGrades.ui.UserIOConsoleImpl;

public class EntryPoint_StudentQuizScores {

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
        StudentQuizGradesView myView = new StudentQuizGradesView(myIo);
        StudentQuizGradesDao myDao = new StudentQuizGradesDaoImpl();
        StudentQuizGradesController controller = new StudentQuizGradesController(myView, myDao);
        controller.run();

    }
}
