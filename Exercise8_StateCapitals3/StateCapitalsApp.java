package Exercise8_StateCapitals3;

import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;

public class StateCapitalsApp {

    public static void main(String[] args) throws IOException {

        List<Capital> allCapitalObjects = new ArrayList<>();
        List<String> states = new ArrayList<>();
        Map<String, Capital> statesAndCapitalData = new HashMap<>();
        Scanner userInput = new Scanner(System.in);

        //importing data from file stored in PROJECT:
        try (BufferedReader br = new BufferedReader(new FileReader("MoreStateCapitals.txt"))){

            String currentLine;
            while ((currentLine = br.readLine()) != null){

                // separating the data by the double colon:
                String[] detailed = currentLine.split("::");

                states.add(detailed[0]);
                String name = detailed[1];
                String population = detailed[2];
                String mileage = detailed[3];

                allCapitalObjects.add(new Capital(name, Integer.parseInt(population), Double.parseDouble(mileage)));
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        //inserting data from both arraylists in hashmap:
        for(int i=0; i<states.size(); i++){
            statesAndCapitalData.put(states.get(i), allCapitalObjects.get(i));
        }

        statesAndCapitalData.forEach((key, value)
                        -> System.out.println("State: " + key
                        + ", capital city: " + value.getName()
                        + ", population: " + value.getPopulation()
                        + ", mileage: " + value.getMileage()
                )
        );

        //----------------------------------------------------------------------------------------

        System.out.println("\nEnter population limit: ");
        int minPop = Integer.parseInt(userInput.nextLine());

        int countStatesPop = 0;
        for (Map.Entry<String, Capital> m :statesAndCapitalData.entrySet()) {
            if(m.getValue().getPopulation() > minPop){
                countStatesPop++;
            }
        }
        System.out.println("There are " + countStatesPop +
                " states/capitals above the population limit of " + minPop + ": ");
        for (Map.Entry<String, Capital> m :statesAndCapitalData.entrySet()) {
            if(m.getValue().getPopulation() > minPop){
                System.out.println("state: " + m.getKey() + ", capital: " + m.getValue().getName());
            }
        }

        //-----------------------------------------------------------------------------

        System.out.println("\nEnter area limit: ");
        double minArea = Double.parseDouble(userInput.nextLine());

        int countStatesArea = 0;
        for (Map.Entry<String, Capital> m :statesAndCapitalData.entrySet()) {
            if(m.getValue().getMileage() < minArea){
                countStatesArea++;
            }
        }
        System.out.println("There are " + countStatesArea +
                " states/capitals under the area limit of " + minArea + ": ");
        for (Map.Entry<String, Capital> m :statesAndCapitalData.entrySet()) {
            if(m.getValue().getMileage() < minArea){
                System.out.println("state: " + m.getKey() + ", capital: " + m.getValue().getName());
            }
        }

    }
}
