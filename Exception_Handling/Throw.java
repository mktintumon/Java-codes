package Exception_Handling;

public class Throw {
    public static void main(String[] args) {
        int a = 10; 
        int b = 5;
        try {
            if (b == 0) 
                throw new ArithmeticException("Do not perform division");
        else 
            System.out.println(a/b);
        }
        catch(ArithmeticException e) {
            e.printStackTrace();
        }
    }
}
