package _12_DP.Basics._05_BestSum;

import java.util.ArrayList;

public class BruteForce {
    public static void main(String[] args) {
        System.out.println(bestSum(7, new int[] {4,3}));
		System.out.println(bestSum(8, new int[] {2,3,5}));
		System.out.println(bestSum(300, new int[] {7,14}));
        System.out.println(bestSum(100, new int[] {1,2,5,25}));
    }
    // answer with shortest path
    static ArrayList<Integer> bestSum(int target, int[] arr) {
        if (target == 0) return new ArrayList<>();
        if (target < 0) return null;

        ArrayList<Integer> shortestPath = null;
        for (int num : arr) {
            ArrayList<Integer> child = bestSum(target - num, arr);
            if (child != null) {
                ArrayList<Integer> parent = child; parent.add(num);
                if (shortestPath == null || parent.size() < shortestPath.size()) {
                    shortestPath = parent;
                }
            }
        }
        return shortestPath;
    }
}

// T : O(n^m * m)
// S : O(m*m)