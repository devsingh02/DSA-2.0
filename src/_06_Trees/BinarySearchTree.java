package _06_Trees;

import java.util.Scanner;

public class BinarySearchTree {

    public static class Node {
        int value;
        Node left, right;
        int height;
        Node(int value) {
            this.value = value;
            // rest all default values (height = 0)
        }
    }
    Node root; // BST has a node root


    public void input(Scanner sc) {
        System.out.println("Start filling the Binary Search Tree :-" );
        String inp = sc.next();
        while (!inp.equals("e") && !inp.equals("ex") && !inp.equals("exit")) {
            populate(Integer.parseInt(inp));
            inp = sc.next();
        }
    }
    public void populate(int key) {
        root = populate(root, key);
    }
    private Node populate(Node node, int key) {
        if (node == null) return new Node(key);
        // insertion
        if (key < node.value) node.left = populate(node.left, key);
        else node.right = populate(node.right, key);

        node.height = Math.max(height(node.right), height(node.left)) + 1; //inserted one node

        return node; // return current/child node to its parent node
    }
    private void populateSorted(int[] nums, int start, int end) {
        if (start >= end) return;

        int mid = start + (end - start)/2;  // (start + end)/2 -> may give error in large sizes
        populate(nums[mid]);
        populateSorted(nums, start, mid);
        populateSorted(nums, mid + 1, end);
    }


    public void displayTree() {
        displayTree(root, 0);
    }
    private void displayTree(Node node, int level) {
        if (node == null) return;
        displayTree(node.right, level + 1);
        // now "node" at right most level
        if (level == 0) System.out.println(node.value);
        else {
            for (int i = 0; i < level - 1 ; i++) System.out.print("|\t\t");
            System.out.println("|------>" + node.value);
        }
        displayTree(node.left, level + 1);
    }


    public void inorderSeq() {
        System.out.print("Inorder/Sorted Sequence : [");
        inorder(root);
        System.out.println("\b\b]");  //removed 1 space & 1 coma at the end
    }
    private void inorder(Node node) {
        if (node == null) return;

        inorder(node.left);
        System.out.print(node.value + ", ");
        inorder(node.right);
    }
    public void preorderSeq() {
        System.out.print("Preorder Sequence : [");
        preorder(root);
        System.out.println("\b\b]");
    }
    private void preorder(Node node) {
        if (node == null) return;

        System.out.print(node.value + ", ");
        preorder(node.left);
        preorder(node.right);
    }
    public void postorderSeq() {
        System.out.print("Postorder Sequence : [");
        postorder(root);
        System.out.println("\b\b]");
    }
    private void postorder(Node node) {
        if (node == null) return;

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value + ", ");
    }


    public void balanced() {    // Complexity of the tree => O(logn)
        String det;
        if (balanced(root)) det = "";
        else det = "NOT ";
        System.out.println("Since the ΔHEIGHT b/w CHILDREN of EACH NODE throughout the tree IS "
                + det + "<= 1 :-\n" + det + "BALANCED");
    }
    private boolean balanced(Node node) {
        if (node == null) return true; //basically fallback
//                                                -1 || 0 || 1
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }


    private int height(Node node) {
        if (node == null) return 0; // -1 ? But 0 gives answer in AVL
        return node.height;
    }
    private boolean isEmpty() {
        return root == null;
    }


    public void sampleTree() {
//        int[] tree = {15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9}; //un-balanced
        int[] tree = {15, 6, 18, 3, 7, 17, 20, 2, 4, 13}; //balanced
//        int[] tree = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; //sorted/skewed

        for (int key : tree) populate(key);
//        populateSorted(tree, 0, tree.length - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
//        bst.input(sc);
        bst.sampleTree();  System.out.println();
        bst.displayTree(); System.out.println();
        bst.inorderSeq();
        bst.preorderSeq();
        bst.postorderSeq();System.out.println();
        bst.balanced();    System.out.println();
    }
}
