package _07_Backtracking.Mathematics;

import java.util.ArrayList;
import java.util.List;

public class Combinations { // SubSequences with condition
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
        List<Integer> curset = new ArrayList<>();
        helper(1, n, k, curset, subset);    // i -> value (1 to 5)
        return subset;
    }
    static void helper(int i, int n, int k, List<Integer> curset, List<List<Integer>> subset) {//take "i"
        if (curset.size() == k) {
            subset.add(new ArrayList<>(curset));
            return;
        }
        if (i == n + 1) return;

        // if (cond.) *** to reduce additional recursion + backtracking [which takes considerable time]
        //choice -> take i
        curset.add(i); // TAKE "i"
        helper(i + 1, n, k, curset, subset); //all possible combinations with "i"
        curset.remove(curset.size() - 1);
        //choice -> don't take
        helper(i + 1, n, k, curset, subset);
    }


    // Time : O(k * C(n,k))     : EFFICIENT
    static List<List<Integer>> combinationsNCK(int n, int k) {
        List<List<Integer>> subset = new ArrayList<>();
        List<Integer> curset = new ArrayList<>();
        helped(1, n, k, curset, subset);
        return subset;
    }
    static void helped(int i, int n, int k, List<Integer> curset, List<List<Integer>> subset) {
        if (curset.size() == k) {
            subset.add(new ArrayList<>(curset));
            return;
        }
        if (i == n + 1) return;
        // take elements as [join i with : > i elements]
        for (int j = i; j <= n; j++) {  // current level
            curset.add(j);  // add
            helped(j + 1, n, k, curset, subset); // NEXT LEVEL // check if can add next || condition fulfilled
            curset.remove(curset.size() - 1);   // backtrack
        }
    }
}
