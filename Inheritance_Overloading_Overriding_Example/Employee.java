package Inheritance_Overloading_Overriding_Example;

public class Employee {

    /*
     Note that we make firstName and lastName protected so that
     the child classes will have access to these members.
     */

        protected String firstName;
        protected String lastName;

        public Employee(String first, String last){
            this.firstName = first;
            this.lastName = last;
        }

        public void doWork() {
            System.out.println("\nEMPLOYEE doing work.");
        }

        //below: an example of an OVERLOADED method (different signature from the method above):
        public void doWork(String t) {
            System.out.println("\nEMPLOYEE doing special task: " + t);
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        /*
            below: this method will be OVERRIDDEN by
            a homonymous method in the child class MANAGER
        */
        public void createYearlyObjectives() {
            System.out.println("\nEMPLOYEE creating yearly objectives");
        }

        /*
            below: not only will this method be OVERRIDDEN by
            a homonymous method in the child class MANAGER,
            but it will also be invoked inside that MANAGER's overriding method!
        */
        public void goForCoffeeBreak() {
            System.out.println("\nEMPLOYEE going for a coffee.");
        }
}

