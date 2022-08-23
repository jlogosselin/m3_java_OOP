package StudentQuizGrades.dao;

import StudentQuizGrades.dto.Scores;

import java.io.*;
import java.util.*;
import java.util.HashMap;

public class StudentQuizGradesDaoImpl implements StudentQuizGradesDao{

    //creating our COLLECTION DATA STRUCTURE attribute (of class types STUDENT & SCORES):
    private Map<String, Scores> studentScoreData = new HashMap<>();
    public static final String QUIZ_SCORES_FILE = "quiz_scores.txt";
    public static final String DELIMITER = "::";

    public StudentQuizGradesDaoImpl(){}

    @Override
    public List<String> getAllStudentScoresRowsAsListOfStrings() throws StudentQuizGradesDaoException{

        loadQuizScoreFileIntoHashMap();
        List<String> allData = new ArrayList<String>();
        for(Map.Entry<String, Scores> entry : this.studentScoreData.entrySet()) {
            String key = entry.getKey();
            Scores value = entry.getValue();
            String singleStudentScoreRow = this.marshallStudentScoreData(key, value);
            allData.add(singleStudentScoreRow);
        }
        return allData;
    }

    @Override
    public Map<String, Scores> setSingleRowOfStudentScores(String studentName, Scores scoreData)
            throws StudentQuizGradesDaoException {
        loadQuizScoreFileIntoHashMap();
        this.studentScoreData.put(studentName, scoreData);
        Map<String, Scores> newStudentScoreData = this.studentScoreData;
        writeHashMapToFile();
        return newStudentScoreData;
    }

    @Override
    public List<Integer> getScoresFromSpecificStudent(String studentName) throws StudentQuizGradesDaoException {
        loadQuizScoreFileIntoHashMap();
        List<Integer> scores = this.studentScoreData.get(studentName).getListOfAllScores();
        return scores;
    }

    @Override
    public Map<String, Scores>  removeSingleRowOfStudentScores(String studentName)
            throws StudentQuizGradesDaoException {
        loadQuizScoreFileIntoHashMap();
        this.studentScoreData.remove(studentName);
        Map<String, Scores> removedStudentScoreData = new HashMap<String, Scores>();
        removedStudentScoreData.putAll(this.studentScoreData);
        writeHashMapToFile();
        return removedStudentScoreData;
    }

    @Override
    public Map<Integer, Double> getAverageScore() throws StudentQuizGradesDaoException{
        loadQuizScoreFileIntoHashMap();
        List<String> allData = new ArrayList<String>();
        double total=0;
        int numberScores=0;
        for(Map.Entry<String, Scores> entry : this.studentScoreData.entrySet()) {
            Scores values = entry.getValue();
            for(int n : values.getListOfAllScores()){
                total += n;
                numberScores++;
            }
        }
        Map<Integer, Double> results = new HashMap<Integer,Double>();
        results.put(numberScores, total / numberScores);
        return results;
    }

    @Override
    public LinkedHashMap<String, Integer> preliminaryMethodForGettingTotalScores() throws StudentQuizGradesDaoException{
        loadQuizScoreFileIntoHashMap();
        Map<String, Integer> finalResults = new HashMap<String, Integer>();
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(Map.Entry<String, Scores> entry : this.studentScoreData.entrySet()) {
            int total = 0;
            Scores values = entry.getValue();
            for(int n : values.getListOfAllScores()){
                total += n;
            }
            finalResults.put(entry.getKey(), total);
        }
        for (Map.Entry<String, Integer> entry : finalResults.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list);
        for (int num : list) {
            for (Map.Entry<String, Integer> entry : finalResults.entrySet()) {
                if (entry.getValue().equals(num)) {
                    sortedMap.put(entry.getKey(), num);
                }
            }
        }
        return sortedMap;
    }

    @Override
    public String getHighestScore(LinkedHashMap<String, Integer> prelimResults){
        int count = 1;
        String lastResult = "";
        for(Map.Entry<String, Integer> entry : prelimResults.entrySet()) {
            if (count == prelimResults.size()){
                lastResult += entry.getKey() + " has the highest total score: " + entry.getValue() + " points.";
            }
            count++;
        }
        return lastResult;
    }

    @Override
    public String getLowestScore(LinkedHashMap<String, Integer> prelimResults){
        int count = 1;
        String lastResult = "";
        for(Map.Entry<String, Integer> entry : prelimResults.entrySet()) {
            if (count == 1){
                lastResult += entry.getKey() + " has the lowest total score: " + entry.getValue() + " points.";
                break;
            }
        }
        return lastResult;
    }

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
        Map<String, Scores> tempSingleRowMap;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();
            tempSingleRowMap = unmarshallStudentScoreRow(currentLine);
            Map.Entry<String, Scores> entry = tempSingleRowMap.entrySet().iterator().next();
            String name = entry.getKey();
            Scores tempScores = entry.getValue();
            this.studentScoreData.put(name, tempScores);
        }
        // close scanner
        scanner.close();
    }

    private Map<String, Scores> unmarshallStudentScoreRow(String studentScoreAsText){

        //STUDENT-SCORE data will be written in the txt file as so:
        // ______________________________________
        // |            | || || || || |
        // |John Dawson::9::1::4::5::8
        // |            | || || || || |
        // --------------------------------------
        //       [0]    [1][2][3][4][5] etc...

        String[] allTokens = studentScoreAsText.split(DELIMITER);
        String studentName = allTokens[0];

        Scores scoresListFromFile = new Scores();
        for(int i=1; i<=5; i++){
            scoresListFromFile.addSingleScoreToList(Integer.parseInt(allTokens[i]));
        }

        Map<String, Scores> hashMapFromFile = new HashMap<>();
        hashMapFromFile.put(studentName,scoresListFromFile);

        return hashMapFromFile;
    }

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

        for(Map.Entry<String, Scores> entry : this.studentScoreData.entrySet()) {
            String key = entry.getKey();
            Scores value = entry.getValue();
            String studentScoreDataAsText = this.marshallStudentScoreData(key, value);
            out.println(studentScoreDataAsText);
            out.flush();
        }

        // Clean up
        out.close();
    }

    private String marshallStudentScoreData(String k, Scores v) throws StudentQuizGradesDaoException{

        String fullDataLine = "";
        fullDataLine += k;
        Scores s = studentScoreData.get(k);
        for (Integer i : s.getListOfAllScores()) {
            fullDataLine += DELIMITER;
            fullDataLine += i;
        }
        return fullDataLine;
    }

}
