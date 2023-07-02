package _12_DP.Basics._01_Fibonacci;

import java.util.HashMap;

class Memoization {
    public static void main(String[] args) {
        System.out.println(fib(5, new HashMap<>()));
        System.out.println(fib(15, new HashMap<>()));
        System.out.println(fib(50, new HashMap<>()));
    }
    static long fib(int n, HashMap<Integer, Long> memo) {
        if (memo.containsKey(n)) return memo.get(n);
        if (n == 1 || n == 2) return 1;

        memo.put(n, fib(n-1, memo) + fib(n-2, memo));
        return memo.get(n);
    }
}

//public class Memoization {
//    public static void main(String[] args) {
//        int n = 1000;
//        int[] memo = new int[n+1];
//        System.out.println(fib(n, memo));
//    }
//    static int fib(int n, int[] memo) {
//        if (memo[n] != 0) return memo[n];
//        if (n == 1 || n == 2) return 1;
//        memo[n] = fib(n-1, memo) + fib(n-2, memo);
//        return memo[n];
//    }
//}
