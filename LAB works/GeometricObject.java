
interface GeometricObjects{
    abstract double getArea();
    abstract double getPerimeter();
}

class Triangle implements GeometricObjects{
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }
    
    public double getArea(){
        double s = (side1+side2+side3)/2;
        double calc = s*(s-side1)*(s-side2)*(s-side3);
        return Math.sqrt(calc);
    }
    
    public double getPerimeter(){
        return side1+side2+side3;
    }
}
    

public class GeometricObject {
    public static void main(String[] args) {
        GeometricObjects go = new Triangle(2.0,3.0,4.2);
        System.out.printf("Area is :" + "%.3f",go.getArea());
        System.out.println();
        System.out.println("perimeter is :" + go.getPerimeter());
    }
}


