package ExerciseK_StudentQuizGrades_UNFINISHED.ui;


import ExerciseK_StudentQuizGrades_UNFINISHED.dto.Scores;
import ExerciseK_StudentQuizGrades_UNFINISHED.dto.Student;

import java.util.List;
import java.util.Map;

public class StudentQuizGradesView {

    private ExerciseK_StudentQuizGrades_UNFINISHED.ui.UserIO io;
    public StudentQuizGradesView(UserIO u){
        this.io = u;
    }

    /////////////////////////////////////   menu  /////////////////////////////////////////////

    public int printMenuAndGetSelection() {

        io.print("Main Menu");
        io.print("1. Print all student-score data");
        io.print("2. Create new piece of student-score data");
        io.print("3. View specific piece of student-score data");
        io.print("4. Remove specific piece of student-score data");
        io.print("5. Exit");

        return io.readInt("Please select from the above choices.", 1, 5);
    }

    /////////////////////////////////////   all banners  /////////////////////////////////////////////

    public void displayCreateStudentScoreRowBanner() {
        io.print("=== Create Student-Score data ===");
    }
    public void displayCreateStudentScoreRowSuccessBanner() {io.readString("Student-Score data row successfully created.  Please hit enter to continue");}
    public void displayAllStudentScoreRowsBanner() {
        io.print("=== Display All Student-Score rows ===");
    }
    public void displaySpecificStudentScoreRowBanner() {
        io.print("=== Display Specific Data for chosen Student; enter name of student: ===");
    }
    public String getStudentNameChoice() {
        return io.readString("Please enter the Student name.");
    }
    public void displayRemoveSpecificStudentScoreDataBanner () {io.print("=== Remove Specific Student-Score row ===");}
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }
    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    /////////////////////////////////////   method implementation  /////////////////////////////////////////////

    //splitting IO method in two: one for STUDENT object, another for LIST OF SCORES object
    //(both these instances will be combined in a HASHMAP data structure in the DAO_IMPL class)

    public Student enterNewStudentName(){
        String studentName = io.readString("Please enter full Student name:");
        Student currentStudent = new Student(studentName);
        return currentStudent;
    }

    public Scores enterNewRowOfScores(){
        Scores scoreList = new Scores();
        io.print("Enter 5 quiz scores for this student:");
        for(int i=0; i<5; i++){
            int score = io.readInt("Enter score no." + (i+1) + ":");
            //implement score input verification...
            scoreList.addSingleScoreToList(score);
        }
        return scoreList;
    }

    public String enterStudentNameChoice(){
        String s = io.readString("Enter the name of the student whose score data you wish to remove:");
        return s;
    }

    /////////////////////////////////////////////////////////////////////////////////////////

    public void displayAllStudentScoreRows(List<String> fullStudentScoreDataRows) {
        for(String s : fullStudentScoreDataRows){
            System.out.println(s);
        }
        io.readString("Please hit enter to continue.");
    }

    public void displaySpecificStudentScoreRow(String studentName, List<Integer> scoreList) {
        if (studentName != null) {
            io.print("Score data for student " + studentName + ": ");
            for(Integer i : scoreList){
                io.print(String.valueOf(i));
            }
        } else {
            io.print("No such student exists.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveResult(String studentRecord, Map<Student, Scores> map) {
        boolean isInMap = map.containsKey(studentRecord);
        if(isInMap){
            io.print("Student-Score row successfully removed.");
        }else{
            io.print("No such student-score row exists.");
        }
        io.readString("Please hit enter to continue.");
    }


}
