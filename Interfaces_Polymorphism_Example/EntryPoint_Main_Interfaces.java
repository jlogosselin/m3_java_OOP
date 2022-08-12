package Interfaces_Polymorphism_Example;

public class EntryPoint_Main_Interfaces {

    public static void main(String[] args) {

        /*
        Here, we simply create a new MidsizeSedan object on the
        heap and point to it with a MidsizeSedan reference.

        This is pretty straightforward: this is how we have been
        instantiating and referring to objects so far in the course.

        Our reference variable (car) has access to all of the methods
        on MidsizeSedan.
         */
        MidSizeSedan car = new MidSizeSedan();

        /*
        we create a new MidsizeSedan object on the heap, but this time
        we point to it with a Vehicle reference.

        In this case, a complete MidsizeSedan object is created on the heap,
        just like the example above.

        However, since we have chosen to treat the MidsizeSedan as Vehicle
        by referring to the MidsizeSedan object with a Vehicle reference,
        we only have access to the methods on the MidsizeSedan that are
        defined in the Vehicle interface.

        As far as we're concerned, the object we've created is just a
        Vehicle and nothing more.
         */

        Vehicle vehicle = new MidSizeSedan();

        /*
        Below, we create a new MidsizeSedan object on the heap, but this time
        we point to it with a Trackable reference.

        In this case, a complete MidsizeSedan object is created on the heap,
        just like in the previous two examples.

        However, since we have chosen to treat the MidsizeSedan as a Trackable
        by referring to it with a Trackable reference, we only have access to
        the methods that are defined in the Trackable interface.

        As far as we're concerned, the object we created is just a Trackable
        and nothing more.
         */

        Trackable trackable = new MidSizeSedan();

        /*
        In each of the examples above, a new, complete MidsizeSedan object is created
        on the heap.

        The difference is that we refer to the newly created object with different
        reference types.

        The reference types, in turn, determine how the newly created object looks
        to us — either a MidsizeSedan, a Vehicle, or a Trackable object.
         */



    }
}
