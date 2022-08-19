package ExerciseJ_ClassRoster.com.sg.classroster.controller;

//notice: must import classes from different packages
import ExerciseJ_ClassRoster.com.sg.classroster.dao.ClassRosterDao;
import ExerciseJ_ClassRoster.com.sg.classroster.dao.ClassRosterDaoException;
import ExerciseJ_ClassRoster.com.sg.classroster.dao.ClassRosterDaoFileImpl;
import ExerciseJ_ClassRoster.com.sg.classroster.dto.Student;
import ExerciseJ_ClassRoster.com.sg.classroster.ui.ClassRosterView;
import ExerciseJ_ClassRoster.com.sg.classroster.ui.UserIO;
import ExerciseJ_ClassRoster.com.sg.classroster.ui.UserIOConsoleImpl;

import java.util.List;

public class ClassRosterController {

    public ClassRosterController(){}

    /*
    Below: creating three instances of classes CLASSROSTERREVIEW,
    USERIO and CLASSROSTERDAO does not provide us with loose coupling.
    We are instead hard-cooding our references, which isn't great when the time
    comes for us to conduct UNIT TESTING.
    What need instead is DEPENDENCY INJECTION!
     */

    /*
    private ClassRosterView view = new ClassRosterView();
    private UserIO io = new UserIOConsoleImpl();
    private ClassRosterDao dao = new ClassRosterDaoFileImpl();
     */

    /*
    Instead of the above, we will simply declare PRIVATE members
    of these classes, then initialise them inside the CLASSROSTERCONTROLLER's
    own constructor, as so:
     */

    private ClassRosterView view;
    private ClassRosterDao dao;

    public ClassRosterController(ClassRosterView v, ClassRosterDao d){
        this.view = v;
        this.dao = d;
    }

    /*
    Why are we passing an instance of the ClassRosterView into our constructor?
    ClassRosterView is not an interface and we won't have any other implementations of it,
    so why use dependency injection here?

    The reason is that we are going to change ClassRosterView so that its dependency
    is injected into its constructor.

    We don't want to make the ClassRosterController responsible for injecting the right
    UserIO implementation into ClassRosterView;
    that is the job of the ENTRYPOINT_CLASSROSTER class!
     */


    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        listStudents();
                        break;
                    case 2:
                        createStudent();
                        break;
                    case 3:
                        viewStudent();
                        break;
                    case 4:
                        removeStudent();
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        } catch (ClassRosterDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createStudent() throws ClassRosterDaoException {
        view.displayCreateStudentBanner();
        Student newStudent = view.getNewStudentInfo();
        dao.addStudent(newStudent.getStudentId(), newStudent);
        view.displayCreateSuccessBanner();
    }

    private void listStudents() throws ClassRosterDaoException {
        view.displayDisplayAllBanner();
        List<Student> studentList = dao.getAllStudents();
        view.displayStudentList(studentList);
    }

    private void viewStudent() throws ClassRosterDaoException {
        view.displayDisplayStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student student = dao.getStudent(studentId);
        view.displayStudent(student);
    }

    private void removeStudent() throws ClassRosterDaoException {
        view.displayRemoveStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student removedStudent = dao.removeStudent(studentId);
        view.displayRemoveResult(removedStudent);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }


}
