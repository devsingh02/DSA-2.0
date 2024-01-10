package _12_DP._01_Knapsack;

public class TargetSum {
    static int findTargetSumWays(int[] nums, int target) {
        int range = 0;
        for (int num : nums) range += num;
        // sum shouldn't be decimal since all elements int
        if (((range - target) % 2 == 1) || (target > range))
            return 0;

        int n = nums.length;
        // We take s2 not s1(range+target/2) since it may go out of bounds
        int sum = (range - target) / 2;
        // Memoization table
        int[][] memo = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                memo[i][j] = -1;
            }
        }
        return Knap(nums, n, sum, memo);
    }

    static int Knap(int[] nums, int n, int sum, int[][] memo) {
        // BASE CASE
        if (n == 0 && sum == 0) return 1;
        if (n == 0) return 0;

        if (memo[n][sum] != -1) {
            return memo[n][sum];
        }

        int tempans;
        if (nums[n - 1] <= sum)
            tempans = Knap(nums, n - 1, sum - nums[n - 1], memo) + Knap(nums, n - 1, sum, memo);
        else tempans = Knap(nums, n - 1, sum, memo);

        memo[n][sum] = tempans;
        return memo[n][sum];
    }

    // Driver Code
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;
        System.out.println(findTargetSumWays(nums, target)); //ans = 5
    }
}
