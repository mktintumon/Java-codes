import java.time.LocalDateTime;
import java.util.*;

class Producer extends Thread{
    // taken fixed size of queue as 3
    private static final int MAX_SIZE = 3;
    private List<String> queue = new ArrayList<>();

    @Override
    public void run(){
        try {
            while(true){
                produceItems();
            }
        } catch (Exception e) {
            
        }
    }

    // one thread get access at a time
    private synchronized void produceItems() throws InterruptedException {
        while(queue.size() == MAX_SIZE){
            System.out.println("Queue limit reached...waiting for consumer");
            wait();
            System.out.println("Producer got notification from consumer to produce");
        }

        String data = LocalDateTime.now().toString();
        queue.add(data);
        System.out.println("Items has been produced...");

        // notify consumer about data produced
        notify();
    }


    // we make consumer method as we want to synchronise the event
    public synchronized String consumeItems() throws InterruptedException{
        notify(); //--> notify producer about going to consume data

        while(queue.size() == 0){
            wait();
        }

        String data = queue.get(0);
        queue.remove(0);
        return data;
    }
}


class Consumer extends Thread{
    // as we need data from producer
    private Producer producer;

    public Consumer(Producer producer){
        this.producer = producer;
    }

    @Override
    public void run() {
        try {
            while(true){
                String data = producer.consumeItems();
                System.out.println("Consumed by " + Thread.currentThread().getName() + " " +data);
                Thread.sleep(500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


public class ProducerConsumer {
    public static void main(String[] args) {
        Producer producer = new Producer();
        producer.setName("producer");
        producer.start();

        Consumer consumer1 = new Consumer(producer);
        consumer1.setName("consumer-1");
        consumer1.start();

        Consumer consumer2 = new Consumer(producer);
        consumer2.setName("consumer-2");
        consumer2.start();

        Consumer consumer3 = new Consumer(producer);
        consumer3.setName("consumer-3");
        consumer3.start();
    }
}
