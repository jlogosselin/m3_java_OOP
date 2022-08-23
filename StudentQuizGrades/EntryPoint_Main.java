package StudentQuizGrades;

import StudentQuizGrades.controller.StudentQuizGradesController;
import StudentQuizGrades.dao.StudentQuizGradesDao;
import StudentQuizGrades.dao.StudentQuizGradesDaoImpl;
import StudentQuizGrades.ui.StudentQuizGradesView;
import StudentQuizGrades.ui.UserIO;
import StudentQuizGrades.ui.UserIOConsoleImpl;

public class EntryPoint_Main {
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        StudentQuizGradesView myView = new StudentQuizGradesView(myIo);
        StudentQuizGradesDao myDao = new StudentQuizGradesDaoImpl();
        StudentQuizGradesController controller = new StudentQuizGradesController(myView, myDao);
        controller.run();
    }
}
