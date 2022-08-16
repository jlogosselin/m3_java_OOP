package lesson4_DATA_INPUT_OUTPUT;

import java.io.*;
import java.util.Scanner;

public class SimpleFileIO {

    public static void main(String[] args) throws IOException {

        //////////////////////////////////////////////////////////////////////////////////
        /////////////////// PART 1: CREATING A FILE + ADDING CONTENT TO IT ///////////////
        //////////////////////////////////////////////////////////////////////////////////

        //below: we will write content to a file we named OutFile:
        PrintWriter out = new PrintWriter(new FileWriter("myCoolFile.txt"));

        //adding 3 lines of text to our file:
        out.println("Hello everyone!");
        out.println("Welcome to my cool txt file!");
        out.println("It's finally raining - at last!");
        /*
        FLUSH() method forces everything to be written to the file — PrintWriter may buffer some
        of our output rather than writing it immediately.
         */
        out.flush();
        out.close();

        /*
        to view the OutFile.txt we just created and filled up with content,
        click on arrow next to PROJECT, top left, then choose PROJECT FILES:
        this should show where the file has been stored!
        Double-click on this file, and you should see the content stored!
         */

        //////////////////////////////////////////////////////////////////////////////////
        /////////////////// PART 2: OPENING THE FILE + READING ITS CONTENT ///////////////
        //////////////////////////////////////////////////////////////////////////////////

        Scanner sc = new Scanner(new BufferedReader(new FileReader("myCoolFile.txt")));
        // going through the file line by line
        while (sc.hasNextLine()) {
            String currentLine = sc.nextLine();
            System.out.println(currentLine);
        }



    }
}
