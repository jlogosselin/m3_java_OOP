package Interfaces_Polymorphism_Example;

/*
There are times when you might want to define an interface that has the same
capabilities as an existing interface but with one or more additional methods.

In this case, we can EXTEND an existing interface.

The new interface declares that it extends the existing interface and then
defines only its new methods.

For example, say we have a new line of business that takes some of our existing
vehicles and turns them into emergency vehicles (such as police cruisers or ambulances).

The interface for these vehicles must include the capabilities of our existing
Vehicle interface, but we also need the ability to control sirens and flashers.

For this situation, our new interface might look something like this
 */

public interface EmergencyVehicle extends Vehicle{

    public void flashersOn();
    public void flashersOff();
    public void sirenOn();
    public void sirenOff();
}
