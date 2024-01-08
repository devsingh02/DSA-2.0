package _12_DP._03_LCS;

public class PrintingLCSRecursive {
    // Returns length of LCS for X[0..m-1], Y[0..n-1]
    static String LCS(char[] X, char[] Y, int m, int n) {
        // BASE CASE => Smallest Valid Input
        if (m == 0 || n == 0) return "";

        // CHOICE DIAGRAM
        if (X[m-1] == Y[n-1]) {
            // If the last characters are the same, add them to the LCS
            return X[m-1] + LCS(X, Y, m-1, n-1);
        } else {
            // Choose the maximum of two possibilities
            String lcs1 = LCS(X, Y, m, n-1);
            String lcs2 = LCS(X, Y, m-1, n);
            return lcs1.length() > lcs2.length() ? lcs1 : lcs2;
        }
    }

    // Driver code
    public static void main(String[] args) {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";
        String lcs = LCS(str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length());
        System.out.println("Length of LCS is = " + lcs.length());
        System.out.println("LCS is = " + lcs);
    }
}
