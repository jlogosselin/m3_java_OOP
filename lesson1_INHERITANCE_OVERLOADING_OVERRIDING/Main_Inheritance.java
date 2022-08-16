package lesson1_INHERITANCE_OVERLOADING_OVERRIDING;

public class Main_Inheritance {

    public static void main(String[] args) {

        /*
        Even though only the additional Manager-specific methods
        are contained in the Manager class definition, all of the
        members of EMPLOYEE class are included in Manager.

        To illustrate this, we'll instantiate a new Manager object
        and then see what methods are available to it using the
        IntelliSense in the IDE:
         */

        Manager thisManager = new Manager("Barry", "Simmons", "George");

        //---------------------------------------------------------------

        //here: invoking all methods belonging strictly to MANAGER class:
        thisManager.hire();
        thisManager.fire();
        thisManager.givePerformanceReview();
        thisManager.goForCoffeeBreak(); //---> this prints the results from ***both*** versions of the method at once, from EMPLOYEE & MANAGER classes
        //this will invoke the EMPLOYEE method overridden by MANAGER class:
        thisManager.createYearlyObjectives();

        //---------------------------------------------------------------

        //here: invoking all methods belonging to parent class EMPLOYEE:
        thisManager.getFirstName();
        thisManager.getLastName();
        thisManager.doWork(); //---> this prints the method from EMPLOYEE
        //here: invoking the overloaded method
        thisManager.doWork("accounting task"); //---> this prints the overloaded version from EMPLOYEE


        //---------------------------------------------------------------





    }
}
