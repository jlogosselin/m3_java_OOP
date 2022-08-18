package ExerciseG_StateCapitals2;

import java.io.*;
import java.util.*;
import java.lang.Math;

public class StateCapitals2 {

    public static void main(String[] args) throws IOException {

        //////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////// STEP 1: CREATING A DATA FILE  /////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////

        PrintWriter out = new PrintWriter(new FileWriter("myStatesAndCapitalsFile.txt"));

        out.println("Alabama::Montgomery");
        out.println("Alaska::Juneau ");
        out.println("Arizona::Phoenix");
        out.println("Arkansas::Little Rock");
        out.println("California::Sacramento");
        out.println("Colorado::Denver");
        out.println("Connecticut::Hartford");
        out.println("Delaware::Dover");
        out.println("Florida::Tallahassee");
        out.println("Georgia::Atlanta");
        out.println("Hawaii::Honolulu");
        out.println("Idaho::Boise");
        out.println("Illinois::Springfield");
        out.println("Indiana::Indianapolis");
        out.println("Iowa::Des Moines");
        out.println("Kansas::Topeka");
        out.println("Kentucky::Frankfort");
        out.println("Louisiana::Baton Rouge");
        out.println("Maine::Augusta");
        out.println("Maryland::Annapolis");
        out.println("Massachusetts::Boston");
        out.println("Michigan::Lansing");
        out.println("Minnesota::Saint Paul");
        out.println("Mississippi::Jackson");
        out.println("Missouri::Jefferson City");
        out.println("Montana::Helena");
        out.println("Nebraska::Lincoln");
        out.println("Nevada::Carson City");
        out.println("New Hampshire::Concord");
        out.println("New Jersey::Trenton");
        out.println("New Mexico::Santa Fe");
        out.println("New York::Albany");
        out.println("North Carolina::Raleigh");
        out.println("North Dakota::Bismarck");
        out.println("Ohio::Columbus");
        out.println("Oklahoma::Oklahoma City");
        out.println("Oregon::Salem");
        out.println("Pennsylvania::Harrisburg");
        out.println("Rhode Island::Providence");
        out.println("South Carolina::Columbia");
        out.println("South Dakota::Pierre");
        out.println("Tennessee::Nashville");
        out.println("Texas::Austin");
        out.println("Utah::Salt Lake City");
        out.println("Vermont::Montpelier");
        out.println("Virginia::Richmond");
        out.println("Washington::Olympia");
        out.println("West Virginia::Charleston");
        out.println("Wisconsin::Madison");
        out.println("Wyoming::Cheyenne");

        out.flush();
        out.close();

        //////////////////////////////////////////////////////////////////////////////////////////
        //////////// STEP 2: CREATING A HASHMAP + LOADING DATA FILE CONTENT INTO IT //////////////
        //////////////////////////////////////////////////////////////////////////////////////////

        Map<String, String> statesAndCapitals = new HashMap<>();

        Scanner sc = new Scanner(new BufferedReader(new FileReader("myStatesAndCapitalsFile.txt")));

        while (sc.hasNextLine()) {
            String currentLine = sc.nextLine();
            String parts[] = currentLine.split("::");
            statesAndCapitals.put(parts[0],parts[1]);
        }

        //////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////// STEP 3: CREATING A GUESSING GAME ///////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////

        int min = 1;
        int max = 50;
        int range = (max - min) + 1;
        int numberCorrectAnswers = 0;
        String userAnswer = "";
        String answer = "";
        int numberGuesses;
        List<Integer> pastQuestions = new ArrayList<Integer>();
        Scanner userInput = new Scanner(System.in);
        Object[] allStates = statesAndCapitals.keySet().toArray();

        do{

            System.out.println("\nLet's play a guessing game: try guessing the capital of a given state!\n");
            System.out.println("How many capitals would you like to guess?");
            numberGuesses = Integer.parseInt(userInput.nextLine());

            for(int i=0; i<numberGuesses; i++){

                System.out.println("QUESTION " + (i+1) + ": ");
                int num;
                do{
                    num = (int)(Math.random() * range) + min;
                }while(pastQuestions.contains(num));
                pastQuestions.add(num);
                Object key = allStates[num];
                String result = statesAndCapitals.get(key);
                System.out.println("What is the capital of " + key + "?");
                userAnswer = userInput.nextLine();

                if(userAnswer.equals(result)){
                    System.out.println("CORRECT! WELL DONE!");
                    numberCorrectAnswers++;
                }
                else System.out.println("Ouch! Incorrect. The answer was " + result);
            }

            double percentage = (numberCorrectAnswers * 100) / numberGuesses;
            System.out.println("You got " + numberCorrectAnswers + " correct answers out of " + numberGuesses + " questions.");
            System.out.println("In other words: " + percentage + "%");
            System.out.println("Would you like to play again? (y/n)");
            answer = userInput.nextLine();
            numberCorrectAnswers = 0;

        }while(answer.equals("y"));

        System.out.println("\nThank you! Bye!");
    }
}
