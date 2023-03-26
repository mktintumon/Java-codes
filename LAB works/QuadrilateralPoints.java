import java.util.Random;

// Point class to represent x-y coordinates
class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}

// Quadrilateral class with 4 endpoints
class Quadrilateral {
    protected Point p1;
    protected Point p2;
    protected Point p3;
    protected Point p4;

    public Quadrilateral(Point p1, Point p2, Point p3, Point p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    // use it in all subclasses
    public double getPerimeter() {
        double perimeter = distance(p1, p2) + distance(p2, p3) + distance(p3, p4) + distance(p4, p1);
        return perimeter;
    }

    // use it in all subclasses
    public double distance(Point p1, Point p2) {
        double dx = p1.getX() - p2.getX();
        double dy = p1.getY() - p2.getY();
        return Math.sqrt(dx*dx + dy*dy);
    }
}


// Rectangle class with 2 sides perpendicular to the other 2 sides
class Rectangle extends Quadrilateral {
    public Rectangle(Point p1, Point p2, Point p3, Point p4) {
        super(p1, p2, p3, p4);
    }  

    public double getArea() {
        double length = distance(p1, p2);
        double width = distance(p2,p3);
        return length * width;
    }
}


// Square class with all sides equal and perpendicular
class Square extends Rectangle {
    public Square(Point p1, Point p2, Point p3, Point p4) {
        super(p1, p2, p3, p4);
    }

    public double getArea() {
        double side = distance(p1,p2);
        return side * side;
    }
}


public class QuadrilateralPoints{
public static void main(String[] args) {
    Random rand = new Random();
    Quadrilateral[] shapes = new Quadrilateral[5];

    for (int i = 0; i < 5; i++) {
        Point p1 = new Point(rand.nextDouble() * 10, rand.nextDouble() * 10);
        Point p2 = new Point(rand.nextDouble() * 10, rand.nextDouble() * 10);
        Point p3 = new Point(rand.nextDouble() * 10, rand.nextDouble() * 10);
        Point p4 = new Point(rand.nextDouble() * 10, rand.nextDouble() * 10);

        if (isRectangle(p1, p2, p3, p4)) {
            shapes[i] = new Rectangle(p1, p2, p3, p4);
        } else {
            shapes[i] = new Square(p1, p2, p3, p4);
        }
    }

    for (Quadrilateral shape : shapes) {
        if (shape instanceof Rectangle) {
            Rectangle rect = (Rectangle) shape;
            System.out.println("Rectangle:");
            System.out.printf("  \nArea = " + "%.3f",rect.getArea());
            System.out.printf("  \nPerimeter = " + "%.3f",rect.getPerimeter());
        } else if (shape instanceof Square) {
            Square square = (Square) shape;
            System.out.println("Square:");
            System.out.printf("  \nArea = " + "%.3f",square.getArea());
            System.out.printf("  \nPerimeter = " + "%.3f",square.getPerimeter());
        }
        System.out.println();
    }
}

    // Helper method to check if given points form a rectangle
    private static boolean isRectangle(Point p1, Point p2, Point p3, Point p4) {
        double d1 = distance(p1, p2);
        double d2 = distance(p2, p3);
        double d3 = distance(p3, p4);
        double d4 = distance(p4, p1);
        double d5 = distance(p1, p3);
        double d6 = distance(p2, p4);
        return (d1 == d3 && d2 == d4 && d5 == d6);
    }

    // Helper method to compute distance between two points
    private static double distance(Point p1, Point p2) {
        double dx = p1.getX() - p2.getX();
        double dy = p1.getY() - p2.getY();
        return Math.sqrt(dx*dx + dy*dy);
    }
}
