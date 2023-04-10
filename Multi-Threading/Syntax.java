
class First extends Thread{
    public void run(){
        for(int i=1 ; i<=10 ; i++){
            System.out.print("A" + " ");
        }
    }
}

class Second extends Thread{
    public void run(){
        for(int i=1 ; i<=10 ; i++){
            System.out.print("B" + " ");
        }
    }
}

class Third extends Thread{
    public void run(){
        for(int i=1 ; i<=10 ; i++){
            System.out.print(i + " ");
        }
    }
}

public class Syntax {
    public static void main(String[] args) {
        Thread A = new Thread(new First());
        A.start();
        Thread B = new Thread(new Second());
        B.start();
        Thread C = new Thread(new Third());
        C.start();
    }
}
