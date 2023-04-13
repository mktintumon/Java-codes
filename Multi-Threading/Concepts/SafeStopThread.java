package Concepts;

class CustomThread extends Thread{
    private boolean shouldExit = false;
    
    public void setShouldExit(boolean shouldExit){
        this.shouldExit = shouldExit;
    }

    public void run(){
        try {
            for(int i=0 ; i<10 ; i++){
                if(shouldExit == true){
                    break;
                }

                System.out.println("Thread is running");
                Thread.sleep(200);
            }
            System.out.println("Thread is completed");
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class SafeStopThread {
    public static void main(String[] args) throws InterruptedException {
        CustomThread ct = new CustomThread();
        ct.start();


        // For properly stopping the thread 
        int maxSleep = 3000;
        int slept = 0;
        
        while(slept < maxSleep){
            Thread.sleep(300);
            slept+=300;

            if(!ct.isAlive()){
                System.out.println("Thread was completed within 3 seconds");
                System.exit(0);
            }
        }

        if(ct.isAlive()){
            ct.setShouldExit(true);
            ct.join();
        }

        // this terminates thread without instruction
        System.exit(0);
    }
}
