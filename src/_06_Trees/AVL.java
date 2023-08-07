package _06_Trees;

public class AVL {

    static class Node {
        int value;
        Node left, right;
        int height;
        Node(int value) {
            this.value = value;
        }
    }
    private Node root;


    public void populate(int key) {
        root = populate(root, key);
    }
    private Node populate(Node node, int key) {
        if (node == null) return new Node(key);

        if (key < node.value) node.left = populate(node.left, key);
        else node.right = populate(node.right, key);

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return rotate(node); //[P] : if no rotation  |  [C] : if rotation occurs
    }                        //catches & rotates the first unbalanced node (since that node lies on path of inserted node)
    // ALL rotate function => returns same node which is passed on
    // node -> P
    // node.left
    private Node rotate(Node node) {
        if (height(node.left) - height(node.right) > 1) {
            //left HEAVY => node.left : C
            if (height(node.left.left) - height(node.left.right) > 0) { //positive
                //left-left => node.left.left : g
                return rightRotate(node);
            }
            // do nothing if Δh = 0 => balanced already
            if (height(node.left.left) - height(node.left.right) < 0) { //negative
                //left-right => node.left.right : g
                node.left = leftRotate(node.left); // [C]
                return rightRotate(node);
            }
        }

        if (height(node.left) - height(node.right) < -1) {
            //right HEAVY => node.right : C
            if (height(node.right.right) - height(node.right.left) > 0) { //positive
                //right-right => node.right.right : g
                return leftRotate(node);
            }
            // do nothing if Δh = 0 => balanced already
            if (height(node.right.right) - height(node.right.left) < 0) { //negative
                //right-left => node.right.left : g
                node.right = rightRotate(node.right);// [C]
                return leftRotate(node);
            }
        }

        return node;
    }
    private Node rightRotate(Node P) {
        Node C = P.left;
        Node t = C.right;

        C.right = P;
        P.left = t;
        // height of P & C is only changed (height is looked from bottom-up)
        P.height = Math.max(height(P.left), height(P.right)) + 1;
        C.height = Math.max(height(C.left), height(C.right)) + 1;
        return C;   //upar C hai ab => previous node will now point to C (rotated positions)
    }
    private Node leftRotate(Node P) {
        Node C = P.right;
        Node t = C.left;

        C.left = P;
        P.right = t;

        P.height = Math.max(height(P.left), height(P.right)) + 1;
        C.height = Math.max(height(C.left), height(C.right)) + 1;
        return C;   //upar C hai ab => previous node will now point to C (rotated positions)
    }


    public void displayTree() {
        display(root, 0);
    }
    private void display(Node node, int level) {
        if (node == null) return;
        display(node.right, level + 1);    //at right most node

        if (level == 0) {
            System.out.println(node.value);
        } else {
            for (int i = 0; i < level - 1; i++) System.out.print("|\t\t");
            System.out.println("|------>" + node.value);
        }
        display(node.left, level + 1);
    }


    public void balanced() {
        String det;
        if (balanced(root)) det = "";
        else det = "NOT ";
        System.out.println("Since the ΔHEIGHT b/w CHILDREN of EACH NODE throughout the tree IS "
                + det + "<= 1 :-\n" + det + "BALANCED");
    }
    private boolean balanced(Node node) {
        if (node == null) return true;

        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    private int height(Node node) {
        if (node == null) return 0; //***
        return node.height;
    }

    private void sampleTree() {
        int[] tree = {2, 3, 4, 6, 7, 13, 15, 17, 18, 20}; //un-balanced / sorted / skewed
//        int[] tree = {15, 6, 18, 3, 7, 17, 20, 2, 4, 13}; //balanced / unsorted

//        int[] tree = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; //sorted/skewed

        for (int key : tree) populate(key);
    }

    public static void main(String[] args) {
        AVL tree = new AVL();
        tree.sampleTree();  System.out.println();
        tree.displayTree(); System.out.println();
        tree.balanced();    System.out.println();
    }
}
