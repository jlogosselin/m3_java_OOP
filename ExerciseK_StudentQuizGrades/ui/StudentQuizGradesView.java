package ExerciseK_StudentQuizGrades.ui;


import ExerciseK_StudentQuizGrades.dto.Student;

import java.util.List;

public class StudentQuizGradesView {

        /*
    In the same way that we injected dependency in our CONTROLLER class,
    we will get rid of our hard-coded reference below and replace this with
    a member initialise in the constructor:
     */
    //private UserIO io = new UserIOConsoleImpl();

    private ExerciseK_StudentQuizGrades.ui.UserIO io;

    public StudentQuizGradesView(UserIO u){
        this.io = u;
    }

    public int printMenuAndGetSelection() {

        io.print("Main Menu");
        io.print("1. Print all student-score data");
        io.print("2. Create new piece of student-score data");
        io.print("3. View specific piece of student-score data");
        io.print("4. Remove specific piece of student-score data");
        io.print("5. Exit");

        return io.readInt("Please select from the above choices.", 1, 5);
    }

    public Student enterNewStudentScoreData() {

        String studentName = io.readString("Please enter full Student name:");
        Student currentStudent = new Student(studentName);
        int numberScores = io.readInt("How many scores do you wish to enter?");
        for(int i=0; i<numberScores; i++){
            int score = io.readInt("Enter score no." + (i+1) + ":");

        }
        int scoreData = io.readInt("Please enter score:");


        return currentStudent;
    }

    public void displayCreateStudentBanner() {
        io.print("=== Create Student ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString(
                "Student successfully created.  Please hit enter to continue");
    }

    public void displayStudentList(List<Student> studentList) {
        for (Student currentStudent : studentList) {
            String studentInfo = String.format("#%s : %s %s [%s]",
                    currentStudent.getStudentId(),
                    currentStudent.getFirstName(),
                    currentStudent.getLastName(),
                    currentStudent.getCohort());
            io.print(studentInfo);
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All Students ===");
    }

    public void displayDisplayStudentBanner () {
        io.print("=== Display Student ===");
    }

    public String getStudentIdChoice() {
        return io.readString("Please enter the Student ID.");
    }

    public void displayStudent(Student student) {
        if (student != null) {
            io.print(student.getStudentId());
            io.print(student.getFirstName() + " " + student.getLastName());
            io.print(student.getCohort());
            io.print("");
        } else {
            io.print("No such student.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveStudentBanner () {
        io.print("=== Remove Student ===");
    }

    public void displayRemoveResult(Student studentRecord) {
        if(studentRecord != null){
            io.print("Student successfully removed.");
        }else{
            io.print("No such student.");
        }
        io.readString("Please hit enter to continue.");
    }

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
}
