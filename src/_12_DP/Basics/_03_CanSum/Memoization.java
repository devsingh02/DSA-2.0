package _12_DP.Basics._03_CanSum;

import java.util.HashMap;

public class Memoization {
    public static void main(String[] args) {
        // HashMap<Integer, Boolean> memo = new HashMap<>();  // wrong way -> progress stored in memo for all ques.
        System.out.println(canSum(7, new int[] {4,3}, new HashMap<>()));
        System.out.println(canSum(8, new int[] {2,3,5}, new HashMap<>()));
        System.out.println(canSum(300, new int[] {7,14}, new HashMap<>()));
    }
    static boolean canSum(int target, int[] arr, HashMap<Integer, Boolean> memo) {
        if (target == 0) return true;
        if (target < 0) return false;
        if (memo.containsKey(target)) return memo.get(target);
        for (int num : arr) {
            if (canSum(target - num, arr, memo)) {
                memo.put(target, true);
                return true;
            }
        }
        memo.put(target, false);
        return false;
    }
}
