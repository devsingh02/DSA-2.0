package _12_DP.Basics._04_HowSum;

import java.util.ArrayList; // answer
import java.util.HashMap;   // memo

public class Memoization {
	public static void main(String[] args) {
		System.out.println(howSum(7, new int[] {4,3}, new HashMap<>()));
		System.out.println(howSum(8, new int[] {2,3,5}, new HashMap<>()));
		System.out.println(howSum(300, new int[] {7,14}, new HashMap<>()));
	}
	//print path
	static ArrayList<Integer> howSum(int target, int[] arr, HashMap<Integer, ArrayList<Integer>> memo) {
		if (target == 0) return new ArrayList<>();
		if (target < 0) return null;
        if (memo.containsKey(target)) return memo.get(target);

        for (int num : arr) {
            ArrayList<Integer> child = howSum(target - num, arr, memo);
            if (child != null) {
                child.add(num); // child -> parent (current)
                memo.put(target, child);
                return child;
            } 
        }
        memo.put(target, null);
        return null;
	}
}

/*
m = target
n = arr.length;

Time = O(n^m * m)  // Arraylist
Space = O(m)
*/
