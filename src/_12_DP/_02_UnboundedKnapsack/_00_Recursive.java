package _12_DP._02_UnboundedKnapsack;

// Can take a element multiple times
public class _00_Recursive {
    static int UnKnapsack(int[] wt, int[] val, int n, int W) {
        if (n == 0 || W == 0) return 0;

        if (wt[n-1] <= W)
            return Math.max(val[n-1] + UnKnapsack(wt, val, n, W - wt[n-1]),
                    UnKnapsack(wt, val, n-1, W));
        else
            return UnKnapsack(wt, val, n-1, W);
    }

    // Driver code
    public static void main(String[] args)
    {   int[] value = new int[] {160, 100, 120}; //ANS => 5x160 = 800 (Rem. wt = 0)
        int[] weight = new int[] {10, 20, 30};
        int W = 50;
        int n = value.length;
        System.out.println("Max Value = " + UnKnapsack(weight, value, n, W));
    }
}
