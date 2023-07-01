package _12_DP.Basics._04_HowSum;

import java.util.ArrayList;

public class BruteForce {
	public static void main(String[] args) {
		System.out.println(howSum(7, new int[] {4,3}));
		System.out.println(howSum(8, new int[] {2,3,5}));
		System.out.println(howSum(300, new int[] {7,14}));
	}
		//print path
	static ArrayList<Integer> howSum(int target, int[] arr) {
		if (target == 0) return new ArrayList<>();
		if (target < 0) return null;

        for (int num : arr) {
            ArrayList<Integer> child = howSum(target - num, arr);
            if (child != null) {
                child.add(num); // child -> parent (current)
                return child;
            } 
        }
        return null;
	}
}

/*
m = target
n = arr.length;

Time = O(n^m * m)  // Arraylist
Space = O(m)
*/
