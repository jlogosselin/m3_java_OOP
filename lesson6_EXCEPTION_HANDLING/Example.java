package lesson6_EXCEPTION_HANDLING;

public class Example {

    //list of all Java exceptions here:
    //https://programming.guide/java/list-of-java-exceptions.html

    public static void main(String[] args) {

        //-------------------------- EXAMPLE 1 ----------------------------------

        try {
            int divideByZero = 5 / 0;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException found!");
        }
        System.out.println("EXAMPLE 1: done\n");

        //-------------------------- EXAMPLE 2 ----------------------------------

        /*
        For each try block, there can be zero or more catch blocks.
        Multiple catch blocks allow us to handle each exception differently.
        The argument type of each catch block indicates the type of exception that
        can be handled by it. For example
         */

        int[] arr = new int[10];

        try {
            arr[20] = 11;
        } catch (NumberFormatException e1) {
            System.out.println("NumberFormatException found!");
        } catch (IndexOutOfBoundsException e2) {
            System.out.println("IndexOutOfBoundsException found!");
        }
        System.out.println("EXAMPLE 2: done");

    }
}
