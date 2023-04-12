package Concepts;
import java.time.LocalDateTime;

class Greeting implements Runnable{
    public void run(){
        System.out.println("Thread "+Thread.currentThread().getName() +" started");
        for(int i=0 ; i<10 ; i++){
            System.out.println(LocalDateTime.now() + " Hello friend ");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread "+Thread.currentThread().getName() +" ended");
    }
}

public class Syntax2 {
    public static void main(String[] args) {
        Thread t = new Thread(new Greeting());
        t.setName("Greet");
        t.start();
    }
}
