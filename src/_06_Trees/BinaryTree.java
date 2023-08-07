package _06_Trees;

import java.util.Scanner;

public class BinaryTree {

    static class Node {
        int value;
        Node left, right;
        Node(int value) {
            this.value = value;
        }
   }

    Node root;  //global-variable / instance-v. / static-v.? => Call by Reference

    //insert elements [DFS]
    public void populate(Scanner sc) {  //user doesn't need to know & write "root" for him/herself
        System.out.println("Enter the root node value : ");
        int value = sc.nextInt();
        root = new Node(value);
        populate(sc, root);
    }
    private void populate(Scanner sc, Node node) {
        System.out.println("Do you want to enter LEFT of " + node.value + " ?");
        char choice = sc.next().charAt(0);
        if (choice == 'y') {
            System.out.print("=> ");
            node.left = new Node(sc.nextInt());
            populate(sc, node.left);
        }
        System.out.println("Do you want to enter RIGHT of " + node.value + " ?");
        choice = sc.next().charAt(0);
        if (choice == 'y') {
            System.out.print("=> ");
            node.right = new Node(sc.nextInt());
            populate(sc, node.right);
        }
    }
    //pretty display
    public void display() { //user doesn't need to know & write "root" for him/herself
        display(root, 0);
    }
    private void display(Node node, int level) {
        if (node == null) return;
        display(node.right, level + 1); //gives right most node

        if (level == 0) {
            System.out.println(node.value);
        } else {
            for (int i = 0; i < level - 1; i++) System.out.print("|\t\t");
            System.out.println("|------>" + node.value);
        }
        display(node.left, level + 1);
    }

    private void sampleTree() {
        root = new Node(15);
        Node node1 = new Node(6);
        Node node2 = new Node(9);
        Node node3 = new Node(8);
        Node node4 = new Node(14);
        Node node5 = new Node(10);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node3.right = node5;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree bt = new BinaryTree();
//        BT.populate(sc);
        bt.sampleTree();
        bt.display();
    }
}
