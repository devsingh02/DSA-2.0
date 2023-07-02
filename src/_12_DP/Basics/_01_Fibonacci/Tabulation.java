// TABULATION -> Iterative
// unlike javascript -> java -> ArrayOutOfBounds

package _12_DP.Basics._01_Fibonacci;

public class Tabulation {
    public static void main(String[] args) {
        System.out.println(fib(5));   // size : n + 1
        System.out.println(fib(15));
        System.out.println(fib(50));
    }
    static long fib(int n) {
        long[] table = new long[n + 1]; // Tabulation -> n+1
        table[1] = 1;

        for (int i = 0; i <= n; i++) {
            if (i+1 <= n) table[i+1] += table[i];
            if (i+2 <= n) table[i+2] += table[i];
        }
        return table[n];
    }
}

// In java : default int/long Arrays contain = 0;