package Exercise4_Abstract_Shape;

public class MainEntryPoint {

    public static void main(String[] args) {

        Square mySquare = new Square(7.2, "orange");
        System.out.println("Perimeter of square = " + mySquare.getPerimeter());
        System.out.println("Area of square = " + mySquare.getArea());

        Rectangle myRect = new Rectangle(3.4, 8.9, "green");
        System.out.println("\nPerimeter of rectangle = " + myRect.getPerimeter());
        System.out.println("Area of rectangle = " + myRect.getArea());

        Triangle myTri = new Triangle(3.4, 3.9, 4.6, "black");
        System.out.println("\nPerimeter of triangle = " + myTri.getPerimeter());
        System.out.println("Area of triangle = " + myTri.getArea());

    }
}
