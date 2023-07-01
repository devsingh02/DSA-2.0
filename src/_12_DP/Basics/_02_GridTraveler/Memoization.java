package _12_DP.Basics._02_GridTraveler;

import java.util.HashMap;

public class Memoization {
    public static void main(String[] args) {
        HashMap<String, Long> memo = new HashMap<>();   // MEMO OBJECT
        System.out.println(gridTraveler(3,4,memo)); 
        System.out.println(gridTraveler(18,18,memo));    //total paths possible DOWN | RIGHT
    }

    static long gridTraveler(int m, int n, HashMap<String, Long> memo) {
        String key = m+","+n;
        String swappedKey = n+","+m;
        if (m == 1 && n == 1) return 1;
        if (m == 0 || n == 0) return 0;
        // (m,n) == (n,m)
        if (memo.containsKey(key)) return memo.get(key);
        if (memo.containsKey(swappedKey)) return memo.get(swappedKey);
        // memo[n] = fib(n-1, memo) + fib(n-2, memo);
        memo.put(key, gridTraveler(m-1, n, memo) + gridTraveler(m, n-1, memo));
        return memo.get(key);
    }
}
