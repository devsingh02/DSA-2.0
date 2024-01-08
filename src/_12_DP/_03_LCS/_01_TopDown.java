package _12_DP._03_LCS;

public class _01_TopDown {
    static String LCS(char[] X, char[] Y, int m, int n) {
        int[][] t = new int[m + 1][n + 1];

        // Build the DP table
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                // BASE CASE == INITIALIZATION
                if (i == 0 || j == 0)
                    t[i][j] = 0;
                    // CHOICE DIAGRAM
                else if (X[i - 1] == Y[j - 1])
                    t[i][j] = 1 + t[i - 1][j - 1];
                else
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
            }
        }

        // Retrieve the LCS string
        int len = t[m][n];
        char[] lcsChars = new char[len];
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (X[i - 1] == Y[j - 1]) {
                lcsChars[len - 1] = X[i - 1];
                i--;
                j--;
                len--;
            } else if (t[i - 1][j] > t[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return new String(lcsChars);
    }

    // Driver code
    public static void main(String[] args) {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";
        String LCS = LCS(str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length());
        System.out.println("LCS => " + LCS + "\nIt's length = " + LCS.length());
    }
}
