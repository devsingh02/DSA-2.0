package _12_DP._03_LCS;

public class _01_TopDown {
    static int LCS(char[] X, char[] Y, int m, int n) {
        int[][] t = new int[m+1][n+1];
        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j < n+1; j++) {
                // BASE CASE == INITIALISATION
                if (i == 0 || j == 0) t[i][j] = 0;

                else if (X[i-1] == Y[j-1])
                    t[i][j] = 1 + t[i-1][j-1];
                else
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
            }
        }
        return t[m][n];
    }
    // Driver code
    public static void main(String[] args) {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";
        System.out.println("Length of LCS is = " + LCS(str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length()));
    }
}
