package _06_Trees;

public class SegmentTree {

    static class Node {
        int data;
        int startInterval, endInterval;
        Node left, right;

        Node (int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    Node root;

    public void constructTree(int[] arr) {
        root = constructTree(arr, 0, arr.length - 1);
    }

    // O(4*n) => O(n)
    private Node constructTree(int[] arr, int start, int end) {
        if (start == end) {
            //leaf node
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }
        //current node
        Node node = new Node(start, end);

        int mid = start + (end - start)/2;
        node.left = constructTree(arr, start, mid);
        node.right = constructTree(arr, mid + 1, end);

        node.data = node.left.data + node.right.data;
        return node;
    }


    public void query(int qsi, int qei) {    //query = given problem/range
        System.out.println(query(root, qsi, qei));
    }
    private int query(Node node, int qsi, int qei) {
        if (node.startInterval >= qsi && node.endInterval <= qei) {
            //node interval lies in query
            return node.data;
        }
        else if (node.startInterval > qei || node.endInterval < qsi) {
            //node interval lies completely outside
            return 0;
        } else {
            //node interval lies partially in query
            return query(node.left, qsi, qei) + query(node.right, qsi, qei);
        }
    }


    public void update(int index, int value) {
        update(root, index, value);
    }
    private int update(Node node, int index, int value) {
        if (index >= node.startInterval && index <= node.endInterval) {
            //index lies b/w node interval
            if (index == node.startInterval && index == node.endInterval) {
                //reached the correct leaf
                node.data = value;
            } else {
                node.data = update(node.left, index, value) + update(node.right, index, value);
            }
        }
        return node.data;   //returns unchanged value if index out of range
    }


    public void display() {
        display(root);
    }
    private void display(Node node) {
        String str = "";

        if(node.left != null) {
            str = str + "Interval=[" + node.left.startInterval + "-" + node.left.endInterval + "] and data: " + node.left.data + " => ";
        } else {
            str = str + "No left child";
        }

        // for current node
        str = str + "Interval=[" + node.startInterval + "-" + node.endInterval + "] and data: " + node.data + " <= ";

        if(node.right != null) {
            str = str + "Interval=[" + node.right.startInterval + "-" + node.right.endInterval + "] and data: " + node.right.data;
        } else {
            str = str + "No right child";
        }

        System.out.println(str + '\n');

        // call recursion
        if(node.left != null) {
            display(node.left);
        }

        if(node.right != null) {
            display(node.right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 8, 6, 7, -2, -8, 4, 9};
        SegmentTree tree = new SegmentTree();
        tree.constructTree(arr);
        tree.display();
        tree.query(2, 6); //7
        tree.update(6, 5); //4 -> 5
        tree.query(2, 6); //8
    }

}
