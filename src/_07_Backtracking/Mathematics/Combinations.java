package _07_Backtracking.Mathematics;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Combinations {
    // Given n numbers (1 - n), return all possible combinations of size k.
    // (n choose k math problem).
    public static void main(String[] args) {
        System.out.println(combinationsSubset(5, 2));
        System.out.println(combinationsNCK(5, 2));
    }

    //Subset with k size limitation [NO REPETITION IS THERE]
    // Time : O(k * 2^n)
    static List<List<Integer>> combinationsSubset(int n, int k) {
        List<List<Integer>> subset = new ArrayList<>();
        Stack<Integer> curset = new Stack<>();
        helper(1, n, k, curset, subset);    // i -> value (1 to 5)
        return subset;
    }
    static void helper(int i, int n, int k, Stack<Integer> curset, List<List<Integer>> subset) {//take "i"
        if (curset.size() == k) {
            subset.add(new ArrayList<>(curset));
            return;
        }
        if (i == n + 1) return;

        //choice -> take i
        curset.push(i); // TAKE "i"
        helper(i + 1, n, k, curset, subset); //all possible combinations with "i"
        curset.pop();
        //choice -> don't take
        helper(i + 1, n, k, curset, subset);
    }


    // Time : O(k * C(n,k))     : EFFICIENT
    static List<List<Integer>> combinationsNCK(int n, int k) {
        List<List<Integer>> subset = new ArrayList<>();
        Stack<Integer> curset = new Stack<>();
        helped(1, n, k, curset, subset);
        return subset;
    }
    static void helped(int i, int n, int k, Stack<Integer> curset, List<List<Integer>> subset) {
        if (curset.size() == k) {
            subset.add(new ArrayList<>(curset));
            return;
        }
        if (i == n + 1) return;
        // take elements as [join i with : > i elements]
        for (int j = i; j <= n; j++) {  // current level
            curset.add(j);  // add
            helped(j + 1, n, k, curset, subset); // NEXT LEVEL // check if can add next || condition fulfilled
            curset.pop();   // backtrack
        }
    }
}
