package ExerciseF_UserIO_Interface;

public interface UserIO {

    /*
    Reminder: an interface is a "contract", where the interface lists
    a series of method definitions (or signatures) which
    should be implemented by other of classes.

    NOTE: no access modifiers (PUBLIC, PRIVATE, PROTECTED...) are ever added to these method definitions!
     */

    void print(String message);
    String readString(String prompt);
    int readInt(String prompt);
    int readInt(String prompt, int min, int max);
    double readDouble(String prompt);
    double readDouble(String prompt, double min, double max);
    float readFloat(String prompt);
    float readFloat(String prompt, float min, float max);
    long readLong(String prompt);
    long readLong(String prompt, long min, long max);
}
