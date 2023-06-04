/*
 You are implementing a network message system, which needs a priority queue 
 for sending messages based on priority levels. Develop and test a Java program 
 that implements PriorityQueue to store messages and sorts them based on priority, 
 and a method that sends messages in the order of priority. 
 */

import java.util.PriorityQueue;

class Message implements Comparable<Message> {
    private String content;
    private int priority;

    public Message(String content, int priority) {
        this.content = content;
        this.priority = priority;
    }

    public String getContent() {
        return content;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Message other) {
        return Integer.compare(this.priority, other.priority);
    }
}

class Network {
    private PriorityQueue<Message> mssgQueue;

    public Network() {
        mssgQueue = new PriorityQueue<>();
    }

    public void addMessage(Message msg) {
        mssgQueue.add(msg);
        System.out.println("Message added: " + msg.getContent() + " (Priority: " + msg.getPriority() + ")");
    }

    public void sendMessage() {
        while (!mssgQueue.isEmpty()) {
            Message msg = mssgQueue.remove();
            System.out.println("Sent message: " + msg.getContent() + " (Priority: " + msg.getPriority() + ")");
        }
    }
}

public class NetworkMessageSystem {
    public static void main(String[] args) {
        Network net = new Network();

        Message message1 = new Message("Hello", 2);
        Message message2 = new Message("Important message", 1);
        Message message3 = new Message("Goodbye", 3);

        net.addMessage(message1);
        net.addMessage(message2);
        net.addMessage(message3);

        System.out.println("\nSending messages in order of priority:");
        net.sendMessage();
    }
}

