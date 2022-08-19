package ExerciseK_StudentQuizGrades.dto;

public class Student {

    private String fullName;

    public Student(String studentName) {
        this.fullName = studentName;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fn) {
        this.fullName = fn;
    }

}
