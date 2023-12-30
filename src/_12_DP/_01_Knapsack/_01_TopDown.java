package _12_DP._01_Knapsack;

public class _01_TopDown {

    static int knapSack(int[] wt, int[] val, int W, int n) {
        int[][] t = new int[n+1][W+1]; //to store n = 0 also

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < W+1; j++) {
                // BASE CASE <--> INITIALISATION
                if (i == 0 || j == 0) t[i][j] = 0;

                // CHOICE DIAGRAM
                else if (wt[i-1] <= j) t[i][j] = Math.max(val[i-1] + t[i-1][j-wt[i-1]], t[i-1][j]);
                else t[i][j] = t[i-1][j];
            }
        }
        return t[n][W];
    }

    // Driver code
    public static void main(String[] args)
    {
        int[] value = new int[] {160, 100, 120};
        int[] weight = new int[] {10, 20, 30};
        int W = 50;
        int n = value.length;
        System.out.println("Max Value = " + knapSack(weight, value, W, n));
    }
}

