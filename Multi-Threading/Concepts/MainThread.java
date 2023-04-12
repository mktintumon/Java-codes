package Concepts;

// A program may have many processes
// A process may have many Threads

// Thread that runs by default is called Main thread

public class MainThread {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println("current thread : " + t.getName());

        t.setName("Mohit Thread");
        System.out.println("current thread : " + t.getName());
    }
}
