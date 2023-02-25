package Abstract;

abstract class Bank{
    abstract int getROI();
}

class Sbi extends Bank{
    int getROI(){
        return 10;
    }
}

class Pnb extends Bank{
    int getROI(){
        return 8;
    }
}

public class Example2 {
    public static void main(String[] args) {
        Bank b1;
        b1 = new Sbi();
        System.out.println("Sbi Interest -> " + b1.getROI());
        b1 = new Pnb();
        System.out.println("Pnb Interest -> " + b1.getROI());
    }
}
