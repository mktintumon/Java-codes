

class Calc extends Thread{
    long value;

    public Calc(long value){
        this.value = value;
    }

    public void run(){
        long startTime = System.currentTimeMillis();
        
        long sum = 0;
        for(int i=0 ; i<value ; i++){
            sum+=i;
        }

        System.out.println("Sum : "+sum);
        long timeTaken = System.currentTimeMillis() - startTime;
        System.out.println("Excution time -> " + timeTaken + " by thread " + Thread.currentThread().getName());
    }
}

public class JoinThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Calc(300000000L));
        t1.setName("High priority");
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();

        // if thread not give result in 5 sec -> gets killed
        t1.join(5000);

        // this will kill thread and exits
        System.exit(0);
    }
}

