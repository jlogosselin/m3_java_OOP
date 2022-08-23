package ExerciseK_Final_StudentQuizGrades.controller;


import ExerciseK_Final_StudentQuizGrades.dao.StudentQuizGradesDao;
import ExerciseK_Final_StudentQuizGrades.dao.StudentQuizGradesDaoException;
import ExerciseK_Final_StudentQuizGrades.dto.Scores;
import ExerciseK_Final_StudentQuizGrades.dto.Student;
import ExerciseK_Final_StudentQuizGrades.ui.StudentQuizGradesView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StudentQuizGradesController {

    private StudentQuizGradesView view;
    private StudentQuizGradesDao dao;

    public StudentQuizGradesController(StudentQuizGradesView v, StudentQuizGradesDao d){
        this.view = v;
        this.dao = d;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        listAllStudentScoresRows();
                        break;
                    case 2:
                        createSingleStudentScoresRow();
                        break;
                    case 3:
                        viewSingleStudentScoresRow();
                        break;
                    case 4:
                        removeStudentScoresRow();
                        break;
                    case 5:
                        getAverageQuizScoreForWholeClass();
                        break;
                    case 6:
                        getListOfStudentsWithHighestQuizScores();
                        break;
                    case 7:
                        getListOfStudentsWithLowestQuizScores();
                        break;
                    case 8:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        } catch (StudentQuizGradesDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    //done
    private void listAllStudentScoresRows() throws StudentQuizGradesDaoException {
        view.displayAllStudentScoreRowsBanner();
        List<String> studentList = new ArrayList<>();
        studentList.addAll(dao.getAllStudentScoresRowsAsListOfStrings());
        view.displayAllStudentScoreRows(studentList);
    }

    //done
    private void createSingleStudentScoresRow() throws StudentQuizGradesDaoException {
        view.displayCreateStudentScoreRowBanner();
        Student newStudent = view.enterNewStudentName();
        String newStudentName = newStudent.getStudentName();
        Scores newScores = view.enterNewRowOfScores();
        dao.setSingleRowOfStudentScores(newStudentName, newScores);
        view.displayCreateStudentScoreRowSuccessBanner();
    }

    //done
    private void viewSingleStudentScoresRow() throws StudentQuizGradesDaoException {
        view.displaySpecificStudentScoreRowBanner();
        String studentName = view.getStudentNameChoice();
        List<Integer> scoreList = dao.getScoresFromSpecificStudent(studentName);
        view.displaySpecificStudentScoreRow(studentName, scoreList);
    }

    private void removeStudentScoresRow() throws StudentQuizGradesDaoException {
        view.displayRemoveSpecificStudentScoreDataBanner();
        String studentName = view.enterStudentNameChoice();
        Map<String, Scores> changedMap = dao.removeSingleRowOfStudentScores(studentName);
        view.displayRemovedStudentScoreData(studentName, changedMap);
    }

    private void getAverageQuizScoreForWholeClass() throws StudentQuizGradesDaoException{
        view.displayAverageScoreBanner();
        Map<Integer, Double> results = dao.getAverageScore();
        view.displayAverage(results);
    }

    private void getListOfStudentsWithHighestQuizScores() throws StudentQuizGradesDaoException{
        view.displayStudentsWithHighestQuizScoresBanner();
        LinkedHashMap<String, Integer> preliminaryResults = dao.preliminaryMethodForGettingTotalScores();
        String finalResult = dao.getHighestScore(preliminaryResults);
        view.displayHighestScoreStudent(finalResult);
    }

    private void getListOfStudentsWithLowestQuizScores() throws StudentQuizGradesDaoException{
        view.displayStudentsWithLowestQuizScoresBanner();
        LinkedHashMap<String, Integer> preliminaryResults = dao.preliminaryMethodForGettingTotalScores();
        String finalResult = dao.getLowestScore(preliminaryResults);
        view.displayLowestScoreStudent(finalResult);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    private void exitMessage() {
        view.displayExitBanner();
    }
}
