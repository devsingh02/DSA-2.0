package _12_DP.Basics._05_BestSum;

import java.util.ArrayList;
import java.util.HashMap;

public class Memoization {
    public static void main(String[] args) {
        System.out.println(bestSum(7, new int[] {4,3}, new HashMap<>()));
		System.out.println(bestSum(8, new int[] {2,3,5}, new HashMap<>()));
		System.out.println(bestSum(300, new int[] {7,14}, new HashMap<>()));
        System.out.println(bestSum(100, new int[] {1,2,5,25}, new HashMap<>()));
    }
    // answer with shortest path
    static ArrayList<Integer> bestSum(int target, int[] arr, HashMap<Integer, ArrayList<Integer>> memo) {
        if (target == 0) return new ArrayList<>();
        if (target < 0) return null;
        if (memo.containsKey(target)) return memo.get(target);

        ArrayList<Integer> shortestPath = null;
        for (int num : arr) {
            ArrayList<Integer> child = bestSum(target - num, arr, memo);
            if (child != null) {    //valid ans
                ArrayList<Integer> parent  = new ArrayList<>(child); 
                parent.add(num);
                if (shortestPath == null || parent.size() < shortestPath.size())
                    shortestPath = parent;
            }
        }
        memo.put(target, shortestPath);
        return memo.get(target);
    }
}

// T : O(n*m*m)
// S : O(m*m)
