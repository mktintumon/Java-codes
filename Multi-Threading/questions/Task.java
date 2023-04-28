//import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

class Greeting extends Thread{
    public void run(){
        for(int i=0 ; i<100 ; i++){
            System.out.println("Hello world");
        }
    }
}

class NumGenerator extends Thread{
    public void run(){
        for(int i=0 ; i<100 ; i++){
            Random rand = new Random();
            int num = rand.nextInt(110,250+1);
            //int num = ThreadLocalRandom.current().nextInt(110, 250 + 1);
            System.out.println(num);
        }
    }
}

public class Task {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Greeting());
        Thread t2 = new Thread(new NumGenerator());
        t1.start();
        t2.start();
    }    
}
