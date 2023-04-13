
class Fibonacci extends Thread{
    public void run(){
        System.out.println("Thread "+Thread.currentThread().getName() +" started");
        int count = 0;
        int prev = 0;
        int curr = 1;
        while(count <= 6){
            System.out.println(curr+" ");
            int sum = prev+curr;
            prev = curr;
            curr = sum;
            count++;

            // stop thread for 2 sec after printing 3 number
            if(count % 3 == 0){
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Thread "+Thread.currentThread().getName() +" Ended");
    }
}

class Factorial extends Thread{
    int count = 0;
    public void run(){
        System.out.println("Thread "+Thread.currentThread().getName() +" started");
        int fact = 1;
        for(int x=2 ; x<=6 ; x++){
            count++;
            fact = fact*x;
            System.out.println(fact+" ");

            // stop thread for 2 sec after printing 3 number
            if(count % 3 == 0){
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Thread "+Thread.currentThread().getName() +" Ended");
    }
}

public class Syntax3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Fibonacci());
        t1.setName("Fibonacci");
        t1.start();
        Thread t2 = new Thread(new Factorial());
        t2.setName("Factorial");
        t2.start();
    }
}
