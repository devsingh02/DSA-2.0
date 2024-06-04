package _13_Bitmasking;

import java.util.*;

public class MM {
    static int minAbsDifference(int[] nums, int goal) {

        Arrays.sort(nums);

        int n = nums.length;
        int mid = n / 2;
//        int mid = n >> 1;

        int[] left = new int[1];
        int[] right = new int[1];

        for (int i = 0; i < mid; i++)
            left = dfs(left, nums[i]);

        for (int i = mid; i < n; i++)
            right = dfs(right, nums[i]);

        int n1 = left.length;
        int n2 = right.length;
        int j = n2 - 1;

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n1 && j >= 0; i++) {
            while (j >= 0 && left[i] + right[j] > goal)
                j--;

            if (j >= 0)
                ans = Math.min(ans, goal - left[i] - right[j]);

            if (j + 1 < n2)
                ans = Math.min(ans, left[i] + right[j + 1] - goal);

        }
        return ans;
    }

    static int[] dfs(int[] cur, int val) {
        int n = cur.length, j = 0, index = 0;
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i++) {
            while (j < n && cur[i] > cur[j] + val)
                ans[index++] = cur[j++] + val;
            ans[index++] = cur[i];
            if (j < n && cur[i] == cur[j] + val)
                j++;
        }
        while (j < n)
            ans[index++] = cur[j++] + val;

        ans = Arrays.copyOf(ans, index);
        return ans;
    }

    public static void main(String[] args) {
        int goal = -5;
        int[] nums = {7,-9,15,-2};
        System.out.println(minAbsDifference(nums, goal));
    }
}
