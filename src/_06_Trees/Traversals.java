package _06_Trees;

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class Traversals extends BinarySearchTree {

    //Keeps track/record of both children through Stack
    public void iterativeDFS() {
        System.out.print("\nDepth First Traversal {I} : [");
        iterativeDFS(root);
        System.out.println("\b\b]");
    }
    private void iterativeDFS(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            System.out.print(curr.value + ", ");
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }
    }

    public void recursiveDFS() {
        System.out.print("Depth First Traversal {R} : [");
        recursiveDFS(root);
        System.out.println("\b\b]\n");
    }
    private void recursiveDFS(Node node) {
        if (node == null) return;

        System.out.print(node.value + ", ");
        recursiveDFS(node.left);
        recursiveDFS(node.right);
    }


    public void BFS() {
        System.out.print("Breadth First Traversal : [");
        BFS(root);
        System.out.println("\b\b]\n");
    }
    private void BFS(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            //remove node -> add its children
            Node curr = queue.poll();
            if (curr.left != null) queue.offer(curr.left);
            if (curr.right != null) queue.offer(curr.right);

            System.out.print(curr.value + ", ");
        }
    }


    public static void main(String[] args) {
        Traversals tree = new Traversals();
        tree.sampleTree();
        tree.displayTree();
        tree.iterativeDFS();
        tree.recursiveDFS();
        tree.BFS();
    }
}