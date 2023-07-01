package _12_DP.Basics._01_Fibonacci;

public class Bottom_up {
    public static void main(String[] args) {
        int n = 1000;
        System.out.println(fib(n));
    }
    static int fib(int n) {
        if (n == 1 || n == 2) return 1;

        int[] bu = new int[n+1];
        bu[1] = 1; bu[2] = 1;
        for (int i = 3; i <= n; i++) {
            bu[i] = bu[i-1] + bu[i-2];
        }
        return bu[n];
    }
}
