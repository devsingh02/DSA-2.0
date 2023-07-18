package _07_Backtracking.Mathematics;

import java.util.List;
import java.util.ArrayList; // STACK is SLOWER than ARRAYLISTS
import java.util.Arrays;

// Pattern of taking some elements and ignoring others
public class SubSequences { // Subsets / Power-Set
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
        List<Integer> curset = new ArrayList<>(); //[]
        helper(0, arr, curset, subset); //modifies subset // 0th index -> 1
        return subset;
    }
    static void helper(int i, int[] arr, List<Integer> curset, List<List<Integer>> subset) {// TAKE / NOT-TAKE "i"
        if (i == arr.length) {  //made every possible choice (took/left every index)
            subset.add(new ArrayList<>(curset));// O(1)
            return;
        }
        //choice -> take 'i'th index
        curset.add(arr[i]); // took i
        helper(i + 1, arr, curset, subset); //all possible combinations taking "i"
        curset.remove(curset.size() - 1); // []     // O(1)    // O(n) in list

        //choice -> don't take 'i'th element
        // no pushing arr[i]
        helper(i + 1, arr, curset, subset); //all possible combinations without "i"
    }



    // Time: O(n * 2^n), Space: O(n)
    static List<List<Integer>> subsetsWithDuplicates(int[] arr) {
        List<List<Integer>> subset = new ArrayList<>();
        List<Integer> curset = new ArrayList<>();
        Arrays.sort(arr);   //effects real array in main too (Arrays -> call by reference)
        helped(0, arr, curset, subset);
        return subset;
    }
    static void helped(int i, int[] arr, List<Integer> curset, List<List<Integer>> subset) {
        if (i == arr.length) {
            subset.add(new ArrayList<>(curset));
            return;
        }
        //TAKE ALL DUPLICATES (recursively it will take)
        curset.add(arr[i]);
        helped(i + 1, arr, curset, subset);
        curset.remove(curset.size() - 1);
        ////SKIP ALL DUPILCATES
        while (i+1 < arr.length && arr[i] == arr[i+1]) i++; //index i now at last duplicate
        helped(i + 1, arr, curset, subset); // i at next new element
    }
}
