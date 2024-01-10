package _12_DP._04_MCM;

// Min. no. of attempts to find the critical floor
// => Project Estimation / Luck => Best of worst / Min of Max possible cases

public class EggDrop {

    // RECURSIVE SOLN.
    static int solve(int e, int f) {
        if (e == 1 || f <= 1) return f;

        int mn = Integer.MAX_VALUE;
        for (int k = 1; k <= f; k++) {
            int tempans = 1 + Math.max(solve(e,f-k), solve(e-1, k-1));
            mn = Math.min(mn, tempans);
        }
        return mn;
    }

    // TOP-DOWN SOLN.
    static int solveDP(int e, int f) {
        int[][] t = new int[e+1][f+1];

        for (int i = 1; i <= e; i++) {
            for (int j = 1; j <= f; j++) {
                int mn = Integer.MAX_VALUE;

                if (i == 1 || j <= 1) {
                    t[i][j] = j;
                    continue;
                }

                for (int k = 1; k <= j; k++) {
                    int tempans = 1 + Math.max(t[i][j-k], t[i-1][k-1]);
                    mn = Math.min(mn, tempans);
                }
                t[i][j] = mn;
            }
        }
        return t[e][f];
    }

    // Driver code
    public static void main(String[] args) {
        int e = 2, f = 36;
        System.out.print("Minimum number of trials in worst case with " + e + " eggs and " + f + " floors is ");
        System.out.print(solveDP(e, f));
    }
}

//// MEMOIZED
//public int superEggDrop(int e, int f) {
//    int[][] t = new int[e+1][f+1];
//    for (int i = 0; i <= e; i++) {
//        for (int j = 0; j <= f; j++) {
//            t[i][j] = -1;
//        }
//    }
//    return solve(e,f,t);
//}
//public int solve(int e, int f, int[][] t) {
//    if (e == 1 || f <= 1) {
//        t[e][f] = f;
//        return f;
//    }
//    if (t[e][f] != -1) return t[e][f];
//
//    int mn = Integer.MAX_VALUE;
//    for (int k = 1; k <= f; k++) {
//        int unbroken = solve(e,f-k,t);
//        int broken = solve(e-1,k-1,t);
//
//        int tempans = 1 + Math.max();
//        mn = Math.min(mn, tempans);
//    }
//    t[e][f] = mn;
//    return t[e][f];
//}