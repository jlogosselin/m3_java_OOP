package ExerciseK_StudentQuizGrades_UNFINISHED;

import ExerciseK_StudentQuizGrades_UNFINISHED.controller.StudentQuizGradesController;
import ExerciseK_StudentQuizGrades_UNFINISHED.dao.StudentQuizGradesDao;
import ExerciseK_StudentQuizGrades_UNFINISHED.dao.StudentQuizGradesDaoImpl;
import ExerciseK_StudentQuizGrades_UNFINISHED.ui.StudentQuizGradesView;
import ExerciseK_StudentQuizGrades_UNFINISHED.ui.UserIO;
import ExerciseK_StudentQuizGrades_UNFINISHED.ui.UserIOConsoleImpl;

public class EntryPoint_StudentQuizScores {

    public static void main(String[] args) {

        UserIO myIo = new UserIOConsoleImpl();

        StudentQuizGradesView myView = new StudentQuizGradesView(myIo);

        StudentQuizGradesDao myDao = new StudentQuizGradesDaoImpl();

        StudentQuizGradesController controller = new StudentQuizGradesController(myView, myDao);

        controller.run();

    }
}
