package ExerciseK_StudentQuizGrades_UNFINISHED.dao;

import ExerciseK_StudentQuizGrades_UNFINISHED.dto.Scores;
import ExerciseK_StudentQuizGrades_UNFINISHED.dto.Student;

import java.util.List;
import java.util.Map;

public interface StudentQuizGradesDao {

    Map<Student, Scores> setSingleRowOfStudentScores(Student student, Scores scoreData)
            throws StudentQuizGradesDaoException;

    List<String> getAllStudentScoresRowsAsListOfStrings() throws StudentQuizGradesDaoException;

    List<Integer> getScoresFromSpecificStudent(String studentName) throws StudentQuizGradesDaoException;

    Map<Student, Scores>  removeSingleRowOfStudentScores(String studentName) throws StudentQuizGradesDaoException;
    //previously: Map<String, ArrayList<Integer>>

}
