package ExerciseK_StudentQuizGrades_UNFINISHED.dao;

import ExerciseK_StudentQuizGrades_UNFINISHED.dto.Scores;
import ExerciseK_StudentQuizGrades_UNFINISHED.dto.Student;

import java.io.*;
import java.util.*;

public class StudentQuizGradesDaoImpl implements StudentQuizGradesDao{

    //creating our COLLECTION DATA STRUCTURE attribute (of class types STUDENT & SCORES):
    private Map<Student, Scores> studentScoreData = new HashMap<>();
    public static final String QUIZ_SCORES_FILE = "quiz_scores.txt";
    public static final String DELIMITER = "::";

    public StudentQuizGradesDaoImpl(){}

    ///////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////// implementing methods from DAO_INTERFACE  ///////////////////
    ///////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////

    @Override
    public Map<Student, Scores> setSingleRowOfStudentScores(Student student, Scores scoreData)
            throws StudentQuizGradesDaoException {
        loadQuizScoreFileIntoHashMap();
        Map<Student, Scores> newStudentScoreData =
                (Map<Student, Scores>) this.studentScoreData.put(student, scoreData);
        writeHashMapToFile();
        return newStudentScoreData;
    }


    @Override
    public List<String> getAllStudentScoresRowsAsListOfStrings() throws StudentQuizGradesDaoException {

        loadQuizScoreFileIntoHashMap();

        List<String> listOfAllStudentScoreData = new ArrayList<String>();
        int x = 0;
        for(Student key: this.studentScoreData.keySet()) {
            String fullDataLine = "";
            fullDataLine += key.getStudentName();
            fullDataLine += "::";
            Scores s = studentScoreData.get(key);
            for (Integer i : s.getListOfAllScores()) {
                fullDataLine += i;
                fullDataLine += "::";
            }
            listOfAllStudentScoreData.add(fullDataLine);
        }

        return listOfAllStudentScoreData;
    }

    @Override
    public List<Integer> getScoresFromSpecificStudent(String studentName) throws StudentQuizGradesDaoException {
        loadQuizScoreFileIntoHashMap();
        Scores scores = this.studentScoreData.get(studentName);
        List<Integer> values = scores.getListOfAllScores();
        return values;
    }

    @Override
    public Map<Student, Scores> removeSingleRowOfStudentScores(String studentName)
            throws StudentQuizGradesDaoException {
        loadQuizScoreFileIntoHashMap();
        Map<Student, Scores> removedStudentScoreData =
                (Map<Student, Scores>) this.studentScoreData.remove(studentName);
        writeHashMapToFile();
        return removedStudentScoreData;
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////


    /*
    the method below reads the quiz score file into memory, saving the data
    inside our class attribute: the HASHMAP DATA STRUCTURE (declared + initialised above)
     */

    private void loadQuizScoreFileIntoHashMap() throws StudentQuizGradesDaoException {

        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(QUIZ_SCORES_FILE)));
        } catch (FileNotFoundException e) {
            throw new StudentQuizGradesDaoException(
                    "-_- Could not load quiz score data into memory.", e);
        }

        String currentLine;

        Map<Student, Scores> tempMap;

        while (scanner.hasNextLine()) {

            // get the next line in the file
            currentLine = scanner.nextLine();
            //System.out.println("Current line: " + currentLine);

            // unmarshalling the line (ie: eliminating its delimiters) into a temp map
            tempMap = unmarshallStudentScoreData(currentLine);

            //extracting key and value from the temp map:
            Map.Entry<Student, Scores> entry = tempMap.entrySet().iterator().next();
            String key = entry.getKey().getStudentName();
            Student tempStudent = new Student(key);
            Scores tempScores = entry.getValue();

            //saving data into our class attribute HASHMAP:
            this.studentScoreData.put(tempStudent, tempScores);

        }
        // close scanner
        scanner.close();
    }


    //******************************************************************************************
    //******************************************************************************************

    /*
    below is the helper method that can translate a line of text from a txt file
    into a one-row HASHMAP (of class types STUDENT & SCORES)
     */


    private Map<Student, Scores> unmarshallStudentScoreData(String studentScoreAsText){

        //STUDENT-SCORE data will be written in the txt file as so:
        // ______________________________________
        // |            | || || || || |
        // |John Dawson::9::1::4::5::8
        // |            | || || || || |
        // --------------------------------------
        //       [0]    [1][2][3][4][5] etc...

        String[] allTokens = studentScoreAsText.split(DELIMITER);

        String studentName = allTokens[0];

        Student studentFromFile = new Student(studentName);

        Scores scoresListFromFile = new Scores();

        for(int i=1; i<=5; i++){
            scoresListFromFile.addSingleScoreToList(Integer.parseInt(allTokens[i]));
        }


        //last but not least: combining the STUDENT and SCORES object to add data to the existing
        //HASHMAP object, before returning :

        Map<Student, Scores> hashMapFromFile = new HashMap<>();
        hashMapFromFile.put(studentFromFile,scoresListFromFile);
               // (Map<Student, Scores>) this.studentScoreData.put(studentFromFile,scoresListFromFile);

/*
        System.out.println("All data stored in temp hash map so far:");
        for( Map.Entry<Student, Scores> entry : hashMapFromFile.entrySet() ){
            System.out.println( entry.getKey().getStudentName() + " => " + entry.getValue().printFullListOfScores() );
        }
        System.out.println("All data stored in class hash map so far:");
        for( Map.Entry<Student, Scores> entry : this.studentScoreData.entrySet() ){
            System.out.println( entry.getKey().getStudentName() + " => " + entry.getValue().printFullListOfScores() );
        }

 */

        return hashMapFromFile;
    }



    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////


    /*
    the method below writes the student-score data stored in our class HASHMAP to a txt file:
     */

    /**
     * Writes all students in the roster out to a ROSTER_FILE.  See loadRoster
     * for file format.
     *
     * @throws StudentQuizGradesDaoException if an error occurs writing to the file
     */


    private void writeHashMapToFile() throws StudentQuizGradesDaoException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(QUIZ_SCORES_FILE));
        } catch (IOException e) {
            throw new StudentQuizGradesDaoException(
                    "Could not save student-score data.", e);
        }

        String studentScoreDataAsText;

        List<String> studentScoresList = this.getAllStudentScoresRowsAsListOfStrings();

        for (String s : studentScoresList) {

            studentScoreDataAsText = marshallStudent(s);

            // write the data to the file
            out.println(studentScoreDataAsText);

            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }


    //******************************************************************************************
    //******************************************************************************************


    /*
    below is the helper method that can translate the data from our HASHMAP into
     a line of text, so that it can then be written properly into a file.
     */


    private String marshallStudent(String singleRowOfStudentScores){

        return singleRowOfStudentScores;
    }


}
