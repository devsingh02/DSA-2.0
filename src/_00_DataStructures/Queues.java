package _00_DataStructures;

 /*
 1. FIFO
 2. Linked List implements Queue Interface
    (as Queue can be implemented in two forms : Array or Queue)
 3. Function equivalent but throws exception if false :-
    offer() <-> add()
    poll() <-> remove()
    peek() <-> element()
 */

import java.util.Queue;
import java.util.LinkedList;

public class Queues {
    public static void main(String[] args) {
        Queue<String> animals = new LinkedList<>();

        animals.offer("Lion");
        animals.offer("Rabbit");
        animals.offer("Dog");
        animals.offer("Cat");
        System.out.println("Queue -> " + animals);

        System.out.println("The Head element : " + animals.peek()); // pointer at first element

        System.out.println("First Element is removed : " + animals.poll()); // poll() returns the deleted value
        System.out.println("After Deletions : " + animals.peek());

        System.out.println("Queue -> " + animals);
    }
}
