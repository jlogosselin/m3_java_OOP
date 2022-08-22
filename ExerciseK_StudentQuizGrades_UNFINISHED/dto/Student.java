package ExerciseK_StudentQuizGrades_UNFINISHED.dto;

public class Student {

    private String fullName;

    public Student(String studentName) {
        this.fullName = studentName;
    }
    public String getStudentName() {
        return fullName;
    }
    public void setFullName(String fn) {
        this.fullName = fn;
    }

}
