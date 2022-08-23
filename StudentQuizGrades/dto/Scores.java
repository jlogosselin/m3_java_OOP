package StudentQuizGrades.dto;

import java.util.ArrayList;
import java.util.List;

public class Scores {

    List<Integer> scoreList = new ArrayList<Integer>();

    public Scores(){}

    public Scores(List<Integer> thisList){
        this.scoreList.addAll(thisList);
    }

    public void addSingleScoreToList(int n){
        this.scoreList.add(n);
    }

    public List<Integer> getListOfAllScores(){
        return this.scoreList;
    }

}
