package StudentQuizGrades.ui;

import StudentQuizGrades.dto.Scores;
import StudentQuizGrades.dto.Student;

import java.text.DecimalFormat;
import java.util.Formatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StudentQuizGradesView {

    private StudentQuizGrades.ui.UserIO io;
    public StudentQuizGradesView(UserIO u){
        this.io = u;
    }

    /////////////////////////////////////   menu  /////////////////////////////////////////////

    public int printMenuAndGetSelection() {

        io.print("\nMain Menu");
        io.print("1. Print all student-score data");
        io.print("2. Add new student-score data");
        io.print("3. View specific student-score data");
        io.print("4. Remove specific student-score data");
        io.print("5. Get average of all group's quiz scores");
        io.print("6. Get list of students with highest scores");
        io.print("7. Get list of students with lowest scores");
        io.print("8. Exit");

        return io.readInt("Please select from the above choices.", 1, 5);
    }

    /////////////////////////////////////   all banners  /////////////////////////////////////////////

    public void displayCreateStudentScoreRowBanner() {io.print("=== Creating student-score data ===");}
    public void displayCreateStudentScoreRowSuccessBanner() {io.readString("Student-core data row successfully created.  Please hit enter to continue");}
    public void displayAllStudentScoreRowsBanner() {io.print("=== Displaying all student-score data ===");}
    public void displaySpecificStudentScoreRowBanner() {io.print("=== Displaying specific data for chosen Student ===");}
    public void displayAverageScoreBanner() {io.print("=== Displaying average score of whole group ===");}
    public String getStudentNameChoice() {return io.readString("Please enter the Student name.");}
    public void displayRemoveSpecificStudentScoreDataBanner () {io.print("=== Removing specific student-score row ===");}
    public void displayStudentsWithHighestQuizScoresBanner(){io.print("=== Displaying student with highest total score ===");}
    public void displayStudentsWithLowestQuizScoresBanner(){io.print("=== Displaying student with lowest total score ===");}
    public void displayExitBanner() {io.print("Goodbye!!!");}
    public void displayUnknownCommandBanner() {io.print("Unknown Command!!!");}
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
    }

    public void displaySpecificStudentScoreRow(String studentName, List<Integer> scoreList) {
        if (studentName != null) {
            io.print("Score data for student " + studentName + ": ");
            for(Integer i : scoreList){
                io.print(String.valueOf(i));
            }
        } else {io.print("No such student exists.");}
    }

    public void displayRemovedStudentScoreData(String studentRecord, Map<String, Scores> map) {
        boolean isInMap = map.containsKey(studentRecord);
        if(isInMap){
            io.print("Bizarre: this item was deleted...");
        }else{
            io.print("Student-Score row successfully removed.");
        }
    }

    public void displayAverage(Map<Integer, Double> singleMapRowForAverages){
        Map.Entry<Integer,Double> entry = singleMapRowForAverages.entrySet().iterator().next();
        Integer numberOfValues = entry.getKey();
        Double avg = entry.getValue();
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        io.print("The average of all " + numberOfValues + " quiz scores is: " + numberFormat.format(avg));
    }

    public void displayHighestScoreStudent(String results){
        io.print(results);
    }

    public void displayLowestScoreStudent(String results){
        io.print(results);
    }


}
