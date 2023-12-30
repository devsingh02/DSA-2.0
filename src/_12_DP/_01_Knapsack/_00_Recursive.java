package _12_DP._01_Knapsack;

/* Note: in 0/1 Knapsack => each object can be chosen only once */
public class _00_Recursive {

    // Returns the maximum value that  can be put in a knapsack of capacity W
    static int knapSack(int[] wt, int[] val, int W, int n) {
        // BASE CASE => smallest valid input
        if (n == 0 || W == 0) return 0;

        // CHOICE DIAGRAM ( n-1 -> last object )
        if (wt[n-1] <= W)
            return Math.max(val[n-1] + knapSack(wt, val,W - wt[n-1], n-1),
                            knapSack(wt, val, W, n-1));
        else
            return knapSack(wt, val, W, n-1);
    }

    // Driver code
    public static void main(String[] args)
    {
        int[] value = new int[] {160, 100, 120}; //ANS => 160x1 + 120x1 = 280 (Rem. wt = 10)
        int[] weight = new int[] {10, 20, 30};
        int W = 50;
        int n = value.length;
        System.out.println("Max Value = " + knapSack(weight, value, W, n));
    }
}


