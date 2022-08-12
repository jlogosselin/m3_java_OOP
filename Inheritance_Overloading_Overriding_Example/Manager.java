package Inheritance_Overloading_Overriding_Example;

/*
All EMPLOYEES have capabilities set out in the EMPLOYEE class,
whether they are accountants, software developers, managers,
or even the CEO.

However, many employees have additional capabilities and responsibilities.

For example, a manager can hire and fire people and can give performance reviews.

As you can see, a Manager is a special kind of Employee — it inherits
some common properties and behaviors but it also extends the functionality
of Employee with new and/or different properties and behaviors.

In Java, this specialization relationship is achieved via inheritance
and is implemented using the EXTENDS keyword:
 */

public class Manager extends Employee{

    private String middleName;

    public Manager(String first, String last, String middle){
        //below: invoking the PARENT class's constructor first, passing on all relevant values:
        super(first, last);
        //finally: initialising the attribute specific to MANAGER class:
        this.middleName = middle;
    }

    public void hire() {
        // code to hire someone...
    }

    public void fire() {
        // code to fire someone...
    }

    public void givePerformanceReview() {
        // code to give performance review...
    }

    /*
    below:  the MANAGER class overrides the createYearlyObjectives() method
    from its parent class EMPLOYEE
     */
    @Override
    public void createYearlyObjectives(){
        System.out.println("\nMANAGER creating yearly objectives.");
    }

     /*
    below:  not only does the MANAGER class override the goForCoffeeBreak() method
    from its parent class EMPLOYEE, but it also invokes the original method
    from EMPLOYEE inside itself by using the SUPER keyword:
     */

    @Override
    public void goForCoffeeBreak() {
        System.out.println("\nMANAGER going for coffee.");
        super.goForCoffeeBreak();
    }

}
