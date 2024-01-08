public class Try {
    // Returns length of LCS for X[0..m-1], Y[0..n-1]
    static String res = "";

    static int LCS(char[] X, char[] Y, int m, int n) {
        // BASE CASE => Smallest Valid Input
        if (m == 0 || n == 0) return 0;

        // CHOICE DIAGRAM
        if (X[m-1] == Y[n-1]) {
            res = X[m-1] + res; // Append character to the beginning of the result string
            return 1 + LCS(X, Y, m - 1, n - 1);
        } else {
            int lcs1 = LCS(X, Y, m, n - 1);
            int lcs2 = LCS(X, Y, m - 1, n);
            return Math.max(lcs1, lcs2);
        }
    }

    // Driver code
    public static void main(String[] args) {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";
        int lengthOfLCS = LCS(str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length());
        System.out.println("Length of LCS is = " + lengthOfLCS);
        System.out.println("LCS is = " + res);
    }
}
