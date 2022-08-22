package ExerciseK_StudentQuizGrades_UNFINISHED.dto;

import java.util.ArrayList;
import java.util.List;

public class Scores {

    //these methods will be invoked in the VIEW class

    private List<Integer> scores = new ArrayList<Integer>();

    public Scores(){}

    public void addSingleScoreToList(Integer i){
        scores.add(i);
    }

    public List<Integer> getListOfAllScores(){ return this.scores;}

    public String printFullListOfScores(){
        String s = "";
        for(int i=0;i<this.scores.size();i++){
            s += this.scores.get(i) + ", ";
        }
        return s;
    }

    public Integer accessSingleScoreFromList(int i){
        return scores.get(i);
    }

    public void changeSingleScoreValueInList(int i, Integer in){
        scores.set(i, in);
    }

    public void removeSingleScoreFromList(int i){
        scores.remove(i);
    }

}
