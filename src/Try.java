import java.util.*;
public class Try {
    public List<String> all_longest_common_subsequences(String s, String t)
    {
        String s1 = s, s2 = t;
        int m = s1.length(), n = s2.length();

        int[][] dp = makeLCStable(m, n, s1, s2);

        List<String> ans = new ArrayList<>();
        backtrack(m, n, s1, s2, dp, ans, "");
        Collections.sort(ans);
        return ans;
    }

    int[][] makeLCStable(int m, int n, String s1, String s2) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else  dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp;
    }

    void backtrack(int i, int j, String s1, String s2, int[][] dp, List<String> ans, String curr) {
        if (i == 0 || j == 0) {
            ans.add(curr);
            return;
        }

        if (s1.charAt(i - 1) == s2.charAt(j - 1))
            backtrack(i - 1, j - 1, s1, s2, dp, ans, s1.charAt(i - 1) + curr);
        else {
            // takes both possibilities if equal
            if (dp[i - 1][j] >= dp[i][j - 1]) backtrack(i - 1, j, s1, s2, dp, ans, curr);
            if (dp[i - 1][j] <= dp[i][j - 1]) backtrack(i, j - 1, s1, s2, dp, ans, curr);

        }
    }

    public static void main(String[] args) {
        Try obj = new Try();
        String s1 = "rabbbit";
        String s2 = "rabbit";
        List<String> result = obj.all_longest_common_subsequences(s1, s2);
        System.out.println("Longest Common Subsequences:");
        for (String seq : result) {
            System.out.println(seq);
        }
    }
}