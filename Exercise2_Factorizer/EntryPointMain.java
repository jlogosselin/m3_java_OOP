package Exercise2_Factorizer;

import java.util.Scanner;

public class EntryPointMain {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter a value: ");
        int v = Integer.parseInt(userInput.nextLine());

        Factorizer factorizerObject = new Factorizer(v);

        factorizerObject.countFactors();
        factorizerObject.isPrime();
        factorizerObject.isPerfect();

    }
}
