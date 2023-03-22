package Exception_Handling;

public class Demo {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        int c = 0;
        System.out.println("printed");

        try {
            // code will be monitored
            c = a / b;     
        } catch (Exception e) {
            // exception handler
            //System.out.println(e);
            e.printStackTrace();

            // recover from exception and resume work
            c = 0;
        }

        
        System.out.println("value " + c);
    }
}
