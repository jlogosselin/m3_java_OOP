package ExerciseK_Final_StudentQuizGrades;

import ExerciseK_Final_StudentQuizGrades.controller.StudentQuizGradesController;
import ExerciseK_Final_StudentQuizGrades.dao.StudentQuizGradesDao;
import ExerciseK_Final_StudentQuizGrades.dao.StudentQuizGradesDaoImpl;
import ExerciseK_Final_StudentQuizGrades.ui.StudentQuizGradesView;
import ExerciseK_Final_StudentQuizGrades.ui.UserIO;
import ExerciseK_Final_StudentQuizGrades.ui.UserIOConsoleImpl;

public class EntryPoint_Main {
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        StudentQuizGradesView myView = new StudentQuizGradesView(myIo);
        StudentQuizGradesDao myDao = new StudentQuizGradesDaoImpl();
        StudentQuizGradesController controller = new StudentQuizGradesController(myView, myDao);
        controller.run();
    }
}
