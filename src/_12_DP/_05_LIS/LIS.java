package _12_DP._05_LIS;

import java.util.*;
class LIS {
    public int lengthofLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        // dp[i] => LIS till i-th index
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (nums[prev] < nums[i]) dp[i] = Math.max(dp[i], 1 + dp[prev]); //update if larger subsequence found
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        LIS obj = new LIS();

        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums2 = {5, 4, 11, 1, 16, 8};
        System.out.println(obj.lengthofLIS(nums1));
    }
}

