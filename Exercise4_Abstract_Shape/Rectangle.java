package Exercise4_Abstract_Shape;

public class Rectangle extends Shape{

    private double rectLength;
    private double rectWidth;

    public Rectangle(double rl, double rw, String c){
        super(c);
        this.rectLength = rl;
        this.rectWidth = rw;
    }

    public double getPerimeter(){
        return (this.rectLength + this.rectWidth)*2;
    }

    public double getArea(){
        return this.rectLength*this.rectWidth;
    }
}
