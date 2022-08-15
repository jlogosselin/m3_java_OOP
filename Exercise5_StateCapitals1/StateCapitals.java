package Exercise5_StateCapitals1;

/*
Your program must include the following:

This program will be a Java Console Application called StateCapitals.
Create a HashMap to hold the names of all the states and their corresponding capital names.
(State name is the key, capital name is the value.)
Load the HashMap with each state/capital pair. (This should be hard-coded.)
Print all of the state names to the screen. (Hint: Get the keys from the map and then print
each state name one by one.)
Print all of the capital names to the screen. (Hint: Get the values from the map and then
print each capital name to the screen one by one.)
Print each state along with its capital to the screen.
(Hint: Use the key set to get each value from the map one by one, printing both the key and value as you go.)

Sample output (order may vary):
STATES:
=======
Alabama
Alaska
Arizona
Arkansas
…
…

CAPITALS:
=========
Montgomery
Juneau
Phoenix
Little Rock
…
…

STATE/CAPITAL PAIRS:
====================
Alabama - Montgomery
Alaska - Juneau
Arizona - Phoenix
Arkansas - Little Rock
 */

import java.util.Map;
import java.util.HashMap;

public class StateCapitals {

    public static void main(String[] args) {

        Map<String, String> statesAndCapitals = new HashMap<>();
        statesAndCapitals.put("Alabama","Montgomery");
        statesAndCapitals.put("Alaska","Juneau");
        statesAndCapitals.put("Arizona","Phoenix");
        statesAndCapitals.put("Arkansas","Little Rock");

        //accessing states:
        System.out.println("STATES:");
        System.out.println("=======");
        for(Map.Entry m:statesAndCapitals.entrySet()){
            System.out.println(m.getKey());
        }
        System.out.println("\n");

        //accessing capitals:
        System.out.println("CAPITALS:");
        System.out.println("=======");
        for(Map.Entry m:statesAndCapitals.entrySet()){
            System.out.println(m.getValue());
        }
        System.out.println("\n");

        //accessing states & capitals:
        System.out.println("STATE/CAPITAL PAIRS:");
        System.out.println("=======");
        for(Map.Entry m:statesAndCapitals.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }


    }
}
