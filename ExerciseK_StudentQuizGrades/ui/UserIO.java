package ExerciseK_StudentQuizGrades.ui;

public interface UserIO {
    void print(String msg);
    double readDouble(String prompt);
    double readDouble(String prompt, double min, double max);
    int readInt(String prompt);
    int readInt(String prompt, int min, int max);
    String readString(String prompt);
}
