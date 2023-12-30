package _12_DP._02_UnboundedKnapsack;

public class MinCoins {

    static int minCoins(int[] c, int n, int sum) {
        long[][] t = new long[n+1][sum+1];

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < sum+1; j++) {
                // INTIALISATION
                if (i == 0 && j != 0) t[i][j] = Integer.MAX_VALUE;
                else if (j == 0) t[i][j] = 0;

                // CHOICE DIAGRAM
                else if (c[i - 1] <= j)
                    t[i][j] = Math.min(1 + t[i][j - c[i-1]],
                            t[i-1][j]);
                else
                    t[i][j] = t[i-1][j];
            }
        }
        return t[n][sum] == Integer.MAX_VALUE ? -1 : (int)t[n][sum];
    }

    // Example usage:
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int n = coins.length;
        int targetSum = 11;

        int result = minCoins(coins, n, targetSum);
        System.out.println("Minimum number of coins required: " + result);
    }
}


//    static int minCoins(int[] c, int n, int V) {
//        long[][] t = new long[n + 1][V + 1];
//
//        t[0][0] = 0;
//
//        for (int i = 1; i < n + 1; i++)
//            t[i][0] = 0;
//
//        for (int j = 1; j < V + 1; j++)
//            t[0][j] = Integer.MAX_VALUE;
//
//        for (int i = 1; i < n + 1; i++) {
//            for (int j = 1; j < V + 1; j++) {
//                if (c[i - 1] <= j)
//                    t[i][j] = Math.min(1 + t[i][j - c[i - 1]], t[i - 1][j]);
//                else
//                    t[i][j] = t[i - 1][j];
//            }
//        }
//
//        return t[n][V] == Integer.MAX_VALUE ? -1 : (int) t[n][V]; //-1 = not possible
//    }