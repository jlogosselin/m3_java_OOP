package Exercise4_Abstract_Shape;

public class Square extends Shape{

    private double side;

    public Square(double s, String c){
        super(c);
        this.side = s;
    }

    public double getPerimeter(){
        return this.side*4;
    }

    public double getArea(){
        return this.side*this.side;
    }
}
