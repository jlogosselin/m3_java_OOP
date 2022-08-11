package Exercise3_SimpleCalculator;

/*
Design a class (no main method) called SimpleCalculator that performs basic math operations
(addition, subtraction, multiplication, division) on two operands.

Create another class called App that presents a simple console calculator UI to the user.
This second class should handle all user input and console output and must use the first class to perform
all of the math operations.

The UI should give the user a choice of operations. One of the choices should be to exit the program.

After the user selects an operation, the UI should ask the user for two operands and then display
the result of the calculation.

The UI should then display the menu of choices again.

When the user chooses to exit the program, the UI should print a thank you message.
 */

public class SimpleCalculator {

    private int n1;
    private int n2;

    public SimpleCalculator(int a, int b){
        this.n1 = a;
        this.n2 = b;
    }

    public int getter_Value1(){
        return this.n1;
    }

    public int getter_Value2(){
        return this.n2;
    }

    public int addition(int a, int b){
        return this.n1 + this.n2;
    }

    public int multiplication(int a, int b){
        return this.n1 * this.n2;
    }

    public int subtraction(int a, int b){
        return this.n1 - this.n2;
    }

    public double division(int a, int b){
        return (double)this.n1 / (double)this.n2;
    }
}
