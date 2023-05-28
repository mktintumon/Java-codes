/*
Develop and test a program that inserts 25 random integers from 0 to 100 
in order into a linked-list object. For this exercise, you’ll need to modify 
the List<T> class to maintain an ordered list. Name the new version of the 
class SortedList.Modify the SortedList class to include a merge method that
can merge the SortedList it receives as an argument with the SortedList that
calls the method. Write an application to test method merge.
*/

import java.util.Random;

public class MergeSortedList<T extends Comparable<T>> {

    static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;

    public void insert(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null || data.compareTo(head.data) < 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null && data.compareTo(current.next.data) > 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void merge(MergeSortedList<T> otherList) {
        Node<T> current = otherList.head;
        while (current != null) {
            insert(current.data);
            current = current.next;
        }
    }

    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MergeSortedList<Integer> list1 = new MergeSortedList<>();
        MergeSortedList<Integer> list2 = new MergeSortedList<>();

        Random rand = new Random();

        // Insert random integers into lists
        for (int i = 0; i < 10; i++) {
            int num1 = rand.nextInt(101);
            list1.insert(num1);
            int num2 = rand.nextInt(101);
            list2.insert(num2);
        }


        System.out.println("List 1:");
        list1.display();

        System.out.println("List 2:");
        list2.display();

        // Merge list2 into list1
        list1.merge(list2);

        System.out.println("Merged List:");
        list1.display();
    }
}

