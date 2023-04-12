package Concepts;

class First extends Thread{

    public void run(){
        System.out.println("Starting " + Thread.currentThread().getName());
        for(int i=1 ; i<=5 ; i++){
            System.out.println("A" + " ");
        }
        System.out.println("Ending " + Thread.currentThread().getName());
    }
}

class Second extends Thread{

    public void run(){
        System.out.println("Starting " + Thread.currentThread().getName());
        for(int i=1 ; i<=5 ; i++){
            System.out.println("B" + " ");
        }
        System.out.println("Ending " + Thread.currentThread().getName());
    }
}

class Third extends Thread{

    public void run(){
        System.out.println("Starting " + Thread.currentThread().getName());
        for(int i=1 ; i<=5 ; i++){
            System.out.println("C" + " ");
        }
        System.out.println("Ending " + Thread.currentThread().getName());
    }
}

public class Syntax {
    public static void main(String[] args) {
        Thread A = new Thread(new First());
        A.setName("Thread first");
        A.start();

        Thread B = new Thread(new Second());
        B.setName("Thread second");
        B.start();
        
        Thread C = new Thread(new Third());
        C.setName("Thread third");
        C.start();
    }
}
