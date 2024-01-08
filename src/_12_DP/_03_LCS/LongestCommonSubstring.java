package _12_DP._03_LCS;

public class LongestCommonSubstring {
    static int LCS(char[] X, char[] Y, int m, int n) {
        int[][] t = new int[m+1][n+1];
        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j < n+1; j++) {
                // BASE CASE == INITIALISATION
                if (i == 0 || j == 0) t[i][j] = 0;

                    // CHOICE DIAGRAM
                else if (X[i-1] == Y[j-1])
                    t[i][j] = 1 + t[i-1][j-1];
                else
                    t[i][j] = 0;
            }
        }
        displayArray(t, m, n);
        return maxValInArray(t, m, n);
    }
    static int maxValInArray(int[][] t, int m, int n) {
        int result = 0;
        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j < n+1; j++) {
                if (t[i][j] > result) result = t[i][j];
            }
        }
        return result;
    }
    static void displayArray(int[][] t, int m, int n) {
        System.out.println("\nDP Table :-");
        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j < n+1; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    // Driver code
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "abfce";
        System.out.println("Length of LCS is = " + LCS(str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length()));
    }
}
