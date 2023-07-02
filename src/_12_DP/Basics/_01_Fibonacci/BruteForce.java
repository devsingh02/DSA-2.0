package _12_DP.Basics._01_Fibonacci;

class BruteForce {
    public static void main(String[] args) {
        System.out.println(fib(5));
        System.out.println(fib(15));
        System.out.println(fib(50));
    }
    static long fib(int n) {
        if (n == 1 || n == 2) return 1;
        return fib(n-1) + fib(n-2);
    }
}