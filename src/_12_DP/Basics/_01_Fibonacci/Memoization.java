package _12_DP.Basics._01_Fibonacci;

public class Memoization {
    public static void main(String[] args) {
        int n = 1000;
        int[] memo = new int[n+1];
        System.out.println(fib(n, memo));
    }
    static int fib(int n, int[] memo) {
        if (memo[n] != 0) return memo[n];
        if (n == 1 || n == 2) return 1;
        memo[n] = fib(n-1, memo) + fib(n-2, memo);
        return memo[n];
    }
}
