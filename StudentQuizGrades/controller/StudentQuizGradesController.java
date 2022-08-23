package StudentQuizGrades.controller;


import StudentQuizGrades.dao.StudentQuizGradesDao;
import StudentQuizGrades.dao.StudentQuizGradesDaoException;
import StudentQuizGrades.dto.Scores;
import StudentQuizGrades.dto.Student;
import StudentQuizGrades.ui.StudentQuizGradesView;

import java.util.ArrayList;
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
                        getListOfStudentWithHighestQuizScore();
                        break;
                    case 7:
                        getListOfStudentWithLowestQuizScore();
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

    private void getListOfStudentWithHighestQuizScore(){

    }

    private void getListOfStudentWithLowestQuizScore(){

    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    private void exitMessage() {
        view.displayExitBanner();
    }
}
