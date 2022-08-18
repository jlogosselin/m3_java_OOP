package ExerciseD_Abstract_Shape;

public class Triangle extends Shape{

    private double a;
    private double b;
    private double c;
    private double semi_perimeter;

    public Triangle(double side1, double side2, double side3, String c){
        super(c);
        this.a = side1;
        this.b = side2;
        this.c = side3;
        this.semi_perimeter = (this.a + this.b + this.c)/2;
    }

    public double getPerimeter(){
        return this.a + this.b + this.c;
    }

    public double getArea(){
        return Math.sqrt(this.semi_perimeter *
                                                (this.semi_perimeter - this.a) *
                                                (this.semi_perimeter - this.b) *
                                                (this.semi_perimeter - this.c));
    }
}
