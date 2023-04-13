

import java.util.*;

class StringThread extends Thread{
    private ArrayList<Character> list;
    private String mssg;

    public StringThread(ArrayList<Character> list ,String mssg){
        this.list = list;
        this.mssg = mssg;
    }

    public void run(){
        // As list is common for 2 thread -> so uses list as parameter
        // As Mssg is different for different thread
        synchronized(list){
            System.out.println("Mssg aquired by " + Thread.currentThread().getName());
            for(int i=0 ; i<mssg.length() ; i++){
                try {
                    list.add(mssg.charAt(i));
                    Thread.sleep(500);
                } catch (Exception e) {
                
                }
            }
            System.out.println(list);
        }
    }
}

public class Synchronization {
    public static void main(String[] args) throws InterruptedException {
        /*
        --> This will not give correct result -> without synchronisation
        --> As both thread accessing same list and follow CPU scheduling
        --> Result will be mixed  [M, H, E, H, I, L, O]
                                  [M, H, E, H, I, L, O]

        ArrayList<Character> list = new ArrayList<>();
        Thread t1 = new Thread(new StringThread(list,"HELLO"));
        t1.start();
        
        Thread t2 = new Thread(new StringThread(list,"MOHIT"));
        t2.start();
        
        t1.join();
        t2.join();
        */

        // LETS FIX THE CODE -> BY using synchronized keyword
        ArrayList<Character> list = new ArrayList<>();
        Thread t1 = new Thread(new StringThread(list,"HELLO"));
        t1.start();
        
        Thread t2 = new Thread(new StringThread(list,"MOHIT"));
        t2.start();
        
        t1.join();
        t2.join();


    }
}
