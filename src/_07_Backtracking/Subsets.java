package _07_Backtracking;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Arrays;

public class Subsets {
    public static void main(String[] args) {
        // NO DUPLICATES
        int[] arr = {1, 2, 3};
        System.out.println("Subsets (No Duplicates) : " + subsetsWithoutDuplicates(arr));
        // DUPLICATES
        arr = new int[]{2, 1, 2, 3};
        System.out.println("Subsets (With Duplicates) : " + subsetsWithDuplicates(arr));
    }

    // Time: O(n * 2^n), Space: O(n)
    static List<List<Integer>> subsetsWithoutDuplicates(int[] arr) {
        List<List<Integer>> subset = new ArrayList<>(); // [  ]
        Stack<Integer> curset = new Stack<>(); //[]
        helper(0, arr, curset, subset); //modifies subset // 0th index -> 1
        return subset;
    }
    static void helper(int i, int[] arr, Stack<Integer> curset, List<List<Integer>> subset) {
        if (i == arr.length) {  //made every possible choice (took/left every index)
            subset.add(new ArrayList<>(curset));// O(1)
            return;
        }
        //choice -> take 'i'th index
        curset.push(arr[i]); // [1]
        helper(i + 1, arr, curset, subset); //move on to 2

        //choice -> don't take 'i'th element
        curset.pop(); // []     // O(1)    // O(n) in list
        helper(i + 1, arr, curset, subset);
    }

    // Time: O(n * 2^n), Space: O(n)
    static List<List<Integer>> subsetsWithDuplicates(int[] arr) {
        List<List<Integer>> subset = new ArrayList<>();
        Stack<Integer> curset = new Stack<>();
        Arrays.sort(arr);   //effects real array in main too (Arrays -> call by reference)
        helped(0, arr, curset, subset);
        return subset;
    }
    static void helped(int i, int[] arr, Stack<Integer> curset, List<List<Integer>> subset) {
        if (i == arr.length) {
            subset.add(new ArrayList<>(curset));
            return;
        }
        //choice -> take index i
        curset.push(arr[i]);
        helped(i + 1, arr, curset, subset);
        //choice -> don't take index i + REMOVE DUPLICATES
        curset.pop();
        while (i+1 < arr.length && arr[i] == arr[i+1]) i++; //index i now at last duplicate
        helped(i + 1, arr, curset, subset); // i at next new element
    }
}
