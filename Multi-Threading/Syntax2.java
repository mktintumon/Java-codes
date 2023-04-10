import java.time.LocalDateTime;

class Greeting implements Runnable{
    public void run(){
        for(int i=0 ; i<10 ; i++){
            System.out.println(LocalDateTime.now() + " Hello friend ");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

public class Syntax2 {
    public static void main(String[] args) {
        Thread t = new Thread(new Greeting());
        t.start();
    }
}
