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

        System.out.println("Sum : "+sum);
        long timeTaken = System.currentTimeMillis() - startTime;
        System.out.println("Excution time -> " + timeTaken + " by thread " + Thread.currentThread().getName());
    }
}

public class AliveThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Calculator(300000000L));
        t1.setName("High priority");
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();

        while(t1.isAlive()){
            System.out.println("Thread is active");
        }

        System.out.println("Thread ended successfully");
    }
}

