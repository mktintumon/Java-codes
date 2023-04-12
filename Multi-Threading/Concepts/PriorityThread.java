package Concepts;

// MAX_PRIORITY = 10
// MIN_PRIORITY = 0
// NORM_PRIORITY = 5


class Calculator extends Thread{
    long value;

    public Calculator(long value){
        this.value = value;
    }

    public void run(){
        long startTime = System.currentTimeMillis();
        
        long sum = 0;
        for(int i=0 ; i<value ; i++){
            sum+=i;
        }

        System.out.println(sum);
        long timeTaken = System.currentTimeMillis() - startTime;
        System.out.println("Excution time -> " + timeTaken + " by thread " + Thread.currentThread().getName());
    }
}

public class PriorityThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Calculator(300000000L));
        t1.setName("High priority");
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();

        Thread t2 = new Thread(new Calculator(300000000L));
        t2.setName("Low priority");
        t2.setPriority(Thread.MIN_PRIORITY);
        t2.start();

        Thread t3 = new Thread(new Calculator(300000000L));
        t3.setName("Norm priority");
        t3.setPriority(6); //Thread.NORM_PRIORITY
        t3.start();
    }
}
