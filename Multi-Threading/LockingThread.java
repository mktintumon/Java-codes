

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


// Another method to acheive synchronisation
// Difference between sync and lock -> 
//        sync code must be in same block
//        but lock and unlock can be in different blocks

// If we lock ....we have to unlock also -> otherwise Starvation occurs

class String_Thread extends Thread{
    private ArrayList<Character> list;
    private String mssg;

    // static -> as it is shared among threads
    private static Lock lock = new ReentrantLock(true);

    public String_Thread(ArrayList<Character> list ,String mssg){
        this.list = list;
        this.mssg = mssg;
    }

    public void run(){
        // locking
        lock.lock();
        
        try {
            System.out.println("Lock aquired by " + Thread.currentThread().getName());
            for(int i=0 ; i<mssg.length() ; i++){
                try {
                    list.add(mssg.charAt(i));
                    Thread.sleep(500);
                } catch (Exception e) {
                
                }
            }
            System.out.println(list);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            // unlocking
            lock.unlock();
            System.out.println("Lock unlocked by " + Thread.currentThread().getName());
        }
        
    }
}

public class LockingThread {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("mohit");
        ArrayList<Character> list = new ArrayList<>();
        Thread t1 = new Thread(new String_Thread(list,"HELLO"));
        t1.start();
        
        Thread t2 = new Thread(new String_Thread(list,"MOHIT"));
        t2.start();
        
        t1.join();
        t2.join();


    }
}

