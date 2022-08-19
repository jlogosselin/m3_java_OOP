package ExerciseK_StudentQuizGrades.dao;




import ExerciseK_StudentQuizGrades.dto.Scores;
import ExerciseK_StudentQuizGrades.dto.Student;

import java.io.*;
import java.security.KeyStore;
import java.util.*;

public class StudentQuizGradesDaoImpl implements StudentQuizGradesDao{

    private Map<Student, Scores> studentScoreData = new HashMap<>();
    public static final String QUIZ_SCORES_FILE = "quiz_scores.txt";
    public static final String DELIMITER = "::";

    public StudentQuizGradesDaoImpl(){}

    @Override
    public Map<Student, Scores> addStudentScoreData(Student student, Scores scoreData)
            throws StudentQuizGradesDaoException {
        loadRoster();
        Map<Student, Scores> newStudentScoreData =
                (Map<Student, Scores>) this.studentScoreData.put(student, scoreData);
        writeRoster();
        return newStudentScoreData;
    }


    @Override
    public String[] getAllStudentData() throws StudentQuizGradesDaoException {
        loadRoster();
        //MUST LOOK INTO THIS!
        //excellent link: https://stackoverflow.com/questions/12960265/retrieve-all-values-from-hashmap-keys-in-an-arraylist-java
        // other link: https://stackoverflow.com/questions/16246821/how-to-get-values-and-keys-from-hashmap

        String[] allStudentScoreData = new String[this.studentScoreData.size()];
        int x = 0;
        for(Student key: this.studentScoreData.keySet()) {
            String fullDataLine = "";
            fullDataLine += key.getFullName();
            fullDataLine += "::";
            Scores s = studentScoreData.get(key);
            for (Integer i : s.getAllScores()) {
                fullDataLine += i;
                fullDataLine += "::";
            }
            allStudentScoreData[x] = fullDataLine;

        }
        return allStudentScoreData;
    }



    @Override
    public ArrayList<Integer> getScoresFromSpecificStudent(String studentName) throws StudentQuizGradesDaoException {
        loadRoster();
        ArrayList<Integer> values = this.studentScoreData.get(studentName);
        return values;
    }

    @Override
    public Map<String, ArrayList<Integer>> removeStudentScoreData(String studentName)
            throws StudentQuizGradesDaoException {
        loadRoster();
        Map<String, ArrayList<Integer>> removedStudentScoreData =
                (Map<String, ArrayList<Integer>>) this.studentScoreData.remove(studentName);
        writeRoster();
        return removedStudentScoreData;
    }

    ///////////////////////////////////////////////////////////////

    //below is a method that can translate a line of text from a txt file
    // into a Student object

    private Student unmarshallStudent(String studentScoreAsText){
        // ______________________________________
        // |    |   |        |                  |
        // |1234|Ada|Lovelace|Java-September1842|
        // |    |   |        |                  |
        // --------------------------------------
        //  [0]  [1]    [2]         [3]
        String[] studentScoreTokens = studentScoreAsText.split(DELIMITER);

        // Given the pattern above, the student Id is in index 0 of the array.
        String studentId = studentScoreTokens[0];

        // Which we can then use to create a new Student object to satisfy
        // the requirements of the Student constructor.
        Student studentFromFile = new Student(studentId);

        // However, there are 3 remaining tokens that need to be set into the
        // new student object. Do this manually by using the appropriate setters.

        // Index 1 - FirstName
        studentFromFile.setFirstName(studentTokens[1]);

        // Index 2 - LastName
        studentFromFile.setLastName(studentTokens[2]);

        // Index 3 - Cohort
        studentFromFile.setCohort(studentTokens[3]);

        // We have now created a student! Return it!
        return studentFromFile;
    }

    //below is another method which this time
    // reads the roster file into memory

    private void loadRoster() throws ClassRosterDaoException {

        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(QUIZ_SCORES_FILE)));
        } catch (FileNotFoundException e) {
            throw new ClassRosterDaoException(
                    "-_- Could not load roster data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentStudent holds the most recent student unmarshalled
        Student currentStudent;
        // Go through ROSTER_FILE line by line, decoding each line into a
        // Student object by calling the unmarshallStudent method.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a Student
            currentStudent = unmarshallStudent(currentLine);

            // We are going to use the student id as the map key for our student object.
            // Put currentStudent into the map using student id as the key
            this.students.put(currentStudent.getStudentId(), currentStudent);
        }
        // close scanner
        scanner.close();
    }

    //the method below organizes student information from an in-memory object
    // into a line of text, so that it can then be written properly into a file.

    private String marshallStudent(Student aStudent){
        // We need to turn a Student object into a line of text for our file.
        // For example, we need an in memory object to end up like this:
        // 4321::Charles::Babbage::Java-September1842

        // It's not a complicated process. Just get out each property,
        // and concatenate with our DELIMITER as a kind of spacer.

        // Start with the student id, since that's supposed to be first.
        String studentAsText = aStudent.getStudentId() + DELIMITER;

        // add the rest of the properties in the correct order:

        // FirstName
        studentAsText += aStudent.getFirstName() + DELIMITER;

        // LastName
        studentAsText += aStudent.getLastName() + DELIMITER;

        // Cohort - don't forget to skip the DELIMITER here.
        studentAsText += aStudent.getCohort();

        // We have now turned a student to text! Return it!
        return studentAsText;
    }

    //the method below writes the student information from memory to a file:

    /**
     * Writes all students in the roster out to a ROSTER_FILE.  See loadRoster
     * for file format.
     *
     * @throws ClassRosterDaoException if an error occurs writing to the file
     */
    private void writeRoster() throws ClassRosterDaoException {
        // NOTE FOR APPRENTICES: We are not handling the IOException - but
        // we are translating it to an application specific exception and
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to
        // handle any errors that occur.
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(QUIZ_SCORES_FILE));
        } catch (IOException e) {
            throw new ClassRosterDaoException(
                    "Could not save student data.", e);
        }

        // Write out the Student objects to the roster file.
        // NOTE TO THE APPRENTICES: We could just grab the student map,
        // get the Collection of Students and iterate over them but we've
        // already created a method that gets a List of Students so
        // we'll reuse it.
        String studentAsText;
        List<Student> studentList = this.getAllStudents();
        for (Student currentStudent : studentList) {
            // turn a Student into a String
            studentAsText = marshallStudent(currentStudent);
            // write the Student object to the file
            out.println(studentAsText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }


}
