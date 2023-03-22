package Exception_Handling;

public class Syntax {
    public static void main(String[] args) {
        int a = 10, b=0;
        try {
            b = 10/a;
            int[] c = {15};     
            c[5] = 43;
        }catch(ArithmeticException e) {
                e.printStackTrace();
        }catch(ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
        }finally {
                System.out.println("Always printing" + b);
        }

        // Here both catch blocks can be handles by one, i.e -> (Exception e)
        // because both exception are subclass of class exception
    }
}
