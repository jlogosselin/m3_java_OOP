package StudentQuizGrades.dao;

import StudentQuizGrades.dto.Scores;

import java.util.List;
import java.util.Map;

public interface StudentQuizGradesDao {

    Map<String, Scores> setSingleRowOfStudentScores(String studentName, Scores scoreData)
            throws StudentQuizGradesDaoException;

    List<String> getAllStudentScoresRowsAsListOfStrings() throws StudentQuizGradesDaoException;

    List<Integer> getScoresFromSpecificStudent(String studentName) throws StudentQuizGradesDaoException;

    Map<String, Scores> removeSingleRowOfStudentScores(String studentName) throws StudentQuizGradesDaoException;

    Map<Integer, Double> getAverageScore() throws StudentQuizGradesDaoException;
}
