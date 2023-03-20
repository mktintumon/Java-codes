class Complex {
    private double realPart;
    private double imaginaryPart;

    public Complex(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    // no argument constructor
    public Complex() {
        this.realPart = 0.0;
        this.imaginaryPart = 0.0;
    }

    void addition(Complex c1 , Complex c2) {
        double real = c1.realPart + c2.realPart;
        double imaginary = c1.imaginaryPart + c2.imaginaryPart;
        
        System.out.println("(" + real + ", " + imaginary + ")");
    }

    void subtract(Complex c1 , Complex c2) {
        double real = c1.realPart - c2.realPart;
        double imaginary = c1.imaginaryPart - c2.imaginaryPart;
        System.out.println("(" + real + ", " + imaginary + ")");
    }

    String print() {
        String ans = "";
        if(this.imaginaryPart < 0){
            ans = "(" + this.realPart + " - " + this.imaginaryPart +" i" + ")";
        }
        else{
            ans = "(" + this.realPart + " + " + this.imaginaryPart +" i" + ")";
        }
        return ans;
    }
}


class ComplexNumber {
    public static void main(String[] args) {
        // invokes parameterized constructor
        Complex c1 = new Complex(5,8);
        Complex c2 = new Complex(4,3);

        System.out.println("Operation with parameterized constructor : ");
        System.out.print("Numbers are : " + c1.print() + " and " + c2.print()); 
        System.out.print("\nSum of numbers : ");
        c1.addition(c1, c2);
        System.out.print("Diff of numbers : ");
        c1.subtract(c1, c2);

        // invoves constructor with no parameter -> default (0,0)
        System.out.println("\nOperation with default constructor : ");
        Complex c3 = new Complex();
        System.out.print("Numbers are : " + c1.print() + " and " + c3.print());
        System.out.print("\n Sum of numbers : ");
        c1.addition(c1, c3);
        System.out.print("Diff of numbers : ");
        c1.subtract(c1, c3);

    }
}
