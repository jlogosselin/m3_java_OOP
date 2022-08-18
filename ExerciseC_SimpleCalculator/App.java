package ExerciseC_SimpleCalculator;

public class App {

    private String introMessage;
    private String menu;
    private int userChoice;
    private int v1;
    private int v2;
    private int sum;
    private int product;
    private int difference;
    private double quotient;
    SimpleCalculator sc;

    public App(){
        this.introMessage = "Hello! Welcome to this brand new calculator app! Enter two values: ";
        this.menu = "Choose (1) to add both values; (2) to multiply both values; (3) to subtract n2 from n1; (4) to divide n1 by n2; (5) to exit";
        this.v1 = 0;
        this.v2 = 0;
        this.sum = 0;
        this.product = 0;
        this.difference = 0;
        this.quotient = 0;
        this.userChoice = 0;
    }

    public void printIntroMessage(){
        System.out.println(this.introMessage);
    }

    public void printMenu(){
        System.out.println(this.menu);
    }

    public void setValues(int a, int b){
        this.v1 = a;
        this.v2 = b;
        sc = new SimpleCalculator(a, b);
    }

    public void setChoice(int a){
        this.userChoice = a;
    }

    public void applyOperation(){

        if(this.userChoice == 1){
            this.sum = sc.addition(this.v1, this.v2);
        }
        else if(this.userChoice == 2){
            this.product = sc.multiplication(this.v1, this.v2);
        }
        else if(this.userChoice == 3){
            this.difference = sc.subtraction(this.v1, this.v2);
        }
        else if(this.userChoice == 4){
            this.quotient = sc.division(this.v1, this.v2);
        }
    }

    public void getResult(){
        if(this.userChoice == 1){
            System.out.println("Sum = " + this.sum);
        }
        else if (this.userChoice == 2){
            System.out.println("Product = " + this.product);
        }
        else if (this.userChoice == 3){
            System.out.println("Difference = " + this.difference);
        }
        else if (this.userChoice == 4){
            System.out.println("Quotient = " + this.quotient);
        }
    }

    public void exitMessage(){
        System.out.println("Thank you! Goodbye!");
    }



}
