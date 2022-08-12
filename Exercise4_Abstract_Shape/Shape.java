package Exercise4_Abstract_Shape;

public abstract class Shape {

    //this attribute to be defined and implemented in all non-abstract classes:
    protected String colour;

    public Shape(String c) {
        this.colour = c;
    }

    //these methods to be defined and implemented in all non-abstract classes:
    protected abstract double getPerimeter();
    protected abstract double getArea();

}
