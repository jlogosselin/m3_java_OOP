package lesson2_INTERFACE_POLYMORPHISM;

//the class implements not one but TWO interfaces

public class MidSizeSedan implements Vehicle, Trackable{

    //below: all methods declared in TRACKABLE interface

    @Override
    public void moveForward(int milesPerHour) {
        // implementation code here...
    }

    @Override
    public void moveBackward(int milesPerHour) {
        // implementation code here...
    }

    @Override
    public void stop() {
        // implementation code here...
    }

    @Override
    public void turnLeft() {
        // implementation code here...
    }

    @Override
    public void turnRight() {
        // implementation code here...
    }

    @Override
    public void engineOn() {
        // implementation code here...
    }

    @Override
    public void engineOff() {
        // implementation code here...
    }

    //below: all methods declared in TRACKABLE interface

    @Override
    public void sendCurrentLocation() {
        // implementation code here...
    }

    @Override
    public void beaconOn() {
        // implementation code here...
    }

    @Override
    public void beaconOff() {
        // implementation code here...
    }
}
