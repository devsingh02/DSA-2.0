package _12_DP.Basics._01_Fibonacci;

class Recursion_NaiveApproach {
    public static void main(String[] args) {
        int n = 50;
        System.out.println(fib(n));
    }
    static int fib(int n) {
        if (n == 1 || n == 2) return 1;
        return fib(n-1) + fib(n-2);
    }
}