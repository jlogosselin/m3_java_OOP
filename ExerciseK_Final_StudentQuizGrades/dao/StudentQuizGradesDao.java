package ExerciseK_Final_StudentQuizGrades.dao;

import ExerciseK_Final_StudentQuizGrades.dto.Scores;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface StudentQuizGradesDao {

    Map<String, Scores> setSingleRowOfStudentScores(String studentName, Scores scoreData)
            throws StudentQuizGradesDaoException;

    List<String> getAllStudentScoresRowsAsListOfStrings() throws StudentQuizGradesDaoException;

    List<Integer> getScoresFromSpecificStudent(String studentName) throws StudentQuizGradesDaoException;

    Map<String, Scores> removeSingleRowOfStudentScores(String studentName) throws StudentQuizGradesDaoException;

    Map<Integer, Double> getAverageScore() throws StudentQuizGradesDaoException;

    LinkedHashMap<String, Integer> preliminaryMethodForGettingTotalScores() throws StudentQuizGradesDaoException;

    String getHighestScore(LinkedHashMap<String, Integer> l) throws StudentQuizGradesDaoException;

    String getLowestScore(LinkedHashMap<String, Integer> l) throws StudentQuizGradesDaoException;


}
