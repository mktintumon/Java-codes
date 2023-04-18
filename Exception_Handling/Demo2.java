

public class Demo2 {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        System.out.println("printed");

        int c = a / b; // Exception occured
        // Error printed in italic is called stack Trace
        System.out.println(c + "Not printed");
    }
}
