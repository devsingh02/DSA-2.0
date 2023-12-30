package _12_DP._03_LCS;

public class _00_Recursive {
    // Returns length of LCS for X[0..m-1], Y[0..n-1]
    static int LCS(char[] X, char[] Y, int m, int n) {
        // BASE CASE => Smallest Valid Input
        if (m == 0 || n == 0) return 0;

        // CHOICE DIAGRAM
        if (X[m-1] == Y[n-1])
            return 1 + LCS(X, Y, m-1, n-1);
        else
            return Math.max(LCS(X, Y, m, n-1), LCS(X, Y, m-1, n));
    }

    // Driver code
    public static void main(String[] args) {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";
        System.out.println("Length of LCS is = " + LCS(str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length()));
    }
}
