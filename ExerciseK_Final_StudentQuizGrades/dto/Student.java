package ExerciseK_Final_StudentQuizGrades.dto;

public class Student {

    String fullName;
    public Student(String s){
        this.fullName = s;
    }
    public String getStudentName(){
        return this.fullName;
    }
}
