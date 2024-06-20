 /*
 LIFO
 */

 // push / add -> add element to stack
 // pop -> also returns the popped value
 // peek -> returns the last element without removing it

 package _00_DataStructures;

import java.util.Stack;

public class Stacks {
    public static void main(String[] args) {
        Stack<String> animals = new Stack<>();

        animals.push("Lion");
        animals.push("Rabbit");
        animals.push("Dog");
        animals.push("Cat");
        System.out.println("Stack -> " + animals);

        System.out.println("The last element : " + animals.peek()); // pointer at last element

        animals.pop();
        System.out.println("After Deletions : " + animals.peek());

        System.out.println("Stack -> " + animals);
    }
}
