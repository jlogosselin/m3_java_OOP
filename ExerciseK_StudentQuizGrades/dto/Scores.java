package ExerciseK_StudentQuizGrades.dto;

import java.util.ArrayList;
import java.util.List;

public class Scores {

    //these methods will be invoked in the VIEW class

    private List<Integer> scores = new ArrayList<Integer>();

    public Scores(){}

    public void addScoreToList(Integer i){
        scores.add(i);
    }

    public List<Integer> getAllScores(){ return this.scores;}

    public Integer accessScoreFromList(int i){
        return scores.get(i);
    }

    public void changeScoreValueInList(int i, Integer in){
        scores.set(i, in);
    }

    public void removeScoreFromList(int i){
        scores.remove(i);
    }

}
